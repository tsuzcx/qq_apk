package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class a
  extends n
  implements k, com.tencent.mm.plugin.q.b
{
  private g callback;
  public final com.tencent.mm.ak.b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bfe();
    ((b.a)localObject).hvu = new bff();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).funcId = 113;
    ((b.a)localObject).reqCmdId = 35;
    ((b.a)localObject).respCmdId = 1000000035;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bfe)this.rr.hvr.hvw;
    ((bfe)localObject).EUv = paramInt;
    ((bfe)localObject).DLC = com.tencent.mm.sdk.platformtools.i.cGY;
    if ((10012 == ab.ivG) && (ab.ivH > 0)) {
      ((bfe)localObject).DLC = ab.ivH;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((bfe)localObject).EUv), Integer.valueOf(((bfe)localObject).DLC), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cGY), bs.eWi() });
      AppMethodBeat.o(32578);
      return;
      h.wUl.idkeyStat(405L, 3L, 1L, true);
      continue;
      h.wUl.idkeyStat(405L, 4L, 1L, true);
      continue;
      h.wUl.idkeyStat(405L, 5L, 1L, true);
      continue;
      h.wUl.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int deV()
  {
    return ((bff)this.rr.hvs.hvw).EUw;
  }
  
  public final String[] deW()
  {
    AppMethodBeat.i(32581);
    bff localbff = (bff)this.rr.hvs.hvw;
    String[] arrayOfString = new String[localbff.EUB.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((crm)localbff.EUB.get(i)).FEm;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final bff deX()
  {
    int i = 1;
    bff localbff;
    if (SubCoreSandBox.wVf)
    {
      localbff = (bff)this.rr.hvs.hvw;
      localbff.EUD = 1;
      localbff.EUE = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.wVg) {
        break label58;
      }
    }
    for (;;)
    {
      localbff.EUF = i;
      return (bff)this.rr.hvs.hvw;
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
  
  public final int eSL()
  {
    return ((bff)this.rr.hvs.hvw).EUy;
  }
  
  public final String eSM()
  {
    return ((bff)this.rr.hvs.hvw).EUx;
  }
  
  public final String eSN()
  {
    AppMethodBeat.i(32582);
    Object localObject = (bff)this.rr.hvs.hvw;
    ac.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((bff)localObject).EUC, bs.eWi() });
    localObject = ((bff)localObject).EUC;
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
    ac.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.wUl.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = eSN();
      if (paramString == null) {
        break label285;
      }
      paramq = com.tencent.mm.d.i.ed(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      ac.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      az.agi().a(new ae(ai.getPackageName(), paramInt1), 0);
      h.wUl.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      h.wUl.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.wUl.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.wUl.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.wUl.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.wUl.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    ac.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label285:
    ac.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.wUl.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */