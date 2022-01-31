package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public String query;
  public WidgetData.Info uKA;
  public WidgetData.Style uKB;
  public int uKC;
  public String uKD;
  public WidgetData.MoreFooter uKz;
  
  static
  {
    AppMethodBeat.i(124287);
    CREATOR = new WidgetData.1();
    AppMethodBeat.o(124287);
  }
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    AppMethodBeat.i(124286);
    this.uKz = ((WidgetData.MoreFooter)paramParcel.readParcelable(WidgetData.MoreFooter.class.getClassLoader()));
    this.uKA = ((WidgetData.Info)paramParcel.readParcelable(WidgetData.Info.class.getClassLoader()));
    this.uKB = ((WidgetData.Style)paramParcel.readParcelable(WidgetData.Style.class.getClassLoader()));
    this.uKC = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.uKD = paramParcel.readString();
    AppMethodBeat.o(124286);
  }
  
  public static WidgetData agA(String paramString)
  {
    AppMethodBeat.i(124284);
    if ((paramString == null) || (paramString.length() == 0))
    {
      d.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(124284);
      return null;
    }
    WidgetData localWidgetData = cZU();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.uKA.cwc = paramString.optString("appid");
        localWidgetData.uKA.version = paramString.optInt("version");
        localWidgetData.uKA.blZ = paramString.optString("nickName");
        localWidgetData.uKA.userName = paramString.optString("username");
        localWidgetData.uKA.fqf = paramString.optString("srcAppid");
        localWidgetData.uKA.uKE = paramString.optString("inputData");
        localWidgetData.uKA.cmG = paramString.optString("pagePath");
        localWidgetData.uKA.uKF = paramString.optString("wxaData");
        localWidgetData.uKA.uKG = paramString.optString("launchwxawidget");
        localWidgetData.uKA.fmF = bo.apV(paramString.optString("serviceType"));
        Object localObject = localWidgetData.uKA;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((WidgetData.Info)localObject).uKH = i;
          localWidgetData.uKA.hng = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.uKA.uKK = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.uKB;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((WidgetData.Style)localObject).uKQ = i;
            localWidgetData.uKB.height = paramString.optInt("height");
            localWidgetData.uKB.width = paramString.optInt("width");
            localWidgetData.uKB.hhh = paramString.optString("backgroundColor");
            localObject = localWidgetData.uKB;
            if (!paramString.has("minHeight")) {
              break label498;
            }
            d = paramString.optDouble("minHeight");
            ((WidgetData.Style)localObject).uKP = d;
            localWidgetData.uKB.offsetX = paramString.optInt("offsetX");
            localWidgetData.uKB.offsetY = paramString.optInt("offsetY");
            localObject = localWidgetData.uKB;
            if (!paramString.has("show")) {
              break label503;
            }
            bool = paramString.optBoolean("show");
            ((WidgetData.Style)localObject).cIy = bool;
            AppMethodBeat.o(124284);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          d.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        d.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
        AppMethodBeat.o(124284);
        return null;
      }
      continue;
      label498:
      double d = 0.0D;
      continue;
      label503:
      boolean bool = true;
    }
  }
  
  private static WidgetData cZU()
  {
    AppMethodBeat.i(124283);
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.uKA = new WidgetData.Info();
    localWidgetData.uKB = new WidgetData.Style();
    AppMethodBeat.o(124283);
    return localWidgetData;
  }
  
  public static WidgetData l(JSONObject paramJSONObject, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(124282);
    WidgetData localWidgetData = cZU();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("boxInfo").getJSONObject("providerInfo");
        if (localJSONObject == null)
        {
          AppMethodBeat.o(124282);
          return null;
        }
        localWidgetData.uKA.cwc = paramJSONObject.optString("appID");
        localWidgetData.uKA.version = paramJSONObject.optInt("appVersion");
        localWidgetData.uKA.uKI = paramJSONObject.optString("docID");
        localWidgetData.uKA.iconUrl = paramJSONObject.optString("iconUrl");
        localWidgetData.uKA.blZ = paramJSONObject.optString("nickName");
        localWidgetData.uKA.userName = paramJSONObject.optString("username");
        Object localObject1 = URLEncoder.encode(localJSONObject.optString("widgetData"));
        localWidgetData.uKA.uKE = "widgetData=".concat(String.valueOf(localObject1));
        localWidgetData.uKA.cmG = (localJSONObject.optString("jumpUrl") + "&" + localWidgetData.uKA.uKE);
        localWidgetData.uKA.uKF = localJSONObject.optString("wxaData");
        localWidgetData.uKA.fmF = localJSONObject.optInt("type");
        try
        {
          localObject1 = localJSONObject.optString("relay_info");
          if (localObject1 != null)
          {
            localObject1 = new JSONObject((String)localObject1);
            localWidgetData.uKA.uKJ = ((JSONObject)localObject1).optString("widget_stat_buffer");
            localWidgetData.uKA.downloadUrl = ((JSONObject)localObject1).optString("downloadurl");
            localWidgetData.uKA.uKG = ((JSONObject)localObject1).optString("launchwxawidget");
            localWidgetData.uKA.uKH = ((JSONObject)localObject1).optInt("widget_version_type");
            localWidgetData.uKA.fqf = ((JSONObject)localObject1).optString("appid");
            Object localObject2 = ((JSONObject)localObject1).optJSONArray("widget_labels");
            if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
              continue;
            }
            localWidgetData.uKA.label = ((JSONArray)localObject2).optString(0);
            localObject2 = localWidgetData.uKA;
            if (((JSONObject)localObject1).optInt("need_localsearch_footer") != 1) {
              break label672;
            }
            bool = true;
            ((WidgetData.Info)localObject2).uKM = bool;
            localWidgetData.uKA.uKL = ((JSONObject)localObject1).optString("localsearch_header");
            localWidgetData.uKA.kmN = ((JSONObject)localObject1).optString("localsearch_footer");
            localWidgetData.uKA.uKK = ((JSONObject)localObject1).optLong("openapp_permission");
            if (!((JSONObject)localObject1).has("footer")) {
              break label739;
            }
            localObject1 = ((JSONObject)localObject1).optJSONObject("footer");
            if (((JSONObject)localObject1).has("type")) {
              i = ((JSONObject)localObject1).optInt("type");
            }
            localWidgetData.uKC = i;
            switch (localWidgetData.uKC)
            {
            case 2: 
              d.w("WidgetData", "unknow footer type %d", new Object[] { Integer.valueOf(localWidgetData.uKC) });
            }
          }
        }
        catch (JSONException localJSONException)
        {
          d.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        localWidgetData.uKA.hng = paramString;
        localWidgetData.uKB.uKQ = paramJSONObject.optInt("maxHeight");
        localWidgetData.uKB.height = a.ar(ah.getContext(), localJSONObject.optInt("height"));
        localWidgetData.uKB.width = a.ar(ah.getContext(), localJSONObject.optInt("width"));
        AppMethodBeat.o(124282);
        return localWidgetData;
      }
      catch (JSONException paramJSONObject)
      {
        d.printErrStackTrace("WidgetData", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(124282);
        return null;
      }
      localWidgetData.uKA.label = null;
      continue;
      label672:
      boolean bool = false;
      continue;
      localWidgetData.uKz = new WidgetData.MoreFooter();
      localWidgetData.uKz.title = localJSONException.optString("title");
      localWidgetData.uKz.uKN = localJSONException.optString("username");
      localWidgetData.uKz.uKO = localJSONException.optString("jumpurl");
      continue;
      label739:
      localWidgetData.uKC = 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(124280);
    if (this == paramObject)
    {
      AppMethodBeat.o(124280);
      return true;
    }
    if (!(paramObject instanceof WidgetData))
    {
      AppMethodBeat.o(124280);
      return false;
    }
    paramObject = (WidgetData)paramObject;
    if ((this.uKC == paramObject.uKC) && (Objects.equals(this.uKz, paramObject.uKz)) && (Objects.equals(this.uKA, paramObject.uKA)) && (Objects.equals(this.uKB, paramObject.uKB)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.uKD, paramObject.uKD)))
    {
      AppMethodBeat.o(124280);
      return true;
    }
    AppMethodBeat.o(124280);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(124281);
    int i = Objects.hash(new Object[] { this.uKz, this.uKA, this.uKB, Integer.valueOf(this.uKC), this.query, this.uKD });
    AppMethodBeat.o(124281);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(124279);
    String str1;
    if (this.uKA == null)
    {
      str1 = "";
      if (this.uKB != null) {
        break label64;
      }
    }
    label64:
    for (String str2 = "";; str2 = this.uKB.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(124279);
      return str1;
      str1 = this.uKA.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124285);
    paramParcel.writeParcelable(this.uKz, paramInt);
    paramParcel.writeParcelable(this.uKA, paramInt);
    paramParcel.writeParcelable(this.uKB, paramInt);
    paramParcel.writeInt(this.uKC);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.uKD);
    AppMethodBeat.o(124285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */