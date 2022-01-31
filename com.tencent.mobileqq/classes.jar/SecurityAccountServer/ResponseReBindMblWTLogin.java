package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponseReBindMblWTLogin
  extends JceStruct
{
  public int result;
  
  public ResponseReBindMblWTLogin() {}
  
  public ResponseReBindMblWTLogin(int paramInt)
  {
    this.result = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponseReBindMblWTLogin
 * JD-Core Version:    0.7.0.1
 */