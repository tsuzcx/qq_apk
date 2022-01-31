package com.tencent.mm.ui.h;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b App;
  private static b Apq;
  
  @TargetApi(11)
  public static void b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107423);
    View localView = paramActivity.getWindow().getDecorView();
    App = b.iz(paramActivity);
    Apq = b.iz(paramActivity);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
    int k = arrayOfInt[1];
    App.setHeight(k - i - j);
    k = dh(paramActivity)[1];
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    Apq.setHeight(k - m - n);
    App.showAtLocation(localView, 48, 0, j + i);
    Apq.showAtLocation(localView, 80, 0, 0);
    AppMethodBeat.o(107423);
  }
  
  private static int[] dh(Context paramContext)
  {
    AppMethodBeat.i(107425);
    int[] arrayOfInt = new int[2];
    if ((paramContext instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      AppMethodBeat.o(107425);
      return arrayOfInt;
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = paramContext.getWidth();
      arrayOfInt[1] = paramContext.getHeight();
    }
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(107424);
    if (App != null)
    {
      App.setAnimationStyle(-1);
      App.dismiss();
      App = null;
    }
    if (Apq != null)
    {
      Apq.setAnimationStyle(-1);
      Apq.dismiss();
      Apq = null;
    }
    AppMethodBeat.o(107424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.a
 * JD-Core Version:    0.7.0.1
 */