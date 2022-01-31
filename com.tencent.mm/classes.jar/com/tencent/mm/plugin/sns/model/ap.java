package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ap
{
  boolean fWq;
  boolean fWr;
  long rim;
  private boolean rin;
  int rio;
  int rip;
  c<rx> riq;
  c rir;
  c ris;
  
  ap()
  {
    AppMethodBeat.i(36607);
    this.rim = 0L;
    this.fWq = false;
    this.fWr = false;
    this.rin = false;
    this.rio = 0;
    this.rip = 1440;
    this.riq = new ap.1(this);
    this.rir = new c() {};
    this.ris = new c() {};
    AppMethodBeat.o(36607);
  }
  
  final boolean cpF()
  {
    AppMethodBeat.i(36608);
    Object localObject = g.Nq().getValue("SnsImgPreLoadingTimeLimit");
    ab.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(36608);
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = bo.apV(arrayOfString[0]);
      this.rio = (bo.apV(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bo.apV(localObject[0]);
      this.rip = (bo.apV(localObject[1]) + i * 60);
      ab.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.rio), Integer.valueOf(this.rip) });
      AppMethodBeat.o(36608);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36608);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */