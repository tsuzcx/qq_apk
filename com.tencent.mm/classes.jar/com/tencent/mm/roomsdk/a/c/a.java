package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

public abstract class a
{
  protected p tipDialog;
  protected boolean yjH = true;
  protected com.tencent.mm.roomsdk.a.b.a yjI;
  protected com.tencent.mm.roomsdk.a.b.a yjJ;
  protected com.tencent.mm.roomsdk.a.b.a yjK;
  
  public static b pB(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c pC(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.yjI = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.yjJ = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.yjK = parama;
    return this;
  }
  
  public final boolean drm()
  {
    return this.yjH;
  }
  
  public abstract void drn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */