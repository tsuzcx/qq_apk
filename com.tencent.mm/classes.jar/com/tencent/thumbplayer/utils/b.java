package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
{
  private ArrayList<b> mListeners;
  
  private b()
  {
    AppMethodBeat.i(194830);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(194830);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(194831);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        d.i("TPGlobalEventNofication", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(194831);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(194832);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        d.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(194832);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static b Mzh;
    
    static
    {
      AppMethodBeat.i(194829);
      Mzh = new b((byte)0);
      AppMethodBeat.o(194829);
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.b
 * JD-Core Version:    0.7.0.1
 */