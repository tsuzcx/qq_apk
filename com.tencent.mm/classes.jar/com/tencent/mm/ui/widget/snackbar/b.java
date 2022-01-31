package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static boolean AKA = false;
  
  public static boolean Pk()
  {
    return AKA;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(112984);
    paramActivity = new a.a(paramActivity);
    paramActivity.nGF = paramString1;
    paramActivity.AKn = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, null);
    AppMethodBeat.o(112984);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(112986);
    paramActivity = new a.a(paramActivity);
    paramActivity.nGF = paramString1;
    paramActivity.AKn = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, paramc);
    AppMethodBeat.o(112986);
  }
  
  public static void a(Context paramContext, View paramView, String paramString, a.c paramc)
  {
    AppMethodBeat.i(112988);
    paramContext = new a.a(paramContext, paramView);
    paramContext.nGF = paramString;
    paramContext = paramContext.a(Short.valueOf((short)1500));
    if (paramc != null) {
      paramContext.a(paramc);
    }
    paramContext.dPA();
    AppMethodBeat.o(112988);
  }
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112985);
    paramContext = new a.a(paramContext, paramView);
    paramContext.nGF = paramString1;
    paramContext.AKn = paramString2;
    a(paramContext.a(Short.valueOf((short)2500)), null, null);
    AppMethodBeat.o(112985);
  }
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(139662);
    paramContext = new a.a(paramContext, paramView);
    paramContext.nGF = paramString1;
    paramContext.AKn = paramString2;
    a(paramContext.a(Short.valueOf((short)2500)), paramb, paramc);
    AppMethodBeat.o(139662);
  }
  
  private static void a(a.a parama, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(112990);
    if (paramb != null) {
      parama.a(paramb);
    }
    if (paramc != null) {
      parama.a(paramc);
    }
    parama.dPA();
    AppMethodBeat.o(112990);
  }
  
  public static void l(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(112989);
    paramActivity = new a.a(paramActivity);
    paramActivity.nGF = paramString;
    a(paramActivity.a(Short.valueOf((short)1500)), null, null);
    AppMethodBeat.o(112989);
  }
  
  public static void rJ(boolean paramBoolean)
  {
    AKA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.b
 * JD-Core Version:    0.7.0.1
 */