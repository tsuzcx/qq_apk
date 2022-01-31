package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.uu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<uu>
{
  public a()
  {
    AppMethodBeat.i(135282);
    this.__eventId = uu.class.getName().hashCode();
    AppMethodBeat.o(135282);
  }
  
  private static boolean a(uu paramuu)
  {
    AppMethodBeat.i(135283);
    e locale;
    Object localObject;
    if ((paramuu instanceof uu))
    {
      if (!g.RG())
      {
        AppMethodBeat.o(135283);
        return false;
      }
      locale = com.tencent.mm.plugin.voip_cs.b.c.cQn();
      localObject = paramuu.cLk.cLl;
      if ((localObject != null) && (localObject.length != 0))
      {
        paramuu = new byte[localObject.length - 1];
        System.arraycopy(localObject, 1, paramuu, 0, paramuu.length);
        localObject = new cry();
      }
    }
    try
    {
      ((cry)localObject).parseFrom(paramuu);
      ab.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((cry)localObject).yaR + ",notifySeq = " + locale.tKI);
      paramuu = new csf();
      paramuu.xSP = ((cry)localObject).xSP;
      paramuu.wQQ = ((cry)localObject).wQQ;
      paramuu.yaP = ((cry)localObject).yaP;
      paramuu.yaR = ((cry)localObject).yaR;
      paramuu.yaS = ((cry)localObject).yaS;
      paramuu.yaT = ((cry)localObject).yaT;
      paramuu.yaQ = ((cry)localObject).yaQ;
      locale.a(paramuu);
      AppMethodBeat.o(135283);
      return false;
    }
    catch (IOException paramuu)
    {
      for (;;)
      {
        ab.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramuu });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */