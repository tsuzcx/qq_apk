package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject
{
  public String dia;
  public String pHO;
  public MallTransactionObject vwI;
  public b vwJ;
  public ArrayList<ProductSectionItem> vwK;
  public List<a> vwL;
  public List<HelpCenter> vwM;
  int vwN;
  public String vwO;
  public String vwP;
  public int vwQ;
  
  public MallOrderDetailObject()
  {
    AppMethodBeat.i(66651);
    this.vwM = new LinkedList();
    this.vwN = -1;
    AppMethodBeat.o(66651);
  }
  
  static ArrayList<ProductSectionItem> aA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66652);
    paramJSONObject = paramJSONObject.getJSONObject("product_section");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(66652);
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONArray("items");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(66652);
      return null;
    }
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
          localProductSectionItem.vyx = aB(localJSONObject);
          localProductSectionItem.count = localJSONObject.optInt("count");
          localProductSectionItem.vyy = localJSONObject.optString("price");
          localProductSectionItem.jumpUrl = localJSONObject.optString("jump_url");
          localProductSectionItem.vyz = localJSONObject.optString("pid");
          localProductSectionItem.scene = localJSONObject.optInt("scene");
          localArrayList.add(localProductSectionItem);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.MallOrderDetailObject", localJSONException, "", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.MallOrderDetailObject", localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(66652);
    return localArrayList;
  }
  
  private static List<ProductSectionItem.Skus> aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66653);
    paramJSONObject = paramJSONObject.getJSONArray("skus");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(66653);
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
    AppMethodBeat.o(66653);
    return localArrayList;
  }
  
  public static class HelpCenter
    implements Parcelable
  {
    public static final Parcelable.Creator<HelpCenter> CREATOR;
    public boolean daU;
    public String name;
    public String url;
    
    static
    {
      AppMethodBeat.i(66650);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(66650);
    }
    
    protected HelpCenter() {}
    
    protected HelpCenter(Parcel paramParcel)
    {
      AppMethodBeat.i(66648);
      this.name = paramParcel.readString();
      this.url = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.daU = bool;
        AppMethodBeat.o(66648);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(66649);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.url);
      if (this.daU) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(66649);
        return;
      }
    }
  }
  
  public static final class a
  {
    public int jumpType;
    public String jumpUrl;
    public boolean nUD;
    public String name;
    public int type = 0;
    public String value;
  }
  
  public static final class b
  {
    public int gIh;
    public String thh;
    public String thumbUrl;
    public String vwR;
    public String vwS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject
 * JD-Core Version:    0.7.0.1
 */