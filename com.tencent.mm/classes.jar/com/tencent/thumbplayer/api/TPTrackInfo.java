package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPTrackInfo
{
  public static final int TP_MEDIA_TRACK_TYPE_AUDIO = 2;
  public static final int TP_MEDIA_TRACK_TYPE_SUBTITLE = 3;
  public static final int TP_MEDIA_TRACK_TYPE_UNKNOW = 0;
  public static final int TP_MEDIA_TRACK_TYPE_VIDEO = 1;
  public boolean isExclusive = true;
  public boolean isInternal = true;
  public boolean isSelected = false;
  public String name = "";
  public int trackType = 0;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189049);
    if ((paramObject == null) || (!(paramObject instanceof TPTrackInfo)))
    {
      AppMethodBeat.o(189049);
      return false;
    }
    if ((this.name.equals(((TPTrackInfo)paramObject).name)) && (this.trackType == ((TPTrackInfo)paramObject).trackType))
    {
      AppMethodBeat.o(189049);
      return true;
    }
    AppMethodBeat.o(189049);
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getTrackType()
  {
    return this.trackType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPTrackInfo
 * JD-Core Version:    0.7.0.1
 */