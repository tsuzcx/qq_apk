package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected boolean HWg = true;
  protected com.tencent.mm.roomsdk.a.b.a HWh;
  protected com.tencent.mm.roomsdk.a.b.a HWi;
  protected com.tencent.mm.roomsdk.a.b.a HWj;
  protected p tipDialog;
  
  public static b wo(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c wp(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.HWh = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.HWi = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public abstract void cyR();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.HWj = parama;
    return this;
  }
  
  public final boolean fil()
  {
    return this.HWg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */