package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkUinInPhoto
  extends JceStruct
{
  public String groupid = "";
  public long h = 0L;
  public boolean is_recommend = false;
  public long target_uin = 0L;
  public long w = 0L;
  public long x = 0L;
  public long y = 0L;
  
  public MarkUinInPhoto() {}
  
  public MarkUinInPhoto(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, boolean paramBoolean)
  {
    this.x = paramLong1;
    this.y = paramLong2;
    this.w = paramLong3;
    this.h = paramLong4;
    this.target_uin = paramLong5;
    this.groupid = paramString;
    this.is_recommend = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x = paramJceInputStream.read(this.x, 0, false);
    this.y = paramJceInputStream.read(this.y, 1, false);
    this.w = paramJceInputStream.read(this.w, 2, false);
    this.h = paramJceInputStream.read(this.h, 3, false);
    this.target_uin = paramJceInputStream.read(this.target_uin, 4, false);
    this.groupid = paramJceInputStream.readString(5, false);
    this.is_recommend = paramJceInputStream.read(this.is_recommend, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x, 0);
    paramJceOutputStream.write(this.y, 1);
    paramJceOutputStream.write(this.w, 2);
    paramJceOutputStream.write(this.h, 3);
    paramJceOutputStream.write(this.target_uin, 4);
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 5);
    }
    paramJceOutputStream.write(this.is_recommend, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.MarkUinInPhoto
 * JD-Core Version:    0.7.0.1
 */