package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ii;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.transition.GravityArcMotion;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.e.b;
import com.tencent.mm.plugin.mv.model.e.f;
import com.tencent.mm.plugin.mv.model.e.g;
import com.tencent.mm.plugin.mv.model.e.h;
import com.tencent.mm.plugin.mv.model.e.i;
import com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList;
import com.tencent.mm.plugin.mv.model.flex.a.c;
import com.tencent.mm.plugin.mv.model.flex.b.a;
import com.tencent.mm.plugin.mv.ui.uic.m.e;
import com.tencent.mm.plugin.mv.ui.uic.n;
import com.tencent.mm.plugin.mv.ui.uic.p.b;
import com.tencent.mm.plugin.mv.ui.uic.t;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.f;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.g.b.q;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "()V", "albumAnimationContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAlbumAnimationContainer", "()Landroid/view/View;", "albumAnimationContainer$delegate", "Lkotlin/Lazy;", "albumFakeThumb", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAlbumFakeThumb", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "albumFakeThumb$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "fixMvCardRV", "Landroidx/recyclerview/widget/RecyclerView;", "getFixMvCardRV", "()Landroidx/recyclerview/widget/RecyclerView;", "fixMvCardRV$delegate", "mvChooseView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "getMvChooseView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "mvChooseView$delegate", "mvItemEditBottomLine", "getMvItemEditBottomLine", "mvItemEditBottomLine$delegate", "mvItemEditThumb", "Landroid/widget/ImageView;", "getMvItemEditThumb", "()Landroid/widget/ImageView;", "mvItemEditThumb$delegate", "mvListEditBottomLine", "getMvListEditBottomLine", "mvListEditBottomLine$delegate", "mvTypeObserver", "Landroidx/lifecycle/Observer;", "", "nextBtn", "getNextBtn", "nextBtn$delegate", "nextIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getNextIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "nextIv$delegate", "onDelListener", "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1", "Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1;", "selectClipCnt", "check", "", "durationMs", "clipCnt", "isVideo", "doNext", "", "finish", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "makeMediaThumbTransition", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onAnimationEnd", "Lkotlin/Function0;", "onAlbumItemClicked", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onAlbumItemFlexChecked", "isChecked", "fragmentType", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinderItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onFinderItemFlexChecked", "onFinderItemFlexClicked", "position", "onHeaderCameraClicked", "minRecordDurationMs", "onNextBtnStatusChange", "enable", "onPause", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "onResume", "onSearchBarClicked", "updateFixNextEnable", "updateFlexNextEnable", "Companion", "plugin-mv_release"})
public final class MusicMvMakerUI
  extends BaseMusicMvUI
  implements MusicMVCardChooseView.b
{
  public static final MusicMvMakerUI.a Gex;
  private static int pEj;
  private static int pEk;
  private final kotlin.f Aqt;
  private final kotlin.f Gel;
  private final kotlin.f Gem;
  private final kotlin.f Gen;
  private final kotlin.f Geo;
  private final kotlin.f Gep;
  private final kotlin.f Geq;
  private final kotlin.f Ger;
  private final kotlin.f Ges;
  private final kotlin.f Get;
  private int Geu;
  private final s<Integer> Gev;
  private final x Gew;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(226144);
    Gex = new MusicMvMakerUI.a((byte)0);
    AppMethodBeat.o(226144);
  }
  
  public MusicMvMakerUI()
  {
    AppMethodBeat.i(226143);
    this.Gel = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Gem = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Aqt = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Gen = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.Geo = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.Gep = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.Geq = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Ger = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.Ges = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.Get = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Gev = ((s)new k(this));
    this.Gew = new x(this);
    AppMethodBeat.o(226143);
  }
  
  private final boolean D(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(226141);
    if ((paramBoolean) && (paramInt1 <= 2000))
    {
      new f.a((Context)this).bBl(getResources().getString(b.h.music_mv_flex_min_video_limit)).bBp(getResources().getString(b.h.app_i_know)).show();
      AppMethodBeat.o(226141);
      return false;
    }
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.l.class);
    kotlin.g.b.p.j(localObject, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    localObject = (com.tencent.mm.plugin.mv.ui.uic.l)localObject;
    this.Geu += paramInt2;
    int i = this.Geu;
    localObject = (dbo)((com.tencent.mm.plugin.mv.ui.uic.l)localObject).Gko.getValue();
    if (localObject != null) {}
    for (paramInt1 = ((dbo)localObject).GiZ; i > paramInt1; paramInt1 = 0)
    {
      this.Geu -= paramInt2;
      new f.a((Context)this).bBl(getResources().getString(b.h.music_mv_reach_max_limit)).bBp(getResources().getString(b.h.app_i_know)).show();
      AppMethodBeat.o(226141);
      return false;
    }
    AppMethodBeat.o(226141);
    return true;
  }
  
  private final void a(com.tencent.mm.plugin.mv.model.g paramg, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(226116);
    if (paramg == null)
    {
      parama.invoke();
      AppMethodBeat.o(226116);
      return;
    }
    Object localObject = fgt();
    kotlin.g.b.p.j(localObject, "albumAnimationContainer");
    ((View)localObject).setVisibility(0);
    localObject = fgu();
    kotlin.g.b.p.j(localObject, "albumFakeThumb");
    paramg.j((ImageView)localObject);
    fgu().setRadius(0);
    localObject = new int[2];
    fgv().getLocationInWindow((int[])localObject);
    int i = localObject[0];
    RecyclerView localRecyclerView = fgv();
    kotlin.g.b.p.j(localRecyclerView, "fixMvCardRV");
    localObject[0] = (i + (localRecyclerView.getWidth() - paramg.GbH.getWidth()) / 2);
    i = localObject[1];
    localRecyclerView = fgv();
    kotlin.g.b.p.j(localRecyclerView, "fixMvCardRV");
    localObject[1] = (i + (localRecyclerView.getHeight() - paramg.GbH.getHeight()) / 2);
    paramg = new GravityArcMotion().getPath(paramg.GbG.x, paramg.GbG.y, localObject[0], localObject[1]);
    paramg = ObjectAnimator.ofFloat(fgu(), "x", "y", paramg);
    kotlin.g.b.p.j(paramg, "pathAnimator");
    paramg.setInterpolator((TimeInterpolator)new androidx.f.a.a.b());
    paramg.setDuration(400L);
    paramg.addListener((Animator.AnimatorListener)new f(this, parama));
    paramg.start();
    AppMethodBeat.o(226116);
  }
  
  private final View fgq()
  {
    AppMethodBeat.i(226082);
    View localView = (View)this.Gen.getValue();
    AppMethodBeat.o(226082);
    return localView;
  }
  
  private final WeImageView fgr()
  {
    AppMethodBeat.i(226083);
    WeImageView localWeImageView = (WeImageView)this.Geo.getValue();
    AppMethodBeat.o(226083);
    return localWeImageView;
  }
  
  private final MusicMVCardChooseView fgs()
  {
    AppMethodBeat.i(226084);
    MusicMVCardChooseView localMusicMVCardChooseView = (MusicMVCardChooseView)this.Gep.getValue();
    AppMethodBeat.o(226084);
    return localMusicMVCardChooseView;
  }
  
  private final View fgt()
  {
    AppMethodBeat.i(226085);
    View localView = (View)this.Geq.getValue();
    AppMethodBeat.o(226085);
    return localView;
  }
  
  private final MMRoundCornerImageView fgu()
  {
    AppMethodBeat.i(226086);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.Ger.getValue();
    AppMethodBeat.o(226086);
    return localMMRoundCornerImageView;
  }
  
  private final RecyclerView fgv()
  {
    AppMethodBeat.i(226087);
    RecyclerView localRecyclerView = (RecyclerView)this.Get.getValue();
    AppMethodBeat.o(226087);
    return localRecyclerView;
  }
  
  @SuppressLint({"ResourceType"})
  private final void vz(boolean paramBoolean)
  {
    AppMethodBeat.i(226105);
    if (paramBoolean)
    {
      localObject = fgq();
      if (localObject != null) {
        ((View)localObject).setBackground(getResources().getDrawable(b.d.FWw));
      }
      localObject = fgr();
      localContext = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(b.b.White));
      AppMethodBeat.o(226105);
      return;
    }
    Object localObject = fgq();
    if (localObject != null) {
      ((View)localObject).setBackground(getResources().getDrawable(b.d.FWv));
    }
    localObject = fgr();
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(b.b.BW_100_Alpha_0_1));
    AppMethodBeat.o(226105);
  }
  
  public final void ZH(int paramInt)
  {
    AppMethodBeat.i(226136);
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.l.class);
    kotlin.g.b.p.j(localObject1, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    localObject1 = (Integer)((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).fhe().getValue();
    int i;
    int j;
    if (localObject1 == null)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      Object localObject2;
      com.tencent.mm.plugin.music.model.c localc;
      if (i != 0)
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = (com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
        localObject2 = k.fet();
        kotlin.g.b.p.j(localObject2, "MusicPlayerManager.Instance()");
        ((k)localObject2).feg().pause();
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "takePhoto, minDuration:" + paramInt + ", maxDuration:" + j);
        localObject2 = new Intent((Context)((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).getActivity(), MusicMvRouterUI.class);
        ((Intent)localObject2).putExtra("KEY_MUSIC_ROUTER", 1);
        ((Intent)localObject2).putExtra("KEY_IS_FIX_CLIP_MODE", true);
        ((Intent)localObject2).putExtra("KEY_MIN_RECORD_DURATION", paramInt);
        ((Intent)localObject2).putExtra("KEY_MAX_RECORD_DURATION", j);
        localc = com.tencent.mm.plugin.music.model.c.FRf;
        com.tencent.mm.plugin.music.model.c.vs(true);
        ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).getActivity().startActivityForResult((Intent)localObject2, 1024);
        AppMethodBeat.o(226136);
        return;
        if (((Integer)localObject1).intValue() == 0)
        {
          i = 1;
          j = paramInt;
        }
      }
      else
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = (n)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(n.class);
        localObject2 = k.fet();
        kotlin.g.b.p.j(localObject2, "MusicPlayerManager.Instance()");
        ((k)localObject2).feg().pause();
        Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "takePhoto, minDuration:" + paramInt + ", maxDuration:60000");
        localObject2 = new Intent((Context)((n)localObject1).getActivity(), MusicMvRouterUI.class);
        ((Intent)localObject2).putExtra("KEY_MUSIC_ROUTER", 1);
        ((Intent)localObject2).putExtra("KEY_IS_FIX_CLIP_MODE", false);
        ((Intent)localObject2).putExtra("KEY_MIN_RECORD_DURATION", paramInt);
        ((Intent)localObject2).putExtra("KEY_MAX_RECORD_DURATION", 60000);
        localc = com.tencent.mm.plugin.music.model.c.FRf;
        com.tencent.mm.plugin.music.model.c.vs(true);
        ((n)localObject1).getActivity().startActivityForResult((Intent)localObject2, 1025);
        AppMethodBeat.o(226136);
        return;
      }
      i = 0;
      j = 0;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(226167);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(226167);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(226166);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(226166);
    return localView1;
  }
  
  public final void a(final GalleryItem.MediaItem paramMediaItem, com.tencent.mm.plugin.mv.model.g paramg)
  {
    AppMethodBeat.i(226117);
    kotlin.g.b.p.k(paramMediaItem, "data");
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      a(paramg, (kotlin.g.a.a)new n(this, paramMediaItem));
      AppMethodBeat.o(226117);
      return;
    }
    Log.e("MicroMsg.Mv.MusicMvMakerUI", "data must be GalleryItem.VideoMediaItem");
    AppMethodBeat.o(226117);
  }
  
  public final void a(final MusicMvTabFragment.f paramf, com.tencent.mm.plugin.mv.model.g paramg)
  {
    AppMethodBeat.i(226126);
    kotlin.g.b.p.k(paramf, "data");
    a(paramg, (kotlin.g.a.a)new y(this, paramf));
    AppMethodBeat.o(226126);
  }
  
  public final boolean a(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem)
  {
    int k = 0;
    AppMethodBeat.i(226125);
    kotlin.g.b.p.k(paramMediaItem, "data");
    Object localObject1 = a.Gfi;
    Object localObject2 = a.OJ(paramMediaItem.BVl);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      i = 3;
      if (!(paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        break label141;
      }
    }
    label141:
    for (int j = ((GalleryItem.VideoMediaItem)paramMediaItem).maT;; j = 0)
    {
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(n.class);
      kotlin.g.b.p.j(localObject1, "UICProvider.of(this@Musi…rFlexEditUIC::class.java)");
      localObject1 = (n)localObject1;
      ((n)localObject1).wNB = true;
      if (paramBoolean) {
        break label147;
      }
      this.Geu -= i;
      ((n)localObject1).fhj().aNe((String)localObject2);
      ((n)localObject1).fhj().fgm();
      AppMethodBeat.o(226125);
      return true;
      i = 1;
      break;
    }
    label147:
    if (!D(j, i, paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      AppMethodBeat.o(226125);
      return false;
    }
    kotlin.g.b.p.k(paramMediaItem, "data");
    Object localObject3 = new com.tencent.mm.plugin.mv.model.e();
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 1;
    Object localObject4 = com.tencent.mm.plugin.mv.model.e.Gba;
    kotlin.g.b.p.k(paramMediaItem, "mediaItem");
    kotlin.g.b.p.k(localObject3, "item");
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 1;
    ((com.tencent.mm.plugin.mv.model.e)localObject3).GaW = ((e.g)new e.f(paramMediaItem));
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      localObject4 = paramMediaItem.aBv();
      kotlin.g.b.p.j(localObject4, "mediaItem.uniqueValue()");
      String str = ((GalleryItem.VideoMediaItem)paramMediaItem).etI();
      kotlin.g.b.p.j(str, "mediaItem.originalPath");
      localObject4 = new e.i((String)localObject4, str, ((GalleryItem.VideoMediaItem)paramMediaItem).maT);
      ((e.i)localObject4).videoWidth = ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
      ((e.i)localObject4).videoHeight = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight;
      ((com.tencent.mm.plugin.mv.model.e)localObject3).GaX = ((e.h)localObject4);
    }
    localObject4 = com.tencent.mm.plugin.mv.model.m.GcA;
    com.tencent.mm.plugin.mv.model.m.ZF(2);
    localObject4 = com.tencent.mm.plugin.mv.model.m.GcA;
    com.tencent.mm.plugin.mv.model.m.a(((List)((n)localObject1).fhj().mXB).size(), (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject2 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject2, 1, System.currentTimeMillis(), 0);
    ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG = new com.tencent.mm.plugin.mv.model.flex.a.a((byte)0);
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).thumbPath = paramMediaItem.aZe();
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).BVl = paramMediaItem.BVl;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).GcL = paramMediaItem.BVm;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).BVd = paramMediaItem;
    }
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = ((GalleryItem.VideoMediaItem)paramMediaItem).maT;
      MMLiveList.a(((n)localObject1).fhj(), (com.tencent.mm.plugin.livelist.b)localObject2);
      ((n)localObject1).fhj().fgm();
      AppMethodBeat.o(226125);
      return true;
    }
    ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = 0;
    paramMediaItem = BitmapUtil.getPictureSize(paramMediaItem.aZe());
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
    if (localObject3 != null) {
      if (paramMediaItem == null) {
        break label593;
      }
    }
    label593:
    for (int i = paramMediaItem.x;; i = 0)
    {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).width = i;
      localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
      if (localObject3 == null) {
        break;
      }
      i = k;
      if (paramMediaItem != null) {
        i = paramMediaItem.y;
      }
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).height = i;
      break;
    }
  }
  
  public final boolean a(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt)
  {
    AppMethodBeat.i(226131);
    kotlin.g.b.p.k(paramf, "data");
    Object localObject2 = com.tencent.mm.ae.d.Fw(paramf.feedId);
    Object localObject1 = paramf.feedObject;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          localObject1 = (FinderMedia)kotlin.a.j.M((List)localObject1, 0);
          if (localObject1 == null) {}
        }
      }
    }
    for (int i = ((FinderMedia)localObject1).videoDuration * 1000;; i = 0)
    {
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(n.class);
      kotlin.g.b.p.j(localObject1, "UICProvider.of(this@Musi…rFlexEditUIC::class.java)");
      localObject1 = (n)localObject1;
      ((n)localObject1).wNB = true;
      if (paramBoolean) {
        break;
      }
      ((n)localObject1).fhj().aNe((String)localObject2);
      ((n)localObject1).fhj().fgm();
      this.Geu -= 3;
      AppMethodBeat.o(226131);
      return true;
    }
    if (!D(i, 3, true))
    {
      AppMethodBeat.o(226131);
      return false;
    }
    kotlin.g.b.p.k(paramf, "data");
    Object localObject3 = new com.tencent.mm.plugin.mv.model.e();
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 2;
    Object localObject4 = com.tencent.mm.plugin.mv.model.e.Gba;
    e.b.a(paramf, (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject4 = com.tencent.mm.plugin.mv.model.m.GcA;
    com.tencent.mm.plugin.mv.model.m.a(((List)((n)localObject1).fhj().mXB).size(), (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject2 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject2, 2, System.currentTimeMillis(), paramInt);
    ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH = new a.c((byte)0);
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
    if (localObject3 != null) {
      ((a.c)localObject3).Gbc = paramf.feedObject;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
    if (localObject3 != null)
    {
      paramf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
      if (paramf == null) {
        break label434;
      }
      paramf = paramf.Gbc;
      if (paramf == null) {
        break label434;
      }
      paramf = paramf.objectDesc;
      if (paramf == null) {
        break label434;
      }
      paramf = paramf.media;
      if (paramf == null) {
        break label434;
      }
      paramf = (FinderMedia)kotlin.a.j.M((List)paramf, 0);
      if (paramf == null) {
        break label434;
      }
    }
    label434:
    for (paramf = paramf.thumbUrl + paramf.thumb_url_token;; paramf = null)
    {
      ((a.c)localObject3).thumbUrl = paramf;
      ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = i;
      MMLiveList.a(((n)localObject1).fhj(), (com.tencent.mm.plugin.livelist.b)localObject2);
      ((n)localObject1).fhj().fgm();
      AppMethodBeat.o(226131);
      return true;
    }
  }
  
  public final void bz(final LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(226137);
    kotlin.g.b.p.k(paramLinkedList, "mediaItems");
    com.tencent.e.h.ZvG.be((Runnable)new z(this, paramLinkedList));
    AppMethodBeat.o(226137);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(226110);
    super.finish();
    AppMethodBeat.o(226110);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZI;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(226089);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = kotlin.a.ak.b(localSet, (Iterable)kotlin.a.ak.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.m.class, n.class, com.tencent.mm.plugin.mv.ui.uic.p.class, com.tencent.mm.plugin.mv.ui.uic.l.class, t.class }));
      AppMethodBeat.o(226089);
      return localSet;
    }
    AppMethodBeat.o(226089);
    return null;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(226103);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = getContext();
    kotlin.g.b.p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.transparent));
    hideActionbarLine();
    pEj = com.tencent.mm.ci.a.kr((Context)this);
    pEk = ax.au((Context)this).y;
    paramBundle = (View)this.Aqt.getValue();
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new q(this));
    }
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.livebase.a.a.class);
    kotlin.g.b.p.j(paramBundle, "UICProvider.of(this).get…ycleScopeUIC::class.java)");
    final com.tencent.mm.plugin.livebase.a.a locala = (com.tencent.mm.plugin.livebase.a.a)paramBundle;
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.l.class);
    kotlin.g.b.p.j(paramBundle, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    final com.tencent.mm.plugin.mv.ui.uic.l locall = (com.tencent.mm.plugin.mv.ui.uic.l)paramBundle;
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(n.class);
    kotlin.g.b.p.j(paramBundle, "UICProvider.of(this).get…rFlexEditUIC::class.java)");
    final n localn = (n)paramBundle;
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
    kotlin.g.b.p.j(paramBundle, "UICProvider.of(this).get…erFixEditUIC::class.java)");
    final com.tencent.mm.plugin.mv.ui.uic.m localm = (com.tencent.mm.plugin.mv.ui.uic.m)paramBundle;
    paramBundle = fgq();
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new r(this));
    }
    MusicMvMakerUI localMusicMvMakerUI = (MusicMvMakerUI)this;
    Object localObject2;
    if (com.tencent.mm.plugin.music.model.m.cPm())
    {
      paramBundle = findViewById(b.e.FYf);
      kotlin.g.b.p.j(paramBundle, "findViewById<LinearLayout>(R.id.mvTypeSwitchLL)");
      ((LinearLayout)paramBundle).setVisibility(0);
      paramBundle = (TextView)findViewById(b.e.FXl);
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new o(locall));
        localObject2 = (TextView)findViewById(b.e.FXi);
        if (localObject2 != null)
        {
          ((TextView)localObject2).setOnClickListener((View.OnClickListener)new p(locall));
          localObject1 = localObject2;
        }
        locall.fhe().a((androidx.lifecycle.l)this, (s)new s(this, (TextView)localObject1, paramBundle));
      }
    }
    else
    {
      locall.fhe().a((androidx.lifecycle.l)this, this.Gev);
      locall.Gko.a((androidx.lifecycle.l)localMusicMvMakerUI, (s)new t(this, localn, locala, locall, localm));
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.p)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.p.class)).GlK = ((p.b)new u(this, locall));
      paramBundle = com.tencent.mm.plugin.mv.model.o.GcB;
      paramBundle = (Context)this;
      localObject1 = locall.GaB;
      kotlin.g.b.p.k(paramBundle, "context");
      kotlin.g.b.p.k(localObject1, "songInfo");
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (dbs)com.tencent.mm.plugin.secdata.ui.a.a.a(paramBundle, 7, dbs.class);
      if ((localObject2 != null) && (10 == ((dbs)localObject2).scene)) {
        break label575;
      }
    }
    for (;;)
    {
      localn.GkU.a((androidx.lifecycle.l)this, (s)new v(this));
      localn.GkW.a((androidx.lifecycle.l)this, (s)new w(this));
      AppMethodBeat.o(226103);
      return;
      paramBundle = null;
      break;
      label575:
      com.tencent.mm.plugin.mv.model.o.a(paramBundle, (bds)localObject1, new com.tencent.mm.plugin.mv.model.f());
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226109);
    super.onDestroy();
    Object localObject1 = fgs();
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.gallery.model.e.etl().b((i.c)localObject1);
      Object localObject2 = ((MusicMVCardChooseView)localObject1).Gnl;
      if (localObject2 != null) {
        ((TabLayout)localObject2).b((TabLayout.b)((MusicMVCardChooseView)localObject1).GnG);
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).Gnt;
      if (localObject2 != null) {
        ((MusicMvTabSearchFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).GnB;
      if (localObject2 != null) {
        ((MusicMvTabMyFavFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).Gnz;
      if (localObject2 != null) {
        ((MusicMvTabMachineFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).GnA;
      if (localObject2 != null) {
        ((MusicMvTabMyPostFragment)localObject2).onDestroy();
      }
      localObject1 = ((MusicMVCardChooseView)localObject1).GnC;
      if (localObject1 != null)
      {
        ((MusicMvTabMyLikeFragment)localObject1).onDestroy();
        AppMethodBeat.o(226109);
        return;
      }
      AppMethodBeat.o(226109);
      return;
    }
    AppMethodBeat.o(226109);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(226107);
    super.onPause();
    Object localObject = fgs();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).Caz = true;
    }
    localObject = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.feJ();
    AppMethodBeat.o(226107);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(226106);
    super.onResume();
    Object localObject = fgs();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).Caz = false;
    }
    localObject = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.onResume();
    localObject = com.tencent.mm.plugin.music.model.l.FRM;
    com.tencent.mm.plugin.music.model.l.aw((Activity)this);
    AppMethodBeat.o(226106);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MMRoundCornerImageView>
  {
    c(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    e(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$makeMediaThumbTransition$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(kotlin.g.a.a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(226247);
      MusicMvMakerUI.g(this.Gey).animate().alpha(0.0F).setDuration(200L).withEndAction((Runnable)new a(this)).start();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(226247);
        return;
      }
      AppMethodBeat.o(226247);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MusicMvMakerUI.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(225807);
        View localView = MusicMvMakerUI.f(this.GeA.Gey);
        kotlin.g.b.p.j(localView, "albumAnimationContainer");
        localView.setVisibility(8);
        AppMethodBeat.o(225807);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<MusicMVCardChooseView>
  {
    g(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<View>
  {
    h(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<View>
  {
    j(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class k<T>
    implements s<Integer>
  {
    k(MusicMvMakerUI paramMusicMvMakerUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<View>
  {
    l(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    m(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(MusicMvMakerUI paramMusicMvMakerUI, GalleryItem.MediaItem paramMediaItem)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$flexTV$1$1"})
  static final class o
    implements View.OnClickListener
  {
    o(com.tencent.mm.plugin.mv.ui.uic.l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233473);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = (Integer)this.GeC.fhe().getValue();
      if (paramView == null) {}
      for (;;)
      {
        this.GeC.fhe().L(Integer.valueOf(1));
        paramView = com.tencent.mm.plugin.mv.model.m.GcA;
        com.tencent.mm.plugin.mv.model.m.vy(true);
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233473);
          return;
        } while (paramView.intValue() == 1);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$fixTV$1$1"})
  static final class p
    implements View.OnClickListener
  {
    p(com.tencent.mm.plugin.mv.ui.uic.l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225334);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = (Integer)this.GeC.fhe().getValue();
      if (paramView == null) {}
      for (;;)
      {
        this.GeC.fhe().L(Integer.valueOf(0));
        paramView = com.tencent.mm.plugin.mv.model.m.GcA;
        com.tencent.mm.plugin.mv.model.m.vy(false);
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(225334);
          return;
        } while (paramView.intValue() == 0);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234902);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Gey.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234902);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230302);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      MusicMvMakerUI.a(this.Gey);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230302);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class s<T>
    implements s<Integer>
  {
    s(MusicMvMakerUI paramMusicMvMakerUI, TextView paramTextView1, TextView paramTextView2) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class t<T>
    implements s<dbo>
  {
    t(MusicMvMakerUI paramMusicMvMakerUI, n paramn, com.tencent.mm.plugin.livebase.a.a parama, com.tencent.mm.plugin.mv.ui.uic.l paraml, com.tencent.mm.plugin.mv.ui.uic.m paramm) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"})
  public static final class u
    implements p.b
  {
    u(com.tencent.mm.plugin.mv.ui.uic.l paraml) {}
    
    public final void vA(boolean paramBoolean)
    {
      AppMethodBeat.i(226260);
      Object localObject1 = MusicMvMakerUI.f(this.Gey);
      kotlin.g.b.p.j(localObject1, "albumAnimationContainer");
      ((View)localObject1).setVisibility(0);
      MusicMvMakerUI.g(this.Gey).setRadius(com.tencent.mm.ci.a.fromDPToPix((Context)this.Gey.getContext(), 12));
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
      kotlin.g.b.p.j(localObject1, "UICProvider.of(this@Musi…erFixEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.m)localObject1;
      if (paramBoolean) {
        ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).wNB = true;
      }
      Object localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).fhh();
      ImageView localImageView = MusicMvMakerUI.h(this.Gey);
      kotlin.g.b.p.j(localImageView, "mvItemEditThumb");
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      MMRoundCornerImageView localMMRoundCornerImageView = MusicMvMakerUI.g(this.Gey);
      kotlin.g.b.p.j(localMMRoundCornerImageView, "albumFakeThumb");
      localObject2 = com.tencent.mm.plugin.mv.model.h.a(localImageView, (View)localObject2, (ImageView)localMMRoundCornerImageView, false);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new c(this));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      MusicMvMakerUI.e(this.Gey).animate().translationY(0.0F).setListener((Animator.AnimatorListener)new d(this)).start();
      ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).g((kotlin.g.a.m)new e(paramBoolean));
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "disableCurrentSyncMusic");
      if (((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).GjI.jNa + 1 < ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).getAdapter().getItemCount())
      {
        localObject1 = (com.tencent.mm.plugin.mv.model.e)kotlin.a.j.M((List)((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).mXB, ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).GjI.jNa);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mv.model.e)localObject1).GaV = false;
        }
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.p)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.p.class)).setShow(false);
      MusicMvMakerUI.e(this.Gey).fhH();
      if (!locall.fgD()) {
        MusicMvMakerUI.b(this.Gey);
      }
      AppMethodBeat.o(226260);
    }
    
    public final void vB(boolean paramBoolean)
    {
      AppMethodBeat.i(226265);
      Object localObject1 = MusicMvMakerUI.f(this.Gey);
      kotlin.g.b.p.j(localObject1, "albumAnimationContainer");
      ((View)localObject1).setVisibility(0);
      MusicMvMakerUI.g(this.Gey).setRadius(com.tencent.mm.ci.a.fromDPToPix((Context)this.Gey.getContext(), 12));
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
      kotlin.g.b.p.j(localObject1, "UICProvider.of(this@Musi…erFixEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.m)localObject1;
      Object localObject2 = com.tencent.mm.ui.component.g.Xox;
      localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.m.class)).fhh();
      Object localObject3 = MusicMvMakerUI.h(this.Gey);
      kotlin.g.b.p.j(localObject3, "mvItemEditThumb");
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      MMRoundCornerImageView localMMRoundCornerImageView = MusicMvMakerUI.g(this.Gey);
      kotlin.g.b.p.j(localMMRoundCornerImageView, "albumFakeThumb");
      localObject2 = com.tencent.mm.plugin.mv.model.h.a((ImageView)localObject3, (View)localObject2, (ImageView)localMMRoundCornerImageView, ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).GkA);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new a(this));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).g((kotlin.g.a.m)new b(paramBoolean));
      localObject2 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.p)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(com.tencent.mm.plugin.mv.ui.uic.p.class)).setShow(false);
      if ((((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).GkA) && (((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).wKJ >= 0) && (((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).wKJ < ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).mXB.size()))
      {
        localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).mXB.get(((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).wKJ);
        kotlin.g.b.p.j(localObject2, "dataList[lastPos]");
        localObject2 = (com.tencent.mm.plugin.mv.model.e)localObject2;
        int i = ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).wKJ;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)localObject2).GaY;
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.mv.model.e)localObject3).xUg = ((com.tencent.mm.plugin.mv.model.e)localObject2).xUg;
          ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).mXB.set(i, localObject3);
          ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).getAdapter().cL(i);
          ((com.tencent.mm.plugin.mv.ui.uic.m)localObject1).ZS(i);
        }
      }
      MusicMvMakerUI.e(this.Gey).animate().translationY(0.0F).start();
      MusicMvMakerUI.e(this.Gey).fhH();
      if (!locall.fgD()) {
        MusicMvMakerUI.b(this.Gey);
      }
      AppMethodBeat.o(226265);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onCancel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(226679);
        paramAnimator = MusicMvMakerUI.g(this.GeM.Gey);
        kotlin.g.b.p.j(paramAnimator, "albumFakeThumb");
        paramAnimator.setAlpha(1.0F);
        paramAnimator = MusicMvMakerUI.f(this.GeM.Gey);
        kotlin.g.b.p.j(paramAnimator, "albumAnimationContainer");
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(226679);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.model.e, x>
    {
      b(boolean paramBoolean)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onConfirm$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class c
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(243656);
        paramAnimator = MusicMvMakerUI.f(this.GeM.Gey);
        kotlin.g.b.p.j(paramAnimator, "albumAnimationContainer");
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(243656);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onConfirm$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class d
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(243189);
        MusicMvMakerUI.e(this.GeM.Gey).animate().setListener(null);
        paramAnimator = com.tencent.mm.ui.component.g.Xox;
        Object localObject = (com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.GeM.Gey).i(com.tencent.mm.plugin.mv.ui.uic.m.class);
        Log.d("MicroMsg.Mv.MusicMvMakerFixEditUIC", "moveToNextItem, lastPos:" + ((com.tencent.mm.plugin.mv.ui.uic.m)localObject).wKJ);
        if (((com.tencent.mm.plugin.mv.ui.uic.m)localObject).wKJ + 1 < ((com.tencent.mm.plugin.mv.ui.uic.m)localObject).getAdapter().getItemCount())
        {
          paramAnimator = ((com.tencent.mm.plugin.mv.ui.uic.m)localObject).fhf();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(((com.tencent.mm.plugin.mv.ui.uic.m)localObject).wKJ + 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          paramAnimator.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnimator, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(243189);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.model.e, x>
    {
      e(boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class v<T>
    implements s<Integer>
  {
    v(MusicMvMakerUI paramMusicMvMakerUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"})
  static final class w<T>
    implements s<Integer>
  {
    w(MusicMvMakerUI paramMusicMvMakerUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"})
  public static final class x
    implements b.a
  {
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.flex.a parama)
    {
      AppMethodBeat.i(230741);
      kotlin.g.b.p.k(parama, "item");
      Log.i("MicroMsg.Mv.MusicMvMakerUI", "OnDelBtnClicked, pos:" + paramInt + ", type:" + parama.type);
      Object localObject1;
      if ((parama.type == 1) || (parama.type == 3))
      {
        localObject1 = parama.GcG;
        if (localObject1 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).BVl);
        }
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.mv.model.m.GcA;
        localObject2 = com.tencent.mm.plugin.mv.model.m.fgi();
        ((ii)localObject2).sP(13L);
        ((ii)localObject2).alS();
        ((ii)localObject2).sV(com.tencent.mm.plugin.mv.model.m.Gcu);
        if ((com.tencent.mm.plugin.mv.model.m.Gcu != 1) && (com.tencent.mm.plugin.mv.model.m.Gcu != 2)) {
          ((ii)localObject2).sS(paramInt);
        }
        ((ii)localObject2).bpa();
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
        localObject2 = MusicMvMakerUI.e(this.Gey);
        if (localObject2 == null) {
          break label430;
        }
        paramInt = parama.type;
        if (localObject1 != null) {
          break;
        }
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "invalid parameters, type:" + paramInt + ", uniqueId:" + localObject1);
        AppMethodBeat.o(230741);
        return;
        localObject1 = null;
        continue;
        localObject1 = parama.GcH;
        if (localObject1 != null)
        {
          localObject1 = ((a.c)localObject1).Gbc;
          if (localObject1 != null)
          {
            localObject1 = Long.valueOf(((FinderObject)localObject1).id);
            continue;
          }
        }
        localObject1 = null;
      }
      switch (paramInt)
      {
      default: 
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "error logic.type:" + paramInt + ", uniqueId:" + localObject1);
        AppMethodBeat.o(230741);
        return;
      case 1: 
      case 3: 
        parama = ((MusicMVCardChooseView)localObject2).Gnn;
        if (parama != null)
        {
          parama.OK(((Long)localObject1).longValue());
          AppMethodBeat.o(230741);
          return;
        }
        AppMethodBeat.o(230741);
        return;
      }
      parama = ((MusicMVCardChooseView)localObject2).Gnz;
      if (parama != null) {
        parama.OK(((Long)localObject1).longValue());
      }
      parama = ((MusicMVCardChooseView)localObject2).GnA;
      if (parama != null) {
        parama.OK(((Long)localObject1).longValue());
      }
      parama = ((MusicMVCardChooseView)localObject2).GnB;
      if (parama != null) {
        parama.OK(((Long)localObject1).longValue());
      }
      parama = ((MusicMVCardChooseView)localObject2).GnC;
      if (parama != null)
      {
        parama.OK(((Long)localObject1).longValue());
        AppMethodBeat.o(230741);
        return;
      }
      AppMethodBeat.o(230741);
      return;
      label430:
      AppMethodBeat.o(230741);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.a<x>
  {
    y(MusicMvMakerUI paramMusicMvMakerUI, MusicMvTabFragment.f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MusicMvMakerUI paramMusicMvMakerUI, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(234774);
      Object localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = ((n)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.Gey).i(n.class)).fhj();
      ((MusicMvFlexLiveList)localObject).U((kotlin.g.a.b)new q((MusicMvFlexLiveList)localObject) {});
      AppMethodBeat.o(234774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI
 * JD-Core Version:    0.7.0.1
 */