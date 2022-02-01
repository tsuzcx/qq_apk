package com.tencent.mm.sandbox.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.plugin.y.b;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedList;

public final class a
  extends p
  implements m, b
{
  private com.tencent.mm.am.h callback;
  public final c rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(32578);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cuf();
    ((c.a)localObject).otF = new cug();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getupdateinfo";
    ((c.a)localObject).funcId = 113;
    ((c.a)localObject).otG = 35;
    ((c.a)localObject).respCmdId = 1000000035;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cuf)c.b.b(this.rr.otB);
    ((cuf)localObject).aazF = paramInt;
    ((cuf)localObject).YJZ = ChannelUtil.channelId;
    if ((10012 == z.pCm) && (z.pCn > 0)) {
      ((cuf)localObject).YJZ = z.pCn;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[] { Integer.valueOf(((cuf)localObject).aazF), Integer.valueOf(((cuf)localObject).YJZ), Integer.valueOf(ChannelUtil.channelId), Util.getStack() });
      AppMethodBeat.o(32578);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 3L, 1L, true);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 4L, 1L, true);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 5L, 1L, true);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 6L, 1L, true);
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(32579);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(32579);
    return i;
  }
  
  public final int gdG()
  {
    AppMethodBeat.i(248402);
    int i = ((cug)c.c.b(this.rr.otC)).aazG;
    AppMethodBeat.o(248402);
    return i;
  }
  
  public final String[] gdH()
  {
    AppMethodBeat.i(32581);
    cug localcug = (cug)c.c.b(this.rr.otC);
    String[] arrayOfString = new String[localcug.aazL.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((etl)localcug.aazL.get(i)).abwM;
      i += 1;
    }
    AppMethodBeat.o(32581);
    return arrayOfString;
  }
  
  public final cug gdI()
  {
    int i = 1;
    AppMethodBeat.i(248412);
    cug localcug;
    if (SubCoreSandBox.OGF)
    {
      localcug = (cug)c.c.b(this.rr.otC);
      localcug.aazN = 1;
      localcug.aazO = ("http://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index");
      if (!SubCoreSandBox.OGH) {
        break label94;
      }
    }
    for (;;)
    {
      localcug.aazP = i;
      localcug = (cug)c.c.b(this.rr.otC);
      AppMethodBeat.o(248412);
      return localcug;
      label94:
      i = 0;
    }
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final int iRW()
  {
    AppMethodBeat.i(248393);
    int i = ((cug)c.c.b(this.rr.otC)).aazI;
    AppMethodBeat.o(248393);
    return i;
  }
  
  public final String iRX()
  {
    AppMethodBeat.i(248398);
    String str = ((cug)c.c.b(this.rr.otC)).aazH;
    AppMethodBeat.o(248398);
    return str;
  }
  
  public final String iRY()
  {
    AppMethodBeat.i(32582);
    Object localObject = (cug)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[] { ((cug)localObject).aazM, Util.getStack() });
    localObject = ((cug)localObject).aazM;
    AppMethodBeat.o(32582);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32580);
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 7L, 1L, true);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = iRY();
      if (paramString == null) {
        break label287;
      }
      params = com.tencent.mm.d.h.ib(paramString);
      if (params == null) {
        break;
      }
      paramInt1 = params.versionCode;
      Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[] { Integer.valueOf(paramInt1) });
      bh.aZW().a(new ag(MMApplicationContext.getPackageName(), paramInt1), 0);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 13L, 1L, true);
      AppMethodBeat.o(32580);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 8L, 1L, true);
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 9L, 1L, true);
        if (paramInt3 == -16) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 10L, 1L, true);
        } else if (paramInt3 == -17) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 11L, 1L, true);
        } else if (paramInt3 == -18) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 12L, 1L, true);
        }
      }
    }
    Log.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[] { paramString });
    AppMethodBeat.o(32580);
    return;
    label287:
    Log.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 14L, 1L, true);
    AppMethodBeat.o(32580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.a.a
 * JD-Core Version:    0.7.0.1
 */