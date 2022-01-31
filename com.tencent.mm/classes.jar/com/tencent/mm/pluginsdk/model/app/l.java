package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
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
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static com.tencent.mm.plugin.record.b.e pYd;
  
  public static int LD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static String Z(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(27338);
    Object localObject = new com.tencent.mm.vfs.b(paramString1);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    if (bo.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + bo.aoy();
      paramString2 = (String)localObject;
      if (!bo.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(paramString2).dQI().dQJ()).equalsIgnoreCase(com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(paramString1).dQJ())))
        {
          localObject = paramString1 + "da_" + bo.aoy();
          ab.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(27338);
        return localObject;
        localObject = paramString2;
        if (!bo.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!com.tencent.mm.vfs.e.cN(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!com.tencent.mm.vfs.e.cN(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + bo.aoy();
            paramString2 = (String)localObject;
            if (bo.isNullOrNil(paramString3)) {
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
          ab.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bo.aoy();
          localObject = paramString1;
          if (!bo.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static int a(long paramLong, String paramString, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(153690);
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(paramLong);
    int i;
    if (localbi.field_msgId != paramLong)
    {
      ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(153690);
      return 0 - i;
    }
    j.b localb = j.b.mY(localbi.field_content);
    if (localb == null)
    {
      ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " getmsgFailed id:" + paramLong);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(153690);
      return 0 - i;
    }
    localb.cmN = paramString;
    if ((paramBoolean) && (paramd != null))
    {
      if (!paramd.field_aesKey.equals("")) {
        break label393;
      }
      str = localb.ewj;
      localb.ewj = str;
      if (!paramd.field_fileId.equals("")) {
        break label402;
      }
      str = localb.fgL;
      label195:
      localb.fgL = str;
      if (!paramd.field_filemd5.equals("")) {
        break label411;
      }
      str = localb.filemd5;
      label221:
      localb.filemd5 = str;
      if (paramd.field_fileLength != 0) {
        break label420;
      }
      i = localb.fgw;
      label242:
      localb.fgw = i;
      if (!paramd.field_thumbUrl.equals("")) {
        break label429;
      }
    }
    label393:
    label402:
    label411:
    label420:
    label429:
    for (String str = localb.fgM;; str = paramd.field_thumbUrl)
    {
      localb.fgM = str;
      localbi.setContent(j.b.a(localb, localb.cmN, paramd));
      aw.aaz();
      com.tencent.mm.model.c.YC().a(localbi.field_msgId, localbi);
      paramd = al.dlL().nx(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbi.field_content;
        al.dlL().update(paramd, new String[] { "msgId" });
      }
      if (paramBoolean)
      {
        paramd = al.aUJ().nw(paramLong);
        paramd.field_mediaSvrId = paramString;
        paramd.field_offset = paramd.field_totalLen;
        al.aUJ().a(paramd, new String[0]);
      }
      AppMethodBeat.o(153690);
      return 0;
      str = paramd.field_aesKey;
      break;
      str = paramd.field_fileId;
      break label195;
      str = paramd.field_filemd5;
      break label221;
      i = paramd.field_fileLength;
      break label242;
    }
  }
  
  public static int a(j.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(27342);
    int i = a(paramb, paramWXMediaMessage, paramString, null, null);
    AppMethodBeat.o(27342);
    return i;
  }
  
  private static int a(j.b paramb, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(27343);
    Object localObject2 = b(paramb, paramWXMediaMessage, paramString2);
    ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "summerbig content url:" + paramb.url + " lowUrl:" + paramb.fgv + " attachlen:" + paramb.fgw + " attachid:" + paramb.cmN + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    int i;
    if (!bo.isNullOrNil((String)localObject2))
    {
      localObject1 = a((String)localObject1, paramb, (String)localObject2);
      if (localObject1 == null)
      {
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27343);
        return 0 - i;
      }
      localObject2 = com.tencent.mm.sdk.platformtools.d.aoT((String)localObject2);
      if (localObject2 != null)
      {
        paramb.fgR = ((BitmapFactory.Options)localObject2).outWidth;
        paramb.fgQ = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bi localbi = new bi();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 65536) || (paramWXMediaMessage.getType() == 36) || (paramWXMediaMessage.getType() == 46)) {
          break label540;
        }
        if (paramb.type != 2) {
          break label534;
        }
        bool = true;
        localObject2 = o.ahC().a(paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label266:
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bo.isNullOrNil((String)localObject2)) {
          localbi.kk((String)localObject2);
        }
      }
      if (localObject1 != null) {
        paramb.cmN = ((b)localObject1).systemRowid;
      }
      paramString1 = bo.P(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label844;
        }
        localObject2 = (String)paramString1.next();
        paramb.fgy = paramString2;
        localbi.setContent(j.b.a(paramb, null, null));
        localbi.setStatus(1);
        localbi.kj((String)localObject2);
        localbi.fQ(bf.py((String)localObject2));
        localbi.hL(1);
        localbi.setType(c(paramb));
        localObject2 = ((q)com.tencent.mm.kernel.g.E(q.class)).B(localbi);
        if (!bo.isNullOrNil((String)localObject2)) {
          localbi.jl((String)localObject2);
        }
        aw.aaz();
        long l = com.tencent.mm.model.c.YC().Z(localbi);
        if (l < 0L)
        {
          ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " summerbig insert msg failed :" + l);
          i = com.tencent.mm.compatible.util.g.getLine();
          AppMethodBeat.o(27343);
          return 0 - i;
          label534:
          bool = false;
          break;
          label540:
          localObject2 = o.ahC().T(paramWXMediaMessage.thumbData);
          break label266;
        }
        ab.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbi.setMsgId(l);
        localObject2 = new com.tencent.mm.af.j();
        ((com.tencent.mm.af.j)localObject2).field_xml = localbi.field_content;
        ((com.tencent.mm.af.j)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.af.j)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.af.j)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.af.j)localObject2).field_msgId = l;
        ((com.tencent.mm.af.j)localObject2).field_source = paramb.appName;
        al.dlL().insert((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((b)localObject1).field_msgInfoId = l;
          ((b)localObject1).field_status = 101L;
          ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((b)localObject1).field_msgInfoId), Long.valueOf(((b)localObject1).field_status), Long.valueOf(((b)localObject1).systemRowid), Integer.valueOf(((com.tencent.mm.af.j)localObject2).field_type) });
          al.aUJ().a((b)localObject1, new String[0]);
          if (!bo.isNullOrNil(paramString3)) {
            al.dlN().A(((b)localObject1).field_msgInfoId, paramString3);
          }
          al.dlN().run();
        }
        else
        {
          ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((com.tencent.mm.af.j)localObject2).field_type) });
          al.dlN();
          ak.a.B(l, paramString3);
        }
      }
      label844:
      AppMethodBeat.o(27343);
      return 0;
      localObject1 = null;
    }
  }
  
  public static int a(j.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27336);
    int i = a(paramb, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, null);
    AppMethodBeat.o(27336);
    return i;
  }
  
  public static int a(j.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    AppMethodBeat.i(27337);
    int i = a(paramb, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramString5, "");
    AppMethodBeat.o(27337);
    return i;
  }
  
  public static int a(j.b paramb, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6)
  {
    AppMethodBeat.i(27339);
    ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, paramb });
    Object localObject = System.currentTimeMillis();
    int i;
    if (!bo.isNullOrNil(paramString4))
    {
      localObject = a((String)localObject, paramb, paramString4);
      if (localObject == null)
      {
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27339);
        return 0 - i;
      }
    }
    for (;;)
    {
      bi localbi = new bi();
      int j;
      label179:
      label191:
      int k;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 44) && (paramb.type != 48)) {
          break label615;
        }
        if (paramb.type != 48) {
          break label543;
        }
        i = 0;
        j = 0;
        com.tencent.mm.af.a locala = (com.tencent.mm.af.a)paramb.R(com.tencent.mm.af.a.class);
        if (locala == null) {
          break label572;
        }
        paramString4 = locala.ffp;
        if (locala == null) {
          break label579;
        }
        bool = locala.ffq;
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTB, 0) != 1) {
          break label585;
        }
        k = 1;
        label216:
        if (((!f.IS_FLAVOR_RED) && (k == 0)) || (paramb.type == 48)) {
          break label591;
        }
        paramString4 = o.ahC().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, paramString4, bool);
      }
      long l;
      for (;;)
      {
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + paramString4);
        if (!bo.isNullOrNil(paramString4))
        {
          localbi.kk(paramString4);
          ab.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(paramString4)));
        }
        if (localObject != null) {
          paramb.cmN = ((b)localObject).systemRowid;
        }
        localbi.setContent(j.b.a(paramb, null, null));
        localbi.setStatus(1);
        localbi.kj(paramString3);
        localbi.fQ(bf.py(paramString3));
        localbi.hL(1);
        localbi.setType(c(paramb));
        paramString3 = ((q)com.tencent.mm.kernel.g.E(q.class)).B(localbi);
        if (!bo.isNullOrNil(paramString3))
        {
          localbi.jl(paramString3);
          ab.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbi.dns });
        }
        aw.aaz();
        l = com.tencent.mm.model.c.YC().Z(localbi);
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label675;
        }
        ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27339);
        return 0 - i;
        label543:
        i = (int)(com.tencent.mm.sdk.platformtools.d.aow().density * 240.0F);
        j = (int)(com.tencent.mm.sdk.platformtools.d.aow().density * 240.0F);
        break;
        label572:
        paramString4 = "";
        break label179;
        label579:
        bool = false;
        break label191;
        label585:
        k = 0;
        break label216;
        label591:
        paramString4 = o.ahC().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j, paramString4, bool);
        continue;
        label615:
        if (paramb.type != 46) {
          break label640;
        }
        paramString4 = o.ahC().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG);
      }
      label640:
      if (paramb.type == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString4 = o.ahC().a(paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
      label675:
      ab.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
      localbi.setMsgId(l);
      paramString3 = new com.tencent.mm.af.j();
      paramString3.field_xml = localbi.field_content;
      paramString3.field_appId = paramString1;
      paramString3.field_title = paramb.title;
      paramString3.field_type = paramb.type;
      paramString3.field_description = paramb.description;
      paramString3.field_msgId = l;
      paramString3.field_source = paramString2;
      al.dlL().insert(paramString3);
      if (localObject == null)
      {
        bool = true;
        ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
        if (localObject == null) {
          break label886;
        }
        ((b)localObject).field_msgInfoId = l;
        ((b)localObject).field_status = 101L;
        al.aUJ().a((b)localObject, new String[0]);
        if ((paramb.type == 2) || (!bo.isNullOrNil(paramString5))) {
          al.dlN().A(l, paramString5);
        }
        al.dlN().run();
      }
      for (;;)
      {
        AppMethodBeat.o(27339);
        return 0;
        bool = false;
        break;
        label886:
        al.dlN();
        ak.a.c(l, paramString5, paramString6);
      }
      localObject = null;
    }
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(27340);
    paramInt = a(paramWXMediaMessage, paramString1, paramString2, paramString3, paramInt, paramString4, null);
    AppMethodBeat.o(27340);
    return paramInt;
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(27341);
    j.b localb = new j.b();
    localb.appId = paramString1;
    localb.appName = paramString2;
    localb.fgz = paramInt;
    paramInt = a(localb, paramWXMediaMessage, paramString3, paramString4, paramString5);
    AppMethodBeat.o(27341);
    return paramInt;
  }
  
  public static b a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(27333);
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bo.aoy();
    localb.field_lastModifyTime = bo.aox();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    AppMethodBeat.o(27333);
    return localb;
  }
  
  public static b a(String paramString1, j.b paramb, String paramString2)
  {
    AppMethodBeat.i(27334);
    ab.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.compatible.util.e.eQu))
    {
      ab.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      AppMethodBeat.o(27334);
      return null;
    }
    localObject = new b();
    ((b)localObject).field_totalLen = paramb.fgw;
    ((b)localObject).field_fileFullPath = paramString2;
    ((b)localObject).field_sdkVer = paramb.sdkVer;
    ((b)localObject).field_appId = paramb.appId;
    ((b)localObject).field_clientAppDataId = paramString1;
    ((b)localObject).field_type = paramb.type;
    ((b)localObject).field_status = 200L;
    ((b)localObject).field_isUpload = true;
    ((b)localObject).field_createTime = bo.aoy();
    ((b)localObject).field_lastModifyTime = bo.aox();
    ((b)localObject).field_mediaSvrId = bo.aoy();
    ((b)localObject).field_isUseCdn = 0;
    al.aUJ().insert((com.tencent.mm.sdk.e.c)localObject);
    ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " summerbig buildUploadAttachInfo file:" + ((b)localObject).field_fileFullPath + " rowid:" + ((b)localObject).systemRowid + " clientAppDataId:" + ((b)localObject).field_clientAppDataId);
    if (((b)localObject).systemRowid < 0L)
    {
      ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " summerbig uploadAttach insert appattach info failed :" + ((b)localObject).systemRowid);
      AppMethodBeat.o(27334);
      return null;
    }
    AppMethodBeat.o(27334);
    return localObject;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(27332);
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bo.aoy();
    localb.field_lastModifyTime = bo.aox();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    localb.field_type = paramInt3;
    ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(al.aUJ().insert(localb)), Long.valueOf(localb.systemRowid), Long.valueOf(localb.field_totalLen), Long.valueOf(localb.field_type), Integer.valueOf(paramInt4), paramString1, bo.dtY() });
    AppMethodBeat.o(27332);
    return paramString3;
  }
  
  public static void a(bi parambi, l.a parama)
  {
    AppMethodBeat.i(27328);
    Object localObject = j.b.mY(parambi.field_content);
    if (localObject == null)
    {
      ab.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambi.field_content });
      AppMethodBeat.o(27328);
      return;
    }
    if ((bo.isNullOrNil(((j.b)localObject).cmN)) && (!bo.isNullOrNil(((j.b)localObject).fgL)))
    {
      ab.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambi.field_content });
      ((j.b)localObject).cmN = ((j.b)localObject).fgL.hashCode();
    }
    localObject = ((j.b)localObject).cmN;
    if ((!a(parambi, q((String)localObject, parambi.field_msgId))) && (d((String)localObject, parambi)))
    {
      pYd = new com.tencent.mm.plugin.record.b.e(parambi.field_msgId, (String)localObject, new com.tencent.mm.ai.g()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
        {
          AppMethodBeat.i(27323);
          if (this.vLq != null) {
            this.vLq.ha(paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(27323);
        }
      });
      aw.Rc().a(pYd, 0);
    }
    AppMethodBeat.o(27328);
  }
  
  public static boolean a(bi parambi, b paramb)
  {
    AppMethodBeat.i(27329);
    if ((paramb == null) || (!com.tencent.mm.vfs.e.cN(paramb.field_fileFullPath)))
    {
      AppMethodBeat.o(27329);
      return false;
    }
    if ((paramb.bEL()) || ((parambi.field_isSend == 1) && (paramb.field_isUpload)))
    {
      AppMethodBeat.o(27329);
      return true;
    }
    AppMethodBeat.o(27329);
    return false;
  }
  
  public static void al(bi parambi)
  {
    AppMethodBeat.i(27348);
    Object localObject5 = j.b.mY(parambi.field_content);
    if (localObject5 == null)
    {
      ab.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      AppMethodBeat.o(27348);
      return;
    }
    Object localObject4 = alv(((j.b)localObject5).cmN);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (((b)localObject4).field_fileFullPath != null)
      {
        localObject1 = localObject2;
        if (!((b)localObject4).field_fileFullPath.equals(""))
        {
          aw.aaz();
          localObject1 = Z(com.tencent.mm.model.c.YS(), ((j.b)localObject5).title, ((j.b)localObject5).fgx);
          com.tencent.mm.vfs.e.C(((b)localObject4).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambi.field_imgPath != null) && (!parambi.field_imgPath.equals(""))) {}
    Object localObject6;
    Object localObject3;
    for (localObject2 = o.ahC().J(parambi.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = com.tencent.mm.vfs.e.i((String)localObject2, 0, -1);
        localObject4 = j.b.a((j.b)localObject5);
        localObject5 = ((j.b)localObject5).appName;
        localObject6 = System.currentTimeMillis();
        if (bo.isNullOrNil((String)localObject1)) {
          break label804;
        }
        localObject1 = a((String)localObject6, (j.b)localObject4, (String)localObject1);
        if (localObject1 != null) {
          break;
        }
        com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27348);
        return;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject6 = new bi();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        if (((j.b)localObject4).type != 46) {
          break label572;
        }
        localObject3 = o.ahC().a((byte[])localObject3, Bitmap.CompressFormat.JPEG);
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + (String)localObject3);
        if (!bo.isNullOrNil((String)localObject3))
        {
          ((bi)localObject6).kk((String)localObject3);
          ab.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
        }
      }
      if (localObject1 != null) {
        ((j.b)localObject4).cmN = ((b)localObject1).systemRowid;
      }
      ((bi)localObject6).setContent(j.b.a((j.b)localObject4, null, null));
      ((bi)localObject6).setStatus(1);
      ((bi)localObject6).kj(parambi.field_talker);
      ((bi)localObject6).fQ(bf.py(parambi.field_talker));
      ((bi)localObject6).hL(1);
      ((bi)localObject6).setType(c((j.b)localObject4));
      localObject3 = ((q)com.tencent.mm.kernel.g.E(q.class)).B((bi)localObject6);
      if (!bo.isNullOrNil((String)localObject3))
      {
        ((bi)localObject6).jl((String)localObject3);
        ab.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((dd)localObject6).dns });
      }
      aw.aaz();
      long l = com.tencent.mm.model.c.YC().Z((bi)localObject6);
      ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
        com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27348);
        return;
        label572:
        if (((j.b)localObject4).type == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject3 = o.ahC().a((byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
          break;
        }
      }
      ab.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
      ((bi)localObject6).setMsgId(l);
      localObject3 = new ud();
      ((ud)localObject3).cKE.cKF = parambi.field_msgId;
      ((ud)localObject3).cKE.cKG = l;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
      parambi = new com.tencent.mm.af.j();
      parambi.field_xml = ((dd)localObject6).field_content;
      parambi.field_title = ((j.b)localObject4).title;
      parambi.field_type = ((j.b)localObject4).type;
      parambi.field_description = ((j.b)localObject4).description;
      parambi.field_msgId = l;
      parambi.field_source = ((String)localObject5);
      al.dlL().insert(parambi);
      if (localObject1 != null)
      {
        ((b)localObject1).field_msgInfoId = l;
        ((b)localObject1).field_status = 101L;
        al.aUJ().a((b)localObject1, new String[0]);
        al.dlN().run();
        AppMethodBeat.o(27348);
        return;
      }
      al.dlN();
      ak.a.kW(l);
      AppMethodBeat.o(27348);
      return;
      label804:
      localObject1 = null;
    }
  }
  
  public static boolean alt(String paramString)
  {
    AppMethodBeat.i(27324);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27324);
      return false;
    }
    if (paramString.equals("0:0"))
    {
      AppMethodBeat.o(27324);
      return false;
    }
    AppMethodBeat.o(27324);
    return true;
  }
  
  public static int alu(String paramString)
  {
    AppMethodBeat.i(27326);
    j.b localb1 = j.b.mY(paramString);
    if (localb1 == null)
    {
      AppMethodBeat.o(27326);
      return -1;
    }
    if (!alt(localb1.cmN))
    {
      AppMethodBeat.o(27326);
      return -1;
    }
    b localb = new b();
    long l = bo.getLong(localb1.cmN, -1L);
    if (l != -1L)
    {
      al.aUJ().get(l, localb);
      paramString = localb;
      if (localb.systemRowid != l)
      {
        localb = al.aUJ().alo(localb1.cmN);
        if (localb != null)
        {
          paramString = localb;
          if (localb.field_mediaSvrId.equals(localb1.cmN)) {}
        }
        else
        {
          AppMethodBeat.o(27326);
          return -1;
        }
      }
    }
    else
    {
      localb = al.aUJ().alo(localb1.cmN);
      if (localb != null)
      {
        paramString = localb;
        if (localb.field_mediaSvrId.equals(localb1.cmN)) {}
      }
      else
      {
        AppMethodBeat.o(27326);
        return -1;
      }
    }
    if (paramString.field_totalLen == 0L)
    {
      AppMethodBeat.o(27326);
      return -1;
    }
    int i = (int)(paramString.field_offset * 100L / paramString.field_totalLen);
    AppMethodBeat.o(27326);
    return i;
  }
  
  public static b alv(String paramString)
  {
    AppMethodBeat.i(27347);
    b localb2 = new b();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27347);
      return null;
    }
    ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bo.getLong(paramString, -1L);
    b localb1;
    if (l != -1L)
    {
      al.aUJ().get(l, localb2);
      localb1 = localb2;
      if (localb2.systemRowid != l)
      {
        localb2 = al.aUJ().alo(paramString);
        if (localb2 != null)
        {
          localb1 = localb2;
          if (localb2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localb1 = null;
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      AppMethodBeat.o(27347);
      return localb1;
      localb2 = al.aUJ().alo(paramString);
      if (localb2 != null)
      {
        localb1 = localb2;
        if (localb2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localb1 = null;
      }
    }
  }
  
  public static String b(j.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(27345);
    ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
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
      if (!bo.ce(paramWXMediaMessage.fileData))
      {
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.fgw = paramWXMediaMessage.fileData.length;
        paramb = bK(paramWXMediaMessage.fileData);
        AppMethodBeat.o(27345);
        return paramb;
      }
      paramb.fgw = ((int)com.tencent.mm.vfs.e.avI(paramWXMediaMessage.filePath));
      ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.fgw);
      if (paramb.fgw > 0)
      {
        paramb.fgx = com.tencent.mm.vfs.e.cP(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(27345);
        return paramb;
      }
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 49)
    {
      paramb.type = g.LC(((WXWeWorkObject)paramWXMediaMessage).subType);
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bo.ce(paramWXMediaMessage.fileData))
      {
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " fileData:" + paramWXMediaMessage.fileData.length);
        paramb.fgw = paramWXMediaMessage.fileData.length;
        paramb = bK(paramWXMediaMessage.fileData);
        AppMethodBeat.o(27345);
        return paramb;
      }
      paramb.fgw = ((int)com.tencent.mm.vfs.e.avI(paramWXMediaMessage.filePath));
      ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " read file:" + paramWXMediaMessage.filePath + " len:" + paramb.fgw);
      if (paramb.fgw > 0)
      {
        paramb.fgx = com.tencent.mm.vfs.e.cP(paramWXMediaMessage.filePath);
        paramb = paramWXMediaMessage.filePath;
        AppMethodBeat.o(27345);
        return paramb;
      }
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!bo.ce(paramWXMediaMessage.imageData))
      {
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " fileData:" + paramWXMediaMessage.imageData.length);
        paramb.fgw = paramWXMediaMessage.imageData.length;
        paramb = bK(paramWXMediaMessage.imageData);
        AppMethodBeat.o(27345);
        return paramb;
      }
      if (!bo.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        paramb.fgw = ((int)com.tencent.mm.vfs.e.avI(paramWXMediaMessage.imagePath));
        ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " read file:" + paramWXMediaMessage.imagePath + " len:" + paramb.fgw);
        if (paramb.fgw > 0)
        {
          paramb.fgx = com.tencent.mm.vfs.e.cP(paramWXMediaMessage.imagePath);
          aw.aaz();
          paramb = com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(com.tencent.mm.model.c.YS(), "appmsg_img_" + System.currentTimeMillis()).dQJ());
          paramString = com.tencent.mm.sdk.platformtools.d.aoT(paramWXMediaMessage.imagePath);
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
              ab.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(27345);
              return null;
              bool = false;
              break;
              i = paramString.outWidth;
              break label799;
            }
          }
          if (r.g(paramWXMediaMessage.imagePath, "", true))
          {
            ab.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
            if (com.tencent.mm.vfs.e.C(paramWXMediaMessage.imagePath, paramb) < 0L)
            {
              ab.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, paramb });
              AppMethodBeat.o(27345);
              return null;
            }
            AppMethodBeat.o(27345);
            return paramb;
          }
          if ((paramString.outWidth > 960) || (paramString.outHeight > 960))
          {
            paramWXMediaMessage = com.tencent.mm.sdk.platformtools.d.d(paramWXMediaMessage.imagePath, 960, 960, false);
            if (paramWXMediaMessage == null) {}
          }
          while (com.tencent.mm.vfs.e.C(paramWXMediaMessage.imagePath, paramb) >= 0L)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.d.a(paramWXMediaMessage, 100, Bitmap.CompressFormat.JPEG, paramb, true);
              AppMethodBeat.o(27345);
              return paramb;
            }
            catch (IOException paramb)
            {
              ab.printErrStackTrace("MicroMsg.AppMsgLogic", paramb, "", new Object[0]);
              AppMethodBeat.o(27345);
              return null;
            }
            AppMethodBeat.o(27345);
            return null;
          }
          AppMethodBeat.o(27345);
          return null;
        }
        AppMethodBeat.o(27345);
        return null;
      }
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.musicUrl;
      paramb.fgv = paramWXMediaMessage.musicLowBandUrl;
      paramb.fgU = paramWXMediaMessage.musicDataUrl;
      paramb.fgV = paramWXMediaMessage.musicLowBandDataUrl;
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.videoUrl;
      paramb.fgv = paramWXMediaMessage.videoLowBandUrl;
      AppMethodBeat.o(27345);
      return null;
    }
    if (paramb.type == 5)
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      paramb.url = paramWXMediaMessage.webpageUrl;
      if (!bo.isNullOrNil(paramWXMediaMessage.extInfo)) {
        paramb.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bo.isNullOrNil(paramWXMediaMessage.canvasPageXml)) {
        paramb.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      AppMethodBeat.o(27345);
      return null;
    }
    if ((paramb.type == 36) || (paramb.type == 46) || (paramb.type == 48))
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      paramb.fiX = paramWXMediaMessage.userName;
      paramb.fiW = paramWXMediaMessage.path;
      paramb.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.ayE() != null) {
          paramb.fji = paramWXMediaMessage.ayE().bDc;
        }
        paramb.fjj = paramWXMediaMessage.field_brandIconURL;
        ab.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(paramb.fji), paramb.fjj });
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(27345);
        return null;
        if (paramb.type == 1)
        {
          paramb.title = ((WXTextObject)paramWXMediaMessage).text;
          AppMethodBeat.o(27345);
          return null;
        }
        if (paramb.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!bo.ce(paramWXMediaMessage.emojiData))
        {
          ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " fileData:" + paramWXMediaMessage.emojiData.length);
          paramb.fgw = paramWXMediaMessage.emojiData.length;
          paramb = bK(paramWXMediaMessage.emojiData);
          AppMethodBeat.o(27345);
          return paramb;
        }
        if (!bo.isNullOrNil(paramWXMediaMessage.emojiPath))
        {
          paramb.fgw = ((int)com.tencent.mm.vfs.e.avI(paramWXMediaMessage.emojiPath));
          ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + paramb.fgw);
          if (paramb.fgw > 0)
          {
            paramb.fgx = com.tencent.mm.vfs.e.cP(paramWXMediaMessage.emojiPath);
            paramb = paramWXMediaMessage.emojiPath;
            AppMethodBeat.o(27345);
            return paramb;
          }
          AppMethodBeat.o(27345);
          return null;
        }
        paramb.fgy = paramString;
      }
      if (paramb.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.fhg = paramWXMediaMessage.packageflag;
        paramb.fhf = paramWXMediaMessage.packageid;
        paramb.showType = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(27345);
        return null;
      }
      if (paramb.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.fhg = paramWXMediaMessage.packageflag;
        paramb.fhf = paramWXMediaMessage.packageid;
        paramb.showType = 8;
        paramb.url = paramWXMediaMessage.url;
        AppMethodBeat.o(27345);
        return null;
      }
      if (paramb.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        paramb.thumburl = paramWXMediaMessage.thumburl;
        paramb.url = paramWXMediaMessage.url;
        paramb.fiL = paramWXMediaMessage.designerUIN;
        paramb.designerName = paramWXMediaMessage.designerName;
        paramb.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        paramb.showType = 18;
        AppMethodBeat.o(27345);
        return null;
      }
    } while ((paramb.type != 27) && (paramb.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    paramb.thumburl = paramWXMediaMessage.iconUrl;
    paramb.url = paramWXMediaMessage.url;
    paramb.tid = paramWXMediaMessage.tid;
    paramb.fiM = paramWXMediaMessage.title;
    paramb.desc = paramWXMediaMessage.desc;
    paramb.iconUrl = paramWXMediaMessage.iconUrl;
    paramb.secondUrl = paramWXMediaMessage.secondUrl;
    paramb.pageType = paramWXMediaMessage.pageType;
    paramb.showType = 20;
    AppMethodBeat.o(27345);
    return null;
  }
  
  public static String bK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27344);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " attachBuf is null");
      AppMethodBeat.o(27344);
      return null;
    }
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = com.tencent.mm.model.c.YS() + "ua_" + bo.aoy();
    ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " buildUploadAttachInfo file:" + (String)localObject);
    if (com.tencent.mm.vfs.e.b((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " writeFile error file:" + (String)localObject);
      AppMethodBeat.o(27344);
      return null;
    }
    AppMethodBeat.o(27344);
    return localObject;
  }
  
  public static int c(j.b paramb)
  {
    AppMethodBeat.i(27349);
    if (paramb == null)
    {
      AppMethodBeat.o(27349);
      return 49;
    }
    int i = paramb.type;
    int j = paramb.showType;
    int k = paramb.fgh;
    int m = paramb.fgW;
    int n = paramb.fiq;
    ab.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + j + " atype " + i + ", itemShowType = " + k + ", c2cNewAAType = " + n);
    if ((k == 4) || (m != 0))
    {
      AppMethodBeat.o(27349);
      return 318767153;
    }
    if (i == 2001)
    {
      if (j == 1)
      {
        AppMethodBeat.o(27349);
        return 469762097;
      }
      if (n == 4)
      {
        AppMethodBeat.o(27349);
        return 503316529;
      }
      AppMethodBeat.o(27349);
      return 436207665;
    }
    if (i == 2002)
    {
      AppMethodBeat.o(27349);
      return 536870961;
    }
    switch (j)
    {
    default: 
      switch (i)
      {
      default: 
        AppMethodBeat.o(27349);
        return 49;
      }
    case 1: 
      if (i == 21)
      {
        AppMethodBeat.o(27349);
        return -1879048185;
      }
      AppMethodBeat.o(27349);
      return 285212721;
    case 2: 
      if (i == 21)
      {
        AppMethodBeat.o(27349);
        return -1879048183;
      }
      AppMethodBeat.o(27349);
      return 301989937;
    case 3: 
      if (i == 21)
      {
        AppMethodBeat.o(27349);
        return -1879048176;
      }
      AppMethodBeat.o(27349);
      return -1879048189;
    case 4: 
      if (i == 21)
      {
        AppMethodBeat.o(27349);
        return -1879048183;
      }
      AppMethodBeat.o(27349);
      return -1879048190;
    case 5: 
      AppMethodBeat.o(27349);
      return -1879048191;
    }
    AppMethodBeat.o(27349);
    return -1879048186;
    AppMethodBeat.o(27349);
    return 268435505;
    AppMethodBeat.o(27349);
    return 16777265;
    AppMethodBeat.o(27349);
    return 1048625;
    AppMethodBeat.o(27349);
    return 335544369;
    AppMethodBeat.o(27349);
    return 402653233;
    AppMethodBeat.o(27349);
    return 369098801;
    AppMethodBeat.o(27349);
    return 452984881;
    AppMethodBeat.o(27349);
    return -1879048186;
    AppMethodBeat.o(27349);
    return 419430449;
    AppMethodBeat.o(27349);
    return 520093745;
    com.tencent.mm.af.a locala = (com.tencent.mm.af.a)paramb.R(com.tencent.mm.af.a.class);
    if ((locala != null) && (locala.ffc) && ((paramb.fiZ == 2) || (paramb.fiZ == 3)))
    {
      AppMethodBeat.o(27349);
      return 553648177;
    }
    if ((locala != null) && (locala.fff) && (paramb.fiZ == 3))
    {
      AppMethodBeat.o(27349);
      return 587202609;
    }
    AppMethodBeat.o(27349);
    return 49;
    AppMethodBeat.o(27349);
    return 687865905;
    AppMethodBeat.o(27349);
    return 738197553;
    AppMethodBeat.o(27349);
    return 671088689;
    AppMethodBeat.o(27349);
    return 704643121;
  }
  
  public static b d(bi parambi, String paramString)
  {
    AppMethodBeat.i(27346);
    b localb = alv(paramString);
    if (localb == null)
    {
      s(parambi.field_msgId, parambi.field_content);
      parambi = alv(paramString);
      AppMethodBeat.o(27346);
      return parambi;
    }
    AppMethodBeat.o(27346);
    return localb;
  }
  
  public static boolean d(String paramString, bi parambi)
  {
    AppMethodBeat.i(27330);
    if (parambi == null)
    {
      AppMethodBeat.o(27330);
      return false;
    }
    boolean bool2 = true;
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str5 = null;
    String str1 = null;
    Object localObject1 = q(paramString, parambi.field_msgId);
    Object localObject2 = j.b.mY(parambi.field_content);
    if (localObject2 != null)
    {
      str3 = ah.nullAsNil(((j.b)localObject2).title);
      str4 = ah.nullAsNil(((j.b)localObject2).fgx).toLowerCase();
      str2 = ah.nullAsNil(((j.b)localObject2).filemd5);
      str5 = ah.nullAsNil(((j.b)localObject2).czp);
      str1 = ah.nullAsNil(((j.b)localObject2).ewj);
    }
    if (localObject1 == null)
    {
      s(parambi.field_msgId, parambi.field_content);
      parambi = q(paramString, parambi.field_msgId);
      paramString = parambi;
      bool1 = bool2;
      if (parambi != null)
      {
        l1 = parambi.systemRowid;
        l2 = parambi.field_totalLen;
        paramString = parambi.field_fileFullPath;
        l3 = parambi.field_type;
        localObject1 = parambi.field_mediaId;
        l4 = parambi.field_msgInfoId;
        bool1 = parambi.field_isUpload;
        if (parambi.field_signature != null) {
          break label353;
        }
        i = -1;
        ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambi;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((j.b)localObject2).fgA == 0)
          {
            paramString = parambi;
            bool1 = bool2;
            if (((j.b)localObject2).fgw <= 26214400) {}
          }
          else
          {
            if (ah.isNullOrNil(parambi.field_signature)) {
              break label364;
            }
          }
        }
      }
      label353:
      label364:
      for (bool1 = true;; bool1 = false)
      {
        paramString = parambi;
        if (!bool1) {
          aw.Rc().a(new com.tencent.mm.plugin.record.b.c(paramString, str1, str2, str3, str4, str5), 0);
        }
        AppMethodBeat.o(27330);
        return bool1;
        i = parambi.field_signature.length();
        break;
      }
    }
    paramString = new com.tencent.mm.vfs.b(((b)localObject1).field_fileFullPath);
    if ((((b)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      s(parambi.field_msgId, parambi.field_content);
    }
    long l1 = ((b)localObject1).systemRowid;
    long l2 = ((b)localObject1).field_totalLen;
    parambi = ((b)localObject1).field_fileFullPath;
    long l3 = ((b)localObject1).field_type;
    localObject2 = ((b)localObject1).field_mediaId;
    long l4 = ((b)localObject1).field_msgInfoId;
    boolean bool1 = ((b)localObject1).field_isUpload;
    boolean bool3 = paramString.exists();
    long l5 = ((b)localObject1).field_status;
    if (((b)localObject1).field_signature == null) {}
    for (int i = -1;; i = ((b)localObject1).field_signature.length())
    {
      ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambi, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
      paramString = (String)localObject1;
      bool1 = bool2;
      break;
    }
  }
  
  public static void kX(long paramLong)
  {
    AppMethodBeat.i(27325);
    al.aUJ().nv(paramLong);
    b localb = new b();
    al.aUJ().get(paramLong, localb);
    if (localb.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(27325);
      return;
    }
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(localb.field_msgInfoId);
    if (localbi.field_msgId != localb.field_msgInfoId)
    {
      AppMethodBeat.o(27325);
      return;
    }
    localbi.setStatus(5);
    aw.aaz();
    com.tencent.mm.model.c.YC().a(localbi.field_msgId, localbi);
    AppMethodBeat.o(27325);
  }
  
  public static b q(String paramString, long paramLong)
  {
    AppMethodBeat.i(27331);
    b localb = alv(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = al.aUJ().nw(paramLong);
    }
    if (paramString != null) {
      ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), ah.aoA() });
    }
    for (;;)
    {
      AppMethodBeat.o(27331);
      return paramString;
      ab.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { ah.aoA() });
    }
  }
  
  public static String s(long paramLong, String paramString)
  {
    AppMethodBeat.i(27327);
    ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = j.b.mY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(27327);
      return null;
    }
    String str = Z(com.tencent.mm.compatible.util.e.esq, paramString.title, paramString.fgx);
    if ((bo.isNullOrNil(paramString.cmN)) && (!bo.isNullOrNil(paramString.fgL))) {
      paramString.cmN = paramString.fgL.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.cmN, paramString.fgw, paramString.type, paramString.fgA);
    AppMethodBeat.o(27327);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */