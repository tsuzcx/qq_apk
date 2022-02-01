package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class m
  extends n
  implements k
{
  private static Vector<String> xRq;
  private ArrayList<p> cQJ;
  public g callback;
  private String desc;
  private boolean gNN;
  private com.tencent.mm.ak.b rr;
  final int sourceType;
  private boolean xRn;
  private long xRo;
  private long xRp;
  public int xRr;
  public int xRs;
  
  static
  {
    AppMethodBeat.i(95585);
    xRq = new Vector();
    AppMethodBeat.o(95585);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(95581);
    this.xRo = 0L;
    this.xRp = 0L;
    this.gNN = false;
    this.cQJ = new ArrayList();
    this.xRr = 0;
    this.xRs = 0;
    this.desc = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new czy();
    ((b.a)localObject).hvu = new czz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((b.a)localObject).funcId = 601;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.xRo = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.xRn = bool;
      this.sourceType = 2;
      localObject = (czy)this.rr.hvr.hvw;
      ((czy)localObject).FJm = "";
      ((czy)localObject).FJn = 0L;
      ((czy)localObject).FJo = paramString;
      ((czy)localObject).FJp = 1;
      ac.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(0L), paramString, Integer.valueOf(0) });
      AppMethodBeat.o(95581);
      return;
    }
  }
  
  /* Error */
  public static boolean atI(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 160
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/sns/model/m:xRq	Ljava/util/Vector;
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
    //   30: getstatic 44	com/tencent/mm/plugin/sns/model/m:xRq	Ljava/util/Vector;
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
  
  public static boolean atJ(String paramString)
  {
    try
    {
      AppMethodBeat.i(95580);
      xRq.remove(paramString);
      AppMethodBeat.o(95580);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private p b(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95582);
    p localp = new p();
    Object localObject = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
    ac.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localp.auR((String)localObject))
    {
      AppMethodBeat.o(95582);
      return null;
    }
    paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
    localp.field_userName = paramSnsObject.Username;
    localp.setCreateTime(paramSnsObject.CreateTime);
    localp.field_likeFlag = paramSnsObject.LikeFlag;
    localp.xG(paramSnsObject.Id);
    localp.xI(paramSnsObject.Id);
    localp.Pb(this.sourceType);
    try
    {
      localp.bB(paramSnsObject.toByteArray());
      localObject = localp.dLV();
      ((TimeLineObject)localObject).ncR = paramSnsObject.Username;
      localp.field_pravited = ((TimeLineObject)localObject).Fjj;
      ac.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + paramSnsObject.ExtFlag);
      localp.dMr();
      localp.f((TimeLineObject)localObject);
      localp.field_type = ((TimeLineObject)localObject).FQo.Ety;
      localp.field_subType = ((TimeLineObject)localObject).FQo.EtA;
      AppMethodBeat.o(95582);
      return localp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", localException, "", new Object[0]);
      }
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95584);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95584);
    return i;
  }
  
  public final int getType()
  {
    return 601;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95583);
    ac.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (czz)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0) && (paramq.getRespObj().getRetCode() != 212))
    {
      atJ("@__classify_timeline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95583);
      return;
    }
    if (paramq.getRespObj().getRetCode() == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.gNN = bool;
      this.xRr = paramArrayOfByte.FJq;
      this.desc = paramArrayOfByte.DPS;
      com.tencent.mm.plugin.sns.data.q.wX(this.xRo);
      ac.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.Fli), this.desc });
      paramq = paramArrayOfByte.DXh.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = b((SnsObject)paramq.next());
        if (paramArrayOfByte != null) {
          this.cQJ.add(paramArrayOfByte);
        }
      }
    }
    atJ("@__classify_timeline");
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */