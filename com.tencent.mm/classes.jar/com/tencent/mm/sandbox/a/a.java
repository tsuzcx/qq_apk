package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class a
  extends n
  implements k, com.tencent.mm.plugin.q.b
{
  private g callback;
  public final com.tencent.mm.al.b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bbm();
    ((b.a)localObject).gUV = new bbn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).funcId = 113;
    ((b.a)localObject).reqCmdId = 35;
    ((b.a)localObject).respCmdId = 1000000035;
    this.rr = ((b.a)localObject).atI();
    localObject = (bbm)this.rr.gUS.gUX;
    ((bbm)localObject).DyZ = paramInt;
    ((bbm)localObject).Ctl = com.tencent.mm.sdk.platformtools.i.cJR;
    if ((10012 == ab.hVC) && (ab.hVD > 0)) {
      ((bbm)localObject).Ctl = ab.hVD;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((bbm)localObject).DyZ), Integer.valueOf(((bbm)localObject).Ctl), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cJR), bt.eGN() });
      AppMethodBeat.o(32578);
      return;
      h.vKh.idkeyStat(405L, 3L, 1L, true);
      continue;
      h.vKh.idkeyStat(405L, 4L, 1L, true);
      continue;
      h.vKh.idkeyStat(405L, 5L, 1L, true);
      continue;
      h.vKh.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int cRl()
  {
    return ((bbn)this.rr.gUT.gUX).Dza;
  }
  
  public final String[] cRm()
  {
    AppMethodBeat.i(32581);
    bbn localbbn = (bbn)this.rr.gUT.gUX;
    String[] arrayOfString = new String[localbbn.Dzf.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((cmf)localbbn.Dzf.get(i)).Ehn;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final bbn cRn()
  {
    int i = 1;
    bbn localbbn;
    if (SubCoreSandBox.vLe)
    {
      localbbn = (bbn)this.rr.gUT.gUX;
      localbbn.Dzh = 1;
      localbbn.Dzi = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.vLf) {
        break label58;
      }
    }
    for (;;)
    {
      localbbn.Dzj = i;
      return (bbn)this.rr.gUT.gUX;
      label58:
      i = 0;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(32579);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(32579);
    return i;
  }
  
  public final int eDr()
  {
    return ((bbn)this.rr.gUT.gUX).Dzc;
  }
  
  public final String eDs()
  {
    return ((bbn)this.rr.gUT.gUX).Dzb;
  }
  
  public final String eDt()
  {
    AppMethodBeat.i(32582);
    Object localObject = (bbn)this.rr.gUT.gUX;
    ad.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((bbn)localObject).Dzg, bt.eGN() });
    localObject = ((bbn)localObject).Dzg;
    AppMethodBeat.o(32582);
    return localObject;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32580);
    ad.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.vKh.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = eDt();
      if (paramString == null) {
        break label285;
      }
      paramq = com.tencent.mm.d.i.eo(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      ad.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      az.aeS().a(new ae(aj.getPackageName(), paramInt1), 0);
      h.vKh.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      h.vKh.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.vKh.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.vKh.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.vKh.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.vKh.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    ad.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label285:
    ad.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.vKh.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */