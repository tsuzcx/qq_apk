package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TMAssistantDownloadTaskInfo$1
  implements Parcelable.Creator<TMAssistantDownloadTaskInfo>
{
  public final TMAssistantDownloadTaskInfo createFromParcel(Parcel paramParcel)
  {
    return new TMAssistantDownloadTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
  }
  
  public final TMAssistantDownloadTaskInfo[] newArray(int paramInt)
  {
    return new TMAssistantDownloadTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo.1
 * JD-Core Version:    0.7.0.1
 */