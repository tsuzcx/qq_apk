package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.zf;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.d.f;
import com.tencent.mm.plugin.sns.ad.timeline.helper.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.ffl;
import com.tencent.mm.protocal.protobuf.ffm;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  private long QsL;
  private String QsM;
  private long Qsh;
  public int Qsj;
  public int Qsk;
  public int bUo;
  public com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  final int sourceType;
  
  public u()
  {
    AppMethodBeat.i(95619);
    this.Qsh = 0L;
    this.QsL = 0L;
    this.QsM = "";
    this.Qsj = 0;
    this.Qsk = 0;
    this.bUo = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ffl();
    ((c.a)localObject).otF = new ffm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((c.a)localObject).funcId = 718;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    int i = t.aPK();
    this.sourceType = 2;
    ffl localffl = (ffl)c.b.b(this.rr.otB);
    localffl.abCZ = i;
    localffl.abDv = 0L;
    int j = al.hgr().hhi();
    this.Qsh = al.hgB().h(0L, j, true);
    localffl.abEV = this.Qsh;
    int k = d.b(this.Qsh, 0L, "@__weixintimtline");
    localffl.abEW = k;
    this.QsL = al.hgB().h(0L, 1, true);
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.QsL);
    localffl.abEX = this.QsL;
    com.tencent.mm.plugin.sns.storage.u localu = al.hgF().aZW("@__weixintimtline");
    if (localu == null)
    {
      localObject = "";
      this.QsM = ((String)localObject);
      if (this.QsM == null) {
        this.QsM = "";
      }
      localffl.abDu = this.QsM;
      if ((localu != null) && (localu.field_adsession != null)) {
        break label432;
      }
    }
    for (localffl.abCX = new gol().df(new byte[0]);; localffl.abCX = new gol().df(localu.field_adsession))
    {
      localffl.abFh = new gol().df(f.gZJ());
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "This req nextCount: " + j + " min:" + this.Qsh + " ReqTime:" + localffl.abEW + " nettype: " + i);
      Log.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { t.uA(this.Qsh), Integer.valueOf(k) });
      AppMethodBeat.o(95619);
      return;
      localObject = localu.field_md5;
      break;
      label432:
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { localu.field_adsession });
    }
  }
  
  private void a(ffm paramffm, String paramString)
  {
    AppMethodBeat.i(95620);
    ap.a("@__weixintimtline", this.sourceType, paramffm.YMT, paramString);
    this.Qsh = ((SnsObject)paramffm.YMT.getLast()).Id;
    d.f("@__weixintimtline", ((SnsObject)paramffm.YMT.getFirst()).Id, this.Qsh, paramffm.abFi);
    paramffm = paramffm.YMT.iterator();
    label667:
    label704:
    while (paramffm.hasNext())
    {
      paramString = (SnsObject)paramffm.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = al.hgB().vj(paramString.Id);
        if ((localObject1 != null) && (((SnsInfo)localObject1).getTimeLine() != null))
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine().ContentObj.Zpr;
          Object localObject3;
          Object localObject4;
          if ((((SnsInfo)localObject1).isAd()) || (!bh.hoY()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (dmz)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                b((dmz)localObject4, bool);
                break;
              }
            }
          }
          else
          {
            localObject3 = ((SnsInfo)localObject1).getSnsId();
            if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
              break label338;
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((((SnsInfo)localObject1).getTypeFlag() != 15) || ((((SnsInfo)localObject1).isAd()) && (!b.p((SnsInfo)localObject1)))) {
                break label704;
              }
              al.hgz().I((SnsInfo)localObject1);
              try
              {
                localObject1 = ((dmz)((SnsInfo)localObject1).getTimeLine().ContentObj.Zpr.get(0)).Url;
                com.tencent.mm.plugin.report.service.h.OAn.b(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label338:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (dmz)((List)localObject2).get(0);
              Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((dmz)localObject2).vhJ) });
              b((dmz)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                dmz localdmz = (dmz)((List)localObject2).get(i);
                if (6 == localdmz.vhJ)
                {
                  Log.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localdmz.Id });
                  b(localdmz, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = t.d(localdmz);
                  String str = as.mg(al.getAccSnsPath(), localdmz.Id);
                  if ((y.ZC(str + (String)localObject5)) || (y.ZC(str + t.k(localdmz))) || (y.ZC(str + t.l(localdmz)))) {
                    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localdmz.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label667;
                    }
                    localObject5 = new com.tencent.mm.plugin.sns.data.p(localdmz);
                    ((com.tencent.mm.plugin.sns.data.p)localObject5).QnY = 0;
                    ((com.tencent.mm.plugin.sns.data.p)localObject5).hOG = localdmz.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localdmz);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                al.hgw().a((String)localObject3, (SparseArray)localObject4, localSparseArray, br.adjV, k, 1);
              }
            }
          }
        }
      }
    }
    al.hgz().hhy();
    AppMethodBeat.o(95620);
  }
  
  private static void b(dmz paramdmz, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (paramdmz == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = t.d(paramdmz);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = as.mg(al.getAccSnsPath(), paramdmz.Id);
      if ((!y.ZC((String)localObject2 + (String)localObject1)) && (!y.ZC((String)localObject2 + t.k(paramdmz))) && (!y.ZC((String)localObject2 + t.l(paramdmz)))) {
        break;
      }
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { paramdmz.Id });
      AppMethodBeat.o(95623);
      return;
    }
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { paramdmz.Id });
    localObject1 = new com.tencent.mm.plugin.sns.data.p(paramdmz);
    ((com.tencent.mm.plugin.sns.data.p)localObject1).QnY = i;
    ((com.tencent.mm.plugin.sns.data.p)localObject1).hOG = paramdmz.Id;
    Object localObject2 = al.hgw();
    i = j;
    if (paramdmz.vhJ == 6) {
      i = 5;
    }
    ((c)localObject2).b(paramdmz, i, (com.tencent.mm.plugin.sns.data.p)localObject1, br.adjV);
    AppMethodBeat.o(95623);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95622);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95622);
    return i;
  }
  
  public final int getType()
  {
    return 718;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95621);
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ffm localffm = (ffm)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      z.aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (localffm.abDz != null)
    {
      Log.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + localffm.abDz.abER + " " + localffm.abDz.abEQ);
      paramInt1 = localffm.abDz.abER;
      com.tencent.mm.plugin.sns.d.a.Qkq = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.d.a.Qkq = 2147483647;
      }
      com.tencent.mm.storage.as.acHp = localffm.abDz.abEQ;
      Tiger2022Helper.a(localffm.abDz);
    }
    this.Qsj = localffm.abDy;
    this.Qsk = localffm.IcW;
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + localffm.abDy + " , objCount:  " + localffm.aaWr + " controlFlag : " + localffm.IcW);
    this.bUo = localffm.aaWr;
    String str = t.uB(0L);
    if (!localffm.YMT.isEmpty())
    {
      paramArrayOfByte = new StringBuilder("resp size ").append(localffm.YMT.size()).append(", resp Max:").append(((SnsObject)localffm.YMT.getFirst()).Id).append(" ").append(t.uA(((SnsObject)localffm.YMT.getFirst()).Id)).append(", resp Min:").append(((SnsObject)localffm.YMT.getLast()).Id).append(" ").append(t.uA(((SnsObject)localffm.YMT.getLast()).Id)).append(", adListSize:");
      if (localffm.abFk == null) {}
      for (paramInt1 = 0;; paramInt1 = localffm.abFk.size())
      {
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        com.tencent.mm.plugin.sns.ad.d.g.c(localffm.abFo, localffm.abFn, 1);
        this.bUo = localffm.aaWr;
        if (!this.QsM.equals(localffm.abDu)) {
          break;
        }
        this.Qsh = al.hgB().h(0L, this.Qsj, true);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.Qsh) });
        z.aYk("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
      }
    }
    paramArrayOfByte = new StringBuilder(" resp is Empty, adListSize:");
    if (localffm.abFk == null) {}
    for (paramInt1 = 0;; paramInt1 = localffm.abFk.size())
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
      break;
    }
    al.hgF().g("@__weixintimtline", localffm.abDu, com.tencent.mm.platformtools.w.a(localffm.abCX));
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + localffm.YMT.size() + " adsize : " + localffm.abFj);
    LinkedList localLinkedList = localffm.abFk;
    if ((localffm != null) && (localLinkedList != null) && (localLinkedList.size() > 0)) {
      f.gZK();
    }
    label841:
    long l2;
    synchronized (a.Qqy)
    {
      if (a.hfz() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "adDynamic, graySwitch=".concat(String.valueOf(bool)));
        if ((!bool) || (localLinkedList == null)) {
          break label841;
        }
        paramInt1 = 0;
        while (paramInt1 < localLinkedList.size())
        {
          Log.i("MicroMsg.NetSceneSnsPreTimeLine", "adDynamic, updateSuccess=".concat(String.valueOf(a.a((ef)localLinkedList.get(paramInt1)))));
          paramInt1 += 1;
        }
        Log.d("AdPassThroughInfoHelper", "NetSceneSnsPreTimeLine, resp AdvertiseList size is 0");
        break;
      }
      paramInt1 = 0;
      if (paramInt1 < localLinkedList.size())
      {
        ef localef = (ef)localLinkedList.get(paramInt1);
        Object localObject6 = new StringBuilder();
        if ((localef != null) && (localef.YGo != null)) {
          ((StringBuilder)localObject6).append(com.tencent.mm.platformtools.w.a(localef.YGo));
        }
        Object localObject4 = new StringBuilder();
        paramArrayOfByte = new StringBuilder();
        if ((localef != null) && (localef.YGn != null))
        {
          ((StringBuilder)localObject4).append(com.tencent.mm.platformtools.w.a(localef.YGn.abCT));
          paramArrayOfByte.append(com.tencent.mm.platformtools.w.b(localef.YGn.abCS.ObjectDesc));
        }
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject6).toString());
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject4).toString());
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + paramArrayOfByte.toString() + "\r\n");
        long l3 = 0L;
        Object localObject1 = "";
        l2 = l3;
        paramArrayOfByte = (byte[])localObject1;
        try
        {
          localObject6 = ((StringBuilder)localObject6).toString();
          l2 = l3;
          paramArrayOfByte = (byte[])localObject1;
          localObject4 = ((StringBuilder)localObject4).toString();
          l1 = l3;
          localObject1 = localObject4;
          l2 = l3;
          paramArrayOfByte = (byte[])localObject4;
          if (!Util.isNullOrNil(new String[] { localObject6, localObject4 }))
          {
            l1 = l3;
            if (localef != null)
            {
              l1 = l3;
              l2 = l3;
              paramArrayOfByte = (byte[])localObject4;
              if (localef.YGn != null)
              {
                l1 = l3;
                l2 = l3;
                paramArrayOfByte = (byte[])localObject4;
                if (localef.YGn.abCS != null)
                {
                  l2 = l3;
                  paramArrayOfByte = (byte[])localObject4;
                  l1 = Util.nullAsNil(Long.valueOf(localef.YGn.abCS.Id));
                }
              }
            }
            l2 = l1;
            paramArrayOfByte = (byte[])localObject4;
            k.g(l1, (String)localObject6, (String)localObject4);
            localObject1 = localObject4;
          }
        }
        finally
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localObject2.toString());
            long l1 = l2;
            localObject3 = paramArrayOfByte;
          }
        }
        paramArrayOfByte = localef.YGn.abCS.Username;
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          bool = com.tencent.mm.plugin.sns.data.m.aXg((String)localObject1);
          Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + paramArrayOfByte + ", isUsePreferedInfo=" + bool + ", snsId=" + t.uB(l1));
          if (!bool)
          {
            az.a.okP.aZ(paramArrayOfByte, "");
            com.tencent.threadpool.h.ahAA.p(new u.1(this, paramArrayOfByte), 10000L);
          }
        }
        com.tencent.mm.plugin.sns.ad.timeline.helper.h.a(localef, 4);
        paramInt1 += 1;
      }
    }
    a.a(localLinkedList, localffm.YMT, false, -1);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.g(localLinkedList, false);
    if (localffm.abFj == 0)
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(localffm.abFl) });
      a.g(localffm.abFm, localffm.YMT);
      a.bR(localffm.abFm);
    }
    paramArrayOfByte = new LinkedList();
    Object localObject3 = localffm.YMT.iterator();
    while (((Iterator)localObject3).hasNext()) {
      paramArrayOfByte.add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
    }
    localObject3 = new zf();
    ((zf)localObject3).ics.ict = paramArrayOfByte;
    ((zf)localObject3).publish();
    if (params.getRespObj().getRetCode() == 207)
    {
      if (localffm.YMT.isEmpty()) {
        al.hgB().hkW();
      }
      for (;;)
      {
        z.aYk("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        al.hgB().bab(t.uB(((SnsObject)localffm.YMT.getFirst()).Id));
        al.hgB().baa(t.uB(((SnsObject)localffm.YMT.getLast()).Id));
        a(localffm, str);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bV(localffm.YMT);
      }
    }
    if (localffm.YMT.isEmpty()) {
      al.hgB().hkW();
    }
    for (;;)
    {
      z.aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(localffm, str);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bV(localffm.YMT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */