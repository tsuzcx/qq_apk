package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.q;

public abstract class a
{
  protected boolean NDL = true;
  protected com.tencent.mm.roomsdk.a.b.a NDM;
  protected com.tencent.mm.roomsdk.a.b.a NDN;
  protected com.tencent.mm.roomsdk.a.b.a NDO;
  protected q tipDialog;
  
  public static b Aw(boolean paramBoolean)
  {
    return new b(paramBoolean);
  }
  
  public static c Ax(boolean paramBoolean)
  {
    return new c(paramBoolean);
  }
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void aJu();
  
  public final a b(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.NDM = parama;
    return this;
  }
  
  public final a c(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.NDN = parama;
    return this;
  }
  
  public abstract void cancel();
  
  public final a d(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.NDO = parama;
    return this;
  }
  
  public final boolean gvP()
  {
    return this.NDL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */