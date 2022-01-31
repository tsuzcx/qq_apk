package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ProductSectionItem$Skus
  implements Parcelable
{
  public static final Parcelable.Creator<Skus> CREATER = new ProductSectionItem.Skus.1();
  public String key;
  public String value;
  
  public ProductSectionItem$Skus() {}
  
  public ProductSectionItem$Skus(Parcel paramParcel)
  {
    this.key = paramParcel.readString();
    this.value = paramParcel.readString();
  }
  
  public static String bT(List<Skus> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      Skus localSkus = (Skus)paramList.get(i);
      if (i != 0) {
        localStringBuilder.append("、");
      }
      localStringBuilder.append(localSkus.value);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.ProductSectionItem.Skus
 * JD-Core Version:    0.7.0.1
 */