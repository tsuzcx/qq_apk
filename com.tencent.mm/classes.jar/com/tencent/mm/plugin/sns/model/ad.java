package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xg;
import com.tencent.mm.f.a.xg.b;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class ad
{
  q JWP;
  a JWQ;
  private cvw JWR;
  private String clientId;
  int fWh;
  int jGU;
  String lPn;
  private g.a lPx;
  private long mJB;
  private String mPath;
  int mhr;
  private String ovC;
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
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/ad:mJB	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/ad:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/ad:jGU	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/ad:ovC	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/cvw
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/cvw:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/ad$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/ad$4:<init>	(Lcom/tencent/mm/plugin/sns/model/ad;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/ad:lPx	Lcom/tencent/mm/i/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/ad:mJB	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/ad:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/ad:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/ad:JWQ	Lcom/tencent/mm/plugin/sns/model/ad$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/ad:fWh	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/ad:JWP	Lcom/tencent/mm/plugin/sns/storage/q;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/cvw
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/cvw:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/cvw:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/cvw
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/cvw:TEA	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/cvw:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/ad:ovC	Ljava/lang/String;
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
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/ad:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/cvw:TEA	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/ad:JWR	Lcom/tencent/mm/protocal/protobuf/cvw;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/cvw:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/aj:fOx	()Lcom/tencent/mm/plugin/sns/storage/r;
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
    //   228: invokestatic 169	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/ad:ovC	Ljava/lang/String;
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
  
  final boolean a(cuv paramcuv, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.jGU = com.tencent.mm.i.a.iUb;
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
    localg.iUG = this.lPx;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.i.a.iUb;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!Util.isNullOrNil(paramString))
    {
      localg.field_largesvideo = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(paramString, 10);
      if (com.tencent.mm.pluginsdk.model.ad.bpQ(this.mPath))
      {
        h.IzE.idkeyStat(106L, 31L, 1L, false);
        localg.snsVersion = 1;
      }
      paramString = u.buc(this.mPath);
      if ((!Util.isNullOrNil(this.ovC)) && (!this.ovC.equals(paramString)))
      {
        Log.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ovC, paramString });
        afK(-2);
        this.JWQ.yv(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      com.tencent.mm.modelcontrol.e.bkp();
      if (paramcuv.TCA) {}
      for (paramString = com.tencent.mm.modelcontrol.e.bkp().bkr();; paramString = com.tencent.mm.modelcontrol.e.bkp().bks())
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.e.b(paramString);
        break;
      }
    }
    if (!com.tencent.mm.aq.f.bkg().f(localg))
    {
      Log.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((paramcuv != null) && (paramcuv.TCA)) {}
    for (int i = 4;; i = 5)
    {
      this.mhr = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aH(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    q localq = aj.fOx().Re(this.fWh);
    Log.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localq.KzZ = paramString3;
    try
    {
      paramString3 = (cvw)new cvw().parseFrom(localq.KAa);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new cvw();
      }
      paramString3 = new cvo();
      paramString3.rWu = 1;
      paramString3.Url = paramString1;
      ((cvw)localObject).TEx = paramString3;
      ((cvw)localObject).TAg = 0;
      com.tencent.mm.aq.f.bkh();
      ((cvw)localObject).TDY = com.tencent.mm.aq.a.Vu(this.mPath);
      Log.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((cvw)localObject).TDY });
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = new cvo();
        paramString1.rWu = 1;
        paramString1.Url = paramString2;
        ((cvw)localObject).TEz.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localq.KAa = ((cvw)localObject).toByteArray();
        localq.fSV();
        aj.fOx().a(this.fWh, localq);
        aj.fOH().afP(this.fWh);
        if (aj.fOE() != null) {
          aj.fOE().fNd();
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
  
  final void afK(int paramInt)
  {
    AppMethodBeat.i(95705);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    q localq = aj.fOx().Re(this.fWh);
    try
    {
      cvw localcvw = (cvw)new cvw().parseFrom(localq.KAa);
      localcvw.TAg = 1;
      localcvw.TEj = paramInt;
      if (this.JWR.TED != null) {
        this.JWR.TED.ABK = 0;
      }
      localq.KAa = localcvw.toByteArray();
    }
    catch (Exception localException)
    {
      label83:
      break label83;
    }
    aj.fOH().afP(this.fWh);
    aj.fOx().a(this.fWh, localq);
    AppMethodBeat.o(95705);
  }
  
  public final boolean baa(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = u.buc(this.mPath);
    if ((!Util.isNullOrNil(this.ovC)) && (!this.ovC.equals(localObject1)))
    {
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ovC, localObject1 });
      afK(-2);
      this.JWQ.yv(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.JWR.TED != null)
    {
      localObject1 = this.JWR.TED;
      if ((!Util.isNullOrNil(paramString)) && (((cuv)localObject1).TCE))
      {
        Log.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((cuv)localObject1).TCA = true;
        ((cuv)localObject1).TCF = paramString;
      }
      Log.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((cuv)localObject1).ABK), Boolean.valueOf(((cuv)localObject1).TCA), paramString });
      localObject2 = com.tencent.mm.plugin.sight.base.f.aYg(this.mPath);
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
      if (((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration < l1) {
        break label394;
      }
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration) });
      afK(-2);
      this.JWQ.yv(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new cuv();
      break;
      label358:
      if (((cuv)localObject1).TCA) {
        l1 = com.tencent.mm.modelcontrol.e.bkp().bkr().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.e.bkp().bks().duration;
      }
    }
    label394:
    if (!((cuv)localObject1).TCA)
    {
      a((cuv)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = com.tencent.mm.plugin.sight.base.a.JrD;
    if (((cuv)localObject1).ABK >= 3)
    {
      onError();
      AppMethodBeat.o(95702);
      return false;
    }
    Log.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new xg();
    ((xg)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        Log.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.JWS.fWl.result) });
        if (this.JWS.fWl.result >= 0)
        {
          ad.a(ad.this);
          ad.this.a(this.JWT, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        ad.this.onError();
        AppMethodBeat.o(95697);
      }
    };
    ((xg)localObject2).fWk.fWo = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean eRA()
      {
        AppMethodBeat.i(95698);
        Log.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ad.a(ad.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((xg)localObject2).fWk.fVR = this.mPath;
    ((xg)localObject2).fWk.scene = i;
    ((xg)localObject2).fWk.fWm = ((cuv)localObject1);
    ((xg)localObject2).fWk.fWn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.JWT.ABK += 1;
        try
        {
          Log.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.JWT.ABK) });
          cvw localcvw = (cvw)new cvw().parseFrom(ad.this.JWP.KAa);
          localcvw.TED = this.JWT;
          ad.this.JWP.KAa = localcvw.toByteArray();
          aj.fOx().a(ad.this.JWP.localid, ad.this.JWP);
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
    EventCenter.instance.asyncPublish((IEvent)localObject2, aj.fOv());
    AppMethodBeat.o(95702);
    return true;
  }
  
  final void onError()
  {
    AppMethodBeat.i(95706);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    q localq = aj.fOx().Re(this.fWh);
    localq.offset = 0;
    try
    {
      cvw localcvw = (cvw)new cvw().parseFrom(localq.KAa);
      localcvw.TEA = "";
      if (localcvw.TED != null) {
        localcvw.TED.ABK = 0;
      }
      localq.KAa = localcvw.toByteArray();
      aj.fOx().a(this.fWh, localq);
      aj.fOH().afP(this.fWh);
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
    public abstract void yv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */