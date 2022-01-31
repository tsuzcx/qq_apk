package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class ac
{
  private int cIp;
  private String clientId;
  String fFo;
  int fFp;
  private g.a fFy;
  int fWX;
  private String hyD;
  private String mPath;
  private long rfC;
  r rfU;
  ac.a rfV;
  private bcv rfW;
  long startTime;
  private String thumbPath;
  
  /* Error */
  public ac(int paramInt, r paramr, String paramString1, String paramString2, ac.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	java/lang/Object:<init>	()V
    //   4: ldc 35
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 43
    //   12: putfield 45	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 47	com/tencent/mm/plugin/sns/model/ac:rfC	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 49	com/tencent/mm/plugin/sns/model/ac:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 51	com/tencent/mm/plugin/sns/model/ac:fFp	I
    //   30: aload_0
    //   31: ldc 43
    //   33: putfield 53	com/tencent/mm/plugin/sns/model/ac:hyD	Ljava/lang/String;
    //   36: aload_0
    //   37: new 55	com/tencent/mm/protocal/protobuf/bcv
    //   40: dup
    //   41: invokespecial 56	com/tencent/mm/protocal/protobuf/bcv:<init>	()V
    //   44: putfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   47: aload_0
    //   48: new 60	com/tencent/mm/plugin/sns/model/ac$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 63	com/tencent/mm/plugin/sns/model/ac$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ac;)V
    //   56: putfield 65	com/tencent/mm/plugin/sns/model/ac:fFy	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   63: putfield 47	com/tencent/mm/plugin/sns/model/ac:rfC	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 73	com/tencent/mm/plugin/sns/model/ac:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 75	com/tencent/mm/plugin/sns/model/ac:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 77	com/tencent/mm/plugin/sns/model/ac:rfV	Lcom/tencent/mm/plugin/sns/model/ac$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 79	com/tencent/mm/plugin/sns/model/ac:cIp	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 81	com/tencent/mm/plugin/sns/model/ac:rfU	Lcom/tencent/mm/plugin/sns/storage/r;
    //   93: aload_0
    //   94: new 55	com/tencent/mm/protocal/protobuf/bcv
    //   97: dup
    //   98: invokespecial 56	com/tencent/mm/protocal/protobuf/bcv:<init>	()V
    //   101: aload_2
    //   102: getfield 87	com/tencent/mm/plugin/sns/storage/r:rDG	[B
    //   105: invokevirtual 91	com/tencent/mm/protocal/protobuf/bcv:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   108: checkcast 55	com/tencent/mm/protocal/protobuf/bcv
    //   111: putfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   119: getfield 94	com/tencent/mm/protocal/protobuf/bcv:xsN	Ljava/lang/String;
    //   122: putfield 45	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   130: getfield 97	com/tencent/mm/protocal/protobuf/bcv:cqq	Ljava/lang/String;
    //   133: putfield 53	com/tencent/mm/plugin/sns/model/ac:hyD	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 45	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   140: invokestatic 103	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 105	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 109	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   157: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 123	java/lang/String:getBytes	()[B
    //   166: invokestatic 129	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   169: putfield 45	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   176: aload_0
    //   177: getfield 45	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   180: putfield 94	com/tencent/mm/protocal/protobuf/bcv:xsN	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 58	com/tencent/mm/plugin/sns/model/ac:rfW	Lcom/tencent/mm/protocal/protobuf/bcv;
    //   188: invokevirtual 132	com/tencent/mm/protocal/protobuf/bcv:toByteArray	()[B
    //   191: putfield 87	com/tencent/mm/plugin/sns/storage/r:rDG	[B
    //   194: invokestatic 138	com/tencent/mm/plugin/sns/model/ag:coU	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   197: aload_2
    //   198: getfield 141	com/tencent/mm/plugin/sns/storage/r:rCV	I
    //   201: aload_2
    //   202: invokevirtual 147	com/tencent/mm/plugin/sns/storage/s:a	(ILcom/tencent/mm/plugin/sns/storage/r;)I
    //   205: pop
    //   206: ldc 149
    //   208: ldc 151
    //   210: iconst_4
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: iload_1
    //   217: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_3
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload_3
    //   228: invokestatic 163	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 53	com/tencent/mm/plugin/sns/model/ac:hyD	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 35
    //   248: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 149
    //   255: ldc 173
    //   257: invokestatic 177	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 35
    //   262: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 149
    //   269: aload_2
    //   270: ldc 43
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 181	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -73 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	ac
    //   0	282	1	paramInt	int
    //   0	282	2	paramr	r
    //   0	282	3	paramString1	String
    //   0	282	4	paramString2	String
    //   0	282	5	parama	ac.a
    // Exception table:
    //   from	to	target	type
    //   93	114	252	java/lang/Exception
    //   183	206	266	java/lang/Exception
  }
  
  final void DF(int paramInt)
  {
    AppMethodBeat.i(36379);
    ab.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    r localr = ag.coU().ma(this.cIp);
    try
    {
      bcv localbcv = (bcv)new bcv().parseFrom(localr.rDG);
      localbcv.nkT = 1;
      localbcv.xsx = paramInt;
      if (this.rfW.xsQ != null) {
        this.rfW.xsQ.xrb = 0;
      }
      localr.rDG = localbcv.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    ag.cpe().DK(this.cIp);
    ag.coU().a(this.cIp, localr);
    AppMethodBeat.o(36379);
  }
  
  final boolean a(bby parambby, String paramString)
  {
    AppMethodBeat.i(154476);
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.fFp = com.tencent.mm.i.a.ecL;
    }
    String str = this.clientId;
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(154476);
      return false;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = this.fFy;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.ecL;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.ecF;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!bo.isNullOrNil(paramString))
    {
      localg.field_largesvideo = as.eu("OpenSdkVideoTime", 1).decodeInt(paramString, 10);
      paramString = com.tencent.mm.a.g.getMD5(this.mPath);
      if ((!bo.isNullOrNil(this.hyD)) && (!this.hyD.equals(paramString)))
      {
        ab.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.hyD, paramString });
        DF(-2);
        this.rfV.lb(false);
        AppMethodBeat.o(154476);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.d.afW();
      if (parambby.xra) {}
      for (paramString = com.tencent.mm.modelcontrol.d.afW().afY();; paramString = com.tencent.mm.modelcontrol.d.afW().afZ())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(paramString);
        break;
      }
    }
    if (!f.afO().e(localg))
    {
      ab.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(154476);
      return false;
    }
    if ((parambby != null) && (parambby.xra)) {}
    for (int i = 4;; i = 5)
    {
      this.fWX = i;
      AppMethodBeat.o(154476);
      return true;
    }
  }
  
  public final boolean aas(String paramString)
  {
    AppMethodBeat.i(154475);
    Object localObject1 = com.tencent.mm.a.g.getMD5(this.mPath);
    if ((!bo.isNullOrNil(this.hyD)) && (!this.hyD.equals(localObject1)))
    {
      ab.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.hyD, localObject1 });
      DF(-2);
      this.rfV.lb(false);
      AppMethodBeat.o(154475);
      return false;
    }
    long l1;
    if (this.rfW.xsQ != null)
    {
      localObject1 = this.rfW.xsQ;
      if ((!bo.isNullOrNil(paramString)) && (paramString.contains("wx5dfbe0a95623607b")))
      {
        ab.i("MicroMsg.SightCdnUpload", "weishi appid, set localCapture to true");
        ((bby)localObject1).xra = true;
      }
      ab.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((bby)localObject1).xrb), Boolean.valueOf(((bby)localObject1).xra), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.d.Zo(this.mPath);
      if (localObject2 == null) {
        break label383;
      }
      ab.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (bo.isNullOrNil(paramString)) {
        break label347;
      }
      l1 = as.eu("OpenSdkVideoTime", 1).decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      ab.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).eVA < l1) {
        break label383;
      }
      ab.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).eVA) });
      DF(-2);
      this.rfV.lb(false);
      AppMethodBeat.o(154475);
      return false;
      localObject1 = new bby();
      break;
      label347:
      if (((bby)localObject1).xra) {
        l1 = com.tencent.mm.modelcontrol.d.afW().afY().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.d.afW().afZ().duration;
      }
    }
    label383:
    if (!((bby)localObject1).xra)
    {
      a((bby)localObject1, paramString);
      AppMethodBeat.o(154475);
      return true;
    }
    int i = h.oHB;
    if (((bby)localObject1).xrb >= 3)
    {
      onError();
      AppMethodBeat.o(154475);
      return false;
    }
    ab.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new sc();
    ((sc)localObject2).callback = new ac.1(this, (sc)localObject2, (bby)localObject1, paramString);
    ((sc)localObject2).cIs.cIw = new ac.2(this);
    ((sc)localObject2).cIs.cIa = this.mPath;
    ((sc)localObject2).cIs.scene = i;
    ((sc)localObject2).cIs.cIu = ((bby)localObject1);
    ((sc)localObject2).cIs.cIv = new ac.3(this, (bby)localObject1);
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject2, ag.coS());
    AppMethodBeat.o(154475);
    return true;
  }
  
  public final boolean ai(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36378);
    r localr = ag.coU().ma(this.cIp);
    ab.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localr.rDF = paramString3;
    try
    {
      paramString3 = (bcv)new bcv().parseFrom(localr.rDG);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new bcv();
      }
      paramString3 = new bcp();
      paramString3.jKs = 1;
      paramString3.Url = paramString1;
      ((bcv)localObject).xsK = paramString3;
      ((bcv)localObject).nkT = 0;
      f.afP();
      ((bcv)localObject).xsn = com.tencent.mm.al.a.sE(this.mPath);
      ab.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((bcv)localObject).xsn });
      if (!bo.isNullOrNil(paramString2))
      {
        paramString1 = new bcp();
        paramString1.jKs = 1;
        paramString1.Url = paramString2;
        ((bcv)localObject).xsM.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localr.rDG = ((bcv)localObject).toByteArray();
        localr.cte();
        ag.coU().a(this.cIp, localr);
        ag.cpe().DK(this.cIp);
        if (ag.cpb() != null) {
          ag.cpb().cnP();
        }
        AppMethodBeat.o(36378);
        return true;
        paramString3 = paramString3;
        paramString3 = null;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  final void onError()
  {
    AppMethodBeat.i(36380);
    ab.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    r localr = ag.coU().ma(this.cIp);
    localr.offset = 0;
    try
    {
      bcv localbcv = (bcv)new bcv().parseFrom(localr.rDG);
      localbcv.xsN = "";
      if (localbcv.xsQ != null) {
        localbcv.xsQ.xrb = 0;
      }
      localr.rDG = localbcv.toByteArray();
      ag.coU().a(this.cIp, localr);
      ag.cpe().DK(this.cIp);
      AppMethodBeat.o(36380);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(36380);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */