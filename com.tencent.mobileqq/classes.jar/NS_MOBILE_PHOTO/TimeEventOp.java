package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeEventOp
  extends JceStruct
{
  static int cache_action = 0;
  static TimeEvent cache_events = new TimeEvent();
  public int action = 0;
  public TimeEvent events = null;
  
  public TimeEventOp() {}
  
  public TimeEventOp(TimeEvent paramTimeEvent, int paramInt)
  {
    this.events = paramTimeEvent;
    this.action = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.events = ((TimeEvent)paramJceInputStream.read(cache_events, 0, false));
    this.action = paramJceInputStream.read(this.action, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    TimeEvent localTimeEvent = this.events;
    if (localTimeEvent != null) {
      paramJceOutputStream.write(localTimeEvent, 0);
    }
    paramJceOutputStream.write(this.action, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.TimeEventOp
 * JD-Core Version:    0.7.0.1
 */