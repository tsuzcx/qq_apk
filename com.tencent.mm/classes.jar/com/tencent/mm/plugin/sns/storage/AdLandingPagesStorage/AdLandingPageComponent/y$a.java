package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

public final class y$a
{
  public String label = "";
  public String oDT = "";
  public float value;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        break;
      }
      paramObject = (a)paramObject;
    } while ((paramObject.label.equals(this.label)) && (paramObject.oDT.equals(this.oDT)) && (paramObject.value == this.value));
    return false;
    return false;
  }
  
  public final int hashCode()
  {
    return (int)(this.label.hashCode() + this.oDT.hashCode() + this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y.a
 * JD-Core Version:    0.7.0.1
 */