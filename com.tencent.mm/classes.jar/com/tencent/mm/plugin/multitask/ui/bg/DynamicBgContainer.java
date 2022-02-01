package com.tencent.mm.plugin.multitask.ui.bg;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomGradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "getBottomGradientBgView", "()Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "<set-?>", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "colorConfig", "getColorConfig", "()Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "dynamicBgSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "getDynamicBgSurfaceView", "()Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "setDynamicBgSurfaceView", "(Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;)V", "value", "gradientBgView", "getGradientBgView", "setGradientBgView", "(Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;)V", "activeDynamicBg", "", "removeDynamicBg", "setVisibility", "visibility", "shouldFixStatusBar", "", "stopDynamicBg", "tryFixStatusBar", "updateBgColorConfig", "Companion", "plugin-multitask_release"})
public final class DynamicBgContainer
  extends FrameLayout
{
  public static final DynamicBgContainer.a AdD;
  private a AdA;
  private GradientColorBackgroundView AdB;
  private final GradientColorBackgroundView AdC;
  private DynamicBackgroundGLSurfaceView Adz;
  
  static
  {
    AppMethodBeat.i(200778);
    AdD = new DynamicBgContainer.a((byte)0);
    AppMethodBeat.o(200778);
  }
  
  public DynamicBgContainer(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
  }
  
  public DynamicBgContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public DynamicBgContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200776);
    paramContext = a.AdG;
    this.AdA = a.a.erA();
    paramContext = getContext();
    p.g(paramContext, "getContext()");
    this.AdC = new GradientColorBackgroundView(paramContext);
    addView((View)this.AdC, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (c)com.tencent.mm.kernel.g.af(c.class);
    if (paramContext != null)
    {
      paramContext.fuu();
      AppMethodBeat.o(200776);
      return;
    }
    AppMethodBeat.o(200776);
  }
  
  public static boolean erw()
  {
    AppMethodBeat.i(200771);
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8()))
    {
      AppMethodBeat.o(200771);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      AppMethodBeat.o(200771);
      return true;
    }
    AppMethodBeat.o(200771);
    return false;
  }
  
  public final void erv()
  {
    AppMethodBeat.i(200770);
    if (!erw())
    {
      AppMethodBeat.o(200770);
      return;
    }
    setVisibility(4);
    GradientColorBackgroundView localGradientColorBackgroundView = this.AdB;
    if (localGradientColorBackgroundView != null)
    {
      localGradientColorBackgroundView.setVisibility(4);
      AppMethodBeat.o(200770);
      return;
    }
    AppMethodBeat.o(200770);
  }
  
  public final void erx()
  {
    AppMethodBeat.i(200772);
    Object localObject = a.AdG;
    this.AdA = a.a.erA();
    localObject = this.Adz;
    if (localObject != null) {
      ((DynamicBackgroundGLSurfaceView)localObject).setColor(this.AdA.gRQ, this.AdA.gRR, this.AdA.gRS, this.AdA.gRT, this.AdA.gRU);
    }
    localObject = this.AdB;
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setColor(this.AdA.gRT, this.AdA.gRU);
    }
    localObject = this.AdB;
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setUpdateMode(1);
    }
    this.AdC.setColor(this.AdA.gRT, this.AdA.gRU);
    this.AdC.setUpdateMode(1);
    AppMethodBeat.o(200772);
  }
  
  public final void ery()
  {
    AppMethodBeat.i(200774);
    Object localObject = this.AdB;
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setVisibility(0);
    }
    localObject = this.AdB;
    if (localObject != null) {
      ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
    }
    localObject = this.Adz;
    if (localObject != null)
    {
      Log.i("MicroMsg.DynamicBgContainer", "stop dynamicBg");
      ((DynamicBackgroundGLSurfaceView)localObject).onPause();
      ((DynamicBackgroundGLSurfaceView)localObject).setVisibility(8);
      AppMethodBeat.o(200774);
      return;
    }
    AppMethodBeat.o(200774);
  }
  
  public final void erz()
  {
    AppMethodBeat.i(200775);
    setVisibility(0);
    Object localObject1 = this.AdB;
    if (localObject1 != null) {
      ((GradientColorBackgroundView)localObject1).setVisibility(0);
    }
    localObject1 = this.AdB;
    if (localObject1 != null) {
      ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
    }
    Object localObject2;
    if (this.Adz != null)
    {
      Log.i("MicroMsg.DynamicBgContainer", "re activeDynamicBg");
      localObject1 = this.Adz;
      if (localObject1 != null)
      {
        localObject2 = this.AdB;
        if (localObject2 == null) {
          p.hyc();
        }
        ((DynamicBackgroundGLSurfaceView)localObject1).setGradientBackgroundView((View)localObject2);
      }
      localObject1 = this.Adz;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).setShowGradientView(false);
      }
      localObject1 = this.Adz;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).setVisibility(0);
      }
      localObject1 = this.Adz;
      if (localObject1 != null)
      {
        ((DynamicBackgroundGLSurfaceView)localObject1).onResume();
        AppMethodBeat.o(200775);
        return;
      }
      AppMethodBeat.o(200775);
      return;
    }
    localObject1 = (c)com.tencent.mm.kernel.g.af(c.class);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.DynamicBgContainer", "addDynamicBackgroundView service is null");
      AppMethodBeat.o(200775);
      return;
    }
    if (((c)localObject1).fuv())
    {
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      this.Adz = ((DynamicBackgroundGLSurfaceView)((c)localObject1).ho(getContext()));
      localObject1 = this.Adz;
      if (localObject1 == null) {
        break label346;
      }
    }
    label346:
    for (localObject1 = ((DynamicBackgroundGLSurfaceView)localObject1).getParent();; localObject1 = null)
    {
      localObject1 = (DynamicBgContainer)localObject1;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.DynamicBgContainer", "removed");
        if (((DynamicBgContainer)localObject1).Adz != null)
        {
          ((DynamicBgContainer)localObject1).removeView((View)((DynamicBgContainer)localObject1).Adz);
          ((DynamicBgContainer)localObject1).Adz = null;
        }
      }
      addView((View)this.Adz, (ViewGroup.LayoutParams)localObject2);
      localObject1 = this.Adz;
      if (localObject1 != null)
      {
        localObject2 = this.AdB;
        if (localObject2 == null) {
          p.hyc();
        }
        ((DynamicBackgroundGLSurfaceView)localObject1).setGradientBackgroundView((View)localObject2);
      }
      localObject1 = this.Adz;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).setShowGradientView(false);
      }
      localObject1 = this.Adz;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).setVisibility(0);
      }
      localObject1 = this.Adz;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).onResume();
      }
      Log.i("MicroMsg.DynamicBgContainer", "virbg: added");
      AppMethodBeat.o(200775);
      return;
    }
  }
  
  public final GradientColorBackgroundView getBottomGradientBgView()
  {
    return this.AdC;
  }
  
  public final a getColorConfig()
  {
    return this.AdA;
  }
  
  public final DynamicBackgroundGLSurfaceView getDynamicBgSurfaceView()
  {
    return this.Adz;
  }
  
  public final GradientColorBackgroundView getGradientBgView()
  {
    return this.AdB;
  }
  
  public final void setDynamicBgSurfaceView(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView)
  {
    this.Adz = paramDynamicBackgroundGLSurfaceView;
  }
  
  public final void setGradientBgView(GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(200769);
    this.AdB = paramGradientColorBackgroundView;
    erx();
    AppMethodBeat.o(200769);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200773);
    super.setVisibility(paramInt);
    Log.i("MicroMsg.DynamicBgContainer", "virbg: set visibility ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(200773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer
 * JD-Core Version:    0.7.0.1
 */