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
  public List<Skus> APw;
  public String APx;
  public int count;
  public String iconUrl;
  public String jumpUrl;
  public String name;
  public String price;
  public int scene;
  
  static
  {
    AppMethodBeat.i(66699);
    CREATER = new Parcelable.Creator() {};
    AppMethodBeat.o(66699);
  }
  
  public ProductSectionItem() {}
  
  public ProductSectionItem(Parcel paramParcel)
  {
    AppMethodBeat.i(66697);
    this.iconUrl = paramParcel.readString();
    this.name = paramParcel.readString();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.APw = new ArrayList();
      int i = 0;
      while (i < j)
      {
        Skus localSkus = new Skus();
        localSkus.key = paramParcel.readString();
        localSkus.value = paramParcel.readString();
        this.APw.add(localSkus);
        i += 1;
      }
    }
    this.count = paramParcel.readInt();
    this.price = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.APx = paramParcel.readString();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(66697);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(66698);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.name);
    if (this.APw != null)
    {
      paramParcel.writeInt(this.APw.size());
      paramInt = 0;
      while (paramInt < this.APw.size())
      {
        Skus localSkus = (Skus)this.APw.get(paramInt);
        paramParcel.writeString(localSkus.key);
        paramParcel.writeString(localSkus.value);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeInt(this.count);
    paramParcel.writeString(this.price);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.APx);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(66698);
  }
  
  public static class Skus
    implements Parcelable
  {
    public static final Parcelable.Creator<Skus> CREATER;
    public String key;
    public String value;
    
    static
    {
      AppMethodBeat.i(66696);
      CREATER = new Parcelable.Creator() {};
      AppMethodBeat.o(66696);
    }
    
    public Skus() {}
    
    public Skus(Parcel paramParcel)
    {
      AppMethodBeat.i(66693);
      this.key = paramParcel.readString();
      this.value = paramParcel.readString();
      AppMethodBeat.o(66693);
    }
    
    public static String fJ(List<Skus> paramList)
    {
      AppMethodBeat.i(66695);
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(66695);
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
      AppMethodBeat.o(66695);
      return paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(66694);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      AppMethodBeat.o(66694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.ProductSectionItem
 * JD-Core Version:    0.7.0.1
 */