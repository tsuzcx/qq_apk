package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject
{
  public String cvr;
  public String lNS;
  public MallTransactionObject poM;
  public MallOrderDetailObject.b poN;
  public ArrayList<ProductSectionItem> poO;
  public List<a> poP;
  public List<HelpCenter> poQ;
  int poR;
  public String poS;
  public String poT;
  public int poU;
  
  public MallOrderDetailObject()
  {
    AppMethodBeat.i(43743);
    this.poQ = new LinkedList();
    this.poR = -1;
    AppMethodBeat.o(43743);
  }
  
  static ArrayList<ProductSectionItem> ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43744);
    paramJSONObject = paramJSONObject.getJSONObject("product_section");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(43744);
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONArray("items");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(43744);
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
          localProductSectionItem.pqB = al(localJSONObject);
          localProductSectionItem.count = localJSONObject.optInt("count");
          localProductSectionItem.pqC = localJSONObject.optString("price");
          localProductSectionItem.jumpUrl = localJSONObject.optString("jump_url");
          localProductSectionItem.pqD = localJSONObject.optString("pid");
          localProductSectionItem.scene = localJSONObject.optInt("scene");
          localArrayList.add(localProductSectionItem);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", localJSONException, "", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MallOrderDetailObject", localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(43744);
    return localArrayList;
  }
  
  private static List<ProductSectionItem.Skus> al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43745);
    paramJSONObject = paramJSONObject.getJSONArray("skus");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      AppMethodBeat.o(43745);
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
    AppMethodBeat.o(43745);
    return localArrayList;
  }
  
  public static class HelpCenter
    implements Parcelable
  {
    public static final Parcelable.Creator<HelpCenter> CREATOR;
    public boolean coy;
    public String name;
    public String url;
    
    static
    {
      AppMethodBeat.i(43742);
      CREATOR = new MallOrderDetailObject.HelpCenter.1();
      AppMethodBeat.o(43742);
    }
    
    protected HelpCenter() {}
    
    protected HelpCenter(Parcel paramParcel)
    {
      AppMethodBeat.i(43740);
      this.name = paramParcel.readString();
      this.url = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.coy = bool;
        AppMethodBeat.o(43740);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(43741);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.url);
      if (this.coy) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(43741);
        return;
      }
    }
  }
  
  public static final class a
  {
    public int jumpType;
    public String jumpUrl;
    public boolean kmy;
    public String name;
    public int type = 0;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject
 * JD-Core Version:    0.7.0.1
 */