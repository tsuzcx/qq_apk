package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
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
  public List<cou> rbc;
  private com.tencent.mm.an.d rr;
  
  public h(List<cou> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new d.a();
    this.rbc = paramList;
    ((d.a)localObject).lBU = new cf();
    ((d.a)localObject).lBV = new cg();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((d.a)localObject).funcId = 1802;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cf)d.b.b(this.rr.lBR);
    cot localcot = new cot();
    localcot.jUb = com.tencent.mm.protocal.d.RAx;
    localcot.jUc = com.tencent.mm.protocal.d.RAw;
    localcot.jUd = com.tencent.mm.protocal.d.RAz;
    localcot.jUe = com.tencent.mm.protocal.d.RAA;
    localcot.jUf = LocaleUtil.getApplicationLanguage();
    localcot.TwF = ((int)(System.currentTimeMillis() / 1000L));
    ((cf)localObject).RHS = localcot;
    while (i < paramList.size())
    {
      ((cf)localObject).RHT.add(paramList.get(i));
      i += 1;
    }
    Log.i("MicroMsg.NetSceneAdLog", "report count: " + ((cf)localObject).RHT.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(g paramg, i parami)
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
      paramInt1 = ((cg)d.c.b(((com.tencent.mm.an.d)params).lBS)).RHU;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViR, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.h
 * JD-Core Version:    0.7.0.1
 */