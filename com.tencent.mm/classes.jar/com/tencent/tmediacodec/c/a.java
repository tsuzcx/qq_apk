package com.tencent.tmediacodec.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.f;

public final class a
{
  private final b ahUd;
  private final b ahUe;
  
  public a()
  {
    AppMethodBeat.i(210742);
    this.ahUd = new b(2, "keep");
    this.ahUe = new b(2147483647, "running");
    this.ahUd.ahUh = new c()
    {
      public final void i(f paramAnonymousf)
      {
        AppMethodBeat.i(210746);
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          "onErase codecWrapper:".concat(String.valueOf(paramAnonymousf));
          com.tencent.tmediacodec.g.b.O("CodecWrapperManager");
        }
        paramAnonymousf.recycle();
        AppMethodBeat.o(210746);
      }
    };
    AppMethodBeat.o(210742);
  }
  
  public final f c(com.tencent.tmediacodec.b.e parame)
  {
    AppMethodBeat.i(210789);
    parame = this.ahUd.d(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtainCodecWrapper codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.O("CodecWrapperManager");
    }
    AppMethodBeat.o(210789);
    return parame;
  }
  
  public final void f(final f paramf)
  {
    AppMethodBeat.i(210751);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transToRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.O("CodecWrapperManager");
    }
    this.ahUd.l(paramf);
    this.ahUe.j(paramf);
    com.tencent.tmediacodec.g.e.br(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210754);
        com.tencent.tmediacodec.a.a locala = paramf.ahTw;
        if (locala != null) {
          locala.onTransToRunningPool();
        }
        AppMethodBeat.o(210754);
      }
    });
    AppMethodBeat.o(210751);
  }
  
  public final void g(f paramf)
  {
    AppMethodBeat.i(210767);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "removeFromRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.O("CodecWrapperManager");
    }
    this.ahUe.l(paramf);
    AppMethodBeat.o(210767);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(210780);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transTokeep codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.O("CodecWrapperManager");
    }
    this.ahUe.l(paramf);
    this.ahUd.j(paramf);
    paramf = paramf.ahTw;
    if (paramf != null) {
      paramf.onTransToKeepPool();
    }
    AppMethodBeat.o(210780);
  }
  
  public final void kcB()
  {
    AppMethodBeat.i(210800);
    if (com.tencent.tmediacodec.g.b.isLogEnable()) {
      com.tencent.tmediacodec.g.b.Q("CodecWrapperManager");
    }
    this.ahUe.clear();
    this.ahUd.clear();
    AppMethodBeat.o(210800);
  }
  
  public final String kcC()
  {
    AppMethodBeat.i(210807);
    String str = "runningPool:" + this.ahUe + " keepPool:" + this.ahUd;
    AppMethodBeat.o(210807);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.c.a
 * JD-Core Version:    0.7.0.1
 */