package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a IIW = null;
  private f IIX = null;
  
  public static a fpt()
  {
    AppMethodBeat.i(62656);
    if (IIW == null) {}
    try
    {
      if (IIW == null) {
        IIW = new a();
      }
      a locala = IIW;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f fpu()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = fpt();
    if (((a)localObject1).IIX == null) {}
    try
    {
      if (((a)localObject1).IIX == null) {
        ((a)localObject1).IIX = new f();
      }
      localObject1 = ((a)localObject1).IIX;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void fpv()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    fpu();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */