package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.c.y;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.bvw;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ffi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends aa
{
  LinkedList<g> JWA;
  private LinkedList<g> JWB;
  private LinkedList<String> JWC;
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
    ((d.a)localObject).iLN = new bvv();
    ((d.a)localObject).iLO = new bvw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((d.a)localObject).funcId = 409;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bvv)this.hhm.iLK.iLR;
    ((bvv)localObject).xIV = 3;
    ((bvv)localObject).xLV = 0;
    ((bvv)localObject).xLW = 20;
    ((bvv)localObject).xLl = paramString;
    paramString = bG(paramLinkedList);
    ((bvv)localObject).MbN = paramString.size();
    ((bvv)localObject).xLF = paramString;
    this.JWA = new LinkedList();
    this.JWB = new LinkedList();
    this.JWC = new LinkedList();
    this.JWC.addAll(paramLinkedList);
    AppMethodBeat.o(151821);
  }
  
  private static void a(g paramg, br parambr)
  {
    AppMethodBeat.i(151829);
    paramg.Bl(parambr.KFr);
    paramg.Bo(parambr.xJM);
    paramg.Bm(parambr.KFt);
    paramg.field_appName = parambr.xMq;
    paramg.field_appIconUrl = parambr.KFs;
    paramg.Bp(parambr.KFv);
    paramg.Bx(parambr.KFx);
    a(paramg, parambr.KFw);
    AppMethodBeat.o(151829);
  }
  
  private static void a(g paramg, dje paramdje)
  {
    AppMethodBeat.i(151826);
    paramg.Bl(paramdje.KFr);
    paramg.field_appIconUrl = paramdje.KFs;
    paramg.Bk(paramdje.MNg);
    paramg.field_appName = paramdje.xMq;
    paramg.Bm(paramdje.KFt);
    paramg.field_appType = paramdje.KRY;
    paramg.Bo(paramdje.xJM);
    paramg.field_packageName = paramdje.KFu;
    paramg.Bp(paramdje.KFv);
    if (!Util.isNullOrNil(paramdje.KFv))
    {
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { paramdje.KFv, Integer.valueOf(paramdje.MNq) });
      paramg.mZ(paramdje.MNq);
    }
    paramg.Bq(paramdje.MNn);
    paramg.Br(paramdje.MNo);
    a(paramg, paramdje.KFw);
    s(paramg);
    AppMethodBeat.o(151826);
  }
  
  private static void a(g paramg, ffi paramffi)
  {
    AppMethodBeat.i(151828);
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramg.field_appId });
    if (paramffi != null)
    {
      paramg.mZ(paramffi.NAD);
      paramg.Bu(paramffi.xuc);
      paramg.Bv(paramffi.xNS);
      paramg.Bs(paramffi.NAE);
      paramg.Bt(paramffi.xNU);
      paramg.Bw(paramffi.xNV);
      paramg.na(paramffi.xNW);
      Log.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramffi.NAD), paramffi.xuc, paramffi.xNS, paramffi.NAE, paramffi.xNU, paramffi.xNV, Integer.valueOf(paramffi.xNW) });
    }
    AppMethodBeat.o(151828);
  }
  
  private void a(j paramj, LinkedList<br> paramLinkedList)
  {
    AppMethodBeat.i(151823);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        br localbr = (br)localIterator.next();
        paramLinkedList = h.o(localbr.hik, true, false);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbr);
          paramj.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.JWB.add(paramLinkedList);
          break;
          paramLinkedList = new g();
          paramLinkedList.field_appId = localbr.hik;
          a(paramLinkedList, localbr);
          paramj.r(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(151823);
  }
  
  private void b(j paramj, LinkedList<dje> paramLinkedList)
  {
    AppMethodBeat.i(151824);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dje localdje = (dje)localIterator.next();
        if (Util.isNullOrNil(localdje.hik))
        {
          Log.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = h.o(localdje.hik, true, false);
          label138:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localdje);
            if (this.appType == 3)
            {
              paramLinkedList.field_status = 5;
              if ((Util.isNullOrNil(paramLinkedList.fmM)) || (Util.isNullOrNil(paramLinkedList.fmL))) {
                if (paramLinkedList.fmM != null)
                {
                  bool1 = true;
                  if (paramLinkedList.fmL == null) {
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
              Log.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localdje.hik, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label215:
              if ((!bool1) || (this.JWC.contains(localdje.hik)) || (this.JWA.contains(paramLinkedList))) {
                break label426;
              }
              this.JWA.add(paramLinkedList);
              break;
              bool1 = false;
              break label138;
              label262:
              bool2 = false;
              break label148;
            }
          }
          paramLinkedList = new g();
          paramLinkedList.field_appId = localdje.hik;
          a(paramLinkedList, localdje);
          if (this.appType == 3)
          {
            paramLinkedList.field_status = 5;
            if ((Util.isNullOrNil(paramLinkedList.fmM)) || (Util.isNullOrNil(paramLinkedList.fmL))) {
              if (paramLinkedList.fmM != null)
              {
                bool1 = true;
                label347:
                if (paramLinkedList.fmL == null) {
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
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localdje.hik, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
  
  private static LinkedList<dqi> bG(LinkedList<String> paramLinkedList)
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
        localLinkedList.add(z.Su(str));
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
  
  public final void cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151831);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(151831);
      return;
    }
    d.c localc = this.hhm.iLL;
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
  
  public final byte[] gmB()
  {
    AppMethodBeat.i(151830);
    try
    {
      byte[] arrayOfByte = ((d.b)this.hhm.getReqObj()).toProtoBuf();
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
  
  public final int gnb()
  {
    return ((bvw)this.hhm.iLL.iLR).MbO;
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
    paramString = (bvw)this.hhm.iLL.iLR;
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(151822);
      return;
    }
    Log.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.MbO), Integer.valueOf(this.appType) });
    params = a.a.eAZ().eAX();
    b(params, paramString.MbP);
    a(params, paramString.xME);
    AppMethodBeat.o(151822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */