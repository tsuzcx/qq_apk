package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public int HWQ;
  public int HWR;
  public String HWS;
  public String HWT;
  public String HWU;
  public int HWV;
  public ArrayList<String> HWW;
  public String HWX;
  public String HWY;
  public String HWZ;
  public String HXa;
  public String dGp;
  public String egd;
  public String egh;
  public int pmM;
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
    this.HWW = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.HWW = new ArrayList();
    this.pmM = paramParcel.readInt();
    this.dGp = paramParcel.readString();
    this.HWQ = paramParcel.readInt();
    this.HWR = paramParcel.readInt();
    this.HWS = paramParcel.readString();
    this.HWT = paramParcel.readString();
    this.HWU = paramParcel.readString();
    this.HWV = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.HWW);
    this.HWX = paramParcel.readString();
    this.HWY = paramParcel.readString();
    this.HWZ = paramParcel.readString();
    this.HXa = paramParcel.readString();
    this.egd = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void bF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      g.aAh().azQ().set(ar.a.Oik, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    g.aAh().azQ().set(ar.a.Oik, "");
    AppMethodBeat.o(70264);
  }
  
  public static dju fQp()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)g.aAh().azQ().get(ar.a.Oik, null);
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        dju localdju = new dju();
        localObject = new JSONObject((String)localObject);
        localdju.KCl = ((JSONObject)localObject).optInt("guide_flag");
        localdju.yXJ = ((JSONObject)localObject).optString("guide_wording");
        localdju.lHA = ((JSONObject)localObject).optString("left_button_wording");
        localdju.lHB = ((JSONObject)localObject).optString("right_button_wording");
        localdju.yXK = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localdju;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo fQq()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.Oik, null);
    if (!Util.isNullOrNil((String)localObject1)) {
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
          localECardInfo.egd = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.HWW = new ArrayList(localArrayList);
          localECardInfo.HWY = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.HWZ = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.HXa = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.HWX = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.pmM = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.dGp = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.HWQ = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.HWR = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.HWS = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.HWT = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.HWU = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.HWV = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.egh = ((JSONObject)localObject2).optString("upload_credit_url", "");
          AppMethodBeat.o(70266);
          return localECardInfo;
        }
        AppMethodBeat.o(70266);
        return null;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.ECardInfo", localJSONException, "", new Object[0]);
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
    paramParcel.writeInt(this.pmM);
    paramParcel.writeString(this.dGp);
    paramParcel.writeInt(this.HWQ);
    paramParcel.writeInt(this.HWR);
    paramParcel.writeString(this.HWS);
    paramParcel.writeString(this.HWT);
    paramParcel.writeString(this.HWU);
    paramParcel.writeInt(this.HWV);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.HWW);
    paramParcel.writeString(this.HWX);
    paramParcel.writeString(this.HWY);
    paramParcel.writeString(this.HWZ);
    paramParcel.writeString(this.HXa);
    paramParcel.writeString(this.egd);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */