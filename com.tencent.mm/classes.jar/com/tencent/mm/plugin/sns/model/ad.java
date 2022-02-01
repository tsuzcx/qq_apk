package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.j;
import com.tencent.mm.plugin.sns.c.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fge;
import com.tencent.mm.protocal.protobuf.fgf;
import com.tencent.mm.protocal.protobuf.fgg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.Vector;

public final class ad
  extends p
  implements m, b
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
  private long QtD;
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
    AppMethodBeat.i(309423);
    Qtz = new Vector();
    AppMethodBeat.o(309423);
  }
  
  public ad(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramString, paramLong, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1);
  }
  
  public ad(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(309409);
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
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.QtJ = paramInt5;
      localObject = new c.a();
      ((c.a)localObject).otE = new fgf();
      ((c.a)localObject).otF = new fgg();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnswwuserpage";
      ((c.a)localObject).funcId = 5203;
      this.rr = ((c.a)localObject).bEF();
      localObject = (fgf)c.b.b(this.rr.otB);
      ((fgf)localObject).Username = paramString;
      ((fgf)localObject).abDv = paramLong;
      ((fgf)localObject).abFH = paramInt3;
      if (paramLong != 0L) {
        break label389;
      }
    }
    label389:
    for (boolean bool = true;; bool = false)
    {
      this.Qsg = bool;
      if ((paramInt2 != ay.QyA) && (paramInt2 != ay.QyB) && (paramInt2 != ay.Qyz)) {
        break label395;
      }
      ((fgf)localObject).abEV = 0L;
      ((fgf)localObject).IcB = paramInt1;
      if (paramInt2 == ay.QyA) {
        ((fgf)localObject).abFb = 1;
      }
      this.sourceType = 16;
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { t.uA(paramLong), t.uA(this.Qsh), Integer.valueOf(paramInt1), Integer.valueOf(((fgf)localObject).abFb) });
      this.Qte = paramLong;
      AppMethodBeat.o(309409);
      return;
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label395:
    paramInt2 = al.hgr().aYB(paramString);
    w localw = al.hgB();
    long l;
    if (this.Qsg)
    {
      l = 0L;
      label419:
      this.Qsh = localw.a(l, paramInt2, paramString, paramBoolean);
      ((fgf)localObject).abEV = this.Qsh;
      paramInt3 = d.b(this.Qsh, paramLong, paramString);
      ((fgf)localObject).abEW = paramInt3;
      ((fgf)localObject).IcB = paramInt1;
      if (this.Qsg) {
        if (!hfS()) {
          break label612;
        }
      }
    }
    label612:
    for (this.QsM = al.hgF().aZT(paramString);; this.QsM = al.hgF().aZS(paramString))
    {
      if (this.QsM == null) {
        this.QsM = "";
      }
      ((fgf)localObject).abDu = this.QsM;
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "nextCount: " + paramInt2 + " maxId:" + t.uA(paramLong) + " minId:" + t.uA(this.Qsh) + " lastReqTime:" + paramInt3 + " snsSource:" + paramInt1 + " FirstPageMd5:" + this.QsM);
      break;
      l = paramLong;
      break label419;
    }
  }
  
  private void a(final fgf paramfgf)
  {
    AppMethodBeat.i(309418);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309474);
        Log.i("MicroMsg.NetSceneSnsWwUserPage", "doFetchByContinueID continueID:%s", new Object[] { Long.valueOf(paramfgf.abDv) });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(new ad(paramfgf.Username, paramfgf.abDv, ad.a(ad.this), paramfgf.IcB, ad.this.QtI, paramfgf.abFH, ad.b(ad.this), ad.this.QtJ, ad.c(ad.this) + 1), 0);
        AppMethodBeat.o(309474);
      }
    });
    AppMethodBeat.o(309418);
  }
  
  private void a(fgg paramfgg, String paramString)
  {
    AppMethodBeat.i(309414);
    ap.a(this.userName, this.sourceType, paramfgg.YMT, paramString);
    if (this.maxId == 0L) {}
    for (this.maxId = ((SnsObject)paramfgg.YMT.getFirst()).Id;; this.maxId = d.uE(this.maxId))
    {
      this.Qsh = ((SnsObject)paramfgg.YMT.getLast()).Id;
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.maxId), Long.valueOf(this.Qsh), Integer.valueOf(paramfgg.abFi) });
      d.f(this.userName, this.maxId, this.Qsh, paramfgg.abFi);
      AppMethodBeat.o(309414);
      return;
    }
  }
  
  /* Error */
  public static boolean aYo(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 359
    //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 58	com/tencent/mm/plugin/sns/model/ad:Qtz	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 363	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 359
    //   24: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 58	com/tencent/mm/plugin/sns/model/ad:Qtz	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 366	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 359
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
  
  public static boolean aYp(String paramString)
  {
    try
    {
      AppMethodBeat.i(309404);
      Qtz.remove(paramString);
      AppMethodBeat.o(309404);
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
    AppMethodBeat.i(309412);
    int i = al.hgB().df(this.userName, this.hHq);
    if ((i <= 10) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Qth = true;
      AppMethodBeat.o(309412);
      return;
    }
    if ((i == 0) || ((i <= 10) && (paramInt2 == 207))) {
      this.QtE = true;
    }
    AppMethodBeat.o(309412);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(309434);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(309434);
    return i;
  }
  
  public final int getType()
  {
    return 5203;
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
    AppMethodBeat.i(309430);
    Log.i("MicroMsg.NetSceneSnsWwUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (fgg)c.c.b(((com.tencent.mm.am.c)params).otC);
    boolean bool;
    if (this.QtI == -1)
    {
      if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 203) && (this.rr.otC.getRetCode() != 0) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005) && (this.rr.otC.getRetCode() != 2003))
      {
        aYp(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(309430);
        return;
      }
      if (this.rr.otC.getRetCode() == 2003) {
        al.hgB().aZZ(this.userName);
      }
      this.QtC = params.abFN;
      this.Qsj = params.abDy;
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "ForSameMd5 count: " + params.abDy + " , objCount:" + params.aaWr + ", retTips:" + this.QtC + ", ContinueID:" + params.abFM + ", requestTime:" + this.Hit);
      this.QtH = params.abFL;
      paramArrayOfByte = t.uB(this.maxId);
      if (!this.Qsg)
      {
        Log.d("MicroMsg.NetSceneSnsWwUserPage", "np  " + params.YMT.size());
        if (params.YMT.isEmpty()) {
          if ((params.abFM != 0L) && (this.rr.otC.getRetCode() != 207) && (this.Hit <= 50))
          {
            paramArrayOfByte = (fgf)c.b.b(this.rr.otB);
            paramArrayOfByte.abDv = params.abFM;
            a(paramArrayOfByte);
          }
        }
        for (;;)
        {
          aYp(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(309430);
          return;
          if (this.rr.otC.getRetCode() == 203) {}
          for (bool = true;; bool = false)
          {
            this.QtG = bool;
            al.hgB().i(this.userName, this.hHq, paramArrayOfByte);
            this.QtE = true;
            this.Qsh = this.maxId;
            break;
          }
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
          Log.i("MicroMsg.NetSceneSnsWwUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.Qsh) });
          lp(paramInt2, paramInt3);
          aYp(this.userName);
          params = al.hgF().aZW(this.userName);
          this.callback.onSceneEnd(params.field_lastFirstPageRequestErrType, params.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(309430);
          return;
        }
      }
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "fp  " + params.YMT.size());
      if ((!this.Qsg) || (this.QsM.equals(params.abDu)))
      {
        if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005)) {
          break label1552;
        }
        al.hgF().mP(this.userName, "");
        if (!params.YMT.isEmpty()) {
          break label1433;
        }
        if ((params.abFM == 0L) || (this.rr.otC.getRetCode() == 207) || (this.Hit > 50)) {
          break label1408;
        }
        paramArrayOfByte = (fgf)c.b.b(this.rr.otB);
        paramArrayOfByte.abDv = params.abFM;
        a(paramArrayOfByte);
      }
      for (;;)
      {
        lp(paramInt2, paramInt3);
        aYp(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(309430);
        return;
        this.QtA = params.abFK;
        u localu = al.hgF().aZW(this.userName);
        localu.field_icount = this.QtA;
        fge localfge = params.abGh;
        Object localObject;
        if (localfge != null)
        {
          localObject = localfge.abGg;
          String str1 = al.getAccSnsPath();
          String str2 = this.userName + "bg_";
          String str3 = this.userName + "tbg_";
          if ((localu.field_bgUrl == null) || (localu.field_bgId == null) || (!localu.field_bgId.equals(localObject)))
          {
            localu.field_older_bgId = localu.field_bgId;
            if (y.ZC(as.mg(str1, this.userName) + str2))
            {
              y.deleteFile(as.mg(str1, this.userName) + str3);
              y.bF(as.mg(str1, this.userName), str2, str3);
            }
            this.QtB = true;
            localu.hkO();
            Log.d("MicroMsg.NetSceneSnsWwUserPage", "get new BGurl: " + localfge.abGa);
          }
          localu.field_bgId = ((String)localObject);
          localu.field_bgUrl = localfge.abGa;
          localu.field_snsBgId = 0L;
          localu.field_imBGaeskey = localfge.abGe;
          localu.field_imBGauthkey = localfge.abGf;
          localu.field_imBGmd5sum = localfge.abGb;
          localu.field_imBGfileid = localfge.abGc;
          localObject = al.hgp().JE(this.userName);
          if (localObject != null)
          {
            com.tencent.mm.kernel.h.baF();
            if ((((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getSnsFlagStg().RV(this.userName) & 0x2) != 0L) {
              break label1395;
            }
            ((com.tencent.mm.contact.d)localObject).Bo("");
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.NetSceneSnsWwUserPage", "readfpInfo, id:%s, url:%s", new Object[] { localu.field_bgId, localu.field_bgUrl });
          al.hgF().a(localu);
          break;
          label1395:
          ((com.tencent.mm.contact.d)localObject).Bo(localfge.pSi);
        }
        label1408:
        al.hgB().dc(this.userName, this.hHq);
        this.Qsh = this.maxId;
      }
      label1433:
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
      label1552:
      if (params.YMT.size() == 0)
      {
        if ((params.abFM != 0L) && (this.rr.otC.getRetCode() != 207) && (this.Hit <= 50))
        {
          paramString = (fgf)c.b.b(this.rr.otB);
          paramString.abDv = params.abFM;
          a(paramString);
          AppMethodBeat.o(309430);
          return;
        }
        Log.d("MicroMsg.NetSceneSnsWwUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(309430);
        return;
      }
      if (hfS()) {
        al.hgF().t(this.userName, params.abDu, paramInt2, paramInt3);
      }
      for (;;)
      {
        a(params, paramArrayOfByte);
        aYp(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(309430);
        return;
        al.hgF().s(this.userName, params.abDu, paramInt2, paramInt3);
      }
    }
    if ((this.rr.otC.getRetCode() != 207) && (this.rr.otC.getRetCode() != 203) && (this.rr.otC.getRetCode() != 0) && (this.rr.otC.getRetCode() != 2001) && (this.rr.otC.getRetCode() != 2004) && (this.rr.otC.getRetCode() != 2005) && (this.rr.otC.getRetCode() != 2003))
    {
      aYp(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(309430);
      return;
    }
    this.QtC = params.abFN;
    this.Qsj = params.abDy;
    Log.i("MicroMsg.NetSceneSnsWwUserPage", "ForSameMd5: " + params.abDy + " , objCount:  " + params.aaWr + ", retTips:" + this.QtC + ", prePageDayEndFlag:" + params.abFO + ", ObjectList:" + params.YMT.size() + ", ContinueID:" + params.abFM + ", requestTime:" + this.Hit);
    this.QtH = params.abFL;
    if (params.YMT.size() == 0)
    {
      if ((params.abFM != 0L) && (this.rr.otC.getRetCode() != 207) && (this.Hit <= 50))
      {
        paramString = (fgf)c.b.b(this.rr.otB);
        paramString.abDv = params.abFM;
        a(paramString);
        AppMethodBeat.o(309430);
        return;
      }
      Log.e("MicroMsg.NetSceneSnsWwUserPage", "error: server give size zero");
      if (this.rr.otC.getRetCode() == 203)
      {
        bool = true;
        this.QtG = bool;
        if (this.QtI != ay.QyA) {
          break label2199;
        }
        this.QtF = true;
      }
      for (;;)
      {
        aYp(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.Qsh = this.maxId;
        AppMethodBeat.o(309430);
        return;
        bool = false;
        break;
        label2199:
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
      Log.i("MicroMsg.NetSceneSnsWwUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(ap.maxId), Long.valueOf(ap.Qsh), Integer.valueOf(params.abFi) });
      aYp(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(309430);
      return;
      if (this.QtI == ay.Qyz) {
        this.QtD = ((SnsObject)params.YMT.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */