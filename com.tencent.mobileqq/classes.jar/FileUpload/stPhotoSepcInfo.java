package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPhotoSepcInfo
  extends JceStruct
{
  public long iPhotoHeight = 0L;
  public long iPhotoSize = 0L;
  public long iPhotoType = 0L;
  public long iPhotoWidth = 0L;
  
  public stPhotoSepcInfo() {}
  
  public stPhotoSepcInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.iPhotoSize = paramLong1;
    this.iPhotoWidth = paramLong2;
    this.iPhotoHeight = paramLong3;
    this.iPhotoType = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPhotoSize = paramJceInputStream.read(this.iPhotoSize, 0, true);
    this.iPhotoWidth = paramJceInputStream.read(this.iPhotoWidth, 1, true);
    this.iPhotoHeight = paramJceInputStream.read(this.iPhotoHeight, 2, true);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPhotoSize, 0);
    paramJceOutputStream.write(this.iPhotoWidth, 1);
    paramJceOutputStream.write(this.iPhotoHeight, 2);
    paramJceOutputStream.write(this.iPhotoType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.stPhotoSepcInfo
 * JD-Core Version:    0.7.0.1
 */