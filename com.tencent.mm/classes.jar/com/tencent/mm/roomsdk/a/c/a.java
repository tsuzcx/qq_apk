package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected boolean Iqo = true;
  protected com.tencent.mm.roomsdk.a.b.a Iqp;
  protected com.tencent.mm.roomsdk.a.b.a Iqq;
  protected com.tencent.mm.roomsdk.a.b.a Iqr;
  protected p tipDialog;
  
  public static b ww(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c wx(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Iqp = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Iqq = parama;
    return this;
  }
  
  public abstract void cAs();
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Iqr = parama;
    return this;
  }
  
  public final boolean fmd()
  {
    return this.Iqo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */