package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  protected static String AnN = "https://m.facebook.com/dialog/";
  protected static String AnO = "https://graph.facebook.com/";
  protected static String AnP = "https://api.facebook.com/restserver.php";
  private long AnQ;
  public long AnR;
  private Activity AnS;
  private String[] AnT;
  private int AnU;
  private c.a AnV;
  private final long AnW;
  public String gsH;
  private String mAppId;
  
  public c(String paramString)
  {
    AppMethodBeat.i(80298);
    this.gsH = null;
    this.AnQ = 0L;
    this.AnR = 0L;
    this.AnW = 86400000L;
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
      AppMethodBeat.o(80298);
      throw paramString;
    }
    this.mAppId = paramString;
    AppMethodBeat.o(80298);
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    AppMethodBeat.i(80301);
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    com.tencent.xweb.c.jQ(paramActivity);
    a(paramActivity, "oauth", localBundle, new c.1(this));
    AppMethodBeat.o(80301);
  }
  
  private void b(Activity paramActivity, String[] paramArrayOfString, c.a parama)
  {
    AppMethodBeat.i(80300);
    this.AnV = parama;
    a(paramActivity, paramArrayOfString);
    AppMethodBeat.o(80300);
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(80305);
    paramBundle.putString("format", "json");
    if (dNf()) {
      paramBundle.putString("access_token", this.gsH);
    }
    if (paramString1 != null) {}
    for (paramString1 = AnO + paramString1;; paramString1 = AnP)
    {
      paramString1 = f.e(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(80305);
      return paramString1;
    }
  }
  
  public final void a(Activity paramActivity, String[] paramArrayOfString, c.a parama)
  {
    AppMethodBeat.i(80299);
    b(paramActivity, paramArrayOfString, parama);
    h.qsU.idkeyStat(582L, 0L, 1L, false);
    AppMethodBeat.o(80299);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, c.a parama)
  {
    AppMethodBeat.i(80306);
    String str = AnN + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (dNf()) {
        paramBundle.putString("access_token", this.gsH);
      }
      paramString = str + "?" + f.aJ(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      f.L(paramContext, "Error", "Application requires permission to access the Internet");
      AppMethodBeat.o(80306);
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new g(paramContext, paramString, parama).show();
    AppMethodBeat.o(80306);
  }
  
  public final void auI(String paramString)
  {
    AppMethodBeat.i(80308);
    this.gsH = paramString;
    this.AnQ = System.currentTimeMillis();
    AppMethodBeat.o(80308);
  }
  
  public final void auJ(String paramString)
  {
    AppMethodBeat.i(80309);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label31;
      }
    }
    label31:
    for (long l = 0L;; l = System.currentTimeMillis() + bo.apW(paramString) * 1000L)
    {
      this.AnR = l;
      AppMethodBeat.o(80309);
      return;
    }
  }
  
  public final boolean dNf()
  {
    AppMethodBeat.i(80307);
    if ((this.gsH != null) && ((this.AnR == 0L) || (System.currentTimeMillis() < this.AnR)))
    {
      AppMethodBeat.o(80307);
      return true;
    }
    AppMethodBeat.o(80307);
    return false;
  }
  
  public final void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80302);
    if (paramInt1 == this.AnU)
    {
      if (paramInt2 == -1)
      {
        String str2 = paramIntent.getStringExtra("error");
        String str1 = str2;
        if (str2 == null) {
          str1 = paramIntent.getStringExtra("error_type");
        }
        if (str1 != null)
        {
          if ((str1.equals("service_disabled")) || (str1.equals("AndroidAuthKillSwitchException")))
          {
            ab.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
            a(this.AnS, this.AnT);
            AppMethodBeat.o(80302);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            ab.d("Facebook-authorize", "Login canceled by user.");
            this.AnV.onCancel();
            AppMethodBeat.o(80302);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramIntent)));
          this.AnV.a(new e(paramIntent));
          AppMethodBeat.o(80302);
          return;
        }
        auI(paramIntent.getStringExtra("access_token"));
        auJ(paramIntent.getStringExtra("expires_in"));
        if (dNf())
        {
          ab.d("Facebook-authorize", "Login Success! access_token=" + this.gsH + " expires=" + this.AnR);
          this.AnV.u(paramIntent.getExtras());
          AppMethodBeat.o(80302);
          return;
        }
        this.AnV.a(new e("Failed to receive access token."));
        AppMethodBeat.o(80302);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          ab.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.AnV.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          AppMethodBeat.o(80302);
          return;
        }
        ab.d("Facebook-authorize", "Login canceled by user.");
        this.AnV.onCancel();
      }
    }
    AppMethodBeat.o(80302);
  }
  
  public final String ix(Context paramContext)
  {
    AppMethodBeat.i(80303);
    f.iy(paramContext);
    auI(null);
    this.AnR = 0L;
    AppMethodBeat.o(80303);
    return null;
  }
  
  public final String q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(80304);
    paramString = a(paramString, paramBundle, "GET");
    AppMethodBeat.o(80304);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.c
 * JD-Core Version:    0.7.0.1
 */