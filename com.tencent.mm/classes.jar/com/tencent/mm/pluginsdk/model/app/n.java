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
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.abo;
import com.tencent.mm.autogen.a.pz;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
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
import com.tencent.mm.opensdk.modelmsg.WXMusicVipInfo;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.pluginsdk.h.a.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class n
{
  private static g NzY;
  
  public static int a(long paramLong, String paramString, com.tencent.mm.g.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31028);
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(paramLong);
    int i;
    if ((localcc == null) || (localcc.field_msgId != paramLong))
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    k.b localb = k.b.Hf(localcc.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(31028);
      return 0 - i;
    }
    if ((localb.type == 6) && (localcc.getType() == 10000))
    {
      Log.e("MicroMsg.AppMsgLogic", "rebuildXMLAtUploadFin: stop send revoke msg(%s)", new Object[] { Long.valueOf(localcc.field_msgId) });
      AppMethodBeat.o(31028);
      return -1;
    }
    localb.hzM = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label455;
      }
      str = localb.aesKey;
      localb.aesKey = str;
      if (!paramd.field_fileId.equals("")) {
        break label464;
      }
      str = localb.nRq;
      label254:
      localb.nRq = str;
      if (!paramd.field_filemd5.equals("")) {
        break label473;
      }
      str = localb.filemd5;
      label280:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0L) {
        break label482;
      }
      i = localb.nRd;
      label303:
      localb.nRd = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label492;
      }
    }
    label455:
    label464:
    label473:
    label482:
    label492:
    for (String str = localb.nRr;; str = paramd.field_thumbUrl)
    {
      localb.nRr = str;
      localcc.setContent(k.b.a(localb, localb.hzM, paramd));
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(localcc.field_msgId, localcc);
      paramd = as.iIJ().rI(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localcc.field_content;
        as.iIJ().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = as.cWJ().yi(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        as.cWJ().a(paramd, new String[0]);
      }
      AppMethodBeat.o(31028);
      return 0;
      str = paramd.field_aesKey;
      break;
      str = paramd.field_fileId;
      break label254;
      str = paramd.field_filemd5;
      break label280;
      i = (int)paramd.field_fileLength;
      break label303;
    }
  }
  
  public static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31035);
    paramInt = a(paramb, paramWXMediaMessage, paramString, null, paramInt, parama);
    AppMethodBeat.o(31035);
    return paramInt;
  }
  
  private static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(244987);
    paramInt = a(paramb, paramWXMediaMessage, paramString1, null, null, paramInt, parama, null);
    AppMethodBeat.o(244987);
    return paramInt;
  }
  
  private static int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, a parama, Map<String, Long> paramMap)
  {
    AppMethodBeat.i(244994);
    if (paramInt == 1)
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.tools.c();
      ((com.tencent.mm.pluginsdk.ui.tools.c)localObject1).hYn = 1;
      paramb.a((com.tencent.mm.message.f)localObject1);
    }
    Object localObject1 = "";
    if (parama != null) {
      localObject1 = parama.mOI;
    }
    Object localObject2 = a(paramb, paramWXMediaMessage, paramString2, (String)localObject1);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.nRc + " attachlen:" + paramb.nRd + " attachid:" + paramb.hzM + " attach file:" + (String)localObject2);
    localObject1 = System.currentTimeMillis();
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(244994);
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
      cc localcc = new cc();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 65536) || (paramWXMediaMessage.getType() == 36) || (paramWXMediaMessage.getType() == 46)) {
          break label670;
        }
        if (paramb.type != 2) {
          break label664;
        }
        bool = true;
        localObject2 = b(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG, false);
        label306:
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          localcc.BT((String)localObject2);
        }
      }
      if (localObject1 != null)
      {
        paramb.hzM = ((c)localObject1).systemRowid;
        if ((paramb.type == 6) && (Util.isNullOrNil(paramb.filemd5)))
        {
          com.tencent.mm.modelcdntran.k.bHX();
          paramb.filemd5 = com.tencent.mm.modelcdntran.d.Ns(((c)localObject1).field_fileFullPath);
        }
      }
      paramb.nRf = paramString2;
      localcc.setContent(k.b.a(paramb, null, null));
      localcc.setStatus(1);
      localcc.pI(1);
      localcc.setType(h(paramb));
      paramString2 = Util.stringsToList(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString2.hasNext()) {
          break label1023;
        }
        paramString1 = (String)paramString2.next();
        localcc.BS(paramString1);
        localcc.setCreateTime(br.JN(paramString1));
        localObject2 = ((aa)com.tencent.mm.kernel.h.ax(aa.class)).ak(localcc);
        if (!Util.isNullOrNil((String)localObject2)) {
          localcc.AU((String)localObject2);
        }
        long l;
        if (paramMap != null)
        {
          l = ((Long)paramMap.get(paramString1)).longValue();
          label556:
          paramString1 = Long.valueOf(l);
          if ((paramString1 == null) || (paramString1.longValue() < 0L)) {
            break label695;
          }
          Log.i("MicroMsg.AppMsgLogic", "sendAppMsg, updateById, existMsgId:%d ", new Object[] { paramString1 });
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramString1.longValue(), localcc);
        }
        for (;;)
        {
          if (paramString1.longValue() >= 0L) {
            break label716;
          }
          Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " summerbig insert msg failed :" + paramString1);
          paramInt = com.tencent.mm.compatible.util.f.getLine();
          AppMethodBeat.o(244994);
          return 0 - paramInt;
          label664:
          bool = false;
          break;
          label670:
          localObject2 = b(paramWXMediaMessage.thumbData, false, Bitmap.CompressFormat.JPEG, true);
          break label306;
          l = -1L;
          break label556;
          label695:
          bh.bCz();
          paramString1 = Long.valueOf(com.tencent.mm.model.c.bzD().ba(localcc));
        }
        label716:
        Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " summerbig new msg inserted to db , local id = " + paramString1);
        localcc.setMsgId(paramString1.longValue());
        localObject2 = new com.tencent.mm.message.k();
        ((com.tencent.mm.message.k)localObject2).field_xml = localcc.field_content;
        ((com.tencent.mm.message.k)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.message.k)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.message.k)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.message.k)localObject2).field_msgId = paramString1.longValue();
        ((com.tencent.mm.message.k)localObject2).field_source = paramb.appName;
        as.iIJ().insert((IAutoDBItem)localObject2);
        if (localObject1 != null)
        {
          ((c)localObject1).field_msgInfoId = paramString1.longValue();
          ((c)localObject1).field_status = 101L;
          Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((c)localObject1).field_msgInfoId), Long.valueOf(((c)localObject1).field_status), Long.valueOf(((c)localObject1).systemRowid), Integer.valueOf(((com.tencent.mm.message.k)localObject2).field_type) });
          as.cWJ().a((c)localObject1, new String[0]);
          if (!Util.isNullOrNil(paramString3)) {
            as.iIL().ao(((c)localObject1).field_msgInfoId, paramString3);
          }
          b(localcc, (c)localObject1);
        }
        else
        {
          Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, paramString1, paramString3, Integer.valueOf(((com.tencent.mm.message.k)localObject2).field_type) });
          as.iIL();
          l = paramString1.longValue();
          localcc.getType();
          ar.a.a(l, paramString3, paramInt, parama);
        }
      }
      label1023:
      AppMethodBeat.o(244994);
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
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, a parama, Map<String, Long> paramMap)
  {
    AppMethodBeat.i(244982);
    k.b localb = new k.b();
    localb.appId = paramString1;
    localb.appName = paramString2;
    localb.nRg = paramInt1;
    paramInt1 = a(localb, paramWXMediaMessage, paramString3, paramString4, paramString5, paramInt2, parama, paramMap);
    AppMethodBeat.o(244982);
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
    paramb = a(paramb, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramString5, paramString6, "");
    AppMethodBeat.o(31032);
    return paramb;
  }
  
  public static Pair<Integer, Long> a(k.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(244971);
    Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    if (!Util.isNullOrNil(paramString4))
    {
      localObject = a((String)localObject, paramb, paramString4);
      if (localObject == null)
      {
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(244971);
        return paramb;
      }
    }
    for (;;)
    {
      cc localcc = new cc();
      int i;
      int j;
      String str;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 44) && (paramb.type != 48)) {
          break label750;
        }
        if (paramb.type != 48) {
          break label684;
        }
        i = 0;
        j = 0;
        com.tencent.mm.message.a locala = (com.tencent.mm.message.a)paramb.aK(com.tencent.mm.message.a.class);
        if (locala == null) {
          break label713;
        }
        str = locala.imageUrl;
        label193:
        if (locala == null) {
          break label720;
        }
        bool = locala.nPc;
        label205:
        if ((paramb.type == 44) || (paramb.type == 48)) {
          break label726;
        }
        paramArrayOfByte = r.bKa().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, str, bool);
      }
      long l;
      for (;;)
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " thumbData MsgInfo path:" + paramArrayOfByte);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localcc.BT(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramArrayOfByte)));
        }
        if (localObject != null)
        {
          paramb.hzM = ((c)localObject).systemRowid;
          if ((paramb.type == 6) && (Util.isNullOrNil(paramb.filemd5)))
          {
            com.tencent.mm.modelcdntran.k.bHX();
            paramb.filemd5 = com.tencent.mm.modelcdntran.d.Ns(((c)localObject).field_fileFullPath);
          }
        }
        localcc.setContent(k.b.a(paramb, null, null));
        localcc.setStatus(1);
        localcc.BS(paramString3);
        localcc.setCreateTime(br.JN(paramString3));
        localcc.pI(1);
        localcc.setType(h(paramb));
        localcc.AU(bt.JW(paramString7));
        paramArrayOfByte = ((aa)com.tencent.mm.kernel.h.ax(aa.class)).ak(localcc);
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          localcc.AU(paramArrayOfByte);
          Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localcc.jUr });
        }
        if (paramb.type == 53) {
          localcc.Cd((String)paramb.nTT.first);
        }
        bh.bCz();
        l = com.tencent.mm.model.c.bzD().ba(localcc);
        if (paramb.type == 53)
        {
          paramArrayOfByte = new pz();
          paramArrayOfByte.hTe.type = 0;
          paramArrayOfByte.hTe.key = localcc.kLs;
          paramArrayOfByte.hTe.username = localcc.field_talker;
          paramArrayOfByte.hTf.msgId = l;
          paramArrayOfByte.publish();
        }
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label808;
        }
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
        paramb = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(244971);
        return paramb;
        label684:
        i = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        j = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 240.0F);
        break;
        label713:
        str = "";
        break label193;
        label720:
        bool = false;
        break label205;
        label726:
        paramArrayOfByte = r.bKa().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, str, bool);
        continue;
        label750:
        if (paramb.type != 46) {
          break label775;
        }
        paramArrayOfByte = r.bKa().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label775:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = b(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG, false);
        break;
      }
      label808:
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localcc.setMsgId(l);
      paramArrayOfByte = new com.tencent.mm.message.k();
      paramArrayOfByte.field_xml = localcc.field_content;
      paramArrayOfByte.field_appId = paramString1;
      paramArrayOfByte.field_title = paramb.title;
      paramArrayOfByte.field_type = paramb.type;
      paramArrayOfByte.field_description = paramb.description;
      paramArrayOfByte.field_msgId = l;
      paramArrayOfByte.field_source = paramString2;
      as.iIJ().insert(paramArrayOfByte);
      if (localObject == null)
      {
        bool = true;
        Log.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label1046;
        }
        ((c)localObject).field_msgInfoId = l;
        ((c)localObject).field_status = 101L;
        as.cWJ().a((c)localObject, new String[0]);
        if ((paramb.type == 2) || (!Util.isNullOrNil(paramString5))) {
          as.iIL().ao(l, paramString5);
        }
        b(localcc, (c)localObject);
      }
      for (;;)
      {
        paramb = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(244971);
        return paramb;
        bool = false;
        break;
        label1046:
        if ((paramb.nRh != 0) || (paramb.nRd > 26214400))
        {
          bh.aZW().a(new com.tencent.mm.pluginsdk.h.c(paramb, paramString4, paramString3, new n.6(localcc, l, paramString5)), 0);
        }
        else
        {
          as.iIL();
          localcc.getType();
          ar.a.j(l, paramString5, paramString6);
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
    localc.field_createTime = cn.bDu();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    AppMethodBeat.o(31026);
    return localc;
  }
  
  public static c a(String paramString1, k.b paramb, String paramString2)
  {
    AppMethodBeat.i(31027);
    Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.loader.i.b.bmq()))
    {
      Log.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(31027);
      return null;
    }
    localObject = new c();
    ((c)localObject).field_totalLen = paramb.nRd;
    ((c)localObject).field_fileFullPath = paramString2;
    ((c)localObject).field_sdkVer = paramb.sdkVer;
    ((c)localObject).field_appId = paramb.appId;
    ((c)localObject).field_clientAppDataId = paramString1;
    ((c)localObject).field_type = paramb.type;
    ((c)localObject).field_status = 200L;
    ((c)localObject).field_isUpload = true;
    ((c)localObject).field_createTime = cn.bDu();
    ((c)localObject).field_lastModifyTime = Util.nowSecond();
    ((c)localObject).field_mediaSvrId = Util.nowMilliSecond();
    ((c)localObject).field_isUseCdn = 0;
    as.cWJ().insert((IAutoDBItem)localObject);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " summerbig buildUploadAttachInfo file:" + ((c)localObject).field_fileFullPath + " rowid:" + ((c)localObject).systemRowid + " clientAppDataId:" + ((c)localObject).field_clientAppDataId);
    if (((c)localObject).systemRowid < 0L)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " summerbig uploadAttach insert appattach info failed :" + ((c)localObject).systemRowid);
      AppMethodBeat.o(31027);
      return null;
    }
    AppMethodBeat.o(31027);
    return localObject;
  }
  
  public static String a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(244999);
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.nRd = paramWXMediaMessage.fileData.length;
        paramb = cW(paramWXMediaMessage.fileData);
        AppMethodBeat.o(244999);
        return paramb;
      }
      paramb.nRd = ((int)y.bEl(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.nRd);
      if (paramb.nRd > 0)
      {
        paramb.nRe = y.alV(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(244999);
        return paramb;
      }
      AppMethodBeat.o(244999);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = h.avP(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(244999);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.fileData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.nRd = paramWXMediaMessage.fileData.length;
        paramb = cW(paramWXMediaMessage.fileData);
        AppMethodBeat.o(244999);
        return paramb;
      }
      paramb.nRd = ((int)y.bEl(paramWXMediaMessage.filePath));
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.nRd);
      if (paramb.nRd > 0)
      {
        paramb.nRe = y.alV(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(244999);
        return paramb;
      }
      AppMethodBeat.o(244999);
      return null;
    }
    if (paramb.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.nRd = paramWXMediaMessage.imageData.length;
        paramb = cW(paramWXMediaMessage.imageData);
        AppMethodBeat.o(244999);
        return paramb;
      }
      if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.nRd = ((int)y.bEl(paramWXMediaMessage.imagePath));
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.nRd);
        if (paramb.nRd > 0)
        {
          paramb.nRe = y.alV(paramWXMediaMessage.imagePath);
          bh.bCz();
          paramb = ah.v(new u(com.tencent.mm.model.c.bzT(), "appmsg_img_" + System.currentTimeMillis()).jKT());
          paramString1 = BitmapUtil.getImageOptions(paramWXMediaMessage.imagePath);
          if ((paramString1 == null) || (paramString1.outWidth <= 0) || (paramString1.outHeight <= 0))
          {
            int i;
            if (paramString1 == null)
            {
              bool = true;
              if (paramString1 != null) {
                break label860;
              }
              i = -1;
              label803:
              if (paramString1 != null) {
                break label869;
              }
            }
            label860:
            label869:
            for (int j = -1;; j = paramString1.outHeight)
            {
              Log.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(244999);
              return null;
              bool = false;
              break;
              i = paramString1.outWidth;
              break label803;
            }
          }
          if (com.tencent.mm.model.z.h(paramWXMediaMessage.imagePath, "", true))
          {
            Log.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (y.O(paramWXMediaMessage.imagePath, paramb, false) < 0L)
            {
              Log.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(244999);
              return null;
            }
            AppMethodBeat.o(244999);
            return paramb;
          }
          if ((paramString1.outWidth > 960) || (paramString1.outHeight > 960))
          {
            paramWXMediaMessage = BitmapUtil.extractThumbNail(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (y.O(paramWXMediaMessage.imagePath, paramb, false) >= 0L)
          {
            try
            {
              BitmapUtil.saveBitmapToImage(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(244999);
              return paramb;
            }
            catch (IOException paramb)
            {
              Log.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
              AppMethodBeat.o(244999);
              return null;
            }
            AppMethodBeat.o(244999);
            return null;
          }
          AppMethodBeat.o(244999);
          return null;
        }
        AppMethodBeat.o(244999);
        return null;
      }
      AppMethodBeat.o(244999);
      return null;
    }
    if (paramb.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.nRc = paramWXMediaMessage.musicLowBandUrl;
      paramb.nRx = paramWXMediaMessage.musicDataUrl;
      paramb.nRy = paramWXMediaMessage.musicLowBandDataUrl;
      paramString1 = new com.tencent.mm.pluginsdk.ui.tools.b();
      paramString1.songAlbumUrl = paramWXMediaMessage.songAlbumUrl;
      paramString1.songLyric = paramWXMediaMessage.songLyric;
      paramb.a(paramString1);
      AppMethodBeat.o(244999);
      return null;
    }
    if (paramb.type == 76)
    {
      paramString1 = (WXMusicVideoObject)paramWXMediaMessage;
      paramb.url = paramString1.musicUrl;
      paramb.nRx = paramString1.musicDataUrl;
      com.tencent.mm.pluginsdk.ui.tools.b localb = new com.tencent.mm.pluginsdk.ui.tools.b();
      localb.songAlbumUrl = paramString2;
      localb.YqR = paramString1.singerName;
      localb.YqS = paramString1.albumName;
      localb.songLyric = paramString1.songLyric;
      localb.YqT = paramString1.musicGenre;
      localb.YqU = String.valueOf(paramString1.issueDate);
      localb.YqV = paramString1.identification;
      localb.LNC = paramString1.duration;
      localb.YqW = paramb.messageExt;
      localb.YqX = paramString1.musicOperationUrl;
      if (paramString1.musicVipInfo != null) {}
      for (paramWXMediaMessage = com.tencent.mm.aw.a.OK(paramString1.musicVipInfo.musicId);; paramWXMediaMessage = "")
      {
        localb.oOZ = paramWXMediaMessage;
        paramWXMediaMessage = paramString1.singerName;
        if (paramString1.musicVipInfo != null) {
          bool = true;
        }
        Log.i("MicroMsg.AppMsgLogic", "share music mv to chatting, singerName:%s, musicVipInfo is valid:%b", new Object[] { paramWXMediaMessage, Boolean.valueOf(bool) });
        paramb.a(localb);
        AppMethodBeat.o(244999);
        return null;
      }
    }
    if (paramb.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.videoUrl;
      paramb.nRc = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(244999);
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
        paramString1.IvM = paramWXMediaMessage.IvM;
        paramString1.jumpUrl = paramWXMediaMessage.jumpUrl;
        paramb.a(paramString1);
      }
      AppMethodBeat.o(244999);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.nTD = paramWXMediaMessage.userName;
      paramb.nTC = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.clf() != null) {
          paramb.nTX = paramWXMediaMessage.clf().appVersion;
        }
        paramb.nTY = paramWXMediaMessage.field_brandIconURL;
        Log.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.nTX), paramb.nTY });
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(244999);
        return null;
        if (paramb.type == 1)
        {
          paramb.title = ((WXTextObject)paramWXMediaMessage).text;
          AppMethodBeat.o(244999);
          return null;
        }
        if (paramb.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiData))
        {
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.nRd = paramWXMediaMessage.emojiData.length;
          paramb = cW(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(244999);
          return paramb;
        }
        if (!Util.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.nRd = ((int)y.bEl(paramWXMediaMessage.emojiPath));
          Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.nRd);
          if (paramb.nRd > 0)
          {
            paramb.nRe = y.alV(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(244999);
            return paramb;
          }
          AppMethodBeat.o(244999);
          return null;
        }
        paramb.nRf = paramString1;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.nRJ = paramWXMediaMessage.packageflag;
        paramb.nRI = paramWXMediaMessage.packageid;
        paramb.hAN = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(244999);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.nRJ = paramWXMediaMessage.packageflag;
        paramb.nRI = paramWXMediaMessage.packageid;
        paramb.hAN = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(244999);
        return null;
      }
      if (paramb.type == 68)
      {
        paramWXMediaMessage = (WXLiteAppObject)paramWXMediaMessage;
        paramb.url = paramWXMediaMessage.webpageUrl;
        paramb.nTQ = paramWXMediaMessage.userName;
        paramb.nTR = paramWXMediaMessage.path;
        paramb.nTS = paramWXMediaMessage.query;
        paramb.hAN = 0;
        AppMethodBeat.o(244999);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.nTq = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.hAN = 18;
        AppMethodBeat.o(244999);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.nTr = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.hAN = 20;
    AppMethodBeat.o(244999);
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
    localc.field_createTime = cn.bDu();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], msgLocalId[%s], stack[%s]", new Object[] { Boolean.valueOf(as.cWJ().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, Long.valueOf(paramLong), Util.getStack() });
    AppMethodBeat.o(31025);
    return paramString3;
  }
  
  private static List<a.b> a(long paramLong, String paramString, arv paramarv)
  {
    AppMethodBeat.i(244974);
    List localList = Collections.synchronizedList(new ArrayList());
    Iterator localIterator = paramarv.vEn.iterator();
    while (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      if (localarf.Zza > 26214400L)
      {
        a.b localb = new a.b();
        String str = com.tencent.mm.plugin.record.model.q.c(localarf, paramLong);
        paramarv = y.bub(str);
        localb.toUser = paramString;
        localb.fileSize = localarf.Zza;
        localb.lPJ = localarf.ZyU;
        if (Util.isNullOrNil(localarf.ZyW))
        {
          label121:
          localb.vyS = paramarv;
          localb.aesKey = localarf.ZyH;
          localb.fileName = localarf.title;
          if (!Util.isNullOrNil(localarf.Zzd)) {
            break label189;
          }
        }
        label189:
        for (paramarv = str;; paramarv = localarf.Zzd)
        {
          localb.filePath = paramarv;
          localList.add(localb);
          break;
          paramarv = localarf.ZyW;
          break label121;
        }
      }
    }
    AppMethodBeat.o(244974);
    return localList;
  }
  
  public static void a(cc paramcc, a parama)
  {
    AppMethodBeat.i(31021);
    Object localObject = k.b.Hf(paramcc.field_content);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramcc.field_content });
      AppMethodBeat.o(31021);
      return;
    }
    if ((Util.isNullOrNil(((k.b)localObject).hzM)) && (!Util.isNullOrNil(((k.b)localObject).nRq)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramcc.field_content });
      ((k.b)localObject).hzM = ((k.b)localObject).nRq.hashCode();
    }
    localObject = ((k.b)localObject).hzM;
    if ((!a(paramcc, q((String)localObject, paramcc.field_msgId))) && (e((String)localObject, paramcc)))
    {
      NzY = new g(paramcc.field_msgId, (String)localObject, new com.tencent.mm.am.i()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
        {
          AppMethodBeat.i(244878);
          if (n.this != null) {
            n.this.nH(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(244878);
        }
      });
      bh.aZW().a(NzY, 0);
    }
    AppMethodBeat.o(31021);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(244924);
    com.tencent.mm.ui.base.k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(paramInt), "", parama.aezO.getMMResources().getString(R.l.grG), parama.aezO.getMMResources().getString(R.l.app_cancel), new n.3(paramcc), new n.4());
    bh.bCz();
    parama = com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId);
    parama.setStatus(5);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, parama);
    AppMethodBeat.o(244924);
  }
  
  public static void a(final com.tencent.mm.ui.chatting.d.a parama, cc paramcc, int paramInt, k.b paramb)
  {
    AppMethodBeat.i(244921);
    com.tencent.mm.ui.base.k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(paramInt), "", parama.aezO.getMMResources().getString(R.l.grG), parama.aezO.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(244868);
        n.bx(n.this);
        parama.jpK();
        AppMethodBeat.o(244868);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    bh.bCz();
    parama = com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId);
    parama.setFileStatus(101);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, parama);
    paramcc = o.aePR;
    o.d.a(5, paramb, parama);
    AppMethodBeat.o(244921);
  }
  
  public static boolean a(cc paramcc, c paramc)
  {
    AppMethodBeat.i(31022);
    if ((paramc == null) || (!y.ZC(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(31022);
      return false;
    }
    if ((paramc.efT()) || ((paramcc.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(31022);
      return true;
    }
    AppMethodBeat.o(31022);
    return false;
  }
  
  public static String aK(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(31031);
    Object localObject = new u(paramString1);
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
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
        if (!ah.v(new u((String)localObject).jKP().jKT()).equalsIgnoreCase(ah.v(new u(paramString1).jKT())))
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
    } while (!y.ZC(paramString2));
    for (;;)
    {
      localObject = paramString2;
      if (i < 20)
      {
        if (!y.ZC(paramString1 + i + "_" + str1)) {
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
  
  public static String ab(long paramLong, String paramString)
  {
    AppMethodBeat.i(31020);
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.Hf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(31020);
      return null;
    }
    String str = aK(com.tencent.mm.loader.i.b.bmC(), paramString.title, paramString.nRe);
    if ((Util.isNullOrNil(paramString.hzM)) && (!Util.isNullOrNil(paramString.nRq))) {
      paramString.hzM = paramString.nRq.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.hzM, paramString.nRd, paramString.type, paramString.nRh);
    AppMethodBeat.o(31020);
    return paramString;
  }
  
  public static int am(long paramLong, String paramString)
  {
    AppMethodBeat.i(244917);
    c localc = as.cWJ().yi(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      AppMethodBeat.o(244917);
      return -1;
    }
    if (localc.field_status != 101L)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(244917);
      return -1;
    }
    if ((Util.isNullOrNil(localc.field_clientAppDataId)) && (!Util.isNullOrNil(localc.field_mediaSvrId))) {}
    for (localc.field_status = 102L;; localc.field_status = 105L)
    {
      localc.field_lastModifyTime = Util.nowSecond();
      as.cWJ().a(localc, new String[0]);
      AppMethodBeat.o(244917);
      return 0;
    }
  }
  
  public static int an(long paramLong, String paramString)
  {
    AppMethodBeat.i(244918);
    c localc = as.cWJ().yi(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      AppMethodBeat.o(244918);
      return -1;
    }
    if ((localc.field_status != 105L) && (localc.field_status != 101L))
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localc.field_status);
      AppMethodBeat.o(244918);
      return -1;
    }
    localc.field_status = 101L;
    localc.field_lastModifyTime = Util.nowSecond();
    as.cWJ().a(localc, new String[0]);
    as.iIL().run();
    AppMethodBeat.o(244918);
    return 0;
  }
  
  public static String b(byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    AppMethodBeat.i(245017);
    if (paramBoolean2) {}
    for (paramArrayOfByte = r.bKa().az(paramArrayOfByte);; paramArrayOfByte = r.bKa().b(paramArrayOfByte, paramBoolean1, paramCompressFormat))
    {
      Log.i("MicroMsg.AppMsgLogic", "saveAppMsgDirThumb directSave:" + paramBoolean2 + "  path:" + paramArrayOfByte);
      AppMethodBeat.o(245017);
      return paramArrayOfByte;
    }
  }
  
  public static void b(cc paramcc, c paramc)
  {
    AppMethodBeat.i(245020);
    if ((paramc != null) && (paramcc.getType() == 1090519089))
    {
      long l1 = paramc.field_msgInfoId;
      long l2 = paramc.systemRowid;
      com.tencent.mm.am.z.a(new com.tencent.mm.pluginsdk.model.file.a(paramc).rr, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(244860);
          Log.i("MicroMsg.AppMsgLogic", "sendFileUploadMsgCallback type:%d errType:%d errCode:%d errMsg:%s tempMsgId:%s", new Object[] { Integer.valueOf(paramAnonymousp.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Util.nullAs(paramAnonymousString, ""), Long.valueOf(this.XSC) });
          paramAnonymousp = (exg)c.b.b(paramAnonymousc.otB);
          if ((paramAnonymousp == null) || (!Util.isEqual(paramAnonymousp.abzh, this.XSC)))
          {
            AppMethodBeat.o(244860);
            return 0;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousc = (exh)c.c.b(paramAnonymousc.otC);
            if (paramAnonymousc != null)
            {
              Log.i("MicroMsg.AppMsgLogic", "FileUploadToken:%s NewMsgId:%s msgId:%s", new Object[] { paramAnonymousc.abzj, Long.valueOf(paramAnonymousc.abzl), paramAnonymousp.abzh });
              paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(Util.safeParseLong(paramAnonymousp.abzh));
              if (paramAnonymousString.field_msgId == 0L)
              {
                Log.e("MicroMsg.AppMsgLogic", "sendFileUploadMsgCallback msg:%s no exist!", new Object[] { paramAnonymousp.abzh });
                AppMethodBeat.o(244860);
                return 0;
              }
              paramAnonymousp = k.b.Hf(Util.processXml(paramAnonymousString.field_content));
              com.tencent.mm.message.a.b localb = new com.tencent.mm.message.a.b();
              localb.Hm(paramAnonymousc.abzj);
              localb.nVD = paramAnonymousc.abzl;
              paramAnonymousp.a(localb);
              paramAnonymousString.setContent(k.b.a(paramAnonymousp, null, null));
              paramAnonymousString.setStatus(2);
              paramAnonymousString.gX(paramAnonymousc.abzl);
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramAnonymousString.field_msgId, paramAnonymousString);
              paramAnonymousc = o.aePR;
              o.d.a(1, paramAnonymousp, paramAnonymousString);
            }
          }
          for (;;)
          {
            as.iIL().run();
            AppMethodBeat.o(244860);
            return 0;
            n.tn(this.XSD);
          }
        }
      });
      AppMethodBeat.o(245020);
      return;
    }
    as.iIL().run();
    AppMethodBeat.o(245020);
  }
  
  public static boolean bpS(String paramString)
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
  
  public static int bpT(String paramString)
  {
    AppMethodBeat.i(31019);
    k.b localb = k.b.Hf(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    if (!bpS(localb.hzM))
    {
      AppMethodBeat.o(31019);
      return -1;
    }
    c localc = new c();
    long l = Util.getLong(localb.hzM, -1L);
    if (l != -1L)
    {
      as.cWJ().get(l, localc);
      paramString = localc;
      if (localc.systemRowid != l)
      {
        localc = as.cWJ().bpI(localb.hzM);
        if (localc != null)
        {
          paramString = localc;
          if (localc.field_mediaSvrId.equals(localb.hzM)) {}
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
      localc = as.cWJ().bpI(localb.hzM);
      if (localc != null)
      {
        paramString = localc;
        if (localc.field_mediaSvrId.equals(localb.hzM)) {}
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
  
  public static c bpU(String paramString)
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
      as.cWJ().get(l, localc2);
      localc1 = localc2;
      if (localc2.systemRowid != l)
      {
        localc2 = as.cWJ().bpI(paramString);
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
      localc2 = as.cWJ().bpI(paramString);
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
  
  public static Pair<Integer, Long> bx(cc paramcc)
  {
    AppMethodBeat.i(31041);
    Object localObject5 = k.b.Hf(paramcc.field_content);
    if (localObject5 == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(31041);
      return null;
    }
    Object localObject4 = bpU(((k.b)localObject5).hzM);
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
          bh.bCz();
          localObject1 = aK(com.tencent.mm.model.c.bzT(), ((k.b)localObject5).title, ((k.b)localObject5).nRe);
          y.O(((c)localObject4).field_fileFullPath, (String)localObject1, false);
        }
      }
    }
    if ((paramcc.field_imgPath != null) && (!paramcc.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = r.bKa().X(paramcc.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = y.bi((String)localObject2, 0, -1);
        localObject4 = k.b.a((k.b)localObject5);
        localObject5 = ((k.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (Util.isNullOrNil((String)localObject1)) {
          break label1119;
        }
        localObject1 = a((String)localObject6, (k.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        paramcc = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(-1L));
        AppMethodBeat.o(31041);
        return paramcc;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new cc();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((k.b)localObject4).type != 46) {
          break label736;
        }
        localObject3 = r.bKa().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((cc)localObject6).BT((String)localObject3);
          Log.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null)
      {
        ((k.b)localObject4).hzM = ((c)localObject1).systemRowid;
        if ((((k.b)localObject4).type == 6) && (Util.isNullOrNil(((k.b)localObject4).filemd5)))
        {
          com.tencent.mm.modelcdntran.k.bHX();
          ((k.b)localObject4).filemd5 = com.tencent.mm.modelcdntran.d.Ns(((c)localObject1).field_fileFullPath);
        }
      }
      ((cc)localObject6).setContent(k.b.a((k.b)localObject4, null, null));
      ((cc)localObject6).setStatus(1);
      ((cc)localObject6).BS(paramcc.field_talker);
      ((cc)localObject6).setCreateTime(br.JN(paramcc.field_talker));
      ((cc)localObject6).pI(1);
      ((cc)localObject6).setType(h((k.b)localObject4));
      localObject3 = ((aa)com.tencent.mm.kernel.h.ax(aa.class)).ak((cc)localObject6);
      if (!Util.isNullOrNil((String)localObject3))
      {
        ((cc)localObject6).AU((String)localObject3);
        Log.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((fi)localObject6).jUr });
      }
      if (((k.b)localObject4).type == 53) {
        ((cc)localObject6).Cd(paramcc.kLs);
      }
      bh.bCz();
      long l = com.tencent.mm.model.c.bzD().ba((cc)localObject6);
      if (((k.b)localObject4).type == 53)
      {
        localObject3 = new pz();
        ((pz)localObject3).hTe.type = 0;
        ((pz)localObject3).hTe.key = ((fi)localObject6).kLs;
        ((pz)localObject3).hTe.username = ((fi)localObject6).field_talker;
        ((pz)localObject3).hTf.msgId = l;
        ((pz)localObject3).publish();
      }
      Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
        paramcc = new Pair(Integer.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramcc;
        label736:
        if (((k.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = b((byte[])localObject3, bool, Bitmap.CompressFormat.PNG, false);
          break;
        }
      }
      Log.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((cc)localObject6).setMsgId(l);
      localObject3 = new abo();
      ((abo)localObject3).ifb.ifc = paramcc.field_msgId;
      ((abo)localObject3).ifb.ifd = l;
      ((abo)localObject3).publish();
      localObject3 = new com.tencent.mm.message.k();
      ((com.tencent.mm.message.k)localObject3).field_xml = ((fi)localObject6).field_content;
      ((com.tencent.mm.message.k)localObject3).field_title = ((k.b)localObject4).title;
      ((com.tencent.mm.message.k)localObject3).field_type = ((k.b)localObject4).type;
      ((com.tencent.mm.message.k)localObject3).field_description = ((k.b)localObject4).description;
      ((com.tencent.mm.message.k)localObject3).field_msgId = l;
      ((com.tencent.mm.message.k)localObject3).field_source = ((String)localObject5);
      as.iIJ().insert((IAutoDBItem)localObject3);
      if (localObject1 != null)
      {
        ((c)localObject1).field_msgInfoId = l;
        ((c)localObject1).field_status = 101L;
        as.cWJ().a((c)localObject1, new String[0]);
        b((cc)localObject6, (c)localObject1);
      }
      for (;;)
      {
        paramcc = new Pair(Integer.valueOf(0), Long.valueOf(l));
        AppMethodBeat.o(31041);
        return paramcc;
        if ((((k.b)localObject4).type == 24) || (((k.b)localObject4).type == 19))
        {
          localObject1 = com.tencent.mm.plugin.record.model.q.aSH(((k.b)localObject4).nRF);
          localObject3 = new arv();
          if (localObject1 != null) {
            ((arv)localObject3).vEn.addAll(((com.tencent.mm.protocal.b.a.c)localObject1).nUC);
          }
          localObject5 = paramcc.field_talker;
          List localList = a(l, (String)localObject5, (arv)localObject3);
          if (localList.size() > 0)
          {
            com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.pluginsdk.h.a(localList, new a.a()
            {
              public final void cy(int paramAnonymousInt, String paramAnonymousString)
              {
                AppMethodBeat.i(244876);
                if (paramAnonymousInt == 0)
                {
                  paramAnonymousString = new com.tencent.mm.plugin.record.a.k();
                  paramAnonymousString.field_msgId = this.hkO;
                  paramAnonymousString.field_oriMsgId = this.XSB.field_msgId;
                  paramAnonymousString.field_toUser = this.hkh;
                  paramAnonymousString.field_title = this.svq.title;
                  paramAnonymousString.field_desc = this.svq.description;
                  paramAnonymousString.field_dataProto = this.NAN;
                  paramAnonymousString.field_type = 0;
                  paramAnonymousString.field_favFrom = this.NAM.NAa;
                  paramAnonymousString.field_localId = (new Random().nextInt(2147483645) + 1);
                  Log.i("MicroMsg.AppMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramAnonymousString)), Long.valueOf(this.hkO), Integer.valueOf(paramAnonymousString.field_localId) });
                  ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramAnonymousString);
                  AppMethodBeat.o(244876);
                  return;
                }
                if (-3200 == paramAnonymousInt) {
                  Log.e("MicroMsg.AppMsgLogic", "why errCode equals %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
                }
                this.oiL.setStatus(5);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.hkO, this.oiL);
                cc localcc = new cc();
                localcc.setCreateTime(this.oiL.getCreateTime() + 1L);
                localcc.BS(this.oiL.field_talker);
                localcc.setContent(paramAnonymousString);
                localcc.setType(10000);
                localcc.setStatus(6);
                localcc.pI(0);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
                AppMethodBeat.o(244876);
              }
            }), 0);
          }
          else
          {
            as.iIL();
            ar.a.tm(l);
          }
        }
        else
        {
          as.iIL();
          ar.a.tm(l);
        }
      }
      label1119:
      localObject1 = null;
    }
  }
  
  public static String cW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31037);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " attachBuf is null");
      AppMethodBeat.o(31037);
      return null;
    }
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = com.tencent.mm.model.c.bzT() + "ua_" + Util.nowMilliSecond();
    Log.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " buildUploadAttachInfo file:" + (String)localObject);
    if (y.f((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      Log.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(31037);
      return null;
    }
    AppMethodBeat.o(31037);
    return localObject;
  }
  
  public static boolean e(String paramString, cc paramcc)
  {
    AppMethodBeat.i(31023);
    if (paramcc == null)
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
    Object localObject1 = q(paramString, paramcc.field_msgId);
    Object localObject2 = k.b.Hf(paramcc.field_content);
    if (localObject2 != null)
    {
      str3 = ab.nullAsNil(((k.b)localObject2).title);
      str4 = ab.nullAsNil(((k.b)localObject2).nRe).toLowerCase();
      str2 = ab.nullAsNil(((k.b)localObject2).filemd5);
      str5 = ab.nullAsNil(((k.b)localObject2).hQQ);
      str1 = ab.nullAsNil(((k.b)localObject2).aesKey);
    }
    if (localObject1 == null)
    {
      ab(paramcc.field_msgId, paramcc.field_content);
      paramcc = q(paramString, paramcc.field_msgId);
      paramString = paramcc;
      bool1 = bool2;
      if (paramcc != null)
      {
        l1 = paramcc.systemRowid;
        l2 = paramcc.field_totalLen;
        paramString = paramcc.field_fileFullPath;
        l3 = paramcc.field_type;
        localObject1 = paramcc.field_mediaId;
        l4 = paramcc.field_msgInfoId;
        bool1 = paramcc.field_isUpload;
        if (paramcc.field_signature != null) {
          break label343;
        }
      }
      label343:
      for (i = -1;; i = paramcc.field_signature.length())
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = paramcc;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((k.b)localObject2).nRh == 0)
          {
            paramString = paramcc;
            bool1 = bool2;
            if (((k.b)localObject2).nRd <= 26214400) {}
          }
          else
          {
            bool1 = false;
            paramString = paramcc;
          }
        }
        if (!bool1) {
          bh.aZW().a(new com.tencent.mm.plugin.record.model.e(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(31023);
        return bool1;
      }
    }
    paramString = new u(((c)localObject1).field_fileFullPath);
    if ((((c)localObject1).field_status == 199L) && (!paramString.jKS()))
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      ab(paramcc.field_msgId, paramcc.field_content);
    }
    long l1 = ((c)localObject1).systemRowid;
    long l2 = ((c)localObject1).field_totalLen;
    paramcc = ((c)localObject1).field_fileFullPath;
    long l3 = ((c)localObject1).field_type;
    localObject2 = ((c)localObject1).field_mediaId;
    long l4 = ((c)localObject1).field_msgInfoId;
    boolean bool1 = ((c)localObject1).field_isUpload;
    boolean bool3 = paramString.jKS();
    long l5 = ((c)localObject1).field_status;
    if (((c)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject1).field_signature.length())
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramcc, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
      paramString = (String)localObject1;
      bool1 = bool2;
      break;
    }
  }
  
  public static c g(cc paramcc, String paramString)
  {
    AppMethodBeat.i(31039);
    c localc = bpU(paramString);
    if (localc == null)
    {
      ab(paramcc.field_msgId, paramcc.field_content);
      paramcc = bpU(paramString);
      AppMethodBeat.o(31039);
      return paramcc;
    }
    AppMethodBeat.o(31039);
    return localc;
  }
  
  public static int h(k.b paramb)
  {
    AppMethodBeat.i(31042);
    if (paramb == null)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    int i = paramb.type;
    int j = paramb.hAN;
    int k = paramb.nQm;
    int m = paramb.nRz;
    int n = paramb.nSU;
    int i1 = paramb.nTe;
    Log.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n + ", bubbleType = " + i1);
    if (i == 76)
    {
      AppMethodBeat.o(31042);
      return 1040187441;
    }
    if ((i == 3) && ((m.aml(paramb.appId)) || ("wx485a97c844086dc9".equals(paramb.appId))))
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
      if ((j == 1) || (i1 == 1))
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
    com.tencent.mm.message.a locala = (com.tencent.mm.message.a)paramb.aK(com.tencent.mm.message.a.class);
    if ((locala != null) && (locala.nOK) && ((paramb.nTF == 2) || (paramb.nTF == 3)))
    {
      AppMethodBeat.o(31042);
      return 553648177;
    }
    if ((locala != null) && (locala.nON) && (paramb.nTF == 3))
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
    paramb = (com.tencent.mm.message.e)paramb.aK(com.tencent.mm.message.e.class);
    if ((paramb != null) && (paramb.nQs != null))
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
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 973078577;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 973078577;
    AppMethodBeat.o(31042);
    return 975175729;
    AppMethodBeat.o(31042);
    return 974127153;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 754974769;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 754974769;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 838860849;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 838860849;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1006633009;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1006633009;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 956301361;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 956301361;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1023410225;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1023410225;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 788529201;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 788529201;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 1076887601;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 1076887601;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 771751985;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
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
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXy, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 989855793;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 1)
    {
      AppMethodBeat.o(31042);
      return 49;
    }
    AppMethodBeat.o(31042);
    return 989855793;
    switch (com.tencent.mm.plugin.findersdk.a.q.f(paramb.nUd, paramb.nUa))
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
  
  public static int i(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(244926);
    c localc = as.cWJ().yi(paramLong);
    if (localc == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString2);
      AppMethodBeat.o(244926);
      return -1;
    }
    if (localc.field_status != 101L)
    {
      Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString2 + " status:" + localc.field_status);
      AppMethodBeat.o(244926);
      return -1;
    }
    localc.field_status = 102L;
    localc.field_lastModifyTime = Util.nowSecond();
    as.cWJ().a(localc, new String[0]);
    paramString1 = g.a(localc.field_createTime, paramString1, paramLong);
    com.tencent.mm.modelcdntran.b.a(paramString1, n..ExternalSyntheticLambda0.INSTANCE, paramString1);
    AppMethodBeat.o(244926);
    return 0;
  }
  
  public static c q(String paramString, long paramLong)
  {
    AppMethodBeat.i(31024);
    c localc = bpU(paramString);
    paramString = localc;
    if (localc == null) {
      paramString = as.cWJ().yi(paramLong);
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
  
  public static void tn(long paramLong)
  {
    AppMethodBeat.i(31018);
    as.cWJ().yh(paramLong);
    Log.d("MicroMsg.AppMsgLogic", "setError rowid:%s, stack:%s", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    Object localObject = new c();
    as.cWJ().get(paramLong, (IAutoDBItem)localObject);
    if (((c)localObject).field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(31018);
      return;
    }
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(((c)localObject).field_msgInfoId);
    if ((localcc == null) || (localcc.field_msgId != ((c)localObject).field_msgInfoId))
    {
      AppMethodBeat.o(31018);
      return;
    }
    if ((localcc.field_status == 2) && (localcc.getType() == 1090519089) && (localcc.kLw == 0))
    {
      localcc.setFileStatus(100);
      localObject = o.aePR;
      o.d.a(3, null, localcc);
    }
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(localcc.field_msgId, localcc);
      AppMethodBeat.o(31018);
      return;
      localcc.setStatus(5);
    }
  }
  
  public static int va(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static abstract interface a
  {
    public abstract void nH(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */