package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.g.a.wb.b;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ad
{
  q DJN;
  a DJO;
  private cne DJP;
  private String clientId;
  int ecf;
  int gVY;
  String iYT;
  private g.a iZc;
  private long jSo;
  int jrO;
  private String lAl;
  private String mPath;
  long startTime;
  private String thumbPath;
  
  /* Error */
  public ad(int paramInt, q paramq, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: ldc 44
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 52
    //   12: putfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/ad:jSo	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/ad:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/ad:gVY	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/ad:lAl	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/cne
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/cne:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/ad$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/ad$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ad;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/ad:iZc	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/ad:jSo	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/ad:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/ad:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/ad:DJO	Lcom/tencent/mm/plugin/sns/model/ad$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/ad:ecf	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/ad:DJN	Lcom/tencent/mm/plugin/sns/storage/q;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/cne
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/cne:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/q:EmR	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/cne:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/cne
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/cne:Mtu	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/cne:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/ad:lAl	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   140: invokestatic 110	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifeq +63 -> 206
    //   146: aload_0
    //   147: new 112	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   154: invokestatic 116	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   157: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 130	java/lang/String:getBytes	()[B
    //   166: invokestatic 136	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   169: putfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/cne:Mtu	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/ad:DJP	Lcom/tencent/mm/protocal/protobuf/cne;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/cne:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/q:EmR	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/aj:faD	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   197: aload_2
    //   198: getfield 148	com/tencent/mm/plugin/sns/storage/q:localid	I
    //   201: aload_2
    //   202: invokevirtual 153	com/tencent/mm/plugin/sns/storage/r:a	(ILcom/tencent/mm/plugin/sns/storage/q;)I
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
    //   228: invokestatic 169	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/ad:lAl	Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 44
    //   248: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_2
    //   253: ldc 155
    //   255: ldc 179
    //   257: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc 44
    //   262: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore_2
    //   267: ldc 155
    //   269: aload_2
    //   270: ldc 52
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -73 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	ad
    //   0	282	1	paramInt	int
    //   0	282	2	paramq	q
    //   0	282	3	paramString1	String
    //   0	282	4	paramString2	String
    //   0	282	5	parama	a
    // Exception table:
    //   from	to	target	type
    //   93	114	252	java/lang/Exception
    //   183	206	266	java/lang/Exception
  }
  
  final void Ys(int paramInt)
  {
    AppMethodBeat.i(95705);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    q localq = aj.faD().JK(this.ecf);
    try
    {
      cne localcne = (cne)new cne().parseFrom(localq.EmR);
      localcne.Mpa = 1;
      localcne.Mtd = paramInt;
      if (this.DJP.Mtx != null) {
        this.DJP.Mtx.vUh = 0;
      }
      localq.EmR = localcne.toByteArray();
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    aj.faN().Yx(this.ecf);
    aj.faD().a(this.ecf, localq);
    AppMethodBeat.o(95705);
  }
  
  final boolean a(cly paramcly, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.gVY = com.tencent.mm.i.a.gpT;
    }
    String str = this.clientId;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    g localg = new g();
    localg.taskName = "task_NetSceneSnsUpload_2";
    localg.gqy = this.iZc;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.gpT;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!Util.isNullOrNil(paramString))
    {
      localg.field_largesvideo = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(paramString, 10);
      if (z.bdw(this.mPath))
      {
        h.CyF.idkeyStat(106L, 31L, 1L, false);
        localg.snsVersion = 1;
      }
      paramString = s.bhK(this.mPath);
      if ((!Util.isNullOrNil(this.lAl)) && (!this.lAl.equals(paramString)))
      {
        Log.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.lAl, paramString });
        Ys(-2);
        this.DJO.uO(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.e.baZ();
      if (paramcly.Mrn) {}
      for (paramString = com.tencent.mm.modelcontrol.e.baZ().bbb();; paramString = com.tencent.mm.modelcontrol.e.baZ().bbc())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.e.b(paramString);
        break;
      }
    }
    if (!f.baQ().f(localg))
    {
      Log.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((paramcly != null) && (paramcly.Mrn)) {}
    for (int i = 4;; i = 5)
    {
      this.jrO = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    q localq = aj.faD().JK(this.ecf);
    Log.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localq.EmQ = paramString3;
    try
    {
      paramString3 = (cne)new cne().parseFrom(localq.EmR);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new cne();
      }
      paramString3 = new cmw();
      paramString3.oUv = 1;
      paramString3.Url = paramString1;
      ((cne)localObject).Mtr = paramString3;
      ((cne)localObject).Mpa = 0;
      f.baR();
      ((cne)localObject).MsS = com.tencent.mm.an.a.NX(this.mPath);
      Log.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((cne)localObject).MsS });
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = new cmw();
        paramString1.oUv = 1;
        paramString1.Url = paramString2;
        ((cne)localObject).Mtt.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localq.EmR = ((cne)localObject).toByteArray();
        localq.ffa();
        aj.faD().a(this.ecf, localq);
        aj.faN().Yx(this.ecf);
        if (aj.faK() != null) {
          aj.faK().eZn();
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
          Log.printErrStackTrace("MicroMsg.SightCdnUpload", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean aPf(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = s.bhK(this.mPath);
    if ((!Util.isNullOrNil(this.lAl)) && (!this.lAl.equals(localObject1)))
    {
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.lAl, localObject1 });
      Ys(-2);
      this.DJO.uO(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.DJP.Mtx != null)
    {
      localObject1 = this.DJP.Mtx;
      if ((!Util.isNullOrNil(paramString)) && (((cly)localObject1).Mrr))
      {
        Log.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((cly)localObject1).Mrn = true;
        ((cly)localObject1).Mrs = paramString;
      }
      Log.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((cly)localObject1).vUh), Boolean.valueOf(((cly)localObject1).Mrn), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.e.aNx(this.mPath);
      if (localObject2 == null) {
        break label394;
      }
      Log.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (Util.isNullOrNil(paramString)) {
        break label358;
      }
      l1 = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(paramString, 10);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      Log.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration < l1) {
        break label394;
      }
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration) });
      Ys(-2);
      this.DJO.uO(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new cly();
      break;
      label358:
      if (((cly)localObject1).Mrn) {
        l1 = com.tencent.mm.modelcontrol.e.baZ().bbb().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.e.baZ().bbc().duration;
      }
    }
    label394:
    if (!((cly)localObject1).Mrn)
    {
      a((cly)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = i.zut;
    if (((cly)localObject1).vUh >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    Log.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new wb();
    ((wb)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        Log.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.DJQ.ecj.result) });
        if (this.DJQ.ecj.result >= 0)
        {
          ad.a(ad.this);
          ad.this.a(this.DJR, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ad.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((wb)localObject2).eci.ecm = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean ehT()
      {
        AppMethodBeat.i(95698);
        Log.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ad.a(ad.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((wb)localObject2).eci.ebP = this.mPath;
    ((wb)localObject2).eci.scene = i;
    ((wb)localObject2).eci.eck = ((cly)localObject1);
    ((wb)localObject2).eci.ecl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.DJR.vUh += 1;
        try
        {
          Log.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.DJR.vUh) });
          cne localcne = (cne)new cne().parseFrom(ad.this.DJN.EmR);
          localcne.Mtx = this.DJR;
          ad.this.DJN.EmR = localcne.toByteArray();
          aj.faD().a(ad.this.DJN.localid, ad.this.DJN);
          AppMethodBeat.o(95699);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(95699);
        }
      }
    };
    EventCenter.instance.asyncPublish((IEvent)localObject2, aj.faB());
    AppMethodBeat.o(95702);
    return true;
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    q localq = aj.faD().JK(this.ecf);
    localq.offset = 0;
    try
    {
      cne localcne = (cne)new cne().parseFrom(localq.EmR);
      localcne.Mtu = "";
      if (localcne.Mtx != null) {
        localcne.Mtx.vUh = 0;
      }
      localq.EmR = localcne.toByteArray();
      aj.faD().a(this.ecf, localq);
      aj.faN().Yx(this.ecf);
      AppMethodBeat.o(95706);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95706);
    }
  }
  
  public static abstract interface a
  {
    public abstract void uO(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */