package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a Suf = null;
  private f Sug = null;
  
  public static a hqI()
  {
    AppMethodBeat.i(62656);
    if (Suf == null) {}
    try
    {
      if (Suf == null) {
        Suf = new a();
      }
      a locala = Suf;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f hqJ()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = hqI();
    if (((a)localObject1).Sug == null) {}
    try
    {
      if (((a)localObject1).Sug == null) {
        ((a)localObject1).Sug = new f();
      }
      localObject1 = ((a)localObject1).Sug;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void hqK()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    hqJ();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */