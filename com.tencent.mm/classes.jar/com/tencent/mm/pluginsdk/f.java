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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

public final class f
{
  public static void a(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    AppMethodBeat.i(105831);
    if (paramMMFragmentActivity == null)
    {
      AppMethodBeat.o(105831);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramMMFragmentActivity.getWindow() != null) && (paramMMFragmentActivity.getWindow().getDecorView() != null)) {
      paramMMFragmentActivity.getWindow().getDecorView().post(new f.2(paramMMFragmentActivity, paramView));
    }
    AppMethodBeat.o(105831);
  }
  
  public static void ao(Activity paramActivity)
  {
    AppMethodBeat.i(105828);
    if (Build.VERSION.SDK_INT >= 16)
    {
      if ((paramActivity instanceof AppCompatActivity))
      {
        ((AppCompatActivity)paramActivity).supportRequestWindowFeature(109);
        AppMethodBeat.o(105828);
        return;
      }
      paramActivity.requestWindowFeature(9);
    }
    AppMethodBeat.o(105828);
  }
  
  public static void b(MMFragmentActivity paramMMFragmentActivity, View paramView)
  {
    AppMethodBeat.i(105832);
    if (paramMMFragmentActivity == null)
    {
      AppMethodBeat.o(105832);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (paramMMFragmentActivity.getWindow() != null) && (paramMMFragmentActivity.getWindow().getDecorView() != null)) {
      paramMMFragmentActivity.getWindow().getDecorView().post(new f.3(paramMMFragmentActivity, paramView));
    }
    AppMethodBeat.o(105832);
  }
  
  public static int di(Context paramContext)
  {
    AppMethodBeat.i(105833);
    int i = 0;
    Object localObject = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(2130772143, (TypedValue)localObject, true)) {
      i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramContext.getResources().getDisplayMetrics());
    }
    localObject = paramContext.getResources().getDisplayMetrics();
    int j = i;
    if (i <= 0) {
      if (((DisplayMetrics)localObject).widthPixels <= ((DisplayMetrics)localObject).heightPixels) {
        break label86;
      }
    }
    label86:
    for (j = paramContext.getResources().getDimensionPixelSize(2131427558);; j = paramContext.getResources().getDimensionPixelSize(2131427559))
    {
      AppMethodBeat.o(105833);
      return j;
    }
  }
  
  public static int fK(Context paramContext)
  {
    AppMethodBeat.i(105827);
    int i = 0;
    if ((paramContext instanceof MMActivity)) {
      i = ((MMActivity)paramContext).getTitleLocation();
    }
    int j = i;
    if (i <= 0) {
      j = paramContext.getResources().getDimensionPixelSize(2131427559);
    }
    AppMethodBeat.o(105827);
    return j;
  }
  
  public static void m(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(105829);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.supportRequestWindowFeature(109);
    }
    AppMethodBeat.o(105829);
  }
  
  public static void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(105830);
    WeakReference localWeakReference = new WeakReference(paramMMActivity);
    if (Build.VERSION.SDK_INT >= 16) {
      paramMMActivity.getWindow().getDecorView().post(new f.1(localWeakReference));
    }
    AppMethodBeat.o(105830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f
 * JD-Core Version:    0.7.0.1
 */