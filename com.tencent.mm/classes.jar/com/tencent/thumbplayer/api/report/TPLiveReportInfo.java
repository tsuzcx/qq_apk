package com.tencent.thumbplayer.api.report;

public class TPLiveReportInfo
  extends TPDefaultReportInfo
{
  public int adPlayLength;
  public String cdnServer;
  public int contentId;
  public boolean isLookBack;
  public boolean isUserPay;
  public int liveDelay;
  public int liveType;
  public int playTime;
  public int programId;
  public int streamId;
  
  public int getPlayType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.report.TPLiveReportInfo
 * JD-Core Version:    0.7.0.1
 */