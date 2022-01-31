package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCustomOnlineStatusReq
  extends JceStruct
{
  public int iModelNum;
  public long lUin;
  public String sIMei = "";
  
  public GetCustomOnlineStatusReq() {}
  
  public GetCustomOnlineStatusReq(long paramLong, String paramString, int paramInt)
  {
    this.lUin = paramLong;
    this.sIMei = paramString;
    this.iModelNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.sIMei = paramJceInputStream.readString(1, false);
    this.iModelNum = paramJceInputStream.read(this.iModelNum, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.sIMei != null) {
      paramJceOutputStream.write(this.sIMei, 1);
    }
    paramJceOutputStream.write(this.iModelNum, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetCustomOnlineStatusReq
 * JD-Core Version:    0.7.0.1
 */