package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class m
  implements t
{
  private List<String> vKU;
  public Vector<String> vLr;
  private volatile boolean vLs;
  
  public m()
  {
    AppMethodBeat.i(79329);
    this.vLs = false;
    this.vLr = new Vector();
    this.vKU = new ArrayList();
    a.caf().a(1, this);
    AppMethodBeat.o(79329);
  }
  
  private void Ps()
  {
    int i = 20;
    AppMethodBeat.i(79333);
    if (this.vLs)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      AppMethodBeat.o(79333);
      return;
    }
    if (this.vLr.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      AppMethodBeat.o(79333);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.vLr.size());
    int j = this.vLr.size();
    if (j > 20) {}
    for (;;)
    {
      this.vLs = true;
      this.vKU.addAll(this.vLr.subList(0, i));
      y localy = new y(1, new ab(this.vKU));
      com.tencent.mm.kernel.g.RK().eHt.a(localy, 0);
      AppMethodBeat.o(79333);
      return;
      i = j;
    }
  }
  
  public static String alw(String paramString)
  {
    AppMethodBeat.i(79332);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
      AppMethodBeat.o(79332);
      return null;
    }
    Object localObject1 = g.bZ(paramString, false);
    if (localObject1 == null)
    {
      AppMethodBeat.o(79332);
      return null;
    }
    if ((((f)localObject1).field_openId != null) && (((f)localObject1).field_openId.length() != 0))
    {
      paramString = ((f)localObject1).field_openId;
      AppMethodBeat.o(79332);
      return paramString;
    }
    localObject1 = new LinkedList();
    ((List)localObject1).add(paramString);
    localObject1 = new ab((List)localObject1);
    Object localObject2 = new b.a();
    ((b.a)localObject2).fsX = new dn();
    ((b.a)localObject2).fsY = new do();
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject2).funcId = 452;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).ado();
    Object localObject3 = (dn)((com.tencent.mm.ai.b)localObject2).fsV.fta;
    byte[] arrayOfByte = ((ab)localObject1).dli();
    if (arrayOfByte != null) {
      ((dn)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((dn)localObject3).jKs = 1;
    localObject3 = com.tencent.mm.ai.x.c((com.tencent.mm.ai.b)localObject2);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((a.a)localObject3).errType), Integer.valueOf(((a.a)localObject3).errCode) });
    if ((((a.a)localObject3).errType != 0) || (((a.a)localObject3).errCode != 0))
    {
      AppMethodBeat.o(79332);
      return null;
    }
    ((ab)localObject1).bJ(aa.a(((do)((a.a)localObject3).fsN).wpD));
    ((ab)localObject1).onGYNetEnd(0, ((a.a)localObject3).errType, ((a.a)localObject3).errCode, ((a.a)localObject3).errMsg, (q)localObject2, new byte[0]);
    paramString = g.ca(paramString, false);
    if (paramString != null)
    {
      paramString = paramString.field_openId;
      AppMethodBeat.o(79332);
      return paramString;
    }
    AppMethodBeat.o(79332);
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    AppMethodBeat.i(79334);
    if (paramx.getType() != 1)
    {
      AppMethodBeat.o(79334);
      return;
    }
    this.vLs = false;
    paramString = ((ab)paramx).vLA;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.vLr.removeAll(this.vKU);
    this.vKU.clear();
    Ps();
    AppMethodBeat.o(79334);
  }
  
  public final void addAll(List<String> paramList)
  {
    AppMethodBeat.i(79331);
    if ((paramList == null) || (paramList.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppSettingService", "addAll list is null");
      AppMethodBeat.o(79331);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bo.isNullOrNil(str)) && (!this.vLr.contains(str))) {
        this.vLr.add(str);
      }
    }
    Ps();
    AppMethodBeat.o(79331);
  }
  
  public final void xB(String paramString)
  {
    AppMethodBeat.i(79330);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(paramString)));
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppSettingService", "add appId is null");
      AppMethodBeat.o(79330);
      return;
    }
    if (!this.vLr.contains(paramString)) {
      this.vLr.add(paramString);
    }
    Ps();
    AppMethodBeat.o(79330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */