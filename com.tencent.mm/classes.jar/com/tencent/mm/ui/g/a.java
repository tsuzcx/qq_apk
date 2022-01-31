package com.tencent.mm.ui.g;

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

public final class a
{
  private static b vXh;
  private static b vXi;
  
  @TargetApi(11)
  public static void a(Activity paramActivity, View paramView)
  {
    View localView = paramActivity.getWindow().getDecorView();
    vXh = b.hd(paramActivity);
    vXi = b.hd(paramActivity);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Object localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
    int k = arrayOfInt[1];
    vXh.setHeight(k - i - j);
    localObject = new int[2];
    if ((paramActivity instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramActivity).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      localObject[0] = localDisplayMetrics.widthPixels;
      localObject[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      k = localObject[1];
      int m = arrayOfInt[1];
      int n = paramView.getHeight();
      vXi.setHeight(k - m - n);
      vXh.showAtLocation(localView, 48, 0, i + j);
      vXi.showAtLocation(localView, 80, 0, 0);
      return;
      paramActivity = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localObject[0] = paramActivity.getWidth();
      localObject[1] = paramActivity.getHeight();
    }
  }
  
  public static void dismiss()
  {
    if (vXh != null)
    {
      vXh.setAnimationStyle(-1);
      vXh.dismiss();
      vXh = null;
    }
    if (vXi != null)
    {
      vXi.setAnimationStyle(-1);
      vXi.dismiss();
      vXi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.g.a
 * JD-Core Version:    0.7.0.1
 */