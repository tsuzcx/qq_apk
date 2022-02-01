package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.y;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.ab.a.a.a;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends aa
{
  LinkedList<g> QWT;
  private LinkedList<g> QWU;
  private LinkedList<String> QWV;
  private int appType;
  
  public af(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151821);
    Log.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.appType = 3;
    localObject = new d.a();
    ((d.a)localObject).lBU = new cdn();
    ((d.a)localObject).lBV = new cdo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((d.a)localObject).funcId = 409;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (cdn)d.b.b(this.jTk.lBR);
    ((cdn)localObject).CNb = 3;
    ((cdn)localObject).CQe = 0;
    ((cdn)localObject).CQf = 20;
    ((cdn)localObject).CPt = paramString;
    paramString = cf(paramLinkedList);
    ((cdn)localObject).Tlp = paramString.size();
    ((cdn)localObject).CPO = paramString;
    this.QWT = new LinkedList();
    this.QWU = new LinkedList();
    this.QWV = new LinkedList();
    this.QWV.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, bp parambp)
  {
    AppMethodBeat.i(151829);
    paramg.HZ(parambp.RGI);
    paramg.Ic(parambp.CNU);
    paramg.Ia(parambp.RGK);
    paramg.field_appName = parambp.CQz;
    paramg.field_appIconUrl = parambp.RGJ;
    paramg.Id(parambp.RGM);
    paramg.Il(parambp.RGO);
    a(paramg, parambp.RGN);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, dst paramdst)
  {
    AppMethodBeat.i(151826);
    paramg.HZ(paramdst.RGI);
    paramg.field_appIconUrl = paramdst.RGJ;
    paramg.HY(paramdst.TYZ);
    paramg.field_appName = paramdst.CQz;
    paramg.Ia(paramdst.RGK);
    paramg.field_appType = paramdst.RSZ;
    paramg.Ic(paramdst.CNU);
    paramg.field_packageName = paramdst.RGL;
    paramg.Id(paramdst.RGM);
    if (!Util.isNullOrNil(paramdst.RGM))
    {
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramdst.RGM, Integer.valueOf(paramdst.TZj) });
      paramg.pm(paramdst.TZj);
    }
    paramg.Ie(paramdst.TZg);
    paramg.If(paramdst.TZh);
    a(paramg, paramdst.RGN);
    s(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, fqj paramfqj)
  {
    AppMethodBeat.i(151828);
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (paramfqj != null)
    {
      paramg.pm(paramfqj.UOf);
      paramg.Ii(paramfqj.Cqt);
      paramg.Ij(paramfqj.CSc);
      paramg.Ig(paramfqj.UOg);
      paramg.Ih(paramfqj.CSe);
      paramg.Ik(paramfqj.CSf);
      paramg.pn(paramfqj.CSg);
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramfqj.UOf), paramfqj.Cqt, paramfqj.CSc, paramfqj.UOg, paramfqj.CSe, paramfqj.CSf, Integer.valueOf(paramfqj.CSg) });
    }
    AppMethodBeat.o(151828);
  }
  
  private void a(j paramj, LinkedList<bp> paramLinkedList)
  {
    AppMethodBeat.i(151823);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        bp localbp = (bp)localIterator.next();
        paramLinkedList = h.o(localbp.jUi, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbp);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.QWU.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbp.jUi;
          a(paramLinkedList, localbp);
          paramj.r(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<dst> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dst localdst = (dst)localIterator.next();
        if (Util.isNullOrNil(localdst.jUi))
        {
          Log.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.o(localdst.jUi, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localdst);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((Util.isNullOrNil(paramLinkedList.hrL)) || (Util.isNullOrNil(paramLinkedList.hrK))) {
                if (paramLinkedList.hrL != null)
                {
                  bool1 = true;
                  if (paramLinkedList.hrK == null) {
                    break label262;
                  }
                  bool2 = true;
                  label148:
                  Log.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = paramj.a(paramLinkedList, new String[0]))
            {
              Log.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localdst.jUi, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.QWV.contains(localdst.jUi)) || (this.QWT.contains(paramLinkedList))) {
                break label426;
              }
              this.QWT.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localdst.jUi;
          a(paramLinkedList, localdst);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((Util.isNullOrNil(paramLinkedList.hrL)) || (Util.isNullOrNil(paramLinkedList.hrK))) {
              if (paramLinkedList.hrL != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.hrK == null) {
                  break label433;
                }
                bool2 = true;
                label357:
                Log.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localdst.jUi, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            break label215;
            label426:
            break;
            bool1 = false;
            break label347;
            label433:
            bool2 = false;
            break label357;
            bool2 = paramj.r(paramLinkedList);
            bool1 = bool4;
          }
        }
      }
    }
    AppMethodBeat.o(151824);
  }
  
  private static LinkedList<eaf> cf(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151825);
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(151825);
      return localLinkedList;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      if (!Util.isNullOrNil(str)) {
        localLinkedList.add(z.ZW(str));
      }
    }
    AppMethodBeat.o(151825);
    return localLinkedList;
  }
  
  private static void s(g paramg)
  {
    AppMethodBeat.i(151827);
    if ((!Util.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6"))))
    {
      if (!paramg.field_appType.endsWith(",")) {
        paramg.field_appType += ",";
      }
      paramg.field_appType = ("," + paramg.field_appType);
    }
    AppMethodBeat.o(151827);
  }
  
  public final void cS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    d.c localc = this.jTk.lBS;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151831);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151831);
    }
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final int hhC()
  {
    AppMethodBeat.i(211397);
    int i = ((cdo)d.c.b(this.jTk.lBS)).Tlq;
    AppMethodBeat.o(211397);
    return i;
  }
  
  public final byte[] hha()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((d.b)this.jTk.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151830);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      AppMethodBeat.o(151830);
    }
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151822);
    Log.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151822);
      return;
    }
    paramString = (cdo)d.c.b(this.jTk.lBS);
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.Tlq), Integer.valueOf(this.appType) });
    params = a.a.fmG().fmE();
    b(params, paramString.Tlr);
    a(params, paramString.CQN);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */