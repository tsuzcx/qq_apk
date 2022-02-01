package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.g;
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
  public List<String> ELU;
  public String ELV;
  private List<String> ELW;
  private f callback;
  public int dsi;
  public String jex;
  private final com.tencent.mm.al.b rr;
  
  public o(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151639);
    this.ELU = null;
    this.dsi = 0;
    this.ELW = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.dsi = paramInt;
      this.ELU = paramList1;
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
      paramList2.hNM = new dvc();
      paramList2.hNN = new dvd();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.hNO = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.aDC();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label282;
        }
        ad.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
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
        ((List)localObject).add(bt.bI(a.aVi().azR().aSl((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.aVi().azR().D((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    dvc localdvc = (dvc)this.rr.hNK.hNQ;
    localdvc.FAt = paramInt;
    localdvc.GDx = paramString1;
    this.ELV = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      duz localduz = new duz();
      localduz.yhw = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localduz.HHs = paramList2;
        paramList2 = a.aVi().azR();
        String str = localduz.yhw;
        ((Integer)paramList.get(paramInt)).intValue();
        localduz.Guj = bt.bI(paramList2.aSl(str), "");
        if ((TextUtils.isEmpty(localduz.Guj)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localduz.Guj = ((String)((List)localObject).get(paramInt));
        }
        localduz.HnU = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localduz.yhw))) {
          localduz.HHt = ((Integer)paramMap.get(localduz.yhw)).intValue();
        }
        localduz.HHx = paramString4;
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.dsi), Integer.valueOf(paramInt), localduz.yhw, localduz.Guj, paramString3, paramString4, Integer.valueOf(localduz.HHt) });
        paramString1.add(localduz);
        paramInt += 1;
        break;
      }
    }
    localdvc.HHD = paramString1;
    localdvc.HHC = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localdvc.HHF = paramList1;
    localdvc.HHE = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.b.wtJ.ats("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_ver_usr");
    }
    paramList1 = new eah();
    paramList1.HNj = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.att("ie_ver_usr"));
    if (paramList1.HNj != null) {
      paramInt = paramList1.HNj.getILen();
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.HNk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.atw("ce_ver_usr"));
      if (paramList1.HNk != null)
      {
        paramInt = paramList1.HNk.getILen();
        label837:
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
        if (paramList1.HNl == null) {
          break label1018;
        }
        paramInt = paramList1.HNl.getILen();
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      try
      {
        localdvc.FzL = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label929:
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.dsi), Integer.valueOf(localdvc.HHD.size()), Integer.valueOf(localdvc.HHF.size()), bt.m((List)localObject, ","), paramString3, bt.flS() });
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
    this.ELU = null;
    this.dsi = 0;
    this.ELW = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.ELU = new LinkedList();
    this.ELU.add(paramString1);
    this.dsi = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dvc();
    ((b.a)localObject).hNN = new dvd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).funcId = 137;
    ((b.a)localObject).hNO = 44;
    ((b.a)localObject).respCmdId = 1000000044;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dvc)this.rr.hNK.hNQ;
    ((dvc)localObject).FAt = 3;
    ((dvc)localObject).GDx = "";
    LinkedList localLinkedList = new LinkedList();
    duz localduz = new duz();
    localduz.yhw = paramString1;
    localduz.HHs = paramString2;
    localduz.Guj = a.aVi().azR().aSl(paramString1);
    localduz.HnU = paramString3;
    if (paramInt2 > 0) {
      localduz.HHt = paramInt2;
    }
    localLinkedList.add(localduz);
    ((dvc)localObject).HHD = localLinkedList;
    ((dvc)localObject).HHC = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((dvc)localObject).HHF = paramString1;
    ((dvc)localObject).HHE = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.b.wtJ.ats("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_ver_usr");
    }
    paramString1 = new eah();
    paramString1.HNj = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.att("ie_ver_usr"));
    if (paramString1.HNj != null) {
      paramInt1 = paramString1.HNj.getILen();
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.HNk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.atw("ce_ver_usr"));
      if (paramString1.HNk != null)
      {
        paramInt1 = paramString1.HNk.getILen();
        label400:
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
        if (paramString1.HNl == null) {
          break label569;
        }
        paramInt1 = paramString1.HNl.getILen();
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      try
      {
        ((dvc)localObject).FzL = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
        label492:
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify user:%d scene:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((dvc)localObject).HHD.size()), Integer.valueOf(((dvc)localObject).HHF.size()), paramString2, localduz.Guj, Integer.valueOf(paramInt2) });
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
  
  public final void Gl(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((dvc)this.rr.hNK.hNQ).HHD.iterator();
    while (localIterator.hasNext()) {
      ((duz)localIterator.next()).GtA = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(dva paramdva)
  {
    AppMethodBeat.i(151643);
    if (paramdva == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramdva.FxO), Integer.valueOf(paramdva.HHB), paramdva.Gdg });
    Iterator localIterator = ((dvc)this.rr.hNK.hNQ).HHD.iterator();
    while (localIterator.hasNext())
    {
      duz localduz = (duz)localIterator.next();
      try
      {
        localduz.HHA = new SKBuiltinBuffer_t().setBuffer(paramdva.toByteArray());
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(151643);
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151644);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151644);
    return i;
  }
  
  public final String eZF()
  {
    if ((this.rr != null) && (this.rr.hNL != null)) {
      return ((dvd)this.rr.hNL.hNQ).nDo;
    }
    return "";
  }
  
  public final int eZG()
  {
    return this.dsi;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final void lr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((dvc)this.rr.hNK.hNQ).HHD.iterator();
    while (localIterator.hasNext())
    {
      duz localduz = (duz)localIterator.next();
      localduz.HHu = paramString1;
      localduz.HHv = paramString2;
    }
    AppMethodBeat.o(151640);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151645);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151645);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(151642);
    Iterator localIterator = ((dvc)this.rr.hNK.hNQ).HHD.iterator();
    while (localIterator.hasNext()) {
      ((duz)localIterator.next()).FxO = paramInt;
    }
    AppMethodBeat.o(151642);
  }
  
  public final void vE(boolean paramBoolean)
  {
    dvc localdvc = (dvc)this.rr.hNK.hNQ;
    if (paramBoolean)
    {
      localdvc.HHI = 1;
      return;
    }
    localdvc.HHI = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */