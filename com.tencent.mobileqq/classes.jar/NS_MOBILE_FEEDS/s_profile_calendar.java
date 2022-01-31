package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_profile_calendar
  extends JceStruct
{
  public int month;
  
  public s_profile_calendar() {}
  
  public s_profile_calendar(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.month = paramJceInputStream.read(this.month, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.month, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_profile_calendar
 * JD-Core Version:    0.7.0.1
 */