package com.tencent.mm.roomsdk.model.factory;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.w;

public abstract class a
{
  protected boolean acmw = true;
  protected com.tencent.mm.roomsdk.model.b.a acmx;
  protected com.tencent.mm.roomsdk.model.b.a acmy;
  protected com.tencent.mm.roomsdk.model.b.a acmz;
  protected w tipDialog;
  
  public static b Kp(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c Kq(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.model.b.a parama)
  {
    this.acmx = parama;
    return this;
  }
  
  public abstract void blj();
  
  public final a c(com.tencent.mm.roomsdk.model.b.a parama)
  {
    this.acmy = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.model.b.a parama)
  {
    this.acmz = parama;
    return this;
  }
  
  public final boolean iRT()
  {
    return this.acmw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.factory.a
 * JD-Core Version:    0.7.0.1
 */