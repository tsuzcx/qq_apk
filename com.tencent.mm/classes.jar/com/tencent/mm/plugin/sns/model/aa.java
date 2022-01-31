package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Vector;

public final class aa
  extends com.tencent.mm.ai.m
  implements k, d
{
  private static Vector<String> rfF;
  public f callback;
  private final int cpG;
  private boolean ctJ;
  public int reA;
  private boolean rew;
  private long rex;
  long rey;
  private int rfG;
  private boolean rfH;
  private String rfI;
  private boolean rfJ;
  public long rfK;
  private String rfa;
  private long rfs;
  private boolean rft;
  private boolean rfu;
  private b rr;
  String userName;
  
  static
  {
    AppMethodBeat.i(36362);
    rfF = new Vector();
    AppMethodBeat.o(36362);
  }
  
  public aa(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36357);
    this.rfs = 0L;
    this.rex = 0L;
    this.rey = 0L;
    this.rfG = 0;
    this.rfH = false;
    this.rfa = "";
    this.rfI = "";
    this.rft = false;
    this.rfu = false;
    this.rfJ = false;
    this.reA = 0;
    this.userName = paramString;
    this.rex = paramLong;
    this.ctJ = paramBoolean;
    int i;
    label116:
    Object localObject;
    o localo;
    if (paramLong == 0L)
    {
      ab.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(paramString)));
      if (!paramBoolean) {
        break label446;
      }
      i = 4;
      this.cpG = i;
      localObject = new b.a();
      ((b.a)localObject).fsX = new cfk();
      ((b.a)localObject).fsY = new cfl();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
      ((b.a)localObject).funcId = 212;
      ((b.a)localObject).reqCmdId = 99;
      ((b.a)localObject).respCmdId = 1000000099;
      this.rr = ((b.a)localObject).ado();
      localObject = (cfk)this.rr.fsV.fta;
      ((cfk)localObject).Username = paramString;
      ((cfk)localObject).xOl = paramLong;
      if (paramLong == 0L) {
        bool = true;
      }
      this.rew = bool;
      i = ag.coV().aaB(paramString);
      localo = ag.cpf();
      if (!this.rew) {
        break label453;
      }
    }
    for (;;)
    {
      this.rey = localo.a(l, i, paramString, paramBoolean);
      ((cfk)localObject).xPt = this.rey;
      int j = c.a(this.rey, paramLong, paramString);
      ((cfk)localObject).xPu = j;
      ((cfk)localObject).niK = paramInt;
      if (this.rew)
      {
        this.rfa = ag.cpj().abz(paramString).field_md5;
        if (this.rfa == null) {
          this.rfa = "";
        }
        ((cfk)localObject).xOk = this.rfa;
      }
      this.rfs = paramLong;
      ab.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + i + " maxId:" + i.lq(paramLong) + " minId:" + i.lq(this.rey) + " lastReqTime:" + j + " snsSource " + paramInt);
      AppMethodBeat.o(36357);
      return;
      ab.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(paramString)));
      break;
      label446:
      i = 8;
      break label116;
      label453:
      l = paramLong;
    }
  }
  
  private void a(cfl paramcfl, String paramString)
  {
    AppMethodBeat.i(36359);
    ak.b(this.userName, this.cpG, paramcfl.wuP, paramString);
    if (this.rex == 0L) {}
    for (this.rex = ((SnsObject)paramcfl.wuP.getFirst()).Id;; this.rex = c.lw(this.rex))
    {
      this.rey = ((SnsObject)paramcfl.wuP.getLast()).Id;
      ab.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[] { this.userName, Long.valueOf(this.rex), Long.valueOf(this.rey), Integer.valueOf(paramcfl.xPz) });
      c.f(this.userName, this.rex, this.rey, paramcfl.xPz);
      AppMethodBeat.o(36359);
      return;
    }
  }
  
  /* Error */
  public static boolean aaq(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 308
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 51	com/tencent/mm/plugin/sns/model/aa:rfF	Ljava/util/Vector;
    //   12: aload_0
    //   13: invokevirtual 312	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   16: ifeq +16 -> 32
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc_w 308
    //   24: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: getstatic 51	com/tencent/mm/plugin/sns/model/aa:rfF	Ljava/util/Vector;
    //   35: aload_0
    //   36: invokevirtual 315	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: iconst_1
    //   41: istore_1
    //   42: ldc_w 308
    //   45: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean aar(String paramString)
  {
    try
    {
      AppMethodBeat.i(36356);
      rfF.remove(paramString);
      AppMethodBeat.o(36356);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138379);
    Object localObject = ag.cpf();
    String str = this.userName;
    boolean bool = this.ctJ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select snsId from SnsInfo ").append(o.bs(str, bool)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit 4");
    str = localStringBuilder.toString();
    localObject = ((o)localObject).db.rawQuery(str, null);
    int i = ((Cursor)localObject).getCount();
    ((Cursor)localObject).close();
    if ((i <= 3) && (i > 0) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rfu = true;
      AppMethodBeat.o(138379);
      return;
    }
    if (i == 0) {
      this.rft = true;
    }
    AppMethodBeat.o(138379);
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
    return this.rfJ;
  }
  
  public final long cor()
  {
    return this.rey;
  }
  
  public final boolean cos()
  {
    return this.rfH;
  }
  
  public final long cot()
  {
    return this.rfK;
  }
  
  public final String cou()
  {
    return this.rfI;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(36361);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36361);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36360);
    ab.i("MicroMsg.NetSceneSnsUserPage", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    cfl localcfl = (cfl)((b)paramq).fsW.fta;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 203) && (paramq.getRespObj().getRetCode() != 0) && (paramq.getRespObj().getRetCode() != 2001) && (paramq.getRespObj().getRetCode() != 2004) && (paramq.getRespObj().getRetCode() != 2005) && (paramq.getRespObj().getRetCode() != 2003))
    {
      aar(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36360);
      return;
    }
    Object localObject;
    boolean bool;
    if (paramq.getRespObj().getRetCode() == 2003)
    {
      paramArrayOfByte = ag.cpf();
      str1 = this.userName;
      localObject = "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bo.wC(str1) + "\"";
      bool = paramArrayOfByte.db.execSQL("SnsInfo", (String)localObject);
      ab.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str1 + " res " + bool);
    }
    this.rfI = localcfl.xPS;
    this.reA = localcfl.xOo;
    ab.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + localcfl.xOo + " , objCount:  " + localcfl.xtO + ", retTips:" + this.rfI);
    this.rfK = localcfl.xPQ;
    String str1 = i.lr(this.rex);
    if (!this.rew)
    {
      ab.d("MicroMsg.NetSceneSnsUserPage", "np  " + localcfl.wuP.size());
      if (localcfl.wuP.isEmpty()) {
        if (paramq.getRespObj().getRetCode() == 203)
        {
          bool = true;
          this.rfJ = bool;
          ag.cpf().d(this.userName, this.ctJ, str1);
          this.rft = true;
          this.rey = this.rex;
        }
      }
      for (;;)
      {
        aar(this.userName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36360);
        return;
        bool = false;
        break;
        a(localcfl, str1);
      }
    }
    if (this.rfa.equals(localcfl.xOk))
    {
      paramq = ag.cpf();
      if (this.rew) {}
      for (long l = 0L;; l = this.rfs)
      {
        this.rey = paramq.a(l, this.reA, this.userName, this.ctJ);
        ab.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[] { Long.valueOf(this.rey) });
        fu(paramInt2, paramInt3);
        aar(this.userName);
        paramq = ag.cpj().abz(this.userName);
        this.callback.onSceneEnd(paramq.field_lastFirstPageRequestErrType, paramq.field_lastFirstPageRequestErrCode, paramString, this);
        AppMethodBeat.o(36360);
        return;
      }
    }
    ab.i("MicroMsg.NetSceneSnsUserPage", "fp  " + localcfl.wuP.size());
    if ((!this.rew) || (this.rfa.equals(localcfl.xOk)))
    {
      ag.cpj().l(this.userName, localcfl.xOk, paramInt2, paramInt3);
      if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 2001) && (paramq.getRespObj().getRetCode() != 2004) && (paramq.getRespObj().getRetCode() != 2005)) {
        break label1409;
      }
      ag.cpj().gF(this.userName, "");
      if (!localcfl.wuP.isEmpty()) {
        break label1249;
      }
      paramq = ag.cpf();
      paramArrayOfByte = this.userName;
      bool = this.ctJ;
      paramq.s(bool, o.bs(paramArrayOfByte, bool) + " AND  (snsId != 0  ) ");
      this.rey = this.rex;
    }
    for (;;)
    {
      fu(paramInt2, paramInt3);
      aar(this.userName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36360);
      return;
      this.rfG = localcfl.xPP;
      paramArrayOfByte = ag.cpj().abz(this.userName);
      paramArrayOfByte.field_icount = this.rfG;
      localObject = localcfl.xpk;
      if (localObject != null)
      {
        str2 = i.lq(((cfj)localObject).gxc);
        String str3 = ag.getAccSnsPath();
        String str4 = this.userName + "bg_";
        String str5 = this.userName + "tbg_";
        if ((paramArrayOfByte.field_bgUrl == null) || (!paramArrayOfByte.field_bgId.equals(str2)))
        {
          paramArrayOfByte.field_older_bgId = paramArrayOfByte.field_bgId;
          if (com.tencent.mm.vfs.e.cN(ao.gl(str3, this.userName) + str4))
          {
            com.tencent.mm.vfs.e.deleteFile(ao.gl(str3, this.userName) + str5);
            com.tencent.mm.vfs.e.h(ao.gl(str3, this.userName), str4, str5);
          }
          this.rfH = true;
          paramArrayOfByte.csv();
          ab.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + ((cfj)localObject).gxb);
        }
        paramArrayOfByte.field_bgId = str2;
        paramArrayOfByte.field_bgUrl = ((cfj)localObject).gxb;
        paramArrayOfByte.field_snsBgId = ((cfj)localObject).gxc;
      }
      ag.cpj().a(paramArrayOfByte);
      break;
      label1249:
      localObject = ag.cpf();
      paramq = this.userName;
      bool = this.ctJ;
      String str2 = i.lr(((SnsObject)localcfl.wuP.getFirst()).Id);
      paramArrayOfByte = o.bs(paramq, bool) + " AND  (snsId != 0  ) ";
      paramq = paramArrayOfByte;
      if (o.abD(str2)) {
        paramq = paramArrayOfByte + " AND " + ((o)localObject).abG(str2);
      }
      ((o)localObject).s(bool, paramq);
      ag.cpf().d(this.userName, this.ctJ, i.lr(((SnsObject)localcfl.wuP.getLast()).Id));
      a(localcfl, str1);
    }
    label1409:
    if (localcfl.wuP.size() == 0)
    {
      ab.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36360);
      return;
    }
    a(localcfl, str1);
    aar(this.userName);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(36360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */