package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TMAssistantDownloadTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantDownloadTaskInfo> CREATOR;
  public String mContentType;
  public long mReceiveDataLen;
  public String mSavePath;
  public int mState;
  public long mTotalDataLen;
  public String mUrl;
  
  static
  {
    AppMethodBeat.i(75679);
    CREATOR = new TMAssistantDownloadTaskInfo.1();
    AppMethodBeat.o(75679);
  }
  
  public TMAssistantDownloadTaskInfo(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    this.mUrl = paramString1;
    this.mSavePath = paramString2;
    this.mState = paramInt;
    this.mReceiveDataLen = paramLong1;
    this.mTotalDataLen = paramLong2;
    this.mContentType = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(75678);
    if (this.mUrl != null)
    {
      paramParcel.writeString(this.mUrl);
      if (this.mSavePath == null) {
        break label82;
      }
      paramParcel.writeString(this.mSavePath);
    }
    for (;;)
    {
      paramParcel.writeInt(this.mState);
      paramParcel.writeLong(this.mReceiveDataLen);
      paramParcel.writeLong(this.mTotalDataLen);
      paramParcel.writeString(this.mContentType);
      AppMethodBeat.o(75678);
      return;
      paramParcel.writeString("");
      break;
      label82:
      paramParcel.writeString("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */