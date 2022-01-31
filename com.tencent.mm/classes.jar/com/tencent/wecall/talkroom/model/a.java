package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public class a
{
  private static a BzV = null;
  private f BzW = null;
  
  public static a dXf()
  {
    AppMethodBeat.i(127764);
    if (BzV == null) {}
    try
    {
      if (BzV == null) {
        BzV = new a();
      }
      a locala = BzV;
      AppMethodBeat.o(127764);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(127764);
    }
  }
  
  public static f dXg()
  {
    AppMethodBeat.i(127765);
    Object localObject1 = dXf();
    if (((a)localObject1).BzW == null) {}
    try
    {
      if (((a)localObject1).BzW == null) {
        ((a)localObject1).BzW = new f();
      }
      localObject1 = ((a)localObject1).BzW;
      AppMethodBeat.o(127765);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127765);
    }
  }
  
  public static void dXh()
  {
    AppMethodBeat.i(127766);
    c.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    dXg();
    AppMethodBeat.o(127766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */