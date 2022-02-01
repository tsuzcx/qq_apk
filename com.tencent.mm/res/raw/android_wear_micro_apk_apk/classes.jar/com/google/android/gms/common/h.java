package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.aj;
import com.google.android.gms.common.util.g;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;

public class h
{
  public static final int IX = n.IX;
  private static final h Na = new h();
  
  private static String g(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(IX);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(ch.v(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label94:
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label94;
    }
  }
  
  public static void m(Context paramContext)
  {
    n.m(paramContext);
  }
  
  public PendingIntent a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramInt1, paramInt2, null);
  }
  
  public PendingIntent a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    paramString = a(paramContext, paramInt1, paramString);
    if (paramString == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }
  
  public Intent a(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      if ((paramContext != null) && (g.k(paramContext))) {
        return aj.hL();
      }
      return aj.b("com.google.android.gms", g(paramContext, paramString));
    }
    return aj.m("com.google.android.gms");
  }
  
  public boolean b(Context paramContext, int paramInt)
  {
    return n.b(paramContext, paramInt);
  }
  
  public boolean bt(int paramInt)
  {
    return n.bD(paramInt);
  }
  
  @Deprecated
  public Intent bu(int paramInt)
  {
    return a(null, paramInt, null);
  }
  
  public String bv(int paramInt)
  {
    return n.bv(paramInt);
  }
  
  public int d(Context paramContext)
  {
    int j = n.d(paramContext);
    int i = j;
    if (n.b(paramContext, j)) {
      i = 18;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.h
 * JD-Core Version:    0.7.0.1
 */