package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class y
  extends s
{
  public float borderWidth;
  public List<y.a> itemList = new ArrayList();
  public String oDM = "";
  public String oDN = "";
  public int oDO;
  public int oDP;
  public int oDQ;
  public int oDR;
  public String oDS = "";
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label59:
    label117:
    do
    {
      return true;
      if (!(paramObject instanceof y)) {
        break label202;
      }
      paramObject = (y)paramObject;
      if (paramObject.oDM != null) {
        break label133;
      }
      if (this.oDM != null) {
        break;
      }
      if (paramObject.borderWidth != this.borderWidth) {
        break;
      }
      if (paramObject.oDN != null) {
        break label150;
      }
      if (this.oDN != null) {
        break;
      }
      if ((paramObject.oDO != this.oDO) || (paramObject.oDP != this.oDP) || (paramObject.oDQ != this.oDQ) || (paramObject.oDR != this.oDR)) {
        break;
      }
      if (paramObject.itemList != null) {
        break label167;
      }
      if (this.itemList != null) {
        break;
      }
      if (paramObject.oDS != null) {
        break label186;
      }
    } while (this.oDS == null);
    label133:
    label150:
    label167:
    label186:
    while (!paramObject.oDS.equals(this.oDS))
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (!paramObject.oDM.equals(this.oDM));
          break;
        } while (!paramObject.oDN.equals(this.oDN));
        break label59;
      } while (!paramObject.itemList.equals(this.itemList));
      break label117;
    }
    return true;
    label202:
    return false;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y
 * JD-Core Version:    0.7.0.1
 */