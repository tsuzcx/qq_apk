package com.tencent.mm.plugin.music.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.util.b.a;
import java.util.HashMap;

public final class a
{
  private static HashMap<Integer, Boolean> LNn;
  private static HashMap<Integer, Long> LNo;
  
  static
  {
    AppMethodBeat.i(63133);
    LNn = new HashMap();
    LNo = new HashMap();
    LNn.put(Integer.valueOf(0), Boolean.FALSE);
    LNn.put(Integer.valueOf(1), Boolean.FALSE);
    LNn.put(Integer.valueOf(4), Boolean.FALSE);
    LNn.put(Integer.valueOf(5), Boolean.FALSE);
    LNn.put(Integer.valueOf(6), Boolean.FALSE);
    LNn.put(Integer.valueOf(7), Boolean.FALSE);
    LNn.put(Integer.valueOf(8), Boolean.FALSE);
    LNn.put(Integer.valueOf(9), Boolean.FALSE);
    LNn.put(Integer.valueOf(13), Boolean.FALSE);
    LNn.put(Integer.valueOf(14), Boolean.FALSE);
    LNo.put(Integer.valueOf(0), Long.valueOf(0L));
    LNo.put(Integer.valueOf(1), Long.valueOf(0L));
    LNo.put(Integer.valueOf(4), Long.valueOf(0L));
    LNo.put(Integer.valueOf(5), Long.valueOf(0L));
    LNo.put(Integer.valueOf(6), Long.valueOf(0L));
    LNo.put(Integer.valueOf(7), Long.valueOf(0L));
    LNo.put(Integer.valueOf(8), Long.valueOf(0L));
    LNo.put(Integer.valueOf(9), Long.valueOf(0L));
    LNo.put(Integer.valueOf(13), Long.valueOf(0L));
    LNo.put(Integer.valueOf(14), Long.valueOf(0L));
    AppMethodBeat.o(63133);
  }
  
  public static boolean gnh()
  {
    AppMethodBeat.i(271084);
    if (((c)h.ax(c.class)).a(c.a.zhX, b.a.agqT, 0) == 1)
    {
      AppMethodBeat.o(271084);
      return true;
    }
    AppMethodBeat.o(271084);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */