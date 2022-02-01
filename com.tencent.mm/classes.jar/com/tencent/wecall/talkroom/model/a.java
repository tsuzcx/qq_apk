package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a ahZA = null;
  private f ahZB = null;
  
  public static a kdO()
  {
    AppMethodBeat.i(62656);
    if (ahZA == null) {}
    try
    {
      if (ahZA == null) {
        ahZA = new a();
      }
      a locala = ahZA;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f kdP()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = kdO();
    if (((a)localObject1).ahZB == null) {}
    try
    {
      if (((a)localObject1).ahZB == null) {
        ((a)localObject1).ahZB = new f();
      }
      localObject1 = ((a)localObject1).ahZB;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void kdQ()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    kdP();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */