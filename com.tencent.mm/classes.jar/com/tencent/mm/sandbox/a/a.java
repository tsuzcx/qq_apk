package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.plugin.y.b;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.eaf;
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
  private com.tencent.mm.an.i callback;
  public final d rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ced();
    ((d.a)localObject).lBV = new cee();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((d.a)localObject).funcId = 113;
    ((d.a)localObject).lBW = 35;
    ((d.a)localObject).respCmdId = 1000000035;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ced)d.b.b(this.rr.lBR);
    ((ced)localObject).TlJ = paramInt;
    ((ced)localObject).RML = ChannelUtil.channelId;
    if ((10012 == ac.mFM) && (ac.mFN > 0)) {
      ((ced)localObject).RML = ac.mFN;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((ced)localObject).TlJ), Integer.valueOf(((ced)localObject).RML), Integer.valueOf(ChannelUtil.channelId), Util.getStack() });
      AppMethodBeat.o(32578);
      return;
      h.IzE.idkeyStat(405L, 3L, 1L, true);
      continue;
      h.IzE.idkeyStat(405L, 4L, 1L, true);
      continue;
      h.IzE.idkeyStat(405L, 5L, 1L, true);
      continue;
      h.IzE.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(32579);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(32579);
    return i;
  }
  
  public final int eUU()
  {
    AppMethodBeat.i(282207);
    int i = ((cee)d.c.b(this.rr.lBS)).TlK;
    AppMethodBeat.o(282207);
    return i;
  }
  
  public final String[] eUV()
  {
    AppMethodBeat.i(32581);
    cee localcee = (cee)d.c.b(this.rr.lBS);
    String[] arrayOfString = new String[localcee.TlP.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((eaf)localcee.TlP.get(i)).Ufy;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final cee eUW()
  {
    int i = 1;
    AppMethodBeat.i(282208);
    cee localcee;
    if (SubCoreSandBox.IAz)
    {
      localcee = (cee)d.c.b(this.rr.lBS);
      localcee.TlR = 1;
      localcee.TlS = ("http://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index");
      if (!SubCoreSandBox.IAA) {
        break label94;
      }
    }
    for (;;)
    {
      localcee.TlT = i;
      localcee = (cee)d.c.b(this.rr.lBS);
      AppMethodBeat.o(282208);
      return localcee;
      label94:
      i = 0;
    }
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final int hrQ()
  {
    AppMethodBeat.i(282204);
    int i = ((cee)d.c.b(this.rr.lBS)).TlM;
    AppMethodBeat.o(282204);
    return i;
  }
  
  public final String hrR()
  {
    AppMethodBeat.i(282206);
    String str = ((cee)d.c.b(this.rr.lBS)).TlL;
    AppMethodBeat.o(282206);
    return str;
  }
  
  public final String hrS()
  {
    AppMethodBeat.i(32582);
    Object localObject = (cee)d.c.b(this.rr.lBS);
    Log.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((cee)localObject).TlQ, Util.getStack() });
    localObject = ((cee)localObject).TlQ;
    AppMethodBeat.o(32582);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32580);
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.IzE.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = hrS();
      if (paramString == null) {
        break label287;
      }
      params = com.tencent.mm.d.i.gB(paramString);
      if (params == null) {
        break;
      }
      paramInt1 = params.versionCode;
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      bh.aGY().a(new af(MMApplicationContext.getPackageName(), paramInt1), 0);
      h.IzE.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      h.IzE.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        h.IzE.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          h.IzE.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          h.IzE.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          h.IzE.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label287:
    Log.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    h.IzE.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */