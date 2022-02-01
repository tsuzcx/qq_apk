package com.tencent.mm.sdcard_migrate.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  private a UWH;
  private Context mContext;
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(191995);
    this.mContext = paramContext;
    this.UWH = new a();
    AppMethodBeat.o(191995);
  }
  
  public final a EP(boolean paramBoolean)
  {
    this.UWH.bxO = false;
    return this;
  }
  
  public final a a(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.UWH.UVJ = paramOnClickListener;
    return this;
  }
  
  public final a asf(int paramInt)
  {
    AppMethodBeat.i(192003);
    this.UWH.UVB = this.mContext.getString(paramInt);
    AppMethodBeat.o(192003);
    return this;
  }
  
  public final a b(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.UWH.UVK = paramOnClickListener;
    return this;
  }
  
  public final a bul(String paramString)
  {
    this.UWH.Ig = null;
    return this;
  }
  
  public final a bum(String paramString)
  {
    this.UWH.UVy = paramString;
    return this;
  }
  
  public final a bun(String paramString)
  {
    this.UWH.UVB = paramString;
    return this;
  }
  
  public final a buo(String paramString)
  {
    this.UWH.UVC = paramString;
    return this;
  }
  
  public final c htk()
  {
    AppMethodBeat.i(192015);
    c localc = new c(this.mContext);
    localc.a(this.UWH);
    AppMethodBeat.o(192015);
    return localc;
  }
  
  public static abstract interface c
  {
    public abstract CharSequence htl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c.a
 * JD-Core Version:    0.7.0.1
 */