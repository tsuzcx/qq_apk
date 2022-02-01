package com.tencent.trtc;

import java.util.ArrayList;

public class TRTCStatistics
{
  public int appCpu;
  public int downLoss;
  public ArrayList<TRTCLocalStatistics> localArray;
  public long receiveBytes;
  public ArrayList<TRTCRemoteStatistics> remoteArray;
  public int rtt;
  public long sendBytes;
  public int systemCpu;
  public int upLoss;
  
  public static class TRTCLocalStatistics
  {
    public int audioBitrate;
    public int audioCaptureState;
    public int audioSampleRate;
    public int frameRate;
    public int height;
    public int streamType;
    public int videoBitrate;
    public int width;
  }
  
  public static class TRTCRemoteStatistics
  {
    public int audioBitrate;
    public int audioBlockRate;
    public int audioSampleRate;
    public int audioTotalBlockTime;
    public int finalLoss;
    public int frameRate;
    public int height;
    public int jitterBufferDelay;
    public int point2PointDelay;
    public int streamType;
    public String userId;
    public int videoBitrate;
    public int videoBlockRate;
    public int videoTotalBlockTime;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.trtc.TRTCStatistics
 * JD-Core Version:    0.7.0.1
 */