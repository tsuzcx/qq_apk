package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract boolean LN();
  
  public abstract long dqQ();
  
  public abstract a dqR();
  
  public abstract Camera.PreviewCallback dqS();
  
  public abstract int getDuration();
  
  public abstract String getRecordPath();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(28704);
      wtT = new a("WaitStart", 0);
      wtU = new a("Start", 1);
      wtV = new a("PrepareStop", 2);
      wtW = new a("WaitStop", 3);
      wtX = new a("Stop", 4);
      wtY = new a("WaitSend", 5);
      wtZ = new a("Sent", 6);
      wua = new a("Error", 7);
      wub = new a("Initialized", 8);
      wuc = new a("Pause", 9);
      wud = new a[] { wtT, wtU, wtV, wtW, wtX, wtY, wtZ, wua, wub, wuc };
      AppMethodBeat.o(28704);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a
 * JD-Core Version:    0.7.0.1
 */