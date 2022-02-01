package com.tencent.mm.sdk.d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  implements a
{
  public void enter() {}
  
  public void exit() {}
  
  public String getName()
  {
    AppMethodBeat.i(158010);
    String str = getClass().getName();
    str = str.substring(str.lastIndexOf('$') + 1);
    AppMethodBeat.o(158010);
    return str;
  }
  
  public boolean k(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */