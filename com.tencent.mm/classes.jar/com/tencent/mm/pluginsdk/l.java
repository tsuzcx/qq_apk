package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu.a;

@Deprecated
public abstract interface l
{
  public abstract void MR();
  
  public abstract void MT();
  
  public abstract void MU();
  
  public abstract Intent MV();
  
  public abstract boolean MW();
  
  public abstract void MX();
  
  public abstract boolean MY();
  
  public abstract String Q(String paramString1, String paramString2);
  
  public abstract Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract n a(g paramg);
  
  public abstract void a(Context paramContext, am paramam, bu.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, bu.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(bzp parambzp, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(am paramam);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bx(Context paramContext);
  
  public abstract n ci(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String fw(String paramString);
  
  public abstract boolean fx(String paramString);
  
  public abstract boolean fy(String paramString);
  
  public abstract void fz(String paramString);
  
  public abstract void hu(int paramInt);
  
  public abstract String r(Context paramContext, String paramString);
  
  public abstract boolean s(Activity paramActivity);
  
  public abstract boolean s(Context paramContext, String paramString);
  
  public abstract void t(Activity paramActivity);
  
  public abstract String u(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */