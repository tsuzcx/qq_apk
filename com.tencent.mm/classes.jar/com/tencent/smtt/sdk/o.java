package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class o
  extends HandlerThread
{
  private static o a;
  
  public o(String paramString)
  {
    super(paramString);
  }
  
  public static o a()
  {
    try
    {
      AppMethodBeat.i(55215);
      if (a == null)
      {
        localo = new o("TbsHandlerThread");
        a = localo;
        localo.start();
      }
      o localo = a;
      AppMethodBeat.o(55215);
      return localo;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */