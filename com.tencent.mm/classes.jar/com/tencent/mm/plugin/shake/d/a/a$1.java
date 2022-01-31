package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qafpapi.QAFPNative;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] arg1, int paramInt)
  {
    g.a locala = new g.a();
    label396:
    for (;;)
    {
      long l;
      synchronized (this.oaF.ikx)
      {
        int i;
        if (this.oaF.oat == 408)
        {
          y.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
          i = QAFPNative.QAFPProcessTV(???, paramInt);
          l = bk.UY() - this.oaF.oaC;
          y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(this.oaF.oaz), Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.zJ()) });
          if (l <= this.oaF.oaD * 3000 + 4000) {
            break label396;
          }
          ??? = new byte[10240];
          ??? = new g.a();
          if (this.oaF.oat == 408)
          {
            y.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
            paramInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
            y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(this.oaF.oaz), Integer.valueOf(paramInt), Long.valueOf(???.zJ()) });
            if ((paramInt < 10240) && (paramInt > 0)) {
              break label298;
            }
            y.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(this.oaF.oaz), Integer.valueOf(paramInt) });
            this.oaF.reset();
          }
        }
        else
        {
          i = QAFPNative.QAFPProcess(???, paramInt);
        }
      }
      paramInt = QAFPNative.QAFPGetAudioFingerPrint((byte[])???);
      continue;
      label298:
      synchronized (this.oaF.oap)
      {
        System.arraycopy(???, 0, this.oaF.oap, 0, paramInt);
        this.oaF.oaq = paramInt;
        ??? = this.oaF;
        if (this.oaF.oaD >= 3)
        {
          bool = true;
          ((a)???).oay = bool;
          this.oaF.oar = ((int)(l / 1000L));
          this.oaF.Om();
          ??? = this.oaF;
          ???.oaD += 1;
          if (!this.oaF.oay) {
            continue;
          }
          y.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(this.oaF.oaz), Long.valueOf(l) });
          this.oaF.reset();
          return;
        }
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.1
 * JD-Core Version:    0.7.0.1
 */