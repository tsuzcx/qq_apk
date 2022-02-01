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
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  private static final String[] Dix = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new asf();
    ((b.a)localObject).hvu = new asg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).funcId = 451;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (asf)this.fYA.hvr.hvw;
    LinkedList localLinkedList = gQ(paramList);
    ((asf)localObject).ELM = localLinkedList;
    ((asf)localObject).ncL = localLinkedList.size();
    ((asf)localObject).ELO = gP(paramList);
    if (((asf)localObject).ELO != null) {
      i = ((asf)localObject).ELO.size();
    }
    ((asf)localObject).ELN = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, lw paramlw)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = paramlw.hOf;
    }
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramlw.hOf, Integer.valueOf(paramlw.thu), Long.valueOf(paramlw.Eai) });
      ac.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.eKX()) || (bs.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = paramlw.Name;
      }
      if ((!paramg.eKX()) || (bs.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = paramlw.DZT;
      }
      if ((!paramg.eKX()) || (bs.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = paramlw.DZV;
      }
      paramg.field_appDiscription = paramlw.DPS;
      paramg.field_appDiscription_en = paramlw.DZU;
      paramg.field_appDiscription_tw = paramlw.DZW;
      paramg.field_appWatermarkUrl = paramlw.Eaa;
      paramg.field_packageName = paramlw.DOn;
      Object localObject = paramlw.Eab;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        ac.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        ac.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramlw.Eab, paramg.field_signature, paramlw.DOn });
        paramg.field_appType = paramlw.Eac;
        if ((!bs.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = paramlw.thu;
        paramg.field_appVersion = paramlw.Eae;
        paramg.pO(paramlw.Ead);
        paramg.field_appWatermarkUrl = paramlw.Eaa;
        if ((!bs.isNullOrNil(paramlw.sVp)) && (!bs.isNullOrNil(paramlw.Eah)))
        {
          ac.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, paramlw.sVp, paramlw.Eah });
          paramg.pP(paramlw.sVp);
          paramg.pS(paramlw.Eah);
        }
        paramg.pT(paramlw.DOo);
        paramg.field_svrAppSupportContentType = paramlw.Eai;
        if (paramlw.Eaf > paramg.eql)
        {
          paramg.eqm = 1;
          paramg.epG = true;
        }
        paramg.eql = paramlw.Eaf;
        paramg.epG = true;
        localObject = paramlw.DOn;
        String str = paramlw.DOn;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          ac.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramlw.DOn + "appid: " + paramg.field_appId);
        }
        if (paramg.CC()) {
          d.aHM(paramg.field_appId);
        }
        localObject = a.dny();
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
        paramg.field_appIconUrl = paramlw.DZY;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < Dix.length)
        {
          if (paramg.field_appId.equals(Dix[i])) {
            paramg.field_status = -1;
          }
        }
        else
        {
          if (((j)localObject).q(paramg)) {
            break label733;
          }
          ac.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(151811);
          return;
          localObject = r.aGq((String)localObject);
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
      a.dnw().fz(paramg.field_appId, 1);
      a.dnw().fz(paramg.field_appId, 2);
      a.dnw().fz(paramg.field_appId, 3);
      a.dnw().fz(paramg.field_appId, 4);
      a.dnw().fz(paramg.field_appId, 5);
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
          if (i < Dix.length)
          {
            if (!paramg.field_appId.equals(Dix[i])) {
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
        ac.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, paramlw.DZY });
        paramg.field_appIconUrl = paramlw.DZY;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.dnw().fz(paramg.field_appId, 1);
        a.dnw().fz(paramg.field_appId, 2);
        a.dnw().fz(paramg.field_appId, 3);
        a.dnw().fz(paramg.field_appId, 4);
        a.dnw().fz(paramg.field_appId, 5);
      }
      for (;;)
      {
        ac.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramlw.hOf);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramlw == null) || (paramlw.Eag == null) || (paramlw.Eag.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(paramlw.DZY))
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
  
  private static LinkedList<crm> gP(List<String> paramList)
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    aw localaw = aw.aKU("key_open_sdk_pkg");
    if (localaw == null)
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList1.add(localaw.decodeString((String)paramList.next(), ""));
    }
    paramList = localLinkedList1.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (bs.isNullOrNil((String)paramList.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(151808);
        return localLinkedList2;
      }
      paramList = gQ(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<crm> gQ(List<String> paramList)
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
      if (!bs.isNullOrNil(paramList)) {
        localLinkedList.add(z.FI(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151813);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(151813);
      return;
    }
    try
    {
      this.fYA.hvs.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151813);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151813);
    }
  }
  
  public final byte[] eKJ()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fYA.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151812);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
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
    ac.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151809);
      return;
    }
    paramString = ((asg)this.fYA.hvs.hvw).ELP;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramq = (lw)paramString.next();
        if (paramq != null) {
          a(h.k(paramq.hOf, false, false), paramq);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */