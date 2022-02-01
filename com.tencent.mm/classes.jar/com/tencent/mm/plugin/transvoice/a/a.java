package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.al;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class a
{
  private static final String ixV;
  private final int BBw;
  private com.tencent.mm.sdk.b.c BBx;
  private h BBy;
  private com.tencent.mm.audio.e.a iyd;
  private com.tencent.mm.modelvoiceaddr.a.c iyt;
  private c.a iyu;
  
  static
  {
    AppMethodBeat.i(102626);
    ixV = al.IpN + "voice_temp.silk";
    AppMethodBeat.o(102626);
  }
  
  public a()
  {
    AppMethodBeat.i(185257);
    this.BBw = 16000;
    this.iyu = new c.a()
    {
      byte[] iyx;
      
      public final void NX()
      {
        AppMethodBeat.i(102623);
        ad.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(102623);
      }
      
      public final void aNS()
      {
        AppMethodBeat.i(102622);
        int i = (int)i.aYo(a.ers());
        ad.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
        if ((i > 0) && (a.c(a.this) != null))
        {
          ad.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
          a.c(a.this).qt(i);
        }
        AppMethodBeat.o(102622);
      }
      
      public final void aNT()
      {
        AppMethodBeat.i(102621);
        ad.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
        if (a.c(a.this) != null)
        {
          ad.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
          a.c(a.this).aNX();
        }
        if ((a.b(a.this) != null) && (!a.b(a.this).Rz())) {
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
        if ((this.iyx == null) || (this.iyx.length < paramAnonymousInt * 2)) {
          this.iyx = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.iyx[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.iyx[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (a.b(a.this) != null) {}
        for (paramAnonymousInt = a.b(a.this).a(new g.a(this.iyx, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
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
    this.BBx = new com.tencent.mm.sdk.b.c()
    {
      short[] iyv;
      
      private boolean a(sr paramAnonymoussr)
      {
        AppMethodBeat.i(102618);
        for (;;)
        {
          synchronized (a.this)
          {
            ad.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
            byte[] arrayOfByte = paramAnonymoussr.dHk.buf;
            int j = paramAnonymoussr.dHk.len;
            ad.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
            if ((this.iyv == null) || (this.iyv.length < j / 2))
            {
              this.iyv = new short[j / 2];
              break label200;
              if (i < j / 2)
              {
                this.iyv[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
                i += 1;
                continue;
              }
              if (a.a(a.this) != null)
              {
                a.a(a.this).e(this.iyv, j / 2);
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
      e locale = new e(ixV);
      if (!locale.exists()) {
        locale.mkdirs();
      }
      locale = new e(ixV);
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
    this.BBy = paramh;
    this.iyd = new com.tencent.mm.audio.e.c(16000, 23900);
    if (!this.iyd.gC(ixV))
    {
      ad.e("MicroMsg.CutShortSentence", "init speex writer failed");
      this.iyd.Ry();
      this.iyd = null;
      error(1);
    }
    try
    {
      this.iyt = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
      this.iyt.izb = this.iyu;
      com.tencent.mm.sdk.b.a.IbL.c(this.BBx);
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
  public final void err()
  {
    // Byte code:
    //   0: ldc 190
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 183	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   10: aload_0
    //   11: getfield 81	com/tencent/mm/plugin/transvoice/a/a:BBx	Lcom/tencent/mm/sdk/b/c;
    //   14: invokevirtual 192	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   17: pop
    //   18: aload_0
    //   19: getfield 129	com/tencent/mm/plugin/transvoice/a/a:iyd	Lcom/tencent/mm/audio/e/a;
    //   22: ifnull +17 -> 39
    //   25: aload_0
    //   26: getfield 129	com/tencent/mm/plugin/transvoice/a/a:iyd	Lcom/tencent/mm/audio/e/a;
    //   29: invokeinterface 167 1 0
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 129	com/tencent/mm/plugin/transvoice/a/a:iyd	Lcom/tencent/mm/audio/e/a;
    //   39: aload_0
    //   40: getfield 125	com/tencent/mm/plugin/transvoice/a/a:iyt	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +15 -> 60
    //   48: aload_0
    //   49: getfield 125	com/tencent/mm/plugin/transvoice/a/a:iyt	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   52: invokevirtual 195	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 125	com/tencent/mm/plugin/transvoice/a/a:iyt	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   60: aload_0
    //   61: getfield 133	com/tencent/mm/plugin/transvoice/a/a:BBy	Lcom/tencent/mm/modelvoiceaddr/h;
    //   64: ifnull +24 -> 88
    //   67: getstatic 53	com/tencent/mm/plugin/transvoice/a/a:ixV	Ljava/lang/String;
    //   70: invokestatic 201	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   73: l2i
    //   74: istore_1
    //   75: aload_0
    //   76: getfield 133	com/tencent/mm/plugin/transvoice/a/a:BBy	Lcom/tencent/mm/modelvoiceaddr/h;
    //   79: iload_1
    //   80: invokevirtual 206	com/tencent/mm/modelvoiceaddr/h:qt	(I)V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 133	com/tencent/mm/plugin/transvoice/a/a:BBy	Lcom/tencent/mm/modelvoiceaddr/h;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a
 * JD-Core Version:    0.7.0.1
 */