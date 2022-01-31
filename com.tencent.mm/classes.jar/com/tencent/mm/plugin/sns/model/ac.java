package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.qr;
import com.tencent.mm.j.f.a;
import com.tencent.mm.m.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ac
{
  private String clientId;
  int eHh;
  String eoQ;
  int eoR;
  private f.a epa;
  private String ghQ;
  private String mPath;
  private int onc;
  private long oqR;
  r ori;
  ac.a orj;
  private awg ork;
  long startTime;
  private String thumbPath;
  
  /* Error */
  public ac(int paramInt, r paramr, String paramString1, String paramString2, ac.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 38
    //   7: putfield 40	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   10: aload_0
    //   11: lconst_0
    //   12: putfield 42	com/tencent/mm/plugin/sns/model/ac:oqR	J
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 44	com/tencent/mm/plugin/sns/model/ac:startTime	J
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 46	com/tencent/mm/plugin/sns/model/ac:eoR	I
    //   25: aload_0
    //   26: ldc 38
    //   28: putfield 48	com/tencent/mm/plugin/sns/model/ac:ghQ	Ljava/lang/String;
    //   31: aload_0
    //   32: new 50	com/tencent/mm/protocal/c/awg
    //   35: dup
    //   36: invokespecial 51	com/tencent/mm/protocal/c/awg:<init>	()V
    //   39: putfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   42: aload_0
    //   43: new 6	com/tencent/mm/plugin/sns/model/ac$4
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 56	com/tencent/mm/plugin/sns/model/ac$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ac;)V
    //   51: putfield 58	com/tencent/mm/plugin/sns/model/ac:epa	Lcom/tencent/mm/j/f$a;
    //   54: aload_0
    //   55: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   58: putfield 42	com/tencent/mm/plugin/sns/model/ac:oqR	J
    //   61: aload_0
    //   62: aload_3
    //   63: putfield 66	com/tencent/mm/plugin/sns/model/ac:mPath	Ljava/lang/String;
    //   66: aload_0
    //   67: aload 4
    //   69: putfield 68	com/tencent/mm/plugin/sns/model/ac:thumbPath	Ljava/lang/String;
    //   72: aload_0
    //   73: aload 5
    //   75: putfield 70	com/tencent/mm/plugin/sns/model/ac:orj	Lcom/tencent/mm/plugin/sns/model/ac$a;
    //   78: aload_0
    //   79: iload_1
    //   80: putfield 72	com/tencent/mm/plugin/sns/model/ac:onc	I
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 74	com/tencent/mm/plugin/sns/model/ac:ori	Lcom/tencent/mm/plugin/sns/storage/r;
    //   88: aload_0
    //   89: new 50	com/tencent/mm/protocal/c/awg
    //   92: dup
    //   93: invokespecial 51	com/tencent/mm/protocal/c/awg:<init>	()V
    //   96: aload_2
    //   97: getfield 80	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   100: invokevirtual 84	com/tencent/mm/protocal/c/awg:aH	([B)Lcom/tencent/mm/bv/a;
    //   103: checkcast 50	com/tencent/mm/protocal/c/awg
    //   106: putfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   114: getfield 87	com/tencent/mm/protocal/c/awg:tsM	Ljava/lang/String;
    //   117: putfield 40	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   125: getfield 90	com/tencent/mm/protocal/c/awg:bIW	Ljava/lang/String;
    //   128: putfield 48	com/tencent/mm/plugin/sns/model/ac:ghQ	Ljava/lang/String;
    //   131: aload_0
    //   132: getfield 40	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   135: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   138: ifeq +63 -> 201
    //   141: aload_0
    //   142: new 98	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   149: invokestatic 102	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   152: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   155: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 116	java/lang/String:getBytes	()[B
    //   161: invokestatic 122	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   164: putfield 40	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   167: aload_0
    //   168: getfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   171: aload_0
    //   172: getfield 40	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   175: putfield 87	com/tencent/mm/protocal/c/awg:tsM	Ljava/lang/String;
    //   178: aload_2
    //   179: aload_0
    //   180: getfield 53	com/tencent/mm/plugin/sns/model/ac:ork	Lcom/tencent/mm/protocal/c/awg;
    //   183: invokevirtual 125	com/tencent/mm/protocal/c/awg:toByteArray	()[B
    //   186: putfield 80	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   189: invokestatic 131	com/tencent/mm/plugin/sns/model/af:bDu	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   192: aload_2
    //   193: getfield 134	com/tencent/mm/plugin/sns/storage/r:oLk	I
    //   196: aload_2
    //   197: invokevirtual 140	com/tencent/mm/plugin/sns/storage/s:a	(ILcom/tencent/mm/plugin/sns/storage/r;)I
    //   200: pop
    //   201: ldc 142
    //   203: ldc 144
    //   205: iconst_4
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: iload_1
    //   212: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: aload_3
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: aload_3
    //   223: invokestatic 156	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   226: l2i
    //   227: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: dup
    //   232: iconst_3
    //   233: aload_0
    //   234: getfield 48	com/tencent/mm/plugin/sns/model/ac:ghQ	Ljava/lang/String;
    //   237: aastore
    //   238: invokestatic 162	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: return
    //   242: astore_2
    //   243: ldc 142
    //   245: ldc 164
    //   247: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: return
    //   251: astore_2
    //   252: ldc 142
    //   254: aload_2
    //   255: ldc 38
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 172	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: goto -63 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	ac
    //   0	267	1	paramInt	int
    //   0	267	2	paramr	r
    //   0	267	3	paramString1	String
    //   0	267	4	paramString2	String
    //   0	267	5	parama	ac.a
    // Exception table:
    //   from	to	target	type
    //   88	109	242	java/lang/Exception
    //   178	201	251	java/lang/Exception
  }
  
  public final boolean X(String paramString1, String paramString2, String paramString3)
  {
    r localr = af.bDu().gu(this.onc);
    y.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localr.oLU = paramString3;
    try
    {
      paramString3 = (awg)new awg().aH(localr.oLV);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new awg();
      }
      paramString3 = new awa();
      paramString3.hQR = 1;
      paramString3.kSC = paramString1;
      ((awg)localObject).tsI = paramString3;
      ((awg)localObject).tsL = 0;
      com.tencent.mm.ak.f.Ne();
      ((awg)localObject).tsk = com.tencent.mm.ak.a.lH(this.mPath);
      y.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((awg)localObject).tsk });
      if (!bk.bl(paramString2))
      {
        paramString1 = new awa();
        paramString1.hQR = 1;
        paramString1.kSC = paramString2;
        ((awg)localObject).tsK.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localr.oLV = ((awg)localObject).toByteArray();
        localr.bHa();
        af.bDu().a(this.onc, localr);
        af.bDE().xK(this.onc);
        if (af.bDB() != null) {
          af.bDB().bCp();
        }
        return true;
        paramString3 = paramString3;
        paramString3 = null;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  final boolean a(avn paramavn)
  {
    if (this.startTime == 0L)
    {
      this.startTime = bk.UY();
      this.eoR = com.tencent.mm.j.a.dlq;
    }
    String str = this.clientId;
    if (bk.bl(str))
    {
      y.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      return false;
    }
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = this.epa;
    localf.field_mediaId = str;
    localf.field_fullpath = this.mPath;
    localf.field_thumbpath = this.thumbPath;
    localf.field_fileType = com.tencent.mm.j.a.dlq;
    localf.field_talker = "";
    localf.field_priority = com.tencent.mm.j.a.dlk;
    localf.field_needStorage = true;
    localf.field_isStreamMedia = false;
    localf.field_appType = 102;
    localf.field_bzScene = 1;
    Object localObject;
    if ((!bk.bl(paramavn.bOL)) && (paramavn.bOL.contains("wx5dfbe0a95623607b")))
    {
      localf.field_largesvideo = com.tencent.mm.m.g.AA().getInt("WeiShiShareSnsSightTimeLength", 10);
      localObject = com.tencent.mm.a.g.bQ(this.mPath);
      if ((!bk.bl(this.ghQ)) && (!this.ghQ.equals(localObject)))
      {
        y.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ghQ, localObject });
        xF(-2);
        this.orj.iU(false);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.d.Nl();
      if (paramavn.tra) {}
      for (localObject = com.tencent.mm.modelcontrol.d.Nl().Nn();; localObject = com.tencent.mm.modelcontrol.d.Nl().No())
      {
        localf.field_largesvideo = com.tencent.mm.modelcontrol.d.a((VideoTransPara)localObject);
        break;
      }
    }
    if (!com.tencent.mm.ak.f.Nd().c(localf))
    {
      y.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      return false;
    }
    if ((paramavn != null) && (paramavn.tra)) {}
    for (int i = 4;; i = 5)
    {
      this.eHh = i;
      return true;
    }
  }
  
  public final boolean bDf()
  {
    Object localObject1 = com.tencent.mm.a.g.bQ(this.mPath);
    if ((!bk.bl(this.ghQ)) && (!this.ghQ.equals(localObject1)))
    {
      y.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ghQ, localObject1 });
      xF(-2);
      this.orj.iU(false);
      return false;
    }
    long l1;
    if (this.ork.tsP != null)
    {
      localObject1 = this.ork.tsP;
      y.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((avn)localObject1).trb), Boolean.valueOf(((avn)localObject1).tra) });
      localObject2 = com.tencent.mm.plugin.sight.base.d.MH(this.mPath);
      if (localObject2 == null) {
        break label346;
      }
      y.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if ((bk.bl(((avn)localObject1).bOL)) || (!((avn)localObject1).bOL.contains("wx5dfbe0a95623607b"))) {
        break label310;
      }
      l1 = com.tencent.mm.m.g.AA().getInt("WeiShiShareSnsSightTimeLength", 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      y.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).jlu < l1) {
        break label346;
      }
      y.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).jlu) });
      xF(-2);
      this.orj.iU(false);
      return false;
      localObject1 = new avn();
      break;
      label310:
      if (((avn)localObject1).tra) {
        l1 = com.tencent.mm.modelcontrol.d.Nl().Nn().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.d.Nl().No().duration;
      }
    }
    label346:
    if (!((avn)localObject1).tra)
    {
      a((avn)localObject1);
      return true;
    }
    int i = h.mhw;
    if (((avn)localObject1).trb >= 3)
    {
      onError();
      return false;
    }
    y.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new qr();
    ((qr)localObject2).bFJ = new ac.1(this, (qr)localObject2, (avn)localObject1);
    ((qr)localObject2).bZV.bZZ = new ac.2(this);
    ((qr)localObject2).bZV.bZI = this.mPath;
    ((qr)localObject2).bZV.scene = i;
    ((qr)localObject2).bZV.bZX = ((avn)localObject1);
    ((qr)localObject2).bZV.bZY = new ac.3(this, (avn)localObject1);
    com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject2, af.bDs().getLooper());
    return true;
  }
  
  final void onError()
  {
    y.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    r localr = af.bDu().gu(this.onc);
    localr.offset = 0;
    try
    {
      awg localawg = (awg)new awg().aH(localr.oLV);
      localawg.tsM = "";
      if (localawg.tsP != null) {
        localawg.tsP.trb = 0;
      }
      localr.oLV = localawg.toByteArray();
      af.bDu().a(this.onc, localr);
      af.bDE().xK(this.onc);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
    }
  }
  
  final void xF(int paramInt)
  {
    y.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    r localr = af.bDu().gu(this.onc);
    try
    {
      awg localawg = (awg)new awg().aH(localr.oLV);
      localawg.tsL = 1;
      localawg.tsu = paramInt;
      if (this.ork.tsP != null) {
        this.ork.tsP.trb = 0;
      }
      localr.oLV = localawg.toByteArray();
    }
    catch (Exception localException)
    {
      label77:
      break label77;
    }
    af.bDE().xK(this.onc);
    af.bDu().a(this.onc, localr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */