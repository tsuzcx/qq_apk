package com.tencent.mm.plugin.msgquote.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgQuoteItem
  implements Parcelable
{
  public static final Parcelable.Creator<MsgQuoteItem> CREATOR;
  public long LgU;
  public String LgV;
  public String LgW;
  public String LgX;
  public String LgY;
  public String content;
  public String jUr;
  public int type;
  
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
    this.LgU = paramParcel.readLong();
    this.LgV = paramParcel.readString();
    this.LgW = paramParcel.readString();
    this.LgX = paramParcel.readString();
    this.LgY = paramParcel.readString();
    this.content = paramParcel.readString();
    this.jUr = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.LgU + ", fromusr='" + this.LgV + '\'' + ", chatuser='" + this.LgW + '\'' + ", displayname='" + this.LgX + '\'' + ", msgsource='" + this.LgY + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.jUr + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.LgU);
    paramParcel.writeString(this.LgV);
    paramParcel.writeString(this.LgW);
    paramParcel.writeString(this.LgX);
    paramParcel.writeString(this.LgY);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.jUr);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */