package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected boolean ENi = true;
  protected com.tencent.mm.roomsdk.a.b.a ENj;
  protected com.tencent.mm.roomsdk.a.b.a ENk;
  protected com.tencent.mm.roomsdk.a.b.a ENl;
  protected p tipDialog;
  
  public static b uA(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c uB(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ENj = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ENk = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ENl = parama;
    return this;
  }
  
  public final boolean eDo()
  {
    return this.ENi;
  }
  
  public abstract void eDp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */