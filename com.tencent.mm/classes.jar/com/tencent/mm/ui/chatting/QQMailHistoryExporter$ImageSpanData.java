package com.tencent.mm.ui.chatting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQMailHistoryExporter$ImageSpanData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageSpanData> CREATOR = new Parcelable.Creator() {};
  int ebL;
  int endPos;
  String path;
  private int thumbnail = 0;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.ebL);
    paramParcel.writeInt(this.endPos);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.thumbnail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.QQMailHistoryExporter.ImageSpanData
 * JD-Core Version:    0.7.0.1
 */