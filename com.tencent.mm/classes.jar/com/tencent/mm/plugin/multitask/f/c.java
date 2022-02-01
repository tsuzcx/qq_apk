package com.tencent.mm.plugin.multitask.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/utils/MultiTaskUtil;", "", "()V", "POSITION_BUTTOM", "", "POSITION_CENTER", "POSITION_NONE", "POSITION_TOP", "TAG", "", "disableMultiTaskTypeInfos", "sCutOutHeight", "Ljava/lang/Integer;", "sHasCutout", "", "Ljava/lang/Boolean;", "checkPositionInView", "view", "Landroid/view/View;", "x", "y", "disableMultiTaskSnapMode", "type", "enableMultiTaskFullScreenMode", "getCutOutHeight", "context", "Landroid/content/Context;", "getMultiTaskSlideFractor", "", "getPositionInView", "getPositionInViewRect", "Landroid/graphics/Rect;", "getVisiablePositionInView", "Lkotlin/Pair;", "hasCutout", "runOnUI", "", "runnable", "Ljava/lang/Runnable;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c LIw;
  private static String LIx;
  private static Boolean vlW;
  private static Integer vlX;
  
  static
  {
    AppMethodBeat.i(303769);
    LIw = new c();
    AppMethodBeat.o(303769);
  }
  
  public static boolean ada(int paramInt)
  {
    AppMethodBeat.i(303763);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(303763);
      return false;
    }
    if (LIx == null) {}
    try
    {
      LIx = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuh, "");
      Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo: %s", new Object[] { LIx });
      String str = LIx;
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)s.X("", Integer.valueOf(paramInt)), false)))
      {
        Log.i("MicroMsg.MultiTaskUtil", "disableMultiTaskTypeInfo ture!!!");
        AppMethodBeat.o(303763);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskUtil", (Throwable)localException, "disableMultiTaskTypeInfo", new Object[0]);
      }
      AppMethodBeat.o(303763);
    }
    return false;
  }
  
  public static final int bw(Context paramContext)
  {
    AppMethodBeat.i(303746);
    if (!aw.bx(paramContext))
    {
      AppMethodBeat.o(303746);
      return 0;
    }
    if (vlX == null) {
      vlX = Integer.valueOf(bw(paramContext));
    }
    paramContext = vlX;
    if (paramContext == null)
    {
      AppMethodBeat.o(303746);
      return 0;
    }
    int i = paramContext.intValue();
    AppMethodBeat.o(303746);
    return i;
  }
  
  public static final boolean fD(Context paramContext)
  {
    AppMethodBeat.i(303740);
    if (vlW == null) {
      vlW = Boolean.valueOf(aw.bx(paramContext));
    }
    paramContext = vlW;
    if (paramContext == null)
    {
      AppMethodBeat.o(303740);
      return false;
    }
    boolean bool = paramContext.booleanValue();
    AppMethodBeat.o(303740);
    return bool;
  }
  
  public static boolean glQ()
  {
    AppMethodBeat.i(303754);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(303754);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zug, true);
    AppMethodBeat.o(303754);
    return bool;
  }
  
  public static float glR()
  {
    AppMethodBeat.i(303758);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(303758);
      return 1.0F;
    }
    float f = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuj, 1.0F);
    AppMethodBeat.o(303758);
    return f;
  }
  
  public static String il(View paramView)
  {
    AppMethodBeat.i(303719);
    if (paramView == null)
    {
      AppMethodBeat.o(303719);
      return "";
    }
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    localObject = am.aixg;
    paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
    s.s(paramView, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(303719);
    return paramView;
  }
  
  public static r<String, Integer> im(View paramView)
  {
    AppMethodBeat.i(303729);
    if (paramView == null)
    {
      paramView = new r("", Integer.valueOf(0));
      AppMethodBeat.o(303729);
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
      localObject = am.aixg;
      paramView = String.format("%d,%d,%d,%d", Arrays.copyOf(new Object[] { Integer.valueOf(paramView.left), Integer.valueOf(paramView.top), Integer.valueOf(paramView.right), Integer.valueOf(paramView.bottom) }, 4));
      s.s(paramView, "java.lang.String.format(format, *args)");
      paramView = new r(paramView, Integer.valueOf(i));
      AppMethodBeat.o(303729);
      return paramView;
      i = 1;
      k = k + i1 - i2;
      continue;
      label248:
      i = 2;
    }
  }
  
  public static final Rect in(View paramView)
  {
    AppMethodBeat.i(303733);
    if (paramView == null)
    {
      paramView = new Rect();
      AppMethodBeat.o(303733);
      return paramView;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramView = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    AppMethodBeat.o(303733);
    return paramView;
  }
  
  public static final boolean q(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303714);
    if (paramView == null)
    {
      AppMethodBeat.o(303714);
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    boolean bool = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j).contains(paramInt1, paramInt2);
    AppMethodBeat.o(303714);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.c
 * JD-Core Version:    0.7.0.1
 */