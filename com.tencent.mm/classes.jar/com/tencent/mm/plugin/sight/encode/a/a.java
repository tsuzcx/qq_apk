package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract boolean Np();
  
  public abstract long dTY();
  
  public abstract a dTZ();
  
  public abstract Camera.PreviewCallback dUa();
  
  public abstract int getDuration();
  
  public abstract String getRecordPath();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(28704);
      zkd = new a("WaitStart", 0);
      zke = new a("Start", 1);
      zkf = new a("PrepareStop", 2);
      zkg = new a("WaitStop", 3);
      zkh = new a("Stop", 4);
      zki = new a("WaitSend", 5);
      zkj = new a("Sent", 6);
      zkk = new a("Error", 7);
      zkl = new a("Initialized", 8);
      zkm = new a("Pause", 9);
      zkn = new a[] { zkd, zke, zkf, zkg, zkh, zki, zkj, zkk, zkl, zkm };
      AppMethodBeat.o(28704);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a
 * JD-Core Version:    0.7.0.1
 */