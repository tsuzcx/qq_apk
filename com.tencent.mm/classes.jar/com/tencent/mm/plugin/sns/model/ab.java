package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.a.a;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fft;
import com.tencent.mm.protocal.protobuf.ffu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.Vector;

public final class ab
  extends p
  implements m, com.tencent.mm.plugin.sns.c.b
{
  private static Vector<String> Qtz;
  private int Hit;
  private String QsM;
  private boolean Qsg;
  long Qsh;
  public int Qsj;
  private int QtA;
  private boolean QtB;
  private String QtC;
  public long QtD;
  private boolean QtE;
  private boolean QtF;
  private boolean QtG;
  public long QtH;
  public int QtI;
  public int QtJ;
  private long Qte;
  private boolean Qth;
  public com.tencent.mm.am.h callback;
  private boolean hHq;
  private long maxId;
  private com.tencent.mm.am.c rr;
  private int sourceType;
  String userName;
  
  static
  {
    AppMethodBeat.i(95688);
    Qtz = new Vector();
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
    AppMethodBeat.i(309407);
    this.Qte = 0L;
    this.maxId = 0L;
    this.Qsh = 0L;
    this.QtA = 0;
    this.QtB = false;
    this.QsM = "";
    this.QtC = "";
    this.QtD = 0L;
    this.QtE = false;
    this.QtF = false;
    this.Qth = false;
    this.QtG = false;
    this.Qsj = 0;
    this.QtI = -1;
    this.QtJ = 0;
    this.Hit = 0;
    this.Hit = paramInt6;
    this.userName = paramString;
    this.maxId = paramLong;
    this.hHq = paramBoolean;
    this.QtI = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.QtJ = paramInt5;
      localObject = new c.a();
      ((c.a)localObject).otE = new fft();
      ((c.a)localObject).otF = new ffu();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((c.a)localObject).funcId = 212;
      ((c.a)localObject).otG = 99;
      ((c.a)localObject).respCmdId = 1000000099;
      this.rr = ((c.a)localObject).bEF();
      localObject = (fft)c.b.b(this.rr.otB);
      ((fft)localObject).Username = paramString;
      ((fft)localObject).abDv = paramLong;
      ((fft)localObject).abFH = paramInt3;
      if (!MultiProcessMMKV.getDefault().getBoolean("ShowWithTaEntrance_".concat(String.valueOf(paramString)), false)) {
        ((fft)localObject).abFJ = 1;
      }
      if (paramLong != 0L) {
        break label428;
      }
    }
    label428:
    for (boolean bool = true;; bool = false)
    {
      this.Qsg = bool;
      if ((paramInt2 != ay.QyA) && (paramInt2 != ay.QyB) && (paramInt2 != ay.Qyz)) {
        break label434;
      }
      ((fft)localObject).abEV = 0L;
      ((fft)localObject).IcB = paramInt1;
      if (paramInt2 == ay.QyA) {
        ((fft)localObject).abFb = 1;
      }
      this.sourceType = 16;
      Log.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { t.uA(paramLong), t.uA(this.Qsh), Integer.valueOf(paramInt1), Integer.valueOf(((fft)localObject).abFb) });
      this.Qte = paramLong;
      AppMethodBeat.o(309407);
      return;
      Log.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label434:
    paramInt2 = al.hgr().aYB(paramString);
    w localw = al.hgB();
    long l;
    if (this.Qsg)
    {
      l = 0L;
      label458:
      this.Qsh = localw.a(l, paramInt2, paramString, paramBoolean);
      ((fft)localObject).abEV = this.Qsh;
      paramInt3 = d.b(this.Qsh, paramLong, paramString);
      ((fft)localObject).abEW = paramInt3;
      ((fft)localObject).IcB = paramInt1;
      if (this.Qsg) {
        if (!hfS()) {
          break label651;
        }
      }
    }
    label651:
    for (this.QsM = al.hgF().aZT(paramString);; this.QsM = al.hgF().aZS(paramString))
    {
      if (this.QsM == null) {
        this.QsM = "";
      }
      ((fft)localObject).abDu = this.QsM;
      Log.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + t.uA(paramLong) + " minId:" + t.uA(this.Qsh) + " lastReqTime:" + paramInt3 + " snsSource:" + paramInt1 + " FirstPageMd5:" + this.QsM);
      break;
      l = paramLong;
      break label458;
    }
  }
  
  private void a(final fft paramfft)
  {
    AppMethodBeat.i(309417);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309472);
        Log.i("MicroMsg.NetSceneSnsUserPage", "doFetchByContinueID continueID:%s", new Object[] { Long.valueOf(paramfft.abDv) });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new ab(paramfft.Username, paramfft.abDv, ab.a(ab.this), paramfft.IcB, ab.this.QtI, paramfft.abFH, ab.b(ab.this), ab.this.QtJ, ab.c(ab.this) + 1), 0);
        AppMethodBeat.o(309472);
      }
    });
    AppMethodBeat.o(309417);
  }
  
  private void a(ffu paramffu, String paramString)
  {
    AppMethodBeat.i(95685);
    ap.a(this.userName, this.sourceType, paramffu.YMT, paramString);
    if (this.maxId == 0L) {}
    for (this.maxId = ((SnsObject)paramffu.YMT.getFirst()).Id;; this.maxId = d.uE(this.maxId))
    {
      this.Qsh = ((SnsObject)paramffu.YMT.getLast()).Id;
      Log.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.maxId), Long.valueOf(this.Qsh), Integer.valueOf(paramffu.abFi) });
      d.f(this.userName, this.maxId, this.Qsh, paramffu.abFi);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean aYm(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 382
    //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 58	com/tencent/mm/plugin/sns/model/ab:Qtz	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 386	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 382
    //   24: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 58	com/tencent/mm/plugin/sns/model/ab:Qtz	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 389	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 382
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
  
  public static boolean aYn(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      Qtz.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean hfS()
  {
    return this.sourceType == 64;
  }
  
  private void lp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    int i = al.hgB().df(this.userName, this.hHq);
    if ((i <= 10) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Qth = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.QtE = true;
    }
    AppMethodBeat.o(95684);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95687);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
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
  
  public final boolean hdR()
  {
    return this.Qsg;
  }
  
  public final boolean hdS()
  {
    return (this.QtI == ay.Qyz) || (this.QtI == ay.QyB) || (this.QtI == ay.QyA);
  }
  
  public final int hdT()
  {
    return this.QtI;
  }
  
  public final boolean hdU()
  {
    return this.QtF;
  }
  
  public final boolean hdV()
  {
    return this.QtE;
  }
  
  public final boolean hdW()
  {
    return this.Qth;
  }
  
  public final boolean hdX()
  {
    return this.QtG;
  }
  
  public final long hdY()
  {
    return this.Qsh;
  }
  
  public final boolean hdZ()
  {
    return this.QtB;
  }
  
  public final long hea()
  {
    return this.QtH;
  }
  
  public final String heb()
  {
    return this.QtC;
  }
  
  public final boolean hec()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95686);
    Log.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (ffu)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((!MultiProcessMMKV.getDefault().getBoolean("ShowWithTaEntrance_" + this.userName, false)) && (params.abFQ > 0)) {
      MultiProcessMMKV.getDefault().encode("ShowWithTaEntrance_" + this.userName, true);
    }
    if (this.QtI == -1)
    {
      if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 203) && (this.rr.otC.getRetCode() != 0) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005) && (this.rr.otC.getRetCode() != 2003))
      {
        aYn(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      Tiger2022Helper.a(params.abDz);
      if ((params.abFM == 0L) || (this.Hit > 10)) {
        break label2555;
      }
      paramArrayOfByte = (fft)c.b.b(this.rr.otB);
      paramArrayOfByte.abDv = params.abFM;
      a(paramArrayOfByte);
    }
    label626:
    label2555:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (this.rr.otC.getRetCode() == 2003) {
        al.hgB().aZZ(this.userName);
      }
      this.QtC = params.abFN;
      this.Qsj = params.abDy;
      Log.i("MicroMsg.NetSceneSnsUserPage", "ForSameMd5 count: " + params.abDy + " , objCount:" + params.aaWr + ", retTips:" + this.QtC + ", ContinueID:" + params.abFM + ", requestTime:" + this.Hit);
      this.QtH = params.abFL;
      paramArrayOfByte = t.uB(this.maxId);
      boolean bool;
      if (!this.Qsg)
      {
        Log.d("MicroMsg.NetSceneSnsUserPage", "np  " + params.YMT.size());
        if (params.YMT.isEmpty()) {
          if (paramInt1 == 0)
          {
            if (this.rr.otC.getRetCode() != 203) {
              break label626;
            }
            bool = true;
            this.QtG = bool;
            al.hgB().i(this.userName, this.hHq, paramArrayOfByte);
            this.QtE = true;
            this.Qsh = this.maxId;
          }
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            aYn(this.userName);
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(params, paramArrayOfByte);
        }
      }
      al.hgF().J(this.userName, params.abEb);
      if (this.QsM.equals(params.abDu))
      {
        params = al.hgB();
        if (this.Qsg) {}
        for (long l = 0L;; l = this.Qte)
        {
          this.Qsh = params.a(l, this.Qsj, this.userName, this.hHq);
          Log.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.Qsh) });
          lp(paramInt2, paramInt3);
          if (paramInt1 == 0) {
            aYn(this.userName);
          }
          params = al.hgF().aZW(this.userName);
          this.callback.onSceneEnd(params.field_lastFirstPageRequestErrType, params.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp  " + params.YMT.size());
      if ((!this.Qsg) || (this.QsM.equals(params.abDu)))
      {
        Log.i("MicroMsg.NetSceneSnsUserPage", "jump readfpInfo for requestMd5:%s FirstPageMd5:%s", new Object[] { this.QsM, params.abDu });
        if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005)) {
          break label1816;
        }
        al.hgF().mP(this.userName, "");
        if (params.YMT.isEmpty())
        {
          if (paramInt1 == 0)
          {
            al.hgB().dc(this.userName, this.hHq);
            this.Qsh = this.maxId;
          }
          lp(paramInt2, paramInt3);
          if (paramInt1 == 0) {
            aYn(this.userName);
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
        }
      }
      else
      {
        this.QtA = params.abFK;
        u localu = al.hgF().aZW(this.userName);
        localu.field_icount = this.QtA;
        ffs localffs = params.aaMs;
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (localffs != null)
        {
          localObject1 = t.uA(localffs.pSs);
          localObject2 = al.getAccSnsPath();
          localObject3 = this.userName + "bg_";
          String str = this.userName + "tbg_";
          Log.i("MicroMsg.NetSceneSnsUserPage", "current ext bg id:%s net_id:%s", new Object[] { localu.field_bgId, localObject1 });
          if ((localu.field_bgUrl == null) || (!localu.field_bgId.equals(localObject1)))
          {
            localu.field_older_bgId = localu.field_bgId;
            if (y.ZC(as.mg((String)localObject2, this.userName) + (String)localObject3))
            {
              y.deleteFile(as.mg((String)localObject2, this.userName) + str);
              y.bF(as.mg((String)localObject2, this.userName), (String)localObject3, str);
            }
            this.QtB = true;
            localu.hkO();
            Log.i("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + localffs.pSr);
          }
          localu.field_bgId = ((String)localObject1);
          localu.field_bgUrl = localffs.pSr;
          al.hgF();
          v.a(localu, localffs.pSr, this.userName);
          localu.field_snsBgId = localffs.pSs;
          localObject1 = al.hgG().aZM(this.userName);
          Log.i("MicroMsg.NetSceneSnsUserPage", "isBgChange:%b  coverId:%s extId:%s", new Object[] { Boolean.valueOf(this.QtB), t.uA(((q)localObject1).field_snsBgId), t.uA(localffs.pSs) });
          if ((this.QtB) || (((q)localObject1).field_snsBgId != localffs.pSs))
          {
            localObject1 = al.hgG();
            localObject3 = this.userName;
            kotlin.g.b.s.u(localObject3, "userName");
            kotlin.g.b.s.u(localffs, "snsUserInfo");
            Log.i(r.TAG, kotlin.g.b.s.X("updateUserSnsCoverNetScene ", localObject3));
            localObject2 = al.hgG().aZM((String)localObject3);
            if (localObject2 == null) {
              break label1681;
            }
            if ((((q)localObject2).field_snsBgId != localffs.pSs) || (localffs.pSs == 0L)) {
              break label1610;
            }
            if (TextUtils.isEmpty((CharSequence)localffs.pSr))
            {
              Log.i(r.TAG, "user:" + (String)localObject3 + " has been block");
              localObject3 = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
              com.tencent.mm.plugin.sns.cover.c.b.b((q)localObject2);
              ((q)localObject2).field_type = 5;
              ((r)localObject1).a((q)localObject2, true);
              ((r)localObject1).d((q)localObject2);
            }
            if (!((q)localObject2).field_success) {
              break label1681;
            }
          }
        }
        for (;;)
        {
          al.hgF().a(localu);
          break;
          if (localffs.pSs == 0L)
          {
            Log.i(r.TAG, "user:" + (String)localObject3 + " only chatting");
            ((q)localObject2).field_type = 0;
            ((q)localObject2).field_snsBgId = 0L;
            ((r)localObject1).a((q)localObject2, true);
            ((r)localObject1).d((q)localObject2);
          }
          else
          {
            ((r)localObject1).QYK.vp(localffs.pSs);
          }
        }
      }
      if (hfS()) {
        al.hgF().t(this.userName, params.abDu, paramInt2, paramInt3);
      }
      for (;;)
      {
        al.hgB().h(this.userName, this.hHq, t.uB(((SnsObject)params.YMT.getFirst()).Id));
        al.hgB().i(this.userName, this.hHq, t.uB(((SnsObject)params.YMT.getLast()).Id));
        a(params, paramArrayOfByte);
        break;
        al.hgF().s(this.userName, params.abDu, paramInt2, paramInt3);
      }
      if (params.YMT.size() == 0)
      {
        if (paramInt1 == 0)
        {
          Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        AppMethodBeat.o(95686);
        return;
      }
      if (hfS()) {
        al.hgF().t(this.userName, params.abDu, paramInt2, paramInt3);
      }
      for (;;)
      {
        a(params, paramArrayOfByte);
        if (paramInt1 != 0) {
          break;
        }
        aYn(this.userName);
        break;
        al.hgF().s(this.userName, params.abDu, paramInt2, paramInt3);
      }
      if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 203) && (this.rr.otC.getRetCode() != 0) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005) && (this.rr.otC.getRetCode() != 2003))
      {
        aYn(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if ((params.abFM != 0L) && (this.Hit <= 10))
      {
        paramArrayOfByte = (fft)c.b.b(this.rr.otB);
        paramArrayOfByte.abDv = params.abFM;
        a(paramArrayOfByte);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.QtC = params.abFN;
        this.Qsj = params.abDy;
        Log.i("MicroMsg.NetSceneSnsUserPage", "ForSameMd5: " + params.abDy + " , objCount:  " + params.aaWr + ", retTips:" + this.QtC + ", prePageDayEndFlag:" + params.abFO + ", ObjectList:" + params.YMT.size() + ", ContinueID:" + params.abFM + ", requestTime:" + this.Hit);
        this.QtH = params.abFL;
        if (params.YMT.size() == 0)
        {
          if (paramInt1 == 0)
          {
            Log.e("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
            if (this.rr.otC.getRetCode() != 203) {
              break label2357;
            }
            bool = true;
            this.QtG = bool;
            if (this.QtI != ay.QyA) {
              break label2363;
            }
            this.QtF = true;
          }
          for (;;)
          {
            aYn(this.userName);
            this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
            this.Qsh = this.maxId;
            AppMethodBeat.o(95686);
            return;
            bool = false;
            break;
            this.QtE = true;
          }
        }
        if (this.QtI == ay.QyA) {
          if (params.abFO) {
            this.QtD = ((SnsObject)params.YMT.getFirst()).Id;
          }
        }
        for (;;)
        {
          paramArrayOfByte = t.uB(((SnsObject)params.YMT.getFirst()).Id);
          ap.a(this.userName, this.sourceType, params.YMT, paramArrayOfByte);
          ap.n(params.YMT, this.QtI);
          Log.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(ap.maxId), Long.valueOf(ap.Qsh), Integer.valueOf(params.abFi) });
          if (paramInt1 != 0) {
            break;
          }
          aYn(this.userName);
          break;
          if (this.QtI == ay.Qyz) {
            this.QtD = ((SnsObject)params.YMT.getFirst()).Id;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */