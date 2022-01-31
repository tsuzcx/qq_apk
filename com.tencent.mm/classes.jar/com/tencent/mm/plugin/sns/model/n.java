package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class n
  extends m
  implements k
{
  private static Vector<String> opS = new Vector();
  final int bIl;
  private String desc = "";
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  private boolean inQ = false;
  private ArrayList<com.tencent.mm.plugin.sns.storage.n> ioK = new ArrayList();
  private boolean opP;
  private long opQ = 0L;
  private long opR = 0L;
  public int opT = 0;
  public int opU = 0;
  
  public n(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new btb();
    ((b.a)localObject).ecI = new btc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((b.a)localObject).ecG = 601;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.opQ = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.opP = bool;
      this.bIl = 2;
      localObject = (btb)this.dmK.ecE.ecN;
      ((btb)localObject).tJH = "";
      ((btb)localObject).tJI = 0L;
      ((btb)localObject).tJJ = paramString;
      ((btb)localObject).tJK = 1;
      y.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { i.fN(0L), paramString, Integer.valueOf(0) });
      return;
    }
  }
  
  /* Error */
  public static boolean Nu(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/tencent/mm/plugin/sns/model/n:opS	Ljava/util/Vector;
    //   6: aload_0
    //   7: invokevirtual 152	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc 2
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: getstatic 37	com/tencent/mm/plugin/sns/model/n:opS	Ljava/util/Vector;
    //   25: aload_0
    //   26: invokevirtual 155	java/util/Vector:add	(Ljava/lang/Object;)Z
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
  
  public static boolean Nv(String paramString)
  {
    try
    {
      opS.remove(paramString);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private com.tencent.mm.plugin.sns.storage.n b(bto parambto)
  {
    com.tencent.mm.plugin.sns.storage.n localn = new com.tencent.mm.plugin.sns.storage.n();
    Object localObject = new String(parambto.tJU.tFM.toByteArray());
    y.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(parambto.sGd) });
    if (!localn.Oz((String)localObject)) {
      return null;
    }
    parambto.tJU.bs(new byte[0]);
    localn.field_userName = parambto.sxM;
    localn.iB(parambto.mPL);
    localn.field_likeFlag = parambto.tJV;
    localn.gp(parambto.sGd);
    localn.gr(parambto.sGd);
    localn.yp(this.bIl);
    try
    {
      localn.aL(parambto.toByteArray());
      localObject = localn.bGe();
      ((bxk)localObject).hPY = parambto.sxM;
      localn.field_pravited = ((bxk)localObject).trR;
      y.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + parambto.ttI);
      localn.bGB();
      localn.c((bxk)localObject);
      localn.field_type = ((bxk)localObject).tNr.sPI;
      localn.field_subType = ((bxk)localObject).tNr.sPK;
      return localn;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", localException, "", new Object[0]);
      }
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (btc)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramq.HF().spN != 207) && (paramq.HF().spN != 0) && (paramq.HF().spN != 212))
    {
      Nv("@__classify_timeline");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramq.HF().spN == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.inQ = bool;
      this.opT = paramArrayOfByte.tJL;
      this.desc = paramArrayOfByte.sxZ;
      i.fO(this.opQ);
      y.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.ttP), this.desc });
      paramq = paramArrayOfByte.sAA.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = b((bto)paramq.next());
        if (paramArrayOfByte != null) {
          this.ioK.add(paramArrayOfByte);
        }
      }
    }
    Nv("@__classify_timeline");
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 601;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */