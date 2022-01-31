package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ai.g;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;

@Deprecated
public abstract interface m
{
  public abstract void BO();
  
  public abstract void BQ();
  
  public abstract void BR();
  
  public abstract Intent BS();
  
  public abstract boolean BT();
  
  public abstract void BU();
  
  public abstract boolean BV();
  
  public abstract String H(String paramString1, String paramString2);
  
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract com.tencent.mm.ai.m a(g paramg);
  
  public abstract void a(Context paramContext, ad paramad, bi.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bi.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(bdt parambdt, String paramString);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(ad paramad);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bh(Context paramContext);
  
  public abstract com.tencent.mm.ai.m bs(boolean paramBoolean);
  
  public abstract String dE(String paramString);
  
  public abstract boolean dF(String paramString);
  
  public abstract boolean dG(String paramString);
  
  public abstract void dH(String paramString);
  
  public abstract String f(Context paramContext, String paramString1, String paramString2);
  
  public abstract void gf(int paramInt);
  
  public abstract boolean n(Activity paramActivity);
  
  public abstract void o(Activity paramActivity);
  
  public abstract String t(Context paramContext, String paramString);
  
  public abstract String t(String paramString, int paramInt);
  
  public abstract boolean u(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m
 * JD-Core Version:    0.7.0.1
 */