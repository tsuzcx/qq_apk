package com.tencent.tmediacodec.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.f;

public final class a
{
  private final b ZPc;
  private final b ZPd;
  
  public a()
  {
    AppMethodBeat.i(224488);
    this.ZPc = new b(2, "keep");
    this.ZPd = new b(2147483647, "running");
    this.ZPc.ZPg = new c()
    {
      public final void i(f paramAnonymousf)
      {
        AppMethodBeat.i(224472);
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          "onErase codecWrapper:".concat(String.valueOf(paramAnonymousf));
          com.tencent.tmediacodec.g.b.bDP("CodecWrapperManager");
        }
        paramAnonymousf.recycle();
        AppMethodBeat.o(224472);
      }
    };
    AppMethodBeat.o(224488);
  }
  
  public final f c(com.tencent.tmediacodec.b.e parame)
  {
    AppMethodBeat.i(224482);
    parame = this.ZPc.d(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtainCodecWrapper codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.bDP("CodecWrapperManager");
    }
    AppMethodBeat.o(224482);
    return parame;
  }
  
  public final void f(final f paramf)
  {
    AppMethodBeat.i(224473);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transToRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bDP("CodecWrapperManager");
    }
    this.ZPc.l(paramf);
    this.ZPd.j(paramf);
    com.tencent.tmediacodec.g.e.bi(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224468);
        com.tencent.tmediacodec.a.a locala = paramf.ZOv;
        if (locala != null) {
          locala.onTransToRunningPool();
        }
        AppMethodBeat.o(224468);
      }
    });
    AppMethodBeat.o(224473);
  }
  
  public final void g(f paramf)
  {
    AppMethodBeat.i(224476);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "removeFromRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bDP("CodecWrapperManager");
    }
    this.ZPd.l(paramf);
    AppMethodBeat.o(224476);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(224479);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transTokeep codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bDP("CodecWrapperManager");
    }
    this.ZPd.l(paramf);
    this.ZPc.j(paramf);
    paramf = paramf.ZOv;
    if (paramf != null) {
      paramf.onTransToKeepPool();
    }
    AppMethodBeat.o(224479);
  }
  
  public final void ith()
  {
    AppMethodBeat.i(224484);
    if (com.tencent.tmediacodec.g.b.isLogEnable()) {
      com.tencent.tmediacodec.g.b.bDQ("CodecWrapperManager");
    }
    this.ZPd.clear();
    this.ZPc.clear();
    AppMethodBeat.o(224484);
  }
  
  public final String iti()
  {
    AppMethodBeat.i(224487);
    String str = "runningPool:" + this.ZPd + " keepPool:" + this.ZPc;
    AppMethodBeat.o(224487);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.c.a
 * JD-Core Version:    0.7.0.1
 */