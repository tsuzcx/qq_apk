package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.openapi.a.a;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.elo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gns;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
  extends ae
{
  LinkedList<g> XSR;
  private LinkedList<g> XSS;
  private LinkedList<String> XST;
  private int appType;
  
  public aj(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151821);
    Log.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.appType = 3;
    localObject = new c.a();
    ((c.a)localObject).otE = new ctd();
    ((c.a)localObject).otF = new cte();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((c.a)localObject).funcId = 409;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (ctd)c.b.b(this.mtC.otB);
    ((ctd)localObject).IHg = 3;
    ((ctd)localObject).IKo = 0;
    ((ctd)localObject).IKp = 20;
    ((ctd)localObject).IJD = paramString;
    paramString = cr(paramLinkedList);
    ((ctd)localObject).aayZ = paramString.size();
    ((ctd)localObject).IJY = paramString;
    this.XSR = new LinkedList();
    this.XSS = new LinkedList();
    this.XST = new LinkedList();
    this.XST.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, bz parambz)
  {
    AppMethodBeat.i(151829);
    paramg.AE(parambz.YDK);
    paramg.AH(parambz.IIe);
    paramg.AF(parambz.YDM);
    paramg.field_appName = parambz.IKJ;
    paramg.field_appIconUrl = parambz.YDL;
    paramg.AI(parambz.YDO);
    paramg.AQ(parambz.YDQ);
    a(paramg, parambz.YDP);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, elo paramelo)
  {
    AppMethodBeat.i(151826);
    paramg.AE(paramelo.YDK);
    paramg.field_appIconUrl = paramelo.YDL;
    paramg.AD(paramelo.abpW);
    paramg.field_appName = paramelo.IKJ;
    paramg.AF(paramelo.YDM);
    paramg.field_appType = paramelo.YQz;
    paramg.AH(paramelo.IIe);
    paramg.field_packageName = paramelo.YDN;
    paramg.AI(paramelo.YDO);
    if (!Util.isNullOrNil(paramelo.YDO))
    {
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramelo.YDO, Integer.valueOf(paramelo.abqg) });
      paramg.pl(paramelo.abqg);
    }
    paramg.AJ(paramelo.abqd);
    paramg.AK(paramelo.abqe);
    a(paramg, paramelo.YDP);
    s(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, gns paramgns)
  {
    AppMethodBeat.i(151828);
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (paramgns != null)
    {
      paramg.pl(paramgns.aciH);
      paramg.AN(paramgns.IcC);
      paramg.AO(paramgns.IMs);
      paramg.AL(paramgns.aciI);
      paramg.AM(paramgns.IMu);
      paramg.AP(paramgns.IMv);
      paramg.pm(paramgns.IMw);
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramgns.aciH), paramgns.IcC, paramgns.IMs, paramgns.aciI, paramgns.IMu, paramgns.IMv, Integer.valueOf(paramgns.IMw) });
    }
    AppMethodBeat.o(151828);
  }
  
  private void a(j paramj, LinkedList<bz> paramLinkedList)
  {
    AppMethodBeat.i(151823);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        bz localbz = (bz)localIterator.next();
        paramLinkedList = h.s(localbz.muA, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbz);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.XSS.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbz.muA;
          a(paramLinkedList, localbz);
          paramj.r(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<elo> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        elo localelo = (elo)localIterator.next();
        if (Util.isNullOrNil(localelo.muA))
        {
          Log.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.s(localelo.muA, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localelo);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((Util.isNullOrNil(paramLinkedList.jOy)) || (Util.isNullOrNil(paramLinkedList.jOx))) {
                if (paramLinkedList.jOy != null)
                {
                  bool1 = true;
                  if (paramLinkedList.jOx == null) {
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
              Log.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localelo.muA, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.XST.contains(localelo.muA)) || (this.XSR.contains(paramLinkedList))) {
                break label426;
              }
              this.XSR.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localelo.muA;
          a(paramLinkedList, localelo);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((Util.isNullOrNil(paramLinkedList.jOy)) || (Util.isNullOrNil(paramLinkedList.jOx))) {
              if (paramLinkedList.jOy != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.jOx == null) {
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
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localelo.muA, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
  
  private static LinkedList<etl> cr(LinkedList<String> paramLinkedList)
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
        localLinkedList.add(w.Sk(str));
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
  
  public final void cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    c.c localc = this.mtC.otC;
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
  
  public final int iIE()
  {
    AppMethodBeat.i(244877);
    int i = ((cte)c.c.b(this.mtC.otC)).aaza;
    AppMethodBeat.o(244877);
    return i;
  }
  
  public final byte[] iIa()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((c.b)this.mtC.getReqObj()).toProtoBuf();
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
    paramString = (cte)c.c.b(this.mtC.otC);
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.aaza), Integer.valueOf(this.appType) });
    params = a.a.gxu().gxs();
    b(params, paramString.aazb);
    a(params, paramString.ILb);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */