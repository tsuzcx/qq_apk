package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PushInfo
  extends JceStruct
{
  public int totalPush = 0;
  
  public PushInfo() {}
  
  public PushInfo(int paramInt)
  {
    this.totalPush = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.totalPush = paramJceInputStream.read(this.totalPush, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalPush, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.PushInfo
 * JD-Core Version:    0.7.0.1
 */