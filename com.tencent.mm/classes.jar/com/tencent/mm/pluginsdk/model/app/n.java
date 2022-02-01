package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n
  implements u
{
  private List<String> BPA;
  public CopyOnWriteArrayList<String> BPZ;
  private volatile boolean BQa;
  
  public n()
  {
    AppMethodBeat.i(151754);
    this.BQa = false;
    this.BPZ = new CopyOnWriteArrayList();
    this.BPA = new ArrayList();
    a.cZT().a(1, this);
    AppMethodBeat.o(151754);
  }
  
  public static String aAW(String paramString)
  {
    AppMethodBeat.i(151757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(151757);
      return null;
    }
    Object localObject1 = h.cn(paramString, false);
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
    ((b.a)localObject2).gUU = new ea();
    ((b.a)localObject2).gUV = new eb();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).atI();
    Object localObject3 = (ea)((com.tencent.mm.al.b)localObject2).gUS.gUX;
    byte[] arrayOfByte = ((ae)localObject1).evp();
    if (arrayOfByte != null) {
      ((ea)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((ea)localObject3).mBH = 1;
    localObject3 = y.e((com.tencent.mm.al.b)localObject2);
    ad.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
    if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(151757);
      return null;
    }
    ((ae)localObject1).cb(z.a(((eb)((c.a)localObject3).gUK).Cyq));
    ((ae)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
    paramString = h.j(paramString, false, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(151757);
      return paramString;
    }
    AppMethodBeat.o(151757);
    return null;
  }
  
  private void acS()
  {
    int i = 20;
    AppMethodBeat.i(151758);
    if (this.BQa)
    {
      ad.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(151758);
      return;
    }
    if (this.BPZ.size() <= 0)
    {
      ad.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(151758);
      return;
    }
    ad.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.BPZ.size());
    int j = this.BPZ.size();
    if (j > 20) {}
    for (;;)
    {
      this.BQa = true;
      this.BPA.addAll(this.BPZ.subList(0, i));
      ab localab = new ab(1, new ae(this.BPA));
      com.tencent.mm.kernel.g.afA().gcy.a(localab, 0);
      AppMethodBeat.o(151758);
      return;
      i = j;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151759);
    if (paramaa.getType() != 1)
    {
      AppMethodBeat.o(151759);
      return;
    }
    this.BQa = false;
    paramString = ((ae)paramaa).BQk;
    ad.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.BPZ.removeAll(this.BPA);
    this.BPA.clear();
    acS();
    AppMethodBeat.o(151759);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(151756);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(151756);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bt.isNullOrNil(str)) && (!this.BPZ.contains(str))) {
        this.BPZ.add(str);
      }
    }
    acS();
    AppMethodBeat.o(151756);
  }
  
  public final void xe(String paramString)
  {
    AppMethodBeat.i(151755);
    ad.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(151755);
      return;
    }
    if (!this.BPZ.contains(paramString)) {
      this.BPZ.add(paramString);
    }
    acS();
    AppMethodBeat.o(151755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.n
 * JD-Core Version:    0.7.0.1
 */