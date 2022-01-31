package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class quote_photo_src
  extends JceStruct
{
  public long fromUin;
  public int src_type;
  
  public quote_photo_src() {}
  
  public quote_photo_src(int paramInt, long paramLong)
  {
    this.src_type = paramInt;
    this.fromUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.src_type = paramJceInputStream.read(this.src_type, 0, false);
    this.fromUin = paramJceInputStream.read(this.fromUin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.src_type, 0);
    paramJceOutputStream.write(this.fromUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.quote_photo_src
 * JD-Core Version:    0.7.0.1
 */