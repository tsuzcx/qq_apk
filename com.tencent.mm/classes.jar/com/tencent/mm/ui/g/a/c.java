package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.d;

public final class c
{
  protected static String KWl = "https://m.facebook.com/dialog/";
  protected static String KWm = "https://graph.facebook.com/";
  protected static String KWn = "https://api.facebook.com/restserver.php";
  private long KWo;
  public long KWp;
  private Activity KWq;
  private String[] KWr;
  private int KWs;
  private a KWt;
  private final long KWu;
  public String jbU;
  private String mAppId;
  
  public c(String paramString)
  {
    AppMethodBeat.i(152810);
    this.jbU = null;
    this.KWo = 0L;
    this.KWp = 0L;
    this.KWu = 86400000L;
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
    d.lB(paramActivity);
    a(paramActivity, "oauth", localBundle, new a()
    {
      public final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(152807);
        ae.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymousb)));
        c.a(c.this).a(paramAnonymousb);
        AppMethodBeat.o(152807);
      }
      
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(152808);
        ae.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymouse)));
        c.a(c.this).a(paramAnonymouse);
        AppMethodBeat.o(152808);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(152809);
        ae.d("Facebook-authorize", "Login canceled");
        c.a(c.this).onCancel();
        AppMethodBeat.o(152809);
      }
      
      public final void y(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(152806);
        d.gfa();
        d.sync();
        c.this.aYB(paramAnonymousBundle.getString("access_token"));
        c.this.aYC(paramAnonymousBundle.getString("expires_in"));
        if (c.this.fNU())
        {
          ae.d("Facebook-authorize", "Login Success! access_token=" + c.this.jbU + " expires=" + c.this.KWp);
          c.a(c.this).y(paramAnonymousBundle);
          AppMethodBeat.o(152806);
          return;
        }
        c.a(c.this).a(new e("Failed to receive access token."));
        AppMethodBeat.o(152806);
      }
    });
    AppMethodBeat.o(152813);
  }
  
  private void b(Activity paramActivity, String[] paramArrayOfString, a parama)
  {
    AppMethodBeat.i(152812);
    this.KWt = parama;
    a(paramActivity, paramArrayOfString);
    AppMethodBeat.o(152812);
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(152817);
    paramBundle.putString("format", "json");
    if (fNU()) {
      paramBundle.putString("access_token", this.jbU);
    }
    if (paramString1 != null) {}
    for (paramString1 = KWm + paramString1;; paramString1 = KWn)
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(582L, 0L, 1L, false);
    AppMethodBeat.o(152811);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(152818);
    String str = KWl + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (fNU()) {
        paramBundle.putString("access_token", this.jbU);
      }
      paramString = str + "?" + f.bj(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      f.U(paramContext, "Error", "Application requires permission to access the Internet");
      AppMethodBeat.o(152818);
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new g(paramContext, paramString, parama).show();
    AppMethodBeat.o(152818);
  }
  
  public final void aYB(String paramString)
  {
    AppMethodBeat.i(152820);
    this.jbU = paramString;
    this.KWo = System.currentTimeMillis();
    AppMethodBeat.o(152820);
  }
  
  public final void aYC(String paramString)
  {
    AppMethodBeat.i(152821);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label31;
      }
    }
    label31:
    for (long l = 0L;; l = System.currentTimeMillis() + bu.aSC(paramString) * 1000L)
    {
      this.KWp = l;
      AppMethodBeat.o(152821);
      return;
    }
  }
  
  public final boolean fNU()
  {
    AppMethodBeat.i(152819);
    if ((this.jbU != null) && ((this.KWp == 0L) || (System.currentTimeMillis() < this.KWp)))
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
    if (paramInt1 == this.KWs)
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
            ae.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
            a(this.KWq, this.KWr);
            AppMethodBeat.o(152814);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            ae.d("Facebook-authorize", "Login canceled by user.");
            this.KWt.onCancel();
            AppMethodBeat.o(152814);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          ae.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramIntent)));
          this.KWt.a(new e(paramIntent));
          AppMethodBeat.o(152814);
          return;
        }
        aYB(paramIntent.getStringExtra("access_token"));
        aYC(paramIntent.getStringExtra("expires_in"));
        if (fNU())
        {
          ae.d("Facebook-authorize", "Login Success! access_token=" + this.jbU + " expires=" + this.KWp);
          this.KWt.y(paramIntent.getExtras());
          AppMethodBeat.o(152814);
          return;
        }
        this.KWt.a(new e("Failed to receive access token."));
        AppMethodBeat.o(152814);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          ae.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.KWt.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          AppMethodBeat.o(152814);
          return;
        }
        ae.d("Facebook-authorize", "Login canceled by user.");
        this.KWt.onCancel();
      }
    }
    AppMethodBeat.o(152814);
  }
  
  public final String kD(Context paramContext)
  {
    AppMethodBeat.i(152815);
    f.kE(paramContext);
    aYB(null);
    this.KWp = 0L;
    AppMethodBeat.o(152815);
    return null;
  }
  
  public final String s(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(152816);
    paramString = a(paramString, paramBundle, "GET");
    AppMethodBeat.o(152816);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void a(e parame);
    
    public abstract void onCancel();
    
    public abstract void y(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.c
 * JD-Core Version:    0.7.0.1
 */