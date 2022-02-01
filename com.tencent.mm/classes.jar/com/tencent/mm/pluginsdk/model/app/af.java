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
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.ekl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends aa
{
  LinkedList<g> FfJ;
  private LinkedList<g> FfK;
  private LinkedList<String> FfL;
  private int appType;
  
  public af(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151821);
    ae.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ae.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.appType = 3;
    localObject = new b.a();
    ((b.a)localObject).hQF = new bjq();
    ((b.a)localObject).hQG = new bjr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).funcId = 409;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bjq)this.gux.hQD.hQJ;
    ((bjq)localObject).uqD = 3;
    ((bjq)localObject).utT = 0;
    ((bjq)localObject).utU = 20;
    ((bjq)localObject).usS = paramString;
    paramString = bl(paramLinkedList);
    ((bjq)localObject).GXe = paramString.size();
    ((bjq)localObject).utD = paramString;
    this.FfJ = new LinkedList();
    this.FfK = new LinkedList();
    this.FfL = new LinkedList();
    this.FfL.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, bl parambl)
  {
    AppMethodBeat.i(151829);
    paramg.sU(parambl.FLP);
    paramg.sX(parambl.urv);
    paramg.sV(parambl.FLR);
    paramg.field_appName = parambl.uuo;
    paramg.field_appIconUrl = parambl.FLQ;
    paramg.sY(parambl.FLT);
    paramg.tg(parambl.FLV);
    a(paramg, parambl.FLU);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, crf paramcrf)
  {
    AppMethodBeat.i(151826);
    paramg.sU(paramcrf.FLP);
    paramg.field_appIconUrl = paramcrf.FLQ;
    paramg.sT(paramcrf.HCs);
    paramg.field_appName = paramcrf.uuo;
    paramg.sV(paramcrf.FLR);
    paramg.field_appType = paramcrf.FYh;
    paramg.sX(paramcrf.urv);
    paramg.field_packageName = paramcrf.FLS;
    paramg.sY(paramcrf.FLT);
    if (!bu.isNullOrNil(paramcrf.FLT))
    {
      ae.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramcrf.FLT, Integer.valueOf(paramcrf.HCC) });
      paramg.jX(paramcrf.HCC);
    }
    paramg.sZ(paramcrf.HCz);
    paramg.ta(paramcrf.HCA);
    a(paramg, paramcrf.FLU);
    r(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, ekl paramekl)
  {
    AppMethodBeat.i(151828);
    ae.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (paramekl != null)
    {
      paramg.jX(paramekl.Inx);
      paramg.td(paramekl.ucL);
      paramg.te(paramekl.uvR);
      paramg.tb(paramekl.Iny);
      paramg.tc(paramekl.uvT);
      paramg.tf(paramekl.uvU);
      paramg.jY(paramekl.uvV);
      ae.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramekl.Inx), paramekl.ucL, paramekl.uvR, paramekl.Iny, paramekl.uvT, paramekl.uvU, Integer.valueOf(paramekl.uvV) });
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
        paramLinkedList = h.m(localbl.gvv, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbl);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.FfK.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbl.gvv;
          a(paramLinkedList, localbl);
          paramj.q(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<crf> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        crf localcrf = (crf)localIterator.next();
        if (bu.isNullOrNil(localcrf.gvv))
        {
          ae.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.m(localcrf.gvv, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localcrf);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bu.isNullOrNil(paramLinkedList.eJk)) || (bu.isNullOrNil(paramLinkedList.eJj))) {
                if (paramLinkedList.eJk != null)
                {
                  bool1 = true;
                  if (paramLinkedList.eJj == null) {
                    break label262;
                  }
                  bool2 = true;
                  label148:
                  ae.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = paramj.a(paramLinkedList, new String[0]))
            {
              ae.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcrf.gvv, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.FfL.contains(localcrf.gvv)) || (this.FfJ.contains(paramLinkedList))) {
                break label426;
              }
              this.FfJ.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localcrf.gvv;
          a(paramLinkedList, localcrf);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bu.isNullOrNil(paramLinkedList.eJk)) || (bu.isNullOrNil(paramLinkedList.eJj))) {
              if (paramLinkedList.eJk != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.eJj == null) {
                  break label433;
                }
                bool2 = true;
                label357:
                ae.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localcrf.gvv, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
  
  private static LinkedList<cxn> bl(LinkedList<String> paramLinkedList)
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
      if (!bu.isNullOrNil(str)) {
        localLinkedList.add(z.Jw(str));
      }
    }
    AppMethodBeat.o(151825);
    return localLinkedList;
  }
  
  private static void r(g paramg)
  {
    AppMethodBeat.i(151827);
    if ((!bu.isNullOrNil(paramg.field_appType)) && ((paramg.field_appType.startsWith("1")) || (paramg.field_appType.startsWith("6"))))
    {
      if (!paramg.field_appType.endsWith(",")) {
        paramg.field_appType += ",";
      }
      paramg.field_appType = ("," + paramg.field_appType);
    }
    AppMethodBeat.o(151827);
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    b.c localc = this.gux.hQE;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151831);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151831);
    }
  }
  
  public final int fdQ()
  {
    return ((bjr)this.gux.hQE.hQJ).GXf;
  }
  
  public final byte[] fdr()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((b.b)this.gux.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151830);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      AppMethodBeat.o(151830);
    }
    return null;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151822);
    ae.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151822);
      return;
    }
    paramString = (bjr)this.gux.hQE.hQJ;
    if (paramString == null)
    {
      ae.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    ae.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.GXf), Integer.valueOf(this.appType) });
    paramq = a.a.dBn().dBl();
    b(paramq, paramString.GXg);
    a(paramq, paramString.uuD);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */