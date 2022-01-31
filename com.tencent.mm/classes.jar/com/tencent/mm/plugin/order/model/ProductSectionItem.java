package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem
  implements Parcelable
{
  public static final Parcelable.Creator<ProductSectionItem> CREATER = new ProductSectionItem.1();
  public int count;
  public String iconUrl;
  public String jumpUrl;
  public List<ProductSectionItem.Skus> mQm;
  public String mQn;
  public String mQo;
  public String name;
  public int scene;
  
  public ProductSectionItem() {}
  
  public ProductSectionItem(Parcel paramParcel)
  {
    this.iconUrl = paramParcel.readString();
    this.name = paramParcel.readString();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.mQm = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ProductSectionItem.Skus localSkus = new ProductSectionItem.Skus();
        localSkus.key = paramParcel.readString();
        localSkus.value = paramParcel.readString();
        this.mQm.add(localSkus);
        i += 1;
      }
    }
    this.count = paramParcel.readInt();
    this.mQn = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.mQo = paramParcel.readString();
    this.scene = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.name);
    if (this.mQm != null)
    {
      paramParcel.writeInt(this.mQm.size());
      paramInt = 0;
      while (paramInt < this.mQm.size())
      {
        ProductSectionItem.Skus localSkus = (ProductSectionItem.Skus)this.mQm.get(paramInt);
        paramParcel.writeString(localSkus.key);
        paramParcel.writeString(localSkus.value);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeInt(this.count);
    paramParcel.writeString(this.mQn);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.mQo);
    paramParcel.writeInt(this.scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.ProductSectionItem
 * JD-Core Version:    0.7.0.1
 */