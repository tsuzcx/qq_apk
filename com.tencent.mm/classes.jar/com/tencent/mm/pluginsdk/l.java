package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;

@Deprecated
public abstract interface l
{
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract m a(g paramg);
  
  public abstract void a(Context paramContext, ad paramad, bi.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bi.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(axd paramaxd, String paramString);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(ad paramad);
  
  public abstract void aJ(Context paramContext);
  
  public abstract m aQ(boolean paramBoolean);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract String cs(String paramString);
  
  public abstract boolean ct(String paramString);
  
  public abstract boolean cu(String paramString);
  
  public abstract void es(int paramInt);
  
  public abstract String f(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean m(Activity paramActivity);
  
  public abstract String n(Context paramContext, String paramString);
  
  public abstract void n(Activity paramActivity);
  
  public abstract boolean o(Context paramContext, String paramString);
  
  public abstract String q(String paramString, int paramInt);
  
  public abstract void tk();
  
  public abstract void tm();
  
  public abstract void tn();
  
  public abstract Intent to();
  
  public abstract boolean tp();
  
  public abstract void tq();
  
  public abstract boolean tr();
  
  public abstract String u(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */