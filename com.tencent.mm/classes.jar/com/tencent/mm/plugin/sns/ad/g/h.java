package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends p
  implements m
{
  public com.tencent.mm.am.h callback;
  public List<dfo> eXW;
  private c rr;
  
  public h(List<dfo> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new c.a();
    this.eXW = paramList;
    ((c.a)localObject).otE = new cp();
    ((c.a)localObject).otF = new cq();
    ((c.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((c.a)localObject).funcId = 1802;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cp)c.b.b(this.rr.otB);
    dfn localdfn = new dfn();
    localdfn.mut = d.Yxb;
    localdfn.muu = d.Yxa;
    localdfn.muv = d.Yxd;
    localdfn.muw = d.Yxe;
    localdfn.mux = LocaleUtil.getApplicationLanguage();
    localdfn.aaLm = ((int)(System.currentTimeMillis() / 1000L));
    ((cp)localObject).YEV = localdfn;
    int i = 0;
    while (i < paramList.size())
    {
      ((cp)localObject).YEW.add((dfo)paramList.get(i));
      i += 1;
    }
    Log.i("MicroMsg.NetSceneAdLog", "report count: " + ((cp)localObject).YEW.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(94983);
    this.callback = paramh;
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
      paramInt1 = ((cq)c.c.b(((c)params).otC)).cro;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acKl, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.h
 * JD-Core Version:    0.7.0.1
 */