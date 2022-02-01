package com.tencent.mm.plugin.taskbar.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.u;
import com.tencent.mm.autogen.mmdata.rpt.v;
import com.tencent.mm.autogen.mmdata.rpt.x;
import com.tencent.mm.autogen.mmdata.rpt.y;

public final class a
{
  public long SQM = 0L;
  public String SQN = "";
  
  public static int UG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    case 3: 
      return 6;
    case 4: 
      return 5;
    case 6: 
      return 10;
    case 21: 
      return 9;
    }
    return 8;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    AppMethodBeat.i(263961);
    u localu = new u();
    localu.imd = localu.F("session_id", this.SQN, true);
    localu.ime = paramInt1;
    localu.imf = paramInt2;
    localu.imh = paramInt3;
    localu.imi = paramInt4;
    localu.imj = paramInt5;
    localu.imk = paramInt6;
    localu.imm = paramInt7;
    localu.imn = paramInt8;
    localu.imo = paramInt9;
    localu.imp = paramInt10;
    localu.imq = paramInt11;
    localu.bMH();
    AppMethodBeat.o(263961);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(263975);
    x localx = new x();
    localx.imd = localx.F("session_id", this.SQN, true);
    localx.imw = localx.F("action_type", String.valueOf(paramInt1), true);
    localx.imx = paramInt2;
    localx.imy = paramInt3;
    localx.imt = localx.F("content_id", paramString, true);
    localx.imv = paramInt4;
    localx.imq = paramInt5;
    localx.imz = paramInt6;
    localx.imA = paramInt7;
    localx.bMH();
    AppMethodBeat.o(263975);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(263968);
    v localv = new v();
    localv.imd = localv.F("session_id", this.SQN, true);
    localv.imr = paramInt1;
    localv.ims = paramInt2;
    localv.imt = localv.F("content_id", paramString1, true);
    localv.imq = paramInt3;
    if (paramString2 != null) {
      localv.imu = localv.F("icon_appid", paramString2, true);
    }
    localv.bMH();
    AppMethodBeat.o(263968);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(263985);
    y localy = new y();
    localy.imd = localy.F("session_id", this.SQN, true);
    localy.imB = paramInt1;
    localy.imr = paramInt2;
    localy.imC = localy.F("conent_list", paramString1, true);
    localy.imD = paramInt3;
    if (paramString2 != null) {
      localy.imu = localy.F("icon_appid", paramString2, true);
    }
    localy.bMH();
    AppMethodBeat.o(263985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.a.a
 * JD-Core Version:    0.7.0.1
 */