package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.vu;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  public LinkedList<String> Vxy;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfb();
    ((c.a)localObject).otF = new cfc();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((c.a)localObject).funcId = getType();
    this.rr = ((c.a)localObject).bEF();
    this.rr.setIsUserCmd(true);
    localObject = (cfb)c.b.b(this.rr.otB);
    ((cfb)localObject).aaoM = paramLinkedList;
    ((cfb)localObject).Zbi = k.iis();
    if (!e.iOV()) {
      ((cfb)localObject).Zhn = e.iOW();
    }
    i.aGA(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(69898);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69898);
    return i;
  }
  
  public final int getType()
  {
    return 1650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69899);
    Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cfc)c.c.b(((c)params).otC);
      Log.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { params.aaoN });
      this.Vxy = params.Vxy;
      paramArrayOfByte = this.Vxy;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        Log.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acMI, Util.nullAs(params.aaoN, ""));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acMJ, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      vu localvu = new vu();
      localvu.hZs.hZu = paramArrayOfByte;
      localvu.publish();
      break;
      i.aGA(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */