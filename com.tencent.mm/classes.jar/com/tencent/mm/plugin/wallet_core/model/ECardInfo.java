package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public String cLV;
  public String cLZ;
  public String cqh;
  public int kbq;
  public String subtitle;
  public String title;
  public int uhc;
  public int uhd;
  public String uhe;
  public String uhf;
  public String uhg;
  public int uhh;
  public ArrayList<String> uhi;
  public String uhj;
  public String uhk;
  public String uhl;
  public String uhm;
  
  static
  {
    AppMethodBeat.i(46750);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46750);
  }
  
  public ECardInfo()
  {
    AppMethodBeat.i(46744);
    this.uhi = new ArrayList();
    AppMethodBeat.o(46744);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46745);
    this.uhi = new ArrayList();
    this.kbq = paramParcel.readInt();
    this.cqh = paramParcel.readString();
    this.uhc = paramParcel.readInt();
    this.uhd = paramParcel.readInt();
    this.uhe = paramParcel.readString();
    this.uhf = paramParcel.readString();
    this.uhg = paramParcel.readString();
    this.uhh = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.uhi);
    this.uhj = paramParcel.readString();
    this.uhk = paramParcel.readString();
    this.uhl = paramParcel.readString();
    this.uhm = paramParcel.readString();
    this.cLV = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(46745);
  }
  
  public static void aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46747);
    if (paramJSONObject != null)
    {
      g.RL().Ru().set(ac.a.yLl, paramJSONObject.toString());
      AppMethodBeat.o(46747);
      return;
    }
    g.RL().Ru().set(ac.a.yLl, "");
    AppMethodBeat.o(46747);
  }
  
  public static bry cTt()
  {
    AppMethodBeat.i(46748);
    Object localObject = (String)g.RL().Ru().get(ac.a.yLl, null);
    if (!bo.isNullOrNil((String)localObject)) {
      try
      {
        bry localbry = new bry();
        localObject = new JSONObject((String)localObject);
        localbry.wkQ = ((JSONObject)localObject).optInt("guide_flag");
        localbry.opB = ((JSONObject)localObject).optString("guide_wording");
        localbry.opC = ((JSONObject)localObject).optString("left_button_wording");
        localbry.opD = ((JSONObject)localObject).optString("right_button_wording");
        localbry.opE = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(46748);
        return localbry;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46748);
    return null;
  }
  
  public static ECardInfo cTu()
  {
    AppMethodBeat.i(46749);
    Object localObject1 = (String)g.RL().Ru().get(ac.a.yLl, null);
    if (!bo.isNullOrNil((String)localObject1)) {
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
          localECardInfo.cLV = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.uhi = new ArrayList(localArrayList);
          localECardInfo.uhk = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.uhl = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.uhm = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.uhj = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.kbq = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.cqh = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.uhc = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.uhd = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.uhe = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.uhf = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.uhg = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.uhh = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.cLZ = ((JSONObject)localObject2).optString("upload_credit_url", "");
          AppMethodBeat.o(46749);
          return localECardInfo;
        }
        AppMethodBeat.o(46749);
        return null;
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.ECardInfo", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46749);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46746);
    paramParcel.writeInt(this.kbq);
    paramParcel.writeString(this.cqh);
    paramParcel.writeInt(this.uhc);
    paramParcel.writeInt(this.uhd);
    paramParcel.writeString(this.uhe);
    paramParcel.writeString(this.uhf);
    paramParcel.writeString(this.uhg);
    paramParcel.writeInt(this.uhh);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.uhi);
    paramParcel.writeString(this.uhj);
    paramParcel.writeString(this.uhk);
    paramParcel.writeString(this.uhl);
    paramParcel.writeString(this.uhm);
    paramParcel.writeString(this.cLV);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(46746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */