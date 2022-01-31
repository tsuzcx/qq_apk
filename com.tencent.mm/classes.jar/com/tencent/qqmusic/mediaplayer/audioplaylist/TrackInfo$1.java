package com.tencent.qqmusic.mediaplayer.audioplaylist;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TrackInfo$1
  implements Parcelable.Creator<TrackInfo>
{
  public final TrackInfo createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(111090);
    int i = paramParcel.readInt();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    long l1 = paramParcel.readLong();
    long l2 = paramParcel.readLong();
    String str3 = paramParcel.readString();
    paramParcel = paramParcel.readString();
    TrackInfo localTrackInfo = new TrackInfo(i);
    localTrackInfo.setFilePath(str1);
    localTrackInfo.setTitle(str2);
    localTrackInfo.setStartPosition(l1);
    localTrackInfo.setEndPostion(l2);
    localTrackInfo.setPerformer(str3);
    localTrackInfo.setAlbum(paramParcel);
    AppMethodBeat.o(111090);
    return localTrackInfo;
  }
  
  public final TrackInfo[] newArray(int paramInt)
  {
    return new TrackInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo.1
 * JD-Core Version:    0.7.0.1
 */