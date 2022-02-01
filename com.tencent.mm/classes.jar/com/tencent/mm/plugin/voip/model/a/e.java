package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.protocal.protobuf.gap;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends n<gap, gaq>
{
  public e(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115230);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gap();
    ((c.a)localObject).otF = new gaq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
    ((c.a)localObject).funcId = 303;
    ((c.a)localObject).otG = 119;
    ((c.a)localObject).respCmdId = 1000000119;
    this.rr = ((c.a)localObject).bEF();
    localObject = (gap)c.b.b(this.rr.otB);
    ((gap)localObject).Zvz = paramInt;
    ((gap)localObject).ZvA = paramLong;
    ((gap)localObject).abXZ = paramString;
    ((gap)localObject).vhJ = 1;
    ((gap)localObject).abWT = System.currentTimeMillis();
    AppMethodBeat.o(115230);
  }
  
  public final int getType()
  {
    return 303;
  }
  
  public final h hYT()
  {
    AppMethodBeat.i(115232);
    e.1 local1 = new e.1(this);
    AppMethodBeat.o(115232);
    return local1;
  }
  
  public final void mD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115231);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      gaq localgaq = (gaq)hYX();
      if (localgaq != null) {
        Log.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[] { Integer.valueOf(localgaq.Zvz), Long.valueOf(localgaq.ZvA), Integer.valueOf(localgaq.lyF), Integer.valueOf(localgaq.abXQ) });
      }
      AppMethodBeat.o(115231);
      return;
    }
    Log.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    AppMethodBeat.o(115231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e
 * JD-Core Version:    0.7.0.1
 */