package com.tencent.mm.plugin.multitask.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/utils/MultiTaskUtil;", "", "()V", "POSITION_BUTTOM", "", "POSITION_CENTER", "POSITION_NONE", "POSITION_TOP", "TAG", "", "disableMultiTaskTypeInfos", "sCutOutHeight", "Ljava/lang/Integer;", "sHasCutout", "", "Ljava/lang/Boolean;", "checkPositionInView", "view", "Landroid/view/View;", "x", "y", "disableMultiTaskSnapMode", "type", "enableMultiTaskFullScreenMode", "getCutOutHeight", "context", "Landroid/content/Context;", "getMultiTaskSlideFractor", "", "getPositionInView", "getPositionInViewRect", "Landroid/graphics/Rect;", "getVisiablePositionInView", "Lkotlin/Pair;", "hasCutout", "runOnUI", "", "runnable", "Ljava/lang/Runnable;", "plugin-multitask_release"})
public final class c
{
  private static String FNA;
  public static final c FNB;
  private static Boolean saF;
  private static Integer saG;
  
  static
  {
    AppMethodBeat.i(247785);
    FNB = new c();
    AppMethodBeat.o(247785);
  }
  
  public static boolean YO(int paramInt)
  {
    AppMethodBeat.i(247784);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(247784);
      return false;
    }
    if (FNA == null) {}
    try
    {
      FNA = ((b)h.ae(b.class)).a(b.a.waG, "");
      Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo: %s", new Object[] { FNA });
      String str = FNA;
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false)))
      {
        Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo ture!!!");
        AppMethodBeat.o(247784);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskUtil", (Throwable)localException, "disableMultiTaskTypeInfo", new Object[0]);
      }
      AppMethodBeat.o(247784);
    }
    return false;
  }
  
  public static final int aM(Context paramContext)
  {
    AppMethodBeat.i(247780);
    if (!ar.aN(paramContext))
    {
      AppMethodBeat.o(247780);
      return 0;
    }
    if (saG == null) {
      saG = Integer.valueOf(aM(paramContext));
    }
    paramContext = saG;
    if (paramContext != null)
    {
      int i = paramContext.intValue();
      AppMethodBeat.o(247780);
      return i;
    }
    AppMethodBeat.o(247780);
    return 0;
  }
  
  public static final boolean eI(Context paramContext)
  {
    AppMethodBeat.i(247779);
    if (saF == null) {
      saF = Boolean.valueOf(ar.aN(paramContext));
    }
    paramContext = saF;
    if (paramContext != null)
    {
      boolean bool = paramContext.booleanValue();
      AppMethodBeat.o(247779);
      return bool;
    }
    AppMethodBeat.o(247779);
    return false;
  }
  
  public static final Rect fA(View paramView)
  {
    AppMethodBeat.i(247778);
    if (paramView == null)
    {
      paramView = new Rect();
      AppMethodBeat.o(247778);
      return paramView;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    AppMethodBeat.o(247778);
    return paramView;
  }
  
  public static boolean fcN()
  {
    AppMethodBeat.i(247781);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(247781);
      return true;
    }
    boolean bool = ((b)h.ae(b.class)).a(b.a.waF, true);
    AppMethodBeat.o(247781);
    return bool;
  }
  
  public static float fcO()
  {
    AppMethodBeat.i(247782);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(247782);
      return 1.0F;
    }
    float f = ((b)h.ae(b.class)).a(b.a.waI, 1.0F);
    AppMethodBeat.o(247782);
    return f;
  }
  
  public static String fy(View paramView)
  {
    AppMethodBeat.i(247776);
    if (paramView == null)
    {
      AppMethodBeat.o(247776);
      return "";
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    localObject = af.aaBG;
    paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
    p.j(paramView, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(247776);
    return paramView;
  }
  
  public static o<String, Integer> fz(View paramView)
  {
    AppMethodBeat.i(247777);
    if (paramView == null)
    {
      paramView = new o("", Integer.valueOf(0));
      AppMethodBeat.o(247777);
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
      localObject = af.aaBG;
      paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
      p.j(paramView, "java.lang.String.format(format, *args)");
      paramView = new o(paramView, Integer.valueOf(i));
      AppMethodBeat.o(247777);
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
    AppMethodBeat.i(247775);
    if (paramView == null)
    {
      AppMethodBeat.o(247775);
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    boolean bool = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j).contains(paramInt1, paramInt2);
    AppMethodBeat.o(247775);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.c
 * JD-Core Version:    0.7.0.1
 */