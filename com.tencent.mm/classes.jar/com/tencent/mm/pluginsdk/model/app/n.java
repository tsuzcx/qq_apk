package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.er;
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
  public CopyOnWriteArrayList<String> QWI;
  private volatile boolean QWJ;
  private List<String> QWa;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.QWJ = false;
    this.QWI = new CopyOnWriteArrayList();
    this.QWa = new ArrayList();
    a.fmC().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  private void aEB()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.QWJ)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.QWI.size() <= 0)
    {
      Log.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    Log.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.QWI.size());
    int j = this.QWI.size();
    if (j > 20) {}
    for (;;)
    {
      this.QWJ = true;
      this.QWa.addAll(this.QWI.subList(0, i));
      ab localab = new ab(1, new ad(this.QWa));
      com.tencent.mm.kernel.h.aHF().kcd.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public static String bqg(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.dl(paramString, false);
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
    ((d.a)localObject2).lBU = new eq();
    ((d.a)localObject2).lBV = new er();
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((d.a)localObject2).funcId = 452;
    ((d.a)localObject2).lBW = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject2 = ((d.a)localObject2).bgN();
    Object localObject3 = (eq)d.b.b(((d)localObject2).lBR);
    byte[] arrayOfByte = ((ad)localObject1).hha();
    if (arrayOfByte != null) {
      ((eq)localObject3).RJA = new eae().dc(arrayOfByte);
    }
    ((eq)localObject3).rWu = 1;
    localObject3 = com.tencent.mm.an.ab.e((d)localObject2);
    Log.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
    if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ad)localObject1).cS(z.a(((er)((c.a)localObject3).lBJ).RJB));
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
    this.QWJ = false;
    paramString = ((ad)paramaa).QWS;
    Log.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.QWI.removeAll(this.QWa);
    this.QWa.clear();
    aEB();
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
    if (!this.QWI.contains(paramString)) {
      this.QWI.add(paramString);
    }
    aEB();
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
      if ((!Util.isNullOrNil(str)) && (!this.QWI.contains(str))) {
        this.QWI.add(str);
      }
    }
    aEB();
    AppMethodBeat.o(151756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */