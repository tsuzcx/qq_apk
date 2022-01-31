package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class y
  extends com.tencent.mm.ai.m
  implements k, d
{
  private static Vector<String> rez;
  public int ZY;
  public com.tencent.mm.ai.f callback;
  final int cpG;
  private boolean fOd;
  public int reA;
  public int reB;
  private long reZ;
  public boolean rew;
  private long rex;
  long rey;
  private String rfa;
  private long rfs;
  private boolean rft;
  private boolean rfu;
  private com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(36344);
    rez = new Vector();
    AppMethodBeat.o(36344);
  }
  
  public y(long paramLong)
  {
    AppMethodBeat.i(36338);
    this.fOd = false;
    this.rfs = 0L;
    this.rex = 0L;
    this.rey = 0L;
    this.reZ = 0L;
    this.rfa = "";
    this.rft = false;
    this.rfu = false;
    this.reA = 0;
    this.reB = 0;
    this.ZY = 0;
    long l2 = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cfe();
    ((b.a)localObject).fsY = new cff();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
    ((b.a)localObject).funcId = 211;
    ((b.a)localObject).reqCmdId = 98;
    ((b.a)localObject).respCmdId = 1000000098;
    this.rr = ((b.a)localObject).ado();
    int i;
    if (at.isWifi(ah.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.rex = paramLong;
      boolean bool;
      label166:
      cfe localcfe;
      int j;
      long l1;
      label227:
      int k;
      com.tencent.mm.plugin.sns.storage.l locall;
      if (paramLong == 0L)
      {
        bool = true;
        this.rew = bool;
        this.cpG = 2;
        localcfe = (cfe)this.rr.fsV.fta;
        localcfe.xNQ = i;
        localcfe.xOl = paramLong;
        j = ag.coV().cpD();
        localObject = ag.cpf();
        if (!this.rew) {
          break label588;
        }
        l1 = 0L;
        this.rey = ((o)localObject).g(l1, j, true);
        localcfe.xPt = this.rey;
        k = c.a(this.rey, paramLong, "@__weixintimtline");
        localcfe.xPu = k;
        locall = ag.cpj().abz("@__weixintimtline");
        if (this.rew)
        {
          this.reZ = ag.cpf().g(0L, 1, true);
          ab.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.reZ);
          localcfe.xPv = this.reZ;
          if (locall != null) {
            break label594;
          }
          localObject = "";
          label341:
          this.rfa = ((String)localObject);
          if (this.rfa == null) {
            this.rfa = "";
          }
          localcfe.xOk = this.rfa;
        }
        if ((locall != null) && (locall.field_adsession != null)) {
          break label604;
        }
      }
      for (localcfe.xNO = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localcfe.xNO = new SKBuiltinBuffer_t().setBuffer(locall.field_adsession))
      {
        this.rfs = paramLong;
        ab.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + j + " max:" + paramLong + " min:" + this.rey + " ReqTime:" + localcfe.xPu + " nettype: " + i);
        ab.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[] { i.lq(paramLong), i.lq(this.rey), Integer.valueOf(k) });
        ab.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        AppMethodBeat.o(36338);
        return;
        if (at.is3G(ah.getContext()))
        {
          i = 3;
          break;
        }
        if (at.is4G(ah.getContext()))
        {
          i = 4;
          break;
        }
        if (!at.is2G(ah.getContext())) {
          break label647;
        }
        i = 2;
        break;
        bool = false;
        break label166;
        label588:
        l1 = paramLong;
        break label227;
        label594:
        localObject = locall.field_md5;
        break label341;
        label604:
        ab.i("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
      }
      label647:
      i = 0;
    }
  }
  
  private void a(cff paramcff, String paramString)
  {
    AppMethodBeat.i(36340);
    ak.b("@__weixintimtline", this.cpG, paramcff.wuP, paramString);
    this.rey = ((SnsObject)paramcff.wuP.getLast()).Id;
    if (this.rex == 0L) {
      this.rex = ((SnsObject)paramcff.wuP.getFirst()).Id;
    }
    for (;;)
    {
      c.f("@__weixintimtline", this.rex, this.rey, paramcff.xPz);
      try
      {
        paramcff = paramcff.wuP.iterator();
        for (;;)
        {
          if (paramcff.hasNext())
          {
            paramString = (SnsObject)paramcff.next();
            if (paramString.NoChange == 0)
            {
              Object localObject = ag.cpf().lZ(paramString.Id);
              if ((localObject != null) && (((n)localObject).csh() != null))
              {
                int i = ((n)localObject).field_type;
                if (i == 15)
                {
                  try
                  {
                    localObject = ((bcs)((n)localObject).csh().xTS.wOa.get(0)).Url;
                    h.qsU.e(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject, Integer.valueOf(0) });
                  }
                  catch (Exception paramString) {}
                  continue;
                  this.rex = c.lw(this.rex);
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(36340);
        return;
      }
      catch (Exception paramcff)
      {
        AppMethodBeat.o(36340);
      }
    }
  }
  
  /* Error */
  public static boolean aan(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 406
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 48	com/tencent/mm/plugin/sns/model/y:rez	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 410	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 406
    //   24: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 48	com/tencent/mm/plugin/sns/model/y:rez	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 413	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 406
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aao(String paramString)
  {
    try
    {
      AppMethodBeat.i(36337);
      rez.remove(paramString);
      AppMethodBeat.o(36337);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static boolean c(cy paramcy)
  {
    AppMethodBeat.i(36342);
    if (!at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(36342);
      return false;
    }
    try
    {
      com.tencent.mm.modelsns.e.uA(aa.b(paramcy.wpl.xNM.ObjectDesc));
      ag.cpa();
      AppMethodBeat.o(36342);
      return true;
    }
    catch (Exception paramcy)
    {
      AppMethodBeat.o(36342);
    }
    return false;
  }
  
  private void coD()
  {
    AppMethodBeat.i(36339);
    Object localObject = ag.cpf();
    String str = o.ctb();
    localObject = ((o)localObject).db.a(str, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext()) {
      i += 1;
    }
    ((Cursor)localObject).close();
    if ((i < 3) && (i > 0))
    {
      this.rfu = true;
      AppMethodBeat.o(36339);
      return;
    }
    if (i == 0) {
      this.rft = true;
    }
    AppMethodBeat.o(36339);
  }
  
  public final boolean con()
  {
    return this.rew;
  }
  
  public final boolean coo()
  {
    return this.rft;
  }
  
  public final boolean cop()
  {
    return this.rfu;
  }
  
  public final boolean coq()
  {
    return false;
  }
  
  public final long cor()
  {
    return this.rey;
  }
  
  public final boolean cos()
  {
    return false;
  }
  
  public final long cot()
  {
    return 0L;
  }
  
  public final String cou()
  {
    return "";
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36343);
    this.callback = paramf;
    paramf = (cfe)this.rr.fsV.fta;
    LinkedList localLinkedList = com.tencent.mm.plugin.sns.i.e.roN.cqh();
    if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
    {
      paramf.xPx = localLinkedList;
      paramf.xPw = paramf.xPx.size();
      ab.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", new Object[] { localLinkedList });
    }
    for (;;)
    {
      paramf.xPy = g.RL().Ru().getInt(ac.a.yLj, 0);
      g.RL().Ru().set(ac.a.yLj, Integer.valueOf(0));
      ab.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", new Object[] { Integer.valueOf(paramf.xPw), Integer.valueOf(paramf.xPy) });
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(36343);
      return i;
      paramf.xPw = 0;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36341);
    ab.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (cff)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      aao("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36341);
      return;
    }
    if (paramArrayOfByte.xOq != null)
    {
      ab.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + paramArrayOfByte.xOq.xPp + " " + paramArrayOfByte.xOq.xPo);
      paramInt1 = paramArrayOfByte.xOq.xPp;
      com.tencent.mm.plugin.sns.c.a.raX = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.raX = 2147483647;
      }
      com.tencent.mm.storage.ab.yxn = paramArrayOfByte.xOq.xPo;
    }
    this.reA = paramArrayOfByte.xOo;
    this.reB = paramArrayOfByte.xOp;
    ab.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + paramArrayOfByte.xOo + " , objCount:  " + paramArrayOfByte.xtO + " cflag : " + paramArrayOfByte.xOp);
    this.ZY = paramArrayOfByte.xtO;
    String str1 = i.lr(this.rex);
    Object localObject1;
    label537:
    long l;
    Object localObject2;
    if (!paramArrayOfByte.wuP.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramArrayOfByte.wuP.size()).append(" Max ").append(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id).append(" ").append(i.lq(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramArrayOfByte.wuP.getLast()).Id).append(" ").append(i.lq(((SnsObject)paramArrayOfByte.wuP.getLast()).Id)).append(" adCount=");
      if (paramArrayOfByte.xPB == null)
      {
        paramInt1 = 0;
        ab.i("MicroMsg.NetSceneSnsTimeLine", paramInt1);
        if (paramArrayOfByte.xPE <= 0) {
          break label783;
        }
        ab.i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramArrayOfByte.xPE) });
        if ((paramArrayOfByte.xPF == null) || (paramArrayOfByte.xPF.size() != paramArrayOfByte.xPE)) {
          break label783;
        }
        localObject1 = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 >= paramArrayOfByte.xPE) {
          break label751;
        }
        l = ((wj)paramArrayOfByte.xPF.get(paramInt1)).Id;
        ab.i("MicroMsg.NetSceneSnsTimeLine", "delete ad %s", new Object[] { Long.valueOf(l) });
        if (l != 0L)
        {
          localObject2 = ag.cpi().lQ(l);
          if (localObject2 != null) {
            break label683;
          }
          ab.i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label683:
    Object localObject4;
    for (;;)
    {
      paramInt1 += 1;
      break label537;
      paramInt1 = paramArrayOfByte.xPB.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramArrayOfByte.xPB == null) {}
      for (paramInt1 = 0;; paramInt1 = paramArrayOfByte.xPB.size())
      {
        ab.i("MicroMsg.NetSceneSnsTimeLine", paramInt1);
        break;
      }
      localObject4 = new bp();
      ((bp)localObject4).wog = 13298;
      ((bp)localObject4).woh = new com.tencent.mm.bv.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).csd().cFe.getBytes());
      ((bp)localObject4).woi = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.lt(l);
    }
    label751:
    if (((LinkedList)localObject1).size() > 0)
    {
      g.RM();
      g.RK().eHt.a(new l((LinkedList)localObject1), 0);
    }
    label783:
    if (this.rfa.equals(paramArrayOfByte.xOk))
    {
      paramq = ag.cpf();
      if (this.rew) {}
      for (l = 0L;; l = this.rfs)
      {
        this.rey = paramq.g(l, this.reA, true);
        ab.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.rey) });
        coD();
        aao("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36341);
        return;
      }
    }
    ag.cpj().h("@__weixintimtline", paramArrayOfByte.xOk, aa.a(paramArrayOfByte.xNO));
    ab.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + paramArrayOfByte.wuP.size() + " adsize : " + paramArrayOfByte.xPA);
    paramInt1 = 0;
    String str2;
    for (;;)
    {
      if (paramInt1 < paramArrayOfByte.xPB.size())
      {
        localObject1 = (cy)paramArrayOfByte.xPB.get(paramInt1);
        if (this.fOd) {
          localObject2 = ag.getAccPath() + "ad.proto";
        }
        try
        {
          localObject4 = ((cy)localObject1).toByteArray();
          com.tencent.mm.vfs.e.b((String)localObject2, (byte[])localObject4, localObject4.length);
          localObject2 = aa.a(((cy)localObject1).wpm);
          localObject4 = aa.a(((cy)localObject1).wpl.xNN);
          str2 = aa.b(((cy)localObject1).wpl.xNM.ObjectDesc);
          ab.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject2)));
          ab.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
          ab.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
          localObject1 = ((cy)localObject1).wpl.xNM.Username;
          if (!bo.isNullOrNil((String)localObject1))
          {
            ab.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject1)));
            ao.a.flI.am((String)localObject1, "");
            com.tencent.mm.sdk.g.d.ysm.r(new y.1(this, (String)localObject1), 10000L);
          }
          paramInt1 += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.e("MicroMsg.NetSceneSnsTimeLine", "save error " + localException2.getMessage());
          }
        }
      }
    }
    if ((this.fOd) && (paramArrayOfByte.xPB.size() == 0)) {}
    try
    {
      localObject1 = com.tencent.mm.vfs.e.i(ag.getAccPath() + "ad.proto", 0, -1);
      localObject3 = new cy();
      ((cy)localObject3).parseFrom((byte[])localObject1);
      paramArrayOfByte.xPB.add(localObject3);
      paramArrayOfByte.xPA = paramArrayOfByte.xPB.size();
      ab.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + paramArrayOfByte.xPA);
      if (paramArrayOfByte.xPB.size() > 0)
      {
        localObject1 = (cy)paramArrayOfByte.xPB.get(0);
        localObject3 = aa.a(((cy)localObject1).wpm);
        localObject4 = aa.a(((cy)localObject1).wpl.xNN);
        str2 = aa.b(((cy)localObject1).wpl.xNM.ObjectDesc);
        ab.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(localObject3)));
        ab.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(localObject4)));
        ab.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + str2 + "\r\n");
        c((cy)localObject1);
      }
      a.l(paramArrayOfByte.xPB, paramArrayOfByte.wuP);
      a.as(paramArrayOfByte.xPB);
      if (paramArrayOfByte.xPA == 0)
      {
        ab.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.xPC) });
        a.e(paramArrayOfByte.xPD, paramArrayOfByte.wuP);
        a.ar(paramArrayOfByte.xPD);
      }
      if (!this.rew)
      {
        ab.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + paramArrayOfByte.wuP.size());
        if (paramArrayOfByte.wuP.isEmpty())
        {
          ag.cpf().abA(str1);
          this.rft = true;
          this.rey = this.rex;
          aao("@__weixintimtline");
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(36341);
          return;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneSnsTimeLine", "read error " + localException1.getMessage());
        continue;
        a(paramArrayOfByte, str1);
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = paramArrayOfByte.wuP.iterator();
      while (((Iterator)localObject3).hasNext()) {
        localLinkedList.add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
      }
      localObject3 = new sg();
      ((sg)localObject3).cIA.cIB = localLinkedList;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
      if (paramq.getRespObj().getRetCode() == 207)
      {
        if (paramArrayOfByte.wuP.isEmpty())
        {
          ag.cpf().csX();
          this.rey = this.rex;
        }
        for (;;)
        {
          this.rft = true;
          aao("@__weixintimtline");
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(36341);
          return;
          ag.cpf().abB(i.lr(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id));
          ag.cpf().abA(i.lr(((SnsObject)paramArrayOfByte.wuP.getLast()).Id));
          a(paramArrayOfByte, str1);
          a.at(paramArrayOfByte.wuP);
        }
      }
      if (!paramArrayOfByte.wuP.isEmpty()) {
        break label1973;
      }
    }
    ag.cpf().csX();
    this.rey = this.rex;
    this.rft = true;
    for (;;)
    {
      aao("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36341);
      return;
      label1973:
      a(paramArrayOfByte, str1);
      a.at(paramArrayOfByte.wuP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */