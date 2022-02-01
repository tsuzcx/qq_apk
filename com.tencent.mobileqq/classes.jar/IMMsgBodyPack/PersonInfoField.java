package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PersonInfoField
  extends JceStruct
{
  public long uField = 0L;
  
  public PersonInfoField() {}
  
  public PersonInfoField(long paramLong)
  {
    this.uField = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uField = paramJceInputStream.read(this.uField, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uField, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.PersonInfoField
 * JD-Core Version:    0.7.0.1
 */