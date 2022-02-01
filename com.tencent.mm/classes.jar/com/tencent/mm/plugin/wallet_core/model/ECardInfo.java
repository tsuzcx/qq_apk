package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public int CVS;
  public int CVT;
  public String CVU;
  public String CVW;
  public String CVX;
  public int CVY;
  public ArrayList<String> CVZ;
  public String CWa;
  public String CWb;
  public String CWc;
  public String CWd;
  public String dMS;
  public String dMW;
  public String dnV;
  public int nWh;
  public String subtitle;
  public String title;
  
  static
  {
    AppMethodBeat.i(70267);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70267);
  }
  
  public ECardInfo()
  {
    AppMethodBeat.i(70261);
    this.CVZ = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.CVZ = new ArrayList();
    this.nWh = paramParcel.readInt();
    this.dnV = paramParcel.readString();
    this.CVS = paramParcel.readInt();
    this.CVT = paramParcel.readInt();
    this.CVU = paramParcel.readString();
    this.CVW = paramParcel.readString();
    this.CVX = paramParcel.readString();
    this.CVY = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.CVZ);
    this.CWa = paramParcel.readString();
    this.CWb = paramParcel.readString();
    this.CWc = paramParcel.readString();
    this.CWd = paramParcel.readString();
    this.dMS = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void bf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      g.ajC().ajl().set(al.a.IFf, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    g.ajC().ajl().set(al.a.IFf, "");
    AppMethodBeat.o(70264);
  }
  
  public static cra eFf()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)g.ajC().ajl().get(al.a.IFf, null);
    if (!bt.isNullOrNil((String)localObject)) {
      try
      {
        cra localcra = new cra();
        localObject = new JSONObject((String)localObject);
        localcra.Fqw = ((JSONObject)localObject).optInt("guide_flag");
        localcra.vqB = ((JSONObject)localObject).optString("guide_wording");
        localcra.kzK = ((JSONObject)localObject).optString("left_button_wording");
        localcra.kzL = ((JSONObject)localObject).optString("right_button_wording");
        localcra.vqC = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localcra;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo eFg()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IFf, null);
    if (!bt.isNullOrNil((String)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optJSONArray("upload_reasons");
        ArrayList localArrayList = new ArrayList();
        if (localObject2 != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            localArrayList.add(((JSONArray)localObject2).optString(i));
            i += 1;
          }
        }
        if (((JSONObject)localObject1).has("ecard_info"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("ecard_info");
          ECardInfo localECardInfo = new ECardInfo();
          localECardInfo.dMS = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.CVZ = new ArrayList(localArrayList);
          localECardInfo.CWb = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.CWc = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.CWd = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.CWa = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.nWh = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.dnV = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.CVS = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.CVT = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.CVU = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.CVW = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.CVX = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.CVY = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.dMW = ((JSONObject)localObject2).optString("upload_credit_url", "");
          AppMethodBeat.o(70266);
          return localECardInfo;
        }
        AppMethodBeat.o(70266);
        return null;
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.ECardInfo", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70266);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70263);
    paramParcel.writeInt(this.nWh);
    paramParcel.writeString(this.dnV);
    paramParcel.writeInt(this.CVS);
    paramParcel.writeInt(this.CVT);
    paramParcel.writeString(this.CVU);
    paramParcel.writeString(this.CVW);
    paramParcel.writeString(this.CVX);
    paramParcel.writeInt(this.CVY);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.CVZ);
    paramParcel.writeString(this.CWa);
    paramParcel.writeString(this.CWb);
    paramParcel.writeString(this.CWc);
    paramParcel.writeString(this.CWd);
    paramParcel.writeString(this.dMS);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */