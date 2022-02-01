package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public abstract boolean aEd();
  
  public abstract long gYU();
  
  public abstract a gYV();
  
  public abstract Camera.PreviewCallback gYW();
  
  public abstract int getDuration();
  
  public abstract String getRecordPath();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(28704);
      PHW = new a("WaitStart", 0);
      PHX = new a("Start", 1);
      PHY = new a("PrepareStop", 2);
      PHZ = new a("WaitStop", 3);
      PIa = new a("Stop", 4);
      PIb = new a("WaitSend", 5);
      PIc = new a("Sent", 6);
      PId = new a("Error", 7);
      PIe = new a("Initialized", 8);
      PIf = new a("Pause", 9);
      PIg = new a[] { PHW, PHX, PHY, PHZ, PIa, PIb, PIc, PId, PIe, PIf };
      AppMethodBeat.o(28704);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.a
 * JD-Core Version:    0.7.0.1
 */