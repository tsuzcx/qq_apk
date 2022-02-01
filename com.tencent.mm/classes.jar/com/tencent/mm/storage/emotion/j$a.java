package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(105111);
    FBS = new a("DesignerSimpleInfo", 0, 0);
    FBT = new a("PersonalDesigner", 1, 1);
    FBU = new a("DesignerEmojiList", 2, 2);
    FBV = new a[] { FBS, FBT, FBU };
    AppMethodBeat.o(105111);
  }
  
  private j$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.j.a
 * JD-Core Version:    0.7.0.1
 */