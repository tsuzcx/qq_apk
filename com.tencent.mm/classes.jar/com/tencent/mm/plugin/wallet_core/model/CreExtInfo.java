package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreExtInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreExtInfo> CREATOR;
  public int ugR;
  public int ugS;
  public int ugT;
  public int ugU;
  
  static
  {
    AppMethodBeat.i(46733);
    CREATOR = new CreExtInfo.1();
    AppMethodBeat.o(46733);
  }
  
  public CreExtInfo() {}
  
  protected CreExtInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46730);
    this.ugR = paramParcel.readInt();
    this.ugS = paramParcel.readInt();
    this.ugT = paramParcel.readInt();
    this.ugU = paramParcel.readInt();
    AppMethodBeat.o(46730);
  }
  
  public static CreExtInfo az(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46732);
    if (paramJSONObject != null)
    {
      CreExtInfo localCreExtInfo = new CreExtInfo();
      localCreExtInfo.ugR = paramJSONObject.optInt("need_creid_renewal", 0);
      localCreExtInfo.ugS = paramJSONObject.optInt("need_birth_date", 0);
      localCreExtInfo.ugT = paramJSONObject.optInt("need_cre_expire_date", 0);
      localCreExtInfo.ugU = paramJSONObject.optInt("need_show_cre_type", 0);
      AppMethodBeat.o(46732);
      return localCreExtInfo;
    }
    AppMethodBeat.o(46732);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46731);
    paramParcel.writeInt(this.ugR);
    paramParcel.writeInt(this.ugS);
    paramParcel.writeInt(this.ugT);
    paramParcel.writeInt(this.ugU);
    AppMethodBeat.o(46731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreExtInfo
 * JD-Core Version:    0.7.0.1
 */