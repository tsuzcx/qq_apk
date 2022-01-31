package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.buu;
import com.tencent.mm.protocal.c.buv;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Vector;

public final class aa
  extends com.tencent.mm.ah.m
  implements k, d
{
  private static Vector<String> oqU = new Vector();
  private final int bIl;
  private boolean bMo;
  private b dmK;
  public f dmL;
  private boolean opP;
  private long opQ = 0L;
  long opR = 0L;
  public int opT = 0;
  private long oqI = 0L;
  private boolean oqJ = false;
  private boolean oqK = false;
  private int oqV = 0;
  private boolean oqW = false;
  private boolean oqX = false;
  public long oqY;
  private String oqr = "";
  String userName;
  
  public aa(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    this.userName = paramString;
    this.opQ = paramLong;
    this.bMo = paramBoolean;
    int i;
    label112:
    Object localObject;
    o localo;
    if (paramLong == 0L)
    {
      y.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + paramString);
      if (!paramBoolean) {
        break label444;
      }
      i = 4;
      this.bIl = i;
      localObject = new b.a();
      ((b.a)localObject).ecH = new buu();
      ((b.a)localObject).ecI = new buv();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).ecG = 212;
      ((b.a)localObject).ecJ = 99;
      ((b.a)localObject).ecK = 1000000099;
      this.dmK = ((b.a)localObject).Kt();
      localObject = (buu)this.dmK.ecE.ecN;
      ((buu)localObject).sxM = paramString;
      ((buu)localObject).tJI = paramLong;
      if (paramLong == 0L) {
        bool = true;
      }
      this.opP = bool;
      i = af.bDv().NH(paramString);
      localo = af.bDF();
      if (!this.opP) {
        break label451;
      }
    }
    for (;;)
    {
      this.opR = localo.a(l, i, paramString, paramBoolean);
      ((buu)localObject).tLe = this.opR;
      int j = c.a(this.opR, paramLong, paramString);
      ((buu)localObject).tLf = j;
      ((buu)localObject).swS = paramInt;
      if (this.opP)
      {
        this.oqr = af.bDJ().OF(paramString).field_md5;
        if (this.oqr == null) {
          this.oqr = "";
        }
        ((buu)localObject).tJH = this.oqr;
      }
      this.oqI = paramLong;
      y.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + i + " maxId:" + i.fN(paramLong) + " minId:" + i.fN(this.opR) + " lastReqTime:" + j + " snsSource " + paramInt);
      return;
      y.i("MicroMsg.NetSceneSnsUserPage", "np userName " + paramString);
      break;
      label444:
      i = 8;
      break label112;
      label451:
      l = paramLong;
    }
  }
  
  /* Error */
  public static boolean Nx(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/tencent/mm/plugin/sns/model/aa:oqU	Ljava/util/Vector;
    //   6: aload_0
    //   7: invokevirtual 234	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc 2
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: getstatic 43	com/tencent/mm/plugin/sns/model/aa:oqU	Ljava/util/Vector;
    //   25: aload_0
    //   26: invokevirtual 237	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   29: pop
    //   30: iconst_1
    //   31: istore_1
    //   32: goto -15 -> 17
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramString	String
    //   10	22	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	11	35	finally
    //   22	30	35	finally
  }
  
  public static boolean Ny(String paramString)
  {
    try
    {
      oqU.remove(paramString);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(buv parambuv, String paramString)
  {
    aj.a(this.userName, this.bIl, parambuv.sAA, paramString);
    if (this.opQ == 0L) {}
    for (this.opQ = ((bto)parambuv.sAA.getFirst()).sGd;; this.opQ = c.fR(this.opQ))
    {
      this.opR = ((bto)parambuv.sAA.getLast()).sGd;
      y.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.opQ), Long.valueOf(this.opR), Integer.valueOf(parambuv.tLh) });
      c.f(this.userName, this.opQ, this.opR, parambuv.tLh);
      return;
    }
  }
  
  private void bDd()
  {
    Object localObject = af.bDF();
    String str = this.userName;
    boolean bool = this.bMo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(o.bd(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((o)localObject).dXw.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0)) {
      this.oqK = true;
    }
    while (i != 0) {
      return;
    }
    this.oqJ = true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    buv localbuv = (buv)((b)paramq).ecF.ecN;
    if ((paramq.HF().spN != 207) && (paramq.HF().spN != 203) && (paramq.HF().spN != 0) && (paramq.HF().spN != 2001) && (paramq.HF().spN != 2004) && (paramq.HF().spN != 2003))
    {
      Ny(this.userName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    Object localObject;
    boolean bool;
    if (paramq.HF().spN == 2003)
    {
      paramArrayOfByte = af.bDF();
      str1 = this.userName;
      localObject = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bk.pl(str1) + "\"";
      bool = paramArrayOfByte.dXw.gk("SnsInfo", (String)localObject);
      y.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str1 + " res " + bool);
    }
    this.opT = localbuv.tJL;
    y.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localbuv.tJL + " , objCount:  " + localbuv.ttP);
    this.oqY = localbuv.tLr;
    String str1 = i.fO(this.opQ);
    if (!this.opP)
    {
      y.d("MicroMsg.NetSceneSnsUserPage", "np  " + localbuv.sAA.size());
      if (localbuv.sAA.isEmpty()) {
        if (paramq.HF().spN == 203)
        {
          bool = true;
          this.oqX = bool;
          af.bDF().c(this.userName, this.bMo, str1);
          this.oqJ = true;
          this.opR = this.opQ;
        }
      }
      for (;;)
      {
        Ny(this.userName);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        bool = false;
        break;
        a(localbuv, str1);
      }
    }
    if (this.oqr.equals(localbuv.tJH))
    {
      paramq = af.bDF();
      if (this.opP) {}
      for (long l = 0L;; l = this.oqI)
      {
        this.opR = paramq.a(l, this.opT, this.userName, this.bMo);
        y.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.opR) });
        bDd();
        Ny(this.userName);
        paramq = af.bDJ().OF(this.userName);
        this.dmL.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
        return;
      }
    }
    y.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localbuv.sAA.size());
    if ((!this.opP) || (this.oqr.equals(localbuv.tJH)))
    {
      af.bDJ().l(this.userName, localbuv.tJH, paramInt2, paramInt3);
      if ((paramq.HF().spN != 207) && (paramq.HF().spN != 2001) && (paramq.HF().spN != 2004)) {
        break label1321;
      }
      af.bDJ().eX(this.userName, "");
      if (!localbuv.sAA.isEmpty()) {
        break label1161;
      }
      paramq = af.bDF();
      paramArrayOfByte = this.userName;
      bool = this.bMo;
      paramq.m(bool, o.bd(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
      this.opR = this.opQ;
    }
    for (;;)
    {
      bDd();
      Ny(this.userName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      this.oqV = localbuv.tLq;
      paramArrayOfByte = af.bDJ().OF(this.userName);
      paramArrayOfByte.field_icount = this.oqV;
      localObject = localbuv.tpm;
      if (localObject != null)
      {
        str2 = i.fN(((but)localObject).ffu);
        String str3 = af.getAccSnsPath();
        String str4 = this.userName + "bg_";
        String str5 = this.userName + "tbg_";
        if ((paramArrayOfByte.field_bgUrl == null) || (!paramArrayOfByte.field_bgId.equals(str2)))
        {
          paramArrayOfByte.field_older_bgId = paramArrayOfByte.field_bgId;
          if (com.tencent.mm.vfs.e.bK(an.eJ(str3, this.userName) + str4))
          {
            com.tencent.mm.vfs.e.deleteFile(an.eJ(str3, this.userName) + str5);
            com.tencent.mm.vfs.e.f(an.eJ(str3, this.userName), str4, str5);
          }
          this.oqW = true;
          paramArrayOfByte.bGs();
          y.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + ((but)localObject).fft);
        }
        paramArrayOfByte.field_bgId = str2;
        paramArrayOfByte.field_bgUrl = ((but)localObject).fft;
        paramArrayOfByte.field_snsBgId = ((but)localObject).ffu;
      }
      af.bDJ().a(paramArrayOfByte);
      break;
      label1161:
      localObject = af.bDF();
      paramq = this.userName;
      bool = this.bMo;
      String str2 = i.fO(((bto)localbuv.sAA.getFirst()).sGd);
      paramArrayOfByte = o.bd(paramq, bool) + " AND  (snsId != 0  ) ";
      paramq = paramArrayOfByte;
      if (o.OJ(str2)) {
        paramq = paramArrayOfByte + " AND " + ((o)localObject).OM(str2);
      }
      ((o)localObject).m(bool, paramq);
      af.bDF().c(this.userName, this.bMo, i.fO(((bto)localbuv.sAA.getLast()).sGd));
      a(localbuv, str1);
    }
    label1321:
    if (localbuv.sAA.size() == 0)
    {
      y.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    a(localbuv, str1);
    Ny(this.userName);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final boolean bCM()
  {
    return this.opP;
  }
  
  public final boolean bCN()
  {
    return this.oqJ;
  }
  
  public final boolean bCO()
  {
    return this.oqK;
  }
  
  public final boolean bCP()
  {
    return this.oqX;
  }
  
  public final long bCQ()
  {
    return this.opR;
  }
  
  public final boolean bCR()
  {
    return this.oqW;
  }
  
  public final long bCS()
  {
    return this.oqY;
  }
  
  public final int getType()
  {
    return 212;
  }
  
  public final String getUserName()
  {
    return this.userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */