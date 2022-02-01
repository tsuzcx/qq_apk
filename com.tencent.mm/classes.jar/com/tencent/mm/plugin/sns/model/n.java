package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private static Vector<String> zxZ;
  public f callback;
  private ArrayList<p> ddb;
  private String desc;
  private boolean hkx;
  private com.tencent.mm.ak.b rr;
  final int sourceType;
  private boolean zxW;
  private long zxX;
  private long zxY;
  public int zya;
  public int zyb;
  
  static
  {
    AppMethodBeat.i(95585);
    zxZ = new Vector();
    AppMethodBeat.o(95585);
  }
  
  public n(String paramString)
  {
    AppMethodBeat.i(95581);
    this.zxX = 0L;
    this.zxY = 0L;
    this.hkx = false;
    this.ddb = new ArrayList();
    this.zya = 0;
    this.zyb = 0;
    this.desc = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dgf();
    ((b.a)localObject).hQG = new dgg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((b.a)localObject).funcId = 601;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.zxX = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.zxW = bool;
      this.sourceType = 2;
      localObject = (dgf)this.rr.hQD.hQJ;
      ((dgf)localObject).HNx = "";
      ((dgf)localObject).HNy = 0L;
      ((dgf)localObject).HNz = paramString;
      ((dgf)localObject).HNA = 1;
      ae.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { r.zV(0L), paramString, Integer.valueOf(0) });
      AppMethodBeat.o(95581);
      return;
    }
  }
  
  /* Error */
  public static boolean aAe(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 160
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/sns/model/n:zxZ	Ljava/util/Vector;
    //   11: aload_0
    //   12: invokevirtual 164	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   15: ifeq +15 -> 30
    //   18: iconst_0
    //   19: istore_1
    //   20: ldc 160
    //   22: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: getstatic 44	com/tencent/mm/plugin/sns/model/n:zxZ	Ljava/util/Vector;
    //   33: aload_0
    //   34: invokevirtual 167	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: iconst_1
    //   39: istore_1
    //   40: ldc 160
    //   42: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -20 -> 25
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramString	String
    //   19	21	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	18	48	finally
    //   20	25	48	finally
    //   30	38	48	finally
    //   40	45	48	finally
  }
  
  public static boolean aAf(String paramString)
  {
    try
    {
      AppMethodBeat.i(95580);
      zxZ.remove(paramString);
      AppMethodBeat.o(95580);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private p c(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95582);
    p localp = new p();
    Object localObject = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
    ae.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localp.aBp((String)localObject))
    {
      AppMethodBeat.o(95582);
      return null;
    }
    paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
    localp.field_userName = paramSnsObject.Username;
    localp.setCreateTime(paramSnsObject.CreateTime);
    localp.field_likeFlag = paramSnsObject.LikeFlag;
    localp.AC(paramSnsObject.Id);
    localp.AE(paramSnsObject.Id);
    localp.Rq(this.sourceType);
    try
    {
      localp.bL(paramSnsObject.toByteArray());
      localObject = localp.ebP();
      ((TimeLineObject)localObject).nIJ = paramSnsObject.Username;
      localp.field_pravited = ((TimeLineObject)localObject).Hml;
      ae.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + paramSnsObject.ExtFlag);
      localp.ecl();
      localp.f((TimeLineObject)localObject);
      localp.field_type = ((TimeLineObject)localObject).HUG.Gtw;
      localp.field_subType = ((TimeLineObject)localObject).HUG.Gty;
      AppMethodBeat.o(95582);
      return localp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", localException, "", new Object[0]);
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95584);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95584);
    return i;
  }
  
  public final int getType()
  {
    return 601;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95583);
    ae.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (dgg)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0) && (paramq.getRespObj().getRetCode() != 212))
    {
      aAf("@__classify_timeline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95583);
      return;
    }
    if (paramq.getRespObj().getRetCode() == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.hkx = bool;
      this.zya = paramArrayOfByte.HNB;
      this.desc = paramArrayOfByte.FNF;
      r.zW(this.zxX);
      ae.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.Hor), this.desc });
      paramq = paramArrayOfByte.FUY.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = c((SnsObject)paramq.next());
        if (paramArrayOfByte != null) {
          this.ddb.add(paramArrayOfByte);
        }
      }
    }
    aAf("@__classify_timeline");
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */