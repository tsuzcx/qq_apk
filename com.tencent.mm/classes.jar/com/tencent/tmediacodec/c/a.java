package com.tencent.tmediacodec.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.f;

public final class a
{
  private final b Smr;
  private final b Sms;
  
  public a()
  {
    AppMethodBeat.i(190153);
    this.Smr = new b(2, "keep");
    this.Sms = new b(2147483647, "running");
    this.Smr.Smv = new c()
    {
      public final void i(f paramAnonymousf)
      {
        AppMethodBeat.i(190146);
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          "onErase codecWrapper:".concat(String.valueOf(paramAnonymousf));
          com.tencent.tmediacodec.g.b.bqQ("CodecWrapperManager");
        }
        paramAnonymousf.recycle();
        AppMethodBeat.o(190146);
      }
    };
    AppMethodBeat.o(190153);
  }
  
  public final f c(com.tencent.tmediacodec.b.e parame)
  {
    AppMethodBeat.i(190150);
    parame = this.Smr.d(parame);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "obtainCodecWrapper codecWrapper:".concat(String.valueOf(parame));
      com.tencent.tmediacodec.g.b.bqQ("CodecWrapperManager");
    }
    AppMethodBeat.o(190150);
    return parame;
  }
  
  public final void f(final f paramf)
  {
    AppMethodBeat.i(190147);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transToRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bqQ("CodecWrapperManager");
    }
    this.Smr.l(paramf);
    this.Sms.j(paramf);
    com.tencent.tmediacodec.g.e.bb(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190145);
        com.tencent.tmediacodec.a.a locala = paramf.SlK;
        if (locala != null) {
          locala.onTransToRunningPool();
        }
        AppMethodBeat.o(190145);
      }
    });
    AppMethodBeat.o(190147);
  }
  
  public final void g(f paramf)
  {
    AppMethodBeat.i(190148);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "removeFromRunning codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bqQ("CodecWrapperManager");
    }
    this.Sms.l(paramf);
    AppMethodBeat.o(190148);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(190149);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      "transTokeep codecWrapper:".concat(String.valueOf(paramf));
      com.tencent.tmediacodec.g.b.bqQ("CodecWrapperManager");
    }
    this.Sms.l(paramf);
    this.Smr.j(paramf);
    paramf = paramf.SlK;
    if (paramf != null) {
      paramf.onTransToKeepPool();
    }
    AppMethodBeat.o(190149);
  }
  
  public final void hpB()
  {
    AppMethodBeat.i(190151);
    if (com.tencent.tmediacodec.g.b.isLogEnable()) {
      com.tencent.tmediacodec.g.b.bqR("CodecWrapperManager");
    }
    this.Sms.clear();
    this.Smr.clear();
    AppMethodBeat.o(190151);
  }
  
  public final String hpC()
  {
    AppMethodBeat.i(190152);
    String str = "runningPool:" + this.Sms + " keepPool:" + this.Smr;
    AppMethodBeat.o(190152);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.c.a
 * JD-Core Version:    0.7.0.1
 */