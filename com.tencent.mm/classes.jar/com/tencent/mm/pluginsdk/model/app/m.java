package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
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
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class m
{
  private static com.tencent.mm.plugin.record.b.f BGq;
  
  public static String E(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.HD(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aB(com.tencent.mm.loader.j.b.aKM(), paramString.title, paramString.iwJ);
    if ((Util.isNullOrNil(paramString.dCK)) && (!Util.isNullOrNil(paramString.iwW))) {
      paramString.dCK = paramString.iwW.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dCK, paramString.iwI, paramString.type, paramString.iwM);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static void HS(long paramLong)
  {
    AppMethodBeat.i(31018);
    ao.cgO().Mo(paramLong);
    c localc = new c();
    ao.cgO().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().Hb(localc.field_msgInfoId);
    if (localca.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    localca.setStatus(5);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(localca.field_msgId, localca);
    AppMethodBeat.o(31018);
  }
  
  public static int a(long paramLong, String paramString, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31028);
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().Hb(paramLong);
    int i;
    if (localca.field_msgId != paramLong)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.HD(localca.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    localb.dCK = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label399;
      }
      str = localb.aesKey;
      localb.aesKey = str;
      if (!paramd.field_fileId.equals("")) {
        break label408;
      }
      str = localb.iwW;
      label198:
      localb.iwW = str;
      if (!paramd.field_filemd5.equals("")) {
        break label417;
      }
      str = localb.filemd5;
      label224:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label426;
      }
      i = localb.iwI;
      label247:
      localb.iwI = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label436;
      }
    }
    label399:
    label408:
    label417:
    label426:
    label436:
    for (String str = localb.iwX;; str = paramd.field_thumbUrl)
    {
      localb.iwX = str;
      localca.setContent(k.b.a(localb, localb.dCK, paramd));
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(localca.field_msgId, localca);
      paramd = ao.gnf().GL(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localca.field_content;
        ao.gnf().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ao.cgO().Mp(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ao.cgO().a(paramd, new String[0]);
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
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).dYz = 1;
      paramb.a((com.tencent.mm.ag.f)localObject1);
    }
    Object localObject2 = null;
    Object localObject1 = "";
    if (parama != null) {
      localObject1 = parama.pkK;
    }
    Object localObject3 = a(paramb, paramWXMediaMessage, paramString2, (String)localObject1);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.iwH + " attachlen:" + paramb.iwI + " attachid:" + paramb.dCK + " attach file:" + (String)localObject3);
    String str = System.currentTimeMillis();
    localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject3))
    {
      localObject1 = a(str, paramb, (String)localObject3);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(31036);
        return 0 - paramInt;
      }
      localObject2 = BitmapUtil.getImageOptions((String)localObject3);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    localObject3 = new ca();
    boolean bool;
    if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
    {
      if ((paramWXMediaMessage.thumbData.length <= 65536) || (paramWXMediaMessage.getType() == 36) || (paramWXMediaMessage.getType() == 46)) {
        break label592;
      }
      if (paramb.type != 2) {
        break label586;
      }
      bool = true;
      localObject2 = com.tencent.mm.av.q.bcR().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
      label318:
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
      if (!Util.isNullOrNil((String)localObject2)) {
        ((ca)localObject3).Cz((String)localObject2);
      }
    }
    if (localObject1 != null) {
      paramb.dCK = ((c)localObject1).systemRowid;
    }
    paramString1 = Util.stringsToList(paramString1.split(",")).iterator();
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label900;
      }
      localObject2 = (String)paramString1.next();
      paramb.iwK = paramString2;
      ((ca)localObject3).setContent(k.b.a(paramb, null, null));
      ((ca)localObject3).setStatus(1);
      ((ca)localObject3).Cy((String)localObject2);
      ((ca)localObject3).setCreateTime(bp.Kw((String)localObject2));
      ((ca)localObject3).nv(1);
      ((ca)localObject3).setType(g(paramb));
      localObject2 = ((w)g.af(w.class)).Z((ca)localObject3);
      if (!Util.isNullOrNil((String)localObject2)) {
        ((ca)localObject3).BB((String)localObject2);
      }
      bg.aVF();
      long l = com.tencent.mm.model.c.aSQ().aC((ca)localObject3);
      if (l < 0L)
      {
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig insert msg failed :" + l);
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(31036);
        return 0 - paramInt;
        label586:
        bool = false;
        break;
        label592:
        localObject2 = com.tencent.mm.av.q.bcR().ap(paramWXMediaMessage.thumbData);
        break label318;
      }
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + l);
      ((ca)localObject3).setMsgId(l);
      localObject2 = new com.tencent.mm.ag.k();
      ((com.tencent.mm.ag.k)localObject2).field_xml = ((eo)localObject3).field_content;
      ((com.tencent.mm.ag.k)localObject2).field_title = paramWXMediaMessage.title;
      ((com.tencent.mm.ag.k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
      ((com.tencent.mm.ag.k)localObject2).field_description = paramWXMediaMessage.description;
      ((com.tencent.mm.ag.k)localObject2).field_msgId = l;
      ((com.tencent.mm.ag.k)localObject2).field_source = paramb.appName;
      ao.gnf().insert((IAutoDBItem)localObject2);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((com.tencent.mm.ag.k)localObject2).field_type) });
        ao.cgO().a((c)localObject1, new String[0]);
        if (!Util.isNullOrNil(paramString3)) {
          ao.gnh().P(((c)localObject1).field_msgInfoId, paramString3);
        }
        ao.gnh().run();
      }
      else
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((com.tencent.mm.ag.k)localObject2).field_type) });
        ao.gnh();
        an.a.a(l, paramString3, paramInt, parama);
      }
    }
    label900:
    AppMethodBeat.o(31036);
    return 0;
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
    localb.iwL = paramInt1;
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
          break label708;
        }
        if (paramb.type != 48) {
          break label642;
        }
        i = 0;
        j = 0;
        com.tencent.mm.ag.a locala = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
        if (locala == null) {
          break label671;
        }
        str = locala.imageUrl;
        label193:
        if (locala == null) {
          break label678;
        }
        bool = locala.ivh;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label684;
        }
        paramArrayOfByte = com.tencent.mm.av.q.bcR().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, str, bool);
      }
      final long l;
      for (;;)
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + paramArrayOfByte);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localca.Cz(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramArrayOfByte)));
        }
        if (localObject != null) {
          paramb.dCK = ((c)localObject).systemRowid;
        }
        localca.setContent(k.b.a(paramb, null, null));
        localca.setStatus(1);
        localca.Cy(paramString3);
        localca.setCreateTime(bp.Kw(paramString3));
        localca.nv(1);
        localca.setType(g(paramb));
        paramArrayOfByte = ((w)g.af(w.class)).Z(localca);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localca.BB(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.fqK });
        }
        if (paramb.type == 53) {
          localca.CJ((String)paramb.izx.first);
        }
        bg.aVF();
        l = com.tencent.mm.model.c.aSQ().aC(localca);
        if (paramb.type == 53)
        {
          paramArrayOfByte = new ns();
          paramArrayOfByte.dTP.type = 0;
          paramArrayOfByte.dTP.key = localca.fRd;
          paramArrayOfByte.dTP.username = localca.field_talker;
          paramArrayOfByte.dTQ.msgId = l;
          EventCenter.instance.publish(paramArrayOfByte);
        }
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label768;
        }
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label642:
        i = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        j = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        break;
        label671:
        str = "";
        break label193;
        label678:
        bool = false;
        break label205;
        label684:
        paramArrayOfByte = com.tencent.mm.av.q.bcR().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, str, bool);
        continue;
        label708:
        if (paramb.type != 46) {
          break label733;
        }
        paramArrayOfByte = com.tencent.mm.av.q.bcR().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label733:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = com.tencent.mm.av.q.bcR().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label768:
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      paramArrayOfByte = new com.tencent.mm.ag.k();
      paramArrayOfByte.field_xml = localca.field_content;
      paramArrayOfByte.field_appId = paramString1;
      paramArrayOfByte.field_title = paramb.title;
      paramArrayOfByte.field_type = paramb.type;
      paramArrayOfByte.field_description = paramb.description;
      paramArrayOfByte.field_msgId = l;
      paramArrayOfByte.field_source = paramString2;
      ao.gnf().insert(paramArrayOfByte);
      if (localObject == null)
      {
        bool = true;
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label1005;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ao.cgO().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!Util.isNullOrNil(paramString5))) {
          ao.gnh().P(l, paramString5);
        }
        ao.gnh().run();
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label1005:
        if ((paramb.iwM != 0) || (paramb.iwI > 26214400))
        {
          bg.azz().a(new com.tencent.mm.pluginsdk.g.c(paramb, paramString4, paramString3, new c.a()
          {
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
            {
              AppMethodBeat.i(232150);
              if (Util.isNullOrNil(paramAnonymousString4))
              {
                this.iBF.setStatus(5);
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(this.iBF.field_msgId, this.iBF);
                paramAnonymousString2 = new ca();
                paramAnonymousString2.setCreateTime(bp.Kw(paramAnonymousString2.field_talker));
                paramAnonymousString2.Cy(paramAnonymousString2.field_talker);
                paramAnonymousString2.setContent(paramAnonymousString1);
                paramAnonymousString2.setType(10000);
                paramAnonymousString2.setStatus(6);
                paramAnonymousString2.nv(0);
                bg.aVF();
                com.tencent.mm.model.c.aSQ().aC(paramAnonymousString2);
                AppMethodBeat.o(232150);
                return;
              }
              ao.gnh();
              an.a.f(l, this.lnN, paramAnonymousString4);
              AppMethodBeat.o(232150);
            }
          }), 0);
        }
        else
        {
          ao.gnh();
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
    localc.field_createTime = Util.nowMilliSecond();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.aKA()))
    {
      Log.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.iwI;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = Util.nowMilliSecond();
    ((c)localObject).field_lastModifyTime = Util.nowSecond();
    ((c)localObject).field_mediaSvrId = Util.nowMilliSecond();
    ((c)localObject).field_isUseCdn = 0;
    ao.cgO().insert((IAutoDBItem)localObject);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
      AppMethodBeat.o(31027);
      return null;
    }
    AppMethodBeat.o(31027);
    return localObject;
  }
  
  public static String a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2)
  {
    AppMethodBeat.i(232153);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.iwI = paramWXMediaMessage.fileData.length;
        paramb = cC(paramWXMediaMessage.fileData);
        AppMethodBeat.o(232153);
        return paramb;
      }
      paramb.iwI = ((int)s.boW(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.iwI);
      if (paramb.iwI > 0)
      {
        paramb.iwJ = s.akC(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(232153);
        return paramb;
      }
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.ahL(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.fileData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.iwI = paramWXMediaMessage.fileData.length;
        paramb = cC(paramWXMediaMessage.fileData);
        AppMethodBeat.o(232153);
        return paramb;
      }
      paramb.iwI = ((int)s.boW(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.iwI);
      if (paramb.iwI > 0)
      {
        paramb.iwJ = s.akC(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(232153);
        return paramb;
      }
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.iwI = paramWXMediaMessage.imageData.length;
        paramb = cC(paramWXMediaMessage.imageData);
        AppMethodBeat.o(232153);
        return paramb;
      }
      if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.iwI = ((int)s.boW(paramWXMediaMessage.imagePath));
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.iwI);
        if (paramb.iwI > 0)
        {
          paramb.iwJ = s.akC(paramWXMediaMessage.imagePath);
          bg.aVF();
          paramb = aa.z(new o(com.tencent.mm.model.c.aTg(), "appmsg_img_" + System.currentTimeMillis()).her());
          paramString1 = BitmapUtil.getImageOptions(paramWXMediaMessage.imagePath);
          if ((paramString1 == null) || (paramString1.outWidth <= 0) || (paramString1.outHeight <= 0))
          {
            boolean bool;
            int i;
            if (paramString1 == null)
            {
              bool = true;
              if (paramString1 != null) {
                break label857;
              }
              i = -1;
              label800:
              if (paramString1 != null) {
                break label866;
              }
            }
            label857:
            label866:
            for (int j = -1;; j = paramString1.outHeight)
            {
              Log.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(232153);
              return null;
              bool = false;
              break;
              i = paramString1.outWidth;
              break label800;
            }
          }
          if (z.f(paramWXMediaMessage.imagePath, "", true))
          {
            Log.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (s.nw(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              Log.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(232153);
              return null;
            }
            AppMethodBeat.o(232153);
            return paramb;
          }
          if ((paramString1.outWidth > 960) || (paramString1.outHeight > 960))
          {
            paramWXMediaMessage = BitmapUtil.extractThumbNail(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (s.nw(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              BitmapUtil.saveBitmapToImage(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(232153);
              return paramb;
            }
            catch (IOException paramb)
            {
              Log.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
              AppMethodBeat.o(232153);
              return null;
            }
            AppMethodBeat.o(232153);
            return null;
          }
          AppMethodBeat.o(232153);
          return null;
        }
        AppMethodBeat.o(232153);
        return null;
      }
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.iwH = paramWXMediaMessage.musicLowBandUrl;
      paramb.ixd = paramWXMediaMessage.musicDataUrl;
      paramb.ixe = paramWXMediaMessage.musicLowBandDataUrl;
      paramString1 = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString1.songAlbumUrl = paramWXMediaMessage.songAlbumUrl;
      paramString1.songLyric = paramWXMediaMessage.songLyric;
      paramb.a(paramString1);
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 76)
    {
      paramWXMediaMessage = (WXMusicVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.ixd = paramWXMediaMessage.musicDataUrl;
      paramString1 = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString1.songAlbumUrl = paramString2;
      paramString1.Ktr = paramWXMediaMessage.singerName;
      paramString1.Kts = paramWXMediaMessage.albumName;
      paramString1.songLyric = paramWXMediaMessage.songLyric;
      paramString1.Ktt = paramWXMediaMessage.musicGenre;
      paramString1.Ktu = String.valueOf(paramWXMediaMessage.issueDate);
      paramString1.Ktv = paramWXMediaMessage.identification;
      paramString1.Alz = paramWXMediaMessage.duration;
      paramString1.Ktw = paramb.messageExt;
      paramb.a(paramString1);
      AppMethodBeat.o(232153);
      return null;
    }
    if (paramb.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.videoUrl;
      paramb.iwH = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(232153);
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
        paramString1.xxN = paramWXMediaMessage.xxN;
        paramString1.jumpUrl = paramWXMediaMessage.jumpUrl;
        paramb.a(paramString1);
      }
      AppMethodBeat.o(232153);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.izi = paramWXMediaMessage.userName;
      paramb.izh = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.bAp() != null) {
          paramb.izA = paramWXMediaMessage.bAp().appVersion;
        }
        paramb.izB = paramWXMediaMessage.field_brandIconURL;
        Log.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.izA), paramb.izB });
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(232153);
        return null;
        if (paramb.type == 1)
        {
          paramb.title = ((WXTextObject)paramWXMediaMessage).text;
          AppMethodBeat.o(232153);
          return null;
        }
        if (paramb.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiData))
        {
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.iwI = paramWXMediaMessage.emojiData.length;
          paramb = cC(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(232153);
          return paramb;
        }
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.iwI = ((int)s.boW(paramWXMediaMessage.emojiPath));
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.iwI);
          if (paramb.iwI > 0)
          {
            paramb.iwJ = s.akC(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(232153);
            return paramb;
          }
          AppMethodBeat.o(232153);
          return null;
        }
        paramb.iwK = paramString1;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.ixp = paramWXMediaMessage.packageflag;
        paramb.ixo = paramWXMediaMessage.packageid;
        paramb.dDG = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(232153);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.ixp = paramWXMediaMessage.packageflag;
        paramb.ixo = paramWXMediaMessage.packageid;
        paramb.dDG = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(232153);
        return null;
      }
      if (paramb.type == 68)
      {
        paramWXMediaMessage = (WXLiteAppObject)paramWXMediaMessage;
        paramb.url = paramWXMediaMessage.webpageUrl;
        paramb.izu = paramWXMediaMessage.userName;
        paramb.izv = paramWXMediaMessage.path;
        paramb.izw = paramWXMediaMessage.query;
        paramb.dDG = 0;
        AppMethodBeat.o(232153);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.iyV = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.dDG = 18;
        AppMethodBeat.o(232153);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.iyW = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.dDG = 20;
    AppMethodBeat.o(232153);
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
    localc.field_createTime = Util.nowMilliSecond();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ao.cgO().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, Util.getStack() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  private static List<a.b> a(long paramLong, String paramString, anb paramanb)
  {
    AppMethodBeat.i(232152);
    List localList = Collections.synchronizedList(new ArrayList());
    Iterator localIterator = paramanb.ppH.iterator();
    while (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      if (localaml.LvI > 26214400L)
      {
        a.b localb = new a.b();
        String str = p.c(localaml, paramLong);
        paramanb = s.bhK(str);
        localb.toUser = paramString;
        localb.fileSize = localaml.LvI;
        localb.gCr = localaml.LvC;
        if (Util.isNullOrNil(localaml.LvE))
        {
          label121:
          localb.pkL = paramanb;
          localb.aesKey = localaml.Lvp;
          localb.fileName = localaml.title;
          if (!Util.isNullOrNil(localaml.LvL)) {
            break label189;
          }
        }
        label189:
        for (paramanb = str;; paramanb = localaml.LvL)
        {
          localb.filePath = paramanb;
          localList.add(localb);
          break;
          paramanb = localaml.LvE;
          break label121;
        }
      }
    }
    AppMethodBeat.o(232152);
    return localList;
  }
  
  public static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.HD(paramca.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramca.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((Util.isNullOrNil(((k.b)localObject).dCK)) && (!Util.isNullOrNil(((k.b)localObject).iwW)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramca.field_content });
      ((k.b)localObject).dCK = ((k.b)localObject).iwW.hashCode();
    }
    localObject = ((k.b)localObject).dCK;
    if ((!a(paramca, s((String)localObject, paramca.field_msgId))) && (e((String)localObject, paramca)))
    {
      BGq = new com.tencent.mm.plugin.record.b.f(paramca.field_msgId, (String)localObject, new j()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(31016);
          if (this.JWn != null) {
            this.JWn.kA(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(31016);
        }
      });
      bg.azz().a(BGq, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static boolean a(ca paramca, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!s.YS(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.deQ()) || ((paramca.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static String aB(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new o(paramString1);
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
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
        if (!aa.z(new o((String)localObject).heq().her()).equalsIgnoreCase(aa.z(new o(paramString1).her())))
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
    } while (!s.YS(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!s.YS(paramString1 + i + "_" + str1)) {
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
  
  public static Pair<Integer, Long> aS(ca paramca)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.HD(paramca.field_content);
    if (localObject5 == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = bdJ(((k.b)localObject5).dCK);
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
          bg.aVF();
          localObject1 = aB(com.tencent.mm.model.c.aTg(), ((k.b)localObject5).title, ((k.b)localObject5).iwJ);
          s.nw(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((paramca.field_imgPath != null) && (!paramca.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = s.aW((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (Util.isNullOrNil((String)localObject1)) {
          break label1087;
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
          break label700;
        }
        localObject3 = com.tencent.mm.av.q.bcR().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ca)localObject6).Cz((String)localObject3);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((k.b)localObject4).dCK = ((c)localObject1).systemRowid;
      }
      ((ca)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((ca)localObject6).setStatus(1);
      ((ca)localObject6).Cy(paramca.field_talker);
      ((ca)localObject6).setCreateTime(bp.Kw(paramca.field_talker));
      ((ca)localObject6).nv(1);
      ((ca)localObject6).setType(g((k.b)localObject4));
      localObject3 = ((w)g.af(w.class)).Z((ca)localObject6);
      if (!Util.isNullOrNil((String)localObject3))
      {
        ((ca)localObject6).BB((String)localObject3);
        Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((eo)localObject6).fqK });
      }
      if (((k.b)localObject4).type == 53) {
        ((ca)localObject6).CJ(paramca.fRd);
      }
      bg.aVF();
      long l = com.tencent.mm.model.c.aSQ().aC((ca)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new ns();
        ((ns)localObject3).dTP.type = 0;
        ((ns)localObject3).dTP.key = ((eo)localObject6).fRd;
        ((ns)localObject3).dTP.username = ((eo)localObject6).field_talker;
        ((ns)localObject3).dTQ.msgId = l;
        EventCenter.instance.publish((IEvent)localObject3);
      }
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
        paramca = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramca;
        label700:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = com.tencent.mm.av.q.bcR().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((ca)localObject6).setMsgId(l);
      localObject3 = new yl();
      ((yl)localObject3).eeI.eeJ = paramca.field_msgId;
      ((yl)localObject3).eeI.eeK = l;
      EventCenter.instance.publish((IEvent)localObject3);
      localObject3 = new com.tencent.mm.ag.k();
      ((com.tencent.mm.ag.k)localObject3).field_xml = ((eo)localObject6).field_content;
      ((com.tencent.mm.ag.k)localObject3).field_title = ((k.b)localObject4).title;
      ((com.tencent.mm.ag.k)localObject3).field_type = ((k.b)localObject4).type;
      ((com.tencent.mm.ag.k)localObject3).field_description = ((k.b)localObject4).description;
      ((com.tencent.mm.ag.k)localObject3).field_msgId = l;
      ((com.tencent.mm.ag.k)localObject3).field_source = ((String)localObject5);
      ao.gnf().insert((IAutoDBItem)localObject3);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ao.cgO().a((c)localObject1, new String[0]);
        ao.gnh().run();
      }
      for (;;)
      {
        paramca = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramca;
        if ((((k.b)localObject4).type == 24) || (((k.b)localObject4).type == 19))
        {
          localObject1 = p.aKY(((k.b)localObject4).ixl);
          localObject3 = new anb();
          if (localObject1 != null) {
            ((anb)localObject3).ppH.addAll(((com.tencent.mm.protocal.b.a.c)localObject1).iAd);
          }
          localObject5 = paramca.field_talker;
          List localList = a(l, (String)localObject5, (anb)localObject3);
          if (localList.size() > 0)
          {
            g.azz().a(new com.tencent.mm.pluginsdk.g.a(localList, new a.a()
            {
              public final void bS(int paramAnonymousInt, String paramAnonymousString)
              {
                AppMethodBeat.i(232151);
                if (paramAnonymousInt == 0)
                {
                  paramAnonymousString = new com.tencent.mm.plugin.record.a.k();
                  paramAnonymousString.field_msgId = this.dnZ;
                  paramAnonymousString.field_oriMsgId = this.JWo.field_msgId;
                  paramAnonymousString.field_toUser = this.dnJ;
                  paramAnonymousString.field_title = this.msv.title;
                  paramAnonymousString.field_desc = this.msv.description;
                  paramAnonymousString.field_dataProto = this.BHf;
                  paramAnonymousString.field_type = 0;
                  paramAnonymousString.field_favFrom = this.BHe.BGs;
                  paramAnonymousString.field_localId = (new Random().nextInt(2147483645) + 1);
                  Log.i("MicroMsg.AppMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramAnonymousString)), Long.valueOf(this.dnZ), Integer.valueOf(paramAnonymousString.field_localId) });
                  ((com.tencent.mm.plugin.record.a.a)g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramAnonymousString);
                  AppMethodBeat.o(232151);
                  return;
                }
                if (-3200 == paramAnonymousInt) {
                  Log.e("MicroMsg.AppMsgLogic", "why errCode equals %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
                }
                this.iBF.setStatus(5);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.dnZ, this.iBF);
                ca localca = new ca();
                localca.setCreateTime(this.iBF.field_createTime + 1L);
                localca.Cy(this.iBF.field_talker);
                localca.setContent(paramAnonymousString);
                localca.setType(10000);
                localca.setStatus(6);
                localca.nv(0);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
                AppMethodBeat.o(232151);
              }
            }), 0);
          }
          else
          {
            ao.gnh();
            an.a.HR(l);
          }
        }
        else
        {
          ao.gnh();
          an.a.HR(l);
        }
      }
      label1087:
      localObject1 = null;
    }
  }
  
  public static int ahM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static boolean bdH(String paramString)
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
  
  public static int bdI(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.HD(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!bdH(localb.dCK))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = Util.getLong(localb.dCK, -1L);
    if (l != -1L)
    {
      ao.cgO().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ao.cgO().bdx(localb.dCK);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.dCK)) {}
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
      localc = ao.cgO().bdx(localb.dCK);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.dCK)) {}
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
  
  public static c bdJ(String paramString)
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
      ao.cgO().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ao.cgO().bdx(paramString);
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
      localc2 = ao.cgO().bdx(paramString);
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
  
  public static c c(ca paramca, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = bdJ(paramString);
    if (localc == null)
    {
      E(paramca.field_msgId, paramca.field_content);
      paramca = bdJ(paramString);
      AppMethodBeat.o(31039);
      return paramca;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static String cC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = com.tencent.mm.model.c.aTg() + "ua_" + Util.nowMilliSecond();
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " buildUploadAttachInfo file:" + (String)localObject);
    if (s.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.apq() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
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
    Object localObject1 = s(paramString, paramca.field_msgId);
    Object localObject2 = k.b.HD(paramca.field_content);
    if (localObject2 != null)
    {
      str3 = af.nullAsNil(((k.b)localObject2).title);
      str4 = af.nullAsNil(((k.b)localObject2).iwJ).toLowerCase();
      str2 = af.nullAsNil(((k.b)localObject2).filemd5);
      str5 = af.nullAsNil(((k.b)localObject2).dRL);
      str1 = af.nullAsNil(((k.b)localObject2).aesKey);
    }
    if (localObject1 == null)
    {
      E(paramca.field_msgId, paramca.field_content);
      paramca = s(paramString, paramca.field_msgId);
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
          if (((k.b)localObject2).iwM == 0)
          {
            paramString = paramca;
            bool1 = bool2;
            if (((k.b)localObject2).iwI <= 26214400) {}
          }
          else
          {
            bool1 = false;
            paramString = paramca;
          }
        }
        if (!bool1) {
          bg.azz().a(new com.tencent.mm.plugin.record.b.d(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
      }
    }
    paramString = new o(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      E(paramca.field_msgId, paramca.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    paramca = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
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
    int j = paramb.dDG;
    int k = paramb.iwc;
    int m = paramb.ixf;
    int n = paramb.iyA;
    Log.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
    if (i == 76)
    {
      AppMethodBeat.o(31042);
      return 1040187441;
    }
    if ((i == 3) && (com.tencent.mm.plugin.music.model.m.akQ(paramb.appId)))
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
    com.tencent.mm.ag.a locala = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
    if ((locala != null) && (locala.iuQ) && ((paramb.izk == 2) || (paramb.izk == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.iuT) && (paramb.izk == 3))
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
    paramb = (e)paramb.as(e.class);
    if ((paramb != null) && (paramb.iwi != null))
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
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 973078577;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 973078577;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1006633009;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1006633009;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 956301361;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 956301361;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1023410225;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1023410225;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
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
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sai, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 989855793;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbx, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 989855793;
    switch (com.tencent.mm.plugin.i.a.l.d(paramb.izF, paramb.izD))
    {
    default: 
      AppMethodBeat.o(31042);
      return 49;
    case 100000000: 
      AppMethodBeat.o(31042);
      return 1023475761;
    case 1: 
      AppMethodBeat.o(31042);
      return 1023541297;
    }
    AppMethodBeat.o(31042);
    return 1057030193;
  }
  
  public static c s(String paramString, long paramLong)
  {
    AppMethodBeat.i(31024);
    c localc = bdJ(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ao.cgO().Mp(paramLong);
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
    public abstract void kA(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */