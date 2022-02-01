package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejm;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class o
  extends q
  implements m
{
  private static Vector<String> JVh;
  private boolean JVe;
  private long JVf;
  private long JVg;
  public int JVi;
  public int JVj;
  public i callback;
  private String desc;
  private ArrayList<SnsInfo> fmA;
  private boolean kSa;
  private d rr;
  final int sourceType;
  
  static
  {
    AppMethodBeat.i(95585);
    JVh = new Vector();
    AppMethodBeat.o(95585);
  }
  
  public o(String paramString)
  {
    AppMethodBeat.i(95581);
    this.JVf = 0L;
    this.JVg = 0L;
    this.kSa = false;
    this.fmA = new ArrayList();
    this.JVi = 0;
    this.JVj = 0;
    this.desc = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ejm();
    ((d.a)localObject).lBV = new ejn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((d.a)localObject).funcId = 601;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.JVf = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.JVe = bool;
      this.sourceType = 2;
      localObject = (ejm)d.b.b(this.rr.lBR);
      ((ejm)localObject).UlA = "";
      ((ejm)localObject).UlB = 0L;
      ((ejm)localObject).UlC = paramString;
      ((ejm)localObject).UlD = 1;
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { t.Qu(0L), paramString, Integer.valueOf(0) });
      AppMethodBeat.o(95581);
      return;
    }
  }
  
  /* Error */
  public static boolean aZV(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 161
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/sns/model/o:JVh	Ljava/util/Vector;
    //   11: aload_0
    //   12: invokevirtual 165	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   15: ifeq +15 -> 30
    //   18: iconst_0
    //   19: istore_1
    //   20: ldc 161
    //   22: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: getstatic 44	com/tencent/mm/plugin/sns/model/o:JVh	Ljava/util/Vector;
    //   33: aload_0
    //   34: invokevirtual 168	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: iconst_1
    //   39: istore_1
    //   40: ldc 161
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
  
  public static boolean aZW(String paramString)
  {
    try
    {
      AppMethodBeat.i(95580);
      JVh.remove(paramString);
      AppMethodBeat.o(95580);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private SnsInfo e(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95582);
    SnsInfo localSnsInfo = new SnsInfo();
    Object localObject = new String(paramSnsObject.ObjectDesc.Tkb.toByteArray());
    Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localSnsInfo.setContent((String)localObject))
    {
      AppMethodBeat.o(95582);
      return null;
    }
    paramSnsObject.ObjectDesc.dc(new byte[0]);
    localSnsInfo.setUserName(paramSnsObject.Username);
    localSnsInfo.setCreateTime(paramSnsObject.CreateTime);
    localSnsInfo.setLikeFlag(paramSnsObject.LikeFlag);
    localSnsInfo.setSnsId(paramSnsObject.Id);
    localSnsInfo.setStringSeq(paramSnsObject.Id);
    localSnsInfo.addSourceFlag(this.sourceType);
    try
    {
      localSnsInfo.setAttrBuf(paramSnsObject.toByteArray());
      localObject = localSnsInfo.getTimeLine();
      ((TimeLineObject)localObject).UserName = paramSnsObject.Username;
      localSnsInfo.setPravited(((TimeLineObject)localObject).Privated);
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + paramSnsObject.ExtFlag);
      localSnsInfo.setExtFlag();
      localSnsInfo.setTimeLine((TimeLineObject)localObject);
      localSnsInfo.setTypeFlag(((TimeLineObject)localObject).ContentObj.Sqq);
      localSnsInfo.setSubTypeFlag(((TimeLineObject)localObject).ContentObj.Sqs);
      AppMethodBeat.o(95582);
      return localSnsInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", localException, "", new Object[0]);
      }
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95584);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95584);
    return i;
  }
  
  public final int getType()
  {
    return 601;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95583);
    Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (ejn)d.c.b(((d)params).lBS);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0) && (params.getRespObj().getRetCode() != 212))
    {
      aZW("@__classify_timeline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95583);
      return;
    }
    if (params.getRespObj().getRetCode() == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.kSa = bool;
      this.JVi = paramArrayOfByte.UlE;
      this.desc = paramArrayOfByte.RIC;
      t.Qv(this.JVf);
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.TGK), this.desc });
      params = paramArrayOfByte.RPF.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = e((SnsObject)params.next());
        if (paramArrayOfByte != null) {
          this.fmA.add(paramArrayOfByte);
        }
      }
    }
    aZW("@__classify_timeline");
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */