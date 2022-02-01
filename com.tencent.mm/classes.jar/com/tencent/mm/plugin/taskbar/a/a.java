package com.tencent.mm.plugin.taskbar.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.g.b.a.r;
import com.tencent.mm.g.b.a.s;

public final class a
{
  public String FSr = "";
  public long oCb = 0L;
  
  public static int Mm(int paramInt)
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
  
  public final void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(238102);
    p localp = new p();
    localp.ekH = localp.x("session_id", this.FSr, true);
    localp.ekR = paramInt1;
    localp.ekS = paramInt2;
    localp.ekT = localp.x("content_id", paramString, true);
    localp.bfK();
    AppMethodBeat.o(238102);
  }
  
  public final void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(238104);
    s locals = new s();
    locals.ekH = locals.x("session_id", this.FSr, true);
    locals.ekY = paramInt1;
    locals.ekR = paramInt2;
    locals.ekZ = locals.x("conent_list", paramString, true);
    locals.bfK();
    AppMethodBeat.o(238104);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    AppMethodBeat.i(238103);
    r localr = new r();
    localr.ekH = localr.x("session_id", this.FSr, true);
    localr.ekV = localr.x("action_type", String.valueOf(paramInt1), true);
    localr.ekW = paramInt2;
    localr.ekX = paramInt3;
    localr.ekT = localr.x("content_id", paramString, true);
    localr.ekU = paramInt4;
    localr.bfK();
    AppMethodBeat.o(238103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.a.a
 * JD-Core Version:    0.7.0.1
 */