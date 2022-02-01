package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eqa;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqe;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class p
  extends q
  implements m
{
  public List<String> JVj;
  public String JVk;
  private List<String> JVl;
  private i callback;
  public int dKy;
  public String kfu;
  private final com.tencent.mm.ak.d rr;
  
  public p(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151639);
    this.JVj = null;
    this.dKy = 0;
    this.JVl = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.dKy = paramInt;
      this.JVj = paramList1;
      if (paramList2 != null)
      {
        localObject = paramList2;
        if (paramList2.size() != 0) {}
      }
      else
      {
        localObject = new LinkedList();
      }
      paramList2 = new d.a();
      paramList2.iLN = new eqd();
      paramList2.iLO = new eqe();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.iLP = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.aXF();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label282;
        }
        Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
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
        ((List)localObject).add(Util.nullAs(a.bqE().aTp().biD((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.bqE().aTp().O((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    eqd localeqd = (eqd)this.rr.iLK.iLR;
    localeqd.KMz = paramInt;
    localeqd.MbK = paramString1;
    this.JVk = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      eqa localeqa = new eqa();
      localeqa.Cyk = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localeqa.Nnv = paramList2;
        paramList2 = a.bqE().aTp();
        String str = localeqa.Cyk;
        ((Integer)paramList.get(paramInt)).intValue();
        localeqa.LRO = Util.nullAs(paramList2.biD(str), "");
        if ((TextUtils.isEmpty(localeqa.LRO)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localeqa.LRO = ((String)((List)localObject).get(paramInt));
        }
        localeqa.MSG = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localeqa.Cyk))) {
          localeqa.Nnw = ((Integer)paramMap.get(localeqa.Cyk)).intValue();
        }
        localeqa.NnA = paramString4;
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.dKy), Integer.valueOf(paramInt), localeqa.Cyk, localeqa.LRO, paramString3, paramString4, Integer.valueOf(localeqa.Nnw) });
        paramString1.add(localeqa);
        paramInt += 1;
        break;
      }
    }
    localeqd.NnG = paramString1;
    localeqd.NnF = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localeqd.NnI = paramList1;
    localeqd.NnH = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.d.AEF.aIO("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_ver_usr");
    }
    paramList1 = new ewf();
    paramList1.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIP("ie_ver_usr"));
    if (paramList1.NtO != null) {
      paramInt = paramList1.NtO.getILen();
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIS("ce_ver_usr"));
      if (paramList1.NtP != null)
      {
        paramInt = paramList1.NtP.getILen();
        label837:
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
        if (paramList1.NtQ == null) {
          break label1050;
        }
        paramInt = paramList1.NtQ.getILen();
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_ver_usr");
        if (paramList != null) {
          paramList1.NtV = new SKBuiltinBuffer_t().setBuffer(paramList.getBytes());
        }
      }
      try
      {
        localeqd.KLQ = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label961:
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.dKy), Integer.valueOf(localeqd.NnG.size()), Integer.valueOf(localeqd.NnI.size()), Util.listToString((List)localObject, ","), paramString3, Util.getStack() });
        AppMethodBeat.o(151639);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        break label837;
        label1050:
        paramInt = -1;
      }
      catch (Throwable paramList1)
      {
        break label961;
      }
    }
  }
  
  public p(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null, 0);
  }
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151638);
    this.JVj = null;
    this.dKy = 0;
    this.JVl = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.JVj = new LinkedList();
    this.JVj.add(paramString1);
    this.dKy = 3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eqd();
    ((d.a)localObject).iLO = new eqe();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((d.a)localObject).funcId = 137;
    ((d.a)localObject).iLP = 44;
    ((d.a)localObject).respCmdId = 1000000044;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eqd)this.rr.iLK.iLR;
    ((eqd)localObject).KMz = 3;
    ((eqd)localObject).MbK = "";
    LinkedList localLinkedList = new LinkedList();
    eqa localeqa = new eqa();
    localeqa.Cyk = paramString1;
    localeqa.Nnv = paramString2;
    localeqa.LRO = a.bqE().aTp().biD(paramString1);
    localeqa.MSG = paramString3;
    if (paramInt2 > 0) {
      localeqa.Nnw = paramInt2;
    }
    localLinkedList.add(localeqa);
    ((eqd)localObject).NnG = localLinkedList;
    ((eqd)localObject).NnF = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((eqd)localObject).NnI = paramString1;
    ((eqd)localObject).NnH = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.d.AEF.aIO("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_ver_usr");
    }
    paramString1 = new ewf();
    paramString1.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIP("ie_ver_usr"));
    if (paramString1.NtO != null) {
      paramInt1 = paramString1.NtO.getILen();
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIS("ce_ver_usr"));
      if (paramString1.NtP != null)
      {
        paramInt1 = paramString1.NtP.getILen();
        label400:
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
        if (paramString1.NtQ == null) {
          break label604;
        }
        paramInt1 = paramString1.NtQ.getILen();
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString3 = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_ver_usr");
        if (paramString3 != null) {
          paramString1.NtV = new SKBuiltinBuffer_t().setBuffer(paramString3.getBytes());
        }
      }
      try
      {
        ((eqd)localObject).KLQ = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
        label527:
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify user:%d scene:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((eqd)localObject).NnG.size()), Integer.valueOf(((eqd)localObject).NnI.size()), paramString2, localeqa.LRO, Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151638);
        return;
        paramInt1 = -1;
        continue;
        paramInt1 = -1;
        break label400;
        label604:
        paramInt1 = -1;
      }
      catch (Throwable paramString1)
      {
        break label527;
      }
    }
  }
  
  public p(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(1, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public p(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(2, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public final void Pz(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((eqd)this.rr.iLK.iLR).NnG.iterator();
    while (localIterator.hasNext()) {
      ((eqa)localIterator.next()).LRe = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(eqb parameqb)
  {
    AppMethodBeat.i(151643);
    if (parameqb == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(parameqb.KJS), Integer.valueOf(parameqb.NnE), parameqb.Lru });
    Iterator localIterator = ((eqd)this.rr.iLK.iLR).NnG.iterator();
    while (localIterator.hasNext())
    {
      eqa localeqa = (eqa)localIterator.next();
      try
      {
        localeqa.NnD = new SKBuiltinBuffer_t().setBuffer(parameqb.toByteArray());
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(151643);
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151644);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151644);
    return i;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final String gmD()
  {
    if ((this.rr != null) && (this.rr.iLL != null)) {
      return ((eqe)this.rr.iLL.iLR).UserName;
    }
    return "";
  }
  
  public final int gmE()
  {
    return this.dKy;
  }
  
  public final void mw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((eqd)this.rr.iLK.iLR).NnG.iterator();
    while (localIterator.hasNext())
    {
      eqa localeqa = (eqa)localIterator.next();
      localeqa.Nnx = paramString1;
      localeqa.Nny = paramString2;
    }
    AppMethodBeat.o(151640);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151645);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151645);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(151642);
    Iterator localIterator = ((eqd)this.rr.iLK.iLR).NnG.iterator();
    while (localIterator.hasNext()) {
      ((eqa)localIterator.next()).KJS = paramInt;
    }
    AppMethodBeat.o(151642);
  }
  
  public final void zJ(boolean paramBoolean)
  {
    eqd localeqd = (eqd)this.rr.iLK.iLR;
    if (paramBoolean)
    {
      localeqd.NnL = 1;
      return;
    }
    localeqd.NnL = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */