package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dtj;
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
  public int OOQ;
  public int OOR;
  public String OOS;
  public String OOT;
  public String OOU;
  public int OOV;
  public ArrayList<String> OOW;
  public String OOX;
  public String OOY;
  public String OOZ;
  public String OPa;
  public String fza;
  public String gat;
  public String gax;
  public String subtitle;
  public int svv;
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
    this.OOW = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.OOW = new ArrayList();
    this.svv = paramParcel.readInt();
    this.fza = paramParcel.readString();
    this.OOQ = paramParcel.readInt();
    this.OOR = paramParcel.readInt();
    this.OOS = paramParcel.readString();
    this.OOT = paramParcel.readString();
    this.OOU = paramParcel.readString();
    this.OOV = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.OOW);
    this.OOX = paramParcel.readString();
    this.OOY = paramParcel.readString();
    this.OOZ = paramParcel.readString();
    this.OPa = paramParcel.readString();
    this.gat = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void bQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      h.aHG().aHp().set(ar.a.VwA, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    h.aHG().aHp().set(ar.a.VwA, "");
    AppMethodBeat.o(70264);
  }
  
  public static dtj gIV()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)h.aHG().aHp().get(ar.a.VwA, null);
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        dtj localdtj = new dtj();
        localObject = new JSONObject((String)localObject);
        localdtj.REc = ((JSONObject)localObject).optInt("guide_flag");
        localdtj.EBN = ((JSONObject)localObject).optString("guide_wording");
        localdtj.oDJ = ((JSONObject)localObject).optString("left_button_wording");
        localdtj.oDK = ((JSONObject)localObject).optString("right_button_wording");
        localdtj.EBO = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localdtj;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo gIW()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)h.aHG().aHp().get(ar.a.VwA, null);
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
          localECardInfo.gat = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.OOW = new ArrayList(localArrayList);
          localECardInfo.OOY = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.OOZ = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.OPa = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.OOX = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.svv = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.fza = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.OOQ = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.OOR = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.OOS = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.OOT = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.OOU = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.OOV = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.gax = ((JSONObject)localObject2).optString("upload_credit_url", "");
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
    paramParcel.writeInt(this.svv);
    paramParcel.writeString(this.fza);
    paramParcel.writeInt(this.OOQ);
    paramParcel.writeInt(this.OOR);
    paramParcel.writeString(this.OOS);
    paramParcel.writeString(this.OOT);
    paramParcel.writeString(this.OOU);
    paramParcel.writeInt(this.OOV);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.OOW);
    paramParcel.writeString(this.OOX);
    paramParcel.writeString(this.OOY);
    paramParcel.writeString(this.OOZ);
    paramParcel.writeString(this.OPa);
    paramParcel.writeString(this.gat);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */