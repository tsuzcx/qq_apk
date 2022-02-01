package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.d.i;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import java.util.LinkedList;

public final class a
  extends n
  implements k, com.tencent.mm.plugin.q.b
{
  private f callback;
  public final com.tencent.mm.al.b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bjm();
    ((b.a)localObject).hNN = new bjn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).funcId = 113;
    ((b.a)localObject).hNO = 35;
    ((b.a)localObject).respCmdId = 1000000035;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bjm)this.rr.hNK.hNQ;
    ((bjm)localObject).GDS = paramInt;
    ((bjm)localObject).FqH = j.cSc;
    if ((10012 == ac.iON) && (ac.iOO > 0)) {
      ((bjm)localObject).FqH = ac.iOO;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((bjm)localObject).GDS), Integer.valueOf(((bjm)localObject).FqH), Integer.valueOf(j.cSc), bt.flS() });
      AppMethodBeat.o(32578);
      return;
      g.yhR.idkeyStat(405L, 3L, 1L, true);
      continue;
      g.yhR.idkeyStat(405L, 4L, 1L, true);
      continue;
      g.yhR.idkeyStat(405L, 5L, 1L, true);
      continue;
      g.yhR.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(32579);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(32579);
    return i;
  }
  
  public final int dot()
  {
    return ((bjn)this.rr.hNL.hNQ).GDT;
  }
  
  public final String[] dou()
  {
    AppMethodBeat.i(32581);
    bjn localbjn = (bjn)this.rr.hNL.hNQ;
    String[] arrayOfString = new String[localbjn.GDY.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((cwt)localbjn.GDY.get(i)).HoB;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final bjn dov()
  {
    int i = 1;
    bjn localbjn;
    if (SubCoreSandBox.yiI)
    {
      localbjn = (bjn)this.rr.hNL.hNQ;
      localbjn.GEa = 1;
      localbjn.GEb = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.yiJ) {
        break label58;
      }
    }
    for (;;)
    {
      localbjn.GEc = i;
      return (bjn)this.rr.hNL.hNQ;
      label58:
      i = 0;
    }
  }
  
  public final int fin()
  {
    return ((bjn)this.rr.hNL.hNQ).GDV;
  }
  
  public final String fio()
  {
    return ((bjn)this.rr.hNL.hNQ).GDU;
  }
  
  public final String fip()
  {
    AppMethodBeat.i(32582);
    Object localObject = (bjn)this.rr.hNL.hNQ;
    ad.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((bjn)localObject).GDZ, bt.flS() });
    localObject = ((bjn)localObject).GDZ;
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
      g.yhR.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = fip();
      if (paramString == null) {
        break label285;
      }
      paramq = i.eY(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      ad.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      ba.aiU().a(new ae(aj.getPackageName(), paramInt1), 0);
      g.yhR.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      g.yhR.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        g.yhR.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          g.yhR.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          g.yhR.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          g.yhR.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    ad.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label285:
    ad.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    g.yhR.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */