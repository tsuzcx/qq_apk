package com.tencent.mm.plugin.multitask.ui.bg;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sj;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.d;
import com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.j;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomGradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "getBottomGradientBgView", "()Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "dynamicBgSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "getDynamicBgSurfaceView", "()Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "setDynamicBgSurfaceView", "(Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;)V", "value", "gradientBgView", "getGradientBgView", "setGradientBgView", "(Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;)V", "released", "", "getReleased", "()Z", "setReleased", "(Z)V", "activeDynamicBg", "", "pause", "release", "removeDynamicBg", "resume", "setVisibility", "visibility", "shouldFixStatusBar", "stopDynamicBg", "tryFixStatusBar", "updateBgColorConfig", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DynamicBgContainer
  extends FrameLayout
{
  public static final DynamicBgContainer.a LFs;
  private static boolean hRD;
  private DynamicBackgroundGLSurfaceView LFt;
  private GradientColorBackgroundView LFu;
  private final GradientColorBackgroundView LFv;
  private boolean released;
  
  static
  {
    AppMethodBeat.i(304238);
    LFs = new DynamicBgContainer.a((byte)0);
    AppMethodBeat.o(304238);
  }
  
  public DynamicBgContainer(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
    AppMethodBeat.i(304222);
    AppMethodBeat.o(304222);
  }
  
  public DynamicBgContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(304214);
    AppMethodBeat.o(304214);
  }
  
  public DynamicBgContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304182);
    paramContext = getContext();
    s.s(paramContext, "getContext()");
    this.LFv = new GradientColorBackgroundView(paramContext);
    addView((View)this.LFv, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (b)h.ax(b.class);
    if (paramContext != null) {
      paramContext.hCW();
    }
    AppMethodBeat.o(304182);
  }
  
  private static final void a(DynamicBgContainer paramDynamicBgContainer)
  {
    AppMethodBeat.i(304228);
    s.u(paramDynamicBgContainer, "this$0");
    Log.i("MicroMsg.DynamicBgContainer.", "hide gradient");
    paramDynamicBgContainer = paramDynamicBgContainer.getDynamicBgSurfaceView();
    if (paramDynamicBgContainer != null) {
      paramDynamicBgContainer.setShowGradientView(false);
    }
    AppMethodBeat.o(304228);
  }
  
  public static boolean gkF()
  {
    AppMethodBeat.i(304194);
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8()))
    {
      AppMethodBeat.o(304194);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      AppMethodBeat.o(304194);
      return true;
    }
    AppMethodBeat.o(304194);
    return false;
  }
  
  private void gkG()
  {
    AppMethodBeat.i(304202);
    Object localObject1 = a.LFw;
    localObject1 = a.a.gkK();
    Object localObject2 = this.LFt;
    if (localObject2 != null) {
      ((DynamicBackgroundGLSurfaceView)localObject2).j(((a)localObject1).mbZ, ((a)localObject1).mca, ((a)localObject1).mcb, ((a)localObject1).mcd, ((a)localObject1).mce);
    }
    localObject2 = this.LFu;
    if (localObject2 != null) {
      ((GradientColorBackgroundView)localObject2).setColor(((a)localObject1).mcd, ((a)localObject1).mce);
    }
    localObject2 = this.LFu;
    if (localObject2 != null) {
      ((GradientColorBackgroundView)localObject2).setUpdateMode(1);
    }
    this.LFv.setColor(((a)localObject1).mcd, ((a)localObject1).mce);
    this.LFv.setUpdateMode(1);
    AppMethodBeat.o(304202);
  }
  
  private void gkH()
  {
    AppMethodBeat.i(304207);
    if (this.LFt != null)
    {
      Log.i("MicroMsg.DynamicBgContainer.", "removed");
      removeView((View)this.LFt);
      this.LFt = null;
    }
    AppMethodBeat.o(304207);
  }
  
  public static final void setIsInMultiWindowMode(boolean paramBoolean)
  {
    hRD = paramBoolean;
  }
  
  public final GradientColorBackgroundView getBottomGradientBgView()
  {
    return this.LFv;
  }
  
  public final DynamicBackgroundGLSurfaceView getDynamicBgSurfaceView()
  {
    return this.LFt;
  }
  
  public final GradientColorBackgroundView getGradientBgView()
  {
    return this.LFu;
  }
  
  public final boolean getReleased()
  {
    return this.released;
  }
  
  public final void gkE()
  {
    AppMethodBeat.i(304284);
    if (!gkF())
    {
      AppMethodBeat.o(304284);
      return;
    }
    setVisibility(4);
    GradientColorBackgroundView localGradientColorBackgroundView = this.LFu;
    if (localGradientColorBackgroundView != null) {
      localGradientColorBackgroundView.setVisibility(4);
    }
    AppMethodBeat.o(304284);
  }
  
  public final void gkI()
  {
    try
    {
      AppMethodBeat.i(304309);
      Log.i("MicroMsg.DynamicBgContainer.", "stopDynamicBg");
      Object localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setVisibility(0);
      }
      localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.LFt;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.DynamicBgContainer.", "stop dynamicBg");
        ((DynamicBackgroundGLSurfaceView)localObject1).onPause();
        ((DynamicBackgroundGLSurfaceView)localObject1).setVisibility(8);
        localObject1 = getDynamicBgSurfaceView();
        if (localObject1 != null)
        {
          DynamicBackgroundGLSurfaceView.c localc = (DynamicBackgroundGLSurfaceView.c)new b();
          s.t(localc, "l");
          ((DynamicBackgroundGLSurfaceView)localObject1).mco.mcP = ((Runnable)new DynamicBackgroundGLSurfaceView.d((DynamicBackgroundGLSurfaceView)localObject1, localc));
          ((DynamicBackgroundGLSurfaceView)localObject1).mco.aTU();
        }
        removeView((View)getDynamicBgSurfaceView());
        setDynamicBgSurfaceView(null);
      }
      AppMethodBeat.o(304309);
      return;
    }
    finally {}
  }
  
  public final void gkJ()
  {
    try
    {
      AppMethodBeat.i(304314);
      Log.i("MicroMsg.DynamicBgContainer.", "activeDynamicBg");
      if (this.released) {
        AppMethodBeat.o(304314);
      }
      for (;;)
      {
        return;
        new sj().publish();
        setVisibility(0);
        Object localObject1 = this.LFu;
        if (localObject1 != null) {
          ((GradientColorBackgroundView)localObject1).setVisibility(0);
        }
        localObject1 = this.LFu;
        if (localObject1 != null) {
          ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
        }
        localObject1 = (b)h.ax(b.class);
        if (localObject1 != null) {
          break;
        }
        Log.e("MicroMsg.DynamicBgContainer.", "addDynamicBackgroundView service is null");
        AppMethodBeat.o(304314);
      }
      if (!localObject2.hCX()) {
        break label268;
      }
    }
    finally {}
    Object localObject4;
    if (!hRD)
    {
      localObject4 = new ViewGroup.LayoutParams(-1, -1);
      this.LFt = ((DynamicBackgroundGLSurfaceView)localObject2.ke(getContext()));
      gkG();
      localObject3 = this.LFt;
      if (localObject3 != null) {
        break label277;
      }
    }
    label268:
    label277:
    for (Object localObject3 = null;; localObject3 = ((DynamicBackgroundGLSurfaceView)localObject3).getParent())
    {
      localObject3 = (DynamicBgContainer)localObject3;
      if (localObject3 != null) {
        ((DynamicBgContainer)localObject3).gkH();
      }
      addView((View)this.LFt, (ViewGroup.LayoutParams)localObject4);
      localObject3 = this.LFt;
      if (localObject3 != null)
      {
        localObject4 = this.LFu;
        s.checkNotNull(localObject4);
        ((DynamicBackgroundGLSurfaceView)localObject3).setGradientBackgroundView((View)localObject4);
      }
      localObject3 = this.LFt;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).setShowGradientView(false);
      }
      localObject3 = this.LFt;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).setVisibility(0);
      }
      localObject3 = this.LFt;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).onResume();
      }
      Log.i("MicroMsg.DynamicBgContainer.", "virbg: added");
      AppMethodBeat.o(304314);
      break;
    }
  }
  
  public final void pause()
  {
    try
    {
      AppMethodBeat.i(304297);
      Log.i("MicroMsg.DynamicBgContainer.", "pause");
      Object localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setVisibility(0);
      }
      localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.LFt;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).onPause();
      }
      AppMethodBeat.o(304297);
      return;
    }
    finally {}
  }
  
  public final void release()
  {
    AppMethodBeat.i(304319);
    Log.i("MicroMsg.DynamicBgContainer.", "release");
    this.released = true;
    gkH();
    AppMethodBeat.o(304319);
  }
  
  public final void resume()
  {
    try
    {
      AppMethodBeat.i(304301);
      Log.i("MicroMsg.DynamicBgContainer.", "resume");
      Object localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setVisibility(0);
      }
      localObject1 = this.LFu;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.LFt;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).onResume();
      }
      postDelayed(new DynamicBgContainer..ExternalSyntheticLambda0(this), 100L);
      AppMethodBeat.o(304301);
      return;
    }
    finally {}
  }
  
  public final void setDynamicBgSurfaceView(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView)
  {
    this.LFt = paramDynamicBackgroundGLSurfaceView;
  }
  
  public final void setGradientBgView(GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(304275);
    this.LFu = paramGradientColorBackgroundView;
    gkG();
    AppMethodBeat.o(304275);
  }
  
  public final void setReleased(boolean paramBoolean)
  {
    this.released = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(304291);
    super.setVisibility(paramInt);
    Log.i("MicroMsg.DynamicBgContainer.", s.X("virbg: set visibility ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(304291);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer$stopDynamicBg$1$1", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$ReleaseListener;", "finish", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements DynamicBackgroundGLSurfaceView.c
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer
 * JD-Core Version:    0.7.0.1
 */