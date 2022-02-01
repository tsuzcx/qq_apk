package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public int VEK;
  public int VEL;
  public String VEM;
  public String VEN;
  public String VEO;
  public int VEP;
  public ArrayList<String> VEQ;
  public String VER;
  public String VES;
  public String VET;
  public String VEU;
  public String hDJ;
  public String igC;
  public String igG;
  public String igN;
  public String title;
  public int vAZ;
  
  static
  {
    AppMethodBeat.i(70267);
    CREATOR = new ECardInfo.1();
    AppMethodBeat.o(70267);
  }
  
  public ECardInfo()
  {
    AppMethodBeat.i(70261);
    this.VEQ = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.VEQ = new ArrayList();
    this.vAZ = paramParcel.readInt();
    this.hDJ = paramParcel.readString();
    this.VEK = paramParcel.readInt();
    this.VEL = paramParcel.readInt();
    this.VEM = paramParcel.readString();
    this.VEN = paramParcel.readString();
    this.VEO = paramParcel.readString();
    this.VEP = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.VEQ);
    this.VER = paramParcel.readString();
    this.VES = paramParcel.readString();
    this.VET = paramParcel.readString();
    this.VEU = paramParcel.readString();
    this.igC = paramParcel.readString();
    this.igN = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void cl(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      h.baE().ban().set(at.a.acYl, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    h.baE().ban().set(at.a.acYl, "");
    AppMethodBeat.o(70264);
  }
  
  public static eme iij()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)h.baE().ban().get(at.a.acYl, null);
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        eme localeme = new eme();
        localObject = new JSONObject((String)localObject);
        localeme.YAF = ((JSONObject)localObject).optInt("guide_flag");
        localeme.KuO = ((JSONObject)localObject).optString("guide_wording");
        localeme.rGU = ((JSONObject)localObject).optString("left_button_wording");
        localeme.right_button_wording = ((JSONObject)localObject).optString("right_button_wording");
        localeme.KuP = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localeme;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo iik()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)h.baE().ban().get(at.a.acYl, null);
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
          localECardInfo.igC = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.igN = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.VEQ = new ArrayList(localArrayList);
          localECardInfo.VES = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.VET = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.VEU = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.VER = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.vAZ = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.hDJ = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.VEK = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.VEL = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.VEM = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.VEN = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.VEO = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.VEP = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.igG = ((JSONObject)localObject2).optString("upload_credit_url", "");
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
    paramParcel.writeInt(this.vAZ);
    paramParcel.writeString(this.hDJ);
    paramParcel.writeInt(this.VEK);
    paramParcel.writeInt(this.VEL);
    paramParcel.writeString(this.VEM);
    paramParcel.writeString(this.VEN);
    paramParcel.writeString(this.VEO);
    paramParcel.writeInt(this.VEP);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.VEQ);
    paramParcel.writeString(this.VER);
    paramParcel.writeString(this.VES);
    paramParcel.writeString(this.VET);
    paramParcel.writeString(this.VEU);
    paramParcel.writeString(this.igC);
    paramParcel.writeString(this.igN);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */