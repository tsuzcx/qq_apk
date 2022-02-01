package com.tencent.mm.plugin.msgquote.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgQuoteItem
  implements Parcelable
{
  public static final Parcelable.Creator<MsgQuoteItem> CREATOR;
  public long FkS;
  public String FkT;
  public String FkU;
  public String FkV;
  public String FkW;
  public String content;
  public String hxy;
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
    this.FkS = paramParcel.readLong();
    this.FkT = paramParcel.readString();
    this.FkU = paramParcel.readString();
    this.FkV = paramParcel.readString();
    this.FkW = paramParcel.readString();
    this.content = paramParcel.readString();
    this.hxy = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.FkS + ", fromusr='" + this.FkT + '\'' + ", chatuser='" + this.FkU + '\'' + ", displayname='" + this.FkV + '\'' + ", msgsource='" + this.FkW + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.hxy + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.FkS);
    paramParcel.writeString(this.FkT);
    paramParcel.writeString(this.FkU);
    paramParcel.writeString(this.FkV);
    paramParcel.writeString(this.FkW);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.hxy);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */