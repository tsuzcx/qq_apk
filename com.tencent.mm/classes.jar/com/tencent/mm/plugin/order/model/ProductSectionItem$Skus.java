package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ProductSectionItem$Skus
  implements Parcelable
{
  public static final Parcelable.Creator<Skus> CREATER;
  public String key;
  public String value;
  
  static
  {
    AppMethodBeat.i(43788);
    CREATER = new ProductSectionItem.Skus.1();
    AppMethodBeat.o(43788);
  }
  
  public ProductSectionItem$Skus() {}
  
  public ProductSectionItem$Skus(Parcel paramParcel)
  {
    AppMethodBeat.i(43785);
    this.key = paramParcel.readString();
    this.value = paramParcel.readString();
    AppMethodBeat.o(43785);
  }
  
  public static String cr(List<Skus> paramList)
  {
    AppMethodBeat.i(43787);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(43787);
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
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(43787);
    return paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(43786);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.value);
    AppMethodBeat.o(43786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.ProductSectionItem.Skus
 * JD-Core Version:    0.7.0.1
 */