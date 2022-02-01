package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject
{
  public String duJ;
  public String qrY;
  public MallTransactionObject wRN;
  public b wRO;
  public ArrayList<ProductSectionItem> wRP;
  public List<a> wRQ;
  public List<MallOrderDetailObject.HelpCenter> wRR;
  int wRS;
  public String wRT;
  public String wRU;
  public int wRV;
  
  public MallOrderDetailObject()
  {
    AppMethodBeat.i(66651);
    this.wRR = new LinkedList();
    this.wRS = -1;
    AppMethodBeat.o(66651);
  }
  
  static ArrayList<ProductSectionItem> aJ(JSONObject paramJSONObject)
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
          localProductSectionItem.wTC = aK(localJSONObject);
          localProductSectionItem.count = localJSONObject.optInt("count");
          localProductSectionItem.wTD = localJSONObject.optString("price");
          localProductSectionItem.jumpUrl = localJSONObject.optString("jump_url");
          localProductSectionItem.wTE = localJSONObject.optString("pid");
          localProductSectionItem.scene = localJSONObject.optInt("scene");
          localArrayList.add(localProductSectionItem);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MallOrderDetailObject", localJSONException, "", new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MallOrderDetailObject", localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(66652);
    return localArrayList;
  }
  
  private static List<ProductSectionItem.Skus> aK(JSONObject paramJSONObject)
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
    public boolean oEA;
    public int type = 0;
    public String value;
  }
  
  public static final class b
  {
    public int heF;
    public String thumbUrl;
    public String uqf;
    public String wRW;
    public String wRX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject
 * JD-Core Version:    0.7.0.1
 */