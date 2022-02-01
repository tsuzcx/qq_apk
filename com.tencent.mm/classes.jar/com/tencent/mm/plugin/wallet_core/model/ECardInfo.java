package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECardInfo> CREATOR;
  public int Adj;
  public int Adk;
  public String Adl;
  public String Adm;
  public String Adn;
  public int Ado;
  public ArrayList<String> Adp;
  public String Adq;
  public String Adr;
  public String Ads;
  public String Adt;
  public String dCT;
  public String dCX;
  public String dfe;
  public int mSu;
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
    this.Adp = new ArrayList();
    AppMethodBeat.o(70261);
  }
  
  public ECardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70262);
    this.Adp = new ArrayList();
    this.mSu = paramParcel.readInt();
    this.dfe = paramParcel.readString();
    this.Adj = paramParcel.readInt();
    this.Adk = paramParcel.readInt();
    this.Adl = paramParcel.readString();
    this.Adm = paramParcel.readString();
    this.Adn = paramParcel.readString();
    this.Ado = paramParcel.readInt();
    this.title = paramParcel.readString();
    paramParcel.readStringList(this.Adp);
    this.Adq = paramParcel.readString();
    this.Adr = paramParcel.readString();
    this.Ads = paramParcel.readString();
    this.Adt = paramParcel.readString();
    this.dCT = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    AppMethodBeat.o(70262);
  }
  
  public static void aW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70264);
    if (paramJSONObject != null)
    {
      g.afB().afk().set(ae.a.FuG, paramJSONObject.toString());
      AppMethodBeat.o(70264);
      return;
    }
    g.afB().afk().set(ae.a.FuG, "");
    AppMethodBeat.o(70264);
  }
  
  public static cgx ebJ()
  {
    AppMethodBeat.i(70265);
    Object localObject = (String)g.afB().afk().get(ae.a.FuG, null);
    if (!bt.isNullOrNil((String)localObject)) {
      try
      {
        cgx localcgx = new cgx();
        localObject = new JSONObject((String)localObject);
        localcgx.Cta = ((JSONObject)localObject).optInt("guide_flag");
        localcgx.tfG = ((JSONObject)localObject).optString("guide_wording");
        localcgx.tfH = ((JSONObject)localObject).optString("left_button_wording");
        localcgx.tfI = ((JSONObject)localObject).optString("right_button_wording");
        localcgx.tfJ = ((JSONObject)localObject).optString("upload_credit_url");
        AppMethodBeat.o(70265);
        return localcgx;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ECardInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70265);
    return null;
  }
  
  public static ECardInfo ebK()
  {
    AppMethodBeat.i(70266);
    Object localObject1 = (String)g.afB().afk().get(ae.a.FuG, null);
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
          localECardInfo.dCT = ((JSONObject)localObject1).optString("guide_flag");
          localECardInfo.title = ((JSONObject)localObject1).optString("title");
          localECardInfo.subtitle = ((JSONObject)localObject1).optString("subtitle");
          localECardInfo.Adp = new ArrayList(localArrayList);
          localECardInfo.Adr = ((JSONObject)localObject1).optString("protocol_url");
          localECardInfo.Ads = ((JSONObject)localObject1).optString("left_protocol_wording");
          localECardInfo.Adt = ((JSONObject)localObject1).optString("right_protocol_wording");
          localECardInfo.Adq = ((JSONObject)localObject1).optString("done_button_wording");
          localECardInfo.mSu = ((JSONObject)localObject2).optInt("ecard_open_scene", 0);
          localECardInfo.dfe = ((JSONObject)localObject2).optString("ecard_type", "");
          localECardInfo.Adj = ((JSONObject)localObject2).optInt("show_check_box", 0);
          localECardInfo.Adk = ((JSONObject)localObject2).optInt("check_box_selected", 0);
          localECardInfo.Adl = ((JSONObject)localObject2).optString("check_box_left_wording", "");
          localECardInfo.Adm = ((JSONObject)localObject2).optString("check_box_right_wording", "");
          localECardInfo.Adn = ((JSONObject)localObject2).optString("check_box_url", "");
          localECardInfo.Ado = ((JSONObject)localObject2).optInt("is_upload_credid", 0);
          localECardInfo.dCX = ((JSONObject)localObject2).optString("upload_credit_url", "");
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
    paramParcel.writeInt(this.mSu);
    paramParcel.writeString(this.dfe);
    paramParcel.writeInt(this.Adj);
    paramParcel.writeInt(this.Adk);
    paramParcel.writeString(this.Adl);
    paramParcel.writeString(this.Adm);
    paramParcel.writeString(this.Adn);
    paramParcel.writeInt(this.Ado);
    paramParcel.writeString(this.title);
    paramParcel.writeStringList(this.Adp);
    paramParcel.writeString(this.Adq);
    paramParcel.writeString(this.Adr);
    paramParcel.writeString(this.Ads);
    paramParcel.writeString(this.Adt);
    paramParcel.writeString(this.dCT);
    paramParcel.writeString(this.subtitle);
    AppMethodBeat.o(70263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ECardInfo
 * JD-Core Version:    0.7.0.1
 */