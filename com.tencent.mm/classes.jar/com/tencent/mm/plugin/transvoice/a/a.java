package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.tq.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a
{
  private static final String jwd;
  private final int GtA;
  private IListener GtB;
  private h GtC;
  private com.tencent.mm.modelvoiceaddr.a.c jwB;
  private c.a jwC;
  private com.tencent.mm.audio.e.a jwl;
  
  static
  {
    AppMethodBeat.i(102626);
    jwd = ar.NSe + "voice_temp.silk";
    AppMethodBeat.o(102626);
  }
  
  public a()
  {
    AppMethodBeat.i(185257);
    this.GtA = 16000;
    this.jwC = new c.a()
    {
      byte[] jwF;
      
      public final void Yh()
      {
        AppMethodBeat.i(102623);
        Log.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(102623);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(102620);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(102620);
          return;
        }
        if ((this.jwF == null) || (this.jwF.length < paramAnonymousInt * 2)) {
          this.jwF = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.jwF[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.jwF[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (a.b(a.this) != null) {}
        for (paramAnonymousInt = a.b(a.this).a(new g.a(this.jwF, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            a.error(2);
            Log.e("MicroMsg.CutShortSentence", "write to file failed");
          }
          AppMethodBeat.o(102620);
          return;
        }
      }
      
      public final void bix()
      {
        AppMethodBeat.i(102622);
        int i = (int)s.boW(a.fAs());
        Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
        if ((i > 0) && (a.c(a.this) != null))
        {
          Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
          a.c(a.this).ul(i);
        }
        AppMethodBeat.o(102622);
      }
      
      public final void biy()
      {
        AppMethodBeat.i(102621);
        Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
        if (a.c(a.this) != null)
        {
          Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
          a.c(a.this).biC();
        }
        if ((a.b(a.this) != null) && (!a.b(a.this).abQ())) {
          a.error(1);
        }
        AppMethodBeat.o(102621);
      }
    };
    Log.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", new Object[] { this });
    this.GtB = new IListener()
    {
      short[] jwD;
      
      private boolean a(tq paramAnonymoustq)
      {
        AppMethodBeat.i(102618);
        for (;;)
        {
          synchronized (a.this)
          {
            Log.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
            byte[] arrayOfByte = paramAnonymoustq.ead.buf;
            int j = paramAnonymoustq.ead.len;
            Log.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
            if ((this.jwD == null) || (this.jwD.length < j / 2))
            {
              this.jwD = new short[j / 2];
              break label200;
              if (i < j / 2)
              {
                this.jwD[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
                i += 1;
                continue;
              }
              if (a.a(a.this) != null)
              {
                a.a(a.this).e(this.jwD, j / 2);
                AppMethodBeat.o(102618);
                return false;
              }
              a.error(4);
              Log.e("MicroMsg.CutShortSentence", "mVoiceSilentDetectAPI is null");
            }
          }
          label200:
          int i = 0;
        }
      }
    };
    Log.i("MicroMsg.CutShortSentence", "init cut sentence, time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    try
    {
      o localo = new o(jwd);
      if (!localo.exists()) {
        localo.mkdirs();
      }
      localo = new o(jwd);
      if (!localo.exists()) {
        localo.createNewFile();
      }
      localo.delete();
      AppMethodBeat.o(185257);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CutShortSentence", localException, "delete file failed", new Object[0]);
      AppMethodBeat.o(185257);
    }
  }
  
  public static void error(int paramInt)
  {
    AppMethodBeat.i(102625);
    Log.i("MicroMsg.CutShortSentence", "error localCode = %s.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102625);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(185258);
    this.GtC = paramh;
    this.jwl = new com.tencent.mm.audio.e.c(16000, 23900);
    if (!this.jwl.hz(jwd))
    {
      Log.e("MicroMsg.CutShortSentence", "init speex writer failed");
      this.jwl.abP();
      this.jwl = null;
      error(1);
    }
    try
    {
      this.jwB = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
      this.jwB.jxj = this.jwC;
      EventCenter.instance.addListener(this.GtB);
      AppMethodBeat.o(185258);
      return;
    }
    catch (Throwable paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CutShortSentence", paramh, "init VoiceDetectAPI failed", new Object[0]);
        error(3);
      }
    }
  }
  
  /* Error */
  public final void fAr()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 183	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   10: aload_0
    //   11: getfield 81	com/tencent/mm/plugin/transvoice/a/a:GtB	Lcom/tencent/mm/sdk/event/IListener;
    //   14: invokevirtual 194	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   17: pop
    //   18: aload_0
    //   19: getfield 129	com/tencent/mm/plugin/transvoice/a/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   22: ifnull +17 -> 39
    //   25: aload_0
    //   26: getfield 129	com/tencent/mm/plugin/transvoice/a/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   29: invokeinterface 167 1 0
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 129	com/tencent/mm/plugin/transvoice/a/a:jwl	Lcom/tencent/mm/audio/e/a;
    //   39: aload_0
    //   40: getfield 125	com/tencent/mm/plugin/transvoice/a/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +15 -> 60
    //   48: aload_0
    //   49: getfield 125	com/tencent/mm/plugin/transvoice/a/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   52: invokevirtual 197	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 125	com/tencent/mm/plugin/transvoice/a/a:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   60: aload_0
    //   61: getfield 133	com/tencent/mm/plugin/transvoice/a/a:GtC	Lcom/tencent/mm/modelvoiceaddr/h;
    //   64: ifnull +24 -> 88
    //   67: getstatic 53	com/tencent/mm/plugin/transvoice/a/a:jwd	Ljava/lang/String;
    //   70: invokestatic 203	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   73: l2i
    //   74: istore_1
    //   75: aload_0
    //   76: getfield 133	com/tencent/mm/plugin/transvoice/a/a:GtC	Lcom/tencent/mm/modelvoiceaddr/h;
    //   79: iload_1
    //   80: invokevirtual 208	com/tencent/mm/modelvoiceaddr/h:ul	(I)V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 133	com/tencent/mm/plugin/transvoice/a/a:GtC	Lcom/tencent/mm/modelvoiceaddr/h;
    //   88: aload_0
    //   89: monitorexit
    //   90: ldc 191
    //   92: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_2
    //   97: ldc 70
    //   99: aload_2
    //   100: ldc 210
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -49 -> 60
    //   112: astore_2
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc 191
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a
 * JD-Core Version:    0.7.0.1
 */