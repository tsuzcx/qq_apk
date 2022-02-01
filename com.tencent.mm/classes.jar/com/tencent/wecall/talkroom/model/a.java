package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a
{
  private static a MIk = null;
  private f MIl = null;
  
  public static a gdG()
  {
    AppMethodBeat.i(62656);
    if (MIk == null) {}
    try
    {
      if (MIk == null) {
        MIk = new a();
      }
      a locala = MIk;
      AppMethodBeat.o(62656);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(62656);
    }
  }
  
  public static f gdH()
  {
    AppMethodBeat.i(62657);
    Object localObject1 = gdG();
    if (((a)localObject1).MIl == null) {}
    try
    {
      if (((a)localObject1).MIl == null) {
        ((a)localObject1).MIl = new f();
      }
      localObject1 = ((a)localObject1).MIl;
      AppMethodBeat.o(62657);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(62657);
    }
  }
  
  public static void gdI()
  {
    AppMethodBeat.i(62658);
    b.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    gdH();
    AppMethodBeat.o(62658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */