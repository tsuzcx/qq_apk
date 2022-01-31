package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class publish_active_album_rsp
  extends JceStruct
{
  public String fake_feeds_client_key = "";
  public String mgz_id = "";
  public String msg = "";
  public int ret;
  public String share_url = "";
  
  public publish_active_album_rsp() {}
  
  public publish_active_album_rsp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.fake_feeds_client_key = paramString2;
    this.share_url = paramString3;
    this.mgz_id = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.fake_feeds_client_key = paramJceInputStream.readString(2, false);
    this.share_url = paramJceInputStream.readString(3, false);
    this.mgz_id = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    if (this.fake_feeds_client_key != null) {
      paramJceOutputStream.write(this.fake_feeds_client_key, 2);
    }
    if (this.share_url != null) {
      paramJceOutputStream.write(this.share_url, 3);
    }
    if (this.mgz_id != null) {
      paramJceOutputStream.write(this.mgz_id, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.publish_active_album_rsp
 * JD-Core Version:    0.7.0.1
 */