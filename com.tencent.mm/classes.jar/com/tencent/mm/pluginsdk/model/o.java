package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public List<String> Fes;
  public String Fet;
  private List<String> Feu;
  private f callback;
  public int dto;
  public String jhq;
  private final com.tencent.mm.ak.b rr;
  
  public o(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151639);
    this.Fes = null;
    this.dto = 0;
    this.Feu = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.dto = paramInt;
      this.Fes = paramList1;
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
      paramList2.hQF = new dvz();
      paramList2.hQG = new dwa();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.hQH = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.aDS();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (((List)localObject).size() == paramList1.size()) {
          break label282;
        }
        ae.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramList1.size()) });
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
        ((List)localObject).add(bu.bI(a.aVH().aAh().aTI((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.aVH().aAh().F((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    dvz localdvz = (dvz)this.rr.hQD.hQJ;
    localdvz.FSQ = paramInt;
    localdvz.GXa = paramString1;
    this.Fet = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      dvw localdvw = new dvw();
      localdvw.yxn = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localdvw.Ibf = paramList2;
        paramList2 = a.aVH().aAh();
        String str = localdvw.yxn;
        ((Integer)paramList.get(paramInt)).intValue();
        localdvw.GNI = bu.bI(paramList2.aTI(str), "");
        if ((TextUtils.isEmpty(localdvw.GNI)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localdvw.GNI = ((String)((List)localObject).get(paramInt));
        }
        localdvw.HHu = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localdvw.yxn))) {
          localdvw.Ibg = ((Integer)paramMap.get(localdvw.yxn)).intValue();
        }
        localdvw.Ibk = paramString4;
        ae.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.dto), Integer.valueOf(paramInt), localdvw.yxn, localdvw.GNI, paramString3, paramString4, Integer.valueOf(localdvw.Ibg) });
        paramString1.add(localdvw);
        paramInt += 1;
        break;
      }
    }
    localdvz.Ibq = paramString1;
    localdvz.Ibp = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localdvz.Ibs = paramList1;
    localdvz.Ibr = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.b.wJt.auF("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_ver_usr");
    }
    paramList1 = new eby();
    paramList1.Ihq = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auG("ie_ver_usr"));
    if (paramList1.Ihq != null) {
      paramInt = paramList1.Ihq.getILen();
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.Ihr = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auJ("ce_ver_usr"));
      if (paramList1.Ihr != null)
      {
        paramInt = paramList1.Ihr.getILen();
        label837:
        ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
        if (paramList1.Ihs == null) {
          break label1018;
        }
        paramInt = paramList1.Ihs.getILen();
        ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      try
      {
        localdvz.FSj = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label929:
        ae.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.dto), Integer.valueOf(localdvz.Ibq.size()), Integer.valueOf(localdvz.Ibs.size()), bu.m((List)localObject, ","), paramString3, bu.fpN() });
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
    this.Fes = null;
    this.dto = 0;
    this.Feu = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.Fes = new LinkedList();
    this.Fes.add(paramString1);
    this.dto = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dvz();
    ((b.a)localObject).hQG = new dwa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).funcId = 137;
    ((b.a)localObject).hQH = 44;
    ((b.a)localObject).respCmdId = 1000000044;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dvz)this.rr.hQD.hQJ;
    ((dvz)localObject).FSQ = 3;
    ((dvz)localObject).GXa = "";
    LinkedList localLinkedList = new LinkedList();
    dvw localdvw = new dvw();
    localdvw.yxn = paramString1;
    localdvw.Ibf = paramString2;
    localdvw.GNI = a.aVH().aAh().aTI(paramString1);
    localdvw.HHu = paramString3;
    if (paramInt2 > 0) {
      localdvw.Ibg = paramInt2;
    }
    localLinkedList.add(localdvw);
    ((dvz)localObject).Ibq = localLinkedList;
    ((dvz)localObject).Ibp = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((dvz)localObject).Ibs = paramString1;
    ((dvz)localObject).Ibr = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.b.wJt.auF("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_ver_usr");
    }
    paramString1 = new eby();
    paramString1.Ihq = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auG("ie_ver_usr"));
    if (paramString1.Ihq != null) {
      paramInt1 = paramString1.Ihq.getILen();
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.Ihr = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auJ("ce_ver_usr"));
      if (paramString1.Ihr != null)
      {
        paramInt1 = paramString1.Ihr.getILen();
        label400:
        ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
        if (paramString1.Ihs == null) {
          break label569;
        }
        paramInt1 = paramString1.Ihs.getILen();
        ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      try
      {
        ((dvz)localObject).FSj = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
        label492:
        ae.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify user:%d scene:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((dvz)localObject).Ibq.size()), Integer.valueOf(((dvz)localObject).Ibs.size()), paramString2, localdvw.GNI, Integer.valueOf(paramInt2) });
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
  
  public final void GN(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((dvz)this.rr.hQD.hQJ).Ibq.iterator();
    while (localIterator.hasNext()) {
      ((dvw)localIterator.next()).GMZ = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(dvx paramdvx)
  {
    AppMethodBeat.i(151643);
    if (paramdvx == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    ae.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramdvx.FQm), Integer.valueOf(paramdvx.Ibo), paramdvx.GvN });
    Iterator localIterator = ((dvz)this.rr.hQD.hQJ).Ibq.iterator();
    while (localIterator.hasNext())
    {
      dvw localdvw = (dvw)localIterator.next();
      try
      {
        localdvw.Ibn = new SKBuiltinBuffer_t().setBuffer(paramdvx.toByteArray());
      }
      catch (IOException localIOException)
      {
        ae.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
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
  
  public final String fdt()
  {
    if ((this.rr != null) && (this.rr.hQE != null)) {
      return ((dwa)this.rr.hQE.hQJ).nIJ;
    }
    return "";
  }
  
  public final int fdu()
  {
    return this.dto;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final void ly(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((dvz)this.rr.hQD.hQJ).Ibq.iterator();
    while (localIterator.hasNext())
    {
      dvw localdvw = (dvw)localIterator.next();
      localdvw.Ibh = paramString1;
      localdvw.Ibi = paramString2;
    }
    AppMethodBeat.o(151640);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151645);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151645);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(151642);
    Iterator localIterator = ((dvz)this.rr.hQD.hQJ).Ibq.iterator();
    while (localIterator.hasNext()) {
      ((dvw)localIterator.next()).FQm = paramInt;
    }
    AppMethodBeat.o(151642);
  }
  
  public final void vM(boolean paramBoolean)
  {
    dvz localdvz = (dvz)this.rr.hQD.hQJ;
    if (paramBoolean)
    {
      localdvz.Ibv = 1;
      return;
    }
    localdvz.Ibv = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */