package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yz;
import com.tencent.mm.autogen.a.yz.b;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

public final class af
{
  z QtX;
  a QtY;
  private dnc QtZ;
  private String clientId;
  int icg;
  private String mPath;
  private int mgx;
  String oHX;
  private long osG;
  private g.a osH;
  int paC;
  private String ryW;
  private long startTime;
  private String thumbPath;
  
  /* Error */
  public af(int paramInt, z paramz, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	java/lang/Object:<init>	()V
    //   4: ldc 44
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 52
    //   12: putfield 54	com/tencent/mm/plugin/sns/model/af:clientId	Ljava/lang/String;
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 56	com/tencent/mm/plugin/sns/model/af:osG	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 58	com/tencent/mm/plugin/sns/model/af:startTime	J
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 60	com/tencent/mm/plugin/sns/model/af:mgx	I
    //   30: aload_0
    //   31: ldc 52
    //   33: putfield 62	com/tencent/mm/plugin/sns/model/af:ryW	Ljava/lang/String;
    //   36: aload_0
    //   37: new 64	com/tencent/mm/protocal/protobuf/dnc
    //   40: dup
    //   41: invokespecial 65	com/tencent/mm/protocal/protobuf/dnc:<init>	()V
    //   44: putfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   47: aload_0
    //   48: new 12	com/tencent/mm/plugin/sns/model/af$4
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 70	com/tencent/mm/plugin/sns/model/af$4:<init>	(Lcom/tencent/mm/plugin/sns/model/af;)V
    //   56: putfield 72	com/tencent/mm/plugin/sns/model/af:osH	Lcom/tencent/mm/g/g$a;
    //   59: aload_0
    //   60: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   63: putfield 56	com/tencent/mm/plugin/sns/model/af:osG	J
    //   66: aload_0
    //   67: aload_3
    //   68: putfield 80	com/tencent/mm/plugin/sns/model/af:mPath	Ljava/lang/String;
    //   71: aload_0
    //   72: aload 4
    //   74: putfield 82	com/tencent/mm/plugin/sns/model/af:thumbPath	Ljava/lang/String;
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 84	com/tencent/mm/plugin/sns/model/af:QtY	Lcom/tencent/mm/plugin/sns/model/af$a;
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 86	com/tencent/mm/plugin/sns/model/af:icg	I
    //   88: aload_0
    //   89: aload_2
    //   90: putfield 88	com/tencent/mm/plugin/sns/model/af:QtX	Lcom/tencent/mm/plugin/sns/storage/z;
    //   93: aload_0
    //   94: new 64	com/tencent/mm/protocal/protobuf/dnc
    //   97: dup
    //   98: invokespecial 65	com/tencent/mm/protocal/protobuf/dnc:<init>	()V
    //   101: aload_2
    //   102: getfield 94	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   105: invokevirtual 98	com/tencent/mm/protocal/protobuf/dnc:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   108: checkcast 64	com/tencent/mm/protocal/protobuf/dnc
    //   111: putfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   119: getfield 101	com/tencent/mm/protocal/protobuf/dnc:aaUh	Ljava/lang/String;
    //   122: putfield 54	com/tencent/mm/plugin/sns/model/af:clientId	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   130: getfield 104	com/tencent/mm/protocal/protobuf/dnc:md5	Ljava/lang/String;
    //   133: putfield 62	com/tencent/mm/plugin/sns/model/af:ryW	Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 54	com/tencent/mm/plugin/sns/model/af:clientId	Ljava/lang/String;
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
    //   169: putfield 54	com/tencent/mm/plugin/sns/model/af:clientId	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   176: aload_0
    //   177: getfield 54	com/tencent/mm/plugin/sns/model/af:clientId	Ljava/lang/String;
    //   180: putfield 101	com/tencent/mm/protocal/protobuf/dnc:aaUh	Ljava/lang/String;
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 67	com/tencent/mm/plugin/sns/model/af:QtZ	Lcom/tencent/mm/protocal/protobuf/dnc;
    //   188: invokevirtual 139	com/tencent/mm/protocal/protobuf/dnc:toByteArray	()[B
    //   191: putfield 94	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   194: invokestatic 145	com/tencent/mm/plugin/sns/model/al:hgq	()Lcom/tencent/mm/plugin/sns/storage/aa;
    //   197: aload_2
    //   198: getfield 148	com/tencent/mm/plugin/sns/storage/z:localid	I
    //   201: aload_2
    //   202: invokevirtual 153	com/tencent/mm/plugin/sns/storage/aa:a	(ILcom/tencent/mm/plugin/sns/storage/z;)I
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
    //   228: invokestatic 169	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   231: l2i
    //   232: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: dup
    //   237: iconst_3
    //   238: aload_0
    //   239: getfield 62	com/tencent/mm/plugin/sns/model/af:ryW	Ljava/lang/String;
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
    //   0	282	0	this	af
    //   0	282	1	paramInt	int
    //   0	282	2	paramz	z
    //   0	282	3	paramString1	String
    //   0	282	4	paramString2	String
    //   0	282	5	parama	a
    // Exception table:
    //   from	to	target	type
    //   93	114	252	java/lang/Exception
    //   183	206	266	java/lang/Exception
  }
  
