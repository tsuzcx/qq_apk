package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a Mln = null;
  private f Mlo = null;
  
  public static a fZf()
  {
    AppMethodBeat.i(62656);
    if (Mln == null) {}
    try
    {
      if (Mln == null) {
        Mln = new a();
      }
      a locala = Mln;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f fZg()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = fZf();
    if (((a)localObject1).Mlo == null) {}
    try
    {
      if (((a)localObject1).Mlo == null) {
        ((a)localObject1).Mlo = new f();
      }
      localObject1 = ((a)localObject1).Mlo;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void fZh()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    fZg();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */