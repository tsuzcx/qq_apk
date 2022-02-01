package com.tencent.mm.ui.i;

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
  private static b QkV;
  private static b QkW;
  
  @TargetApi(11)
  public static void c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(142857);
    View localView = paramActivity.getWindow().getDecorView();
    QkV = b.kz(paramActivity);
    QkW = b.kz(paramActivity);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
    int k = arrayOfInt[1];
    QkV.setHeight(k - i - j);
    k = getScreenWH(paramActivity)[1];
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    QkW.setHeight(k - m - n);
    QkV.showAtLocation(localView, 48, 0, j + i);
    QkW.showAtLocation(localView, 80, 0, 0);
    AppMethodBeat.o(142857);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(142858);
    if (QkV != null)
    {
      QkV.setAnimationStyle(-1);
      QkV.dismiss();
      QkV = null;
    }
    if (QkW != null)
    {
      QkW.setAnimationStyle(-1);
      QkW.dismiss();
      QkW = null;
    }
    AppMethodBeat.o(142858);
  }
  
  private static int[] getScreenWH(Context paramContext)
  {
    AppMethodBeat.i(142859);
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
      AppMethodBeat.o(142859);
      return arrayOfInt;
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = paramContext.getWidth();
      arrayOfInt[1] = paramContext.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.i.a
 * JD-Core Version:    0.7.0.1
 */