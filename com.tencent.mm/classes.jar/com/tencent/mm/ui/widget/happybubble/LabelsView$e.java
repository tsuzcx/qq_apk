package com.tencent.mm.ui.widget.happybubble;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LabelsView$e
{
  int value;
  
  static
  {
    AppMethodBeat.i(143562);
    YpL = new e("NONE", 0, 1);
    YpM = new e("SINGLE", 1, 2);
    YpN = new e("SINGLE_IRREVOCABLY", 2, 3);
    YpO = new e("MULTI", 3, 4);
    YpP = new e[] { YpL, YpM, YpN, YpO };
    AppMethodBeat.o(143562);
  }
  
  private LabelsView$e(int paramInt)
  {
    this.value = paramInt;
  }
  
  static e ayx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return YpL;
    case 1: 
      return YpL;
    case 2: 
      return YpM;
    case 3: 
      return YpN;
    }
    return YpO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView.e
 * JD-Core Version:    0.7.0.1
 */