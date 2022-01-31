package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ban_info
  extends JceStruct
{
  public byte iBanLevel;
  public String strMessage = "";
  
  public ban_info() {}
  
  public ban_info(byte paramByte, String paramString)
  {
    this.iBanLevel = paramByte;
    this.strMessage = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iBanLevel = paramJceInputStream.read(this.iBanLevel, 0, false);
    this.strMessage = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBanLevel, 0);
    if (this.strMessage != null) {
      paramJceOutputStream.write(this.strMessage, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.ban_info
 * JD-Core Version:    0.7.0.1
 */