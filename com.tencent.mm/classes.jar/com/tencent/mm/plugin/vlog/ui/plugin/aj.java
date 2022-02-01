package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;)V", "animator", "Landroid/animation/ValueAnimator;", "beautyEffectIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "beautyLoadingProgress", "Landroid/widget/ProgressBar;", "beautyLoadingTips", "Landroid/widget/TextView;", "container", "Landroid/widget/RelativeLayout;", "isBeautyCheck", "", "isEnable", "isLoadingStatus", "isNeedSetVisibleRect", "labelRetriever", "Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "loadingWidth", "", "margin", "getMultiMedia", "()Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "newVisibleRect", "Landroid/graphics/RectF;", "normalWidth", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoVisibleRect", "cancelRetrieveLabel", "", "hideBeautySwitch", "isBeautyOpened", "loadingNormalStateSwitch", "toLoading", "callback", "Lkotlin/Function0;", "setEnable", "enable", "setVisibility", "visibility", "setVisibleRect", "rect", "showBeautySwitch", "switchVideoEnhancement", "isAllImage", "switchVideoEnhancementCheckStatus", "Companion", "plugin-vlog_release"})
public final class aj
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final aj.a GJP;
  final v GDT;
  private RectF GJE;
  private boolean GJF;
  private RectF GJG;
  private RelativeLayout GJH;
  private final int GJI;
  private final WeImageView GJJ;
  private final ProgressBar GJK;
  private final TextView GJL;
  private boolean GJM;
  public com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a GJN;
  private boolean GJO;
  private final int GyC;
  private ValueAnimator animator;
  private boolean ded;
  private ViewGroup parent;
  private final int vXu;
  private d wgr;
  
  static
  {
    AppMethodBeat.i(191595);
    GJP = new aj.a((byte)0);
    AppMethodBeat.o(191595);
  }
  
  public aj(ViewGroup paramViewGroup, d paramd, v paramv)
  {
    AppMethodBeat.i(191594);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.GDT = paramv;
    this.GJE = new RectF();
    this.GJG = new RectF();
    paramViewGroup = this.parent.findViewById(2131306108);
    p.g(paramViewGroup, "parent.findViewById(R.id…view_decorator_container)");
    this.GJH = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.getContext();
    p.g(paramViewGroup, "parent.context");
    this.GyC = paramViewGroup.getResources().getDimensionPixelSize(2131165304);
    paramViewGroup = this.parent.getContext();
    p.g(paramViewGroup, "parent.context");
    this.vXu = paramViewGroup.getResources().getDimensionPixelSize(2131165289);
    paramViewGroup = this.parent.getContext();
    p.g(paramViewGroup, "parent.context");
    this.GJI = paramViewGroup.getResources().getDimensionPixelSize(2131165283);
    this.GJN = new com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a();
    this.ded = true;
    aa.jQ(this.parent.getContext()).inflate(2131493898, (ViewGroup)this.GJH, true);
    paramViewGroup = this.GJH.findViewById(2131297342);
    p.g(paramViewGroup, "container.findViewById(R.id.beauty_effect)");
    this.GJJ = ((WeImageView)paramViewGroup);
    paramViewGroup = this.GJH.findViewById(2131303711);
    p.g(paramViewGroup, "container.findViewById(R.id.loading_progress)");
    this.GJK = ((ProgressBar)paramViewGroup);
    paramViewGroup = this.GJH.findViewById(2131303715);
    p.g(paramViewGroup, "container.findViewById(R.id.loading_tips)");
    this.GJL = ((TextView)paramViewGroup);
    this.GJJ.setIconColor(-1);
    this.GJJ.setVisibility(8);
    if (aj.a.isEnable()) {
      this.GJH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(191577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (aj.f(this.GJQ).isShown())
          {
            paramAnonymousView = this.GJQ;
            if (aj.k(this.GJQ)) {
              break label101;
            }
          }
          label101:
          for (boolean bool = true;; bool = false)
          {
            aj.c(paramAnonymousView, bool);
            aj.a(this.GJQ, aj.k(this.GJQ));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191577);
            return;
          }
        }
      });
    }
    if (!aj.a.isEnable()) {
      this.GJH.setVisibility(8);
    }
    com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
    AppMethodBeat.o(191594);
  }
  
  private final void c(final boolean paramBoolean, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(191587);
    Log.i("MicroMsg.VideoPreviewDecorationPlugin", "start loadingNormalStateSwitch, toLoading:".concat(String.valueOf(paramBoolean)));
    this.GJJ.setVisibility(8);
    this.GJL.setVisibility(8);
    this.GJK.setVisibility(8);
    this.GJO = paramBoolean;
    int i;
    if (paramBoolean)
    {
      i = this.GyC;
      if (!paramBoolean) {
        break label265;
      }
    }
    label265:
    for (int j = this.GJI;; j = this.GyC)
    {
      i = (int)(this.GJE.width() + this.GJE.left - i - this.vXu);
      j = (int)(this.GJE.width() + this.GJE.left - j - this.vXu);
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
      AppMethodBeat.o(191587);
      return;
      i = this.GJI;
      break;
    }
    label274:
    AppMethodBeat.o(191587);
  }
  
  private final void wK(boolean paramBoolean)
  {
    AppMethodBeat.i(191586);
    wL(paramBoolean);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.wgr.a(d.c.BWU, (Bundle)localObject);
    this.GJM = paramBoolean;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      com.tencent.mm.plugin.vlog.model.local.a.fBY();
    }
    AppMethodBeat.o(191586);
  }
  
  private void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(191590);
    this.GJJ.setVisibility(0);
    if (paramBoolean) {
      this.GJJ.setImageDrawable(this.parent.getContext().getDrawable(2131690528));
    }
    for (;;)
    {
      this.GJJ.setIconColor(-1);
      AppMethodBeat.o(191590);
      return;
      this.GJJ.setImageDrawable(this.parent.getContext().getDrawable(2131690527));
    }
  }
  
  public final void aB(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(191584);
    if (!aj.a.isEnable())
    {
      Log.i("MicroMsg.VideoPreviewDecorationPlugin", "not enable video enhancement, ignore this request");
      AppMethodBeat.o(191584);
      return;
    }
    Log.i("MicroMsg.VideoPreviewDecorationPlugin", "switchVideoEnhancement:".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      if (com.tencent.mm.plugin.vlog.model.local.a.fBS().isEmpty())
      {
        c(true, (kotlin.g.a.a)new d(this, paramBoolean2, paramBoolean1));
        AppMethodBeat.o(191584);
        return;
      }
    }
    wK(paramBoolean1);
    AppMethodBeat.o(191584);
  }
  
  public final void aSs() {}
  
  public final boolean fDS()
  {
    AppMethodBeat.i(191591);
    if ((this.GJM) && (aj.a.isEnable()))
    {
      AppMethodBeat.o(191591);
      return true;
    }
    AppMethodBeat.o(191591);
    return false;
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(191589);
    p.h(paramRectF, "rect");
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
      if (!(p.j(this.GJE, paramRectF) ^ true)) {
        break label317;
      }
      this.GJF = false;
      this.GJE.set(paramRectF);
      paramRectF = this.GJH.getLayoutParams();
      if (paramRectF != null) {
        break label186;
      }
      paramRectF = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(191589);
      throw paramRectF;
      i = 0;
      break;
    }
    label186:
    paramRectF = (ViewGroup.MarginLayoutParams)paramRectF;
    paramRectF.topMargin = ((int)((int)this.GJE.top + this.GJE.height() - this.GyC - this.vXu));
    if (this.GJO) {}
    for (paramRectF.leftMargin = ((int)(this.GJE.width() + this.GJE.left - this.GJI - this.vXu));; paramRectF.leftMargin = ((int)(this.GJE.width() + this.GJE.left - this.GyC - this.vXu)))
    {
      this.GJH.setLayoutParams((ViewGroup.LayoutParams)paramRectF);
      AppMethodBeat.o(191589);
      return;
    }
    label317:
    this.GJF = true;
    this.GJG.set(paramRectF);
    AppMethodBeat.o(191589);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191596);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191596);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(191592);
    this.ded = paramBoolean;
    if (aj.a.isEnable())
    {
      this.GJH.setVisibility(0);
      AppMethodBeat.o(191592);
      return;
    }
    this.GJH.setVisibility(8);
    AppMethodBeat.o(191592);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191593);
    if (aj.a.isEnable()) {
      this.GJH.setVisibility(paramInt);
    }
    AppMethodBeat.o(191593);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(aj paramaj) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(191579);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(191579);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = aj.c(this.GJQ).getLayoutParams();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(191579);
        throw paramValueAnimator;
      }
      paramValueAnimator = (ViewGroup.MarginLayoutParams)paramValueAnimator;
      paramValueAnimator.leftMargin = ((int)f);
      paramValueAnimator.width = ((int)(aj.d(this.GJQ).width() + aj.d(this.GJQ).left - aj.e(this.GJQ) - f));
      aj.c(this.GJQ).setLayoutParams((ViewGroup.LayoutParams)paramValueAnimator);
      AppMethodBeat.o(191579);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/VideoEnhancementPlugin$loadingNormalStateSwitch$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-vlog_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean, kotlin.g.a.a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int j = 0;
      AppMethodBeat.i(191580);
      paramAnimator = aj.f(this.GJQ);
      if (paramBoolean)
      {
        i = 8;
        paramAnimator.setVisibility(i);
        paramAnimator = aj.g(this.GJQ);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label47:
        paramAnimator.setVisibility(i);
        paramAnimator = aj.h(this.GJQ);
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
        if (aj.i(this.GJQ)) {
          this.GJQ.h(aj.j(this.GJQ));
        }
        AppMethodBeat.o(191580);
        return;
        i = 0;
        break;
        i = 8;
        break label47;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(aj paramaj, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.aj
 * JD-Core Version:    0.7.0.1
 */