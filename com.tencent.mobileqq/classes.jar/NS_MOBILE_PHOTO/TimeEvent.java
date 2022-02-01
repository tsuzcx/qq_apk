package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeEvent
  extends JceStruct
{
  public String content = "";
  public String copywriter = "";
  public long time = 0L;
  public long type = 0L;
  
  public TimeEvent() {}
  
  public TimeEvent(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.time = paramLong1;
    this.type = paramLong2;
    this.content = paramString1;
    this.copywriter = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.time = paramJceInputStream.read(this.time, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.content = paramJceInputStream.readString(2, false);
    this.copywriter = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.type, 1);
    String str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.copywriter;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.TimeEvent
 * JD-Core Version:    0.7.0.1
 */