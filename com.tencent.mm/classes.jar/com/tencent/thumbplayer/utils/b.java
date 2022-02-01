package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  private ArrayList<b> mListeners;
  
  private b()
  {
    AppMethodBeat.i(192152);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(192152);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(192153);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        d.i("TPGlobalEventNofication", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(192153);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(192154);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        d.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(192154);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static b Mcm;
    
    static
    {
      AppMethodBeat.i(192151);
      Mcm = new b((byte)0);
      AppMethodBeat.o(192151);
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.b
 * JD-Core Version:    0.7.0.1
 */