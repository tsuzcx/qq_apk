package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.l;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.ui.c.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.transition.GravityArcMotion;
import com.tencent.mm.plugin.mv.a.d.b;
import com.tencent.mm.plugin.mv.ui.adapter.b.c.a;
import com.tencent.mm.plugin.mv.ui.adapter.b.c.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.e;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.f;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.i;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.j;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.k;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.v;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSaveDraftUIC;
import com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView;
import com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView.b;
import com.tencent.mm.plugin.mv.ui.view.FirstRowLayoutManager;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.c;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.g;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.h;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.i;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.j;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.k;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.l;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.m;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.v;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.c;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.f;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.a.m;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "()V", "albumAnimationContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAlbumAnimationContainer", "()Landroid/view/View;", "albumAnimationContainer$delegate", "Lkotlin/Lazy;", "albumFakeThumb", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAlbumFakeThumb", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "albumFakeThumb$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "mvCardRV", "Landroid/support/v7/widget/RecyclerView;", "getMvCardRV", "()Landroid/support/v7/widget/RecyclerView;", "mvCardRV$delegate", "mvChooseView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "getMvChooseView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "mvChooseView$delegate", "mvItemEditBottomLine", "getMvItemEditBottomLine", "mvItemEditBottomLine$delegate", "mvItemEditThumb", "Landroid/widget/ImageView;", "getMvItemEditThumb", "()Landroid/widget/ImageView;", "mvItemEditThumb$delegate", "mvListEditBottomLine", "getMvListEditBottomLine", "mvListEditBottomLine$delegate", "nextBtn", "getNextBtn", "nextBtn$delegate", "finish", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "makeMediaThumbTransition", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onAnimationEnd", "Lkotlin/Function0;", "onAlbumItemClicked", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFeederItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onHeaderCameraClicked", "minDuration", "onPause", "onResume", "onSearchBarClicked", "Companion", "plugin-mv_release"})
public final class MusicMvMakerUI
  extends BaseMusicMvUI
  implements MusicMVCardChooseView.b
{
  public static final a Arf;
  private static int mEX;
  private static int mEY;
  private final kotlin.f Ard;
  private final kotlin.f Are;
  private final kotlin.f Auz;
  private final kotlin.f UqM;
  private final kotlin.f UqN;
  private final kotlin.f UqO;
  private final kotlin.f UqP;
  private final kotlin.f UqQ;
  private HashMap _$_findViewCache;
  private final kotlin.f vJB;
  
  static
  {
    AppMethodBeat.i(256907);
    Arf = new a((byte)0);
    AppMethodBeat.o(256907);
  }
  
  public MusicMvMakerUI()
  {
    AppMethodBeat.i(256906);
    this.Ard = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.Are = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vJB = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.m(this));
    this.UqM = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.q(this));
    this.UqN = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.o(this));
    this.UqO = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.k(this));
    this.UqP = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.l(this));
    this.UqQ = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.p(this));
    this.Auz = kotlin.g.ah((kotlin.g.a.a)new MusicMvMakerUI.n(this));
    AppMethodBeat.o(256906);
  }
  
  private final void a(com.tencent.mm.plugin.mv.a.f paramf, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(256902);
    if (paramf == null)
    {
      parama.invoke();
      AppMethodBeat.o(256902);
      return;
    }
    Object localObject = gFi();
    kotlin.g.b.p.g(localObject, "albumAnimationContainer");
    ((View)localObject).setVisibility(0);
    localObject = gFj();
    kotlin.g.b.p.g(localObject, "albumFakeThumb");
    paramf.i((ImageView)localObject);
    gFj().setRadius(0);
    localObject = new int[2];
    gFk().getLocationInWindow((int[])localObject);
    int i = localObject[0];
    RecyclerView localRecyclerView = gFk();
    kotlin.g.b.p.g(localRecyclerView, "mvCardRV");
    localObject[0] = (i + (localRecyclerView.getWidth() - paramf.ApT.getWidth()) / 2);
    i = localObject[1];
    localRecyclerView = gFk();
    kotlin.g.b.p.g(localRecyclerView, "mvCardRV");
    localObject[1] = (i + (localRecyclerView.getHeight() - paramf.ApT.getHeight()) / 2);
    paramf = new GravityArcMotion().getPath(paramf.ApS.x, paramf.ApS.y, localObject[0], localObject[1]);
    paramf = ObjectAnimator.ofFloat(gFj(), "x", "y", paramf);
    kotlin.g.b.p.g(paramf, "pathAnimator");
    paramf.setInterpolator((TimeInterpolator)new android.support.v4.view.b.b());
    paramf.setDuration(400L);
    paramf.addListener((Animator.AnimatorListener)new b(this, parama));
    paramf.start();
    AppMethodBeat.o(256902);
  }
  
  private final View gFg()
  {
    AppMethodBeat.i(258878);
    View localView = (View)this.UqM.getValue();
    AppMethodBeat.o(258878);
    return localView;
  }
  
  private final MusicMVCardChooseView gFh()
  {
    AppMethodBeat.i(258879);
    MusicMVCardChooseView localMusicMVCardChooseView = (MusicMVCardChooseView)this.UqN.getValue();
    AppMethodBeat.o(258879);
    return localMusicMVCardChooseView;
  }
  
  private final View gFi()
  {
    AppMethodBeat.i(258880);
    View localView = (View)this.UqO.getValue();
    AppMethodBeat.o(258880);
    return localView;
  }
  
  private final MMRoundCornerImageView gFj()
  {
    AppMethodBeat.i(258881);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.UqP.getValue();
    AppMethodBeat.o(258881);
    return localMMRoundCornerImageView;
  }
  
  private final RecyclerView gFk()
  {
    AppMethodBeat.i(258882);
    RecyclerView localRecyclerView = (RecyclerView)this.Auz.getValue();
    AppMethodBeat.o(258882);
    return localRecyclerView;
  }
  
  public final void Tk(int paramInt)
  {
    AppMethodBeat.i(256905);
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = (MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvMakerEditUIC.class);
    Object localObject2 = k.euj();
    kotlin.g.b.p.g(localObject2, "MusicPlayerManager.Instance()");
    ((k)localObject2).etW().pause();
    Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "takePhoto, minDuration:".concat(String.valueOf(paramInt)));
    localObject2 = new Intent((Context)((MusicMvMakerEditUIC)localObject1).getActivity(), MusicMvRouterUI.class);
    ((Intent)localObject2).putExtra("KEY_MUSIC_ROUTER", 1);
    ((Intent)localObject2).putExtra("KEY_REQUIRE_VIDEO_DURATION", paramInt);
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.sm(true);
    ((MusicMvMakerEditUIC)localObject1).getActivity().startActivityForResult((Intent)localObject2, 1024);
    AppMethodBeat.o(256905);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256911);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256911);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256910);
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
    AppMethodBeat.o(256910);
    return localView1;
  }
  
  public final void a(final GalleryItem.VideoMediaItem paramVideoMediaItem, com.tencent.mm.plugin.mv.a.f paramf)
  {
    AppMethodBeat.i(256903);
    kotlin.g.b.p.h(paramVideoMediaItem, "data");
    a(paramf, (kotlin.g.a.a)new e(this, paramVideoMediaItem));
    AppMethodBeat.o(256903);
  }
  
  public final void a(final MusicMvTabFragment.f paramf, com.tencent.mm.plugin.mv.a.f paramf1)
  {
    AppMethodBeat.i(256904);
    kotlin.g.b.p.h(paramf, "data");
    a(paramf1, (kotlin.g.a.a)new j(this, paramf));
    AppMethodBeat.o(256904);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256901);
    super.finish();
    AppMethodBeat.o(256901);
  }
  
  public final int getLayoutId()
  {
    return 2131495794;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(256896);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { MusicMvMakerEditUIC.class, MusicMvMakerItemEditUIC.class, MusicMvMakerDataUIC.class, MusicMvSaveDraftUIC.class }));
      AppMethodBeat.o(256896);
      return localSet;
    }
    AppMethodBeat.o(256896);
    return null;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(256897);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = getContext();
    kotlin.g.b.p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131101287));
    hideActionbarLine();
    paramBundle = (View)this.vJB.getValue();
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    }
    paramBundle = gFg();
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvMakerDataUIC.class);
    kotlin.g.b.p.g(paramBundle, "UICProvider.of(this).get…MakerDataUIC::class.java)");
    paramBundle = (MusicMvMakerDataUIC)paramBundle;
    paramBundle.Auy = ((com.tencent.mm.plugin.mv.ui.uic.a.b)new h(this, paramBundle));
    Object localObject = i.vfo;
    localObject = paramBundle.AqY;
    long l;
    if (localObject != null)
    {
      l = ((csp)localObject).localId;
      if (l == 0L) {
        break label284;
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      i.as(10, bool);
      localObject = i.vfo;
      i.Kp(5);
      localObject = i.vfo;
      paramBundle = paramBundle.AkC;
      if (paramBundle != null)
      {
        localObject = paramBundle.field_musicId;
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      i.auE(paramBundle);
      paramBundle = i.vfo;
      i.Kq(2);
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvMakerItemEditUIC.class)).Avl = ((MusicMvMakerItemEditUIC.b)new i(this));
      AppMethodBeat.o(256897);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(256900);
    super.onDestroy();
    Object localObject1 = gFh();
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.gallery.model.e.dQK().b((i.c)localObject1);
      Object localObject2 = ((MusicMVCardChooseView)localObject1).AwB;
      if (localObject2 != null) {
        ((TabLayout)localObject2).b((TabLayout.b)((MusicMVCardChooseView)localObject1).AwX);
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).AwJ;
      if (localObject2 != null) {
        ((MusicMvTabSearchFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).AwR;
      if (localObject2 != null) {
        ((MusicMvTabMyFavFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).AwP;
      if (localObject2 != null) {
        ((MusicMvTabMachineFragment)localObject2).onDestroy();
      }
      localObject2 = ((MusicMVCardChooseView)localObject1).AwQ;
      if (localObject2 != null) {
        ((MusicMvTabMyPostFragment)localObject2).onDestroy();
      }
      localObject1 = ((MusicMVCardChooseView)localObject1).AwS;
      if (localObject1 != null)
      {
        ((MusicMvTabMyLikeFragment)localObject1).onDestroy();
        AppMethodBeat.o(256900);
        return;
      }
      AppMethodBeat.o(256900);
      return;
    }
    AppMethodBeat.o(256900);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256899);
    super.onPause();
    Object localObject = gFh();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).xoh = true;
    }
    localObject = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.gFa();
    AppMethodBeat.o(256899);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256898);
    super.onResume();
    Object localObject = gFh();
    if (localObject != null) {
      ((MusicMVCardChooseView)localObject).xoh = false;
    }
    localObject = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.onResume();
    localObject = com.tencent.mm.plugin.music.model.l.AkI;
    com.tencent.mm.plugin.music.model.l.aq((Activity)this);
    AppMethodBeat.o(256898);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI$Companion;", "", "()V", "TAG", "", "screenHeight", "", "screenWidth", "plugin-mv_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$makeMediaThumbTransition$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(kotlin.g.a.a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(256878);
      MusicMvMakerUI.c(this.Arg).animate().alpha(0.0F).setDuration(200L).withEndAction((Runnable)new a(this)).start();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(256878);
        return;
      }
      AppMethodBeat.o(256878);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MusicMvMakerUI.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(256877);
        View localView = MusicMvMakerUI.b(this.Ari.Arg);
        kotlin.g.b.p.g(localView, "albumAnimationContainer");
        localView.setVisibility(8);
        AppMethodBeat.o(256877);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    c(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    d(MusicMvMakerUI paramMusicMvMakerUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(MusicMvMakerUI paramMusicMvMakerUI, GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256882);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class)).onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256882);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256883);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class);
      paramView = new Intent((Context)((MusicMvMakerEditUIC)localObject1).getActivity(), MusicMvMakerPreviewUI.class);
      Object localObject2 = ((MusicMvMakerEditUIC)localObject1).d(((MusicMvMakerEditUIC)localObject1).AqY);
      if (localObject2 != null) {
        paramView.putExtra("key_track_data", ((csp)localObject2).toByteArray());
      }
      paramView.putExtra("key_seek_to_start", true);
      localObject2 = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.sm(true);
      localObject1 = ((MusicMvMakerEditUIC)localObject1).getActivity();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramView.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((AppCompatActivity)localObject1).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.plugin.mv.a.l.Uqz;
      paramView = com.tencent.mm.plugin.mv.a.l.gFd();
      paramView.PF(6L);
      paramView.bfK();
      localObject1 = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256883);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "onInitDataReady", "", "plugin-mv_release"})
  public static final class h
    implements com.tencent.mm.plugin.mv.ui.uic.a.b
  {
    h(MusicMvMakerDataUIC paramMusicMvMakerDataUIC) {}
    
    public final void evE()
    {
      AppMethodBeat.i(256889);
      MusicMvMakerUI localMusicMvMakerUI = this.Arg;
      Object localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = com.tencent.mm.ui.component.a.b((AppCompatActivity)localMusicMvMakerUI).get(MusicMvMakerEditUIC.class);
      kotlin.g.b.p.g(localObject1, "UICProvider.of(activity)…MakerEditUIC::class.java)");
      Object localObject2 = (MusicMvMakerEditUIC)localObject1;
      ((MusicMvMakerEditUIC)localObject2).AqY = paramBundle.AqY;
      ((MusicMvMakerEditUIC)localObject2).AkC = paramBundle.AkC;
      localObject1 = ((MusicMvMakerEditUIC)localObject2).evW();
      kotlin.g.b.p.g(localObject1, "mvCardRV");
      ((WxRecyclerView)localObject1).setItemAnimator(null);
      localObject1 = ((MusicMvMakerEditUIC)localObject2).evW();
      kotlin.g.b.p.g(localObject1, "mvCardRV");
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)((MusicMvMakerEditUIC)localObject2).getLayoutManager());
      localObject1 = ((MusicMvMakerEditUIC)localObject2).evW();
      kotlin.g.b.p.g(localObject1, "mvCardRV");
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)((MusicMvMakerEditUIC)localObject2).getAdapter());
      ((MusicMvMakerEditUIC)localObject2).evW().setPadding(MusicMvMakerEditUIC.f.getPadding(), 0, MusicMvMakerEditUIC.f.getPadding(), 0);
      ((MusicMvMakerEditUIC)localObject2).AuC.gRD = com.tencent.mm.cb.a.jn((Context)((MusicMvMakerEditUIC)localObject2).getContext());
      ((MusicMvMakerEditUIC)localObject2).evW().addOnLayoutChangeListener((View.OnLayoutChangeListener)new MusicMvMakerEditUIC.i((MusicMvMakerEditUIC)localObject2));
      ((MusicMvMakerEditUIC)localObject2).evW().b((RecyclerView.h)((MusicMvMakerEditUIC)localObject2).evX());
      ((MusicMvMakerEditUIC)localObject2).AtW.hbS = ((a.c)new MusicMvMakerEditUIC.j((MusicMvMakerEditUIC)localObject2));
      ((MusicMvMakerEditUIC)localObject2).getAdapter().a((RecyclerView.c)new MusicMvMakerEditUIC.k((MusicMvMakerEditUIC)localObject2));
      Object localObject3 = ((MusicMvMakerEditUIC)localObject2).AqY;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.mv.a.d.Aps;
        localObject1 = ((MusicMvMakerEditUIC)localObject2).AkC;
        kotlin.g.b.p.h(localObject3, "trackData");
        localObject4 = new LinkedList();
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.music.model.o.euD().a((com.tencent.mm.plugin.music.model.e.a)localObject1, false);
          if (localObject1 != null) {
            break label3215;
          }
        }
        localObject1 = null;
      }
      label1546:
      label3215:
      for (;;)
      {
        Object localObject5 = ((csp)localObject3).MxE;
        int i;
        if (localObject5 != null)
        {
          localObject5 = ((FinderObject)localObject5).objectDesc;
          if (localObject5 != null)
          {
            localObject5 = ((FinderObjectDesc)localObject5).mvInfo;
            if (localObject5 != null)
            {
              localObject5 = ((axw)localObject5).LId;
              if (localObject5 != null)
              {
                localObject5 = ((Iterable)localObject5).iterator();
                i = 0;
                if (((Iterator)localObject5).hasNext())
                {
                  Object localObject6 = ((Iterator)localObject5).next();
                  if (i < 0) {
                    kotlin.a.j.hxH();
                  }
                  Object localObject7 = (axz)localObject6;
                  localObject6 = com.tencent.mm.plugin.mv.a.d.Aps;
                  kotlin.g.b.p.g(localObject7, "mvTrack");
                  localObject6 = ((csp)localObject3).LDi;
                  kotlin.g.b.p.g(localObject6, "trackData.refObjectList");
                  localObject6 = d.b.a((axz)localObject7, (com.tencent.mm.plugin.music.model.e)localObject1, (List)localObject6);
                  Object localObject8 = ((csp)localObject3).MxG;
                  if (localObject8 != null)
                  {
                    localObject8 = ((axw)localObject8).LId;
                    if (localObject8 != null)
                    {
                      localObject8 = (axz)kotlin.a.j.L((List)localObject8, i);
                      if (localObject8 != null)
                      {
                        if (!(kotlin.g.b.p.j(((axz)localObject7).LIm, ((axz)localObject8).LIm) ^ true)) {
                          break label578;
                        }
                        localObject7 = com.tencent.mm.plugin.mv.a.d.Aps;
                        localObject7 = ((csp)localObject3).LDi;
                        kotlin.g.b.p.g(localObject7, "trackData.refObjectList");
                        localObject7 = d.b.a((axz)localObject8, (com.tencent.mm.plugin.music.model.e)localObject1, (List)localObject7);
                        ((com.tencent.mm.plugin.mv.a.d)localObject7).type = 0;
                        ((com.tencent.mm.plugin.mv.a.d)localObject6).Apq = ((com.tencent.mm.plugin.mv.a.d)localObject7);
                      }
                    }
                  }
                  for (;;)
                  {
                    ((LinkedList)localObject4).add(localObject6);
                    i += 1;
                    break;
                    label578:
                    ((com.tencent.mm.plugin.mv.a.d)localObject6).type = 0;
                  }
                }
              }
            }
          }
        }
        localObject1 = (List)localObject4;
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "updateMusicItemList size:" + ((List)localObject1).size());
        ((MusicMvMakerEditUIC)localObject2).kgc.clear();
        ((MusicMvMakerEditUIC)localObject2).kgc.addAll((Collection)localObject1);
        ((MusicMvMakerEditUIC)localObject2).AuA.clear();
        ((MusicMvMakerEditUIC)localObject2).AuA.addAll((Collection)localObject1);
        ((MusicMvMakerEditUIC)localObject2).getAdapter().notifyDataSetChanged();
        ((MusicMvMakerEditUIC)localObject2).evW().post((Runnable)new MusicMvMakerEditUIC.v((MusicMvMakerEditUIC)localObject2));
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Long.valueOf(0L));
        localObject3 = ((csp)localObject3).MxE;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObject)localObject3).objectDesc;
          if (localObject3 != null)
          {
            localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
            if (localObject3 != null)
            {
              localObject3 = ((axw)localObject3).LId;
              if (localObject3 != null)
              {
                localObject4 = (Iterable)localObject3;
                localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
                localObject4 = ((Iterable)localObject4).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (axz)((Iterator)localObject4).next();
                  ((Collection)localObject3).add(Long.valueOf(((axz)localObject5).Ghu + ((axz)localObject5).LIl));
                }
                ((ArrayList)localObject1).addAll((Collection)localObject3);
              }
            }
          }
        }
        ((MusicMvMakerEditUIC)localObject2).evX().fD((List)localObject1);
        ((MusicMvMakerEditUIC)localObject2).AuG = new MMTPRecyclerVideoLayout((Context)((MusicMvMakerEditUIC)localObject2).getActivity());
        localObject1 = ((MusicMvMakerEditUIC)localObject2).AuG;
        if (localObject1 != null) {
          ((MMTPRecyclerVideoLayout)localObject1).fxf();
        }
        localObject1 = ((MusicMvMakerEditUIC)localObject2).AuG;
        if (localObject1 != null) {
          ((MMTPRecyclerVideoLayout)localObject1).setId(2131305117);
        }
        ((MusicMvMakerEditUIC)localObject2).AuE = ((MusicMvMakerEditUIC.e)new a(this));
        MusicMvMakerUI.RX(com.tencent.mm.cb.a.jn((Context)localMusicMvMakerUI));
        MusicMvMakerUI.RY(au.az((Context)localMusicMvMakerUI).y);
        localObject1 = paramBundle.AkC;
        if (localObject1 != null)
        {
          i = (int)(MusicMvMakerUI.esa() * 0.45F);
          int j = MusicMvMakerUI.esa();
          int k = com.tencent.mm.cb.a.fromDPToPix((Context)localMusicMvMakerUI, 64);
          localObject3 = MusicMvMakerUI.a(this.Arg);
          if (localObject3 != null)
          {
            localObject2 = (MMActivity)localMusicMvMakerUI;
            kotlin.g.b.p.h(localObject2, "activity");
            kotlin.g.b.p.h(localObject1, "music");
            ((MusicMVCardChooseView)localObject3).activity = ((MMActivity)localObject2);
            ((MusicMVCardChooseView)localObject3).AkC = ((com.tencent.mm.plugin.music.model.e.a)localObject1);
            ((MusicMVCardChooseView)localObject3).minHeight = i;
            ((MusicMVCardChooseView)localObject3).maxHeight = (j - k);
            ((MusicMVCardChooseView)localObject3).mEX = com.tencent.mm.cb.a.jn(((MusicMVCardChooseView)localObject3).getContext());
            View.inflate(((MusicMVCardChooseView)localObject3).getContext(), 2131495780, (ViewGroup)localObject3);
            MusicMVCardChooseView.a((MusicMVCardChooseView)localObject3, ((MusicMVCardChooseView)localObject3).minHeight);
            localObject1 = (RelativeLayout)((MusicMVCardChooseView)localObject3)._$_findCachedViewById(2131302303);
            if (localObject1 != null) {
              ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.h((MusicMVCardChooseView)localObject3));
            }
            ((MusicMVCardChooseView)localObject3).ewl();
            ((MusicMVCardChooseView)localObject3).qUd = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true);
            ((MusicMVCardChooseView)localObject3).AwC = ((RecyclerView)((MusicMVCardChooseView)localObject3).findViewById(2131296619));
            localObject1 = ((MusicMVCardChooseView)localObject3).getContext();
            kotlin.g.b.p.g(localObject1, "context");
            ((MusicMVCardChooseView)localObject3).AwD = new com.tencent.mm.plugin.mv.ui.adapter.b((Context)localObject1);
            localObject2 = new b.c.a();
            localObject1 = ((MusicMVCardChooseView)localObject3).AwD;
            if (localObject1 == null) {
              kotlin.g.b.p.hyc();
            }
            localObject2 = (b.c.b)localObject2;
            ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).xns.remove(localObject2);
            ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).xns.add(localObject2);
            localObject1 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject1 != null) {
              ((RecyclerView)localObject1).setAdapter((RecyclerView.a)((MusicMVCardChooseView)localObject3).AwD);
            }
            localObject1 = ((MusicMVCardChooseView)localObject3).activity;
            if (localObject1 == null) {
              break label3191;
            }
            localObject1 = ((MMActivity)localObject1).getContext();
            localObject1 = new FirstRowLayoutManager((Context)localObject1, 4);
            localObject2 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject2 != null) {
              ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
            }
            localObject2 = new c.a(((MusicMVCardChooseView)localObject3).getContext()).NP(2131166771).NO(2131166771).dSd().dSe().dSf();
            localObject4 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject4 != null) {
              ((RecyclerView)localObject4).b((RecyclerView.h)localObject2);
            }
            localObject2 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject2 != null) {
              ((RecyclerView)localObject2).a((RecyclerView.l)new MusicMVCardChooseView.g((MusicMVCardChooseView)localObject3, (FirstRowLayoutManager)localObject1));
            }
            localObject1 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject1 != null) {
              ((RecyclerView)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
            }
            localObject1 = ((MusicMVCardChooseView)localObject3).AwD;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).ArL = ((MusicMVCardChooseView)localObject3).ArL;
            }
            localObject4 = (Activity)((MusicMVCardChooseView)localObject3).activity;
            localObject1 = ((MusicMVCardChooseView)localObject3).activity;
            if (localObject1 == null) {
              break label3197;
            }
            localObject1 = ((MMActivity)localObject1).getString(2131763890);
            label1524:
            localObject2 = ((MusicMVCardChooseView)localObject3).activity;
            if (localObject2 == null) {
              break label3203;
            }
            localObject2 = ((MMActivity)localObject2).getString(2131761100);
            ((MusicMVCardChooseView)localObject3).xot = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject4, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, (String)localObject1, (String)localObject2);
            Log.i("MicroMsg.Mv.MusicMVCardChooseView", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(((MusicMVCardChooseView)localObject3).xot) });
            ((MusicMVCardChooseView)localObject3).Axa = MusicMVCardChooseView.c.Axe;
            localObject2 = (Context)((MusicMVCardChooseView)localObject3).activity;
            localObject1 = ((MusicMVCardChooseView)localObject3).activity;
            if (localObject1 == null) {
              break label3209;
            }
          }
        }
        for (localObject1 = ((MMActivity)localObject1).getString(2131756029);; localObject1 = null)
        {
          ((MusicMVCardChooseView)localObject3).gtM = ((ProgressDialog)com.tencent.mm.ui.base.q.a((Context)localObject2, (CharSequence)localObject1, false));
          localObject1 = com.tencent.mm.plugin.gallery.model.e.dQK();
          kotlin.g.b.p.g(localObject1, "GalleryCore.getMediaQueryService()");
          ((com.tencent.mm.plugin.gallery.model.o)localObject1).NG(((MusicMVCardChooseView)localObject3).het);
          localObject1 = com.tencent.mm.plugin.gallery.model.e.dQK();
          kotlin.g.b.p.g(localObject1, "GalleryCore.getMediaQueryService()");
          ((com.tencent.mm.plugin.gallery.model.o)localObject1).setQueryType(((MusicMVCardChooseView)localObject3).xos);
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "query source: " + ((MusicMVCardChooseView)localObject3).het + ", queryType: " + ((MusicMVCardChooseView)localObject3).xos);
          ((MusicMVCardChooseView)localObject3).initView();
          if (((MusicMVCardChooseView)localObject3).xot)
          {
            com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
            com.tencent.mm.plugin.gallery.a.dQq().setScene(((MusicMVCardChooseView)localObject3).het);
            Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", new Object[] { localObject3 });
            com.tencent.mm.plugin.gallery.model.e.dQK().a((i.c)localObject3);
            ((MusicMVCardChooseView)localObject3).xov = MusicMVCardChooseView.ewo();
            com.tencent.mm.plugin.gallery.model.e.dQK().ax("", ((MusicMVCardChooseView)localObject3).xov);
            localObject1 = ((MusicMVCardChooseView)localObject3).AwC;
            if (localObject1 != null) {
              ((RecyclerView)localObject1).postDelayed((Runnable)new MusicMVCardChooseView.v((MusicMVCardChooseView)localObject3), 300L);
            }
            localObject1 = com.tencent.mm.plugin.gallery.model.p.xjw;
            com.tencent.mm.plugin.gallery.model.p.dRt().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.l());
            localObject1 = com.tencent.mm.plugin.gallery.model.p.xjw;
            com.tencent.mm.plugin.gallery.model.p.dRt().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.q());
          }
          com.tencent.mm.plugin.gallery.model.e.dQS();
          ((MusicMVCardChooseView)localObject3).AwE = ((RelativeLayout)((MusicMVCardChooseView)localObject3).findViewById(2131300788));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwE;
          if (localObject1 != null) {
            ((RelativeLayout)localObject1).setVisibility(4);
          }
          ((MusicMVCardChooseView)localObject3).AwF = ((RelativeLayout)((MusicMVCardChooseView)localObject3).findViewById(2131301354));
          ((MusicMVCardChooseView)localObject3).AwG = ((WeImageView)((MusicMVCardChooseView)localObject3).findViewById(2131307356));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwG;
          if (localObject1 != null) {
            ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.i((MusicMVCardChooseView)localObject3));
          }
          ((MusicMVCardChooseView)localObject3).AwI = ((FTSSearchNoActionBarView)((MusicMVCardChooseView)localObject3).findViewById(2131307428));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null) {
            ((FTSSearchNoActionBarView)localObject1).setSearchViewListener((FTSSearchNoActionBarView.b)localObject3);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).setHint(((MusicMVCardChooseView)localObject3).getContext().getString(2131755972));
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null)
            {
              localObject2 = ((MusicMVCardChooseView)localObject3).getContext();
              kotlin.g.b.p.g(localObject2, "context");
              ((FTSEditTextView)localObject1).setHintColor(((Context)localObject2).getResources().getColor(2131099677));
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null)
            {
              localObject2 = ((MusicMVCardChooseView)localObject3).getContext();
              kotlin.g.b.p.g(localObject2, "context");
              ((FTSEditTextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099679));
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).setFtsEditTextListener((FTSEditTextView.a)localObject3);
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).setCanDeleteTag(false);
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).gUA();
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).hideVKB();
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null) {
              ((FTSEditTextView)localObject1).gWY();
            }
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwI;
          if (localObject1 != null)
          {
            localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
            if (localObject1 != null)
            {
              localObject1 = ((FTSEditTextView)localObject1).getClearBtn();
              if (localObject1 != null) {
                ((ImageButton)localObject1).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
              }
            }
          }
          ((MusicMVCardChooseView)localObject3).AwH = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131307412));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwH;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(8);
          }
          ((MusicMVCardChooseView)localObject3).AwJ = ((MusicMvTabSearchFragment)((MusicMVCardChooseView)localObject3).findViewById(2131305777));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwJ;
          if (localObject1 != null) {
            ((MusicMvTabSearchFragment)localObject1).a((MusicMvTabFragment.b)((MusicMVCardChooseView)localObject3).AwY);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwJ;
          if (localObject1 != null)
          {
            localObject2 = (MusicMvTabFragment.c)((MusicMVCardChooseView)localObject3).AwZ;
            kotlin.g.b.p.h(localObject2, "resultListener");
            ((MusicMvTabFragment)localObject1).Azf = ((MusicMvTabFragment.c)localObject2);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwJ;
          if (localObject1 != null) {
            ((MusicMvTabSearchFragment)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
          }
          ((MusicMVCardChooseView)localObject3).vtJ = ((TextView)((MusicMVCardChooseView)localObject3).findViewById(2131305461));
          ((MusicMVCardChooseView)localObject3).AwK = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131303706));
          ((MusicMVCardChooseView)localObject3).AwL = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131305201));
          ((MusicMVCardChooseView)localObject3).AwM = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131305203));
          ((MusicMVCardChooseView)localObject3).AwN = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131305195));
          ((MusicMVCardChooseView)localObject3).AwO = ((LinearLayout)((MusicMVCardChooseView)localObject3).findViewById(2131305202));
          ((MusicMVCardChooseView)localObject3).AwP = ((MusicMvTabMachineFragment)((MusicMVCardChooseView)localObject3).findViewById(2131305773));
          ((MusicMVCardChooseView)localObject3).AwQ = ((MusicMvTabMyPostFragment)((MusicMVCardChooseView)localObject3).findViewById(2131305776));
          ((MusicMVCardChooseView)localObject3).AwR = ((MusicMvTabMyFavFragment)((MusicMVCardChooseView)localObject3).findViewById(2131305774));
          ((MusicMVCardChooseView)localObject3).AwS = ((MusicMvTabMyLikeFragment)((MusicMVCardChooseView)localObject3).findViewById(2131305775));
          localObject1 = ((MusicMVCardChooseView)localObject3).AwR;
          if (localObject1 != null) {
            ((MusicMvTabMyFavFragment)localObject1).a((MusicMvTabFragment.b)((MusicMVCardChooseView)localObject3).AwY);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwP;
          if (localObject1 != null) {
            ((MusicMvTabMachineFragment)localObject1).a((MusicMvTabFragment.b)((MusicMVCardChooseView)localObject3).AwY);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwQ;
          if (localObject1 != null) {
            ((MusicMvTabMyPostFragment)localObject1).a((MusicMvTabFragment.b)((MusicMVCardChooseView)localObject3).AwY);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwS;
          if (localObject1 != null) {
            ((MusicMvTabMyLikeFragment)localObject1).a((MusicMvTabFragment.b)((MusicMVCardChooseView)localObject3).AwY);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwP;
          if (localObject1 != null) {
            ((MusicMvTabMachineFragment)localObject1).a(((MusicMVCardChooseView)localObject3).AkC, null);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwQ;
          if (localObject1 != null) {
            ((MusicMvTabMyPostFragment)localObject1).a(((MusicMVCardChooseView)localObject3).AkC, null);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwR;
          if (localObject1 != null) {
            ((MusicMvTabMyFavFragment)localObject1).a(((MusicMVCardChooseView)localObject3).AkC, null);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwS;
          if (localObject1 != null) {
            ((MusicMvTabMyLikeFragment)localObject1).a(((MusicMVCardChooseView)localObject3).AkC, null);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwP;
          if (localObject1 != null) {
            ((MusicMvTabMachineFragment)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwQ;
          if (localObject1 != null) {
            ((MusicMvTabMyPostFragment)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwR;
          if (localObject1 != null) {
            ((MusicMvTabMyFavFragment)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwS;
          if (localObject1 != null) {
            ((MusicMvTabMyLikeFragment)localObject1).setOnFlingListener((RecyclerView.j)((MusicMVCardChooseView)localObject3).AwU);
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwL;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.j((MusicMVCardChooseView)localObject3));
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwM;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.k((MusicMVCardChooseView)localObject3));
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwN;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.l((MusicMVCardChooseView)localObject3));
          }
          localObject1 = ((MusicMVCardChooseView)localObject3).AwO;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)new MusicMVCardChooseView.m((MusicMVCardChooseView)localObject3));
          }
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "init completed");
          localObject1 = MusicMvMakerUI.a(this.Arg);
          if (localObject1 != null)
          {
            localObject2 = (MusicMVCardChooseView.b)localMusicMvMakerUI;
            kotlin.g.b.p.h(localObject2, "listener");
            ((MusicMVCardChooseView)localObject1).AwV = ((MusicMVCardChooseView.b)localObject2);
          }
          localObject1 = MusicMvMakerUI.g(this.Arg);
          kotlin.g.b.p.g(localObject1, "nextBtn");
          localObject2 = com.tencent.mm.ui.component.a.PRN;
          ((View)localObject1).setEnabled(((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
          AppMethodBeat.o(256889);
          return;
          label3191:
          localObject1 = null;
          break;
          label3197:
          localObject1 = null;
          break label1524;
          localObject2 = null;
          break label1546;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3$onInitDataReady$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"})
    public static final class a
      implements MusicMvMakerEditUIC.e
    {
      public final void a(com.tencent.mm.plugin.mv.a.d paramd, boolean paramBoolean, com.tencent.mm.plugin.mv.a.f paramf)
      {
        AppMethodBeat.i(256887);
        kotlin.g.b.p.h(paramd, "item");
        if (paramf != null)
        {
          Object localObject1 = MusicMvMakerUI.b(this.Arl.Arg);
          kotlin.g.b.p.g(localObject1, "albumAnimationContainer");
          ((View)localObject1).setVisibility(0);
          MusicMvMakerUI.c(this.Arl.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context)this.Arl.Arg.getContext(), 12));
          localObject1 = MusicMvMakerUI.d(this.Arl.Arg);
          kotlin.g.b.p.g(localObject1, "mvItemEditThumb");
          localObject1 = (View)localObject1;
          Object localObject2 = MusicMvMakerUI.c(this.Arl.Arg);
          kotlin.g.b.p.g(localObject2, "albumFakeThumb");
          localObject2 = (ImageView)localObject2;
          kotlin.g.b.p.h(localObject1, "to");
          kotlin.g.b.p.h(localObject2, "animateView");
          paramf = paramf.a(com.tencent.mm.plugin.mv.a.g.eC((View)localObject1), (ImageView)localObject2, false);
          paramf.addListener((Animator.AnimatorListener)new a(this));
          paramf.setDuration(250L);
          paramf.start();
          paramf = com.tencent.mm.ui.component.a.PRN;
          ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(true);
          paramf = com.tencent.mm.ui.component.a.PRN;
          ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).d(paramd);
          paramd = MusicMvMakerUI.e(this.Arl.Arg);
          kotlin.g.b.p.g(paramd, "mvItemEditBottomLine");
          f1 = paramd.getY();
          paramd = MusicMvMakerUI.f(this.Arl.Arg);
          kotlin.g.b.p.g(paramd, "mvListEditBottomLine");
          f2 = paramd.getY();
          MusicMvMakerUI.a(this.Arl.Arg).animate().translationY(f1 - f2).start();
          paramd = com.tencent.mm.ui.component.a.PRN;
          ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerEditUIC.class)).AuF = paramBoolean;
          MusicMvMakerUI.a(this.Arl.Arg).AwT = false;
          AppMethodBeat.o(256887);
          return;
        }
        paramf = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(true);
        paramf = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).d(paramd);
        paramd = MusicMvMakerUI.e(this.Arl.Arg);
        kotlin.g.b.p.g(paramd, "mvItemEditBottomLine");
        float f1 = paramd.getY();
        paramd = MusicMvMakerUI.f(this.Arl.Arg);
        kotlin.g.b.p.g(paramd, "mvListEditBottomLine");
        float f2 = paramd.getY();
        MusicMvMakerUI.a(this.Arl.Arg).animate().translationY(f1 - f2).start();
        paramd = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerEditUIC.class)).AuF = paramBoolean;
        MusicMvMakerUI.a(this.Arl.Arg).AwT = false;
        AppMethodBeat.o(256887);
      }
      
      public final void b(com.tencent.mm.plugin.mv.a.d paramd)
      {
        AppMethodBeat.i(256885);
        kotlin.g.b.p.h(paramd, "item");
        MusicMVCardChooseView localMusicMVCardChooseView = MusicMvMakerUI.a(this.Arl.Arg);
        if (localMusicMVCardChooseView != null)
        {
          int i = paramd.getDurationMs();
          MusicMVCardChooseView.Axc = i;
          paramd = localMusicMVCardChooseView.AwD;
          if (paramd != null)
          {
            paramd.ArJ = i;
            paramd.notifyDataSetChanged();
          }
          paramd = localMusicMVCardChooseView.AwP;
          if (paramd != null) {
            paramd.setVideoDuration(i);
          }
          paramd = localMusicMVCardChooseView.AwQ;
          if (paramd != null) {
            paramd.setVideoDuration(i);
          }
          paramd = localMusicMVCardChooseView.AwR;
          if (paramd != null) {
            paramd.setVideoDuration(i);
          }
          paramd = localMusicMVCardChooseView.AwS;
          if (paramd != null) {
            paramd.setVideoDuration(i);
          }
          paramd = localMusicMVCardChooseView.AwJ;
          if (paramd != null)
          {
            paramd.setVideoDuration(i);
            AppMethodBeat.o(256885);
            return;
          }
          AppMethodBeat.o(256885);
          return;
        }
        AppMethodBeat.o(256885);
      }
      
      public final void c(com.tencent.mm.plugin.mv.a.d paramd)
      {
        AppMethodBeat.i(256888);
        kotlin.g.b.p.h(paramd, "item");
        paramd = MusicMvMakerUI.g(this.Arl.Arg);
        kotlin.g.b.p.g(paramd, "nextBtn");
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        paramd.setEnabled(((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arl.Arg).get(MusicMvMakerEditUIC.class)).evZ());
        AppMethodBeat.o(256888);
      }
      
      public final void evF()
      {
        AppMethodBeat.i(256886);
        Object localObject = MusicMvMakerUI.a(this.Arl.Arg);
        if (localObject != null)
        {
          com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
          com.tencent.mm.plugin.gallery.a.dQq().setScene(((MusicMVCardChooseView)localObject).het);
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", new Object[] { localObject });
          com.tencent.mm.plugin.gallery.model.e.dQK().a((i.c)localObject);
          ((MusicMVCardChooseView)localObject).xov = MusicMVCardChooseView.ewo();
          com.tencent.mm.plugin.gallery.model.e.dQK().ax("", ((MusicMVCardChooseView)localObject).xov);
          localObject = com.tencent.mm.plugin.gallery.model.p.xjw;
          com.tencent.mm.plugin.gallery.model.p.dRt().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.l());
          localObject = com.tencent.mm.plugin.gallery.model.p.xjw;
          com.tencent.mm.plugin.gallery.model.p.dRt().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.q());
          AppMethodBeat.o(256886);
          return;
        }
        AppMethodBeat.o(256886);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3$onInitDataReady$1$onEditItem$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
      public static final class a
        extends AnimatorListenerAdapter
      {
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(256884);
          paramAnimator = MusicMvMakerUI.b(this.Arm.Arl.Arg);
          kotlin.g.b.p.g(paramAnimator, "albumAnimationContainer");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(256884);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"})
  public static final class i
    implements MusicMvMakerItemEditUIC.b
  {
    public final void Fe(boolean paramBoolean)
    {
      AppMethodBeat.i(258876);
      Object localObject1 = MusicMvMakerUI.b(this.Arg);
      kotlin.g.b.p.g(localObject1, "albumAnimationContainer");
      ((View)localObject1).setVisibility(0);
      MusicMvMakerUI.c(this.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context)this.Arg.getContext(), 12));
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class);
      kotlin.g.b.p.g(localObject1, "UICProvider.of(this@Musi…MakerEditUIC::class.java)");
      localObject1 = (MusicMvMakerEditUIC)localObject1;
      Object localObject2 = ((MusicMvMakerEditUIC)localObject1).evY();
      ImageView localImageView = MusicMvMakerUI.d(this.Arg);
      kotlin.g.b.p.g(localImageView, "mvItemEditThumb");
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      MMRoundCornerImageView localMMRoundCornerImageView = MusicMvMakerUI.c(this.Arg);
      kotlin.g.b.p.g(localMMRoundCornerImageView, "albumFakeThumb");
      localObject2 = com.tencent.mm.plugin.mv.a.g.a(localImageView, (View)localObject2, (ImageView)localMMRoundCornerImageView, false);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new b(this));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      MusicMvMakerUI.a(this.Arg).animate().translationY(0.0F).setListener((Animator.AnimatorListener)new c(this)).start();
      ((MusicMvMakerEditUIC)localObject1).k((m)new MusicMvMakerUI.i.e(paramBoolean));
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class);
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "disableCurrentSyncMusic");
      if (((MusicMvMakerEditUIC)localObject1).AtW.hbQ + 1 < ((MusicMvMakerEditUIC)localObject1).getAdapter().getItemCount())
      {
        localObject1 = (com.tencent.mm.plugin.mv.a.d)kotlin.a.j.L((List)((MusicMvMakerEditUIC)localObject1).kgc, ((MusicMvMakerEditUIC)localObject1).AtW.hbQ);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mv.a.d)localObject1).Apn = false;
        }
      }
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(false);
      MusicMvMakerUI.a(this.Arg).AwT = true;
      localObject1 = MusicMvMakerUI.g(this.Arg);
      kotlin.g.b.p.g(localObject1, "nextBtn");
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      ((View)localObject1).setEnabled(((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
      AppMethodBeat.o(258876);
    }
    
    public final void Ff(boolean paramBoolean)
    {
      AppMethodBeat.i(258877);
      Object localObject1 = MusicMvMakerUI.b(this.Arg);
      kotlin.g.b.p.g(localObject1, "albumAnimationContainer");
      ((View)localObject1).setVisibility(0);
      MusicMvMakerUI.c(this.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context)this.Arg.getContext(), 12));
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class);
      kotlin.g.b.p.g(localObject1, "UICProvider.of(this@Musi…MakerEditUIC::class.java)");
      localObject1 = (MusicMvMakerEditUIC)localObject1;
      Object localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class)).evY();
      Object localObject3 = MusicMvMakerUI.d(this.Arg);
      kotlin.g.b.p.g(localObject3, "mvItemEditThumb");
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      MMRoundCornerImageView localMMRoundCornerImageView = MusicMvMakerUI.c(this.Arg);
      kotlin.g.b.p.g(localMMRoundCornerImageView, "albumFakeThumb");
      localObject2 = com.tencent.mm.plugin.mv.a.g.a((ImageView)localObject3, (View)localObject2, (ImageView)localMMRoundCornerImageView, ((MusicMvMakerEditUIC)localObject1).AuF);
      ((Animator)localObject2).addListener((Animator.AnimatorListener)new a(this));
      ((Animator)localObject2).setDuration(250L);
      ((Animator)localObject2).start();
      ((MusicMvMakerEditUIC)localObject1).k((m)new MusicMvMakerUI.i.d(paramBoolean));
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvMakerItemEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(false);
      if ((((MusicMvMakerEditUIC)localObject1).AuF) && (((MusicMvMakerEditUIC)localObject1).tex >= 0) && (((MusicMvMakerEditUIC)localObject1).tex < ((MusicMvMakerEditUIC)localObject1).kgc.size()))
      {
        localObject2 = ((MusicMvMakerEditUIC)localObject1).kgc.get(((MusicMvMakerEditUIC)localObject1).tex);
        kotlin.g.b.p.g(localObject2, "dataList[lastPos]");
        localObject2 = (com.tencent.mm.plugin.mv.a.d)localObject2;
        int i = ((MusicMvMakerEditUIC)localObject1).tex;
        localObject3 = ((com.tencent.mm.plugin.mv.a.d)localObject2).Apq;
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.mv.a.d)localObject3).uOQ = ((com.tencent.mm.plugin.mv.a.d)localObject2).uOQ;
          ((MusicMvMakerEditUIC)localObject1).kgc.set(i, localObject3);
          ((MusicMvMakerEditUIC)localObject1).getAdapter().ci(i);
          ((MusicMvMakerEditUIC)localObject1).Tq(i);
        }
      }
      MusicMvMakerUI.a(this.Arg).animate().translationY(0.0F).start();
      MusicMvMakerUI.a(this.Arg).AwT = true;
      localObject1 = MusicMvMakerUI.g(this.Arg);
      kotlin.g.b.p.g(localObject1, "nextBtn");
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      ((View)localObject1).setEnabled(((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
      AppMethodBeat.o(258877);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onCancel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(256890);
        paramAnimator = MusicMvMakerUI.c(this.Arn.Arg);
        kotlin.g.b.p.g(paramAnimator, "albumFakeThumb");
        paramAnimator.setAlpha(1.0F);
        paramAnimator = MusicMvMakerUI.b(this.Arn.Arg);
        kotlin.g.b.p.g(paramAnimator, "albumAnimationContainer");
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(256890);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onConfirm$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class b
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(256891);
        paramAnimator = MusicMvMakerUI.b(this.Arn.Arg);
        kotlin.g.b.p.g(paramAnimator, "albumAnimationContainer");
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(256891);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onConfirm$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class c
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(256892);
        MusicMvMakerUI.a(this.Arn.Arg).animate().setListener(null);
        paramAnimator = com.tencent.mm.ui.component.a.PRN;
        Object localObject = (MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.Arn.Arg).get(MusicMvMakerEditUIC.class);
        Log.d("MicroMsg.Mv.MusicMvMakerEditUIC", "moveToNextItem, lastPos:" + ((MusicMvMakerEditUIC)localObject).tex);
        if (((MusicMvMakerEditUIC)localObject).tex + 1 < ((MusicMvMakerEditUIC)localObject).getAdapter().getItemCount())
        {
          paramAnimator = ((MusicMvMakerEditUIC)localObject).evW();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(((MusicMvMakerEditUIC)localObject).tex + 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          paramAnimator.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnimator, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(256892);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(MusicMvMakerUI paramMusicMvMakerUI, MusicMvTabFragment.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI
 * JD-Core Version:    0.7.0.1
 */