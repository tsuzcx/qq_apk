package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stRecommandUpload
  extends JceStruct
{
  static int cache_type = 0;
  public long begin;
  public long end;
  public long left_days;
  public int type = 1;
  
  public stRecommandUpload() {}
  
  public stRecommandUpload(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = paramInt;
    this.left_days = paramLong1;
    this.begin = paramLong2;
    this.end = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.left_days = paramJceInputStream.read(this.left_days, 1, false);
    this.begin = paramJceInputStream.read(this.begin, 2, false);
    this.end = paramJceInputStream.read(this.end, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.left_days, 1);
    paramJceOutputStream.write(this.begin, 2);
    paramJceOutputStream.write(this.end, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stRecommandUpload
 * JD-Core Version:    0.7.0.1
 */