  final boolean a(dmb paramdmb, String paramString)
  {
    AppMethodBeat.i(95703);
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.mgx = com.tencent.mm.g.a.lwg;
    }
    String str = this.clientId;
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
      AppMethodBeat.o(95703);
      return false;
    }
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_NetSceneSnsUpload_2";
    localg.lwL = this.osH;
    localg.field_mediaId = str;
    localg.field_fullpath = this.mPath;
    localg.field_thumbpath = this.thumbPath;
    localg.field_fileType = com.tencent.mm.g.a.lwg;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    localg.field_needStorage = true;
    localg.field_isStreamMedia = false;
    localg.field_appType = 102;
    localg.field_bzScene = 1;
    if (!Util.isNullOrNil(paramString))
    {
      localg.field_largesvideo = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(paramString, 10);
      if (com.tencent.mm.pluginsdk.model.af.bpH(this.mPath))
      {
        h.OAn.idkeyStat(106L, 31L, 1L, false);
        localg.snsVersion = 1;
      }
      paramString = y.bub(this.mPath);
      if ((!Util.isNullOrNil(this.ryW)) && (!this.ryW.equals(paramString)))
      {
        Log.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ryW, paramString });
        akz(-2);
        this.QtY.DD(false);
        AppMethodBeat.o(95703);
        return false;
      }
    }
    else
    {
      if (paramdmb.aaSm)
      {
        com.tencent.mm.modelcontrol.e.bIg();
        paramString = com.tencent.mm.modelcontrol.e.bIg().bIj();
      }
      for (;;)
      {
        localg.field_largesvideo = com.tencent.mm.modelcontrol.e.b(paramString);
        break;
        com.tencent.mm.modelcontrol.e.bIg();
        if (paramdmb.aaSg) {
          paramString = com.tencent.mm.modelcontrol.e.bIg().bIi();
        } else {
          paramString = com.tencent.mm.modelcontrol.e.bIg().bIk();
        }
      }
    }
    if (!k.bHW().g(localg))
    {
      Log.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { str });
      AppMethodBeat.o(95703);
      return false;
    }
    if ((paramdmb != null) && (paramdmb.aaSg)) {}
    for (int i = 4;; i = 5)
    {
      this.paC = i;
      AppMethodBeat.o(95703);
      return true;
    }
  }
  
  public final boolean aX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95704);
    z localz = al.hgq().vk(this.icg);
    Log.d("MicroMsg.SightCdnUpload", "upload ok " + paramString1 + "  " + paramString3 + "  1");
    localz.strId = paramString3;
    try
    {
      paramString3 = (dnc)new dnc().parseFrom(localz.QZv);
      localObject = paramString3;
      if (paramString3 == null) {
        localObject = new dnc();
      }
      paramString3 = new dmu();
      paramString3.vhJ = 1;
      paramString3.Url = paramString1;
      ((dnc)localObject).aaUe = paramString3;
      ((dnc)localObject).aaPu = 0;
      k.bHX();
      ((dnc)localObject).aaTE = com.tencent.mm.modelcdntran.d.Nu(this.mPath);
      Log.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[] { ((dnc)localObject).aaTE });
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = new dmu();
        paramString1.vhJ = 1;
        paramString1.Url = paramString2;
        ((dnc)localObject).aaUg.add(paramString1);
      }
    }
    catch (Exception paramString3)
    {
      try
      {
        Object localObject;
        localz.QZv = ((dnc)localObject).toByteArray();
        localz.hlh();
        al.hgq().a(this.icg, localz);
        al.hgA().akE(this.icg);
        if (al.hgx() != null) {
          al.hgx().hej();
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
  
  public final boolean aYq(final String paramString)
  {
    AppMethodBeat.i(95702);
    Object localObject1 = y.bub(this.mPath);
    if ((!Util.isNullOrNil(this.ryW)) && (!this.ryW.equals(localObject1)))
    {
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ryW, localObject1 });
      akz(-2);
      this.QtY.DD(false);
      AppMethodBeat.o(95702);
      return false;
    }
    long l1;
    if (this.QtZ.aaUk != null)
    {
      localObject1 = this.QtZ.aaUk;
      if ((!Util.isNullOrNil(paramString)) && (((dmb)localObject1).aaSk))
      {
        Log.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", new Object[] { paramString });
        ((dmb)localObject1).aaSg = true;
        ((dmb)localObject1).aaSl = paramString;
      }
      Log.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", new Object[] { this.mPath, Integer.valueOf(((dmb)localObject1).Gad), Boolean.valueOf(((dmb)localObject1).aaSg), paramString });
      localObject2 = f.aVX(this.mPath);
      if (localObject2 == null) {
        break label423;
      }
      Log.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[] { localObject2 });
      if (Util.isNullOrNil(paramString)) {
        break label365;
      }
      l1 = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(paramString, com.tencent.mm.modelcontrol.e.bIg().bIk().duration);
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = 10L;
      }
      l1 = l2 * 1000L + 3000L;
      Log.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[] { Long.valueOf(l1) });
      if (((b)localObject2).videoDuration < l1) {
        break label423;
      }
      Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[] { Integer.valueOf(((b)localObject2).videoDuration) });
      akz(-2);
      this.QtY.DD(false);
      AppMethodBeat.o(95702);
      return false;
      localObject1 = new dmb();
      break;
      label365:
      if (((dmb)localObject1).aaSm) {
        l1 = com.tencent.mm.modelcontrol.e.bIg().bIj().duration;
      } else if (((dmb)localObject1).aaSg) {
        l1 = com.tencent.mm.modelcontrol.e.bIg().bIi().duration;
      } else {
        l1 = com.tencent.mm.modelcontrol.e.bIg().bIk().duration;
      }
    }
    label423:
    if (!((dmb)localObject1).aaSg)
    {
      a((dmb)localObject1, paramString);
      AppMethodBeat.o(95702);
      return true;
    }
    int i = com.tencent.mm.plugin.sight.base.a.PFd;
    if (((dmb)localObject1).Gad >= 3)
    {
      atR();
      AppMethodBeat.o(95702);
      return false;
    }
    Log.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[] { Integer.valueOf(i), this.mPath });
    Object localObject2 = new yz();
    ((yz)localObject2).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95697);
        Log.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.Qua.ick.result) });
        if (this.Qua.ick.result >= 0)
        {
          af.a(af.this);
          af.this.a(this.Qub, paramString);
          AppMethodBeat.o(95697);
          return;
        }
        af.this.atR();
        AppMethodBeat.o(95697);
      }
    };
    ((yz)localObject2).icj.icn = new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean gaj()
      {
        AppMethodBeat.i(95698);
        Log.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        af.a(af.this);
        AppMethodBeat.o(95698);
        return false;
      }
    };
    ((yz)localObject2).icj.ibR = this.mPath;
    ((yz)localObject2).icj.scene = i;
    ((yz)localObject2).icj.icl = ((dmb)localObject1);
    ((yz)localObject2).icj.icm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95699);
        this.Qub.Gad += 1;
        try
        {
          Log.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.Qub.Gad) });
          dnc localdnc = (dnc)new dnc().parseFrom(af.this.QtX.QZv);
          localdnc.aaUk = this.Qub;
          af.this.QtX.QZv = localdnc.toByteArray();
          al.hgq().a(af.this.QtX.localid, af.this.QtX);
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
    ((yz)localObject2).asyncPublish(al.hgo());
    AppMethodBeat.o(95702);
    return true;
  }
  
  final void akz(int paramInt)
  {
    AppMethodBeat.i(95705);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    z localz = al.hgq().vk(this.icg);
    try
    {
      dnc localdnc = (dnc)new dnc().parseFrom(localz.QZv);
      localdnc.aaPu = 1;
      localdnc.aaTP = paramInt;
      if (this.QtZ.aaUk != null) {
        this.QtZ.aaUk.Gad = 0;
      }
      localz.QZv = localdnc.toByteArray();
    }
    catch (Exception localException)
    {
      label83:
      break label83;
    }
    al.hgA().akE(this.icg);
    al.hgq().a(this.icg, localz);
    AppMethodBeat.o(95705);
  }
  
  final void atR()
  {
    AppMethodBeat.i(95706);
    Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
    z localz = al.hgq().vk(this.icg);
    localz.offset = 0;
    try
    {
      dnc localdnc = (dnc)new dnc().parseFrom(localz.QZv);
      localdnc.aaUh = "";
      if (localdnc.aaUk != null) {
        localdnc.aaUk.Gad = 0;
      }
      localz.QZv = localdnc.toByteArray();
      al.hgq().a(this.icg, localz);
      al.hgA().akE(this.icg);
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
    public abstract void DD(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af
 * JD-Core Version:    0.7.0.1
 */