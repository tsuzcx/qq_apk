package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class c
{
  private static final Lock GX = new ReentrantLock();
  private static c GY;
  private final Lock GZ = new ReentrantLock();
  private final SharedPreferences Ha;
  
  private c(Context paramContext)
  {
    this.Ha = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    String str = String.valueOf(":");
    return String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2;
  }
  
  public static c c(Context paramContext)
  {
    d.u(paramContext);
    GX.lock();
    try
    {
      if (GY == null) {
        GY = new c(paramContext.getApplicationContext());
      }
      paramContext = GY;
      return paramContext;
    }
    finally
    {
      GX.unlock();
    }
  }
  
  private GoogleSignInAccount i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = k(a("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.g(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private GoogleSignInOptions j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = k(a("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.h(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private String k(String paramString)
  {
    this.GZ.lock();
    try
    {
      paramString = this.Ha.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.GZ.unlock();
    }
  }
  
  public final GoogleSignInAccount gj()
  {
    return i(k("defaultGoogleSignInAccount"));
  }
  
  public final GoogleSignInOptions gk()
  {
    return j(k("defaultGoogleSignInAccount"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.c
 * JD-Core Version:    0.7.0.1
 */