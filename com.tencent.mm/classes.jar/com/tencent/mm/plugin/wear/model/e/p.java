package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.protocal.protobuf.fkm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.qqpinyin.voicerecoapi.c.a;
import java.util.LinkedList;

public final class p
  implements i
{
  public static final String PsA;
  public com.tencent.mm.plugin.wear.model.d.c PsB;
  public com.tencent.qqpinyin.voicerecoapi.c PsC;
  public d PsD;
  private int PsE;
  public int PsF;
  public int PsG;
  public boolean gbt;
  public LinkedList<Integer> odL;
  
  static
  {
    AppMethodBeat.i(30107);
    PsA = ar.Vgb + "tmp_wearvoicetotext.spx";
    AppMethodBeat.o(30107);
  }
  
  public p()
  {
    AppMethodBeat.i(30103);
    this.gbt = false;
    this.PsE = 0;
    this.odL = new LinkedList();
    AppMethodBeat.o(30103);
  }
  
  public final void a(int paramInt, fkl paramfkl)
  {
    AppMethodBeat.i(30106);
    if (paramfkl.RLr == null)
    {
      Log.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
      AppMethodBeat.o(30106);
      return;
    }
    Object localObject = paramfkl.RLr.toByteArray();
    this.PsE += this.PsD.a(new g.a((byte[])localObject, paramfkl.RVD), 0, false);
    Log.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[] { Integer.valueOf(this.PsE) });
    short[] arrayOfShort = new short[paramfkl.RVD / 2];
    int i = 0;
    while (i < paramfkl.RVD / 2)
    {
      arrayOfShort[i] = ((short)(localObject[(i * 2)] & 0xFF | localObject[(i * 2 + 1)] << 8));
      i += 1;
    }
    localObject = new c.a();
    this.PsC.a(arrayOfShort, paramfkl.RVD / 2, (c.a)localObject);
    Log.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + ((c.a)localObject).Znr);
    if (((c.a)localObject).Znr == 2) {
      this.PsG = 1;
    }
    for (;;)
    {
      if (this.PsG != 0)
      {
        if (this.PsG < 0)
        {
          if (this.odL.size() > 10) {
            this.odL.removeLast();
          }
          this.odL.addFirst(Integer.valueOf(paramInt));
        }
        if (this.PsG == 1)
        {
          paramfkl = new fkm();
          paramfkl.Ueg = this.PsB.talker;
          paramfkl.RUd = "";
          paramfkl.SZN = this.PsG;
          paramfkl.UJg = true;
          a.gOu().a(new a(this.PsB.fwM, paramfkl));
          this.PsG = 0;
        }
      }
      if ((!this.gbt) && (this.PsE > 3300))
      {
        this.gbt = true;
        bh.aGY().a(this.PsB, 0);
      }
      AppMethodBeat.o(30106);
      return;
      if (((c.a)localObject).Znr == 3) {
        this.PsG = 2;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(30105);
    if ((paramq instanceof com.tencent.mm.plugin.wear.model.d.c))
    {
      paramString = (com.tencent.mm.plugin.wear.model.d.c)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        bh.aGY().b(349, this);
        paramq = new fkm();
        paramq.Ueg = paramString.talker;
        paramq.RUd = "";
        paramq.SZN = -1;
        paramq.UJg = false;
        a.gOu().a(new a(paramString.fwM, paramq));
        AppMethodBeat.o(30105);
        return;
      }
      if (paramString.Psr)
      {
        bh.aGY().b(349, this);
        paramq = new fkm();
        paramq.Ueg = paramString.talker;
        if (Util.isNullOrNil(paramString.Psq)) {
          break label213;
        }
        Log.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[] { paramString.Psq });
        paramq.RUd = paramString.Psq;
        paramq.SZN = 0;
      }
    }
    for (paramq.UJg = true;; paramq.UJg = false)
    {
      a.gOu().a(new a(paramString.fwM, paramq));
      AppMethodBeat.o(30105);
      return;
      label213:
      paramq.RUd = "";
      paramq.SZN = -1;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(30104);
    Log.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[] { Integer.valueOf(this.PsF) });
    if (this.PsD != null)
    {
      this.PsD.agC();
      this.PsD = null;
      Log.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
    }
    if (this.PsC != null)
    {
      this.PsC.stop();
      this.PsC = null;
      Log.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
    }
    if (this.PsB != null)
    {
      this.PsB.mjP = true;
      bh.aGY().b(349, this);
      bh.aGY().a(this.PsB);
      this.PsB = null;
    }
    this.PsG = 0;
    this.gbt = false;
    this.PsE = 0;
    this.PsF = -1;
    this.odL.clear();
    AppMethodBeat.o(30104);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.c
  {
    public fkm PsI;
    public int Psa = 2;
    public int fwM;
    public int lYT;
    
    public a(int paramInt, fkm paramfkm)
    {
      this.fwM = paramInt;
      this.lYT = 30001;
      this.PsI = paramfkm;
    }
    
    /* Error */
    public final void gOA()
    {
      // Byte code:
      //   0: sipush 30102
      //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 30	com/tencent/mm/plugin/wear/model/e/p$a:PsI	Lcom/tencent/mm/protocal/protobuf/fkm;
      //   10: invokevirtual 46	com/tencent/mm/protocal/protobuf/fkm:toByteArray	()[B
      //   13: astore_1
      //   14: invokestatic 52	com/tencent/mm/plugin/wear/model/a:gOt	()Lcom/tencent/mm/plugin/wear/model/d;
      //   17: aload_1
      //   18: invokevirtual 58	com/tencent/mm/plugin/wear/model/d:cO	([B)[B
      //   21: astore_2
      //   22: new 60	java/io/ByteArrayOutputStream
      //   25: dup
      //   26: invokespecial 61	java/io/ByteArrayOutputStream:<init>	()V
      //   29: astore_1
      //   30: new 63	java/io/DataOutputStream
      //   33: dup
      //   34: aload_1
      //   35: invokespecial 66	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   38: astore_3
      //   39: aload_3
      //   40: aload_0
      //   41: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:Psa	I
      //   44: invokevirtual 69	java/io/DataOutputStream:writeInt	(I)V
      //   47: aload_3
      //   48: aload_0
      //   49: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:fwM	I
      //   52: invokevirtual 69	java/io/DataOutputStream:writeInt	(I)V
      //   55: aload_3
      //   56: aload_0
      //   57: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:lYT	I
      //   60: invokevirtual 69	java/io/DataOutputStream:writeInt	(I)V
      //   63: aload_2
      //   64: ifnull +91 -> 155
      //   67: aload_2
      //   68: arraylength
      //   69: ifle +86 -> 155
      //   72: aload_3
      //   73: aload_2
      //   74: arraylength
      //   75: invokevirtual 69	java/io/DataOutputStream:writeInt	(I)V
      //   78: aload_3
      //   79: aload_2
      //   80: invokevirtual 73	java/io/DataOutputStream:write	([B)V
      //   83: aload_1
      //   84: invokevirtual 74	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   87: astore_2
      //   88: ldc 76
      //   90: ldc 78
      //   92: iconst_2
      //   93: anewarray 80	java/lang/Object
      //   96: dup
      //   97: iconst_0
      //   98: aload_0
      //   99: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:lYT	I
      //   102: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   105: aastore
      //   106: dup
      //   107: iconst_1
      //   108: aload_2
      //   109: arraylength
      //   110: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   113: aastore
      //   114: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   117: invokestatic 52	com/tencent/mm/plugin/wear/model/a:gOt	()Lcom/tencent/mm/plugin/wear/model/d;
      //   120: aload_1
      //   121: invokevirtual 74	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   124: invokevirtual 95	com/tencent/mm/plugin/wear/model/d:cM	([B)Z
      //   127: pop
      //   128: sipush 30102
      //   131: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: return
      //   135: astore_1
      //   136: ldc 76
      //   138: aload_1
      //   139: ldc 100
      //   141: iconst_0
      //   142: anewarray 80	java/lang/Object
      //   145: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   148: sipush 30102
      //   151: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: return
      //   155: aload_3
      //   156: iconst_0
      //   157: invokevirtual 69	java/io/DataOutputStream:writeInt	(I)V
      //   160: goto -77 -> 83
      //   163: astore_1
      //   164: ldc 76
      //   166: aload_1
      //   167: ldc 106
      //   169: iconst_3
      //   170: anewarray 80	java/lang/Object
      //   173: dup
      //   174: iconst_0
      //   175: aload_0
      //   176: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:Psa	I
      //   179: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   182: aastore
      //   183: dup
      //   184: iconst_1
      //   185: aload_0
      //   186: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:fwM	I
      //   189: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   192: aastore
      //   193: dup
      //   194: iconst_2
      //   195: aload_0
      //   196: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:lYT	I
      //   199: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   202: aastore
      //   203: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   206: sipush 30102
      //   209: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	213	0	this	a
      //   13	108	1	localObject	Object
      //   135	4	1	localIOException1	java.io.IOException
      //   163	4	1	localIOException2	java.io.IOException
      //   21	88	2	arrayOfByte	byte[]
      //   38	118	3	localDataOutputStream	java.io.DataOutputStream
      // Exception table:
      //   from	to	target	type
      //   6	22	135	java/io/IOException
      //   39	63	163	java/io/IOException
      //   67	83	163	java/io/IOException
      //   83	128	163	java/io/IOException
      //   155	160	163	java/io/IOException
    }
    
    public final String getName()
    {
      return "WearVoiceToTextTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p
 * JD-Core Version:    0.7.0.1
 */