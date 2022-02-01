package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class m
{
  private static com.tencent.mm.plugin.record.b.e wiK;
  
  public static int Wz(int paramInt)
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
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().vP(paramLong);
    int i;
    if (localbo.field_msgId != paramLong)
    {
      ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.vA(localbo.field_content);
    if (localb == null)
    {
      ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    localb.cZa = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label399;
      }
      str = localb.fQi;
      localb.fQi = str;
      if (!paramd.field_fileId.equals("")) {
        break label408;
      }
      str = localb.hhU;
      label198:
      localb.hhU = str;
      if (!paramd.field_filemd5.equals("")) {
        break label417;
      }
      str = localb.filemd5;
      label224:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label426;
      }
      i = localb.hhF;
      label247:
      localb.hhF = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label436;
      }
    }
    label399:
    label408:
    label417:
    label426:
    label436:
    for (String str = localb.hhV;; str = paramd.field_thumbUrl)
    {
      localb.hhV = str;
      localbo.setContent(k.b.a(localb, localb.cZa, paramd));
      az.ayM();
      com.tencent.mm.model.c.awD().a(localbo.field_msgId, localbo);
      paramd = ap.eLl().zN(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbo.field_content;
        ap.eLl().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ap.bEO().zM(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ap.bEO().a(paramd, new String[0]);
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
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).dtL = 1;
      paramb.a((com.tencent.mm.ah.f)localObject1);
    }
    Object localObject2 = b(paramb, paramWXMediaMessage, paramString2);
    ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.hhE + " attachlen:" + paramb.hhF + " attachid:" + paramb.cZa + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    if (!bs.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(31036);
        return 0 - paramInt;
      }
      localObject2 = com.tencent.mm.sdk.platformtools.f.aKw((String)localObject2);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bo localbo = new bo();
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
        localObject2 = o.aFx().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label288:
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bs.isNullOrNil((String)localObject2)) {
          localbo.rf((String)localObject2);
        }
      }
      if (localObject1 != null) {
        paramb.cZa = ((c)localObject1).systemRowid;
      }
      paramString1 = bs.S(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label870;
        }
        localObject2 = (String)paramString1.next();
        paramb.hhH = paramString2;
        localbo.setContent(k.b.a(paramb, null, null));
        localbo.setStatus(1);
        localbo.re((String)localObject2);
        localbo.oA(bi.yp((String)localObject2));
        localbo.jT(1);
        localbo.setType(f(paramb));
        localObject2 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbo);
        if (!bs.isNullOrNil((String)localObject2)) {
          localbo.qf((String)localObject2);
        }
        az.ayM();
        long l = com.tencent.mm.model.c.awD().ap(localbo);
        if (l < 0L)
        {
          ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " summerbig insert msg failed :" + l);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(31036);
          return 0 - paramInt;
          label556:
          bool = false;
          break;
          label562:
          localObject2 = o.aFx().aa(paramWXMediaMessage.thumbData);
          break label288;
        }
        ac.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbo.setMsgId(l);
        localObject2 = new k();
        ((k)localObject2).field_xml = localbo.field_content;
        ((k)localObject2).field_title = paramWXMediaMessage.title;
        ((k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((k)localObject2).field_description = paramWXMediaMessage.description;
        ((k)localObject2).field_msgId = l;
        ((k)localObject2).field_source = paramb.appName;
        ap.eLl().insert((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = l;
          ((c)localObject1).field_status = 101L;
          ac.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((k)localObject2).field_type) });
          ap.bEO().a((c)localObject1, new String[0]);
          if (!bs.isNullOrNil(paramString3)) {
            ap.eLn().E(((c)localObject1).field_msgInfoId, paramString3);
          }
          ap.eLn().run();
        }
        else
        {
          ac.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((k)localObject2).field_type) });
          ap.eLn();
          ao.a.a(l, paramString3, paramInt, parama);
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
    localb.hhI = paramInt1;
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
    ac.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    if (!bs.isNullOrNil(paramString4))
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
      bo localbo = new bo();
      int i;
      int j;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 44) && (paramb.type != 48)) {
          break label699;
        }
        if (paramb.type != 48) {
          break label633;
        }
        i = 0;
        j = 0;
        com.tencent.mm.ah.a locala = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
        if (locala == null) {
          break label662;
        }
        paramString4 = locala.hgd;
        label193:
        if (locala == null) {
          break label669;
        }
        bool = locala.hge;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label675;
        }
        paramString4 = o.aFx().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, paramString4, bool);
      }
      long l;
      for (;;)
      {
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " thumbData MsgInfo path:" + paramString4);
        if (!bs.isNullOrNil(paramString4))
        {
          localbo.rf(paramString4);
          ac.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramString4)));
        }
        if (localObject != null) {
          paramb.cZa = ((c)localObject).systemRowid;
        }
        localbo.setContent(k.b.a(paramb, null, null));
        localbo.setStatus(1);
        localbo.re(paramString3);
        localbo.oA(bi.yp(paramString3));
        localbo.jT(1);
        localbo.setType(f(paramb));
        paramString3 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbo);
        if (!bs.isNullOrNil(paramString3))
        {
          localbo.qf(paramString3);
          ac.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbo.eul });
        }
        if (paramb.type == 53) {
          localbo.rm((String)paramb.hko.first);
        }
        az.ayM();
        l = com.tencent.mm.model.c.awD().ap(localbo);
        if (paramb.type == 53)
        {
          paramString3 = new ms();
          paramString3.dpi.type = 0;
          paramString3.dpi.key = localbo.eSn;
          paramString3.dpi.username = localbo.field_talker;
          paramString3.dpj.msgId = l;
          com.tencent.mm.sdk.b.a.GpY.l(paramString3);
        }
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label759;
        }
        ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label633:
        i = (int)(com.tencent.mm.sdk.platformtools.f.aNu().density * 240.0F);
        j = (int)(com.tencent.mm.sdk.platformtools.f.aNu().density * 240.0F);
        break;
        label662:
        paramString4 = "";
        break label193;
        label669:
        bool = false;
        break label205;
        label675:
        paramString4 = o.aFx().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, paramString4, bool);
        continue;
        label699:
        if (paramb.type != 46) {
          break label724;
        }
        paramString4 = o.aFx().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label724:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString4 = o.aFx().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label759:
      ac.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbo.setMsgId(l);
      paramString3 = new k();
      paramString3.field_xml = localbo.field_content;
      paramString3.field_appId = paramString1;
      paramString3.field_title = paramb.title;
      paramString3.field_type = paramb.type;
      paramString3.field_description = paramb.description;
      paramString3.field_msgId = l;
      paramString3.field_source = paramString2;
      ap.eLl().insert(paramString3);
      if (localObject == null)
      {
        bool = true;
        ac.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label987;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ap.bEO().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!bs.isNullOrNil(paramString5))) {
          ap.eLn().E(l, paramString5);
        }
        ap.eLn().run();
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label987:
        ap.eLn();
        ao.a.f(l, paramString5, paramString6);
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
    localc.field_createTime = bs.eWj();
    localc.field_lastModifyTime = bs.aNx();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    ac.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.aoY()))
    {
      ac.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.hhF;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = bs.eWj();
    ((c)localObject).field_lastModifyTime = bs.aNx();
    ((c)localObject).field_mediaSvrId = bs.eWj();
    ((c)localObject).field_isUseCdn = 0;
    ap.bEO().insert((com.tencent.mm.sdk.e.c)localObject);
    ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
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
    localc.field_createTime = bs.eWj();
    localc.field_lastModifyTime = bs.aNx();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ac.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ap.bEO().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bs.eWi() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  public static void a(bo parambo, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.vA(parambo.field_content);
    if (localObject == null)
    {
      ac.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambo.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((bs.isNullOrNil(((k.b)localObject).cZa)) && (!bs.isNullOrNil(((k.b)localObject).hhU)))
    {
      ac.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambo.field_content });
      ((k.b)localObject).cZa = ((k.b)localObject).hhU.hashCode();
    }
    localObject = ((k.b)localObject).cZa;
    if ((!a(parambo, q((String)localObject, parambo.field_msgId))) && (e((String)localObject, parambo)))
    {
      wiK = new com.tencent.mm.plugin.record.b.e(parambo.field_msgId, (String)localObject, new com.tencent.mm.ak.h()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
        {
          AppMethodBeat.i(31016);
          if (this.Dim != null) {
            this.Dim.iY(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(31016);
        }
      });
      az.agi().a(wiK, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static boolean a(bo parambo, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!i.eA(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.cOg()) || ((parambo.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static Pair<Integer, Long> aD(bo parambo)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.vA(parambo.field_content);
    if (localObject5 == null)
    {
      ac.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = aGn(((k.b)localObject5).cZa);
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
          az.ayM();
          localObject1 = aj(com.tencent.mm.model.c.awT(), ((k.b)localObject5).title, ((k.b)localObject5).hhG);
          i.lZ(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambo.field_imgPath != null) && (!parambo.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = o.aFx().R(parambo.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = i.aU((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (bs.isNullOrNil((String)localObject1)) {
          break label945;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        parambo = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return parambo;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new bo();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label700;
        }
        localObject3 = o.aFx().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!bs.isNullOrNil((String)localObject3))
        {
          ((bo)localObject6).rf((String)localObject3);
          ac.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((k.b)localObject4).cZa = ((c)localObject1).systemRowid;
      }
      ((bo)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((bo)localObject6).setStatus(1);
      ((bo)localObject6).re(parambo.field_talker);
      ((bo)localObject6).oA(bi.yp(parambo.field_talker));
      ((bo)localObject6).jT(1);
      ((bo)localObject6).setType(f((k.b)localObject4));
      localObject3 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N((bo)localObject6);
      if (!bs.isNullOrNil((String)localObject3))
      {
        ((bo)localObject6).qf((String)localObject3);
        ac.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((dy)localObject6).eul });
      }
      if (((k.b)localObject4).type == 53) {
        ((bo)localObject6).rm(parambo.eSn);
      }
      az.ayM();
      long l = com.tencent.mm.model.c.awD().ap((bo)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new ms();
        ((ms)localObject3).dpi.type = 0;
        ((ms)localObject3).dpi.key = ((dy)localObject6).eSn;
        ((ms)localObject3).dpi.username = ((dy)localObject6).field_talker;
        ((ms)localObject3).dpj.msgId = l;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
      }
      ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
        parambo = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambo;
        label700:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = o.aFx().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      ac.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bo)localObject6).setMsgId(l);
      localObject3 = new wn();
      ((wn)localObject3).dzp.dzq = parambo.field_msgId;
      ((wn)localObject3).dzp.dzr = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
      parambo = new k();
      parambo.field_xml = ((dy)localObject6).field_content;
      parambo.field_title = ((k.b)localObject4).title;
      parambo.field_type = ((k.b)localObject4).type;
      parambo.field_description = ((k.b)localObject4).description;
      parambo.field_msgId = l;
      parambo.field_source = ((String)localObject5);
      ap.eLl().insert(parambo);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ap.bEO().a((c)localObject1, new String[0]);
        ap.eLn().run();
      }
      for (;;)
      {
        parambo = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambo;
        ap.eLn();
        ao.a.wq(l);
      }
      label945:
      localObject1 = null;
    }
  }
  
  public static boolean aGl(String paramString)
  {
    AppMethodBeat.i(31017);
    if (bs.isNullOrNil(paramString))
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
  
  public static int aGm(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.vA(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!aGl(localb.cZa))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = bs.getLong(localb.cZa, -1L);
    if (l != -1L)
    {
      ap.bEO().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ap.bEO().aGd(localb.cZa);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.cZa)) {}
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
      localc = ap.bEO().aGd(localb.cZa);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.cZa)) {}
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
  
  public static c aGn(String paramString)
  {
    AppMethodBeat.i(31040);
    c localc2 = new c();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31040);
      return null;
    }
    ac.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bs.getLong(paramString, -1L);
    c localc1;
    if (l != -1L)
    {
      ap.bEO().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ap.bEO().aGd(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ac.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localc1 = null;
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      AppMethodBeat.o(31040);
      return localc1;
      localc2 = ap.bEO().aGd(paramString);
      if (localc2 != null)
      {
        localc1 = localc2;
        if (localc2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        ac.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localc1 = null;
      }
    }
  }
  
  public static String aj(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new com.tencent.mm.vfs.e(paramString1);
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    String str1;
    String str2;
    if (bs.isNullOrNil(paramString2))
    {
      str1 = paramString1 + "da_" + bs.eWj();
      localObject = str1;
      str2 = paramString2;
      if (!bs.isNullOrNil(paramString3))
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
        if (!com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((String)localObject).fxU().fxV()).equalsIgnoreCase(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString1).fxV())))
        {
          localObject = paramString1 + "da_" + bs.eWj();
          paramString2 = (String)localObject;
          if (!bs.isNullOrNil(str2)) {
            paramString2 = (String)localObject + str2;
          }
          localObject = paramString2;
          if (!bs.isNullOrNil(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
          ac.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
          paramString2 = (String)localObject;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bs.eWj();
          paramString2 = paramString1;
          if (!bs.isNullOrNil(paramString3)) {
            paramString2 = paramString1 + "." + paramString3;
          }
        }
      }
      AppMethodBeat.o(31031);
      return paramString2;
      str1 = paramString2;
      if (!bs.isNullOrNil(paramString3))
      {
        str1 = paramString2;
        if (!paramString2.endsWith(paramString3)) {
          str1 = paramString2 + "." + paramString3;
        }
      }
      paramString2 = paramString1 + str1;
      localObject = paramString2;
      str2 = str1;
    } while (!i.eA(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!i.eA(paramString1 + i + "_" + str1)) {
          localObject = paramString1 + i + "_" + str1;
        }
      }
      else
      {
        str2 = str1;
        if (i != 20) {
          break;
        }
        paramString2 = paramString1 + "da_" + bs.eWj();
        localObject = paramString2;
        str2 = str1;
        if (bs.isNullOrNil(paramString3)) {
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
    ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
      if (!bs.cv(paramWXMediaMessage.fileData))
      {
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hhF = paramWXMediaMessage.fileData.length;
        paramb = cb(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hhF = ((int)i.aSp(paramWXMediaMessage.filePath));
      ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hhF);
      if (paramb.hhF > 0)
      {
        paramb.hhG = i.VW(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(31038);
        return paramb;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.Wy(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bs.cv(paramWXMediaMessage.fileData))
      {
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hhF = paramWXMediaMessage.fileData.length;
        paramb = cb(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hhF = ((int)i.aSp(paramWXMediaMessage.filePath));
      ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hhF);
      if (paramb.hhF > 0)
      {
        paramb.hhG = i.VW(paramWXMediaMessage.filePath);
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
      if (!bs.cv(paramWXMediaMessage.imageData))
      {
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.hhF = paramWXMediaMessage.imageData.length;
        paramb = cb(paramWXMediaMessage.imageData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      if (!bs.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.hhF = ((int)i.aSp(paramWXMediaMessage.imagePath));
        ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.hhF);
        if (paramb.hhF > 0)
        {
          paramb.hhG = i.VW(paramWXMediaMessage.imagePath);
          az.ayM();
          paramb = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(com.tencent.mm.model.c.awT(), "appmsg_img_" + System.currentTimeMillis()).fxV());
          paramString = com.tencent.mm.sdk.platformtools.f.aKw(paramWXMediaMessage.imagePath);
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
              ac.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(31038);
              return null;
              bool = false;
              break;
              i = paramString.outWidth;
              break label799;
            }
          }
          if (u.f(paramWXMediaMessage.imagePath, "", true))
          {
            ac.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (i.lZ(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              ac.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(31038);
              return null;
            }
            AppMethodBeat.o(31038);
            return paramb;
          }
          if ((paramString.outWidth > 960) || (paramString.outHeight > 960))
          {
            paramWXMediaMessage = com.tencent.mm.sdk.platformtools.f.e(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (i.lZ(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.f.a(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(31038);
              return paramb;
            }
            catch (IOException paramb)
            {
              ac.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
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
      paramb.hhE = paramWXMediaMessage.musicLowBandUrl;
      paramb.hib = paramWXMediaMessage.musicDataUrl;
      paramb.hic = paramWXMediaMessage.musicLowBandDataUrl;
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
      paramb.hhE = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 5) || (paramb.type == 54))
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!bs.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bs.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.hke = paramWXMediaMessage.userName;
      paramb.hkd = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.baN() != null) {
          paramb.hkr = paramWXMediaMessage.baN().aBM;
        }
        paramb.hks = paramWXMediaMessage.field_brandIconURL;
        ac.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.hkr), paramb.hks });
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
        if (!bs.cv(paramWXMediaMessage.emojiData))
        {
          ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.hhF = paramWXMediaMessage.emojiData.length;
          paramb = cb(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(31038);
          return paramb;
        }
        if (!bs.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.hhF = ((int)i.aSp(paramWXMediaMessage.emojiPath));
          ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.hhF);
          if (paramb.hhF > 0)
          {
            paramb.hhG = i.VW(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(31038);
            return paramb;
          }
          AppMethodBeat.o(31038);
          return null;
        }
        paramb.hhH = paramString;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hin = paramWXMediaMessage.packageflag;
        paramb.him = paramWXMediaMessage.packageid;
        paramb.cZX = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hin = paramWXMediaMessage.packageflag;
        paramb.him = paramWXMediaMessage.packageid;
        paramb.cZX = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.hjS = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.cZX = 18;
        AppMethodBeat.o(31038);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.hjT = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.cZX = 20;
    AppMethodBeat.o(31038);
    return null;
  }
  
  public static c c(bo parambo, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = aGn(paramString);
    if (localc == null)
    {
      v(parambo.field_msgId, parambo.field_content);
      parambo = aGn(paramString);
      AppMethodBeat.o(31039);
      return parambo;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static String cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = com.tencent.mm.model.c.awT() + "ua_" + bs.eWj();
    ac.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " buildUploadAttachInfo file:" + (String)localObject);
    if (i.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      ac.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.YG() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static boolean e(String paramString, bo parambo)
  {
    AppMethodBeat.i(31023);
    if (parambo == null)
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
    Object localObject1 = q(paramString, parambo.field_msgId);
    Object localObject2 = k.b.vA(parambo.field_content);
    if (localObject2 != null)
    {
      str3 = ae.nullAsNil(((k.b)localObject2).title);
      str4 = ae.nullAsNil(((k.b)localObject2).hhG).toLowerCase();
      str2 = ae.nullAsNil(((k.b)localObject2).filemd5);
      str5 = ae.nullAsNil(((k.b)localObject2).dng);
      str1 = ae.nullAsNil(((k.b)localObject2).fQi);
    }
    if (localObject1 == null)
    {
      v(parambo.field_msgId, parambo.field_content);
      parambo = q(paramString, parambo.field_msgId);
      paramString = parambo;
      bool1 = bool2;
      if (parambo != null)
      {
        l1 = parambo.systemRowid;
        l2 = parambo.field_totalLen;
        paramString = parambo.field_fileFullPath;
        l3 = parambo.field_type;
        localObject1 = parambo.field_mediaId;
        l4 = parambo.field_msgInfoId;
        bool1 = parambo.field_isUpload;
        if (parambo.field_signature != null) {
          break label353;
        }
        i = -1;
        ac.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambo;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).hhJ == 0)
          {
            paramString = parambo;
            bool1 = bool2;
            if (((k.b)localObject2).hhF <= 26214400) {}
          }
          else
          {
            if (ae.isNullOrNil(parambo.field_signature)) {
              break label364;
            }
          }
        }
      }
      label353:
      label364:
      for (bool1 = true;; bool1 = false)
      {
        paramString = parambo;
        if (!bool1) {
          az.agi().a(new com.tencent.mm.plugin.record.b.c(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
        i = parambo.field_signature.length();
        break;
      }
    }
    paramString = new com.tencent.mm.vfs.e(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      ac.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      v(parambo.field_msgId, parambo.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    parambo = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      ac.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambo, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
      paramString = (String)localObject1;
      bool1 = bool2;
      break;
    }
  }
  
  public static int f(k.b paramb)
  {
    AppMethodBeat.i(31042);
    if (paramb == null)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    int i = paramb.type;
    int j = paramb.cZX;
    int k = paramb.hgY;
    int m = paramb.hid;
    int n = paramb.hjx;
    ac.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
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
    if ((locala != null) && (locala.hfN) && ((paramb.hkg == 2) || (paramb.hkg == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.hfQ) && (paramb.hkg == 3))
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
    paramb = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
    if ((paramb != null) && (paramb.hhf != null))
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
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUX, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUX, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUX, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUX, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 771751985;
    AppMethodBeat.o(31042);
    return 855638065;
  }
  
  public static c q(String paramString, long paramLong)
  {
    AppMethodBeat.i(31024);
    c localc = aGn(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ap.bEO().zM(paramLong);
    }
    if (paramString != null) {
      ac.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bs.eWi() });
    }
    for (;;)
    {
      AppMethodBeat.o(31024);
      return paramString;
      ac.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bs.eWi() });
    }
  }
  
  public static String v(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    ac.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.vA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aj(com.tencent.mm.loader.j.b.apj(), paramString.title, paramString.hhG);
    if ((bs.isNullOrNil(paramString.cZa)) && (!bs.isNullOrNil(paramString.hhU))) {
      paramString.cZa = paramString.hhU.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.cZa, paramString.hhF, paramString.type, paramString.hhJ);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static void wr(long paramLong)
  {
    AppMethodBeat.i(31018);
    ap.bEO().zL(paramLong);
    c localc = new c();
    ap.bEO().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().vP(localc.field_msgInfoId);
    if (localbo.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    localbo.setStatus(5);
    az.ayM();
    com.tencent.mm.model.c.awD().a(localbo.field_msgId, localbo);
    AppMethodBeat.o(31018);
  }
  
  public static abstract interface a
  {
    public abstract void iY(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */