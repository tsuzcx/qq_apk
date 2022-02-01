package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
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
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static com.tencent.mm.plugin.record.b.f xqu;
  
  public static int Yv(int paramInt)
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
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().xY(paramLong);
    int i;
    if (localbu.field_msgId != paramLong)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.yr(localbu.field_content);
    if (localb == null)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    localb.dks = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label399;
      }
      str = localb.gjI;
      localb.gjI = str;
      if (!paramd.field_fileId.equals("")) {
        break label408;
      }
      str = localb.hAd;
      label198:
      localb.hAd = str;
      if (!paramd.field_filemd5.equals("")) {
        break label417;
      }
      str = localb.filemd5;
      label224:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label426;
      }
      i = localb.hzO;
      label247:
      localb.hzO = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label436;
      }
    }
    label399:
    label408:
    label417:
    label426:
    label436:
    for (String str = localb.hAe;; str = paramd.field_thumbUrl)
    {
      localb.hAe = str;
      localbu.setContent(k.b.a(localb, localb.dks, paramd));
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(localbu.field_msgId, localbu);
      paramd = ao.fag().xH(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbu.field_content;
        ao.fag().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = ao.bIX().CB(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        ao.bIX().a(paramd, new String[0]);
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
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).dFL = 1;
      paramb.a((com.tencent.mm.ai.f)localObject1);
    }
    Object localObject2 = b(paramb, paramWXMediaMessage, paramString2);
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.hzN + " attachlen:" + paramb.hzO + " attachid:" + paramb.dks + " attach file:" + (String)localObject2);
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
      localObject2 = com.tencent.mm.sdk.platformtools.g.aQc((String)localObject2);
      if (localObject2 != null)
      {
        paramb.thumbWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.thumbHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bu localbu = new bu();
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
        localObject2 = com.tencent.mm.aw.q.aIF().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label288:
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bt.isNullOrNil((String)localObject2)) {
          localbu.tO((String)localObject2);
        }
      }
      if (localObject1 != null) {
        paramb.dks = ((c)localObject1).systemRowid;
      }
      paramString1 = bt.U(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label870;
        }
        localObject2 = (String)paramString1.next();
        paramb.hzQ = paramString2;
        localbu.setContent(k.b.a(paramb, null, null));
        localbu.setStatus(1);
        localbu.tN((String)localObject2);
        localbu.qA(bj.Bo((String)localObject2));
        localbu.kr(1);
        localbu.setType(g(paramb));
        localObject2 = ((v)com.tencent.mm.kernel.g.ab(v.class)).Q(localbu);
        if (!bt.isNullOrNil((String)localObject2)) {
          localbu.sP((String)localObject2);
        }
        ba.aBQ();
        long l = com.tencent.mm.model.c.azs().as(localbu);
        if (l < 0L)
        {
          ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " summerbig insert msg failed :" + l);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(31036);
          return 0 - paramInt;
          label556:
          bool = false;
          break;
          label562:
          localObject2 = com.tencent.mm.aw.q.aIF().aa(paramWXMediaMessage.thumbData);
          break label288;
        }
        ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbu.setMsgId(l);
        localObject2 = new k();
        ((k)localObject2).field_xml = localbu.field_content;
        ((k)localObject2).field_title = paramWXMediaMessage.title;
        ((k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((k)localObject2).field_description = paramWXMediaMessage.description;
        ((k)localObject2).field_msgId = l;
        ((k)localObject2).field_source = paramb.appName;
        ao.fag().insert((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = l;
          ((c)localObject1).field_status = 101L;
          ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((k)localObject2).field_type) });
          ao.bIX().a((c)localObject1, new String[0]);
          if (!bt.isNullOrNil(paramString3)) {
            ao.fai().J(((c)localObject1).field_msgInfoId, paramString3);
          }
          ao.fai().run();
        }
        else
        {
          ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((k)localObject2).field_type) });
          ao.fai();
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
    localb.hzR = paramInt1;
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
      bu localbu = new bu();
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
        paramString4 = locala.hym;
        label193:
        if (locala == null) {
          break label669;
        }
        bool = locala.hyn;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label675;
        }
        paramString4 = com.tencent.mm.aw.q.aIF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, paramString4, bool);
      }
      long l;
      for (;;)
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " thumbData MsgInfo path:" + paramString4);
        if (!bt.isNullOrNil(paramString4))
        {
          localbu.tO(paramString4);
          ad.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramString4)));
        }
        if (localObject != null) {
          paramb.dks = ((c)localObject).systemRowid;
        }
        localbu.setContent(k.b.a(paramb, null, null));
        localbu.setStatus(1);
        localbu.tN(paramString3);
        localbu.qA(bj.Bo(paramString3));
        localbu.kr(1);
        localbu.setType(g(paramb));
        paramString3 = ((v)com.tencent.mm.kernel.g.ab(v.class)).Q(localbu);
        if (!bt.isNullOrNil(paramString3))
        {
          localbu.sP(paramString3);
          ad.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbu.eLs });
        }
        if (paramb.type == 53) {
          localbu.tY((String)paramb.hCx.first);
        }
        ba.aBQ();
        l = com.tencent.mm.model.c.azs().as(localbu);
        if (paramb.type == 53)
        {
          paramString3 = new na();
          paramString3.dAV.type = 0;
          paramString3.dAV.key = localbu.fkC;
          paramString3.dAV.username = localbu.field_talker;
          paramString3.dAW.msgId = l;
          com.tencent.mm.sdk.b.a.IbL.l(paramString3);
        }
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label759;
        }
        ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        label633:
        i = (int)(com.tencent.mm.sdk.platformtools.g.aQF().density * 240.0F);
        j = (int)(com.tencent.mm.sdk.platformtools.g.aQF().density * 240.0F);
        break;
        label662:
        paramString4 = "";
        break label193;
        label669:
        bool = false;
        break label205;
        label675:
        paramString4 = com.tencent.mm.aw.q.aIF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, paramString4, bool);
        continue;
        label699:
        if (paramb.type != 46) {
          break label724;
        }
        paramString4 = com.tencent.mm.aw.q.aIF().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label724:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString4 = com.tencent.mm.aw.q.aIF().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label759:
      ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbu.setMsgId(l);
      paramString3 = new k();
      paramString3.field_xml = localbu.field_content;
      paramString3.field_appId = paramString1;
      paramString3.field_title = paramb.title;
      paramString3.field_type = paramb.type;
      paramString3.field_description = paramb.description;
      paramString3.field_msgId = l;
      paramString3.field_source = paramString2;
      ao.fag().insert(paramString3);
      if (localObject == null)
      {
        bool = true;
        ad.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label987;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        ao.bIX().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!bt.isNullOrNil(paramString5))) {
          ao.fai().J(l, paramString5);
        }
        ao.fai().run();
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31032);
        return paramb;
        bool = false;
        break;
        label987:
        ao.fai();
        an.a.f(l, paramString5, paramString6);
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
    localc.field_createTime = bt.flT();
    localc.field_lastModifyTime = bt.aQJ();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.arL()))
    {
      ad.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.hzO;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = bt.flT();
    ((c)localObject).field_lastModifyTime = bt.aQJ();
    ((c)localObject).field_mediaSvrId = bt.flT();
    ((c)localObject).field_isUseCdn = 0;
    ao.bIX().insert((com.tencent.mm.sdk.e.c)localObject);
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
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
    localc.field_createTime = bt.flT();
    localc.field_lastModifyTime = bt.aQJ();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ao.bIX().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bt.flS() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  private static List<a.b> a(long paramLong, String paramString, akd paramakd)
  {
    AppMethodBeat.i(193411);
    List localList = Collections.synchronizedList(new ArrayList());
    Iterator localIterator = paramakd.nZa.iterator();
    while (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      if (localajn.Ghm > 26214400L)
      {
        a.b localb = new a.b();
        String str = p.c(localajn, paramLong);
        paramakd = com.tencent.mm.vfs.i.aPK(str);
        localb.toUser = paramString;
        localb.fileSize = localajn.Ghm;
        localb.fVf = localajn.Ghg;
        if (bt.isNullOrNil(localajn.Ghi))
        {
          label121:
          localb.nUg = paramakd;
          localb.gjI = localajn.GgT;
          localb.fileName = localajn.title;
          if (!bt.isNullOrNil(localajn.Ghp)) {
            break label189;
          }
        }
        label189:
        for (paramakd = str;; paramakd = localajn.Ghp)
        {
          localb.filePath = paramakd;
          localList.add(localb);
          break;
          paramakd = localajn.Ghi;
          break label121;
        }
      }
    }
    AppMethodBeat.o(193411);
    return localList;
  }
  
  public static void a(bu parambu, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.yr(parambu.field_content);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambu.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((bt.isNullOrNil(((k.b)localObject).dks)) && (!bt.isNullOrNil(((k.b)localObject).hAd)))
    {
      ad.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambu.field_content });
      ((k.b)localObject).dks = ((k.b)localObject).hAd.hashCode();
    }
    localObject = ((k.b)localObject).dks;
    if ((!a(parambu, r((String)localObject, parambu.field_msgId))) && (e((String)localObject, parambu)))
    {
      xqu = new com.tencent.mm.plugin.record.b.f(parambu.field_msgId, (String)localObject, new com.tencent.mm.al.g()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(31016);
          if (this.EMZ != null) {
            this.EMZ.jk(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(31016);
        }
      });
      ba.aiU().a(xqu, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static boolean a(bu parambu, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!com.tencent.mm.vfs.i.fv(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.cWz()) || ((parambu.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static Pair<Integer, Long> aG(bu parambu)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.yr(parambu.field_content);
    if (localObject5 == null)
    {
      ad.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = aLN(((k.b)localObject5).dks);
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
          ba.aBQ();
          localObject1 = aq(com.tencent.mm.model.c.azI(), ((k.b)localObject5).title, ((k.b)localObject5).hzP);
          com.tencent.mm.vfs.i.mz(((c)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambu.field_imgPath != null) && (!parambu.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = com.tencent.mm.vfs.i.aY((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (bt.isNullOrNil((String)localObject1)) {
          break label1087;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        parambu = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return parambu;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new bu();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label700;
        }
        localObject3 = com.tencent.mm.aw.q.aIF().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((bu)localObject6).tO((String)localObject3);
          ad.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((k.b)localObject4).dks = ((c)localObject1).systemRowid;
      }
      ((bu)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((bu)localObject6).setStatus(1);
      ((bu)localObject6).tN(parambu.field_talker);
      ((bu)localObject6).qA(bj.Bo(parambu.field_talker));
      ((bu)localObject6).kr(1);
      ((bu)localObject6).setType(g((k.b)localObject4));
      localObject3 = ((v)com.tencent.mm.kernel.g.ab(v.class)).Q((bu)localObject6);
      if (!bt.isNullOrNil((String)localObject3))
      {
        ((bu)localObject6).sP((String)localObject3);
        ad.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((ei)localObject6).eLs });
      }
      if (((k.b)localObject4).type == 53) {
        ((bu)localObject6).tY(parambu.fkC);
      }
      ba.aBQ();
      long l = com.tencent.mm.model.c.azs().as((bu)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new na();
        ((na)localObject3).dAV.type = 0;
        ((na)localObject3).dAV.key = ((ei)localObject6).fkC;
        ((na)localObject3).dAV.username = ((ei)localObject6).field_talker;
        ((na)localObject3).dAW.msgId = l;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
      }
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + "insert msg failed :" + l);
        parambu = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambu;
        label700:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = com.tencent.mm.aw.q.aIF().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      ad.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bu)localObject6).setMsgId(l);
      localObject3 = new xg();
      ((xg)localObject3).dLB.dLC = parambu.field_msgId;
      ((xg)localObject3).dLB.dLD = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
      localObject3 = new k();
      ((k)localObject3).field_xml = ((ei)localObject6).field_content;
      ((k)localObject3).field_title = ((k.b)localObject4).title;
      ((k)localObject3).field_type = ((k.b)localObject4).type;
      ((k)localObject3).field_description = ((k.b)localObject4).description;
      ((k)localObject3).field_msgId = l;
      ((k)localObject3).field_source = ((String)localObject5);
      ao.fag().insert((com.tencent.mm.sdk.e.c)localObject3);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        ao.bIX().a((c)localObject1, new String[0]);
        ao.fai().run();
      }
      for (;;)
      {
        parambu = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return parambu;
        if ((((k.b)localObject4).type == 24) || (((k.b)localObject4).type == 19))
        {
          localObject1 = p.avr(((k.b)localObject4).hAs);
          localObject3 = new akd();
          if (localObject1 != null) {
            ((akd)localObject3).nZa.addAll(((com.tencent.mm.protocal.b.a.c)localObject1).hDb);
          }
          localObject5 = parambu.field_talker;
          List localList = a(l, (String)localObject5, (akd)localObject3);
          if (localList.size() > 0)
          {
            com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.pluginsdk.g.a(localList, new m.2(l, parambu, (String)localObject5, (k.b)localObject4, (akd)localObject3, (com.tencent.mm.protocal.b.a.c)localObject1, (bu)localObject6)), 0);
          }
          else
          {
            ao.fai();
            an.a.yC(l);
          }
        }
        else
        {
          ao.fai();
          an.a.yC(l);
        }
      }
      label1087:
      localObject1 = null;
    }
  }
  
  public static boolean aLL(String paramString)
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
  
  public static int aLM(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.yr(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!aLL(localb.dks))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = bt.getLong(localb.dks, -1L);
    if (l != -1L)
    {
      ao.bIX().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = ao.bIX().aLD(localb.dks);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.dks)) {}
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
      localc = ao.bIX().aLD(localb.dks);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.dks)) {}
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
  
  public static c aLN(String paramString)
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
      ao.bIX().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = ao.bIX().aLD(paramString);
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
      localc2 = ao.bIX().aLD(paramString);
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
  
  public static String aq(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new com.tencent.mm.vfs.e(paramString1);
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    String str1;
    String str2;
    if (bt.isNullOrNil(paramString2))
    {
      str1 = paramString1 + "da_" + bt.flT();
      localObject = str1;
      str2 = paramString2;
      if (!bt.isNullOrNil(paramString3))
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
        if (!com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((String)localObject).fOJ().fOK()).equalsIgnoreCase(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString1).fOK())))
        {
          localObject = paramString1 + "da_" + bt.flT();
          paramString2 = (String)localObject;
          if (!bt.isNullOrNil(str2)) {
            paramString2 = (String)localObject + str2;
          }
          localObject = paramString2;
          if (!bt.isNullOrNil(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
          ad.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
          paramString2 = (String)localObject;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bt.flT();
          paramString2 = paramString1;
          if (!bt.isNullOrNil(paramString3)) {
            paramString2 = paramString1 + "." + paramString3;
          }
        }
      }
      AppMethodBeat.o(31031);
      return paramString2;
      str1 = paramString2;
      if (!bt.isNullOrNil(paramString3))
      {
        str1 = paramString2;
        if (!paramString2.endsWith(paramString3)) {
          str1 = paramString2 + "." + paramString3;
        }
      }
      paramString2 = paramString1 + str1;
      localObject = paramString2;
      str2 = str1;
    } while (!com.tencent.mm.vfs.i.fv(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!com.tencent.mm.vfs.i.fv(paramString1 + i + "_" + str1)) {
          localObject = paramString1 + i + "_" + str1;
        }
      }
      else
      {
        str2 = str1;
        if (i != 20) {
          break;
        }
        paramString2 = paramString1 + "da_" + bt.flT();
        localObject = paramString2;
        str2 = str1;
        if (bt.isNullOrNil(paramString3)) {
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
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
      if (!bt.cC(paramWXMediaMessage.fileData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hzO = paramWXMediaMessage.fileData.length;
        paramb = ci(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hzO = ((int)com.tencent.mm.vfs.i.aYo(paramWXMediaMessage.filePath));
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hzO);
      if (paramb.hzO > 0)
      {
        paramb.hzP = com.tencent.mm.vfs.i.ZF(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(31038);
        return paramb;
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.Yu(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(31038);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bt.cC(paramWXMediaMessage.fileData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.hzO = paramWXMediaMessage.fileData.length;
        paramb = ci(paramWXMediaMessage.fileData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      paramb.hzO = ((int)com.tencent.mm.vfs.i.aYo(paramWXMediaMessage.filePath));
      ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.hzO);
      if (paramb.hzO > 0)
      {
        paramb.hzP = com.tencent.mm.vfs.i.ZF(paramWXMediaMessage.filePath);
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
      if (!bt.cC(paramWXMediaMessage.imageData))
      {
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.hzO = paramWXMediaMessage.imageData.length;
        paramb = ci(paramWXMediaMessage.imageData);
        AppMethodBeat.o(31038);
        return paramb;
      }
      if (!bt.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.hzO = ((int)com.tencent.mm.vfs.i.aYo(paramWXMediaMessage.imagePath));
        ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.hzO);
        if (paramb.hzO > 0)
        {
          paramb.hzP = com.tencent.mm.vfs.i.ZF(paramWXMediaMessage.imagePath);
          ba.aBQ();
          paramb = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(com.tencent.mm.model.c.azI(), "appmsg_img_" + System.currentTimeMillis()).fOK());
          paramString = com.tencent.mm.sdk.platformtools.g.aQc(paramWXMediaMessage.imagePath);
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
            if (com.tencent.mm.vfs.i.mz(paramWXMediaMessage.imagePath, paramb) < 0L)
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
            paramWXMediaMessage = com.tencent.mm.sdk.platformtools.g.d(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (com.tencent.mm.vfs.i.mz(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.g.a(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
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
      paramb.hzN = paramWXMediaMessage.musicLowBandUrl;
      paramb.hAk = paramWXMediaMessage.musicDataUrl;
      paramb.hAl = paramWXMediaMessage.musicLowBandDataUrl;
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
      paramb.hzN = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 5) || (paramb.type == 54) || (paramb.type == 69))
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!bt.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bt.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      if ((paramb.type == 69) && ((paramWXMediaMessage instanceof com.tencent.mm.plugin.game.luggage.e.b)))
      {
        paramWXMediaMessage = (com.tencent.mm.plugin.game.luggage.e.b)paramWXMediaMessage;
        paramString = new com.tencent.mm.plugin.game.luggage.e.a();
        paramString.iconUrl = paramWXMediaMessage.iconUrl;
        paramString.bVF = paramWXMediaMessage.bVF;
        paramString.desc = paramWXMediaMessage.desc;
        paramString.tUK = paramWXMediaMessage.tUK;
        paramString.jumpUrl = paramWXMediaMessage.jumpUrl;
        paramb.a(paramString);
      }
      AppMethodBeat.o(31038);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.hCn = paramWXMediaMessage.userName;
      paramb.hCm = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.ben() != null) {
          paramb.hCA = paramWXMediaMessage.ben().aDD;
        }
        paramb.hCB = paramWXMediaMessage.field_brandIconURL;
        ad.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.hCA), paramb.hCB });
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
        if (!bt.cC(paramWXMediaMessage.emojiData))
        {
          ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.hzO = paramWXMediaMessage.emojiData.length;
          paramb = ci(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(31038);
          return paramb;
        }
        if (!bt.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.hzO = ((int)com.tencent.mm.vfs.i.aYo(paramWXMediaMessage.emojiPath));
          ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.hzO);
          if (paramb.hzO > 0)
          {
            paramb.hzP = com.tencent.mm.vfs.i.ZF(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(31038);
            return paramb;
          }
          AppMethodBeat.o(31038);
          return null;
        }
        paramb.hzQ = paramString;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hAw = paramWXMediaMessage.packageflag;
        paramb.hAv = paramWXMediaMessage.packageid;
        paramb.dlp = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.hAw = paramWXMediaMessage.packageflag;
        paramb.hAv = paramWXMediaMessage.packageid;
        paramb.dlp = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(31038);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.hCb = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.dlp = 18;
        AppMethodBeat.o(31038);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.hCc = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.dlp = 20;
    AppMethodBeat.o(31038);
    return null;
  }
  
  public static c c(bu parambu, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = aLN(paramString);
    if (localc == null)
    {
      y(parambu.field_msgId, parambu.field_content);
      parambu = aLN(paramString);
      AppMethodBeat.o(31039);
      return parambu;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static String ci(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = com.tencent.mm.model.c.azI() + "ua_" + bt.flT();
    ad.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " buildUploadAttachInfo file:" + (String)localObject);
    if (com.tencent.mm.vfs.i.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      ad.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.abi() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static boolean e(String paramString, bu parambu)
  {
    AppMethodBeat.i(31023);
    if (parambu == null)
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
    Object localObject1 = r(paramString, parambu.field_msgId);
    Object localObject2 = k.b.yr(parambu.field_content);
    if (localObject2 != null)
    {
      str3 = af.nullAsNil(((k.b)localObject2).title);
      str4 = af.nullAsNil(((k.b)localObject2).hzP).toLowerCase();
      str2 = af.nullAsNil(((k.b)localObject2).filemd5);
      str5 = af.nullAsNil(((k.b)localObject2).dyU);
      str1 = af.nullAsNil(((k.b)localObject2).gjI);
    }
    if (localObject1 == null)
    {
      y(parambu.field_msgId, parambu.field_content);
      parambu = r(paramString, parambu.field_msgId);
      paramString = parambu;
      bool1 = bool2;
      if (parambu != null)
      {
        l1 = parambu.systemRowid;
        l2 = parambu.field_totalLen;
        paramString = parambu.field_fileFullPath;
        l3 = parambu.field_type;
        localObject1 = parambu.field_mediaId;
        l4 = parambu.field_msgInfoId;
        bool1 = parambu.field_isUpload;
        if (parambu.field_signature != null) {
          break label343;
        }
      }
      label343:
      for (i = -1;; i = parambu.field_signature.length())
      {
        ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambu;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).hzS == 0)
          {
            paramString = parambu;
            bool1 = bool2;
            if (((k.b)localObject2).hzO <= 26214400) {}
          }
          else
          {
            bool1 = false;
            paramString = parambu;
          }
        }
        if (!bool1) {
          ba.aiU().a(new com.tencent.mm.plugin.record.b.d(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
      }
    }
    paramString = new com.tencent.mm.vfs.e(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      y(parambu.field_msgId, parambu.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    parambu = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambu, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
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
    int j = paramb.dlp;
    int k = paramb.hzh;
    int m = paramb.hAm;
    int n = paramb.hBG;
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
    com.tencent.mm.ai.a locala = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
    if ((locala != null) && (locala.hxV) && ((paramb.hCp == 2) || (paramb.hCp == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.hxY) && (paramb.hCp == 3))
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
    if ((paramb != null) && (paramb.hzo != null))
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
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzG, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 1)
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
    c localc = aLN(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = ao.bIX().CB(paramLong);
    }
    if (paramString != null) {
      ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bt.flS() });
    }
    for (;;)
    {
      AppMethodBeat.o(31024);
      return paramString;
      ad.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bt.flS() });
    }
  }
  
  public static String y(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.yr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aq(com.tencent.mm.loader.j.b.arX(), paramString.title, paramString.hzP);
    if ((bt.isNullOrNil(paramString.dks)) && (!bt.isNullOrNil(paramString.hAd))) {
      paramString.dks = paramString.hAd.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dks, paramString.hzO, paramString.type, paramString.hzS);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static void yD(long paramLong)
  {
    AppMethodBeat.i(31018);
    ao.bIX().CA(paramLong);
    c localc = new c();
    ao.bIX().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().xY(localc.field_msgInfoId);
    if (localbu.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(31018);
      return;
    }
    localbu.setStatus(5);
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(localbu.field_msgId, localbu);
    AppMethodBeat.o(31018);
  }
  
  public static abstract interface a
  {
    public abstract void jk(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */