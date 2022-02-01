package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.j;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import com.tencent.qqpinyin.voicerecoapi.c.a;
import java.util.LinkedList;

public final class p
  implements g
{
  public static final String AEP;
  public com.tencent.mm.plugin.wear.model.d.c AEQ;
  public com.tencent.qqpinyin.voicerecoapi.c AER;
  public d AES;
  private int AET;
  public int AEU;
  public int AEV;
  public boolean dDS;
  public LinkedList<Integer> jhB;
  
  static
  {
    AppMethodBeat.i(30107);
    AEP = ae.FfH + "tmp_wearvoicetotext.spx";
    AppMethodBeat.o(30107);
  }
  
  public p()
  {
    AppMethodBeat.i(30103);
    this.dDS = false;
    this.AET = 0;
    this.jhB = new LinkedList();
    AppMethodBeat.o(30103);
  }
  
  public final void a(int paramInt, dse paramdse)
  {
    AppMethodBeat.i(30106);
    if (paramdse.CAF == null)
    {
      ad.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
      AppMethodBeat.o(30106);
      return;
    }
    Object localObject = paramdse.CAF.toByteArray();
    this.AET += this.AES.a(new g.a((byte[])localObject, paramdse.CJI), 0, false);
    ad.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[] { Integer.valueOf(this.AET) });
    short[] arrayOfShort = new short[paramdse.CJI / 2];
    int i = 0;
    while (i < paramdse.CJI / 2)
    {
      arrayOfShort[i] = ((short)(localObject[(i * 2)] & 0xFF | localObject[(i * 2 + 1)] << 8));
      i += 1;
    }
    localObject = new c.a();
    this.AER.a(arrayOfShort, paramdse.CJI / 2, (c.a)localObject);
    ad.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + ((c.a)localObject).IpI);
    if (((c.a)localObject).IpI == 2) {
      this.AEV = 1;
    }
    for (;;)
    {
      if (this.AEV != 0)
      {
        if (this.AEV < 0)
        {
          if (this.jhB.size() > 10) {
            this.jhB.removeLast();
          }
          this.jhB.addFirst(Integer.valueOf(paramInt));
        }
        if (this.AEV == 1)
        {
          paramdse = new dsf();
          paramdse.Egc = this.AEQ.talker;
          paramdse.CIE = "";
          paramdse.Ctr = this.AEV;
          paramdse.EGS = true;
          a.egW().a(new a(this.AEQ.dcS, paramdse));
          this.AEV = 0;
        }
      }
      if ((!this.dDS) && (this.AET > 3300))
      {
        this.dDS = true;
        az.aeS().a(this.AEQ, 0);
      }
      AppMethodBeat.o(30106);
      return;
      if (((c.a)localObject).IpI == 3) {
        this.AEV = 2;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(30105);
    if ((paramn instanceof com.tencent.mm.plugin.wear.model.d.c))
    {
      paramString = (com.tencent.mm.plugin.wear.model.d.c)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        az.aeS().b(349, this);
        paramn = new dsf();
        paramn.Egc = paramString.talker;
        paramn.CIE = "";
        paramn.Ctr = -1;
        paramn.EGS = false;
        a.egW().a(new a(paramString.dcS, paramn));
        AppMethodBeat.o(30105);
        return;
      }
      if (paramString.AEG)
      {
        az.aeS().b(349, this);
        paramn = new dsf();
        paramn.Egc = paramString.talker;
        if (bt.isNullOrNil(paramString.AEF)) {
          break label213;
        }
        ad.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[] { paramString.AEF });
        paramn.CIE = paramString.AEF;
        paramn.Ctr = 0;
      }
    }
    for (paramn.EGS = true;; paramn.EGS = false)
    {
      a.egW().a(new a(paramString.dcS, paramn));
      AppMethodBeat.o(30105);
      return;
      label213:
      paramn.CIE = "";
      paramn.Ctr = -1;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(30104);
    ad.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[] { Integer.valueOf(this.AEU) });
    if (this.AES != null)
    {
      this.AES.PQ();
      this.AES = null;
      ad.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
    }
    if (this.AER != null)
    {
      this.AER.stop();
      this.AER = null;
      ad.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
    }
    if (this.AEQ != null)
    {
      this.AEQ.hCh = true;
      az.aeS().b(349, this);
      az.aeS().a(this.AEQ);
      this.AEQ = null;
    }
    this.AEV = 0;
    this.dDS = false;
    this.AET = 0;
    this.AEU = -1;
    this.jhB.clear();
    AppMethodBeat.o(30104);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.c
  {
    public dsf AEX;
    public int AEm = 2;
    public int dcS;
    public int hrg;
    
    public a(int paramInt, dsf paramdsf)
    {
      this.dcS = paramInt;
      this.hrg = 30001;
      this.AEX = paramdsf;
    }
    
    public final String getName()
    {
      return "WearVoiceToTextTask";
    }
    
    /* Error */
    public final void send()
    {
      // Byte code:
      //   0: sipush 30102
      //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 30	com/tencent/mm/plugin/wear/model/e/p$a:AEX	Lcom/tencent/mm/protocal/protobuf/dsf;
      //   10: invokevirtual 50	com/tencent/mm/protocal/protobuf/dsf:toByteArray	()[B
      //   13: astore_1
      //   14: invokestatic 56	com/tencent/mm/plugin/wear/model/a:egV	()Lcom/tencent/mm/plugin/wear/model/d;
      //   17: aload_1
      //   18: invokevirtual 62	com/tencent/mm/plugin/wear/model/d:bX	([B)[B
      //   21: astore_2
      //   22: new 64	java/io/ByteArrayOutputStream
      //   25: dup
      //   26: invokespecial 65	java/io/ByteArrayOutputStream:<init>	()V
      //   29: astore_1
      //   30: new 67	java/io/DataOutputStream
      //   33: dup
      //   34: aload_1
      //   35: invokespecial 70	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   38: astore_3
      //   39: aload_3
      //   40: aload_0
      //   41: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:AEm	I
      //   44: invokevirtual 73	java/io/DataOutputStream:writeInt	(I)V
      //   47: aload_3
      //   48: aload_0
      //   49: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:dcS	I
      //   52: invokevirtual 73	java/io/DataOutputStream:writeInt	(I)V
      //   55: aload_3
      //   56: aload_0
      //   57: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:hrg	I
      //   60: invokevirtual 73	java/io/DataOutputStream:writeInt	(I)V
      //   63: aload_2
      //   64: ifnull +91 -> 155
      //   67: aload_2
      //   68: arraylength
      //   69: ifle +86 -> 155
      //   72: aload_3
      //   73: aload_2
      //   74: arraylength
      //   75: invokevirtual 73	java/io/DataOutputStream:writeInt	(I)V
      //   78: aload_3
      //   79: aload_2
      //   80: invokevirtual 77	java/io/DataOutputStream:write	([B)V
      //   83: aload_1
      //   84: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   87: astore_2
      //   88: ldc 80
      //   90: ldc 82
      //   92: iconst_2
      //   93: anewarray 84	java/lang/Object
      //   96: dup
      //   97: iconst_0
      //   98: aload_0
      //   99: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:hrg	I
      //   102: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   105: aastore
      //   106: dup
      //   107: iconst_1
      //   108: aload_2
      //   109: arraylength
      //   110: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   113: aastore
      //   114: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   117: invokestatic 56	com/tencent/mm/plugin/wear/model/a:egV	()Lcom/tencent/mm/plugin/wear/model/d;
      //   120: aload_1
      //   121: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   124: invokevirtual 99	com/tencent/mm/plugin/wear/model/d:bV	([B)Z
      //   127: pop
      //   128: sipush 30102
      //   131: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: return
      //   135: astore_1
      //   136: ldc 80
      //   138: aload_1
      //   139: ldc 104
      //   141: iconst_0
      //   142: anewarray 84	java/lang/Object
      //   145: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   148: sipush 30102
      //   151: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: return
      //   155: aload_3
      //   156: iconst_0
      //   157: invokevirtual 73	java/io/DataOutputStream:writeInt	(I)V
      //   160: goto -77 -> 83
      //   163: astore_1
      //   164: ldc 80
      //   166: aload_1
      //   167: ldc 110
      //   169: iconst_3
      //   170: anewarray 84	java/lang/Object
      //   173: dup
      //   174: iconst_0
      //   175: aload_0
      //   176: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:AEm	I
      //   179: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   182: aastore
      //   183: dup
      //   184: iconst_1
      //   185: aload_0
      //   186: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:dcS	I
      //   189: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   192: aastore
      //   193: dup
      //   194: iconst_2
      //   195: aload_0
      //   196: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:hrg	I
      //   199: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   202: aastore
      //   203: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   206: sipush 30102
      //   209: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p
 * JD-Core Version:    0.7.0.1
 */