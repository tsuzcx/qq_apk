package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.xlabeffect.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.j;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "animator", "Landroid/animation/ValueAnimator;", "beautyEffectIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "beautyLoadingProgress", "Landroid/widget/ProgressBar;", "beautyLoadingTips", "Landroid/widget/TextView;", "container", "Landroid/widget/RelativeLayout;", "isAllImage", "", "isBeautyCheck", "isEnable", "isLoadingStatus", "isNeedSetVisibleRect", "labelRetriever", "Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "loadingWidth", "", "margin", "newVisibleRect", "Landroid/graphics/RectF;", "normalWidth", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "videoVisibleRect", "cancelRetrieveLabel", "", "enableVideoEnhancement", "hideBeautySwitch", "isBeautyOpened", "loadingNormalStateSwitch", "toLoading", "callback", "Lkotlin/Function0;", "photoEnhancement", "paths", "", "", "enable", "setEnable", "setVideoComposition", "setVisibility", "visibility", "setVisibleRect", "rect", "showBeautySwitch", "switchVideoEnhancement", "switchVideoEnhancementCheckStatus", "videoEnhancement", "Companion", "plugin-vlog_release"})
public final class ai
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a Nxh;
  private final int AFN;
  private d APl;
  private boolean Nma;
  private final int Nme;
  private RectF NwV;
  private boolean NwW;
  private RectF NwX;
  private RelativeLayout NwY;
  private final int NwZ;
  private final WeImageView Nxa;
  private final ProgressBar Nxb;
  private final TextView Nxc;
  public boolean Nxd;
  public com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a Nxe;
  private boolean Nxf;
  private j Nxg;
  private ValueAnimator animator;
  private boolean dih;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(241585);
    Nxh = new a((byte)0);
    AppMethodBeat.o(241585);
  }
  
  public ai(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(241582);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.NwV = new RectF();
    this.NwX = new RectF();
    paramViewGroup = this.parent.findViewById(a.f.preview_decorator_container);
    p.j(paramViewGroup, "parent.findViewById(R.id…view_decorator_container)");
    this.NwY = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.getContext();
    p.j(paramViewGroup, "parent.context");
    this.Nme = paramViewGroup.getResources().getDimensionPixelSize(a.d.Edge_4_5_A);
    paramViewGroup = this.parent.getContext();
    p.j(paramViewGroup, "parent.context");
    this.AFN = paramViewGroup.getResources().getDimensionPixelSize(a.d.Edge_1_5_A);
    paramViewGroup = this.parent.getContext();
    p.j(paramViewGroup, "parent.context");
    this.NwZ = paramViewGroup.getResources().getDimensionPixelSize(a.d.Edge_14A);
    this.Nxe = new com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a();
    this.dih = true;
    ad.kS(this.parent.getContext()).inflate(a.g.editor_video_beauty_view, (ViewGroup)this.NwY, true);
    paramViewGroup = this.NwY.findViewById(a.f.beauty_effect);
    p.j(paramViewGroup, "container.findViewById(R.id.beauty_effect)");
    this.Nxa = ((WeImageView)paramViewGroup);
    paramViewGroup = this.NwY.findViewById(a.f.loading_progress);
    p.j(paramViewGroup, "container.findViewById(R.id.loading_progress)");
    this.Nxb = ((ProgressBar)paramViewGroup);
    paramViewGroup = this.NwY.findViewById(a.f.loading_tips);
    p.j(paramViewGroup, "container.findViewById(R.id.loading_tips)");
    this.Nxc = ((TextView)paramViewGroup);
    this.Nxa.setIconColor(-1);
    this.Nxa.setVisibility(8);
    if (a.isEnable())
    {
      this.NwY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(243682);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          boolean bool;
          if (ai.f(this.Nxi).isShown())
          {
            paramAnonymousView = this.Nxi;
            if (ai.k(this.Nxi)) {
              break label111;
            }
            bool = true;
            ai.c(paramAnonymousView, bool);
            if (!ai.l(this.Nxi)) {
              break label116;
            }
            ai.a(this.Nxi, ai.k(this.Nxi));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243682);
            return;
            label111:
            bool = false;
            break;
            label116:
            paramAnonymousView = this.Nxi;
            localObject = ai.m(this.Nxi);
            bool = ai.k(this.Nxi);
            if (!ai.a.isEnable())
            {
              Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
            }
            else
            {
              if (bool)
              {
                com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.Nol;
                if ((com.tencent.mm.plugin.vlog.model.local.a.gtP().isEmpty()) && (localObject != null))
                {
                  paramAnonymousView.c(true, (kotlin.g.a.a)new ai.e(paramAnonymousView, (j)localObject, bool));
                  continue;
                }
              }
              paramAnonymousView.Ay(bool);
            }
          }
        }
      });
      Az(false);
    }
    if (!a.isEnable()) {
      this.NwY.setVisibility(8);
    }
    com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf.dbH();
    AppMethodBeat.o(241582);
  }
  
  private void Az(boolean paramBoolean)
  {
    AppMethodBeat.i(241572);
    this.Nxa.setVisibility(0);
    if (paramBoolean) {
      this.Nxa.setImageDrawable(this.parent.getContext().getDrawable(a.h.icons_filled_cutie_check));
    }
    for (;;)
    {
      this.Nxa.setIconColor(-1);
      AppMethodBeat.o(241572);
      return;
      this.Nxa.setImageDrawable(this.parent.getContext().getDrawable(a.h.icons_filled_cutie));
    }
  }
  
  final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(241567);
    Az(paramBoolean);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.APl.a(d.c.HTG, (Bundle)localObject);
    this.Nxd = paramBoolean;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      com.tencent.mm.plugin.vlog.model.local.a.gtW();
    }
    AppMethodBeat.o(241567);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(241563);
    p.k(paramj, "videoComposition");
    this.Nxg = paramj;
    AppMethodBeat.o(241563);
  }
  
  final void c(final boolean paramBoolean, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(241568);
    Log.i("MicroMsg.VideoPreviewDecorationPlugin", "start loadingNormalStateSwitch, toLoading:".concat(String.valueOf(paramBoolean)));
    this.Nxa.setVisibility(8);
    this.Nxc.setVisibility(8);
    this.Nxb.setVisibility(8);
    this.Nxf = paramBoolean;
    int i;
    if (paramBoolean)
    {
      i = this.Nme;
      if (!paramBoolean) {
        break label265;
      }
    }
    label265:
    for (int j = this.NwZ;; j = this.Nme)
    {
      i = (int)(this.NwV.width() + this.NwV.left - i - this.AFN);
      j = (int)(this.NwV.width() + this.NwV.left - j - this.AFN);
      ValueAnimator localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.animator = ValueAnimator.ofFloat(new float[] { i, j });
      localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this));
      }
      localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.addListener((Animator.AnimatorListener)new c(this, paramBoolean, parama));
      }
      parama = this.animator;
      if (parama != null) {
        parama.setDuration(300L);
      }
      parama = this.animator;
      if (parama == null) {
        break label274;
      }
      parama.start();
      AppMethodBeat.o(241568);
      return;
      i = this.NwZ;
      break;
    }
    label274:
    AppMethodBeat.o(241568);
  }
  
  public final boolean gvR()
  {
    AppMethodBeat.i(241573);
    if ((this.Nxd) && (a.isEnable()))
    {
      AppMethodBeat.o(241573);
      return true;
    }
    AppMethodBeat.o(241573);
    return false;
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(241570);
    p.k(paramRectF, "rect");
    Object localObject1 = new StringBuilder("setVisibleRect:").append(paramRectF).append(", animator:");
    Object localObject2 = this.animator;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(", isRunning:");
      localObject1 = this.animator;
      if (localObject1 == null) {
        break label181;
      }
    }
    label181:
    for (localObject1 = Boolean.valueOf(((ValueAnimator)localObject1).isRunning());; localObject1 = null)
    {
      Log.i("MicroMsg.VideoPreviewDecorationPlugin", localObject1);
      if (this.animator != null)
      {
        localObject1 = this.animator;
        if ((localObject1 == null) || (((ValueAnimator)localObject1).isRunning())) {
          break label317;
        }
      }
      if (!(p.h(this.NwV, paramRectF) ^ true)) {
        break label317;
      }
      this.NwW = false;
      this.NwV.set(paramRectF);
      paramRectF = this.NwY.getLayoutParams();
      if (paramRectF != null) {
        break label186;
      }
      paramRectF = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(241570);
      throw paramRectF;
      i = 0;
      break;
    }
    label186:
    paramRectF = (ViewGroup.MarginLayoutParams)paramRectF;
    paramRectF.topMargin = ((int)((int)this.NwV.top + this.NwV.height() - this.Nme - this.AFN));
    if (this.Nxf) {}
    for (paramRectF.leftMargin = ((int)(this.NwV.width() + this.NwV.left - this.NwZ - this.AFN));; paramRectF.leftMargin = ((int)(this.NwV.width() + this.NwV.left - this.Nme - this.AFN)))
    {
      this.NwY.setLayoutParams((ViewGroup.LayoutParams)paramRectF);
      AppMethodBeat.o(241570);
      return;
    }
    label317:
    this.NwW = true;
    this.NwX.set(paramRectF);
    AppMethodBeat.o(241570);
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(241575);
    this.dih = paramBoolean;
    if (a.isEnable())
    {
      this.NwY.setVisibility(0);
      AppMethodBeat.o(241575);
      return;
    }
    this.NwY.setVisibility(8);
    AppMethodBeat.o(241575);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(241577);
    if (a.isEnable()) {
      this.NwY.setVisibility(paramInt);
    }
    AppMethodBeat.o(241577);
  }
  
  public final void v(final List<String> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(241564);
    if (!a.isEnable())
    {
      Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
      AppMethodBeat.o(241564);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      if ((com.tencent.mm.plugin.vlog.model.local.a.gtP().isEmpty()) && (paramList != null))
      {
        c(true, (kotlin.g.a.a)new d(this, paramList, paramBoolean));
        AppMethodBeat.o(241564);
        return;
      }
    }
    Ay(paramBoolean);
    AppMethodBeat.o(241564);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$Companion;", "", "()V", "TAG", "", "isEnable", "", "plugin-vlog_release"})
  public static final class a
  {
    public static boolean isEnable()
    {
      AppMethodBeat.i(226026);
      Object localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      if (com.tencent.mm.plugin.vlog.model.local.a.gtU()) {
        if (!g.HVd.fxS())
        {
          localObject = new StringBuilder();
          h localh = h.QQH;
          localObject = ((StringBuilder)localObject).append(h.hfj()).append("/");
          localh = h.QQH;
          if (!u.agG(h.hfl())) {}
        }
        else
        {
          AppMethodBeat.o(226026);
          return true;
        }
      }
      AppMethodBeat.o(226026);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(ai paramai) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(231605);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(231605);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = ai.c(this.Nxi).getLayoutParams();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(231605);
        throw paramValueAnimator;
      }
      paramValueAnimator = (ViewGroup.MarginLayoutParams)paramValueAnimator;
      paramValueAnimator.leftMargin = ((int)f);
      paramValueAnimator.width = ((int)(ai.d(this.Nxi).width() + ai.d(this.Nxi).left - ai.e(this.Nxi) - f));
      ai.c(this.Nxi).setLayoutParams((ViewGroup.LayoutParams)paramValueAnimator);
      AppMethodBeat.o(231605);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$loadingNormalStateSwitch$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-vlog_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean, kotlin.g.a.a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int j = 0;
      AppMethodBeat.i(233794);
      paramAnimator = ai.f(this.Nxi);
      if (paramBoolean)
      {
        i = 8;
        paramAnimator.setVisibility(i);
        paramAnimator = ai.g(this.Nxi);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label47:
        paramAnimator.setVisibility(i);
        paramAnimator = ai.h(this.Nxi);
        if (!paramBoolean) {
          break label155;
        }
      }
      label149:
      label155:
      for (int i = j;; i = 8)
      {
        paramAnimator.setVisibility(i);
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", "end loadingNormalStateSwitch, toLoading:" + paramBoolean);
        paramAnimator = parama;
        if (paramAnimator != null) {
          paramAnimator.invoke();
        }
        if (ai.i(this.Nxi)) {
          this.Nxi.h(ai.j(this.Nxi));
        }
        AppMethodBeat.o(233794);
        return;
        i = 0;
        break;
        i = 8;
        break label47;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(ai paramai, List paramList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(ai paramai, j paramj, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ai
 * JD-Core Version:    0.7.0.1
 */