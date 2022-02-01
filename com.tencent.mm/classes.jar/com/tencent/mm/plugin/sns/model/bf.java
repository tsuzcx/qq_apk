package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.yw;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.sns.k.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class bf
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.sns.c.o
{
  private static int QqC;
  private static final String Qzc;
  private t Qzd;
  private LinkedList<Pair<String, String>> Qze;
  public m Qzf;
  public af.a Qzg;
  private Set<a> listeners;
  private String ltf;
  
  static
  {
    AppMethodBeat.i(96034);
    QqC = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    Qzc = com.tencent.mm.kernel.h.baE().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public bf()
  {
    AppMethodBeat.i(96011);
    this.ltf = "";
    this.Qzd = null;
    this.listeners = new HashSet();
    this.Qzf = new m();
    this.Qzg = new af.a()
    {
      public final void DD(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          bf.this.hej();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = y.bi(Qzc, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.Qzf = ((m)new m().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        y.deleteFile(Qzc);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean K(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96019);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject2 = paramSnsInfo.getTimeLine();
    if (((TimeLineObject)localObject2).ContentObj.Zpq == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject2).ContentObj.Zpq == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject1;
    if (((TimeLineObject)localObject2).ContentObj.Zpq == 26)
    {
      localObject1 = new ht();
      ((ht)localObject1).hIR.type = 30;
      ((ht)localObject1).hIR.hIY = 5;
      ((ht)localObject1).hIR.desc = ((TimeLineObject)localObject2).ContentObj.Zpt;
      ((ht)localObject1).hIR.hIX = String.valueOf(paramSnsInfo.localid);
      ((ht)localObject1).publish();
      if (((ht)localObject1).hIS.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject2 == null) || (((TimeLineObject)localObject2).ContentObj.Zpr == null))
    {
      a(paramSnsInfo, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject2).ContentObj.Zpr.size() == 0)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = (dna)new dna().parseFrom(paramSnsInfo.getPostBuf());
        if (((TimeLineObject)localObject2).ContentObj.Zpq != 1) {
          break label560;
        }
        if (((dna)localObject1).aaTI.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject2).ContentObj.Zpq == 21) {
            bool = false;
          }
          if (((TimeLineObject)localObject2).ContentObj.Zpq != 15) {
            break label428;
          }
          localObject1 = ((dna)localObject1).aaTI.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label421;
          }
          localObject2 = (djp)((Iterator)localObject1).next();
          localObject3 = akK(((djp)localObject2).aaPC);
          if (localObject3 != bf.b.Qzs) {
            break label406;
          }
          a(paramSnsInfo, ((djp)localObject2).aaPC, 2, "upload has set it fail");
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
      label406:
      if (localObject3 == bf.b.Qzu)
      {
        AppMethodBeat.o(96019);
        return false;
        label421:
        AppMethodBeat.o(96019);
        return true;
        label428:
        localObject3 = localException.aaTI.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          djp localdjp = (djp)((Iterator)localObject3).next();
          if (al.hgq().vk(localdjp.aaPC).type == 6) {}
          for (bf.b localb = akK(localdjp.aaPC); localb == bf.b.Qzs; localb = o(localdjp.aaPC, bool, ((TimeLineObject)localObject2).ContentObj.Zpq))
          {
            a(paramSnsInfo, localdjp.aaPC, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == bf.b.Qzu)
          {
            AppMethodBeat.o(96019);
            return false;
          }
        }
        AppMethodBeat.o(96019);
        return true;
        label560:
        bool = true;
      }
    }
  }
  
  private boolean M(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96024);
    final dna localdna;
    try
    {
      localdna = (dna)new dna().parseFrom(paramSnsInfo.getPostBuf());
      localdna.nrQ += 1;
      paramSnsInfo.setPostBuf(localdna.toByteArray());
      al.hgB().f(paramSnsInfo.localid, paramSnsInfo);
      if (paramSnsInfo.isTimeLimit(localdna.nrQ, localdna.aaTL))
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
    z localz;
    Object localObject3;
    String str;
    Object localObject5;
    int k;
    Object localObject4;
    Object localObject1;
    if (K(paramSnsInfo))
    {
      localTimeLineObject = paramSnsInfo.getTimeLine();
      localObject2 = a(paramSnsInfo, localdna);
      i = 0;
      if (i < localdna.aaTI.size())
      {
        j = ((djp)localdna.aaTI.get(i)).aaPC;
        localz = al.hgq().vk(j);
        if (localz == null)
        {
          a(paramSnsInfo, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (dnc)new dnc().parseFrom(localz.QZv);
          if ((((dnc)localObject3).aaUe == null) || (((dnc)localObject3).aaUg.size() <= 0))
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
        str = ((dnc)localObject3).aaUe.Url;
        localObject5 = ((dmu)((dnc)localObject3).aaUg.get(0)).Url;
        j = ((dnc)localObject3).aaUe.vhJ;
        k = ((dmu)((dnc)localObject3).aaUg.get(0)).vhJ;
        localObject4 = ((dnc)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.ContentObj.Zpr.size()) {
          localObject1 = ((dmz)localTimeLineObject.ContentObj.Zpr.get(i)).aaTn;
        }
        if ((localTimeLineObject.ContentObj.Zpq == 4) || (localTimeLineObject.ContentObj.Zpq == 42) || (localTimeLineObject.ContentObj.Zpq == 5))
        {
          if (i >= localTimeLineObject.ContentObj.Zpr.size()) {
            break label1162;
          }
          localObject1 = (dmz)localTimeLineObject.ContentObj.Zpr.get(i);
          ((dmz)localObject1).aaTl = ((String)localObject5);
          ((dmz)localObject1).aaTm = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.Zpq == 1)) {
        ((dmz)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).ContentObj.Zpq == 15))
      {
        ((dmz)localObject1).md5 = ((dnc)localObject3).md5;
        ((dmz)localObject1).aaTE = ((dnc)localObject3).aaTE;
      }
      if (i < localTimeLineObject.ContentObj.Zpr.size())
      {
        localObject3 = (dmz)localTimeLineObject.ContentObj.Zpr.get(i);
        ((dmz)localObject1).hAP = ((dmz)localObject3).hAP;
        ((dmz)localObject1).IGG = ((dmz)localObject3).IGG;
        ((dmz)localObject1).subType = ((dmz)localObject3).subType;
        ((dmz)localObject1).RcB = ((dmz)localObject3).RcB;
        ((dmz)localObject1).aaTF = ((dmz)localObject3).aaTF;
      }
      if (localObject1 == null)
      {
        a(paramSnsInfo, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = com.tencent.mm.modelsns.o.a(localz.strId, localz.type, str, (String)localObject5, j, k, ((dnc)localObject3).Privated, "", (dnb)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).ContentObj.Zpr.add(localObject1);
        i += 1;
        break;
        label821:
        if (!al.hgA().akB(paramSnsInfo.localid))
        {
          Log.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localdna.aaTJ.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((ffw)((Iterator)localObject3).next()).UserName);
        }
        localObject3 = com.tencent.mm.plugin.sns.k.o.e((TimeLineObject)localObject2);
        Log.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).contentDescScene + " contentDescShowType: " + ((TimeLineObject)localObject2).contentDescShowType);
        if (paramSnsInfo.field_pravited == 1) {
          Log.i("MicroMsg.UploadManager", "content private xml is null ? " + Util.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramSnsInfo, 5, "content is error");
          al.hgA().akC(paramSnsInfo.localid);
          AppMethodBeat.o(96024);
          return false;
          Log.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localdna.aaTR == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramSnsInfo.localid;
          localObject4 = localdna.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).Location.aaPP;
          localObject2 = ((TimeLineObject)localObject2).ContentObj.hAP;
          al.fAG().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (al.isInValid())
              {
                Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localdna.aaTZ != null)
              {
                i = localdna.aaTZ.YHq;
                str = localdna.aaTZ.IcK;
              }
              bf.a(bf.this, new t(this.val$content, localdna.Privated, localdna.aaTH, this.Qzj, localTimeLineObject, i, localdna.nUv, localdna.aaTM, localdna.aaTN, localdna.aaTO, localdna, bool, this.Qzm, localdna.aaTS, this.Qzn, this.eSG, i, str));
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(bf.d(bf.this), 0);
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
  
  private static TimeLineObject a(SnsInfo paramSnsInfo, dna paramdna)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramSnsInfo.getTimeLine();
    Object localObject = localTimeLineObject2.Location;
    String str1 = localTimeLineObject2.ContentDesc;
    String str2 = localTimeLineObject2.sourceUserName;
    String str3 = localTimeLineObject2.sourceNickName;
    String str4 = localTimeLineObject2.ContentObj.IGG;
    String str5 = localTimeLineObject2.ContentObj.hAP;
    String str6 = localTimeLineObject2.ContentObj.Url;
    String str7 = localTimeLineObject2.ContentObj.Zpt;
    fr localfr = localTimeLineObject2.AppInfo;
    gfh localgfh = localTimeLineObject2.weappInfo;
    dif localdif = localTimeLineObject2.liteappInfo;
    int i = localTimeLineObject2.ContentObj.Zpq;
    int j = localTimeLineObject2.ContentObj.Zps;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.o.bMJ();
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
    localTimeLineObject1.ContentObj.IGG = str4;
    localTimeLineObject1.ContentObj.hAP = str5;
    localTimeLineObject1.ContentObj.Zpq = i;
    localTimeLineObject1.ContentObj.Zps = j;
    localTimeLineObject1.ContentObj.Url = str6;
    localTimeLineObject1.ContentObj.Zpt = str7;
    localTimeLineObject1.ContentObj.hKU = localTimeLineObject2.ContentObj.hKU;
    localTimeLineObject1.ContentObj.oPb = localTimeLineObject2.ContentObj.oPb;
    localTimeLineObject1.ContentObj.Zpv = localTimeLineObject2.ContentObj.Zpv;
    localTimeLineObject1.ContentObj.Zpz = localTimeLineObject2.ContentObj.Zpz;
    localTimeLineObject1.ContentObj.Zpx = localTimeLineObject2.ContentObj.Zpx;
    localTimeLineObject1.ContentObj.Zpw = localTimeLineObject2.ContentObj.Zpw;
    localTimeLineObject1.ContentObj.DHa = localTimeLineObject2.ContentObj.DHa;
    localTimeLineObject1.ContentObj.Zpy = localTimeLineObject2.ContentObj.Zpy;
    localTimeLineObject1.ContentObj.ZpA = localTimeLineObject2.ContentObj.ZpA;
    localTimeLineObject1.ContentObj.akiL = localTimeLineObject2.ContentObj.akiL;
    localTimeLineObject1.Location = ((djv)localObject);
    localTimeLineObject1.streamvideo = localTimeLineObject2.streamvideo;
    localTimeLineObject1.statExtStr = localTimeLineObject2.statExtStr;
    localTimeLineObject1.videoTemplate = localTimeLineObject2.videoTemplate;
    if (localTimeLineObject2.actionInfo != null) {
      localTimeLineObject1.actionInfo = localTimeLineObject2.actionInfo;
    }
    if (localfr != null) {
      localTimeLineObject1.AppInfo = localfr;
    }
    if (localgfh != null) {
      localTimeLineObject1.weappInfo = localgfh;
    }
    if (localdif != null) {
      localTimeLineObject1.liteappInfo = localdif;
    }
    paramSnsInfo = localTimeLineObject2.ContentObj.Zpr.iterator();
    while (paramSnsInfo.hasNext())
    {
      localObject = (dmz)paramSnsInfo.next();
      if (((dmz)localObject).aaTq == 1) {
        localTimeLineObject1.ContentObj.Zpr.add(localObject);
      }
    }
    if (localTimeLineObject2.webSearchInfo != null) {
      localTimeLineObject1.webSearchInfo = localTimeLineObject2.webSearchInfo;
    }
    paramSnsInfo = ad.bCb().M(paramdna.sessionId, true);
    if (paramSnsInfo.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramSnsInfo.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.ContentObj.Zpu = new dll();
        localTimeLineObject1.ContentObj.Zpu.nUA = i;
        localTimeLineObject1.ContentObj.Zpu.nQp = paramSnsInfo.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if ((i == 5) || (i == 16))
        {
          localTimeLineObject1.ContentObj.Zpu.vid = paramSnsInfo.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.ContentObj.Zpu.nQn = paramSnsInfo.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.ContentObj.Zpu.duration = paramSnsInfo.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.ContentObj.Zpu.desc = paramSnsInfo.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.ContentObj.Zpu.coverUrl = paramSnsInfo.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.ContentObj.Zpu.videoWidth = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.ContentObj.Zpu.videoHeight = paramSnsInfo.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.ContentObj.Zpu.nQq = paramSnsInfo.getInt("_DATA_CENTER_FUNC_FLAG", 0);
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
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = al.hgq().vk(paramInt1);
      try
      {
        i = ((dnc)new dnc().parseFrom(paramString.QZv)).aaTP;
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
        paramString.aaTP = i;
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
    al.hgB().f(paramSnsInfo.localid, paramSnsInfo);
    Log.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramSnsInfo.localid);
    paramString = new yw();
    paramString.icd.ice = paramSnsInfo.localid;
    paramString.publish();
    switch (paramInt2)
    {
    }
    for (;;)
    {
      bH(paramSnsInfo.localid, false);
      AppMethodBeat.o(96014);
      return;
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramSnsInfo.getPostInfo();
      if (paramString == null) {
        break label385;
      }
      paramInt1 = paramString.aaTP;
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
  
  private static void a(dna paramdna)
  {
    AppMethodBeat.i(96027);
    if (paramdna == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    paramdna = paramdna.aaTI.iterator();
    while (paramdna.hasNext())
    {
      djp localdjp = (djp)paramdna.next();
      al.hgA().akE(localdjp.aaPC);
    }
    AppMethodBeat.o(96027);
  }
  
  private bf.b akK(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = bf.b.Qzs;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = al.hgq().vk(paramInt);
    dnc localdnc;
    try
    {
      localdnc = (dnc)new dnc().parseFrom(((z)localObject).QZv);
      Log.i("MicroMsg.UploadManager", "state " + localdnc.aaPu + " doUploadSight, serverErr:" + localdnc.aaTP);
      if (localdnc.aaPu == 1)
      {
        localObject = bf.b.Qzs;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = bf.b.Qzs;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (y.bEl(localdnc.videoPath) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not fileexist  " + localdnc.videoPath);
      localb = bf.b.Qzs;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (y.bEl(localdnc.aaUi) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localdnc.aaUi);
      localb = bf.b.Qzs;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localdnc.aaPu == 0)
    {
      localb = bf.b.Qzt;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (al.hgA().akD(paramInt))
    {
      al.hgq().a(paramInt, localb);
      new af(paramInt, localb, localdnc.videoPath, localdnc.aaUi, this.Qzg).aYq(localdnc.appid);
    }
    bf.b localb = bf.b.Qzu;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private void bH(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    al.fAG().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (al.isInValid())
        {
          Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = bf.c(bf.this).iterator();
        while (localIterator.hasNext())
        {
          bf.a locala = (bf.a)localIterator.next();
          if (locala != null) {
            locala.bF(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static bg c(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
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
    bg localbg;
    for (;;)
    {
      localbg = new bg(i);
      localbg.aYS(Util.nullAs(paramString2, "")).aYT(Util.nullAs(paramString3, ""));
      localbg.akQ(5);
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
      localbg.aYM(paramString1);
    }
    localbg.aYR(Util.nullAs(paramWXMediaMessage.title, "")).aYP(Util.nullAs(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      Log.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbg.aYP("");
      localbg.aYM(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbg;
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
        localbg.aYR("").aYP("");
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
        if (localbg.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!Util.isNullOrNil(paramWXMediaMessage.imageData))
      {
        if (!localbg.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!Util.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbg.mo(paramWXMediaMessage.imagePath, ""))
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
          localbg.b(paramWXMediaMessage.thumbData, Util.nullAs(paramWXMediaMessage.description, ""), Util.nullAs(paramWXMediaMessage.title, ""));
        }
        localbg.aYP(paramString1.webpageUrl).aYQ(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbg.QzA.ContentObj.Url = paramWXMediaMessage;
        localbg.aYO(paramString1.canvasPageXml);
        continue;
        Log.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbg.aYR("").aYP("");
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
          if (localbg.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, Util.nullAs(paramWXMediaMessage.title, ""), Util.nullAs(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((Util.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbg.aYR(paramWXMediaMessage.filePath);
        localbg.aYP(paramWXMediaMessage.filePath);
      }
    }
    Log.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  public static String hhD()
  {
    AppMethodBeat.i(309386);
    String str = MultiProcessMMKV.getMMKV("SnsMMKV").getString("SnsMMKVUploadUrl", "");
    AppMethodBeat.o(309386);
    return str;
  }
  
  private boolean hhE()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = al.hgB();
    localObject2 = "select *,rowid from SnsInfo  where " + w.QZb + " order by SnsInfo.rowid asc ";
    localObject1 = ((w)localObject1).QYR.rawQuery((String)localObject2, null);
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
        dna localdna = (dna)new dna().parseFrom(((SnsInfo)localObject2).getPostBuf());
        if (((SnsInfo)localObject2).isTimeLimit(localdna.nrQ, localdna.aaTL))
        {
          a(localdna);
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
  
  public static void ml(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309392);
    y.deleteFile(paramString2);
    y.O(paramString1, paramString2, false);
    AppMethodBeat.o(309392);
  }
  
  private bf.b o(final int paramInt1, final boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(309422);
    if (paramInt1 == -1)
    {
      Log.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      localObject1 = bf.b.Qzs;
      AppMethodBeat.o(309422);
      return localObject1;
    }
    Object localObject1 = al.hgq().vk(paramInt1);
    dnc localdnc;
    try
    {
      localdnc = (dnc)new dnc().parseFrom(((z)localObject1).QZv);
      Log.i("MicroMsg.UploadManager", "state " + localdnc.aaPu + " pic isMuti: " + paramBoolean);
      if (localdnc.aaPu == 1)
      {
        localObject1 = bf.b.Qzs;
        AppMethodBeat.o(309422);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.UploadManager", "parse uploadInfo error");
      localObject2 = bf.b.Qzs;
      AppMethodBeat.o(309422);
      return localObject2;
    }
    String str = com.tencent.mm.plugin.sns.data.t.aXq(((z)localObject2).Oxm);
    str = as.mg(al.getAccSnsPath(), ((z)localObject2).Oxm) + str;
    if (y.bEl(str) == 0L)
    {
      Log.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      localObject2 = bf.b.Qzs;
      AppMethodBeat.o(309422);
      return localObject2;
    }
    if (localdnc.aaPu == 0)
    {
      localObject2 = bf.b.Qzt;
      AppMethodBeat.o(309422);
      return localObject2;
    }
    if (al.hgA().akD(paramInt1))
    {
      al.hgq().a(paramInt1, (z)localObject2);
      localObject2 = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + " " + System.currentTimeMillis()).getBytes());
      al.fAG().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (al.isInValid())
          {
            Log.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          aa localaa = new aa(paramInt1, this.Qzp, paramBoolean, paramInt2);
          al.hgA().lq(paramInt1, localaa.hashCode());
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(localaa, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    Object localObject2 = bf.b.Qzu;
    AppMethodBeat.o(309422);
    return localObject2;
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
  
  public final void C(List<com.tencent.mm.plugin.sns.k.n> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.Qzf.QCV = paramBoolean;
    this.Qzf.QCT.clear();
    this.Qzf.QCT.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.k.n localn;
    if (Util.isNullOrNil(this.Qzf.QCU))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localn = (com.tencent.mm.plugin.sns.k.n)paramList.next();
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
        localn = (com.tencent.mm.plugin.sns.k.n)paramList.next();
        if (localn.type == 2)
        {
          Iterator localIterator = this.Qzf.QCU.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!Util.isEqual(((com.tencent.mm.plugin.sns.k.n)localIterator.next()).name, localn.name));
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
            this.Qzf.QCU.addAll(0, localArrayList);
          }
          if (this.Qzf.QCU.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.Qzf.QCU);
            this.Qzf.QCU.clear();
            this.Qzf.QCU.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.Qzf.toByteArray();
            y.f(Qzc, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            Log.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + Qzc, new Object[0]);
            y.deleteFile(Qzc);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final void L(SnsInfo paramSnsInfo)
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
      Object localObject1 = (dna)new dna().parseFrom(paramSnsInfo.getPostBuf());
      if ((localObject1 != null) && (((dna)localObject1).aaTI != null))
      {
        localObject1 = ((dna)localObject1).aaTI.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          djp localdjp = (djp)((Iterator)localObject1).next();
          int i = al.hgA().akG(localdjp.aaPC);
          al.hgA().akF(localdjp.aaPC);
          Log.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramSnsInfo.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.cancel(i);
            al.hgA().akE(localdjp.aaPC);
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
      if ((al.hgA().akA(paramSnsInfo.localid)) && (this.Qzd != null))
      {
        Log.i("MicroMsg.UploadManager", "cancel post");
        this.Qzd.lKI = true;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(this.Qzd);
        al.hgA().akC(paramSnsInfo.localid);
      }
      Object localObject2 = al.hgB().alB(paramSnsInfo.localid);
      if ((localObject2 != null) && (((SnsInfo)localObject2).field_snsId != 0L))
      {
        al.hgA().uQ(((SnsInfo)localObject2).field_snsId);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new s(((SnsInfo)localObject2).field_snsId, 1), 0);
      }
      al.hgB().alC(paramSnsInfo.localid);
      if (paramSnsInfo.getTypeFlag() == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.hfm().hfo();
      }
      Log.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramSnsInfo.getLocalid());
      localObject2 = new yw();
      ((yw)localObject2).icd.ice = paramSnsInfo.localid;
      ((yw)localObject2).publish();
      AppMethodBeat.o(96020);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(309446);
    this.listeners.add(parama);
    int i = QqC + 1;
    QqC = i;
    if (i > 1)
    {
      AppMethodBeat.o(309446);
      return;
    }
    AppMethodBeat.o(309446);
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
    paramString1.aYN(paramWXMediaMessage.mediaTagName);
    paramString1.aY(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramString1.akL(1);
    }
    Log.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.FW())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(309449);
    this.listeners.remove(parama);
    int i = QqC - 1;
    QqC = i;
    if (i > 0)
    {
      AppMethodBeat.o(309449);
      return;
    }
    AppMethodBeat.o(309449);
  }
  
  public final void bB(ArrayList<MediaSingleInfo> paramArrayList)
  {
    AppMethodBeat.i(309452);
    Object localObject1 = "";
    Object localObject2 = paramArrayList.iterator();
    String str = "";
    paramArrayList = (ArrayList<MediaSingleInfo>)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (MediaSingleInfo)((Iterator)localObject2).next();
      if (((MediaSingleInfo)localObject1).KON == com.tencent.mm.plugin.mediabasic.data.a.KOB) {
        str = ((MediaSingleInfo)localObject1).path;
      }
      if (((MediaSingleInfo)localObject1).KON != com.tencent.mm.plugin.mediabasic.data.a.KOC) {
        break label222;
      }
      paramArrayList = ((MediaSingleInfo)localObject1).path;
    }
    label222:
    for (;;)
    {
      break;
      Log.i("MicroMsg.UploadManager", "coverPath:%s thumbPath:%s", new Object[] { str, paramArrayList });
      if ((hgg() != null) && (!hgg().equals("")))
      {
        localObject1 = as.mg(al.getAccSnsPath(), hgg());
        y.bDX((String)localObject1);
        y.deleteFile((String)localObject1 + hgg() + "bg_");
        localObject1 = as.Ew(hgg());
        localObject2 = as.aYD(hgg());
        ml(str, (String)localObject2);
        ml(paramArrayList, (String)localObject1);
        al.hgG().bb(hgg(), (String)localObject1, (String)localObject2);
      }
      hhF();
      localObject1 = com.tencent.mm.plugin.sns.model.c.a.QAM;
      com.tencent.mm.plugin.sns.model.c.a.mq(str, paramArrayList);
      AppMethodBeat.o(309452);
      return;
    }
  }
  
  public final void hej()
  {
    AppMethodBeat.i(96021);
    al.fAG().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        bf.a(bf.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String hgg()
  {
    AppMethodBeat.i(96013);
    if ((this.ltf == null) || (this.ltf.equals("")))
    {
      com.tencent.mm.kernel.h.baF();
      this.ltf = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
    }
    String str = this.ltf;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final LinkedList<Pair<String, String>> hhC()
  {
    AppMethodBeat.i(309437);
    Object localObject;
    if (this.Qze == null)
    {
      localObject = MultiProcessMMKV.getMMKV("SnsMMKV").getString("SnsMMKVUploadUrl", "");
      if (!Util.isNullOrNil((String)localObject)) {
        break label59;
      }
      this.Qze = new LinkedList();
    }
    for (;;)
    {
      localObject = this.Qze;
      AppMethodBeat.o(309437);
      return localObject;
      label59:
      this.Qze = Util.stringsToLinkedListPair(((String)localObject).split(" "));
      if (this.Qze == null) {
        this.Qze = new LinkedList();
      }
    }
  }
  
  public final void hhF()
  {
    AppMethodBeat.i(309465);
    q localq = al.hgG().aZM(hgg());
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.a(localq);
      }
    }
    AppMethodBeat.o(309465);
  }
  
  public final boolean lT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    Log.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    y.O(paramString1, str, false);
    paramString1 = new bg(1);
    paramString1.aYM(paramString2);
    paramString1.akQ(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.s(str, 2));
    paramString1.kC(paramString2);
    if (paramString1.FW() > 0)
    {
      AppMethodBeat.o(96016);
      return true;
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(96030);
    Log.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType() + " @" + hashCode());
    switch (paramp.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        hej();
        if ((paramp instanceof aa))
        {
          int i = ((aa)paramp).icg;
          paramString = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
          com.tencent.mm.plugin.sns.cover.c.b.lm(i, paramInt2 + 10000);
          continue;
          paramString = (t)paramp;
          i = paramString.icg;
          paramp = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
          com.tencent.mm.plugin.sns.cover.c.b.lm(i, paramInt2);
          if (paramString.lKI)
          {
            long l = paramString.PZu;
            Log.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
            if (l != 0L)
            {
              al.hgA().uQ(l);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new s(l, 1), 0);
            }
            al.hgB().alC(i);
            if (l != 0L)
            {
              al.hgH().vh(l);
              com.tencent.mm.plugin.sns.storage.n.vg(l);
            }
          }
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            bH(paramString.icg, false);
          }
          for (;;)
          {
            this.Qzd = null;
            break;
            bH(paramString.icg, true);
          }
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
    
    public abstract void bF(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bf
 * JD-Core Version:    0.7.0.1
 */