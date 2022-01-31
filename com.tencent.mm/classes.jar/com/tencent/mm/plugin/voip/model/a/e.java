package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends n<cso, csp>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(4710);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cso();
    ((b.a)localObject).fsY = new csp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((b.a)localObject).funcId = 303;
    ((b.a)localObject).reqCmdId = 119;
    ((b.a)localObject).respCmdId = 1000000119;
    this.rr = ((b.a)localObject).ado();
    localObject = (cso)this.rr.fsV.fta;
    ((cso)localObject).wQP = paramInt;
    ((cso)localObject).wQQ = paramLong;
    ((cso)localObject).ybf = paramString;
    ((cso)localObject).jKs = 1;
    ((cso)localObject).yab = System.currentTimeMillis();
    AppMethodBeat.o(4710);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4712);
    e.1 local1 = new e.1(this);
    AppMethodBeat.o(4712);
    return local1;
  }
  
  public final int getType()
  {
    return 303;
  }
  
  public final void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4711);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      csp localcsp = (csp)cOt();
      if (localcsp != null) {
        ab.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localcsp.wQP), Long.valueOf(localcsp.wQQ), Integer.valueOf(localcsp.eeF), Integer.valueOf(localcsp.yaX) });
      }
      AppMethodBeat.o(4711);
      return;
    }
    ab.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(4711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */