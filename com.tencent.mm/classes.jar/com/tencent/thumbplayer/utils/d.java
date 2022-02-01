package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
{
  private ArrayList<b> mListeners;
  
  private d()
  {
    AppMethodBeat.i(188227);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(188227);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(188228);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        f.i("TPGlobalEventNofication", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(188228);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(188229);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        f.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(188229);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static d Kmn;
    
    static
    {
      AppMethodBeat.i(188226);
      Kmn = new d((byte)0);
      AppMethodBeat.o(188226);
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.d
 * JD-Core Version:    0.7.0.1
 */