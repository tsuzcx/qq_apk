package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DefineAvatarInfo
  extends JceStruct
{
  public byte cImgFmt = 0;
  public byte cImgStyle = 0;
  
  public DefineAvatarInfo() {}
  
  public DefineAvatarInfo(byte paramByte1, byte paramByte2)
  {
    this.cImgStyle = paramByte1;
    this.cImgFmt = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cImgStyle = paramJceInputStream.read(this.cImgStyle, 0, true);
    this.cImgFmt = paramJceInputStream.read(this.cImgFmt, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cImgStyle, 0);
    paramJceOutputStream.write(this.cImgFmt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQFS.DefineAvatarInfo
 * JD-Core Version:    0.7.0.1
 */