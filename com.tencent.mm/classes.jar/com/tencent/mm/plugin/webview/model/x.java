package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
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
  private final com.tencent.mm.ak.d rr;
  
  public x(List<cfy> paramList)
  {
    AppMethodBeat.i(78909);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cfg();
    ((d.a)localObject).iLO = new cfh();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/jslog";
    ((d.a)localObject).funcId = 1803;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cfg)this.rr.iLK.iLR;
    cfx localcfx = new cfx();
    localcfx.hid = com.tencent.mm.protocal.d.KyJ;
    localcfx.hie = com.tencent.mm.protocal.d.KyI;
    localcfx.hif = com.tencent.mm.protocal.d.KyL;
    localcfx.hig = com.tencent.mm.protocal.d.KyM;
    localcfx.hih = LocaleUtil.getApplicationLanguage();
    localcfx.LOF = ((int)(System.currentTimeMillis() / 1000L));
    ((cfg)localObject).KGA = localcfx;
    ((cfg)localObject).KGB.addAll(paramList);
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
      params = (cfh)((com.tencent.mm.ak.d)params).iLL.iLR;
      Log.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
      paramArrayOfByte = new StringBuilder("{ ");
      if (!Util.isNullOrNil(params.Mlt)) {
        break label165;
      }
      paramArrayOfByte.append("{  }");
    }
    for (;;)
    {
      paramArrayOfByte.append(" }");
      Log.i("MicroMsg.NetSceneJsLog", paramArrayOfByte.toString());
      h.a.gcu();
      h.ii(params.Mlt);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78910);
      return;
      label165:
      Iterator localIterator = params.Mlt.iterator();
      while (localIterator.hasNext())
      {
        cdi localcdi = (cdi)localIterator.next();
        paramArrayOfByte.append(String.format(" { logId(%d), interval(%d) },", new Object[] { Integer.valueOf(localcdi.Mjf), Integer.valueOf(localcdi.Mjg) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */