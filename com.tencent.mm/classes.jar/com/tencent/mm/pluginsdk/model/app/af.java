package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends aa
{
  LinkedList<g> ENm;
  private LinkedList<g> ENn;
  private LinkedList<String> ENo;
  private int appType;
  
  public af(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151821);
    ad.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.appType = 3;
    localObject = new b.a();
    ((b.a)localObject).hNM = new biy();
    ((b.a)localObject).hNN = new biz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).funcId = 409;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (biy)this.grW.hNK.hNQ;
    ((biy)localObject).uft = 3;
    ((biy)localObject).uiv = 0;
    ((biy)localObject).uiw = 20;
    ((biy)localObject).uhu = paramString;
    paramString = bk(paramLinkedList);
    ((biy)localObject).GDB = paramString.size();
    ((biy)localObject).uie = paramString;
    this.ENm = new LinkedList();
    this.ENn = new LinkedList();
    this.ENo = new LinkedList();
    this.ENo.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, bl parambl)
  {
    AppMethodBeat.i(151829);
    paramg.sz(parambl.Ftr);
    paramg.sC(parambl.ufY);
    paramg.sA(parambl.Ftt);
    paramg.field_appName = parambl.uiR;
    paramg.field_appIconUrl = parambl.Fts;
    paramg.sD(parambl.Ftv);
    paramg.sL(parambl.Ftx);
    a(paramg, parambl.Ftw);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, cql paramcql)
  {
    AppMethodBeat.i(151826);
    paramg.sz(paramcql.Ftr);
    paramg.field_appIconUrl = paramcql.Fts;
    paramg.sy(paramcql.HiS);
    paramg.field_appName = paramcql.uiR;
    paramg.sA(paramcql.Ftt);
    paramg.field_appType = paramcql.FFL;
    paramg.sC(paramcql.ufY);
    paramg.field_packageName = paramcql.Ftu;
    paramg.sD(paramcql.Ftv);
    if (!bt.isNullOrNil(paramcql.Ftv))
    {
      ad.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramcql.Ftv, Integer.valueOf(paramcql.Hjc) });
      paramg.jV(paramcql.Hjc);
    }
    paramg.sE(paramcql.HiZ);
    paramg.sF(paramcql.Hja);
    a(paramg, paramcql.Ftw);
    r(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, eiu parameiu)
  {
    AppMethodBeat.i(151828);
    ad.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (parameiu != null)
    {
      paramg.jV(parameiu.HTq);
      paramg.sI(parameiu.tRU);
      paramg.sJ(parameiu.uku);
      paramg.sG(parameiu.HTr);
      paramg.sH(parameiu.ukw);
      paramg.sK(parameiu.ukx);
      paramg.jW(parameiu.uky);
      ad.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(parameiu.HTq), parameiu.tRU, parameiu.uku, parameiu.HTr, parameiu.ukw, parameiu.ukx, Integer.valueOf(parameiu.uky) });
    }
    AppMethodBeat.o(151828);
  }
  
  private void a(j paramj, LinkedList<bl> paramLinkedList)
  {
    AppMethodBeat.i(151823);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        bl localbl = (bl)localIterator.next();
        paramLinkedList = h.m(localbl.gsT, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbl);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.ENn.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbl.gsT;
          a(paramLinkedList, localbl);
          paramj.q(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<cql> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cql localcql = (cql)localIterator.next();
        if (bt.isNullOrNil(localcql.gsT))
        {
          ad.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.m(localcql.gsT, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localcql);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bt.isNullOrNil(paramLinkedList.eHB)) || (bt.isNullOrNil(paramLinkedList.eHA))) {
                if (paramLinkedList.eHB != null)
                {
                  bool1 = true;
                  if (paramLinkedList.eHA == null) {
                    break label262;
                  }
                  bool2 = true;
                  label148:
                  ad.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = paramj.a(paramLinkedList, new String[0]))
            {
              ad.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcql.gsT, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.ENo.contains(localcql.gsT)) || (this.ENm.contains(paramLinkedList))) {
                break label426;
              }
              this.ENm.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localcql.gsT;
          a(paramLinkedList, localcql);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bt.isNullOrNil(paramLinkedList.eHB)) || (bt.isNullOrNil(paramLinkedList.eHA))) {
              if (paramLinkedList.eHB != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.eHA == null) {
                  break label433;
                }
                bool2 = true;
                label357:
                ad.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcql.gsT, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            break label215;
            label426:
            break;
            bool1 = false;
            break label347;
            label433:
            bool2 = false;
            break label357;
            bool2 = paramj.q(paramLinkedList);
            bool1 = bool4;
          }
        }
      }
    }
    AppMethodBeat.o(151824);
  }
  
  private static LinkedList<cwt> bk(LinkedList<String> paramLinkedList)
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
      if (!bt.isNullOrNil(str)) {
        localLinkedList.add(z.IX(str));
      }
    }
    AppMethodBeat.o(151825);
    return localLinkedList;
  }
  
  private static void r(g paramg)
  {
    AppMethodBeat.i(151827);
    if ((!bt.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6"))))
    {
      if (!paramg.field_appType.endsWith(",")) {
        paramg.field_appType += ",";
      }
      paramg.field_appType = ("," + paramg.field_appType);
    }
    AppMethodBeat.o(151827);
  }
  
  public final void ch(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    b.c localc = this.grW.hNL;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151831);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151831);
    }
  }
  
  public final byte[] eZD()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((b.b)this.grW.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151830);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      AppMethodBeat.o(151830);
    }
    return null;
  }
  
  public final int fac()
  {
    return ((biz)this.grW.hNL.hNQ).GDC;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151822);
    ad.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151822);
      return;
    }
    paramString = (biz)this.grW.hNL.hNQ;
    if (paramString == null)
    {
      ad.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    ad.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.GDC), Integer.valueOf(this.appType) });
    paramq = a.a.dxX().dxV();
    b(paramq, paramString.GDD);
    a(paramq, paramString.ujf);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */