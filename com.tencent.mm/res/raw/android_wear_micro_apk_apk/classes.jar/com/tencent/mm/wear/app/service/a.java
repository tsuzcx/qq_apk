package com.tencent.mm.wear.app.service;

final class a
{
  public int ahN = 0;
  public int ahO = 0;
  public long lastUpdateTime = System.currentTimeMillis();
  
  public final void T(String paramString)
  {
    paramString = paramString.split("@");
    if (paramString.length == 3) {}
    try
    {
      this.lastUpdateTime = Long.valueOf(paramString[0]).longValue();
      this.ahN = Integer.valueOf(paramString[1]).intValue();
      this.ahO = Integer.valueOf(paramString[2]).intValue();
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public final String toString()
  {
    return this.lastUpdateTime + "@" + this.ahN + "@" + this.ahO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.a
 * JD-Core Version:    0.7.0.1
 */