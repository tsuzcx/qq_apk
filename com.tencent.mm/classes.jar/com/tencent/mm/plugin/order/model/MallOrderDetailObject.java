package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject
{
  public MallTransactionObject ANI;
  public b ANJ;
  public ArrayList<ProductSectionItem> ANK;
  public List<a> ANL;
  public List<MallOrderDetailObject.HelpCenter> ANM;
  int ANN;
  public String ANO;
  public String ANP;
  public int ANQ;
  public String appUserName;
  public String rJd;
  
  public MallOrderDetailObject()
  {
    AppMethodBeat.i(66651);
    this.ANM = new LinkedList();
    this.ANN = -1;
    AppMethodBeat.o(66651);
  }
  
  static ArrayList<ProductSectionItem> bf(JSONObject paramJSONObject)
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
          localProductSectionItem.APw = bg(localJSONObject);
          localProductSectionItem.count = localJSONObject.optInt("count");
          localProductSectionItem.price = localJSONObject.optString("price");
          localProductSectionItem.jumpUrl = localJSONObject.optString("jump_url");
          localProductSectionItem.APx = localJSONObject.optString("pid");
          localProductSectionItem.scene = localJSONObject.optInt("scene");
          localArrayList.add(localProductSectionItem);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", localJSONException, "", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(66652);
    return localArrayList;
  }
  
  private static List<ProductSectionItem.Skus> bg(JSONObject paramJSONObject)
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
  
  public static final class a
  {
    public int jumpType;
    public String jumpUrl;
    public String name;
    public boolean pSj;
    public int type = 0;
    public String value;
  }
  
  public static final class b
  {
    public String ANR;
    public String ANS;
    public int hXs;
    public String thumbUrl;
    public String xIy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject
 * JD-Core Version:    0.7.0.1
 */