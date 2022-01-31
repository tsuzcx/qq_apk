package com.tencent.mm.pluginsdk.model.app;

final class r
{
  public String appId;
  public int ezA;
  
  public r(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.ezA = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof r));
      paramObject = (r)paramObject;
    } while ((!paramObject.appId.equals(this.appId)) || (paramObject.ezA != this.ezA));
    return true;
  }
  
  public final String toString()
  {
    return this.appId + this.ezA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.r
 * JD-Core Version:    0.7.0.1
 */