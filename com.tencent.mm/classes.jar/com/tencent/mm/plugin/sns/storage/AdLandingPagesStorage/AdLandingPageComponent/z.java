package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;

public final class z
  implements Serializable
{
  public float height;
  public String iconUrl;
  public float oDj;
  public float width;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof z)) {
        break;
      }
      paramObject = (z)paramObject;
    } while ((paramObject.iconUrl.equals(this.iconUrl)) && (paramObject.width == this.width) && (paramObject.height == this.height) && (paramObject.oDj == this.oDj));
    return false;
    return false;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z
 * JD-Core Version:    0.7.0.1
 */