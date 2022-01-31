package com.tencent.ttpic.util;

import android.util.SparseArray;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FrameManager
{
  private static FrameManager instance;
  public SparseArray<h> frameSparseArray;
  
  static
  {
    AppMethodBeat.i(83917);
    instance = new FrameManager();
    AppMethodBeat.o(83917);
  }
  
  private FrameManager()
  {
    AppMethodBeat.i(83915);
    this.frameSparseArray = new SparseArray();
    AppMethodBeat.o(83915);
  }
  
  public static FrameManager getInstance()
  {
    return instance;
  }
  
  public h getFrameByTex(int paramInt)
  {
    AppMethodBeat.i(83916);
    h localh2 = (h)this.frameSparseArray.get(paramInt);
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      this.frameSparseArray.put(paramInt, localh1);
    }
    AppMethodBeat.o(83916);
    return localh1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameManager
 * JD-Core Version:    0.7.0.1
 */