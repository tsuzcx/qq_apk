package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery
  extends a
{
  public String DrH;
  public PayUBankcardElement DrJ;
  
  public NetScenePayUElementQuery(String paramString)
  {
    AppMethodBeat.i(71975);
    this.DrH = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(71975);
  }
  
  public final int eEK()
  {
    return 22;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71976);
    this.DrJ = new PayUBankcardElement();
    this.DrJ.DrK = paramJSONObject.optString("bin");
    this.DrJ.wCD = paramJSONObject.optString("bank_name");
    this.DrJ.DrL = paramJSONObject.optString("issuer_type");
    this.DrJ.cardType = paramJSONObject.optString("card_type");
    this.DrJ.dyV = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(71976);
  }
  
  public static class PayUBankcardElement
    implements Parcelable
  {
    public String DrK = "";
    public String DrL = "";
    public String cardType = "";
    public String dyV = "";
    public String wCD = "";
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(71974);
      paramParcel.writeString(this.DrK);
      paramParcel.writeString(this.wCD);
      paramParcel.writeString(this.DrL);
      paramParcel.writeString(this.cardType);
      paramParcel.writeString(this.dyV);
      AppMethodBeat.o(71974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */