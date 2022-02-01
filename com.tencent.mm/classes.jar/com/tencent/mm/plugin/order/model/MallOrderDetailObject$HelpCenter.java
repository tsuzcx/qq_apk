package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallOrderDetailObject$HelpCenter
  implements Parcelable
{
  public static final Parcelable.Creator<HelpCenter> CREATOR;
  public boolean dEF;
  public String name;
  public String url;
  
  static
  {
    AppMethodBeat.i(66650);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66650);
  }
  
  protected MallOrderDetailObject$HelpCenter() {}
  
  protected MallOrderDetailObject$HelpCenter(Parcel paramParcel)
  {
    AppMethodBeat.i(66648);
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.dEF = bool;
      AppMethodBeat.o(66648);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(66649);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    if (this.dEF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(66649);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter
 * JD-Core Version:    0.7.0.1
 */