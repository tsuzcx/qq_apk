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
  private static b IKe;
  private static b IKf;
  
  @TargetApi(11)
  public static void b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(142857);
    View localView = paramActivity.getWindow().getDecorView();
    IKe = b.km(paramActivity);
    IKf = b.km(paramActivity);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
    int k = arrayOfInt[1];
    IKe.setHeight(k - i - j);
    k = eB(paramActivity)[1];
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    IKf.setHeight(k - m - n);
    IKe.showAtLocation(localView, 48, 0, j + i);
    IKf.showAtLocation(localView, 80, 0, 0);
    AppMethodBeat.o(142857);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(142858);
    if (IKe != null)
    {
      IKe.setAnimationStyle(-1);
      IKe.dismiss();
      IKe = null;
    }
    if (IKf != null)
    {
      IKf.setAnimationStyle(-1);
      IKf.dismiss();
      IKf = null;
    }
    AppMethodBeat.o(142858);
  }
  
  private static int[] eB(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.a
 * JD-Core Version:    0.7.0.1
 */