package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv.a;

@Deprecated
public abstract interface l
{
  public abstract void MM();
  
  public abstract void MO();
  
  public abstract void MP();
  
  public abstract Intent MQ();
  
  public abstract boolean MR();
  
  public abstract void MS();
  
  public abstract boolean MT();
  
  public abstract String Q(String paramString1, String paramString2);
  
  public abstract n a(g paramg);
  
  public abstract void a(Context paramContext, an paraman, bv.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bv.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(caj paramcaj, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(an paraman);
  
  public abstract Bitmap b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bz(Context paramContext);
  
  public abstract n ci(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String fC(String paramString);
  
  public abstract boolean fD(String paramString);
  
  public abstract boolean fE(String paramString);
  
  public abstract void fF(String paramString);
  
  public abstract void hu(int paramInt);
  
  public abstract String r(Context paramContext, String paramString);
  
  public abstract boolean s(Activity paramActivity);
  
  public abstract boolean s(Context paramContext, String paramString);
  
  public abstract void t(Activity paramActivity);
  
  public abstract String v(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */