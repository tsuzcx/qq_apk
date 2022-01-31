package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.io.File;

public final class a
{
  private static final String gbo;
  public com.tencent.mm.modelvoiceaddr.a.c gbF;
  public c.a gbG;
  public com.tencent.mm.audio.e.a gbw;
  private final int tpf;
  public com.tencent.mm.sdk.b.c tpg;
  public h tph;
  public a.a tpi;
  
  static
  {
    AppMethodBeat.i(155199);
    gbo = ac.eQv + "voice_temp.silk";
    AppMethodBeat.o(155199);
  }
  
  public a(a.a parama)
  {
    AppMethodBeat.i(155197);
    this.tpf = 16000;
    this.gbG = new a.2(this);
    ab.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", new Object[] { this });
    this.tpi = parama;
    this.tpg = new com.tencent.mm.sdk.b.c()
    {
      short[] gbH;
      
      private boolean a(qe paramAnonymousqe)
      {
        AppMethodBeat.i(155191);
        for (;;)
        {
          synchronized (a.this)
          {
            ab.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
            byte[] arrayOfByte = paramAnonymousqe.cGK.buf;
            int j = paramAnonymousqe.cGK.len;
            ab.d("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
            if ((this.gbH == null) || (this.gbH.length < j / 2))
            {
              this.gbH = new short[j / 2];
              break label200;
              if (i < j / 2)
              {
                this.gbH[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
                i += 1;
                continue;
              }
              if (a.a(a.this) != null)
              {
                a.a(a.this).f(this.gbH, j / 2);
                AppMethodBeat.o(155191);
                return false;
              }
              a.error(4);
              ab.e("MicroMsg.CutShortSentence", "mVoiceSilentDetectAPI is null");
            }
          }
          label200:
          int i = 0;
        }
      }
    };
    ab.i("MicroMsg.CutShortSentence", "init cut sentence, time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    try
    {
      parama = new File(gbo);
      if (!parama.exists()) {
        parama.mkdir();
      }
      parama = new File(gbo);
      if (!parama.exists()) {
        parama.createNewFile();
      }
      parama.delete();
      AppMethodBeat.o(155197);
      return;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace("MicroMsg.CutShortSentence", parama, "delete file failed", new Object[0]);
      AppMethodBeat.o(155197);
    }
  }
  
  public static String cKW()
  {
    return gbo;
  }
  
  public static void error(int paramInt)
  {
    AppMethodBeat.i(155198);
    ab.i("MicroMsg.CutShortSentence", "error localCode = %s.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(155198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a
 * JD-Core Version:    0.7.0.1
 */