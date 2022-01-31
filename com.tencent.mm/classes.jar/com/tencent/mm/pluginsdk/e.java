package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.s;

public final class e
{
  public static void S(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if ((paramActivity instanceof AppCompatActivity)) {
        ((AppCompatActivity)paramActivity).supportRequestWindowFeature(109);
      }
    }
    else {
      return;
    }
    paramActivity.requestWindowFeature(9);
  }
  
  public static void a(MMFragmentActivity paramMMFragmentActivity, final View paramView)
  {
    if (paramMMFragmentActivity == null) {}
    while ((Build.VERSION.SDK_INT < 16) || (paramMMFragmentActivity.getWindow() == null) || (paramMMFragmentActivity.getWindow().getDecorView() == null)) {
      return;
    }
    paramMMFragmentActivity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        this.rSC.getWindow().getDecorView().setSystemUiVisibility(this.rSC.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
        int i = a.bh(this.rSC);
        y.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(i) });
        if (paramView != null) {
          paramView.setPadding(0, i, 0, 0);
        }
      }
    });
  }
  
  public static void b(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    if (paramMMFragmentActivity == null) {}
    while ((Build.VERSION.SDK_INT < 16) || (paramMMFragmentActivity.getWindow() == null) || (paramMMFragmentActivity.getWindow().getDecorView() == null)) {
      return;
    }
    paramMMFragmentActivity.getWindow().getDecorView().post(new e.3(paramMMFragmentActivity, paramView));
  }
  
  public static int cD(Context paramContext)
  {
    int i = 0;
    Object localObject = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(a.c.actionBarSize, (TypedValue)localObject, true)) {
      i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
    }
    localObject = paramContext.getResources().getDisplayMetrics();
    int j = i;
    if (i <= 0)
    {
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightLand);
      }
    }
    else {
      return j;
    }
    return paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
  }
  
  public static int eK(Context paramContext)
  {
    int i = 0;
    if ((paramContext instanceof MMActivity)) {
      i = ((MMActivity)paramContext).mController.getTitleLocation();
    }
    int j = i;
    if (i <= 0) {
      j = paramContext.getResources().getDimensionPixelSize(a.e.DefaultActionbarHeightPort);
    }
    return j;
  }
  
  public static void k(MMActivity paramMMActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.supportRequestWindowFeature(109);
    }
  }
  
  public static void l(MMActivity paramMMActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.getWindow().getDecorView().post(new e.1(paramMMActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e
 * JD-Core Version:    0.7.0.1
 */