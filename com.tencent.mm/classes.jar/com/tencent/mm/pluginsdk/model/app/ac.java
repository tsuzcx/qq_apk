package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
  extends aa
{
  private static final String[] ENk = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ac(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new awd();
    ((b.a)localObject).hNN = new awe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).funcId = 451;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (awd)this.grW.hNK.hNQ;
    LinkedList localLinkedList = hc(paramList);
    ((awd)localObject).GuQ = localLinkedList;
    ((awd)localObject).nDi = localLinkedList.size();
    ((awd)localObject).GuS = hb(paramList);
    if (((awd)localObject).GuS != null) {
      i = ((awd)localObject).GuS.size();
    }
    ((awd)localObject).GuR = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, ml paramml)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = paramml.iht;
    }
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramml.iht, Integer.valueOf(paramml.ufl), Long.valueOf(paramml.FFR) });
      ad.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.eZR()) || (bt.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = paramml.Name;
      }
      if ((!paramg.eZR()) || (bt.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = paramml.FFC;
      }
      if ((!paramg.eZR()) || (bt.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = paramml.FFE;
      }
      paramg.field_appDiscription = paramml.Fvh;
      paramg.field_appDiscription_en = paramml.FFD;
      paramg.field_appDiscription_tw = paramml.FFF;
      paramg.field_appWatermarkUrl = paramml.FFJ;
      paramg.field_packageName = paramml.Ftu;
      Object localObject = paramml.FFK;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        ad.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        ad.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramml.FFK, paramg.field_signature, paramml.Ftu });
        paramg.field_appType = paramml.FFL;
        if ((!bt.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = paramml.ufl;
        paramg.field_appVersion = paramml.FFN;
        paramg.sy(paramml.FFM);
        paramg.field_appWatermarkUrl = paramml.FFJ;
        if ((!bt.isNullOrNil(paramml.tRU)) && (!bt.isNullOrNil(paramml.FFQ)))
        {
          ad.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, paramml.tRU, paramml.FFQ });
          paramg.sz(paramml.tRU);
          paramg.sC(paramml.FFQ);
        }
        paramg.sD(paramml.Ftv);
        paramg.field_svrAppSupportContentType = paramml.FFR;
        if (paramml.FFO > paramg.eHu)
        {
          paramg.eHv = 1;
          paramg.eGP = true;
        }
        paramg.eHu = paramml.FFO;
        paramg.eGP = true;
        localObject = paramml.Ftu;
        String str = paramml.Ftu;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          ad.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramml.Ftu + "appid: " + paramg.field_appId);
        }
        if (paramg.Eb()) {
          d.aNo(paramg.field_appId);
        }
        localObject = a.dxQ();
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
        paramg.field_appIconUrl = paramml.FFH;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < ENk.length)
        {
          if (paramg.field_appId.equals(ENk[i])) {
            paramg.field_status = -1;
          }
        }
        else
        {
          if (((j)localObject).q(paramg)) {
            break label733;
          }
          ad.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(151811);
          return;
          localObject = r.aLQ((String)localObject);
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
      a.dxO().fW(paramg.field_appId, 1);
      a.dxO().fW(paramg.field_appId, 2);
      a.dxO().fW(paramg.field_appId, 3);
      a.dxO().fW(paramg.field_appId, 4);
      a.dxO().fW(paramg.field_appId, 5);
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
          if (i < ENk.length)
          {
            if (!paramg.field_appId.equals(ENk[i])) {
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
        ad.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, paramml.FFH });
        paramg.field_appIconUrl = paramml.FFH;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.dxO().fW(paramg.field_appId, 1);
        a.dxO().fW(paramg.field_appId, 2);
        a.dxO().fW(paramg.field_appId, 3);
        a.dxO().fW(paramg.field_appId, 4);
        a.dxO().fW(paramg.field_appId, 5);
      }
      for (;;)
      {
        ad.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramml.iht);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramml == null) || (paramml.FFP == null) || (paramml.FFP.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(paramml.FFH))
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
  
  private static LinkedList<cwt> hb(List<String> paramList)
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    ax localax = ax.aQA("key_open_sdk_pkg");
    if (localax == null)
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList1.add(localax.decodeString((String)paramList.next(), ""));
    }
    paramList = localLinkedList1.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (bt.isNullOrNil((String)paramList.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(151808);
        return localLinkedList2;
      }
      paramList = hc(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<cwt> hc(List<String> paramList)
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
      if (!bt.isNullOrNil(paramList)) {
        localLinkedList.add(z.IX(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void ch(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151813);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(151813);
      return;
    }
    try
    {
      this.grW.hNL.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151813);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151813);
    }
  }
  
  public final byte[] eZD()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((b.b)this.grW.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151812);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
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
    ad.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151809);
      return;
    }
    paramString = ((awe)this.grW.hNL.hNQ).GuT;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramq = (ml)paramString.next();
        if (paramq != null) {
          a(h.m(paramq.iht, false, false), paramq);
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