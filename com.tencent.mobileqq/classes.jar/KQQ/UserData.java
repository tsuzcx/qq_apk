package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserData
  extends JceStruct
{
  public byte cIfPushPic;
  
  public UserData() {}
  
  public UserData(byte paramByte)
  {
    this.cIfPushPic = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cIfPushPic = paramJceInputStream.read(this.cIfPushPic, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cIfPushPic, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.UserData
 * JD-Core Version:    0.7.0.1
 */