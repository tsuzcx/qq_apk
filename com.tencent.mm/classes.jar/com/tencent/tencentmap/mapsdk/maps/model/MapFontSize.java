package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MapFontSize
{
  private int engineCode;
  private int fontSize;
  
  static
  {
    AppMethodBeat.i(218027);
    tiny = new MapFontSize("tiny", 0, 0, 4);
    small = new MapFontSize("small", 1, 1, 3);
    normal = new MapFontSize("normal", 2, 2, 0);
    large = new MapFontSize("large", 3, 3, 1);
    huge = new MapFontSize("huge", 4, 4, 2);
    $VALUES = new MapFontSize[] { tiny, small, normal, large, huge };
    AppMethodBeat.o(218027);
  }
  
  private MapFontSize(int paramInt1, int paramInt2)
  {
    this.fontSize = paramInt1;
    this.engineCode = paramInt2;
  }
  
  public final int getFontSize()
  {
    return this.fontSize;
  }
  
  public final int getValue()
  {
    return this.engineCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapFontSize
 * JD-Core Version:    0.7.0.1
 */