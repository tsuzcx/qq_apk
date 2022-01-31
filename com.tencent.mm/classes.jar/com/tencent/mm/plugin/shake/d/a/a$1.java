package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qafpapi.QAFPNative;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] arg1, int paramInt)
  {
    AppMethodBeat.i(24589);
    g.a locala = new g.a();
    long l;
    for (;;)
    {
      synchronized (this.qOO.clk)
      {
        int i;
        if (this.qOO.qOC == 408)
        {
          ab.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
          i = QAFPNative.QAFPProcessTV(???, paramInt);
          l = bo.aoy() - this.qOO.qOL;
          ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(this.qOO.qOI), Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.Mm()) });
          if (l <= this.qOO.qOM * 3000 + 4000) {
            break label414;
          }
          ??? = new byte[10240];
          ??? = new g.a();
          if (this.qOO.qOC == 408)
          {
            ab.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
            paramInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
            ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(this.qOO.qOI), Integer.valueOf(paramInt), Long.valueOf(???.Mm()) });
            if ((paramInt < 10240) && (paramInt > 0)) {
              break;
            }
            ab.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(this.qOO.qOI), Integer.valueOf(paramInt) });
            this.qOO.reset();
            AppMethodBeat.o(24589);
          }
        }
        else
        {
          i = QAFPNative.QAFPProcess(???, paramInt);
        }
      }
      paramInt = QAFPNative.QAFPGetAudioFingerPrint((byte[])???);
    }
    synchronized (this.qOO.qOy)
    {
      System.arraycopy(???, 0, this.qOO.qOy, 0, paramInt);
      this.qOO.qOz = paramInt;
      ??? = this.qOO;
      if (this.qOO.qOM >= 3)
      {
        bool = true;
        ((a)???).qOH = bool;
        this.qOO.qOA = ((int)(l / 1000L));
        this.qOO.ahb();
        ??? = this.qOO;
        ???.qOM += 1;
        label414:
        if (this.qOO.qOH)
        {
          ab.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(this.qOO.qOI), Long.valueOf(l) });
          this.qOO.reset();
        }
        AppMethodBeat.o(24589);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.1
 * JD-Core Version:    0.7.0.1
 */