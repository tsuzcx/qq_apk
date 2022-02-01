package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.fdt;
import com.tencent.mm.protocal.protobuf.fdu;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class o
  extends p
  implements m
{
  private static Vector<String> Qsi;
  private boolean Qsg;
  private long Qsh;
  public int Qsj;
  public int Qsk;
  public h callback;
  private String desc;
  private ArrayList<SnsInfo> hqL;
  private long maxId;
  private boolean nxG;
  private c rr;
  final int sourceType;
  
  static
  {
    AppMethodBeat.i(95585);
    Qsi = new Vector();
    AppMethodBeat.o(95585);
  }
  
  public o(String paramString)
  {
    AppMethodBeat.i(95581);
    this.maxId = 0L;
    this.Qsh = 0L;
    this.nxG = false;
    this.hqL = new ArrayList();
    this.Qsj = 0;
    this.Qsk = 0;
    this.desc = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fdt();
    ((c.a)localObject).otF = new fdu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
    ((c.a)localObject).funcId = 601;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.maxId = 0L;
    if (0L == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.Qsg = bool;
      this.sourceType = 2;
      localObject = (fdt)c.b.b(this.rr.otB);
      ((fdt)localObject).abDu = "";
      ((fdt)localObject).abDv = 0L;
      ((fdt)localObject).abDw = paramString;
      ((fdt)localObject).abDx = 1;
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[] { t.uA(0L), paramString, Integer.valueOf(0) });
      AppMethodBeat.o(95581);
      return;
    }
  }
  
  /* Error */
  public static boolean aYj(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 161
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/sns/model/o:Qsi	Ljava/util/Vector;
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
    //   30: getstatic 44	com/tencent/mm/plugin/sns/model/o:Qsi	Ljava/util/Vector;
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
  
  public static boolean aYk(String paramString)
  {
    try
    {
      AppMethodBeat.i(95580);
      Qsi.remove(paramString);
      AppMethodBeat.o(95580);
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private SnsInfo f(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95582);
    SnsInfo localSnsInfo = new SnsInfo();
    Object localObject = new String(paramSnsObject.ObjectDesc.aaxD.toByteArray());
    Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[] { Long.valueOf(paramSnsObject.Id) });
    if (!localSnsInfo.setContent((String)localObject))
    {
      AppMethodBeat.o(95582);
      return null;
    }
    paramSnsObject.ObjectDesc.df(new byte[0]);
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
      localSnsInfo.setTypeFlag(((TimeLineObject)localObject).ContentObj.Zpq);
      localSnsInfo.setSubTypeFlag(((TimeLineObject)localObject).ContentObj.Zps);
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95584);
    this.callback = paramh;
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
    paramArrayOfByte = (fdu)c.c.b(((c)params).otC);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0) && (params.getRespObj().getRetCode() != 212))
    {
      aYk("@__classify_timeline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95583);
      return;
    }
    if (params.getRespObj().getRetCode() == 212) {}
    for (boolean bool = true;; bool = false)
    {
      this.nxG = bool;
      this.Qsj = paramArrayOfByte.abDy;
      this.desc = paramArrayOfByte.crB;
      t.uB(this.maxId);
      Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[] { Integer.valueOf(paramArrayOfByte.aaWr), this.desc });
      params = paramArrayOfByte.YMT.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = f((SnsObject)params.next());
        if (paramArrayOfByte != null) {
          this.hqL.add(paramArrayOfByte);
        }
      }
    }
    aYk("@__classify_timeline");
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */