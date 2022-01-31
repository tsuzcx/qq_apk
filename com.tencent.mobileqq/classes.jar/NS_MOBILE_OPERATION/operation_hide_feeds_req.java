package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_hide_feeds_req
  extends JceStruct
{
  public String strFeedUinKey = "";
  public long uHostUin;
  public long uTime;
  
  public operation_hide_feeds_req() {}
  
  public operation_hide_feeds_req(String paramString, long paramLong1, long paramLong2)
  {
    this.strFeedUinKey = paramString;
    this.uHostUin = paramLong1;
    this.uTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strFeedUinKey = paramJceInputStream.readString(0, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 1, false);
    this.uTime = paramJceInputStream.read(this.uTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strFeedUinKey != null) {
      paramJceOutputStream.write(this.strFeedUinKey, 0);
    }
    paramJceOutputStream.write(this.uHostUin, 1);
    paramJceOutputStream.write(this.uTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_hide_feeds_req
 * JD-Core Version:    0.7.0.1
 */