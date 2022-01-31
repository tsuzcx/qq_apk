package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected p tipDialog;
  protected boolean ubr = true;
  protected com.tencent.mm.roomsdk.a.b.a ubs;
  protected com.tencent.mm.roomsdk.a.b.a ubt;
  protected com.tencent.mm.roomsdk.a.b.a ubu;
  
  public static b mm(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c mn(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ubs = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ubt = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final boolean cpy()
  {
    return this.ubr;
  }
  
  public abstract void cpz();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ubu = parama;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */