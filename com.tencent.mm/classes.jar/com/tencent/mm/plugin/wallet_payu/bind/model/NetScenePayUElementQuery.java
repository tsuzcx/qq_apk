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
  public String DJm;
  public PayUBankcardElement DJo;
  
  public NetScenePayUElementQuery(String paramString)
  {
    AppMethodBeat.i(71975);
    this.DJm = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(71975);
  }
  
  public final int eIr()
  {
    return 22;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71976);
    this.DJo = new PayUBankcardElement();
    this.DJo.DJp = paramJSONObject.optString("bin");
    this.DJo.wSo = paramJSONObject.optString("bank_name");
    this.DJo.DJq = paramJSONObject.optString("issuer_type");
    this.DJo.cardType = paramJSONObject.optString("card_type");
    this.DJo.dAa = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(71976);
  }
  
  public static class PayUBankcardElement
    implements Parcelable
  {
    public String DJp = "";
    public String DJq = "";
    public String cardType = "";
    public String dAa = "";
    public String wSo = "";
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(71974);
      paramParcel.writeString(this.DJp);
      paramParcel.writeString(this.wSo);
      paramParcel.writeString(this.DJq);
      paramParcel.writeString(this.cardType);
      paramParcel.writeString(this.dAa);
      AppMethodBeat.o(71974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */