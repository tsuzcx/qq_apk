package com.tencent.mm.plugin.music.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import java.util.HashMap;

public final class a
{
  private static HashMap<Integer, Boolean> FSr;
  private static HashMap<Integer, Long> FSs;
  
  static
  {
    AppMethodBeat.i(63133);
    FSr = new HashMap();
    FSs = new HashMap();
    FSr.put(Integer.valueOf(0), Boolean.FALSE);
    FSr.put(Integer.valueOf(1), Boolean.FALSE);
    FSr.put(Integer.valueOf(4), Boolean.FALSE);
    FSr.put(Integer.valueOf(5), Boolean.FALSE);
    FSr.put(Integer.valueOf(6), Boolean.FALSE);
    FSr.put(Integer.valueOf(7), Boolean.FALSE);
    FSr.put(Integer.valueOf(8), Boolean.FALSE);
    FSr.put(Integer.valueOf(9), Boolean.FALSE);
    FSr.put(Integer.valueOf(13), Boolean.FALSE);
    FSr.put(Integer.valueOf(14), Boolean.FALSE);
    FSs.put(Integer.valueOf(0), Long.valueOf(0L));
    FSs.put(Integer.valueOf(1), Long.valueOf(0L));
    FSs.put(Integer.valueOf(4), Long.valueOf(0L));
    FSs.put(Integer.valueOf(5), Long.valueOf(0L));
    FSs.put(Integer.valueOf(6), Long.valueOf(0L));
    FSs.put(Integer.valueOf(7), Long.valueOf(0L));
    FSs.put(Integer.valueOf(8), Long.valueOf(0L));
    FSs.put(Integer.valueOf(9), Long.valueOf(0L));
    FSs.put(Integer.valueOf(13), Long.valueOf(0L));
    FSs.put(Integer.valueOf(14), Long.valueOf(0L));
    AppMethodBeat.o(63133);
  }
  
  public static boolean fee()
  {
    AppMethodBeat.i(259873);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPv, com.tencent.mm.util.b.a.YxU, 0) == 1)
    {
      AppMethodBeat.o(259873);
      return true;
    }
    AppMethodBeat.o(259873);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */