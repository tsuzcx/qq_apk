package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public List<String> BOW;
  public String BOX;
  private List<String> BOY;
  private com.tencent.mm.al.g callback;
  public int djq;
  public String ilh;
  private final com.tencent.mm.al.b rr;
  
  public o(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151639);
    this.BOW = null;
    this.djq = 0;
    this.BOY = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.djq = paramInt;
      this.BOW = paramList1;
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
      paramList2.gUU = new djw();
      paramList2.gUV = new djx();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.reqCmdId = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.atI();
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
        ((List)localObject).add(bt.by(a.aLf().aqn().aHl((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.aLf().aqn().D((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    djw localdjw = (djw)this.rr.gUS.gUX;
    localdjw.CCB = paramInt;
    localdjw.DyE = paramString1;
    this.BOX = paramString1;
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      djt localdjt = new djt();
      localdjt.vJI = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        localdjt.Ezy = paramList2;
        paramList2 = a.aLf().aqn();
        String str = localdjt.vJI;
        ((Integer)paramList.get(paramInt)).intValue();
        localdjt.Dqd = bt.by(paramList2.aHl(str), "");
        if ((TextUtils.isEmpty(localdjt.Dqd)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          localdjt.Dqd = ((String)((List)localObject).get(paramInt));
        }
        localdjt.EgI = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(localdjt.vJI))) {
          localdjt.Ezz = ((Integer)paramMap.get(localdjt.vJI)).intValue();
        }
        localdjt.EzD = paramString4;
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.djq), Integer.valueOf(paramInt), localdjt.vJI, localdjt.Dqd, paramString3, paramString4, Integer.valueOf(localdjt.Ezz) });
        paramString1.add(localdjt);
        paramInt += 1;
        break;
      }
    }
    localdjw.EzJ = paramString1;
    localdjw.EzI = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localdjw.EzL = paramList1;
    localdjw.EzK = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.b.ufs.aju("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_ver_usr");
    }
    paramList1 = new dow();
    paramList1.EFa = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajv("ie_ver_usr"));
    if (paramList1.EFa != null) {
      paramInt = paramList1.EFa.getILen();
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.EFb = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajy("ce_ver_usr"));
      if (paramList1.EFb != null)
      {
        paramInt = paramList1.EFb.getILen();
        label837:
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
        if (paramList1.EFc == null) {
          break label1018;
        }
        paramInt = paramList1.EFc.getILen();
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      }
      try
      {
        localdjw.CBU = new SKBuiltinBuffer_t().setBuffer(paramList1.toByteArray());
        label929:
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.djq), Integer.valueOf(localdjw.EzJ.size()), Integer.valueOf(localdjw.EzL.size()), bt.n((List)localObject, ","), paramString3, bt.eGN() });
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
    this.BOW = null;
    this.djq = 0;
    this.BOY = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.BOW = new LinkedList();
    this.BOW.add(paramString1);
    this.djq = 3;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djw();
    ((b.a)localObject).gUV = new djx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((b.a)localObject).funcId = 137;
    ((b.a)localObject).reqCmdId = 44;
    ((b.a)localObject).respCmdId = 1000000044;
    this.rr = ((b.a)localObject).atI();
    localObject = (djw)this.rr.gUS.gUX;
    ((djw)localObject).CCB = 3;
    ((djw)localObject).DyE = "";
    LinkedList localLinkedList = new LinkedList();
    djt localdjt = new djt();
    localdjt.vJI = paramString1;
    localdjt.Ezy = paramString2;
    localdjt.Dqd = a.aLf().aqn().aHl(paramString1);
    localdjt.EgI = paramString3;
    if (paramInt2 > 0) {
      localdjt.Ezz = paramInt2;
    }
    localLinkedList.add(localdjt);
    ((djw)localObject).EzJ = localLinkedList;
    ((djw)localObject).EzI = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((djw)localObject).EzL = paramString1;
    ((djw)localObject).EzK = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.b.ufs.aju("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_ver_usr");
    }
    paramString1 = new dow();
    paramString1.EFa = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajv("ie_ver_usr"));
    if (paramString1.EFa != null) {
      paramInt1 = paramString1.EFa.getILen();
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.EFb = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajy("ce_ver_usr"));
      if (paramString1.EFb != null)
      {
        paramInt1 = paramString1.EFb.getILen();
        label400:
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
        if (paramString1.EFc == null) {
          break label569;
        }
        paramInt1 = paramString1.EFc.getILen();
        ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      try
      {
        ((djw)localObject).CBU = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
        label492:
        ad.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((djw)localObject).EzJ.size()), Integer.valueOf(((djw)localObject).EzL.size()), paramString2, localdjt.Dqd, Integer.valueOf(paramInt2) });
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
  
  public final void a(dju paramdju)
  {
    AppMethodBeat.i(151643);
    if (paramdju == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    ad.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramdju.CzZ), Integer.valueOf(paramdju.EzH), paramdju.DcD });
    Iterator localIterator = ((djw)this.rr.gUS.gUX).EzJ.iterator();
    while (localIterator.hasNext())
    {
      djt localdjt = (djt)localIterator.next();
      try
      {
        localdjt.EzG = new SKBuiltinBuffer_t().setBuffer(paramdju.toByteArray());
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(151643);
  }
  
  public int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(151644);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151644);
    return i;
  }
  
  public final String evr()
  {
    if ((this.rr != null) && (this.rr.gUT != null)) {
      return ((djx)this.rr.gUT.gUX).mAQ;
    }
    return "";
  }
  
  public final int evs()
  {
    return this.djq;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final void kx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((djw)this.rr.gUS.gUX).EzJ.iterator();
    while (localIterator.hasNext())
    {
      djt localdjt = (djt)localIterator.next();
      localdjt.EzA = paramString1;
      localdjt.EzB = paramString2;
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
    Iterator localIterator = ((djw)this.rr.gUS.gUX).EzJ.iterator();
    while (localIterator.hasNext()) {
      ((djt)localIterator.next()).CzZ = paramInt;
    }
    AppMethodBeat.o(151642);
  }
  
  public final void tS(boolean paramBoolean)
  {
    djw localdjw = (djw)this.rr.gUS.gUX;
    if (paramBoolean)
    {
      localdjw.EzO = 1;
      return;
    }
    localdjw.EzO = 0;
  }
  
  public final void zb(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((djw)this.rr.gUS.gUX).EzJ.iterator();
    while (localIterator.hasNext()) {
      ((djt)localIterator.next()).Dpx = paramString;
    }
    AppMethodBeat.o(151641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */