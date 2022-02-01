package com.tencent.mm.plugin.taskbar.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.s;
import com.tencent.mm.f.b.a.t;
import com.tencent.mm.f.b.a.v;
import com.tencent.mm.f.b.a.w;

public final class a
{
  public long Mnt = 0L;
  public String Mnu = "";
  
  public static int RC(int paramInt)
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
    AppMethodBeat.i(214229);
    s locals = new s();
    locals.gfz = locals.z("session_id", this.Mnu, true);
    locals.gfA = paramInt1;
    locals.gfB = paramInt2;
    locals.gfC = paramInt3;
    locals.gfD = paramInt4;
    locals.gfE = paramInt5;
    locals.gfF = paramInt6;
    locals.gfH = paramInt7;
    locals.gfI = paramInt8;
    locals.gfJ = paramInt9;
    locals.gfK = paramInt10;
    locals.gfL = paramInt11;
    locals.bpa();
    AppMethodBeat.o(214229);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(214232);
    v localv = new v();
    localv.gfz = localv.z("session_id", this.Mnu, true);
    localv.gfQ = localv.z("action_type", String.valueOf(paramInt1), true);
    localv.gfR = paramInt2;
    localv.gfS = paramInt3;
    localv.gfO = localv.z("content_id", paramString, true);
    localv.gfP = paramInt4;
    localv.gfL = paramInt5;
    localv.gfT = paramInt6;
    localv.gfU = paramInt7;
    localv.bpa();
    AppMethodBeat.o(214232);
  }
  
  public final void g(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(214230);
    t localt = new t();
    localt.gfz = localt.z("session_id", this.Mnu, true);
    localt.gfM = paramInt1;
    localt.gfN = paramInt2;
    localt.gfO = localt.z("content_id", paramString, true);
    localt.gfL = paramInt3;
    localt.bpa();
    AppMethodBeat.o(214230);
  }
  
  public final void h(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(214233);
    w localw = new w();
    localw.gfz = localw.z("session_id", this.Mnu, true);
    localw.gfV = paramInt1;
    localw.gfM = paramInt2;
    localw.gfW = localw.z("conent_list", paramString, true);
    localw.gfX = paramInt3;
    localw.bpa();
    AppMethodBeat.o(214233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.a.a
 * JD-Core Version:    0.7.0.1
 */