package com.tencent.mm.plugin.subapp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.LinkedList;

final class a$1
  implements ap.a
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25220);
    if (this.sWW.sWV < 0)
    {
      AppMethodBeat.o(25220);
      return false;
    }
    aro localaro = (aro)this.sWW.rr.fsW.fta;
    try
    {
      Object localObject1 = (cpq)localaro.xgT.get(this.sWW.sWV);
      if ((localObject1 != null) && (((cpq)localObject1).xYB != null) && (((cpq)localObject1).xYB.getBuffer() != null) && (((cpq)localObject1).xYA != null) && (((cpq)localObject1).xYA.getBuffer() != null))
      {
        ab.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localaro.Version + " idx:" + this.sWW.sWV + " id:" + Integer.toHexString(((cpq)localObject1).ID) + " size:" + ((cpq)localObject1).xYA.getILen() + " hdsize:" + ((cpq)localObject1).xYB.getILen());
        a.a(((cpq)localObject1).ID, true, ((cpq)localObject1).xYB.getBuffer().toByteArray());
        a.a(((cpq)localObject1).ID, false, ((cpq)localObject1).xYA.getBuffer().toByteArray());
      }
      localObject1 = this.sWW;
      ((a)localObject1).sWV -= 1;
      AppMethodBeat.o(25220);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.sWW.sWV + " not Found");
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a.1
 * JD-Core Version:    0.7.0.1
 */