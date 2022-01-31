package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class t$1
  extends n.a
{
  t$1(t paramt) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(4601);
    ab.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramInt)));
    if ((t.a(this.tzi)) && (paramInt == 4))
    {
      localObject = this.tzi.tyR.ttm;
      if (((k)localObject).tvt == 0) {
        ((k)localObject).tvt = ((k)localObject).tvj.tzZ;
      }
      paramInt = a.getNetType(ah.getContext());
      if (paramInt != ((k)localObject).tvt) {
        a.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + ((k)localObject).tvt + " to " + paramInt);
      }
    }
    try
    {
      byte[] arrayOfByte = new byte[4];
      arrayOfByte[0] = ((byte)paramInt);
      int i = ((k)localObject).tvj.setAppCmd(301, arrayOfByte, 4);
      if (i < 0) {
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramInt + "fail:" + i + ", [roomid=" + ((k)localObject).tvj.nNh + ", roomkey=" + ((k)localObject).tvj.nNa + "]");
      }
      cpp localcpp = new cpp();
      localcpp.xYy = 3;
      localcpp.xYz = new b(arrayOfByte, 0, 1);
      ((k)localObject).tvj.SendRUDP(localcpp.toByteArray(), localcpp.toByteArray().length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
      }
    }
    ((k)localObject).tvt = paramInt;
    Object localObject = this.tzi.tyR;
    new h(((u)localObject).ttm.tvj.nMZ, ((u)localObject).ttm.tvj.nNa, ((u)localObject).ttm.tvj.nNh, 0, 0, null).cOs();
    AppMethodBeat.o(4601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t.1
 * JD-Core Version:    0.7.0.1
 */