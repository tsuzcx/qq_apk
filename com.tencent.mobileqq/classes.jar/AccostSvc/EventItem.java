package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EventItem
  extends JceStruct
{
  static byte[] cache_eventData;
  public byte[] eventData;
  public int eventType;
  
  public EventItem() {}
  
  public EventItem(int paramInt, byte[] paramArrayOfByte)
  {
    this.eventType = paramInt;
    this.eventData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eventType = paramJceInputStream.read(this.eventType, 0, true);
    if (cache_eventData == null)
    {
      cache_eventData = (byte[])new byte[1];
      ((byte[])cache_eventData)[0] = 0;
    }
    this.eventData = ((byte[])paramJceInputStream.read(cache_eventData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eventType, 0);
    if (this.eventData != null) {
      paramJceOutputStream.write(this.eventData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AccostSvc.EventItem
 * JD-Core Version:    0.7.0.1
 */