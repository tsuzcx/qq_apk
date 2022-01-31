package com.tencent.ttpic.util;

import android.util.SparseArray;
import com.tencent.filter.h;

public class FrameManager
{
  private static FrameManager instance = new FrameManager();
  public SparseArray<h> frameSparseArray = new SparseArray();
  
  public static FrameManager getInstance()
  {
    return instance;
  }
  
  public h getFrameByTex(int paramInt)
  {
    h localh2 = (h)this.frameSparseArray.get(paramInt);
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      this.frameSparseArray.put(paramInt, localh1);
    }
    return localh1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameManager
 * JD-Core Version:    0.7.0.1
 */