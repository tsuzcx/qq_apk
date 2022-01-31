package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponseVerifyWTLogin
  extends JceStruct
{
  public long preBindUin;
  
  public ResponseVerifyWTLogin() {}
  
  public ResponseVerifyWTLogin(long paramLong)
  {
    this.preBindUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.preBindUin = paramJceInputStream.read(this.preBindUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.preBindUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponseVerifyWTLogin
 * JD-Core Version:    0.7.0.1
 */