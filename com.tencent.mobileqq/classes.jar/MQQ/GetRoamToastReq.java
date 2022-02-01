package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRoamToastReq
  extends JceStruct
{
  public String sKey = "";
  public long uUin = 0L;
  
  public GetRoamToastReq() {}
  
  public GetRoamToastReq(long paramLong, String paramString)
  {
    this.uUin = paramLong;
    this.sKey = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, true);
    this.sKey = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    paramJceOutputStream.write(this.sKey, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.GetRoamToastReq
 * JD-Core Version:    0.7.0.1
 */