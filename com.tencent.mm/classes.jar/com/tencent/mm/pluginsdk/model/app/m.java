package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static com.tencent.mm.plugin.record.b.f xGr;
  
  public static int Zb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static int a(long paramLong, String paramString, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31028);
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().ys(paramLong);
    int i;
    if (localbv.field_msgId != paramLong)
    {
      ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.zb(localbv.field_content);
    if (localb == null)
    {
      ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    localb.dlu = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label399;
      }
      str = localb.gmb;
      localb.gmb = str;
      if (!paramd.field_fileId.equals("")) {
        break label408;
      }
      str = localb.hCR;
      label198:
      localb.hCR = str;
      if (!paramd.field_filemd5.equals("")) {
        break label417;
      }
      str = localb.filemd5;
      label224:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label426;
      }
      i = localb.hCC;
      label247:
      localb.hCC = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label436;
      }
    }
    label399:
    label408:
    label417:
    label426:
    label436:
    for (String str = localb.hCS;; str = paramd.field_thumbUrl)
    {
      localb.hCS = str;
      localbv.setContent(k.b.a(localb, localb.dlu, paramd));
      bc.aCg();
      com.tencent.mm.model.c.azI().a(localbv.field_msgId, localbv);
      paramd = ao.fdU().yb(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbv.field_content;
        ao.fdU().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ao.bJV().CZ(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ao.bJV().a(paramd, new String[0]);
      }
      AppMethodBeat.o(31028);
      return 0;
      str = paramd.field_aesKey;
      break;
      str = paramd.field_fileId;
      break label198;
      str = paramd.field_filemd5;
      break label224;
      i = (int)paramd.field_fileLength;
      break label247;
    }
  }
  
  public static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31035);
    paramInt = a(paramb, paramWXMediaMessage, paramString, null, null, paramInt, parama);
    AppMethodBeat.o(31035);
    return paramInt;
  }
  
  private static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(31036);
    if (paramInt == 1)
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.tools.c();
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).dGQ = 1;
      paramb.a((com.tencent.mm.ah.f)localObject1);
    }
    Object localObject2 = b(paramb, paramWXMediaMessage, paramString2);
    ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.hCB + " attachlen:" + paramb.hCC + " attachid:" + paramb.dlu + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    if (!bu.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(31036);
        return 0 - paramInt;
      }
      localObject2 = com.tencent.mm.sdk.platformtools.h.aRz((String)localObject2);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bv localbv = new bv();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 65536) || (paramWXMediaMessage.getType() == 36) || (paramWXMediaMessage.getType() == 46)) {
          break label562;
        }
        if (paramb.type != 2) {
          break label556;
        }
        bool = true;
        localObject2 = com.tencent.mm.av.q.aIX().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label288:
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bu.isNullOrNil((String)localObject2)) {
          localbv.uj((String)localObject2);
        }
      }
      if (localObject1 != null) {
        paramb.dlu = ((c)localObject1).systemRowid;
      }
      paramString1 = bu.U(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label870;
        }
        localObject2 = (String)paramString1.next();
        paramb.hCE = paramString2;
        localbv.setContent(k.b.a(paramb, null, null));
        localbv.setStatus(1);
        localbv.ui((String)localObject2);
        localbv.qN(bl.BQ((String)localObject2));
        localbv.kt(1);
        localbv.setType(g(paramb));
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.w)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.w.class)).Q(localbv);
        if (!bu.isNullOrNil((String)localObject2)) {
          localbv.tk((String)localObject2);
        }
        bc.aCg();
        long l = com.tencent.mm.model.c.azI().ar(localbv);
        if (l < 0L)
        {
          ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " summerbig insert msg failed :" + l);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(31036);
          return 0 - paramInt;
          label556:
          bool = false;
          break;
          label562:
          localObject2 = com.tencent.mm.av.q.aIX().aa(paramWXMediaMessage.thumbData);
          break label288;
        }
        ae.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbv.setMsgId(l);
        localObject2 = new com.tencent.mm.ah.k();
        ((com.tencent.mm.ah.k)localObject2).field_xml = localbv.field_content;
        ((com.tencent.mm.ah.k)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.ah.k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.ah.k)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.ah.k)localObject2).field_msgId = l;
        ((com.tencent.mm.ah.k)localObject2).field_source = paramb.appName;
        ao.fdU().insert((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = l;
          ((c)localObject1).field_status = 101L;
          ae.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((com.tencent.mm.ah.k)localObject2).field_type) });
          ao.bJV().a((c)localObject1, new String[0]);
          if (!bu.isNullOrNil(paramString3)) {
            ao.fdW().K(((c)localObject1).field_msgInfoId, paramString3);
          }
          ao.fdW().run();
        }
        else
        {
          ae.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((com.tencent.mm.ah.k)localObject2).field_type) });
          ao.fdW();
          an.a.a(l, paramString3, paramInt, parama);
        }
      }
      label870:
      AppMethodBeat.o(31036);
      return 0;
      localObject1 = null;
    }
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(31033);
    paramInt = a(paramWXMediaMessage, paramString1, paramString2, paramString3, paramInt, paramString4, null, 0, null);
    AppMethodBeat.o(31033);
    return paramInt;
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, a parama)
  {
    AppMethodBeat.i(31034);
    k.b localb = new k.b();
    localb.appId = paramString1;
    localb.appName = paramString2;
    localb.hCF = paramInt1;
    paramInt1 = a(localb, paramWXMediaMessage, paramString3, paramString4, paramString5, paramInt2, parama);
    AppMethodBeat.o(31034);
    return paramInt1;
  }
  
  public static Pair<Integer, Long> a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31029);
    paramb = a(paramb, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, null);
    AppMethodBeat.o(31029);
    return paramb;
  }
  
  public static Pair<Integer, Long> a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    AppMethodBeat.i(31030);
    paramb = a(paramb, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramString5, "");
    AppMethodBeat.o(31030);
    return paramb;
  }
  
  public static Pair<Integer, Long> a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6)
  {
    AppMethodBeat.i(31032);
    ae.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    if (!bu.isNullOrNil(paramString4))
    {
      localObject = a((String)localObject, paramb, paramString4);
      if (localObject == null)
      {
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31032);
        return paramb;
      }
    }
    for (;;)
    {
      bv localbv = new bv();
      int i;
      int j;
      String str;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 44) && (paramb.type != 48)) {
          break label708;
        }
        if (paramb.type != 48) {
          break label642;
        }
        i = 0;
        j = 0;
        com.tencent.mm.ah.a locala = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
        if (locala == null) {
          break label671;
        }
        str = locala.hBa;
        label193:
        if (locala == null) {
          break label678;
        }
        bool = locala.hBb;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label684;
        }
        paramArrayOfByte = com.tencent.mm.av.q.aIX().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, str, bool);
      }
      final long l;
      for (;;)
      {
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " thumbData MsgInfo path:" + paramArrayOfByte);
        if (!bu.isNullOrNil(paramArrayOfByte))
        {
          localbv.uj(paramArrayOfByte);
          ae.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramArrayOfByte)));
        }
        if (localObject != null) {
          paramb.dlu = ((c)localObject).systemRowid;
        }
        localbv.setContent(k.b.a(paramb, null, null));
        localbv.setStatus(1);
        localbv.ui(paramString3);
        localbv.qN(bl.BQ(paramString3));
        localbv.kt(1);
        localbv.setType(g(paramb));
        paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.w)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.w.class)).Q(localbv);
        if (!bu.isNullOrNil(paramArrayOfByte))
        {
          localbv.tk(paramArrayOfByte);
          ae.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbv.eNd });
        }
        if (paramb.type == 53) {
          localbv.ut((String)paramb.hFp.first);
        }
        bc.aCg();
        l = com.tencent.mm.model.c.azI().ar(localbv);
        if (paramb.type == 53)
        {
          paramArrayOfByte = new nb();
          paramArrayOfByte.dCa.type = 0;
          paramArrayOfByte.dCa.key = localbv.fmz;
          paramArrayOfByte.dCa.username = localbv.field_talker;
          paramArrayOfByte.dCb.msgId = l;
          com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
        }
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label768;
        }
        ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label642:
        i = (int)(com.tencent.mm.sdk.platformtools.h.aRe().density * 240.0F);
        j = (int)(com.tencent.mm.sdk.platformtools.h.aRe().density * 240.0F);
        break;
        label671:
        str = "";
        break label193;
        label678:
        bool = false;
        break label205;
        label684:
        paramArrayOfByte = com.tencent.mm.av.q.aIX().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, str, bool);
        continue;
        label708:
        if (paramb.type != 46) {
          break label733;
        }
        paramArrayOfByte = com.tencent.mm.av.q.aIX().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label733:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = com.tencent.mm.av.q.aIX().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label768:
      ae.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbv.setMsgId(l);
      paramArrayOfByte = new com.tencent.mm.ah.k();
      paramArrayOfByte.field_xml = localbv.field_content;
      paramArrayOfByte.field_appId = paramString1;
      paramArrayOfByte.field_title = paramb.title;
      paramArrayOfByte.field_type = paramb.type;
      paramArrayOfByte.field_description = paramb.description;
      paramArrayOfByte.field_msgId = l;
      paramArrayOfByte.field_source = paramString2;
      ao.fdU().insert(paramArrayOfByte);
      if (localObject == null)
      {
        bool = true;
        ae.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label1005;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ao.bJV().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!bu.isNullOrNil(paramString5))) {
          ao.fdW().K(l, paramString5);
        }
        ao.fdW().run();
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label1005:
        if ((paramb.hCG != 0) || (paramb.hCC > 26214400))
        {
          bc.ajj().a(new com.tencent.mm.pluginsdk.g.c(paramb, paramString4, paramString3, new c.a()
          {
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
            {
              AppMethodBeat.i(186689);
              if (bu.isNullOrNil(paramAnonymousString4))
              {
                this.hHv.setStatus(5);
                bc.aCg();
                com.tencent.mm.model.c.azI().a(this.hHv.field_msgId, this.hHv);
                paramAnonymousString2 = new bv();
                paramAnonymousString2.qN(bl.BQ(paramAnonymousString2.field_talker));
                paramAnonymousString2.ui(paramAnonymousString2.field_talker);
                paramAnonymousString2.setContent(paramAnonymousString1);
                paramAnonymousString2.setType(10000);
                paramAnonymousString2.setStatus(6);
                paramAnonymousString2.kt(0);
                bc.aCg();
                com.tencent.mm.model.c.azI().ar(paramAnonymousString2);
                AppMethodBeat.o(186689);
                return;
              }
              ao.fdW();
              an.a.f(l, this.kke, paramAnonymousString4);
              AppMethodBeat.o(186689);
            }
          }), 0);
        }
        else
        {
          ao.fdW();
          an.a.f(l, paramString5, paramString6);
        }
      }
      localObject = null;
    }
  }
  
  public static c a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(31026);
    c localc = new c();
    localc.field_fileFullPath = paramString1;
    localc.field_appId = paramString2;
    localc.field_sdkVer = paramInt1;
    localc.field_mediaSvrId = paramString3;
    localc.field_totalLen = paramInt2;
    localc.field_status = 101L;
    localc.field_isUpload = false;
    localc.field_createTime = bu.fpO();
    localc.field_lastModifyTime = bu.aRi();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    ae.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.asa()))
    {
      ae.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.hCC;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = bu.fpO();
    ((c)localObject).field_lastModifyTime = bu.aRi();
    ((c)localObject).field_mediaSvrId = bu.fpO();
    ((c)localObject).field_isUseCdn = 0;
    ao.bJV().insert((com.tencent.mm.sdk.e.c)localObject);
    ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
      AppMethodBeat.o(31027);
      return null;
    }
    AppMethodBeat.o(31027);
    return localObject;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31025);
    c localc = new c();
    localc.field_fileFullPath = paramString1;
    localc.field_appId = paramString2;
    localc.field_sdkVer = paramInt1;
    localc.field_mediaSvrId = paramString3;
    localc.field_totalLen = paramInt2;
    localc.field_status = 101L;
    localc.field_isUpload = false;
    localc.field_createTime = bu.fpO();
    localc.field_lastModifyTime = bu.aRi();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ae.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ao.bJV().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bu.fpN() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  private static List<a.b> a(long paramLong, String paramString, akn paramakn)
  {
    AppMethodBeat.i(186691);
    List localList = Collections.synchronizedList(new ArrayList());
    Iterator localIterator = paramakn.oeJ.iterator();
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      if (localajx.GzV > 26214400L)
      {
        a.b localb = new a.b();
        String str = p.c(localajx, paramLong);
        paramakn = com.tencent.mm.vfs.o.aRh(str);
        localb.toUser = paramString;
        localb.fileSize = localajx.GzV;
        localb.fXl = localajx.GzP;
        if (bu.isNullOrNil(localajx.GzR))
        {
          label121:
          localb.nZM = paramakn;
          localb.gmb = localajx.GzC;
          localb.fileName = localajx.title;
          if (!bu.isNullOrNil(localajx.GzY)) {
            break label189;
          }
        }
        label189:
        for (paramakn = str;; paramakn = localajx.GzY)
        {
          localb.filePath = paramakn;
          localList.add(localb);
          break;
          paramakn = localajx.GzR;
          break label121;
        }
      }
    }
    AppMethodBeat.o(186691);
    return localList;
  }
  
  public static void a(bv parambv, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.zb(parambv.field_content);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambv.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((bu.isNullOrNil(((k.b)localObject).dlu)) && (!bu.isNullOrNil(((k.b)localObject).hCR)))
    {
      ae.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambv.field_content });
      ((k.b)localObject).dlu = ((k.b)localObject).hCR.hashCode();
    }
    localObject = ((k.b)localObject).dlu;
    if ((!a(parambv, r((String)localObject, parambv.field_msgId))) && (e((String)localObject, parambv)))
    {
      xGr = new com.tencent.mm.plugin.record.b.f(parambv.field_msgId, (String)localObject, new com.tencent.mm.ak.g()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
        {
          AppMethodBeat.i(31016);
          if (this.Ffw != null) {
            this.Ffw.jo(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(31016);
        }
      });
      bc.ajj().a(xGr, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static boolean a(bv parambv, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!com.tencent.mm.vfs.o.fB(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.cZe()) || ((parambv.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static Pair<Integer, Long> aF(bv parambv)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.zb(parambv.field_content);
    if (localObject5 == null)
    {
      ae.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = aNj(((k.b)localObject5).dlu);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((c)localObject4).field_fileFullPath != null)
      {
        localObject1 = localObject2;
        if (!((c)localObject4).field_fileFullPath.equals(""))
        {
          bc.aCg();
          localObject1 = aq(com.tencent.mm.model.c.azY(), ((k.b)localObject5).title, ((k.b)localObject5).hCD);
          com.tencent.mm.vfs.o.mF(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambv.field_imgPath != null) && (!parambv.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = com.tencent.mm.av.q.aIX().R(parambv.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = com.tencent.mm.vfs.o.bb((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (bu.isNullOrNil((String)localObject1)) {
          break label1087;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        parambv = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return parambv;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new bv();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label700;
        }
        localObject3 = com.tencent.mm.av.q.aIX().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!bu.isNullOrNil((String)localObject3))
        {
          ((bv)localObject6).uj((String)localObject3);
          ae.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((k.b)localObject4).dlu = ((c)localObject1).systemRowid;
      }
      ((bv)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((bv)localObject6).setStatus(1);
      ((bv)localObject6).ui(parambv.field_talker);
      ((bv)localObject6).qN(bl.BQ(parambv.field_talker));
      ((bv)localObject6).kt(1);
      ((bv)localObject6).setType(g((k.b)localObject4));
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.w)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.w.class)).Q((bv)localObject6);
      if (!bu.isNullOrNil((String)localObject3))
      {
        ((bv)localObject6).tk((String)localObject3);
        ae.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((ei)localObject6).eNd });
      }
      if (((k.b)localObject4).type == 53) {
        ((bv)localObject6).ut(parambv.fmz);
      }
      bc.aCg();
      long l = com.tencent.mm.model.c.azI().ar((bv)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new nb();
        ((nb)localObject3).dCa.type = 0;
        ((nb)localObject3).dCa.key = ((ei)localObject6).fmz;
        ((nb)localObject3).dCa.username = ((ei)localObject6).field_talker;
        ((nb)localObject3).dCb.msgId = l;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
      }
      ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
        parambv = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambv;
        label700:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = com.tencent.mm.av.q.aIX().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      ae.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bv)localObject6).setMsgId(l);
      localObject3 = new xk();
      ((xk)localObject3).dMQ.dMR = parambv.field_msgId;
      ((xk)localObject3).dMQ.dMS = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
      localObject3 = new com.tencent.mm.ah.k();
      ((com.tencent.mm.ah.k)localObject3).field_xml = ((ei)localObject6).field_content;
      ((com.tencent.mm.ah.k)localObject3).field_title = ((k.b)localObject4).title;
      ((com.tencent.mm.ah.k)localObject3).field_type = ((k.b)localObject4).type;
      ((com.tencent.mm.ah.k)localObject3).field_description = ((k.b)localObject4).description;
      ((com.tencent.mm.ah.k)localObject3).field_msgId = l;
      ((com.tencent.mm.ah.k)localObject3).field_source = ((String)localObject5);
      ao.fdU().insert((com.tencent.mm.sdk.e.c)localObject3);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ao.bJV().a((c)localObject1, new String[0]);
        ao.fdW().run();
      }
      for (;;)
      {
        parambv = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambv;
        if ((((k.b)localObject4).type == 24) || (((k.b)localObject4).type == 19))
        {
          localObject1 = p.awG(((k.b)localObject4).hDg);
          localObject3 = new akn();
          if (localObject1 != null) {
            ((akn)localObject3).oeJ.addAll(((com.tencent.mm.protocal.b.a.c)localObject1).hFT);
          }
          localObject5 = parambv.field_talker;
          List localList = a(l, (String)localObject5, (akn)localObject3);
          if (localList.size() > 0)
          {
            com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.pluginsdk.g.a(localList, new m.3(l, parambv, (String)localObject5, (k.b)localObject4, (akn)localObject3, (com.tencent.mm.protocal.b.a.c)localObject1, (bv)localObject6)), 0);
          }
          else
          {
            ao.fdW();
            an.a.zb(l);
          }
        }
        else
        {
          ao.fdW();
          an.a.zb(l);
        }
      }
      label1087:
      localObject1 = null;
    }
  }
  
  public static boolean aNh(String paramString)
  {
    AppMethodBeat.i(31017);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31017);
      return false;
    }
    if (paramString.equals("0:0"))
    {
      AppMethodBeat.o(31017);
      return false;
    }
    AppMethodBeat.o(31017);
    return true;
  }
  
  public static int aNi(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.zb(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!aNh(localb.dlu))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = bu.getLong(localb.dlu, -1L);
    if (l != -1L)
    {
      ao.bJV().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ao.bJV().aMZ(localb.dlu);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.dlu)) {}
        }
        else
        {
          AppMethodBeat.o(31019);
          return -1;
        }
      }
    }
    else
    {
      localc = ao.bJV().aMZ(localb.dlu);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.dlu)) {}
      }
      else
      {
        AppMethodBeat.o(31019);
        return -1;
      }
    }
    if (paramString.field_totalLen == 0L)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    int i = (int)(paramString.field_offset * 100L / paramString.field_totalLen);
    AppMethodBeat.o(31019);
    return i;
  }
  
  public static c aNj(String paramString)
  {
    AppMethodBeat.i(31040);
    c localc2 = new c();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31040);
      return null;
    }
    ae.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bu.getLong(paramString, -1L);
    c localc1;
    if (l != -1L)
    {
      ao.bJV().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ao.bJV().aMZ(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localc1 = null;
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      AppMethodBeat.o(31040);
      return localc1;
      localc2 = ao.bJV().aMZ(paramString);
      if (localc2 != null)
      {
        localc1 = localc2;
        if (localc2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localc1 = null;
      }
    }
  }
  
  public static String aq(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new com.tencent.mm.vfs.k(paramString1);
    if (!((com.tencent.mm.vfs.k)localObject).exists()) {
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    String str1;
    String str2;
    if (bu.isNullOrNil(paramString2))
    {
      str1 = paramString1 + "da_" + bu.fpO();
      localObject = str1;
      str2 = paramString2;
      if (!bu.isNullOrNil(paramString3))
      {
        localObject = str1 + "." + paramString3;
        str2 = paramString2;
      }
    }
    do
    {
      paramString2 = (String)localObject;
      try
      {
        if (!com.tencent.mm.vfs.w.B(new com.tencent.mm.vfs.k((String)localObject).fTg().fTh()).equalsIgnoreCase(com.tencent.mm.vfs.w.B(new com.tencent.mm.vfs.k(paramString1).fTh())))
        {
          localObject = paramString1 + "da_" + bu.fpO();
          paramString2 = (String)localObject;
          if (!bu.isNullOrNil(str2)) {
            paramString2 = (String)localObject + str2;
          }
          localObject = paramString2;
          if (!bu.isNullOrNil(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
          ae.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
          paramString2 = (String)localObject;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bu.fpO();
          paramString2 = paramString1;
          if (!bu.isNullOrNil(paramString3)) {
            paramString2 = paramString1 + "." + paramString3;
          }
        }
      }
      AppMethodBeat.o(31031);
      return paramString2;
      str1 = paramString2;
      if (!bu.isNullOrNil(paramString3))
      {
        str1 = paramString2;
        if (!paramString2.endsWith(paramString3)) {
          str1 = paramString2 + "." + paramString3;
        }
      }
      paramString2 = paramString1 + str1;
      localObject = paramString2;
      str2 = str1;
    } while (!com.tencent.mm.vfs.o.fB(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!com.tencent.mm.vfs.o.fB(paramString1 + i + "_" + str1)) {
          localObject = paramString1 + i + "_" + str1;
        }
      }
      else
      {
        str2 = str1;
        if (i != 20) {
          break;
        }
        paramString2 = paramString1 + "da_" + bu.fpO();
        localObject = paramString2;
        str2 = str1;
        if (bu.isNullOrNil(paramString3)) {
          break;
        }
        localObject = paramString2 + "." + paramString3;
        str2 = str1;
        break;
      }
      i += 1;
    }
  }
  
  public static String b(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(31038);
    ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
    paramb.sdkVer = paramWXMediaMessage.sdkVer;
    paramb.title = paramWXMediaMessage.title;
    paramb.description = paramWXMediaMessage.description;
    paramb.mediaTagName = paramWXMediaMessage.mediaTagName;
    paramb.messageAction = paramWXMediaMessage.messageAction;
    paramb.messageExt = paramWXMediaMessage.messageExt;
    paramWXMediaMessage = paramWXMediaMessage.mediaObject;
    paramb.type = paramWXMediaMessage.type();
    if (paramb.type == 7)
    {
      paramWXMediaMessage = (WXAppExtendObject)paramWXMediaMessage;
      paramb.extInfo = paramWXMediaMessage.extInfo;
      if (!bu.cF(paramWXMediaMessage.fileData))
      {
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hCC = paramWXMediaMessage.fileData.length;
        paramb = cl(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hCC = ((int)com.tencent.mm.vfs.o.aZR(paramWXMediaMessage.filePath));
      ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hCC);
      if (paramb.hCC > 0)
      {
        paramb.hCD = com.tencent.mm.vfs.o.aaw(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(31038);
        return paramb;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.Za(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bu.cF(paramWXMediaMessage.fileData))
      {
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hCC = paramWXMediaMessage.fileData.length;
        paramb = cl(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hCC = ((int)com.tencent.mm.vfs.o.aZR(paramWXMediaMessage.filePath));
      ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hCC);
      if (paramb.hCC > 0)
      {
        paramb.hCD = com.tencent.mm.vfs.o.aaw(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(31038);
        return paramb;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!bu.cF(paramWXMediaMessage.imageData))
      {
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.hCC = paramWXMediaMessage.imageData.length;
        paramb = cl(paramWXMediaMessage.imageData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      if (!bu.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.hCC = ((int)com.tencent.mm.vfs.o.aZR(paramWXMediaMessage.imagePath));
        ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.hCC);
        if (paramb.hCC > 0)
        {
          paramb.hCD = com.tencent.mm.vfs.o.aaw(paramWXMediaMessage.imagePath);
          bc.aCg();
          paramb = com.tencent.mm.vfs.w.B(new com.tencent.mm.vfs.k(com.tencent.mm.model.c.azY(), "appmsg_img_" + System.currentTimeMillis()).fTh());
          paramString = com.tencent.mm.sdk.platformtools.h.aRz(paramWXMediaMessage.imagePath);
          if ((paramString == null) || (paramString.outWidth <= 0) || (paramString.outHeight <= 0))
          {
            boolean bool;
            int i;
            if (paramString == null)
            {
              bool = true;
              if (paramString != null) {
                break label855;
              }
              i = -1;
              label799:
              if (paramString != null) {
                break label863;
              }
            }
            label855:
            label863:
            for (int j = -1;; j = paramString.outHeight)
            {
              ae.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(31038);
              return null;
              bool = false;
              break;
              i = paramString.outWidth;
              break label799;
            }
          }
          if (v.f(paramWXMediaMessage.imagePath, "", true))
          {
            ae.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (com.tencent.mm.vfs.o.mF(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              ae.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(31038);
              return null;
            }
            AppMethodBeat.o(31038);
            return paramb;
          }
          if ((paramString.outWidth > 960) || (paramString.outHeight > 960))
          {
            paramWXMediaMessage = com.tencent.mm.sdk.platformtools.h.d(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (com.tencent.mm.vfs.o.mF(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.h.a(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(31038);
              return paramb;
            }
            catch (IOException paramb)
            {
              ae.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
              AppMethodBeat.o(31038);
              return null;
            }
            AppMethodBeat.o(31038);
            return null;
          }
          AppMethodBeat.o(31038);
          return null;
        }
        AppMethodBeat.o(31038);
        return null;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.hCB = paramWXMediaMessage.musicLowBandUrl;
      paramb.hCY = paramWXMediaMessage.musicDataUrl;
      paramb.hCZ = paramWXMediaMessage.musicLowBandDataUrl;
      paramString = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString.songAlbumUrl = paramWXMediaMessage.songAlbumUrl;
      paramString.songLyric = paramWXMediaMessage.songLyric;
      paramb.a(paramString);
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.videoUrl;
      paramb.hCB = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 5) || (paramb.type == 54) || (paramb.type == 69))
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!bu.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bu.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      if ((paramb.type == 69) && ((paramWXMediaMessage instanceof com.tencent.mm.plugin.game.luggage.e.b)))
      {
        paramWXMediaMessage = (com.tencent.mm.plugin.game.luggage.e.b)paramWXMediaMessage;
        paramString = new com.tencent.mm.plugin.game.luggage.e.a();
        paramString.iconUrl = paramWXMediaMessage.iconUrl;
        paramString.bVF = paramWXMediaMessage.bVF;
        paramString.desc = paramWXMediaMessage.desc;
        paramString.ufC = paramWXMediaMessage.ufC;
        paramString.jumpUrl = paramWXMediaMessage.jumpUrl;
        paramb.a(paramString);
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.hFc = paramWXMediaMessage.userName;
      paramb.hFb = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.beV() != null) {
          paramb.hFs = paramWXMediaMessage.beV().aDD;
        }
        paramb.hFt = paramWXMediaMessage.field_brandIconURL;
        ae.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.hFs), paramb.hFt });
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(31038);
        return null;
        if (paramb.type == 1)
        {
          paramb.title = ((WXTextObject)paramWXMediaMessage).text;
          AppMethodBeat.o(31038);
          return null;
        }
        if (paramb.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!bu.cF(paramWXMediaMessage.emojiData))
        {
          ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.hCC = paramWXMediaMessage.emojiData.length;
          paramb = cl(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(31038);
          return paramb;
        }
        if (!bu.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.hCC = ((int)com.tencent.mm.vfs.o.aZR(paramWXMediaMessage.emojiPath));
          ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.hCC);
          if (paramb.hCC > 0)
          {
            paramb.hCD = com.tencent.mm.vfs.o.aaw(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(31038);
            return paramb;
          }
          AppMethodBeat.o(31038);
          return null;
        }
        paramb.hCE = paramString;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hDk = paramWXMediaMessage.packageflag;
        paramb.hDj = paramWXMediaMessage.packageid;
        paramb.dmr = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hDk = paramWXMediaMessage.packageflag;
        paramb.hDj = paramWXMediaMessage.packageid;
        paramb.dmr = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 68)
      {
        paramWXMediaMessage = (WXLiteAppObject)paramWXMediaMessage;
        paramb.url = paramWXMediaMessage.webpageUrl;
        paramb.hFm = paramWXMediaMessage.userName;
        paramb.hFn = paramWXMediaMessage.path;
        paramb.hFo = paramWXMediaMessage.query;
        paramb.dmr = 0;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.hEP = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.dmr = 18;
        AppMethodBeat.o(31038);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.hEQ = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.dmr = 20;
    AppMethodBeat.o(31038);
    return null;
  }
  
  public static c c(bv parambv, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = aNj(paramString);
    if (localc == null)
    {
      z(parambv.field_msgId, parambv.field_content);
      parambv = aNj(paramString);
      AppMethodBeat.o(31039);
      return parambv;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static String cl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (bu.cF(paramArrayOfByte))
    {
      ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = com.tencent.mm.model.c.azY() + "ua_" + bu.fpO();
    ae.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " buildUploadAttachInfo file:" + (String)localObject);
    if (com.tencent.mm.vfs.o.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      ae.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abr() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static boolean e(String paramString, bv parambv)
  {
    AppMethodBeat.i(31023);
    if (parambv == null)
    {
      AppMethodBeat.o(31023);
      return false;
    }
    boolean bool2 = true;
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str5 = null;
    String str1 = null;
    Object localObject1 = r(paramString, parambv.field_msgId);
    Object localObject2 = k.b.zb(parambv.field_content);
    if (localObject2 != null)
    {
      str3 = af.nullAsNil(((k.b)localObject2).title);
      str4 = af.nullAsNil(((k.b)localObject2).hCD).toLowerCase();
      str2 = af.nullAsNil(((k.b)localObject2).filemd5);
      str5 = af.nullAsNil(((k.b)localObject2).dzZ);
      str1 = af.nullAsNil(((k.b)localObject2).gmb);
    }
    if (localObject1 == null)
    {
      z(parambv.field_msgId, parambv.field_content);
      parambv = r(paramString, parambv.field_msgId);
      paramString = parambv;
      bool1 = bool2;
      if (parambv != null)
      {
        l1 = parambv.systemRowid;
        l2 = parambv.field_totalLen;
        paramString = parambv.field_fileFullPath;
        l3 = parambv.field_type;
        localObject1 = parambv.field_mediaId;
        l4 = parambv.field_msgInfoId;
        bool1 = parambv.field_isUpload;
        if (parambv.field_signature != null) {
          break label343;
        }
      }
      label343:
      for (i = -1;; i = parambv.field_signature.length())
      {
        ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambv;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).hCG == 0)
          {
            paramString = parambv;
            bool1 = bool2;
            if (((k.b)localObject2).hCC <= 26214400) {}
          }
          else
          {
            bool1 = false;
            paramString = parambv;
          }
        }
        if (!bool1) {
          bc.ajj().a(new com.tencent.mm.plugin.record.b.d(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
      }
    }
    paramString = new com.tencent.mm.vfs.k(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      z(parambv.field_msgId, parambv.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    parambv = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambv, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
      paramString = (String)localObject1;
      bool1 = bool2;
      break;
    }
  }
  
  public static int g(k.b paramb)
  {
    AppMethodBeat.i(31042);
    if (paramb == null)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    int i = paramb.type;
    int j = paramb.dmr;
    int k = paramb.hBV;
    int m = paramb.hDa;
    int n = paramb.hEu;
    ae.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
    if ((k == 4) || (m != 0))
    {
      AppMethodBeat.o(31042);
      return 318767153;
    }
    if (i == 2001)
    {
      if (j == 1)
      {
        AppMethodBeat.o(31042);
        return 469762097;
      }
      if (n == 4)
      {
        AppMethodBeat.o(31042);
        return 503316529;
      }
      AppMethodBeat.o(31042);
      return 436207665;
    }
    if (i == 2002)
    {
      AppMethodBeat.o(31042);
      return 536870961;
    }
    if (i == 66)
    {
      AppMethodBeat.o(31042);
      return 905969713;
    }
    switch (j)
    {
    default: 
      switch (i)
      {
      default: 
        AppMethodBeat.o(31042);
        return 49;
      }
    case 1: 
      if (i == 21)
      {
        AppMethodBeat.o(31042);
        return -1879048185;
      }
      AppMethodBeat.o(31042);
      return 285212721;
    case 2: 
      if (i == 21)
      {
        AppMethodBeat.o(31042);
        return -1879048183;
      }
      AppMethodBeat.o(31042);
      return 301989937;
    case 3: 
      if (i == 21)
      {
        AppMethodBeat.o(31042);
        return -1879048176;
      }
      AppMethodBeat.o(31042);
      return -1879048189;
    case 4: 
      if (i == 21)
      {
        AppMethodBeat.o(31042);
        return -1879048183;
      }
      AppMethodBeat.o(31042);
      return -1879048190;
    case 5: 
      AppMethodBeat.o(31042);
      return -1879048191;
    }
    AppMethodBeat.o(31042);
    return -1879048186;
    AppMethodBeat.o(31042);
    return 268435505;
    AppMethodBeat.o(31042);
    return 16777265;
    AppMethodBeat.o(31042);
    return 1048625;
    AppMethodBeat.o(31042);
    return 335544369;
    AppMethodBeat.o(31042);
    return 402653233;
    AppMethodBeat.o(31042);
    return 369098801;
    AppMethodBeat.o(31042);
    return 452984881;
    AppMethodBeat.o(31042);
    return -1879048186;
    AppMethodBeat.o(31042);
    return 419430449;
    AppMethodBeat.o(31042);
    return 520093745;
    com.tencent.mm.ah.a locala = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
    if ((locala != null) && (locala.hAJ) && ((paramb.hFe == 2) || (paramb.hFe == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.hAM) && (paramb.hFe == 3))
    {
      AppMethodBeat.o(31042);
      return 587202609;
    }
    AppMethodBeat.o(31042);
    return 49;
    AppMethodBeat.o(31042);
    return 687865905;
    AppMethodBeat.o(31042);
    return 738197553;
    AppMethodBeat.o(31042);
    return 671088689;
    AppMethodBeat.o(31042);
    return 704643121;
    paramb = (e)paramb.ao(e.class);
    if ((paramb != null) && (paramb.hCc != null))
    {
      AppMethodBeat.o(31042);
      return 486539313;
    }
    AppMethodBeat.o(31042);
    return 49;
    AppMethodBeat.o(31042);
    return 805306417;
    AppMethodBeat.o(31042);
    return 822083633;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 771751985;
    AppMethodBeat.o(31042);
    return 855638065;
    AppMethodBeat.o(31042);
    return 939524145;
    AppMethodBeat.o(31042);
    return 922746929;
  }
  
  public static c r(String paramString, long paramLong)
  {
    AppMethodBeat.i(31024);
    c localc = aNj(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ao.bJV().CZ(paramLong);
    }
    if (paramString != null) {
      ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bu.fpN() });
    }
    for (;;)
    {
      AppMethodBeat.o(31024);
      return paramString;
      ae.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bu.fpN() });
    }
  }
  
  public static String z(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    ae.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.zb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aq(com.tencent.mm.loader.j.b.asm(), paramString.title, paramString.hCD);
    if ((bu.isNullOrNil(paramString.dlu)) && (!bu.isNullOrNil(paramString.hCR))) {
      paramString.dlu = paramString.hCR.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dlu, paramString.hCC, paramString.type, paramString.hCG);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static void zc(long paramLong)
  {
    AppMethodBeat.i(31018);
    ao.bJV().CY(paramLong);
    c localc = new c();
    ao.bJV().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().ys(localc.field_msgInfoId);
    if (localbv.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    localbv.setStatus(5);
    bc.aCg();
    com.tencent.mm.model.c.azI().a(localbv.field_msgId, localbv);
    AppMethodBeat.o(31018);
  }
  
  public static abstract interface a
  {
    public abstract void jo(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */