package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedList;

public final class a
  extends q
  implements m, b
{
  private com.tencent.mm.ak.i callback;
  public final d rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bwn();
    ((d.a)localObject).iLO = new bwo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((d.a)localObject).funcId = 113;
    ((d.a)localObject).iLP = 35;
    ((d.a)localObject).respCmdId = 1000000035;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bwn)this.rr.iLK.iLR;
    ((bwn)localObject).Mck = paramInt;
    ((bwn)localObject).KCx = ChannelUtil.channelId;
    if ((10012 == ac.jOC) && (ac.jOD > 0)) {
      ((bwn)localObject).KCx = ac.jOD;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((bwn)localObject).Mck), Integer.valueOf(((bwn)localObject).KCx), Integer.valueOf(ChannelUtil.channelId), Util.getStack() });
      AppMethodBeat.o(32578);
      return;
      h.CyF.idkeyStat(405L, 3L, 1L, true);
      continue;
      h.CyF.idkeyStat(405L, 4L, 1L, true);
      continue;
      h.CyF.idkeyStat(405L, 5L, 1L, true);
      continue;
      h.CyF.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(32579);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(32579);
    return i;
  }
  
  public final int ell()
  {
    return ((bwo)this.rr.iLL.iLR).Mcl;
  }
  
  public final String[] elm()
  {
    AppMethodBeat.i(32581);
    bwo localbwo = (bwo)this.rr.iLL.iLR;
    String[] arrayOfString = new String[localbwo.Mcq.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((dqi)localbwo.Mcq.get(i)).MTo;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final bwo eln()
  {
    int i = 1;
    AppMethodBeat.i(232383);
    bwo localbwo;
    if (SubCoreSandBox.Czx)
    {
      localbwo = (bwo)this.rr.iLL.iLR;
      localbwo.Mcs = 1;
      localbwo.Mct = ("http://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index");
      if (!SubCoreSandBox.Czy) {
        break label93;
      }
    }
    for (;;)
    {
      localbwo.Mcu = i;
      localbwo = (bwo)this.rr.iLL.iLR;
      AppMethodBeat.o(232383);
      return localbwo;
      label93:
      i = 0;
    }
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final int gvS()
  {
    return ((bwo)this.rr.iLL.iLR).Mcn;
  }
  
  public final String gvT()
  {
    return ((bwo)this.rr.iLL.iLR).Mcm;
  }
  
  public final String gvU()
  {
    AppMethodBeat.i(32582);
    Object localObject = (bwo)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((bwo)localObject).Mcr, Util.getStack() });
    localObject = ((bwo)localObject).Mcr;
    AppMethodBeat.o(32582);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32580);
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.CyF.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = gvU();
      if (paramString == null) {
        break label286;
      }
      params = com.tencent.mm.d.i.fR(paramString);
      if (params == null) {
        break;
      }
      paramInt1 = params.versionCode;
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      bg.azz().a(new af(MMApplicationContext.getPackageName(), paramInt1), 0);
      h.CyF.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      h.CyF.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.CyF.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.CyF.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.CyF.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.CyF.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label286:
    Log.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.CyF.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */