package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.al.h;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl.a;

@Deprecated
public abstract interface k
{
  public abstract void Ll();
  
  public abstract void Ln();
  
  public abstract void Lo();
  
  public abstract Intent Lp();
  
  public abstract boolean Lq();
  
  public abstract void Lr();
  
  public abstract boolean Ls();
  
  public abstract String O(String paramString1, String paramString2);
  
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract n a(h paramh);
  
  public abstract void a(Context paramContext, af paramaf, bl.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bl.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(bqj parambqj, String paramString);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(af paramaf);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bv(Context paramContext);
  
  public abstract n cf(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String eL(String paramString);
  
  public abstract boolean eM(String paramString);
  
  public abstract boolean eN(String paramString);
  
  public abstract void eO(String paramString);
  
  public abstract void hD(int paramInt);
  
  public abstract String s(Context paramContext, String paramString);
  
  public abstract String s(String paramString, int paramInt);
  
  public abstract boolean s(Activity paramActivity);
  
  public abstract void t(Activity paramActivity);
  
  public abstract boolean t(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k
 * JD-Core Version:    0.7.0.1
 */