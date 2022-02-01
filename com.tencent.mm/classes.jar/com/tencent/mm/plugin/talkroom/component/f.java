package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends d.a
{
  private v2engine BmI;
  private short BmJ;
  private short BmK;
  private c dgu;
  private c.a dhz;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.dhz = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(29394);
        ad.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt <= 0)
        {
          ad.e("MicroMsg.MicRecoder", "pcm data too low");
          AppMethodBeat.o(29394);
          return;
        }
        f.a(f.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        paramAnonymousInt = f.a(f.this).Send(paramAnonymousArrayOfByte, (short)paramAnonymousInt);
        if (paramAnonymousInt < 0)
        {
          ad.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(29394);
          return;
        }
        AppMethodBeat.o(29394);
      }
    };
    this.BmI = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void aLV()
  {
    AppMethodBeat.i(29397);
    this.dgu = new c(a.BmX, 1, 2);
    this.dgu.t(8, false);
    this.dgu.dhh = this.dhz;
    this.dgu.hO(20);
    this.dgu.PP();
    this.BmK = 0;
    this.BmJ = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void enA()
  {
    AppMethodBeat.i(29396);
    if (this.dgu != null)
    {
      this.dgu.PG();
      this.dgu = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int enB()
  {
    if (this.BmK < this.BmJ) {
      this.BmK = this.BmJ;
    }
    if (this.BmK == 0) {
      return 0;
    }
    int i = (short)(this.BmJ * 100 / this.BmK);
    this.BmJ = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    enA();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */