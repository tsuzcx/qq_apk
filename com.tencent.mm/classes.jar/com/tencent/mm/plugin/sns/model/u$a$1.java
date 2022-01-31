package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class u$a$1
  extends ak
{
  u$a$1(u.a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(36303);
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(36303);
      return;
    }
    if ((this.rfl.mcO == null) || (this.rfl.mcO.isEmpty()))
    {
      paramMessage = this.rfl.rfi;
      cew localcew = (cew)paramMessage.rr.fsW.fta;
      cev localcev = (cev)paramMessage.rr.fsV.fta;
      byte[] arrayOfByte = localcew.wFR.getBuffer().toByteArray();
      arrayOfByte = com.tencent.mm.protocal.ab.j(localcev.wFR.getBuffer().toByteArray(), arrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        g.RM();
        g.RL().Ru().set(8195, bo.cg(arrayOfByte));
      }
      localcev.wFR.setBuffer(arrayOfByte);
      if ((localcew.wBX & localcev.wFQ) == 0)
      {
        paramMessage.callback.onSceneEnd(0, 0, "", paramMessage);
        AppMethodBeat.o(36303);
        return;
      }
      paramMessage.doScene(paramMessage.dispatcher(), paramMessage.callback);
      AppMethodBeat.o(36303);
      return;
    }
    paramMessage = (ud)this.rfl.mcO.getFirst();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramMessage.wMC);
    this.rfl.mcO.removeFirst();
    switch (paramMessage.wMC)
    {
    default: 
      this.rfl.mur.sendEmptyMessage(0);
      AppMethodBeat.o(36303);
      return;
    case 45: 
      ag.coO().post(new u.a.1.1(this, paramMessage));
      AppMethodBeat.o(36303);
      return;
    }
    ag.coO().post(new u.a.1.2(this, paramMessage));
    AppMethodBeat.o(36303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.a.1
 * JD-Core Version:    0.7.0.1
 */