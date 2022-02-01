package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCPushStreamMsg
  extends JceStruct
{
  static StreamData cache_stStreamData;
  static StreamInfo cache_stStreamInfo;
  public long bubbleID = 0L;
  public long diyAddonId = 0L;
  public int iSeq = 0;
  public long lKey = 0L;
  public short shVersion = 0;
  public StreamData stStreamData = null;
  public StreamInfo stStreamInfo = null;
  public long subBubbleId = 0L;
  public long uPcQQStatus = 0L;
  
  public SCPushStreamMsg() {}
  
  public SCPushStreamMsg(short paramShort, int paramInt, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt;
    this.stStreamInfo = paramStreamInfo;
    this.stStreamData = paramStreamData;
    this.lKey = paramLong1;
    this.bubbleID = paramLong2;
    this.uPcQQStatus = paramLong3;
    this.subBubbleId = paramLong4;
    this.diyAddonId = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    if (cache_stStreamData == null) {
      cache_stStreamData = new StreamData();
    }
    this.stStreamData = ((StreamData)paramJceInputStream.read(cache_stStreamData, 3, true));
    this.lKey = paramJceInputStream.read(this.lKey, 4, true);
    this.bubbleID = paramJceInputStream.read(this.bubbleID, 5, false);
    this.uPcQQStatus = paramJceInputStream.read(this.uPcQQStatus, 6, false);
    this.subBubbleId = paramJceInputStream.read(this.subBubbleId, 7, false);
    this.diyAddonId = paramJceInputStream.read(this.diyAddonId, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.stStreamData, 3);
    paramJceOutputStream.write(this.lKey, 4);
    paramJceOutputStream.write(this.bubbleID, 5);
    paramJceOutputStream.write(this.uPcQQStatus, 6);
    paramJceOutputStream.write(this.subBubbleId, 7);
    paramJceOutputStream.write(this.diyAddonId, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.SCPushStreamMsg
 * JD-Core Version:    0.7.0.1
 */