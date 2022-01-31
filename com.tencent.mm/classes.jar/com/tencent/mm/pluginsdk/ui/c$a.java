package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
  implements i.a
{
  Bitmap jVm = null;
  private i.a pFL;
  
  public c$a(i.a parama)
  {
    this.pFL = parama;
  }
  
  public final Bitmap AY()
  {
    AppMethodBeat.i(79672);
    Bitmap localBitmap;
    if ((this.jVm != null) && (!this.jVm.isRecycled()))
    {
      localBitmap = this.jVm;
      AppMethodBeat.o(79672);
      return localBitmap;
    }
    if (this.pFL != null)
    {
      localBitmap = this.pFL.AY();
      AppMethodBeat.o(79672);
      return localBitmap;
    }
    AppMethodBeat.o(79672);
    return null;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(79673);
    if (this.pFL != null) {
      this.pFL.a(parami);
    }
    AppMethodBeat.o(79673);
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(79669);
    if (this.pFL != null)
    {
      paramString = this.pFL.b(paramString, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(79669);
      return paramString;
    }
    AppMethodBeat.o(79669);
    return null;
  }
  
  public final Bitmap dt(String paramString)
  {
    AppMethodBeat.i(79670);
    if (this.pFL != null)
    {
      paramString = this.pFL.dt(paramString);
      AppMethodBeat.o(79670);
      return paramString;
    }
    AppMethodBeat.o(79670);
    return null;
  }
  
  public final Bitmap du(String paramString)
  {
    AppMethodBeat.i(79671);
    if (this.pFL != null)
    {
      paramString = this.pFL.du(paramString);
      AppMethodBeat.o(79671);
      return paramString;
    }
    AppMethodBeat.o(79671);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c.a
 * JD-Core Version:    0.7.0.1
 */