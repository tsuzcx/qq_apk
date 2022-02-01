package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.ue;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  public LinkedList<String> OHM;
  private i callback;
  private d rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bqk();
    ((d.a)localObject).lBV = new bql();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((d.a)localObject).funcId = getType();
    this.rr = ((d.a)localObject).bgN();
    this.rr.setIsUserCmd(true);
    localObject = (bqk)d.b.b(this.rr.lBR);
    ((bqk)localObject).TbA = paramLinkedList;
    ((bqk)localObject).Sdp = k.gJe();
    if (!e.hod()) {
      ((bqk)localObject).Sjh = e.hoe();
    }
    com.tencent.mm.wallet_core.ui.g.azK(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69898);
    this.callback = parami;
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
      params = (bql)d.c.b(((d)params).lBS);
      Log.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { params.TbB });
      this.OHM = params.OHM;
      paramArrayOfByte = this.OHM;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        Log.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        h.aHH();
        h.aHG().aHp().set(ar.a.Vlo, Util.nullAs(params.TbB, ""));
        h.aHH();
        h.aHG().aHp().set(ar.a.Vlp, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      ue localue = new ue();
      localue.fTu.fTw = paramArrayOfByte;
      EventCenter.instance.publish(localue);
      break;
      com.tencent.mm.wallet_core.ui.g.azK(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */