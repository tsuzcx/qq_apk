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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public final class ae
{
  private static Typeface ryh = null;
  
  public static boolean abl(String paramString)
  {
    AppMethodBeat.i(37365);
    if ((paramString != null) && (paramString.length() >= 102400))
    {
      AppMethodBeat.o(37365);
      return true;
    }
    AppMethodBeat.o(37365);
    return false;
  }
  
  public static String abm(String paramString)
  {
    AppMethodBeat.i(37366);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37366);
      return "";
    }
    Object localObject = new com.tencent.mm.vfs.b(com.tencent.mm.loader.j.b.eQw.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = j.p(new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject, System.currentTimeMillis()).dQJ());
      int i = e.b((String)localObject, paramString, paramString.length);
      if (i == 0)
      {
        AppMethodBeat.o(37366);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      ab.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
      AppMethodBeat.o(37366);
    }
    return "";
  }
  
  public static String abn(String paramString)
  {
    AppMethodBeat.i(37367);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37367);
      return "";
    }
    try
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString);
      if (!localb.exists())
      {
        AppMethodBeat.o(37367);
        return "";
      }
      paramString = e.cS(paramString);
      localb.delete();
      AppMethodBeat.o(37367);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
      AppMethodBeat.o(37367);
    }
    return "";
  }
  
  public static void ai(Activity paramActivity)
  {
    AppMethodBeat.i(37361);
    ab.i("LandingPageUtil", "setFullScreen");
    int i = 514;
    if (!af.hW(paramActivity)) {
      i = 1542;
    }
    for (;;)
    {
      int j = i;
      if (Build.VERSION.SDK_INT >= 19) {
        j = i | 0x1000;
      }
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(j);
      AppMethodBeat.o(37361);
      return;
      ab.i("LandingPageUtil", "has cut out");
    }
  }
  
  public static int bb(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static int[] eU(Context paramContext)
  {
    AppMethodBeat.i(37360);
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
      AppMethodBeat.o(37360);
      return new int[] { j, i };
      j = paramContext.getWidth();
    }
  }
  
  public static void eV(Context paramContext)
  {
    AppMethodBeat.i(37362);
    g("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(37362);
  }
  
  public static Typeface eW(Context paramContext)
  {
    AppMethodBeat.i(37364);
    if (ryh == null) {
      ryh = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = ryh;
    AppMethodBeat.o(37364);
    return paramContext;
  }
  
  public static void g(String paramString, Context paramContext)
  {
    AppMethodBeat.i(145327);
    d.R(paramContext).c(new Intent(paramString));
    AppMethodBeat.o(145327);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(37359);
    String str = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
    paramString = "adId" + "_image_" + ag.cE(paramString);
    paramString = str + "/" + paramString;
    if (e.cN(paramString))
    {
      paramString = BackwardSupportUtil.b.k(paramString, 1.0F);
      AppMethodBeat.o(37359);
      return paramString;
    }
    AppMethodBeat.o(37359);
    return null;
  }
  
  public static String m(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(37363);
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
        for (paramVarArgs = paramVarArgs.toString();; paramVarArgs = (String)localObject + "&" + paramVarArgs.toString())
        {
          paramVarArgs = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramVarArgs, localURI.getFragment()).toString();
          AppMethodBeat.o(37363);
          return paramVarArgs;
        }
      }
      return paramString;
    }
    catch (URISyntaxException paramVarArgs)
    {
      ab.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
      AppMethodBeat.o(37363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */