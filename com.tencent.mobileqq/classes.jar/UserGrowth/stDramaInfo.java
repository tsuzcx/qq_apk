package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDramaInfo
  extends JceStruct
{
  public String coverImg = "";
  public int curPublishedFeedNum = 0;
  public String curWatchedFeedID = "";
  public int curWatchedFeedNum = 0;
  public String id = "";
  public boolean isFollowed = true;
  public boolean isPublishCompleted = true;
  public String name = "";
  public long playCount = 0L;
  public String recmdDesc = "";
  public String tag = "";
  
  public stDramaInfo() {}
  
  public stDramaInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2, String paramString6)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.recmdDesc = paramString3;
    this.coverImg = paramString4;
    this.tag = paramString5;
    this.isPublishCompleted = paramBoolean1;
    this.isFollowed = paramBoolean2;
    this.playCount = paramLong;
    this.curPublishedFeedNum = paramInt1;
    this.curWatchedFeedNum = paramInt2;
    this.curWatchedFeedID = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.recmdDesc = paramJceInputStream.readString(2, false);
    this.coverImg = paramJceInputStream.readString(3, false);
    this.tag = paramJceInputStream.readString(4, false);
    this.isPublishCompleted = paramJceInputStream.read(this.isPublishCompleted, 5, false);
    this.isFollowed = paramJceInputStream.read(this.isFollowed, 6, false);
    this.playCount = paramJceInputStream.read(this.playCount, 7, false);
    this.curPublishedFeedNum = paramJceInputStream.read(this.curPublishedFeedNum, 8, false);
    this.curWatchedFeedNum = paramJceInputStream.read(this.curWatchedFeedNum, 9, false);
    this.curWatchedFeedID = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.recmdDesc;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.coverImg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.tag;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.isPublishCompleted, 5);
    paramJceOutputStream.write(this.isFollowed, 6);
    paramJceOutputStream.write(this.playCount, 7);
    paramJceOutputStream.write(this.curPublishedFeedNum, 8);
    paramJceOutputStream.write(this.curWatchedFeedNum, 9);
    str = this.curWatchedFeedID;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stDramaInfo
 * JD-Core Version:    0.7.0.1
 */