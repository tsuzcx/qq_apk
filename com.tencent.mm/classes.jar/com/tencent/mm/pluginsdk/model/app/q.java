package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class q
  implements y
{
  private List<String> XRX;
  public CopyOnWriteArrayList<String> XSF;
  private volatile boolean XSG;
  
  public q()
  {
    AppMethodBeat.i(151754);
    this.XSG = false;
    this.XSF = new CopyOnWriteArrayList();
    this.XRX = new ArrayList();
    a.gxq().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  private void aXF()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.XSG)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.XSF.size() <= 0)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    Log.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.XSF.size());
    int j = this.XSF.size();
    if (j > 20) {}
    for (;;)
    {
      this.XSG = true;
      this.XRX.addAll(this.XSF.subList(0, i));
      af localaf = new af(1, new ah(this.XRX));
      com.tencent.mm.kernel.h.baD().mCm.a(localaf, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public static String bpV(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.dV(paramString, false);
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
    localObject1 = new ah((List)localObject1);
    Object localObject2 = new c.a();
    ((c.a)localObject2).otE = new fk();
    ((c.a)localObject2).otF = new fl();
    ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((c.a)localObject2).funcId = 452;
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    localObject2 = ((c.a)localObject2).bEF();
    Object localObject3 = (fk)c.b.b(((com.tencent.mm.am.c)localObject2).otB);
    byte[] arrayOfByte = ((ah)localObject1).iIa();
    if (arrayOfByte != null) {
      ((fk)localObject3).YGU = new gol().df(arrayOfByte);
    }
    ((fk)localObject3).vhJ = 1;
    localObject3 = aa.a((com.tencent.mm.am.c)localObject2, 20000L);
    Log.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((b.a)localObject3).errType), Integer.valueOf(((b.a)localObject3).errCode) });
    if ((((b.a)localObject3).errType != 0) || (((b.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ah)localObject1).cV(w.a(((fl)((b.a)localObject3).ott).YGV));
    ((ah)localObject1).onGYNetEnd(0, ((b.a)localObject3).errType, ((b.a)localObject3).errCode, ((b.a)localObject3).errMsg, (com.tencent.mm.network.s)localObject2, new byte[0]);
    paramString = h.s(paramString, false, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    AppMethodBeat.o(151757);
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, ae paramae)
  {
    AppMethodBeat.i(151759);
    if (paramae.getType() != 1)
    {
      AppMethodBeat.o(151759);
      return;
    }
    this.XSG = false;
    paramString = ((ah)paramae).XSQ;
    Log.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.XSF.removeAll(this.XRX);
    this.XRX.clear();
    aXF();
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
    if (!this.XSF.contains(paramString)) {
      this.XSF.add(paramString);
    }
    com.tencent.threadpool.h.ahAA.bk(new q..ExternalSyntheticLambda1(this));
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
      if ((!Util.isNullOrNil(str)) && (!this.XSF.contains(str))) {
        this.XSF.add(str);
      }
    }
    com.tencent.threadpool.h.ahAA.bk(new q..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q
 * JD-Core Version:    0.7.0.1
 */