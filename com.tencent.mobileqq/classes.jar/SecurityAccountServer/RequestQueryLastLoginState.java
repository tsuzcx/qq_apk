package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryLastLoginState
  extends JceStruct
{
  public String MobileUniqueNo = "";
  public long nextFlag;
  public long timeStamp;
  
  public RequestQueryLastLoginState() {}
  
  public RequestQueryLastLoginState(long paramLong1, long paramLong2, String paramString)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.MobileUniqueNo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.MobileUniqueNo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryLastLoginState
 * JD-Core Version:    0.7.0.1
 */