package com.tencent.mm.sdk.vendor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import java.lang.reflect.Method;

public class Meizu
{
  private static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(175933);
    int i = n.D(paramContext, 0);
    AppMethodBeat.o(175933);
    return i;
  }
  
  public static boolean hasSmartBar()
  {
    AppMethodBeat.i(153481);
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      AppMethodBeat.o(153481);
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2"))
      {
        AppMethodBeat.o(153481);
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
      {
        AppMethodBeat.o(153481);
        return false;
      }
      AppMethodBeat.o(153481);
    }
    return false;
  }
  
  public static void hideMeizuSmartBar(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(214375);
    if (!hasSmartBar())
    {
      AppMethodBeat.o(214375);
      return;
    }
    if (paramActivity.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(214375);
      return;
    }
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().addFlags(2048);
    paramView.setPadding(0, getStatusBarHeight(paramActivity), 0, 0);
    AppMethodBeat.o(214375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Meizu
 * JD-Core Version:    0.7.0.1
 */