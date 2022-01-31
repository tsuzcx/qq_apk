package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.c.d;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.c.cci;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$10
  extends n.a
{
  VoipCSMainUI$10(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void et(int paramInt)
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from " + paramInt);
    com.tencent.mm.plugin.voip_cs.b.a locala;
    if ((c.bSP().qeb == 2) && ((paramInt == 4) || (paramInt == 6)))
    {
      localObject = c.bSP();
      locala = c.bSO().qeL;
      if (((e)localObject).pQo == 0) {
        ((e)localObject).pQo = locala.pUy;
      }
      paramInt = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
      if (paramInt != ((e)localObject).pQo) {
        y.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((e)localObject).pQo + " to " + paramInt);
      }
    }
    try
    {
      byte[] arrayOfByte = new byte[4];
      arrayOfByte[0] = ((byte)paramInt);
      int i = locala.setAppCmd(301, arrayOfByte, 4);
      if (i < 0) {
        y.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramInt + "fail:" + i + ", [roomid=" + locala.lpL + ", roomkey=" + locala.lpE + "]");
      }
      cci localcci = new cci();
      localcci.tRC = 3;
      localcci.tRD = new b(arrayOfByte, 0, 1);
      locala.SendRUDP(localcci.toByteArray(), localcci.toByteArray().length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
      }
    }
    ((e)localObject).pQo = paramInt;
    Object localObject = c.bSP();
    y.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + c.bSO().qeL.pUA + "roomkey:" + c.bSO().qeL.lpE);
    g.Dk().a(285, (f)localObject);
    localObject = c.bSO().qeL;
    localObject = new d(((v2protocal)localObject).pUA, ((v2protocal)localObject).lpE);
    g.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.10
 * JD-Core Version:    0.7.0.1
 */