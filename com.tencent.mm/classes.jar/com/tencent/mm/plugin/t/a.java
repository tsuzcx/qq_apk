package com.tencent.mm.plugin.t;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;

public final class a
{
  private static final Application.ActivityLifecycleCallbacks uqX;
  
  static
  {
    AppMethodBeat.i(116071);
    uqX = new com.tencent.mm.plugin.appbrand.aa.a()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(116064);
        try
        {
          if (bt.nullAsNil(paramAnonymousActivity.getLocalClassName()).contains("WebView"))
          {
            paramAnonymousBundle = paramAnonymousActivity.getLocalClassName();
            if (paramAnonymousActivity.getIntent() != null) {
              break label59;
            }
          }
          label59:
          for (paramAnonymousActivity = null;; paramAnonymousActivity = paramAnonymousActivity.getIntent().getStringExtra(e.m.FIB))
          {
            ad.i("MicroMsg.WxPayAdUxInfoTracer", "onActivityCreated-%s, adUxInfo=%s", new Object[] { paramAnonymousBundle, paramAnonymousActivity });
            AppMethodBeat.o(116064);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousActivity)
        {
          AppMethodBeat.o(116064);
        }
      }
    };
    AppMethodBeat.o(116071);
  }
  
  public static void a(String paramString, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(116067);
    a("onCreate", paramString, paramPersistableBundle);
    AppMethodBeat.o(116067);
  }
  
  private static void a(String paramString1, String paramString2, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(116069);
    if (paramPersistableBundle == null) {}
    for (paramPersistableBundle = null;; paramPersistableBundle = paramPersistableBundle.getString("adUxInfo"))
    {
      ad.i("MicroMsg.WxPayAdUxInfoTracer", "AppBrandRuntime(%s)-%s, adUxInfo=%s", new Object[] { paramString2, paramString1, paramPersistableBundle });
      AppMethodBeat.o(116069);
      return;
    }
  }
  
  public static void b(String paramString, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(116068);
    a("onNewConfig", paramString, paramPersistableBundle);
    AppMethodBeat.o(116068);
  }
  
  public static void k(Application paramApplication)
  {
    AppMethodBeat.i(116065);
    paramApplication.registerActivityLifecycleCallbacks(uqX);
    AppMethodBeat.o(116065);
  }
  
  public static void q(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(116066);
    ad.i("MicroMsg.WxPayAdUxInfoTracer", "trace: ".concat(String.valueOf(paramString)), paramVarArgs);
    AppMethodBeat.o(116066);
  }
  
  public static void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(116070);
    ad.i("MicroMsg.WxPayAdUxInfoTracer", "trace: scene[%s] api[%s] udUxInfo[%s] source[%s]", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(116070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.t.a
 * JD-Core Version:    0.7.0.1
 */