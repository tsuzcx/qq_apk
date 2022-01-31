package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.sl;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
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
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.j;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static ac rUs;
  
  public static String A(long paramLong, String paramString)
  {
    y.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = g.a.gp(paramString);
    if (paramString == null) {
      return null;
    }
    String str1 = aj(com.tencent.mm.compatible.util.e.dzB, paramString.title, paramString.dQw);
    if ((bk.bl(paramString.bFE)) && (!bk.bl(paramString.dQK))) {
      paramString.bFE = paramString.dQK.hashCode();
    }
    int i = paramString.sdkVer;
    String str2 = paramString.appId;
    String str3 = paramString.bFE;
    int j = paramString.dQv;
    int k = paramString.type;
    String str4 = paramString.dQR;
    return a(str1, paramLong, i, str2, str3, j, k, paramString.dQz);
  }
  
  public static int DK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static boolean VV(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (paramString.equals("0:0")) {
      return false;
    }
    return true;
  }
  
  public static int VW(String paramString)
  {
    g.a locala = g.a.gp(paramString);
    if (locala == null) {
      return -1;
    }
    if (!VV(locala.bFE)) {
      return -1;
    }
    b localb = new b();
    long l = bk.getLong(locala.bFE, -1L);
    if (l != -1L)
    {
      ap.avh().b(l, localb);
      paramString = localb;
      if (localb.ujK != l)
      {
        localb = ap.avh().VQ(locala.bFE);
        if (localb != null)
        {
          paramString = localb;
          if (localb.field_mediaSvrId.equals(locala.bFE)) {}
        }
        else
        {
          return -1;
        }
      }
    }
    else
    {
      localb = ap.avh().VQ(locala.bFE);
      if (localb != null)
      {
        paramString = localb;
        if (localb.field_mediaSvrId.equals(locala.bFE)) {}
      }
      else
      {
        return -1;
      }
    }
    if (paramString.field_totalLen == 0L) {
      return -1;
    }
    return (int)(paramString.field_offset * 100L / paramString.field_totalLen);
  }
  
  public static b VX(String paramString)
  {
    b localb2 = new b();
    if (bk.bl(paramString)) {
      return null;
    }
    y.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
    long l = bk.getLong(paramString, -1L);
    b localb1;
    if (l != -1L)
    {
      ap.avh().b(l, localb2);
      localb1 = localb2;
      if (localb2.ujK != l)
      {
        localb2 = ap.avh().VQ(paramString);
        if (localb2 != null)
        {
          localb1 = localb2;
          if (localb2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          y.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
          localb1 = null;
        }
      }
    }
    for (;;)
    {
      y.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
      return localb1;
      localb2 = ap.avh().VQ(paramString);
      if (localb2 != null)
      {
        localb1 = localb2;
        if (localb2.field_mediaSvrId.equals(paramString)) {}
      }
      else
      {
        y.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
        localb1 = null;
      }
    }
  }
  
  public static int a(long paramLong, String paramString, d paramd)
  {
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (localbi.field_msgId != paramLong)
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " getmsgFailed id:" + paramLong);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    g.a locala = g.a.gp(localbi.field_content);
    if (locala == null)
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " getmsgFailed id:" + paramLong);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    locala.bFE = paramString;
    label161:
    label184:
    int i;
    if (paramd != null)
    {
      if (paramd.field_aesKey != "") {
        break label344;
      }
      str = locala.dQR;
      locala.dQR = str;
      if (paramd.field_fileId != "") {
        break label353;
      }
      str = locala.dQK;
      locala.dQK = str;
      if (paramd.field_filemd5 != "") {
        break label362;
      }
      str = locala.filemd5;
      locala.filemd5 = str;
      if (paramd.field_fileLength != 0) {
        break label371;
      }
      i = locala.dQv;
      label205:
      locala.dQv = i;
      if (paramd.field_thumbUrl != "") {
        break label380;
      }
    }
    label344:
    label353:
    label362:
    label371:
    label380:
    for (String str = locala.dQL;; str = paramd.field_thumbUrl)
    {
      locala.dQL = str;
      localbi.setContent(g.a.a(locala, locala.bFE, paramd));
      au.Hx();
      com.tencent.mm.model.c.Fy().a(localbi.field_msgId, localbi);
      paramd = ap.clc().gZ(paramLong);
      if (paramd != null)
      {
        paramd.field_xml = localbi.field_content;
        ap.clc().c(paramd, new String[] { "msgId" });
      }
      paramd = ap.avh().gY(paramLong);
      paramd.field_mediaSvrId = paramString;
      paramd.field_offset = paramd.field_totalLen;
      ap.avh().c(paramd, new String[0]);
      return 0;
      str = paramd.field_aesKey;
      break;
      str = paramd.field_fileId;
      break label161;
      str = paramd.field_filemd5;
      break label184;
      i = paramd.field_fileLength;
      break label205;
    }
  }
  
  public static int a(g.a parama, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    return a(parama, paramWXMediaMessage, paramString, null, null);
  }
  
  private static int a(g.a parama, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = b(parama, paramWXMediaMessage, paramString2);
    y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + "summerbig content url:" + parama.url + " lowUrl:" + parama.dQu + " attachlen:" + parama.dQv + " attachid:" + parama.bFE + " attach file:" + (String)localObject2);
    Object localObject1 = System.currentTimeMillis();
    if (!bk.bl((String)localObject2))
    {
      localObject1 = a((String)localObject1, parama, (String)localObject2);
      if (localObject1 == null) {
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      localObject2 = com.tencent.mm.sdk.platformtools.c.YU((String)localObject2);
      if (localObject2 != null)
      {
        parama.dQQ = ((BitmapFactory.Options)localObject2).outWidth;
        parama.dQP = ((BitmapFactory.Options)localObject2).outHeight;
      }
    }
    for (;;)
    {
      bi localbi = new bi();
      boolean bool;
      if ((paramWXMediaMessage.thumbData != null) && (paramWXMediaMessage.thumbData.length > 0))
      {
        if ((paramWXMediaMessage.thumbData.length <= 32768) || (paramWXMediaMessage.getType() == 36)) {
          break label493;
        }
        if (parama.type != 2) {
          break label487;
        }
        bool = true;
        localObject2 = o.OJ().a(6, paramWXMediaMessage.thumbData, bool, Bitmap.CompressFormat.JPEG);
        label243:
        y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " summerbig thumbData MsgInfo path:" + (String)localObject2);
        if (!bk.bl((String)localObject2)) {
          localbi.ed((String)localObject2);
        }
      }
      if (localObject1 != null) {
        parama.bFE = ((b)localObject1).ujK;
      }
      paramString1 = bk.G(paramString1.split(",")).iterator();
      for (;;)
      {
        if (!paramString1.hasNext()) {
          break label799;
        }
        localObject2 = (String)paramString1.next();
        parama.dQx = paramString2;
        localbi.setContent(g.a.a(parama, null, null));
        localbi.setStatus(1);
        localbi.ec((String)localObject2);
        localbi.bg(bd.iK((String)localObject2));
        localbi.fA(1);
        localbi.setType(d(parama));
        if (f.eW(localbi.field_talker)) {
          localbi.cY(com.tencent.mm.ai.a.e.HR());
        }
        au.Hx();
        long l = com.tencent.mm.model.c.Fy().T(localbi);
        if (l < 0L)
        {
          y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " summerbig insert msg failed :" + l);
          return 0 - com.tencent.mm.compatible.util.g.getLine();
          label487:
          bool = false;
          break;
          label493:
          localObject2 = o.OJ().g(6, paramWXMediaMessage.thumbData);
          break label243;
        }
        y.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " summerbig new msg inserted to db , local id = " + l);
        localbi.setMsgId(l);
        localObject2 = new com.tencent.mm.ae.g();
        ((com.tencent.mm.ae.g)localObject2).field_xml = localbi.field_content;
        ((com.tencent.mm.ae.g)localObject2).field_title = paramWXMediaMessage.title;
        ((com.tencent.mm.ae.g)localObject2).field_type = paramWXMediaMessage.mediaObject.type();
        ((com.tencent.mm.ae.g)localObject2).field_description = paramWXMediaMessage.description;
        ((com.tencent.mm.ae.g)localObject2).field_msgId = l;
        ((com.tencent.mm.ae.g)localObject2).field_source = parama.appName;
        ap.clc().b((com.tencent.mm.sdk.e.c)localObject2);
        if (localObject1 != null)
        {
          ((b)localObject1).field_msgInfoId = l;
          ((b)localObject1).field_status = 101L;
          y.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", new Object[] { Long.valueOf(((b)localObject1).field_msgInfoId), Long.valueOf(((b)localObject1).field_status), Long.valueOf(((b)localObject1).ujK), Integer.valueOf(((com.tencent.mm.ae.g)localObject2).field_type) });
          ap.avh().c((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
          if (!bk.bl(paramString3)) {
            ap.cle().B(((b)localObject1).field_msgInfoId, paramString3);
          }
          ap.cle().run();
        }
        else
        {
          y.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", new Object[] { localObject1, Long.valueOf(l), paramString3, Integer.valueOf(((com.tencent.mm.ae.g)localObject2).field_type) });
          ap.cle();
          ao.a.C(l, paramString3);
        }
      }
      label799:
      return 0;
      localObject1 = null;
    }
  }
  
  public static int a(g.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    return a(parama, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, null);
  }
  
  public static int a(g.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5)
  {
    return a(parama, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramString5, "");
  }
  
  public static int a(g.a parama, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5, String paramString6)
  {
    y.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", new Object[] { paramString4, parama });
    String str = null;
    Object localObject = System.currentTimeMillis();
    if (!bk.bl(paramString4))
    {
      paramString4 = a((String)localObject, parama, paramString4);
      str = paramString4;
      if (paramString4 == null) {
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
    }
    localObject = new bi();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((parama.type != 33) && (parama.type != 36)) {
        break label432;
      }
      int i = (int)(com.tencent.mm.sdk.platformtools.c.cqp().density * 240.0F);
      int j = (int)(com.tencent.mm.sdk.platformtools.c.cqp().density * 240.0F);
      paramString4 = o.OJ().a(paramArrayOfByte, Bitmap.CompressFormat.JPEG, i, j);
      y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + paramString4);
      if (!bk.bl(paramString4))
      {
        ((bi)localObject).ed(paramString4);
        y.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + paramString4);
      }
    }
    if (str != null) {
      parama.bFE = str.ujK;
    }
    ((bi)localObject).setContent(g.a.a(parama, null, null));
    ((bi)localObject).setStatus(1);
    ((bi)localObject).ec(paramString3);
    ((bi)localObject).bg(bd.iK(paramString3));
    ((bi)localObject).fA(1);
    ((bi)localObject).setType(d(parama));
    if (f.eW(((cs)localObject).field_talker))
    {
      ((bi)localObject).cY(com.tencent.mm.ai.a.e.HR());
      y.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((cs)localObject).czr });
    }
    au.Hx();
    long l = com.tencent.mm.model.c.Fy().T((bi)localObject);
    y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " msginfo insert id: " + l);
    label432:
    boolean bool;
    if (l < 0L)
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
      if (parama.type == 2) {}
      for (bool = true;; bool = false)
      {
        paramString4 = o.OJ().a(6, paramArrayOfByte, bool, Bitmap.CompressFormat.PNG);
        break;
      }
    }
    y.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    ((bi)localObject).setMsgId(l);
    paramString3 = new com.tencent.mm.ae.g();
    paramString3.field_xml = ((cs)localObject).field_content;
    paramString3.field_appId = paramString1;
    paramString3.field_title = parama.title;
    paramString3.field_type = parama.type;
    paramString3.field_description = parama.description;
    paramString3.field_msgId = l;
    paramString3.field_source = paramString2;
    ap.clc().b(paramString3);
    if (str == null)
    {
      bool = true;
      y.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attInfo is null[%b]", new Object[] { Boolean.valueOf(bool) });
      if (str == null) {
        break label674;
      }
      str.field_msgInfoId = l;
      str.field_status = 101L;
      ap.avh().c(str, new String[0]);
      if ((parama.type == 2) || (!bk.bl(paramString5))) {
        ap.cle().B(l, paramString5);
      }
      ap.cle().run();
    }
    for (;;)
    {
      return 0;
      bool = false;
      break;
      label674:
      ap.cle();
      ao.a.b(l, paramString5, paramString6);
    }
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    return a(paramWXMediaMessage, paramString1, paramString2, paramString3, paramInt, paramString4, null);
  }
  
  public static int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    g.a locala = new g.a();
    locala.appId = paramString1;
    locala.appName = paramString2;
    locala.dQy = paramInt;
    return a(locala, paramWXMediaMessage, paramString3, paramString4, paramString5);
  }
  
  public static b a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bk.UY();
    localb.field_lastModifyTime = bk.UX();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    return localb;
  }
  
  public static b a(String paramString1, g.a parama, String paramString2)
  {
    y.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " summerbig buildUploadAttachInfo clientAppDataId:" + paramString1 + " attach file :" + paramString2);
    Object localObject = paramString2.replace("//", "/");
    if (((String)localObject).startsWith(com.tencent.mm.compatible.util.e.dOO))
    {
      y.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", new Object[] { localObject });
      return null;
    }
    localObject = new b();
    ((b)localObject).field_totalLen = parama.dQv;
    ((b)localObject).field_fileFullPath = paramString2;
    ((b)localObject).field_sdkVer = parama.sdkVer;
    ((b)localObject).field_appId = parama.appId;
    ((b)localObject).field_clientAppDataId = paramString1;
    ((b)localObject).field_type = parama.type;
    ((b)localObject).field_status = 200L;
    ((b)localObject).field_isUpload = true;
    ((b)localObject).field_createTime = bk.UY();
    ((b)localObject).field_lastModifyTime = bk.UX();
    ((b)localObject).field_mediaSvrId = bk.UY();
    ap.avh().b((com.tencent.mm.sdk.e.c)localObject);
    y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " summerbig buildUploadAttachInfo file:" + ((b)localObject).field_fileFullPath + " rowid:" + ((b)localObject).ujK + " clientAppDataId:" + ((b)localObject).field_clientAppDataId);
    if (((b)localObject).ujK < 0L)
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " summerbig uploadAttach insert appattach info failed :" + ((b)localObject).ujK);
      return null;
    }
    return localObject;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    b localb = new b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bk.UY();
    localb.field_lastModifyTime = bk.UX();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    localb.field_type = paramInt3;
    y.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(ap.avh().b(localb)), Long.valueOf(localb.ujK), Long.valueOf(localb.field_totalLen), Long.valueOf(localb.field_type), Integer.valueOf(paramInt4), paramString1, bk.csb() });
    return paramString3;
  }
  
  public static void a(bi parambi, l.a parama)
  {
    Object localObject = g.a.gp(parambi.field_content);
    if (localObject == null) {
      y.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambi.field_content });
    }
    do
    {
      return;
      if ((bk.bl(((g.a)localObject).bFE)) && (!bk.bl(((g.a)localObject).dQK)))
      {
        y.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambi.field_content });
        ((g.a)localObject).bFE = ((g.a)localObject).dQK.hashCode();
      }
      localObject = ((g.a)localObject).bFE;
    } while ((a(parambi, ap((String)localObject, parambi.field_msgId))) || (!d((String)localObject, parambi)));
    rUs = new ac(parambi.field_msgId, (String)localObject, new com.tencent.mm.ah.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
      {
        if (this.rUt != null) {
          this.rUt.eT(paramAnonymousInt1, paramAnonymousInt2);
        }
      }
    });
    au.Dk().a(rUs, 0);
  }
  
  public static boolean a(bi parambi, b paramb)
  {
    if ((paramb == null) || (com.tencent.mm.vfs.e.bK(paramb.field_fileFullPath))) {}
    while ((!paramb.aXY()) && ((parambi.field_isSend != 1) || (!paramb.field_isUpload))) {
      return false;
    }
    return true;
  }
  
  public static void ae(bi parambi)
  {
    Object localObject4 = g.a.gp(parambi.field_content);
    if (localObject4 == null)
    {
      y.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
      return;
    }
    Object localObject5 = VX(((g.a)localObject4).bFE);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject5 != null)
    {
      localObject1 = localObject2;
      if (((b)localObject5).field_fileFullPath != null)
      {
        localObject1 = localObject2;
        if (!((b)localObject5).field_fileFullPath.equals(""))
        {
          au.Hx();
          localObject1 = aj(com.tencent.mm.model.c.FO(), ((g.a)localObject4).title, ((g.a)localObject4).dQw);
          com.tencent.mm.vfs.e.r(((b)localObject5).field_fileFullPath, (String)localObject1);
        }
      }
    }
    if ((parambi.field_imgPath != null) && (!parambi.field_imgPath.equals(""))) {}
    String str;
    for (localObject2 = o.OJ().F(parambi.field_imgPath, true);; localObject3 = null) {
      try
      {
        localObject2 = com.tencent.mm.vfs.e.c((String)localObject2, 0, -1);
        localObject5 = g.a.a((g.a)localObject4);
        str = ((g.a)localObject4).appId;
        str = ((g.a)localObject4).appName;
        localObject4 = System.currentTimeMillis();
        if (bk.bl((String)localObject1)) {
          break;
        }
        localObject4 = a((String)localObject4, (g.a)localObject5, (String)localObject1);
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label232;
        }
        com.tencent.mm.compatible.util.g.getLine();
        return;
      }
      catch (Exception localException) {}
    }
    localObject1 = null;
    label232:
    localObject4 = new bi();
    if ((localObject3 != null) && (localObject3.length > 0)) {
      if (((g.a)localObject5).type != 2) {
        break label559;
      }
    }
    long l;
    label559:
    for (boolean bool = true;; bool = false)
    {
      localObject3 = o.OJ().a(6, (byte[])localObject3, bool, Bitmap.CompressFormat.PNG);
      y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + (String)localObject3);
      if (!bk.bl((String)localObject3))
      {
        ((bi)localObject4).ed((String)localObject3);
        y.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + (String)localObject3);
      }
      if (localObject1 != null) {
        ((g.a)localObject5).bFE = ((b)localObject1).ujK;
      }
      ((bi)localObject4).setContent(g.a.a((g.a)localObject5, null, null));
      ((bi)localObject4).setStatus(1);
      ((bi)localObject4).ec(parambi.field_talker);
      ((bi)localObject4).bg(bd.iK(parambi.field_talker));
      ((bi)localObject4).fA(1);
      ((bi)localObject4).setType(d((g.a)localObject5));
      if (f.eW(((cs)localObject4).field_talker))
      {
        ((bi)localObject4).cY(com.tencent.mm.ai.a.e.HR());
        y.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[] { ((cs)localObject4).czr });
      }
      au.Hx();
      l = com.tencent.mm.model.c.Fy().T((bi)localObject4);
      y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break;
      }
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      com.tencent.mm.compatible.util.g.getLine();
      return;
    }
    y.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    ((bi)localObject4).setMsgId(l);
    Object localObject3 = new sl();
    ((sl)localObject3).cbY.cbZ = parambi.field_msgId;
    ((sl)localObject3).cbY.cca = l;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
    parambi = new com.tencent.mm.ae.g();
    parambi.field_xml = ((cs)localObject4).field_content;
    parambi.field_title = ((g.a)localObject5).title;
    parambi.field_type = ((g.a)localObject5).type;
    parambi.field_description = ((g.a)localObject5).description;
    parambi.field_msgId = l;
    parambi.field_source = str;
    ap.clc().b(parambi);
    if (localObject1 != null)
    {
      ((b)localObject1).field_msgInfoId = l;
      ((b)localObject1).field_status = 101L;
      ap.avh().c((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
      ap.cle().run();
      return;
    }
    ap.cle();
    ao.a.hd(l);
  }
  
  public static String aj(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    Object localObject = new com.tencent.mm.vfs.b(paramString1);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    if (bk.bl(paramString2)) {
      paramString2 = paramString1 + "da_" + bk.UY();
    }
    do
    {
      paramString3 = paramString2;
      try
      {
        if (!j.n(new com.tencent.mm.vfs.b(paramString2).cLq().cLr()).equalsIgnoreCase(j.n(new com.tencent.mm.vfs.b(paramString1).cLr())))
        {
          paramString3 = paramString1 + "da_" + bk.UY();
          y.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { paramString3 });
        }
        return paramString3;
      }
      catch (Exception paramString2)
      {
        y.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
      }
      localObject = paramString2;
      if (!bk.bl(paramString3))
      {
        localObject = paramString2;
        if (!paramString2.endsWith(paramString3)) {
          localObject = paramString2 + "." + paramString3;
        }
      }
      paramString3 = paramString1 + (String)localObject;
      paramString2 = paramString3;
    } while (!com.tencent.mm.vfs.e.bK(paramString3));
    for (;;)
    {
      paramString2 = paramString3;
      if (i < 20)
      {
        if (!com.tencent.mm.vfs.e.bK(paramString1 + i + "_" + (String)localObject)) {
          paramString2 = paramString1 + i + "_" + (String)localObject;
        }
      }
      else
      {
        if (i != 20) {
          break;
        }
        paramString2 = paramString1 + "da_" + bk.UY();
        break;
      }
      i += 1;
    }
    return paramString1 + "da_" + bk.UY();
  }
  
  public static b ap(String paramString, long paramLong)
  {
    b localb = VX(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = ap.avh().gY(paramLong);
    }
    if (paramString != null)
    {
      y.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.ujK), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), ah.Vb() });
      return paramString;
    }
    y.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { ah.Vb() });
    return paramString;
  }
  
  public static String b(g.a parama, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + "mediaMessageToContent sdkver:" + paramWXMediaMessage.sdkVer + " title:" + paramWXMediaMessage.title + " desc:" + paramWXMediaMessage.description + " type:" + paramWXMediaMessage.mediaObject.type());
    parama.sdkVer = paramWXMediaMessage.sdkVer;
    parama.title = paramWXMediaMessage.title;
    parama.description = paramWXMediaMessage.description;
    parama.mediaTagName = paramWXMediaMessage.mediaTagName;
    parama.messageAction = paramWXMediaMessage.messageAction;
    parama.messageExt = paramWXMediaMessage.messageExt;
    paramWXMediaMessage = paramWXMediaMessage.mediaObject;
    parama.type = paramWXMediaMessage.type();
    if (parama.type == 7)
    {
      paramWXMediaMessage = (WXAppExtendObject)paramWXMediaMessage;
      parama.extInfo = paramWXMediaMessage.extInfo;
      if (!bk.bE(paramWXMediaMessage.fileData))
      {
        y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " fileData:" + paramWXMediaMessage.fileData.length);
        parama.dQv = paramWXMediaMessage.fileData.length;
        return bj(paramWXMediaMessage.fileData);
      }
      parama.dQv = ((int)com.tencent.mm.vfs.e.aeQ(paramWXMediaMessage.filePath));
      y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " read file:" + paramWXMediaMessage.filePath + " len:" + parama.dQv);
      if (parama.dQv > 0)
      {
        parama.dQw = com.tencent.mm.vfs.e.bM(paramWXMediaMessage.filePath);
        return paramWXMediaMessage.filePath;
      }
      return null;
    }
    if (parama.type == 6)
    {
      paramWXMediaMessage = (WXFileObject)paramWXMediaMessage;
      if (!bk.bE(paramWXMediaMessage.fileData))
      {
        y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " fileData:" + paramWXMediaMessage.fileData.length);
        parama.dQv = paramWXMediaMessage.fileData.length;
        return bj(paramWXMediaMessage.fileData);
      }
      parama.dQv = ((int)com.tencent.mm.vfs.e.aeQ(paramWXMediaMessage.filePath));
      y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " read file:" + paramWXMediaMessage.filePath + " len:" + parama.dQv);
      if (parama.dQv > 0)
      {
        parama.dQw = com.tencent.mm.vfs.e.bM(paramWXMediaMessage.filePath);
        return paramWXMediaMessage.filePath;
      }
      return null;
    }
    if (parama.type == 2)
    {
      paramWXMediaMessage = (WXImageObject)paramWXMediaMessage;
      if (!bk.bE(paramWXMediaMessage.imageData))
      {
        y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " fileData:" + paramWXMediaMessage.imageData.length);
        parama.dQv = paramWXMediaMessage.imageData.length;
        return bj(paramWXMediaMessage.imageData);
      }
      if (!bk.bl(paramWXMediaMessage.imagePath))
      {
        parama.dQv = ((int)com.tencent.mm.vfs.e.aeQ(paramWXMediaMessage.imagePath));
        y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " read file:" + paramWXMediaMessage.imagePath + " len:" + parama.dQv);
        if (parama.dQv > 0)
        {
          parama.dQw = com.tencent.mm.vfs.e.bM(paramWXMediaMessage.imagePath);
          au.Hx();
          parama = j.n(new com.tencent.mm.vfs.b(com.tencent.mm.model.c.FO(), "appmsg_img_" + System.currentTimeMillis()).cLr());
          paramString = com.tencent.mm.sdk.platformtools.c.YU(paramWXMediaMessage.imagePath);
          if ((paramString == null) || (paramString.outWidth <= 0) || (paramString.outHeight <= 0))
          {
            boolean bool;
            int i;
            if (paramString == null)
            {
              bool = true;
              if (paramString != null) {
                break label760;
              }
              i = -1;
              label710:
              if (paramString != null) {
                break label768;
              }
            }
            label768:
            for (int j = -1;; j = paramString.outHeight)
            {
              y.e("MicroMsg.AppMsgLogic", "options is null! %B, bitmapWidth = %d, bitmapHeight = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
              return null;
              bool = false;
              break;
              label760:
              i = paramString.outWidth;
              break label710;
            }
          }
          if (q.g(paramWXMediaMessage.imagePath, "", true))
          {
            y.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", new Object[] { paramWXMediaMessage.imagePath, parama });
            if (com.tencent.mm.vfs.e.r(paramWXMediaMessage.imagePath, parama) < 0L)
            {
              y.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", new Object[] { paramWXMediaMessage.imagePath, parama });
              return null;
            }
            return parama;
          }
          if ((paramString.outWidth > 960) || (paramString.outHeight > 960))
          {
            paramString = new MMBitmapFactory.DecodeResultLogger();
            localBitmap = com.tencent.mm.sdk.platformtools.c.a(paramWXMediaMessage.imagePath, 960, 960, false, paramString, 0);
            if (localBitmap == null) {}
          }
          while (com.tencent.mm.vfs.e.r(paramWXMediaMessage.imagePath, parama) >= 0L)
          {
            try
            {
              Bitmap localBitmap;
              com.tencent.mm.sdk.platformtools.c.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, parama, true);
              return parama;
            }
            catch (IOException parama)
            {
              y.printErrStackTrace("MicroMsg.AppMsgLogic", parama, "", new Object[0]);
              return null;
            }
            if (paramString.getDecodeResult() >= 2000)
            {
              parama = MMBitmapFactory.KVStatHelper.getKVStatString(paramWXMediaMessage.imagePath, 6, paramString);
              h.nFQ.aC(12712, parama);
            }
            return null;
          }
          return null;
        }
        return null;
      }
      return null;
    }
    if (parama.type == 3)
    {
      paramWXMediaMessage = (WXMusicObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.musicUrl;
      parama.dQu = paramWXMediaMessage.musicLowBandUrl;
      parama.dQU = paramWXMediaMessage.musicDataUrl;
      parama.dQV = paramWXMediaMessage.musicLowBandDataUrl;
      return null;
    }
    if (parama.type == 4)
    {
      paramWXMediaMessage = (WXVideoObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.videoUrl;
      parama.dQu = paramWXMediaMessage.videoLowBandUrl;
      return null;
    }
    if (parama.type == 5)
    {
      paramWXMediaMessage = (WXWebpageObject)paramWXMediaMessage;
      parama.url = paramWXMediaMessage.webpageUrl;
      if (!bk.bl(paramWXMediaMessage.extInfo)) {
        parama.extInfo = paramWXMediaMessage.extInfo;
      }
      if (!bk.bl(paramWXMediaMessage.canvasPageXml)) {
        parama.canvasPageXml = paramWXMediaMessage.canvasPageXml;
      }
      return null;
    }
    if (parama.type == 36)
    {
      paramWXMediaMessage = (WXMiniProgramObject)paramWXMediaMessage;
      parama.dSY = paramWXMediaMessage.userName;
      parama.dSX = paramWXMediaMessage.path;
      parama.url = paramWXMediaMessage.webpageUrl;
      paramWXMediaMessage = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(paramWXMediaMessage.userName);
      if (paramWXMediaMessage != null)
      {
        if (paramWXMediaMessage.aep() != null) {
          parama.dTg = paramWXMediaMessage.aep().cau;
        }
        parama.dTh = paramWXMediaMessage.field_brandIconURL;
        y.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", new Object[] { Integer.valueOf(parama.dTg), parama.dTh });
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if (parama.type == 1)
        {
          parama.title = ((WXTextObject)paramWXMediaMessage).text;
          return null;
        }
        if (parama.type != 8) {
          break;
        }
        paramWXMediaMessage = (WXEmojiObject)paramWXMediaMessage;
        if (!bk.bE(paramWXMediaMessage.emojiData))
        {
          y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " fileData:" + paramWXMediaMessage.emojiData.length);
          parama.dQv = paramWXMediaMessage.emojiData.length;
          return bj(paramWXMediaMessage.emojiData);
        }
        if (!bk.bl(paramWXMediaMessage.emojiPath))
        {
          parama.dQv = ((int)com.tencent.mm.vfs.e.aeQ(paramWXMediaMessage.emojiPath));
          y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " read file:" + paramWXMediaMessage.emojiPath + " len:" + parama.dQv);
          if (parama.dQv > 0)
          {
            parama.dQw = com.tencent.mm.vfs.e.bM(paramWXMediaMessage.emojiPath);
            return paramWXMediaMessage.emojiPath;
          }
          return null;
        }
        parama.dQx = paramString;
      }
      if (parama.type == 15)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.dRh = paramWXMediaMessage.packageflag;
        parama.dRg = paramWXMediaMessage.packageid;
        parama.showType = 8;
        parama.url = paramWXMediaMessage.url;
        return null;
      }
      if (parama.type == 13)
      {
        paramWXMediaMessage = (WXEmojiSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.dRh = paramWXMediaMessage.packageflag;
        parama.dRg = paramWXMediaMessage.packageid;
        parama.showType = 8;
        parama.url = paramWXMediaMessage.url;
        return null;
      }
      if (parama.type == 25)
      {
        paramWXMediaMessage = (WXDesignerSharedObject)paramWXMediaMessage;
        parama.thumburl = paramWXMediaMessage.thumburl;
        parama.url = paramWXMediaMessage.url;
        parama.dSM = paramWXMediaMessage.designerUIN;
        parama.designerName = paramWXMediaMessage.designerName;
        parama.designerRediretctUrl = paramWXMediaMessage.designerRediretctUrl;
        parama.showType = 18;
        return null;
      }
    } while ((parama.type != 27) && (parama.type != 26));
    paramWXMediaMessage = (WXEmojiPageSharedObject)paramWXMediaMessage;
    parama.thumburl = paramWXMediaMessage.iconUrl;
    parama.url = paramWXMediaMessage.url;
    parama.tid = paramWXMediaMessage.tid;
    parama.dSN = paramWXMediaMessage.title;
    parama.desc = paramWXMediaMessage.desc;
    parama.iconUrl = paramWXMediaMessage.iconUrl;
    parama.secondUrl = paramWXMediaMessage.secondUrl;
    parama.pageType = paramWXMediaMessage.pageType;
    parama.showType = 20;
    return null;
  }
  
  public static String bj(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " attachBuf is null");
      return null;
    }
    Object localObject = new StringBuilder();
    au.Hx();
    localObject = com.tencent.mm.model.c.FO() + "ua_" + bk.UY();
    y.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " buildUploadAttachInfo file:" + (String)localObject);
    if (com.tencent.mm.vfs.e.b((String)localObject, paramArrayOfByte, paramArrayOfByte.length) != 0)
    {
      y.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zI() + " writeFile error file:" + (String)localObject);
      return null;
    }
    return localObject;
  }
  
  public static int d(g.a parama)
  {
    int i = -1879048183;
    if (parama == null) {
      i = 49;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = parama.type;
        int k = parama.showType;
        int m = parama.dQW;
        int n = parama.dQX;
        int i1 = parama.dSr;
        y.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + k + " atype " + j + ", itemShowType = " + m + ", c2cNewAAType = " + i1);
        if ((m == 4) || (n != 0)) {
          return 318767153;
        }
        if (j == 2001)
        {
          if (k == 1) {
            return 469762097;
          }
          if (i1 == 4) {
            return 503316529;
          }
          return 436207665;
        }
        if (j == 2002) {
          return 536870961;
        }
        switch (k)
        {
        default: 
          switch (j)
          {
          default: 
            return 49;
          }
        case 1: 
          if (j == 21) {
            return -1879048185;
          }
          return 285212721;
        }
      } while (j == 21);
      return 301989937;
      if (j == 21) {
        return -1879048176;
      }
      return -1879048189;
    } while (j == 21);
    return -1879048190;
    return -1879048191;
    return -1879048186;
    return 268435505;
    return 16777265;
    return 1048625;
    return 335544369;
    return 402653233;
    return 369098801;
    return 452984881;
    return -1879048186;
    return 419430449;
    return 520093745;
    com.tencent.mm.ae.a locala = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
    if ((locala != null) && (locala.dPD) && ((parama.dTa == 2) || (parama.dTa == 3))) {
      return 553648177;
    }
    if ((locala != null) && (locala.dPG) && (parama.dTa == 3)) {
      return 587202609;
    }
    return 49;
    return 671088689;
  }
  
  public static b d(bi parambi, String paramString)
  {
    b localb2 = VX(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      A(parambi.field_msgId, parambi.field_content);
      localb1 = VX(paramString);
    }
    return localb1;
  }
  
  public static boolean d(String paramString, bi parambi)
  {
    if (parambi == null) {
      return false;
    }
    boolean bool2 = true;
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str5 = null;
    String str1 = null;
    Object localObject1 = ap(paramString, parambi.field_msgId);
    Object localObject2 = g.a.gp(parambi.field_content);
    if (localObject1 != null) {
      String str6 = ((b)localObject1).field_fileFullPath;
    }
    if (localObject2 != null)
    {
      str3 = ah.pm(((g.a)localObject2).title);
      str4 = ah.pm(((g.a)localObject2).dQw).toLowerCase();
      str2 = ah.pm(((g.a)localObject2).filemd5);
      str5 = ah.pm(((g.a)localObject2).bRO);
      str1 = ah.pm(((g.a)localObject2).dQR);
    }
    if (localObject1 == null)
    {
      A(parambi.field_msgId, parambi.field_content);
      parambi = ap(paramString, parambi.field_msgId);
      paramString = parambi;
      bool1 = bool2;
      if (parambi != null)
      {
        l1 = parambi.ujK;
        l2 = parambi.field_totalLen;
        paramString = parambi.field_fileFullPath;
        l3 = parambi.field_type;
        localObject1 = parambi.field_mediaId;
        l4 = parambi.field_msgInfoId;
        bool1 = parambi.field_isUpload;
        if (parambi.field_signature != null) {
          break label347;
        }
        i = -1;
        y.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramString, Long.valueOf(l3), localObject1, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        paramString = parambi;
        bool1 = bool2;
        if (localObject2 != null) {
          if (((g.a)localObject2).dQz == 0)
          {
            paramString = parambi;
            bool1 = bool2;
            if (((g.a)localObject2).dQv <= 26214400) {}
          }
          else
          {
            if (ah.bl(parambi.field_signature)) {
              break label358;
            }
          }
        }
      }
      label347:
      label358:
      for (bool1 = true;; bool1 = false)
      {
        paramString = parambi;
        if (!bool1) {
          au.Dk().a(new z(paramString, str1, str2, str3, str4, str5), 0);
        }
        return bool1;
        i = parambi.field_signature.length();
        break;
      }
    }
    paramString = new com.tencent.mm.vfs.b(((b)localObject1).field_fileFullPath);
    if ((((b)localObject1).field_status == 199L) && (!paramString.exists()))
    {
      y.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      A(parambi.field_msgId, parambi.field_content);
    }
    long l1 = ((b)localObject1).ujK;
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
      y.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), parambi, Long.valueOf(l3), localObject2, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Long.valueOf(l5), Integer.valueOf(i) });
      paramString = (String)localObject1;
      bool1 = bool2;
      break;
    }
  }
  
  public static void ha(long paramLong)
  {
    b localb = ap.avh().gY(paramLong);
    if (localb != null) {
      y.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.vfs.e.deleteFile(localb.field_fileFullPath)), Boolean.valueOf(ap.avh().a(localb, new String[] { "msgInfoId" })), Long.valueOf(localb.field_msgInfoId), localb.field_mediaSvrId, localb.field_fileFullPath, bk.csb() });
    }
  }
  
  public static void hb(long paramLong)
  {
    Object localObject1 = ap.avh();
    Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bk.UX() + " where rowid = " + paramLong;
    ((c)localObject1).dXw.gk("appattach", (String)localObject2);
    ((c)localObject1).doNotify();
    localObject1 = new b();
    ap.avh().b(paramLong, (com.tencent.mm.sdk.e.c)localObject1);
    if (((b)localObject1).field_msgInfoId <= 0L) {}
    do
    {
      return;
      au.Hx();
      localObject2 = com.tencent.mm.model.c.Fy().fd(((b)localObject1).field_msgInfoId);
    } while (((cs)localObject2).field_msgId != ((b)localObject1).field_msgInfoId);
    ((bi)localObject2).setStatus(5);
    au.Hx();
    com.tencent.mm.model.c.Fy().a(((cs)localObject2).field_msgId, (bi)localObject2);
  }
  
  public static int z(long paramLong, String paramString)
  {
    b localb = ap.avh().gY(paramLong);
    if (localb == null)
    {
      y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return -1;
    }
    if (localb.field_status != 105L)
    {
      y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramString + " status:" + localb.field_status);
      return -1;
    }
    localb.field_status = 101L;
    localb.field_lastModifyTime = bk.UX();
    ap.avh().c(localb, new String[0]);
    ap.cle().run();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */