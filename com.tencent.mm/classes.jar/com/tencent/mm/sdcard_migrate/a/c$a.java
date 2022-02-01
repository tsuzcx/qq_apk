package com.tencent.mm.sdcard_migrate.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  private a acrS;
  private Context mContext;
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(257224);
    this.mContext = paramContext;
    this.acrS = new a();
    AppMethodBeat.o(257224);
  }
  
  public final a KB(boolean paramBoolean)
  {
    this.acrS.dqR = false;
    return this;
  }
  
  public final a a(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.acrS.acqU = paramOnClickListener;
    return this;
  }
  
  public final a ayk(int paramInt)
  {
    AppMethodBeat.i(257245);
    this.acrS.acqM = this.mContext.getString(paramInt);
    AppMethodBeat.o(257245);
    return this;
  }
  
  public final a b(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.acrS.acqV = paramOnClickListener;
    return this;
  }
  
  public final a buk(String paramString)
  {
    this.acrS.title = null;
    return this;
  }
  
  public final a bul(String paramString)
  {
    this.acrS.acqJ = paramString;
    return this;
  }
  
  public final a bum(String paramString)
  {
    this.acrS.acqM = paramString;
    return this;
  }
  
  public final a bun(String paramString)
  {
    this.acrS.acqN = paramString;
    return this;
  }
  
  public final c iTq()
  {
    AppMethodBeat.i(257263);
    c localc = new c(this.mContext);
    localc.a(this.acrS);
    AppMethodBeat.o(257263);
    return localc;
  }
  
  public static abstract interface c
  {
    public abstract CharSequence iTr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c.a
 * JD-Core Version:    0.7.0.1
 */