package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Vector;

public final class z
  extends com.tencent.mm.al.n
  implements k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> zit;
  public f callback;
  private boolean drv;
  private com.tencent.mm.al.b rr;
  private int sourceType;
  String userName;
  private String zhM;
  private boolean zhh;
  private long zhi;
  long zhj;
  public int zhl;
  private boolean ziA;
  public long ziB;
  public int ziC;
  public int ziD;
  private long zie;
  private boolean zih;
  private int ziu;
  private boolean ziv;
  private String ziw;
  public long zix;
  private boolean ziy;
  private boolean ziz;
  
  static
  {
    AppMethodBeat.i(95688);
    zit = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public z(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(160650);
    this.zie = 0L;
    this.zhi = 0L;
    this.zhj = 0L;
    this.ziu = 0;
    this.ziv = false;
    this.zhM = "";
    this.ziw = "";
    this.zix = 0L;
    this.ziy = false;
    this.ziz = false;
    this.zih = false;
    this.ziA = false;
    this.zhl = 0;
    this.ziC = -1;
    this.ziD = 0;
    this.userName = paramString;
    this.zhi = paramLong;
    this.drv = paramBoolean;
    this.ziC = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      ad.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.ziD = paramInt5;
      localObject = new b.a();
      ((b.a)localObject).hNM = new dhh();
      ((b.a)localObject).hNN = new dhi();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).funcId = 212;
      ((b.a)localObject).hNO = 99;
      ((b.a)localObject).respCmdId = 1000000099;
      this.rr = ((b.a)localObject).aDC();
      localObject = (dhh)this.rr.hNK.hNQ;
      ((dhh)localObject).Username = paramString;
      ((dhh)localObject).HtV = paramLong;
      ((dhh)localObject).HvL = paramInt3;
      if (paramLong != 0L) {
        break label392;
      }
    }
    label392:
    for (boolean bool = true;; bool = false)
    {
      this.zhh = bool;
      if ((paramInt2 != au.zmM) && (paramInt2 != au.zmN) && (paramInt2 != au.zmL)) {
        break label398;
      }
      ((dhh)localObject).Hvg = 0L;
      ((dhh)localObject).tRT = paramInt1;
      if (paramInt2 == au.zmM) {
        ((dhh)localObject).Hvm = 1;
      }
      this.sourceType = 16;
      ad.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramLong), com.tencent.mm.plugin.sns.data.q.zw(this.zhj), Integer.valueOf(paramInt1), Integer.valueOf(((dhh)localObject).Hvm) });
      this.zie = paramLong;
      AppMethodBeat.o(160650);
      return;
      ad.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label398:
    paramInt2 = ag.dTU().aza(paramString);
    com.tencent.mm.plugin.sns.storage.q localq = ag.dUe();
    long l;
    if (this.zhh)
    {
      l = 0L;
      label422:
      this.zhj = localq.b(l, paramInt2, paramString, paramBoolean);
      ((dhh)localObject).Hvg = this.zhj;
      paramInt3 = c.a(this.zhj, paramLong, paramString);
      ((dhh)localObject).Hvh = paramInt3;
      ((dhh)localObject).tRT = paramInt1;
      if (this.zhh) {
        if (!dTD()) {
          break label605;
        }
      }
    }
    label605:
    for (this.zhM = ag.dUi().aAf(paramString).field_albumMd5;; this.zhM = ag.dUi().aAf(paramString).field_md5)
    {
      if (this.zhM == null) {
        this.zhM = "";
      }
      ((dhh)localObject).HtU = this.zhM;
      ad.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + com.tencent.mm.plugin.sns.data.q.zw(paramLong) + " minId:" + com.tencent.mm.plugin.sns.data.q.zw(this.zhj) + " lastReqTime:" + paramInt3 + " snsSource " + paramInt1);
      break;
      l = paramLong;
      break label422;
    }
  }
  
  private void a(dhi paramdhi, String paramString)
  {
    AppMethodBeat.i(95685);
    ak.b(this.userName, this.sourceType, paramdhi.FCD, paramString);
    if (this.zhi == 0L) {}
    for (this.zhi = ((SnsObject)paramdhi.FCD.getFirst()).Id;; this.zhi = c.zB(this.zhi))
    {
      this.zhj = ((SnsObject)paramdhi.FCD.getLast()).Id;
      ad.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.zhi), Long.valueOf(this.zhj), Integer.valueOf(paramdhi.Hvp) });
      c.f(this.userName, this.zhi, this.zhj, paramdhi.Hvp);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean ayQ(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 346
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/z:zit	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 350	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 346
    //   24: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/z:zit	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 353	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 346
    //   45: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean ayR(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      zit.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean dTD()
  {
    return this.sourceType == 64;
  }
  
  private void hy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = ag.dUe();
    String str = this.userName;
    boolean bool = this.drv;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(com.tencent.mm.plugin.sns.storage.q.bR(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30,33) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.zih = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.ziy = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final boolean dSn()
  {
    return this.zhh;
  }
  
  public final boolean dSo()
  {
    return (this.ziC == au.zmL) || (this.ziC == au.zmN) || (this.ziC == au.zmM);
  }
  
  public final int dSp()
  {
    return this.ziC;
  }
  
  public final boolean dSq()
  {
    return this.ziz;
  }
  
  public final boolean dSr()
  {
    return this.ziy;
  }
  
  public final boolean dSs()
  {
    return this.zih;
  }
  
  public final boolean dSt()
  {
    return this.ziA;
  }
  
  public final long dSu()
  {
    return this.zhj;
  }
  
  public final boolean dSv()
  {
    return this.ziv;
  }
  
  public final long dSw()
  {
    return this.ziB;
  }
  
  public final String dSx()
  {
    return this.ziw;
  }
  
  public final boolean dSy()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(95687);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95687);
    return i;
  }
  
  public final int getType()
  {
    return 212;
  }
  
  public final String getUserName()
  {
    return this.userName;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95686);
    ad.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dhi localdhi = (dhi)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    boolean bool;
    if (this.ziC == -1)
    {
      if ((this.rr.hNL.getRetCode() != 207) && (this.rr.hNL.getRetCode() != 203) && (this.rr.hNL.getRetCode() != 0) && (this.rr.hNL.getRetCode() != 2001) && (this.rr.hNL.getRetCode() != 2004) && (this.rr.hNL.getRetCode() != 2005) && (this.rr.hNL.getRetCode() != 2003))
      {
        ayR(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.hNL.getRetCode() == 2003)
      {
        paramq = ag.dUe();
        paramArrayOfByte = this.userName;
        ad.m("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bt.aQN(paramArrayOfByte) + "\"";
        bool = paramq.db.execSQL("SnsInfo", str1);
        ad.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.ziw = localdhi.HvP;
      this.zhl = localdhi.HtY;
      ad.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdhi.HtY + " , objCount:  " + localdhi.GUQ + ", retTips:" + this.ziw);
      this.ziB = localdhi.HvN;
      String str1 = com.tencent.mm.plugin.sns.data.q.zx(this.zhi);
      if (!this.zhh)
      {
        ad.d("MicroMsg.NetSceneSnsUserPage", "np  " + localdhi.FCD.size());
        if (localdhi.FCD.isEmpty()) {
          if (this.rr.hNL.getRetCode() == 203)
          {
            bool = true;
            this.ziA = bool;
            ag.dUe().f(this.userName, this.drv, str1);
            this.ziy = true;
            this.zhj = this.zhi;
          }
        }
        for (;;)
        {
          ayR(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(localdhi, str1);
        }
      }
      ag.dUi().x(this.userName, localdhi.Huw);
      if (this.zhM.equals(localdhi.HtU))
      {
        paramq = ag.dUe();
        if (this.zhh) {}
        for (long l = 0L;; l = this.zie)
        {
          this.zhj = paramq.b(l, this.zhl, this.userName, this.drv);
          ad.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.zhj) });
          hy(paramInt2, paramInt3);
          ayR(this.userName);
          paramq = ag.dUi().aAf(this.userName);
          this.callback.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      ad.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localdhi.FCD.size());
      if ((!this.zhh) || (this.zhM.equals(localdhi.HtU)))
      {
        if (!dTD()) {
          break label1297;
        }
        ag.dUi().o(this.userName, localdhi.HtU, paramInt2, paramInt3);
        label822:
        if ((this.rr.hNL.getRetCode() != 207) && (this.rr.hNL.getRetCode() != 2001) && (this.rr.hNL.getRetCode() != 2004) && (this.rr.hNL.getRetCode() != 2005)) {
          break label1478;
        }
        ag.dUi().jP(this.userName, "");
        if (!localdhi.FCD.isEmpty()) {
          break label1318;
        }
        paramq = ag.dUe();
        paramArrayOfByte = this.userName;
        bool = this.drv;
        paramq.C(bool, com.tencent.mm.plugin.sns.storage.q.bR(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.zhj = this.zhi;
      }
      for (;;)
      {
        hy(paramInt2, paramInt3);
        ayR(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.ziu = localdhi.HvM;
        paramq = ag.dUi().aAf(this.userName);
        paramq.field_icount = this.ziu;
        paramArrayOfByte = localdhi.GOa;
        if (paramArrayOfByte != null)
        {
          localObject = com.tencent.mm.plugin.sns.data.q.zw(paramArrayOfByte.jdp);
          str2 = ag.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((paramq.field_bgUrl == null) || (!paramq.field_bgId.equals(localObject)))
          {
            paramq.field_older_bgId = paramq.field_bgId;
            if (i.fv(ao.jo(str2, this.userName) + str3))
            {
              i.deleteFile(ao.jo(str2, this.userName) + str4);
              i.bb(ao.jo(str2, this.userName), str3, str4);
            }
            this.ziv = true;
            paramq.dYy();
            ad.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.jdo);
          }
          paramq.field_bgId = ((String)localObject);
          paramq.field_bgUrl = paramArrayOfByte.jdo;
          paramq.field_snsBgId = paramArrayOfByte.jdp;
        }
        ag.dUi().a(paramq);
        break;
        label1297:
        ag.dUi().n(this.userName, localdhi.HtU, paramInt2, paramInt3);
        break label822;
        label1318:
        Object localObject = ag.dUe();
        paramq = this.userName;
        bool = this.drv;
        String str2 = com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localdhi.FCD.getFirst()).Id);
        paramArrayOfByte = com.tencent.mm.plugin.sns.storage.q.bR(paramq, bool) + " AND  (snsId != 0  ) ";
        paramq = paramArrayOfByte;
        if (com.tencent.mm.plugin.sns.storage.q.aAk(str2)) {
          paramq = paramArrayOfByte + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject).aAn(str2);
        }
        ((com.tencent.mm.plugin.sns.storage.q)localObject).C(bool, paramq);
        ag.dUe().f(this.userName, this.drv, com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localdhi.FCD.getLast()).Id));
        a(localdhi, str1);
      }
      label1478:
      if (localdhi.FCD.size() == 0)
      {
        ad.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      a(localdhi, str1);
      ayR(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    if ((this.rr.hNL.getRetCode() != 207) && (this.rr.hNL.getRetCode() != 203) && (this.rr.hNL.getRetCode() != 0) && (this.rr.hNL.getRetCode() != 2001) && (this.rr.hNL.getRetCode() != 2004) && (this.rr.hNL.getRetCode() != 2005) && (this.rr.hNL.getRetCode() != 2003))
    {
      ayR(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.ziw = localdhi.HvP;
    this.zhl = localdhi.HtY;
    ad.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdhi.HtY + " , objCount:  " + localdhi.GUQ + ", retTips:" + this.ziw + ", prePageDayEndFlag:" + localdhi.HvQ);
    this.ziB = localdhi.HvN;
    ad.d("MicroMsg.NetSceneSnsUserPage", "do search  " + localdhi.FCD.size());
    if (localdhi.FCD.size() == 0)
    {
      ad.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.hNL.getRetCode() == 203)
      {
        bool = true;
        this.ziA = bool;
        if (this.ziC != au.zmM) {
          break label1918;
        }
        this.ziz = true;
      }
      for (;;)
      {
        ayR(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.zhj = this.zhi;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label1918:
        this.ziy = true;
      }
    }
    if (this.ziC == au.zmM) {
      if (localdhi.HvQ) {
        this.zix = ((SnsObject)localdhi.FCD.getFirst()).Id;
      }
    }
    for (;;)
    {
      paramq = com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localdhi.FCD.getFirst()).Id);
      ak.b(this.userName, this.sourceType, localdhi.FCD, paramq);
      ak.j(localdhi.FCD, this.ziC);
      ad.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(ak.zhi), Long.valueOf(ak.zhj), Integer.valueOf(localdhi.Hvp) });
      ayR(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.ziC == au.zmL) {
        this.zix = ((SnsObject)localdhi.FCD.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */