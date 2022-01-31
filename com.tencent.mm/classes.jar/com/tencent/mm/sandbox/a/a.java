package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.c.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import java.util.LinkedList;

public final class a
  extends m
  implements k, com.tencent.mm.plugin.p.b
{
  private f callback;
  public final com.tencent.mm.ai.b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(28779);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aqx();
    ((b.a)localObject).fsY = new aqy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).funcId = 113;
    ((b.a)localObject).reqCmdId = 35;
    ((b.a)localObject).respCmdId = 1000000035;
    this.rr = ((b.a)localObject).ado();
    localObject = (aqx)this.rr.fsV.fta;
    ((aqx)localObject).xgd = paramInt;
    ((aqx)localObject).wkX = g.bWu;
    if ((10012 == com.tencent.mm.platformtools.ae.gkK) && (com.tencent.mm.platformtools.ae.gkL > 0)) {
      ((aqx)localObject).wkX = com.tencent.mm.platformtools.ae.gkL;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((aqx)localObject).xgd), Integer.valueOf(((aqx)localObject).wkX), Integer.valueOf(g.bWu), bo.dtY() });
      AppMethodBeat.o(28779);
      return;
      h.qsU.idkeyStat(405L, 3L, 1L, true);
      continue;
      h.qsU.idkeyStat(405L, 4L, 1L, true);
      continue;
      h.qsU.idkeyStat(405L, 5L, 1L, true);
      continue;
      h.qsU.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int bSp()
  {
    return ((aqy)this.rr.fsW.fta).xge;
  }
  
  public final String[] bSq()
  {
    AppMethodBeat.i(28782);
    aqy localaqy = (aqy)this.rr.fsW.fta;
    String[] arrayOfString = new String[localaqy.xgj.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((bwc)localaqy.xgj.get(i)).xJE;
      i += 1;
    }
    AppMethodBeat.o(28782);
    return arrayOfString;
  }
  
  public final aqy bSr()
  {
    int i = 1;
    aqy localaqy;
    if (SubCoreSandBox.qto)
    {
      localaqy = (aqy)this.rr.fsW.fta;
      localaqy.xgl = 1;
      localaqy.xgm = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.qtp) {
        break label58;
      }
    }
    for (;;)
    {
      localaqy.xgn = i;
      return (aqy)this.rr.fsW.fta;
      label58:
      i = 0;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28780);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28780);
    return i;
  }
  
  public final int drp()
  {
    return ((aqy)this.rr.fsW.fta).xgg;
  }
  
  public final String drq()
  {
    return ((aqy)this.rr.fsW.fta).xgf;
  }
  
  public final String drr()
  {
    AppMethodBeat.i(28783);
    Object localObject = (aqy)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((aqy)localObject).xgk, bo.dtY() });
    localObject = ((aqy)localObject).xgk;
    AppMethodBeat.o(28783);
    return localObject;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28781);
    ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.qsU.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = drr();
      if (paramString == null) {
        break label285;
      }
      paramq = i.dq(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      aw.Rc().a(new com.tencent.mm.modelsimple.ae(ah.getPackageName(), paramInt1), 0);
      h.qsU.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(28781);
      return;
      h.qsU.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.qsU.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.qsU.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.qsU.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.qsU.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    ab.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(28781);
    return;
    label285:
    ab.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.qsU.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(28781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */