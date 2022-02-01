package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class az
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.sns.c.m
{
  public static int wDn;
  private static final String wKI;
  public Set<a> csT;
  private String fki;
  private r wKJ;
  public l wKK;
  public ab.a wKL;
  
  static
  {
    AppMethodBeat.i(96034);
    wDn = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    wKI = com.tencent.mm.kernel.g.afB().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public az()
  {
    AppMethodBeat.i(96011);
    this.fki = "";
    this.wKJ = null;
    this.csT = new HashSet();
    this.wKK = new l();
    this.wKL = new ab.a()
    {
      public final void pJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          az.this.drS();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aR(wKI, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.wKK = ((l)new l().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.i.deleteFile(wKI);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean A(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96024);
    final bpj localbpj;
    try
    {
      localbpj = (bpj)new bpj().parseFrom(paramp.field_postBuf);
      localbpj.gll += 1;
      paramp.field_postBuf = localbpj.toByteArray();
      af.dtu().b(paramp.xiB, paramp);
      if (com.tencent.mm.plugin.sns.storage.p.tg(localbpj.DNs))
      {
        a(paramp, 6, "this item isTimeLimit");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramp.dxX() + " is die ");
        AppMethodBeat.o(96024);
        return false;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramp, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(96024);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "try start post " + paramp.dxX());
    final TimeLineObject localTimeLineObject;
    Object localObject2;
    final int i;
    int j;
    t localt;
    Object localObject3;
    String str;
    Object localObject5;
    int k;
    Object localObject4;
    Object localObject1;
    if (y(paramp))
    {
      localTimeLineObject = paramp.dxy();
      localObject2 = a(paramp, localbpj);
      i = 0;
      if (i < localbpj.DNp.size())
      {
        j = ((bmh)localbpj.DNp.get(i)).DJN;
        localt = af.dtj().ti(j);
        if (localt == null)
        {
          a(paramp, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (bpl)new bpl().parseFrom(localt.xjn);
          if ((((bpl)localObject3).DNK == null) || (((bpl)localObject3).DNM.size() <= 0))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "item with not url" + paramp.field_type);
            if (paramp.field_type == 3) {
              break label788;
            }
            a(paramp, 4, "buf url is null");
            AppMethodBeat.o(96024);
            return false;
          }
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramp, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(96024);
          return false;
        }
        str = ((bpl)localObject3).DNK.Url;
        localObject5 = ((bpd)((bpl)localObject3).DNM.get(0)).Url;
        j = ((bpl)localObject3).DNK.mBH;
        k = ((bpd)((bpl)localObject3).DNM.get(0)).mBH;
        localObject4 = ((bpl)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.Etm.DaC.size()) {
          localObject1 = ((bpi)localTimeLineObject.Etm.DaC.get(i)).DMT;
        }
        if ((localTimeLineObject.Etm.DaB == 4) || (localTimeLineObject.Etm.DaB == 5))
        {
          if (i >= localTimeLineObject.Etm.DaC.size()) {
            break label1126;
          }
          localObject1 = (bpi)localTimeLineObject.Etm.DaC.get(i);
          ((bpi)localObject1).DMQ = ((String)localObject5);
          ((bpi)localObject1).DMR = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).Etm.DaB == 1)) {
        ((bpi)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).Etm.DaB == 15))
      {
        ((bpi)localObject1).md5 = ((bpl)localObject3).md5;
        ((bpi)localObject1).DNl = ((bpl)localObject3).DNl;
      }
      if (i < localTimeLineObject.Etm.DaC.size())
      {
        localObject3 = (bpi)localTimeLineObject.Etm.DaC.get(i);
        ((bpi)localObject1).Title = ((bpi)localObject3).Title;
        ((bpi)localObject1).Desc = ((bpi)localObject3).Desc;
        ((bpi)localObject1).subType = ((bpi)localObject3).subType;
        ((bpi)localObject1).xmd = ((bpi)localObject3).xmd;
        ((bpi)localObject1).DNm = ((bpi)localObject3).DNm;
      }
      if (localObject1 == null)
      {
        a(paramp, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = com.tencent.mm.modelsns.g.a(localt.xjm, localt.type, str, (String)localObject5, j, k, ((bpl)localObject3).DMS, "", (bpk)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).Etm.DaC.add(localObject1);
        i += 1;
        break;
        label788:
        if (!af.dtt().Mh(paramp.xiB))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localbpj.DNq.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((cwk)((Iterator)localObject3).next()).mAQ);
        }
        localObject3 = com.tencent.mm.plugin.sns.j.n.f((TimeLineObject)localObject2);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).Etp + " contentDescShowType: " + ((TimeLineObject)localObject2).Eto);
        if (paramp.field_pravited == 1) {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "content private xml is null ? " + bt.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramp, 5, "content is error");
          af.dtt().Mi(paramp.xiB);
          AppMethodBeat.o(96024);
          return false;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localbpj.DNy == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramp.xiB;
          localObject4 = localbpj.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).Etk.DKa;
          localObject2 = ((TimeLineObject)localObject2).Etm.Title;
          af.czA().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (af.dtd())
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localbpj.DNG != null)
              {
                i = localbpj.DNG.CyL;
                str = localbpj.DNG.rZy;
              }
              az.a(az.this, new r(this.hrB, localbpj.DMS, localbpj.DNo, this.wKP, localTimeLineObject, i, localbpj.gKn, localbpj.DNt, localbpj.DNu, localbpj.DNv, localbpj, bool, this.wKS, localbpj.DNz, this.wKT, this.cPN, i, str));
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(az.d(az.this), 0);
              AppMethodBeat.o(96005);
            }
          });
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramp.dxX());
          AppMethodBeat.o(96024);
          return true;
        }
        label1126:
        localObject1 = null;
      }
    }
  }
  
  private static int Mq(int paramInt)
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
  
  private az.b Mr(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = az.b.wKY;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = af.dtj().ti(paramInt);
    bpl localbpl;
    try
    {
      localbpl = (bpl)new bpl().parseFrom(((t)localObject).xjn);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "state " + localbpl.DJF + " doUploadSight, serverErr:" + localbpl.DNw);
      if (localbpl.DJF == 1)
      {
        localObject = az.b.wKY;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = az.b.wKY;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aMN(localbpl.videoPath) == 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "path not fileexist  " + localbpl.videoPath);
      localb = az.b.wKY;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aMN(localbpl.DNO) == 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localbpl.DNO);
      localb = az.b.wKY;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localbpl.DJF == 0)
    {
      localb = az.b.wKZ;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (af.dtt().Mj(paramInt))
    {
      af.dtj().a(paramInt, localb);
      new ab(paramInt, localb, localbpl.videoPath, localbpl.DNO, this.wKL).aoB(localbpl.dlB);
    }
    az.b localb = az.b.wLa;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private az.b a(final int paramInt1, final boolean paramBoolean, final bpj parambpj, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      parambpj = az.b.wKY;
      AppMethodBeat.o(96026);
      return parambpj;
    }
    Object localObject = af.dtj().ti(paramInt1);
    bpl localbpl;
    try
    {
      localbpl = (bpl)new bpl().parseFrom(((t)localObject).xjn);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "state " + localbpl.DJF + " pic isMuti: " + paramBoolean);
      if (localbpl.DJF == 1)
      {
        parambpj = az.b.wKY;
        AppMethodBeat.o(96026);
        return parambpj;
      }
    }
    catch (Exception parambpj)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "parse uploadInfo error");
      parambpj = az.b.wKY;
      AppMethodBeat.o(96026);
      return parambpj;
    }
    String str = com.tencent.mm.plugin.sns.data.q.anE(((t)localObject).xjj);
    str = an.iF(af.getAccSnsPath(), ((t)localObject).xjj) + str;
    if (com.tencent.mm.vfs.i.aMN(str) == 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      parambpj = az.b.wKY;
      AppMethodBeat.o(96026);
      return parambpj;
    }
    if (localbpl.DJF == 0)
    {
      parambpj = az.b.wKZ;
      AppMethodBeat.o(96026);
      return parambpj;
    }
    if (af.dtt().Mj(paramInt1))
    {
      af.dtj().a(paramInt1, (t)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((bt.GC() + " " + System.currentTimeMillis()).getBytes());
      af.czA().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (af.dtd())
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          y localy = new y(paramInt1, this.wKV, paramBoolean, paramInt2);
          af.dtt().gZ(paramInt1, localy.hashCode());
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(localy, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    parambpj = az.b.wLa;
    AppMethodBeat.o(96026);
    return parambpj;
  }
  
  private static TimeLineObject a(com.tencent.mm.plugin.sns.storage.p paramp, bpj parambpj)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramp.dxy();
    Object localObject = localTimeLineObject2.Etk;
    String str1 = localTimeLineObject2.Etj;
    String str2 = localTimeLineObject2.jec;
    String str3 = localTimeLineObject2.BXw;
    String str4 = localTimeLineObject2.Etm.Desc;
    String str5 = localTimeLineObject2.Etm.Title;
    String str6 = localTimeLineObject2.Etm.Url;
    String str7 = localTimeLineObject2.Etm.DaE;
    eh localeh = localTimeLineObject2.Etl;
    dqn localdqn = localTimeLineObject2.Ets;
    int i = localTimeLineObject2.Etm.DaB;
    int j = localTimeLineObject2.Etm.DaD;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.g.aBl();
    localTimeLineObject1.mAQ = paramp.field_userName;
    localTimeLineObject1.DMS = paramp.field_pravited;
    localTimeLineObject1.Etj = str1;
    localTimeLineObject1.jec = bt.nullAsNil(str2);
    localTimeLineObject1.BXw = bt.nullAsNil(str3);
    localTimeLineObject1.Eto = localTimeLineObject2.Eto;
    localTimeLineObject1.Etp = localTimeLineObject2.Etp;
    localTimeLineObject1.gHj = localTimeLineObject2.gHj;
    localTimeLineObject1.Etq = localTimeLineObject2.Etq;
    localTimeLineObject1.xpl = localTimeLineObject2.xpl;
    localTimeLineObject1.Etm.Desc = str4;
    localTimeLineObject1.Etm.Title = str5;
    localTimeLineObject1.Etm.DaB = i;
    localTimeLineObject1.Etm.DaD = j;
    localTimeLineObject1.Etm.Url = str6;
    localTimeLineObject1.Etm.DaE = str7;
    localTimeLineObject1.Etm.DaG = localTimeLineObject2.Etm.DaG;
    localTimeLineObject1.Etm.DaH = localTimeLineObject2.Etm.DaH;
    localTimeLineObject1.Etk = ((bmn)localObject);
    localTimeLineObject1.Etr = localTimeLineObject2.Etr;
    localTimeLineObject1.xns = localTimeLineObject2.xns;
    if (localTimeLineObject2.wLl != null) {
      localTimeLineObject1.wLl = localTimeLineObject2.wLl;
    }
    if (localeh != null) {
      localTimeLineObject1.Etl = localeh;
    }
    if (localdqn != null) {
      localTimeLineObject1.Ets = localdqn;
    }
    paramp = localTimeLineObject2.Etm.DaC.iterator();
    while (paramp.hasNext())
    {
      localObject = (bpi)paramp.next();
      if (((bpi)localObject).DMW == 1) {
        localTimeLineObject1.Etm.DaC.add(localObject);
      }
    }
    if (localTimeLineObject2.wLn != null) {
      localTimeLineObject1.wLn = localTimeLineObject2.wLn;
    }
    paramp = com.tencent.mm.model.y.arz().E(parambpj.sessionId, true);
    if (paramp.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramp.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.Etm.DaF = new bnt();
        localTimeLineObject1.Etm.DaF.gKq = i;
        localTimeLineObject1.Etm.DaF.gGA = paramp.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.Etm.DaF.gGC = paramp.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.Etm.DaF.gGy = paramp.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.Etm.DaF.duration = paramp.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.Etm.DaF.desc = paramp.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.Etm.DaF.coverUrl = paramp.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.Etm.DaF.videoWidth = paramp.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.Etm.DaF.videoHeight = paramp.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.Etm.DaF.gGB = paramp.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(96023);
    return localTimeLineObject1;
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96014);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "localId " + paramp.dxX() + "processError " + paramInt2 + " errMsg: " + paramString);
    h.vKh.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = af.dtj().ti(paramInt1);
      try
      {
        i = ((bpl)new bpl().parseFrom(paramString.xjn)).DNw;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramp.dxQ();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.DNw = i;
        paramp.field_postBuf = paramString.toByteArray();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramp.dyb();
    af.dtu().b(paramp.xiB, paramp);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramp.xiB);
    paramString = new tt();
    paramString.dzb.dzc = paramp.xiB;
    com.tencent.mm.sdk.b.a.ESL.l(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      aq(paramp.xiB, false);
      AppMethodBeat.o(96014);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramp.dxQ();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.DNw;
      break;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "arg is error");
      continue;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(96015);
    a(paramp, 0, paramInt, paramString);
    AppMethodBeat.o(96015);
  }
  
  private static void a(bpj parambpj)
  {
    AppMethodBeat.i(96027);
    if (parambpj == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    parambpj = parambpj.DNp.iterator();
    while (parambpj.hasNext())
    {
      bmh localbmh = (bmh)parambpj.next();
      af.dtt().Mk(localbmh.DJN);
    }
    AppMethodBeat.o(96027);
  }
  
  private void aq(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    af.czA().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (af.dtd())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = az.c(az.this).iterator();
        while (localIterator.hasNext())
        {
          az.a locala = (az.a)localIterator.next();
          if (locala != null) {
            locala.ar(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static ba b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96017);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    ba localba;
    for (;;)
    {
      localba = new ba(i);
      localba.aoY(bt.by(paramString2, "")).aoZ(bt.by(paramString3, ""));
      localba.Mw(5);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "timeLineType is invalid");
      AppMethodBeat.o(96017);
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
    if (!bt.isNullOrNil(paramString1)) {
      localba.aoS(paramString1);
    }
    localba.aoX(bt.by(paramWXMediaMessage.title, "")).aoV(bt.by(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localba.aoV("");
      localba.aoS(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localba;
      paramString2 = (WXMusicObject)localObject;
      if (!bt.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramString3 = bt.by(paramString1, "");
        if (bt.isNullOrNil(paramString2.musicDataUrl)) {
          break label469;
        }
      }
      label469:
      for (paramString1 = paramString2.musicDataUrl;; paramString1 = paramString2.musicUrl)
      {
        localObject = bt.by(paramString1, "");
        localba.aoX("").aoV("");
        i = Mq(3);
        if (i != -1) {
          break label477;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = paramString2.musicLowBandUrl;
        break;
      }
      label477:
      if (!bt.isNullOrNil(paramString2.musicLowBandDataUrl)) {}
      for (paramString1 = paramString2.musicLowBandDataUrl;; paramString1 = paramString2.musicLowBandUrl)
      {
        paramString1 = bt.by(paramString1, "");
        if (localba.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, bt.by(paramWXMediaMessage.title, ""), bt.by(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!bt.cw(paramWXMediaMessage.imageData))
      {
        if (!localba.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!bt.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localba.iK(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!bt.cw(paramWXMediaMessage.thumbData)) {
          localba.b(paramWXMediaMessage.thumbData, bt.by(paramWXMediaMessage.description, ""), bt.by(paramWXMediaMessage.title, ""));
        }
        localba.aoV(paramString1.webpageUrl).aoW(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localba.wLh.Etm.Url = paramWXMediaMessage;
        localba.aoU(paramString1.canvasPageXml);
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localba.aoX("").aoV("");
        i = Mq(4);
        if (i == -1)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(96017);
          return null;
        }
        if (!bt.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = bt.by(paramString1, "");
          if (localba.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bt.by(paramWXMediaMessage.title, ""), bt.by(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((bt.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localba.aoX(paramWXMediaMessage.filePath);
        localba.aoV(paramWXMediaMessage.filePath);
      }
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean duq()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = af.dtu();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.xiW + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.storage.p();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(96022);
      return false;
      ((Cursor)localObject1).moveToFirst();
    }
    ((Cursor)localObject1).moveToFirst();
    do
    {
      ((com.tencent.mm.plugin.sns.storage.p)localObject2).convertFrom((Cursor)localObject1);
      try
      {
        bpj localbpj = (bpj)new bpj().parseFrom(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_postBuf);
        if (com.tencent.mm.plugin.sns.storage.p.tg(localbpj.DNs))
        {
          a(localbpj);
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 6, "snsinfo is tle");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((com.tencent.mm.plugin.sns.storage.p)localObject2).dxX() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(96022);
    return true;
  }
  
  private boolean y(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96019);
    if (paramp == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramp.dxy();
    if (((TimeLineObject)localObject1).Etm.DaB == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).Etm.DaB == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).Etm.DaB == 26)
    {
      localObject2 = new gs();
      ((gs)localObject2).dkc.type = 30;
      ((gs)localObject2).dkc.dkj = 5;
      ((gs)localObject2).dkc.desc = ((TimeLineObject)localObject1).Etm.DaE;
      ((gs)localObject2).dkc.dki = String.valueOf(paramp.xiB);
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((gs)localObject2).dkd.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).Etm.DaC == null))
    {
      a(paramp, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).Etm.DaC.size() == 0)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = (bpj)new bpj().parseFrom(paramp.field_postBuf);
        if (((TimeLineObject)localObject1).Etm.DaB != 1) {
          break label552;
        }
        if (((bpj)localObject2).DNp.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).Etm.DaB != 21) {
            break label549;
          }
          bool = false;
          if (((TimeLineObject)localObject1).Etm.DaB != 15) {
            break label442;
          }
          localObject1 = ((bpj)localObject2).DNp.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label434;
          }
          localObject2 = (bmh)((Iterator)localObject1).next();
          localObject3 = Mr(((bmh)localObject2).DJN);
          if (localObject3 != az.b.wKY) {
            break label418;
          }
          a(paramp, ((bmh)localObject2).DJN, 2, "upload has set it fail");
          AppMethodBeat.o(96019);
          return false;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dxX());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(96019);
        return false;
      }
      boolean bool = false;
      continue;
      label418:
      if (localObject3 == az.b.wLa)
      {
        AppMethodBeat.o(96019);
        return false;
        label434:
        AppMethodBeat.o(96019);
        return true;
        label442:
        localObject3 = ((bpj)localObject2).DNp.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bmh localbmh = (bmh)((Iterator)localObject3).next();
          az.b localb = a(localbmh.DJN, bool, (bpj)localObject2, localException.Etm.DaB);
          if (localb == az.b.wKY)
          {
            a(paramp, localbmh.DJN, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == az.b.wLa)
          {
            AppMethodBeat.o(96019);
            return false;
          }
        }
        AppMethodBeat.o(96019);
        return true;
        label549:
        continue;
        label552:
        bool = true;
      }
    }
  }
  
  public final boolean a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(96018);
    paramString1 = b(paramWXMediaMessage, paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      AppMethodBeat.o(96018);
      return false;
    }
    paramString1.aoT(paramWXMediaMessage.mediaTagName);
    paramString1.au(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.d.a.wzN) {
      paramString1.Ms(1);
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void drS()
  {
    AppMethodBeat.i(96021);
    af.czA().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        az.a(az.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String dta()
  {
    AppMethodBeat.i(96013);
    if ((this.fki == null) || (this.fki.equals("")))
    {
      com.tencent.mm.kernel.g.afC();
      this.fki = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
    }
    String str = this.fki;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void dur()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.csT.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dus();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final void g(List<com.tencent.mm.plugin.sns.j.m> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.wKK.wOm = paramBoolean;
    this.wKK.wOk.clear();
    this.wKK.wOk.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.j.m localm;
    if (bt.gL(this.wKK.wOl))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localm = (com.tencent.mm.plugin.sns.j.m)paramList.next();
        if (localm.type == 2) {
          localArrayList.add(localm);
        }
      }
    }
    paramList = paramList.iterator();
    label381:
    for (;;)
    {
      if (paramList.hasNext())
      {
        localm = (com.tencent.mm.plugin.sns.j.m)paramList.next();
        if (localm.type == 2)
        {
          Iterator localIterator = this.wKK.wOl.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!bt.kU(((com.tencent.mm.plugin.sns.j.m)localIterator.next()).name, localm.name));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label381;
          }
          localArrayList.add(localm);
          break;
          if (!bt.gL(localArrayList)) {
            this.wKK.wOl.addAll(0, localArrayList);
          }
          if (this.wKK.wOl.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.wKK.wOl);
            this.wKK.wOl.clear();
            this.wKK.wOl.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.wKK.toByteArray();
            com.tencent.mm.vfs.i.f(wKI, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + wKI, new Object[0]);
            com.tencent.mm.vfs.i.deleteFile(wKI);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final boolean iv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    com.tencent.mm.vfs.i.lC(paramString1, str);
    paramString1 = new ba(1);
    paramString1.aoS(paramString2);
    paramString1.Mw(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.p(str, 2));
    paramString1.fr(paramString2);
    if (paramString1.commit() > 0)
    {
      AppMethodBeat.o(96016);
      return true;
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(96030);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    switch (paramn.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        drS();
        continue;
        paramString = (r)paramn;
        int i = paramString.dzf;
        if (paramString.fuh)
        {
          long l = paramString.wFm;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            af.dtt().sL(l);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new q(l, 1), 0);
          }
          af.dtu().Nf(i);
          if (l != 0L)
          {
            af.dtz().tc(l);
            com.tencent.mm.plugin.sns.storage.i.tb(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          aq(paramString.dzf, false);
        }
        for (;;)
        {
          this.wKJ = null;
          break;
          aq(paramString.dzf, true);
          ak.report(paramString.wFm);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public final void z(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96020);
    if (paramp == null)
    {
      AppMethodBeat.o(96020);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "cancel snsinfo " + paramp.dxX());
    try
    {
      Object localObject1 = (bpj)new bpj().parseFrom(paramp.field_postBuf);
      if ((localObject1 != null) && (((bpj)localObject1).DNp != null))
      {
        localObject1 = ((bpj)localObject1).DNp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          bmh localbmh = (bmh)((Iterator)localObject1).next();
          int i = af.dtt().Mm(localbmh.DJN);
          af.dtt().Ml(localbmh.DJN);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramp.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.cancel(i);
            af.dtt().Mk(localbmh.DJN);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dxX());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((af.dtt().Mg(paramp.xiB)) && (this.wKJ != null))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadManager", "cancel post");
        this.wKJ.fuh = true;
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(this.wKJ);
        af.dtt().Mi(paramp.xiB);
      }
      Object localObject2 = af.dtu().Ne(paramp.xiB);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId != 0L))
      {
        af.dtt().sL(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new q(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId, 1), 0);
      }
      af.dtu().Nf(paramp.xiB);
      if (paramp.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.dsq().dss();
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramp.dxX());
      localObject2 = new tt();
      ((tt)localObject2).dzb.dzc = paramp.xiB;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      AppMethodBeat.o(96020);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ar(int paramInt, boolean paramBoolean);
    
    public abstract void dus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.az
 * JD-Core Version:    0.7.0.1
 */