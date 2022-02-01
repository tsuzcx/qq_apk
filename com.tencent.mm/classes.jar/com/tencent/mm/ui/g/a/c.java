package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.d;

public final class c
{
  protected static String Hir = "https://m.facebook.com/dialog/";
  protected static String His = "https://graph.facebook.com/";
  protected static String Hit = "https://api.facebook.com/restserver.php";
  private final long HiA;
  private long Hiu;
  public long Hiv;
  private Activity Hiw;
  private String[] Hix;
  private int Hiy;
  private a Hiz;
  public String ifJ;
  private String mAppId;
  
  public c(String paramString)
  {
    AppMethodBeat.i(152810);
    this.ifJ = null;
    this.Hiu = 0L;
    this.Hiv = 0L;
    this.HiA = 86400000L;
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
    d.kU(paramActivity);
    a(paramActivity, "oauth", localBundle, new a()
    {
      public final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(152807);
        ad.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymousb)));
        c.a(c.this).a(paramAnonymousb);
        AppMethodBeat.o(152807);
      }
      
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(152808);
        ad.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymouse)));
        c.a(c.this).a(paramAnonymouse);
        AppMethodBeat.o(152808);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(152809);
        ad.d("Facebook-authorize", "Login canceled");
        c.a(c.this).onCancel();
        AppMethodBeat.o(152809);
      }
      
      public final void w(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(152806);
        d.fqE();
        d.sync();
        c.this.aLA(paramAnonymousBundle.getString("access_token"));
        c.this.aLB(paramAnonymousBundle.getString("expires_in"));
        if (c.this.fcU())
        {
          ad.d("Facebook-authorize", "Login Success! access_token=" + c.this.ifJ + " expires=" + c.this.Hiv);
          c.a(c.this).w(paramAnonymousBundle);
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
    this.Hiz = parama;
    a(paramActivity, paramArrayOfString);
    AppMethodBeat.o(152812);
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(152817);
    paramBundle.putString("format", "json");
    if (fcU()) {
      paramBundle.putString("access_token", this.ifJ);
    }
    if (paramString1 != null) {}
    for (paramString1 = His + paramString1;; paramString1 = Hit)
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
    h.vKh.idkeyStat(582L, 0L, 1L, false);
    AppMethodBeat.o(152811);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(152818);
    String str = Hir + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (fcU()) {
        paramBundle.putString("access_token", this.ifJ);
      }
      paramString = str + "?" + f.aZ(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      f.S(paramContext, "Error", "Application requires permission to access the Internet");
      AppMethodBeat.o(152818);
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new g(paramContext, paramString, parama).show();
    AppMethodBeat.o(152818);
  }
  
  public final void aLA(String paramString)
  {
    AppMethodBeat.i(152820);
    this.ifJ = paramString;
    this.Hiu = System.currentTimeMillis();
    AppMethodBeat.o(152820);
  }
  
  public final void aLB(String paramString)
  {
    AppMethodBeat.i(152821);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label31;
      }
    }
    label31:
    for (long l = 0L;; l = System.currentTimeMillis() + bt.aGi(paramString) * 1000L)
    {
      this.Hiv = l;
      AppMethodBeat.o(152821);
      return;
    }
  }
  
  public final boolean fcU()
  {
    AppMethodBeat.i(152819);
    if ((this.ifJ != null) && ((this.Hiv == 0L) || (System.currentTimeMillis() < this.Hiv)))
    {
      AppMethodBeat.o(152819);
      return true;
    }
    AppMethodBeat.o(152819);
    return false;
  }
  
  public final void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(152814);
    if (paramInt1 == this.Hiy)
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
            ad.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
            a(this.Hiw, this.Hix);
            AppMethodBeat.o(152814);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            ad.d("Facebook-authorize", "Login canceled by user.");
            this.Hiz.onCancel();
            AppMethodBeat.o(152814);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          ad.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramIntent)));
          this.Hiz.a(new e(paramIntent));
          AppMethodBeat.o(152814);
          return;
        }
        aLA(paramIntent.getStringExtra("access_token"));
        aLB(paramIntent.getStringExtra("expires_in"));
        if (fcU())
        {
          ad.d("Facebook-authorize", "Login Success! access_token=" + this.ifJ + " expires=" + this.Hiv);
          this.Hiz.w(paramIntent.getExtras());
          AppMethodBeat.o(152814);
          return;
        }
        this.Hiz.a(new e("Failed to receive access token."));
        AppMethodBeat.o(152814);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          ad.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.Hiz.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          AppMethodBeat.o(152814);
          return;
        }
        ad.d("Facebook-authorize", "Login canceled by user.");
        this.Hiz.onCancel();
      }
    }
    AppMethodBeat.o(152814);
  }
  
  public final String jZ(Context paramContext)
  {
    AppMethodBeat.i(152815);
    f.ka(paramContext);
    aLA(null);
    this.Hiv = 0L;
    AppMethodBeat.o(152815);
    return null;
  }
  
  public final String q(String paramString, Bundle paramBundle)
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
    
    public abstract void w(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.c
 * JD-Core Version:    0.7.0.1
 */