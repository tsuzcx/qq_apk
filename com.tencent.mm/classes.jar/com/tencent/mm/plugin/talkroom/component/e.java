package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.talkroom.model.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends c.a
{
  private v2engine SMv;
  private short SMw;
  private short SMx;
  private c hvI;
  private com.tencent.mm.audio.b.c.a hwR;
  
  public e(v2engine paramv2engine)
  {
    AppMethodBeat.i(29395);
    this.hwR = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
    this.SMv = paramv2engine;
    AppMethodBeat.o(29395);
  }
  
  public final void bNp()
  {
    AppMethodBeat.i(29397);
    this.hvI = new c(a.SMK, 1, 2);
    this.hvI.O(8, false);
    this.hvI.hwy = this.hwR;
    this.hvI.ok(20);
    this.hvI.aGR();
    this.SMx = 0;
    this.SMw = 0;
    AppMethodBeat.o(29397);
  }
  
  public final void hCj()
  {
    AppMethodBeat.i(29396);
    if (this.hvI != null)
    {
      this.hvI.aGH();
      this.hvI = null;
    }
    AppMethodBeat.o(29396);
  }
  
  public final int hCk()
  {
    if (this.SMx < this.SMw) {
      this.SMx = this.SMw;
    }
    if (this.SMx == 0) {
      return 0;
    }
    int i = (short)(this.SMw * 100 / this.SMx);
    this.SMw = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(29398);
    hCj();
    AppMethodBeat.o(29398);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.e
 * JD-Core Version:    0.7.0.1
 */