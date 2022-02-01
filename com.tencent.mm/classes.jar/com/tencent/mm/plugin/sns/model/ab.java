package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.elk;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.Vector;

public final class ab
  extends q
  implements com.tencent.mm.network.m, b
{
  private static Vector<String> JWt;
  private int BAV;
  private String JVL;
  private boolean JVe;
  private long JVf;
  long JVg;
  public int JVi;
  private boolean JWA;
  public long JWB;
  public int JWC;
  public int JWD;
  private long JWd;
  private boolean JWg;
  private int JWu;
  private boolean JWv;
  private String JWw;
  public long JWx;
  private boolean JWy;
  private boolean JWz;
  public i callback;
  private boolean fCB;
  private com.tencent.mm.an.d rr;
  private int sourceType;
  String userName;
  
  static
  {
    AppMethodBeat.i(95688);
    JWt = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public ab(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramString, paramLong, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1);
    AppMethodBeat.i(160650);
    AppMethodBeat.o(160650);
  }
  
  public ab(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(201876);
    this.JWd = 0L;
    this.JVf = 0L;
    this.JVg = 0L;
    this.JWu = 0;
    this.JWv = false;
    this.JVL = "";
    this.JWw = "";
    this.JWx = 0L;
    this.JWy = false;
    this.JWz = false;
    this.JWg = false;
    this.JWA = false;
    this.JVi = 0;
    this.JWC = -1;
    this.JWD = 0;
    this.BAV = 0;
    this.BAV = paramInt6;
    this.userName = paramString;
    this.JVf = paramLong;
    this.fCB = paramBoolean;
    this.JWC = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.JWD = paramInt5;
      localObject = new d.a();
      ((d.a)localObject).lBU = new elk();
      ((d.a)localObject).lBV = new ell();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((d.a)localObject).funcId = 212;
      ((d.a)localObject).lBW = 99;
      ((d.a)localObject).respCmdId = 1000000099;
      this.rr = ((d.a)localObject).bgN();
      localObject = (elk)d.b.b(this.rr.lBR);
      ((elk)localObject).Username = paramString;
      ((elk)localObject).UlB = paramLong;
      ((elk)localObject).Uny = paramInt3;
      if (paramLong != 0L) {
        break label403;
      }
    }
    label403:
    for (boolean bool = true;; bool = false)
    {
      this.JVe = bool;
      if ((paramInt2 != aw.Kbk) && (paramInt2 != aw.Kbl) && (paramInt2 != aw.Kbj)) {
        break label409;
      }
      ((elk)localObject).UmO = 0L;
      ((elk)localObject).Cqs = paramInt1;
      if (paramInt2 == aw.Kbk) {
        ((elk)localObject).UmU = 1;
      }
      this.sourceType = 16;
      Log.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { com.tencent.mm.plugin.sns.data.t.Qu(paramLong), com.tencent.mm.plugin.sns.data.t.Qu(this.JVg), Integer.valueOf(paramInt1), Integer.valueOf(((elk)localObject).UmU) });
      this.JWd = paramLong;
      AppMethodBeat.o(201876);
      return;
      Log.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label409:
    paramInt2 = aj.fOy().baj(paramString);
    n localn = aj.fOI();
    long l;
    if (this.JVe)
    {
      l = 0L;
      label433:
      this.JVg = localn.a(l, paramInt2, paramString, paramBoolean);
      ((elk)localObject).UmO = this.JVg;
      paramInt3 = d.a(this.JVg, paramLong, paramString);
      ((elk)localObject).UmP = paramInt3;
      ((elk)localObject).Cqs = paramInt1;
      if (this.JVe) {
        if (!fOf()) {
          break label629;
        }
      }
    }
    label629:
    for (this.JVL = aj.fOM().bbr(paramString).field_albumMd5;; this.JVL = aj.fOM().bbr(paramString).field_md5)
    {
      if (this.JVL == null) {
        this.JVL = "";
      }
      ((elk)localObject).UlA = this.JVL;
      Log.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + com.tencent.mm.plugin.sns.data.t.Qu(paramLong) + " minId:" + com.tencent.mm.plugin.sns.data.t.Qu(this.JVg) + " lastReqTime:" + paramInt3 + " snsSource:" + paramInt1 + " FirstPageMd5:" + this.JVL);
      break;
      l = paramLong;
      break label433;
    }
  }
  
  private void a(final elk paramelk)
  {
    AppMethodBeat.i(201981);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269733);
        Log.i("MicroMsg.NetSceneSnsUserPage", "doFetchByContinueID continueID:%s", new Object[] { Long.valueOf(paramelk.UlB) });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(new ab(paramelk.Username, paramelk.UlB, ab.a(ab.this), paramelk.Cqs, ab.this.JWC, paramelk.Uny, ab.b(ab.this), ab.this.JWD, ab.c(ab.this) + 1), 0);
        AppMethodBeat.o(269733);
      }
    });
    AppMethodBeat.o(201981);
  }
  
  private void a(ell paramell, String paramString)
  {
    AppMethodBeat.i(95685);
    an.a(this.userName, this.sourceType, paramell.RPF, paramString);
    if (this.JVf == 0L) {}
    for (this.JVf = ((SnsObject)paramell.RPF.getFirst()).Id;; this.JVf = d.Qy(this.JVf))
    {
      this.JVg = ((SnsObject)paramell.RPF.getLast()).Id;
      Log.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.JVf), Long.valueOf(this.JVg), Integer.valueOf(paramell.Unb) });
      d.f(this.userName, this.JVf, this.JVg, paramell.Unb);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean aZY(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 373
    //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 58	com/tencent/mm/plugin/sns/model/ab:JWt	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 377	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 373
    //   24: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 58	com/tencent/mm/plugin/sns/model/ab:JWt	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 380	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 373
    //   45: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aZZ(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      JWt.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean fOf()
  {
    return this.sourceType == 64;
  }
  
  private void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = aj.fOI();
    String str = this.userName;
    boolean bool = this.fCB;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(n.cA(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30 , 34,43,38,33,37,36,39,41,42,44) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((n)localObject).lvy.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.JWg = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.JWy = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95687);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95687);
    return i;
  }
  
  public final boolean fML()
  {
    return this.JVe;
  }
  
  public final boolean fMM()
  {
    return (this.JWC == aw.Kbj) || (this.JWC == aw.Kbl) || (this.JWC == aw.Kbk);
  }
  
  public final int fMN()
  {
    return this.JWC;
  }
  
  public final boolean fMO()
  {
    return this.JWz;
  }
  
  public final boolean fMP()
  {
    return this.JWy;
  }
  
  public final boolean fMQ()
  {
    return this.JWg;
  }
  
  public final boolean fMR()
  {
    return this.JWA;
  }
  
  public final long fMS()
  {
    return this.JVg;
  }
  
  public final boolean fMT()
  {
    return this.JWv;
  }
  
  public final long fMU()
  {
    return this.JWB;
  }
  
  public final String fMV()
  {
    return this.JWw;
  }
  
  public final boolean fMW()
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95686);
    Log.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ell localell = (ell)d.c.b(((com.tencent.mm.an.d)params).lBS);
    boolean bool;
    if (this.JWC == -1)
    {
      if ((this.rr.lBS.getRetCode() != 207) && (this.rr.lBS.getRetCode() != 203) && (this.rr.lBS.getRetCode() != 0) && (this.rr.lBS.getRetCode() != 2001) && (this.rr.lBS.getRetCode() != 2004) && (this.rr.lBS.getRetCode() != 2005) && (this.rr.lBS.getRetCode() != 2003))
      {
        aZZ(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.lBS.getRetCode() == 2003)
      {
        params = aj.fOI();
        paramArrayOfByte = this.userName;
        Log.printInfoStack("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + Util.escapeSqlValue(paramArrayOfByte) + "\"";
        bool = params.lvy.execSQL("SnsInfo", str1);
        Log.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.JWw = localell.UnC;
      this.JVi = localell.UlE;
      Log.i("MicroMsg.NetSceneSnsUserPage", "ForSameMd5 count: " + localell.UlE + " , objCount:" + localell.TGK + ", retTips:" + this.JWw + ", ContinueID:" + localell.UnB + ", requestTime:" + this.BAV);
      this.JWB = localell.UnA;
      String str1 = com.tencent.mm.plugin.sns.data.t.Qv(this.JVf);
      if (!this.JVe)
      {
        Log.d("MicroMsg.NetSceneSnsUserPage", "np  " + localell.RPF.size());
        if (localell.RPF.isEmpty()) {
          if ((localell.UnB != 0L) && (this.rr.lBS.getRetCode() != 207) && (this.BAV <= 50))
          {
            params = (elk)d.b.b(this.rr.lBR);
            params.UlB = localell.UnB;
            a(params);
          }
        }
        for (;;)
        {
          aZZ(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          if (this.rr.lBS.getRetCode() == 203) {}
          for (bool = true;; bool = false)
          {
            this.JWA = bool;
            aj.fOI().e(this.userName, this.fCB, str1);
            this.JWy = true;
            this.JVg = this.JVf;
            break;
          }
          a(localell, str1);
        }
      }
      aj.fOM().D(this.userName, localell.Uma);
      if (this.JVL.equals(localell.UlA))
      {
        params = aj.fOI();
        if (this.JVe) {}
        for (long l = 0L;; l = this.JWd)
        {
          this.JVg = params.a(l, this.JVi, this.userName, this.fCB);
          Log.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.JVg) });
          jD(paramInt2, paramInt3);
          aZZ(this.userName);
          params = aj.fOM().bbr(this.userName);
          this.callback.onSceneEnd(params.field_lastFirstPageRequestErrType, params.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localell.RPF.size());
      if ((!this.JVe) || (this.JVL.equals(localell.UlA)))
      {
        if ((this.rr.lBS.getRetCode() != 207) && (this.rr.lBS.getRetCode() != 2001) && (this.rr.lBS.getRetCode() != 2004) && (this.rr.lBS.getRetCode() != 2005)) {
          break label1659;
        }
        aj.fOM().lg(this.userName, "");
        if (!localell.RPF.isEmpty()) {
          break label1453;
        }
        if ((localell.UnB == 0L) || (this.rr.lBS.getRetCode() == 207) || (this.BAV > 50)) {
          break label1392;
        }
        params = (elk)d.b.b(this.rr.lBR);
        params.UlB = localell.UnB;
        a(params);
      }
      Object localObject;
      String str2;
      for (;;)
      {
        jD(paramInt2, paramInt3);
        aZZ(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.JWu = localell.Unz;
        params = aj.fOM().bbr(this.userName);
        params.field_icount = this.JWu;
        paramArrayOfByte = localell.TxL;
        if (paramArrayOfByte != null)
        {
          localObject = com.tencent.mm.plugin.sns.data.t.Qu(paramArrayOfByte.mVL);
          str2 = aj.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((params.field_bgUrl == null) || (!params.field_bgId.equals(localObject)))
          {
            params.field_older_bgId = params.field_bgId;
            if (u.agG(aq.kD(str2, this.userName) + str3))
            {
              u.deleteFile(aq.kD(str2, this.userName) + str4);
              u.bj(aq.kD(str2, this.userName), str3, str4);
            }
            this.JWv = true;
            params.fSC();
            Log.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.mVK);
          }
          params.field_bgId = ((String)localObject);
          params.field_bgUrl = paramArrayOfByte.mVK;
          aj.fOM();
          com.tencent.mm.plugin.sns.storage.m.a(params, paramArrayOfByte.mVK, this.userName);
          params.field_snsBgId = paramArrayOfByte.mVL;
        }
        aj.fOM().a(params);
        break;
        label1392:
        params = aj.fOI();
        paramArrayOfByte = this.userName;
        bool = this.fCB;
        params.K(bool, n.cA(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.JVg = this.JVf;
      }
      label1453:
      if (fOf()) {
        aj.fOM().p(this.userName, localell.UlA, paramInt2, paramInt3);
      }
      for (;;)
      {
        localObject = aj.fOI();
        params = this.userName;
        bool = this.fCB;
        str2 = com.tencent.mm.plugin.sns.data.t.Qv(((SnsObject)localell.RPF.getFirst()).Id);
        paramArrayOfByte = n.cA(params, bool) + " AND  (snsId != 0  ) ";
        params = paramArrayOfByte;
        if (n.bbw(str2)) {
          params = paramArrayOfByte + " AND " + ((n)localObject).bbz(str2);
        }
        ((n)localObject).K(bool, params);
        aj.fOI().e(this.userName, this.fCB, com.tencent.mm.plugin.sns.data.t.Qv(((SnsObject)localell.RPF.getLast()).Id));
        a(localell, str1);
        break;
        aj.fOM().o(this.userName, localell.UlA, paramInt2, paramInt3);
      }
      label1659:
      if (localell.RPF.size() == 0)
      {
        if ((localell.UnB != 0L) && (this.rr.lBS.getRetCode() != 207) && (this.BAV <= 50))
        {
          paramString = (elk)d.b.b(this.rr.lBR);
          paramString.UlB = localell.UnB;
          a(paramString);
          AppMethodBeat.o(95686);
          return;
        }
        Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (fOf()) {
        aj.fOM().p(this.userName, localell.UlA, paramInt2, paramInt3);
      }
      for (;;)
      {
        a(localell, str1);
        aZZ(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        aj.fOM().o(this.userName, localell.UlA, paramInt2, paramInt3);
      }
    }
    if ((this.rr.lBS.getRetCode() != 207) && (this.rr.lBS.getRetCode() != 203) && (this.rr.lBS.getRetCode() != 0) && (this.rr.lBS.getRetCode() != 2001) && (this.rr.lBS.getRetCode() != 2004) && (this.rr.lBS.getRetCode() != 2005) && (this.rr.lBS.getRetCode() != 2003))
    {
      aZZ(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.JWw = localell.UnC;
    this.JVi = localell.UlE;
    Log.i("MicroMsg.NetSceneSnsUserPage", "ForSameMd5: " + localell.UlE + " , objCount:  " + localell.TGK + ", retTips:" + this.JWw + ", prePageDayEndFlag:" + localell.UnD + ", ObjectList:" + localell.RPF.size() + ", ContinueID:" + localell.UnB + ", requestTime:" + this.BAV);
    this.JWB = localell.UnA;
    if (localell.RPF.size() == 0)
    {
      if ((localell.UnB != 0L) && (this.rr.lBS.getRetCode() != 207) && (this.BAV <= 50))
      {
        paramString = (elk)d.b.b(this.rr.lBR);
        paramString.UlB = localell.UnB;
        a(paramString);
        AppMethodBeat.o(95686);
        return;
      }
      Log.e("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.lBS.getRetCode() == 203)
      {
        bool = true;
        this.JWA = bool;
        if (this.JWC != aw.Kbk) {
          break label2306;
        }
        this.JWz = true;
      }
      for (;;)
      {
        aZZ(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.JVg = this.JVf;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label2306:
        this.JWy = true;
      }
    }
    if (this.JWC == aw.Kbk) {
      if (localell.UnD) {
        this.JWx = ((SnsObject)localell.RPF.getFirst()).Id;
      }
    }
    for (;;)
    {
      params = com.tencent.mm.plugin.sns.data.t.Qv(((SnsObject)localell.RPF.getFirst()).Id);
      an.a(this.userName, this.sourceType, localell.RPF, params);
      an.k(localell.RPF, this.JWC);
      Log.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(an.JVf), Long.valueOf(an.JVg), Integer.valueOf(localell.Unb) });
      aZZ(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.JWC == aw.Kbj) {
        this.JWx = ((SnsObject)localell.RPF.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */