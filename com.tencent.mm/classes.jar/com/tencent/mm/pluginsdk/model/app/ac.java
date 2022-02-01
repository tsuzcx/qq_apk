package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.y;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
  extends aa
{
  private static final String[] QWR = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ac(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpo();
    ((d.a)localObject).lBV = new bpp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((d.a)localObject).funcId = 451;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (bpo)d.b.b(this.jTk.lBR);
    LinkedList localLinkedList = jj(paramList);
    ((bpo)localObject).Tbf = localLinkedList;
    ((bpo)localObject).rVx = localLinkedList.size();
    ((bpo)localObject).Tbh = ji(paramList);
    if (((bpo)localObject).Tbh != null) {
      i = ((bpo)localObject).Tbh.size();
    }
    ((bpo)localObject).Tbg = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, mw parammw)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = parammw.lVG;
    }
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { parammw.lVG, Integer.valueOf(parammw.CMT), Long.valueOf(parammw.RTf) });
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.hhs()) || (Util.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = parammw.CMP;
      }
      if ((!paramg.hhs()) || (Util.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = parammw.RSQ;
      }
      if ((!paramg.hhs()) || (Util.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = parammw.RSS;
      }
      paramg.field_appDiscription = parammw.RIC;
      paramg.field_appDiscription_en = parammw.RSR;
      paramg.field_appDiscription_tw = parammw.RST;
      paramg.field_appWatermarkUrl = parammw.RSX;
      paramg.field_packageName = parammw.RGL;
      Object localObject = parammw.RSY;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        Log.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        Log.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { parammw.RSY, paramg.field_signature, parammw.RGL });
        paramg.field_appType = parammw.RSZ;
        if ((!Util.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = parammw.CMT;
        paramg.field_appVersion = parammw.RTb;
        paramg.HY(parammw.RTa);
        paramg.field_appWatermarkUrl = parammw.RSX;
        if ((!Util.isNullOrNil(parammw.Cqt)) && (!Util.isNullOrNil(parammw.RTe)))
        {
          Log.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, parammw.Cqt, parammw.RTe });
          paramg.HZ(parammw.Cqt);
          paramg.Ic(parammw.RTe);
        }
        paramg.Id(parammw.RGM);
        paramg.field_svrAppSupportContentType = parammw.RTf;
        if (parammw.RTc > paramg.hrE)
        {
          paramg.hrF = 1;
          paramg.hqZ = true;
        }
        paramg.hrE = parammw.RTc;
        paramg.hqZ = true;
        localObject = parammw.RGL;
        String str = parammw.RGL;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          Log.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + parammw.RGL + "appid: " + paramg.field_appId);
        }
        if (paramg.Qv()) {
          com.tencent.mm.pluginsdk.ui.tools.d.brJ(paramg.field_appId);
        }
        localObject = a.fmz();
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
        paramg.field_appIconUrl = parammw.RSV;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < QWR.length)
        {
          if (paramg.field_appId.equals(QWR[i])) {
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
          localObject = r.bqi((String)localObject);
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
      a.fmx().hm(paramg.field_appId, 1);
      a.fmx().hm(paramg.field_appId, 2);
      a.fmx().hm(paramg.field_appId, 3);
      a.fmx().hm(paramg.field_appId, 4);
      a.fmx().hm(paramg.field_appId, 5);
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
          if (i < QWR.length)
          {
            if (!paramg.field_appId.equals(QWR[i])) {
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
        Log.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, parammw.RSV });
        paramg.field_appIconUrl = parammw.RSV;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.fmx().hm(paramg.field_appId, 1);
        a.fmx().hm(paramg.field_appId, 2);
        a.fmx().hm(paramg.field_appId, 3);
        a.fmx().hm(paramg.field_appId, 4);
        a.fmx().hm(paramg.field_appId, 5);
      }
      for (;;)
      {
        Log.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + parammw.lVG);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((parammw == null) || (parammw.RTd == null) || (parammw.RTd.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(parammw.RSV))
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
  
  private static LinkedList<eaf> ji(List<String> paramList)
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
      paramList = jj(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<eaf> jj(List<String> paramList)
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
        localLinkedList.add(z.ZW(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void cS(byte[] paramArrayOfByte)
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
      this.jTk.lBS.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] hha()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((d.b)this.jTk.getReqObj()).toProtoBuf();
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
    paramString = ((bpp)d.c.b(this.jTk.lBS)).Tbi;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        params = (mw)paramString.next();
        if (params != null) {
          a(h.o(params.lVG, false, false), params);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */