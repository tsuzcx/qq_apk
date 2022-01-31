package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text$FIFOList<T>
  extends CopyOnWriteArrayList<T>
{
  private int mCapacity;
  
  public Audio2Text$FIFOList(int paramInt)
  {
    this.mCapacity = paramInt;
  }
  
  public boolean add(T paramT)
  {
    AppMethodBeat.i(83451);
    if (size() >= this.mCapacity)
    {
      remove(0);
      bool = super.add(paramT);
      AppMethodBeat.o(83451);
      return bool;
    }
    boolean bool = super.add(paramT);
    AppMethodBeat.o(83451);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text.FIFOList
 * JD-Core Version:    0.7.0.1
 */