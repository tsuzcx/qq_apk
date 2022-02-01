package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.y;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.op;
import com.tencent.mm.f.a.zs;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
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
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.pluginsdk.h.a.b;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class m
{
  private static com.tencent.mm.plugin.record.b.f HCv;
  static int QWC = -1;
  
  public static String M(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.OQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aw(com.tencent.mm.loader.j.b.aSO(), paramString.title, paramString.llY);
    if ((Util.isNullOrNil(paramString.fvr)) && (!Util.isNullOrNil(paramString.lml))) {
      paramString.fvr = paramString.lml.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.fvr, paramString.llX, paramString.type, paramString.lmb);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static void Pn(long paramLong)
  {
    AppMethodBeat.i(31018);
    ao.ctZ().TQ(paramLong);
    Log.d("MicroMsg.AppMsgLogic", "setError rowid:%s, stack:%s", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    Object localObject = new c();
    ao.ctZ().get(paramLong, (IAutoDBItem)localObject);
    if (((c)localObject).field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    bh.beI();
    ca localca = com.tencent.mm.model.c.bbO().Oq(((c)localObject).field_msgInfoId);
    if (localca.field_msgId != ((c)localObject).field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    if ((localca.field_status == 2) && (localca.getType() == 1090519089) && (localca.ilx == 0))
    {
      localca.setFileStatus(100);
      localObject = o.XfQ;
      o.d.a(3, null, localca);
    }
    for (;;)
    {
      bh.beI();
      com.tencent.mm.model.c.bbO().a(localca.field_msgId, localca);
      AppMethodBeat.o(31018);
      return;
      localca.setStatus(5);
    }
  }
  
  public static void TS(long paramLong)
  {
    AppMethodBeat.i(287101);
    c localc = ao.ctZ().TR(paramLong);
    if (localc != null) {
      Log.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(u.deleteFile(localc.field_fileFullPath)), Boolean.valueOf(ao.ctZ().delete(localc, new String[] { "msgInfoId" })), Long.valueOf(localc.field_msgInfoId), localc.field_mediaSvrId, localc.field_fileFullPath, Util.getStack() });
    }
    AppMethodBeat.o(287101);
  }
  
  public static int X(long paramLong, String paramString)
  {
    AppMethodBeat.i(287103);
    c localc = ao.ctZ().TR(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      AppMethodBeat.o(287103);
      return -1;
    }
    if (localc.field_status != 101L)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(287103);
      return -1;
    }
    if ((Util.isNullOrNil(localc.field_clientAppDataId)) && (!Util.isNullOrNil(localc.field_mediaSvrId))) {}
    for (localc.field_status = 102L;; localc.field_status = 105L)
    {
      localc.field_lastModifyTime = Util.nowSecond();
      ao.ctZ().a(localc, new String[0]);
      AppMethodBeat.o(287103);
      return 0;
    }
  }
  
  public static int Y(long paramLong, String paramString)
  {
    AppMethodBeat.i(287104);
    c localc = ao.ctZ().TR(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      AppMethodBeat.o(287104);
      return -1;
    }
    if ((localc.field_status != 105L) && (localc.field_status != 101L))
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(287104);
      return -1;
    }
    localc.field_status = 101L;
    localc.field_lastModifyTime = Util.nowSecond();
    ao.ctZ().a(localc, new String[0]);
    ao.hhJ().run();
    AppMethodBeat.o(287104);
    return 0;
  }
  
  public static int Z(long paramLong, String paramString)
  {
    AppMethodBeat.i(287105);
    c localc = ao.ctZ().TR(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      AppMethodBeat.o(287105);
      return -1;
    }
    if (localc.field_status != 198L)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(287105);
      return -1;
    }
    localc.field_status = 101L;
    localc.field_lastModifyTime = Util.nowSecond();
    ao.ctZ().a(localc, new String[0]);
    ao.hhJ().run();
    AppMethodBeat.o(287105);
    return 0;
  }
  
  public static int a(long paramLong, String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(287111);
    int i = a(paramLong, paramString, paramd, true);
    AppMethodBeat.o(287111);
    return i;
  }
  
  public static int a(long paramLong, String paramString, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31028);
    bh.beI();
    ca localca = com.tencent.mm.model.c.bbO().Oq(paramLong);
    int i;
    if (localca.field_msgId != paramLong)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.OQ(localca.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    if ((localb.type == 6) && (localca.getType() == 10000))
    {
      Log.e("MicroMsg.AppMsgLogic", "rebuildXMLAtUploadFin: stop send revoke msg(%s)", new Object[] { Long.valueOf(localca.field_msgId) });
      AppMethodBeat.o(31028);
      return -1;
    }
    localb.fvr = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label458;
      }
      str = localb.aesKey;
      localb.aesKey = str;
      if (!paramd.field_fileId.equals("")) {
        break label467;
      }
      str = localb.lml;
      label254:
      localb.lml = str;
      if (!paramd.field_filemd5.equals("")) {
        break label476;
      }
      str = localb.filemd5;
      label281:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label485;
      }
      i = localb.llX;
      label304:
      localb.llX = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label495;
      }
    }
    label458:
    label467:
    label476:
    label485:
    label495:
    for (String str = localb.lmm;; str = paramd.field_thumbUrl)
    {
      localb.lmm = str;
      localca.setContent(k.b.a(localb, localb.fvr, paramd));
      bh.beI();
      com.tencent.mm.model.c.bbO().a(localca.field_msgId, localca);
      paramd = ao.hhH().NR(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localca.field_content;
        ao.hhH().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ao.ctZ().TR(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ao.ctZ().a(paramd, new String[0]);
      }
      AppMethodBeat.o(31028);
      return 0;
      str = paramd.field_aesKey;
      break;
      str = paramd.field_fileId;
      break label254;
      str = paramd.field_filemd5;
      break label281;
      i = (int)paramd.field_fileLength;
      break label304;
    }
  }
  
  public static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31035);
    paramInt = a(paramb, paramWXMediaMessage, paramString, null, null, paramInt, parama, null);
    AppMethodBeat.o(31035);
    return paramInt;
  }
  
  private static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, a parama, Map<String, Long> paramMap)
  {
    AppMethodBeat.i(287119);
    if (paramInt == 1)
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.tools.c();
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).fSq = 1;
      paramb.a((com.tencent.mm.aj.f)localObject1);
    }
    Object localObject1 = "";
    if (parama != null) {
      localObject1 = parama.smT;
    }
    Object localObject2 = a(paramb, paramWXMediaMessage, paramString2, (String)localObject1);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.llW + " attachlen:" + paramb.llX + " attachid:" + paramb.fvr + " attach file:" + (String)localObject2);
    localObject1 = System.currentTimeMillis();
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(287119);
        return 0 - paramInt;
      }
      localObject2 = BitmapUtil.getImageOptions((String)localObject2);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      ca localca = new ca();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 65536) || (paramWXMediaMessage.getType() == 36) || (paramWXMediaMessage.getType() == 46)) {
          break label675;
        }
        if (paramb.type != 2) {
          break label669;
        }
        bool = true;
        localObject2 = b(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG, false);
        label310:
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          localca.Jn((String)localObject2);
        }
      }
      if (localObject1 != null)
      {
        paramb.fvr = ((c)localObject1).systemRowid;
        if ((paramb.type == 6) && (Util.isNullOrNil(paramb.filemd5)))
        {
          com.tencent.mm.aq.f.bkh();
          paramb.filemd5 = com.tencent.mm.aq.a.Vs(((c)localObject1).field_fileFullPath);
        }
      }
      paramb.llZ = paramString2;
      localca.setContent(k.b.a(paramb, null, null));
      localca.setStatus(1);
      localca.pJ(1);
      localca.setType(g(paramb));
      paramString2 = Util.stringsToList(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString2.hasNext()) {
          break label1028;
        }
        paramString1 = (String)paramString2.next();
        localca.Jm(paramString1);
        localca.setCreateTime(bq.RP(paramString1));
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.aa.class)).af(localca);
        if (!Util.isNullOrNil((String)localObject2)) {
          localca.Ip((String)localObject2);
        }
        long l;
        if (paramMap != null)
        {
          l = ((Long)paramMap.get(paramString1)).longValue();
          label560:
          paramString1 = Long.valueOf(l);
          if ((paramString1 == null) || (paramString1.longValue() < 0L)) {
            break label700;
          }
          Log.i("MicroMsg.AppMsgLogic", "sendAppMsg, updateById, existMsgId:%d ", new Object[] { paramString1 });
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramString1.longValue(), localca);
        }
        for (;;)
        {
          if (paramString1.longValue() >= 0L) {
            break label721;
          }
          Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " summerbig insert msg failed :" + paramString1);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(287119);
          return 0 - paramInt;
          label669:
          bool = false;
          break;
          label675:
          localObject2 = b(paramWXMediaMessage.thumbData, false, Bitmap.CompressFormat.JPEG, true);
          break label310;
          l = -1L;
          break label560;
          label700:
          bh.beI();
          paramString1 = Long.valueOf(com.tencent.mm.model.c.bbO().aM(localca));
        }
        label721:
        Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + paramString1);
        localca.setMsgId(paramString1.longValue());
        localObject2 = new com.tencent.mm.aj.k();
        ((com.tencent.mm.aj.k)localObject2).field_xml = localca.field_content;
        ((com.tencent.mm.aj.k)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.aj.k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.aj.k)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.aj.k)localObject2).field_msgId = paramString1.longValue();
        ((com.tencent.mm.aj.k)localObject2).field_source = paramb.appName;
        ao.hhH().insert((IAutoDBItem)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = paramString1.longValue();
          ((c)localObject1).field_status = 101L;
          Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((com.tencent.mm.aj.k)localObject2).field_type) });
          ao.ctZ().a((c)localObject1, new String[0]);
          if (!Util.isNullOrNil(paramString3)) {
            ao.hhJ().ab(((c)localObject1).field_msgInfoId, paramString3);
          }
          b(localca, (c)localObject1);
        }
        else
        {
          Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, paramString1, paramString3, Integer.valueOf(((com.tencent.mm.aj.k)localObject2).field_type) });
          ao.hhJ();
          l = paramString1.longValue();
          localca.getType();
          an.a.a(l, paramString3, paramInt, parama);
        }
      }
      label1028:
      AppMethodBeat.o(287119);
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
    paramInt1 = a(paramWXMediaMessage, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, parama, null);
    AppMethodBeat.o(31034);
    return paramInt1;
  }
  
  private static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, a parama, Map<String, Long> paramMap)
  {
    AppMethodBeat.i(287117);
    k.b localb = new k.b();
    localb.appId = paramString1;
    localb.appName = paramString2;
    localb.lma = paramInt1;
    paramInt1 = a(localb, paramWXMediaMessage, paramString3, paramString4, paramString5, paramInt2, parama, paramMap);
    AppMethodBeat.o(287117);
    return paramInt1;
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(287122);
    k.b localb1 = new k.b();
    ad.b localb = ad.beh().I(paramString10, true);
    int j;
    e locale;
    if ((localb.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) || (localb.containsKey("_DATA_CENTER_NEED_SHOW_SOURCE_INFO")))
    {
      j = localb.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if ((j != -1) || (localb.getBoolean("_DATA_CENTER_IS_MP_SHARE_VIDEO", false)) || (localb.getBoolean("_DATA_CENTER_NEED_SHOW_SOURCE_INFO", false)))
      {
        locale = new e();
        locale.llp = j;
        locale.lls = localb.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (!localb.getBoolean("_DATA_CENTER_NEED_SHOW_SOURCE_INFO", false)) {
          break label677;
        }
      }
    }
    label677:
    for (int i = 1;; i = 0)
    {
      locale.llw = i;
      if (j == 5)
      {
        locale.vid = localb.getString("_DATA_CENTER_VID", "");
        locale.llq = localb.getInt("_DATA_CENTER_PUB_TIME", 0);
        locale.duration = localb.getInt("_DATA_CENTER__DULATION", 0);
        locale.videoWidth = localb.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
        locale.videoHeight = localb.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
        locale.llt = localb.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        locale.llr = localb.getInt("_DATA_SHOW_NATIVE_PAGE", 0);
      }
      if (localb.getBoolean("_DATA_CENTER_IS_MP_SHARE_VIDEO", false))
      {
        locale.llu = true;
        locale.llv = new y();
        locale.llv.fzT = paramString4;
        locale.llv.lpC = paramString5;
        locale.llv.RPa = localb.getString("_DATA_CENTER_VID", "");
        locale.llv.videoUrl = localb.getString("_DATA_CENTER_VIDEO_PLAY_URL", "");
        locale.llv.lpK = localb.getString("_DATA_CENTER_COVER_URL", "");
        locale.llv.ROZ = localb.getString("_DATA_CENTER_VIDEO_MP_URL", "");
        locale.llv.title = paramWXMediaMessage.title;
        locale.llv.videoDuration = localb.getInt("_DATA_CENTER__DULATION", 0);
        locale.llv.width = localb.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
        locale.llv.height = localb.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
      }
      localb1.a(locale);
      localb1.thumburl = localb.getString("_DATA_CENTER_COVER_URL", "");
      localb1.appId = paramString1;
      localb1.appName = paramString2;
      localb1.lma = paramInt;
      localb1.fUd = paramString4;
      localb1.fUe = paramString5;
      localb1.fUg = paramString6;
      localb1.fUh = paramString7;
      localb1.fUi = paramString8;
      localb1.fUj = paramString9;
      localb1.fUk = paramString11;
      paramString1 = a(localb1, paramWXMediaMessage, null, null);
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " content url:" + localb1.url + " lowUrl:" + localb1.llW + " attachlen:" + localb1.llX + " attachid:" + localb1.fvr + " attach file:" + paramString1);
      paramString4 = System.currentTimeMillis();
      if (Util.isNullOrNil(paramString1)) {
        break label1430;
      }
      paramString1 = a(paramString4, localb1, paramString1);
      if (paramString1 != null) {
        break;
      }
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(287122);
      return 0 - paramInt;
    }
    for (;;)
    {
      paramString5 = new ca();
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0)) {
        if (localb1.type != 2) {
          break label1221;
        }
      }
      long l;
      label1221:
      for (boolean bool = true;; bool = false)
      {
        paramString4 = b(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.PNG, false);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + paramString4);
        if (!Util.isNullOrNil(paramString4))
        {
          paramString5.Jn(paramString4);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramString4)));
        }
        if (paramString1 != null)
        {
          localb1.fvr = paramString1.systemRowid;
          if ((localb1.type == 6) && (Util.isNullOrNil(localb1.filemd5)))
          {
            com.tencent.mm.aq.f.bkh();
            localb1.filemd5 = com.tencent.mm.aq.a.Vs(paramString1.field_fileFullPath);
          }
        }
        paramString5.setContent(k.b.a(localb1, null, null));
        paramString5.setStatus(1);
        paramString5.Jm(paramString3);
        paramString5.setCreateTime(bq.RP(paramString3));
        paramString5.pJ(1);
        paramString5.setType(g(localb1));
        paramString4 = ((com.tencent.mm.plugin.messenger.foundation.a.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.aa.class)).af(paramString5);
        if (!Util.isNullOrNil(paramString4))
        {
          paramString5.Ip(paramString4);
          Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { paramString5.hxy });
        }
        paramString4 = null;
        if (paramString5.dlS())
        {
          paramString6 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
          paramString4 = new w();
          paramString4.fPV = paramString3;
          paramString4.mhK = paramString6;
          paramString4.createTime = paramString5.field_createTime;
          paramString4.fNu = paramString5.field_msgSvrId;
          paramString4.mhW = paramString5.field_content;
          paramString4.a(localb.getString("_DATA_CENTER_VIDEO_PLAY_URL", ""), localb.getInt("_DATA_CENTER__DULATION", 0), paramWXMediaMessage.title, localb.getString("_DATA_CENTER_VIDEO_MP_URL", ""), "", "", "");
          paramString4.mhZ.low = paramString5.field_imgPath;
          paramString5.Jn(x.XS(paramString4.bqM()));
        }
        bh.beI();
        l = com.tencent.mm.model.c.bbO().aM(paramString5);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break;
        }
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(287122);
        return 0 - paramInt;
      }
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      paramString5.setMsgId(l);
      if (paramString4 != null)
      {
        paramString4.mhR = ((int)paramString5.field_msgId);
        paramString4.fileName = paramString5.field_imgPath;
        paramString4.status = 111;
        s.bqB().b(paramString4);
      }
      paramString3 = new com.tencent.mm.aj.k();
      paramString3.field_xml = paramString5.field_content;
      paramString3.field_title = paramWXMediaMessage.title;
      paramString3.field_type = paramWXMediaMessage.mediaObject.type();
      paramString3.field_description = paramWXMediaMessage.description;
      paramString3.field_msgId = l;
      paramString3.field_source = paramString2;
      ao.hhH().insert(paramString3);
      if (paramString1 != null)
      {
        paramString1.field_msgInfoId = l;
        paramString1.field_status = 101L;
        ao.ctZ().a(paramString1, new String[0]);
        b(paramString5, paramString1);
      }
      for (;;)
      {
        AppMethodBeat.o(287122);
        return 0;
        ao.hhJ();
        an.a.ac(l, paramString10);
      }
      label1430:
      paramString1 = null;
    }
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, Map<String, Long> paramMap)
  {
    AppMethodBeat.i(287115);
    int i = a(paramWXMediaMessage, paramString1, paramString2, paramString3, 4, null, null, 0, null, paramMap);
    AppMethodBeat.o(287115);
    return i;
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
    Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    if (!Util.isNullOrNil(paramString4))
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
      ca localca = new ca();
      int i;
      int j;
      String str;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 44) && (paramb.type != 48)) {
          break label744;
        }
        if (paramb.type != 48) {
          break label677;
        }
        i = 0;
        j = 0;
        com.tencent.mm.aj.a locala = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
        if (locala == null) {
          break label706;
        }
        str = locala.imageUrl;
        label193:
        if (locala == null) {
          break label714;
        }
        bool = locala.lkq;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label720;
        }
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, str, bool);
      }
      final long l;
      for (;;)
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + paramArrayOfByte);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localca.Jn(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramArrayOfByte)));
        }
        if (localObject != null)
        {
          paramb.fvr = ((c)localObject).systemRowid;
          if ((paramb.type == 6) && (Util.isNullOrNil(paramb.filemd5)))
          {
            com.tencent.mm.aq.f.bkh();
            paramb.filemd5 = com.tencent.mm.aq.a.Vs(((c)localObject).field_fileFullPath);
          }
        }
        localca.setContent(k.b.a(paramb, null, null));
        localca.setStatus(1);
        localca.Jm(paramString3);
        localca.setCreateTime(bq.RP(paramString3));
        localca.pJ(1);
        localca.setType(g(paramb));
        paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.aa.class)).af(localca);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localca.Ip(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.hxy });
        }
        if (paramb.type == 53) {
          localca.Jx((String)paramb.loQ.first);
        }
        bh.beI();
        l = com.tencent.mm.model.c.bbO().aM(localca);
        if (paramb.type == 53)
        {
          paramArrayOfByte = new op();
          paramArrayOfByte.fNr.type = 0;
          paramArrayOfByte.fNr.key = localca.ilt;
          paramArrayOfByte.fNr.username = localca.field_talker;
          paramArrayOfByte.fNs.msgId = l;
          EventCenter.instance.publish(paramArrayOfByte);
        }
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label802;
        }
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label677:
        i = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        j = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        break;
        label706:
        str = "";
        break label193;
        label714:
        bool = false;
        break label205;
        label720:
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, str, bool);
        continue;
        label744:
        if (paramb.type != 46) {
          break label769;
        }
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label769:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = b(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG, false);
        break;
      }
      label802:
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      paramArrayOfByte = new com.tencent.mm.aj.k();
      paramArrayOfByte.field_xml = localca.field_content;
      paramArrayOfByte.field_appId = paramString1;
      paramArrayOfByte.field_title = paramb.title;
      paramArrayOfByte.field_type = paramb.type;
      paramArrayOfByte.field_description = paramb.description;
      paramArrayOfByte.field_msgId = l;
      paramArrayOfByte.field_source = paramString2;
      ao.hhH().insert(paramArrayOfByte);
      if (localObject == null)
      {
        bool = true;
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label1040;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ao.ctZ().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!Util.isNullOrNil(paramString5))) {
          ao.hhJ().ab(l, paramString5);
        }
        b(localca, (c)localObject);
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label1040:
        if ((paramb.lmb != 0) || (paramb.llX > 26214400))
        {
          bh.aGY().a(new com.tencent.mm.pluginsdk.h.c(paramb, paramString4, paramString3, new c.a()
          {
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
            {
              AppMethodBeat.i(286383);
              if (Util.isNullOrNil(paramAnonymousString4))
              {
                this.lrk.setStatus(5);
                bh.beI();
                com.tencent.mm.model.c.bbO().a(this.lrk.field_msgId, this.lrk);
                paramAnonymousString2 = new ca();
                paramAnonymousString2.setCreateTime(bq.RP(paramAnonymousString2.field_talker));
                paramAnonymousString2.Jm(paramAnonymousString2.field_talker);
                paramAnonymousString2.setContent(paramAnonymousString1);
                paramAnonymousString2.setType(10000);
                paramAnonymousString2.setStatus(6);
                paramAnonymousString2.pJ(0);
                bh.beI();
                com.tencent.mm.model.c.bbO().aM(paramAnonymousString2);
                AppMethodBeat.o(286383);
                return;
              }
              ao.hhJ();
              paramAnonymousLong = l;
              paramAnonymousString1 = this.oiy;
              this.lrk.getType();
              an.a.h(paramAnonymousLong, paramAnonymousString1, paramAnonymousString4);
              AppMethodBeat.o(286383);
            }
          }), 0);
        }
        else
        {
          ao.hhJ();
          localca.getType();
          an.a.h(l, paramString5, paramString6);
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
    localc.field_createTime = cm.bfC();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  private static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.aSC()))
    {
      Log.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.llX;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = cm.bfC();
    ((c)localObject).field_lastModifyTime = Util.nowSecond();
    ((c)localObject).field_mediaSvrId = Util.nowMilliSecond();
    ((c)localObject).field_isUseCdn = 0;
    ao.ctZ().insert((IAutoDBItem)localObject);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
      AppMethodBeat.o(31027);
      return null;
    }
    AppMethodBeat.o(31027);
    return localObject;
  }
  
  private static String a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287124);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
      if (!Util.isNullOrNil(paramWXMediaMessage.fileData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.llX = paramWXMediaMessage.fileData.length;
        paramb = cT(paramWXMediaMessage.fileData);
        AppMethodBeat.o(287124);
        return paramb;
      }
      paramb.llX = ((int)u.bBQ(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.llX);
      if (paramb.llX > 0)
      {
        paramb.llY = u.asq(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(287124);
        return paramb;
      }
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.apK(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.fileData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.llX = paramWXMediaMessage.fileData.length;
        paramb = cT(paramWXMediaMessage.fileData);
        AppMethodBeat.o(287124);
        return paramb;
      }
      paramb.llX = ((int)u.bBQ(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.llX);
      if (paramb.llX > 0)
      {
        paramb.llY = u.asq(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(287124);
        return paramb;
      }
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.llX = paramWXMediaMessage.imageData.length;
        paramb = cT(paramWXMediaMessage.imageData);
        AppMethodBeat.o(287124);
        return paramb;
      }
      if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.llX = ((int)u.bBQ(paramWXMediaMessage.imagePath));
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.llX);
        if (paramb.llX > 0)
        {
          paramb.llY = u.asq(paramWXMediaMessage.imagePath);
          bh.beI();
          paramb = new com.tencent.mm.vfs.q(com.tencent.mm.model.c.bce(), "appmsg_img_" + System.currentTimeMillis()).bOF();
          paramString1 = BitmapUtil.getImageOptions(paramWXMediaMessage.imagePath);
          if ((paramString1 == null) || (paramString1.outWidth <= 0) || (paramString1.outHeight <= 0))
          {
            boolean bool;
            int i;
            if (paramString1 == null)
            {
              bool = true;
              if (paramString1 != null) {
                break label854;
              }
              i = -1;
              label797:
              if (paramString1 != null) {
                break label863;
              }
            }
            label854:
            label863:
            for (int j = -1;; j = paramString1.outHeight)
            {
              Log.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(287124);
              return null;
              bool = false;
              break;
              i = paramString1.outWidth;
              break label797;
            }
          }
          if (z.f(paramWXMediaMessage.imagePath, "", true))
          {
            Log.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (u.on(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              Log.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(287124);
              return null;
            }
            AppMethodBeat.o(287124);
            return paramb;
          }
          if ((paramString1.outWidth > 960) || (paramString1.outHeight > 960))
          {
            paramWXMediaMessage = BitmapUtil.extractThumbNail(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (u.on(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              BitmapUtil.saveBitmapToImage(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(287124);
              return paramb;
            }
            catch (IOException paramb)
            {
              Log.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
              AppMethodBeat.o(287124);
              return null;
            }
            AppMethodBeat.o(287124);
            return null;
          }
          AppMethodBeat.o(287124);
          return null;
        }
        AppMethodBeat.o(287124);
        return null;
      }
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.llW = paramWXMediaMessage.musicLowBandUrl;
      paramb.lms = paramWXMediaMessage.musicDataUrl;
      paramb.lmt = paramWXMediaMessage.musicLowBandDataUrl;
      paramString1 = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString1.songAlbumUrl = paramWXMediaMessage.songAlbumUrl;
      paramString1.songLyric = paramWXMediaMessage.songLyric;
      paramb.a(paramString1);
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 76)
    {
      paramWXMediaMessage = (WXMusicVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.lms = paramWXMediaMessage.musicDataUrl;
      paramString1 = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString1.songAlbumUrl = paramString2;
      paramString1.Ruy = paramWXMediaMessage.singerName;
      paramString1.Ruz = paramWXMediaMessage.albumName;
      paramString1.songLyric = paramWXMediaMessage.songLyric;
      paramString1.RuA = paramWXMediaMessage.musicGenre;
      paramString1.RuB = String.valueOf(paramWXMediaMessage.issueDate);
      paramString1.RuC = paramWXMediaMessage.identification;
      paramString1.FSG = paramWXMediaMessage.duration;
      paramString1.RuD = paramb.messageExt;
      paramb.a(paramString1);
      AppMethodBeat.o(287124);
      return null;
    }
    if (paramb.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.videoUrl;
      paramb.llW = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(287124);
      return null;
    }
    if ((paramb.type == 5) || (paramb.type == 54) || (paramb.type == 69))
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!Util.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!Util.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      if ((paramb.type == 69) && ((paramWXMediaMessage instanceof com.tencent.mm.plugin.game.luggage.f.b)))
      {
        paramWXMediaMessage = (com.tencent.mm.plugin.game.luggage.f.b)paramWXMediaMessage;
        paramString1 = new com.tencent.mm.plugin.game.luggage.f.a();
        paramString1.iconUrl = paramWXMediaMessage.iconUrl;
        paramString1.nickName = paramWXMediaMessage.nickName;
        paramString1.desc = paramWXMediaMessage.desc;
        paramString1.CBX = paramWXMediaMessage.CBX;
        paramString1.jumpUrl = paramWXMediaMessage.jumpUrl;
        paramb.a(paramString1);
      }
      AppMethodBeat.o(287124);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.loA = paramWXMediaMessage.userName;
      paramb.loz = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.bLH() != null) {
          paramb.loU = paramWXMediaMessage.bLH().appVersion;
        }
        paramb.loV = paramWXMediaMessage.field_brandIconURL;
        Log.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.loU), paramb.loV });
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(287124);
        return null;
        if (paramb.type == 1)
        {
          paramb.title = ((WXTextObject)paramWXMediaMessage).text;
          AppMethodBeat.o(287124);
          return null;
        }
        if (paramb.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiData))
        {
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.llX = paramWXMediaMessage.emojiData.length;
          paramb = cT(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(287124);
          return paramb;
        }
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.llX = ((int)u.bBQ(paramWXMediaMessage.emojiPath));
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.llX);
          if (paramb.llX > 0)
          {
            paramb.llY = u.asq(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(287124);
            return paramb;
          }
          AppMethodBeat.o(287124);
          return null;
        }
        paramb.llZ = paramString1;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.lmE = paramWXMediaMessage.packageflag;
        paramb.lmD = paramWXMediaMessage.packageid;
        paramb.fwp = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(287124);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.lmE = paramWXMediaMessage.packageflag;
        paramb.lmD = paramWXMediaMessage.packageid;
        paramb.fwp = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(287124);
        return null;
      }
      if (paramb.type == 68)
      {
        paramWXMediaMessage = (WXLiteAppObject)paramWXMediaMessage;
        paramb.url = paramWXMediaMessage.webpageUrl;
        paramb.loN = paramWXMediaMessage.userName;
        paramb.loO = paramWXMediaMessage.path;
        paramb.loP = paramWXMediaMessage.query;
        paramb.fwp = 0;
        AppMethodBeat.o(287124);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.lon = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.fwp = 18;
        AppMethodBeat.o(287124);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.loo = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.fwp = 20;
    AppMethodBeat.o(287124);
    return null;
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
    localc.field_createTime = cm.bfC();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], msgLocalId[%s], stack[%s]", new Object[] { Boolean.valueOf(ao.ctZ().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, Long.valueOf(paramLong), Util.getStack() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  private static List<a.b> a(long paramLong, String paramString, aoc paramaoc)
  {
    AppMethodBeat.i(287114);
    List localList = Collections.synchronizedList(new ArrayList());
    Iterator localIterator = paramaoc.syG.iterator();
    while (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      if (localanm.Syi > 26214400L)
      {
        a.b localb = new a.b();
        String str = p.c(localanm, paramLong);
        paramaoc = u.buc(str);
        localb.toUser = paramString;
        localb.fileSize = localanm.Syi;
        localb.jmx = localanm.Syc;
        if (Util.isNullOrNil(localanm.Sye))
        {
          label121:
          localb.smU = paramaoc;
          localb.aesKey = localanm.SxP;
          localb.fileName = localanm.title;
          if (!Util.isNullOrNil(localanm.Syl)) {
            break label189;
          }
        }
        label189:
        for (paramaoc = str;; paramaoc = localanm.Syl)
        {
          localb.filePath = paramaoc;
          localList.add(localb);
          break;
          paramaoc = localanm.Sye;
          break label121;
        }
      }
    }
    AppMethodBeat.o(287114);
    return localList;
  }
  
  public static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.OQ(paramca.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramca.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((Util.isNullOrNil(((k.b)localObject).fvr)) && (!Util.isNullOrNil(((k.b)localObject).lml)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramca.field_content });
      ((k.b)localObject).fvr = ((k.b)localObject).lml.hashCode();
    }
    localObject = ((k.b)localObject).fvr;
    if ((!a(paramca, p((String)localObject, paramca.field_msgId))) && (e((String)localObject, paramca)))
    {
      HCv = new com.tencent.mm.plugin.record.b.f(paramca.field_msgId, (String)localObject, new j()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(278027);
          if (this.QWE != null) {
            this.QWE.lT(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(278027);
        }
      });
      bh.aGY().a(HCv, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.e.a parama, ca paramca, int paramInt, k.b paramb)
  {
    AppMethodBeat.i(287106);
    com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(paramInt), "", parama.WQv.getMMResources().getString(R.l.eoH), parama.WQv.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(291508);
        m.bh(this.lrk);
        parama.Gi(true);
        AppMethodBeat.o(291508);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    bh.beI();
    parama = com.tencent.mm.model.c.bbO().Oq(paramca.field_msgId);
    parama.setFileStatus(101);
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, parama);
    paramca = o.XfQ;
    o.d.a(5, paramb, parama);
    AppMethodBeat.o(287106);
  }
  
  public static boolean a(ca paramca, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!u.agG(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.evg()) || ((paramca.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static void aW(ca paramca)
  {
    AppMethodBeat.i(287108);
    a(paramca, null);
    AppMethodBeat.o(287108);
  }
  
  public static int aa(long paramLong, String paramString)
  {
    AppMethodBeat.i(287107);
    c localc = ao.ctZ().TR(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      AppMethodBeat.o(287107);
      return -1;
    }
    if (localc.field_status != 101L)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(287107);
      return -1;
    }
    localc.field_status = 102L;
    localc.field_lastModifyTime = Util.nowSecond();
    ao.ctZ().a(localc, new String[0]);
    AppMethodBeat.o(287107);
    return 0;
  }
  
  public static int apL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static boolean apM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static String aw(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new com.tencent.mm.vfs.q(paramString1);
    if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
      ((com.tencent.mm.vfs.q)localObject).ifL();
    }
    String str1;
    String str2;
    if (Util.isNullOrNil(paramString2))
    {
      str1 = paramString1 + "da_" + Util.nowMilliSecond();
      localObject = str1;
      str2 = paramString2;
      if (!Util.isNullOrNil(paramString3))
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
        if (!new com.tencent.mm.vfs.q((String)localObject).ifB().bOF().equalsIgnoreCase(new com.tencent.mm.vfs.q(paramString1).bOF()))
        {
          localObject = paramString1 + "da_" + Util.nowMilliSecond();
          paramString2 = (String)localObject;
          if (!Util.isNullOrNil(str2)) {
            paramString2 = (String)localObject + str2;
          }
          localObject = paramString2;
          if (!Util.isNullOrNil(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
          Log.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
          paramString2 = (String)localObject;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + Util.nowMilliSecond();
          paramString2 = paramString1;
          if (!Util.isNullOrNil(paramString3)) {
            paramString2 = paramString1 + "." + paramString3;
          }
        }
      }
      AppMethodBeat.o(31031);
      return paramString2;
      str1 = paramString2;
      if (!Util.isNullOrNil(paramString3))
      {
        str1 = paramString2;
        if (!paramString2.endsWith(paramString3)) {
          str1 = paramString2 + "." + paramString3;
        }
      }
      paramString2 = paramString1 + str1;
      localObject = paramString2;
      str2 = str1;
    } while (!u.agG(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!u.agG(paramString1 + i + "_" + str1)) {
          localObject = paramString1 + i + "_" + str1;
        }
      }
      else
      {
        str2 = str1;
        if (i != 20) {
          break;
        }
        paramString2 = paramString1 + "da_" + Util.nowMilliSecond();
        localObject = paramString2;
        str2 = str1;
        if (Util.isNullOrNil(paramString3)) {
          break;
        }
        localObject = paramString2 + "." + paramString3;
        str2 = str1;
        break;
      }
      i += 1;
    }
  }
  
  private static String b(byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    boolean bool = false;
    AppMethodBeat.i(287127);
    if (QWC == -1) {
      QWC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAL, 0);
    }
    if ((QWC == 1) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) {
      bool = true;
    }
    if (paramBoolean2) {
      if (bool) {
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().az(paramArrayOfByte);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppMsgLogic", "saveAppMsgDirThumb directSave:" + paramBoolean2 + "  switchSavePath:" + bool + "  useNewAppMsgSavePath:" + QWC + "  path:" + paramArrayOfByte);
      AppMethodBeat.o(287127);
      return paramArrayOfByte;
      paramArrayOfByte = com.tencent.mm.ay.q.bmh().aA(paramArrayOfByte);
      continue;
      if (bool) {
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().b(paramArrayOfByte, paramBoolean1, paramCompressFormat);
      } else {
        paramArrayOfByte = com.tencent.mm.ay.q.bmh().a(paramArrayOfByte, paramBoolean1, paramCompressFormat);
      }
    }
  }
  
  private static void b(ca paramca, c paramc)
  {
    AppMethodBeat.i(287128);
    if ((paramc != null) && (paramca.getType() == 1090519089))
    {
      long l1 = paramc.field_msgInfoId;
      long l2 = paramc.systemRowid;
      com.tencent.mm.an.aa.a(new com.tencent.mm.pluginsdk.model.a.a(paramc).rr, new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(264058);
          Log.i("MicroMsg.AppMsgLogic", "sendFileUploadMsgCallback type:%d errType:%d errCode:%d errMsg:%s tempMsgId:%s", new Object[] { Integer.valueOf(paramAnonymousq.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Util.nullAs(paramAnonymousString, ""), Long.valueOf(this.QWG) });
          paramAnonymousq = (edp)d.b.b(paramAnonymousd.lBR);
          if ((paramAnonymousq == null) || (!Util.isEqual(paramAnonymousq.UhR, this.QWG)))
          {
            AppMethodBeat.o(264058);
            return 0;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousd = (edq)d.c.b(paramAnonymousd.lBS);
            if (paramAnonymousd != null)
            {
              Log.i("MicroMsg.AppMsgLogic", "FileUploadToken:%s NewMsgId:%s msgId:%s", new Object[] { paramAnonymousd.UhT, Long.valueOf(paramAnonymousd.UhV), paramAnonymousq.UhR });
              paramAnonymousString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(Util.safeParseLong(paramAnonymousq.UhR));
              if (paramAnonymousString.field_msgId == 0L)
              {
                Log.e("MicroMsg.AppMsgLogic", "sendFileUploadMsgCallback msg:%s no exist!", new Object[] { paramAnonymousq.UhR });
                AppMethodBeat.o(264058);
                return 0;
              }
              paramAnonymousq = k.b.OQ(Util.processXml(paramAnonymousString.field_content));
              com.tencent.mm.aj.a.b localb = new com.tencent.mm.aj.a.b();
              localb.OX(paramAnonymousd.UhT);
              localb.lqB = paramAnonymousd.UhV;
              paramAnonymousq.a(localb);
              paramAnonymousString.setContent(k.b.a(paramAnonymousq, null, null));
              paramAnonymousString.setStatus(2);
              paramAnonymousString.EG(paramAnonymousd.UhV);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousString.field_msgId, paramAnonymousString);
              paramAnonymousd = o.XfQ;
              o.d.a(1, paramAnonymousq, paramAnonymousString);
            }
          }
          for (;;)
          {
            ao.hhJ().run();
            AppMethodBeat.o(264058);
            return 0;
            m.Pn(this.QWH);
          }
        }
      });
      AppMethodBeat.o(287128);
      return;
    }
    ao.hhJ().run();
    AppMethodBeat.o(287128);
  }
  
  public static c bg(ca paramca)
  {
    AppMethodBeat.i(287109);
    Object localObject = k.b.OQ(paramca.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramca.field_content });
      AppMethodBeat.o(287109);
      return null;
    }
    if ((Util.isNullOrNil(((k.b)localObject).fvr)) && (!Util.isNullOrNil(((k.b)localObject).lml)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramca.field_content });
      ((k.b)localObject).fvr = ((k.b)localObject).lml.hashCode();
    }
    String str = ((k.b)localObject).fvr;
    c localc = p(str, paramca.field_msgId);
    localObject = localc;
    if (localc == null)
    {
      e(str, paramca);
      localObject = p(str, paramca.field_msgId);
    }
    AppMethodBeat.o(287109);
    return localObject;
  }
  
  public static Pair<Integer, Long> bh(ca paramca)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.OQ(paramca.field_content);
    if (localObject5 == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = bqf(((k.b)localObject5).fvr);
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
          bh.beI();
          localObject1 = aw(com.tencent.mm.model.c.bce(), ((k.b)localObject5).title, ((k.b)localObject5).llY);
          u.on(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((paramca.field_imgPath != null) && (!paramca.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = u.aY((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (Util.isNullOrNil((String)localObject1)) {
          break label1127;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        paramca = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return paramca;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new ca();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label741;
        }
        localObject3 = com.tencent.mm.ay.q.bmh().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ca)localObject6).Jn((String)localObject3);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null)
      {
        ((k.b)localObject4).fvr = ((c)localObject1).systemRowid;
        if ((((k.b)localObject4).type == 6) && (Util.isNullOrNil(((k.b)localObject4).filemd5)))
        {
          com.tencent.mm.aq.f.bkh();
          ((k.b)localObject4).filemd5 = com.tencent.mm.aq.a.Vs(((c)localObject1).field_fileFullPath);
        }
      }
      ((ca)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((ca)localObject6).setStatus(1);
      ((ca)localObject6).Jm(paramca.field_talker);
      ((ca)localObject6).setCreateTime(bq.RP(paramca.field_talker));
      ((ca)localObject6).pJ(1);
      ((ca)localObject6).setType(g((k.b)localObject4));
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.aa.class)).af((ca)localObject6);
      if (!Util.isNullOrNil((String)localObject3))
      {
        ((ca)localObject6).Ip((String)localObject3);
        Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((et)localObject6).hxy });
      }
      if (((k.b)localObject4).type == 53) {
        ((ca)localObject6).Jx(paramca.ilt);
      }
      bh.beI();
      long l = com.tencent.mm.model.c.bbO().aM((ca)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new op();
        ((op)localObject3).fNr.type = 0;
        ((op)localObject3).fNr.key = ((et)localObject6).ilt;
        ((op)localObject3).fNr.username = ((et)localObject6).field_talker;
        ((op)localObject3).fNs.msgId = l;
        EventCenter.instance.publish((IEvent)localObject3);
      }
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
        paramca = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramca;
        label741:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = b((byte[])localObject3, bool, Bitmap.CompressFormat.PNG, false);
          break;
        }
      }
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((ca)localObject6).setMsgId(l);
      localObject3 = new zs();
      ((zs)localObject3).fYX.fYY = paramca.field_msgId;
      ((zs)localObject3).fYX.fYZ = l;
      EventCenter.instance.publish((IEvent)localObject3);
      localObject3 = new com.tencent.mm.aj.k();
      ((com.tencent.mm.aj.k)localObject3).field_xml = ((et)localObject6).field_content;
      ((com.tencent.mm.aj.k)localObject3).field_title = ((k.b)localObject4).title;
      ((com.tencent.mm.aj.k)localObject3).field_type = ((k.b)localObject4).type;
      ((com.tencent.mm.aj.k)localObject3).field_description = ((k.b)localObject4).description;
      ((com.tencent.mm.aj.k)localObject3).field_msgId = l;
      ((com.tencent.mm.aj.k)localObject3).field_source = ((String)localObject5);
      ao.hhH().insert((IAutoDBItem)localObject3);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ao.ctZ().a((c)localObject1, new String[0]);
        b((ca)localObject6, (c)localObject1);
      }
      for (;;)
      {
        paramca = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramca;
        if ((((k.b)localObject4).type == 24) || (((k.b)localObject4).type == 19))
        {
          localObject1 = p.aVz(((k.b)localObject4).lmA);
          localObject3 = new aoc();
          if (localObject1 != null) {
            ((aoc)localObject3).syG.addAll(((com.tencent.mm.protocal.b.a.c)localObject1).lpz);
          }
          localObject5 = paramca.field_talker;
          List localList = a(l, (String)localObject5, (aoc)localObject3);
          if (localList.size() > 0)
          {
            com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.pluginsdk.h.a(localList, new a.a()
            {
              public final void bQ(int paramAnonymousInt, String paramAnonymousString)
              {
                AppMethodBeat.i(292153);
                if (paramAnonymousInt == 0)
                {
                  paramAnonymousString = new com.tencent.mm.plugin.record.a.k();
                  paramAnonymousString.field_msgId = this.fgE;
                  paramAnonymousString.field_oriMsgId = this.QWF.field_msgId;
                  paramAnonymousString.field_toUser = this.ffX;
                  paramAnonymousString.field_title = this.pqD.title;
                  paramAnonymousString.field_desc = this.pqD.description;
                  paramAnonymousString.field_dataProto = this.HDl;
                  paramAnonymousString.field_type = 0;
                  paramAnonymousString.field_favFrom = this.HDk.HCx;
                  paramAnonymousString.field_localId = (new Random().nextInt(2147483645) + 1);
                  Log.i("MicroMsg.AppMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramAnonymousString)), Long.valueOf(this.fgE), Integer.valueOf(paramAnonymousString.field_localId) });
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramAnonymousString);
                  AppMethodBeat.o(292153);
                  return;
                }
                if (-3200 == paramAnonymousInt) {
                  Log.e("MicroMsg.AppMsgLogic", "why errCode equals %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
                }
                this.lrk.setStatus(5);
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fgE, this.lrk);
                ca localca = new ca();
                localca.setCreateTime(this.lrk.field_createTime + 1L);
                localca.Jm(this.lrk.field_talker);
                localca.setContent(paramAnonymousString);
                localca.setType(10000);
                localca.setStatus(6);
                localca.pJ(0);
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
                AppMethodBeat.o(292153);
              }
            }), 0);
          }
          else
          {
            ao.hhJ();
            an.a.Pm(l);
          }
        }
        else
        {
          ao.hhJ();
          an.a.Pm(l);
        }
      }
      label1127:
      localObject1 = null;
    }
  }
  
  public static boolean bqd(String paramString)
  {
    AppMethodBeat.i(31017);
    if (Util.isNullOrNil(paramString))
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
  
  public static int bqe(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.OQ(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!bqd(localb.fvr))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = Util.getLong(localb.fvr, -1L);
    if (l != -1L)
    {
      ao.ctZ().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ao.ctZ().bpR(localb.fvr);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.fvr)) {}
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
      localc = ao.ctZ().bpR(localb.fvr);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.fvr)) {}
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
  
  public static c bqf(String paramString)
  {
    AppMethodBeat.i(31040);
    c localc2 = new c();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31040);
      return null;
    }
    Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = Util.getLong(paramString, -1L);
    c localc1;
    if (l != -1L)
    {
      ao.ctZ().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ao.ctZ().bpR(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localc1 = null;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      AppMethodBeat.o(31040);
      return localc1;
      localc2 = ao.ctZ().bpR(paramString);
      if (localc2 != null)
      {
        localc1 = localc2;
        if (localc2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localc1 = null;
      }
    }
  }
  
  public static String cT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = com.tencent.mm.model.c.bce() + "ua_" + Util.nowMilliSecond();
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " buildUploadAttachInfo file:" + (String)localObject);
    if (u.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.avD() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static c e(ca paramca, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = bqf(paramString);
    if (localc == null)
    {
      M(paramca.field_msgId, paramca.field_content);
      paramca = bqf(paramString);
      AppMethodBeat.o(31039);
      return paramca;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static boolean e(String paramString, ca paramca)
  {
    AppMethodBeat.i(31023);
    if (paramca == null)
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
    Object localObject1 = p(paramString, paramca.field_msgId);
    Object localObject2 = k.b.OQ(paramca.field_content);
    if (localObject2 != null)
    {
      str3 = ae.nullAsNil(((k.b)localObject2).title);
      str4 = ae.nullAsNil(((k.b)localObject2).llY).toLowerCase();
      str2 = ae.nullAsNil(((k.b)localObject2).filemd5);
      str5 = ae.nullAsNil(((k.b)localObject2).fLi);
      str1 = ae.nullAsNil(((k.b)localObject2).aesKey);
    }
    if (localObject1 == null)
    {
      M(paramca.field_msgId, paramca.field_content);
      paramca = p(paramString, paramca.field_msgId);
      paramString = paramca;
      bool1 = bool2;
      if (paramca != null)
      {
        l1 = paramca.systemRowid;
        l2 = paramca.field_totalLen;
        paramString = paramca.field_fileFullPath;
        l3 = paramca.field_type;
        localObject1 = paramca.field_mediaId;
        l4 = paramca.field_msgInfoId;
        bool1 = paramca.field_isUpload;
        if (paramca.field_signature != null) {
          break label343;
        }
      }
      label343:
      for (i = -1;; i = paramca.field_signature.length())
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = paramca;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).lmb == 0)
          {
            paramString = paramca;
            bool1 = bool2;
            if (((k.b)localObject2).llX <= 26214400) {}
          }
          else
          {
            bool1 = false;
            paramString = paramca;
          }
        }
        if (!bool1) {
          bh.aGY().a(new com.tencent.mm.plugin.record.b.d(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
      }
    }
    paramString = new com.tencent.mm.vfs.q(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.ifE()))
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      M(paramca.field_msgId, paramca.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    paramca = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.ifE();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramca, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
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
    int j = paramb.fwp;
    int k = paramb.llp;
    int m = paramb.lmu;
    int n = paramb.lnQ;
    Log.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
    if (i == 76)
    {
      AppMethodBeat.o(31042);
      return 1040187441;
    }
    if ((i == 3) && (com.tencent.mm.plugin.music.model.m.asG(paramb.appId)))
    {
      AppMethodBeat.o(31042);
      return 1040187441;
    }
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
    if (i == 2003)
    {
      AppMethodBeat.o(31042);
      return 536936497;
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
    com.tencent.mm.aj.a locala = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
    if ((locala != null) && (locala.ljZ) && ((paramb.loC == 2) || (paramb.loC == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.lkc) && (paramb.loC == 3))
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
    paramb = (e)paramb.ar(e.class);
    if ((paramb != null) && (paramb.llv != null))
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
    AppMethodBeat.o(31042);
    return 1090519089;
    AppMethodBeat.o(31042);
    return 1074790449;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 973078577;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 973078577;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1006633009;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1006633009;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 956301361;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 956301361;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1023410225;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1023410225;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1076887601;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1076887601;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
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
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 989855793;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJz, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 989855793;
    switch (com.tencent.mm.plugin.findersdk.a.k.d(paramb.lpa, paramb.loX))
    {
    default: 
      AppMethodBeat.o(31042);
      return 49;
    case 100000000: 
      AppMethodBeat.o(31042);
      return 1023475761;
    case 3: 
      AppMethodBeat.o(31042);
      return 1023541297;
    }
    AppMethodBeat.o(31042);
    return 1057030193;
    AppMethodBeat.o(31042);
    return 1075839025;
  }
  
  public static c p(String paramString, long paramLong)
  {
    AppMethodBeat.i(31024);
    c localc = bqf(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ao.ctZ().TR(paramLong);
    }
    if (paramString != null) {
      Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), Util.getStack() });
    }
    for (;;)
    {
      AppMethodBeat.o(31024);
      return paramString;
      Log.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { Util.getStack() });
    }
  }
  
  public static abstract interface a
  {
    public abstract void lT(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */