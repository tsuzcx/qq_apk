package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_albumlist_num_rsp
  extends JceStruct
{
  public long album_num;
  public String msg = "";
  public int ret;
  
  public get_albumlist_num_rsp() {}
  
  public get_albumlist_num_rsp(long paramLong, int paramInt, String paramString)
  {
    this.album_num = paramLong;
    this.ret = paramInt;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album_num = paramJceInputStream.read(this.album_num, 0, true);
    this.ret = paramJceInputStream.read(this.ret, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album_num, 0);
    paramJceOutputStream.write(this.ret, 1);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_albumlist_num_rsp
 * JD-Core Version:    0.7.0.1
 */