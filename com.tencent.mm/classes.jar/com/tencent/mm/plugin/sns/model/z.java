package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Vector;

public final class z
  extends com.tencent.mm.al.n
  implements k, com.tencent.mm.plugin.sns.c.b
{
  private static Vector<String> wGf;
  public g callback;
  private boolean diE;
  private com.tencent.mm.al.b rr;
  private int sourceType;
  String userName;
  private boolean wES;
  private long wET;
  long wEU;
  public int wEW;
  private long wFQ;
  private boolean wFT;
  private String wFy;
  private int wGg;
  private boolean wGh;
  private String wGi;
  public long wGj;
  private boolean wGk;
  private boolean wGl;
  private boolean wGm;
  public long wGn;
  public int wGo;
  public int wGp;
  
  static
  {
    AppMethodBeat.i(95688);
    wGf = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public z(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(160650);
    this.wFQ = 0L;
    this.wET = 0L;
    this.wEU = 0L;
    this.wGg = 0;
    this.wGh = false;
    this.wFy = "";
    this.wGi = "";
    this.wGj = 0L;
    this.wGk = false;
    this.wGl = false;
    this.wFT = false;
    this.wGm = false;
    this.wEW = 0;
    this.wGo = -1;
    this.wGp = 0;
    this.userName = paramString;
    this.wET = paramLong;
    this.diE = paramBoolean;
    this.wGo = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      ad.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.wGp = paramInt5;
      localObject = new b.a();
      ((b.a)localObject).gUU = new cwi();
      ((b.a)localObject).gUV = new cwj();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).funcId = 212;
      ((b.a)localObject).reqCmdId = 99;
      ((b.a)localObject).respCmdId = 1000000099;
      this.rr = ((b.a)localObject).atI();
      localObject = (cwi)this.rr.gUS.gUX;
      ((cwi)localObject).Username = paramString;
      ((cwi)localObject).Emo = paramLong;
      ((cwi)localObject).Eoe = paramInt3;
      if (paramLong != 0L) {
        break label392;
      }
    }
    label392:
    for (boolean bool = true;; bool = false)
    {
      this.wES = bool;
      if ((paramInt2 != as.wKi) && (paramInt2 != as.wKj) && (paramInt2 != as.wKh)) {
        break label398;
      }
      ((cwi)localObject).Enz = 0L;
      ((cwi)localObject).rNz = paramInt1;
      if (paramInt2 == as.wKi) {
        ((cwi)localObject).EnF = 1;
      }
      this.sourceType = 16;
      ad.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramLong), com.tencent.mm.plugin.sns.data.q.st(this.wEU), Integer.valueOf(paramInt1), Integer.valueOf(((cwi)localObject).EnF) });
      this.wFQ = paramLong;
      AppMethodBeat.o(160650);
      return;
      ad.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label398:
    paramInt2 = af.dtk().aoJ(paramString);
    com.tencent.mm.plugin.sns.storage.q localq = af.dtu();
    long l;
    if (this.wES)
    {
      l = 0L;
      label422:
      this.wEU = localq.a(l, paramInt2, paramString, paramBoolean);
      ((cwi)localObject).Enz = this.wEU;
      paramInt3 = c.a(this.wEU, paramLong, paramString);
      ((cwi)localObject).EnA = paramInt3;
      ((cwi)localObject).rNz = paramInt1;
      if (this.wES) {
        if (!dsU()) {
          break label605;
        }
      }
    }
    label605:
    for (this.wFy = af.dty().apP(paramString).field_albumMd5;; this.wFy = af.dty().apP(paramString).field_md5)
    {
      if (this.wFy == null) {
        this.wFy = "";
      }
      ((cwi)localObject).Emn = this.wFy;
      ad.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + com.tencent.mm.plugin.sns.data.q.st(paramLong) + " minId:" + com.tencent.mm.plugin.sns.data.q.st(this.wEU) + " lastReqTime:" + paramInt3 + " snsSource " + paramInt1);
      break;
      l = paramLong;
      break label422;
    }
  }
  
  private void a(cwj paramcwj, String paramString)
  {
    AppMethodBeat.i(95685);
    aj.b(this.userName, this.sourceType, paramcwj.CEH, paramString);
    if (this.wET == 0L) {}
    for (this.wET = ((SnsObject)paramcwj.CEH.getFirst()).Id;; this.wET = c.sz(this.wET))
    {
      this.wEU = ((SnsObject)paramcwj.CEH.getLast()).Id;
      ad.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.wET), Long.valueOf(this.wEU), Integer.valueOf(paramcwj.EnI) });
      c.e(this.userName, this.wET, this.wEU, paramcwj.EnI);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  public static boolean aoA(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      wGf.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean aoz(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 352
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/z:wGf	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 355	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 352
    //   24: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/z:wGf	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 358	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 352
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
  
  private boolean dsU()
  {
    return this.sourceType == 64;
  }
  
  private void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = af.dtu();
    String str = this.userName;
    boolean bool = this.diE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(com.tencent.mm.plugin.sns.storage.q.bD(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.wFT = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.wGk = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(95687);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95687);
    return i;
  }
  
  public final boolean drB()
  {
    return this.wES;
  }
  
  public final boolean drC()
  {
    return (this.wGo == as.wKh) || (this.wGo == as.wKj) || (this.wGo == as.wKi);
  }
  
  public final int drD()
  {
    return this.wGo;
  }
  
  public final boolean drE()
  {
    return this.wGl;
  }
  
  public final boolean drF()
  {
    return this.wGk;
  }
  
  public final boolean drG()
  {
    return this.wFT;
  }
  
  public final boolean drH()
  {
    return this.wGm;
  }
  
  public final long drI()
  {
    return this.wEU;
  }
  
  public final boolean drJ()
  {
    return this.wGh;
  }
  
  public final long drK()
  {
    return this.wGn;
  }
  
  public final String drL()
  {
    return this.wGi;
  }
  
  public final boolean drM()
  {
    return false;
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
    cwj localcwj = (cwj)((com.tencent.mm.al.b)paramq).gUT.gUX;
    boolean bool;
    if (this.wGo == -1)
    {
      if ((this.rr.gUT.getRetCode() != 207) && (this.rr.gUT.getRetCode() != 203) && (this.rr.gUT.getRetCode() != 0) && (this.rr.gUT.getRetCode() != 2001) && (this.rr.gUT.getRetCode() != 2004) && (this.rr.gUT.getRetCode() != 2005) && (this.rr.gUT.getRetCode() != 2003))
      {
        aoA(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.gUT.getRetCode() == 2003)
      {
        paramq = af.dtu();
        paramArrayOfByte = this.userName;
        ad.m("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bt.aFQ(paramArrayOfByte) + "\"";
        bool = paramq.db.execSQL("SnsInfo", str1);
        ad.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.wGi = localcwj.Eoi;
      this.wEW = localcwj.Emr;
      ad.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localcwj.Emr + " , objCount:  " + localcwj.DOR + ", retTips:" + this.wGi);
      this.wGn = localcwj.Eog;
      String str1 = com.tencent.mm.plugin.sns.data.q.su(this.wET);
      if (!this.wES)
      {
        ad.d("MicroMsg.NetSceneSnsUserPage", "np  " + localcwj.CEH.size());
        if (localcwj.CEH.isEmpty()) {
          if (this.rr.gUT.getRetCode() == 203)
          {
            bool = true;
            this.wGm = bool;
            af.dtu().f(this.userName, this.diE, str1);
            this.wGk = true;
            this.wEU = this.wET;
          }
        }
        for (;;)
        {
          aoA(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(localcwj, str1);
        }
      }
      af.dty().x(this.userName, localcwj.EmP);
      if (this.wFy.equals(localcwj.Emn))
      {
        paramq = af.dtu();
        if (this.wES) {}
        for (long l = 0L;; l = this.wFQ)
        {
          this.wEU = paramq.a(l, this.wEW, this.userName, this.diE);
          ad.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.wEU) });
          gY(paramInt2, paramInt3);
          aoA(this.userName);
          paramq = af.dty().apP(this.userName);
          this.callback.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      ad.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localcwj.CEH.size());
      if ((!this.wES) || (this.wFy.equals(localcwj.Emn)))
      {
        if (!dsU()) {
          break label1297;
        }
        af.dty().o(this.userName, localcwj.Emn, paramInt2, paramInt3);
        label822:
        if ((this.rr.gUT.getRetCode() != 207) && (this.rr.gUT.getRetCode() != 2001) && (this.rr.gUT.getRetCode() != 2004) && (this.rr.gUT.getRetCode() != 2005)) {
          break label1478;
        }
        af.dty().je(this.userName, "");
        if (!localcwj.CEH.isEmpty()) {
          break label1318;
        }
        paramq = af.dtu();
        paramArrayOfByte = this.userName;
        bool = this.diE;
        paramq.w(bool, com.tencent.mm.plugin.sns.storage.q.bD(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.wEU = this.wET;
      }
      for (;;)
      {
        gY(paramInt2, paramInt3);
        aoA(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.wGg = localcwj.Eof;
        paramq = af.dty().apP(this.userName);
        paramq.field_icount = this.wGg;
        paramArrayOfByte = localcwj.DJb;
        if (paramArrayOfByte != null)
        {
          localObject = com.tencent.mm.plugin.sns.data.q.st(paramArrayOfByte.ijZ);
          str2 = af.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((paramq.field_bgUrl == null) || (!paramq.field_bgId.equals(localObject)))
          {
            paramq.field_older_bgId = paramq.field_bgId;
            if (i.eK(an.iF(str2, this.userName) + str3))
            {
              i.deleteFile(an.iF(str2, this.userName) + str4);
              i.aQ(an.iF(str2, this.userName), str3, str4);
            }
            this.wGh = true;
            paramq.dxL();
            ad.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.ijY);
          }
          paramq.field_bgId = ((String)localObject);
          paramq.field_bgUrl = paramArrayOfByte.ijY;
          paramq.field_snsBgId = paramArrayOfByte.ijZ;
        }
        af.dty().a(paramq);
        break;
        label1297:
        af.dty().n(this.userName, localcwj.Emn, paramInt2, paramInt3);
        break label822;
        label1318:
        Object localObject = af.dtu();
        paramq = this.userName;
        bool = this.diE;
        String str2 = com.tencent.mm.plugin.sns.data.q.su(((SnsObject)localcwj.CEH.getFirst()).Id);
        paramArrayOfByte = com.tencent.mm.plugin.sns.storage.q.bD(paramq, bool) + " AND  (snsId != 0  ) ";
        paramq = paramArrayOfByte;
        if (com.tencent.mm.plugin.sns.storage.q.apU(str2)) {
          paramq = paramArrayOfByte + " AND " + ((com.tencent.mm.plugin.sns.storage.q)localObject).apX(str2);
        }
        ((com.tencent.mm.plugin.sns.storage.q)localObject).w(bool, paramq);
        af.dtu().f(this.userName, this.diE, com.tencent.mm.plugin.sns.data.q.su(((SnsObject)localcwj.CEH.getLast()).Id));
        a(localcwj, str1);
      }
      label1478:
      if (localcwj.CEH.size() == 0)
      {
        ad.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      a(localcwj, str1);
      aoA(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    if ((this.rr.gUT.getRetCode() != 207) && (this.rr.gUT.getRetCode() != 203) && (this.rr.gUT.getRetCode() != 0) && (this.rr.gUT.getRetCode() != 2001) && (this.rr.gUT.getRetCode() != 2004) && (this.rr.gUT.getRetCode() != 2005) && (this.rr.gUT.getRetCode() != 2003))
    {
      aoA(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.wGi = localcwj.Eoi;
    this.wEW = localcwj.Emr;
    ad.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localcwj.Emr + " , objCount:  " + localcwj.DOR + ", retTips:" + this.wGi + ", prePageDayEndFlag:" + localcwj.Eoj);
    this.wGn = localcwj.Eog;
    ad.d("MicroMsg.NetSceneSnsUserPage", "do search  " + localcwj.CEH.size());
    if (localcwj.CEH.size() == 0)
    {
      ad.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.gUT.getRetCode() == 203)
      {
        bool = true;
        this.wGm = bool;
        if (this.wGo != as.wKi) {
          break label1918;
        }
        this.wGl = true;
      }
      for (;;)
      {
        aoA(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.wEU = this.wET;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label1918:
        this.wGk = true;
      }
    }
    if (this.wGo == as.wKi) {
      if (localcwj.Eoj) {
        this.wGj = ((SnsObject)localcwj.CEH.getFirst()).Id;
      }
    }
    for (;;)
    {
      paramq = com.tencent.mm.plugin.sns.data.q.su(((SnsObject)localcwj.CEH.getFirst()).Id);
      aj.b(this.userName, this.sourceType, localcwj.CEH, paramq);
      aj.j(localcwj.CEH, this.wGo);
      ad.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(aj.wET), Long.valueOf(aj.wEU), Integer.valueOf(localcwj.EnI) });
      aoA(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.wGo == as.wKh) {
        this.wGj = ((SnsObject)localcwj.CEH.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */