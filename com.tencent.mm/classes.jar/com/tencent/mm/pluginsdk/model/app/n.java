package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n
  implements u
{
  private List<String> DhO;
  public CopyOnWriteArrayList<String> Din;
  private volatile boolean Dio;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.Dio = false;
    this.Din = new CopyOnWriteArrayList();
    this.DhO = new ArrayList();
    a.dnB().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  public static String aGo(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.ct(paramString, false);
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
    localObject1 = new ae((List)localObject1);
    Object localObject2 = new b.a();
    ((b.a)localObject2).hvt = new ec();
    ((b.a)localObject2).hvu = new ed();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).aAz();
    Object localObject3 = (ec)((com.tencent.mm.ak.b)localObject2).hvr.hvw;
    byte[] arrayOfByte = ((ae)localObject1).eKJ();
    if (arrayOfByte != null) {
      ((ec)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((ec)localObject3).ndI = 1;
    localObject3 = y.e((com.tencent.mm.ak.b)localObject2);
    ac.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
    if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ae)localObject1).ca(z.a(((ed)((c.a)localObject3).hvj).DQM));
    ((ae)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
    paramString = h.k(paramString, false, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    AppMethodBeat.o(151757);
    return null;
  }
  
  private void adY()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.Dio)
    {
      ac.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.Din.size() <= 0)
    {
      ac.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    ac.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.Din.size());
    int j = this.Din.size();
    if (j > 20) {}
    for (;;)
    {
      this.Dio = true;
      this.DhO.addAll(this.Din.subList(0, i));
      ab localab = new ab(1, new ae(this.DhO));
      com.tencent.mm.kernel.g.agQ().ghe.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public final void Bk(String paramString)
  {
    AppMethodBeat.i(151755);
    ac.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(151755);
      return;
    }
    if (!this.Din.contains(paramString)) {
      this.Din.add(paramString);
    }
    adY();
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
    this.Dio = false;
    paramString = ((ae)paramaa).Diy;
    ac.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.Din.removeAll(this.DhO);
    this.DhO.clear();
    adY();
    AppMethodBeat.o(151759);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(151756);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(151756);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bs.isNullOrNil(str)) && (!this.Din.contains(str))) {
        this.Din.add(str);
      }
    }
    adY();
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */