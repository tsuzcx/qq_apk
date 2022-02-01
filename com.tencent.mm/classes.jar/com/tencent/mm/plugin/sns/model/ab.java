package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.a.uy.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ab
{
  private String clientId;
  int dJd;
  int giN;
  private long iSB;
  String ibe;
  private g.a ibn;
  int itF;
  private String ksR;
  private String mPath;
  long startTime;
  private String thumbPath;
  t ziN;
  a ziO;
  private byq ziP;
  
  /* Error */
  public ab(int paramInt, t paramt, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: ldc 44
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 52
    //   12: putfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/ab:iSB	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/ab:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/ab:giN	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/ab:ksR	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/byq
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/byq:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/ab$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/ab$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ab;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/ab:ibn	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/ab:iSB	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/ab:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/ab:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/ab:ziO	Lcom/tencent/mm/plugin/sns/model/ab$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/ab:dJd	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/ab:ziN	Lcom/tencent/mm/plugin/sns/storage/t;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/byq
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/byq:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/t:zNr	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/byq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/byq
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/byq:GTF	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/byq:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/ab:ksR	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   140: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 112	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 116	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   157: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 130	java/lang/String:getBytes	()[B
    //   166: invokestatic 136	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   169: putfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/byq:GTF	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/ab:ziP	Lcom/tencent/mm/protocal/protobuf/byq;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/byq:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/t:zNr	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/ag:dTT	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   197: aload_2
    //   198: getfield 148	com/tencent/mm/plugin/sns/storage/t:zMC	I
    //   201: aload_2
    //   202: invokevirtual 153	com/tencent/mm/plugin/sns/storage/u:a	(ILcom/tencent/mm/plugin/sns/storage/t;)I
    //   205: pop
    //   206: ldc 155
    //   208: ldc 157
    //   210: iconst_4
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: iload_1
    //   217: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_3
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload_3
    //   228: invokestatic 169	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/ab:ksR	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 44
    //   248: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 155
    //   255: ldc 179
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 44
    //   262: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 155
    //   269: aload_2
    //   270: ldc 52
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 187	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -73 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	ab
    //   0	282	1	paramInt	int
    //   0	282	2	paramt	t
    //   0	282	3	paramString1	String
    //   0	282	4	paramString2	String
    //   0	282	5	parama	a
    // Exception table:
    //   from	to	target	type
    //   93	114	252	java/lang/Exception
    //   183	206	266	java/lang/Exception
  }
  
  final void PO(int paramInt)
  {
    AppMethodBeat.i(95705);
    ad.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = ag.dTT().Aj(this.dJd);
    try
    {
      byq localbyq = (byq)new byq().parseFrom(localt.zNr);
      localbyq.GPx = 1;
      localbyq.GTo = paramInt;
      if (this.ziP.GTI != null) {
        this.ziP.GTI.sJZ = 0;
      }
      localt.zNr = localbyq.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    ag.dUd().PT(this.dJd);
    ag.dTT().a(this.dJd, localt);
    AppMethodBeat.o(95705);
  }
  
  final boolean a(bxm parambxm, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = bt.flT();
      this.giN = com.tencent.mm.i.a.fID;
    }
    String str = this.clientId;
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    g localg = new g();
    localg.fJi = "task_NetSceneSnsUpload_2";
    localg.fJj = this.ibn;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.fID;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fIw;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!bt.isNullOrNil(paramString))
    {
      localg.field_largesvideo = ax.aQA("OpenSdkVideoTime").decodeInt(paramString, 10);
      paramString = com.tencent.mm.vfs.i.aPK(this.mPath);
      if ((!bt.isNullOrNil(this.ksR)) && (!this.ksR.equals(paramString)))
      {
        ad.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ksR, paramString });
        PO(-2);
        this.ziO.rl(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.d.aGQ();
      if (parambxm.GRA) {}
      for (paramString = com.tencent.mm.modelcontrol.d.aGQ().aGS();; paramString = com.tencent.mm.modelcontrol.d.aGQ().aGT())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(paramString);
        break;
      }
    }
    if (!f.aGI().f(localg))
    {
      ad.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((parambxm != null) && (parambxm.GRA)) {}
    for (int i = 4;; i = 5)
    {
      this.itF = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    t localt = ag.dTT().Aj(this.dJd);
    ad.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localt.zNq = paramString3;
    try
    {
      paramString3 = (byq)new byq().parseFrom(localt.zNr);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new byq();
      }
      paramString3 = new byi();
      paramString3.nEf = 1;
      paramString3.Url = paramString1;
      ((byq)localObject).GTC = paramString3;
      ((byq)localObject).GPx = 0;
      f.aGJ();
      ((byq)localObject).GTd = com.tencent.mm.ao.a.EL(this.mPath);
      ad.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((byq)localObject).GTd });
      if (!bt.isNullOrNil(paramString2))
      {
        paramString1 = new byi();
        paramString1.nEf = 1;
        paramString1.Url = paramString2;
        ((byq)localObject).GTE.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localt.zNr = ((byq)localObject).toByteArray();
        localt.dZj();
        ag.dTT().a(this.dJd, localt);
        ag.dUd().PT(this.dJd);
        if (ag.dUa() != null) {
          ag.dUa().dSE();
        }
        AppMethodBeat.o(95704);
        return true;
        paramString3 = paramString3;
        paramString3 = null;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean ayS(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = com.tencent.mm.vfs.i.aPK(this.mPath);
    if ((!bt.isNullOrNil(this.ksR)) && (!this.ksR.equals(localObject1)))
    {
      ad.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ksR, localObject1 });
      PO(-2);
      this.ziO.rl(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.ziP.GTI != null)
    {
      localObject1 = this.ziP.GTI;
      if ((!bt.isNullOrNil(paramString)) && (((bxm)localObject1).GRE))
      {
        ad.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((bxm)localObject1).GRA = true;
        ((bxm)localObject1).GRF = paramString;
      }
      ad.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((bxm)localObject1).sJZ), Boolean.valueOf(((bxm)localObject1).GRA), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.e.axx(this.mPath);
      if (localObject2 == null) {
        break label394;
      }
      ad.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (bt.isNullOrNil(paramString)) {
        break label358;
      }
      l1 = ax.aQA("OpenSdkVideoTime").decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      ad.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration < l1) {
        break label394;
      }
      ad.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration) });
      PO(-2);
      this.ziO.rl(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new bxm();
      break;
      label358:
      if (((bxm)localObject1).GRA) {
        l1 = com.tencent.mm.modelcontrol.d.aGQ().aGS().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.d.aGQ().aGT().duration;
      }
    }
    label394:
    if (!((bxm)localObject1).GRA)
    {
      a((bxm)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = com.tencent.mm.plugin.mmsight.model.i.vOl;
    if (((bxm)localObject1).sJZ >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    ad.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new uy();
    ((uy)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        ad.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.ziQ.dJh.result) });
        if (this.ziQ.dJh.result >= 0)
        {
          ab.a(ab.this);
          ab.this.a(this.ziR, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ab.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((uy)localObject2).dJg.dJk = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean dlg()
      {
        AppMethodBeat.i(95698);
        ad.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ab.a(ab.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((uy)localObject2).dJg.dIO = this.mPath;
    ((uy)localObject2).dJg.scene = i;
    ((uy)localObject2).dJg.dJi = ((bxm)localObject1);
    ((uy)localObject2).dJg.dJj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.ziR.sJZ += 1;
        try
        {
          ad.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.ziR.sJZ) });
          byq localbyq = (byq)new byq().parseFrom(ab.this.ziN.zNr);
          localbyq.GTI = this.ziR;
          ab.this.ziN.zNr = localbyq.toByteArray();
          ag.dTT().a(ab.this.ziN.zMC, ab.this.ziN);
          AppMethodBeat.o(95699);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(95699);
        }
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject2, ag.dTR());
    AppMethodBeat.o(95702);
    return true;
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    ad.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = ag.dTT().Aj(this.dJd);
    localt.offset = 0;
    try
    {
      byq localbyq = (byq)new byq().parseFrom(localt.zNr);
      localbyq.GTF = "";
      if (localbyq.GTI != null) {
        localbyq.GTI.sJZ = 0;
      }
      localt.zNr = localbyq.toByteArray();
      ag.dTT().a(this.dJd, localt);
      ag.dUd().PT(this.dJd);
      AppMethodBeat.o(95706);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95706);
    }
  }
  
  public static abstract interface a
  {
    public abstract void rl(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */