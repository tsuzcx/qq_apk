package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.c.d;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class VoipCSMainUI$10
  extends n.a
{
  VoipCSMainUI$10(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(135398);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramInt)));
    com.tencent.mm.plugin.voip_cs.b.a locala;
    if ((c.cQn().tKO == 2) && ((paramInt == 4) || (paramInt == 6)))
    {
      localObject = c.cQn();
      locala = c.cQm().tLy;
      if (((e)localObject).tvt == 0) {
        ((e)localObject).tvt = locala.tzZ;
      }
      paramInt = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
      if (paramInt != ((e)localObject).tvt) {
        ab.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((e)localObject).tvt + " to " + paramInt);
      }
    }
    try
    {
      byte[] arrayOfByte = new byte[4];
      arrayOfByte[0] = ((byte)paramInt);
      int i = locala.setAppCmd(301, arrayOfByte, 4);
      if (i < 0) {
        ab.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramInt + "fail:" + i + ", [roomid=" + locala.nNh + ", roomkey=" + locala.nNa + "]");
      }
      cpp localcpp = new cpp();
      localcpp.xYy = 3;
      localcpp.xYz = new b(arrayOfByte, 0, 1);
      locala.SendRUDP(localcpp.toByteArray(), localcpp.toByteArray().length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
      }
    }
    ((e)localObject).tvt = paramInt;
    Object localObject = c.cQn();
    ab.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + c.cQm().tLy.tAb + "roomkey:" + c.cQm().tLy.nNa);
    g.Rc().a(285, (f)localObject);
    localObject = c.cQm().tLy;
    localObject = new d(((v2protocal)localObject).tAb, ((v2protocal)localObject).nNa);
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(135398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.10
 * JD-Core Version:    0.7.0.1
 */