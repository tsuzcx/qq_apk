package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.rw.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class a
{
  private static final String hDZ;
  private com.tencent.mm.audio.e.a hEh;
  private com.tencent.mm.modelvoiceaddr.a.c hEx;
  private c.a hEy;
  private final int yVV;
  private com.tencent.mm.sdk.b.c yVW;
  private h yVX;
  
  static
  {
    AppMethodBeat.i(102626);
    hDZ = ae.FfH + "voice_temp.silk";
    AppMethodBeat.o(102626);
  }
  
  public a()
  {
    AppMethodBeat.i(185257);
    this.yVV = 16000;
    this.hEy = new c.a()
    {
      byte[] hEB;
      
      public final void Mq()
      {
        AppMethodBeat.i(102623);
        ad.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(102623);
      }
      
      public final void aDS()
      {
        AppMethodBeat.i(102622);
        int i = (int)i.aMN(a.dQC());
        ad.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
        if ((i > 0) && (a.c(a.this) != null))
        {
          ad.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
          a.c(a.this).pc(i);
        }
        AppMethodBeat.o(102622);
      }
      
      public final void aDT()
      {
        AppMethodBeat.i(102621);
        ad.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
        if (a.c(a.this) != null)
        {
          ad.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
          a.c(a.this).aDX();
        }
        if ((a.b(a.this) != null) && (!a.b(a.this).PR())) {
          a.error(1);
        }
        AppMethodBeat.o(102621);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(102620);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(102620);
          return;
        }
        if ((this.hEB == null) || (this.hEB.length < paramAnonymousInt * 2)) {
          this.hEB = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.hEB[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.hEB[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (a.b(a.this) != null) {}
        for (paramAnonymousInt = a.b(a.this).a(new g.a(this.hEB, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            a.error(2);
            ad.e("MicroMsg.CutShortSentence", "write to file failed");
          }
          AppMethodBeat.o(102620);
          return;
        }
      }
    };
    ad.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", new Object[] { this });
    this.yVW = new com.tencent.mm.sdk.b.c()
    {
      short[] hEz;
      
      private boolean a(rw paramAnonymousrw)
      {
        AppMethodBeat.i(102618);
        for (;;)
        {
          synchronized (a.this)
          {
            ad.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
            byte[] arrayOfByte = paramAnonymousrw.dxw.buf;
            int j = paramAnonymousrw.dxw.len;
            ad.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
            if ((this.hEz == null) || (this.hEz.length < j / 2))
            {
              this.hEz = new short[j / 2];
              break label200;
              if (i < j / 2)
              {
                this.hEz[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
                i += 1;
                continue;
              }
              if (a.a(a.this) != null)
              {
                a.a(a.this).e(this.hEz, j / 2);
                AppMethodBeat.o(102618);
                return false;
              }
              a.error(4);
              ad.e("MicroMsg.CutShortSentence", "mVoiceSilentDetectAPI is null");
            }
          }
          label200:
          int i = 0;
        }
      }
    };
    ad.i("MicroMsg.CutShortSentence", "init cut sentence, time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    try
    {
      e locale = new e(hDZ);
      if (!locale.exists()) {
        locale.mkdirs();
      }
      locale = new e(hDZ);
      if (!locale.exists()) {
        locale.createNewFile();
      }
      locale.delete();
      AppMethodBeat.o(185257);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.CutShortSentence", localException, "delete file failed", new Object[0]);
      AppMethodBeat.o(185257);
    }
  }
  
  public static void error(int paramInt)
  {
    AppMethodBeat.i(102625);
    ad.i("MicroMsg.CutShortSentence", "error localCode = %s.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102625);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(185258);
    this.yVX = paramh;
    this.hEh = new com.tencent.mm.audio.e.c(16000, 23900);
    if (!this.hEh.fR(hDZ))
    {
      ad.e("MicroMsg.CutShortSentence", "init speex writer failed");
      this.hEh.PQ();
      this.hEh = null;
      error(1);
    }
    try
    {
      this.hEx = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
      this.hEx.hFf = this.hEy;
      com.tencent.mm.sdk.b.a.ESL.c(this.yVW);
      AppMethodBeat.o(185258);
      return;
    }
    catch (Throwable paramh)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CutShortSentence", paramh, "init VoiceDetectAPI failed", new Object[0]);
        error(3);
      }
    }
  }
  
  /* Error */
  public final void dQB()
  {
    // Byte code:
    //   0: ldc 190
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 183	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   10: aload_0
    //   11: getfield 81	com/tencent/mm/plugin/transvoice/a/a:yVW	Lcom/tencent/mm/sdk/b/c;
    //   14: invokevirtual 192	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   17: pop
    //   18: aload_0
    //   19: getfield 129	com/tencent/mm/plugin/transvoice/a/a:hEh	Lcom/tencent/mm/audio/e/a;
    //   22: ifnull +17 -> 39
    //   25: aload_0
    //   26: getfield 129	com/tencent/mm/plugin/transvoice/a/a:hEh	Lcom/tencent/mm/audio/e/a;
    //   29: invokeinterface 167 1 0
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 129	com/tencent/mm/plugin/transvoice/a/a:hEh	Lcom/tencent/mm/audio/e/a;
    //   39: aload_0
    //   40: getfield 125	com/tencent/mm/plugin/transvoice/a/a:hEx	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +15 -> 60
    //   48: aload_0
    //   49: getfield 125	com/tencent/mm/plugin/transvoice/a/a:hEx	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   52: invokevirtual 195	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 125	com/tencent/mm/plugin/transvoice/a/a:hEx	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   60: aload_0
    //   61: getfield 133	com/tencent/mm/plugin/transvoice/a/a:yVX	Lcom/tencent/mm/modelvoiceaddr/h;
    //   64: ifnull +24 -> 88
    //   67: getstatic 53	com/tencent/mm/plugin/transvoice/a/a:hDZ	Ljava/lang/String;
    //   70: invokestatic 201	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   73: l2i
    //   74: istore_1
    //   75: aload_0
    //   76: getfield 133	com/tencent/mm/plugin/transvoice/a/a:yVX	Lcom/tencent/mm/modelvoiceaddr/h;
    //   79: iload_1
    //   80: invokevirtual 206	com/tencent/mm/modelvoiceaddr/h:pc	(I)V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 133	com/tencent/mm/plugin/transvoice/a/a:yVX	Lcom/tencent/mm/modelvoiceaddr/h;
    //   88: aload_0
    //   89: monitorexit
    //   90: ldc 190
    //   92: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_2
    //   97: ldc 70
    //   99: aload_2
    //   100: ldc 208
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -49 -> 60
    //   112: astore_2
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc 190
    //   117: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	a
    //   74	6	1	i	int
    //   43	2	2	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   96	4	2	localException	Exception
    //   112	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   48	60	96	java/lang/Exception
    //   7	39	112	finally
    //   39	44	112	finally
    //   48	60	112	finally
    //   60	88	112	finally
    //   88	90	112	finally
    //   97	109	112	finally
    //   113	115	112	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a
 * JD-Core Version:    0.7.0.1
 */