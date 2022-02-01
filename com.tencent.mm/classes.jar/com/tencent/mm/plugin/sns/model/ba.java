package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.uc;
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
import com.tencent.mm.plugin.sns.i.l;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ba
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.sns.b.m
{
  public static int xPI;
  private static final String xXo;
  public Set<a> cqb;
  private String fnC;
  private r xXp;
  public l xXq;
  public ab.a xXr;
  
  static
  {
    AppMethodBeat.i(96034);
    xPI = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    xXo = com.tencent.mm.kernel.g.agR().cachePath + "rangeCache.data";
    AppMethodBeat.o(96034);
  }
  
  public ba()
  {
    AppMethodBeat.i(96011);
    this.fnC = "";
    this.xXp = null;
    this.cqb = new HashSet();
    this.xXq = new l();
    this.xXr = new ab.a()
    {
      public final void qI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96007);
        if (!paramAnonymousBoolean) {
          ba.this.dGr();
        }
        AppMethodBeat.o(96007);
      }
    };
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aU(xXo, 0, -1);
    if (arrayOfByte != null) {
      try
      {
        this.xXq = ((l)new l().parseFrom(arrayOfByte));
        AppMethodBeat.o(96011);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.UploadManager", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.i.deleteFile(xXo);
      }
    }
    AppMethodBeat.o(96011);
  }
  
  private boolean B(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96024);
    final bua localbua;
    try
    {
      localbua = (bua)new bua().parseFrom(paramp.field_postBuf);
      localbua.gLY += 1;
      paramp.field_postBuf = localbua.toByteArray();
      af.dHR().b(paramp.yvp, paramp);
      if (com.tencent.mm.plugin.sns.storage.p.xJ(localbua.FjJ))
      {
        a(paramp, 6, "this item isTimeLimit");
        ac.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + paramp.dMu() + " is die ");
        AppMethodBeat.o(96024);
        return false;
      }
    }
    catch (Exception localException1)
    {
      ac.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
      a(paramp, 2, "MediaPostInfo parser error:" + localException1.getMessage());
      AppMethodBeat.o(96024);
      return false;
    }
    ac.i("MicroMsg.UploadManager", "try start post " + paramp.dMu());
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
    if (z(paramp))
    {
      localTimeLineObject = paramp.dLV();
      localObject2 = a(paramp, localbua);
      i = 0;
      if (i < localbua.FjG.size())
      {
        j = ((bqx)localbua.FjG.get(i)).Fgc;
        localt = af.dHG().xL(j);
        if (localt == null)
        {
          a(paramp, 3, "can not get the media from db ,localMediaId: ".concat(String.valueOf(j)));
          AppMethodBeat.o(96024);
          return false;
        }
        try
        {
          localObject3 = (buc)new buc().parseFrom(localt.ywe);
          if ((((buc)localObject3).Fkb == null) || (((buc)localObject3).Fkd.size() <= 0))
          {
            ac.e("MicroMsg.UploadManager", "item with not url" + paramp.field_type);
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
          ac.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
          a(paramp, 2, "mediaUploadInfo parser error " + localException2.getMessage());
          AppMethodBeat.o(96024);
          return false;
        }
        str = ((buc)localObject3).Fkb.Url;
        localObject5 = ((btu)((buc)localObject3).Fkd.get(0)).Url;
        j = ((buc)localObject3).Fkb.ndI;
        k = ((btu)((buc)localObject3).Fkd.get(0)).ndI;
        localObject4 = ((buc)localObject3).md5;
        localObject1 = null;
        if (i < localTimeLineObject.FQo.Etz.size()) {
          localObject1 = ((btz)localTimeLineObject.FQo.Etz.get(i)).Fjk;
        }
        if ((localTimeLineObject.FQo.Ety == 4) || (localTimeLineObject.FQo.Ety == 5))
        {
          if (i >= localTimeLineObject.FQo.Etz.size()) {
            break label1126;
          }
          localObject1 = (btz)localTimeLineObject.FQo.Etz.get(i);
          ((btz)localObject1).Fjh = ((String)localObject5);
          ((btz)localObject1).Fji = k;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((TimeLineObject)localObject2).FQo.Ety == 1)) {
        ((btz)localObject1).md5 = ((String)localObject4);
      }
      if ((localObject1 != null) && (((TimeLineObject)localObject2).FQo.Ety == 15))
      {
        ((btz)localObject1).md5 = ((buc)localObject3).md5;
        ((btz)localObject1).FjC = ((buc)localObject3).FjC;
      }
      if (i < localTimeLineObject.FQo.Etz.size())
      {
        localObject3 = (btz)localTimeLineObject.FQo.Etz.get(i);
        ((btz)localObject1).Title = ((btz)localObject3).Title;
        ((btz)localObject1).Desc = ((btz)localObject3).Desc;
        ((btz)localObject1).subType = ((btz)localObject3).subType;
        ((btz)localObject1).yyV = ((btz)localObject3).yyV;
        ((btz)localObject1).FjD = ((btz)localObject3).FjD;
      }
      if (localObject1 == null)
      {
        a(paramp, 3, "make media error");
        AppMethodBeat.o(96024);
        return false;
        localObject1 = com.tencent.mm.modelsns.g.a(localt.ywd, localt.type, str, (String)localObject5, j, k, ((buc)localObject3).Fjj, "", (bub)localObject1);
      }
      else
      {
        ((TimeLineObject)localObject2).FQo.Etz.add(localObject1);
        i += 1;
        break;
        label788:
        if (!af.dHQ().Oj(paramp.yvp))
        {
          ac.d("MicroMsg.UploadManager", "this snsinfo is posting");
          AppMethodBeat.o(96024);
          return false;
        }
        localObject1 = new LinkedList();
        localObject3 = localbua.FjH.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((dbw)((Iterator)localObject3).next()).ncR);
        }
        localObject3 = com.tencent.mm.plugin.sns.i.n.e((TimeLineObject)localObject2);
        ac.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + ((TimeLineObject)localObject2).FQr + " contentDescShowType: " + ((TimeLineObject)localObject2).FQq);
        if (paramp.field_pravited == 1) {
          ac.i("MicroMsg.UploadManager", "content private xml is null ? " + bs.isNullOrNil((String)localObject3));
        }
        while ((localObject3 == null) || (((String)localObject3).equals("")))
        {
          a(paramp, 5, "content is error");
          af.dHQ().Ok(paramp.yvp);
          AppMethodBeat.o(96024);
          return false;
          ac.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[] { localObject3 });
        }
        if (localbua.FjP == 1) {}
        for (final boolean bool = true;; bool = false)
        {
          i = paramp.yvp;
          localObject4 = localbua.GroupUser;
          localObject5 = ((TimeLineObject)localObject2).FQm.Fgp;
          localObject2 = ((TimeLineObject)localObject2).FQo.Title;
          af.cMM().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96005);
              if (af.dHA())
              {
                ac.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                AppMethodBeat.o(96005);
                return;
              }
              int i = 1;
              String str = "";
              if (localbua.FjX != null)
              {
                i = localbua.FjX.DRh;
                str = localbua.FjX.thr;
              }
              ba.a(ba.this, new r(this.hSd, localbua.Fjj, localbua.FjF, this.xXv, localTimeLineObject, i, localbua.hkN, localbua.FjK, localbua.FjL, localbua.FjM, localbua, bool, this.xXy, localbua.FjQ, this.xXz, this.cNi, i, str));
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(ba.d(ba.this), 0);
              AppMethodBeat.o(96005);
            }
          });
          ac.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + paramp.dMu());
          AppMethodBeat.o(96024);
          return true;
        }
        label1126:
        localObject1 = null;
      }
    }
  }
  
  private static int Os(int paramInt)
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
  
  private ba.b Ot(int paramInt)
  {
    AppMethodBeat.i(96028);
    if (paramInt == -1)
    {
      ac.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
      localObject = ba.b.xXE;
      AppMethodBeat.o(96028);
      return localObject;
    }
    Object localObject = af.dHG().xL(paramInt);
    buc localbuc;
    try
    {
      localbuc = (buc)new buc().parseFrom(((t)localObject).ywe);
      ac.i("MicroMsg.UploadManager", "state " + localbuc.FfT + " doUploadSight, serverErr:" + localbuc.FjN);
      if (localbuc.FfT == 1)
      {
        localObject = ba.b.xXE;
        AppMethodBeat.o(96028);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
      localb = ba.b.xXE;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aSp(localbuc.videoPath) == 0L)
    {
      ac.i("MicroMsg.UploadManager", "path not fileexist  " + localbuc.videoPath);
      localb = ba.b.xXE;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (com.tencent.mm.vfs.i.aSp(localbuc.Fkf) == 0L)
    {
      ac.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + localbuc.Fkf);
      localb = ba.b.xXE;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (localbuc.FfT == 0)
    {
      localb = ba.b.xXF;
      AppMethodBeat.o(96028);
      return localb;
    }
    if (af.dHQ().Ol(paramInt))
    {
      af.dHG().a(paramInt, localb);
      new ab(paramInt, localb, localbuc.videoPath, localbuc.Fkf, this.xXr).atN(localbuc.djj);
    }
    ba.b localb = ba.b.xXG;
    AppMethodBeat.o(96028);
    return localb;
  }
  
  private ba.b a(final int paramInt1, final boolean paramBoolean, final bua parambua, final int paramInt2)
  {
    AppMethodBeat.i(96026);
    if (paramInt1 == -1)
    {
      ac.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
      parambua = ba.b.xXE;
      AppMethodBeat.o(96026);
      return parambua;
    }
    Object localObject = af.dHG().xL(paramInt1);
    buc localbuc;
    try
    {
      localbuc = (buc)new buc().parseFrom(((t)localObject).ywe);
      ac.i("MicroMsg.UploadManager", "state " + localbuc.FfT + " pic isMuti: " + paramBoolean);
      if (localbuc.FfT == 1)
      {
        parambua = ba.b.xXE;
        AppMethodBeat.o(96026);
        return parambua;
      }
    }
    catch (Exception parambua)
    {
      ac.e("MicroMsg.UploadManager", "parse uploadInfo error");
      parambua = ba.b.xXE;
      AppMethodBeat.o(96026);
      return parambua;
    }
    String str = com.tencent.mm.plugin.sns.data.q.asQ(((t)localObject).ywa);
    str = an.jc(af.getAccSnsPath(), ((t)localObject).ywa) + str;
    if (com.tencent.mm.vfs.i.aSp(str) == 0L)
    {
      ac.i("MicroMsg.UploadManager", "path not exist  ".concat(String.valueOf(str)));
      parambua = ba.b.xXE;
      AppMethodBeat.o(96026);
      return parambua;
    }
    if (localbuc.FfT == 0)
    {
      parambua = ba.b.xXF;
      AppMethodBeat.o(96026);
      return parambua;
    }
    if (af.dHQ().Ol(paramInt1))
    {
      af.dHG().a(paramInt1, (t)localObject);
      localObject = com.tencent.mm.b.g.getMessageDigest((bs.Gn() + " " + System.currentTimeMillis()).getBytes());
      af.cMM().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96006);
          if (af.dHA())
          {
            ac.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            AppMethodBeat.o(96006);
            return;
          }
          y localy = new y(paramInt1, this.xXB, paramBoolean, paramInt2);
          af.dHQ().hi(paramInt1, localy.hashCode());
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(localy, 0);
          AppMethodBeat.o(96006);
        }
      });
    }
    parambua = ba.b.xXG;
    AppMethodBeat.o(96026);
    return parambua;
  }
  
  private static TimeLineObject a(com.tencent.mm.plugin.sns.storage.p paramp, bua parambua)
  {
    AppMethodBeat.i(96023);
    TimeLineObject localTimeLineObject2 = paramp.dLV();
    Object localObject = localTimeLineObject2.FQm;
    String str1 = localTimeLineObject2.FQl;
    String str2 = localTimeLineObject2.jEq;
    String str3 = localTimeLineObject2.DpN;
    String str4 = localTimeLineObject2.FQo.Desc;
    String str5 = localTimeLineObject2.FQo.Title;
    String str6 = localTimeLineObject2.FQo.Url;
    String str7 = localTimeLineObject2.FQo.EtB;
    ej localej = localTimeLineObject2.FQn;
    dwe localdwe = localTimeLineObject2.FQu;
    int i = localTimeLineObject2.FQo.Ety;
    int j = localTimeLineObject2.FQo.EtA;
    TimeLineObject localTimeLineObject1 = com.tencent.mm.modelsns.g.aIb();
    localTimeLineObject1.ncR = paramp.field_userName;
    localTimeLineObject1.Fjj = paramp.field_pravited;
    localTimeLineObject1.FQl = str1;
    localTimeLineObject1.jEq = bs.nullAsNil(str2);
    localTimeLineObject1.DpN = bs.nullAsNil(str3);
    localTimeLineObject1.FQq = localTimeLineObject2.FQq;
    localTimeLineObject1.FQr = localTimeLineObject2.FQr;
    localTimeLineObject1.hhK = localTimeLineObject2.hhK;
    localTimeLineObject1.FQs = localTimeLineObject2.FQs;
    localTimeLineObject1.yCb = localTimeLineObject2.yCb;
    localTimeLineObject1.FQo.Desc = str4;
    localTimeLineObject1.FQo.Title = str5;
    localTimeLineObject1.FQo.Ety = i;
    localTimeLineObject1.FQo.EtA = j;
    localTimeLineObject1.FQo.Url = str6;
    localTimeLineObject1.FQo.EtB = str7;
    localTimeLineObject1.FQo.EtD = localTimeLineObject2.FQo.EtD;
    localTimeLineObject1.FQo.EtE = localTimeLineObject2.FQo.EtE;
    localTimeLineObject1.FQm = ((brd)localObject);
    localTimeLineObject1.FQt = localTimeLineObject2.FQt;
    localTimeLineObject1.yAj = localTimeLineObject2.yAj;
    if (localTimeLineObject2.xXR != null) {
      localTimeLineObject1.xXR = localTimeLineObject2.xXR;
    }
    if (localej != null) {
      localTimeLineObject1.FQn = localej;
    }
    if (localdwe != null) {
      localTimeLineObject1.FQu = localdwe;
    }
    paramp = localTimeLineObject2.FQo.Etz.iterator();
    while (paramp.hasNext())
    {
      localObject = (btz)paramp.next();
      if (((btz)localObject).Fjn == 1) {
        localTimeLineObject1.FQo.Etz.add(localObject);
      }
    }
    if (localTimeLineObject2.xXT != null) {
      localTimeLineObject1.xXT = localTimeLineObject2.xXT;
    }
    paramp = com.tencent.mm.model.y.ayq().F(parambua.sessionId, true);
    if (paramp.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      i = paramp.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      if (i != -1)
      {
        localTimeLineObject1.FQo.EtC = new bsj();
        localTimeLineObject1.FQo.EtC.hkQ = i;
        localTimeLineObject1.FQo.EtC.hhb = paramp.getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", 0);
        if (i == 5)
        {
          localTimeLineObject1.FQo.EtC.hhd = paramp.getString("_DATA_CENTER_VID", "");
          localTimeLineObject1.FQo.EtC.hgZ = paramp.getInt("_DATA_CENTER_PUB_TIME", 0);
          localTimeLineObject1.FQo.EtC.duration = paramp.getInt("_DATA_CENTER__DULATION", 0);
          localTimeLineObject1.FQo.EtC.desc = paramp.getString("_DATA_CENTER_DESC", "");
          localTimeLineObject1.FQo.EtC.coverUrl = paramp.getString("_DATA_CENTER_COVER_URL", "");
          localTimeLineObject1.FQo.EtC.videoWidth = paramp.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
          localTimeLineObject1.FQo.EtC.videoHeight = paramp.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
          localTimeLineObject1.FQo.EtC.hhc = paramp.getInt("_DATA_CENTER_FUNC_FLAG", 0);
        }
      }
    }
    AppMethodBeat.o(96023);
    return localTimeLineObject1;
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96014);
    ac.i("MicroMsg.UploadManager", "localId " + paramp.dMu() + "processError " + paramInt2 + " errMsg: " + paramString);
    h.wUl.idkeyStat(22L, 129L, 1L, true);
    if (paramInt1 != 0)
    {
      paramString = af.dHG().xL(paramInt1);
      try
      {
        i = ((buc)new buc().parseFrom(paramString.ywe)).FjN;
      }
      catch (Exception paramString)
      {
        label136:
        paramInt1 = 0;
      }
    }
    try
    {
      paramString = paramp.dMn();
      paramInt1 = i;
      if (paramString != null)
      {
        paramString.FjN = i;
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
    ac.d("MicroMsg.UploadManager", "post error ".concat(String.valueOf(paramInt1)));
    paramp.dMy();
    af.dHR().b(paramp.yvp, paramp);
    ac.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + paramp.yvp);
    paramString = new uc();
    paramString.dwN.dwO = paramp.yvp;
    com.tencent.mm.sdk.b.a.GpY.l(paramString);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      at(paramp.yvp, false);
      AppMethodBeat.o(96014);
      return;
      ac.e("MicroMsg.UploadManager", "parse uploadInfo error");
      break;
      paramString = paramp.dMn();
      if (paramString == null) {
        break label389;
      }
      paramInt1 = paramString.FjN;
      break;
      ac.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
      continue;
      ac.e("MicroMsg.UploadManager", "parser protobuf error");
      continue;
      ac.e("MicroMsg.UploadManager", "local id is not in db");
      continue;
      ac.e("MicroMsg.UploadManager", "arg is error");
      continue;
      ac.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
      continue;
      ac.e("MicroMsg.UploadManager", "errtle  error");
    }
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(96015);
    a(paramp, 0, paramInt, paramString);
    AppMethodBeat.o(96015);
  }
  
  private static void a(bua parambua)
  {
    AppMethodBeat.i(96027);
    if (parambua == null)
    {
      AppMethodBeat.o(96027);
      return;
    }
    parambua = parambua.FjG.iterator();
    while (parambua.hasNext())
    {
      bqx localbqx = (bqx)parambua.next();
      af.dHQ().Om(localbqx.Fgc);
    }
    AppMethodBeat.o(96027);
  }
  
  private void at(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(96025);
    af.cMM().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96004);
        if (af.dHA())
        {
          ac.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
          AppMethodBeat.o(96004);
          return;
        }
        Iterator localIterator = ba.c(ba.this).iterator();
        while (localIterator.hasNext())
        {
          ba.a locala = (ba.a)localIterator.next();
          if (locala != null) {
            locala.au(paramInt, paramBoolean);
          }
        }
        AppMethodBeat.o(96004);
      }
    });
    AppMethodBeat.o(96025);
  }
  
  public static bb b(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96017);
    ac.d("MicroMsg.UploadManager", "appmsg.description " + paramWXMediaMessage.description);
    ac.d("MicroMsg.UploadManager", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      i = -1;
    }
    bb localbb;
    for (;;)
    {
      localbb = new bb(i);
      localbb.auk(bs.bG(paramString2, "")).aul(bs.bG(paramString3, ""));
      localbb.Oy(5);
      ac.d("MicroMsg.UploadManager", "TimeLineType ".concat(String.valueOf(i)));
      if (i != -1) {
        break;
      }
      ac.d("MicroMsg.UploadManager", "timeLineType is invalid");
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
    if (!bs.isNullOrNil(paramString1)) {
      localbb.aue(paramString1);
    }
    localbb.auj(bs.bG(paramWXMediaMessage.title, "")).auh(bs.bG(paramWXMediaMessage.description, ""));
    switch (((WXMediaMessage.IMediaObject)localObject).type())
    {
    default: 
      ac.e("MicroMsg.UploadManager", "none type not support!");
      AppMethodBeat.o(96017);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject;
      localbb.auh("");
      localbb.aue(paramWXMediaMessage.text);
    }
    for (;;)
    {
      AppMethodBeat.o(96017);
      return localbb;
      paramString2 = (WXMusicObject)localObject;
      if (!bs.isNullOrNil(paramString2.musicUrl))
      {
        paramString1 = paramString2.musicUrl;
        paramString3 = bs.bG(paramString1, "");
        if (bs.isNullOrNil(paramString2.musicDataUrl)) {
          break label469;
        }
      }
      label469:
      for (paramString1 = paramString2.musicDataUrl;; paramString1 = paramString2.musicUrl)
      {
        localObject = bs.bG(paramString1, "");
        localbb.auj("").auh("");
        i = Os(3);
        if (i != -1) {
          break label477;
        }
        ac.d("MicroMsg.UploadManager", "mediaType is invalid");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = paramString2.musicLowBandUrl;
        break;
      }
      label477:
      if (!bs.isNullOrNil(paramString2.musicLowBandDataUrl)) {}
      for (paramString1 = paramString2.musicLowBandDataUrl;; paramString1 = paramString2.musicLowBandUrl)
      {
        paramString1 = bs.bG(paramString1, "");
        if (localbb.a(paramWXMediaMessage.thumbData, paramString3, paramString1, (String)localObject, i, bs.bG(paramWXMediaMessage.title, ""), bs.bG(paramWXMediaMessage.description, ""), paramString2.songAlbumUrl, paramString2.songLyric)) {
          break;
        }
        AppMethodBeat.o(96017);
        return null;
      }
      paramWXMediaMessage = (WXImageObject)localObject;
      if (!bs.cv(paramWXMediaMessage.imageData))
      {
        if (!localbb.b(paramWXMediaMessage.imageData, "", ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else if (!bs.isNullOrNil(paramWXMediaMessage.imagePath))
      {
        if (!localbb.jh(paramWXMediaMessage.imagePath, ""))
        {
          AppMethodBeat.o(96017);
          return null;
        }
      }
      else
      {
        ac.e("MicroMsg.UploadManager", "share img but no res is exist!");
        AppMethodBeat.o(96017);
        return null;
        paramString1 = (WXWebpageObject)localObject;
        if (!bs.cv(paramWXMediaMessage.thumbData)) {
          localbb.b(paramWXMediaMessage.thumbData, bs.bG(paramWXMediaMessage.description, ""), bs.bG(paramWXMediaMessage.title, ""));
        }
        localbb.auh(paramString1.webpageUrl).aui(paramString1.webpageUrl);
        paramWXMediaMessage = paramString1.webpageUrl;
        localbb.xXN.FQo.Url = paramWXMediaMessage;
        localbb.aug(paramString1.canvasPageXml);
        continue;
        ac.e("MicroMsg.UploadManager", "file is not support!");
        AppMethodBeat.o(96017);
        return null;
        paramString2 = (WXVideoObject)localObject;
        localbb.auj("").auh("");
        i = Os(4);
        if (i == -1)
        {
          ac.d("MicroMsg.UploadManager", "mediaType is invalid");
          AppMethodBeat.o(96017);
          return null;
        }
        if (!bs.isNullOrNil(paramString2.videoUrl)) {}
        for (paramString1 = paramString2.videoUrl;; paramString1 = paramString2.videoLowBandUrl)
        {
          paramString1 = bs.bG(paramString1, "");
          if (localbb.a(paramWXMediaMessage.thumbData, paramString1, paramString2.videoLowBandUrl, paramString2.videoUrl, i, bs.bG(paramWXMediaMessage.title, ""), bs.bG(paramWXMediaMessage.description, ""), "", "")) {
            break;
          }
          AppMethodBeat.o(96017);
          return null;
        }
        paramWXMediaMessage = (WXAppExtendObject)localObject;
        if ((bs.isNullOrNil(paramWXMediaMessage.filePath)) || (!paramWXMediaMessage.filePath.startsWith("http"))) {
          break;
        }
        localbb.auj(paramWXMediaMessage.filePath);
        localbb.auh(paramWXMediaMessage.filePath);
      }
    }
    ac.e("MicroMsg.UploadManager", "appdata is not support!");
    AppMethodBeat.o(96017);
    return null;
  }
  
  private boolean dIQ()
  {
    AppMethodBeat.i(96022);
    Object localObject1 = af.dHR();
    localObject2 = "select *,rowid from SnsInfo  where " + com.tencent.mm.plugin.sns.storage.q.yvN + " order by SnsInfo.rowid asc ";
    localObject1 = ((com.tencent.mm.plugin.sns.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    ac.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(localObject2)));
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
        bua localbua = (bua)new bua().parseFrom(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_postBuf);
        if (com.tencent.mm.plugin.sns.storage.p.xJ(localbua.FjJ))
        {
          a(localbua);
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 6, "snsinfo is tle");
          ac.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + ((com.tencent.mm.plugin.sns.storage.p)localObject2).dMu() + " is die ");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
          a((com.tencent.mm.plugin.sns.storage.p)localObject2, 2, "MediaPostInfo parser error");
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(96022);
    return true;
  }
  
  private boolean z(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96019);
    if (paramp == null)
    {
      AppMethodBeat.o(96019);
      return false;
    }
    Object localObject1 = paramp.dLV();
    if (((TimeLineObject)localObject1).FQo.Ety == 8)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    if (((TimeLineObject)localObject1).FQo.Ety == 2)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    Object localObject2;
    if (((TimeLineObject)localObject1).FQo.Ety == 26)
    {
      localObject2 = new gt();
      ((gt)localObject2).dhx.type = 30;
      ((gt)localObject2).dhx.dhE = 5;
      ((gt)localObject2).dhx.desc = ((TimeLineObject)localObject1).FQo.EtB;
      ((gt)localObject2).dhx.dhD = String.valueOf(paramp.yvp);
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((gt)localObject2).dhy.ret != 1)
      {
        AppMethodBeat.o(96019);
        return false;
      }
    }
    if ((localObject1 == null) || (((TimeLineObject)localObject1).FQo.Etz == null))
    {
      a(paramp, 1, "timeline or timelineObjList is null");
      AppMethodBeat.o(96019);
      return false;
    }
    if (((TimeLineObject)localObject1).FQo.Etz.size() == 0)
    {
      AppMethodBeat.o(96019);
      return true;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = (bua)new bua().parseFrom(paramp.field_postBuf);
        if (((TimeLineObject)localObject1).FQo.Ety != 1) {
          break label552;
        }
        if (((bua)localObject2).FjG.size() > 1)
        {
          bool = true;
          if (((TimeLineObject)localObject1).FQo.Ety != 21) {
            break label549;
          }
          bool = false;
          if (((TimeLineObject)localObject1).FQo.Ety != 15) {
            break label442;
          }
          localObject1 = ((bua)localObject2).FjG.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label434;
          }
          localObject2 = (bqx)((Iterator)localObject1).next();
          localObject3 = Ot(((bqx)localObject2).Fgc);
          if (localObject3 != ba.b.xXE) {
            break label418;
          }
          a(paramp, ((bqx)localObject2).Fgc, 2, "upload has set it fail");
          AppMethodBeat.o(96019);
          return false;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dMu());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        AppMethodBeat.o(96019);
        return false;
      }
      boolean bool = false;
      continue;
      label418:
      if (localObject3 == ba.b.xXG)
      {
        AppMethodBeat.o(96019);
        return false;
        label434:
        AppMethodBeat.o(96019);
        return true;
        label442:
        localObject3 = ((bua)localObject2).FjG.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bqx localbqx = (bqx)((Iterator)localObject3).next();
          ba.b localb = a(localbqx.Fgc, bool, (bua)localObject2, localException.FQo.Ety);
          if (localb == ba.b.xXE)
          {
            a(paramp, localbqx.Fgc, 2, "upload has set it fail");
            AppMethodBeat.o(96019);
            return false;
          }
          if (localb == ba.b.xXG)
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
  
  public final void A(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(96020);
    if (paramp == null)
    {
      AppMethodBeat.o(96020);
      return;
    }
    ac.i("MicroMsg.UploadManager", "cancel snsinfo " + paramp.dMu());
    try
    {
      Object localObject1 = (bua)new bua().parseFrom(paramp.field_postBuf);
      if ((localObject1 != null) && (((bua)localObject1).FjG != null))
      {
        localObject1 = ((bua)localObject1).FjG.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          bqx localbqx = (bqx)((Iterator)localObject1).next();
          int i = af.dHQ().Oo(localbqx.Fgc);
          af.dHQ().On(localbqx.Fgc);
          ac.i("MicroMsg.UploadManager", "cancel upload %d", new Object[] { Integer.valueOf(i) });
          if ((paramp.field_type != 15) && (i >= 0))
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.cancel(i);
            af.dHQ().Om(localbqx.Fgc);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + paramp.dMu());
        a(paramp, 2, "mediaPostInfo parser error " + localException.getMessage());
        localObject2 = null;
      }
      if ((af.dHQ().Oi(paramp.yvp)) && (this.xXp != null))
      {
        ac.i("MicroMsg.UploadManager", "cancel post");
        this.xXp.fxO = true;
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(this.xXp);
        af.dHQ().Ok(paramp.yvp);
      }
      Object localObject2 = af.dHR().Ph(paramp.yvp);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId != 0L))
      {
        af.dHQ().xo(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new q(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId, 1), 0);
      }
      af.dHR().Pi(paramp.yvp);
      if (paramp.field_type == 21) {
        com.tencent.mm.plugin.sns.lucky.a.g.dGP().dGR();
      }
      ac.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + paramp.dMu());
      localObject2 = new uc();
      ((uc)localObject2).dwN.dwO = paramp.yvp;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
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
    paramString1.auf(paramWXMediaMessage.mediaTagName);
    paramString1.aw(paramString2, paramWXMediaMessage.messageExt, paramWXMediaMessage.messageAction);
    if (paramInt > com.tencent.mm.plugin.sns.c.a.xMh) {
      paramString1.Ou(1);
    }
    ac.d("MicroMsg.UploadManager", "shareAppMsg set and the result: ".concat(String.valueOf(paramString1.commit())));
    AppMethodBeat.o(96018);
    return true;
  }
  
  public final void dGr()
  {
    AppMethodBeat.i(96021);
    af.cMM().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96002);
        ba.a(ba.this);
        AppMethodBeat.o(96002);
      }
    }, 1000L);
    AppMethodBeat.o(96021);
  }
  
  public final String dHx()
  {
    AppMethodBeat.i(96013);
    if ((this.fnC == null) || (this.fnC.equals("")))
    {
      com.tencent.mm.kernel.g.agS();
      this.fnC = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
    }
    String str = this.fnC;
    AppMethodBeat.o(96013);
    return str;
  }
  
  public final void dIR()
  {
    AppMethodBeat.i(96029);
    Iterator localIterator = this.cqb.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.dIS();
      }
    }
    AppMethodBeat.o(96029);
  }
  
  public final void h(List<com.tencent.mm.plugin.sns.i.m> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(96012);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(96012);
      return;
    }
    this.xXq.yaT = paramBoolean;
    this.xXq.yaR.clear();
    this.xXq.yaR.addAll(paramList);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.sns.i.m localm;
    if (bs.gY(this.xXq.yaS))
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
          Iterator localIterator = this.xXq.yaS.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!bs.lr(((com.tencent.mm.plugin.sns.i.m)localIterator.next()).name, localm.name));
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
          if (!bs.gY(localArrayList)) {
            this.xXq.yaS.addAll(0, localArrayList);
          }
          if (this.xXq.yaS.size() > 5)
          {
            paramList = new ArrayList();
            paramList.addAll(this.xXq.yaS);
            this.xXq.yaS.clear();
            this.xXq.yaS.addAll(paramList.subList(0, 5));
          }
          try
          {
            paramList = this.xXq.toByteArray();
            com.tencent.mm.vfs.i.f(xXo, paramList, paramList.length);
            AppMethodBeat.o(96012);
            return;
          }
          catch (IOException paramList)
          {
            ac.printErrStackTrace("MicroMsg.UploadManager", paramList, "listToFile failed: " + xXo, new Object[0]);
            com.tencent.mm.vfs.i.deleteFile(xXo);
            AppMethodBeat.o(96012);
            return;
          }
        }
      }
    }
  }
  
  public final boolean iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96016);
    ac.d("MicroMsg.UploadManager", "imgPath " + paramString1 + " text " + paramString2);
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    com.tencent.mm.vfs.i.lZ(paramString1, str);
    paramString1 = new bb(1);
    paramString1.aue(paramString2);
    paramString1.Oy(6);
    paramString2 = new LinkedList();
    paramString2.add(new com.tencent.mm.plugin.sns.data.p(str, 2));
    paramString1.fz(paramString2);
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
    ac.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    switch (paramn.getType())
    {
    }
    while ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(96030);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        dGr();
        continue;
        paramString = (r)paramn;
        int i = paramString.dwR;
        if (paramString.fxO)
        {
          long l = paramString.xLI;
          ac.i("MicroMsg.UploadManager", "get the del post come back %d ".concat(String.valueOf(l)), new Object[] { Integer.valueOf(i) });
          if (l != 0L)
          {
            af.dHQ().xo(l);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new q(l, 1), 0);
          }
          af.dHR().Pi(i);
          if (l != 0L)
          {
            af.dHW().xF(l);
            com.tencent.mm.plugin.sns.storage.i.xE(l);
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          at(paramString.dwR, false);
        }
        for (;;)
        {
          this.xXp = null;
          break;
          at(paramString.dwR, true);
          ak.report(paramString.xLI);
        }
      }
    }
    AppMethodBeat.o(96030);
  }
  
  public static abstract interface a
  {
    public abstract void au(int paramInt, boolean paramBoolean);
    
    public abstract void dIS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ba
 * JD-Core Version:    0.7.0.1
 */