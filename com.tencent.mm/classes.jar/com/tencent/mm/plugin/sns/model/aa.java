package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.Vector;

public final class aa
  extends com.tencent.mm.ak.n
  implements k, com.tencent.mm.plugin.sns.b.b
{
  private static Vector<String> zzI;
  public f callback;
  private boolean dsB;
  private com.tencent.mm.ak.b rr;
  private int sourceType;
  String userName;
  private boolean zxW;
  private long zxX;
  long zxY;
  private String zyB;
  private long zyT;
  private boolean zyW;
  public int zya;
  private int zzJ;
  private boolean zzK;
  private String zzL;
  public long zzM;
  private boolean zzN;
  private boolean zzO;
  private boolean zzP;
  public long zzQ;
  public int zzR;
  public int zzS;
  
  static
  {
    AppMethodBeat.i(95688);
    zzI = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public aa(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(160650);
    this.zyT = 0L;
    this.zxX = 0L;
    this.zxY = 0L;
    this.zzJ = 0;
    this.zzK = false;
    this.zyB = "";
    this.zzL = "";
    this.zzM = 0L;
    this.zzN = false;
    this.zzO = false;
    this.zyW = false;
    this.zzP = false;
    this.zya = 0;
    this.zzR = -1;
    this.zzS = 0;
    this.userName = paramString;
    this.zxX = paramLong;
    this.dsB = paramBoolean;
    this.zzR = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      ae.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.zzS = paramInt5;
      localObject = new b.a();
      ((b.a)localObject).hQF = new dib();
      ((b.a)localObject).hQG = new dic();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).funcId = 212;
      ((b.a)localObject).hQH = 99;
      ((b.a)localObject).respCmdId = 1000000099;
      this.rr = ((b.a)localObject).aDS();
      localObject = (dib)this.rr.hQD.hQJ;
      ((dib)localObject).Username = paramString;
      ((dib)localObject).HNy = paramLong;
      ((dib)localObject).HPo = paramInt3;
      if (paramLong != 0L) {
        break label392;
      }
    }
    label392:
    for (boolean bool = true;; bool = false)
    {
      this.zxW = bool;
      if ((paramInt2 != av.zEb) && (paramInt2 != av.zEc) && (paramInt2 != av.zEa)) {
        break label398;
      }
      ((dib)localObject).HOJ = 0L;
      ((dib)localObject).ucK = paramInt1;
      if (paramInt2 == av.zEb) {
        ((dib)localObject).HOP = 1;
      }
      this.sourceType = 16;
      ae.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { r.zV(paramLong), r.zV(this.zxY), Integer.valueOf(paramInt1), Integer.valueOf(((dib)localObject).HOP) });
      this.zyT = paramLong;
      AppMethodBeat.o(160650);
      return;
      ae.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label398:
    paramInt2 = ah.dXu().aAr(paramString);
    com.tencent.mm.plugin.sns.storage.q localq = ah.dXE();
    long l;
    if (this.zxW)
    {
      l = 0L;
      label422:
      this.zxY = localq.b(l, paramInt2, paramString, paramBoolean);
      ((dib)localObject).HOJ = this.zxY;
      paramInt3 = d.a(this.zxY, paramLong, paramString);
      ((dib)localObject).HOK = paramInt3;
      ((dib)localObject).ucK = paramInt1;
      if (this.zxW) {
        if (!dXd()) {
          break label605;
        }
      }
    }
    label605:
    for (this.zyB = ah.dXI().aBw(paramString).field_albumMd5;; this.zyB = ah.dXI().aBw(paramString).field_md5)
    {
      if (this.zyB == null) {
        this.zyB = "";
      }
      ((dib)localObject).HNx = this.zyB;
      ae.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + r.zV(paramLong) + " minId:" + r.zV(this.zxY) + " lastReqTime:" + paramInt3 + " snsSource " + paramInt1);
      break;
      l = paramLong;
      break label422;
    }
  }
  
  private void a(dic paramdic, String paramString)
  {
    AppMethodBeat.i(95685);
    al.b(this.userName, this.sourceType, paramdic.FUY, paramString);
    if (this.zxX == 0L) {}
    for (this.zxX = ((SnsObject)paramdic.FUY.getFirst()).Id;; this.zxX = d.zZ(this.zxX))
    {
      this.zxY = ((SnsObject)paramdic.FUY.getLast()).Id;
      ae.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.zxX), Long.valueOf(this.zxY), Integer.valueOf(paramdic.HOS) });
      d.f(this.userName, this.zxX, this.zxY, paramdic.HOS);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean aAh(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 346
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/aa:zzI	Ljava/util/Vector;
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
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/aa:zzI	Ljava/util/Vector;
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
  
  public static boolean aAi(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      zzI.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean dXd()
  {
    return this.sourceType == 64;
  }
  
  private void hB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = ah.dXE();
    String str = this.userName;
    boolean bool = this.dsB;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(com.tencent.mm.plugin.sns.storage.q.bV(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30,33) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.zyW = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.zzN = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final boolean dVL()
  {
    return this.zxW;
  }
  
  public final boolean dVM()
  {
    return (this.zzR == av.zEa) || (this.zzR == av.zEc) || (this.zzR == av.zEb);
  }
  
  public final int dVN()
  {
    return this.zzR;
  }
  
  public final boolean dVO()
  {
    return this.zzO;
  }
  
  public final boolean dVP()
  {
    return this.zzN;
  }
  
  public final boolean dVQ()
  {
    return this.zyW;
  }
  
  public final boolean dVR()
  {
    return this.zzP;
  }
  
  public final long dVS()
  {
    return this.zxY;
  }
  
  public final boolean dVT()
  {
    return this.zzK;
  }
  
  public final long dVU()
  {
    return this.zzQ;
  }
  
  public final String dVV()
  {
    return this.zzL;
  }
  
  public final boolean dVW()
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
    ae.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dic localdic = (dic)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    boolean bool;
    if (this.zzR == -1)
    {
      if ((this.rr.hQE.getRetCode() != 207) && (this.rr.hQE.getRetCode() != 203) && (this.rr.hQE.getRetCode() != 0) && (this.rr.hQE.getRetCode() != 2001) && (this.rr.hQE.getRetCode() != 2004) && (this.rr.hQE.getRetCode() != 2005) && (this.rr.hQE.getRetCode() != 2003))
      {
        aAi(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.hQE.getRetCode() == 2003)
      {
        paramq = ah.dXE();
        paramArrayOfByte = this.userName;
        ae.m("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bu.aSk(paramArrayOfByte) + "\"";
        bool = paramq.db.execSQL("SnsInfo", str1);
        ae.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.zzL = localdic.HPs;
      this.zya = localdic.HNB;
      ae.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdic.HNB + " , objCount:  " + localdic.Hor + ", retTips:" + this.zzL);
      this.zzQ = localdic.HPq;
      String str1 = r.zW(this.zxX);
      if (!this.zxW)
      {
        ae.d("MicroMsg.NetSceneSnsUserPage", "np  " + localdic.FUY.size());
        if (localdic.FUY.isEmpty()) {
          if (this.rr.hQE.getRetCode() == 203)
          {
            bool = true;
            this.zzP = bool;
            ah.dXE().f(this.userName, this.dsB, str1);
            this.zzN = true;
            this.zxY = this.zxX;
          }
        }
        for (;;)
        {
          aAi(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(localdic, str1);
        }
      }
      ah.dXI().y(this.userName, localdic.HNZ);
      if (this.zyB.equals(localdic.HNx))
      {
        paramq = ah.dXE();
        if (this.zxW) {}
        for (long l = 0L;; l = this.zyT)
        {
          this.zxY = paramq.b(l, this.zya, this.userName, this.dsB);
          ae.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.zxY) });
          hB(paramInt2, paramInt3);
          aAi(this.userName);
          paramq = ah.dXI().aBw(this.userName);
          this.callback.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      ae.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localdic.FUY.size());
      if ((!this.zxW) || (this.zyB.equals(localdic.HNx)))
      {
        if (!dXd()) {
          break label1297;
        }
        ah.dXI().p(this.userName, localdic.HNx, paramInt2, paramInt3);
        label822:
        if ((this.rr.hQE.getRetCode() != 207) && (this.rr.hQE.getRetCode() != 2001) && (this.rr.hQE.getRetCode() != 2004) && (this.rr.hQE.getRetCode() != 2005)) {
          break label1478;
        }
        ah.dXI().jW(this.userName, "");
        if (!localdic.FUY.isEmpty()) {
          break label1318;
        }
        paramq = ah.dXE();
        paramArrayOfByte = this.userName;
        bool = this.dsB;
        paramq.E(bool, com.tencent.mm.plugin.sns.storage.q.bV(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.zxY = this.zxX;
      }
      for (;;)
      {
        hB(paramInt2, paramInt3);
        aAi(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.zzJ = localdic.HPp;
        paramq = ah.dXI().aBw(this.userName);
        paramq.field_icount = this.zzJ;
        paramArrayOfByte = localdic.HhA;
        if (paramArrayOfByte != null)
        {
          localObject = r.zV(paramArrayOfByte.jgi);
          str2 = ah.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((paramq.field_bgUrl == null) || (!paramq.field_bgId.equals(localObject)))
          {
            paramq.field_older_bgId = paramq.field_bgId;
            if (com.tencent.mm.vfs.o.fB(ap.jv(str2, this.userName) + str3))
            {
              com.tencent.mm.vfs.o.deleteFile(ap.jv(str2, this.userName) + str4);
              com.tencent.mm.vfs.o.bc(ap.jv(str2, this.userName), str3, str4);
            }
            this.zzK = true;
            paramq.ecc();
            ae.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.jgh);
          }
          paramq.field_bgId = ((String)localObject);
          paramq.field_bgUrl = paramArrayOfByte.jgh;
          paramq.field_snsBgId = paramArrayOfByte.jgi;
        }
        ah.dXI().a(paramq);
        break;
        label1297:
        ah.dXI().o(this.userName, localdic.HNx, paramInt2, paramInt3);
        break label822;
        label1318:
        Object localObject = ah.dXE();
        paramq = this.userName;
        bool = this.dsB;
        String str2 = r.zW(((SnsObject)localdic.FUY.getFirst()).Id);
        paramArrayOfByte = com.tencent.mm.plugin.sns.storage.q.bV(paramq, bool) + " AND  (snsId != 0  ) ";
        paramq = paramArrayOfByte;
        if (com.tencent.mm.plugin.sns.storage.q.aBB(str2)) {
          paramq = paramArrayOfByte + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject).aBE(str2);
        }
        ((com.tencent.mm.plugin.sns.storage.q)localObject).E(bool, paramq);
        ah.dXE().f(this.userName, this.dsB, r.zW(((SnsObject)localdic.FUY.getLast()).Id));
        a(localdic, str1);
      }
      label1478:
      if (localdic.FUY.size() == 0)
      {
        ae.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      a(localdic, str1);
      aAi(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    if ((this.rr.hQE.getRetCode() != 207) && (this.rr.hQE.getRetCode() != 203) && (this.rr.hQE.getRetCode() != 0) && (this.rr.hQE.getRetCode() != 2001) && (this.rr.hQE.getRetCode() != 2004) && (this.rr.hQE.getRetCode() != 2005) && (this.rr.hQE.getRetCode() != 2003))
    {
      aAi(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.zzL = localdic.HPs;
    this.zya = localdic.HNB;
    ae.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localdic.HNB + " , objCount:  " + localdic.Hor + ", retTips:" + this.zzL + ", prePageDayEndFlag:" + localdic.HPt);
    this.zzQ = localdic.HPq;
    ae.d("MicroMsg.NetSceneSnsUserPage", "do search  " + localdic.FUY.size());
    if (localdic.FUY.size() == 0)
    {
      ae.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.hQE.getRetCode() == 203)
      {
        bool = true;
        this.zzP = bool;
        if (this.zzR != av.zEb) {
          break label1918;
        }
        this.zzO = true;
      }
      for (;;)
      {
        aAi(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.zxY = this.zxX;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label1918:
        this.zzN = true;
      }
    }
    if (this.zzR == av.zEb) {
      if (localdic.HPt) {
        this.zzM = ((SnsObject)localdic.FUY.getFirst()).Id;
      }
    }
    for (;;)
    {
      paramq = r.zW(((SnsObject)localdic.FUY.getFirst()).Id);
      al.b(this.userName, this.sourceType, localdic.FUY, paramq);
      al.k(localdic.FUY, this.zzR);
      ae.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(al.zxX), Long.valueOf(al.zxY), Integer.valueOf(localdic.HOS) });
      aAi(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.zzR == av.zEa) {
        this.zzM = ((SnsObject)localdic.FUY.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */