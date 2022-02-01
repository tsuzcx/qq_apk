package SWEET_NEW_PAIR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class invite_item
  extends JceStruct
{
  public long time = 0L;
  public long uin = 0L;
  
  public invite_item() {}
  
  public invite_item(long paramLong1, long paramLong2)
  {
    this.uin = paramLong1;
    this.time = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.time = paramJceInputStream.read(this.time, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.time, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWEET_NEW_PAIR.invite_item
 * JD-Core Version:    0.7.0.1
 */