package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public int BvD;
  public int BvE;
  public String BvF;
  public String BvG;
  public String BvH;
  public int BvI;
  public ArrayList<String> BvJ;
  public String BvK;
  public String BvL;
  public String BvM;
  public String BvN;
  public String dAF;
  public String dAJ;
  public String dcz;
  public int nuJ;
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
    this.BvJ = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.BvJ = new ArrayList();
    this.nuJ = paramParcel.readInt();
    this.dcz = paramParcel.readString();
    this.BvD = paramParcel.readInt();
    this.BvE = paramParcel.readInt();
    this.BvF = paramParcel.readString();
    this.BvG = paramParcel.readString();
    this.BvH = paramParcel.readString();
    this.BvI = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.BvJ);
    this.BvK = paramParcel.readString();
    this.BvL = paramParcel.readString();
    this.BvM = paramParcel.readString();
    this.BvN = paramParcel.readString();
    this.dAF = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      g.agR().agA().set(ah.a.GSA, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    g.agR().agA().set(ah.a.GSA, "");
    AppMethodBeat.o(70264);
  }
  
  public static cma erf()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)g.agR().agA().get(ah.a.GSA, null);
    if (!bs.isNullOrNil((String)localObject)) {
      try
      {
        cma localcma = new cma();
        localObject = new JSONObject((String)localObject);
        localcma.DLr = ((JSONObject)localObject).optInt("guide_flag");
        localcma.unV = ((JSONObject)localObject).optString("guide_wording");
        localcma.unW = ((JSONObject)localObject).optString("left_button_wording");
        localcma.unX = ((JSONObject)localObject).optString("right_button_wording");
        localcma.unY = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localcma;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo erg()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)g.agR().agA().get(ah.a.GSA, null);
    if (!bs.isNullOrNil((String)localObject1)) {
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
          localECardInfo.dAF = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.BvJ = new ArrayList(localArrayList);
          localECardInfo.BvL = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.BvM = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.BvN = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.BvK = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.nuJ = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.dcz = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.BvD = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.BvE = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.BvF = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.BvG = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.BvH = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.BvI = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.dAJ = ((JSONObject)localObject2).optString("upload_credit_url", "");
          AppMethodBeat.o(70266);
          return localECardInfo;
        }
        AppMethodBeat.o(70266);
        return null;
      }
      catch (JSONException localJSONException)
      {
        ac.printErrStackTrace("MicroMsg.ECardInfo", localJSONException, "", new Object[0]);
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
    paramParcel.writeInt(this.nuJ);
    paramParcel.writeString(this.dcz);
    paramParcel.writeInt(this.BvD);
    paramParcel.writeInt(this.BvE);
    paramParcel.writeString(this.BvF);
    paramParcel.writeString(this.BvG);
    paramParcel.writeString(this.BvH);
    paramParcel.writeInt(this.BvI);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.BvJ);
    paramParcel.writeString(this.BvK);
    paramParcel.writeString(this.BvL);
    paramParcel.writeString(this.BvM);
    paramParcel.writeString(this.BvN);
    paramParcel.writeString(this.dAF);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */