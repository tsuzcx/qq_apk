package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.d.i;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class a
  extends n
  implements com.tencent.mm.network.k, com.tencent.mm.plugin.q.b
{
  private f callback;
  public final com.tencent.mm.ak.b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bke();
    ((b.a)localObject).hQG = new bkf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((b.a)localObject).funcId = 113;
    ((b.a)localObject).hQH = 35;
    ((b.a)localObject).respCmdId = 1000000035;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bke)this.rr.hQD.hQJ;
    ((bke)localObject).GXv = paramInt;
    ((bke)localObject).FJf = com.tencent.mm.sdk.platformtools.k.cSM;
    if ((10012 == ac.iRH) && (ac.iRI > 0)) {
      ((bke)localObject).FJf = ac.iRI;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ae.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((bke)localObject).GXv), Integer.valueOf(((bke)localObject).FJf), Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSM), bu.fpN() });
      AppMethodBeat.o(32578);
      return;
      g.yxI.idkeyStat(405L, 3L, 1L, true);
      continue;
      g.yxI.idkeyStat(405L, 4L, 1L, true);
      continue;
      g.yxI.idkeyStat(405L, 5L, 1L, true);
      continue;
      g.yxI.idkeyStat(405L, 6L, 1L, true);
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
  
  public final int drr()
  {
    return ((bkf)this.rr.hQE.hQJ).GXw;
  }
  
  public final String[] drs()
  {
    AppMethodBeat.i(32581);
    bkf localbkf = (bkf)this.rr.hQE.hQJ;
    String[] arrayOfString = new String[localbkf.GXB.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((cxn)localbkf.GXB.get(i)).HId;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final bkf drt()
  {
    int i = 1;
    bkf localbkf;
    if (SubCoreSandBox.yyz)
    {
      localbkf = (bkf)this.rr.hQE.hQJ;
      localbkf.GXD = 1;
      localbkf.GXE = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
      if (!SubCoreSandBox.yyA) {
        break label58;
      }
    }
    for (;;)
    {
      localbkf.GXF = i;
      return (bkf)this.rr.hQE.hQJ;
      label58:
      i = 0;
    }
  }
  
  public final int fmf()
  {
    return ((bkf)this.rr.hQE.hQJ).GXy;
  }
  
  public final String fmg()
  {
    return ((bkf)this.rr.hQE.hQJ).GXx;
  }
  
  public final String fmh()
  {
    AppMethodBeat.i(32582);
    Object localObject = (bkf)this.rr.hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((bkf)localObject).GXC, bu.fpN() });
    localObject = ((bkf)localObject).GXC;
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
    ae.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      g.yxI.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = fmh();
      if (paramString == null) {
        break label285;
      }
      paramq = i.fd(paramString);
      if (paramq == null) {
        break;
      }
      paramInt1 = paramq.versionCode;
      ae.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      bc.ajj().a(new af(ak.getPackageName(), paramInt1), 0);
      g.yxI.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      g.yxI.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        g.yxI.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          g.yxI.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          g.yxI.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          g.yxI.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    ae.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label285:
    ae.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    g.yxI.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */