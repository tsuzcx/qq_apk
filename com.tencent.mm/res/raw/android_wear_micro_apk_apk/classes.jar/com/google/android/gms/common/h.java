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
  public static final int Hi = n.Hi;
  private static final h Ll = new h();
  
  private static String g(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(Hi);
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
      localStringBuilder.append(ch.u(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label94:
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label94;
    }
  }
  
  public static void l(Context paramContext)
  {
    n.l(paramContext);
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
      if ((paramContext != null) && (g.j(paramContext))) {
        return aj.hB();
      }
      return aj.b("com.google.android.gms", g(paramContext, paramString));
    }
    return aj.m("com.google.android.gms");
  }
  
  public boolean aZ(int paramInt)
  {
    return n.bj(paramInt);
  }
  
  public boolean b(Context paramContext, int paramInt)
  {
    return n.b(paramContext, paramInt);
  }
  
  @Deprecated
  public Intent ba(int paramInt)
  {
    return a(null, paramInt, null);
  }
  
  public String bb(int paramInt)
  {
    return n.bb(paramInt);
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