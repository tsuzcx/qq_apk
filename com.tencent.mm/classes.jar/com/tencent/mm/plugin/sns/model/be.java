package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class be
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.sns.b.m
{
  private static int DGB;
  private static final String DOF;
  private t DOG;
  public com.tencent.mm.plugin.sns.j.m DOH;
  public ad.a DOI;
  private String gna;
  private Set<a> listeners;
  
  static
  {
    AppMethodBeat.i(96034);
    DGB = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    DOF = com.tencent.mm.kernel.g.aAh().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public be()
  {
    AppMethodBeat.i(96011);
    this.gna = "";
    this.DOG = null;
    this.listeners = new HashSet();
    this.DOH = new com.tencent.mm.plugin.sns.j.m();
    this.DOI = new ad.a()
    {
      public final void uO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          be.this.eZn();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = com.tencent.mm.vfs.s.aW(DOF, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.DOH = ((com.tencent.mm.plugin.sns.j.m)new com.tencent.mm.plugin.sns.j.m().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.s.deleteFile(DOF);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean I(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96019);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramSnsInfo.getTimeLine();
    if (((TimeLineObject)localObject1).ContentObj.LoU == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).ContentObj.LoU == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).ContentObj.LoU == 26)
    {
      localObject2 = new hb();
      ((hb)localObject2).dLm.type = 30;
      ((hb)localObject2).dLm.dLt = 5;
      ((hb)localObject2).dLm.desc = ((TimeLineObject)localObject1).ContentObj.LoX;
      ((hb)localObject2).dLm.dLs = String.valueOf(paramSnsInfo.localid);
      EventCenter.instance.publish((IEvent)localObject2);
      if (((hb)localObject2).dLn.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).ContentObj.LoV == null))
    {
      a(paramSnsInfo, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).ContentObj.LoV.size() == 0)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    label534:
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = (cnc)new cnc().parseFrom(paramSnsInfo.getPostBuf());
        if (((TimeLineObject)localObject1).ContentObj.LoU != 1) {
          break label537;
        }
        if (((cnc)localObject2).MsW.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).ContentObj.LoU != 21) {
            break label534;
          }
          bool = false;
          if (((TimeLineObject)localObject1).ContentObj.LoU != 15) {
            break label430;
          }
          localObject1 = ((cnc)localObject2).MsW.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label423;
          }
          localObject2 = (cjs)((Iterator)localObject1).next();
          localObject3 = YE(((cjs)localObject2).Mpj);
          if (localObject3 != be.b.DOU) {
            break label408;
          }
          a(paramSnsInfo, ((cjs)localObject2).Mpj, 2, "upload has set it fail");
          AppMethodBeat.o(96019);
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramSnsInfo.getLocalid());
        a(paramSnsInfo, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(96019);
        return false;
      }
      boolean bool = false;
      continue;
      label408:
      if (localObject3 == be.b.DOW)
      {
        AppMethodBeat.o(96019);
        return false;
        label423:
        AppMethodBeat.o(96019);
        return true;
        label430:
        localObject3 = ((cnc)localObject2).MsW.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          cjs localcjs = (cjs)((Iterator)localObject3).next();
          be.b localb = a(localcjs.Mpj, bool, (cnc)localObject2, localException.ContentObj.LoU);
          if (localb == be.b.DOU)
          {
            a(paramSnsInfo, localcjs.Mpj, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == be.b.DOW)
          {
            AppMethodBeat.o(96019);
            return false;
          }
        }
        AppMethodBeat.o(96019);
        return true;
        continue;
        label537:
        bool = true;
      }
    }
  }
  
  private boolean K(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96024);
    final cnc localcnc;
    try
    {
      localcnc = (cnc)new cnc().parseFrom(paramSnsInfo.getPostBuf());
      localcnc.ibG += 1;
      paramSnsInfo.setPostBuf(localcnc.toByteArray());
      aj.faO().d(paramSnsInfo.localid, paramSnsInfo);
      if (paramSnsInfo.isTimeLimit(localcnc.ibG, localcnc.MsZ))
      {
        a(paramSnsInfo, 6, "this item isTimeLimit");
        Log.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramSnsInfo.getLocalid() + " is die ");
        AppMethodBeat.o(96024);
        return false;
      }
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramSnsInfo, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(96024);
      return false;
    }
    Log.i("MicroMsg.UploadManager", "try start post " + paramSnsInfo.getLocalid());
    final TimeLineObject localTimeLineObject;
    Object localObject2;
    final int i;
    int j;
    com.tencent.mm.plugin.sns.storage.q localq;
    Object localObject3;
    String str;
    Object localObject5;
    int k;
    Object localObject4;
    Object localObject1;
    if (I(paramSnsInfo))
    {
      localTimeLineObject = paramSnsInfo.getTimeLine();
      localObject2 = a(paramSnsInfo, localcnc);
      i = 0;
      if (i < localcnc.MsW.size())
      {
        j = ((cjs)localcnc.MsW.get(i)).Mpj;
        localq = aj.faD().JK(j);
        if (localq == null)
        {
          a(paramSnsInfo, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (cne)new cne().parseFrom(localq.EmR);
          if ((((cne)localObject3).Mtr == null) || (((cne)localObject3).Mtt.size() <= 0))
          {
            Log.e("MicroMsg.UploadManager", "item with not url" + paramSnsInfo.field_type);
            if (paramSnsInfo.field_type == 3) {
              break label821;
            }
            a(paramSnsInfo, 4, "buf url is null");
            AppMethodBeat.o(96024);
            return false;
          }
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramSnsInfo, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(96024);
          return false;
        }
        str = ((cne)localObject3).Mtr.Url;
        localObject5 = ((cmw)((cne)localObject3).Mtt.get(0)).Url;
        j = ((cne)localObject3).Mtr.oUv;
        k = ((cmw)((cne)localObject3).Mtt.get(0)).oUv;
        localObject4 = ((cne)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.ContentObj.LoV.size()) {
          localObject1 = ((cnb)localTimeLineObject.ContentObj.LoV.get(i)).MsB;
        }
        if ((localTimeLineObject.ContentObj.LoU == 4) || (localTimeLineObject.ContentObj.LoU == 42) || (localTimeLineObject.ContentObj.LoU == 5))
        {
          if (i >= localTimeLineObject.ContentObj.LoV.size()) {
            break label1162;
          }
          localObject1 = (cnb)localTimeLineObject.ContentObj.LoV.get(i);
          ((cnb)localObject1).Msz = ((String)localObject5);
          ((cnb)localObject1).MsA = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.LoU == 1)) {
        ((cnb)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.LoU == 15))
      {
        ((cnb)localObject1).md5 = ((cne)localObject3).md5;
        ((cnb)localObject1).MsS = ((cne)localObject3).MsS;
      }
      if (i < localTimeLineObject.ContentObj.LoV.size())
      {
        localObject3 = (cnb)localTimeLineObject.ContentObj.LoV.get(i);
        ((cnb)localObject1).Title = ((cnb)localObject3).Title;
        ((cnb)localObject1).Desc = ((cnb)localObject3).Desc;
        ((cnb)localObject1).subType = ((cnb)localObject3).subType;
        ((cnb)localObject1).EpK = ((cnb)localObject3).EpK;
        ((cnb)localObject1).MsT = ((cnb)localObject3).MsT;
      }
      if (localObject1 == null)
      {
        a(paramSnsInfo, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = com.tencent.mm.modelsns.n.a(localq.EmQ, localq.type, str, (String)localObject5, j, k, ((cne)localObject3).Privated, "", (cnd)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).ContentObj.LoV.add(localObject1);
        i += 1;
        break;
        label821:
        if (!aj.faN().Yu(paramSnsInfo.localid))
        {
          Log.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localcnc.MsX.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((ebm)((Iterator)localObject3).next()).UserName);
        }
        localObject3 = o.e((TimeLineObject)localObject2);
        Log.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).contentDescScene + " contentDescShowType: " + ((TimeLineObject)localObject2).contentDescShowType);
        if (paramSnsInfo.field_pravited == 1) {
          Log.i("MicroMsg.UploadManager", "content private xml is null ? " + Util.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramSnsInfo, 5, "content is error");
          aj.faN().Yv(paramSnsInfo.localid);
          AppMethodBeat.o(96024);
          return false;
          Log.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localcnc.Mtf == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramSnsInfo.localid;
          localObject4 = localcnc.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).Location.Mpw;
          localObject2 = ((TimeLineObject)localObject2).ContentObj.Title;
          aj.dRd().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (aj.isInValid())
              {
                Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localcnc.Mtn != null)
              {
                i = localcnc.Mtn.KIF;
                str = localcnc.Mtn.xuk;
              }
              be.a(be.this, new t(this.val$content, localcnc.Privated, localcnc.MsV, this.DOL, localTimeLineObject, i, localcnc.izX, localcnc.Mta, localcnc.Mtb, localcnc.Mtc, localcnc, bool, this.DOO, localcnc.Mtg, this.DOP, this.dqb, i, str));
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(be.d(be.this), 0);
              AppMethodBeat.o(96005);
            }
          });
          Log.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramSnsInfo.getLocalid());
          AppMethodBeat.o(96024);
          return true;
        }
        label1162:
        localObject1 = null;
      }
    }
  }
  
  private be.b YE(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = be.b.DOU;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = aj.faD().JK(paramInt);
    cne localcne;
    try
    {
      localcne = (cne)new cne().parseFrom(((com.tencent.mm.plugin.sns.storage.q)localObject).EmR);
      Log.i("MicroMsg.UploadManager", "state " + localcne.Mpa + " doUploadSight, serverErr:" + localcne.Mtd);
      if (localcne.Mpa == 1)
      {
        localObject = be.b.DOU;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = be.b.DOU;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.s.boW(localcne.videoPath) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not fileexist  " + localcne.videoPath);
      localb = be.b.DOU;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.s.boW(localcne.Mtv) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localcne.Mtv);
      localb = be.b.DOU;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localcne.Mpa == 0)
    {
      localb = be.b.DOV;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (aj.faN().Yw(paramInt))
    {
      aj.faD().a(paramInt, localb);
      new ad(paramInt, localb, localcne.videoPath, localcne.Mtv, this.DOI).aPf(localcne.dNI);
    }
    be.b localb = be.b.DOW;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private be.b a(final int paramInt1, final boolean paramBoolean, final cnc paramcnc, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      paramcnc = be.b.DOU;
      AppMethodBeat.o(96026);
      return paramcnc;
    }
    Object localObject = aj.faD().JK(paramInt1);
    cne localcne;
    try
    {
      localcne = (cne)new cne().parseFrom(((com.tencent.mm.plugin.sns.storage.q)localObject).EmR);
      Log.i("MicroMsg.UploadManager", "state " + localcne.Mpa + " pic isMuti: " + paramBoolean);
      if (localcne.Mpa == 1)
      {
        paramcnc = be.b.DOU;
        AppMethodBeat.o(96026);
        return paramcnc;
      }
    }
    catch (Exception paramcnc)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      paramcnc = be.b.DOU;
      AppMethodBeat.o(96026);
      return paramcnc;
    }
    String str = com.tencent.mm.plugin.sns.data.r.aOj(((com.tencent.mm.plugin.sns.storage.q)localObject).EmN);
    str = ar.ki(aj.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.q)localObject).EmN) + str;
    if (com.tencent.mm.vfs.s.boW(str) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      paramcnc = be.b.DOU;
      AppMethodBeat.o(96026);
      return paramcnc;
    }
    if (localcne.Mpa == 0)
    {
      paramcnc = be.b.DOV;
      AppMethodBeat.o(96026);
      return paramcnc;
    }
    if (aj.faN().Yw(paramInt1))
    {
      aj.faD().a(paramInt1, (com.tencent.mm.plugin.sns.storage.q)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + " " + System.currentTimeMillis()).getBytes());
      aj.dRd().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (aj.isInValid())
          {
            Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          aa localaa = new aa(paramInt1, this.DOR, paramBoolean, paramInt2);
          aj.faN().iv(paramInt1, localaa.hashCode());
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(localaa, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    paramcnc = be.b.DOW;
    AppMethodBeat.o(96026);
    return paramcnc;
  }
  
  private static TimeLineObject a(SnsInfo paramSnsInfo, cnc paramcnc)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject2.Location;
    String str1 = localTimeLineObject2.ContentDesc;
    String str2 = localTimeLineObject2.sourceUserName;
    String str3 = localTimeLineObject2.sourceNickName;
    String str4 = localTimeLineObject2.ContentObj.Desc;
    String str5 = localTimeLineObject2.ContentObj.Title;
    String str6 = localTimeLineObject2.ContentObj.Url;
    String str7 = localTimeLineObject2.ContentObj.LoX;
    fa localfa = localTimeLineObject2.AppInfo;
    eyd localeyd = localTimeLineObject2.weappInfo;
    cio localcio = localTimeLineObject2.liteappInfo;
    int i = localTimeLineObject2.ContentObj.LoU;
    int j = localTimeLineObject2.ContentObj.LoW;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.n.bfM();
    localTimeLineObject1.UserName = paramSnsInfo.getUserName();
    localTimeLineObject1.Privated = paramSnsInfo.getPravited();
    localTimeLineObject1.ContentDesc = str1;
    localTimeLineObject1.sourceUserName = Util.nullAsNil(str2);
    localTimeLineObject1.sourceNickName = Util.nullAsNil(str3);
    localTimeLineObject1.contentDescShowType = localTimeLineObject2.contentDescShowType;
    localTimeLineObject1.contentDescScene = localTimeLineObject2.contentDescScene;
    localTimeLineObject1.contentattr = localTimeLineObject2.contentattr;
    localTimeLineObject1.statisticsData = localTimeLineObject2.statisticsData;
    localTimeLineObject1.canvasInfo = localTimeLineObject2.canvasInfo;
    localTimeLineObject1.ContentObj.Desc = str4;
    localTimeLineObject1.ContentObj.Title = str5;
    localTimeLineObject1.ContentObj.LoU = i;
    localTimeLineObject1.ContentObj.LoW = j;
    localTimeLineObject1.ContentObj.Url = str6;
    localTimeLineObject1.ContentObj.LoX = str7;
    localTimeLineObject1.ContentObj.dME = localTimeLineObject2.ContentObj.dME;
    localTimeLineObject1.ContentObj.jfy = localTimeLineObject2.ContentObj.jfy;
    localTimeLineObject1.ContentObj.LoZ = localTimeLineObject2.ContentObj.LoZ;
    localTimeLineObject1.ContentObj.Lpe = localTimeLineObject2.ContentObj.Lpe;
    localTimeLineObject1.ContentObj.Lpb = localTimeLineObject2.ContentObj.Lpb;
    localTimeLineObject1.ContentObj.Lpa = localTimeLineObject2.ContentObj.Lpa;
    localTimeLineObject1.ContentObj.Lpc = localTimeLineObject2.ContentObj.Lpc;
    localTimeLineObject1.ContentObj.Lpd = localTimeLineObject2.ContentObj.Lpd;
    localTimeLineObject1.Location = ((cjy)localObject);
    localTimeLineObject1.streamvideo = localTimeLineObject2.streamvideo;
    localTimeLineObject1.statExtStr = localTimeLineObject2.statExtStr;
    if (localTimeLineObject2.actionInfo != null) {
      localTimeLineObject1.actionInfo = localTimeLineObject2.actionInfo;
    }
    if (localfa != null) {
      localTimeLineObject1.AppInfo = localfa;
    }
    if (localeyd != null) {
      localTimeLineObject1.weappInfo = localeyd;
    }
    if (localcio != null) {
      localTimeLineObject1.liteappInfo = localcio;
    }
    paramSnsInfo = localTimeLineObject2.ContentObj.LoV.iterator();
    while (paramSnsInfo.hasNext())
    {
      localObject = (cnb)paramSnsInfo.next();
      if (((cnb)localObject).MsE == 1) {
        localTimeLineObject1.ContentObj.LoV.add(localObject);
      }
    }
    if (localTimeLineObject2.webSearchInfo != null) {
      localTimeLineObject1.webSearchInfo = localTimeLineObject2.webSearchInfo;
    }
    paramSnsInfo = com.tencent.mm.model.ad.aVe().G(paramcnc.sessionId, true);
    if (paramSnsInfo.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramSnsInfo.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.ContentObj.LoY = new cli();
        localTimeLineObject1.ContentObj.LoY.iAb = i;
        localTimeLineObject1.ContentObj.LoY.iwf = paramSnsInfo.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.ContentObj.LoY.vid = paramSnsInfo.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.ContentObj.LoY.iwd = paramSnsInfo.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.ContentObj.LoY.duration = paramSnsInfo.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.ContentObj.LoY.desc = paramSnsInfo.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.ContentObj.LoY.coverUrl = paramSnsInfo.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.ContentObj.LoY.videoWidth = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.ContentObj.LoY.videoHeight = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.ContentObj.LoY.iwg = paramSnsInfo.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(96023);
    return localTimeLineObject1;
  }
  
  private void a(SnsInfo paramSnsInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96014);
    Log.i("MicroMsg.UploadManager", "localId " + paramSnsInfo.getLocalid() + "processError " + paramInt2 + " errMsg: " + paramString);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = aj.faD().JK(paramInt1);
      try
      {
        i = ((cne)new cne().parseFrom(paramString.EmR)).Mtd;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramSnsInfo.getPostInfo();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.Mtd = i;
        paramSnsInfo.setPostBuf(paramString.toByteArray());
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
    Log.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramSnsInfo.setItemDie();
    aj.faO().d(paramSnsInfo.localid, paramSnsInfo);
    Log.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramSnsInfo.localid);
    paramString = new vy();
    paramString.ecb.ecc = paramSnsInfo.localid;
    EventCenter.instance.publish(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      aR(paramSnsInfo.localid, false);
      AppMethodBeat.o(96014);
      return;
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramSnsInfo.getPostInfo();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.Mtd;
      break;
      Log.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      Log.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      Log.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      Log.e("MicroMsg.UploadManager", "arg is error");
      continue;
      Log.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      Log.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(SnsInfo paramSnsInfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(96015);
    a(paramSnsInfo, 0, paramInt, paramString);
    AppMethodBeat.o(96015);
  }
  
  private static void a(cnc paramcnc)
  {
    AppMethodBeat.i(96027);
    if (paramcnc == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    paramcnc = paramcnc.MsW.iterator();
    while (paramcnc.hasNext())
    {
      cjs localcjs = (cjs)paramcnc.next();
      aj.faN().Yx(localcjs.Mpj);
    }
    AppMethodBeat.o(96027);
  }
  
  private void aR(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    aj.dRd().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (aj.isInValid())
        {
          Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = be.c(be.this).iterator();
        while (localIterator.hasNext())
        {
          be.a locala = (be.a)localIterator.next();
          if (locala != null) {
            locala.aP(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static bf c(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96017);
    Log.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    Log.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    bf localbf;
    for (;;)
    {
      localbf = new bf(i);
      localbf.aPC(Util.nullAs(paramString2, "")).aPD(Util.nullAs(paramString3, ""));
      localbf.YK(5);
      Log.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      Log.d("MicroMsg.UploadManager", "timeLineType is invalid");
      AppMethodBeat.o(96017);
      return null;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 42;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 3;
    }
    if (!Util.isNullOrNil(paramString1)) {
      localbf.aPw(paramString1);
    }
    localbf.aPB(Util.nullAs(paramWXMediaMessage.title, "")).aPz(Util.nullAs(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      Log.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbf.aPz("");
      localbf.aPw(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbf;
      paramString2 = (WXMusicObject)localObject;
      if (!Util.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramString3 = Util.nullAs(paramString1, "");
        if (Util.isNullOrNil(paramString2.musicDataUrl)) {
          break label505;
        }
      }
      label505:
      for (paramString1 = paramString2.musicDataUrl;; paramString1 = paramString2.musicUrl)
      {
        localObject = Util.nullAs(paramString1, "");
        localbf.aPB("").aPz("");
        i = tN(3);
        if (i != -1) {
          break label513;
        }
        Log.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = paramString2.musicLowBandUrl;
        break;
      }
      label513:
      if (!Util.isNullOrNil(paramString2.musicLowBandDataUrl)) {}
      for (paramString1 = paramString2.musicLowBandDataUrl;; paramString1 = paramString2.musicLowBandUrl)
      {
        paramString1 = Util.nullAs(paramString1, "");
        if (localbf.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        if (!localbf.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbf.kn(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else
      {
        Log.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!Util.isNullOrNil(paramWXMediaMessage.thumbData)) {
          localbf.b(paramWXMediaMessage.thumbData, Util.nullAs(paramWXMediaMessage.description, ""), Util.nullAs(paramWXMediaMessage.title, ""));
        }
        localbf.aPz(paramString1.webpageUrl).aPA(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbf.DPd.ContentObj.Url = paramWXMediaMessage;
        localbf.aPy(paramString1.canvasPageXml);
        continue;
        Log.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbf.aPB("").aPz("");
        i = tN(4);
        if (i == -1)
        {
          Log.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(96017);
          return null;
        }
        if (!Util.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = Util.nullAs(paramString1, "");
          if (localbf.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((Util.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbf.aPB(paramWXMediaMessage.filePath);
        localbf.aPz(paramWXMediaMessage.filePath);
      }
    }
    Log.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean fbS()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = aj.faO();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.n.Emz + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject1).iFy.rawQuery((String)localObject2, null);
    Log.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = new SnsInfo();
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
      ((SnsInfo)localObject2).convertFrom((Cursor)localObject1);
      try
      {
        cnc localcnc = (cnc)new cnc().parseFrom(((SnsInfo)localObject2).getPostBuf());
        if (((SnsInfo)localObject2).isTimeLimit(localcnc.ibG, localcnc.MsZ))
        {
          a(localcnc);
          a((SnsInfo)localObject2, 6, "snsinfo is tle");
          Log.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((SnsInfo)localObject2).getLocalid() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((SnsInfo)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(96022);
    return true;
  }
  
  public static int tN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 76: 
      return 5;
    case 2: 
      return 2;
    }
    return 4;
  }
  
  public final void J(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96020);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96020);
      return;
    }
    Log.i("MicroMsg.UploadManager", "cancel snsinfo " + paramSnsInfo.getLocalid());
    try
    {
      Object localObject1 = (cnc)new cnc().parseFrom(paramSnsInfo.getPostBuf());
      if ((localObject1 != null) && (((cnc)localObject1).MsW != null))
      {
        localObject1 = ((cnc)localObject1).MsW.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          cjs localcjs = (cjs)((Iterator)localObject1).next();
          int i = aj.faN().Yz(localcjs.Mpj);
          aj.faN().Yy(localcjs.Mpj);
          Log.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramSnsInfo.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.cancel(i);
            aj.faN().Yx(localcjs.Mpj);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramSnsInfo.getLocalid());
        a(paramSnsInfo, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((aj.faN().Yt(paramSnsInfo.localid)) && (this.DOG != null))
      {
        Log.i("MicroMsg.UploadManager", "cancel post");
        this.DOG.gyp = true;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(this.DOG);
        aj.faN().Yv(paramSnsInfo.localid);
      }
      Object localObject2 = aj.faO().Zr(paramSnsInfo.localid);
      if ((localObject2 != null) && (((SnsInfo)localObject2).field_snsId != 0L))
      {
        aj.faN().Jr(((SnsInfo)localObject2).field_snsId);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new s(((SnsInfo)localObject2).field_snsId, 1), 0);
      }
      aj.faO().Zs(paramSnsInfo.localid);
      if (paramSnsInfo.getTypeFlag() == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.eZK().eZM();
      }
      Log.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramSnsInfo.getLocalid());
      localObject2 = new vy();
      ((vy)localObject2).ecb.ecc = paramSnsInfo.localid;
      EventCenter.instance.publish((IEvent)localObject2);
      AppMethodBeat.o(96020);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(202795);
    this.listeners.add(parama);
    int i = DGB + 1;
    DGB = i;
    if (i > 1)
    {
      AppMethodBeat.o(202795);
      return;
    }
    AppMethodBeat.o(202795);
  }
  
  public final boolean a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(96018);
    paramString1 = c(paramWXMediaMessage, paramString1, paramString2, paramString3);
    if (paramString1 == null)
    {
      AppMethodBeat.o(96018);
      return false;
    }
    paramString1.aPx(paramWXMediaMessage.mediaTagName);
    paramString1.aO(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > a.DCT) {
      paramString1.YF(1);
    }
    Log.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(202796);
    this.listeners.remove(parama);
    int i = DGB - 1;
    DGB = i;
    if (i > 0)
    {
      AppMethodBeat.o(202796);
      return;
    }
    AppMethodBeat.o(202796);
  }
  
  public final void eZn()
  {
    AppMethodBeat.i(96021);
    aj.dRd().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        be.a(be.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String fau()
  {
    AppMethodBeat.i(96013);
    if ((this.gna == null) || (this.gna.equals("")))
    {
      com.tencent.mm.kernel.g.aAi();
      this.gna = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
    }
    String str = this.gna;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void fbT()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fbl();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final boolean jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    Log.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    com.tencent.mm.vfs.s.nw(paramString1, str);
    paramString1 = new bf(1);
    paramString1.aPw(paramString2);
    paramString1.YK(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.q(str, 2));
    paramString1.gS(paramString2);
    if (paramString1.commit() > 0)
    {
      AppMethodBeat.o(96016);
      return true;
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final void m(List<com.tencent.mm.plugin.sns.j.n> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.DOH.DSg = paramBoolean;
    this.DOH.DSe.clear();
    this.DOH.DSe.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.j.n localn;
    if (Util.isNullOrNil(this.DOH.DSf))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localn = (com.tencent.mm.plugin.sns.j.n)paramList.next();
        if (localn.type == 2) {
          localArrayList.add(localn);
        }
      }
    }
    paramList = paramList.iterator();
    label381:
    for (;;)
    {
      if (paramList.hasNext())
      {
        localn = (com.tencent.mm.plugin.sns.j.n)paramList.next();
        if (localn.type == 2)
        {
          Iterator localIterator = this.DOH.DSf.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!Util.isEqual(((com.tencent.mm.plugin.sns.j.n)localIterator.next()).name, localn.name));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label381;
          }
          localArrayList.add(localn);
          break;
          if (!Util.isNullOrNil(localArrayList)) {
            this.DOH.DSf.addAll(0, localArrayList);
          }
          if (this.DOH.DSf.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.DOH.DSf);
            this.DOH.DSf.clear();
            this.DOH.DSf.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.DOH.toByteArray();
            com.tencent.mm.vfs.s.f(DOF, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            Log.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + DOF, new Object[0]);
            com.tencent.mm.vfs.s.deleteFile(DOF);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(96030);
    Log.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType() + " @" + hashCode());
    switch (paramq.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        eZn();
        continue;
        paramString = (t)paramq;
        int i = paramString.ecf;
        if (paramString.gyp)
        {
          long l = paramString.Dyz;
          Log.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            aj.faN().Jr(l);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(new s(l, 1), 0);
          }
          aj.faO().Zs(i);
          if (l != 0L)
          {
            aj.faT().JI(l);
            com.tencent.mm.plugin.sns.storage.g.JH(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          aR(paramString.ecf, false);
        }
        for (;;)
        {
          this.DOG = null;
          break;
          aR(paramString.ecf, true);
          ao.report(paramString.Dyz);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void aP(int paramInt, boolean paramBoolean);
    
    public abstract void fbl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.be
 * JD-Core Version:    0.7.0.1
 */