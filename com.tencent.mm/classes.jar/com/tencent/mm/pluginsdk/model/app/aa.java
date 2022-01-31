package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
  extends x
{
  private static final String[] vLz = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public aa(List<String> paramList)
  {
    AppMethodBeat.i(79372);
    paramList = new LinkedList(paramList);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afw();
    ((b.a)localObject).fsY = new afx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).funcId = 451;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (afw)this.lFp.fsV.fta;
    LinkedList localLinkedList = en(paramList);
    ((afw)localObject).wYX = localLinkedList;
    ((afw)localObject).jJu = localLinkedList.size();
    ((afw)localObject).wYZ = em(paramList);
    if (((afw)localObject).wYZ != null) {
      i = ((afw)localObject).wYZ.size();
    }
    ((afw)localObject).wYY = i;
    AppMethodBeat.o(79372);
  }
  
  private static void a(f paramf, kc paramkc)
  {
    int k = 0;
    AppMethodBeat.i(79374);
    if (paramf == null)
    {
      paramf = new f();
      paramf.field_appId = paramkc.fKw;
    }
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramkc.fKw, Integer.valueOf(paramkc.nqf), Long.valueOf(paramkc.wxc) });
      ab.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_status), Integer.valueOf(paramf.field_appInfoFlag) });
      if ((!paramf.dlw()) || (bo.isNullOrNil(paramf.field_appName))) {
        paramf.field_appName = paramkc.Name;
      }
      if ((!paramf.dlw()) || (bo.isNullOrNil(paramf.field_appName_en))) {
        paramf.field_appName_en = paramkc.wwM;
      }
      if ((!paramf.dlw()) || (bo.isNullOrNil(paramf.field_appName_tw))) {
        paramf.field_appName_tw = paramkc.wwO;
      }
      paramf.field_appDiscription = paramkc.woO;
      paramf.field_appDiscription_en = paramkc.wwN;
      paramf.field_appDiscription_tw = paramkc.wwP;
      paramf.field_appWatermarkUrl = paramkc.wwT;
      paramf.field_packageName = paramkc.wnB;
      Object localObject = paramkc.wwU;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        ab.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramf.field_signature = ((String)localObject);
        ab.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramkc.wwU, paramf.field_signature, paramkc.wnB });
        paramf.field_appType = paramkc.wwV;
        if ((!bo.isNullOrNil(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6")))) {
          paramf.field_appType = ("," + paramf.field_appType);
        }
        paramf.field_appInfoFlag = paramkc.nqf;
        paramf.field_appVersion = paramkc.wwX;
        paramf.iU(paramkc.wwW);
        paramf.field_appWatermarkUrl = paramkc.wwT;
        if ((!bo.isNullOrNil(paramkc.wxa)) && (!bo.isNullOrNil(paramkc.wxb)))
        {
          ab.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramf.field_appName, paramkc.wxa, paramkc.wxb });
          paramf.iV(paramkc.wxa);
          paramf.iY(paramkc.wxb);
        }
        paramf.iZ(paramkc.wnC);
        paramf.field_svrAppSupportContentType = paramkc.wxc;
        if (paramkc.wwY > paramf.djK)
        {
          paramf.djL = 1;
          paramf.dje = true;
        }
        paramf.djK = paramkc.wwY;
        paramf.dje = true;
        localObject = paramkc.wnB;
        String str = paramkc.wnB;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          ab.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramkc.wnB + "appid: " + paramf.field_appId);
        }
        if (paramf.vY()) {
          com.tencent.mm.pluginsdk.ui.tools.b.amE(paramf.field_appId);
        }
        localObject = a.cac();
        if (i == 0) {
          break label794;
        }
        if (j == 0) {
          break label721;
        }
        i = 3;
        label625:
        paramf.field_status = i;
        paramf.field_modifyTime = System.currentTimeMillis();
        paramf.field_appIconUrl = paramkc.wwR;
        if (paramf.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < vLz.length)
        {
          if (paramf.field_appId.equals(vLz[i])) {
            paramf.field_status = -1;
          }
        }
        else
        {
          if (((i)localObject).p(paramf)) {
            break label733;
          }
          ab.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(79374);
          return;
          localObject = q.aly((String)localObject);
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
      a.caa().el(paramf.field_appId, 1);
      a.caa().el(paramf.field_appId, 2);
      a.caa().el(paramf.field_appId, 3);
      a.caa().el(paramf.field_appId, 4);
      a.caa().el(paramf.field_appId, 5);
      AppMethodBeat.o(79374);
      return;
      label794:
      label814:
      label865:
      boolean bool;
      if (j != 0)
      {
        i = 3;
        paramf.field_status = i;
        if (paramf.field_appId != null)
        {
          i = 0;
          if (i < vLz.length)
          {
            if (!paramf.field_appId.equals(vLz[i])) {
              break label1020;
            }
            paramf.field_status = -1;
          }
        }
        if ((paramf != null) && (paramf.field_appIconUrl != null) && (paramf.field_appIconUrl.length() != 0)) {
          break label1027;
        }
        i = 1;
        if (i == 0) {
          break label1077;
        }
        ab.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramf.field_appIconUrl, paramkc.wwR });
        paramf.field_appIconUrl = paramkc.wwR;
        bool = ((i)localObject).a(paramf, new String[0]);
        a.caa().el(paramf.field_appId, 1);
        a.caa().el(paramf.field_appId, 2);
        a.caa().el(paramf.field_appId, 3);
        a.caa().el(paramf.field_appId, 4);
        a.caa().el(paramf.field_appId, 5);
      }
      for (;;)
      {
        ab.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramkc.fKw);
        AppMethodBeat.o(79374);
        return;
        i = paramf.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramkc == null) || (paramkc.wwZ == null) || (paramkc.wwZ.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramf.field_appIconUrl.equals(paramkc.wwR))
        {
          i = 1;
          break label865;
        }
        i = 0;
        break label865;
        label1077:
        bool = ((i)localObject).a(paramf, new String[0]);
      }
    }
  }
  
  private static LinkedList<bwc> em(List<String> paramList)
  {
    AppMethodBeat.i(154792);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (bo.es(paramList))
    {
      AppMethodBeat.o(154792);
      return localLinkedList2;
    }
    as localas = as.eu("key_open_sdk_pkg", 1);
    if (localas == null)
    {
      AppMethodBeat.o(154792);
      return localLinkedList2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList1.add(localas.decodeString((String)paramList.next(), ""));
    }
    paramList = localLinkedList1.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (bo.isNullOrNil((String)paramList.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(154792);
        return localLinkedList2;
      }
      paramList = en(localLinkedList1);
      AppMethodBeat.o(154792);
      return paramList;
    }
  }
  
  private static LinkedList<bwc> en(List<String> paramList)
  {
    AppMethodBeat.i(151619);
    LinkedList localLinkedList = new LinkedList();
    String[] arrayOfString = new String[paramList.size()];
    paramList.toArray(arrayOfString);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramList = arrayOfString[i];
      if (!bo.isNullOrNil(paramList)) {
        localLinkedList.add(com.tencent.mm.platformtools.aa.wA(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151619);
    return localLinkedList;
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79376);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(79376);
      return;
    }
    try
    {
      this.lFp.fsW.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(79376);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(79376);
    }
  }
  
  public final byte[] dli()
  {
    AppMethodBeat.i(79375);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lFp.getReqObj()).toProtoBuf();
      AppMethodBeat.o(79375);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
      AppMethodBeat.o(79375);
    }
    return null;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79373);
    ab.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(79373);
      return;
    }
    paramString = ((afx)this.lFp.fsW.fta).wZa;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramq = (kc)paramString.next();
        if (paramq != null) {
          a(g.ca(paramq.fKw, false), paramq);
        }
      }
    }
    AppMethodBeat.o(79373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aa
 * JD-Core Version:    0.7.0.1
 */