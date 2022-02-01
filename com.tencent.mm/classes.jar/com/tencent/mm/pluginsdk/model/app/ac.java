package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
  extends aa
{
  private static final String[] JWy = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ac(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bid();
    ((d.a)localObject).iLO = new bie();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((d.a)localObject).funcId = 451;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bid)this.hhm.iLK.iLR;
    LinkedList localLinkedList = is(paramList);
    ((bid)localObject).LSt = localLinkedList;
    ((bid)localObject).oTz = localLinkedList.size();
    ((bid)localObject).LSv = ir(paramList);
    if (((bid)localObject).LSv != null) {
      i = ((bid)localObject).LSv.size();
    }
    ((bid)localObject).LSu = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, nf paramnf)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = paramnf.jfi;
    }
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramnf.jfi, Integer.valueOf(paramnf.xIN), Long.valueOf(paramnf.KSe) });
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.gmR()) || (Util.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = paramnf.Name;
      }
      if ((!paramg.gmR()) || (Util.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = paramnf.KRP;
      }
      if ((!paramg.gmR()) || (Util.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = paramnf.KRR;
      }
      paramg.field_appDiscription = paramnf.KHk;
      paramg.field_appDiscription_en = paramnf.KRQ;
      paramg.field_appDiscription_tw = paramnf.KRS;
      paramg.field_appWatermarkUrl = paramnf.KRW;
      paramg.field_packageName = paramnf.KFu;
      Object localObject = paramnf.KRX;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        Log.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        Log.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramnf.KRX, paramg.field_signature, paramnf.KFu });
        paramg.field_appType = paramnf.KRY;
        if ((!Util.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = paramnf.xIN;
        paramg.field_appVersion = paramnf.KSa;
        paramg.Bk(paramnf.KRZ);
        paramg.field_appWatermarkUrl = paramnf.KRW;
        if ((!Util.isNullOrNil(paramnf.xuc)) && (!Util.isNullOrNil(paramnf.KSd)))
        {
          Log.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, paramnf.xuc, paramnf.KSd });
          paramg.Bl(paramnf.xuc);
          paramg.Bo(paramnf.KSd);
        }
        paramg.Bp(paramnf.KFv);
        paramg.field_svrAppSupportContentType = paramnf.KSe;
        if (paramnf.KSb > paramg.fmF)
        {
          paramg.fmG = 1;
          paramg.fma = true;
        }
        paramg.fmF = paramnf.KSb;
        paramg.fma = true;
        localObject = paramnf.KFu;
        String str = paramnf.KFu;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          Log.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramnf.KFu + "appid: " + paramg.field_appId);
        }
        if (paramg.NA()) {
          com.tencent.mm.pluginsdk.ui.tools.d.bfo(paramg.field_appId);
        }
        localObject = a.eAS();
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
        paramg.field_appIconUrl = paramnf.KRU;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < JWy.length)
        {
          if (paramg.field_appId.equals(JWy[i])) {
            paramg.field_status = -1;
          }
        }
        else
        {
          if (((j)localObject).r(paramg)) {
            break label733;
          }
          Log.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(151811);
          return;
          localObject = r.bdM((String)localObject);
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
      a.eAQ().gD(paramg.field_appId, 1);
      a.eAQ().gD(paramg.field_appId, 2);
      a.eAQ().gD(paramg.field_appId, 3);
      a.eAQ().gD(paramg.field_appId, 4);
      a.eAQ().gD(paramg.field_appId, 5);
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
          if (i < JWy.length)
          {
            if (!paramg.field_appId.equals(JWy[i])) {
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
        Log.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, paramnf.KRU });
        paramg.field_appIconUrl = paramnf.KRU;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.eAQ().gD(paramg.field_appId, 1);
        a.eAQ().gD(paramg.field_appId, 2);
        a.eAQ().gD(paramg.field_appId, 3);
        a.eAQ().gD(paramg.field_appId, 4);
        a.eAQ().gD(paramg.field_appId, 5);
      }
      for (;;)
      {
        Log.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramnf.jfi);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramnf == null) || (paramnf.KSc == null) || (paramnf.KSc.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(paramnf.KRU))
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
  
  private static LinkedList<dqi> ir(List<String> paramList)
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("key_open_sdk_pkg");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList1.add(localMultiProcessMMKV.decodeString((String)paramList.next(), ""));
    }
    paramList = localLinkedList1.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (Util.isNullOrNil((String)paramList.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(151808);
        return localLinkedList2;
      }
      paramList = is(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<dqi> is(List<String> paramList)
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
      if (!Util.isNullOrNil(paramList)) {
        localLinkedList.add(z.Su(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151813);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(151813);
      return;
    }
    try
    {
      this.hhm.iLL.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151813);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151813);
    }
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final byte[] gmB()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((d.b)this.hhm.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151812);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(151812);
    }
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151809);
    Log.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151809);
      return;
    }
    paramString = ((bie)this.hhm.iLL.iLR).LSw;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        params = (nf)paramString.next();
        if (params != null) {
          a(h.o(params.jfi, false, false), params);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */