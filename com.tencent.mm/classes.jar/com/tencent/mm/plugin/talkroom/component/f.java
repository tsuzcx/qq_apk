package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends d.a
{
  private v2engine BEh;
  private short BEi;
  private short BEj;
  private c dhw;
  private c.a diC;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.diC = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(29394);
        ae.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt <= 0)
        {
          ae.e("MicroMsg.MicRecoder", "pcm data too low");
          AppMethodBeat.o(29394);
          return;
        }
        f.a(f.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        paramAnonymousInt = f.a(f.this).Send(paramAnonymousArrayOfByte, (short)paramAnonymousInt);
        if (paramAnonymousInt < 0)
        {
          ae.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(29394);
          return;
        }
        AppMethodBeat.o(29394);
      }
    };
    this.BEh = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void aMs()
  {
    AppMethodBeat.i(29397);
    this.dhw = new c(a.BEw, 1, 2);
    this.dhw.t(8, false);
    this.dhw.dij = this.diC;
    this.dhw.hQ(20);
    this.dhw.PO();
    this.BEj = 0;
    this.BEi = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void erh()
  {
    AppMethodBeat.i(29396);
    if (this.dhw != null)
    {
      this.dhw.PF();
      this.dhw = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int eri()
  {
    if (this.BEj < this.BEi) {
      this.BEj = this.BEi;
    }
    if (this.BEj == 0) {
      return 0;
    }
    int i = (short)(this.BEi * 100 / this.BEj);
    this.BEi = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    erh();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */