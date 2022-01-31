package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdb;
import com.tencent.mm.protocal.c.cdd;
import com.tencent.mm.protocal.c.cde;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class m
  extends com.tencent.mm.ah.m
  implements k
{
  public int bNb = 0;
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  public String fgB;
  public List<String> rTv = null;
  public String rTw;
  private List<String> rTx = null;
  
  public m(int paramInt, List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(paramInt, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public m(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.bNb = paramInt;
      this.rTv = paramList1;
      if (paramList2 != null)
      {
        localObject = paramList2;
        if (paramList2.size() != 0) {}
      }
      else
      {
        localObject = new LinkedList();
      }
      paramList2 = new b.a();
      paramList2.ecH = new cdd();
      paramList2.ecI = new cde();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.ecG = 137;
      paramList2.ecJ = 44;
      paramList2.ecK = 1000000044;
      this.dmK = paramList2.Kt();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label277;
        }
        y.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
      }
    }
    for (;;)
    {
      if (paramInt != 2) {
        break label335;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        ((List)localObject).add(bk.aM(a.YT().Ga().aaE((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label277:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.YT().Ga().z((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label335:
    cdd localcdd = (cdd)this.dmK.ecE.ecN;
    localcdd.syV = paramInt;
    localcdd.tgV = paramString1;
    this.rTw = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      cdb localcdb = new cdb();
      localcdb.nFs = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localcdb.tRS = paramList2;
        paramList2 = a.YT().Ga();
        String str = localcdb.nFs;
        ((Integer)paramList.get(paramInt)).intValue();
        localcdb.tac = bk.aM(paramList2.aaE(str), "");
        if ((TextUtils.isEmpty(localcdb.tac)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localcdb.tac = ((String)((List)localObject).get(paramInt));
        }
        localcdb.tFA = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localcdb.nFs))) {
          localcdb.tRT = ((Integer)paramMap.get(localcdb.nFs)).intValue();
        }
        localcdb.tRX = paramString4;
        y.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", new Object[] { Integer.valueOf(this.bNb), Integer.valueOf(paramInt), localcdb.nFs, localcdb.tac, paramString3, paramString4 });
        paramString1.add(localcdb);
        paramInt += 1;
        break;
      }
    }
    localcdd.tRZ = paramString1;
    localcdd.tRY = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localcdd.tSb = paramList1;
    localcdd.tSa = paramList1.size();
    localcdd.tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
    y.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.bNb), Integer.valueOf(localcdd.tRZ.size()), Integer.valueOf(localcdd.tSb.size()), bk.c((List)localObject, ","), paramString3, bk.csb() });
  }
  
  private m(String paramString1, String paramString2, int paramInt)
  {
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.rTv = new LinkedList();
    this.rTv.add(paramString1);
    this.bNb = 3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cdd();
    ((b.a)localObject).ecI = new cde();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).ecG = 137;
    ((b.a)localObject).ecJ = 44;
    ((b.a)localObject).ecK = 1000000044;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cdd)this.dmK.ecE.ecN;
    ((cdd)localObject).syV = 3;
    ((cdd)localObject).tgV = "";
    LinkedList localLinkedList = new LinkedList();
    cdb localcdb = new cdb();
    localcdb.nFs = paramString1;
    localcdb.tRS = paramString2;
    localcdb.tac = a.YT().Ga().aaE(paramString1);
    localcdb.tFA = null;
    localLinkedList.add(localcdb);
    ((cdd)localObject).tRZ = localLinkedList;
    ((cdd)localObject).tRY = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt));
    ((cdd)localObject).tSb = paramString1;
    ((cdd)localObject).tSa = paramString1.size();
    ((cdd)localObject).tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
    y.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", new Object[] { Integer.valueOf(((cdd)localObject).tRZ.size()), Integer.valueOf(((cdd)localObject).tSb.size()), paramString2, localcdb.tac });
  }
  
  public m(String paramString1, String paramString2, int paramInt, byte paramByte)
  {
    this(paramString1, paramString2, paramInt);
  }
  
  public m(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(2, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final String ckC()
  {
    if ((this.dmK != null) && (this.dmK.ecF != null)) {
      return ((cde)this.dmK.ecF.ecN).hPY;
    }
    return "";
  }
  
  public final int ckD()
  {
    return this.bNb;
  }
  
  public final void fP(String paramString1, String paramString2)
  {
    Iterator localIterator = ((cdd)this.dmK.ecE.ecN).tRZ.iterator();
    while (localIterator.hasNext())
    {
      cdb localcdb = (cdb)localIterator.next();
      localcdb.tRU = paramString1;
      localcdb.tRV = paramString2;
    }
  }
  
  public final int getType()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */