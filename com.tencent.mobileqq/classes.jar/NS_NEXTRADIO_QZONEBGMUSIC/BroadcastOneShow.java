package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BroadcastOneShow
  extends JceStruct
{
  public String bcShowId = "";
  public String bcShowName = "";
  public long endTime = 0L;
  public int singerId = 0;
  public String singerName = "";
  public long startTime = 0L;
  
  public BroadcastOneShow() {}
  
  public BroadcastOneShow(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, String paramString3)
  {
    this.bcShowId = paramString1;
    this.bcShowName = paramString2;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.singerId = paramInt;
    this.singerName = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bcShowId = paramJceInputStream.readString(0, false);
    this.bcShowName = paramJceInputStream.readString(1, false);
    this.startTime = paramJceInputStream.read(this.startTime, 2, false);
    this.endTime = paramJceInputStream.read(this.endTime, 3, false);
    this.singerId = paramJceInputStream.read(this.singerId, 4, false);
    this.singerName = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.bcShowId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.bcShowName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.startTime, 2);
    paramJceOutputStream.write(this.endTime, 3);
    paramJceOutputStream.write(this.singerId, 4);
    str = this.singerName;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow
 * JD-Core Version:    0.7.0.1
 */