package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a Kvo = null;
  private f Kvp = null;
  
  public static a fHO()
  {
    AppMethodBeat.i(62656);
    if (Kvo == null) {}
    try
    {
      if (Kvo == null) {
        Kvo = new a();
      }
      a locala = Kvo;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f fHP()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = fHO();
    if (((a)localObject1).Kvp == null) {}
    try
    {
      if (((a)localObject1).Kvp == null) {
        ((a)localObject1).Kvp = new f();
      }
      localObject1 = ((a)localObject1).Kvp;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void fHQ()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    fHP();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */