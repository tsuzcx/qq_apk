package com.tencent.mm.plugin.msgquote.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgQuoteItem
  implements Parcelable
{
  public static final Parcelable.Creator<MsgQuoteItem> CREATOR;
  public String content;
  public String eul;
  public int type;
  public long uVU;
  public String uVV;
  public String uVW;
  public String uVX;
  public String uVY;
  
  static
  {
    AppMethodBeat.i(117603);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117603);
  }
  
  public MsgQuoteItem() {}
  
  protected MsgQuoteItem(Parcel paramParcel)
  {
    AppMethodBeat.i(117602);
    this.type = paramParcel.readInt();
    this.uVU = paramParcel.readLong();
    this.uVV = paramParcel.readString();
    this.uVW = paramParcel.readString();
    this.uVX = paramParcel.readString();
    this.uVY = paramParcel.readString();
    this.content = paramParcel.readString();
    this.eul = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.uVU + ", fromusr='" + this.uVV + '\'' + ", chatuser='" + this.uVW + '\'' + ", displayname='" + this.uVX + '\'' + ", msgsource='" + this.uVY + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.eul + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.uVU);
    paramParcel.writeString(this.uVV);
    paramParcel.writeString(this.uVW);
    paramParcel.writeString(this.uVX);
    paramParcel.writeString(this.uVY);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.eul);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */