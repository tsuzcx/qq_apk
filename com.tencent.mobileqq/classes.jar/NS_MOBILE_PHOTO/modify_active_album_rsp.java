package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class modify_active_album_rsp
  extends JceStruct
{
  public String fake_feeds_client_key = "";
  public String msg = "";
  public int ret = 0;
  
  public modify_active_album_rsp() {}
  
  public modify_active_album_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.fake_feeds_client_key = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.fake_feeds_client_key = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    String str = this.fake_feeds_client_key;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_active_album_rsp
 * JD-Core Version:    0.7.0.1
 */