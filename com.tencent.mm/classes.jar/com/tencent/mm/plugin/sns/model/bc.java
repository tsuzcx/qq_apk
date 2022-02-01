package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.model.z.b;
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
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class bc
  implements f, com.tencent.mm.plugin.sns.b.m
{
  private static final String zEC;
  public static int zws;
  public Set<a> cBA;
  private String fHO;
  private s zED;
  public l zEE;
  public ac.a zEF;
  
  static
  {
    AppMethodBeat.i(96034);
    zws = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    zEC = com.tencent.mm.kernel.g.ajR().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public bc()
  {
    AppMethodBeat.i(96011);
    this.fHO = "";
    this.zED = null;
    this.cBA = new HashSet();
    this.zEE = new l();
    this.zEF = new ac.a()
    {
      public final void rs(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          bc.this.dWc();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = o.bb(zEC, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.zEE = ((l)new l().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        o.deleteFile(zEC);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean B(p paramp)
  {
    AppMethodBeat.i(96019);
    if (paramp == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramp.ebP();
    if (((TimeLineObject)localObject1).HUG.Gtw == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).HUG.Gtw == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).HUG.Gtw == 26)
    {
      localObject2 = new gx();
      ((gx)localObject2).dub.type = 30;
      ((gx)localObject2).dub.dui = 5;
      ((gx)localObject2).dub.desc = ((TimeLineObject)localObject1).HUG.Gtz;
      ((gx)localObject2).dub.duh = String.valueOf(paramp.AdJ);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((gx)localObject2).duc.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).HUG.Gtx == null))
    {
      a(paramp, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).HUG.Gtx.size() == 0)
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
        localObject2 = (bzi)new bzi().parseFrom(paramp.field_postBuf);
        if (((TimeLineObject)localObject1).HUG.Gtw != 1) {
          break label537;
        }
        if (((bzi)localObject2).HmI.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).HUG.Gtw != 21) {
            break label534;
          }
          bool = false;
          if (((TimeLineObject)localObject1).HUG.Gtw != 15) {
            break label430;
          }
          localObject1 = ((bzi)localObject2).HmI.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label423;
          }
          localObject2 = (bwe)((Iterator)localObject1).next();
          localObject3 = QH(((bwe)localObject2).Hjg);
          if (localObject3 != bc.b.zES) {
            break label408;
          }
          a(paramp, ((bwe)localObject2).Hjg, 2, "upload has set it fail");
          AppMethodBeat.o(96019);
          return false;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.eco());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(96019);
        return false;
      }
      boolean bool = false;
      continue;
      label408:
      if (localObject3 == bc.b.zEU)
      {
        AppMethodBeat.o(96019);
        return false;
        label423:
        AppMethodBeat.o(96019);
        return true;
        label430:
        localObject3 = ((bzi)localObject2).HmI.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bwe localbwe = (bwe)((Iterator)localObject3).next();
          bc.b localb = a(localbwe.Hjg, bool, (bzi)localObject2, localException.HUG.Gtw);
          if (localb == bc.b.zES)
          {
            a(paramp, localbwe.Hjg, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == bc.b.zEU)
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
  
  private boolean D(p paramp)
  {
    AppMethodBeat.i(96024);
    final bzi localbzi;
    try
    {
      localbzi = (bzi)new bzi().parseFrom(paramp.field_postBuf);
      localbzi.hiJ += 1;
      paramp.field_postBuf = localbzi.toByteArray();
      ah.dXE().b(paramp.AdJ, paramp);
      if (p.AF(localbzi.HmL))
      {
        a(paramp, 6, "this item isTimeLimit");
        ae.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramp.eco() + " is die ");
        AppMethodBeat.o(96024);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ae.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramp, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(96024);
      return false;
    }
    ae.i("MicroMsg.UploadManager", "try start post " + paramp.eco());
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
      localTimeLineObject = paramp.ebP();
      localObject2 = a(paramp, localbzi);
      i = 0;
      if (i < localbzi.HmI.size())
      {
        j = ((bwe)localbzi.HmI.get(i)).Hjg;
        localt = ah.dXt().AH(j);
        if (localt == null)
        {
          a(paramp, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (bzk)new bzk().parseFrom(localt.Aey);
          if ((((bzk)localObject3).Hnd == null) || (((bzk)localObject3).Hnf.size() <= 0))
          {
            ae.e("MicroMsg.UploadManager", "item with not url" + paramp.field_type);
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
          ae.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramp, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(96024);
          return false;
        }
        str = ((bzk)localObject3).Hnd.Url;
        localObject5 = ((bzc)((bzk)localObject3).Hnf.get(0)).Url;
        j = ((bzk)localObject3).Hnd.nJA;
        k = ((bzc)((bzk)localObject3).Hnf.get(0)).nJA;
        localObject4 = ((bzk)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.HUG.Gtx.size()) {
          localObject1 = ((bzh)localTimeLineObject.HUG.Gtx.get(i)).Hmm;
        }
        if ((localTimeLineObject.HUG.Gtw == 4) || (localTimeLineObject.HUG.Gtw == 5))
        {
          if (i >= localTimeLineObject.HUG.Gtx.size()) {
            break label1143;
          }
          localObject1 = (bzh)localTimeLineObject.HUG.Gtx.get(i);
          ((bzh)localObject1).Hmj = ((String)localObject5);
          ((bzh)localObject1).Hmk = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).HUG.Gtw == 1)) {
        ((bzh)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).HUG.Gtw == 15))
      {
        ((bzh)localObject1).md5 = ((bzk)localObject3).md5;
        ((bzh)localObject1).HmE = ((bzk)localObject3).HmE;
      }
      if (i < localTimeLineObject.HUG.Gtx.size())
      {
        localObject3 = (bzh)localTimeLineObject.HUG.Gtx.get(i);
        ((bzh)localObject1).Title = ((bzh)localObject3).Title;
        ((bzh)localObject1).Desc = ((bzh)localObject3).Desc;
        ((bzh)localObject1).subType = ((bzh)localObject3).subType;
        ((bzh)localObject1).Aho = ((bzh)localObject3).Aho;
        ((bzh)localObject1).HmF = ((bzh)localObject3).HmF;
      }
      if (localObject1 == null)
      {
        a(paramp, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = h.a(localt.Aex, localt.type, str, (String)localObject5, j, k, ((bzk)localObject3).Hml, "", (bzj)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).HUG.Gtx.add(localObject1);
        i += 1;
        break;
        label802:
        if (!ah.dXD().Qx(paramp.AdJ))
        {
          ae.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localbzi.HmJ.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((did)((Iterator)localObject3).next()).nIJ);
        }
        localObject3 = com.tencent.mm.plugin.sns.i.n.e((TimeLineObject)localObject2);
        ae.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).HUJ + " contentDescShowType: " + ((TimeLineObject)localObject2).HUI);
        if (paramp.field_pravited == 1) {
          ae.i("MicroMsg.UploadManager", "content private xml is null ? " + bu.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramp, 5, "content is error");
          ah.dXD().Qy(paramp.AdJ);
          AppMethodBeat.o(96024);
          return false;
          ae.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localbzi.HmR == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramp.AdJ;
          localObject4 = localbzi.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).HUE.Hjt;
          localObject2 = ((TimeLineObject)localObject2).HUG.Title;
          ah.cXK().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (ah.dXn())
              {
                ae.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localbzi.HmZ != null)
              {
                i = localbzi.HmZ.FOX;
                str = localbzi.HmZ.uqs;
              }
              bc.a(bc.this, new s(this.ion, localbzi.Hml, localbzi.HmH, this.zEJ, localTimeLineObject, i, localbzi.hFO, localbzi.HmM, localbzi.HmN, localbzi.HmO, localbzi, bool, this.zEM, localbzi.HmS, this.zEN, this.cZw, i, str));
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(bc.d(bc.this), 0);
              AppMethodBeat.o(96005);
            }
          });
          ae.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramp.eco());
          AppMethodBeat.o(96024);
          return true;
        }
        label1143:
        localObject1 = null;
      }
    }
  }
  
  private static int QG(int paramInt)
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
  
  private bc.b QH(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      ae.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = bc.b.zES;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = ah.dXt().AH(paramInt);
    bzk localbzk;
    try
    {
      localbzk = (bzk)new bzk().parseFrom(((t)localObject).Aey);
      ae.i("MicroMsg.UploadManager", "state " + localbzk.HiZ + " doUploadSight, serverErr:" + localbzk.HmP);
      if (localbzk.HiZ == 1)
      {
        localObject = bc.b.zES;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = bc.b.zES;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (o.aZR(localbzk.videoPath) == 0L)
    {
      ae.i("MicroMsg.UploadManager", "path not fileexist  " + localbzk.videoPath);
      localb = bc.b.zES;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (o.aZR(localbzk.Hnh) == 0L)
    {
      ae.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localbzk.Hnh);
      localb = bc.b.zES;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localbzk.HiZ == 0)
    {
      localb = bc.b.zET;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (ah.dXD().Qz(paramInt))
    {
      ah.dXt().a(paramInt, localb);
      new ac(paramInt, localb, localbzk.videoPath, localbzk.Hnh, this.zEF).aAj(localbzk.dwb);
    }
    bc.b localb = bc.b.zEU;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private bc.b a(final int paramInt1, final boolean paramBoolean, final bzi parambzi, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      ae.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      parambzi = bc.b.zES;
      AppMethodBeat.o(96026);
      return parambzi;
    }
    Object localObject = ah.dXt().AH(paramInt1);
    bzk localbzk;
    try
    {
      localbzk = (bzk)new bzk().parseFrom(((t)localObject).Aey);
      ae.i("MicroMsg.UploadManager", "state " + localbzk.HiZ + " pic isMuti: " + paramBoolean);
      if (localbzk.HiZ == 1)
      {
        parambzi = bc.b.zES;
        AppMethodBeat.o(96026);
        return parambzi;
      }
    }
    catch (Exception parambzi)
    {
      ae.e("MicroMsg.UploadManager", "parse uploadInfo error");
      parambzi = bc.b.zES;
      AppMethodBeat.o(96026);
      return parambzi;
    }
    String str = com.tencent.mm.plugin.sns.data.r.azm(((t)localObject).Aeu);
    str = ap.jv(ah.getAccSnsPath(), ((t)localObject).Aeu) + str;
    if (o.aZR(str) == 0L)
    {
      ae.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      parambzi = bc.b.zES;
      AppMethodBeat.o(96026);
      return parambzi;
    }
    if (localbzk.HiZ == 0)
    {
      parambzi = bc.b.zET;
      AppMethodBeat.o(96026);
      return parambzi;
    }
    if (ah.dXD().Qz(paramInt1))
    {
      ah.dXt().a(paramInt1, (t)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((bu.HQ() + " " + System.currentTimeMillis()).getBytes());
      ah.cXK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (ah.dXn())
          {
            ae.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          z localz = new z(paramInt1, this.zEP, paramBoolean, paramInt2);
          ah.dXD().hC(paramInt1, localz.hashCode());
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(localz, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    parambzi = bc.b.zEU;
    AppMethodBeat.o(96026);
    return parambzi;
  }
  
  private static TimeLineObject a(p paramp, bzi parambzi)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramp.ebP();
    Object localObject = localTimeLineObject2.HUE;
    String str1 = localTimeLineObject2.HUD;
    String str2 = localTimeLineObject2.kbH;
    String str3 = localTimeLineObject2.Fnm;
    String str4 = localTimeLineObject2.HUG.Desc;
    String str5 = localTimeLineObject2.HUG.Title;
    String str6 = localTimeLineObject2.HUG.Url;
    String str7 = localTimeLineObject2.HUG.Gtz;
    en localen = localTimeLineObject2.HUF;
    edv localedv = localTimeLineObject2.HUM;
    int i = localTimeLineObject2.HUG.Gtw;
    int j = localTimeLineObject2.HUG.Gty;
    TimeLineObject localTimeLineObject1 = h.aLJ();
    localTimeLineObject1.nIJ = paramp.field_userName;
    localTimeLineObject1.Hml = paramp.field_pravited;
    localTimeLineObject1.HUD = str1;
    localTimeLineObject1.kbH = bu.nullAsNil(str2);
    localTimeLineObject1.Fnm = bu.nullAsNil(str3);
    localTimeLineObject1.HUI = localTimeLineObject2.HUI;
    localTimeLineObject1.HUJ = localTimeLineObject2.HUJ;
    localTimeLineObject1.hCH = localTimeLineObject2.hCH;
    localTimeLineObject1.HUK = localTimeLineObject2.HUK;
    localTimeLineObject1.AkC = localTimeLineObject2.AkC;
    localTimeLineObject1.HUG.Desc = str4;
    localTimeLineObject1.HUG.Title = str5;
    localTimeLineObject1.HUG.Gtw = i;
    localTimeLineObject1.HUG.Gty = j;
    localTimeLineObject1.HUG.Url = str6;
    localTimeLineObject1.HUG.Gtz = str7;
    localTimeLineObject1.HUG.GtB = localTimeLineObject2.HUG.GtB;
    localTimeLineObject1.HUG.GtC = localTimeLineObject2.HUG.GtC;
    localTimeLineObject1.HUG.GtD = localTimeLineObject2.HUG.GtD;
    localTimeLineObject1.HUE = ((bwk)localObject);
    localTimeLineObject1.HUL = localTimeLineObject2.HUL;
    localTimeLineObject1.AiG = localTimeLineObject2.AiG;
    if (localTimeLineObject2.zFf != null) {
      localTimeLineObject1.zFf = localTimeLineObject2.zFf;
    }
    if (localen != null) {
      localTimeLineObject1.HUF = localen;
    }
    if (localedv != null) {
      localTimeLineObject1.HUM = localedv;
    }
    paramp = localTimeLineObject2.HUG.Gtx.iterator();
    while (paramp.hasNext())
    {
      localObject = (bzh)paramp.next();
      if (((bzh)localObject).Hmp == 1) {
        localTimeLineObject1.HUG.Gtx.add(localObject);
      }
    }
    if (localTimeLineObject2.zFh != null) {
      localTimeLineObject1.zFh = localTimeLineObject2.zFh;
    }
    paramp = com.tencent.mm.model.z.aBG().F(parambzi.sessionId, true);
    if (paramp.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramp.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.HUG.GtA = new bxq();
        localTimeLineObject1.HUG.GtA.hFR = i;
        localTimeLineObject1.HUG.GtA.hBY = paramp.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.HUG.GtA.hCa = paramp.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.HUG.GtA.hBW = paramp.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.HUG.GtA.duration = paramp.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.HUG.GtA.desc = paramp.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.HUG.GtA.coverUrl = paramp.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.HUG.GtA.videoWidth = paramp.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.HUG.GtA.videoHeight = paramp.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.HUG.GtA.hBZ = paramp.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(96023);
    return localTimeLineObject1;
  }
  
  private void a(p paramp, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96014);
    ae.i("MicroMsg.UploadManager", "localId " + paramp.eco() + "processError " + paramInt2 + " errMsg: " + paramString);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = ah.dXt().AH(paramInt1);
      try
      {
        i = ((bzk)new bzk().parseFrom(paramString.Aey)).HmP;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramp.ech();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.HmP = i;
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
    ae.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramp.ecs();
    ah.dXE().b(paramp.AdJ, paramp);
    ae.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramp.AdJ);
    paramString = new uz();
    paramString.dKn.dKo = paramp.AdJ;
    com.tencent.mm.sdk.b.a.IvT.l(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      aB(paramp.AdJ, false);
      AppMethodBeat.o(96014);
      return;
      ae.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramp.ech();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.HmP;
      break;
      ae.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      ae.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      ae.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      ae.e("MicroMsg.UploadManager", "arg is error");
      continue;
      ae.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      ae.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(96015);
    a(paramp, 0, paramInt, paramString);
    AppMethodBeat.o(96015);
  }
  
  private static void a(bzi parambzi)
  {
    AppMethodBeat.i(96027);
    if (parambzi == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    parambzi = parambzi.HmI.iterator();
    while (parambzi.hasNext())
    {
      bwe localbwe = (bwe)parambzi.next();
      ah.dXD().QA(localbwe.Hjg);
    }
    AppMethodBeat.o(96027);
  }
  
  private void aB(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    ah.cXK().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (ah.dXn())
        {
          ae.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = bc.c(bc.this).iterator();
        while (localIterator.hasNext())
        {
          bc.a locala = (bc.a)localIterator.next();
          if (locala != null) {
            locala.aC(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static bd b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96017);
    ae.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    ae.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    bd localbd;
    for (;;)
    {
      localbd = new bd(i);
      localbd.aAG(bu.bI(paramString2, "")).aAH(bu.bI(paramString3, ""));
      localbd.QN(5);
      ae.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      ae.d("MicroMsg.UploadManager", "timeLineType is invalid");
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
    if (!bu.isNullOrNil(paramString1)) {
      localbd.aAA(paramString1);
    }
    localbd.aAF(bu.bI(paramWXMediaMessage.title, "")).aAD(bu.bI(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      ae.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbd.aAD("");
      localbd.aAA(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbd;
      paramString2 = (WXMusicObject)localObject;
      if (!bu.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramString3 = bu.bI(paramString1, "");
        if (bu.isNullOrNil(paramString2.musicDataUrl)) {
          break label469;
        }
      }
      label469:
      for (paramString1 = paramString2.musicDataUrl;; paramString1 = paramString2.musicUrl)
      {
        localObject = bu.bI(paramString1, "");
        localbd.aAF("").aAD("");
        i = QG(3);
        if (i != -1) {
          break label477;
        }
        ae.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = paramString2.musicLowBandUrl;
        break;
      }
      label477:
      if (!bu.isNullOrNil(paramString2.musicLowBandDataUrl)) {}
      for (paramString1 = paramString2.musicLowBandDataUrl;; paramString1 = paramString2.musicLowBandUrl)
      {
        paramString1 = bu.bI(paramString1, "");
        if (localbd.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, bu.bI(paramWXMediaMessage.title, ""), bu.bI(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!bu.cF(paramWXMediaMessage.imageData))
      {
        if (!localbd.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!bu.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbd.jA(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else
      {
        ae.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!bu.cF(paramWXMediaMessage.thumbData)) {
          localbd.b(paramWXMediaMessage.thumbData, bu.bI(paramWXMediaMessage.description, ""), bu.bI(paramWXMediaMessage.title, ""));
        }
        localbd.aAD(paramString1.webpageUrl).aAE(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbd.zFb.HUG.Url = paramWXMediaMessage;
        localbd.aAC(paramString1.canvasPageXml);
        continue;
        ae.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbd.aAF("").aAD("");
        i = QG(4);
        if (i == -1)
        {
          ae.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(96017);
          return null;
        }
        if (!bu.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = bu.bI(paramString1, "");
          if (localbd.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bu.bI(paramWXMediaMessage.title, ""), bu.bI(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((bu.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbd.aAF(paramWXMediaMessage.filePath);
        localbd.aAD(paramWXMediaMessage.filePath);
      }
    }
    ae.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean dYE()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = ah.dXE();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.Aeh + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    ae.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = new p();
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
      ((p)localObject2).convertFrom((Cursor)localObject1);
      try
      {
        bzi localbzi = (bzi)new bzi().parseFrom(((p)localObject2).field_postBuf);
        if (p.AF(localbzi.HmL))
        {
          a(localbzi);
          a((p)localObject2, 6, "snsinfo is tle");
          ae.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((p)localObject2).eco() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((p)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(96022);
    return true;
  }
  
  public final void C(p paramp)
  {
    AppMethodBeat.i(96020);
    if (paramp == null)
    {
      AppMethodBeat.o(96020);
      return;
    }
    ae.i("MicroMsg.UploadManager", "cancel snsinfo " + paramp.eco());
    try
    {
      Object localObject1 = (bzi)new bzi().parseFrom(paramp.field_postBuf);
      if ((localObject1 != null) && (((bzi)localObject1).HmI != null))
      {
        localObject1 = ((bzi)localObject1).HmI.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          bwe localbwe = (bwe)((Iterator)localObject1).next();
          int i = ah.dXD().QC(localbwe.Hjg);
          ah.dXD().QB(localbwe.Hjg);
          ae.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramp.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.cancel(i);
            ah.dXD().QA(localbwe.Hjg);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.eco());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((ah.dXD().Qw(paramp.AdJ)) && (this.zED != null))
      {
        ae.i("MicroMsg.UploadManager", "cancel post");
        this.zED.fTh = true;
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(this.zED);
        ah.dXD().Qy(paramp.AdJ);
      }
      Object localObject2 = ah.dXE().Rw(paramp.AdJ);
      if ((localObject2 != null) && (((p)localObject2).field_snsId != 0L))
      {
        ah.dXD().Al(((p)localObject2).field_snsId);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new r(((p)localObject2).field_snsId, 1), 0);
      }
      ah.dXE().Rx(paramp.AdJ);
      if (paramp.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.dWC().dWE();
      }
      ae.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramp.eco());
      localObject2 = new uz();
      ((uz)localObject2).dKn.dKo = paramp.AdJ;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
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
    paramString1.aAB(paramWXMediaMessage.mediaTagName);
    paramString1.aD(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.c.a.zsC) {
      paramString1.QI(1);
    }
    ae.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void dWc()
  {
    AppMethodBeat.i(96021);
    ah.cXK().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        bc.a(bc.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String dXj()
  {
    AppMethodBeat.i(96013);
    if ((this.fHO == null) || (this.fHO.equals("")))
    {
      com.tencent.mm.kernel.g.ajS();
      this.fHO = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null));
    }
    String str = this.fHO;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void dYF()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.cBA.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dYG();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final void i(List<com.tencent.mm.plugin.sns.i.m> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.zEE.zIe = paramBoolean;
    this.zEE.zIc.clear();
    this.zEE.zIc.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.i.m localm;
    if (bu.ht(this.zEE.zId))
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
          Iterator localIterator = this.zEE.zId.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!bu.lX(((com.tencent.mm.plugin.sns.i.m)localIterator.next()).name, localm.name));
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
          if (!bu.ht(localArrayList)) {
            this.zEE.zId.addAll(0, localArrayList);
          }
          if (this.zEE.zId.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.zEE.zId);
            this.zEE.zId.clear();
            this.zEE.zId.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.zEE.toByteArray();
            o.f(zEC, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            ae.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + zEC, new Object[0]);
            o.deleteFile(zEC);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final boolean jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    ae.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = ah.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    o.mF(paramString1, str);
    paramString1 = new bd(1);
    paramString1.aAA(paramString2);
    paramString1.QN(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.q(str, 2));
    paramString1.fV(paramString2);
    if (paramString1.commit() > 0)
    {
      AppMethodBeat.o(96016);
      return true;
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(96030);
    ae.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    switch (paramn.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        dWc();
        continue;
        paramString = (s)paramn;
        int i = paramString.dKr;
        if (paramString.fTh)
        {
          long l = paramString.zry;
          ae.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            ah.dXD().Al(l);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(new r(l, 1), 0);
          }
          ah.dXE().Rx(i);
          if (l != 0L)
          {
            ah.dXJ().AB(l);
            i.AA(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          aB(paramString.dKr, false);
        }
        for (;;)
        {
          this.zED = null;
          break;
          aB(paramString.dKr, true);
          am.report(paramString.zry);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void aC(int paramInt, boolean paramBoolean);
    
    public abstract void dYG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bc
 * JD-Core Version:    0.7.0.1
 */