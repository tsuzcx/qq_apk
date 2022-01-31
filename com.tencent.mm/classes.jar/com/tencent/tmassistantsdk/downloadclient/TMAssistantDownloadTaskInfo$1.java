package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TMAssistantDownloadTaskInfo$1
  implements Parcelable.Creator<TMAssistantDownloadTaskInfo>
{
  public final TMAssistantDownloadTaskInfo createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(75675);
    paramParcel = new TMAssistantDownloadTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
    AppMethodBeat.o(75675);
    return paramParcel;
  }
  
  public final TMAssistantDownloadTaskInfo[] newArray(int paramInt)
  {
    return new TMAssistantDownloadTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo.1
 * JD-Core Version:    0.7.0.1
 */