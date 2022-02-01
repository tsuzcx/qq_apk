package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.s;

public abstract class a
{
  protected boolean URi = true;
  protected com.tencent.mm.roomsdk.a.b.a URj;
  protected com.tencent.mm.roomsdk.a.b.a URk;
  protected com.tencent.mm.roomsdk.a.b.a URl;
  protected s tipDialog;
  
  public static b ED(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c EE(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void aRu();
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.URj = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.URk = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.URl = parama;
    return this;
  }
  
  public final boolean hrN()
  {
    return this.URi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */