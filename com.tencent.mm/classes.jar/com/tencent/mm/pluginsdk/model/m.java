package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public int cut;
  public String gyj;
  private final com.tencent.mm.ai.b rr;
  public List<String> vKs;
  public String vKt;
  private List<String> vKu;
  
  public m(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(79218);
    this.vKs = null;
    this.cut = 0;
    this.vKu = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.cut = paramInt;
      this.vKs = paramList1;
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
      paramList2.fsX = new cqk();
      paramList2.fsY = new cql();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.reqCmdId = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.ado();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label282;
        }
        ab.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
      }
    }
    for (;;)
    {
      if (paramInt != 2) {
        break label340;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        ((List)localObject).add(bo.bf(a.asD().Zb().aqP((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.asD().Zb().x((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    cqk localcqk = (cqk)this.rr.fsV.fta;
    localcqk.wsW = paramInt;
    localcqk.xfJ = paramString1;
    this.vKt = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      cqi localcqi = new cqi();
      localcqi.qsu = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localcqi.xYO = paramList2;
        paramList2 = a.asD().Zb();
        String str = localcqi.qsu;
        ((Integer)paramList.get(paramInt)).intValue();
        localcqi.wYu = bo.bf(paramList2.aqP(str), "");
        if ((TextUtils.isEmpty(localcqi.wYu)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localcqi.wYu = ((String)((List)localObject).get(paramInt));
        }
        localcqi.xJi = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localcqi.qsu))) {
          localcqi.xYP = ((Integer)paramMap.get(localcqi.qsu)).intValue();
        }
        localcqi.xYT = paramString4;
        ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", new Object[] { Integer.valueOf(this.cut), Integer.valueOf(paramInt), localcqi.qsu, localcqi.wYu, paramString3, paramString4 });
        paramString1.add(localcqi);
        paramInt += 1;
        break;
      }
    }
    localcqk.xYX = paramString1;
    localcqk.xYW = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localcqk.xYZ = paramList1;
    localcqk.xYY = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.b.pgQ.VY("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_ver_usr");
    }
    paramList1 = new cuv();
    paramList1.ydw = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.VZ("ie_ver_usr"));
    if (paramList1.ydw != null) {
      paramInt = paramList1.ydw.getILen();
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.ydx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.Wc("ce_ver_usr"));
      if (paramList1.ydx != null)
      {
        paramInt = paramList1.ydx.getILen();
        label825:
        ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.bXq());
        if (paramList1.ydy == null) {
          break label1006;
        }
        paramInt = paramList1.ydy.getILen();
        ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      try
      {
        localcqk.wss = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label917:
        ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.cut), Integer.valueOf(localcqk.xYX.size()), Integer.valueOf(localcqk.xYZ.size()), bo.d((List)localObject, ","), paramString3, bo.dtY() });
        AppMethodBeat.o(79218);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        break label825;
        label1006:
        paramInt = -1;
      }
      catch (Throwable paramList1)
      {
        break label917;
      }
    }
  }
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null);
    AppMethodBeat.i(79217);
    AppMethodBeat.o(79217);
  }
  
  public m(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(151611);
    this.vKs = null;
    this.cut = 0;
    this.vKu = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.vKs = new LinkedList();
    this.vKs.add(paramString1);
    this.cut = 3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cqk();
    ((b.a)localObject).fsY = new cql();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).funcId = 137;
    ((b.a)localObject).reqCmdId = 44;
    ((b.a)localObject).respCmdId = 1000000044;
    this.rr = ((b.a)localObject).ado();
    localObject = (cqk)this.rr.fsV.fta;
    ((cqk)localObject).wsW = 3;
    ((cqk)localObject).xfJ = "";
    LinkedList localLinkedList = new LinkedList();
    cqi localcqi = new cqi();
    localcqi.qsu = paramString1;
    localcqi.xYO = paramString2;
    localcqi.wYu = a.asD().Zb().aqP(paramString1);
    localcqi.xJi = paramString3;
    localLinkedList.add(localcqi);
    ((cqk)localObject).xYX = localLinkedList;
    ((cqk)localObject).xYW = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt));
    ((cqk)localObject).xYZ = paramString1;
    ((cqk)localObject).xYY = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.b.pgQ.VY("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_ver_usr");
    }
    paramString1 = new cuv();
    paramString1.ydw = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.VZ("ie_ver_usr"));
    if (paramString1.ydw != null)
    {
      paramInt = paramString1.ydw.getILen();
      ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramString1.ydx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.Wc("ce_ver_usr"));
      if (paramString1.ydx == null) {
        break label570;
      }
      paramInt = paramString1.ydx.getILen();
      label388:
      ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) {
        break label584;
      }
    }
    label570:
    label584:
    for (paramInt = 6;; paramInt = 4) {
      for (;;)
      {
        paramString1.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.AO(paramInt));
        if (paramString1.ydy != null)
        {
          paramInt = paramString1.ydy.getILen();
          ab.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        }
        try
        {
          ((cqk)localObject).wss = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          label506:
          ab.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", new Object[] { Integer.valueOf(((cqk)localObject).xYX.size()), Integer.valueOf(((cqk)localObject).xYZ.size()), paramString2, localcqi.wYu });
          AppMethodBeat.o(151611);
          return;
          paramInt = -1;
          break;
          paramInt = -1;
          break label388;
          paramInt = -1;
        }
        catch (Throwable paramString1)
        {
          break label506;
        }
      }
    }
  }
  
  public m(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(1, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public m(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(2, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public final String dlk()
  {
    if ((this.rr != null) && (this.rr.fsW != null)) {
      return ((cql)this.rr.fsW.fta).jJA;
    }
    return "";
  }
  
  public final int dll()
  {
    return this.cut;
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(79222);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(79222);
    return i;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final void hR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79219);
    Iterator localIterator = ((cqk)this.rr.fsV.fta).xYX.iterator();
    while (localIterator.hasNext())
    {
      cqi localcqi = (cqi)localIterator.next();
      localcqi.xYQ = paramString1;
      localcqi.xYR = paramString2;
    }
    AppMethodBeat.o(79219);
  }
  
  public final void oY(boolean paramBoolean)
  {
    cqk localcqk = (cqk)this.rr.fsV.fta;
    if (paramBoolean)
    {
      localcqk.xZc = 1;
      return;
    }
    localcqk.xZc = 0;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79223);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ab.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(79223);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(79221);
    Iterator localIterator = ((cqk)this.rr.fsV.fta).xYX.iterator();
    while (localIterator.hasNext()) {
      ((cqi)localIterator.next()).wqO = paramInt;
    }
    AppMethodBeat.o(79221);
  }
  
  public final void uo(String paramString)
  {
    AppMethodBeat.i(79220);
    Iterator localIterator = ((cqk)this.rr.fsV.fta).xYX.iterator();
    while (localIterator.hasNext()) {
      ((cqi)localIterator.next()).wYm = paramString;
    }
    AppMethodBeat.o(79220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */