package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class n
  extends m
  implements k
{
  private static Vector<String> rez;
  public f callback;
  private ArrayList<com.tencent.mm.plugin.sns.storage.n> ceo;
  final int cpG;
  private String desc;
  private boolean eRq;
  public int reA;
  public int reB;
  private boolean rew;
  private long rex;
  private long rey;
  private com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(36260);
    rez = new Vector();
    AppMethodBeat.o(36260);
  }
  
  public n(String paramString)
  {
    AppMethodBeat.i(36256);
    this.rex = 0L;
    this.rey = 0L;
    this.eRq = false;
    this.ceo = new ArrayList();
    this.reA = 0;
    this.reB = 0;
    this.desc = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cdq();
    ((b.a)localObject).fsY = new cdr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((b.a)localObject).funcId = 601;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.rex = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.rew = bool;
      this.cpG = 2;
      localObject = (cdq)this.rr.fsV.fta;
      ((cdq)localObject).xOk = "";
      ((cdq)localObject).xOl = 0L;
      ((cdq)localObject).xOm = paramString;
      ((cdq)localObject).xOn = 1;
      ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { i.lq(0L), paramString, Integer.valueOf(0) });
      AppMethodBeat.o(36256);
      return;
    }
  }
  
  /* Error */
  public static boolean aan(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 160
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/sns/model/n:rez	Ljava/util/Vector;
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
    //   30: getstatic 44	com/tencent/mm/plugin/sns/model/n:rez	Ljava/util/Vector;
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
  
  public static boolean aao(String paramString)
  {
    try
    {
      AppMethodBeat.i(36255);
      rez.remove(paramString);
      AppMethodBeat.o(36255);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private com.tencent.mm.plugin.sns.storage.n b(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(36257);
    com.tencent.mm.plugin.sns.storage.n localn = new com.tencent.mm.plugin.sns.storage.n();
    Object localObject = new String(paramSnsObject.ObjectDesc.getBuffer().toByteArray());
    ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localn.abt((String)localObject))
    {
      AppMethodBeat.o(36257);
      return null;
    }
    paramSnsObject.ObjectDesc.setBuffer(new byte[0]);
    localn.field_userName = paramSnsObject.Username;
    localn.lp(paramSnsObject.CreateTime);
    localn.field_likeFlag = paramSnsObject.LikeFlag;
    localn.lV(paramSnsObject.Id);
    localn.lX(paramSnsObject.Id);
    localn.Eu(this.cpG);
    try
    {
      localn.bj(paramSnsObject.toByteArray());
      localObject = localn.csh();
      ((TimeLineObject)localObject).jJA = paramSnsObject.Username;
      localn.field_pravited = ((TimeLineObject)localObject).xrU;
      ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + paramSnsObject.ExtFlag);
      localn.csE();
      localn.c((TimeLineObject)localObject);
      localn.field_type = ((TimeLineObject)localObject).xTS.wNZ;
      localn.field_subType = ((TimeLineObject)localObject).xTS.wOb;
      AppMethodBeat.o(36257);
      return localn;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", localException, "", new Object[0]);
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36259);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36259);
    return i;
  }
  
  public final int getType()
  {
    return 601;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36258);
    ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (cdr)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0) && (paramq.getRespObj().getRetCode() != 212))
    {
      aao("@__classify_timeline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36258);
      return;
    }
    if (paramq.getRespObj().getRetCode() == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.eRq = bool;
      this.reA = paramArrayOfByte.xOo;
      this.desc = paramArrayOfByte.woO;
      i.lr(this.rex);
      ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.xtO), this.desc });
      paramq = paramArrayOfByte.wuP.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = b((SnsObject)paramq.next());
        if (paramArrayOfByte != null) {
          this.ceo.add(paramArrayOfByte);
        }
      }
    }
    aao("@__classify_timeline");
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(36258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */