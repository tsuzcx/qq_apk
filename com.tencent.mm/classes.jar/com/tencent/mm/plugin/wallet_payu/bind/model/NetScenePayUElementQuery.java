package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery
  extends a
{
  public PayUBankcardElement WcA;
  public String Wcw;
  
  public NetScenePayUElementQuery(String paramString)
  {
    AppMethodBeat.i(71975);
    this.Wcw = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(71975);
  }
  
  public final int ihO()
  {
    return 22;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71976);
    this.WcA = new PayUBankcardElement();
    this.WcA.WcB = paramJSONObject.optString("bin");
    this.WcA.MEo = paramJSONObject.optString("bank_name");
    this.WcA.WcC = paramJSONObject.optString("issuer_type");
    this.WcA.cardType = paramJSONObject.optString("card_type");
    this.WcA.hQR = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(71976);
  }
  
  public static class PayUBankcardElement
    implements Parcelable
  {
    public String MEo = "";
    public String WcB = "";
    public String WcC = "";
    public String cardType = "";
    public String hQR = "";
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(71974);
      paramParcel.writeString(this.WcB);
      paramParcel.writeString(this.MEo);
      paramParcel.writeString(this.WcC);
      paramParcel.writeString(this.cardType);
      paramParcel.writeString(this.hQR);
      AppMethodBeat.o(71974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */