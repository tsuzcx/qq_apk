package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.uf.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ab
{
  private String clientId;
  int dwR;
  int fPn;
  String hIq;
  private g.a hIz;
  int iak;
  private long izs;
  private String jYv;
  private String mPath;
  long startTime;
  private String thumbPath;
  t xST;
  a xSU;
  private buc xSV;
  
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
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/ab:izs	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/ab:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/ab:fPn	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/ab:jYv	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/buc
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/buc:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/ab$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/ab$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ab;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/ab:hIz	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/ab:izs	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/ab:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/ab:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/ab:xSU	Lcom/tencent/mm/plugin/sns/model/ab$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/ab:dwR	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/ab:xST	Lcom/tencent/mm/plugin/sns/storage/t;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/buc
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/buc:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/t:ywe	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/buc:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/buc
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/buc:Fke	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/buc:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/ab:jYv	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   140: invokestatic 110	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 112	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 116	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   157: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 130	java/lang/String:getBytes	()[B
    //   166: invokestatic 136	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   169: putfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/ab:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/buc:Fke	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/ab:xSV	Lcom/tencent/mm/protocal/protobuf/buc;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/buc:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/t:ywe	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/af:dHG	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   197: aload_2
    //   198: getfield 148	com/tencent/mm/plugin/sns/storage/t:yvp	I
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
    //   228: invokestatic 169	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/ab:jYv	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 44
    //   248: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 155
    //   255: ldc 179
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 44
    //   262: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 155
    //   269: aload_2
    //   270: ldc 52
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 187	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final void Oh(int paramInt)
  {
    AppMethodBeat.i(95705);
    ac.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = af.dHG().xL(this.dwR);
    try
    {
      buc localbuc = (buc)new buc().parseFrom(localt.ywe);
      localbuc.FfT = 1;
      localbuc.FjN = paramInt;
      if (this.xSV.Fkh != null) {
        this.xSV.Fkh.rNU = 0;
      }
      localt.ywe = localbuc.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    af.dHQ().Om(this.dwR);
    af.dHG().a(this.dwR, localt);
    AppMethodBeat.o(95705);
  }
  
  final boolean a(bsz parambsz, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.fPn = com.tencent.mm.i.a.fqw;
    }
    String str = this.clientId;
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    g localg = new g();
    localg.frb = this.hIz;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.fqw;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fqp;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!bs.isNullOrNil(paramString))
    {
      localg.field_largesvideo = aw.aKU("OpenSdkVideoTime").decodeInt(paramString, 10);
      paramString = com.tencent.mm.vfs.i.aKe(this.mPath);
      if ((!bs.isNullOrNil(this.jYv)) && (!this.jYv.equals(paramString)))
      {
        ac.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jYv, paramString });
        Oh(-2);
        this.xSU.qI(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.d.aDL();
      if (parambsz.FhZ) {}
      for (paramString = com.tencent.mm.modelcontrol.d.aDL().aDN();; paramString = com.tencent.mm.modelcontrol.d.aDL().aDO())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(paramString);
        break;
      }
    }
    if (!com.tencent.mm.an.f.aDD().f(localg))
    {
      ac.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((parambsz != null) && (parambsz.FhZ)) {}
    for (int i = 4;; i = 5)
    {
      this.iak = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean atN(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = com.tencent.mm.vfs.i.aKe(this.mPath);
    if ((!bs.isNullOrNil(this.jYv)) && (!this.jYv.equals(localObject1)))
    {
      ac.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jYv, localObject1 });
      Oh(-2);
      this.xSU.qI(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.xSV.Fkh != null)
    {
      localObject1 = this.xSV.Fkh;
      if ((!bs.isNullOrNil(paramString)) && (((bsz)localObject1).Fid))
      {
        ac.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((bsz)localObject1).FhZ = true;
        ((bsz)localObject1).Fie = paramString;
      }
      ac.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((bsz)localObject1).rNU), Boolean.valueOf(((bsz)localObject1).FhZ), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.e.asx(this.mPath);
      if (localObject2 == null) {
        break label394;
      }
      ac.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (bs.isNullOrNil(paramString)) {
        break label358;
      }
      l1 = aw.aKU("OpenSdkVideoTime").decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      ac.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration < l1) {
        break label394;
      }
      ac.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration) });
      Oh(-2);
      this.xSU.qI(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new bsz();
      break;
      label358:
      if (((bsz)localObject1).FhZ) {
        l1 = com.tencent.mm.modelcontrol.d.aDL().aDN().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.d.aDL().aDO().duration;
      }
    }
    label394:
    if (!((bsz)localObject1).FhZ)
    {
      a((bsz)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = com.tencent.mm.plugin.mmsight.model.i.uLf;
    if (((bsz)localObject1).rNU >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    ac.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new uf();
    ((uf)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        ac.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.xSW.dwV.result) });
        if (this.xSW.dwV.result >= 0)
        {
          ab.a(ab.this);
          ab.this.a(this.xSX, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ab.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((uf)localObject2).dwU.dwY = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean dbM()
      {
        AppMethodBeat.i(95698);
        ac.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ab.a(ab.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((uf)localObject2).dwU.dwC = this.mPath;
    ((uf)localObject2).dwU.scene = i;
    ((uf)localObject2).dwU.dwW = ((bsz)localObject1);
    ((uf)localObject2).dwU.dwX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.xSX.rNU += 1;
        try
        {
          ac.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.xSX.rNU) });
          buc localbuc = (buc)new buc().parseFrom(ab.this.xST.ywe);
          localbuc.Fkh = this.xSX;
          ab.this.xST.ywe = localbuc.toByteArray();
          af.dHG().a(ab.this.xST.yvp, ab.this.xST);
          AppMethodBeat.o(95699);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(95699);
        }
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject2, af.dHE());
    AppMethodBeat.o(95702);
    return true;
  }
  
  public final boolean av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    t localt = af.dHG().xL(this.dwR);
    ac.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localt.ywd = paramString3;
    try
    {
      paramString3 = (buc)new buc().parseFrom(localt.ywe);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new buc();
      }
      paramString3 = new btu();
      paramString3.ndI = 1;
      paramString3.Url = paramString1;
      ((buc)localObject).Fkb = paramString3;
      ((buc)localObject).FfT = 0;
      com.tencent.mm.an.f.aDE();
      ((buc)localObject).FjC = com.tencent.mm.an.a.BM(this.mPath);
      ac.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((buc)localObject).FjC });
      if (!bs.isNullOrNil(paramString2))
      {
        paramString1 = new btu();
        paramString1.ndI = 1;
        paramString1.Url = paramString2;
        ((buc)localObject).Fkd.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localt.ywe = ((buc)localObject).toByteArray();
        localt.dMU();
        af.dHG().a(this.dwR, localt);
        af.dHQ().Om(this.dwR);
        if (af.dHN() != null) {
          af.dHN().dGr();
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
          ac.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    ac.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = af.dHG().xL(this.dwR);
    localt.offset = 0;
    try
    {
      buc localbuc = (buc)new buc().parseFrom(localt.ywe);
      localbuc.Fke = "";
      if (localbuc.Fkh != null) {
        localbuc.Fkh.rNU = 0;
      }
      localt.ywe = localbuc.toByteArray();
      af.dHG().a(this.dwR, localt);
      af.dHQ().Om(this.dwR);
      AppMethodBeat.o(95706);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95706);
    }
  }
  
  public static abstract interface a
  {
    public abstract void qI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */