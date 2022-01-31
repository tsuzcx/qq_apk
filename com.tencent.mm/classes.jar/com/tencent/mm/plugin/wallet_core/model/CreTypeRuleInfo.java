package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreTypeRuleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CreTypeRuleInfo> CREATOR;
  public int ugV;
  public CreExtInfo ugW;
  
  static
  {
    AppMethodBeat.i(46738);
    CREATOR = new CreTypeRuleInfo.1();
    AppMethodBeat.o(46738);
  }
  
  public CreTypeRuleInfo() {}
  
  protected CreTypeRuleInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46735);
    this.ugV = paramParcel.readInt();
    this.ugW = ((CreExtInfo)paramParcel.readParcelable(CreExtInfo.class.getClassLoader()));
    AppMethodBeat.o(46735);
  }
  
  public static CreTypeRuleInfo aA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46737);
    if (paramJSONObject != null)
    {
      CreTypeRuleInfo localCreTypeRuleInfo = new CreTypeRuleInfo();
      localCreTypeRuleInfo.ugV = paramJSONObject.optInt("support_cre_type", 0);
      localCreTypeRuleInfo.ugW = CreExtInfo.az(paramJSONObject.optJSONObject("cre_need_info"));
      AppMethodBeat.o(46737);
      return localCreTypeRuleInfo;
    }
    AppMethodBeat.o(46737);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46736);
    paramParcel.writeInt(this.ugV);
    paramParcel.writeParcelable(this.ugW, paramInt);
    AppMethodBeat.o(46736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo
 * JD-Core Version:    0.7.0.1
 */