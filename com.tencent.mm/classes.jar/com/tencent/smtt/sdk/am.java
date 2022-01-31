package com.tencent.smtt.sdk;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class am
  extends HandlerThread
{
  private static am a;
  
  public am(String paramString)
  {
    super(paramString);
  }
  
  public static am a()
  {
    try
    {
      AppMethodBeat.i(139264);
      if (a == null)
      {
        localam = new am("TbsHandlerThread");
        a = localam;
        localam.start();
      }
      am localam = a;
      AppMethodBeat.o(139264);
      return localam;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.am
 * JD-Core Version:    0.7.0.1
 */