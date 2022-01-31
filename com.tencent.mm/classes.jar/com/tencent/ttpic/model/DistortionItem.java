package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DistortionItem
  implements Cloneable
{
  public int direction;
  public int distortion;
  public int position;
  public float radius;
  public float strength;
  public int targetDx = 0;
  public int targetDy = 0;
  public int x;
  public int y;
  
  public DistortionItem clone()
  {
    AppMethodBeat.i(83479);
    Object localObject1 = new DistortionItem();
    try
    {
      Object localObject2 = super.clone();
      if (!(localObject2 instanceof DistortionItem)) {
        break label40;
      }
      localObject2 = (DistortionItem)localObject2;
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label32:
      break label32;
    }
    AppMethodBeat.o(83479);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.model.DistortionItem
 * JD-Core Version:    0.7.0.1
 */