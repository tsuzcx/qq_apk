package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stOffset
  extends JceStruct
{
  public long begin = 0L;
  public long end = 0L;
  
  public stOffset() {}
  
  public stOffset(long paramLong1, long paramLong2)
  {
    this.begin = paramLong1;
    this.end = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.begin = paramJceInputStream.read(this.begin, 1, true);
    this.end = paramJceInputStream.read(this.end, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.begin, 1);
    paramJceOutputStream.write(this.end, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.stOffset
 * JD-Core Version:    0.7.0.1
 */