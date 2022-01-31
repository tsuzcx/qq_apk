package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(62852);
    yPY = new a("DesignerSimpleInfo", 0, 0);
    yPZ = new a("PersonalDesigner", 1, 1);
    yQa = new a("DesignerEmojiList", 2, 2);
    yQb = new a[] { yPY, yPZ, yQa };
    AppMethodBeat.o(62852);
  }
  
  private h$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.h.a
 * JD-Core Version:    0.7.0.1
 */