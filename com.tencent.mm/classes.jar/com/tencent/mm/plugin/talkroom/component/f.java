package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends d.a
{
  private c cXI;
  private c.a cYN;
  private v2engine yHQ;
  private short yHR;
  private short yHS;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.cYN = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
    this.yHQ = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void aBV()
  {
    AppMethodBeat.i(29397);
    this.cXI = new c(a.yIf, 1, 2);
    this.cXI.t(8, false);
    this.cXI.cYv = this.cYN;
    this.cXI.hX(20);
    this.cXI.Ok();
    this.yHS = 0;
    this.yHR = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void dMJ()
  {
    AppMethodBeat.i(29396);
    if (this.cXI != null)
    {
      this.cXI.Ob();
      this.cXI = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int dMK()
  {
    if (this.yHS < this.yHR) {
      this.yHS = this.yHR;
    }
    if (this.yHS == 0) {
      return 0;
    }
    int i = (short)(this.yHR * 100 / this.yHS);
    this.yHR = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    dMJ();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */