package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VAResourcesReq
  extends JceStruct
{
  public long lastVisitTime = 0L;
  public int resourcesFlag = 0;
  public String sUin = "";
  
  public VAResourcesReq() {}
  
  public VAResourcesReq(String paramString, long paramLong, int paramInt)
  {
    this.sUin = paramString;
    this.lastVisitTime = paramLong;
    this.resourcesFlag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUin = paramJceInputStream.readString(0, true);
    this.lastVisitTime = paramJceInputStream.read(this.lastVisitTime, 1, false);
    this.resourcesFlag = paramJceInputStream.read(this.resourcesFlag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.lastVisitTime, 1);
    paramJceOutputStream.write(this.resourcesFlag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.VAResourcesReq
 * JD-Core Version:    0.7.0.1
 */