package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends c.a
{
  private v2engine MiZ;
  private short Mja;
  private short Mjb;
  private c frx;
  private com.tencent.mm.audio.b.c.a fsC;
  
  public e(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.fsC = new com.tencent.mm.audio.b.c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(29394);
        Log.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt <= 0)
        {
          Log.e("MicroMsg.MicRecoder", "pcm data too low");
          AppMethodBeat.o(29394);
          return;
        }
        e.a(e.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        paramAnonymousInt = e.a(e.this).Send(paramAnonymousArrayOfByte, (short)paramAnonymousInt);
        if (paramAnonymousInt < 0)
        {
          Log.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(29394);
          return;
        }
        AppMethodBeat.o(29394);
      }
    };
    this.MiZ = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void bpJ()
  {
    AppMethodBeat.i(29397);
    this.frx = new c(a.Mjo, 1, 2);
    this.frx.z(8, false);
    this.frx.fsk = this.fsC;
    this.frx.kD(20);
    this.frx.aeU();
    this.Mjb = 0;
    this.Mja = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void gii()
  {
    AppMethodBeat.i(29396);
    if (this.frx != null)
    {
      this.frx.aeJ();
      this.frx = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int gij()
  {
    if (this.Mjb < this.Mja) {
      this.Mjb = this.Mja;
    }
    if (this.Mjb == 0) {
      return 0;
    }
    int i = (short)(this.Mja * 100 / this.Mjb);
    this.Mja = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    gii();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.e
 * JD-Core Version:    0.7.0.1
 */