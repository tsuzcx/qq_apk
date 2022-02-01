package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ViewInfo
  extends JceStruct
{
  public int totalView = 0;
  
  public ViewInfo() {}
  
  public ViewInfo(int paramInt)
  {
    this.totalView = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.totalView = paramJceInputStream.read(this.totalView, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.ViewInfo
 * JD-Core Version:    0.7.0.1
 */