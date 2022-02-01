package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.tw.b;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class ab
{
  private String clientId;
  int dzf;
  int fLB;
  private long hZo;
  String hhN;
  private g.a hhW;
  int hzJ;
  private String jya;
  private String mPath;
  long startTime;
  private String thumbPath;
  ab.a wGA;
  private bpl wGB;
  t wGz;
  
  /* Error */
  public ab(int paramInt, t paramt, String paramString1, String paramString2, ab.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	java/lang/Object:<init>	()V
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 49
    //   12: putfield 51	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 53	com/tencent/mm/plugin/sns/model/ab:hZo	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 55	com/tencent/mm/plugin/sns/model/ab:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 57	com/tencent/mm/plugin/sns/model/ab:fLB	I
    //   30: aload_0
    //   31: ldc 49
    //   33: putfield 59	com/tencent/mm/plugin/sns/model/ab:jya	Ljava/lang/String;
    //   36: aload_0
    //   37: new 61	com/tencent/mm/protocal/protobuf/bpl
    //   40: dup
    //   41: invokespecial 62	com/tencent/mm/protocal/protobuf/bpl:<init>	()V
    //   44: putfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   47: aload_0
    //   48: new 66	com/tencent/mm/plugin/sns/model/ab$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 69	com/tencent/mm/plugin/sns/model/ab$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ab;)V
    //   56: putfield 71	com/tencent/mm/plugin/sns/model/ab:hhW	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   63: putfield 53	com/tencent/mm/plugin/sns/model/ab:hZo	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 79	com/tencent/mm/plugin/sns/model/ab:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 81	com/tencent/mm/plugin/sns/model/ab:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 83	com/tencent/mm/plugin/sns/model/ab:wGA	Lcom/tencent/mm/plugin/sns/model/ab$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 85	com/tencent/mm/plugin/sns/model/ab:dzf	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 87	com/tencent/mm/plugin/sns/model/ab:wGz	Lcom/tencent/mm/plugin/sns/storage/t;
    //   93: aload_0
    //   94: new 61	com/tencent/mm/protocal/protobuf/bpl
    //   97: dup
    //   98: invokespecial 62	com/tencent/mm/protocal/protobuf/bpl:<init>	()V
    //   101: aload_2
    //   102: getfield 93	com/tencent/mm/plugin/sns/storage/t:xjn	[B
    //   105: invokevirtual 97	com/tencent/mm/protocal/protobuf/bpl:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   108: checkcast 61	com/tencent/mm/protocal/protobuf/bpl
    //   111: putfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   119: getfield 100	com/tencent/mm/protocal/protobuf/bpl:DNN	Ljava/lang/String;
    //   122: putfield 51	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   130: getfield 103	com/tencent/mm/protocal/protobuf/bpl:md5	Ljava/lang/String;
    //   133: putfield 59	com/tencent/mm/plugin/sns/model/ab:jya	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 51	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   140: invokestatic 109	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 111	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 115	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   157: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 129	java/lang/String:getBytes	()[B
    //   166: invokestatic 135	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   169: putfield 51	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   176: aload_0
    //   177: getfield 51	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   180: putfield 100	com/tencent/mm/protocal/protobuf/bpl:DNN	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 64	com/tencent/mm/plugin/sns/model/ab:wGB	Lcom/tencent/mm/protocal/protobuf/bpl;
    //   188: invokevirtual 138	com/tencent/mm/protocal/protobuf/bpl:toByteArray	()[B
    //   191: putfield 93	com/tencent/mm/plugin/sns/storage/t:xjn	[B
    //   194: invokestatic 144	com/tencent/mm/plugin/sns/model/af:dtj	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   197: aload_2
    //   198: getfield 147	com/tencent/mm/plugin/sns/storage/t:xiB	I
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
    //   228: invokestatic 169	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 59	com/tencent/mm/plugin/sns/model/ab:jya	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 41
    //   248: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 155
    //   255: ldc 179
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 41
    //   262: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 155
    //   269: aload_2
    //   270: ldc 49
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
    //   0	282	5	parama	ab.a
    // Exception table:
    //   from	to	target	type
    //   93	114	252	java/lang/Exception
    //   183	206	266	java/lang/Exception
  }
  
  final void Mf(int paramInt)
  {
    AppMethodBeat.i(95705);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = af.dtj().ti(this.dzf);
    try
    {
      bpl localbpl = (bpl)new bpl().parseFrom(localt.xjn);
      localbpl.DJF = 1;
      localbpl.DNw = paramInt;
      if (this.wGB.DNQ != null) {
        this.wGB.DNQ.qRG = 0;
      }
      localt.xjn = localbpl.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    af.dtt().Mk(this.dzf);
    af.dtj().a(this.dzf, localt);
    AppMethodBeat.o(95705);
  }
  
  final boolean a(boj paramboj, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.fLB = com.tencent.mm.i.a.fnc;
    }
    String str = this.clientId;
    if (bt.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    g localg = new g();
    localg.fnH = this.hhW;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.fnc;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fmV;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!bt.isNullOrNil(paramString))
    {
      localg.field_largesvideo = ax.aFD("OpenSdkVideoTime").decodeInt(paramString, 10);
      paramString = com.tencent.mm.vfs.i.aEN(this.mPath);
      if ((!bt.isNullOrNil(this.jya)) && (!this.jya.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jya, paramString });
        Mf(-2);
        this.wGA.pJ(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      d.awT();
      if (paramboj.DLK) {}
      for (paramString = d.awT().awV();; paramString = d.awT().awW())
      {
        localg.field_largesvideo = d.b(paramString);
        break;
      }
    }
    if (!f.awL().e(localg))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((paramboj != null) && (paramboj.DLK)) {}
    for (int i = 4;; i = 5)
    {
      this.hzJ = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aoB(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = com.tencent.mm.vfs.i.aEN(this.mPath);
    if ((!bt.isNullOrNil(this.jya)) && (!this.jya.equals(localObject1)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jya, localObject1 });
      Mf(-2);
      this.wGA.pJ(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.wGB.DNQ != null)
    {
      localObject1 = this.wGB.DNQ;
      if ((!bt.isNullOrNil(paramString)) && (((boj)localObject1).DLO))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((boj)localObject1).DLK = true;
        ((boj)localObject1).DLP = paramString;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((boj)localObject1).qRG), Boolean.valueOf(((boj)localObject1).DLK), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.e.ano(this.mPath);
      if (localObject2 == null) {
        break label394;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (bt.isNullOrNil(paramString)) {
        break label358;
      }
      l1 = ax.aFD("OpenSdkVideoTime").decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration < l1) {
        break label394;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration) });
      Mf(-2);
      this.wGA.pJ(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new boj();
      break;
      label358:
      if (((boj)localObject1).DLK) {
        l1 = d.awT().awV().duration;
      } else {
        l1 = d.awT().awW().duration;
      }
    }
    label394:
    if (!((boj)localObject1).DLK)
    {
      a((boj)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = com.tencent.mm.plugin.mmsight.model.i.tCI;
    if (((boj)localObject1).qRG >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new tw();
    ((tw)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.wGC.dzj.result) });
        if (this.wGC.dzj.result >= 0)
        {
          ab.a(ab.this);
          ab.this.a(this.wGD, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ab.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((tw)localObject2).dzi.dzm = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean cOe()
      {
        AppMethodBeat.i(95698);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ab.a(ab.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((tw)localObject2).dzi.dyQ = this.mPath;
    ((tw)localObject2).dzi.scene = i;
    ((tw)localObject2).dzi.dzk = ((boj)localObject1);
    ((tw)localObject2).dzi.dzl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.wGD.qRG += 1;
        try
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.wGD.qRG) });
          bpl localbpl = (bpl)new bpl().parseFrom(ab.this.wGz.xjn);
          localbpl.DNQ = this.wGD;
          ab.this.wGz.xjn = localbpl.toByteArray();
          af.dtj().a(ab.this.wGz.xiB, ab.this.wGz);
          AppMethodBeat.o(95699);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(95699);
        }
      }
    };
    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject2, af.dth());
    AppMethodBeat.o(95702);
    return true;
  }
  
  public final boolean at(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    t localt = af.dtj().ti(this.dzf);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localt.xjm = paramString3;
    try
    {
      paramString3 = (bpl)new bpl().parseFrom(localt.xjn);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new bpl();
      }
      paramString3 = new bpd();
      paramString3.mBH = 1;
      paramString3.Url = paramString1;
      ((bpl)localObject).DNK = paramString3;
      ((bpl)localObject).DJF = 0;
      f.awM();
      ((bpl)localObject).DNl = com.tencent.mm.ao.a.xG(this.mPath);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((bpl)localObject).DNl });
      if (!bt.isNullOrNil(paramString2))
      {
        paramString1 = new bpd();
        paramString1.mBH = 1;
        paramString1.Url = paramString2;
        ((bpl)localObject).DNM.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localt.xjn = ((bpl)localObject).toByteArray();
        localt.dyx();
        af.dtj().a(this.dzf, localt);
        af.dtt().Mk(this.dzf);
        if (af.dtq() != null) {
          af.dtq().drS();
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
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = af.dtj().ti(this.dzf);
    localt.offset = 0;
    try
    {
      bpl localbpl = (bpl)new bpl().parseFrom(localt.xjn);
      localbpl.DNN = "";
      if (localbpl.DNQ != null) {
        localbpl.DNQ.qRG = 0;
      }
      localt.xjn = localbpl.toByteArray();
      af.dtj().a(this.dzf, localt);
      af.dtt().Mk(this.dzf);
      AppMethodBeat.o(95706);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95706);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */