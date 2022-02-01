package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;

@Deprecated
public abstract interface l
{
  public abstract String O(String paramString, int paramInt);
  
  public abstract String V(String paramString1, String paramString2);
  
  public abstract q a(j paramj);
  
  public abstract void a(Context paramContext, as paramas, ca.a parama, Bundle paramBundle, String paramString);
  
  public abstract void a(Context paramContext, ca.a parama, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(cyb paramcyb, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean a(as paramas);
  
  public abstract void abC();
  
  public abstract void abE();
  
  public abstract void abF();
  
  public abstract Intent abG();
  
  public abstract void abH();
  
  public abstract boolean abI();
  
  public abstract Bitmap b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString);
  
  public abstract void bS(Context paramContext);
  
  public abstract q jdMethod_do(boolean paramBoolean);
  
  public abstract String e(Context paramContext, String paramString1, String paramString2);
  
  public abstract String gY(String paramString);
  
  public abstract boolean gZ(String paramString);
  
  public abstract boolean ha(String paramString);
  
  public abstract void hb(String paramString);
  
  public abstract void kd(int paramInt);
  
  public abstract boolean r(Activity paramActivity);
  
  public abstract void s(Activity paramActivity);
  
  public abstract String t(Context paramContext, String paramString);
  
  public abstract boolean u(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l
 * JD-Core Version:    0.7.0.1
 */