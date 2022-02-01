package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WebSettings$TextSize
{
  int value;
  
  static
  {
    AppMethodBeat.i(55360);
    SMALLEST = new TextSize("SMALLEST", 0, 50);
    SMALLER = new TextSize("SMALLER", 1, 75);
    NORMAL = new TextSize("NORMAL", 2, 100);
    LARGER = new TextSize("LARGER", 3, 125);
    LARGEST = new TextSize("LARGEST", 4, 150);
    $VALUES = new TextSize[] { SMALLEST, SMALLER, NORMAL, LARGER, LARGEST };
    AppMethodBeat.o(55360);
  }
  
  private WebSettings$TextSize(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebSettings.TextSize
 * JD-Core Version:    0.7.0.1
 */