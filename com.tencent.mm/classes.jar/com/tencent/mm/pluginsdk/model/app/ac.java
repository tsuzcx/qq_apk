package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
  extends aa
{
  private static final String[] FfH = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ac(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awt();
    ((b.a)localObject).hQG = new awu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).funcId = 451;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (awt)this.gux.hQD.hQJ;
    LinkedList localLinkedList = hm(paramList);
    ((awt)localObject).GOp = localLinkedList;
    ((awt)localObject).nID = localLinkedList.size();
    ((awt)localObject).GOr = hl(paramList);
    if (((awt)localObject).GOr != null) {
      i = ((awt)localObject).GOr.size();
    }
    ((awt)localObject).GOq = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, mn parammn)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = parammn.ikm;
    }
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { parammn.ikm, Integer.valueOf(parammn.uqv), Long.valueOf(parammn.FYn) });
      ae.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.fdF()) || (bu.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = parammn.Name;
      }
      if ((!paramg.fdF()) || (bu.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = parammn.FXY;
      }
      if ((!paramg.fdF()) || (bu.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = parammn.FYa;
      }
      paramg.field_appDiscription = parammn.FNF;
      paramg.field_appDiscription_en = parammn.FXZ;
      paramg.field_appDiscription_tw = parammn.FYb;
      paramg.field_appWatermarkUrl = parammn.FYf;
      paramg.field_packageName = parammn.FLS;
      Object localObject = parammn.FYg;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        ae.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        ae.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { parammn.FYg, paramg.field_signature, parammn.FLS });
        paramg.field_appType = parammn.FYh;
        if ((!bu.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = parammn.uqv;
        paramg.field_appVersion = parammn.FYj;
        paramg.sT(parammn.FYi);
        paramg.field_appWatermarkUrl = parammn.FYf;
        if ((!bu.isNullOrNil(parammn.ucL)) && (!bu.isNullOrNil(parammn.FYm)))
        {
          ae.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, parammn.ucL, parammn.FYm });
          paramg.sU(parammn.ucL);
          paramg.sX(parammn.FYm);
        }
        paramg.sY(parammn.FLT);
        paramg.field_svrAppSupportContentType = parammn.FYn;
        if (parammn.FYk > paramg.eJd)
        {
          paramg.eJe = 1;
          paramg.eIy = true;
        }
        paramg.eJd = parammn.FYk;
        paramg.eIy = true;
        localObject = parammn.FLS;
        String str = parammn.FLS;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          ae.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + parammn.FLS + "appid: " + paramg.field_appId);
        }
        if (paramg.Ee()) {
          d.aOL(paramg.field_appId);
        }
        localObject = a.dBg();
        if (i == 0) {
          break label794;
        }
        if (j == 0) {
          break label721;
        }
        i = 3;
        label625:
        paramg.field_status = i;
        paramg.field_modifyTime = System.currentTimeMillis();
        paramg.field_appIconUrl = parammn.FYd;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < FfH.length)
        {
          if (paramg.field_appId.equals(FfH[i])) {
            paramg.field_status = -1;
          }
        }
        else
        {
          if (((j)localObject).q(paramg)) {
            break label733;
          }
          ae.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(151811);
          return;
          localObject = r.aNm((String)localObject);
          break;
          label716:
          j = 0;
          break label553;
          label721:
          i = 4;
          break label625;
        }
        i += 1;
      }
      label733:
      a.dBe().gf(paramg.field_appId, 1);
      a.dBe().gf(paramg.field_appId, 2);
      a.dBe().gf(paramg.field_appId, 3);
      a.dBe().gf(paramg.field_appId, 4);
      a.dBe().gf(paramg.field_appId, 5);
      AppMethodBeat.o(151811);
      return;
      label794:
      label814:
      label865:
      boolean bool;
      if (j != 0)
      {
        i = 3;
        paramg.field_status = i;
        if (paramg.field_appId != null)
        {
          i = 0;
          if (i < FfH.length)
          {
            if (!paramg.field_appId.equals(FfH[i])) {
              break label1020;
            }
            paramg.field_status = -1;
          }
        }
        if ((paramg != null) && (paramg.field_appIconUrl != null) && (paramg.field_appIconUrl.length() != 0)) {
          break label1027;
        }
        i = 1;
        if (i == 0) {
          break label1077;
        }
        ae.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, parammn.FYd });
        paramg.field_appIconUrl = parammn.FYd;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.dBe().gf(paramg.field_appId, 1);
        a.dBe().gf(paramg.field_appId, 2);
        a.dBe().gf(paramg.field_appId, 3);
        a.dBe().gf(paramg.field_appId, 4);
        a.dBe().gf(paramg.field_appId, 5);
      }
      for (;;)
      {
        ae.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + parammn.ikm);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((parammn == null) || (parammn.FYl == null) || (parammn.FYl.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(parammn.FYd))
        {
          i = 1;
          break label865;
        }
        i = 0;
        break label865;
        label1077:
        bool = ((j)localObject).a(paramg, new String[0]);
      }
    }
  }
  
  private static LinkedList<cxn> hl(List<String> paramList)
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    ay localay = ay.aRX("key_open_sdk_pkg");
    if (localay == null)
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList1.add(localay.decodeString((String)paramList.next(), ""));
    }
    paramList = localLinkedList1.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (bu.isNullOrNil((String)paramList.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(151808);
        return localLinkedList2;
      }
      paramList = hm(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<cxn> hm(List<String> paramList)
  {
    AppMethodBeat.i(151810);
    LinkedList localLinkedList = new LinkedList();
    String[] arrayOfString = new String[paramList.size()];
    paramList.toArray(arrayOfString);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramList = arrayOfString[i];
      if (!bu.isNullOrNil(paramList)) {
        localLinkedList.add(z.Jw(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151813);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(151813);
      return;
    }
    try
    {
      this.gux.hQE.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151813);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151813);
    }
  }
  
  public final byte[] fdr()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((b.b)this.gux.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151812);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(151812);
    }
    return null;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151809);
    ae.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151809);
      return;
    }
    paramString = ((awu)this.gux.hQE.hQJ).GOs;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramq = (mn)paramString.next();
        if (paramq != null) {
          a(h.m(paramq.ikm, false, false), paramq);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */