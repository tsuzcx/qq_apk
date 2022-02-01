package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class m
{
  private static com.tencent.mm.plugin.record.b.e uZW;
  
  public static int Up(int paramInt)
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
    az.arV();
    bl localbl = com.tencent.mm.model.c.apO().rm(paramLong);
    int i;
    if (localbl.field_msgId != paramLong)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.rx(localbl.field_content);
    if (localb == null)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    localb.dbA = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label399;
      }
      str = localb.fMw;
      localb.fMw = str;
      if (!paramd.field_fileId.equals("")) {
        break label408;
      }
      str = localb.gHt;
      label198:
      localb.gHt = str;
      if (!paramd.field_filemd5.equals("")) {
        break label417;
      }
      str = localb.filemd5;
      label224:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label426;
      }
      i = localb.gHe;
      label247:
      localb.gHe = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label436;
      }
    }
    label399:
    label408:
    label417:
    label426:
    label436:
    for (String str = localb.gHu;; str = paramd.field_thumbUrl)
    {
      localb.gHu = str;
      localbl.setContent(k.b.a(localb, localb.dbA, paramd));
      az.arV();
      com.tencent.mm.model.c.apO().a(localbl.field_msgId, localbl);
      paramd = ap.evR().vk(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbl.field_content;
        ap.evR().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ap.bxS().vj(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ap.bxS().a(paramd, new String[0]);
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
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).dvY = 1;
      paramb.a((com.tencent.mm.ai.f)localObject1);
    }
    Object localObject2 = b(paramb, paramWXMediaMessage, paramString2);
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.gHd + " attachlen:" + paramb.gHe + " attachid:" + paramb.dbA + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    if (!bt.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(31036);
        return 0 - paramInt;
      }
      localObject2 = com.tencent.mm.sdk.platformtools.f.aFf((String)localObject2);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bl localbl = new bl();
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
        localObject2 = o.ayF().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label288:
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bt.isNullOrNil((String)localObject2)) {
          localbl.nZ((String)localObject2);
        }
      }
      if (localObject1 != null) {
        paramb.dbA = ((c)localObject1).systemRowid;
      }
      paramString1 = bt.S(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label870;
        }
        localObject2 = (String)paramString1.next();
        paramb.gHg = paramString2;
        localbl.setContent(k.b.a(paramb, null, null));
        localbl.setStatus(1);
        localbl.nY((String)localObject2);
        localbl.kY(bi.uj((String)localObject2));
        localbl.jV(1);
        localbl.setType(f(paramb));
        localObject2 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbl);
        if (!bt.isNullOrNil((String)localObject2)) {
          localbl.mZ((String)localObject2);
        }
        az.arV();
        long l = com.tencent.mm.model.c.apO().an(localbl);
        if (l < 0L)
        {
          ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " summerbig insert msg failed :" + l);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(31036);
          return 0 - paramInt;
          label556:
          bool = false;
          break;
          label562:
          localObject2 = o.ayF().ab(paramWXMediaMessage.thumbData);
          break label288;
        }
        ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbl.setMsgId(l);
        localObject2 = new k();
        ((k)localObject2).field_xml = localbl.field_content;
        ((k)localObject2).field_title = paramWXMediaMessage.title;
        ((k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((k)localObject2).field_description = paramWXMediaMessage.description;
        ((k)localObject2).field_msgId = l;
        ((k)localObject2).field_source = paramb.appName;
        ap.evR().insert((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = l;
          ((c)localObject1).field_status = 101L;
          ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((k)localObject2).field_type) });
          ap.bxS().a((c)localObject1, new String[0]);
          if (!bt.isNullOrNil(paramString3)) {
            ap.evT().G(((c)localObject1).field_msgInfoId, paramString3);
          }
          ap.evT().run();
        }
        else
        {
          ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((k)localObject2).field_type) });
          ap.evT();
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
    localb.gHh = paramInt1;
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
    ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    if (!bt.isNullOrNil(paramString4))
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
      bl localbl = new bl();
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
        com.tencent.mm.ai.a locala = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
        if (locala == null) {
          break label662;
        }
        paramString4 = locala.gFC;
        label193:
        if (locala == null) {
          break label669;
        }
        bool = locala.gFD;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label675;
        }
        paramString4 = o.ayF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, paramString4, bool);
      }
      long l;
      for (;;)
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " thumbData MsgInfo path:" + paramString4);
        if (!bt.isNullOrNil(paramString4))
        {
          localbl.nZ(paramString4);
          ad.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramString4)));
        }
        if (localObject != null) {
          paramb.dbA = ((c)localObject).systemRowid;
        }
        localbl.setContent(k.b.a(paramb, null, null));
        localbl.setStatus(1);
        localbl.nY(paramString3);
        localbl.kY(bi.uj(paramString3));
        localbl.jV(1);
        localbl.setType(f(paramb));
        paramString3 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbl);
        if (!bt.isNullOrNil(paramString3))
        {
          localbl.mZ(paramString3);
          ad.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbl.esh });
        }
        if (paramb.type == 53) {
          localbl.og((String)paramb.gJO.first);
        }
        az.arV();
        l = com.tencent.mm.model.c.apO().an(localbl);
        if (paramb.type == 53)
        {
          paramString3 = new mj();
          paramString3.drx.type = 0;
          paramString3.drx.key = localbl.ePf;
          paramString3.drx.username = localbl.field_talker;
          paramString3.dry.msgId = l;
          com.tencent.mm.sdk.b.a.ESL.l(paramString3);
        }
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label759;
        }
        ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label633:
        i = (int)(com.tencent.mm.sdk.platformtools.f.aGH().density * 240.0F);
        j = (int)(com.tencent.mm.sdk.platformtools.f.aGH().density * 240.0F);
        break;
        label662:
        paramString4 = "";
        break label193;
        label669:
        bool = false;
        break label205;
        label675:
        paramString4 = o.ayF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, paramString4, bool);
        continue;
        label699:
        if (paramb.type != 46) {
          break label724;
        }
        paramString4 = o.ayF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label724:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString4 = o.ayF().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label759:
      ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbl.setMsgId(l);
      paramString3 = new k();
      paramString3.field_xml = localbl.field_content;
      paramString3.field_appId = paramString1;
      paramString3.field_title = paramb.title;
      paramString3.field_type = paramb.type;
      paramString3.field_description = paramb.description;
      paramString3.field_msgId = l;
      paramString3.field_source = paramString2;
      ap.evR().insert(paramString3);
      if (localObject == null)
      {
        bool = true;
        ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label987;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ap.bxS().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!bt.isNullOrNil(paramString5))) {
          ap.evT().G(l, paramString5);
        }
        ap.evT().run();
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label987:
        ap.evT();
        ao.a.e(l, paramString5, paramString6);
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
    localc.field_createTime = bt.eGO();
    localc.field_lastModifyTime = bt.aGK();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.ahY()))
    {
      ad.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.gHe;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = bt.eGO();
    ((c)localObject).field_lastModifyTime = bt.aGK();
    ((c)localObject).field_mediaSvrId = bt.eGO();
    ((c)localObject).field_isUseCdn = 0;
    ap.bxS().insert((com.tencent.mm.sdk.e.c)localObject);
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
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
    localc.field_createTime = bt.eGO();
    localc.field_lastModifyTime = bt.aGK();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ap.bxS().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bt.eGN() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  public static void a(bl parambl, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.rx(parambl.field_content);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambl.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((bt.isNullOrNil(((k.b)localObject).dbA)) && (!bt.isNullOrNil(((k.b)localObject).gHt)))
    {
      ad.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambl.field_content });
      ((k.b)localObject).dbA = ((k.b)localObject).gHt.hashCode();
    }
    localObject = ((k.b)localObject).dbA;
    if ((!a(parambl, q((String)localObject, parambl.field_msgId))) && (e((String)localObject, parambl)))
    {
      uZW = new com.tencent.mm.plugin.record.b.e(parambl.field_msgId, (String)localObject, new com.tencent.mm.al.h()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
        {
          AppMethodBeat.i(31016);
          if (this.BPY != null) {
            this.BPY.iL(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(31016);
        }
      });
      az.aeS().a(uZW, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static boolean a(bl parambl, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!i.eK(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.cAX()) || ((parambl.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static boolean aAT(String paramString)
  {
    AppMethodBeat.i(31017);
    if (bt.isNullOrNil(paramString))
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
  
  public static int aAU(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.rx(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!aAT(localb.dbA))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = bt.getLong(localb.dbA, -1L);
    if (l != -1L)
    {
      ap.bxS().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ap.bxS().aAL(localb.dbA);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.dbA)) {}
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
      localc = ap.bxS().aAL(localb.dbA);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.dbA)) {}
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
  
  public static c aAV(String paramString)
  {
    AppMethodBeat.i(31040);
    c localc2 = new c();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31040);
      return null;
    }
    ad.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bt.getLong(paramString, -1L);
    c localc1;
    if (l != -1L)
    {
      ap.bxS().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ap.bxS().aAL(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localc1 = null;
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      AppMethodBeat.o(31040);
      return localc1;
      localc2 = ap.bxS().aAL(paramString);
      if (localc2 != null)
      {
        localc1 = localc2;
        if (localc2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localc1 = null;
      }
    }
  }
  
  public static Pair<Integer, Long> aB(bl parambl)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.rx(parambl.field_content);
    if (localObject5 == null)
    {
      ad.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = aAV(((k.b)localObject5).dbA);
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
          az.arV();
          localObject1 = ai(com.tencent.mm.model.c.aqe(), ((k.b)localObject5).title, ((k.b)localObject5).gHf);
          i.lC(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambl.field_imgPath != null) && (!parambl.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = o.ayF().Q(parambl.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = i.aR((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (bt.isNullOrNil((String)localObject1)) {
          break label945;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        parambl = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return parambl;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new bl();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label700;
        }
        localObject3 = o.ayF().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((bl)localObject6).nZ((String)localObject3);
          ad.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((k.b)localObject4).dbA = ((c)localObject1).systemRowid;
      }
      ((bl)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((bl)localObject6).setStatus(1);
      ((bl)localObject6).nY(parambl.field_talker);
      ((bl)localObject6).kY(bi.uj(parambl.field_talker));
      ((bl)localObject6).jV(1);
      ((bl)localObject6).setType(f((k.b)localObject4));
      localObject3 = ((t)com.tencent.mm.kernel.g.ab(t.class)).N((bl)localObject6);
      if (!bt.isNullOrNil((String)localObject3))
      {
        ((bl)localObject6).mZ((String)localObject3);
        ad.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((du)localObject6).esh });
      }
      if (((k.b)localObject4).type == 53) {
        ((bl)localObject6).og(parambl.ePf);
      }
      az.arV();
      long l = com.tencent.mm.model.c.apO().an((bl)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new mj();
        ((mj)localObject3).drx.type = 0;
        ((mj)localObject3).drx.key = ((du)localObject6).ePf;
        ((mj)localObject3).drx.username = ((du)localObject6).field_talker;
        ((mj)localObject3).dry.msgId = l;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
      }
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
        parambl = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambl;
        label700:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = o.ayF().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bl)localObject6).setMsgId(l);
      localObject3 = new wc();
      ((wc)localObject3).dBB.dBC = parambl.field_msgId;
      ((wc)localObject3).dBB.dBD = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
      parambl = new k();
      parambl.field_xml = ((du)localObject6).field_content;
      parambl.field_title = ((k.b)localObject4).title;
      parambl.field_type = ((k.b)localObject4).type;
      parambl.field_description = ((k.b)localObject4).description;
      parambl.field_msgId = l;
      parambl.field_source = ((String)localObject5);
      ap.evR().insert(parambl);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ap.bxS().a((c)localObject1, new String[0]);
        ap.evT().run();
      }
      for (;;)
      {
        parambl = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambl;
        ap.evT();
        ao.a.rN(l);
      }
      label945:
      localObject1 = null;
    }
  }
  
  public static String ai(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new com.tencent.mm.vfs.e(paramString1);
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    if (bt.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + bt.eGO();
      paramString2 = (String)localObject;
      if (!bt.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString2).fhT().fhU()).equalsIgnoreCase(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString1).fhU())))
        {
          localObject = paramString1 + "da_" + bt.eGO();
          ad.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(31031);
        return localObject;
        localObject = paramString2;
        if (!bt.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!i.eK(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!i.eK(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + bt.eGO();
            paramString2 = (String)localObject;
            if (bt.isNullOrNil(paramString3)) {
              break;
            }
            paramString2 = (String)localObject + "." + paramString3;
            break;
          }
          i += 1;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bt.eGO();
          localObject = paramString1;
          if (!bt.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static String b(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(31038);
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
      if (!bt.cw(paramWXMediaMessage.fileData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.gHe = paramWXMediaMessage.fileData.length;
        paramb = cc(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.gHe = ((int)i.aMN(paramWXMediaMessage.filePath));
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.gHe);
      if (paramb.gHe > 0)
      {
        paramb.gHf = i.RK(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(31038);
        return paramb;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.Uo(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bt.cw(paramWXMediaMessage.fileData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.gHe = paramWXMediaMessage.fileData.length;
        paramb = cc(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.gHe = ((int)i.aMN(paramWXMediaMessage.filePath));
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.gHe);
      if (paramb.gHe > 0)
      {
        paramb.gHf = i.RK(paramWXMediaMessage.filePath);
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
      if (!bt.cw(paramWXMediaMessage.imageData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.gHe = paramWXMediaMessage.imageData.length;
        paramb = cc(paramWXMediaMessage.imageData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      if (!bt.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.gHe = ((int)i.aMN(paramWXMediaMessage.imagePath));
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.gHe);
        if (paramb.gHe > 0)
        {
          paramb.gHf = i.RK(paramWXMediaMessage.imagePath);
          az.arV();
          paramb = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(com.tencent.mm.model.c.aqe(), "appmsg_img_" + System.currentTimeMillis()).fhU());
          paramString = com.tencent.mm.sdk.platformtools.f.aFf(paramWXMediaMessage.imagePath);
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
              ad.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
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
            ad.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (i.lC(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              ad.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
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
          while (i.lC(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.f.a(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(31038);
              return paramb;
            }
            catch (IOException paramb)
            {
              ad.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
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
      paramb.gHd = paramWXMediaMessage.musicLowBandUrl;
      paramb.gHA = paramWXMediaMessage.musicDataUrl;
      paramb.gHB = paramWXMediaMessage.musicLowBandDataUrl;
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
      paramb.gHd = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 5) || (paramb.type == 54))
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!bt.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bt.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.gJE = paramWXMediaMessage.userName;
      paramb.gJD = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.aTP() != null) {
          paramb.gJR = paramWXMediaMessage.aTP().aAS;
        }
        paramb.gJS = paramWXMediaMessage.field_brandIconURL;
        ad.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.gJR), paramb.gJS });
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
        if (!bt.cw(paramWXMediaMessage.emojiData))
        {
          ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.gHe = paramWXMediaMessage.emojiData.length;
          paramb = cc(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(31038);
          return paramb;
        }
        if (!bt.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.gHe = ((int)i.aMN(paramWXMediaMessage.emojiPath));
          ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.gHe);
          if (paramb.gHe > 0)
          {
            paramb.gHf = i.RK(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(31038);
            return paramb;
          }
          AppMethodBeat.o(31038);
          return null;
        }
        paramb.gHg = paramString;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.gHM = paramWXMediaMessage.packageflag;
        paramb.gHL = paramWXMediaMessage.packageid;
        paramb.dcz = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.gHM = paramWXMediaMessage.packageflag;
        paramb.gHL = paramWXMediaMessage.packageid;
        paramb.dcz = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.gJs = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.dcz = 18;
        AppMethodBeat.o(31038);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.gJt = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.dcz = 20;
    AppMethodBeat.o(31038);
    return null;
  }
  
  public static c c(bl parambl, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = aAV(paramString);
    if (localc == null)
    {
      x(parambl.field_msgId, parambl.field_content);
      parambl = aAV(paramString);
      AppMethodBeat.o(31039);
      return parambl;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static String cc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (bt.cw(paramArrayOfByte))
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    az.arV();
    localObject = com.tencent.mm.model.c.aqe() + "ua_" + bt.eGO();
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " buildUploadAttachInfo file:" + (String)localObject);
    if (i.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static boolean e(String paramString, bl parambl)
  {
    AppMethodBeat.i(31023);
    if (parambl == null)
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
    Object localObject1 = q(paramString, parambl.field_msgId);
    Object localObject2 = k.b.rx(parambl.field_content);
    if (localObject2 != null)
    {
      str3 = ae.nullAsNil(((k.b)localObject2).title);
      str4 = ae.nullAsNil(((k.b)localObject2).gHf).toLowerCase();
      str2 = ae.nullAsNil(((k.b)localObject2).filemd5);
      str5 = ae.nullAsNil(((k.b)localObject2).dpv);
      str1 = ae.nullAsNil(((k.b)localObject2).fMw);
    }
    if (localObject1 == null)
    {
      x(parambl.field_msgId, parambl.field_content);
      parambl = q(paramString, parambl.field_msgId);
      paramString = parambl;
      bool1 = bool2;
      if (parambl != null)
      {
        l1 = parambl.systemRowid;
        l2 = parambl.field_totalLen;
        paramString = parambl.field_fileFullPath;
        l3 = parambl.field_type;
        localObject1 = parambl.field_mediaId;
        l4 = parambl.field_msgInfoId;
        bool1 = parambl.field_isUpload;
        if (parambl.field_signature != null) {
          break label353;
        }
        i = -1;
        ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambl;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).gHi == 0)
          {
            paramString = parambl;
            bool1 = bool2;
            if (((k.b)localObject2).gHe <= 26214400) {}
          }
          else
          {
            if (ae.isNullOrNil(parambl.field_signature)) {
              break label364;
            }
          }
        }
      }
      label353:
      label364:
      for (bool1 = true;; bool1 = false)
      {
        paramString = parambl;
        if (!bool1) {
          az.aeS().a(new com.tencent.mm.plugin.record.b.c(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
        i = parambl.field_signature.length();
        break;
      }
    }
    paramString = new com.tencent.mm.vfs.e(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      x(parambl.field_msgId, parambl.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    parambl = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambl, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
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
    int j = paramb.dcz;
    int k = paramb.gGx;
    int m = paramb.gHC;
    int n = paramb.gIX;
    ad.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
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
    com.tencent.mm.ai.a locala = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
    if ((locala != null) && (locala.gFm) && ((paramb.gJG == 2) || (paramb.gJG == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.gFp) && (paramb.gJG == 3))
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
    paramb = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
    if ((paramb != null) && (paramb.gGE != null))
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
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prk, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prk, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prk, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prk, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 1)
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
    c localc = aAV(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ap.bxS().vj(paramLong);
    }
    if (paramString != null) {
      ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bt.eGN() });
    }
    for (;;)
    {
      AppMethodBeat.o(31024);
      return paramString;
      ad.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bt.eGN() });
    }
  }
  
  public static void rO(long paramLong)
  {
    AppMethodBeat.i(31018);
    ap.bxS().vi(paramLong);
    c localc = new c();
    ap.bxS().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    az.arV();
    bl localbl = com.tencent.mm.model.c.apO().rm(localc.field_msgInfoId);
    if (localbl.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    localbl.setStatus(5);
    az.arV();
    com.tencent.mm.model.c.apO().a(localbl.field_msgId, localbl);
    AppMethodBeat.o(31018);
  }
  
  public static String x(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.rx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = ai(com.tencent.mm.loader.j.b.aij(), paramString.title, paramString.gHf);
    if ((bt.isNullOrNil(paramString.dbA)) && (!bt.isNullOrNil(paramString.gHt))) {
      paramString.dbA = paramString.gHt.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dbA, paramString.gHe, paramString.type, paramString.gHi);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void iL(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */