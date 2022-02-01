package com.tencent.mm.plugin.multitask.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/utils/MultiTaskUtil;", "", "()V", "POSITION_BUTTOM", "", "POSITION_CENTER", "POSITION_NONE", "POSITION_TOP", "TAG", "", "disableMultiTaskTypeInfos", "sCutOutHeight", "Ljava/lang/Integer;", "sHasCutout", "", "Ljava/lang/Boolean;", "checkPositionInView", "view", "Landroid/view/View;", "x", "y", "disableMultiTaskSnapMode", "type", "enableMultiTaskFullScreenMode", "getCutOutHeight", "context", "Landroid/content/Context;", "getMultiTaskSlideFractor", "", "getPositionInView", "getPositionInViewRect", "Landroid/graphics/Rect;", "getVisiablePositionInView", "Lkotlin/Pair;", "hasCutout", "runOnUI", "", "runnable", "Ljava/lang/Runnable;", "plugin-multitask_release"})
public final class c
{
  private static String AgK;
  public static final c AgL;
  private static Boolean oYE;
  private static Integer oYF;
  
  static
  {
    AppMethodBeat.i(200793);
    AgL = new c();
    AppMethodBeat.o(200793);
  }
  
  public static boolean Ss(int paramInt)
  {
    AppMethodBeat.i(200792);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(200792);
      return false;
    }
    if (AgK == null) {}
    try
    {
      AgK = ((b)g.af(b.class)).a(b.a.soX, "");
      Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo: %s", new Object[] { AgK });
      String str = AgK;
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false)))
      {
        Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo ture!!!");
        AppMethodBeat.o(200792);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskUtil", (Throwable)localException, "disableMultiTaskTypeInfo", new Object[0]);
      }
      AppMethodBeat.o(200792);
    }
    return false;
  }
  
  public static final int aP(Context paramContext)
  {
    AppMethodBeat.i(200789);
    if (!ao.aQ(paramContext))
    {
      AppMethodBeat.o(200789);
      return 0;
    }
    if (oYF == null) {
      oYF = Integer.valueOf(aP(paramContext));
    }
    paramContext = oYF;
    if (paramContext != null)
    {
      int i = paramContext.intValue();
      AppMethodBeat.o(200789);
      return i;
    }
    AppMethodBeat.o(200789);
    return 0;
  }
  
  public static final Rect eA(View paramView)
  {
    AppMethodBeat.i(200787);
    if (paramView == null)
    {
      paramView = new Rect();
      AppMethodBeat.o(200787);
      return paramView;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    AppMethodBeat.o(200787);
    return paramView;
  }
  
  public static final boolean eF(Context paramContext)
  {
    AppMethodBeat.i(200788);
    if (oYE == null) {
      oYE = Boolean.valueOf(ao.aQ(paramContext));
    }
    paramContext = oYE;
    if (paramContext != null)
    {
      boolean bool = paramContext.booleanValue();
      AppMethodBeat.o(200788);
      return bool;
    }
    AppMethodBeat.o(200788);
    return false;
  }
  
  public static boolean esD()
  {
    AppMethodBeat.i(200790);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(200790);
      return true;
    }
    boolean bool = ((b)g.af(b.class)).a(b.a.soW, true);
    AppMethodBeat.o(200790);
    return bool;
  }
  
  public static float esE()
  {
    AppMethodBeat.i(200791);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(200791);
      return 1.0F;
    }
    float f = ((b)g.af(b.class)).a(b.a.soZ, 1.0F);
    AppMethodBeat.o(200791);
    return f;
  }
  
  public static String ey(View paramView)
  {
    AppMethodBeat.i(200785);
    if (paramView == null)
    {
      AppMethodBeat.o(200785);
      return "";
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    localObject = ae.SYK;
    paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
    p.g(paramView, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(200785);
    return paramView;
  }
  
  public static o<String, Integer> ez(View paramView)
  {
    AppMethodBeat.i(200786);
    if (paramView == null)
    {
      paramView = new o("", Integer.valueOf(0));
      AppMethodBeat.o(200786);
      return paramView;
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    int m = localObject[0];
    int k = localObject[1];
    int n = paramView.getWidth();
    int i1 = paramView.getHeight();
    int i2 = localRect.height();
    int j = k + i1;
    int i;
    if (localRect.top == 0)
    {
      j = localRect.height() + k;
      if (i1 + k <= j) {
        break label248;
      }
      i = 4;
    }
    for (;;)
    {
      paramView = new Rect(localRect.left + m, k, localRect.left + (m + n), j);
      localObject = ae.SYK;
      paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
      p.g(paramView, "java.lang.String.format(format, *args)");
      paramView = new o(paramView, Integer.valueOf(i));
      AppMethodBeat.o(200786);
      return paramView;
      i = 1;
      k = k + i1 - i2;
      continue;
      label248:
      i = 2;
    }
  }
  
  public static final boolean q(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200784);
    if (paramView == null)
    {
      AppMethodBeat.o(200784);
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    boolean bool = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j).contains(paramInt1, paramInt2);
    AppMethodBeat.o(200784);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.c
 * JD-Core Version:    0.7.0.1
 */