package com.tencent.mm.plugin.multitask.ui.bg;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomGradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "getBottomGradientBgView", "()Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "dynamicBgSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "getDynamicBgSurfaceView", "()Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "setDynamicBgSurfaceView", "(Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;)V", "value", "gradientBgView", "getGradientBgView", "setGradientBgView", "(Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;)V", "released", "", "getReleased", "()Z", "setReleased", "(Z)V", "activeDynamicBg", "", "pause", "release", "removeDynamicBg", "resume", "setVisibility", "visibility", "shouldFixStatusBar", "stopDynamicBg", "tryFixStatusBar", "updateBgColorConfig", "Companion", "plugin-multitask_release"})
public final class DynamicBgContainer
  extends FrameLayout
{
  public static final DynamicBgContainer.a FKf;
  private static boolean fLS;
  private DynamicBackgroundGLSurfaceView FKc;
  private GradientColorBackgroundView FKd;
  private final GradientColorBackgroundView FKe;
  private boolean released;
  
  static
  {
    AppMethodBeat.i(247766);
    FKf = new DynamicBgContainer.a((byte)0);
    AppMethodBeat.o(247766);
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
    AppMethodBeat.i(247759);
    paramContext = getContext();
    p.j(paramContext, "getContext()");
    this.FKe = new GradientColorBackgroundView(paramContext);
    addView((View)this.FKe, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = (b)h.ae(b.class);
    if (paramContext != null)
    {
      paramContext.giW();
      AppMethodBeat.o(247759);
      return;
    }
    AppMethodBeat.o(247759);
  }
  
  public static boolean fbB()
  {
    AppMethodBeat.i(247749);
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8()))
    {
      AppMethodBeat.o(247749);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      AppMethodBeat.o(247749);
      return true;
    }
    AppMethodBeat.o(247749);
    return false;
  }
  
  private void fbC()
  {
    AppMethodBeat.i(247750);
    Object localObject1 = a.FKj;
    localObject1 = a.a.fbG();
    Object localObject2 = this.FKc;
    if (localObject2 != null) {
      ((DynamicBackgroundGLSurfaceView)localObject2).i(((a)localObject1).jCm, ((a)localObject1).jCn, ((a)localObject1).jCo, ((a)localObject1).jCp, ((a)localObject1).jCq);
    }
    localObject2 = this.FKd;
    if (localObject2 != null) {
      ((GradientColorBackgroundView)localObject2).setColor(((a)localObject1).jCp, ((a)localObject1).jCq);
    }
    localObject2 = this.FKd;
    if (localObject2 != null) {
      ((GradientColorBackgroundView)localObject2).setUpdateMode(1);
    }
    this.FKe.setColor(((a)localObject1).jCp, ((a)localObject1).jCq);
    this.FKe.setUpdateMode(1);
    AppMethodBeat.o(247750);
  }
  
  private void fbD()
  {
    AppMethodBeat.i(247752);
    if (this.FKc != null)
    {
      Log.i("MicroMsg.DynamicBgContainer.", "removed");
      removeView((View)this.FKc);
      this.FKc = null;
    }
    AppMethodBeat.o(247752);
  }
  
  public static final void setIsInMultiWindowMode(boolean paramBoolean)
  {
    fLS = paramBoolean;
  }
  
  public final void fbA()
  {
    AppMethodBeat.i(247748);
    if (!fbB())
    {
      AppMethodBeat.o(247748);
      return;
    }
    setVisibility(4);
    GradientColorBackgroundView localGradientColorBackgroundView = this.FKd;
    if (localGradientColorBackgroundView != null)
    {
      localGradientColorBackgroundView.setVisibility(4);
      AppMethodBeat.o(247748);
      return;
    }
    AppMethodBeat.o(247748);
  }
  
  /* Error */
  public final void fbE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 223
    //   4: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 200
    //   9: ldc 224
    //   11: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 190	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKd	Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +8 -> 28
    //   23: aload_1
    //   24: iconst_0
    //   25: invokevirtual 221	com/tencent/mm/dynamicbackground/view/GradientColorBackgroundView:setVisibility	(I)V
    //   28: aload_0
    //   29: getfield 190	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKd	Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +8 -> 42
    //   37: aload_1
    //   38: fconst_1
    //   39: invokevirtual 228	com/tencent/mm/dynamicbackground/view/GradientColorBackgroundView:setAlpha	(F)V
    //   42: aload_0
    //   43: getfield 168	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKc	Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +96 -> 144
    //   51: ldc 200
    //   53: ldc 230
    //   55: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_1
    //   59: invokevirtual 233	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView:onPause	()V
    //   62: aload_1
    //   63: bipush 8
    //   65: invokevirtual 234	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView:setVisibility	(I)V
    //   68: aload_0
    //   69: getfield 168	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKc	Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +46 -> 120
    //   77: new 236	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer$c
    //   80: dup
    //   81: invokespecial 238	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer$c:<init>	()V
    //   84: checkcast 240	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$c
    //   87: astore_2
    //   88: aload_2
    //   89: ldc 242
    //   91: invokestatic 95	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   94: aload_1
    //   95: getfield 246	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView:jCA	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;
    //   98: new 248	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$d
    //   101: dup
    //   102: aload_1
    //   103: aload_2
    //   104: invokespecial 251	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$d:<init>	(Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$c;)V
    //   107: checkcast 253	java/lang/Runnable
    //   110: invokevirtual 259	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:w	(Ljava/lang/Runnable;)V
    //   113: aload_1
    //   114: getfield 246	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView:jCA	Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j;
    //   117: invokevirtual 262	com/tencent/mm/dynamicbackground/view/GameGLSurfaceView$j:aAZ	()V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 168	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKc	Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;
    //   125: checkcast 115	android/view/View
    //   128: invokevirtual 211	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:removeView	(Landroid/view/View;)V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 168	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKc	Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;
    //   136: ldc 223
    //   138: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: ldc 223
    //   146: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -8 -> 141
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	DynamicBgContainer
    //   18	96	1	localObject1	Object
    //   152	4	1	localObject2	Object
    //   87	17	2	localc	com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.c
    // Exception table:
    //   from	to	target	type
    //   2	19	152	finally
    //   23	28	152	finally
    //   28	33	152	finally
    //   37	42	152	finally
    //   42	47	152	finally
    //   51	73	152	finally
    //   77	120	152	finally
    //   120	141	152	finally
    //   144	149	152	finally
  }
  
  public final void fbF()
  {
    try
    {
      AppMethodBeat.i(247757);
      Log.i("MicroMsg.DynamicBgContainer.", "activeDynamicBg");
      if (this.released) {
        AppMethodBeat.o(247757);
      }
      for (;;)
      {
        return;
        setVisibility(0);
        Object localObject1 = this.FKd;
        if (localObject1 != null) {
          ((GradientColorBackgroundView)localObject1).setVisibility(0);
        }
        localObject1 = this.FKd;
        if (localObject1 != null) {
          ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
        }
        localObject1 = (b)h.ae(b.class);
        if (localObject1 != null) {
          break;
        }
        Log.e("MicroMsg.DynamicBgContainer.", "addDynamicBackgroundView service is null");
        AppMethodBeat.o(247757);
      }
      if (!localObject2.giX()) {
        break label263;
      }
    }
    finally {}
    Object localObject4;
    if (!fLS)
    {
      localObject4 = new ViewGroup.LayoutParams(-1, -1);
      this.FKc = ((DynamicBackgroundGLSurfaceView)localObject2.io(getContext()));
      fbC();
      localObject3 = this.FKc;
      if (localObject3 == null) {
        break label272;
      }
    }
    label263:
    label272:
    for (Object localObject3 = ((DynamicBackgroundGLSurfaceView)localObject3).getParent();; localObject3 = null)
    {
      localObject3 = (DynamicBgContainer)localObject3;
      if (localObject3 != null) {
        ((DynamicBgContainer)localObject3).fbD();
      }
      addView((View)this.FKc, (ViewGroup.LayoutParams)localObject4);
      localObject3 = this.FKc;
      if (localObject3 != null)
      {
        localObject4 = this.FKd;
        if (localObject4 == null) {
          p.iCn();
        }
        ((DynamicBackgroundGLSurfaceView)localObject3).setGradientBackgroundView((View)localObject4);
      }
      localObject3 = this.FKc;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).setShowGradientView(false);
      }
      localObject3 = this.FKc;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).setVisibility(0);
      }
      localObject3 = this.FKc;
      if (localObject3 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject3).onResume();
      }
      Log.i("MicroMsg.DynamicBgContainer.", "virbg: added");
      AppMethodBeat.o(247757);
      break;
    }
  }
  
  public final GradientColorBackgroundView getBottomGradientBgView()
  {
    return this.FKe;
  }
  
  public final DynamicBackgroundGLSurfaceView getDynamicBgSurfaceView()
  {
    return this.FKc;
  }
  
  public final GradientColorBackgroundView getGradientBgView()
  {
    return this.FKd;
  }
  
  public final boolean getReleased()
  {
    return this.released;
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 306
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 200
    //   10: ldc_w 307
    //   13: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 190	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKd	Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +8 -> 30
    //   25: aload_1
    //   26: iconst_0
    //   27: invokevirtual 221	com/tencent/mm/dynamicbackground/view/GradientColorBackgroundView:setVisibility	(I)V
    //   30: aload_0
    //   31: getfield 190	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKd	Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +8 -> 44
    //   39: aload_1
    //   40: fconst_1
    //   41: invokevirtual 228	com/tencent/mm/dynamicbackground/view/GradientColorBackgroundView:setAlpha	(F)V
    //   44: aload_0
    //   45: getfield 168	com/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer:FKc	Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +16 -> 66
    //   53: aload_1
    //   54: invokevirtual 233	com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView:onPause	()V
    //   57: ldc_w 306
    //   60: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: ldc_w 306
    //   69: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -9 -> 63
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	DynamicBgContainer
    //   20	34	1	localObject1	Object
    //   75	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	75	finally
    //   25	30	75	finally
    //   30	35	75	finally
    //   39	44	75	finally
    //   44	49	75	finally
    //   53	63	75	finally
    //   66	72	75	finally
  }
  
  public final void release()
  {
    AppMethodBeat.i(247758);
    Log.i("MicroMsg.DynamicBgContainer.", "release");
    this.released = true;
    fbD();
    AppMethodBeat.o(247758);
  }
  
  public final void resume()
  {
    try
    {
      AppMethodBeat.i(247754);
      Log.i("MicroMsg.DynamicBgContainer.", "resume");
      Object localObject1 = this.FKd;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setVisibility(0);
      }
      localObject1 = this.FKd;
      if (localObject1 != null) {
        ((GradientColorBackgroundView)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.FKc;
      if (localObject1 != null) {
        ((DynamicBackgroundGLSurfaceView)localObject1).onResume();
      }
      postDelayed((Runnable)new b(this), 100L);
      AppMethodBeat.o(247754);
      return;
    }
    finally {}
  }
  
  public final void setDynamicBgSurfaceView(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView)
  {
    this.FKc = paramDynamicBackgroundGLSurfaceView;
  }
  
  public final void setGradientBgView(GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(247746);
    this.FKd = paramGradientColorBackgroundView;
    fbC();
    AppMethodBeat.o(247746);
  }
  
  public final void setReleased(boolean paramBoolean)
  {
    this.released = paramBoolean;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(247751);
    super.setVisibility(paramInt);
    Log.i("MicroMsg.DynamicBgContainer.", "virbg: set visibility ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(247751);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(DynamicBgContainer paramDynamicBgContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(247787);
      Log.i("MicroMsg.DynamicBgContainer.", "hide gradient");
      DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = this.FKg.getDynamicBgSurfaceView();
      if (localDynamicBackgroundGLSurfaceView != null)
      {
        localDynamicBackgroundGLSurfaceView.setShowGradientView(false);
        AppMethodBeat.o(247787);
        return;
      }
      AppMethodBeat.o(247787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer
 * JD-Core Version:    0.7.0.1
 */