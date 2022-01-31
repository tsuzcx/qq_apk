package com.tencent.mm.ui.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  protected static String vVK = "https://m.facebook.com/dialog/";
  protected static String vVL = "https://graph.facebook.com/";
  protected static String vVM = "https://api.facebook.com/restserver.php";
  public String faP = null;
  private String mAppId;
  private long vVN = 0L;
  public long vVO = 0L;
  private Activity vVP;
  private String[] vVQ;
  private int vVR;
  private c.a vVS;
  private final long vVT = 86400000L;
  
  public c(String paramString)
  {
    this.mAppId = paramString;
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    com.tencent.xweb.c.il(paramActivity);
    a(paramActivity, "oauth", localBundle, new c.a()
    {
      public final void a(b paramAnonymousb)
      {
        y.d("Facebook-authorize", "Login failed: " + paramAnonymousb);
        c.a(c.this).a(paramAnonymousb);
      }
      
      public final void a(d paramAnonymousd)
      {
        y.d("Facebook-authorize", "Login failed: " + paramAnonymousd);
        c.a(c.this).a(paramAnonymousd);
      }
      
      public final void l(Bundle paramAnonymousBundle)
      {
        com.tencent.xweb.c.cSg();
        com.tencent.xweb.c.sync();
        c.this.aea(paramAnonymousBundle.getString("access_token"));
        c.this.aeb(paramAnonymousBundle.getString("expires_in"));
        if (c.this.cIx())
        {
          y.d("Facebook-authorize", "Login Success! access_token=" + c.this.faP + " expires=" + c.this.vVO);
          c.a(c.this).l(paramAnonymousBundle);
          return;
        }
        c.a(c.this).a(new d("Failed to receive access token."));
      }
      
      public final void onCancel()
      {
        y.d("Facebook-authorize", "Login canceled");
        c.a(c.this).onCancel();
      }
    });
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    paramBundle.putString("format", "json");
    if (cIx()) {
      paramBundle.putString("access_token", this.faP);
    }
    if (paramString1 != null) {}
    for (paramString1 = vVL + paramString1;; paramString1 = vVM) {
      return e.b(paramString1, paramString2, paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, String[] paramArrayOfString, c.a parama)
  {
    this.vVS = parama;
    a(paramActivity, paramArrayOfString);
    h.nFQ.a(582L, 0L, 1L, false);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, c.a parama)
  {
    String str = vVK + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (cIx()) {
        paramBundle.putString("access_token", this.faP);
      }
      paramString = str + "?" + e.aq(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      e.B(paramContext, "Error", "Application requires permission to access the Internet");
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new f(paramContext, paramString, parama).show();
  }
  
  public final void aea(String paramString)
  {
    this.faP = paramString;
    this.vVN = System.currentTimeMillis();
  }
  
  public final void aeb(String paramString)
  {
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label21;
      }
    }
    label21:
    for (long l = 0L;; l = System.currentTimeMillis() + bk.ZS(paramString) * 1000L)
    {
      this.vVO = l;
      return;
    }
  }
  
  public final boolean cIx()
  {
    return (this.faP != null) && ((this.vVO == 0L) || (System.currentTimeMillis() < this.vVO));
  }
  
  public final void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.vVR)
    {
      if (paramInt2 != -1) {
        break label301;
      }
      str2 = paramIntent.getStringExtra("error");
      str1 = str2;
      if (str2 == null) {
        str1 = paramIntent.getStringExtra("error_type");
      }
      if (str1 == null) {
        break label201;
      }
      if ((!str1.equals("service_disabled")) && (!str1.equals("AndroidAuthKillSwitchException"))) {
        break label83;
      }
      y.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
      a(this.vVP, this.vVQ);
    }
    label83:
    while (paramInt2 != 0)
    {
      String str1;
      return;
      if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
      {
        y.d("Facebook-authorize", "Login canceled by user.");
        this.vVS.onCancel();
        return;
      }
      String str2 = paramIntent.getStringExtra("error_description");
      paramIntent = str1;
      if (str2 != null) {
        paramIntent = str1 + ":" + str2;
      }
      y.d("Facebook-authorize", "Login failed: " + paramIntent);
      this.vVS.a(new d(paramIntent));
      return;
      aea(paramIntent.getStringExtra("access_token"));
      aeb(paramIntent.getStringExtra("expires_in"));
      if (cIx())
      {
        y.d("Facebook-authorize", "Login Success! access_token=" + this.faP + " expires=" + this.vVO);
        this.vVS.l(paramIntent.getExtras());
        return;
      }
      this.vVS.a(new d("Failed to receive access token."));
      return;
    }
    label201:
    if (paramIntent != null)
    {
      y.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
      this.vVS.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
      return;
    }
    label301:
    y.d("Facebook-authorize", "Login canceled by user.");
    this.vVS.onCancel();
  }
  
  public final String hc(Context paramContext)
  {
    com.tencent.xweb.c.il(paramContext);
    com.tencent.xweb.b.cSe().removeAllCookie();
    aea(null);
    this.vVO = 0L;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.c
 * JD-Core Version:    0.7.0.1
 */