package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;

public final class a
{
  public b Zyw;
  private String mTag;
  
  public a(b paramb)
  {
    AppMethodBeat.i(220735);
    this.Zyw = paramb;
    this.mTag = this.Zyw.tag;
    AppMethodBeat.o(220735);
  }
  
  public a(b paramb, String paramString)
  {
    AppMethodBeat.i(220736);
    this.Zyw = new b(paramb, paramString);
    this.mTag = this.Zyw.tag;
    AppMethodBeat.o(220736);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(220741);
    if (paramb == null)
    {
      this.Zyw = new b(this.mTag);
      AppMethodBeat.o(220741);
      return;
    }
    this.Zyw = paramb;
    AppMethodBeat.o(220741);
  }
  
  public final void bDx(String paramString)
  {
    AppMethodBeat.i(220744);
    g.d(this.Zyw.tag, paramString);
    AppMethodBeat.o(220744);
  }
  
  public final void bDy(String paramString)
  {
    AppMethodBeat.i(220745);
    g.i(this.Zyw.tag, paramString);
    AppMethodBeat.o(220745);
  }
  
  public final void bDz(String paramString)
  {
    AppMethodBeat.i(220747);
    g.w(this.Zyw.tag, paramString);
    AppMethodBeat.o(220747);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(220748);
    g.e(this.Zyw.tag, paramString);
    AppMethodBeat.o(220748);
  }
  
  public final void n(Exception paramException)
  {
    AppMethodBeat.i(220742);
    g.e(this.Zyw.tag, paramException);
    AppMethodBeat.o(220742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.f.a
 * JD-Core Version:    0.7.0.1
 */