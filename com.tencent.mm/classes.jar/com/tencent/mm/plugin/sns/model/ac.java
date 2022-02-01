package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vc.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ac
{
  private String clientId;
  int dKr;
  int glf;
  private long iVu;
  String idX;
  private g.a ieg;
  int iwz;
  private String kwh;
  private String mPath;
  long startTime;
  private String thumbPath;
  t zAc;
  a zAd;
  private bzk zAe;
  
  /* Error */
  public ac(int paramInt, t paramt, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: ldc 44
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 52
    //   12: putfield 54	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/ac:iVu	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/ac:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/ac:glf	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/ac:kwh	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/bzk
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/bzk:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/ac$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/ac$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ac;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/ac:ieg	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/ac:iVu	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/ac:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/ac:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/ac:zAd	Lcom/tencent/mm/plugin/sns/model/ac$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/ac:dKr	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/ac:zAc	Lcom/tencent/mm/plugin/sns/storage/t;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/bzk
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/bzk:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/t:Aey	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/bzk:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/bzk
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/bzk:Hng	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/bzk:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/ac:kwh	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 54	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   140: invokestatic 110	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 112	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 116	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   157: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 130	java/lang/String:getBytes	()[B
    //   166: invokestatic 136	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   169: putfield 54	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/ac:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/bzk:Hng	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/ac:zAe	Lcom/tencent/mm/protocal/protobuf/bzk;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/bzk:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/t:Aey	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/ah:dXt	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   197: aload_2
    //   198: getfield 148	com/tencent/mm/plugin/sns/storage/t:AdJ	I
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
    //   228: invokestatic 169	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/ac:kwh	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 174	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 44
    //   248: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 155
    //   255: ldc 179
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 44
    //   262: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 155
    //   269: aload_2
    //   270: ldc 52
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -73 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	ac
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
  
  final void Qv(int paramInt)
  {
    AppMethodBeat.i(95705);
    ae.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = ah.dXt().AH(this.dKr);
    try
    {
      bzk localbzk = (bzk)new bzk().parseFrom(localt.Aey);
      localbzk.HiZ = 1;
      localbzk.HmP = paramInt;
      if (this.zAe.Hnj != null) {
        this.zAe.Hnj.sVm = 0;
      }
      localt.Aey = localbzk.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    ah.dXD().QA(this.dKr);
    ah.dXt().a(this.dKr, localt);
    AppMethodBeat.o(95705);
  }
  
  final boolean a(byg parambyg, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.glf = com.tencent.mm.i.a.fKH;
    }
    String str = this.clientId;
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_NetSceneSnsUpload_2";
    localg.fLm = this.ieg;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.fKH;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fKA;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!bu.isNullOrNil(paramString))
    {
      localg.field_largesvideo = ay.aRX("OpenSdkVideoTime").decodeInt(paramString, 10);
      long l = o.aZR(this.mPath);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxP, false);
      if ((l >= 25165824L) && (bool))
      {
        ae.i("MicroMsg.SightCdnUpload", "send big file:%s  size:%s", new Object[] { this.mPath, Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 31L, 1L, false);
        localg.snsVersion = 1;
      }
      paramString = o.aRh(this.mPath);
      if ((!bu.isNullOrNil(this.kwh)) && (!this.kwh.equals(paramString)))
      {
        ae.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.kwh, paramString });
        Qv(-2);
        this.zAd.rs(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.d.aHh();
      if (parambyg.Hlb) {}
      for (paramString = com.tencent.mm.modelcontrol.d.aHh().aHj();; paramString = com.tencent.mm.modelcontrol.d.aHh().aHk())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(paramString);
        break;
      }
    }
    if (!f.aGZ().f(localg))
    {
      ae.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((parambyg != null) && (parambyg.Hlb)) {}
    for (int i = 4;; i = 5)
    {
      this.iwz = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aAj(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = o.aRh(this.mPath);
    if ((!bu.isNullOrNil(this.kwh)) && (!this.kwh.equals(localObject1)))
    {
      ae.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.kwh, localObject1 });
      Qv(-2);
      this.zAd.rs(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.zAe.Hnj != null)
    {
      localObject1 = this.zAe.Hnj;
      if ((!bu.isNullOrNil(paramString)) && (((byg)localObject1).Hlf))
      {
        ae.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((byg)localObject1).Hlb = true;
        ((byg)localObject1).Hlg = paramString;
      }
      ae.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((byg)localObject1).sVm), Boolean.valueOf(((byg)localObject1).Hlb), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.e.ayN(this.mPath);
      if (localObject2 == null) {
        break label394;
      }
      ae.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (bu.isNullOrNil(paramString)) {
        break label358;
      }
      l1 = ay.aRX("OpenSdkVideoTime").decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      ae.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration < l1) {
        break label394;
      }
      ae.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration) });
      Qv(-2);
      this.zAd.rs(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new byg();
      break;
      label358:
      if (((byg)localObject1).Hlb) {
        l1 = com.tencent.mm.modelcontrol.d.aHh().aHj().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.d.aHh().aHk().duration;
      }
    }
    label394:
    if (!((byg)localObject1).Hlb)
    {
      a((byg)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = i.wao;
    if (((byg)localObject1).sVm >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    ae.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new vc();
    ((vc)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        ae.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.zAf.dKv.result) });
        if (this.zAf.dKv.result >= 0)
        {
          ac.a(ac.this);
          ac.this.a(this.zAg, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ac.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((vc)localObject2).dKu.dKy = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean dog()
      {
        AppMethodBeat.i(95698);
        ae.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ac.a(ac.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((vc)localObject2).dKu.dKc = this.mPath;
    ((vc)localObject2).dKu.scene = i;
    ((vc)localObject2).dKu.dKw = ((byg)localObject1);
    ((vc)localObject2).dKu.dKx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.zAg.sVm += 1;
        try
        {
          ae.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.zAg.sVm) });
          bzk localbzk = (bzk)new bzk().parseFrom(ac.this.zAc.Aey);
          localbzk.Hnj = this.zAg;
          ac.this.zAc.Aey = localbzk.toByteArray();
          ah.dXt().a(ac.this.zAc.AdJ, ac.this.zAc);
          AppMethodBeat.o(95699);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(95699);
        }
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject2, ah.dXr());
    AppMethodBeat.o(95702);
    return true;
  }
  
  public final boolean aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    t localt = ah.dXt().AH(this.dKr);
    ae.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localt.Aex = paramString3;
    try
    {
      paramString3 = (bzk)new bzk().parseFrom(localt.Aey);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new bzk();
      }
      paramString3 = new bzc();
      paramString3.nJA = 1;
      paramString3.Url = paramString1;
      ((bzk)localObject).Hnd = paramString3;
      ((bzk)localObject).HiZ = 0;
      f.aHa();
      ((bzk)localObject).HmE = com.tencent.mm.an.a.Fn(this.mPath);
      ae.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((bzk)localObject).HmE });
      if (!bu.isNullOrNil(paramString2))
      {
        paramString1 = new bzc();
        paramString1.nJA = 1;
        paramString1.Url = paramString2;
        ((bzk)localObject).Hnf.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localt.Aey = ((bzk)localObject).toByteArray();
        localt.ecO();
        ah.dXt().a(this.dKr, localt);
        ah.dXD().QA(this.dKr);
        if (ah.dXA() != null) {
          ah.dXA().dWc();
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
          ae.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    ae.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    t localt = ah.dXt().AH(this.dKr);
    localt.offset = 0;
    try
    {
      bzk localbzk = (bzk)new bzk().parseFrom(localt.Aey);
      localbzk.Hng = "";
      if (localbzk.Hnj != null) {
        localbzk.Hnj.sVm = 0;
      }
      localt.Aey = localbzk.toByteArray();
      ah.dXt().a(this.dKr, localt);
      ah.dXD().QA(this.dKr);
      AppMethodBeat.o(95706);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95706);
    }
  }
  
  public static abstract interface a
  {
    public abstract void rs(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */