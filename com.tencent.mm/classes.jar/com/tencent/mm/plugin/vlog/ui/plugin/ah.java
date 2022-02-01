package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "animator", "Landroid/animation/ValueAnimator;", "beautyEffectIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "beautyLoadingProgress", "Landroid/widget/ProgressBar;", "beautyLoadingTips", "Landroid/widget/TextView;", "container", "Landroid/widget/RelativeLayout;", "isAllImage", "", "isBeautyCheck", "isEnable", "isLoadingStatus", "isNeedSetVisibleRect", "labelRetriever", "Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "loadingWidth", "", "margin", "newVisibleRect", "Landroid/graphics/RectF;", "normalWidth", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "videoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "videoVisibleRect", "cancelRetrieveLabel", "", "enableVideoEnhancement", "hideBeautySwitch", "isBeautyOpened", "loadingNormalStateSwitch", "toLoading", "callback", "Lkotlin/Function0;", "photoEnhancement", "paths", "", "", "enable", "setEnable", "setVideoComposition", "setVisibility", "visibility", "setVisibleRect", "rect", "showBeautySwitch", "switchVideoEnhancement", "switchVideoEnhancementCheckStatus", "videoEnhancement", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a Ukc;
  private final int ALs;
  private RelativeLayout LwF;
  private boolean TZG;
  private final int TZK;
  private RectF Ukd;
  private boolean Uke;
  private RectF Ukf;
  private final int Ukg;
  private final WeImageView Ukh;
  private final ProgressBar Uki;
  private final TextView Ukj;
  public boolean Ukk;
  public com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a Ukl;
  private boolean Ukm;
  private j Ukn;
  private ValueAnimator animator;
  private boolean egk;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(282811);
    Ukc = new a((byte)0);
    AppMethodBeat.o(282811);
  }
  
  public ah(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282689);
    this.parent = paramViewGroup;
    this.Ukd = new RectF();
    this.Ukf = new RectF();
    paramViewGroup = this.parent.findViewById(a.f.preview_decorator_container);
    s.s(paramViewGroup, "parent.findViewById(R.id…view_decorator_container)");
    this.LwF = ((RelativeLayout)paramViewGroup);
    this.TZK = this.parent.getContext().getResources().getDimensionPixelSize(a.d.Edge_4_5_A);
    this.ALs = this.parent.getContext().getResources().getDimensionPixelSize(a.d.Edge_1_5_A);
    this.Ukg = this.parent.getContext().getResources().getDimensionPixelSize(a.d.Edge_14A);
    this.Ukl = new com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a();
    this.egk = true;
    af.mU(this.parent.getContext()).inflate(a.g.editor_video_beauty_view, (ViewGroup)this.LwF, true);
    paramViewGroup = this.LwF.findViewById(a.f.beauty_effect);
    s.s(paramViewGroup, "container.findViewById(R.id.beauty_effect)");
    this.Ukh = ((WeImageView)paramViewGroup);
    paramViewGroup = this.LwF.findViewById(a.f.loading_progress);
    s.s(paramViewGroup, "container.findViewById(R.id.loading_progress)");
    this.Uki = ((ProgressBar)paramViewGroup);
    paramViewGroup = this.LwF.findViewById(a.f.loading_tips);
    s.s(paramViewGroup, "container.findViewById(R.id.loading_tips)");
    this.Ukj = ((TextView)paramViewGroup);
    this.Ukh.setIconColor(-1);
    this.Ukh.setVisibility(8);
    if (a.isEnable())
    {
      this.LwF.setOnClickListener(new ah..ExternalSyntheticLambda1(this));
      FY(false);
    }
    if (!a.isEnable()) {
      this.LwF.setVisibility(8);
    }
    paramViewGroup = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
    if (com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.hTQ())
    {
      paramViewGroup = paramViewGroup.hTO();
      if (paramViewGroup != null)
      {
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.hTL().clear();
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.hTL().putAll((Map)paramViewGroup);
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.hTM();
        AppMethodBeat.o(282689);
      }
    }
    else
    {
      paramViewGroup.hTP();
    }
    AppMethodBeat.o(282689);
  }
  
  private final void FX(boolean paramBoolean)
  {
    AppMethodBeat.i(282698);
    FY(paramBoolean);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.GrC.a(a.c.NQm, (Bundle)localObject);
    this.Ukk = paramBoolean;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      com.tencent.mm.plugin.vlog.model.local.a.hRE();
    }
    AppMethodBeat.o(282698);
  }
  
  private void FY(boolean paramBoolean)
  {
    AppMethodBeat.i(282735);
    this.Ukh.setVisibility(0);
    if (paramBoolean) {
      this.Ukh.setImageDrawable(this.parent.getContext().getDrawable(a.h.icons_filled_cutie_check));
    }
    for (;;)
    {
      this.Ukh.setIconColor(-1);
      AppMethodBeat.o(282735);
      return;
      this.Ukh.setImageDrawable(this.parent.getContext().getDrawable(a.h.icons_filled_cutie));
    }
  }
  
  private static final void a(ah paramah, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(282757);
    s.u(paramah, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramah = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(282757);
      throw paramah;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = paramah.LwF.getLayoutParams();
    if (paramValueAnimator == null)
    {
      paramah = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(282757);
      throw paramah;
    }
    paramValueAnimator = (ViewGroup.MarginLayoutParams)paramValueAnimator;
    paramValueAnimator.leftMargin = ((int)f);
    paramValueAnimator.width = ((int)(paramah.Ukd.width() + paramah.Ukd.left - paramah.ALs - f));
    paramah.LwF.setLayoutParams((ViewGroup.LayoutParams)paramValueAnimator);
    AppMethodBeat.o(282757);
  }
  
  private static final void a(ah paramah, final View paramView)
  {
    AppMethodBeat.i(282745);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramah);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramah, "this$0");
    final boolean bool;
    if (paramah.Ukh.isShown())
    {
      if (paramah.Ukk) {
        break label132;
      }
      bool = true;
      paramah.Ukk = bool;
      if (!paramah.TZG) {
        break label137;
      }
      paramah.J(null, paramah.Ukk);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282745);
      return;
      label132:
      bool = false;
      break;
      label137:
      paramView = paramah.Ukn;
      bool = paramah.Ukk;
      if (!a.isEnable())
      {
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
      }
      else
      {
        if (bool)
        {
          localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
          if ((com.tencent.mm.plugin.vlog.model.local.a.hRx().isEmpty()) && (paramView != null))
          {
            paramah.d(true, (kotlin.g.a.a)new d(paramah, paramView, bool));
            continue;
          }
        }
        paramah.FX(bool);
      }
    }
  }
  
  private final void d(final boolean paramBoolean, final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(282715);
    Log.i("MicroMsg.VideoPreviewDecorationPlugin", s.X("start loadingNormalStateSwitch, toLoading:", Boolean.valueOf(paramBoolean)));
    this.Ukh.setVisibility(8);
    this.Ukj.setVisibility(8);
    this.Uki.setVisibility(8);
    this.Ukm = paramBoolean;
    int i;
    if (paramBoolean)
    {
      i = this.TZK;
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (int j = this.Ukg;; j = this.TZK)
    {
      i = (int)(this.Ukd.width() + this.Ukd.left - i - this.ALs);
      j = (int)(this.Ukd.width() + this.Ukd.left - j - this.ALs);
      ValueAnimator localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.cancel();
      }
      this.animator = ValueAnimator.ofFloat(new float[] { i, j });
      localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener(new ah..ExternalSyntheticLambda0(this));
      }
      localValueAnimator = this.animator;
      if (localValueAnimator != null) {
        localValueAnimator.addListener((Animator.AnimatorListener)new b(this, paramBoolean, parama));
      }
      parama = this.animator;
      if (parama != null) {
        parama.setDuration(300L);
      }
      parama = this.animator;
      if (parama != null) {
        parama.start();
      }
      AppMethodBeat.o(282715);
      return;
      i = this.Ukg;
      break;
    }
  }
  
  public final void J(final List<String> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(282842);
    if (!a.isEnable())
    {
      Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
      AppMethodBeat.o(282842);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      if ((com.tencent.mm.plugin.vlog.model.local.a.hRx().isEmpty()) && (paramList != null))
      {
        d(true, (kotlin.g.a.a)new c(this, paramList, paramBoolean));
        AppMethodBeat.o(282842);
        return;
      }
    }
    FX(paramBoolean);
    AppMethodBeat.o(282842);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(282835);
    s.u(paramj, "videoComposition");
    this.Ukn = paramj;
    AppMethodBeat.o(282835);
  }
  
  public final boolean hTG()
  {
    AppMethodBeat.i(282855);
    if ((this.Ukk) && (a.isEnable()))
    {
      AppMethodBeat.o(282855);
      return true;
    }
    AppMethodBeat.o(282855);
    return false;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(282857);
    this.egk = paramBoolean;
    if (a.isEnable())
    {
      this.LwF.setVisibility(0);
      AppMethodBeat.o(282857);
      return;
    }
    this.LwF.setVisibility(8);
    AppMethodBeat.o(282857);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282863);
    if (a.isEnable()) {
      this.LwF.setVisibility(paramInt);
    }
    AppMethodBeat.o(282863);
  }
  
  public final void setVisibleRect(RectF paramRectF)
  {
    AppMethodBeat.i(282851);
    s.u(paramRectF, "rect");
    Object localObject1 = new StringBuilder("setVisibleRect:").append(paramRectF).append(", animator:");
    Object localObject2 = this.animator;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(", isRunning:");
      localObject1 = this.animator;
      if (localObject1 != null) {
        break label179;
      }
      localObject1 = null;
      label75:
      Log.i("MicroMsg.VideoPreviewDecorationPlugin", localObject1);
      if (this.animator != null)
      {
        localObject1 = this.animator;
        if ((localObject1 == null) || (((ValueAnimator)localObject1).isRunning())) {
          break label190;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        if (!s.p(this.Ukd, paramRectF))
        {
          this.Uke = false;
          this.Ukd.set(paramRectF);
          paramRectF = this.LwF.getLayoutParams();
          if (paramRectF == null)
          {
            paramRectF = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(282851);
            throw paramRectF;
            i = 0;
            break;
            label179:
            localObject1 = Boolean.valueOf(((ValueAnimator)localObject1).isRunning());
            break label75;
            label190:
            i = 0;
            continue;
          }
          paramRectF = (ViewGroup.MarginLayoutParams)paramRectF;
          paramRectF.topMargin = ((int)((int)this.Ukd.top + this.Ukd.height() - this.TZK - this.ALs));
          if (this.Ukm) {}
          for (paramRectF.leftMargin = ((int)(this.Ukd.width() + this.Ukd.left - this.Ukg - this.ALs));; paramRectF.leftMargin = ((int)(this.Ukd.width() + this.Ukd.left - this.TZK - this.ALs)))
          {
            this.LwF.setLayoutParams((ViewGroup.LayoutParams)paramRectF);
            AppMethodBeat.o(282851);
            return;
          }
        }
      }
    }
    this.Uke = true;
    this.Ukf.set(paramRectF);
    AppMethodBeat.o(282851);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$Companion;", "", "()V", "TAG", "", "isEnable", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean isEnable()
    {
      AppMethodBeat.i(282906);
      Object localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      if (com.tencent.mm.plugin.vlog.model.local.a.hRC()) {
        if (!g.NRT.gJF())
        {
          localObject = new StringBuilder();
          d locald = d.XJR;
          localObject = ((StringBuilder)localObject).append(d.iFJ()).append('/');
          locald = d.XJR;
          if (!y.ZC(d.iFO())) {}
        }
        else
        {
          AppMethodBeat.o(282906);
          return true;
        }
      }
      AppMethodBeat.o(282906);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$loadingNormalStateSwitch$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(ah paramah, boolean paramBoolean, kotlin.g.a.a<kotlin.ah> parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int j = 0;
      AppMethodBeat.i(282911);
      paramAnimator = ah.c(this.Uko);
      if (paramBoolean)
      {
        i = 8;
        paramAnimator.setVisibility(i);
        paramAnimator = ah.d(this.Uko);
        if (!paramBoolean) {
          break label142;
        }
        i = 0;
        label47:
        paramAnimator.setVisibility(i);
        paramAnimator = ah.e(this.Uko);
        if (!paramBoolean) {
          break label148;
        }
      }
      label142:
      label148:
      for (int i = j;; i = 8)
      {
        paramAnimator.setVisibility(i);
        Log.i("MicroMsg.VideoPreviewDecorationPlugin", s.X("end loadingNormalStateSwitch, toLoading:", Boolean.valueOf(paramBoolean)));
        paramAnimator = parama;
        if (paramAnimator != null) {
          paramAnimator.invoke();
        }
        if (ah.f(this.Uko)) {
          this.Uko.setVisibleRect(ah.g(this.Uko));
        }
        AppMethodBeat.o(282911);
        return;
        i = 0;
        break;
        i = 8;
        break label47;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(ah paramah, List<String> paramList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(ah paramah, j paramj, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ah
 * JD-Core Version:    0.7.0.1
 */