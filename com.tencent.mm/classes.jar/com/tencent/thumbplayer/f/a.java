package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;

public final class a
{
  public b RVM;
  private String mTag;
  
  public a(b paramb)
  {
    AppMethodBeat.i(189267);
    this.RVM = paramb;
    this.mTag = this.RVM.tag;
    AppMethodBeat.o(189267);
  }
  
  public a(b paramb, String paramString)
  {
    AppMethodBeat.i(189268);
    this.RVM = new b(paramb, paramString);
    this.mTag = this.RVM.tag;
    AppMethodBeat.o(189268);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(189269);
    if (paramb == null)
    {
      this.RVM = new b(this.mTag);
      AppMethodBeat.o(189269);
      return;
    }
    this.RVM = paramb;
    AppMethodBeat.o(189269);
  }
  
  public final void debug(String paramString)
  {
    AppMethodBeat.i(189271);
    g.d(this.RVM.tag, paramString);
    AppMethodBeat.o(189271);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(189274);
    g.e(this.RVM.tag, paramString);
    AppMethodBeat.o(189274);
  }
  
  public final void info(String paramString)
  {
    AppMethodBeat.i(189272);
    g.i(this.RVM.tag, paramString);
    AppMethodBeat.o(189272);
  }
  
  public final void r(Exception paramException)
  {
    AppMethodBeat.i(189270);
    g.e(this.RVM.tag, paramException);
    AppMethodBeat.o(189270);
  }
  
  public final void warn(String paramString)
  {
    AppMethodBeat.i(189273);
    g.w(this.RVM.tag, paramString);
    AppMethodBeat.o(189273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.f.a
 * JD-Core Version:    0.7.0.1
 */