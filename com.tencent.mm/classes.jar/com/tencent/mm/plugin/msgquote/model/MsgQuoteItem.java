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
  public String fqK;
  public int type;
  public long zFI;
  public String zFJ;
  public String zFK;
  public String zFL;
  public String zFM;
  
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
    this.zFI = paramParcel.readLong();
    this.zFJ = paramParcel.readString();
    this.zFK = paramParcel.readString();
    this.zFL = paramParcel.readString();
    this.zFM = paramParcel.readString();
    this.content = paramParcel.readString();
    this.fqK = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.zFI + ", fromusr='" + this.zFJ + '\'' + ", chatuser='" + this.zFK + '\'' + ", displayname='" + this.zFL + '\'' + ", msgsource='" + this.zFM + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.fqK + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.zFI);
    paramParcel.writeString(this.zFJ);
    paramParcel.writeString(this.zFK);
    paramParcel.writeString(this.zFL);
    paramParcel.writeString(this.zFM);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.fqK);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */