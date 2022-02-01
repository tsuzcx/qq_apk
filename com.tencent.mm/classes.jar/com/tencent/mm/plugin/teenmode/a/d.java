package com.tencent.mm.plugin.teenmode.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.storage.au;
import java.util.HashMap;

public abstract interface d
  extends com.tencent.mm.kernel.c.a
{
  public abstract <T extends a> void a(int paramInt, T paramT);
  
  public abstract void a(int paramInt, b paramb);
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, d.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, Boolean paramBoolean);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract void a(g paramg);
  
  public abstract boolean a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract boolean a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb);
  
  public abstract boolean aBu();
  
  public abstract a aoi(int paramInt);
  
  public abstract b aoj(int paramInt);
  
  public abstract void b(g paramg);
  
  public abstract boolean bdk(String paramString);
  
  public abstract boolean jdMethod_do(int paramInt, String paramString);
  
  public abstract int eZD();
  
  public abstract void hEp();
  
  public abstract int hEq();
  
  public abstract int hEr();
  
  public abstract void hEs();
  
  public abstract boolean hEt();
  
  public abstract au hEu();
  
  public abstract HashMap<Integer, String> hEv();
  
  public abstract void kg(Context paramContext);
  
  public abstract void kh(Context paramContext);
  
  public abstract void n(Activity paramActivity, int paramInt);
  
  public abstract void rG(int paramInt);
  
  public abstract void setScene(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.a.d
 * JD-Core Version:    0.7.0.1
 */