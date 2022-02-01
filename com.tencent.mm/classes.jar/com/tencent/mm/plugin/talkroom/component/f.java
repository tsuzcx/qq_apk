package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends d.a
{
  private v2engine FOY;
  private short FOZ;
  private short FPa;
  private c dyI;
  private c.a dzN;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.dzN = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
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
        f.a(f.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        paramAnonymousInt = f.a(f.this).Send(paramAnonymousArrayOfByte, (short)paramAnonymousInt);
        if (paramAnonymousInt < 0)
        {
          Log.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(29394);
          return;
        }
        AppMethodBeat.o(29394);
      }
    };
    this.FOY = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void bgt()
  {
    AppMethodBeat.i(29397);
    this.dyI = new c(a.FPn, 1, 2);
    this.dyI.x(8, false);
    this.dyI.dzv = this.dzN;
    this.dyI.jk(20);
    this.dyI.aai();
    this.FPa = 0;
    this.FOZ = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void ftI()
  {
    AppMethodBeat.i(29396);
    if (this.dyI != null)
    {
      this.dyI.ZZ();
      this.dyI = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int ftJ()
  {
    if (this.FPa < this.FOZ) {
      this.FPa = this.FOZ;
    }
    if (this.FPa == 0) {
      return 0;
    }
    int i = (short)(this.FOZ * 100 / this.FPa);
    this.FOZ = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    ftI();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */