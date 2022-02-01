package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public x(List<cou> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cod();
    ((d.a)localObject).lBV = new coe();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((d.a)localObject).funcId = 1803;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cod)d.b.b(this.rr.lBR);
    cot localcot = new cot();
    localcot.jUb = com.tencent.mm.protocal.d.RAx;
    localcot.jUc = com.tencent.mm.protocal.d.RAw;
    localcot.jUd = com.tencent.mm.protocal.d.RAz;
    localcot.jUe = com.tencent.mm.protocal.d.RAA;
    localcot.jUf = LocaleUtil.getApplicationLanguage();
    localcot.TwF = ((int)(System.currentTimeMillis() / 1000L));
    ((cod)localObject).RHS = localcot;
    ((cod)localObject).RHT.addAll(paramList);
    AppMethodBeat.o(78909);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78911);
    this.callback = parami;
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
      params = (coe)d.c.b(((com.tencent.mm.an.d)params).lBS);
      Log.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!Util.isNullOrNil(params.Twm)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      Log.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.gVp();
      h.iY(params.Twm);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = params.Twm.iterator();
      while (localIterator.hasNext())
      {
        cmc localcmc = (cmc)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localcmc.Stn), Integer.valueOf(localcmc.TtU) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */