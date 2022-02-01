package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class o
  extends n
  implements k
{
  public List<String> Dhk;
  public String Dhl;
  private List<String> Dhm;
  private com.tencent.mm.ak.g callback;
  public int dgL;
  public String iLo;
  private final com.tencent.mm.ak.b rr;
  
  public o(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151639);
    this.Dhk = null;
    this.dgL = 0;
    this.Dhm = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.dgL = paramInt;
      this.Dhk = paramList1;
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
      paramList2.hvt = new dpl();
      paramList2.hvu = new dpm();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.reqCmdId = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.aAz();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label282;
        }
        ac.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
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
        ((List)localObject).add(bs.bG(a.aRW().axc().aMF((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.aRW().axc().C((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    dpl localdpl = (dpl)this.rr.hvr.hvw;
    localdpl.DUY = paramInt;
    localdpl.EUa = paramString1;
    this.Dhl = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      dpi localdpi = new dpi();
      localdpi.wTM = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localdpi.FWC = paramList2;
        paramList2 = a.aRW().axc();
        String str = localdpi.wTM;
        ((Integer)paramList.get(paramInt)).intValue();
        localdpi.ELg = bs.bG(paramList2.aMF(str), "");
        if ((TextUtils.isEmpty(localdpi.ELg)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localdpi.ELg = ((String)((List)localObject).get(paramInt));
        }
        localdpi.FDH = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localdpi.wTM))) {
          localdpi.FWD = ((Integer)paramMap.get(localdpi.wTM)).intValue();
        }
        localdpi.FWH = paramString4;
        ac.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.dgL), Integer.valueOf(paramInt), localdpi.wTM, localdpi.ELg, paramString3, paramString4, Integer.valueOf(localdpi.FWD) });
        paramString1.add(localdpi);
        paramInt += 1;
        break;
      }
    }
    localdpl.FWN = paramString1;
    localdpl.FWM = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localdpl.FWP = paramList1;
    localdpl.FWO = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.b.vor.aos("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_ver_usr");
    }
    paramList1 = new dun();
    paramList1.Gcm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aot("ie_ver_usr"));
    if (paramList1.Gcm != null) {
      paramInt = paramList1.Gcm.getILen();
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.Gcn = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aow("ce_ver_usr"));
      if (paramList1.Gcn != null)
      {
        paramInt = paramList1.Gcn.getILen();
        label837:
        ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
        if (paramList1.Gco == null) {
          break label1018;
        }
        paramInt = paramList1.Gco.getILen();
        ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      try
      {
        localdpl.DUr = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label929:
        ac.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.dgL), Integer.valueOf(localdpl.FWN.size()), Integer.valueOf(localdpl.FWP.size()), bs.n((List)localObject, ","), paramString3, bs.eWi() });
        AppMethodBeat.o(151639);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        break label837;
        label1018:
        paramInt = -1;
      }
      catch (Throwable paramList1)
      {
        break label929;
      }
    }
  }
  
  public o(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null, 0);
  }
  
  public o(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151638);
    this.Dhk = null;
    this.dgL = 0;
    this.Dhm = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.Dhk = new LinkedList();
    this.Dhk.add(paramString1);
    this.dgL = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dpl();
    ((b.a)localObject).hvu = new dpm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).funcId = 137;
    ((b.a)localObject).reqCmdId = 44;
    ((b.a)localObject).respCmdId = 1000000044;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dpl)this.rr.hvr.hvw;
    ((dpl)localObject).DUY = 3;
    ((dpl)localObject).EUa = "";
    LinkedList localLinkedList = new LinkedList();
    dpi localdpi = new dpi();
    localdpi.wTM = paramString1;
    localdpi.FWC = paramString2;
    localdpi.ELg = a.aRW().axc().aMF(paramString1);
    localdpi.FDH = paramString3;
    if (paramInt2 > 0) {
      localdpi.FWD = paramInt2;
    }
    localLinkedList.add(localdpi);
    ((dpl)localObject).FWN = localLinkedList;
    ((dpl)localObject).FWM = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((dpl)localObject).FWP = paramString1;
    ((dpl)localObject).FWO = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.b.vor.aos("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_ver_usr");
    }
    paramString1 = new dun();
    paramString1.Gcm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aot("ie_ver_usr"));
    if (paramString1.Gcm != null) {
      paramInt1 = paramString1.Gcm.getILen();
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.Gcn = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aow("ce_ver_usr"));
      if (paramString1.Gcn != null)
      {
        paramInt1 = paramString1.Gcn.getILen();
        label400:
        ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
        if (paramString1.Gco == null) {
          break label569;
        }
        paramInt1 = paramString1.Gco.getILen();
        ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      try
      {
        ((dpl)localObject).DUr = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
        label492:
        ac.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((dpl)localObject).FWN.size()), Integer.valueOf(((dpl)localObject).FWP.size()), paramString2, localdpi.ELg, Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151638);
        return;
        paramInt1 = -1;
        continue;
        paramInt1 = -1;
        break label400;
        label569:
        paramInt1 = -1;
      }
      catch (Throwable paramString1)
      {
        break label492;
      }
    }
  }
  
  public o(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(1, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public o(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(2, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public final void Dg(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((dpl)this.rr.hvr.hvw).FWN.iterator();
    while (localIterator.hasNext()) {
      ((dpi)localIterator.next()).EKy = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(dpj paramdpj)
  {
    AppMethodBeat.i(151643);
    if (paramdpj == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    ac.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramdpj.DSv), Integer.valueOf(paramdpj.FWL), paramdpj.EvK });
    Iterator localIterator = ((dpl)this.rr.hvr.hvw).FWN.iterator();
    while (localIterator.hasNext())
    {
      dpi localdpi = (dpi)localIterator.next();
      try
      {
        localdpi.FWK = new SKBuiltinBuffer_t().setBuffer(paramdpj.toByteArray());
      }
      catch (IOException localIOException)
      {
        ac.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(151643);
  }
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151644);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151644);
    return i;
  }
  
  public final String eKL()
  {
    if ((this.rr != null) && (this.rr.hvs != null)) {
      return ((dpm)this.rr.hvs.hvw).ncR;
    }
    return "";
  }
  
  public final int eKM()
  {
    return this.dgL;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final void kU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((dpl)this.rr.hvr.hvw).FWN.iterator();
    while (localIterator.hasNext())
    {
      dpi localdpi = (dpi)localIterator.next();
      localdpi.FWE = paramString1;
      localdpi.FWF = paramString2;
    }
    AppMethodBeat.o(151640);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151645);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151645);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(151642);
    Iterator localIterator = ((dpl)this.rr.hvr.hvw).FWN.iterator();
    while (localIterator.hasNext()) {
      ((dpi)localIterator.next()).DSv = paramInt;
    }
    AppMethodBeat.o(151642);
  }
  
  public final void uT(boolean paramBoolean)
  {
    dpl localdpl = (dpl)this.rr.hvr.hvw;
    if (paramBoolean)
    {
      localdpl.FWS = 1;
      return;
    }
    localdpl.FWS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */