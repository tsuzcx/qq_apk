package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.f.a.us;
import com.tencent.mm.f.a.us.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class a
{
  private static final String mlG;
  private final int NgT;
  private IListener NgU;
  private h NgV;
  private com.tencent.mm.audio.e.a mlO;
  private com.tencent.mm.modelvoiceaddr.a.c mme;
  private c.a mmf;
  
  static
  {
    AppMethodBeat.i(102626);
    mlG = ar.Vgb + "voice_temp.silk";
    AppMethodBeat.o(102626);
  }
  
  public a()
  {
    AppMethodBeat.i(185257);
    this.NgT = 16000;
    this.mmf = new c.a()
    {
      byte[] mmi;
      
      public final void acN()
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
        if ((this.mmi == null) || (this.mmi.length < paramAnonymousInt * 2)) {
          this.mmi = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.mmi[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.mmi[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (a.b(a.this) != null) {}
        for (paramAnonymousInt = a.b(a.this).a(new g.a(this.mmi, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            a.ajV(2);
            Log.e("MicroMsg.CutShortSentence", "write to file failed");
          }
          AppMethodBeat.o(102620);
          return;
        }
      }
      
      public final void brV()
      {
        AppMethodBeat.i(102622);
        int i = (int)u.bBQ(a.gst());
        Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
        if ((i > 0) && (a.c(a.this) != null))
        {
          Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
          a.c(a.this).xl(i);
        }
        AppMethodBeat.o(102622);
      }
      
      public final void brW()
      {
        AppMethodBeat.i(102621);
        Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
        if (a.c(a.this) != null)
        {
          Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
          a.c(a.this).bsa();
        }
        if ((a.b(a.this) != null) && (!a.b(a.this).agD())) {
          a.ajV(1);
        }
        AppMethodBeat.o(102621);
      }
    };
    Log.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", new Object[] { this });
    this.NgU = new IListener()
    {
      short[] mmg;
      
      private boolean a(us paramAnonymousus)
      {
        AppMethodBeat.i(102618);
        for (;;)
        {
          synchronized (a.this)
          {
            Log.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
            byte[] arrayOfByte = paramAnonymousus.fTY.buf;
            int j = paramAnonymousus.fTY.fTZ;
            Log.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
            if ((this.mmg == null) || (this.mmg.length < j / 2))
            {
              this.mmg = new short[j / 2];
              break label200;
              if (i < j / 2)
              {
                this.mmg[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
                i += 1;
                continue;
              }
              if (a.a(a.this) != null)
              {
                a.a(a.this).e(this.mmg, j / 2);
                AppMethodBeat.o(102618);
                return false;
              }
              a.ajV(4);
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
      q localq = new q(mlG);
      if (!localq.ifE()) {
        localq.ifK();
      }
      localq = new q(mlG);
      if (!localq.ifE()) {
        localq.ifM();
      }
      localq.cFq();
      AppMethodBeat.o(185257);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CutShortSentence", localException, "delete file failed", new Object[0]);
      AppMethodBeat.o(185257);
    }
  }
  
  public static void ajV(int paramInt)
  {
    AppMethodBeat.i(102625);
    Log.i("MicroMsg.CutShortSentence", "error localCode = %s.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102625);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(185258);
    this.NgV = paramh;
    this.mlO = new com.tencent.mm.audio.e.c(16000, 23900);
    if (!this.mlO.in(mlG))
    {
      Log.e("MicroMsg.CutShortSentence", "init speex writer failed");
      this.mlO.agC();
      this.mlO = null;
      ajV(1);
    }
    try
    {
      this.mme = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
      this.mme.mmM = this.mmf;
      EventCenter.instance.addListener(this.NgU);
      AppMethodBeat.o(185258);
      return;
    }
    catch (Throwable paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CutShortSentence", paramh, "init VoiceDetectAPI failed", new Object[0]);
        ajV(3);
      }
    }
  }
  
  /* Error */
  public final void gss()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 183	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   10: aload_0
    //   11: getfield 81	com/tencent/mm/plugin/transvoice/a/a:NgU	Lcom/tencent/mm/sdk/event/IListener;
    //   14: invokevirtual 194	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   17: pop
    //   18: aload_0
    //   19: getfield 138	com/tencent/mm/plugin/transvoice/a/a:mlO	Lcom/tencent/mm/audio/e/a;
    //   22: ifnull +17 -> 39
    //   25: aload_0
    //   26: getfield 138	com/tencent/mm/plugin/transvoice/a/a:mlO	Lcom/tencent/mm/audio/e/a;
    //   29: invokeinterface 167 1 0
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 138	com/tencent/mm/plugin/transvoice/a/a:mlO	Lcom/tencent/mm/audio/e/a;
    //   39: aload_0
    //   40: getfield 125	com/tencent/mm/plugin/transvoice/a/a:mme	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +15 -> 60
    //   48: aload_0
    //   49: getfield 125	com/tencent/mm/plugin/transvoice/a/a:mme	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   52: invokevirtual 197	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 125	com/tencent/mm/plugin/transvoice/a/a:mme	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   60: aload_0
    //   61: getfield 142	com/tencent/mm/plugin/transvoice/a/a:NgV	Lcom/tencent/mm/modelvoiceaddr/h;
    //   64: ifnull +24 -> 88
    //   67: getstatic 53	com/tencent/mm/plugin/transvoice/a/a:mlG	Ljava/lang/String;
    //   70: invokestatic 203	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   73: l2i
    //   74: istore_1
    //   75: aload_0
    //   76: getfield 142	com/tencent/mm/plugin/transvoice/a/a:NgV	Lcom/tencent/mm/modelvoiceaddr/h;
    //   79: iload_1
    //   80: invokevirtual 208	com/tencent/mm/modelvoiceaddr/h:xl	(I)V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 142	com/tencent/mm/plugin/transvoice/a/a:NgV	Lcom/tencent/mm/modelvoiceaddr/h;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.a
 * JD-Core Version:    0.7.0.1
 */