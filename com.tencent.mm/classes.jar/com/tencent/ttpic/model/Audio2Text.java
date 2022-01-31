package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text
{
  public static final int MODE_FIFO = 2;
  public static final int MODE_LOOP_REPLACE = 1;
  public int segmentCount;
  public double segmentTime;
  public int sentenceCount;
  public int sentenceMode = 2;
  public double silenceTime;
  public String triggerWords;
  
  public static class LoopRepList<T>
    extends CopyOnWriteArrayList<T>
  {
    private int mCapacity;
    private int mCurrent;
    
    public LoopRepList(int paramInt)
    {
      this.mCapacity = paramInt;
      this.mCurrent = 0;
    }
    
    public boolean add(T paramT)
    {
      AppMethodBeat.i(83452);
      if (size() >= this.mCapacity)
      {
        if (this.mCurrent >= this.mCapacity) {
          this.mCurrent = 0;
        }
        int i = this.mCurrent;
        this.mCurrent = (i + 1);
        super.set(i, paramT);
        AppMethodBeat.o(83452);
        return true;
      }
      boolean bool = super.add(paramT);
      AppMethodBeat.o(83452);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text
 * JD-Core Version:    0.7.0.1
 */