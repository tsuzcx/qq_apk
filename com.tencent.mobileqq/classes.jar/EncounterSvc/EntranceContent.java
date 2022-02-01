package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EntranceContent
  extends JceStruct
{
  static byte[] cache_content_buff = (byte[])new byte[1];
  public byte[] content_buff = null;
  public int type = 0;
  
  static
  {
    ((byte[])cache_content_buff)[0] = 0;
  }
  
  public EntranceContent() {}
  
  public EntranceContent(int paramInt, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.content_buff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.content_buff = ((byte[])paramJceInputStream.read(cache_content_buff, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.content_buff, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.EntranceContent
 * JD-Core Version:    0.7.0.1
 */