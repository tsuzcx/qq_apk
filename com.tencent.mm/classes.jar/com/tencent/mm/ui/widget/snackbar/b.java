package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static boolean adzy = false;
  
  public static void NL(boolean paramBoolean)
  {
    adzy = paramBoolean;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(159712);
    paramActivity = new a.a(paramActivity);
    paramActivity.mMessage = paramString1;
    paramActivity.agms = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, null);
    AppMethodBeat.o(159712);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(159715);
    paramActivity = new a.a(paramActivity);
    paramActivity.mMessage = paramString1;
    paramActivity.agms = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, paramc);
    AppMethodBeat.o(159715);
  }
  
  public static void a(Context paramContext, View paramView, String paramString, a.c paramc)
  {
    AppMethodBeat.i(159716);
    paramContext = new a.a(paramContext, paramView);
    paramContext.mMessage = paramString;
    paramContext = paramContext.a(Short.valueOf((short)1500));
    if (paramc != null) {
      paramContext.a(paramc);
    }
    paramContext.jIY();
    AppMethodBeat.o(159716);
  }
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(168815);
    paramContext = new a.a(paramContext, paramView);
    paramContext.mMessage = paramString1;
    paramContext.agms = paramString2;
    a(paramContext.a(Short.valueOf((short)2500)), paramb, null);
    AppMethodBeat.o(168815);
  }
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(159714);
    paramContext = new a.a(paramContext, paramView);
    paramContext.mMessage = paramString1;
    paramContext.agms = paramString2;
    a(paramContext.a(Short.valueOf((short)2500)), paramb, paramc);
    AppMethodBeat.o(159714);
  }
  
  private static void a(a.a parama, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(159718);
    if (paramb != null) {
      parama.a(paramb);
    }
    if (paramc != null) {
      parama.a(paramc);
    }
    parama.jIY();
    AppMethodBeat.o(159718);
  }
  
  public static boolean cvt()
  {
    return adzy;
  }
  
  public static void u(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(159717);
    paramActivity = new a.a(paramActivity);
    paramActivity.mMessage = paramString;
    a(paramActivity.a(Short.valueOf((short)1500)), null, null);
    AppMethodBeat.o(159717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.b
 * JD-Core Version:    0.7.0.1
 */