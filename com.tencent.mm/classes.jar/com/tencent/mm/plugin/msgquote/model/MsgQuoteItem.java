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
  public String esh;
  public long tNr;
  public String tNs;
  public String tNt;
  public String tNu;
  public String tNv;
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
    this.tNr = paramParcel.readLong();
    this.tNs = paramParcel.readString();
    this.tNt = paramParcel.readString();
    this.tNu = paramParcel.readString();
    this.tNv = paramParcel.readString();
    this.content = paramParcel.readString();
    this.esh = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.tNr + ", fromusr='" + this.tNs + '\'' + ", chatuser='" + this.tNt + '\'' + ", displayname='" + this.tNu + '\'' + ", msgsource='" + this.tNv + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.esh + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.tNr);
    paramParcel.writeString(this.tNs);
    paramParcel.writeString(this.tNt);
    paramParcel.writeString(this.tNu);
    paramParcel.writeString(this.tNv);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.esh);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */