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
  public String IsC;
  public PayUBankcardElement IsE;
  
  public NetScenePayUElementQuery(String paramString)
  {
    AppMethodBeat.i(71975);
    this.IsC = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(71975);
  }
  
  public final int fPU()
  {
    return 22;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71976);
    this.IsE = new PayUBankcardElement();
    this.IsE.IsF = paramJSONObject.optString("bin");
    this.IsE.AOj = paramJSONObject.optString("bank_name");
    this.IsE.IsG = paramJSONObject.optString("issuer_type");
    this.IsE.cardType = paramJSONObject.optString("card_type");
    this.IsE.dRM = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(71976);
  }
  
  public static class PayUBankcardElement
    implements Parcelable
  {
    public String AOj = "";
    public String IsF = "";
    public String IsG = "";
    public String cardType = "";
    public String dRM = "";
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(71974);
      paramParcel.writeString(this.IsF);
      paramParcel.writeString(this.AOj);
      paramParcel.writeString(this.IsG);
      paramParcel.writeString(this.cardType);
      paramParcel.writeString(this.dRM);
      AppMethodBeat.o(71974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */