package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class am
{
  private static Typeface zHK = null;
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final com.tencent.mm.pluginsdk.model.app.al paramal, final int paramInt)
  {
    AppMethodBeat.i(198088);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(198088);
      return false;
    }
    if (paramIntent != null) {
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198081);
          List localList = am.ac(this.val$context, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(this.val$context, paramIntent, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(198080);
                if (!paramAnonymous2Boolean1) {
                  am.gl(am.1.this.val$context);
                }
                if (am.1.this.zHM != null) {
                  am.1.this.zHM.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(198080);
              }
            }, null);
          }
          AppMethodBeat.o(198081);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(198088);
      return true;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        paramString2.addFlags(268435456);
        paramString1 = ac(paramContext, paramString2);
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if ((TextUtils.isEmpty(paramString2.getPackage())) && (paramString1.size() == 1)) {}
          for (paramString1 = h.b((ResolveInfo)paramString1.get(0));; paramString1 = paramString2.getPackage())
          {
            if (bt.nullAsNil(aj.getPackageName()).equals(paramString1)) {
              break label179;
            }
            a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198083);
                h.a(this.val$context, paramString2, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(198082);
                    if (!paramAnonymous2Boolean1) {
                      am.gl(am.2.this.val$context);
                    }
                    if (am.2.this.zHM != null) {
                      am.2.this.zHM.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(198082);
                  }
                }, null);
                AppMethodBeat.o(198083);
              }
            });
            break;
          }
        }
      }
      else
      {
        label179:
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198085);
            Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(this.val$context, localIntent, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(198084);
                if (!paramAnonymous2Boolean1) {
                  am.gl(am.3.this.val$context);
                }
                if (am.3.this.zHM != null) {
                  am.3.this.zHM.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(198084);
              }
            }, null);
            AppMethodBeat.o(198085);
          }
        });
      }
    }
  }
  
  public static void aF(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = com.tencent.mm.ui.al.aG(paramActivity);
    ad.i("LandingPageUtil", "setFullScreen, hasCut=".concat(String.valueOf(bool)));
    int i = 514;
    if (!bool) {
      i = 1542;
    }
    int j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(j);
    AppMethodBeat.o(96821);
  }
  
  public static void aG(Activity paramActivity)
  {
    AppMethodBeat.i(198086);
    ad.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(198086);
  }
  
  public static List<ResolveInfo> ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(198087);
    try
    {
      paramContext = bt.ac(paramContext, paramIntent);
      AppMethodBeat.o(198087);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ad.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(198087);
    }
    return null;
  }
  
  public static boolean azQ(String paramString)
  {
    AppMethodBeat.i(96826);
    if ((paramString != null) && (paramString.length() >= 102400))
    {
      AppMethodBeat.o(96826);
      return true;
    }
    AppMethodBeat.o(96826);
    return false;
  }
  
  public static String azR(String paramString)
  {
    AppMethodBeat.i(96827);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new e(b.arN().replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = q.B(new e((e)localObject, System.currentTimeMillis()).fOK());
      int i = i.f((String)localObject, paramString, paramString.length);
      if (i == 0)
      {
        AppMethodBeat.o(96827);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      ad.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
      AppMethodBeat.o(96827);
    }
    return "";
  }
  
  public static String azS(String paramString)
  {
    AppMethodBeat.i(96828);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      e locale = new e(paramString);
      if (!locale.exists())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = i.aYq(paramString);
      locale.delete();
      AppMethodBeat.o(96828);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
      AppMethodBeat.o(96828);
    }
    return "";
  }
  
  public static int bC(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static void f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(96822);
    d.U(paramContext).b(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.arU() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + ai.ee(paramString);
    paramString = str + "/" + paramString;
    if (i.fv(paramString))
    {
      paramString = BackwardSupportUtil.b.o(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static int[] gk(Context paramContext)
  {
    AppMethodBeat.i(96820);
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
      AppMethodBeat.o(96820);
      return new int[] { j, i };
      j = paramContext.getWidth();
    }
  }
  
  public static void gl(Context paramContext)
  {
    AppMethodBeat.i(96823);
    f("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface gm(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (zHK == null) {
      zHK = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = zHK;
    AppMethodBeat.o(96825);
    return paramContext;
  }
  
  public static String n(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(96824);
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
          AppMethodBeat.o(96824);
          return paramVarArgs;
        }
      }
      return paramString;
    }
    catch (URISyntaxException paramVarArgs)
    {
      ad.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
      AppMethodBeat.o(96824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am
 * JD-Core Version:    0.7.0.1
 */