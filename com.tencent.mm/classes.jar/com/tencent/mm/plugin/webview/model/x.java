package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public x(List<dfo> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dex();
    ((c.a)localObject).otF = new dey();
    ((c.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((c.a)localObject).funcId = 1803;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dex)c.b.b(this.rr.otB);
    dfn localdfn = new dfn();
    localdfn.mut = d.Yxb;
    localdfn.muu = d.Yxa;
    localdfn.muv = d.Yxd;
    localdfn.muw = d.Yxe;
    localdfn.mux = LocaleUtil.getApplicationLanguage();
    localdfn.aaLm = ((int)(System.currentTimeMillis() / 1000L));
    ((dex)localObject).YEV = localdfn;
    ((dex)localObject).YEW.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(78911);
    this.callback = paramh;
    Log.d("MicroMsg.NetSceneJsLog", "doScene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78911);
    return i;
  }
  
  public final int getType()
  {
    return 1803;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78910);
    Log.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dey)c.c.b(((c)params).otC);
      Log.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!Util.isNullOrNil(params.aaKT)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      Log.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.iva();
      h.mh(params.aaKT);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = params.aaKT.iterator();
      while (localIterator.hasNext())
      {
        dco localdco = (dco)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localdco.ZsX), Integer.valueOf(localdco.aaIw) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */