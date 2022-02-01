package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends q
  implements m
{
  public i callback;
  public List<cfy> nZr;
  private com.tencent.mm.ak.d rr;
  
  public h(List<cfy> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new d.a();
    this.nZr = paramList;
    ((d.a)localObject).iLN = new ch();
    ((d.a)localObject).iLO = new ci();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((d.a)localObject).funcId = 1802;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ch)this.rr.iLK.iLR;
    cfx localcfx = new cfx();
    localcfx.hid = com.tencent.mm.protocal.d.KyJ;
    localcfx.hie = com.tencent.mm.protocal.d.KyI;
    localcfx.hif = com.tencent.mm.protocal.d.KyL;
    localcfx.hig = com.tencent.mm.protocal.d.KyM;
    localcfx.hih = LocaleUtil.getApplicationLanguage();
    localcfx.LOF = ((int)(System.currentTimeMillis() / 1000L));
    ((ch)localObject).KGA = localcfx;
    while (i < paramList.size())
    {
      ((ch)localObject).KGB.add(paramList.get(i));
      i += 1;
    }
    Log.i("MicroMsg.NetSceneAdLog", "report count: " + ((ch)localObject).KGB.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(94983);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94983);
    return i;
  }
  
  public final int getType()
  {
    return 1802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94984);
    Log.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((ci)((com.tencent.mm.ak.d)params).iLL.iLR).KGC;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUS, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.h
 * JD-Core Version:    0.7.0.1
 */