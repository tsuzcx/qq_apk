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
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  private static final String[] BQj = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151807);
    paramList = new LinkedList(paramList);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new apb();
    ((b.a)localObject).gUV = new apc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).funcId = 451;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (apb)this.fUF.gUS.gUX;
    LinkedList localLinkedList = gF(paramList);
    ((apb)localObject).DqK = localLinkedList;
    ((apb)localObject).mAK = localLinkedList.size();
    ((apb)localObject).DqM = gE(paramList);
    if (((apb)localObject).DqM != null) {
      i = ((apb)localObject).DqM.size();
    }
    ((apb)localObject).DqL = i;
    AppMethodBeat.o(151807);
  }
  
  private static void a(g paramg, lp paramlp)
  {
    int k = 0;
    AppMethodBeat.i(151811);
    if (paramg == null)
    {
      paramg = new g();
      paramg.field_appId = paramlp.hnC;
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramlp.hnC, Integer.valueOf(paramlp.rZB), Long.valueOf(paramlp.CHG) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_status), Integer.valueOf(paramg.field_appInfoFlag) });
      if ((!paramg.evD()) || (bt.isNullOrNil(paramg.field_appName))) {
        paramg.field_appName = paramlp.Name;
      }
      if ((!paramg.evD()) || (bt.isNullOrNil(paramg.field_appName_en))) {
        paramg.field_appName_en = paramlp.CHr;
      }
      if ((!paramg.evD()) || (bt.isNullOrNil(paramg.field_appName_tw))) {
        paramg.field_appName_tw = paramlp.CHt;
      }
      paramg.field_appDiscription = paramlp.Cxw;
      paramg.field_appDiscription_en = paramlp.CHs;
      paramg.field_appDiscription_tw = paramlp.CHu;
      paramg.field_appWatermarkUrl = paramlp.CHy;
      paramg.field_packageName = paramlp.CvS;
      Object localObject = paramlp.CHz;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        localObject = null;
        paramg.field_signature = ((String)localObject);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", new Object[] { paramlp.CHz, paramg.field_signature, paramlp.CvS });
        paramg.field_appType = paramlp.CHA;
        if ((!bt.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6")))) {
          paramg.field_appType = ("," + paramg.field_appType);
        }
        paramg.field_appInfoFlag = paramlp.rZB;
        paramg.field_appVersion = paramlp.CHC;
        paramg.mI(paramlp.CHB);
        paramg.field_appWatermarkUrl = paramlp.CHy;
        if ((!bt.isNullOrNil(paramlp.rNA)) && (!bt.isNullOrNil(paramlp.CHF)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramg.field_appName, paramlp.rNA, paramlp.CHF });
          paramg.mJ(paramlp.rNA);
          paramg.mM(paramlp.CHF);
        }
        paramg.mN(paramlp.CvT);
        paramg.field_svrAppSupportContentType = paramlp.CHG;
        if (paramlp.CHD > paramg.eoh)
        {
          paramg.eoi = 1;
          paramg.enB = true;
        }
        paramg.eoh = paramlp.CHD;
        paramg.enB = true;
        localObject = paramlp.CvS;
        String str = paramlp.CvS;
        if ((localObject != null) && (((String)localObject).length() != 0) && (str != null) && (str.length() != 0)) {
          break label716;
        }
        j = 1;
        label553:
        if (j != 0) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramlp.CvS + "appid: " + paramg.field_appId);
        }
        if (paramg.CZ()) {
          d.aCu(paramg.field_appId);
        }
        localObject = a.cZQ();
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
        paramg.field_appIconUrl = paramlp.CHw;
        if (paramg.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < BQj.length)
        {
          if (paramg.field_appId.equals(BQj[i])) {
            paramg.field_status = -1;
          }
        }
        else
        {
          if (((j)localObject).q(paramg)) {
            break label733;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          AppMethodBeat.o(151811);
          return;
          localObject = r.aAY((String)localObject);
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
      a.cZO().fu(paramg.field_appId, 1);
      a.cZO().fu(paramg.field_appId, 2);
      a.cZO().fu(paramg.field_appId, 3);
      a.cZO().fu(paramg.field_appId, 4);
      a.cZO().fu(paramg.field_appId, 5);
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
          if (i < BQj.length)
          {
            if (!paramg.field_appId.equals(BQj[i])) {
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramg.field_appIconUrl, paramlp.CHw });
        paramg.field_appIconUrl = paramlp.CHw;
        bool = ((j)localObject).a(paramg, new String[0]);
        a.cZO().fu(paramg.field_appId, 1);
        a.cZO().fu(paramg.field_appId, 2);
        a.cZO().fu(paramg.field_appId, 3);
        a.cZO().fu(paramg.field_appId, 4);
        a.cZO().fu(paramg.field_appId, 5);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramlp.hnC);
        AppMethodBeat.o(151811);
        return;
        i = paramg.field_status;
        break;
        label1020:
        i += 1;
        break label814;
        label1027:
        if ((paramlp == null) || (paramlp.CHE == null) || (paramlp.CHE.length() == 0))
        {
          i = 0;
          break label865;
        }
        if (!paramg.field_appIconUrl.equals(paramlp.CHw))
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
  
  private static LinkedList<cmf> gE(List<String> paramList)
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(151808);
      return localLinkedList2;
    }
    ax localax = ax.aFD("key_open_sdk_pkg");
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
      paramList = gF(localLinkedList1);
      AppMethodBeat.o(151808);
      return paramList;
    }
  }
  
  private static LinkedList<cmf> gF(List<String> paramList)
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
        localLinkedList.add(z.BE(paramList));
      }
      i += 1;
    }
    AppMethodBeat.o(151810);
    return localLinkedList;
  }
  
  public final void cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151813);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      AppMethodBeat.o(151813);
      return;
    }
    try
    {
      this.fUF.gUT.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151813);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151813);
    }
  }
  
  public final byte[] evp()
  {
    AppMethodBeat.i(151812);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fUF.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151812);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151809);
      return;
    }
    paramString = ((apc)this.fUF.gUT.gUX).DqN;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramq = (lp)paramString.next();
        if (paramq != null) {
          a(h.j(paramq.hnC, false, false), paramq);
        }
      }
    }
    AppMethodBeat.o(151809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */