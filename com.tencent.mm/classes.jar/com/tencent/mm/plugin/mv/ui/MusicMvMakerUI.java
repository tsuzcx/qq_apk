package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kp;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l.c;
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
import com.tencent.mm.plugin.mv.model.g;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.mv.ui.uic.k.e;
import com.tencent.mm.plugin.mv.ui.uic.l.b;
import com.tencent.mm.plugin.mv.ui.uic.m.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.f;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;

@com.tencent.mm.ui.base.a(33)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "()V", "albumAnimationContainer", "Landroid/view/View;", "getAlbumAnimationContainer", "()Landroid/view/View;", "albumAnimationContainer$delegate", "Lkotlin/Lazy;", "albumFakeThumb", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAlbumFakeThumb", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "albumFakeThumb$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "fixMvCardRV", "Landroidx/recyclerview/widget/RecyclerView;", "getFixMvCardRV", "()Landroidx/recyclerview/widget/RecyclerView;", "fixMvCardRV$delegate", "mvChooseView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "getMvChooseView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "mvChooseView$delegate", "mvItemEditBottomLine", "getMvItemEditBottomLine", "mvItemEditBottomLine$delegate", "mvItemEditThumb", "Landroid/widget/ImageView;", "getMvItemEditThumb", "()Landroid/widget/ImageView;", "mvItemEditThumb$delegate", "mvListEditBottomLine", "getMvListEditBottomLine", "mvListEditBottomLine$delegate", "mvTypeObserver", "Landroidx/lifecycle/Observer;", "", "nextBtn", "getNextBtn", "nextBtn$delegate", "nextIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getNextIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "nextIv$delegate", "onDelListener", "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1", "Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1;", "selectClipCnt", "check", "", "durationMs", "clipCnt", "isVideo", "doNext", "", "finish", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "makeMediaThumbTransition", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onAnimationEnd", "Lkotlin/Function0;", "onAlbumItemClicked", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onAlbumItemFlexChecked", "isChecked", "fragmentType", "onBusinessPermissionDenied", "permission", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinderItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onFinderItemFlexChecked", "onFinderItemFlexClicked", "position", "onHeaderCameraClicked", "minRecordDurationMs", "onNextBtnStatusChange", "enable", "onPause", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "onResume", "onSearchBarClicked", "updateFixNextEnable", "updateFlexNextEnable", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerUI
  extends BaseMusicMvUI
  implements MusicMVCardChooseView.b
{
  public static final MusicMvMakerUI.a LZQ;
  private static int pvg;
  private static int sJv;
  private final kotlin.j FQn;
  private final kotlin.j LZR;
  private final kotlin.j LZS;
  private final kotlin.j LZT;
  private final kotlin.j LZU;
  private final kotlin.j LZV;
  private final kotlin.j LZW;
  private final kotlin.j LZX;
  private final kotlin.j LZY;
  private final kotlin.j LZZ;
  private int Maa;
  private final y<Integer> Mab;
  private final q Mac;
  
  static
  {
    AppMethodBeat.i(286596);
    LZQ = new MusicMvMakerUI.a((byte)0);
    AppMethodBeat.o(286596);
  }
  
  public MusicMvMakerUI()
  {
    AppMethodBeat.i(286345);
    this.LZR = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.LZS = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.FQn = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.LZT = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.LZU = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.LZV = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.LZW = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.LZX = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.LZY = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.LZZ = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Mab = new MusicMvMakerUI..ExternalSyntheticLambda7(this);
    this.Mac = new q(this);
    AppMethodBeat.o(286345);
  }
  
  private final boolean H(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(286412);
    if ((paramBoolean) && (paramInt1 <= 2000))
    {
      new g.a((Context)this).bDE(getResources().getString(b.h.music_mv_flex_min_video_limit)).bDI(getResources().getString(b.h.app_i_know)).show();
      AppMethodBeat.o(286412);
      return false;
    }
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.j.class);
    s.s(localObject, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    localObject = (com.tencent.mm.plugin.mv.ui.uic.j)localObject;
    this.Maa += paramInt2;
    int i = this.Maa;
    localObject = (dtf)((com.tencent.mm.plugin.mv.ui.uic.j)localObject).Mff.getValue();
    if (localObject == null) {}
    for (paramInt1 = 0; i > paramInt1; paramInt1 = ((dtf)localObject).Mea)
    {
      this.Maa -= paramInt2;
      new g.a((Context)this).bDE(getResources().getString(b.h.music_mv_reach_max_limit)).bDI(getResources().getString(b.h.app_i_know)).show();
      AppMethodBeat.o(286412);
      return false;
    }
    AppMethodBeat.o(286412);
    return true;
  }
  
  private static final void a(TextView paramTextView1, MusicMvMakerUI paramMusicMvMakerUI, TextView paramTextView2, Integer paramInteger)
  {
    AppMethodBeat.i(286482);
    s.u(paramTextView1, "$fixTV");
    s.u(paramMusicMvMakerUI, "this$0");
    s.u(paramTextView2, "$flexTV");
    label118:
    int i;
    if (paramInteger == null)
    {
      paramTextView2.setTextColor(paramMusicMvMakerUI.getResources().getColor(b.b.BW_100_Alpha_0_8));
      paramTextView1.setTextColor(paramMusicMvMakerUI.getResources().getColor(b.b.BW_100_Alpha_0_3));
      paramTextView1 = com.tencent.mm.ui.component.k.aeZF;
      paramTextView1 = (Iterable)((com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMusicMvMakerUI).q(com.tencent.mm.plugin.mv.ui.uic.l.class)).MfF.pUj;
      if (((paramTextView1 instanceof Collection)) && (((Collection)paramTextView1).isEmpty())) {
        break label218;
      }
      paramTextView1 = paramTextView1.iterator();
      if (!paramTextView1.hasNext()) {
        break label218;
      }
      if (((com.tencent.mm.plugin.mv.model.flex.a)paramTextView1.next()).type == 0) {
        break label212;
      }
      i = 1;
      label145:
      if (i == 0) {
        break label216;
      }
    }
    label212:
    label216:
    label218:
    for (boolean bool = true;; bool = false)
    {
      paramMusicMvMakerUI.zT(bool);
      AppMethodBeat.o(286482);
      return;
      if (paramInteger.intValue() != 0) {
        break;
      }
      paramTextView1.setTextColor(paramMusicMvMakerUI.getResources().getColor(b.b.BW_100_Alpha_0_8));
      paramTextView2.setTextColor(paramMusicMvMakerUI.getResources().getColor(b.b.BW_100_Alpha_0_3));
      paramMusicMvMakerUI.gpX();
      AppMethodBeat.o(286482);
      return;
      i = 0;
      break label145;
      break label118;
    }
  }
  
  private final void a(g paramg, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(286401);
    if (paramg == null)
    {
      parama.invoke();
      AppMethodBeat.o(286401);
      return;
    }
    gpU().setVisibility(0);
    paramg.q((ImageView)gpV());
    gpV().setRadius(0);
    int[] arrayOfInt = new int[2];
    gpW().getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += (gpW().getWidth() - paramg.Kz.getWidth()) / 2;
    arrayOfInt[1] += (gpW().getHeight() - paramg.Kz.getHeight()) / 2;
    paramg = new GravityArcMotion().getPath(paramg.LXC.x, paramg.LXC.y, arrayOfInt[0], arrayOfInt[1]);
    paramg = ObjectAnimator.ofFloat(gpV(), "x", "y", paramg);
    paramg.setInterpolator((TimeInterpolator)new androidx.g.a.a.b());
    paramg.setDuration(400L);
    paramg.addListener((Animator.AnimatorListener)new MusicMvMakerUI.f(this, parama));
    paramg.start();
    AppMethodBeat.o(286401);
  }
  
  private static final void a(MusicMvMakerUI paramMusicMvMakerUI, View paramView)
  {
    AppMethodBeat.i(286448);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvMakerUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvMakerUI, "this$0");
    paramMusicMvMakerUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286448);
  }
  
  private static final void a(MusicMvMakerUI paramMusicMvMakerUI, com.tencent.mm.plugin.mv.ui.uic.l paraml, com.tencent.mm.plugin.mvvmbase.a.a parama, com.tencent.mm.plugin.mv.ui.uic.k paramk, final com.tencent.mm.plugin.mv.ui.uic.j paramj, dtf paramdtf)
  {
    AppMethodBeat.i(286511);
    s.u(paramMusicMvMakerUI, "this$0");
    s.u(paraml, "$flexEditUIC");
    s.u(parama, "$lifecycleScopeUIC");
    s.u(paramk, "$editUIC");
    s.u(paramj, "$dataUIC");
    paraml.a((b.a)paramMusicMvMakerUI.Mac);
    s.s(paramdtf, "trackData");
    s.u(paramdtf, "trackData");
    Object localObject1 = paramdtf.aaYK;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if ((localObject1 != null) && (((bol)localObject1).ZWM == 1)) {
          i = 1;
        }
      }
    }
    label329:
    label483:
    int j;
    while (i != 0)
    {
      HashMap localHashMap = new HashMap();
      localObject1 = paramdtf.ZJp;
      s.s(localObject1, "trackData.refObjectList");
      Iterator localIterator = ((Iterable)localObject1).iterator();
      Object localObject3;
      Object localObject4;
      Object localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject3 = (FinderObject)localIterator.next();
          localObject4 = (Map)localHashMap;
          localObject2 = ((FinderObject)localObject3).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          s.s(localObject3, "it");
          ((Map)localObject4).put(localObject1, localObject3);
          continue;
          i = 0;
          break;
        }
      }
      localObject1 = paramdtf.aaYK;
      long l;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", s.X("initDraftSelectItem ", localObject1));
        localObject1 = paramdtf.aaYK;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((bol)localObject1).ZWL;
        if (localObject1 == null) {
          break;
        }
        localIterator = ((Iterable)localObject1).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label1282;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject4 = (boq)localObject1;
        localObject3 = (FinderObject)((Map)localHashMap).get(((boq)localObject4).ZWZ);
        if (localObject3 != null)
        {
          if (((boq)localObject4).refObjectId != 0L) {
            break label1095;
          }
          localObject2 = ((boq)localObject4).ZWZ;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          l = System.currentTimeMillis();
          localObject2 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject1, 1, i + l, 0);
          ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr = new com.tencent.mm.plugin.mv.model.flex.a.a((byte)0);
          localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
          if (localObject1 == null) {}
        }
      }
      try
      {
        localObject4 = ((boq)localObject4).ZWZ;
        if (localObject4 != null) {
          break label905;
        }
        l = 0L;
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            l = 0L;
            continue;
            if (!n.bp((CharSequence)localObject1))
            {
              j = 1;
              if (j == 0) {
                break label985;
              }
            }
            for (;;)
            {
              if (localObject1 != null) {
                break label991;
              }
              localObject1 = "0";
              break;
              j = 0;
              break label961;
              localObject1 = null;
            }
            continue;
            l = locala.HHJ;
          }
          localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
        } while (localObject1 == null);
        localObject5 = new GalleryItem.ImageMediaItem();
        locala = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
        if (locala != null) {
          break label1085;
        }
      }
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).HHJ = l;
      localObject1 = ((FinderObject)localObject3).objectDesc;
      com.tencent.mm.plugin.mv.model.flex.a.a locala;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          localObject3 = (FinderMedia)p.oL((List)localObject1);
          if (localObject3 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).thumbPath = ((FinderMedia)localObject3).url;
            }
            localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).width = ((int)((FinderMedia)localObject3).width);
            }
            localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).height = ((int)((FinderMedia)localObject3).height);
            }
            localObject4 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
            if (localObject4 != null)
            {
              localObject1 = ((FinderMedia)localObject3).decodeKey;
              if (localObject1 != null) {
                break label947;
              }
              localObject1 = "0";
              ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject4).LYu = Long.parseLong((String)localObject1);
            }
            ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = ((FinderMedia)localObject3).videoDuration;
            if (((FinderMedia)localObject3).videoDuration <= 0) {
              break label1004;
            }
            localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
            if (localObject1 != null)
            {
              localObject4 = new GalleryItem.VideoMediaItem();
              locala = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
              if (locala != null) {
                break label994;
              }
              l = 0L;
              ((GalleryItem.VideoMediaItem)localObject4).HHJ = l;
              ((GalleryItem.VideoMediaItem)localObject4).oTN = ((FinderMedia)localObject3).videoDuration;
              ((GalleryItem.VideoMediaItem)localObject4).Gcc = ((FinderMedia)localObject3).url;
              ((GalleryItem.VideoMediaItem)localObject4).zWJ = ((FinderMedia)localObject3).url;
              ((GalleryItem.VideoMediaItem)localObject4).nCg = ((FinderMedia)localObject3).bitrate;
              ((GalleryItem.VideoMediaItem)localObject4).videoWidth = ((int)((FinderMedia)localObject3).width);
              ((GalleryItem.VideoMediaItem)localObject4).videoHeight = ((int)((FinderMedia)localObject3).height);
              ((GalleryItem.VideoMediaItem)localObject4).oTN = ((FinderMedia)localObject3).videoDuration;
              localObject3 = ah.aiuX;
              ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).HHB = ((GalleryItem.MediaItem)localObject4);
            }
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
        }
      }
      MvvmList.a((MvvmList)paraml.MfF, (com.tencent.mm.plugin.mvvmlist.b)localObject2);
      paraml.MfF.gpN();
      for (;;)
      {
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        i += 1;
        break label329;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((bol)localObject1).ZWL;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        break;
        label905:
        localObject4 = n.bV((String)localObject4, "local_", "");
        if (localObject4 == null)
        {
          l = 0L;
          break label483;
        }
        l = Long.parseLong((String)localObject4);
        break label483;
        label947:
        label961:
        label985:
        label991:
        label994:
        label1004:
        Object localObject5;
        label1085:
        for (l = 0L;; l = locala.HHJ)
        {
          ((GalleryItem.ImageMediaItem)localObject5).HHJ = l;
          ((GalleryItem.ImageMediaItem)localObject5).Gcc = ((FinderMedia)localObject3).url;
          ((GalleryItem.ImageMediaItem)localObject5).zWJ = ((FinderMedia)localObject3).url;
          localObject3 = ah.aiuX;
          ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).HHB = ((GalleryItem.MediaItem)localObject5);
          break;
        }
        label1095:
        localObject1 = com.tencent.mm.ae.d.hF(((FinderObject)localObject3).id);
        l = System.currentTimeMillis();
        localObject1 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject1, 2, i + l, -1);
        ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs = new a.c((byte)0);
        localObject2 = ((FinderObject)localObject3).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).media;
          if (localObject2 != null)
          {
            localObject2 = (FinderMedia)p.oL((List)localObject2);
            if (localObject2 != null)
            {
              localObject5 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs;
              if (localObject5 != null) {
                ((a.c)localObject5).thumbUrl = s.X(((FinderMedia)localObject2).thumbUrl, ((FinderMedia)localObject2).thumb_url_token);
              }
              localObject5 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs;
              if (localObject5 != null) {
                ((a.c)localObject5).EDa = ((FinderObject)localObject3);
              }
              ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).videoDuration = (((FinderMedia)localObject2).videoDuration * 1000);
              localObject2 = ah.aiuX;
              localObject2 = ah.aiuX;
            }
          }
        }
        MvvmList.a((MvvmList)paraml.MfF, (com.tencent.mm.plugin.mvvmlist.b)localObject1);
        paraml.MfF.gpN();
      }
      label1282:
      localObject1 = ah.aiuX;
    }
    kotlinx.coroutines.j.a((aq)parama.gsu(), (kotlin.d.f)bg.kCh(), null, (kotlin.g.a.m)new MusicMvMakerUI.n(paraml, paramj, paramMusicMvMakerUI, null), 2);
    paramk.LZM = paramdtf;
    paramk.LMB = paramj.LMB;
    paramk.gqS();
    paramk.Mfo = ((k.e)new o(paramMusicMvMakerUI, paramj));
    paraml = paramj.LMB;
    if (paraml != null)
    {
      i = (int)(pvg * 0.45F);
      j = pvg;
      int k = com.tencent.mm.cd.a.fromDPToPix((Context)paramMusicMvMakerUI, 64);
      int m = pvg;
      int n = com.tencent.mm.cd.a.fromDPToPix((Context)paramMusicMvMakerUI, 256);
      parama = paramMusicMvMakerUI.gpT();
      if (parama != null)
      {
        paramk = (MMActivity)paramMusicMvMakerUI;
        s.u(paramk, "activity");
        s.u(paraml, "music");
        parama.activity = paramk;
        parama.LMB = paraml;
        parama.rIW = i;
        parama.maxHeight = (j - k);
        parama.MhO = (m - n);
        parama.initContentView();
        com.tencent.mm.plugin.gallery.model.e.fAv();
      }
      paraml = paramMusicMvMakerUI.gpT();
      if (paraml != null)
      {
        paramMusicMvMakerUI = (MusicMVCardChooseView.b)paramMusicMvMakerUI;
        s.u(paramMusicMvMakerUI, "listener");
        paraml.MhI = paramMusicMvMakerUI;
      }
    }
    if (!com.tencent.mm.plugin.music.model.m.dsS())
    {
      paramj.gqP().t(Integer.valueOf(0));
      paramj.zZ(false);
      AppMethodBeat.o(286511);
      return;
    }
    paramMusicMvMakerUI = paramdtf.aaYK;
    if (paramMusicMvMakerUI == null) {
      i = 0;
    }
    for (;;)
    {
      paramj.gqP().t(Integer.valueOf(i));
      paramj.zZ(true);
      AppMethodBeat.o(286511);
      return;
      paramMusicMvMakerUI = paramMusicMvMakerUI.objectDesc;
      if (paramMusicMvMakerUI == null)
      {
        i = 0;
      }
      else
      {
        paramMusicMvMakerUI = paramMusicMvMakerUI.mvInfo;
        if (paramMusicMvMakerUI == null)
        {
          i = 0;
        }
        else
        {
          paramMusicMvMakerUI = Integer.valueOf(paramMusicMvMakerUI.ZWM);
          if (((Number)paramMusicMvMakerUI).intValue() == 1)
          {
            i = 1;
            label1628:
            if (i == 0) {
              break label1649;
            }
          }
          for (;;)
          {
            if (paramMusicMvMakerUI != null) {
              break label1654;
            }
            i = 0;
            break;
            i = 0;
            break label1628;
            label1649:
            paramMusicMvMakerUI = null;
          }
          label1654:
          i = paramMusicMvMakerUI.intValue();
        }
      }
    }
  }
  
  private static final void a(MusicMvMakerUI paramMusicMvMakerUI, Integer paramInteger)
  {
    AppMethodBeat.i(286515);
    s.u(paramMusicMvMakerUI, "this$0");
    if (paramInteger == null)
    {
      AppMethodBeat.o(286515);
      return;
    }
    if (paramInteger.intValue() == 1) {
      paramMusicMvMakerUI.bYw();
    }
    AppMethodBeat.o(286515);
  }
  
  private static final void a(MusicMvMakerUI paramMusicMvMakerUI, LinkedList paramLinkedList)
  {
    AppMethodBeat.i(286538);
    s.u(paramMusicMvMakerUI, "this$0");
    s.u(paramLinkedList, "$mediaItems");
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    paramMusicMvMakerUI = ((com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMusicMvMakerUI).q(com.tencent.mm.plugin.mv.ui.uic.l.class)).MfF;
    paramMusicMvMakerUI.aB((kotlin.g.a.b)new MusicMvMakerUI.s(paramLinkedList, paramMusicMvMakerUI));
    AppMethodBeat.o(286538);
  }
  
  private static final void a(com.tencent.mm.plugin.mv.ui.uic.j paramj, View paramView)
  {
    AppMethodBeat.i(286464);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dataUIC");
    paramView = (Integer)paramj.gqP().getValue();
    if (paramView == null) {}
    for (;;)
    {
      paramj.gqP().t(Integer.valueOf(1));
      paramj = com.tencent.mm.plugin.mv.model.m.LYc;
      com.tencent.mm.plugin.mv.model.m.zS(true);
      do
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286464);
        return;
      } while (paramView.intValue() == 1);
    }
  }
  
  private static final void b(MusicMvMakerUI paramMusicMvMakerUI, View paramView)
  {
    AppMethodBeat.i(286455);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvMakerUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvMakerUI, "this$0");
    paramMusicMvMakerUI.bYw();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286455);
  }
  
  private static final void b(MusicMvMakerUI paramMusicMvMakerUI, Integer paramInteger)
  {
    AppMethodBeat.i(286519);
    s.u(paramMusicMvMakerUI, "this$0");
    if (paramInteger == null)
    {
      AppMethodBeat.o(286519);
      return;
    }
    if (paramInteger.intValue() == 1)
    {
      paramMusicMvMakerUI = paramMusicMvMakerUI.gpT();
      if (paramMusicMvMakerUI != null) {
        paramMusicMvMakerUI.grq();
      }
    }
    AppMethodBeat.o(286519);
  }
  
  private static final void b(com.tencent.mm.plugin.mv.ui.uic.j paramj, View paramView)
  {
    AppMethodBeat.i(286471);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dataUIC");
    paramView = (Integer)paramj.gqP().getValue();
    if (paramView == null) {}
    for (;;)
    {
      paramj.gqP().t(Integer.valueOf(0));
      paramj = com.tencent.mm.plugin.mv.model.m.LYc;
      com.tencent.mm.plugin.mv.model.m.zS(false);
      do
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286471);
        return;
      } while (paramView.intValue() == 0);
    }
  }
  
  private final void bYw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(286438);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.j.class);
    s.s(localObject1, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    localObject1 = (Integer)((com.tencent.mm.plugin.mv.ui.uic.j)localObject1).gqP().getValue();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      if (((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.k.class)).gqV())
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
        localObject2 = new Intent((Context)((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).getActivity(), MusicMvMakerPreviewUI.class);
        localObject3 = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).f(((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).LZM);
        if (localObject3 != null) {
          ((Intent)localObject2).putExtra("key_track_data", ((dtf)localObject3).toByteArray());
        }
        ((Intent)localObject2).putExtra("key_seek_to_start", true);
        com.tencent.mm.ae.d.a((Intent)localObject2, ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).getActivity().getIntent(), "key_mv_from_scene");
        localObject3 = com.tencent.mm.plugin.music.model.c.LLZ;
        com.tencent.mm.plugin.music.model.c.zK(true);
        localObject3 = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).getActivity();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((AppCompatActivity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject2 = (Iterable)((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).pUj;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    else
    {
      label283:
      label561:
      label575:
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label577;
        }
        localObject3 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.mv.model.e)localObject3).LWZ != null) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label575;
          }
          ((Collection)localObject1).add(localObject3);
          break label283;
          if (((Integer)localObject1).intValue() != 1) {
            break;
          }
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = (com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
          localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.l)localObject3).lzP;
          Object localObject4;
          Context localContext;
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 == null)
            {
              localObject4 = (com.tencent.mm.plugin.mv.ui.uic.l)localObject3;
              localContext = (Context)((com.tencent.mm.plugin.mv.ui.uic.l)localObject4).getContext();
              localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.l)localObject4).getContext();
              if (localObject1 != null) {
                break label561;
              }
            }
          }
          for (localObject1 = localObject2;; localObject1 = ((Activity)localObject1).getString(b.h.app_waiting))
          {
            ((com.tencent.mm.plugin.mv.ui.uic.l)localObject4).lzP = ((ProgressDialog)w.a(localContext, (CharSequence)localObject1, false));
            localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.l)localObject4).lzP;
            if (localObject1 != null) {
              ((ProgressDialog)localObject1).show();
            }
            localObject1 = new dsd();
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            localObject2 = com.tencent.mm.ui.component.k.d(((com.tencent.mm.plugin.mv.ui.uic.l)localObject3).getActivity()).q(com.tencent.mm.plugin.mv.ui.uic.j.class);
            s.s(localObject2, "UICProvider.of(activity)…MakerDataUIC::class.java)");
            localObject2 = (com.tencent.mm.plugin.mv.ui.uic.j)localObject2;
            localObject4 = com.tencent.mm.ui.component.k.aeZF;
            localObject4 = com.tencent.mm.ui.component.k.d(((com.tencent.mm.plugin.mv.ui.uic.l)localObject3).getActivity()).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
            s.s(localObject4, "UICProvider.of(activity)…ycleScopeUIC::class.java)");
            localObject4 = (com.tencent.mm.plugin.mvvmbase.a.a)localObject4;
            ((dsd)localObject1).aaXW = ((com.tencent.mm.plugin.mv.ui.uic.j)localObject2).LWI;
            ((com.tencent.mm.plugin.mv.ui.uic.l)localObject3).MfF.aB((kotlin.g.a.b)new l.b((dsd)localObject1, (com.tencent.mm.plugin.mv.ui.uic.l)localObject3, (com.tencent.mm.plugin.mvvmbase.a.a)localObject4, (com.tencent.mm.plugin.mv.ui.uic.j)localObject2));
            AppMethodBeat.o(286438);
            return;
            ((ProgressDialog)localObject1).show();
            localObject1 = ah.aiuX;
            break;
          }
        }
      }
      label577:
      int i = ((List)localObject1).size();
      localObject1 = com.tencent.mm.plugin.mv.model.m.LYc;
      com.tencent.mm.plugin.mv.model.m.kf(0, i);
    }
    AppMethodBeat.o(286438);
  }
  
  private static final void c(MusicMvMakerUI paramMusicMvMakerUI, Integer paramInteger)
  {
    AppMethodBeat.i(286530);
    s.u(paramMusicMvMakerUI, "this$0");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMusicMvMakerUI).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
    s.s(localObject1, "UICProvider.of(this).get…rFlexEditUIC::class.java)");
    localObject1 = (com.tencent.mm.plugin.mv.ui.uic.l)localObject1;
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMusicMvMakerUI).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
    s.s(localObject2, "UICProvider.of(this).get…erFixEditUIC::class.java)");
    localObject2 = (com.tencent.mm.plugin.mv.ui.uic.k)localObject2;
    if (paramInteger == null) {}
    while (paramInteger == null)
    {
      AppMethodBeat.o(286530);
      return;
      if (paramInteger.intValue() == 1)
      {
        ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).gqW().setVisibility(0);
        ((com.tencent.mm.plugin.mv.ui.uic.k)localObject2).gqQ().setVisibility(8);
        paramMusicMvMakerUI = paramMusicMvMakerUI.gpT();
        if (paramMusicMvMakerUI == null) {
          break label366;
        }
        if (!paramMusicMvMakerUI.LPC) {
          MusicMVCardChooseView.a(paramMusicMvMakerUI, paramMusicMvMakerUI.rIW, paramMusicMvMakerUI.MhO, false, 28);
        }
        paramMusicMvMakerUI.HMO = 3;
        paramMusicMvMakerUI.grt();
        paramMusicMvMakerUI.ae(true, 2000);
        paramInteger = paramMusicMvMakerUI.MhD;
        if (paramInteger != null) {
          paramInteger.gsd();
        }
        paramInteger = paramMusicMvMakerUI.MhE;
        if (paramInteger != null) {
          paramInteger.gsd();
        }
        paramInteger = paramMusicMvMakerUI.MhF;
        if (paramInteger != null) {
          paramInteger.gsd();
        }
        paramInteger = paramMusicMvMakerUI.MhG;
        if (paramInteger != null) {
          paramInteger.gsd();
        }
        paramMusicMvMakerUI = paramMusicMvMakerUI.Mhx;
        if (paramMusicMvMakerUI != null) {
          paramMusicMvMakerUI.gsd();
        }
        AppMethodBeat.o(286530);
        return;
      }
    }
    if (paramInteger.intValue() == 0)
    {
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).gqW().setVisibility(8);
      ((com.tencent.mm.plugin.mv.ui.uic.k)localObject2).gqT();
      paramMusicMvMakerUI = paramMusicMvMakerUI.gpT();
      if (paramMusicMvMakerUI != null)
      {
        if (!paramMusicMvMakerUI.LPC) {
          MusicMVCardChooseView.a(paramMusicMvMakerUI, paramMusicMvMakerUI.MhO, paramMusicMvMakerUI.rIW, false, 28);
        }
        paramMusicMvMakerUI.HMO = 2;
        paramMusicMvMakerUI.grt();
        paramMusicMvMakerUI.ae(false, MusicMVCardChooseView.MhS);
        paramInteger = paramMusicMvMakerUI.MhD;
        if (paramInteger != null) {
          paramInteger.gse();
        }
        paramInteger = paramMusicMvMakerUI.MhE;
        if (paramInteger != null) {
          paramInteger.gse();
        }
        paramInteger = paramMusicMvMakerUI.MhF;
        if (paramInteger != null) {
          paramInteger.gse();
        }
        paramInteger = paramMusicMvMakerUI.MhG;
        if (paramInteger != null) {
          paramInteger.gse();
        }
        paramMusicMvMakerUI = paramMusicMvMakerUI.Mhx;
        if (paramMusicMvMakerUI != null) {
          paramMusicMvMakerUI.gse();
        }
      }
    }
    label366:
    AppMethodBeat.o(286530);
  }
  
  private final View gpR()
  {
    AppMethodBeat.i(286351);
    View localView = (View)this.LZT.getValue();
    AppMethodBeat.o(286351);
    return localView;
  }
  
  private final WeImageView gpS()
  {
    AppMethodBeat.i(286357);
    WeImageView localWeImageView = (WeImageView)this.LZU.getValue();
    AppMethodBeat.o(286357);
    return localWeImageView;
  }
  
  private final MusicMVCardChooseView gpT()
  {
    AppMethodBeat.i(286364);
    MusicMVCardChooseView localMusicMVCardChooseView = (MusicMVCardChooseView)this.LZV.getValue();
    AppMethodBeat.o(286364);
    return localMusicMVCardChooseView;
  }
  
  private final View gpU()
  {
    AppMethodBeat.i(286370);
    View localView = (View)this.LZW.getValue();
    AppMethodBeat.o(286370);
    return localView;
  }
  
  private final MMRoundCornerImageView gpV()
  {
    AppMethodBeat.i(286375);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.LZX.getValue();
    AppMethodBeat.o(286375);
    return localMMRoundCornerImageView;
  }
  
  private final RecyclerView gpW()
  {
    AppMethodBeat.i(286383);
    RecyclerView localRecyclerView = (RecyclerView)this.LZZ.getValue();
    AppMethodBeat.o(286383);
    return localRecyclerView;
  }
  
  private final void gpX()
  {
    AppMethodBeat.i(286419);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    zT(((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.k.class)).gqV());
    AppMethodBeat.o(286419);
  }
  
  private final void zT(boolean paramBoolean)
  {
    AppMethodBeat.i(286390);
    if (paramBoolean)
    {
      localView = gpR();
      if (localView != null) {
        localView.setBackground(getResources().getDrawable(b.d.LRJ));
      }
      gpS().setIconColor(MMApplicationContext.getContext().getResources().getColor(b.b.White));
      AppMethodBeat.o(286390);
      return;
    }
    View localView = gpR();
    if (localView != null) {
      localView.setBackground(getResources().getDrawable(b.d.LRI));
    }
    gpS().setIconColor(MMApplicationContext.getContext().getResources().getColor(b.b.BW_100_Alpha_0_1));
    AppMethodBeat.o(286390);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(GalleryItem.MediaItem paramMediaItem, g paramg)
  {
    AppMethodBeat.i(286725);
    s.u(paramMediaItem, "data");
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      a(paramg, (kotlin.g.a.a)new MusicMvMakerUI.m(this, paramMediaItem));
      AppMethodBeat.o(286725);
      return;
    }
    Log.e("MicroMsg.Mv.MusicMvMakerUI", "data must be GalleryItem.VideoMediaItem");
    AppMethodBeat.o(286725);
  }
  
  public final void a(MusicMvTabFragment.f paramf, g paramg)
  {
    AppMethodBeat.i(286750);
    s.u(paramf, "data");
    a(paramg, (kotlin.g.a.a)new MusicMvMakerUI.r(this, paramf));
    AppMethodBeat.o(286750);
  }
  
  public final boolean a(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem)
  {
    int k = 0;
    AppMethodBeat.i(286746);
    s.u(paramMediaItem, "data");
    Object localObject1 = a.Maz;
    Object localObject2 = a.sH(paramMediaItem.HHJ);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      i = 3;
      if (!(paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        break label141;
      }
    }
    label141:
    for (int j = ((GalleryItem.VideoMediaItem)paramMediaItem).oTN;; j = 0)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
      s.s(localObject1, "UICProvider.of(this@Musi…rFlexEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.l)localObject1;
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).Ake = true;
      if (paramBoolean) {
        break label147;
      }
      this.Maa -= i;
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.aPJ((String)localObject2);
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.gpN();
      AppMethodBeat.o(286746);
      return true;
      i = 1;
      break;
    }
    label147:
    if (!H(j, i, paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      AppMethodBeat.o(286746);
      return false;
    }
    s.u(paramMediaItem, "data");
    Object localObject3 = new com.tencent.mm.plugin.mv.model.e();
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 1;
    Object localObject4 = com.tencent.mm.plugin.mv.model.e.LWT;
    s.u(paramMediaItem, "mediaItem");
    s.u(localObject3, "item");
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 1;
    ((com.tencent.mm.plugin.mv.model.e)localObject3).LWX = ((e.g)new e.f(paramMediaItem));
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      localObject4 = paramMediaItem.aUt();
      s.s(localObject4, "mediaItem.uniqueValue()");
      String str = ((GalleryItem.VideoMediaItem)paramMediaItem).Gcc;
      s.s(str, "mediaItem.originalPath");
      localObject4 = new e.i((String)localObject4, str, ((GalleryItem.VideoMediaItem)paramMediaItem).oTN);
      ((e.i)localObject4).videoWidth = ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
      ((e.i)localObject4).videoHeight = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight;
      ((com.tencent.mm.plugin.mv.model.e)localObject3).LWY = ((e.h)localObject4);
    }
    localObject4 = com.tencent.mm.plugin.mv.model.m.LYc;
    com.tencent.mm.plugin.mv.model.m.adS(2);
    localObject4 = com.tencent.mm.plugin.mv.model.m.LYc;
    com.tencent.mm.plugin.mv.model.m.a(((List)((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.pUj).size(), (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject2 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject2, 1, System.currentTimeMillis(), 0);
    ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr = new com.tencent.mm.plugin.mv.model.flex.a.a((byte)0);
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).thumbPath = paramMediaItem.bud();
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).HHJ = paramMediaItem.HHJ;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).LYu = paramMediaItem.HHK;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).HHB = paramMediaItem;
    }
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
      ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = ((GalleryItem.VideoMediaItem)paramMediaItem).oTN;
    }
    label554:
    do
    {
      MvvmList.a((MvvmList)((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF, (com.tencent.mm.plugin.mvvmlist.b)localObject2);
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.gpN();
      AppMethodBeat.o(286746);
      return true;
      ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = 0;
      paramMediaItem = BitmapUtil.getPictureSize(paramMediaItem.bud());
      localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
      if (localObject3 != null)
      {
        if (paramMediaItem != null) {
          break;
        }
        i = 0;
        ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).width = i;
      }
      localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYr;
    } while (localObject3 == null);
    if (paramMediaItem == null) {}
    for (int i = k;; i = paramMediaItem.y)
    {
      ((com.tencent.mm.plugin.mv.model.flex.a.a)localObject3).height = i;
      break;
      i = paramMediaItem.x;
      break label554;
    }
  }
  
  public final boolean a(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt)
  {
    AppMethodBeat.i(286765);
    s.u(paramf, "data");
    Object localObject2 = com.tencent.mm.ae.d.hF(paramf.feedId);
    Object localObject1 = paramf.feedObject;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label203;
      }
    }
    label203:
    for (int i = 0;; i = ((Integer)localObject1).intValue())
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
      s.s(localObject1, "UICProvider.of(this@Musi…rFlexEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.l)localObject1;
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).Ake = true;
      if (paramBoolean) {
        break label213;
      }
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.aPJ((String)localObject2);
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.gpN();
      this.Maa -= 3;
      AppMethodBeat.o(286765);
      return true;
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (FinderMedia)p.ae((List)localObject1, 0);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((FinderMedia)localObject1).videoDuration * 1000);
      break;
    }
    label213:
    if (!H(i, 3, true))
    {
      AppMethodBeat.o(286765);
      return false;
    }
    s.u(paramf, "data");
    Object localObject3 = new com.tencent.mm.plugin.mv.model.e();
    ((com.tencent.mm.plugin.mv.model.e)localObject3).type = 2;
    Object localObject4 = com.tencent.mm.plugin.mv.model.e.LWT;
    e.b.a(paramf, (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject4 = com.tencent.mm.plugin.mv.model.m.LYc;
    com.tencent.mm.plugin.mv.model.m.a(((List)((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.pUj).size(), (com.tencent.mm.plugin.mv.model.e)localObject3);
    localObject2 = new com.tencent.mm.plugin.mv.model.flex.a((String)localObject2, 2, System.currentTimeMillis(), paramInt);
    ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYs = new a.c((byte)0);
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYs;
    if (localObject3 != null) {
      ((a.c)localObject3).EDa = paramf.feedObject;
    }
    localObject3 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYs;
    if (localObject3 != null)
    {
      paramf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).LYs;
      if (paramf != null) {
        break label410;
      }
      paramf = null;
    }
    for (;;)
    {
      ((a.c)localObject3).thumbUrl = paramf;
      ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration = i;
      MvvmList.a((MvvmList)((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF, (com.tencent.mm.plugin.mvvmlist.b)localObject2);
      ((com.tencent.mm.plugin.mv.ui.uic.l)localObject1).MfF.gpN();
      AppMethodBeat.o(286765);
      return true;
      label410:
      paramf = paramf.EDa;
      if (paramf == null)
      {
        paramf = null;
      }
      else
      {
        paramf = paramf.objectDesc;
        if (paramf == null)
        {
          paramf = null;
        }
        else
        {
          paramf = paramf.media;
          if (paramf == null)
          {
            paramf = null;
          }
          else
          {
            paramf = (FinderMedia)p.ae((List)paramf, 0);
            if (paramf == null) {
              paramf = null;
            } else {
              paramf = s.X(paramf.thumbUrl, paramf.thumb_url_token);
            }
          }
        }
      }
    }
  }
  
  public final void adU(int paramInt)
  {
    AppMethodBeat.i(286773);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.j.class);
    s.s(localObject, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    localObject = (Integer)((com.tencent.mm.plugin.mv.ui.uic.j)localObject).gqP().getValue();
    int i;
    int j;
    if (localObject == null)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      Intent localIntent;
      com.tencent.mm.plugin.music.model.c localc;
      if (i != 0)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = (com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().pause();
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "takePhoto, minDuration:" + paramInt + ", maxDuration:" + j);
        localIntent = new Intent((Context)((com.tencent.mm.plugin.mv.ui.uic.k)localObject).getActivity(), MusicMvRouterUI.class);
        localIntent.putExtra("KEY_MUSIC_ROUTER", 1);
        localIntent.putExtra("KEY_IS_FIX_CLIP_MODE", true);
        localIntent.putExtra("KEY_MIN_RECORD_DURATION", paramInt);
        localIntent.putExtra("KEY_MAX_RECORD_DURATION", j);
        localc = com.tencent.mm.plugin.music.model.c.LLZ;
        com.tencent.mm.plugin.music.model.c.zK(true);
        ((com.tencent.mm.plugin.mv.ui.uic.k)localObject).getActivity().startActivityForResult(localIntent, 1024);
        AppMethodBeat.o(286773);
        return;
        if (((Integer)localObject).intValue() == 0)
        {
          i = 1;
          j = paramInt;
        }
      }
      else
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = (com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().pause();
        Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "takePhoto, minDuration:" + paramInt + ", maxDuration:60000");
        localIntent = new Intent((Context)((com.tencent.mm.plugin.mv.ui.uic.l)localObject).getActivity(), MusicMvRouterUI.class);
        localIntent.putExtra("KEY_MUSIC_ROUTER", 1);
        localIntent.putExtra("KEY_IS_FIX_CLIP_MODE", false);
        localIntent.putExtra("KEY_MIN_RECORD_DURATION", paramInt);
        localIntent.putExtra("KEY_MAX_RECORD_DURATION", 60000);
        localc = com.tencent.mm.plugin.music.model.c.LLZ;
        com.tencent.mm.plugin.music.model.c.zK(true);
        ((com.tencent.mm.plugin.mv.ui.uic.l)localObject).getActivity().startActivityForResult(localIntent, 1025);
        AppMethodBeat.o(286773);
        return;
      }
      i = 0;
      j = 0;
    }
  }
  
  public final void bI(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(286778);
    s.u(paramLinkedList, "mediaItems");
    com.tencent.threadpool.h.ahAA.bm(new MusicMvMakerUI..ExternalSyntheticLambda9(this, paramLinkedList));
    AppMethodBeat.o(286778);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(286717);
    super.finish();
    AppMethodBeat.o(286717);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVF;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286667);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286667);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.k.class, com.tencent.mm.plugin.mv.ui.uic.l.class, com.tencent.mm.plugin.mv.ui.uic.m.class, com.tencent.mm.plugin.mv.ui.uic.j.class, com.tencent.mm.plugin.mv.ui.uic.q.class }));
    AppMethodBeat.o(286667);
    return localSet;
  }
  
  public final void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(286786);
    paramString = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class)).onBackPressed();
    AppMethodBeat.o(286786);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286691);
    super.onCreate(paramBundle);
    hideTitleView();
    setActionbarColor(getContext().getResources().getColor(b.b.transparent));
    hideActionbarLine();
    sJv = com.tencent.mm.cd.a.ms((Context)this);
    pvg = bf.bf((Context)this).y;
    paramBundle = (View)this.FQn.getValue();
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new MusicMvMakerUI..ExternalSyntheticLambda1(this));
    }
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
    s.s(paramBundle, "UICProvider.of(this).get…ycleScopeUIC::class.java)");
    com.tencent.mm.plugin.mvvmbase.a.a locala = (com.tencent.mm.plugin.mvvmbase.a.a)paramBundle;
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.j.class);
    s.s(paramBundle, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    final com.tencent.mm.plugin.mv.ui.uic.j localj = (com.tencent.mm.plugin.mv.ui.uic.j)paramBundle;
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.l.class);
    s.s(paramBundle, "UICProvider.of(this).get…rFlexEditUIC::class.java)");
    com.tencent.mm.plugin.mv.ui.uic.l locall = (com.tencent.mm.plugin.mv.ui.uic.l)paramBundle;
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
    s.s(paramBundle, "UICProvider.of(this).get…erFixEditUIC::class.java)");
    com.tencent.mm.plugin.mv.ui.uic.k localk = (com.tencent.mm.plugin.mv.ui.uic.k)paramBundle;
    paramBundle = gpR();
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new MusicMvMakerUI..ExternalSyntheticLambda0(this));
    }
    Object localObject2;
    if (com.tencent.mm.plugin.music.model.m.dsS())
    {
      ((LinearLayout)findViewById(b.e.LTH)).setVisibility(0);
      paramBundle = (TextView)findViewById(b.e.LSA);
      if (paramBundle == null)
      {
        paramBundle = null;
        localObject2 = (TextView)findViewById(b.e.LSx);
        if (localObject2 != null) {
          break label511;
        }
        label287:
        localj.gqP().a((androidx.lifecycle.q)this, new MusicMvMakerUI..ExternalSyntheticLambda4((TextView)localObject1, this, paramBundle));
      }
    }
    else
    {
      localj.gqP().a((androidx.lifecycle.q)this, this.Mab);
      localj.Mff.a((androidx.lifecycle.q)this, new MusicMvMakerUI..ExternalSyntheticLambda8(this, locall, locala, localk, localj));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).Mgk = ((m.b)new p(this, localj));
      paramBundle = o.LYk;
      paramBundle = (Context)this;
      localObject1 = localj.LWI;
      s.u(paramBundle, "context");
      s.u(localObject1, "songInfo");
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)com.tencent.mm.plugin.secdata.ui.a.a.a(paramBundle, 7, dtk.class);
      if ((localObject2 != null) && (10 == ((dtk)localObject2).scene)) {
        break label529;
      }
    }
    for (;;)
    {
      locall.MfB.a((androidx.lifecycle.q)this, new MusicMvMakerUI..ExternalSyntheticLambda6(this));
      locall.MfD.a((androidx.lifecycle.q)this, new MusicMvMakerUI..ExternalSyntheticLambda5(this));
      AppMethodBeat.o(286691);
      return;
      paramBundle.setOnClickListener(new MusicMvMakerUI..ExternalSyntheticLambda3(localj));
      break;
      label511:
      ((TextView)localObject2).setOnClickListener(new MusicMvMakerUI..ExternalSyntheticLambda2(localj));
      localObject1 = localObject2;
      break label287;
      label529:
      o.a(paramBundle, (boo)localObject1, new com.tencent.mm.plugin.mv.model.f());
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286711);
    super.onDestroy();
    Object localObject1 = gpT();
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.gallery.model.e.fAn().b((l.c)localObject1);
      Object localObject2 = ((MusicMVCardChooseView)localObject1).Mhp;
      if (localObject2 != null) {
        ((TabLayout)localObject2).b((TabLayout.b)((MusicMVCardChooseView)localObject1).MhK);
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).Mhx;
      if (localObject2 != null) {
        ((MusicMvTabSearchFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).MhF;
      if (localObject2 != null) {
        ((MusicMvTabMyFavFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).MhD;
      if (localObject2 != null) {
        ((MusicMvTabMachineFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).MhE;
      if (localObject2 != null) {
        ((MusicMvTabMyPostFragment)localObject2).onDestroy();
      }
      localObject1 = ((MusicMVCardChooseView)localObject1).MhG;
      if (localObject1 != null) {
        ((MusicMvTabMyLikeFragment)localObject1).onDestroy();
      }
      com.tencent.mm.plugin.gallery.model.e.fAw();
    }
    AppMethodBeat.o(286711);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286704);
    super.onPause();
    Object localObject = gpT();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).HMB = true;
    }
    localObject = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnQ();
    AppMethodBeat.o(286704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286699);
    super.onResume();
    Object localObject = gpT();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).HMB = false;
    }
    localObject = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.onResume();
    localObject = com.tencent.mm.plugin.music.model.l.LMH;
    com.tencent.mm.plugin.music.model.l.aX((Activity)this);
    AppMethodBeat.o(286699);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMRoundCornerImageView>
  {
    c(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    e(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<MusicMVCardChooseView>
  {
    g(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<View>
  {
    h(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    i(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<View>
  {
    j(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<View>
  {
    k(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    l(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$2", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements k.e
  {
    o(MusicMvMakerUI paramMusicMvMakerUI, com.tencent.mm.plugin.mv.ui.uic.j paramj) {}
    
    public final void a(com.tencent.mm.plugin.mv.model.e parame, boolean paramBoolean, g paramg)
    {
      AppMethodBeat.i(286524);
      s.u(parame, "item");
      if (paramg != null)
      {
        MusicMvMakerUI.a(this.Mad).setVisibility(0);
        MusicMvMakerUI.b(this.Mad).setRadius(com.tencent.mm.cd.a.fromDPToPix((Context)this.Mad.getContext(), 12));
        paramg = g.a(paramg, (View)MusicMvMakerUI.c(this.Mad), (ImageView)MusicMvMakerUI.b(this.Mad));
        paramg.addListener((Animator.AnimatorListener)new MusicMvMakerUI.o.a(this.Mad));
        paramg.setDuration(250L);
        paramg.start();
        paramg = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).setShow(true);
        paramg = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).d(parame);
        f1 = MusicMvMakerUI.f(this.Mad).getY();
        f2 = MusicMvMakerUI.g(this.Mad).getY();
        MusicMvMakerUI.d(this.Mad).animate().translationY(f1 - f2).start();
        parame = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class)).Mfp = paramBoolean;
        MusicMvMakerUI.d(this.Mad).cOJ();
        AppMethodBeat.o(286524);
        return;
      }
      paramg = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).setShow(true);
      paramg = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).d(parame);
      float f1 = MusicMvMakerUI.f(this.Mad).getY();
      float f2 = MusicMvMakerUI.g(this.Mad).getY();
      MusicMvMakerUI.d(this.Mad).animate().translationY(f1 - f2).start();
      parame = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class)).Mfp = paramBoolean;
      MusicMvMakerUI.d(this.Mad).cOJ();
      AppMethodBeat.o(286524);
    }
    
    public final void b(com.tencent.mm.plugin.mv.model.e parame)
    {
      AppMethodBeat.i(286508);
      s.u(parame, "item");
      MusicMVCardChooseView localMusicMVCardChooseView = MusicMvMakerUI.d(this.Mad);
      if (localMusicMVCardChooseView != null) {
        localMusicMVCardChooseView.ae(false, parame.getDurationMs());
      }
      AppMethodBeat.o(286508);
    }
    
    public final void c(com.tencent.mm.plugin.mv.model.e parame)
    {
      AppMethodBeat.i(286528);
      s.u(parame, "item");
      if (!paramj.gqh()) {
        MusicMvMakerUI.e(this.Mad);
      }
      AppMethodBeat.o(286528);
    }
    
    public final void gpY()
    {
      AppMethodBeat.i(286514);
      MusicMVCardChooseView localMusicMVCardChooseView = MusicMvMakerUI.d(this.Mad);
      if (localMusicMVCardChooseView != null) {
        localMusicMVCardChooseView.grq();
      }
      AppMethodBeat.o(286514);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements m.b
  {
    p(MusicMvMakerUI paramMusicMvMakerUI, com.tencent.mm.plugin.mv.ui.uic.j paramj) {}
    
    public final void zU(boolean paramBoolean)
    {
      AppMethodBeat.i(286430);
      MusicMvMakerUI.a(this.Mad).setVisibility(0);
      MusicMvMakerUI.b(this.Mad).setRadius(com.tencent.mm.cd.a.fromDPToPix((Context)this.Mad.getContext(), 12));
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
      s.s(localObject1, "UICProvider.of(this@Musi…erFixEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.k)localObject1;
      if (paramBoolean) {
        ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Ake = true;
      }
      Object localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).gqU();
      ImageView localImageView = MusicMvMakerUI.c(this.Mad);
      s.checkNotNull(localObject2);
      localObject2 = com.tencent.mm.plugin.mv.model.h.a(localImageView, (View)localObject2, (ImageView)MusicMvMakerUI.b(this.Mad), false);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new MusicMvMakerUI.p.c(this.Mad));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      MusicMvMakerUI.d(this.Mad).animate().translationY(0.0F).setListener((Animator.AnimatorListener)new d(this.Mad)).start();
      ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).q((kotlin.g.a.m)new e(paramBoolean));
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "disableCurrentSyncMusic");
      if (((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).MeK.mma + 1 < ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).getAdapter().getItemCount())
      {
        localObject1 = (com.tencent.mm.plugin.mv.model.e)p.ae((List)((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).pUj, ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).MeK.mma);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mv.model.e)localObject1).LWW = false;
        }
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).setShow(false);
      MusicMvMakerUI.d(this.Mad).grv();
      if (!localj.gqh()) {
        MusicMvMakerUI.e(this.Mad);
      }
      AppMethodBeat.o(286430);
    }
    
    public final void zV(boolean paramBoolean)
    {
      AppMethodBeat.i(286441);
      MusicMvMakerUI.a(this.Mad).setVisibility(0);
      MusicMvMakerUI.b(this.Mad).setRadius(com.tencent.mm.cd.a.fromDPToPix((Context)this.Mad.getContext(), 12));
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
      s.s(localObject1, "UICProvider.of(this@Musi…erFixEditUIC::class.java)");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.k)localObject1;
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class)).gqU();
      Object localObject3 = MusicMvMakerUI.c(this.Mad);
      s.checkNotNull(localObject2);
      localObject2 = com.tencent.mm.plugin.mv.model.h.a((ImageView)localObject3, (View)localObject2, (ImageView)MusicMvMakerUI.b(this.Mad), ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Mfp);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new MusicMvMakerUI.p.a(this.Mad));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).q((kotlin.g.a.m)new b(paramBoolean));
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.m)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.m.class)).setShow(false);
      if ((((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Mfp) && (((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Ahg >= 0) && (((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Ahg < ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).pUj.size()))
      {
        localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).pUj.get(((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Ahg);
        s.s(localObject2, "dataList[lastPos]");
        localObject2 = (com.tencent.mm.plugin.mv.model.e)localObject2;
        int i = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).Ahg;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)localObject2).LWZ;
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.mv.model.e)localObject3).Bvd = ((com.tencent.mm.plugin.mv.model.e)localObject2).Bvd;
          ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).pUj.set(i, localObject3);
          ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).getAdapter().fV(i);
          ((com.tencent.mm.plugin.mv.ui.uic.k)localObject1).aei(i);
        }
      }
      MusicMvMakerUI.d(this.Mad).animate().translationY(0.0F).start();
      MusicMvMakerUI.d(this.Mad).grv();
      if (!localj.gqh()) {
        MusicMvMakerUI.e(this.Mad);
      }
      AppMethodBeat.o(286441);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.model.e, ah>
    {
      b(boolean paramBoolean)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onConfirm$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      extends AnimatorListenerAdapter
    {
      d(MusicMvMakerUI paramMusicMvMakerUI) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(286499);
        MusicMvMakerUI.d(this.Mad).animate().setListener(null);
        paramAnimator = com.tencent.mm.ui.component.k.aeZF;
        Object localObject = (com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.Mad).q(com.tencent.mm.plugin.mv.ui.uic.k.class);
        Log.d("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("moveToNextItem, lastPos:", Integer.valueOf(((com.tencent.mm.plugin.mv.ui.uic.k)localObject).Ahg)));
        if (((com.tencent.mm.plugin.mv.ui.uic.k)localObject).Ahg + 1 < ((com.tencent.mm.plugin.mv.ui.uic.k)localObject).getAdapter().getItemCount())
        {
          paramAnimator = ((com.tencent.mm.plugin.mv.ui.uic.k)localObject).gqQ();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(((com.tencent.mm.plugin.mv.ui.uic.k)localObject).Ahg + 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          paramAnimator.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnimator, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(286499);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.model.e, ah>
    {
      e(boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onDelListener$1", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements b.a
  {
    q(MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.flex.a parama)
    {
      AppMethodBeat.i(286435);
      s.u(parama, "item");
      Log.i("MicroMsg.Mv.MusicMvMakerUI", "OnDelBtnClicked, pos:" + paramInt + ", type:" + parama.type);
      Object localObject1;
      if ((parama.type == 1) || (parama.type == 3))
      {
        localObject1 = parama.LYr;
        if (localObject1 == null) {
          localObject1 = null;
        }
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.mv.model.m.LYc;
        localObject2 = com.tencent.mm.plugin.mv.model.m.gpJ();
        ((kp)localObject2).ioV = 13L;
        ((kp)localObject2).iPH = 1;
        ((kp)localObject2).iXq = com.tencent.mm.plugin.mv.model.m.LYe;
        if ((com.tencent.mm.plugin.mv.model.m.LYe != 1) && (com.tencent.mm.plugin.mv.model.m.LYe != 2)) {
          ((kp)localObject2).iMe = paramInt;
        }
        ((kp)localObject2).bMH();
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
        localObject2 = MusicMvMakerUI.d(this.Mad);
        if (localObject2 == null) {
          break label310;
        }
        paramInt = parama.type;
        if (localObject1 != null) {
          break;
        }
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "invalid parameters, type:" + paramInt + ", uniqueId:" + localObject1);
        AppMethodBeat.o(286435);
        return;
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.mv.model.flex.a.a)localObject1).HHJ);
        continue;
        localObject1 = parama.LYs;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((a.c)localObject1).EDa;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = Long.valueOf(((FinderObject)localObject1).id);
          }
        }
      }
      switch (paramInt)
      {
      default: 
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "error logic.type:" + paramInt + ", uniqueId:" + localObject1);
      }
      label310:
      do
      {
        do
        {
          AppMethodBeat.o(286435);
          return;
          parama = ((MusicMVCardChooseView)localObject2).Mhr;
        } while (parama == null);
        parama.sI(((Long)localObject1).longValue());
        AppMethodBeat.o(286435);
        return;
        parama = ((MusicMVCardChooseView)localObject2).MhD;
        if (parama != null) {
          parama.sI(((Long)localObject1).longValue());
        }
        parama = ((MusicMVCardChooseView)localObject2).MhE;
        if (parama != null) {
          parama.sI(((Long)localObject1).longValue());
        }
        parama = ((MusicMVCardChooseView)localObject2).MhF;
        if (parama != null) {
          parama.sI(((Long)localObject1).longValue());
        }
        parama = ((MusicMVCardChooseView)localObject2).MhG;
      } while (parama == null);
      parama.sI(((Long)localObject1).longValue());
      AppMethodBeat.o(286435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI
 * JD-Core Version:    0.7.0.1
 */