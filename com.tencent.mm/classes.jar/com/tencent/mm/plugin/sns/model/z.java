package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Vector;

public final class z
  extends com.tencent.mm.ak.n
  implements k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> xSz;
  public g callback;
  private boolean dfZ;
  private com.tencent.mm.ak.b rr;
  private int sourceType;
  String userName;
  private String xRS;
  private boolean xRn;
  private long xRo;
  long xRp;
  public int xRr;
  private int xSA;
  private boolean xSB;
  private String xSC;
  public long xSD;
  private boolean xSE;
  private boolean xSF;
  private boolean xSG;
  public long xSH;
  public int xSI;
  public int xSJ;
  private long xSk;
  private boolean xSn;
  
  static
  {
    AppMethodBeat.i(95688);
    xSz = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public z(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(160650);
    this.xSk = 0L;
    this.xRo = 0L;
    this.xRp = 0L;
    this.xSA = 0;
    this.xSB = false;
    this.xRS = "";
    this.xSC = "";
    this.xSD = 0L;
    this.xSE = false;
    this.xSF = false;
    this.xSn = false;
    this.xSG = false;
    this.xRr = 0;
    this.xSI = -1;
    this.xSJ = 0;
    this.userName = paramString;
    this.xRo = paramLong;
    this.dfZ = paramBoolean;
    this.xSI = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      ac.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.xSJ = paramInt5;
      localObject = new b.a();
      ((b.a)localObject).hvt = new dbu();
      ((b.a)localObject).hvu = new dbv();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).funcId = 212;
      ((b.a)localObject).reqCmdId = 99;
      ((b.a)localObject).respCmdId = 1000000099;
      this.rr = ((b.a)localObject).aAz();
      localObject = (dbu)this.rr.hvr.hvw;
      ((dbu)localObject).Username = paramString;
      ((dbu)localObject).FJn = paramLong;
      ((dbu)localObject).FLd = paramInt3;
      if (paramLong != 0L) {
        break label392;
      }
    }
    label392:
    for (boolean bool = true;; bool = false)
    {
      this.xRn = bool;
      if ((paramInt2 != at.xWN) && (paramInt2 != at.xWO) && (paramInt2 != at.xWM)) {
        break label398;
      }
      ((dbu)localObject).FKy = 0L;
      ((dbu)localObject).sVo = paramInt1;
      if (paramInt2 == at.xWN) {
        ((dbu)localObject).FKE = 1;
      }
      this.sourceType = 16;
      ac.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramLong), com.tencent.mm.plugin.sns.data.q.wW(this.xRp), Integer.valueOf(paramInt1), Integer.valueOf(((dbu)localObject).FKE) });
      this.xSk = paramLong;
      AppMethodBeat.o(160650);
      return;
      ac.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label398:
    paramInt2 = af.dHH().atV(paramString);
    com.tencent.mm.plugin.sns.storage.q localq = af.dHR();
    long l;
    if (this.xRn)
    {
      l = 0L;
      label422:
      this.xRp = localq.b(l, paramInt2, paramString, paramBoolean);
      ((dbu)localObject).FKy = this.xRp;
      paramInt3 = c.a(this.xRp, paramLong, paramString);
      ((dbu)localObject).FKz = paramInt3;
      ((dbu)localObject).sVo = paramInt1;
      if (this.xRn) {
        if (!dHr()) {
          break label605;
        }
      }
    }
    label605:
    for (this.xRS = af.dHV().auY(paramString).field_albumMd5;; this.xRS = af.dHV().auY(paramString).field_md5)
    {
      if (this.xRS == null) {
        this.xRS = "";
      }
      ((dbu)localObject).FJm = this.xRS;
      ac.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + com.tencent.mm.plugin.sns.data.q.wW(paramLong) + " minId:" + com.tencent.mm.plugin.sns.data.q.wW(this.xRp) + " lastReqTime:" + paramInt3 + " snsSource " + paramInt1);
      break;
      l = paramLong;
      break label422;
    }
  }
  
  private void a(dbv paramdbv, String paramString)
  {
    AppMethodBeat.i(95685);
    aj.b(this.userName, this.sourceType, paramdbv.DXh, paramString);
    if (this.xRo == 0L) {}
    for (this.xRo = ((SnsObject)paramdbv.DXh.getFirst()).Id;; this.xRo = c.xc(this.xRo))
    {
      this.xRp = ((SnsObject)paramdbv.DXh.getLast()).Id;
      ac.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.xRo), Long.valueOf(this.xRp), Integer.valueOf(paramdbv.FKH) });
      c.f(this.userName, this.xRo, this.xRp, paramdbv.FKH);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean atL(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 346
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/z:xSz	Ljava/util/Vector;
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
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/z:xSz	Ljava/util/Vector;
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
  
  public static boolean atM(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      xSz.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean dHr()
  {
    return this.sourceType == 64;
  }
  
  private void hh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = af.dHR();
    String str = this.userName;
    boolean bool = this.dfZ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(com.tencent.mm.plugin.sns.storage.q.bK(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.xSn = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.xSE = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final boolean dGa()
  {
    return this.xRn;
  }
  
  public final boolean dGb()
  {
    return (this.xSI == at.xWM) || (this.xSI == at.xWO) || (this.xSI == at.xWN);
  }
  
  public final int dGc()
  {
    return this.xSI;
  }
  
  public final boolean dGd()
  {
    return this.xSF;
  }
  
  public final boolean dGe()
  {
    return this.xSE;
  }
  
  public final boolean dGf()
  {
    return this.xSn;
  }
  
  public final boolean dGg()
  {
    return this.xSG;
  }
  
  public final long dGh()
  {
    return this.xRp;
  }
  
  public final boolean dGi()
  {
    return this.xSB;
  }
  
  public final long dGj()
  {
    return this.xSH;
  }
  
  public final String dGk()
  {
    return this.xSC;
  }
  
  public final boolean dGl()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(95687);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dbv localdbv = (dbv)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    boolean bool;
    if (this.xSI == -1)
    {
      if ((this.rr.hvs.getRetCode() != 207) && (this.rr.hvs.getRetCode() != 203) && (this.rr.hvs.getRetCode() != 0) && (this.rr.hvs.getRetCode() != 2001) && (this.rr.hvs.getRetCode() != 2004) && (this.rr.hvs.getRetCode() != 2005) && (this.rr.hvs.getRetCode() != 2003))
      {
        atM(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.hvs.getRetCode() == 2003)
      {
        paramq = af.dHR();
        paramArrayOfByte = this.userName;
        ac.m("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bs.aLh(paramArrayOfByte) + "\"";
        bool = paramq.db.execSQL("SnsInfo", str1);
        ac.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.xSC = localdbv.FLh;
      this.xRr = localdbv.FJq;
      ac.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdbv.FJq + " , objCount:  " + localdbv.Fli + ", retTips:" + this.xSC);
      this.xSH = localdbv.FLf;
      String str1 = com.tencent.mm.plugin.sns.data.q.wX(this.xRo);
      if (!this.xRn)
      {
        ac.d("MicroMsg.NetSceneSnsUserPage", "np  " + localdbv.DXh.size());
        if (localdbv.DXh.isEmpty()) {
          if (this.rr.hvs.getRetCode() == 203)
          {
            bool = true;
            this.xSG = bool;
            af.dHR().f(this.userName, this.dfZ, str1);
            this.xSE = true;
            this.xRp = this.xRo;
          }
        }
        for (;;)
        {
          atM(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(localdbv, str1);
        }
      }
      af.dHV().v(this.userName, localdbv.FJO);
      if (this.xRS.equals(localdbv.FJm))
      {
        paramq = af.dHR();
        if (this.xRn) {}
        for (long l = 0L;; l = this.xSk)
        {
          this.xRp = paramq.b(l, this.xRr, this.userName, this.dfZ);
          ac.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.xRp) });
          hh(paramInt2, paramInt3);
          atM(this.userName);
          paramq = af.dHV().auY(this.userName);
          this.callback.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      ac.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localdbv.DXh.size());
      if ((!this.xRn) || (this.xRS.equals(localdbv.FJm)))
      {
        if (!dHr()) {
          break label1297;
        }
        af.dHV().o(this.userName, localdbv.FJm, paramInt2, paramInt3);
        label822:
        if ((this.rr.hvs.getRetCode() != 207) && (this.rr.hvs.getRetCode() != 2001) && (this.rr.hvs.getRetCode() != 2004) && (this.rr.hvs.getRetCode() != 2005)) {
          break label1478;
        }
        af.dHV().jC(this.userName, "");
        if (!localdbv.DXh.isEmpty()) {
          break label1318;
        }
        paramq = af.dHR();
        paramArrayOfByte = this.userName;
        bool = this.dfZ;
        paramq.x(bool, com.tencent.mm.plugin.sns.storage.q.bK(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.xRp = this.xRo;
      }
      for (;;)
      {
        hh(paramInt2, paramInt3);
        atM(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.xSA = localdbv.FLe;
        paramq = af.dHV().auY(this.userName);
        paramq.field_icount = this.xSA;
        paramArrayOfByte = localdbv.Few;
        if (paramArrayOfByte != null)
        {
          localObject = com.tencent.mm.plugin.sns.data.q.wW(paramArrayOfByte.iKg);
          str2 = af.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((paramq.field_bgUrl == null) || (!paramq.field_bgId.equals(localObject)))
          {
            paramq.field_older_bgId = paramq.field_bgId;
            if (i.eA(an.jc(str2, this.userName) + str3))
            {
              i.deleteFile(an.jc(str2, this.userName) + str4);
              i.aT(an.jc(str2, this.userName), str3, str4);
            }
            this.xSB = true;
            paramq.dMi();
            ac.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.iKf);
          }
          paramq.field_bgId = ((String)localObject);
          paramq.field_bgUrl = paramArrayOfByte.iKf;
          paramq.field_snsBgId = paramArrayOfByte.iKg;
        }
        af.dHV().a(paramq);
        break;
        label1297:
        af.dHV().n(this.userName, localdbv.FJm, paramInt2, paramInt3);
        break label822;
        label1318:
        Object localObject = af.dHR();
        paramq = this.userName;
        bool = this.dfZ;
        String str2 = com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)localdbv.DXh.getFirst()).Id);
        paramArrayOfByte = com.tencent.mm.plugin.sns.storage.q.bK(paramq, bool) + " AND  (snsId != 0  ) ";
        paramq = paramArrayOfByte;
        if (com.tencent.mm.plugin.sns.storage.q.avd(str2)) {
          paramq = paramArrayOfByte + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject).avg(str2);
        }
        ((com.tencent.mm.plugin.sns.storage.q)localObject).x(bool, paramq);
        af.dHR().f(this.userName, this.dfZ, com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)localdbv.DXh.getLast()).Id));
        a(localdbv, str1);
      }
      label1478:
      if (localdbv.DXh.size() == 0)
      {
        ac.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      a(localdbv, str1);
      atM(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    if ((this.rr.hvs.getRetCode() != 207) && (this.rr.hvs.getRetCode() != 203) && (this.rr.hvs.getRetCode() != 0) && (this.rr.hvs.getRetCode() != 2001) && (this.rr.hvs.getRetCode() != 2004) && (this.rr.hvs.getRetCode() != 2005) && (this.rr.hvs.getRetCode() != 2003))
    {
      atM(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.xSC = localdbv.FLh;
    this.xRr = localdbv.FJq;
    ac.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdbv.FJq + " , objCount:  " + localdbv.Fli + ", retTips:" + this.xSC + ", prePageDayEndFlag:" + localdbv.FLi);
    this.xSH = localdbv.FLf;
    ac.d("MicroMsg.NetSceneSnsUserPage", "do search  " + localdbv.DXh.size());
    if (localdbv.DXh.size() == 0)
    {
      ac.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.hvs.getRetCode() == 203)
      {
        bool = true;
        this.xSG = bool;
        if (this.xSI != at.xWN) {
          break label1918;
        }
        this.xSF = true;
      }
      for (;;)
      {
        atM(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.xRp = this.xRo;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label1918:
        this.xSE = true;
      }
    }
    if (this.xSI == at.xWN) {
      if (localdbv.FLi) {
        this.xSD = ((SnsObject)localdbv.DXh.getFirst()).Id;
      }
    }
    for (;;)
    {
      paramq = com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)localdbv.DXh.getFirst()).Id);
      aj.b(this.userName, this.sourceType, localdbv.DXh, paramq);
      aj.j(localdbv.DXh, this.xSI);
      ac.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(aj.xRo), Long.valueOf(aj.xRp), Integer.valueOf(localdbv.FKH) });
      atM(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.xSI == at.xWM) {
        this.xSD = ((SnsObject)localdbv.DXh.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */