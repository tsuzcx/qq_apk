package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class AnimationSet
  extends BaseAnimation
{
  public List<Animation> mAnimations;
  public boolean mShareInterpolator;
  
  public AnimationSet(boolean paramBoolean)
  {
    AppMethodBeat.i(173077);
    this.mAnimations = new ArrayList();
    this.mShareInterpolator = paramBoolean;
    AppMethodBeat.o(173077);
  }
  
  public boolean addAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(173080);
    this.mAnimations.add(paramAnimation);
    AppMethodBeat.o(173080);
    return true;
  }
  
  public void cleanAnimation()
  {
    AppMethodBeat.i(173081);
    this.mAnimations.clear();
    AppMethodBeat.o(173081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.AnimationSet
 * JD-Core Version:    0.7.0.1
 */