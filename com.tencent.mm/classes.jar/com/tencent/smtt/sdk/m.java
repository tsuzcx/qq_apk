package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class m
  extends HandlerThread
{
  private static m a;
  
  public m(String paramString)
  {
    super(paramString);
  }
  
  public static m a()
  {
    try
    {
      AppMethodBeat.i(54498);
      if (a == null)
      {
        localm = new m("TbsHandlerThread");
        a = localm;
        localm.start();
      }
      m localm = a;
      AppMethodBeat.o(54498);
      return localm;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */