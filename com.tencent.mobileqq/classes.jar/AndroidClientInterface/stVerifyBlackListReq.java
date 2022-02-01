package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVerifyBlackListReq
  extends JceStruct
{
  public String strModelName = "";
  
  public stVerifyBlackListReq() {}
  
  public stVerifyBlackListReq(String paramString)
  {
    this.strModelName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strModelName = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strModelName, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AndroidClientInterface.stVerifyBlackListReq
 * JD-Core Version:    0.7.0.1
 */