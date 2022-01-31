package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject
{
  public String bNZ;
  public String jEu;
  public List<HelpCenter> mOA = new LinkedList();
  int mOB = -1;
  public String mOC;
  public String mOD;
  public int mOE;
  public MallTransactionObject mOw;
  public MallOrderDetailObject.b mOx;
  public ArrayList<ProductSectionItem> mOy;
  public List<MallOrderDetailObject.a> mOz;
  
  static ArrayList<ProductSectionItem> Z(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("product_section");
    if (paramJSONObject == null) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONArray("items");
    } while ((paramJSONObject == null) || (paramJSONObject.length() == 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        ProductSectionItem localProductSectionItem = new ProductSectionItem();
        localProductSectionItem.iconUrl = localJSONObject.optString("icon_url");
        localProductSectionItem.name = localJSONObject.optString("name");
        try
        {
          localProductSectionItem.mQm = aa(localJSONObject);
          localProductSectionItem.count = localJSONObject.optInt("count");
          localProductSectionItem.mQn = localJSONObject.optString("price");
          localProductSectionItem.jumpUrl = localJSONObject.optString("jump_url");
          localProductSectionItem.mQo = localJSONObject.optString("pid");
          localProductSectionItem.scene = localJSONObject.optInt("scene");
          localArrayList.add(localProductSectionItem);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.MallOrderDetailObject", localJSONException, "", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.MallOrderDetailObject", localException, "", new Object[0]);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private static List<ProductSectionItem.Skus> aa(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("skus");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      ProductSectionItem.Skus localSkus = new ProductSectionItem.Skus();
      localSkus.key = localJSONObject.optString("key");
      localSkus.value = localJSONObject.optString("value");
      localArrayList.add(localSkus);
      i += 1;
    }
    return localArrayList;
  }
  
  public static class HelpCenter
    implements Parcelable
  {
    public static final Parcelable.Creator<HelpCenter> CREATOR = new MallOrderDetailObject.HelpCenter.1();
    public boolean bHj;
    public String name;
    public String url;
    
    protected HelpCenter() {}
    
    protected HelpCenter(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.url = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bHj = bool;
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.url);
      if (this.bHj) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject
 * JD-Core Version:    0.7.0.1
 */