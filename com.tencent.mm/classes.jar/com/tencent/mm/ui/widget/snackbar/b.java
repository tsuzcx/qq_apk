package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

public final class b
{
  private static boolean wpX = false;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb)
  {
    paramActivity = new a.a(paramActivity);
    paramActivity.ljq = paramString1;
    paramActivity.wpJ = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    paramActivity = new a.a(paramActivity);
    paramActivity.ljq = paramString1;
    paramActivity.wpJ = paramString2;
    a(paramActivity.a(Short.valueOf((short)2500)), paramb, paramc);
  }
  
  public static void a(Context paramContext, View paramView, String paramString, a.c paramc)
  {
    paramContext = new a.a(paramContext, paramView);
    paramContext.ljq = paramString;
    paramContext = paramContext.a(Short.valueOf((short)1500));
    if (paramc != null) {
      paramContext.a(paramc);
    }
    paramContext.cKv();
  }
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2)
  {
    paramContext = new a.a(paramContext, paramView);
    paramContext.ljq = paramString1;
    paramContext.wpJ = paramString2;
    a(paramContext.a(Short.valueOf((short)2500)), null, null);
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, a.b paramb, a.c paramc)
  {
    paramFragment = new a.a(paramFragment.getContext(), paramFragment.getView());
    paramFragment.ljq = paramString1;
    paramFragment.wpJ = paramString2;
    a(paramFragment.a(Short.valueOf((short)2500)), paramb, paramc);
  }
  
  private static void a(a.a parama, a.b paramb, a.c paramc)
  {
    if (paramb != null) {
      parama.wpV.wpP = paramb;
    }
    if (paramc != null) {
      parama.a(paramc);
    }
    parama.cKv();
  }
  
  public static boolean akH()
  {
    return wpX;
  }
  
  public static void h(Activity paramActivity, String paramString)
  {
    paramActivity = new a.a(paramActivity);
    paramActivity.ljq = paramString;
    a(paramActivity.a(Short.valueOf((short)1500)), null, null);
  }
  
  public static void nZ(boolean paramBoolean)
  {
    wpX = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.b
 * JD-Core Version:    0.7.0.1
 */