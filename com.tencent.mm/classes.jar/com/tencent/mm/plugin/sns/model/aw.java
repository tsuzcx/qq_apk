package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.a.qp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.cix;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aw
  implements f, l
{
  public static int ooB = 0;
  private String diG = "";
  public Set<a> dup = new HashSet();
  private s oua = null;
  public ac.a oub = new ac.a()
  {
    public final void iU(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        aw.this.bCp();
      }
    }
  };
  
  private void V(int paramInt, boolean paramBoolean)
  {
    af.aXq().post(new aw.3(this, paramInt, paramBoolean));
  }
  
  private aw.b a(int paramInt1, boolean paramBoolean, awe paramawe, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      y.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      return aw.b.ouo;
    }
    Object localObject = af.bDu().gu(paramInt1);
    awg localawg;
    try
    {
      localawg = (awg)new awg().aH(((com.tencent.mm.plugin.sns.storage.r)localObject).oLV);
      y.i("MicroMsg.UploadManager", "state " + localawg.tsL + " pic isMuti: " + paramBoolean);
      if (localawg.tsL == 1) {
        return aw.b.ouo;
      }
    }
    catch (Exception paramawe)
    {
      y.e("MicroMsg.UploadManager", "parse uploadInfo error");
      return aw.b.ouo;
    }
    String str = com.tencent.mm.plugin.sns.data.i.MV(((com.tencent.mm.plugin.sns.storage.r)localObject).oLR);
    str = an.eJ(af.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.r)localObject).oLR) + str;
    if (com.tencent.mm.vfs.e.aeQ(str) == 0L)
    {
      y.i("MicroMsg.UploadManager", "path not exist  " + str);
      return aw.b.ouo;
    }
    if (localawg.tsL == 0) {
      return aw.b.oup;
    }
    if (af.bDE().xJ(paramInt1))
    {
      af.bDu().a(paramInt1, (com.tencent.mm.plugin.sns.storage.r)localObject);
      localObject = com.tencent.mm.a.g.o((bk.UZ() + " " + System.currentTimeMillis()).getBytes());
      af.aXq().post(new aw.5(this, paramInt1, (String)localObject, paramBoolean, paramawe, paramInt2));
    }
    return aw.b.ouq;
  }
  
  private void a(n paramn, int paramInt1, int paramInt2, String paramString)
  {
    y.i("MicroMsg.UploadManager", "localId " + paramn.bGE() + "processError " + paramInt2 + " errMsg: " + paramString);
    com.tencent.mm.plugin.report.service.h.nFQ.a(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = af.bDu().gu(paramInt1);
      try
      {
        i = ((awg)new awg().aH(paramString.oLV)).tsu;
      }
      catch (Exception paramString)
      {
        label128:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramn.bGw();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.tsu = i;
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
      break label128;
    }
    y.d("MicroMsg.UploadManager", "post error " + paramInt1);
    paramn.bGI();
    af.bDF().b(paramn.oLk, paramn);
    y.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramn.oLk);
    paramString = new qp();
    paramString.bZS.bZT = paramn.oLk;
    com.tencent.mm.sdk.b.a.udP.m(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      V(paramn.oLk, false);
      return;
      y.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramn.bGw();
      if (paramString == null) {
        break label378;
      }
      paramInt1 = paramString.tsu;
      break;
      y.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      y.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      y.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      y.e("MicroMsg.UploadManager", "arg is error");
      continue;
      y.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      y.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(n paramn, int paramInt, String paramString)
  {
    a(paramn, 0, paramInt, paramString);
  }
  
  private static void a(awe paramawe)
  {
    if (paramawe == null) {}
    for (;;)
    {
      return;
      paramawe = paramawe.tsn.iterator();
      while (paramawe.hasNext())
      {
        auf localauf = (auf)paramawe.next();
        af.bDE().xK(localauf.tpH);
      }
    }
  }
  
  public static ax b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    y.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    y.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    ax localax;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
      localax = new ax(i);
      localax.NX(bk.aM(paramString2, "")).NY(bk.aM(paramString3, ""));
      localax.xW(5);
      y.d("MicroMsg.UploadManager", "TimeLineType " + i);
      if (i == -1)
      {
        y.d("MicroMsg.UploadManager", "timeLineType is invalid");
        paramString1 = null;
      }
      break;
    }
    label443:
    label451:
    do
    {
      do
      {
        return paramString1;
        i = 2;
        break;
        i = 4;
        break;
        i = 1;
        break;
        i = 3;
        break;
        i = 5;
        break;
        i = 3;
        break;
        if (!bk.bl(paramString1)) {
          localax.NR(paramString1);
        }
        localax.NW(bk.aM(paramWXMediaMessage.title, "")).NU(bk.aM(paramWXMediaMessage.description, ""));
        switch (((WXMediaMessage.IMediaObject)localObject).type())
        {
        default: 
          y.e("MicroMsg.UploadManager", "none type not support!");
          return null;
        case 1: 
          paramWXMediaMessage = (WXTextObject)localObject;
          localax.NU("");
          localax.NR(paramWXMediaMessage.text);
          return localax;
        case 3: 
          paramString3 = (WXMusicObject)localObject;
          if (!bk.bl(paramString3.musicUrl))
          {
            paramString1 = paramString3.musicUrl;
            paramString2 = bk.aM(paramString1, "");
            if (bk.bl(paramString3.musicDataUrl)) {
              break label443;
            }
          }
          for (paramString1 = paramString3.musicDataUrl;; paramString1 = paramString3.musicUrl)
          {
            localObject = bk.aM(paramString1, "");
            localax.NW("").NU("");
            i = xQ(3);
            if (i != -1) {
              break label451;
            }
            y.d("MicroMsg.UploadManager", "mediaType is invalid");
            return null;
            paramString1 = paramString3.musicLowBandUrl;
            break;
          }
          if (!bk.bl(paramString3.musicLowBandDataUrl)) {}
          for (paramString1 = paramString3.musicLowBandDataUrl;; paramString1 = paramString3.musicLowBandUrl)
          {
            paramString3 = bk.aM(paramString1, "");
            paramString1 = localax;
            if (localax.a(paramWXMediaMessage.thumbData, paramString2, paramString3, (String)localObject, i, bk.aM(paramWXMediaMessage.title, ""), bk.aM(paramWXMediaMessage.description, ""))) {
              break;
            }
            return null;
          }
        case 2: 
          paramWXMediaMessage = (WXImageObject)localObject;
          if (bk.bE(paramWXMediaMessage.imageData)) {
            break label559;
          }
          paramString1 = localax;
        }
      } while (localax.b(paramWXMediaMessage.imageData, "", ""));
      return null;
      if (bk.bl(paramWXMediaMessage.imagePath)) {
        break label588;
      }
      paramString1 = localax;
    } while (localax.eO(paramWXMediaMessage.imagePath, ""));
    label559:
    return null;
    label588:
    y.e("MicroMsg.UploadManager", "share img but no res is exist!");
    return null;
    paramString1 = (WXWebpageObject)localObject;
    if (!bk.bE(paramWXMediaMessage.thumbData)) {
      localax.b(paramWXMediaMessage.thumbData, bk.aM(paramWXMediaMessage.description, ""), bk.aM(paramWXMediaMessage.title, ""));
    }
    localax.NU(paramString1.webpageUrl).NV(paramString1.webpageUrl);
    paramWXMediaMessage = paramString1.webpageUrl;
    localax.ouy.tNr.kSC = paramWXMediaMessage;
    localax.NT(paramString1.canvasPageXml);
    return localax;
    y.e("MicroMsg.UploadManager", "file is not support!");
    return null;
    paramString2 = (WXVideoObject)localObject;
    localax.NW("").NU("");
    int i = xQ(4);
    if (i == -1)
    {
      y.d("MicroMsg.UploadManager", "mediaType is invalid");
      return null;
    }
    if (!bk.bl(paramString2.videoUrl)) {}
    for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
    {
      paramString3 = bk.aM(paramString1, "");
      paramString1 = localax;
      if (localax.a(paramWXMediaMessage.thumbData, paramString3, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bk.aM(paramWXMediaMessage.title, ""), bk.aM(paramWXMediaMessage.description, ""))) {
        break;
      }
      return null;
    }
    paramWXMediaMessage = (WXAppExtendObject)localObject;
    if ((!bk.bl(paramWXMediaMessage.filePath)) && (paramWXMediaMessage.filePath.startsWith("http")))
    {
      localax.NW(paramWXMediaMessage.filePath);
      localax.NU(paramWXMediaMessage.filePath);
      return localax;
    }
    y.e("MicroMsg.UploadManager", "appdata is not support!");
    return null;
  }
  
  private boolean bEn()
  {
    Object localObject1 = af.bDF();
    localObject2 = "select *,rowid from SnsInfo  where " + o.oLF + " order by SnsInfo.rowid asc ";
    localObject1 = ((o)localObject1).dXw.rawQuery((String)localObject2, null);
    y.d("MicroMsg.SnsInfoStorage", "getLastUpload " + (String)localObject2);
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
      return false;
      ((Cursor)localObject1).moveToFirst();
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      ((n)localObject2).d((Cursor)localObject1);
      try
      {
        awe localawe = (awe)new awe().aH(((n)localObject2).field_postBuf);
        int i = localawe.ebp;
        if (n.gs(localawe.tsq))
        {
          a(localawe);
          a((n)localObject2, 6, "snsinfo is tle");
          y.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((n)localObject2).bGE() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((n)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    return true;
  }
  
  private boolean t(n paramn)
  {
    if (paramn == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return false;
      localObject1 = paramn.bGe();
      if (((bxk)localObject1).tNr.sPI == 8) {
        return true;
      }
      if (((bxk)localObject1).tNr.sPI == 2) {
        return true;
      }
      if (((bxk)localObject1).tNr.sPI != 26) {
        break;
      }
      localObject2 = new gf();
      ((gf)localObject2).bNF.type = 30;
      ((gf)localObject2).bNF.bNM = 5;
      ((gf)localObject2).bNF.desc = ((bxk)localObject1).tNr.sPL;
      ((gf)localObject2).bNF.bNL = String.valueOf(paramn.oLk);
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    } while (((gf)localObject2).bNG.ret != 1);
    if ((localObject1 == null) || (((bxk)localObject1).tNr.sPJ == null))
    {
      a(paramn, 1, "timeline or timelineObjList is null");
      return false;
    }
    if (((bxk)localObject1).tNr.sPJ.size() == 0) {
      return true;
    }
    label463:
    label466:
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = (awe)new awe().aH(paramn.field_postBuf);
        if (((bxk)localObject1).tNr.sPI != 1) {
          break label466;
        }
        if (((awe)localObject2).tsn.size() > 1)
        {
          bool = true;
          if (((bxk)localObject1).tNr.sPI != 21) {
            break label463;
          }
          bool = false;
          if (((bxk)localObject1).tNr.sPI != 15) {
            break label374;
          }
          localObject1 = ((awe)localObject2).tsn.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label372;
          }
          localObject2 = (auf)((Iterator)localObject1).next();
          localObject3 = xR(((auf)localObject2).tpH);
          if (localObject3 != aw.b.ouo) {
            break label362;
          }
          a(paramn, ((auf)localObject2).tpH, 2, "upload has set it fail");
          return false;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramn.bGE());
        a(paramn, 2, "mediaPostInfo parser error " + localException.getMessage());
        return false;
      }
      boolean bool = false;
      continue;
      label362:
      if (localObject3 == aw.b.ouq)
      {
        return false;
        label372:
        return true;
        label374:
        localObject3 = ((awe)localObject2).tsn.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          auf localauf = (auf)((Iterator)localObject3).next();
          aw.b localb = a(localauf.tpH, bool, (awe)localObject2, localException.tNr.sPI);
          if (localb == aw.b.ouo)
          {
            a(paramn, localauf.tpH, 2, "upload has set it fail");
            return false;
          }
          if (localb == aw.b.ouq) {
            return false;
          }
        }
        return true;
        continue;
        bool = true;
      }
    }
  }
  
  private static bxk v(n paramn)
  {
    bxk localbxk1 = paramn.bGe();
    Object localObject = localbxk1.tNp;
    String str1 = localbxk1.tNo;
    String str2 = localbxk1.sbK;
    String str3 = localbxk1.sbL;
    String str4 = localbxk1.tNr.kRN;
    String str5 = localbxk1.tNr.bGw;
    String str6 = localbxk1.tNr.kSC;
    String str7 = localbxk1.tNr.sPL;
    dk localdk = localbxk1.tNq;
    cix localcix = localbxk1.tNx;
    int i = localbxk1.tNr.sPI;
    int j = localbxk1.tNr.sPK;
    bxk localbxk2 = com.tencent.mm.modelsns.e.QZ();
    localbxk2.hPY = paramn.field_userName;
    localbxk2.trR = paramn.field_pravited;
    localbxk2.tNo = str1;
    localbxk2.sbK = bk.pm(str2);
    localbxk2.sbL = bk.pm(str3);
    localbxk2.tNt = localbxk1.tNt;
    localbxk2.tNu = localbxk1.tNu;
    localbxk2.dQA = localbxk1.dQA;
    localbxk2.tNv = localbxk1.tNv;
    localbxk2.pjl = localbxk1.pjl;
    localbxk2.tNr.kRN = str4;
    localbxk2.tNr.bGw = str5;
    localbxk2.tNr.sPI = i;
    localbxk2.tNr.sPK = j;
    localbxk2.tNr.kSC = str6;
    localbxk2.tNr.sPL = str7;
    localbxk2.tNp = ((aui)localObject);
    localbxk2.tNw = localbxk1.tNw;
    localbxk2.oPO = localbxk1.oPO;
    if (localbxk1.ouC != null) {
      localbxk2.ouC = localbxk1.ouC;
    }
    if (localdk != null) {
      localbxk2.tNq = localdk;
    }
    if (localcix != null) {
      localbxk2.tNx = localcix;
    }
    paramn = localbxk1.tNr.sPJ.iterator();
    while (paramn.hasNext())
    {
      localObject = (awd)paramn.next();
      if (((awd)localObject).trV == 1) {
        localbxk2.tNr.sPJ.add(localObject);
      }
    }
    if (localbxk1.ouE != null) {
      localbxk2.ouE = localbxk1.ouE;
    }
    return localbxk2;
  }
  
  private boolean w(n paramn)
  {
    awe localawe;
    int i;
    try
    {
      localawe = (awe)new awe().aH(paramn.field_postBuf);
      localawe.ebp += 1;
      paramn.field_postBuf = localawe.toByteArray();
      af.bDF().b(paramn.oLk, paramn);
      i = localawe.ebp;
      if (n.gs(localawe.tsq))
      {
        a(paramn, 6, "this item isTimeLimit");
        y.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramn.bGE() + " is die ");
        return false;
      }
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramn, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      return false;
    }
    y.i("MicroMsg.UploadManager", "try start post " + paramn.bGE());
    bxk localbxk;
    Object localObject2;
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
      localbxk = paramn.bGe();
      localObject2 = v(paramn);
      i = 0;
      if (i < localawe.tsn.size())
      {
        j = ((auf)localawe.tsn.get(i)).tpH;
        localr = af.bDu().gu(j);
        if (localr == null)
        {
          a(paramn, 3, "can not get the media from db ,localMediaId: " + j);
          return false;
        }
        try
        {
          localObject3 = (awg)new awg().aH(localr.oLV);
          if ((((awg)localObject3).tsI == null) || (((awg)localObject3).tsK.size() <= 0))
          {
            y.e("MicroMsg.UploadManager", "item with not url" + paramn.field_type);
            if (paramn.field_type == 3) {
              break label761;
            }
            a(paramn, 4, "buf url is null");
            return false;
          }
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramn, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          return false;
        }
        str = ((awg)localObject3).tsI.kSC;
        localObject5 = ((awa)((awg)localObject3).tsK.get(0)).kSC;
        j = ((awg)localObject3).tsI.hQR;
        k = ((awa)((awg)localObject3).tsK.get(0)).hQR;
        localObject4 = ((awg)localObject3).bIW;
        localObject1 = null;
        if (i < localbxk.tNr.sPJ.size()) {
          localObject1 = ((awd)localbxk.tNr.sPJ.get(i)).trS;
        }
        if ((localbxk.tNr.sPI == 4) || (localbxk.tNr.sPI == 5))
        {
          if (i >= localbxk.tNr.sPJ.size()) {
            break label1084;
          }
          localObject1 = (awd)localbxk.tNr.sPJ.get(i);
          ((awd)localObject1).trP = ((String)localObject5);
          ((awd)localObject1).trQ = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((bxk)localObject2).tNr.sPI == 1)) {
        ((awd)localObject1).bIW = ((String)localObject4);
      }
      if ((localObject1 != null) && (((bxk)localObject2).tNr.sPI == 15))
      {
        ((awd)localObject1).bIW = ((awg)localObject3).bIW;
        ((awd)localObject1).tsk = ((awg)localObject3).tsk;
      }
      if (i < localbxk.tNr.sPJ.size())
      {
        localObject3 = (awd)localbxk.tNr.sPJ.get(i);
        ((awd)localObject1).bGw = ((awd)localObject3).bGw;
        ((awd)localObject1).kRN = ((awd)localObject3).kRN;
        ((awd)localObject1).brC = ((awd)localObject3).brC;
        ((awd)localObject1).oOw = ((awd)localObject3).oOw;
      }
      if (localObject1 == null)
      {
        a(paramn, 3, "make media error");
        return false;
        localObject1 = com.tencent.mm.modelsns.e.a(localr.oLU, localr.type, str, (String)localObject5, j, k, ((awg)localObject3).trR, "", (awf)localObject1);
      }
      else
      {
        ((bxk)localObject2).tNr.sPJ.add(localObject1);
        i += 1;
        break;
        label761:
        if (!af.bDE().xH(paramn.oLk))
        {
          y.d("MicroMsg.UploadManager", "this snsinfo is posting");
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localawe.tso.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((buw)((Iterator)localObject3).next()).hPY);
        }
        localObject3 = j.b((bxk)localObject2);
        y.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((bxk)localObject2).tNu + " contentDescShowType: " + ((bxk)localObject2).tNt);
        if (paramn.field_pravited == 1) {
          y.i("MicroMsg.UploadManager", "content private xml is null ? " + bk.bl((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramn, 5, "content is error");
          af.bDE().xI(paramn.oLk);
          return false;
          y.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localawe.tsw == 1) {}
        for (boolean bool = true;; bool = false)
        {
          i = paramn.oLk;
          localObject4 = localawe.tsx;
          localObject5 = ((bxk)localObject2).tNp.tpU;
          localObject2 = ((bxk)localObject2).tNr.bGw;
          af.aXq().post(new aw.4(this, (String)localObject3, localawe, (List)localObject1, localbxk, i, bool, (LinkedList)localObject4, (com.tencent.mm.bv.b)localObject5, (String)localObject2));
          y.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramn.bGE());
          return true;
        }
        label1084:
        localObject1 = null;
      }
    }
  }
  
  private static int xQ(int paramInt)
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
  
  private aw.b xR(int paramInt)
  {
    if (paramInt == -1)
    {
      y.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      return aw.b.ouo;
    }
    com.tencent.mm.plugin.sns.storage.r localr = af.bDu().gu(paramInt);
    awg localawg;
    try
    {
      localawg = (awg)new awg().aH(localr.oLV);
      y.i("MicroMsg.UploadManager", "state " + localawg.tsL + " doUploadSight, serverErr:" + localawg.tsu);
      if (localawg.tsL == 1) {
        return aw.b.ouo;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      return aw.b.ouo;
    }
    if (com.tencent.mm.vfs.e.aeQ(localawg.videoPath) == 0L)
    {
      y.i("MicroMsg.UploadManager", "path not fileexist  " + localawg.videoPath);
      return aw.b.ouo;
    }
    if (com.tencent.mm.vfs.e.aeQ(localawg.tsN) == 0L)
    {
      y.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localawg.tsN);
      return aw.b.ouo;
    }
    if (localawg.tsL == 0) {
      return aw.b.oup;
    }
    if (af.bDE().xJ(paramInt))
    {
      af.bDu().a(paramInt, localException);
      new ac(paramInt, localException, localawg.videoPath, localawg.tsN, this.oub).bDf();
    }
    return aw.b.ouq;
  }
  
  public final boolean a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString1 = b(paramWXMediaMessage, paramString1, paramString2, paramString3);
    if (paramString1 == null) {
      return false;
    }
    paramString1.NS(paramWXMediaMessage.mediaTagName);
    paramString1.Y(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.c.a.omJ) {
      paramString1.xS(1);
    }
    paramInt = paramString1.commit();
    y.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + paramInt);
    return true;
  }
  
  public final void bCp()
  {
    af.aXq().postDelayed(new aw.1(this), 1000L);
  }
  
  public final String bDl()
  {
    if ((this.diG == null) || (this.diG.equals("")))
    {
      com.tencent.mm.kernel.g.DQ();
      this.diG = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, null));
    }
    return this.diG;
  }
  
  public final void bEo()
  {
    Iterator localIterator = this.dup.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.bEp();
      }
    }
  }
  
  public final boolean eE(String paramString1, String paramString2)
  {
    y.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(paramString1.getBytes());
    com.tencent.mm.vfs.e.r(paramString1, str);
    paramString1 = new ax(1);
    paramString1.NR(paramString2);
    paramString1.xW(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.h(str, 2));
    paramString1.cy(paramString2);
    return paramString1.commit() > 0;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    switch (paramm.getType())
    {
    case 208: 
    default: 
    case 207: 
      for (;;)
      {
        if ((paramInt1 == 0) && (paramInt2 != 0)) {}
        return;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          bCp();
        }
      }
    }
    paramString = (s)paramm;
    int i = paramString.onc;
    if (paramString.dpW)
    {
      long l = paramString.oqh;
      y.i("MicroMsg.UploadManager", "get the del post come back %d " + l, new Object[] { Integer.valueOf(i) });
      if (l != 0L)
      {
        af.bDE().gd(l);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new r(l, 1), 0);
      }
      af.bDF().yu(i);
      if (l != 0L)
      {
        af.bDK().go(l);
        com.tencent.mm.plugin.sns.storage.i.gn(l);
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      V(paramString.onc, false);
    }
    for (;;)
    {
      this.oua = null;
      break;
      V(paramString.onc, true);
      ak.gh(paramString.oqh);
    }
  }
  
  public final void u(n paramn)
  {
    if (paramn == null) {
      return;
    }
    y.i("MicroMsg.UploadManager", "cancel snsinfo " + paramn.bGE());
    try
    {
      Object localObject1 = (awe)new awe().aH(paramn.field_postBuf);
      if ((localObject1 != null) && (((awe)localObject1).tsn != null))
      {
        localObject1 = ((awe)localObject1).tsn.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          auf localauf = (auf)((Iterator)localObject1).next();
          int i = af.bDE().xM(localauf.tpH);
          af.bDE().xL(localauf.tpH);
          y.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramn.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.DQ();
            com.tencent.mm.kernel.g.DO().dJT.cancel(i);
            af.bDE().xK(localauf.tpH);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramn.bGE());
        a(paramn, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((af.bDE().xG(paramn.oLk)) && (this.oua != null))
      {
        y.i("MicroMsg.UploadManager", "cancel post");
        this.oua.dpW = true;
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.c(this.oua);
        af.bDE().xI(paramn.oLk);
      }
      Object localObject2 = af.bDF().yt(paramn.oLk);
      if ((localObject2 != null) && (((n)localObject2).field_snsId != 0L))
      {
        af.bDE().gd(((n)localObject2).field_snsId);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new r(((n)localObject2).field_snsId, 1), 0);
      }
      af.bDF().yu(paramn.oLk);
      if (paramn.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.bCu().bCw();
      }
      y.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramn.bGE());
      localObject2 = new qp();
      ((qp)localObject2).bZS.bZT = paramn.oLk;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void W(int paramInt, boolean paramBoolean);
    
    public abstract void bEp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */