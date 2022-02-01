package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n
  implements u
{
  private List<String> EMz;
  public CopyOnWriteArrayList<String> ENb;
  private volatile boolean ENc;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.ENc = false;
    this.ENb = new CopyOnWriteArrayList();
    this.EMz = new ArrayList();
    a.dxT().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  public static String aLO(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.cy(paramString, false);
    if (localObject1 == null)
    {
      AppMethodBeat.o(151757);
      return null;
    }
    if ((((g)localObject1).field_openId != null) && (((g)localObject1).field_openId.length() != 0))
    {
      paramString = ((g)localObject1).field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    localObject1 = new LinkedList();
    ((List)localObject1).add(paramString);
    localObject1 = new ad((List)localObject1);
    Object localObject2 = new b.a();
    ((b.a)localObject2).hNM = new eg();
    ((b.a)localObject2).hNN = new eh();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).hNO = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).aDC();
    Object localObject3 = (eg)((com.tencent.mm.al.b)localObject2).hNK.hNQ;
    byte[] arrayOfByte = ((ad)localObject1).eZD();
    if (arrayOfByte != null) {
      ((eg)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((eg)localObject3).nEf = 1;
    localObject3 = y.e((com.tencent.mm.al.b)localObject2);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((a.a)localObject3).errType), Integer.valueOf(((a.a)localObject3).errCode) });
    if ((((a.a)localObject3).errType != 0) || (((a.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ad)localObject1).ch(z.a(((eh)((a.a)localObject3).hNC).Fwe));
    ((ad)localObject1).onGYNetEnd(0, ((a.a)localObject3).errType, ((a.a)localObject3).errCode, ((a.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
    paramString = h.m(paramString, false, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    AppMethodBeat.o(151757);
    return null;
  }
  
  private void agE()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.ENc)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.ENb.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.ENb.size());
    int j = this.ENb.size();
    if (j > 20) {}
    for (;;)
    {
      this.ENc = true;
      this.EMz.addAll(this.ENb.subList(0, i));
      ab localab = new ab(1, new ad(this.EMz));
      com.tencent.mm.kernel.g.ajB().gAO.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(151755);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(151755);
      return;
    }
    if (!this.ENb.contains(paramString)) {
      this.ENb.add(paramString);
    }
    agE();
    AppMethodBeat.o(151755);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151759);
    if (paramaa.getType() != 1)
    {
      AppMethodBeat.o(151759);
      return;
    }
    this.ENc = false;
    paramString = ((ad)paramaa).ENl;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.ENb.removeAll(this.EMz);
    this.EMz.clear();
    agE();
    AppMethodBeat.o(151759);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(151756);
    if ((paramList == null) || (paramList.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(151756);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bt.isNullOrNil(str)) && (!this.ENb.contains(str))) {
        this.ENb.add(str);
      }
    }
    agE();
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */