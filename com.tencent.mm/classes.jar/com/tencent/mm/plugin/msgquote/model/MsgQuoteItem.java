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
  public String eNd;
  public int type;
  public long wlg;
  public String wlh;
  public String wli;
  public String wlj;
  public String wlk;
  
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
    this.wlg = paramParcel.readLong();
    this.wlh = paramParcel.readString();
    this.wli = paramParcel.readString();
    this.wlj = paramParcel.readString();
    this.wlk = paramParcel.readString();
    this.content = paramParcel.readString();
    this.eNd = paramParcel.readString();
    AppMethodBeat.o(117602);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117600);
    String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.wlg + ", fromusr='" + this.wlh + '\'' + ", chatuser='" + this.wli + '\'' + ", displayname='" + this.wlj + '\'' + ", msgsource='" + this.wlk + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.eNd + '\'' + '}';
    AppMethodBeat.o(117600);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117601);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.wlg);
    paramParcel.writeString(this.wlh);
    paramParcel.writeString(this.wli);
    paramParcel.writeString(this.wlj);
    paramParcel.writeString(this.wlk);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.eNd);
    AppMethodBeat.o(117601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.MsgQuoteItem
 * JD-Core Version:    0.7.0.1
 */