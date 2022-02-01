package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LastLoginInfo
  extends JceStruct
{
  public String contactsInfoEncrypt = "";
  
  public LastLoginInfo() {}
  
  public LastLoginInfo(String paramString)
  {
    this.contactsInfoEncrypt = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contactsInfoEncrypt = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contactsInfoEncrypt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.LastLoginInfo
 * JD-Core Version:    0.7.0.1
 */