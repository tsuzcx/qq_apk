package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;

public final class a
{
  public b ahDz;
  private String mTag;
  
  public a(b paramb)
  {
    AppMethodBeat.i(226930);
    this.ahDz = paramb;
    this.mTag = this.ahDz.tag;
    AppMethodBeat.o(226930);
  }
  
  public a(b paramb, String paramString)
  {
    AppMethodBeat.i(226933);
    this.ahDz = new b(paramb, paramString);
    this.mTag = this.ahDz.tag;
    AppMethodBeat.o(226933);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(226937);
    if (paramb == null)
    {
      this.ahDz = new b(this.mTag);
      AppMethodBeat.o(226937);
      return;
    }
    this.ahDz = paramb;
    AppMethodBeat.o(226937);
  }
  
  public final void bGe(String paramString)
  {
    AppMethodBeat.i(226949);
    g.i(this.ahDz.tag, paramString);
    AppMethodBeat.o(226949);
  }
  
  public final void bGf(String paramString)
  {
    AppMethodBeat.i(226955);
    g.w(this.ahDz.tag, paramString);
    AppMethodBeat.o(226955);
  }
  
  public final void debug(String paramString)
  {
    AppMethodBeat.i(226946);
    g.d(this.ahDz.tag, paramString);
    AppMethodBeat.o(226946);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(226957);
    g.e(this.ahDz.tag, paramString);
    AppMethodBeat.o(226957);
  }
  
  public final void p(Exception paramException)
  {
    AppMethodBeat.i(226941);
    g.e(this.ahDz.tag, paramException);
    AppMethodBeat.o(226941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.f.a
 * JD-Core Version:    0.7.0.1
 */