package com.tencent.qqmusic.mediaplayer.audioplaylist;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TrackInfo
  extends AudioPlayListItemInfo
{
  public static final Parcelable.Creator<TrackInfo> CREATOR;
  private String mAlbum = "";
  private long mEndPostion;
  private String mPerformer = "";
  private long mStartPosition;
  private String mTitle = "";
  
  static
  {
    AppMethodBeat.i(103522);
    CREATOR = new Parcelable.Creator()
    {
      public final TrackInfo createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(103517);
        int i = paramAnonymousParcel.readInt();
        String str1 = paramAnonymousParcel.readString();
        String str2 = paramAnonymousParcel.readString();
        long l1 = paramAnonymousParcel.readLong();
        long l2 = paramAnonymousParcel.readLong();
        String str3 = paramAnonymousParcel.readString();
        paramAnonymousParcel = paramAnonymousParcel.readString();
        TrackInfo localTrackInfo = new TrackInfo(i);
        localTrackInfo.setFilePath(str1);
        localTrackInfo.setTitle(str2);
        localTrackInfo.setStartPosition(l1);
        localTrackInfo.setEndPostion(l2);
        localTrackInfo.setPerformer(str3);
        localTrackInfo.setAlbum(paramAnonymousParcel);
        AppMethodBeat.o(103517);
        return localTrackInfo;
      }
      
      public final TrackInfo[] newArray(int paramAnonymousInt)
      {
        return new TrackInfo[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(103522);
  }
  
  public TrackInfo(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAlbum()
  {
    return this.mAlbum;
  }
  
  public String getPerformer()
  {
    return this.mPerformer;
  }
  
  public Pair<Long, Long> getRange()
  {
    AppMethodBeat.i(103520);
    Pair localPair = new Pair(Long.valueOf(this.mStartPosition), Long.valueOf(this.mEndPostion));
    AppMethodBeat.o(103520);
    return localPair;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getUri()
  {
    return this.mUri;
  }
  
  public void setAlbum(String paramString)
  {
    this.mAlbum = paramString;
  }
  
  public void setEndPostion(long paramLong)
  {
    this.mEndPostion = paramLong;
  }
  
  public void setFilePath(String paramString)
  {
    this.mUri = paramString;
  }
  
  public void setPerformer(String paramString)
  {
    this.mPerformer = paramString;
  }
  
  public void setStartPosition(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103521);
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mUri);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeLong(this.mStartPosition);
    paramParcel.writeLong(this.mEndPostion);
    paramParcel.writeString(this.mPerformer);
    paramParcel.writeString(this.mAlbum);
    AppMethodBeat.o(103521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo
 * JD-Core Version:    0.7.0.1
 */