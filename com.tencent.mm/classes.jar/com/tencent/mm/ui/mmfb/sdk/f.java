package com.tencent.mm.ui.mmfb.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ao;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;

public class f
{
  public static final String afyP;
  public static final String afyQ;
  public static final String afyR;
  public static final String afyS;
  public static final String afyT;
  public static final String afyU;
  public static final String afyV;
  protected static String afyW;
  protected static String afyX;
  protected static String afyY;
  private static WeakReference<BroadcastReceiver> afyZ;
  private long afza;
  public long afzb;
  private Activity afzc;
  private String[] afzd;
  private int afze;
  private a afzf;
  private a afzg;
  private final long afzh;
  private String mAppId;
  public String pNX;
  private g qht;
  
  static
  {
    AppMethodBeat.i(250245);
    afyP = f.class.getSimpleName() + ".extra_url";
    afyQ = f.class.getSimpleName() + ".extra_action";
    afyR = f.class.getSimpleName() + ".extra_params";
    afyS = f.class.getSimpleName() + ".extra_chromePackage";
    afyT = f.class.getSimpleName() + ".action_refresh";
    afyU = f.class.getSimpleName() + ".no_activity_exception";
    afyV = f.class.getSimpleName() + ".action_customTabRedirect";
    afyW = "https://m.facebook.com/dialog/";
    afyX = "https://graph.facebook.com/";
    afyY = "https://api.facebook.com/restserver.php";
    AppMethodBeat.o(250245);
  }
  
  public f()
  {
    AppMethodBeat.i(250188);
    this.pNX = null;
    this.afza = 0L;
    this.afzb = 0L;
    this.afzh = 86400000L;
    this.qht = null;
    this.mAppId = "290293790992170";
    this.qht = new g();
    AppMethodBeat.o(250188);
  }
  
  private void b(Activity paramActivity, String[] paramArrayOfString)
  {
    AppMethodBeat.i(250193);
    ce(paramActivity);
    new CustomTabLoginMethodHandler(new LoginClient(paramActivity)).a(paramActivity, paramArrayOfString);
    cd(paramActivity);
    AppMethodBeat.o(250193);
  }
  
  public static Bundle bCm(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(250225);
    Bundle localBundle = new Bundle();
    int j;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = paramString.split("&");
      j = paramString.length;
    }
    for (;;)
    {
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        try
        {
          if (arrayOfString.length == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
          } else if (arrayOfString.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      }
      else
      {
        AppMethodBeat.o(250225);
        return localBundle;
      }
      i += 1;
    }
  }
  
  private void c(Activity paramActivity, String[] paramArrayOfString)
  {
    AppMethodBeat.i(250212);
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    ao.oQ(paramActivity);
    a(paramActivity, "oauth", localBundle, ce(paramActivity));
    AppMethodBeat.o(250212);
  }
  
  private void cd(Activity paramActivity)
  {
    AppMethodBeat.i(250197);
    nA(paramActivity);
    BroadcastReceiver local1 = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(250237);
        String str = paramAnonymousIntent.getStringExtra(f.afyP);
        Log.i("MicroMsg.FacebookLoginUI", "data = %s, action = %s.", new Object[] { str, paramAnonymousIntent.getAction() });
        paramAnonymousContext = new Bundle();
        if ((f.afyV.equals(paramAnonymousIntent.getAction())) && (str != null) && (str.startsWith("fb290293790992170://authorize")))
        {
          paramAnonymousIntent = f.bCm(str);
          paramAnonymousContext.putString("access_token", paramAnonymousIntent.getString("access_token"));
        }
        try
        {
          paramAnonymousContext.putLong("data_access_expiration_time", Long.parseLong(paramAnonymousIntent.getString("data_access_expiration_time")) * 1000L);
          Log.i("MicroMsg.FacebookLoginUI", "DATAACCESSEXPIRATIONTIME = %s", new Object[] { Long.valueOf(paramAnonymousContext.getLong("data_access_expiration_time")) });
          label128:
          paramAnonymousContext.putString("expires_in", paramAnonymousIntent.getString("expires_in"));
          paramAnonymousContext.putString("service_disabled", paramAnonymousIntent.getString("service_disabled"));
          if (f.a(f.this) != null) {
            f.a(f.this).T(paramAnonymousContext);
          }
          AppMethodBeat.o(250237);
          return;
        }
        catch (Exception localException)
        {
          break label128;
        }
      }
    };
    afyZ = new WeakReference(local1);
    a.al(paramActivity).a(local1, new IntentFilter(afyV));
    AppMethodBeat.o(250197);
  }
  
  private a ce(Activity paramActivity)
  {
    AppMethodBeat.i(250206);
    ao.oQ(paramActivity);
    this.afzg = new a()
    {
      public final void T(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(250232);
        ao.kgo();
        f.this.bCk(paramAnonymousBundle.getString("access_token"));
        f.this.bCl(paramAnonymousBundle.getString("expires_in"));
        if (paramAnonymousBundle.getLong("data_access_expiration_time") > System.currentTimeMillis() / 1000L) {
          f.this.afzb = paramAnonymousBundle.getLong("data_access_expiration_time");
        }
        while (f.this.jBQ())
        {
          Log.d("Facebook-authorize", "Login Success! access_token=" + f.this.pNX + " expires=" + f.this.afzb);
          f.b(f.this).T(paramAnonymousBundle);
          AppMethodBeat.o(250232);
          return;
          Log.i("MicroMsg.FacebookLoginUI", "onComplete, onError, values.getLong(DATAACCESSEXPIRATIONTIME) = " + paramAnonymousBundle.getLong("data_access_expiration_time") + ", System.currentTimeMillis() = " + System.currentTimeMillis());
        }
        f.b(f.this).a(new h("Failed to receive access token."));
        AppMethodBeat.o(250232);
      }
      
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(250239);
        Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymouse)));
        f.b(f.this).a(paramAnonymouse);
        AppMethodBeat.o(250239);
      }
      
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(250244);
        Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramAnonymoush)));
        f.b(f.this).a(paramAnonymoush);
        AppMethodBeat.o(250244);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(250248);
        Log.d("Facebook-authorize", "Login canceled");
        f.b(f.this).onCancel();
        AppMethodBeat.o(250248);
      }
    };
    paramActivity = this.afzg;
    AppMethodBeat.o(250206);
    return paramActivity;
  }
  
  public static void jBR()
  {
    AppMethodBeat.i(250217);
    Log.i("MicroMsg.FacebookLoginUI", "facebook resetCheck");
    AppMethodBeat.o(250217);
  }
  
  private static void nA(Context paramContext)
  {
    AppMethodBeat.i(250201);
    try
    {
      if ((afyZ != null) && (afyZ.get() != null))
      {
        Log.i("MicroMsg.FacebookLoginUI", "unregisterReceiver");
        a.al(paramContext).unregisterReceiver((BroadcastReceiver)afyZ.get());
        afyZ = null;
      }
      AppMethodBeat.o(250201);
      return;
    }
    catch (Exception paramContext)
    {
      Log.i("MicroMsg.FacebookLoginUI", "facebook destory, Exception = ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(250201);
    }
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(250263);
    paramBundle.putString("format", "json");
    if (jBQ()) {
      paramBundle.putString("access_token", this.pNX);
    }
    if (paramString1 != null) {}
    for (paramString1 = afyX + paramString1;; paramString1 = afyY)
    {
      paramString1 = i.g(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(250263);
      return paramString1;
    }
  }
  
  public final void a(Activity paramActivity, String[] paramArrayOfString, a parama)
  {
    AppMethodBeat.i(250251);
    this.afzf = parama;
    b(paramActivity, paramArrayOfString);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 0L, 1L, false);
    AppMethodBeat.o(250251);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(250265);
    String str = afyW + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    for (;;)
    {
      if (jBQ()) {
        paramBundle.putString("access_token", this.pNX);
      }
      paramString = str + "?" + i.bZ(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      i.al(paramContext, "Error", "Application requires permission to access the Internet");
      AppMethodBeat.o(250265);
      return;
      paramBundle.putString("app_id", this.mAppId);
    }
    new j(paramContext, paramString, parama).show();
    AppMethodBeat.o(250265);
  }
  
  public final void bCk(String paramString)
  {
    AppMethodBeat.i(250275);
    this.pNX = paramString;
    this.afza = System.currentTimeMillis();
    AppMethodBeat.o(250275);
  }
  
  public final void bCl(String paramString)
  {
    AppMethodBeat.i(250281);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label34;
      }
    }
    label34:
    for (long l = 0L;; l = System.currentTimeMillis() + Util.safeParseLong(paramString) * 1000L)
    {
      this.afzb = l;
      AppMethodBeat.o(250281);
      return;
    }
  }
  
  public final void cf(Activity paramActivity)
  {
    AppMethodBeat.i(250288);
    if (this.qht != null) {
      Log.i("MicroMsg.FacebookLoginUI", "facebook destory, unInitSdk = " + Util.getStack());
    }
    nA(paramActivity);
    AppMethodBeat.o(250288);
  }
  
  public final boolean jBQ()
  {
    AppMethodBeat.i(250272);
    if ((this.pNX != null) && ((this.afzb == 0L) || (System.currentTimeMillis() < this.afzb)))
    {
      AppMethodBeat.o(250272);
      return true;
    }
    AppMethodBeat.o(250272);
    return false;
  }
  
  public final void m(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(250256);
    if (paramInt1 == this.afze)
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
            c(this.afzc, this.afzd);
            AppMethodBeat.o(250256);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            Log.d("Facebook-authorize", "Login canceled by user.");
            this.afzf.onCancel();
            AppMethodBeat.o(250256);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          Log.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramIntent)));
          this.afzf.a(new h(paramIntent));
          AppMethodBeat.o(250256);
          return;
        }
        bCk(paramIntent.getStringExtra("access_token"));
        bCl(paramIntent.getStringExtra("expires_in"));
        if (jBQ())
        {
          Log.d("Facebook-authorize", "Login Success! access_token=" + this.pNX + " expires=" + this.afzb);
          this.afzf.T(paramIntent.getExtras());
          AppMethodBeat.o(250256);
          return;
        }
        this.afzf.a(new h("Failed to receive access token."));
        AppMethodBeat.o(250256);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          Log.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.afzf.a(new e(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          AppMethodBeat.o(250256);
          return;
        }
        Log.d("Facebook-authorize", "Login canceled by user.");
        this.afzf.onCancel();
      }
    }
    AppMethodBeat.o(250256);
  }
  
  public final String nB(Context paramContext)
  {
    AppMethodBeat.i(250260);
    ao.oQ(paramContext);
    ao.removeAllCookie();
    bCk(null);
    this.afzb = 0L;
    nA(paramContext);
    AppMethodBeat.o(250260);
    return null;
  }
  
  public final String y(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(250262);
    paramString = a(paramString, paramBundle, "GET");
    AppMethodBeat.o(250262);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void T(Bundle paramBundle);
    
    public abstract void a(e parame);
    
    public abstract void a(h paramh);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.f
 * JD-Core Version:    0.7.0.1
 */