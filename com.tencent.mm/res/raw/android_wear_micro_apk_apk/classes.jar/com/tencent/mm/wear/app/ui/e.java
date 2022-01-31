package com.tencent.mm.wear.app.ui;

public enum e
{
  private int value = 0;
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static e bU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return aeT;
    case 1: 
      return aeU;
    case 2: 
      return aeV;
    case 3: 
      return aeW;
    }
    return aeX;
  }
  
  public final int value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.e
 * JD-Core Version:    0.7.0.1
 */