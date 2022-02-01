package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientInfo
  extends JceStruct
{
  static int cache_eUinType;
  public int eUinType = 0;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public String strUin = "";
  
  public ClientInfo() {}
  
  public ClientInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.eUinType = paramInt;
    this.strUin = paramString1;
    this.strAuthName = paramString2;
    this.strAuthPassword = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eUinType = paramJceInputStream.read(this.eUinType, 1, true);
    this.strUin = paramJceInputStream.readString(2, true);
    this.strAuthName = paramJceInputStream.readString(3, true);
    this.strAuthPassword = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eUinType, 1);
    paramJceOutputStream.write(this.strUin, 2);
    paramJceOutputStream.write(this.strAuthName, 3);
    paramJceOutputStream.write(this.strAuthPassword, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.ClientInfo
 * JD-Core Version:    0.7.0.1
 */