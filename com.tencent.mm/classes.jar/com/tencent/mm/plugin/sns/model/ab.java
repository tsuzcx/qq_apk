package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.Vector;

public final class ab
  extends q
  implements com.tencent.mm.network.m, b
{
  private static Vector<String> DJt;
  private String DIL;
  private boolean DIe;
  private long DIf;
  long DIg;
  public int DIi;
  private boolean DJA;
  public long DJB;
  public int DJC;
  public int DJD;
  private long DJd;
  private boolean DJg;
  private int DJu;
  private boolean DJv;
  private String DJw;
  public long DJx;
  private boolean DJy;
  private boolean DJz;
  public i callback;
  private boolean dJM;
  private com.tencent.mm.ak.d rr;
  private int sourceType;
  String userName;
  
  static
  {
    AppMethodBeat.i(95688);
    DJt = new Vector();
    AppMethodBeat.o(95688);
  }
  
  public ab(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(160650);
    this.DJd = 0L;
    this.DIf = 0L;
    this.DIg = 0L;
    this.DJu = 0;
    this.DJv = false;
    this.DIL = "";
    this.DJw = "";
    this.DJx = 0L;
    this.DJy = false;
    this.DJz = false;
    this.DJg = false;
    this.DJA = false;
    this.DIi = 0;
    this.DJC = -1;
    this.DJD = 0;
    this.userName = paramString;
    this.DIf = paramLong;
    this.dJM = paramBoolean;
    this.DJC = paramInt2;
    Object localObject;
    if (paramLong == 0L)
    {
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      this.sourceType = paramInt4;
      this.DJD = paramInt5;
      localObject = new d.a();
      ((d.a)localObject).iLN = new ebk();
      ((d.a)localObject).iLO = new ebl();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((d.a)localObject).funcId = 212;
      ((d.a)localObject).iLP = 99;
      ((d.a)localObject).respCmdId = 1000000099;
      this.rr = ((d.a)localObject).aXF();
      localObject = (ebk)this.rr.iLK.iLR;
      ((ebk)localObject).Username = paramString;
      ((ebk)localObject).MZh = paramLong;
      ((ebk)localObject).Nbe = paramInt3;
      if (paramLong != 0L) {
        break label392;
      }
    }
    label392:
    for (boolean bool = true;; bool = false)
    {
      this.DIe = bool;
      if ((paramInt2 != ax.DOe) && (paramInt2 != ax.DOf) && (paramInt2 != ax.DOd)) {
        break label398;
      }
      ((ebk)localObject).Nau = 0L;
      ((ebk)localObject).xub = paramInt1;
      if (paramInt2 == ax.DOe) {
        ((ebk)localObject).NaA = 1;
      }
      this.sourceType = 16;
      Log.i("MicroMsg.NetSceneSnsUserPage", "maxId:%s, minId:%s, snsSource:%s, pullType:%s", new Object[] { r.Jb(paramLong), r.Jb(this.DIg), Integer.valueOf(paramInt1), Integer.valueOf(((ebk)localObject).NaA) });
      this.DJd = paramLong;
      AppMethodBeat.o(160650);
      return;
      Log.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
    }
    label398:
    paramInt2 = aj.faE().aPn(paramString);
    n localn = aj.faO();
    long l;
    if (this.DIe)
    {
      l = 0L;
      label422:
      this.DIg = localn.b(l, paramInt2, paramString, paramBoolean);
      ((ebk)localObject).Nau = this.DIg;
      paramInt3 = d.a(this.DIg, paramLong, paramString);
      ((ebk)localObject).Nav = paramInt3;
      ((ebk)localObject).xub = paramInt1;
      if (this.DIe) {
        if (!fam()) {
          break label605;
        }
      }
    }
    label605:
    for (this.DIL = aj.faS().aQr(paramString).field_albumMd5;; this.DIL = aj.faS().aQr(paramString).field_md5)
    {
      if (this.DIL == null) {
        this.DIL = "";
      }
      ((ebk)localObject).MZg = this.DIL;
      Log.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + paramInt2 + " maxId:" + r.Jb(paramLong) + " minId:" + r.Jb(this.DIg) + " lastReqTime:" + paramInt3 + " snsSource " + paramInt1);
      break;
      l = paramLong;
      break label422;
    }
  }
  
  private void a(ebl paramebl, String paramString)
  {
    AppMethodBeat.i(95685);
    an.a(this.userName, this.sourceType, paramebl.KOH, paramString);
    if (this.DIf == 0L) {}
    for (this.DIf = ((SnsObject)paramebl.KOH.getFirst()).Id;; this.DIf = d.Jf(this.DIf))
    {
      this.DIg = ((SnsObject)paramebl.KOH.getLast()).Id;
      Log.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg), Integer.valueOf(paramebl.NaG) });
      d.f(this.userName, this.DIf, this.DIg, paramebl.NaG);
      AppMethodBeat.o(95685);
      return;
    }
  }
  
  /* Error */
  public static boolean aPd(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 346
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 55	com/tencent/mm/plugin/sns/model/ab:DJt	Ljava/util/Vector;
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
    //   32: getstatic 55	com/tencent/mm/plugin/sns/model/ab:DJt	Ljava/util/Vector;
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
  
  public static boolean aPe(String paramString)
  {
    try
    {
      AppMethodBeat.i(95682);
      DJt.remove(paramString);
      AppMethodBeat.o(95682);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean fam()
  {
    return this.sourceType == 64;
  }
  
  private void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95684);
    Object localObject = aj.faO();
    String str = this.userName;
    boolean bool = this.dJM;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(n.cn(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26,28,29,30 , 34,38,33,37,36,39,41,42) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((n)localObject).iFy.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.DJg = true;
      AppMethodBeat.o(95684);
      return;
    }
    if (i == 0) {
      this.DJy = true;
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
  
  public final boolean eYW()
  {
    return this.DIe;
  }
  
  public final boolean eYX()
  {
    return (this.DJC == ax.DOd) || (this.DJC == ax.DOf) || (this.DJC == ax.DOe);
  }
  
  public final int eYY()
  {
    return this.DJC;
  }
  
  public final boolean eYZ()
  {
    return this.DJz;
  }
  
  public final boolean eZa()
  {
    return this.DJy;
  }
  
  public final boolean eZb()
  {
    return this.DJg;
  }
  
  public final boolean eZc()
  {
    return this.DJA;
  }
  
  public final long eZd()
  {
    return this.DIg;
  }
  
  public final boolean eZe()
  {
    return this.DJv;
  }
  
  public final long eZf()
  {
    return this.DJB;
  }
  
  public final String eZg()
  {
    return this.DJw;
  }
  
  public final boolean eZh()
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95686);
    Log.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ebl localebl = (ebl)((com.tencent.mm.ak.d)params).iLL.iLR;
    boolean bool;
    if (this.DJC == -1)
    {
      if ((this.rr.iLL.getRetCode() != 207) && (this.rr.iLL.getRetCode() != 203) && (this.rr.iLL.getRetCode() != 0) && (this.rr.iLL.getRetCode() != 2001) && (this.rr.iLL.getRetCode() != 2004) && (this.rr.iLL.getRetCode() != 2005) && (this.rr.iLL.getRetCode() != 2003))
      {
        aPe(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      if (this.rr.iLL.getRetCode() == 2003)
      {
        params = aj.faO();
        paramArrayOfByte = this.userName;
        Log.printInfoStack("MicroMsg.SnsInfoStorage", "deleteByUserName userName:%s", new Object[] { paramArrayOfByte });
        str1 = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + Util.escapeSqlValue(paramArrayOfByte) + "\"";
        bool = params.iFy.execSQL("SnsInfo", str1);
        Log.d("MicroMsg.SnsInfoStorage", "del snsinfo " + paramArrayOfByte + " res " + bool);
      }
      this.DJw = localebl.Nbi;
      this.DIi = localebl.MZk;
      Log.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localebl.MZk + " , objCount:  " + localebl.MvM + ", retTips:" + this.DJw);
      this.DJB = localebl.Nbg;
      String str1 = r.Jc(this.DIf);
      if (!this.DIe)
      {
        Log.d("MicroMsg.NetSceneSnsUserPage", "np  " + localebl.KOH.size());
        if (localebl.KOH.isEmpty()) {
          if (this.rr.iLL.getRetCode() == 203)
          {
            bool = true;
            this.DJA = bool;
            aj.faO().f(this.userName, this.dJM, str1);
            this.DJy = true;
            this.DIg = this.DIf;
          }
        }
        for (;;)
        {
          aPe(this.userName);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95686);
          return;
          bool = false;
          break;
          a(localebl, str1);
        }
      }
      aj.faS().D(this.userName, localebl.MZG);
      if (this.DIL.equals(localebl.MZg))
      {
        params = aj.faO();
        if (this.DIe) {}
        for (long l = 0L;; l = this.DJd)
        {
          this.DIg = params.b(l, this.DIi, this.userName, this.dJM);
          Log.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.DIg) });
          iu(paramInt2, paramInt3);
          aPe(this.userName);
          params = aj.faS().aQr(this.userName);
          this.callback.onSceneEnd(params.field_lastFirstPageRequestErrType, params.field_lastFirstPageRequestErrCode, paramString, this);
          AppMethodBeat.o(95686);
          return;
        }
      }
      Log.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localebl.KOH.size());
      if ((!this.DIe) || (this.DIL.equals(localebl.MZg)))
      {
        if (!fam()) {
          break label1295;
        }
        aj.faS().p(this.userName, localebl.MZg, paramInt2, paramInt3);
        label820:
        if ((this.rr.iLL.getRetCode() != 207) && (this.rr.iLL.getRetCode() != 2001) && (this.rr.iLL.getRetCode() != 2004) && (this.rr.iLL.getRetCode() != 2005)) {
          break label1476;
        }
        aj.faS().kK(this.userName, "");
        if (!localebl.KOH.isEmpty()) {
          break label1316;
        }
        params = aj.faO();
        paramArrayOfByte = this.userName;
        bool = this.dJM;
        params.F(bool, n.cn(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
        this.DIg = this.DIf;
      }
      for (;;)
      {
        iu(paramInt2, paramInt3);
        aPe(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
        this.DJu = localebl.Nbf;
        params = aj.faS().aQr(this.userName);
        params.field_icount = this.DJu;
        paramArrayOfByte = localebl.MmQ;
        if (paramArrayOfByte != null)
        {
          localObject = r.Jb(paramArrayOfByte.kel);
          str2 = aj.getAccSnsPath();
          String str3 = this.userName + "bg_";
          String str4 = this.userName + "tbg_";
          if ((params.field_bgUrl == null) || (!params.field_bgId.equals(localObject)))
          {
            params.field_older_bgId = params.field_bgId;
            if (com.tencent.mm.vfs.s.YS(ar.ki(str2, this.userName) + str3))
            {
              com.tencent.mm.vfs.s.deleteFile(ar.ki(str2, this.userName) + str4);
              com.tencent.mm.vfs.s.bo(ar.ki(str2, this.userName), str3, str4);
            }
            this.DJv = true;
            params.feI();
            Log.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + paramArrayOfByte.kek);
          }
          params.field_bgId = ((String)localObject);
          params.field_bgUrl = paramArrayOfByte.kek;
          params.field_snsBgId = paramArrayOfByte.kel;
        }
        aj.faS().a(params);
        break;
        label1295:
        aj.faS().o(this.userName, localebl.MZg, paramInt2, paramInt3);
        break label820;
        label1316:
        Object localObject = aj.faO();
        params = this.userName;
        bool = this.dJM;
        String str2 = r.Jc(((SnsObject)localebl.KOH.getFirst()).Id);
        paramArrayOfByte = n.cn(params, bool) + " AND  (snsId != 0  ) ";
        params = paramArrayOfByte;
        if (n.aQw(str2)) {
          params = paramArrayOfByte + " AND " + ((n)localObject).aQz(str2);
        }
        ((n)localObject).F(bool, params);
        aj.faO().f(this.userName, this.dJM, r.Jc(((SnsObject)localebl.KOH.getLast()).Id));
        a(localebl, str1);
      }
      label1476:
      if (localebl.KOH.size() == 0)
      {
        Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95686);
        return;
      }
      a(localebl, str1);
      aPe(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    if ((this.rr.iLL.getRetCode() != 207) && (this.rr.iLL.getRetCode() != 203) && (this.rr.iLL.getRetCode() != 0) && (this.rr.iLL.getRetCode() != 2001) && (this.rr.iLL.getRetCode() != 2004) && (this.rr.iLL.getRetCode() != 2005) && (this.rr.iLL.getRetCode() != 2003))
    {
      aPe(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
    }
    this.DJw = localebl.Nbi;
    this.DIi = localebl.MZk;
    Log.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localebl.MZk + " , objCount:  " + localebl.MvM + ", retTips:" + this.DJw + ", prePageDayEndFlag:" + localebl.Nbj);
    this.DJB = localebl.Nbg;
    Log.d("MicroMsg.NetSceneSnsUserPage", "do search  " + localebl.KOH.size());
    if (localebl.KOH.size() == 0)
    {
      Log.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      if (this.rr.iLL.getRetCode() == 203)
      {
        bool = true;
        this.DJA = bool;
        if (this.DJC != ax.DOe) {
          break label1916;
        }
        this.DJz = true;
      }
      for (;;)
      {
        aPe(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.DIg = this.DIf;
        AppMethodBeat.o(95686);
        return;
        bool = false;
        break;
        label1916:
        this.DJy = true;
      }
    }
    if (this.DJC == ax.DOe) {
      if (localebl.Nbj) {
        this.DJx = ((SnsObject)localebl.KOH.getFirst()).Id;
      }
    }
    for (;;)
    {
      params = r.Jc(((SnsObject)localebl.KOH.getFirst()).Id);
      an.a(this.userName, this.sourceType, localebl.KOH, params);
      an.j(localebl.KOH, this.DJC);
      Log.i("MicroMsg.NetSceneSnsUserPage", "insertSearchCacheList userName:%s maxId:%s minId:%s NewRequestTime:%s", new Object[] { this.userName, Long.valueOf(an.DIf), Long.valueOf(an.DIg), Integer.valueOf(localebl.NaG) });
      aPe(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95686);
      return;
      if (this.DJC == ax.DOd) {
        this.DJx = ((SnsObject)localebl.KOH.getFirst()).Id;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab
 * JD-Core Version:    0.7.0.1
 */