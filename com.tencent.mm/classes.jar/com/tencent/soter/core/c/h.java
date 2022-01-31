package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h
{
  private static volatile h.a Bms;
  
  static
  {
    AppMethodBeat.i(73043);
    Bms = new h.1();
    AppMethodBeat.o(73043);
  }
  
  public static void a(h.a parama)
  {
    AppMethodBeat.i(73040);
    Assert.assertNotNull(parama);
    Bms = parama;
    AppMethodBeat.o(73040);
  }
  
  public static void dVm()
  {
    AppMethodBeat.i(73041);
    Bms.dVo();
    AppMethodBeat.o(73041);
  }
  
  public static boolean dVn()
  {
    AppMethodBeat.i(73042);
    boolean bool = Bms.dVn();
    AppMethodBeat.o(73042);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.c.h
 * JD-Core Version:    0.7.0.1
 */