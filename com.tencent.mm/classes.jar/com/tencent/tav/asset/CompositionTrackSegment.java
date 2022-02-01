package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import java.net.URL;

public class CompositionTrackSegment
  extends AssetTrackSegment
{
  private String sourcePath;
  private int sourceTrackID;
  private int sourceType;
  private URL url;
  
  public CompositionTrackSegment(CMTimeRange paramCMTimeRange)
  {
    super(paramCMTimeRange, paramCMTimeRange);
    AppMethodBeat.i(188395);
    this.empty = true;
    AppMethodBeat.o(188395);
  }
  
  public CompositionTrackSegment(String paramString, int paramInt1, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, int paramInt2)
  {
    super(paramCMTimeRange1, paramCMTimeRange2);
    this.sourcePath = paramString;
    this.sourceType = paramInt2;
    this.sourceTrackID = paramInt1;
    this.empty = false;
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public int getSourceTrackID()
  {
    return this.sourceTrackID;
  }
  
  public int getSourceType()
  {
    return this.sourceType;
  }
  
  public URL getUrl()
  {
    return this.url;
  }
  
  public String toString()
  {
    AppMethodBeat.i(188400);
    String str = "CompositionTrackSegment{sourcePath='" + this.sourcePath + '\'' + ", sourceTrackID=" + this.sourceTrackID + ", timeMapping=" + this.timeMapping + '}';
    AppMethodBeat.o(188400);
    return str;
  }
  
  public void updateTargetTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(188397);
    this.scaleDuration = paramCMTimeRange.getDuration().clone();
    this.timeRange = paramCMTimeRange.clone();
    this.timeMapping.setTarget(paramCMTimeRange);
    AppMethodBeat.o(188397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.asset.CompositionTrackSegment
 * JD-Core Version:    0.7.0.1
 */