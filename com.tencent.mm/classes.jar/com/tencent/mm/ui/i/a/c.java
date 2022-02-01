package com.tencent.mm.ui.i.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.d;

public final class c
{
  protected static String XGM = "https://m.facebook.com/dialog/";
  protected static String XGN = "https://graph.facebook.com/";
  protected static String XGO = "https://api.facebook.com/restserver.php";
  private long XGP;
  public long XGQ;
  private Activity XGR;
  private String[] XGS;
  private int XGT;
  private a XGU;
  private final long XGV;
  private String mAppId;
  public String mRq;
  
  public c(String paramString)
  {
    AppMethodBeat.i(152810);
    this.mRq = null;
    this.XGP = 0L;
    this.XGQ = 0L;
    this.XGV = 86400000L;
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
      AppMethodBeat.o(152810);
      throw paramString;
    }
    this.mAppId = paramString;
    AppMethodBeat.o(152810);
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    AppMethodBeat.i(152813);
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    d.my(paramActivity);
    a(paramActivity, "oauth", localBundle, new a()
    {
      public final void K(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(152806);
        d.ivZ();
        d.sync();
        c.this.bAo(paramAnonymousBundle.getString("access_token"));
        c.this.bAp(paramAnonymousBundle.getString("expires_in"));
        if (c.this.hWS())
        {
          Log.d("Facebook-authorize", "Login Success! access_token=" + c.this.mRq + " expires=" + c.this.XGQ);
          c.a(c.this).K(paramAnonymousBundle);
          AppMethodBeat.o(152806);
          return;
        }
        c.a(c.this).a(new e("Failed to receive access token."));
        AppMethodBeat.o(152806);
      }
      
      public final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(152807);
        Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymousb)));
        c.a(c.this).a(paramAnonymousb);
        AppMethodBeat.o(152807);
      }
      
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(152808);
        Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymouse)));
        c.a(c.this).a(paramAnonymouse);
        AppMethodBeat.o(152808);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(152809);
        Log.d("Facebook-authorize", "Login canceled");
        c.a(c.this).onCancel();
        AppMethodBeat.o(152809);
      }
    });
    AppMethodBeat.o(152813);
  }
  
  private void b(Activity paramActivity, String[] paramArrayOfString, a parama)
  {
    AppMethodBeat.i(152812);
    this.XGU = parama;
    a(paramActivity, paramArrayOfString);
    AppMethodBeat.o(152812);
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(152817);
    paramBundle.putString("format", "json");
    if (hWS()) {
      paramBundle.putString("access_token", this.mRq);
    }
    if (paramString1 != null) {}
    for (paramString1 = XGN + paramString1;; paramString1 = XGO)
    {
      paramString1 = f.e(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(152817);
      return paramString1;
    }
  }
  
  public final void a(Activity paramActivity, String[] paramArrayOfString, a parama)
  {
    AppMethodBeat.i(152811);
    b(paramActivity, paramArrayOfString, parama);
    h.IzE.idkeyStat(582L, 0L, 1L, false);
    AppMethodBeat.o(152811);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(152818);
    String str = XGM + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (hWS()) {
        paramBundle.putString("access_token", this.mRq);
      }
      paramString = str + "?" + f.bt(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      f.ag(paramContext, "Error", "Application requires permission to access the Internet");
      AppMethodBeat.o(152818);
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new g(paramContext, paramString, parama).show();
    AppMethodBeat.o(152818);
  }
  
  public final void bAo(String paramString)
  {
    AppMethodBeat.i(152820);
    this.mRq = paramString;
    this.XGP = System.currentTimeMillis();
    AppMethodBeat.o(152820);
  }
  
  public final void bAp(String paramString)
  {
    AppMethodBeat.i(152821);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label31;
      }
    }
    label31:
    for (long l = 0L;; l = System.currentTimeMillis() + Util.safeParseLong(paramString) * 1000L)
    {
      this.XGQ = l;
      AppMethodBeat.o(152821);
      return;
    }
  }
  
  public final boolean hWS()
  {
    AppMethodBeat.i(152819);
    if ((this.mRq != null) && ((this.XGQ == 0L) || (System.currentTimeMillis() < this.XGQ)))
    {
      AppMethodBeat.o(152819);
      return true;
    }
    AppMethodBeat.o(152819);
    return false;
  }
  
  public final void j(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(152814);
    if (paramInt1 == this.XGT)
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
            Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
            a(this.XGR, this.XGS);
            AppMethodBeat.o(152814);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            Log.d("Facebook-authorize", "Login canceled by user.");
            this.XGU.onCancel();
            AppMethodBeat.o(152814);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramIntent)));
          this.XGU.a(new e(paramIntent));
          AppMethodBeat.o(152814);
          return;
        }
        bAo(paramIntent.getStringExtra("access_token"));
        bAp(paramIntent.getStringExtra("expires_in"));
        if (hWS())
        {
          Log.d("Facebook-authorize", "Login Success! access_token=" + this.mRq + " expires=" + this.XGQ);
          this.XGU.K(paramIntent.getExtras());
          AppMethodBeat.o(152814);
          return;
        }
        this.XGU.a(new e("Failed to receive access token."));
        AppMethodBeat.o(152814);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          Log.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.XGU.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          AppMethodBeat.o(152814);
          return;
        }
        Log.d("Facebook-authorize", "Login canceled by user.");
        this.XGU.onCancel();
      }
    }
    AppMethodBeat.o(152814);
  }
  
  public final String lv(Context paramContext)
  {
    AppMethodBeat.i(152815);
    f.lw(paramContext);
    bAo(null);
    this.XGQ = 0L;
    AppMethodBeat.o(152815);
    return null;
  }
  
  public final String w(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(152816);
    paramString = a(paramString, paramBundle, "GET");
    AppMethodBeat.o(152816);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void K(Bundle paramBundle);
    
    public abstract void a(b paramb);
    
    public abstract void a(e parame);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.c
 * JD-Core Version:    0.7.0.1
 */