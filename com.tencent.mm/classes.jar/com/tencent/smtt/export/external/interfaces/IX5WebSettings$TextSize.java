package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IX5WebSettings$TextSize
{
  int value;
  
  static
  {
    AppMethodBeat.i(53215);
    SMALLEST = new TextSize("SMALLEST", 0, 50);
    SMALLER = new TextSize("SMALLER", 1, 75);
    NORMAL = new TextSize("NORMAL", 2, 100);
    LARGER = new TextSize("LARGER", 3, 125);
    LARGEST = new TextSize("LARGEST", 4, 150);
    $VALUES = new TextSize[] { SMALLEST, SMALLER, NORMAL, LARGER, LARGEST };
    AppMethodBeat.o(53215);
  }
  
  private IX5WebSettings$TextSize(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize
 * JD-Core Version:    0.7.0.1
 */