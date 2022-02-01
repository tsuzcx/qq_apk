package com.tencent.mm.plugin.voip_cs.listener;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ack;
import com.tencent.mm.autogen.a.ack.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip_cs.model.c;
import com.tencent.mm.plugin.voip_cs.model.e;
import com.tencent.mm.protocal.protobuf.fzz;
import com.tencent.mm.protocal.protobuf.gag;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class VoipCSEventListener
  extends IListener<ack>
{
  public VoipCSEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161685);
    this.__eventId = ack.class.getName().hashCode();
    AppMethodBeat.o(161685);
  }
  
  private static boolean a(ack paramack)
  {
    AppMethodBeat.i(125336);
    e locale;
    Object localObject;
    if ((paramack instanceof ack))
    {
      if (!h.baz())
      {
        AppMethodBeat.o(125336);
        return false;
      }
      locale = c.idX();
      localObject = paramack.ifO.ifP;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramack = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramack, 0, paramack.length);
        localObject = new fzz();
      }
    }
    try
    {
      ((fzz)localObject).parseFrom(paramack);
      Log.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((fzz)localObject).abXL + ",notifySeq = " + locale.UXL);
      paramack = new gag();
      paramack.abKe = ((fzz)localObject).abKe;
      paramack.ZvA = ((fzz)localObject).ZvA;
      paramack.abXJ = ((fzz)localObject).abXJ;
      paramack.abXL = ((fzz)localObject).abXL;
      paramack.abXM = ((fzz)localObject).abXM;
      paramack.abXN = ((fzz)localObject).abXN;
      paramack.abXK = ((fzz)localObject).abXK;
      locale.a(paramack);
      AppMethodBeat.o(125336);
      return false;
    }
    catch (IOException paramack)
    {
      for (;;)
      {
        Log.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramack });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.listener.VoipCSEventListener
 * JD-Core Version:    0.7.0.1
 */