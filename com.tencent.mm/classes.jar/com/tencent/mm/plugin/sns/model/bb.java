package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.l;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class bb
  implements f, com.tencent.mm.plugin.sns.b.m
{
  public static int zfC;
  private static final String znn;
  public Set<a> cAT;
  private String fFK;
  private r zno;
  public l znp;
  public ab.a znq;
  
  static
  {
    AppMethodBeat.i(96034);
    zfC = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    znn = com.tencent.mm.kernel.g.ajC().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public bb()
  {
    AppMethodBeat.i(96011);
    this.fFK = "";
    this.zno = null;
    this.cAT = new HashSet();
    this.znp = new l();
    this.znq = new ab.a()
    {
      public final void rl(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          bb.this.dSE();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aY(znn, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.znp = ((l)new l().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.i.deleteFile(znn);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean B(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96019);
    if (paramp == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramp.dYl();
    if (((TimeLineObject)localObject1).HAT.GaP == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).HAT.GaP == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).HAT.GaP == 26)
    {
      localObject2 = new gw();
      ((gw)localObject2).dsV.type = 30;
      ((gw)localObject2).dsV.dtc = 5;
      ((gw)localObject2).dsV.desc = ((TimeLineObject)localObject1).HAT.GaS;
      ((gw)localObject2).dsV.dtb = String.valueOf(paramp.zMC);
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((gw)localObject2).dsW.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).HAT.GaQ == null))
    {
      a(paramp, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).HAT.GaQ.size() == 0)
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
        localObject2 = (byo)new byo().parseFrom(paramp.field_postBuf);
        if (((TimeLineObject)localObject1).HAT.GaP != 1) {
          break label537;
        }
        if (((byo)localObject2).GTh.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).HAT.GaP != 21) {
            break label534;
          }
          bool = false;
          if (((TimeLineObject)localObject1).HAT.GaP != 15) {
            break label430;
          }
          localObject1 = ((byo)localObject2).GTh.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label423;
          }
          localObject2 = (bvk)((Iterator)localObject1).next();
          localObject3 = Qa(((bvk)localObject2).GPE);
          if (localObject3 != bb.b.znD) {
            break label408;
          }
          a(paramp, ((bvk)localObject2).GPE, 2, "upload has set it fail");
          AppMethodBeat.o(96019);
          return false;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dYK());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(96019);
        return false;
      }
      boolean bool = false;
      continue;
      label408:
      if (localObject3 == bb.b.znF)
      {
        AppMethodBeat.o(96019);
        return false;
        label423:
        AppMethodBeat.o(96019);
        return true;
        label430:
        localObject3 = ((byo)localObject2).GTh.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bvk localbvk = (bvk)((Iterator)localObject3).next();
          bb.b localb = a(localbvk.GPE, bool, (byo)localObject2, localException.HAT.GaP);
          if (localb == bb.b.znD)
          {
            a(paramp, localbvk.GPE, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == bb.b.znF)
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
  
  private boolean D(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96024);
    final byo localbyo;
    try
    {
      localbyo = (byo)new byo().parseFrom(paramp.field_postBuf);
      localbyo.hfV += 1;
      paramp.field_postBuf = localbyo.toByteArray();
      ag.dUe().b(paramp.zMC, paramp);
      if (com.tencent.mm.plugin.sns.storage.p.Ah(localbyo.GTk))
      {
        a(paramp, 6, "this item isTimeLimit");
        ad.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramp.dYK() + " is die ");
        AppMethodBeat.o(96024);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramp, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(96024);
      return false;
    }
    ad.i("MicroMsg.UploadManager", "try start post " + paramp.dYK());
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
    if (B(paramp))
    {
      localTimeLineObject = paramp.dYl();
      localObject2 = a(paramp, localbyo);
      i = 0;
      if (i < localbyo.GTh.size())
      {
        j = ((bvk)localbyo.GTh.get(i)).GPE;
        localt = ag.dTT().Aj(j);
        if (localt == null)
        {
          a(paramp, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (byq)new byq().parseFrom(localt.zNr);
          if ((((byq)localObject3).GTC == null) || (((byq)localObject3).GTE.size() <= 0))
          {
            ad.e("MicroMsg.UploadManager", "item with not url" + paramp.field_type);
            if (paramp.field_type == 3) {
              break label802;
            }
            a(paramp, 4, "buf url is null");
            AppMethodBeat.o(96024);
            return false;
          }
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramp, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(96024);
          return false;
        }
        str = ((byq)localObject3).GTC.Url;
        localObject5 = ((byi)((byq)localObject3).GTE.get(0)).Url;
        j = ((byq)localObject3).GTC.nEf;
        k = ((byi)((byq)localObject3).GTE.get(0)).nEf;
        localObject4 = ((byq)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.HAT.GaQ.size()) {
          localObject1 = ((byn)localTimeLineObject.HAT.GaQ.get(i)).GSL;
        }
        if ((localTimeLineObject.HAT.GaP == 4) || (localTimeLineObject.HAT.GaP == 5))
        {
          if (i >= localTimeLineObject.HAT.GaQ.size()) {
            break label1143;
          }
          localObject1 = (byn)localTimeLineObject.HAT.GaQ.get(i);
          ((byn)localObject1).GSI = ((String)localObject5);
          ((byn)localObject1).GSJ = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).HAT.GaP == 1)) {
        ((byn)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).HAT.GaP == 15))
      {
        ((byn)localObject1).md5 = ((byq)localObject3).md5;
        ((byn)localObject1).GTd = ((byq)localObject3).GTd;
      }
      if (i < localTimeLineObject.HAT.GaQ.size())
      {
        localObject3 = (byn)localTimeLineObject.HAT.GaQ.get(i);
        ((byn)localObject1).Title = ((byn)localObject3).Title;
        ((byn)localObject1).Desc = ((byn)localObject3).Desc;
        ((byn)localObject1).subType = ((byn)localObject3).subType;
        ((byn)localObject1).zQh = ((byn)localObject3).zQh;
        ((byn)localObject1).GTe = ((byn)localObject3).GTe;
      }
      if (localObject1 == null)
      {
        a(paramp, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = h.a(localt.zNq, localt.type, str, (String)localObject5, j, k, ((byq)localObject3).GSK, "", (byp)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).HAT.GaQ.add(localObject1);
        i += 1;
        break;
        label802:
        if (!ag.dUd().PQ(paramp.zMC))
        {
          ad.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localbyo.GTi.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((dhj)((Iterator)localObject3).next()).nDo);
        }
        localObject3 = com.tencent.mm.plugin.sns.i.n.e((TimeLineObject)localObject2);
        ad.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).HAW + " contentDescShowType: " + ((TimeLineObject)localObject2).HAV);
        if (paramp.field_pravited == 1) {
          ad.i("MicroMsg.UploadManager", "content private xml is null ? " + bt.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramp, 5, "content is error");
          ag.dUd().PR(paramp.zMC);
          AppMethodBeat.o(96024);
          return false;
          ad.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localbyo.GTq == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramp.zMC;
          localObject4 = localbyo.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).HAR.GPR;
          localObject2 = ((TimeLineObject)localObject2).HAT.Title;
          ag.cVf().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (ag.dTN())
              {
                ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localbyo.GTy != null)
              {
                i = localbyo.GTy.Fwz;
                str = localbyo.GTy.ufi;
              }
              bb.a(bb.this, new r(this.ilu, localbyo.GSK, localbyo.GTg, this.znu, localTimeLineObject, i, localbyo.hCW, localbyo.GTl, localbyo.GTm, localbyo.GTn, localbyo, bool, this.znx, localbyo.GTr, this.zny, this.cYy, i, str));
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.a(bb.d(bb.this), 0);
              AppMethodBeat.o(96005);
            }
          });
          ad.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramp.dYK());
          AppMethodBeat.o(96024);
          return true;
        }
        label1143:
        localObject1 = null;
      }
    }
  }
  
  private static int PZ(int paramInt)
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
  
  private bb.b Qa(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      ad.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = bb.b.znD;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = ag.dTT().Aj(paramInt);
    byq localbyq;
    try
    {
      localbyq = (byq)new byq().parseFrom(((t)localObject).zNr);
      ad.i("MicroMsg.UploadManager", "state " + localbyq.GPx + " doUploadSight, serverErr:" + localbyq.GTo);
      if (localbyq.GPx == 1)
      {
        localObject = bb.b.znD;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = bb.b.znD;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aYo(localbyq.videoPath) == 0L)
    {
      ad.i("MicroMsg.UploadManager", "path not fileexist  " + localbyq.videoPath);
      localb = bb.b.znD;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aYo(localbyq.GTG) == 0L)
    {
      ad.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localbyq.GTG);
      localb = bb.b.znD;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localbyq.GPx == 0)
    {
      localb = bb.b.znE;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (ag.dUd().PS(paramInt))
    {
      ag.dTT().a(paramInt, localb);
      new ab(paramInt, localb, localbyq.videoPath, localbyq.GTG, this.znq).ayS(localbyq.duW);
    }
    bb.b localb = bb.b.znF;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private bb.b a(final int paramInt1, final boolean paramBoolean, final byo parambyo, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      ad.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      parambyo = bb.b.znD;
      AppMethodBeat.o(96026);
      return parambyo;
    }
    Object localObject = ag.dTT().Aj(paramInt1);
    byq localbyq;
    try
    {
      localbyq = (byq)new byq().parseFrom(((t)localObject).zNr);
      ad.i("MicroMsg.UploadManager", "state " + localbyq.GPx + " pic isMuti: " + paramBoolean);
      if (localbyq.GPx == 1)
      {
        parambyo = bb.b.znD;
        AppMethodBeat.o(96026);
        return parambyo;
      }
    }
    catch (Exception parambyo)
    {
      ad.e("MicroMsg.UploadManager", "parse uploadInfo error");
      parambyo = bb.b.znD;
      AppMethodBeat.o(96026);
      return parambyo;
    }
    String str = com.tencent.mm.plugin.sns.data.q.axV(((t)localObject).zNn);
    str = ao.jo(ag.getAccSnsPath(), ((t)localObject).zNn) + str;
    if (com.tencent.mm.vfs.i.aYo(str) == 0L)
    {
      ad.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      parambyo = bb.b.znD;
      AppMethodBeat.o(96026);
      return parambyo;
    }
    if (localbyq.GPx == 0)
    {
      parambyo = bb.b.znE;
      AppMethodBeat.o(96026);
      return parambyo;
    }
    if (ag.dUd().PS(paramInt1))
    {
      ag.dTT().a(paramInt1, (t)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((bt.HI() + " " + System.currentTimeMillis()).getBytes());
      ag.cVf().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (ag.dTN())
          {
            ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          y localy = new y(paramInt1, this.znA, paramBoolean, paramInt2);
          ag.dUd().hz(paramInt1, localy.hashCode());
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(localy, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    parambyo = bb.b.znF;
    AppMethodBeat.o(96026);
    return parambyo;
  }
  
  private static TimeLineObject a(com.tencent.mm.plugin.sns.storage.p paramp, byo parambyo)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramp.dYl();
    Object localObject = localTimeLineObject2.HAR;
    String str1 = localTimeLineObject2.HAQ;
    String str2 = localTimeLineObject2.jYs;
    String str3 = localTimeLineObject2.EUR;
    String str4 = localTimeLineObject2.HAT.Desc;
    String str5 = localTimeLineObject2.HAT.Title;
    String str6 = localTimeLineObject2.HAT.Url;
    String str7 = localTimeLineObject2.HAT.GaS;
    en localen = localTimeLineObject2.HAS;
    ece localece = localTimeLineObject2.HAZ;
    int i = localTimeLineObject2.HAT.GaP;
    int j = localTimeLineObject2.HAT.GaR;
    TimeLineObject localTimeLineObject1 = h.aLm();
    localTimeLineObject1.nDo = paramp.field_userName;
    localTimeLineObject1.GSK = paramp.field_pravited;
    localTimeLineObject1.HAQ = str1;
    localTimeLineObject1.jYs = bt.nullAsNil(str2);
    localTimeLineObject1.EUR = bt.nullAsNil(str3);
    localTimeLineObject1.HAV = localTimeLineObject2.HAV;
    localTimeLineObject1.HAW = localTimeLineObject2.HAW;
    localTimeLineObject1.hzT = localTimeLineObject2.hzT;
    localTimeLineObject1.HAX = localTimeLineObject2.HAX;
    localTimeLineObject1.zTv = localTimeLineObject2.zTv;
    localTimeLineObject1.HAT.Desc = str4;
    localTimeLineObject1.HAT.Title = str5;
    localTimeLineObject1.HAT.GaP = i;
    localTimeLineObject1.HAT.GaR = j;
    localTimeLineObject1.HAT.Url = str6;
    localTimeLineObject1.HAT.GaS = str7;
    localTimeLineObject1.HAT.GaU = localTimeLineObject2.HAT.GaU;
    localTimeLineObject1.HAT.GaV = localTimeLineObject2.HAT.GaV;
    localTimeLineObject1.HAT.GaW = localTimeLineObject2.HAT.GaW;
    localTimeLineObject1.HAR = ((bvq)localObject);
    localTimeLineObject1.HAY = localTimeLineObject2.HAY;
    localTimeLineObject1.zRz = localTimeLineObject2.zRz;
    if (localTimeLineObject2.znQ != null) {
      localTimeLineObject1.znQ = localTimeLineObject2.znQ;
    }
    if (localen != null) {
      localTimeLineObject1.HAS = localen;
    }
    if (localece != null) {
      localTimeLineObject1.HAZ = localece;
    }
    paramp = localTimeLineObject2.HAT.GaQ.iterator();
    while (paramp.hasNext())
    {
      localObject = (byn)paramp.next();
      if (((byn)localObject).GSO == 1) {
        localTimeLineObject1.HAT.GaQ.add(localObject);
      }
    }
    if (localTimeLineObject2.znS != null) {
      localTimeLineObject1.znS = localTimeLineObject2.znS;
    }
    paramp = com.tencent.mm.model.y.aBq().F(parambyo.sessionId, true);
    if (paramp.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramp.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.HAT.GaT = new bww();
        localTimeLineObject1.HAT.GaT.hCZ = i;
        localTimeLineObject1.HAT.GaT.hzk = paramp.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.HAT.GaT.hzm = paramp.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.HAT.GaT.hzi = paramp.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.HAT.GaT.duration = paramp.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.HAT.GaT.desc = paramp.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.HAT.GaT.coverUrl = paramp.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.HAT.GaT.videoWidth = paramp.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.HAT.GaT.videoHeight = paramp.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.HAT.GaT.hzl = paramp.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(96023);
    return localTimeLineObject1;
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96014);
    ad.i("MicroMsg.UploadManager", "localId " + paramp.dYK() + "processError " + paramInt2 + " errMsg: " + paramString);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = ag.dTT().Aj(paramInt1);
      try
      {
        i = ((byq)new byq().parseFrom(paramString.zNr)).GTo;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramp.dYD();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.GTo = i;
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
    ad.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramp.dYO();
    ag.dUe().b(paramp.zMC, paramp);
    ad.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramp.zMC);
    paramString = new uv();
    paramString.dIZ.dJa = paramp.zMC;
    com.tencent.mm.sdk.b.a.IbL.l(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      ay(paramp.zMC, false);
      AppMethodBeat.o(96014);
      return;
      ad.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramp.dYD();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.GTo;
      break;
      ad.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      ad.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      ad.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      ad.e("MicroMsg.UploadManager", "arg is error");
      continue;
      ad.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      ad.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(96015);
    a(paramp, 0, paramInt, paramString);
    AppMethodBeat.o(96015);
  }
  
  private static void a(byo parambyo)
  {
    AppMethodBeat.i(96027);
    if (parambyo == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    parambyo = parambyo.GTh.iterator();
    while (parambyo.hasNext())
    {
      bvk localbvk = (bvk)parambyo.next();
      ag.dUd().PT(localbvk.GPE);
    }
    AppMethodBeat.o(96027);
  }
  
  private void ay(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    ag.cVf().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (ag.dTN())
        {
          ad.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = bb.c(bb.this).iterator();
        while (localIterator.hasNext())
        {
          bb.a locala = (bb.a)localIterator.next();
          if (locala != null) {
            locala.az(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static bc b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96017);
    ad.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    ad.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    bc localbc;
    for (;;)
    {
      localbc = new bc(i);
      localbc.azp(bt.bI(paramString2, "")).azq(bt.bI(paramString3, ""));
      localbc.Qg(5);
      ad.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      ad.d("MicroMsg.UploadManager", "timeLineType is invalid");
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
      localbc.azj(paramString1);
    }
    localbc.azo(bt.bI(paramWXMediaMessage.title, "")).azm(bt.bI(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      ad.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbc.azm("");
      localbc.azj(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbc;
      paramString2 = (WXMusicObject)localObject;
      if (!bt.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramString3 = bt.bI(paramString1, "");
        if (bt.isNullOrNil(paramString2.musicDataUrl)) {
          break label469;
        }
      }
      label469:
      for (paramString1 = paramString2.musicDataUrl;; paramString1 = paramString2.musicUrl)
      {
        localObject = bt.bI(paramString1, "");
        localbc.azo("").azm("");
        i = PZ(3);
        if (i != -1) {
          break label477;
        }
        ad.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = paramString2.musicLowBandUrl;
        break;
      }
      label477:
      if (!bt.isNullOrNil(paramString2.musicLowBandDataUrl)) {}
      for (paramString1 = paramString2.musicLowBandDataUrl;; paramString1 = paramString2.musicLowBandUrl)
      {
        paramString1 = bt.bI(paramString1, "");
        if (localbc.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, bt.bI(paramWXMediaMessage.title, ""), bt.bI(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!bt.cC(paramWXMediaMessage.imageData))
      {
        if (!localbc.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!bt.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbc.jt(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else
      {
        ad.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!bt.cC(paramWXMediaMessage.thumbData)) {
          localbc.b(paramWXMediaMessage.thumbData, bt.bI(paramWXMediaMessage.description, ""), bt.bI(paramWXMediaMessage.title, ""));
        }
        localbc.azm(paramString1.webpageUrl).azn(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbc.znM.HAT.Url = paramWXMediaMessage;
        localbc.azl(paramString1.canvasPageXml);
        continue;
        ad.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbc.azo("").azm("");
        i = PZ(4);
        if (i == -1)
        {
          ad.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(96017);
          return null;
        }
        if (!bt.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = bt.bI(paramString1, "");
          if (localbc.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bt.bI(paramWXMediaMessage.title, ""), bt.bI(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((bt.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbc.azo(paramWXMediaMessage.filePath);
        localbc.azm(paramWXMediaMessage.filePath);
      }
    }
    ad.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean dVd()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = ag.dUe();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.zNa + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    ad.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
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
        byo localbyo = (byo)new byo().parseFrom(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_postBuf);
        if (com.tencent.mm.plugin.sns.storage.p.Ah(localbyo.GTk))
        {
          a(localbyo);
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 6, "snsinfo is tle");
          ad.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((com.tencent.mm.plugin.sns.storage.p)localObject2).dYK() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(96022);
    return true;
  }
  
  public final void C(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96020);
    if (paramp == null)
    {
      AppMethodBeat.o(96020);
      return;
    }
    ad.i("MicroMsg.UploadManager", "cancel snsinfo " + paramp.dYK());
    try
    {
      Object localObject1 = (byo)new byo().parseFrom(paramp.field_postBuf);
      if ((localObject1 != null) && (((byo)localObject1).GTh != null))
      {
        localObject1 = ((byo)localObject1).GTh.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          bvk localbvk = (bvk)((Iterator)localObject1).next();
          int i = ag.dUd().PV(localbvk.GPE);
          ag.dUd().PU(localbvk.GPE);
          ad.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramp.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.cancel(i);
            ag.dUd().PT(localbvk.GPE);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dYK());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((ag.dUd().PP(paramp.zMC)) && (this.zno != null))
      {
        ad.i("MicroMsg.UploadManager", "cancel post");
        this.zno.fRb = true;
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(this.zno);
        ag.dUd().PR(paramp.zMC);
      }
      Object localObject2 = ag.dUe().QP(paramp.zMC);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId != 0L))
      {
        ag.dUd().zN(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(new q(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId, 1), 0);
      }
      ag.dUe().QQ(paramp.zMC);
      if (paramp.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.dTc().dTe();
      }
      ad.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramp.dYK());
      localObject2 = new uv();
      ((uv)localObject2).dIZ.dJa = paramp.zMC;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      AppMethodBeat.o(96020);
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
    paramString1.azk(paramWXMediaMessage.mediaTagName);
    paramString1.aD(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.c.a.zbZ) {
      paramString1.Qb(1);
    }
    ad.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void dSE()
  {
    AppMethodBeat.i(96021);
    ag.cVf().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        bb.a(bb.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String dTJ()
  {
    AppMethodBeat.i(96013);
    if ((this.fFK == null) || (this.fFK.equals("")))
    {
      com.tencent.mm.kernel.g.ajD();
      this.fFK = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null));
    }
    String str = this.fFK;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void dVe()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.cAT.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dVf();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final void i(List<com.tencent.mm.plugin.sns.i.m> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.znp.zqP = paramBoolean;
    this.znp.zqN.clear();
    this.znp.zqN.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.i.m localm;
    if (bt.hj(this.znp.zqO))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localm = (com.tencent.mm.plugin.sns.i.m)paramList.next();
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
        localm = (com.tencent.mm.plugin.sns.i.m)paramList.next();
        if (localm.type == 2)
        {
          Iterator localIterator = this.znp.zqO.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!bt.lQ(((com.tencent.mm.plugin.sns.i.m)localIterator.next()).name, localm.name));
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
          if (!bt.hj(localArrayList)) {
            this.znp.zqO.addAll(0, localArrayList);
          }
          if (this.znp.zqO.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.znp.zqO);
            this.znp.zqO.clear();
            this.znp.zqO.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.znp.toByteArray();
            com.tencent.mm.vfs.i.f(znn, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            ad.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + znn, new Object[0]);
            com.tencent.mm.vfs.i.deleteFile(znn);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final boolean jd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    ad.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = ag.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    com.tencent.mm.vfs.i.mz(paramString1, str);
    paramString1 = new bc(1);
    paramString1.azj(paramString2);
    paramString1.Qg(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.p(str, 2));
    paramString1.fM(paramString2);
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
    ad.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    switch (paramn.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        dSE();
        continue;
        paramString = (r)paramn;
        int i = paramString.dJd;
        if (paramString.fRb)
        {
          long l = paramString.zaX;
          ad.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            ag.dUd().zN(l);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new q(l, 1), 0);
          }
          ag.dUe().QQ(i);
          if (l != 0L)
          {
            ag.dUj().Ad(l);
            com.tencent.mm.plugin.sns.storage.i.Ac(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          ay(paramString.dJd, false);
        }
        for (;;)
        {
          this.zno = null;
          break;
          ay(paramString.dJd, true);
          al.report(paramString.zaX);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void az(int paramInt, boolean paramBoolean);
    
    public abstract void dVf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bb
 * JD-Core Version:    0.7.0.1
 */