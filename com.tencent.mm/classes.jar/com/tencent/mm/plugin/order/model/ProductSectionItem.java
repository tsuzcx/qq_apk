package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem
  implements Parcelable
{
  public static final Parcelable.Creator<ProductSectionItem> CREATER;
  public int count;
  public String iconUrl;
  public String jumpUrl;
  public String name;
  public List<ProductSectionItem.Skus> pqB;
  public String pqC;
  public String pqD;
  public int scene;
  
  static
  {
    AppMethodBeat.i(43791);
    CREATER = new ProductSectionItem.1();
    AppMethodBeat.o(43791);
  }
  
  public ProductSectionItem() {}
  
  public ProductSectionItem(Parcel paramParcel)
  {
    AppMethodBeat.i(43789);
    this.iconUrl = paramParcel.readString();
    this.name = paramParcel.readString();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.pqB = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ProductSectionItem.Skus localSkus = new ProductSectionItem.Skus();
        localSkus.key = paramParcel.readString();
        localSkus.value = paramParcel.readString();
        this.pqB.add(localSkus);
        i += 1;
      }
    }
    this.count = paramParcel.readInt();
    this.pqC = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.pqD = paramParcel.readString();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(43789);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(43790);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.name);
    if (this.pqB != null)
    {
      paramParcel.writeInt(this.pqB.size());
      paramInt = 0;
      while (paramInt < this.pqB.size())
      {
        ProductSectionItem.Skus localSkus = (ProductSectionItem.Skus)this.pqB.get(paramInt);
        paramParcel.writeString(localSkus.key);
        paramParcel.writeString(localSkus.value);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeInt(this.count);
    paramParcel.writeString(this.pqC);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.pqD);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(43790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.ProductSectionItem
 * JD-Core Version:    0.7.0.1
 */