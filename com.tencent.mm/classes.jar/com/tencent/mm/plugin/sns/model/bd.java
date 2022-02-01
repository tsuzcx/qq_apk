package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.xd;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
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
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class bd
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.sns.b.n
{
  private static int JTz;
  private static final String KbM;
  private t KbN;
  public m KbO;
  public ad.a KbP;
  private String iRj;
  private Set<a> listeners;
  
  static
  {
    AppMethodBeat.i(96034);
    JTz = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    KbM = com.tencent.mm.kernel.h.aHG().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public bd()
  {
    AppMethodBeat.i(96011);
    this.iRj = "";
    this.KbN = null;
    this.listeners = new HashSet();
    this.KbO = new m();
    this.KbP = new ad.a()
    {
      public final void yv(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          bd.this.fNd();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = u.aY(KbM, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.KbO = ((m)new m().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        u.deleteFile(KbM);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean J(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96019);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramSnsInfo.getTimeLine();
    if (((TimeLineObject)localObject1).ContentObj.Sqq == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).ContentObj.Sqq == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).ContentObj.Sqq == 26)
    {
      localObject2 = new hi();
      ((hi)localObject2).fEb.type = 30;
      ((hi)localObject2).fEb.fEi = 5;
      ((hi)localObject2).fEb.desc = ((TimeLineObject)localObject1).ContentObj.Sqt;
      ((hi)localObject2).fEb.fEh = String.valueOf(paramSnsInfo.localid);
      EventCenter.instance.publish((IEvent)localObject2);
      if (((hi)localObject2).fEc.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).ContentObj.Sqr == null))
    {
      a(paramSnsInfo, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).ContentObj.Sqr.size() == 0)
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
        localObject2 = (cvu)new cvu().parseFrom(paramSnsInfo.getPostBuf());
        if (((TimeLineObject)localObject1).ContentObj.Sqq != 1) {
          break label537;
        }
        if (((cvu)localObject2).TEc.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).ContentObj.Sqq != 21) {
            break label534;
          }
          bool = false;
          if (((TimeLineObject)localObject1).ContentObj.Sqq != 15) {
            break label430;
          }
          localObject1 = ((cvu)localObject2).TEc.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label423;
          }
          localObject2 = (csn)((Iterator)localObject1).next();
          localObject3 = afV(((csn)localObject2).TAo);
          if (localObject3 != bd.b.Kcb) {
            break label408;
          }
          a(paramSnsInfo, ((csn)localObject2).TAo, 2, "upload has set it fail");
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
      if (localObject3 == bd.b.Kcd)
      {
        AppMethodBeat.o(96019);
        return false;
        label423:
        AppMethodBeat.o(96019);
        return true;
        label430:
        localObject3 = ((cvu)localObject2).TEc.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          csn localcsn = (csn)((Iterator)localObject3).next();
          bd.b localb = a(localcsn.TAo, bool, (cvu)localObject2, localException.ContentObj.Sqq);
          if (localb == bd.b.Kcb)
          {
            a(paramSnsInfo, localcsn.TAo, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == bd.b.Kcd)
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
  
  private boolean L(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96024);
    final cvu localcvu;
    try
    {
      localcvu = (cvu)new cvu().parseFrom(paramSnsInfo.getPostBuf());
      localcvu.kQn += 1;
      paramSnsInfo.setPostBuf(localcvu.toByteArray());
      aj.fOI().d(paramSnsInfo.localid, paramSnsInfo);
      if (paramSnsInfo.isTimeLimit(localcvu.kQn, localcvu.TEf))
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
    if (J(paramSnsInfo))
    {
      localTimeLineObject = paramSnsInfo.getTimeLine();
      localObject2 = a(paramSnsInfo, localcvu);
      i = 0;
      if (i < localcvu.TEc.size())
      {
        j = ((csn)localcvu.TEc.get(i)).TAo;
        localq = aj.fOx().Re(j);
        if (localq == null)
        {
          a(paramSnsInfo, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (cvw)new cvw().parseFrom(localq.KAa);
          if ((((cvw)localObject3).TEx == null) || (((cvw)localObject3).TEz.size() <= 0))
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
        str = ((cvw)localObject3).TEx.Url;
        localObject5 = ((cvo)((cvw)localObject3).TEz.get(0)).Url;
        j = ((cvw)localObject3).TEx.rWu;
        k = ((cvo)((cvw)localObject3).TEz.get(0)).rWu;
        localObject4 = ((cvw)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.ContentObj.Sqr.size()) {
          localObject1 = ((cvt)localTimeLineObject.ContentObj.Sqr.get(i)).TDH;
        }
        if ((localTimeLineObject.ContentObj.Sqq == 4) || (localTimeLineObject.ContentObj.Sqq == 42) || (localTimeLineObject.ContentObj.Sqq == 5))
        {
          if (i >= localTimeLineObject.ContentObj.Sqr.size()) {
            break label1162;
          }
          localObject1 = (cvt)localTimeLineObject.ContentObj.Sqr.get(i);
          ((cvt)localObject1).TDF = ((String)localObject5);
          ((cvt)localObject1).TDG = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.Sqq == 1)) {
        ((cvt)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.Sqq == 15))
      {
        ((cvt)localObject1).md5 = ((cvw)localObject3).md5;
        ((cvt)localObject1).TDY = ((cvw)localObject3).TDY;
      }
      if (i < localTimeLineObject.ContentObj.Sqr.size())
      {
        localObject3 = (cvt)localTimeLineObject.ContentObj.Sqr.get(i);
        ((cvt)localObject1).fwr = ((cvt)localObject3).fwr;
        ((cvt)localObject1).CMB = ((cvt)localObject3).CMB;
        ((cvt)localObject1).subType = ((cvt)localObject3).subType;
        ((cvt)localObject1).KCT = ((cvt)localObject3).KCT;
        ((cvt)localObject1).TDZ = ((cvt)localObject3).TDZ;
      }
      if (localObject1 == null)
      {
        a(paramSnsInfo, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = com.tencent.mm.modelsns.o.a(localq.KzZ, localq.type, str, (String)localObject5, j, k, ((cvw)localObject3).Privated, "", (cvv)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).ContentObj.Sqr.add(localObject1);
        i += 1;
        break;
        label821:
        if (!aj.fOH().afM(paramSnsInfo.localid))
        {
          Log.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localcvu.TEd.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((elm)((Iterator)localObject3).next()).UserName);
        }
        localObject3 = com.tencent.mm.plugin.sns.j.o.e((TimeLineObject)localObject2);
        Log.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).contentDescScene + " contentDescShowType: " + ((TimeLineObject)localObject2).contentDescShowType);
        if (paramSnsInfo.field_pravited == 1) {
          Log.i("MicroMsg.UploadManager", "content private xml is null ? " + Util.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramSnsInfo, 5, "content is error");
          aj.fOH().afN(paramSnsInfo.localid);
          AppMethodBeat.o(96024);
          return false;
          Log.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localcvu.TEl == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramSnsInfo.localid;
          localObject4 = localcvu.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).Location.TAB;
          localObject2 = ((TimeLineObject)localObject2).ContentObj.fwr;
          aj.etE().post(new Runnable()
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
              if (localcvu.TEt != null)
              {
                i = localcvu.TEt.RJW;
                str = localcvu.TEt.CqB;
              }
              bd.a(bd.this, new t(this.val$content, localcvu.Privated, localcvu.TEb, this.KbS, localTimeLineObject, i, localcvu.lps, localcvu.TEg, localcvu.TEh, localcvu.TEi, localcvu, bool, this.KbV, localcvu.TEm, this.KbW, this.cWz, i, str));
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(bd.d(bd.this), 0);
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
  
  private bd.b a(final int paramInt1, final boolean paramBoolean, final cvu paramcvu, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      paramcvu = bd.b.Kcb;
      AppMethodBeat.o(96026);
      return paramcvu;
    }
    Object localObject = aj.fOx().Re(paramInt1);
    cvw localcvw;
    try
    {
      localcvw = (cvw)new cvw().parseFrom(((com.tencent.mm.plugin.sns.storage.q)localObject).KAa);
      Log.i("MicroMsg.UploadManager", "state " + localcvw.TAg + " pic isMuti: " + paramBoolean);
      if (localcvw.TAg == 1)
      {
        paramcvu = bd.b.Kcb;
        AppMethodBeat.o(96026);
        return paramcvu;
      }
    }
    catch (Exception paramcvu)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      paramcvu = bd.b.Kcb;
      AppMethodBeat.o(96026);
      return paramcvu;
    }
    String str = com.tencent.mm.plugin.sns.data.t.aZf(((com.tencent.mm.plugin.sns.storage.q)localObject).KzW);
    str = aq.kD(aj.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.q)localObject).KzW) + str;
    if (u.bBQ(str) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      paramcvu = bd.b.Kcb;
      AppMethodBeat.o(96026);
      return paramcvu;
    }
    if (localcvw.TAg == 0)
    {
      paramcvu = bd.b.Kcc;
      AppMethodBeat.o(96026);
      return paramcvu;
    }
    if (aj.fOH().afO(paramInt1))
    {
      aj.fOx().a(paramInt1, (com.tencent.mm.plugin.sns.storage.q)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + " " + System.currentTimeMillis()).getBytes());
      aj.etE().post(new Runnable()
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
          aa localaa = new aa(paramInt1, this.KbY, paramBoolean, paramInt2);
          aj.fOH().jE(paramInt1, localaa.hashCode());
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(localaa, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    paramcvu = bd.b.Kcd;
    AppMethodBeat.o(96026);
    return paramcvu;
  }
  
  private static TimeLineObject a(SnsInfo paramSnsInfo, cvu paramcvu)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject2.Location;
    String str1 = localTimeLineObject2.ContentDesc;
    String str2 = localTimeLineObject2.sourceUserName;
    String str3 = localTimeLineObject2.sourceNickName;
    String str4 = localTimeLineObject2.ContentObj.CMB;
    String str5 = localTimeLineObject2.ContentObj.fwr;
    String str6 = localTimeLineObject2.ContentObj.Url;
    String str7 = localTimeLineObject2.ContentObj.Sqt;
    ex localex = localTimeLineObject2.AppInfo;
    fiu localfiu = localTimeLineObject2.weappInfo;
    crk localcrk = localTimeLineObject2.liteappInfo;
    int i = localTimeLineObject2.ContentObj.Sqq;
    int j = localTimeLineObject2.ContentObj.Sqs;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.o.bpc();
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
    localTimeLineObject1.ContentObj.CMB = str4;
    localTimeLineObject1.ContentObj.fwr = str5;
    localTimeLineObject1.ContentObj.Sqq = i;
    localTimeLineObject1.ContentObj.Sqs = j;
    localTimeLineObject1.ContentObj.Url = str6;
    localTimeLineObject1.ContentObj.Sqt = str7;
    localTimeLineObject1.ContentObj.fFJ = localTimeLineObject2.ContentObj.fFJ;
    localTimeLineObject1.ContentObj.lVY = localTimeLineObject2.ContentObj.lVY;
    localTimeLineObject1.ContentObj.Sqv = localTimeLineObject2.ContentObj.Sqv;
    localTimeLineObject1.ContentObj.Sqz = localTimeLineObject2.ContentObj.Sqz;
    localTimeLineObject1.ContentObj.Sqx = localTimeLineObject2.ContentObj.Sqx;
    localTimeLineObject1.ContentObj.Sqw = localTimeLineObject2.ContentObj.Sqw;
    localTimeLineObject1.ContentObj.yNL = localTimeLineObject2.ContentObj.yNL;
    localTimeLineObject1.ContentObj.Sqy = localTimeLineObject2.ContentObj.Sqy;
    localTimeLineObject1.ContentObj.SqA = localTimeLineObject2.ContentObj.SqA;
    localTimeLineObject1.Location = ((cst)localObject);
    localTimeLineObject1.streamvideo = localTimeLineObject2.streamvideo;
    localTimeLineObject1.statExtStr = localTimeLineObject2.statExtStr;
    if (localTimeLineObject2.actionInfo != null) {
      localTimeLineObject1.actionInfo = localTimeLineObject2.actionInfo;
    }
    if (localex != null) {
      localTimeLineObject1.AppInfo = localex;
    }
    if (localfiu != null) {
      localTimeLineObject1.weappInfo = localfiu;
    }
    if (localcrk != null) {
      localTimeLineObject1.liteappInfo = localcrk;
    }
    paramSnsInfo = localTimeLineObject2.ContentObj.Sqr.iterator();
    while (paramSnsInfo.hasNext())
    {
      localObject = (cvt)paramSnsInfo.next();
      if (((cvt)localObject).TDK == 1) {
        localTimeLineObject1.ContentObj.Sqr.add(localObject);
      }
    }
    if (localTimeLineObject2.webSearchInfo != null) {
      localTimeLineObject1.webSearchInfo = localTimeLineObject2.webSearchInfo;
    }
    paramSnsInfo = com.tencent.mm.model.ad.beh().I(paramcvu.sessionId, true);
    if (paramSnsInfo.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramSnsInfo.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.ContentObj.Squ = new cuf();
        localTimeLineObject1.ContentObj.Squ.lpx = i;
        localTimeLineObject1.ContentObj.Squ.lls = paramSnsInfo.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.ContentObj.Squ.vid = paramSnsInfo.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.ContentObj.Squ.llq = paramSnsInfo.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.ContentObj.Squ.duration = paramSnsInfo.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.ContentObj.Squ.desc = paramSnsInfo.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.ContentObj.Squ.coverUrl = paramSnsInfo.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.ContentObj.Squ.videoWidth = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.ContentObj.Squ.videoHeight = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.ContentObj.Squ.llt = paramSnsInfo.getInt("_DATA_CENTER_FUNC_FLAG", 0);
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
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = aj.fOx().Re(paramInt1);
      try
      {
        i = ((cvw)new cvw().parseFrom(paramString.KAa)).TEj;
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
        paramString.TEj = i;
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
    aj.fOI().d(paramSnsInfo.localid, paramSnsInfo);
    Log.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramSnsInfo.localid);
    paramString = new xd();
    paramString.fWd.fWe = paramSnsInfo.localid;
    EventCenter.instance.publish(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      ba(paramSnsInfo.localid, false);
      AppMethodBeat.o(96014);
      return;
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramSnsInfo.getPostInfo();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.TEj;
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
  
  private static void a(cvu paramcvu)
  {
    AppMethodBeat.i(96027);
    if (paramcvu == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    paramcvu = paramcvu.TEc.iterator();
    while (paramcvu.hasNext())
    {
      csn localcsn = (csn)paramcvu.next();
      aj.fOH().afP(localcsn.TAo);
    }
    AppMethodBeat.o(96027);
  }
  
  private bd.b afV(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = bd.b.Kcb;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = aj.fOx().Re(paramInt);
    cvw localcvw;
    try
    {
      localcvw = (cvw)new cvw().parseFrom(((com.tencent.mm.plugin.sns.storage.q)localObject).KAa);
      Log.i("MicroMsg.UploadManager", "state " + localcvw.TAg + " doUploadSight, serverErr:" + localcvw.TEj);
      if (localcvw.TAg == 1)
      {
        localObject = bd.b.Kcb;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = bd.b.Kcb;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (u.bBQ(localcvw.videoPath) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not fileexist  " + localcvw.videoPath);
      localb = bd.b.Kcb;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (u.bBQ(localcvw.TEB) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localcvw.TEB);
      localb = bd.b.Kcb;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localcvw.TAg == 0)
    {
      localb = bd.b.Kcc;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (aj.fOH().afO(paramInt))
    {
      aj.fOx().a(paramInt, localb);
      new ad(paramInt, localb, localcvw.videoPath, localcvw.TEB, this.KbP).baa(localcvw.appid);
    }
    bd.b localb = bd.b.Kcd;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private void ba(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    aj.etE().post(new Runnable()
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
        Iterator localIterator = bd.c(bd.this).iterator();
        while (localIterator.hasNext())
        {
          bd.a locala = (bd.a)localIterator.next();
          if (locala != null) {
            locala.aY(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static be c(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
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
    be localbe;
    for (;;)
    {
      localbe = new be(i);
      localbe.bay(Util.nullAs(paramString2, "")).baz(Util.nullAs(paramString3, ""));
      localbe.agb(5);
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
      localbe.bas(paramString1);
    }
    localbe.bax(Util.nullAs(paramWXMediaMessage.title, "")).bav(Util.nullAs(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      Log.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbe.bav("");
      localbe.bas(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbe;
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
        localbe.bax("").bav("");
        i = wN(3);
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
        if (localbe.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        if (!localbe.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbe.kI(paramWXMediaMessage.imagePath, ""))
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
          localbe.b(paramWXMediaMessage.thumbData, Util.nullAs(paramWXMediaMessage.description, ""), Util.nullAs(paramWXMediaMessage.title, ""));
        }
        localbe.bav(paramString1.webpageUrl).baw(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbe.Kck.ContentObj.Url = paramWXMediaMessage;
        localbe.bau(paramString1.canvasPageXml);
        continue;
        Log.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbe.bax("").bav("");
        i = wN(4);
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
          if (localbe.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((Util.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbe.bax(paramWXMediaMessage.filePath);
        localbe.bav(paramWXMediaMessage.filePath);
      }
    }
    Log.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean fPK()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = aj.fOI();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.n.KzI + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject1).lvy.rawQuery((String)localObject2, null);
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
        cvu localcvu = (cvu)new cvu().parseFrom(((SnsInfo)localObject2).getPostBuf());
        if (((SnsInfo)localObject2).isTimeLimit(localcvu.kQn, localcvu.TEf))
        {
          a(localcvu);
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
  
  public static int wN(int paramInt)
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
  
  public final void K(SnsInfo paramSnsInfo)
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
      Object localObject1 = (cvu)new cvu().parseFrom(paramSnsInfo.getPostBuf());
      if ((localObject1 != null) && (((cvu)localObject1).TEc != null))
      {
        localObject1 = ((cvu)localObject1).TEc.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          csn localcsn = (csn)((Iterator)localObject1).next();
          int i = aj.fOH().afR(localcsn.TAo);
          aj.fOH().afQ(localcsn.TAo);
          Log.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramSnsInfo.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.cancel(i);
            aj.fOH().afP(localcsn.TAo);
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
      if ((aj.fOH().afL(paramSnsInfo.localid)) && (this.KbN != null))
      {
        Log.i("MicroMsg.UploadManager", "cancel post");
        this.KbN.jis = true;
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(this.KbN);
        aj.fOH().afN(paramSnsInfo.localid);
      }
      Object localObject2 = aj.fOI().agI(paramSnsInfo.localid);
      if ((localObject2 != null) && (((SnsInfo)localObject2).field_snsId != 0L))
      {
        aj.fOH().QK(((SnsInfo)localObject2).field_snsId);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new s(((SnsInfo)localObject2).field_snsId, 1), 0);
      }
      aj.fOI().agJ(paramSnsInfo.localid);
      if (paramSnsInfo.getTypeFlag() == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.fNB().fND();
      }
      Log.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramSnsInfo.getLocalid());
      localObject2 = new xd();
      ((xd)localObject2).fWd.fWe = paramSnsInfo.localid;
      EventCenter.instance.publish((IEvent)localObject2);
      AppMethodBeat.o(96020);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(201248);
    this.listeners.add(parama);
    int i = JTz + 1;
    JTz = i;
    if (i > 1)
    {
      AppMethodBeat.o(201248);
      return;
    }
    AppMethodBeat.o(201248);
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
    paramString1.bat(paramWXMediaMessage.mediaTagName);
    paramString1.aI(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > a.JPj) {
      paramString1.afW(1);
    }
    Log.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.in())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(201249);
    this.listeners.remove(parama);
    int i = JTz - 1;
    JTz = i;
    if (i > 0)
    {
      AppMethodBeat.o(201249);
      return;
    }
    AppMethodBeat.o(201249);
  }
  
  public final void fNd()
  {
    AppMethodBeat.i(96021);
    aj.etE().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        bd.a(bd.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String fOo()
  {
    AppMethodBeat.i(96013);
    if ((this.iRj == null) || (this.iRj.equals("")))
    {
      com.tencent.mm.kernel.h.aHH();
      this.iRj = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null));
    }
    String str = this.iRj;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void fPL()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.fPf();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final boolean kq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    Log.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    u.on(paramString1, str);
    paramString1 = new be(1);
    paramString1.bas(paramString2);
    paramString1.agb(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.s(str, 2));
    paramString1.hB(paramString2);
    if (paramString1.in() > 0)
    {
      AppMethodBeat.o(96016);
      return true;
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final void o(List<com.tencent.mm.plugin.sns.j.n> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.KbO.Kfo = paramBoolean;
    this.KbO.Kfm.clear();
    this.KbO.Kfm.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.j.n localn;
    if (Util.isNullOrNil(this.KbO.Kfn))
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
          Iterator localIterator = this.KbO.Kfn.iterator();
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
            this.KbO.Kfn.addAll(0, localArrayList);
          }
          if (this.KbO.Kfn.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.KbO.Kfn);
            this.KbO.Kfn.clear();
            this.KbO.Kfn.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.KbO.toByteArray();
            u.f(KbM, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            Log.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + KbM, new Object[0]);
            u.deleteFile(KbM);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
        fNd();
        continue;
        paramString = (t)paramq;
        int i = paramString.fWh;
        if (paramString.jis)
        {
          long l = paramString.JIs;
          Log.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            aj.fOH().QK(l);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(new s(l, 1), 0);
          }
          aj.fOI().agJ(i);
          if (l != 0L)
          {
            aj.fON().Rb(l);
            com.tencent.mm.plugin.sns.storage.g.Ra(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          ba(paramString.fWh, false);
        }
        for (;;)
        {
          this.KbN = null;
          break;
          ba(paramString.fWh, true);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void aY(int paramInt, boolean paramBoolean);
    
    public abstract void fPf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bd
 * JD-Core Version:    0.7.0.1
 */