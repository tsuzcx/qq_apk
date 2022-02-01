package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends d.a
{
  private c cVe;
  private c.a cWj;
  private v2engine zVe;
  private short zVf;
  private short zVg;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.cWj = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(29394);
        ac.d("MicroMsg.MicRecoder", "pcm len: ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt <= 0)
        {
          ac.e("MicroMsg.MicRecoder", "pcm data too low");
          AppMethodBeat.o(29394);
          return;
        }
        f.a(f.this, paramAnonymousArrayOfByte, paramAnonymousInt);
        paramAnonymousInt = f.a(f.this).Send(paramAnonymousArrayOfByte, (short)paramAnonymousInt);
        if (paramAnonymousInt < 0)
        {
          ac.e("MicroMsg.MicRecoder", "send failed, ret: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(29394);
          return;
        }
        AppMethodBeat.o(29394);
      }
    };
    this.zVe = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void aIL()
  {
    AppMethodBeat.i(29397);
    this.cVe = new c(a.zVt, 1, 2);
    this.cVe.t(8, false);
    this.cVe.cVR = this.cWj;
    this.cVe.hH(20);
    this.cVe.Og();
    this.zVg = 0;
    this.zVf = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void ebj()
  {
    AppMethodBeat.i(29396);
    if (this.cVe != null)
    {
      this.cVe.NX();
      this.cVe = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int ebk()
  {
    if (this.zVg < this.zVf) {
      this.zVg = this.zVf;
    }
    if (this.zVg == 0) {
      return 0;
    }
    int i = (short)(this.zVf * 100 / this.zVg);
    this.zVf = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    ebj();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */