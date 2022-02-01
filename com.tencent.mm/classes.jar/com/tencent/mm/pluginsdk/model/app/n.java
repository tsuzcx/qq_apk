package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n
  implements u
{
  private List<String> FeW;
  public CopyOnWriteArrayList<String> Ffy;
  private volatile boolean Ffz;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.Ffz = false;
    this.Ffy = new CopyOnWriteArrayList();
    this.FeW = new ArrayList();
    a.dBj().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  public static String aNk(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.cC(paramString, false);
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
    ((b.a)localObject2).hQF = new eg();
    ((b.a)localObject2).hQG = new eh();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).hQH = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).aDS();
    Object localObject3 = (eg)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
    byte[] arrayOfByte = ((ad)localObject1).fdr();
    if (arrayOfByte != null) {
      ((eg)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((eg)localObject3).nJA = 1;
    localObject3 = y.e((com.tencent.mm.ak.b)localObject2);
    ae.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((a.a)localObject3).errType), Integer.valueOf(((a.a)localObject3).errCode) });
    if ((((a.a)localObject3).errType != 0) || (((a.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ad)localObject1).ck(z.a(((eh)((a.a)localObject3).hQv).FOC));
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
  
  private void agS()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.Ffz)
    {
      ae.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.Ffy.size() <= 0)
    {
      ae.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    ae.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.Ffy.size());
    int j = this.Ffy.size();
    if (j > 20) {}
    for (;;)
    {
      this.Ffz = true;
      this.FeW.addAll(this.Ffy.subList(0, i));
      ab localab = new ab(1, new ad(this.FeW));
      com.tencent.mm.kernel.g.ajQ().gDv.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public final void EL(String paramString)
  {
    AppMethodBeat.i(151755);
    ae.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(151755);
      return;
    }
    if (!this.Ffy.contains(paramString)) {
      this.Ffy.add(paramString);
    }
    agS();
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
    this.Ffz = false;
    paramString = ((ad)paramaa).FfI;
    ae.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.Ffy.removeAll(this.FeW);
    this.FeW.clear();
    agS();
    AppMethodBeat.o(151759);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(151756);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(151756);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bu.isNullOrNil(str)) && (!this.Ffy.contains(str))) {
        this.Ffy.add(str);
      }
    }
    agS();
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */