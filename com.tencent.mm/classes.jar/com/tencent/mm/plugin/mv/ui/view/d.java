package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.mv.ui.uic.k;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "MAX_TRANSLATIONY", "", "collapseLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "getCollapseLayout", "()Lcom/tencent/mm/ui/blur/BlurView;", "collapseLayout$delegate", "Lkotlin/Lazy;", "copyrightFromTv", "Landroid/widget/TextView;", "getCopyrightFromTv", "()Landroid/widget/TextView;", "copyrightFromTv$delegate", "copyrightInfoLayout", "getCopyrightInfoLayout", "copyrightInfoLayout$delegate", "copyrightIv", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getCopyrightIv", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "copyrightIv$delegate", "coverAreaFl", "getCoverAreaFl", "()Landroid/view/ViewGroup;", "coverAreaFl$delegate", "coverIv", "Lcom/tencent/mm/ui/MMImageView;", "getCoverIv", "()Lcom/tencent/mm/ui/MMImageView;", "coverIv$delegate", "defaultCoverFl", "Landroid/view/View;", "getDefaultCoverFl", "()Landroid/view/View;", "defaultCoverFl$delegate", "dialogRootLayout", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getDialogRootLayout", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "dialogRootLayout$delegate", "isShow", "", "layoutHeight", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getParent", "rootLayout", "Landroid/widget/FrameLayout;", "getRootLayout", "()Landroid/widget/FrameLayout;", "rootLayout$delegate", "singerTv", "getSingerTv", "singerTv$delegate", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoFullScreenRoot", "getSongInfoFullScreenRoot", "songInfoFullScreenRoot$delegate", "songNameTv", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "getSongNameTv", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "songNameTv$delegate", "hide", "", "passParameters", "reset", "setListener", "show", "updateMv", "Companion", "OnCloseBtnClickListener", "plugin-mv_release"})
@SuppressLint({"ResourceType"})
public final class d
{
  public static final d.a GpA;
  public static final String TAG;
  public bds GaB;
  public com.tencent.mm.plugin.mv.model.f GgZ;
  private final kotlin.f Gpm;
  private final kotlin.f Gpn;
  private final kotlin.f Gpo;
  private final kotlin.f Gpp;
  private final kotlin.f Gpq;
  private final kotlin.f Gpr;
  private final kotlin.f Gps;
  private final kotlin.f Gpt;
  private final kotlin.f Gpu;
  private final kotlin.f Gpv;
  private final kotlin.f Gpw;
  private final kotlin.f Gpx;
  public final int Gpy;
  public b Gpz;
  public boolean fxt;
  public final ViewGroup parent;
  public int zPO;
  public int zPP;
  
  static
  {
    AppMethodBeat.i(227371);
    GpA = new d.a((byte)0);
    TAG = "MicroMsg.Mv.MusicMvSongInfoDialog@" + GpA.hashCode();
    AppMethodBeat.o(227371);
  }
  
  public d(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(227370);
    this.parent = paramViewGroup;
    this.Gpm = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.Gpn = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.Gpo = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Gpp = kotlin.g.ar((kotlin.g.a.a)new q(this));
    this.Gpq = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.Gpr = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.Gps = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Gpt = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.Gpu = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Gpv = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.Gpw = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Gpx = kotlin.g.ar((kotlin.g.a.a)new c(this));
    paramViewGroup = MMApplicationContext.getContext();
    p.j(paramViewGroup, "MMApplicationContext.getContext()");
    this.Gpy = paramViewGroup.getResources().getDimensionPixelSize(b.c.Edge_10A);
    paramViewGroup = ar.hv(this.parent.getContext());
    this.zPP = paramViewGroup.y;
    this.zPO = paramViewGroup.x;
    Object localObject = fhW();
    p.j(localObject, "coverAreaFl");
    localObject = ((ViewGroup)localObject).getLayoutParams();
    int i = this.zPO - com.tencent.mm.ci.a.fromDPToPix(this.parent.getContext(), 32);
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    ViewGroup localViewGroup = fhW();
    p.j(localViewGroup, "coverAreaFl");
    localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    fhZ().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(241014);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!d.a(this.GpB))
        {
          Log.i(d.access$getTAG$cp(), "copyrightInfoLayout.setOnClickListener, isShow:false, return ");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(241014);
          return;
        }
        paramAnonymousView = com.tencent.mm.ui.component.g.Xox;
        paramAnonymousView = this.GpB.parent.getContext();
        p.j(paramAnonymousView, "parent.context");
        paramAnonymousView = ((com.tencent.mm.plugin.mv.ui.uic.g)com.tencent.mm.ui.component.g.lm(paramAnonymousView).i(com.tencent.mm.plugin.mv.ui.uic.g.class)).GaB;
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = this.GpB.parent.getContext();
        p.j(localObject1, "parent.context");
        int i = ((k)com.tencent.mm.ui.component.g.lm((Context)localObject1).i(k.class)).a(paramAnonymousView, (al)new a(this, paramAnonymousView));
        if (i != 7)
        {
          localObject1 = d.e(this.GpB);
          if ((paramAnonymousView != null) && (localObject1 != null))
          {
            Object localObject2 = o.GcB;
            localObject2 = this.GpB.parent.getContext();
            p.j(localObject2, "parent.context");
            o.a((Context)localObject2, paramAnonymousView, (com.tencent.mm.plugin.mv.model.f)localObject1, 2, i, 1);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241014);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "launchSuccess", "", "launchCancel", "onLaunchApp"})
      static final class a
        implements al
      {
        a(d.1 param1, bds parambds) {}
        
        public final void y(boolean paramBoolean1, boolean paramBoolean2)
        {
          AppMethodBeat.i(225787);
          bds localbds = paramAnonymousView;
          com.tencent.mm.plugin.mv.model.f localf = d.e(this.GpC.GpB);
          if ((localbds != null) && (localf != null))
          {
            Object localObject;
            if (paramBoolean1)
            {
              localObject = o.GcB;
              localObject = this.GpC.GpB.parent.getContext();
              p.j(localObject, "parent.context");
              o.a((Context)localObject, localbds, localf, 2, 1, 1);
            }
            if (paramBoolean2)
            {
              localObject = o.GcB;
              localObject = this.GpC.GpB.parent.getContext();
              p.j(localObject, "parent.context");
              o.a((Context)localObject, localbds, localf, 2, 3, 1);
            }
          }
          AppMethodBeat.o(225787);
        }
      }
    });
    localObject = (ViewGroup)this.Gpm.getValue();
    p.j(localObject, "songInfoFullScreenRoot");
    ((ViewGroup)localObject).setVisibility(0);
    localObject = fhT();
    p.j(localObject, "dialogRootLayout");
    ((RoundCornerRelativeLayout)localObject).setAlpha(0.0F);
    localObject = fhT();
    p.j(localObject, "dialogRootLayout");
    ((RoundCornerRelativeLayout)localObject).setTranslationY(-1.0F * this.Gpy);
    localObject = (FrameLayout)this.Gpn.getValue();
    if (localObject != null) {
      ((FrameLayout)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242977);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.GpB.hide();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242977);
        }
      });
    }
    Log.i(TAG, "init layout height:" + this.zPP + ", screenSize:" + paramViewGroup);
    paramViewGroup = fhX();
    p.j(paramViewGroup, "coverIv");
    paramViewGroup = paramViewGroup.getDrawable();
    localObject = fhZ();
    if (localObject != null) {
      ((BlurView)localObject).T((ViewGroup)fhT()).L(paramViewGroup).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(((BlurView)localObject).getContext())).cO(30.0F).hLy().cN(com.tencent.mm.ci.a.aY(((BlurView)localObject).getContext(), b.c.Edge_A)).hLz().auW(Color.parseColor("#61D2D2D2"));
    }
    localObject = fic();
    if (localObject != null) {
      ((BlurView)localObject).T((ViewGroup)fhT()).L(paramViewGroup).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(((BlurView)localObject).getContext())).cO(50.0F).hLy().cN(com.tencent.mm.ci.a.aY(((BlurView)localObject).getContext(), b.c.Edge_A)).hLz();
    }
    paramViewGroup = fic();
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242831);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = d.f(this.GpB);
          if (paramAnonymousView != null) {
            paramAnonymousView.fhy();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242831);
        }
      });
    }
    this.fxt = false;
    AppMethodBeat.o(227370);
  }
  
  private final ViewGroup fhW()
  {
    AppMethodBeat.i(227334);
    ViewGroup localViewGroup = (ViewGroup)this.Gpr.getValue();
    AppMethodBeat.o(227334);
    return localViewGroup;
  }
  
  private final BlurView fic()
  {
    AppMethodBeat.i(227343);
    BlurView localBlurView = (BlurView)this.Gpx.getValue();
    AppMethodBeat.o(227343);
    return localBlurView;
  }
  
  public final RoundCornerRelativeLayout fhT()
  {
    AppMethodBeat.i(227328);
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = (RoundCornerRelativeLayout)this.Gpo.getValue();
    AppMethodBeat.o(227328);
    return localRoundCornerRelativeLayout;
  }
  
  public final MusicMvMarqueeTextView fhU()
  {
    AppMethodBeat.i(227329);
    MusicMvMarqueeTextView localMusicMvMarqueeTextView = (MusicMvMarqueeTextView)this.Gpp.getValue();
    AppMethodBeat.o(227329);
    return localMusicMvMarqueeTextView;
  }
  
  public final TextView fhV()
  {
    AppMethodBeat.i(227331);
    TextView localTextView = (TextView)this.Gpq.getValue();
    AppMethodBeat.o(227331);
    return localTextView;
  }
  
  public final MMImageView fhX()
  {
    AppMethodBeat.i(227336);
    MMImageView localMMImageView = (MMImageView)this.Gps.getValue();
    AppMethodBeat.o(227336);
    return localMMImageView;
  }
  
  public final View fhY()
  {
    AppMethodBeat.i(227338);
    View localView = (View)this.Gpt.getValue();
    AppMethodBeat.o(227338);
    return localView;
  }
  
  public final BlurView fhZ()
  {
    AppMethodBeat.i(227339);
    BlurView localBlurView = (BlurView)this.Gpu.getValue();
    AppMethodBeat.o(227339);
    return localBlurView;
  }
  
  public final MMRoundCornerImageView fia()
  {
    AppMethodBeat.i(227341);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.Gpv.getValue();
    AppMethodBeat.o(227341);
    return localMMRoundCornerImageView;
  }
  
  public final TextView fib()
  {
    AppMethodBeat.i(227342);
    TextView localTextView = (TextView)this.Gpw.getValue();
    AppMethodBeat.o(227342);
    return localTextView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(227345);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("hide song info dialog, isShow:").append(this.fxt).append(", translateY:");
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = fhT();
    p.j(localRoundCornerRelativeLayout, "dialogRootLayout");
    Log.i(str, localRoundCornerRelativeLayout.getTranslationY());
    if (this.fxt)
    {
      Log.i(TAG, "do hide");
      fhT().animate().translationY(1.0F * this.Gpy).alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new k(this)).start();
    }
    AppMethodBeat.o(227345);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "", "onClicked", "", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void fhy();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<BlurView>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<BlurView>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<MMRoundCornerImageView>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/MMImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<MMImageView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<View>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RoundCornerRelativeLayout>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
  public static final class k
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(226074);
      Log.i(d.access$getTAG$cp(), "onHide animate end");
      paramAnimator = d.b(this.GpB);
      p.j(paramAnimator, "dialogRootLayout");
      paramAnimator.setTranslationY(-1.0F * d.c(this.GpB));
      d.a(this.GpB, false);
      AppMethodBeat.o(226074);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<TextView>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<MusicMvMarqueeTextView>
  {
    q(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.d
 * JD-Core Version:    0.7.0.1
 */