package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_feedsphoto_bytimeline_req
  extends JceStruct
{
  public String attach_info = "";
  public long begin_time = 0L;
  public long end_time = 0L;
  public int type = 0;
  public long uin = 0L;
  
  public get_feedsphoto_bytimeline_req() {}
  
  public get_feedsphoto_bytimeline_req(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    this.uin = paramLong1;
    this.begin_time = paramLong2;
    this.end_time = paramLong3;
    this.type = paramInt;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.begin_time = paramJceInputStream.read(this.begin_time, 1, false);
    this.end_time = paramJceInputStream.read(this.end_time, 2, false);
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.begin_time, 1);
    paramJceOutputStream.write(this.end_time, 2);
    paramJceOutputStream.write(this.type, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_feedsphoto_bytimeline_req
 * JD-Core Version:    0.7.0.1
 */