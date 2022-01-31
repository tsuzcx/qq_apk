package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.h.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ax
  implements f, com.tencent.mm.plugin.sns.b.l
{
  public static int rcV;
  private static final String riS;
  public Set<ax.a> bLQ;
  private String dZZ;
  private s riT;
  public j riU;
  public ac.a riV;
  
  static
  {
    AppMethodBeat.i(145283);
    rcV = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    riS = com.tencent.mm.kernel.g.RL().cachePath + "rangeCache.data";
    AppMethodBeat.o(145283);
  }
  
  public ax()
  {
    AppMethodBeat.i(36691);
    this.dZZ = "";
    this.riT = null;
    this.bLQ = new HashSet();
    this.riU = new j();
    this.riV = new ax.6(this);
    byte[] arrayOfByte = com.tencent.mm.vfs.e.i(riS, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.riU = ((j)new j().parseFrom(arrayOfByte));
        AppMethodBeat.o(36691);
        return;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.e.deleteFile(riS);
      }
    }
    AppMethodBeat.o(36691);
  }
  
  private static int DQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 4;
  }
  
  private ax.b DR(int paramInt)
  {
    AppMethodBeat.i(36708);
    if (paramInt == -1)
    {
      ab.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = ax.b.rji;
      AppMethodBeat.o(36708);
      return localObject;
    }
    Object localObject = ag.coU().ma(paramInt);
    bcv localbcv;
    try
    {
      localbcv = (bcv)new bcv().parseFrom(((com.tencent.mm.plugin.sns.storage.r)localObject).rDG);
      ab.i("MicroMsg.UploadManager", "state " + localbcv.nkT + " doUploadSight, serverErr:" + localbcv.xsx);
      if (localbcv.nkT == 1)
      {
        localObject = ax.b.rji;
        AppMethodBeat.o(36708);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = ax.b.rji;
      AppMethodBeat.o(36708);
      return localb;
    }
    if (com.tencent.mm.vfs.e.avI(localbcv.videoPath) == 0L)
    {
      ab.i("MicroMsg.UploadManager", "path not fileexist  " + localbcv.videoPath);
      localb = ax.b.rji;
      AppMethodBeat.o(36708);
      return localb;
    }
    if (com.tencent.mm.vfs.e.avI(localbcv.xsO) == 0L)
    {
      ab.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localbcv.xsO);
      localb = ax.b.rji;
      AppMethodBeat.o(36708);
      return localb;
    }
    if (localbcv.nkT == 0)
    {
      localb = ax.b.rjj;
      AppMethodBeat.o(36708);
      return localb;
    }
    if (ag.cpe().DJ(paramInt))
    {
      ag.coU().a(paramInt, localb);
      new ac(paramInt, localb, localbcv.videoPath, localbcv.xsO, this.riV).aas(localbcv.cwc);
    }
    ax.b localb = ax.b.rjk;
    AppMethodBeat.o(36708);
    return localb;
  }
  
  private ax.b a(int paramInt1, boolean paramBoolean, bct parambct, int paramInt2)
  {
    AppMethodBeat.i(36706);
    if (paramInt1 == -1)
    {
      ab.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      parambct = ax.b.rji;
      AppMethodBeat.o(36706);
      return parambct;
    }
    Object localObject = ag.coU().ma(paramInt1);
    bcv localbcv;
    try
    {
      localbcv = (bcv)new bcv().parseFrom(((com.tencent.mm.plugin.sns.storage.r)localObject).rDG);
      ab.i("MicroMsg.UploadManager", "state " + localbcv.nkT + " pic isMuti: " + paramBoolean);
      if (localbcv.nkT == 1)
      {
        parambct = ax.b.rji;
        AppMethodBeat.o(36706);
        return parambct;
      }
    }
    catch (Exception parambct)
    {
      ab.e("MicroMsg.UploadManager", "parse uploadInfo error");
      parambct = ax.b.rji;
      AppMethodBeat.o(36706);
      return parambct;
    }
    String str = com.tencent.mm.plugin.sns.data.i.ZB(((com.tencent.mm.plugin.sns.storage.r)localObject).rDC);
    str = ao.gl(ag.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.r)localObject).rDC) + str;
    if (com.tencent.mm.vfs.e.avI(str) == 0L)
    {
      ab.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      parambct = ax.b.rji;
      AppMethodBeat.o(36706);
      return parambct;
    }
    if (localbcv.nkT == 0)
    {
      parambct = ax.b.rjj;
      AppMethodBeat.o(36706);
      return parambct;
    }
    if (ag.cpe().DJ(paramInt1))
    {
      ag.coU().a(paramInt1, (com.tencent.mm.plugin.sns.storage.r)localObject);
      localObject = com.tencent.mm.a.g.w((bo.yB() + " " + System.currentTimeMillis()).getBytes());
      ag.bEf().post(new ax.5(this, paramInt1, (String)localObject, paramBoolean, parambct, paramInt2));
    }
    parambct = ax.b.rjk;
    AppMethodBeat.o(36706);
    return parambct;
  }
  
  private static TimeLineObject a(n paramn, bct parambct)
  {
    AppMethodBeat.i(36703);
    TimeLineObject localTimeLineObject2 = paramn.csh();
    Object localObject = localTimeLineObject2.xTQ;
    String str1 = localTimeLineObject2.xTP;
    String str2 = localTimeLineObject2.inF;
    String str3 = localTimeLineObject2.vSR;
    String str4 = localTimeLineObject2.xTS.Desc;
    String str5 = localTimeLineObject2.xTS.Title;
    String str6 = localTimeLineObject2.xTS.Url;
    String str7 = localTimeLineObject2.xTS.wOc;
    du localdu = localTimeLineObject2.xTR;
    cwk localcwk = localTimeLineObject2.xTY;
    int i = localTimeLineObject2.xTS.wNZ;
    int j = localTimeLineObject2.xTS.wOb;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.e.akg();
    localTimeLineObject1.jJA = paramn.field_userName;
    localTimeLineObject1.xrU = paramn.field_pravited;
    localTimeLineObject1.xTP = str1;
    localTimeLineObject1.inF = bo.nullAsNil(str2);
    localTimeLineObject1.vSR = bo.nullAsNil(str3);
    localTimeLineObject1.xTU = localTimeLineObject2.xTU;
    localTimeLineObject1.xTV = localTimeLineObject2.xTV;
    localTimeLineObject1.fgB = localTimeLineObject2.fgB;
    localTimeLineObject1.xTW = localTimeLineObject2.xTW;
    localTimeLineObject1.sbN = localTimeLineObject2.sbN;
    localTimeLineObject1.xTS.Desc = str4;
    localTimeLineObject1.xTS.Title = str5;
    localTimeLineObject1.xTS.wNZ = i;
    localTimeLineObject1.xTS.wOb = j;
    localTimeLineObject1.xTS.Url = str6;
    localTimeLineObject1.xTS.wOc = str7;
    localTimeLineObject1.xTQ = ((bap)localObject);
    localTimeLineObject1.xTX = localTimeLineObject2.xTX;
    localTimeLineObject1.rHA = localTimeLineObject2.rHA;
    if (localTimeLineObject2.rjv != null) {
      localTimeLineObject1.rjv = localTimeLineObject2.rjv;
    }
    if (localdu != null) {
      localTimeLineObject1.xTR = localdu;
    }
    if (localcwk != null) {
      localTimeLineObject1.xTY = localcwk;
    }
    paramn = localTimeLineObject2.xTS.wOa.iterator();
    while (paramn.hasNext())
    {
      localObject = (bcs)paramn.next();
      if (((bcs)localObject).xrY == 1) {
        localTimeLineObject1.xTS.wOa.add(localObject);
      }
    }
    if (localTimeLineObject2.rjx != null) {
      localTimeLineObject1.rjx = localTimeLineObject2.rjx;
    }
    paramn = v.aae().z(parambct.cpW, true);
    if (paramn.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramn.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.xTS.wOd = new bbs();
        localTimeLineObject1.xTS.wOd.wqp = i;
        if (i == 5)
        {
          localTimeLineObject1.xTS.wOd.fgl = paramn.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.xTS.wOd.fgi = paramn.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.xTS.wOd.duration = paramn.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.xTS.wOd.desc = paramn.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.xTS.wOd.lHo = paramn.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.xTS.wOd.videoWidth = paramn.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.xTS.wOd.videoHeight = paramn.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.xTS.wOd.fgk = paramn.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(36703);
    return localTimeLineObject1;
  }
  
  private void a(n paramn, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(36694);
    ab.i("MicroMsg.UploadManager", "localId " + paramn.csH() + "processError " + paramInt2 + " errMsg: " + paramString);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = ag.coU().ma(paramInt1);
      try
      {
        i = ((bcv)new bcv().parseFrom(paramString.rDG)).xsx;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramn.csz();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.xsx = i;
        paramn.field_postBuf = paramString.toByteArray();
        paramInt1 = i;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramInt1 = i;
      }
      paramInt1 = 0;
      break label136;
    }
    ab.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramn.csL();
    ag.cpf().b(paramn.rCV, paramn);
    ab.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramn.rCV);
    paramString = new rz();
    paramString.cIl.cIm = paramn.rCV;
    com.tencent.mm.sdk.b.a.ymk.l(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      ae(paramn.rCV, false);
      AppMethodBeat.o(36694);
      return;
      ab.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramn.csz();
      if (paramString == null) {
        break label388;
      }
      paramInt1 = paramString.xsx;
      break;
      ab.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      ab.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      ab.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      ab.e("MicroMsg.UploadManager", "arg is error");
      continue;
      ab.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      ab.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(n paramn, int paramInt, String paramString)
  {
    AppMethodBeat.i(36695);
    a(paramn, 0, paramInt, paramString);
    AppMethodBeat.o(36695);
  }
  
  private static void a(bct parambct)
  {
    AppMethodBeat.i(36707);
    if (parambct == null)
    {
      AppMethodBeat.o(36707);
      return;
    }
    parambct = parambct.xsq.iterator();
    while (parambct.hasNext())
    {
      bam localbam = (bam)parambct.next();
      ag.cpe().DK(localbam.xpE);
    }
    AppMethodBeat.o(36707);
  }
  
  private void ae(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36705);
    ag.bEf().post(new ax.3(this, paramInt, paramBoolean));
    AppMethodBeat.o(36705);
  }
  
  public static ay b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36697);
    ab.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    ab.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    ay localay;
    for (;;)
    {
      localay = new ay(i);
      localay.aaR(bo.bf(paramString2, "")).aaS(bo.bf(paramString3, ""));
      localay.DW(5);
      ab.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      ab.d("MicroMsg.UploadManager", "timeLineType is invalid");
      AppMethodBeat.o(36697);
      return null;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 3;
    }
    if (!bo.isNullOrNil(paramString1)) {
      localay.aaL(paramString1);
    }
    localay.aaQ(bo.bf(paramWXMediaMessage.title, "")).aaO(bo.bf(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      ab.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(36697);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localay.aaO("");
      localay.aaL(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(36697);
      return localay;
      paramString3 = (WXMusicObject)localObject;
      if (!bo.isNullOrNil(paramString3.musicUrl))
      {
        paramString1 = paramString3.musicUrl;
        paramString2 = bo.bf(paramString1, "");
        if (bo.isNullOrNil(paramString3.musicDataUrl)) {
          break label469;
        }
      }
      label469:
      for (paramString1 = paramString3.musicDataUrl;; paramString1 = paramString3.musicUrl)
      {
        localObject = bo.bf(paramString1, "");
        localay.aaQ("").aaO("");
        i = DQ(3);
        if (i != -1) {
          break label477;
        }
        ab.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(36697);
        return null;
        paramString1 = paramString3.musicLowBandUrl;
        break;
      }
      label477:
      if (!bo.isNullOrNil(paramString3.musicLowBandDataUrl)) {}
      for (paramString1 = paramString3.musicLowBandDataUrl;; paramString1 = paramString3.musicLowBandUrl)
      {
        paramString1 = bo.bf(paramString1, "");
        if (localay.a(paramWXMediaMessage.thumbData, paramString2, paramString1, (String)localObject, i, bo.bf(paramWXMediaMessage.title, ""), bo.bf(paramWXMediaMessage.description, ""))) {
          break;
        }
        AppMethodBeat.o(36697);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!bo.ce(paramWXMediaMessage.imageData))
      {
        if (!localay.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(36697);
          return null;
        }
      }
      else if (!bo.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localay.gq(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(36697);
          return null;
        }
      }
      else
      {
        ab.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(36697);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!bo.ce(paramWXMediaMessage.thumbData)) {
          localay.b(paramWXMediaMessage.thumbData, bo.bf(paramWXMediaMessage.description, ""), bo.bf(paramWXMediaMessage.title, ""));
        }
        localay.aaO(paramString1.webpageUrl).aaP(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localay.rjr.xTS.Url = paramWXMediaMessage;
        localay.aaN(paramString1.canvasPageXml);
        continue;
        ab.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(36697);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localay.aaQ("").aaO("");
        i = DQ(4);
        if (i == -1)
        {
          ab.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(36697);
          return null;
        }
        if (!bo.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = bo.bf(paramString1, "");
          if (localay.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bo.bf(paramWXMediaMessage.title, ""), bo.bf(paramWXMediaMessage.description, ""))) {
            break;
          }
          AppMethodBeat.o(36697);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((bo.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localay.aaQ(paramWXMediaMessage.filePath);
        localay.aaO(paramWXMediaMessage.filePath);
      }
    }
    ab.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(36697);
    return null;
  }
  
  private boolean cpM()
  {
    AppMethodBeat.i(36702);
    Object localObject1 = ag.cpf();
    localObject2 = "select *,rowid from SnsInfo  where " + o.rDq + " order by SnsInfo.rowid asc ";
    localObject1 = ((o)localObject1).db.rawQuery((String)localObject2, null);
    ab.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = new n();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(36702);
      return false;
      ((Cursor)localObject1).moveToFirst();
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      ((n)localObject2).convertFrom((Cursor)localObject1);
      try
      {
        bct localbct = (bct)new bct().parseFrom(((n)localObject2).field_postBuf);
        if (n.lY(localbct.xst))
        {
          a(localbct);
          a((n)localObject2, 6, "snsinfo is tle");
          ab.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((n)localObject2).csH() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((n)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(36702);
    return true;
  }
  
  private boolean t(n paramn)
  {
    AppMethodBeat.i(36699);
    if (paramn == null)
    {
      AppMethodBeat.o(36699);
      return false;
    }
    Object localObject1 = paramn.csh();
    if (((TimeLineObject)localObject1).xTS.wNZ == 8)
    {
      AppMethodBeat.o(36699);
      return true;
    }
    if (((TimeLineObject)localObject1).xTS.wNZ == 2)
    {
      AppMethodBeat.o(36699);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).xTS.wNZ == 26)
    {
      localObject2 = new gi();
      ((gi)localObject2).cuX.type = 30;
      ((gi)localObject2).cuX.cve = 5;
      ((gi)localObject2).cuX.desc = ((TimeLineObject)localObject1).xTS.wOc;
      ((gi)localObject2).cuX.cvd = String.valueOf(paramn.rCV);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((gi)localObject2).cuY.ret != 1)
      {
        AppMethodBeat.o(36699);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).xTS.wOa == null))
    {
      a(paramn, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(36699);
      return false;
    }
    if (((TimeLineObject)localObject1).xTS.wOa.size() == 0)
    {
      AppMethodBeat.o(36699);
      return true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = (bct)new bct().parseFrom(paramn.field_postBuf);
        if (((TimeLineObject)localObject1).xTS.wNZ != 1) {
          break label552;
        }
        if (((bct)localObject2).xsq.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).xTS.wNZ != 21) {
            break label549;
          }
          bool = false;
          if (((TimeLineObject)localObject1).xTS.wNZ != 15) {
            break label442;
          }
          localObject1 = ((bct)localObject2).xsq.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label434;
          }
          localObject2 = (bam)((Iterator)localObject1).next();
          localObject3 = DR(((bam)localObject2).xpE);
          if (localObject3 != ax.b.rji) {
            break label418;
          }
          a(paramn, ((bam)localObject2).xpE, 2, "upload has set it fail");
          AppMethodBeat.o(36699);
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramn.csH());
        a(paramn, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(36699);
        return false;
      }
      boolean bool = false;
      continue;
      label418:
      if (localObject3 == ax.b.rjk)
      {
        AppMethodBeat.o(36699);
        return false;
        label434:
        AppMethodBeat.o(36699);
        return true;
        label442:
        localObject3 = ((bct)localObject2).xsq.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bam localbam = (bam)((Iterator)localObject3).next();
          ax.b localb = a(localbam.xpE, bool, (bct)localObject2, localException.xTS.wNZ);
          if (localb == ax.b.rji)
          {
            a(paramn, localbam.xpE, 2, "upload has set it fail");
            AppMethodBeat.o(36699);
            return false;
          }
          if (localb == ax.b.rjk)
          {
            AppMethodBeat.o(36699);
            return false;
          }
        }
        AppMethodBeat.o(36699);
        return true;
        label549:
        continue;
        label552:
        bool = true;
      }
    }
  }
  
  private boolean v(n paramn)
  {
    AppMethodBeat.i(36704);
    bct localbct;
    try
    {
      localbct = (bct)new bct().parseFrom(paramn.field_postBuf);
      localbct.ePG += 1;
      paramn.field_postBuf = localbct.toByteArray();
      ag.cpf().b(paramn.rCV, paramn);
      if (n.lY(localbct.xst))
      {
        a(paramn, 6, "this item isTimeLimit");
        ab.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramn.csH() + " is die ");
        AppMethodBeat.o(36704);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramn, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(36704);
      return false;
    }
    ab.i("MicroMsg.UploadManager", "try start post " + paramn.csH());
    TimeLineObject localTimeLineObject;
    Object localObject2;
    int i;
    int j;
    com.tencent.mm.plugin.sns.storage.r localr;
    Object localObject3;
    String str;
    Object localObject5;
    int k;
    Object localObject4;
    Object localObject1;
    if (t(paramn))
    {
      localTimeLineObject = paramn.csh();
      localObject2 = a(paramn, localbct);
      i = 0;
      if (i < localbct.xsq.size())
      {
        j = ((bam)localbct.xsq.get(i)).xpE;
        localr = ag.coU().ma(j);
        if (localr == null)
        {
          a(paramn, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(36704);
          return false;
        }
        try
        {
          localObject3 = (bcv)new bcv().parseFrom(localr.rDG);
          if ((((bcv)localObject3).xsK == null) || (((bcv)localObject3).xsM.size() <= 0))
          {
            ab.e("MicroMsg.UploadManager", "item with not url" + paramn.field_type);
            if (paramn.field_type == 3) {
              break label792;
            }
            a(paramn, 4, "buf url is null");
            AppMethodBeat.o(36704);
            return false;
          }
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramn, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(36704);
          return false;
        }
        str = ((bcv)localObject3).xsK.Url;
        localObject5 = ((bcp)((bcv)localObject3).xsM.get(0)).Url;
        j = ((bcv)localObject3).xsK.jKs;
        k = ((bcp)((bcv)localObject3).xsM.get(0)).jKs;
        localObject4 = ((bcv)localObject3).cqq;
        localObject1 = null;
        if (i < localTimeLineObject.xTS.wOa.size()) {
          localObject1 = ((bcs)localTimeLineObject.xTS.wOa.get(i)).xrV;
        }
        if ((localTimeLineObject.xTS.wNZ == 4) || (localTimeLineObject.xTS.wNZ == 5))
        {
          if (i >= localTimeLineObject.xTS.wOa.size()) {
            break label1133;
          }
          localObject1 = (bcs)localTimeLineObject.xTS.wOa.get(i);
          ((bcs)localObject1).xrS = ((String)localObject5);
          ((bcs)localObject1).xrT = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).xTS.wNZ == 1)) {
        ((bcs)localObject1).cqq = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).xTS.wNZ == 15))
      {
        ((bcs)localObject1).cqq = ((bcv)localObject3).cqq;
        ((bcs)localObject1).xsn = ((bcv)localObject3).xsn;
      }
      if (i < localTimeLineObject.xTS.wOa.size())
      {
        localObject3 = (bcs)localTimeLineObject.xTS.wOa.get(i);
        ((bcs)localObject1).Title = ((bcs)localObject3).Title;
        ((bcs)localObject1).Desc = ((bcs)localObject3).Desc;
        ((bcs)localObject1).subType = ((bcs)localObject3).subType;
        ((bcs)localObject1).rGh = ((bcs)localObject3).rGh;
      }
      if (localObject1 == null)
      {
        a(paramn, 3, "make media error");
        AppMethodBeat.o(36704);
        return false;
        localObject1 = com.tencent.mm.modelsns.e.a(localr.rDF, localr.type, str, (String)localObject5, j, k, ((bcv)localObject3).xrU, "", (bcu)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).xTS.wOa.add(localObject1);
        i += 1;
        break;
        label792:
        if (!ag.cpe().DH(paramn.rCV))
        {
          ab.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(36704);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localbct.xsr.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((cfm)((Iterator)localObject3).next()).jJA);
        }
        localObject3 = com.tencent.mm.plugin.sns.h.l.b((TimeLineObject)localObject2);
        ab.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).xTV + " contentDescShowType: " + ((TimeLineObject)localObject2).xTU);
        if (paramn.field_pravited == 1) {
          ab.i("MicroMsg.UploadManager", "content private xml is null ? " + bo.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramn, 5, "content is error");
          ag.cpe().DI(paramn.rCV);
          AppMethodBeat.o(36704);
          return false;
          ab.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localbct.xsz == 1) {}
        for (boolean bool = true;; bool = false)
        {
          i = paramn.rCV;
          localObject4 = localbct.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).xTQ.xpR;
          localObject2 = ((TimeLineObject)localObject2).xTS.Title;
          ag.bEf().post(new ax.4(this, (String)localObject3, localbct, (List)localObject1, localTimeLineObject, i, bool, (LinkedList)localObject4, (com.tencent.mm.bv.b)localObject5, (String)localObject2));
          ab.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramn.csH());
          AppMethodBeat.o(36704);
          return true;
        }
        label1133:
        localObject1 = null;
      }
    }
  }
  
  public final boolean a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(36698);
    paramString1 = b(paramWXMediaMessage, paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      AppMethodBeat.o(36698);
      return false;
    }
    paramString1.aaM(paramWXMediaMessage.mediaTagName);
    paramString1.aj(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.c.a.raX) {
      paramString1.DS(1);
    }
    ab.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(36698);
    return true;
  }
  
  public final void cnP()
  {
    AppMethodBeat.i(36701);
    ag.bEf().postDelayed(new ax.1(this), 1000L);
    AppMethodBeat.o(36701);
  }
  
  public final String coK()
  {
    AppMethodBeat.i(36692);
    if ((this.dZZ == null) || (this.dZZ.equals("")))
    {
      com.tencent.mm.kernel.g.RM();
      this.dZZ = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, null));
    }
    String str = this.dZZ;
    AppMethodBeat.o(36692);
    return str;
  }
  
  public final void cpN()
  {
    AppMethodBeat.i(36709);
    Iterator localIterator = this.bLQ.iterator();
    while (localIterator.hasNext())
    {
      ax.a locala = (ax.a)localIterator.next();
      if (locala != null) {
        locala.cpO();
      }
    }
    AppMethodBeat.o(36709);
  }
  
  public final void f(List<com.tencent.mm.plugin.sns.h.k> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(145282);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(145282);
      return;
    }
    this.riU.rmb = paramBoolean;
    this.riU.rlZ.clear();
    this.riU.rlZ.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.h.k localk;
    if (bo.es(this.riU.rma))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localk = (com.tencent.mm.plugin.sns.h.k)paramList.next();
        if (localk.type == 2) {
          localArrayList.add(localk);
        }
      }
    }
    paramList = paramList.iterator();
    label381:
    for (;;)
    {
      if (paramList.hasNext())
      {
        localk = (com.tencent.mm.plugin.sns.h.k)paramList.next();
        if (localk.type == 2)
        {
          Iterator localIterator = this.riU.rma.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!bo.isEqual(((com.tencent.mm.plugin.sns.h.k)localIterator.next()).name, localk.name));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label381;
          }
          localArrayList.add(localk);
          break;
          if (!bo.es(localArrayList)) {
            this.riU.rma.addAll(0, localArrayList);
          }
          if (this.riU.rma.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.riU.rma);
            this.riU.rma.clear();
            this.riU.rma.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.riU.toByteArray();
            com.tencent.mm.vfs.e.b(riS, paramList, paramList.length);
            AppMethodBeat.o(145282);
            return;
          }
          catch (IOException paramList)
          {
            ab.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + riS, new Object[0]);
            com.tencent.mm.vfs.e.deleteFile(riS);
            AppMethodBeat.o(145282);
            return;
          }
        }
      }
    }
  }
  
  public final boolean gf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36696);
    ab.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(paramString1.getBytes());
    com.tencent.mm.vfs.e.C(paramString1, str);
    paramString1 = new ay(1);
    paramString1.aaL(paramString2);
    paramString1.DW(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.h(str, 2));
    paramString1.dd(paramString2);
    if (paramString1.commit() > 0)
    {
      AppMethodBeat.o(36696);
      return true;
    }
    AppMethodBeat.o(36696);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(36710);
    ab.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    switch (paramm.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(36710);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        cnP();
        continue;
        paramString = (s)paramm;
        int i = paramString.cIp;
        if (paramString.eht)
        {
          long l = paramString.reO;
          ab.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            ag.cpe().lI(l);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(new r(l, 1), 0);
          }
          ag.cpf().EA(i);
          if (l != 0L)
          {
            ag.cpk().lU(l);
            com.tencent.mm.plugin.sns.storage.i.lT(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          ae(paramString.cIp, false);
        }
        for (;;)
        {
          this.riT = null;
          break;
          ae(paramString.cIp, true);
          al.kk(paramString.reO);
        }
      }
    }
    AppMethodBeat.o(36710);
  }
  
  public final void u(n paramn)
  {
    AppMethodBeat.i(36700);
    if (paramn == null)
    {
      AppMethodBeat.o(36700);
      return;
    }
    ab.i("MicroMsg.UploadManager", "cancel snsinfo " + paramn.csH());
    try
    {
      Object localObject1 = (bct)new bct().parseFrom(paramn.field_postBuf);
      if ((localObject1 != null) && (((bct)localObject1).xsq != null))
      {
        localObject1 = ((bct)localObject1).xsq.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          bam localbam = (bam)((Iterator)localObject1).next();
          int i = ag.cpe().DM(localbam.xpE);
          ag.cpe().DL(localbam.xpE);
          ab.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramn.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.cancel(i);
            ag.cpe().DK(localbam.xpE);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramn.csH());
        a(paramn, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((ag.cpe().DG(paramn.rCV)) && (this.riT != null))
      {
        ab.i("MicroMsg.UploadManager", "cancel post");
        this.riT.eht = true;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(this.riT);
        ag.cpe().DI(paramn.rCV);
      }
      Object localObject2 = ag.cpf().Ez(paramn.rCV);
      if ((localObject2 != null) && (((n)localObject2).field_snsId != 0L))
      {
        ag.cpe().lI(((n)localObject2).field_snsId);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new r(((n)localObject2).field_snsId, 1), 0);
      }
      ag.cpf().EA(paramn.rCV);
      if (paramn.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.cnW().cnY();
      }
      ab.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramn.csH());
      localObject2 = new rz();
      ((rz)localObject2).cIl.cIm = paramn.rCV;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      AppMethodBeat.o(36700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */