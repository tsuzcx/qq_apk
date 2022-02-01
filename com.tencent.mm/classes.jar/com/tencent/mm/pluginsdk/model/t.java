package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.protocal.protobuf.fao;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class t
  extends q
  implements m
{
  public List<String> QVu;
  public String QVv;
  public List<String> QVw;
  private i callback;
  public int fDn;
  public String mWT;
  private final com.tencent.mm.an.d rr;
  
  public t(int paramInt, List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(paramInt, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public t(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    this(paramInt, paramList1, paramList, paramList2, paramString1, paramString2, paramMap, paramString3, paramString4, null);
    AppMethodBeat.i(151639);
    AppMethodBeat.o(151639);
  }
  
  public t(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(190161);
    this.QVu = null;
    this.fDn = 0;
    this.QVw = null;
    boolean bool;
    Object localObject;
    if (paramInt != 3)
    {
      bool = true;
      Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", bool);
      this.fDn = paramInt;
      this.QVu = paramList1;
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
      paramList2.lBU = new fao();
      paramList2.lBV = new fap();
      paramList2.uri = "/cgi-bin/micromsg-bin/verifyuser";
      paramList2.funcId = 137;
      paramList2.lBW = 44;
      paramList2.respCmdId = 1000000044;
      this.rr = paramList2.bgN();
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
        ((List)localObject).add(Util.nullAs(a.bBt().bcn().buW((String)paramList1.get(i)), ""));
        i += 1;
      }
      bool = false;
      break;
      label282:
      i = 0;
      while (i < ((List)localObject).size())
      {
        a.bBt().bcn().T((String)paramList1.get(i), 2147483633, (String)((List)localObject).get(i));
        i += 1;
      }
    }
    label340:
    fao localfao = (fao)d.b.b(this.rr.lBR);
    localfao.RNt = paramInt;
    localfao.Tlm = paramString1;
    this.QVv = paramString1;
    if (!Util.isNullOrNil(paramString5)) {
      localfao.UAD = paramString5;
    }
    paramString1 = new LinkedList();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      paramString5 = new fal();
      paramString5.Izj = ((String)paramList1.get(paramInt));
      if (paramString2 == null) {}
      for (paramList2 = "";; paramList2 = paramString2)
      {
        paramString5.UAm = paramList2;
        paramList2 = a.bBt().bcn();
        String str = paramString5.Izj;
        ((Integer)paramList.get(paramInt)).intValue();
        paramString5.Tav = Util.nullAs(paramList2.buW(str), "");
        if ((TextUtils.isEmpty(paramString5.Tav)) && (localObject != null) && (((List)localObject).size() > paramInt)) {
          paramString5.Tav = ((String)((List)localObject).get(paramInt));
        }
        paramString5.UeN = paramString3;
        if ((paramMap != null) && (paramMap.containsKey(paramString5.Izj))) {
          paramString5.UAn = ((Integer)paramMap.get(paramString5.Izj)).intValue();
        }
        paramString5.UAr = paramString4;
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", new Object[] { Integer.valueOf(this.fDn), Integer.valueOf(paramInt), paramString5.Izj, paramString5.Tav, paramString3, paramString4, Integer.valueOf(paramString5.UAn) });
        paramString1.add(paramString5);
        paramInt += 1;
        break;
      }
    }
    localfao.UAx = paramString1;
    localfao.UAw = paramString1.size();
    paramList1 = new LinkedList();
    paramList1.addAll(paramList);
    localfao.UAz = paramList1;
    localfao.UAy = paramList1.size();
    if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTk("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_ver_usr");
    }
    paramList1 = new fgr();
    paramList1.UGM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTl("ie_ver_usr"));
    if (paramList1.UGM != null) {
      paramInt = paramList1.UGM.Ufv;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
      paramList1.UGN = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_ver_usr"));
      if (paramList1.UGN != null)
      {
        paramInt = paramList1.UGN.Ufv;
        label855:
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList1.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
        if (paramList1.UGO == null) {
          break label1068;
        }
        paramInt = paramList1.UGO.Ufv;
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt) });
        paramList = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_ver_usr");
        if (paramList != null) {
          paramList1.UGT = new eae().dc(paramList.getBytes());
        }
      }
      try
      {
        localfao.RMN = new eae().dc(paramList1.toByteArray());
        label979:
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", new Object[] { Integer.valueOf(this.fDn), Integer.valueOf(localfao.UAx.size()), Integer.valueOf(localfao.UAz.size()), Util.listToString((List)localObject, ","), paramString3, Util.getStack() });
        AppMethodBeat.o(190161);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        break label855;
        label1068:
        paramInt = -1;
      }
      catch (Throwable paramList1)
      {
        break label979;
      }
    }
  }
  
  public t(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null, 0);
  }
  
  public t(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151638);
    this.QVu = null;
    this.fDn = 0;
    this.QVw = null;
    Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
    this.QVu = new LinkedList();
    this.QVu.add(paramString1);
    this.fDn = 3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fao();
    ((d.a)localObject).lBV = new fap();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyuser";
    ((d.a)localObject).funcId = 137;
    ((d.a)localObject).lBW = 44;
    ((d.a)localObject).respCmdId = 1000000044;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fao)d.b.b(this.rr.lBR);
    ((fao)localObject).RNt = 3;
    ((fao)localObject).Tlm = "";
    LinkedList localLinkedList = new LinkedList();
    fal localfal = new fal();
    localfal.Izj = paramString1;
    localfal.UAm = paramString2;
    localfal.Tav = a.bBt().bcn().buW(paramString1);
    localfal.UeN = paramString3;
    if (paramInt2 > 0) {
      localfal.UAn = paramInt2;
    }
    localLinkedList.add(localfal);
    ((fao)localObject).UAx = localLinkedList;
    ((fao)localObject).UAw = localLinkedList.size();
    paramString1 = new LinkedList();
    paramString1.add(Integer.valueOf(paramInt1));
    ((fao)localObject).UAz = paramString1;
    ((fao)localObject).UAy = paramString1.size();
    if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTk("ie_ver_usr")) {
      com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_ver_usr");
    }
    paramString1 = new fgr();
    paramString1.UGM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTl("ie_ver_usr"));
    if (paramString1.UGM != null) {
      paramInt1 = paramString1.UGM.Ufv;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
      paramString1.UGN = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_ver_usr"));
      if (paramString1.UGN != null)
      {
        paramInt1 = paramString1.UGN.Ufv;
        label403:
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString1.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
        if (paramString1.UGO == null) {
          break label607;
        }
        paramInt1 = paramString1.UGO.Ufv;
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", new Object[] { Integer.valueOf(paramInt1) });
        paramString3 = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_ver_usr");
        if (paramString3 != null) {
          paramString1.UGT = new eae().dc(paramString3.getBytes());
        }
      }
      try
      {
        ((fao)localObject).RMN = new eae().dc(paramString1.toByteArray());
        label530:
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify user:%d scene:%d ticket:%s anti:%s, friendFlag:%d", new Object[] { Integer.valueOf(((fao)localObject).UAx.size()), Integer.valueOf(((fao)localObject).UAz.size()), paramString2, localfal.Tav, Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151638);
        return;
        paramInt1 = -1;
        continue;
        paramInt1 = -1;
        break label403;
        label607:
        paramInt1 = -1;
      }
      catch (Throwable paramString1)
      {
        break label530;
      }
    }
  }
  
  public t(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(1, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public final void DO(boolean paramBoolean)
  {
    AppMethodBeat.i(190179);
    fao localfao = (fao)d.b.b(this.rr.lBR);
    if (paramBoolean)
    {
      localfao.UAC = 1;
      AppMethodBeat.o(190179);
      return;
    }
    localfao.UAC = 0;
    AppMethodBeat.o(190179);
  }
  
  public final void WW(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((fao)d.b.b(this.rr.lBR)).UAx.iterator();
    while (localIterator.hasNext()) {
      ((fal)localIterator.next()).SZI = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(fam paramfam)
  {
    AppMethodBeat.i(151643);
    if (paramfam == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramfam.RKI), Integer.valueOf(paramfam.UAv), paramfam.SsR });
    Iterator localIterator = ((fao)d.b.b(this.rr.lBR)).UAx.iterator();
    while (localIterator.hasNext())
    {
      fal localfal = (fal)localIterator.next();
      try
      {
        localfal.UAu = new eae().dc(paramfam.toByteArray());
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
  
  public final String hhc()
  {
    AppMethodBeat.i(190183);
    if ((this.rr != null) && (this.rr.lBS != null))
    {
      String str = ((fap)d.c.b(this.rr.lBS)).UserName;
      AppMethodBeat.o(190183);
      return str;
    }
    AppMethodBeat.o(190183);
    return "";
  }
  
  public final int hhd()
  {
    return this.fDn;
  }
  
  public final fap hhe()
  {
    AppMethodBeat.i(190193);
    fap localfap = (fap)d.c.b(this.rr.lBS);
    AppMethodBeat.o(190193);
    return localfap;
  }
  
  public final void nl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((fao)d.b.b(this.rr.lBR)).UAx.iterator();
    while (localIterator.hasNext())
    {
      fal localfal = (fal)localIterator.next();
      localfal.UAo = paramString1;
      localfal.UAp = paramString2;
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
    Iterator localIterator = ((fao)d.b.b(this.rr.lBR)).UAx.iterator();
    while (localIterator.hasNext()) {
      ((fal)localIterator.next()).RKI = paramInt;
    }
    AppMethodBeat.o(151642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */