package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo.a;

@Deprecated
public abstract interface k
{
  public abstract void Lj();
  
  public abstract void Ll();
  
  public abstract void Lm();
  
  public abstract Intent Ln();
  
  public abstract boolean Lo();
  
  public abstract void Lp();
  
  public abstract boolean Lq();
  
  public abstract String P(String paramString1, String paramString2);
  
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract n a(h paramh);
  
  public abstract void a(Context paramContext, ai paramai, bo.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bo.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(bva parambva, String paramString);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(ai paramai);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void by(Context paramContext);
  
  public abstract n ch(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String eB(String paramString);
  
  public abstract boolean eC(String paramString);
  
  public abstract boolean eD(String paramString);
  
  public abstract void eE(String paramString);
  
  public abstract void hn(int paramInt);
  
  public abstract String s(Context paramContext, String paramString);
  
  public abstract String s(String paramString, int paramInt);
  
  public abstract boolean s(Activity paramActivity);
  
  public abstract void t(Activity paramActivity);
  
  public abstract boolean t(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k
 * JD-Core Version:    0.7.0.1
 */