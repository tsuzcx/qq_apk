package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends ae
{
  private static final String[] XSP = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ag(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cef();
    ((c.a)localObject).otF = new ceg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((c.a)localObject).funcId = 451;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (cef)c.b.b(this.mtC.otB);
    LinkedList localLinkedList = mu(paramList);
    ((cef)localObject).aaor = localLinkedList;
    ((cef)localObject).vgN = localLinkedList.size();
    ((cef)localObject).aaot = mt(paramList);
    if (((cef)localObject).aaot != null) {
      i = ((cef)localObject).aaot.size();
    }
    ((cef)localObject).aaos = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, ob paramob)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = paramob.oOI;
    }
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramob.oOI, Integer.valueOf(paramob.IGY), Long.valueOf(paramob.YQF) });
      Log.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.iIs()) || (Util.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = paramob.IGU;
      }
      if ((!paramg.iIs()) || (Util.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = paramob.YQq;
      }
      if ((!paramg.iIs()) || (Util.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = paramob.YQs;
      }
      paramg.field_appDiscription = paramob.crB;
      paramg.field_appDiscription_en = paramob.YQr;
      paramg.field_appDiscription_tw = paramob.YQt;
      paramg.field_appWatermarkUrl = paramob.YQx;
      paramg.field_packageName = paramob.YDN;
      Object localObject = paramob.YQy;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        Log.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        Log.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramob.YQy, paramg.field_signature, paramob.YDN });
        paramg.field_appType = paramob.YQz;
        if ((!Util.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = paramob.IGY;
        paramg.field_appVersion = paramob.YQB;
        paramg.AD(paramob.YQA);
        paramg.field_appWatermarkUrl = paramob.YQx;
        if ((!Util.isNullOrNil(paramob.IcC)) && (!Util.isNullOrNil(paramob.YQE)))
        {
          Log.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, paramob.IcC, paramob.YQE });
          paramg.AE(paramob.IcC);
          paramg.AH(paramob.YQE);
        }
        paramg.AI(paramob.YDO);
        paramg.field_svrAppSupportContentType = paramob.YQF;
        if (paramob.YQC > paramg.jOr)
        {
          paramg.jOs = 1;
          paramg.jNM = true;
        }
        paramg.jOr = paramob.YQC;
        paramg.jNM = true;
        localObject = paramob.YDN;
        String str = paramob.YDN;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          Log.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramob.YDN + "appid: " + paramg.field_appId);
        }
        if (paramg.aqJ()) {
          d.bry(paramg.field_appId);
        }
        localObject = a.gxn();
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
        paramg.field_appIconUrl = paramob.YQv;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < XSP.length)
        {
          if (paramg.field_appId.equals(XSP[i])) {
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
          localObject = v.bpX((String)localObject);
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
      a.gxl().ir(paramg.field_appId, 1);
      a.gxl().ir(paramg.field_appId, 2);
      a.gxl().ir(paramg.field_appId, 3);
      a.gxl().ir(paramg.field_appId, 4);
      a.gxl().ir(paramg.field_appId, 5);
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
          if (i < XSP.length)
          {
            if (!paramg.field_appId.equals(XSP[i])) {
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
        Log.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, paramob.YQv });
        paramg.field_appIconUrl = paramob.YQv;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.gxl().ir(paramg.field_appId, 1);
        a.gxl().ir(paramg.field_appId, 2);
        a.gxl().ir(paramg.field_appId, 3);
        a.gxl().ir(paramg.field_appId, 4);
        a.gxl().ir(paramg.field_appId, 5);
      }
      for (;;)
      {
        Log.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramob.oOI);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramob == null) || (paramob.YQD == null) || (paramob.YQD.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(paramob.YQv))
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
  
  private static LinkedList<etl> mt(List<String> paramList)
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
      paramList = mu(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<etl> mu(List<String> paramList)
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
        localLinkedList.add(w.Sk(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void cV(byte[] paramArrayOfByte)
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
      this.mtC.otC.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] iIa()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((c.b)this.mtC.getReqObj()).toProtoBuf();
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
    paramString = ((ceg)c.c.b(this.mtC.otC)).aaou;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        params = (ob)paramString.next();
        if (params != null) {
          a(h.s(params.oOI, false, false), params);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */