package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected boolean Gku = true;
  protected com.tencent.mm.roomsdk.a.b.a Gkv;
  protected com.tencent.mm.roomsdk.a.b.a Gkw;
  protected com.tencent.mm.roomsdk.a.b.a Gkx;
  protected p tipDialog;
  
  public static b vC(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c vD(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Gkv = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Gkw = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public abstract void csU();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Gkx = parama;
    return this;
  }
  
  public final boolean eSJ()
  {
    return this.Gku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */