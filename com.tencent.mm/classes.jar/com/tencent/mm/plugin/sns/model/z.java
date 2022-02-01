package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.zf;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.l;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ae;
import com.tencent.mm.plugin.sns.storage.af;
import com.tencent.mm.plugin.sns.storage.ag;
import com.tencent.mm.plugin.sns.storage.ah;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
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
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.protocal.protobuf.fna;
import com.tencent.mm.protocal.protobuf.gdo;
import com.tencent.mm.protocal.protobuf.gio;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class z
  extends p
  implements com.tencent.mm.network.m, com.tencent.mm.plugin.sns.c.b
{
  private static Vector<String> Qsi;
  private long QsL;
  private String QsM;
  public boolean Qsg;
  long Qsh;
  public int Qsj;
  public int Qsk;
  private long Qte;
  private final long Qtf;
  private boolean Qtg;
  private boolean Qth;
  private boolean Qti;
  private ag Qtj;
  public int bUo;
  public com.tencent.mm.am.h callback;
  long maxId;
  public int pullType;
  com.tencent.mm.am.c rr;
  final int sourceType;
  
  static
  {
    AppMethodBeat.i(95670);
    Qsi = new Vector();
    AppMethodBeat.o(95670);
  }
  
  public z(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(179086);
    this.Qte = 0L;
    this.maxId = 0L;
    this.Qsh = 0L;
    this.QsL = 0L;
    this.Qtf = 102400L;
    this.QsM = "";
    this.Qtg = false;
    this.Qth = false;
    this.Qsj = 0;
    this.Qsk = 0;
    this.bUo = 0;
    this.pullType = 0;
    this.Qti = false;
    this.Qtj = null;
    long l3 = System.currentTimeMillis();
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = new ffl();
    ((com.tencent.mm.am.c.a)localObject1).otF = new ffm();
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 211;
    ((com.tencent.mm.am.c.a)localObject1).otG = 98;
    ((com.tencent.mm.am.c.a)localObject1).respCmdId = 1000000098;
    this.rr = ((com.tencent.mm.am.c.a)localObject1).bEF();
    int j = t.aPK();
    this.maxId = paramLong1;
    boolean bool;
    ffl localffl;
    int k;
    long l1;
    label245:
    int m;
    Object localObject2;
    label410:
    int i;
    if ((paramLong1 == 0L) && (paramLong2 == 0L))
    {
      bool = true;
      this.Qsg = bool;
      this.sourceType = 2;
      localffl = (ffl)c.b.b(this.rr.otB);
      localffl.abCZ = j;
      localffl.abDv = paramLong1;
      k = al.hgr().hhi();
      localObject1 = al.hgB();
      if (!this.Qsg) {
        break label979;
      }
      l1 = 0L;
      this.Qsh = ((com.tencent.mm.plugin.sns.storage.w)localObject1).h(l1, k, true);
      localffl.abEV = this.Qsh;
      m = d.b(this.Qsh, paramLong1, "@__weixintimtline");
      localffl.abEW = m;
      localffl.abFc = paramLong2;
      if (!this.Qsg) {
        break label985;
      }
      localObject1 = al.hgN();
      long l2 = ((ax)localObject1).QxY;
      l1 = l2;
      if (((ax)localObject1).QxU != null)
      {
        l1 = l2;
        if (!Util.isNullOrNil(((ax)localObject1).QxU.QCM))
        {
          localObject1 = ((ax)localObject1).QxU.QCM.iterator();
          do
          {
            l1 = l2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (l)((Iterator)localObject1).next();
          } while (Util.isNullOrNil(((l)localObject2).Adz));
          l1 = ((Long)((l)localObject2).Adz.peekLast()).longValue() - 1L;
        }
      }
      localffl.abFd = l1;
      if (paramInt != 1) {
        break label991;
      }
      i = 1;
      label426:
      localffl.abFb = i;
      this.pullType = paramInt;
      Object localObject3 = al.hgK();
      localObject1 = null;
      localObject2 = null;
      String str = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + ah.QZC + " order by SnsWsFoldGroup.top desc limit 1";
      localObject3 = ((ah)localObject3).omV.rawQuery(str, null, 2);
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = new ag();
          ((ag)localObject1).convertFrom((Cursor)localObject3);
        }
        ((Cursor)localObject3).close();
      }
      this.Qtj = ((ag)localObject1);
      if (this.Qtj != null) {
        break label997;
      }
      localffl.abFe = 0L;
      localffl.abFg = 0L;
      label558:
      localffl.abFf = aj.Quq;
      localObject2 = al.hgF().aZW("@__weixintimtline");
      if (this.Qsg)
      {
        this.QsL = al.hgB().h(0L, 1, true);
        Log.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.QsL);
        localffl.abEX = this.QsL;
        if (localObject2 != null) {
          break label1076;
        }
        localObject1 = "";
        label640:
        this.QsM = ((String)localObject1);
        if (this.QsM == null) {
          this.QsM = "";
        }
        localffl.abDu = this.QsM;
      }
      l1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfa, 102400L);
      if ((localObject2 != null) && (((u)localObject2).field_adsession != null) && (((u)localObject2).field_adsession.length <= l1)) {
        break label1086;
      }
    }
    for (localffl.abCX = new gol().df(new byte[0]);; localffl.abCX = new gol().df(((u)localObject2).field_adsession))
    {
      this.Qte = paramLong1;
      localffl.abFh = new gol().df(com.tencent.mm.plugin.sns.ad.d.f.gZJ());
      Log.i("MicroMsg.NetSceneSnsTimeLine", "This req nextCount: " + k + " max:" + paramLong1 + " min:" + this.Qsh + " ReqTime:" + localffl.abEW + " nettype: " + j + " MinIdForCheckUnread:" + localffl.abFd + " pullType:" + paramInt + " minIdForPrePage:" + paramLong2 + " NearbyFoldId:" + localffl.abFe + " FoldSectionSize：" + aj.Quq + " FirstPageMd5：" + localffl.abDu);
      Log.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { t.uA(paramLong1), t.uA(this.Qsh), Integer.valueOf(m) });
      Log.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine cost：%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
      AppMethodBeat.o(179086);
      return;
      bool = false;
      break;
      label979:
      l1 = paramLong1;
      break label245;
      label985:
      l1 = 0L;
      break label410;
      label991:
      i = 0;
      break label426;
      label997:
      Log.i("MicroMsg.NetSceneSnsTimeLine", "firstFinishWsGroup.size:%s, firstFinishWsGroup.top:%s, firstFinishWsGroup.bottom:%s", new Object[] { Integer.valueOf(this.Qtj.field_size), t.uB(this.Qtj.field_top), t.uB(this.Qtj.field_bottom) });
      localffl.abFe = this.Qtj.field_top;
      localffl.abFg = this.Qtj.field_top;
      break label558;
      label1076:
      localObject1 = ((u)localObject2).field_md5;
      break label640;
      label1086:
      Log.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { ((u)localObject2).field_adsession });
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ffm paramffm)
  {
    AppMethodBeat.i(309521);
    if (paramffm.YMT.size() == 0)
    {
      aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(309521);
      return;
    }
    Iterator localIterator = paramffm.YMT.iterator();
    while (localIterator.hasNext()) {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "preload unread sns.id:%s", new Object[] { Long.valueOf(((SnsObject)localIterator.next()).Id) });
    }
    a(paramffm, t.uB(this.maxId));
    aYk("@__weixintimtline");
    this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    AppMethodBeat.o(309521);
  }
  
  private static void a(ffm paramffm)
  {
    AppMethodBeat.i(309518);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramffm != null) {
      if (!Util.isNullOrNil(paramffm.YMT))
      {
        localObject1 = new ArrayList();
        localObject2 = paramffm.YMT.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SnsObject)((Iterator)localObject2).next();
          if ((localObject3 != null) && (ap.akH(((SnsObject)localObject3).ExtFlag))) {
            ((List)localObject1).add(Long.valueOf(((SnsObject)localObject3).Id));
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          al.hgL().vo(((Long)localObject2).longValue());
        }
      }
    }
    label694:
    label962:
    label975:
    label985:
    label994:
    label999:
    for (;;)
    {
      int k;
      int i;
      int j;
      try
      {
        localObject1 = new gio();
        ((gio)localObject1).parseFrom(com.tencent.mm.platformtools.w.a(paramffm.abFs));
        if (!Util.isNullOrNil(((gio)localObject1).aceX))
        {
          k = ((gio)localObject1).aceX.size() / aj.Quq;
          Log.i("MicroMsg.NetSceneSnsTimeLine", "wsInfo.timeline_idx.size:%s, SnsConfig.wsFoldGroupSize:%s, tmp:%s", new Object[] { Integer.valueOf(((gio)localObject1).aceX.size()), Integer.valueOf(aj.Quq), Integer.valueOf(k) });
          if (k != 0) {
            break label985;
          }
          paramffm = new ag();
          paramffm.field_top = ((fna)((gio)localObject1).aceX.getFirst()).Tqa;
          paramffm.field_bottom = ((fna)((gio)localObject1).aceX.getLast()).Tqa;
          paramffm.field_size = ((gio)localObject1).aceX.size();
          if (paramffm.field_size != aj.Quq) {
            break label694;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert topId:%s, bottomId:%s", new Object[] { t.uB(paramffm.field_top), t.uB(paramffm.field_bottom) });
          al.hgK().a(paramffm);
        }
        if (Util.isNullOrNil(((gio)localObject1).aceW)) {
          break label975;
        }
        paramffm = ((gio)localObject1).aceW.iterator();
        if (!paramffm.hasNext()) {
          break label975;
        }
        localObject1 = (gdo)paramffm.next();
        if ((localObject1 == null) || (Util.isNullOrNil(((gdo)localObject1).YMV)) || (((gdo)localObject1).acbv == null)) {
          continue;
        }
        long l = ((gdo)localObject1).acbt;
        i = ((gdo)localObject1).acbu;
        new SnsObject().parseFrom(((gdo)localObject1).acbv.toByteArray());
        localObject2 = new fgb();
        ((fgb)localObject2).abFY.addAll(((gdo)localObject1).YMV);
        localObject3 = o.Pm(new String(((gdo)localObject1).acbv.ObjectDesc.aaxD.toByteArray()));
        if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentDesc)) {
          break label962;
        }
        if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Zpr != null) && (((TimeLineObject)localObject3).ContentObj.Zpr.size() > 0) && (((TimeLineObject)localObject3).ContentObj.Zpr.getFirst() != null))
        {
          j = ((dmz)((TimeLineObject)localObject3).ContentObj.Zpr.getFirst()).vhJ;
          if (j != 2) {
            break label939;
          }
          ((fgb)localObject2).abFZ = MMApplicationContext.getContext().getString(b.j.sns_item_ws_fold_pic);
        }
        localObject3 = new ae();
        ((ae)localObject3).field_groupId = l;
        ((ae)localObject3).field_groupTime = i;
        ((ae)localObject3).field_groupStrcut = ((fgb)localObject2).toByteArray();
        al.hgL().a((ae)localObject3);
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(((gdo)localObject1).acbv);
        ap.a("@__weixintimtline", 128, (LinkedList)localObject2, t.uB(((gdo)localObject1).acbv.Id));
        continue;
        AppMethodBeat.o(309518);
      }
      catch (Exception paramffm)
      {
        Log.w("MicroMsg.NetSceneSnsTimeLine", "parse WSInfo err: %s", new Object[] { paramffm.getMessage() });
      }
      return;
      Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, field_size:%s", new Object[] { Integer.valueOf(paramffm.field_size) });
      continue;
      for (;;)
      {
        if (i >= k) {
          break label999;
        }
        int m = ((gio)localObject1).aceX.size() - 1 - aj.Quq * i;
        j = m - aj.Quq + 1;
        if (j < 0) {
          j = 0;
        }
        for (;;)
        {
          paramffm = new ag();
          paramffm.field_top = ((fna)((gio)localObject1).aceX.get(j)).Tqa;
          paramffm.field_bottom = ((fna)((gio)localObject1).aceX.get(m)).Tqa;
          paramffm.field_size = (m - j + 1);
          if (paramffm.field_size == aj.Quq)
          {
            Log.i("MicroMsg.NetSceneSnsTimeLine", "insert index:%s, topIndex:%s, bottomIndex:%s, topId:%s, bottomId:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), t.uB(paramffm.field_top), t.uB(paramffm.field_bottom) });
            al.hgK().a(paramffm);
            break label994;
          }
          Log.i("MicroMsg.NetSceneSnsTimeLine", "insert skipped, index:%s, topIndex:%s, bottomIndex:%s, field_size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(paramffm.field_size) });
          break label994;
          if (j != 6) {
            break;
          }
          ((fgb)localObject2).abFZ = MMApplicationContext.getContext().getString(b.j.sns_item_ws_fold_video);
          break;
          ((fgb)localObject2).abFZ = ((TimeLineObject)localObject3).ContentDesc;
          break;
          AppMethodBeat.o(309518);
          return;
        }
        if (k <= 0) {
          break;
        }
        i = 0;
        continue;
        i += 1;
      }
    }
  }
  
  private void a(ffm paramffm, String paramString)
  {
    AppMethodBeat.i(95666);
    ap.a("@__weixintimtline", this.sourceType, paramffm.YMT, paramString);
    this.Qsh = ((SnsObject)paramffm.YMT.getLast()).Id;
    if (this.maxId == 0L) {
      this.maxId = ((SnsObject)paramffm.YMT.getFirst()).Id;
    }
    for (;;)
    {
      d.f("@__weixintimtline", this.maxId, this.Qsh, paramffm.abFi);
      try
      {
        paramffm = paramffm.YMT.iterator();
        for (;;)
        {
          if (paramffm.hasNext())
          {
            paramString = (SnsObject)paramffm.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = al.hgB().vj(paramString.Id);
              if ((localObject != null) && (((SnsInfo)localObject).getTimeLine() != null))
              {
                int i = ((SnsInfo)localObject).getTypeFlag();
                if (i == 15)
                {
                  try
                  {
                    localObject = ((dmz)((SnsInfo)localObject).getTimeLine().ContentObj.Zpr.get(0)).Url;
                    com.tencent.mm.plugin.report.service.h.OAn.b(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.maxId = d.uE(this.maxId);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(95666);
        return;
      }
      catch (Exception paramffm)
      {
        AppMethodBeat.o(95666);
      }
    }
  }
  
  /* Error */
  public static boolean aYj(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 743
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 52	com/tencent/mm/plugin/sns/model/z:Qsi	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 746	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 743
    //   24: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 52	com/tencent/mm/plugin/sns/model/z:Qsi	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 747	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 743
    //   45: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -21 -> 27
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   20	22	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	19	51	finally
    //   21	27	51	finally
    //   32	40	51	finally
    //   42	48	51	finally
  }
  
  public static boolean aYk(String paramString)
  {
    try
    {
      AppMethodBeat.i(95663);
      Qsi.remove(paramString);
      AppMethodBeat.o(95663);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, ffm paramffm)
  {
    AppMethodBeat.i(179087);
    int i;
    if (paramffm.abDz != null)
    {
      Log.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramffm.abDz.abER + " " + paramffm.abDz.abEQ);
      i = paramffm.abDz.abER;
      com.tencent.mm.plugin.sns.d.a.Qkq = i;
      if (i <= 0) {
        com.tencent.mm.plugin.sns.d.a.Qkq = 2147483647;
      }
      com.tencent.mm.storage.as.acHp = paramffm.abDz.abEQ;
      Tiger2022Helper.a(paramffm.abDz);
    }
    this.Qsj = paramffm.abDy;
    this.Qsk = paramffm.IcW;
    Log.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramffm.abDy + " , objCount: " + paramffm.aaWr + ", controlFlag: " + paramffm.IcW);
    this.bUo = paramffm.aaWr;
    String str1 = t.uB(this.maxId);
    if (!paramffm.YMT.isEmpty())
    {
      ??? = new StringBuilder("resp size:").append(paramffm.YMT.size()).append(", resp Max:").append(((SnsObject)paramffm.YMT.getFirst()).Id).append(" ").append(t.uA(((SnsObject)paramffm.YMT.getFirst()).Id)).append(", resp Min:").append(((SnsObject)paramffm.YMT.getLast()).Id).append(" ").append(t.uA(((SnsObject)paramffm.YMT.getLast()).Id)).append(", adListSize:");
      if (paramffm.abFk == null)
      {
        i = 0;
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        com.tencent.mm.plugin.sns.ad.d.g.c(paramffm.abFo, paramffm.abFn, 0);
        if (!this.QsM.equals(paramffm.abDu)) {
          break label552;
        }
        paramffm = al.hgB();
        if (!this.Qsg) {
          break label543;
        }
      }
    }
    label543:
    for (long l1 = 0L;; l1 = this.Qte)
    {
      this.Qsh = paramffm.h(l1, this.Qsj, true);
      Log.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid:%s", new Object[] { Long.valueOf(this.Qsh) });
      hfP();
      aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(179087);
      return;
      i = paramffm.abFk.size();
      break;
      ??? = new StringBuilder("resp is Empty, adListSize:");
      if (paramffm.abFk == null) {}
      for (i = 0;; i = paramffm.abFk.size())
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", i);
        break;
      }
    }
    label552:
    if (!paramffm.YMT.isEmpty()) {
      al.hgF().g("@__weixintimtline", paramffm.abDu, com.tencent.mm.platformtools.w.a(paramffm.abCX));
    }
    Log.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramffm.YMT.size() + " adsize : " + paramffm.abFj);
    for (;;)
    {
      synchronized (a.Qqy)
      {
        if (a.hfz() != 1) {
          break label1706;
        }
        bool = true;
        Log.i("MicroMsg.NetSceneSnsTimeLine", "adDynamic, graySwitch=".concat(String.valueOf(bool)));
        if ((bool) && (paramffm.abFk != null))
        {
          i = 0;
          if (i < paramffm.abFk.size())
          {
            bool = a.a((ef)paramffm.abFk.get(i));
            Log.i("MicroMsg.NetSceneSnsTimeLine", "adDynamic, updateSuccess=".concat(String.valueOf(bool)));
            if (bool) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 0);
            } else {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 1);
            }
          }
        }
      }
      if ((paramffm != null) && (paramffm.abFk != null) && (paramffm.abFk.size() > 0))
      {
        com.tencent.mm.plugin.sns.ad.d.f.gZK();
        i = 0;
        long l2;
        for (;;)
        {
          if (i >= paramffm.abFk.size()) {
            break label1202;
          }
          localObject2 = (ef)paramffm.abFk.get(i);
          String str3 = com.tencent.mm.platformtools.w.a(((ef)localObject2).YGo);
          String str2 = com.tencent.mm.platformtools.w.a(((ef)localObject2).YGn.abCT);
          String str4 = com.tencent.mm.platformtools.w.b(((ef)localObject2).YGn.abCS.ObjectDesc);
          Log.d("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(str3)));
          Log.d("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
          Log.d("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str4 + "\r\n");
          long l3 = 0L;
          l1 = l3;
          l2 = l3;
          try
          {
            if (!Util.isNullOrNil(new String[] { str3, str2 }))
            {
              l1 = l3;
              l2 = l3;
              if (((ef)localObject2).YGn != null)
              {
                l1 = l3;
                l2 = l3;
                if (((ef)localObject2).YGn.abCS != null)
                {
                  l2 = l3;
                  l1 = Util.nullAsNil(Long.valueOf(((ef)localObject2).YGn.abCS.Id));
                }
              }
              l2 = l1;
              com.tencent.mm.plugin.sns.data.k.g(l1, str3, str2);
            }
          }
          finally
          {
            for (;;)
            {
              Log.e("MicroMsg.NetSceneSnsTimeLine", "reportAdPullException: " + localObject3.toString());
              l1 = l2;
            }
          }
          str3 = ((ef)localObject2).YGn.abCS.Username;
          if (!Util.isNullOrNil(str3))
          {
            bool = com.tencent.mm.plugin.sns.data.m.aXg(str2);
            Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:" + str3 + ", isUsePreferedInfo=" + bool + ", snsId=" + t.uB(l1));
            if (!bool)
            {
              az.a.okP.aZ(str3, "");
              com.tencent.threadpool.h.ahAA.p(new z.1(this, str3), 10000L);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.helper.h.a((ef)localObject2, 1);
          i += 1;
        }
        label1202:
        a.a(paramffm.abFk, paramffm.YMT, this.Qsg, this.pullType);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.g(paramffm.abFk, false);
        if (paramffm.abFj == 0)
        {
          Log.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramffm.abFl) });
          a.g(paramffm.abFm, paramffm.YMT);
          a.bR(paramffm.abFm);
        }
        if (this.Qsg) {
          break label1406;
        }
        Log.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramffm.YMT.size());
        if (!paramffm.YMT.isEmpty()) {
          break label1395;
        }
        al.hgB().baa(str1);
        this.Qtg = true;
        this.Qsh = this.maxId;
      }
      for (;;)
      {
        aYk("@__weixintimtline");
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
        AppMethodBeat.o(179087);
        return;
        Log.d("AdPassThroughInfoHelper", "NetSceneSnsTimeLine, resp AdvertiseList size is 0");
        break;
        label1395:
        a(paramffm, str1);
      }
      label1406:
      ??? = new LinkedList();
      Object localObject2 = paramffm.YMT.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)???).add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
      }
      localObject2 = new zf();
      ((zf)localObject2).ics.ict = ((LinkedList)???);
      ((zf)localObject2).publish();
      if (this.rr.otC.getRetCode() == 207)
      {
        if (paramffm.YMT.isEmpty())
        {
          al.hgB().hkW();
          this.Qsh = this.maxId;
        }
        for (;;)
        {
          this.Qtg = true;
          aYk("@__weixintimtline");
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(179087);
          return;
          al.hgB().bab(t.uB(((SnsObject)paramffm.YMT.getFirst()).Id));
          al.hgB().baa(t.uB(((SnsObject)paramffm.YMT.getLast()).Id));
          a(paramffm, str1);
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bV(paramffm.YMT);
        }
      }
      if (paramffm.YMT.isEmpty())
      {
        al.hgB().hkW();
        this.Qsh = this.maxId;
        this.Qtg = true;
      }
      for (;;)
      {
        aYk("@__weixintimtline");
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
        AppMethodBeat.o(179087);
        return;
        a(paramffm, str1);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bV(paramffm.YMT);
      }
      i += 1;
      continue;
      label1706:
      boolean bool = false;
    }
  }
  
  private void hfP()
  {
    AppMethodBeat.i(95665);
    Object localObject = al.hgB();
    String str = com.tencent.mm.plugin.sns.storage.w.hlc();
    localObject = ((com.tencent.mm.plugin.sns.storage.w)localObject).QYR.rawQuery(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 10) && (i > 0))
    {
      this.Qth = true;
      AppMethodBeat.o(95665);
      return;
    }
    if (i == 0) {
      this.Qtg = true;
    }
    AppMethodBeat.o(95665);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95669);
    this.callback = paramh;
    paramh = (ffl)c.b.b(this.rr.otB);
    LinkedList localLinkedList = j.QFS.him();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramh.abEZ = localLinkedList;
      paramh.abEY = paramh.abEZ.size();
      Log.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramh.abFa = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYi, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYi, Integer.valueOf(0));
      Log.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramh.abEY), Integer.valueOf(paramh.abFa) });
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(95669);
      return i;
      paramh.abEY = 0;
    }
  }
  
  public final int getType()
  {
    return 211;
  }
  
  public final String getUserName()
  {
    return "@__weixintimtline";
  }
  
  public final boolean hdR()
  {
    return this.Qsg;
  }
  
  public final boolean hdS()
  {
    return this.pullType == 1;
  }
  
  public final int hdT()
  {
    return -1;
  }
  
  public final boolean hdU()
  {
    return false;
  }
  
  public final boolean hdV()
  {
    return this.Qtg;
  }
  
  public final boolean hdW()
  {
    return this.Qth;
  }
  
  public final boolean hdX()
  {
    return false;
  }
  
  public final long hdY()
  {
    return this.Qsh;
  }
  
  public final boolean hdZ()
  {
    return false;
  }
  
  public final long hea()
  {
    return 0L;
  }
  
  public final String heb()
  {
    return "";
  }
  
  public final boolean hec()
  {
    return this.Qti;
  }
  
  public final boolean hfQ()
  {
    return this.pullType == 2;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95667);
    Log.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (ffm)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", false);
    if (this.Qsg)
    {
      if (paramArrayOfByte != null)
      {
        Log.i("MicroMsg.NetSceneSnsTimeLine", "updateUnreadNewId IdListForCheckUnread.size:%s ObjectList.size:%s", new Object[] { Integer.valueOf(paramArrayOfByte.abFq.size()), Integer.valueOf(paramArrayOfByte.YMT.size()) });
        params = al.hgN();
        LinkedList localLinkedList1 = paramArrayOfByte.abFq;
        LinkedList localLinkedList2 = paramArrayOfByte.YMT;
        LinkedList localLinkedList3 = paramArrayOfByte.abFr;
        al.fAG().post(new ax.3(params, localLinkedList1, localLinkedList2, localLinkedList3));
      }
      params = al.hgO();
      if (au.Qxe)
      {
        MMHandlerThread.removeRunnable(params.Qxk);
        params.hhm();
        params.reset();
      }
    }
    a(paramArrayOfByte);
    if (this.pullType == 1)
    {
      if (paramArrayOfByte.YMT.size() == 0)
      {
        this.Qti = true;
        aYk("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95667);
        return;
      }
      this.Qti = false;
      a(paramArrayOfByte, t.uB(((SnsObject)paramArrayOfByte.YMT.getFirst()).Id));
      aYk("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95667);
      return;
    }
    if (this.pullType == 2)
    {
      a(paramInt2, paramInt3, paramString, paramArrayOfByte);
      AppMethodBeat.o(95667);
      return;
    }
    b(paramInt2, paramInt3, paramString, paramArrayOfByte);
    AppMethodBeat.o(95667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */