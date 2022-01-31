package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestDisableMobileBind
  extends JceStruct
{
  public String mobileNo = "";
  public String nationCode = "";
  
  public RequestDisableMobileBind() {}
  
  public RequestDisableMobileBind(String paramString1, String paramString2)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SecurityAccountServer.RequestDisableMobileBind
 * JD-Core Version:    0.7.0.1
 */