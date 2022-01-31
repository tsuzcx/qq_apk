package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.d;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public final class ad
{
  private static Typeface oIm = null;
  
  public static void N(Activity paramActivity)
  {
    y.i("LandingPageUtil", "setFullScreen");
    int i = 514;
    if (!ak.gC(paramActivity)) {
      i = 1542;
    }
    for (;;)
    {
      int j = i;
      if (Build.VERSION.SDK_INT >= 19) {
        j = i | 0x1000;
      }
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(j);
      return;
      y.i("LandingPageUtil", "has cut out");
    }
  }
  
  public static void O(Activity paramActivity)
  {
    y.i("LandingPageUtil", "exitFullScreen");
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFF9F9);
  }
  
  public static String Or(String paramString)
  {
    String str;
    if (bk.bl(paramString)) {
      str = "";
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (!paramString.contains("_"));
      arrayOfString = paramString.split("_");
      str = paramString;
    } while (arrayOfString.length <= 0);
    return arrayOfString[(arrayOfString.length - 1)];
  }
  
  public static boolean Os(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 102400);
  }
  
  public static String Ot(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.loader.a.b.dOQ.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
      if (!localb.exists()) {
        localb.mkdirs();
      }
      try
      {
        byte[] arrayOfByte = paramString.getBytes("UTF-8");
        paramString = j.n(new com.tencent.mm.vfs.b(localb, System.currentTimeMillis()).cLr());
        int i = e.b(paramString, arrayOfByte, arrayOfByte.length);
        if (i == 0) {}
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
      }
    }
    return "";
  }
  
  public static String Ou(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString);
      if (!localb.exists()) {
        return "";
      }
      paramString = e.bP(paramString);
      localb.delete();
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
    }
    return "";
  }
  
  public static int aD(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static int[] ed(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint;
    int j;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getRealSize(localPoint);
      j = localPoint.x;
    }
    for (int i = localPoint.y;; i = paramContext.getHeight())
    {
      return new int[] { j, i };
      j = paramContext.getWidth();
    }
  }
  
  public static void ee(Context paramContext)
  {
    d.Q(paramContext).a(new Intent("com.tencent.mm.adlanding.set_uioption"));
  }
  
  public static Typeface ef(Context paramContext)
  {
    if (oIm == null) {
      oIm = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    return oIm;
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    String str = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
    paramString = "adId" + "_image_" + com.tencent.mm.sdk.platformtools.ad.bB(paramString);
    paramString = str + "/" + paramString;
    if (e.bK(paramString)) {
      return BackwardSupportUtil.b.e(paramString, 1.0F);
    }
    return null;
  }
  
  public static String k(String paramString, String... paramVarArgs)
  {
    try
    {
      URI localURI = new URI(paramString);
      Object localObject = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(paramVarArgs[i]).append("&");
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 1)
      {
        paramVarArgs = ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
        localObject = localURI.getQuery();
        if (localObject == null) {}
        for (paramVarArgs = paramVarArgs.toString();; paramVarArgs = (String)localObject + "&" + paramVarArgs.toString()) {
          return new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramVarArgs, localURI.getFragment()).toString();
        }
      }
      return paramString;
    }
    catch (URISyntaxException paramVarArgs)
    {
      y.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */