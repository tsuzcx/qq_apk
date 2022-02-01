package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public String DnA;
  public String DnB;
  public String DnC;
  public int DnD;
  public ArrayList<String> DnE;
  public String DnF;
  public String DnG;
  public String DnH;
  public String DnI;
  public int Dny;
  public int Dnz;
  public String dOi;
  public String dOm;
  public String dpa;
  public int obQ;
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
    this.DnE = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.DnE = new ArrayList();
    this.obQ = paramParcel.readInt();
    this.dpa = paramParcel.readString();
    this.Dny = paramParcel.readInt();
    this.Dnz = paramParcel.readInt();
    this.DnA = paramParcel.readString();
    this.DnB = paramParcel.readString();
    this.DnC = paramParcel.readString();
    this.DnD = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.DnE);
    this.DnF = paramParcel.readString();
    this.DnG = paramParcel.readString();
    this.DnH = paramParcel.readString();
    this.DnI = paramParcel.readString();
    this.dOi = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void bf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      g.ajR().ajA().set(am.a.IZF, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    g.ajR().ajA().set(am.a.IZF, "");
    AppMethodBeat.o(70264);
  }
  
  public static cru eIM()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)g.ajR().ajA().get(am.a.IZF, null);
    if (!bu.isNullOrNil((String)localObject)) {
      try
      {
        cru localcru = new cru();
        localObject = new JSONObject((String)localObject);
        localcru.FIU = ((JSONObject)localObject).optInt("guide_flag");
        localcru.vCG = ((JSONObject)localObject).optString("guide_wording");
        localcru.kCZ = ((JSONObject)localObject).optString("left_button_wording");
        localcru.kDa = ((JSONObject)localObject).optString("right_button_wording");
        localcru.vCH = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localcru;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo eIN()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)g.ajR().ajA().get(am.a.IZF, null);
    if (!bu.isNullOrNil((String)localObject1)) {
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
          localECardInfo.dOi = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.DnE = new ArrayList(localArrayList);
          localECardInfo.DnG = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.DnH = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.DnI = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.DnF = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.obQ = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.dpa = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.Dny = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.Dnz = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.DnA = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.DnB = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.DnC = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.DnD = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.dOm = ((JSONObject)localObject2).optString("upload_credit_url", "");
          AppMethodBeat.o(70266);
          return localECardInfo;
        }
        AppMethodBeat.o(70266);
        return null;
      }
      catch (JSONException localJSONException)
      {
        ae.printErrStackTrace("MicroMsg.ECardInfo", localJSONException, "", new Object[0]);
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
    paramParcel.writeInt(this.obQ);
    paramParcel.writeString(this.dpa);
    paramParcel.writeInt(this.Dny);
    paramParcel.writeInt(this.Dnz);
    paramParcel.writeString(this.DnA);
    paramParcel.writeString(this.DnB);
    paramParcel.writeString(this.DnC);
    paramParcel.writeInt(this.DnD);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.DnE);
    paramParcel.writeString(this.DnF);
    paramParcel.writeString(this.DnG);
    paramParcel.writeString(this.DnH);
    paramParcel.writeString(this.DnI);
    paramParcel.writeString(this.dOi);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */