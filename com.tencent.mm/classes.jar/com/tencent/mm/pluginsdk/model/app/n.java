package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n
  implements u
{
  private List<String> JVN;
  public CopyOnWriteArrayList<String> JWp;
  private volatile boolean JWq;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.JWq = false;
    this.JWp = new CopyOnWriteArrayList();
    this.JVN = new ArrayList();
    a.eAV().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  private void axe()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.JWq)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.JWp.size() <= 0)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    Log.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.JWp.size());
    int j = this.JWp.size();
    if (j > 20) {}
    for (;;)
    {
      this.JWq = true;
      this.JVN.addAll(this.JWp.subList(0, i));
      ab localab = new ab(1, new ad(this.JVN));
      com.tencent.mm.kernel.g.aAg().hqi.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public static String bdK(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.cX(paramString, false);
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
    Object localObject2 = new d.a();
    ((d.a)localObject2).iLN = new et();
    ((d.a)localObject2).iLO = new eu();
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((d.a)localObject2).funcId = 452;
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject2 = ((d.a)localObject2).aXF();
    Object localObject3 = (et)((d)localObject2).iLK.iLR;
    byte[] arrayOfByte = ((ad)localObject1).gmB();
    if (arrayOfByte != null) {
      ((et)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((et)localObject3).oUv = 1;
    localObject3 = com.tencent.mm.ak.ab.e((d)localObject2);
    Log.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
    if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ad)localObject1).cB(z.a(((eu)((c.a)localObject3).iLC).KIk));
    ((ad)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (s)localObject2, new byte[0]);
    paramString = h.o(paramString, false, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    AppMethodBeat.o(151757);
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151759);
    if (paramaa.getType() != 1)
    {
      AppMethodBeat.o(151759);
      return;
    }
    this.JWq = false;
    paramString = ((ad)paramaa).JWz;
    Log.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.JWp.removeAll(this.JVN);
    this.JVN.clear();
    axe();
    AppMethodBeat.o(151759);
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(151755);
    Log.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(151755);
      return;
    }
    if (!this.JWp.contains(paramString)) {
      this.JWp.add(paramString);
    }
    axe();
    AppMethodBeat.o(151755);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(151756);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(151756);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!Util.isNullOrNil(str)) && (!this.JWp.contains(str))) {
        this.JWp.add(str);
      }
    }
    axe();
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */