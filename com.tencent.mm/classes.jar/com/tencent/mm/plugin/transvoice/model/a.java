package com.tencent.mm.plugin.transvoice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class a
{
  private static final String pfs;
  private final int TTR;
  private IListener TTS;
  private h TTT;
  private com.tencent.mm.audio.e.a pfA;
  private com.tencent.mm.modelvoiceaddr.a.c pfQ;
  private c.a pfR;
  
  static
  {
    AppMethodBeat.i(102626);
    pfs = at.acHq + "voice_temp.silk";
    AppMethodBeat.o(102626);
  }
  
  public a()
  {
    AppMethodBeat.i(185257);
    this.TTR = 16000;
    this.pfR = new c.a()
    {
      byte[] pfU;
      
      public final void aEN()
      {
        AppMethodBeat.i(102623);
        Log.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(102623);
      }
      
      public final void bPB()
      {
        AppMethodBeat.i(102622);
        int i = (int)y.bEl(a.hPB());
        Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", new Object[] { Integer.valueOf(i) });
        if ((i > 0) && (a.c(a.this) != null))
        {
          Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
          a.c(a.this).xl(i);
        }
        AppMethodBeat.o(102622);
      }
      
      public final void bPC()
      {
        AppMethodBeat.i(102621);
        Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
        if (a.c(a.this) != null)
        {
          Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
          a.c(a.this).bPG();
        }
        if ((a.b(a.this) != null) && (!a.b(a.this).aIA())) {
          a.apo(1);
        }
        AppMethodBeat.o(102621);
      }
      
      public final void c(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(102620);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(102620);
          return;
        }
        if ((this.pfU == null) || (this.pfU.length < paramAnonymousInt * 2)) {
          this.pfU = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.pfU[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.pfU[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (a.b(a.this) != null) {}
        for (paramAnonymousInt = a.b(a.this).a(new g.a(this.pfU, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            a.apo(2);
            Log.e("MicroMsg.CutShortSentence", "write to file failed");
          }
          AppMethodBeat.o(102620);
          return;
        }
      }
    };
    Log.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", new Object[] { this });
    this.TTS = new CutShortSentence.1(this, f.hfK);
    Log.i("MicroMsg.CutShortSentence", "init cut sentence, time %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    try
    {
      u localu = new u(pfs);
      if (!localu.jKS()) {
        localu.jKY();
      }
      localu = new u(pfs);
      if (!localu.jKS()) {
        localu.jKZ();
      }
      localu.diJ();
      AppMethodBeat.o(185257);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CutShortSentence", localException, "delete file failed", new Object[0]);
      AppMethodBeat.o(185257);
    }
  }
  
  public static void apo(int paramInt)
  {
    AppMethodBeat.i(102625);
    Log.i("MicroMsg.CutShortSentence", "error localCode = %s.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(102625);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(185258);
    this.TTT = paramh;
    this.pfA = new com.tencent.mm.audio.e.c(16000, 23900);
    if (!this.pfA.jO(pfs))
    {
      Log.e("MicroMsg.CutShortSentence", "init speex writer failed");
      this.pfA.aIz();
      this.pfA = null;
      apo(1);
    }
    try
    {
      this.pfQ = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
      this.pfQ.pgz = this.pfR;
      this.TTS.alive();
      AppMethodBeat.o(185258);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CutShortSentence", paramh, "init VoiceDetectAPI failed", new Object[0]);
        apo(3);
      }
    }
  }
  
  /* Error */
  public final void hPA()
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 89	com/tencent/mm/plugin/transvoice/model/a:TTS	Lcom/tencent/mm/sdk/event/IListener;
    //   11: invokevirtual 195	com/tencent/mm/sdk/event/IListener:dead	()V
    //   14: aload_0
    //   15: getfield 146	com/tencent/mm/plugin/transvoice/model/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: getfield 146	com/tencent/mm/plugin/transvoice/model/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   25: invokeinterface 173 1 0
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 146	com/tencent/mm/plugin/transvoice/model/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   35: aload_0
    //   36: getfield 133	com/tencent/mm/plugin/transvoice/model/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +15 -> 56
    //   44: aload_0
    //   45: getfield 133	com/tencent/mm/plugin/transvoice/model/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   48: invokevirtual 198	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 133	com/tencent/mm/plugin/transvoice/model/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   56: aload_0
    //   57: getfield 150	com/tencent/mm/plugin/transvoice/model/a:TTT	Lcom/tencent/mm/modelvoiceaddr/h;
    //   60: ifnull +24 -> 84
    //   63: getstatic 53	com/tencent/mm/plugin/transvoice/model/a:pfs	Ljava/lang/String;
    //   66: invokestatic 204	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   69: l2i
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 150	com/tencent/mm/plugin/transvoice/model/a:TTT	Lcom/tencent/mm/modelvoiceaddr/h;
    //   75: iload_1
    //   76: invokevirtual 209	com/tencent/mm/modelvoiceaddr/h:xl	(I)V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 150	com/tencent/mm/plugin/transvoice/model/a:TTT	Lcom/tencent/mm/modelvoiceaddr/h;
    //   84: aload_0
    //   85: monitorexit
    //   86: ldc 192
    //   88: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore_2
    //   93: ldc 70
    //   95: aload_2
    //   96: ldc 211
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: goto -49 -> 56
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: ldc 192
    //   113: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	a
    //   70	6	1	i	int
    //   39	2	2	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   92	4	2	localException	Exception
    //   108	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	56	92	java/lang/Exception
    //   7	35	108	finally
    //   35	40	108	finally
    //   44	56	108	finally
    //   56	84	108	finally
    //   84	86	108	finally
    //   93	105	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.model.a
 * JD-Core Version:    0.7.0.1
 */