package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag
  extends aa
{
  private LinkedList<g> DiA;
  private LinkedList<String> DiB;
  LinkedList<g> Diz;
  private int appType;
  
  public ag(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151821);
    ac.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ac.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.appType = 3;
    localObject = new b.a();
    ((b.a)localObject).hvt = new beq();
    ((b.a)localObject).hvu = new ber();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).funcId = 409;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (beq)this.fYA.hvr.hvw;
    ((beq)localObject).thC = 3;
    ((beq)localObject).tkr = 0;
    ((beq)localObject).tks = 20;
    ((beq)localObject).tju = paramString;
    paramString = bj(paramLinkedList);
    ((beq)localObject).EUe = paramString.size();
    ((beq)localObject).tkb = paramString;
    this.Diz = new LinkedList();
    this.DiA = new LinkedList();
    this.DiB = new LinkedList();
    this.DiB.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, bl parambl)
  {
    AppMethodBeat.i(151829);
    paramg.pP(parambl.DOk);
    paramg.pS(parambl.tii);
    paramg.pQ(parambl.DOm);
    paramg.field_appName = parambl.tkL;
    paramg.field_appIconUrl = parambl.DOl;
    paramg.pT(parambl.DOo);
    paramg.qb(parambl.DOq);
    a(paramg, parambl.DOp);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, cll paramcll)
  {
    AppMethodBeat.i(151826);
    paramg.pP(paramcll.DOk);
    paramg.field_appIconUrl = paramcll.DOl;
    paramg.pO(paramcll.FyN);
    paramg.field_appName = paramcll.tkL;
    paramg.pQ(paramcll.DOm);
    paramg.field_appType = paramcll.Eac;
    paramg.pS(paramcll.tii);
    paramg.field_packageName = paramcll.DOn;
    paramg.pT(paramcll.DOo);
    if (!bs.isNullOrNil(paramcll.DOo))
    {
      ac.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramcll.DOo, Integer.valueOf(paramcll.FyX) });
      paramg.jx(paramcll.FyX);
    }
    paramg.pU(paramcll.FyU);
    paramg.pV(paramcll.FyV);
    a(paramg, paramcll.DOp);
    r(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, eco parameco)
  {
    AppMethodBeat.i(151828);
    ac.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (parameco != null)
    {
      paramg.jx(parameco.Gic);
      paramg.pY(parameco.sVp);
      paramg.pZ(parameco.tlV);
      paramg.pW(parameco.Gid);
      paramg.pX(parameco.tlX);
      paramg.qa(parameco.tlY);
      paramg.jy(parameco.tlZ);
      ac.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(parameco.Gic), parameco.sVp, parameco.tlV, parameco.Gid, parameco.tlX, parameco.tlY, Integer.valueOf(parameco.tlZ) });
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
        paramLinkedList = h.k(localbl.fZx, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbl);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.DiA.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbl.fZx;
          a(paramLinkedList, localbl);
          paramj.q(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<cll> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cll localcll = (cll)localIterator.next();
        if (bs.isNullOrNil(localcll.fZx))
        {
          ac.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.k(localcll.fZx, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localcll);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bs.isNullOrNil(paramLinkedList.eqs)) || (bs.isNullOrNil(paramLinkedList.eqr))) {
                if (paramLinkedList.eqs != null)
                {
                  bool1 = true;
                  if (paramLinkedList.eqr == null) {
                    break label262;
                  }
                  bool2 = true;
                  label148:
                  ac.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = paramj.a(paramLinkedList, new String[0]))
            {
              ac.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcll.fZx, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.DiB.contains(localcll.fZx)) || (this.Diz.contains(paramLinkedList))) {
                break label426;
              }
              this.Diz.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localcll.fZx;
          a(paramLinkedList, localcll);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bs.isNullOrNil(paramLinkedList.eqs)) || (bs.isNullOrNil(paramLinkedList.eqr))) {
              if (paramLinkedList.eqs != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.eqr == null) {
                  break label433;
                }
                bool2 = true;
                label357:
                ac.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcll.fZx, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
  
  private static LinkedList<crm> bj(LinkedList<String> paramLinkedList)
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
      if (!bs.isNullOrNil(str)) {
        localLinkedList.add(z.FI(str));
      }
    }
    AppMethodBeat.o(151825);
    return localLinkedList;
  }
  
  private static void r(g paramg)
  {
    AppMethodBeat.i(151827);
    if ((!bs.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6"))))
    {
      if (!paramg.field_appType.endsWith(",")) {
        paramg.field_appType += ",";
      }
      paramg.field_appType = ("," + paramg.field_appType);
    }
    AppMethodBeat.o(151827);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    b.c localc = this.fYA.hvs;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151831);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151831);
    }
  }
  
  public final byte[] eKJ()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fYA.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151830);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      AppMethodBeat.o(151830);
    }
    return null;
  }
  
  public final int eLi()
  {
    return ((ber)this.fYA.hvs.hvw).EUf;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151822);
    ac.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151822);
      return;
    }
    paramString = (ber)this.fYA.hvs.hvw;
    if (paramString == null)
    {
      ac.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    ac.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.EUf), Integer.valueOf(this.appType) });
    paramq = a.a.dnF().dnD();
    b(paramq, paramString.EUg);
    a(paramq, paramString.tkW);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */