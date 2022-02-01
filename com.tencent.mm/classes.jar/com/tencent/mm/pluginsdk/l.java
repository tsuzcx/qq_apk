package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;

@Deprecated
public abstract interface l
{
  public abstract String R(String paramString1, String paramString2);
  
  public abstract void WZ();
  
  public abstract void Xb();
  
  public abstract void Xc();
  
  public abstract Intent Xd();
  
  public abstract void Xe();
  
  public abstract boolean Xf();
  
  public abstract q a(j paramj);
  
  public abstract void a(Context paramContext, as paramas, ca.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, ca.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(cpl paramcpl, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(as paramas);
  
  public abstract Bitmap b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bU(Context paramContext);
  
  public abstract q cR(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String go(String paramString);
  
  public abstract boolean gp(String paramString);
  
  public abstract boolean gq(String paramString);
  
  public abstract void gr(String paramString);
  
  public abstract void iO(int paramInt);
  
  public abstract String r(Context paramContext, String paramString);
  
  public abstract boolean s(Activity paramActivity);
  
  public abstract boolean s(Context paramContext, String paramString);
  
  public abstract void t(Activity paramActivity);
  
  public abstract String w(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */