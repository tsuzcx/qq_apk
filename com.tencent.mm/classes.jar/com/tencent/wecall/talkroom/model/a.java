package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a ZVb = null;
  private f ZVc = null;
  
  public static a ius()
  {
    AppMethodBeat.i(62656);
    if (ZVb == null) {}
    try
    {
      if (ZVb == null) {
        ZVb = new a();
      }
      a locala = ZVb;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f iut()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = ius();
    if (((a)localObject1).ZVc == null) {}
    try
    {
      if (((a)localObject1).ZVc == null) {
        ((a)localObject1).ZVc = new f();
      }
      localObject1 = ((a)localObject1).ZVc;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void iuu()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    iut();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */