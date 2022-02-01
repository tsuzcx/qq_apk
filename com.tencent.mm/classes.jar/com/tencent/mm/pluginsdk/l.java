package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.am.i;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc.a;

@Deprecated
public abstract interface l
{
  public abstract String X(String paramString, int paramInt);
  
  public abstract p a(i parami);
  
  public abstract void a(Context paramContext, au paramau, cc.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, cc.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(dph paramdph, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(au paramau);
  
  public abstract void aDA();
  
  public abstract Intent aDB();
  
  public abstract boolean aDC();
  
  public abstract void aDD();
  
  public abstract boolean aDE();
  
  public abstract void aDx();
  
  public abstract void aDz();
  
  public abstract String ab(String paramString1, String paramString2);
  
  public abstract Bitmap b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void cE(Context paramContext);
  
  public abstract p ea(boolean paramBoolean);
  
  public abstract String i(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean iA(String paramString);
  
  public abstract boolean iB(String paramString);
  
  public abstract void iC(String paramString);
  
  public abstract String iz(String paramString);
  
  public abstract void nK(int paramInt);
  
  public abstract boolean t(Activity paramActivity);
  
  public abstract void u(Activity paramActivity);
  
  public abstract String x(Context paramContext, String paramString);
  
  public abstract boolean y(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */