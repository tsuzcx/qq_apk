package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_arkshare;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class publish_active_album_rsp
  extends JceStruct
{
  static s_arkshare cache_ark_sharedata = new s_arkshare();
  public s_arkshare ark_sharedata = null;
  public String fake_feeds_client_key = "";
  public String mgz_id = "";
  public String msg = "";
  public int ret = 0;
  public String share_url = "";
  public String xcx_name = "";
  public String xcx_share_path = "";
  
  public publish_active_album_rsp() {}
  
  public publish_active_album_rsp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, s_arkshare params_arkshare, String paramString5, String paramString6)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.fake_feeds_client_key = paramString2;
    this.share_url = paramString3;
    this.mgz_id = paramString4;
    this.ark_sharedata = params_arkshare;
    this.xcx_share_path = paramString5;
    this.xcx_name = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.fake_feeds_client_key = paramJceInputStream.readString(2, false);
    this.share_url = paramJceInputStream.readString(3, false);
    this.mgz_id = paramJceInputStream.readString(4, false);
    this.ark_sharedata = ((s_arkshare)paramJceInputStream.read(cache_ark_sharedata, 5, false));
    this.xcx_share_path = paramJceInputStream.readString(6, false);
    this.xcx_name = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    Object localObject = this.fake_feeds_client_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.share_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.mgz_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.ark_sharedata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.xcx_share_path;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.xcx_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.publish_active_album_rsp
 * JD-Core Version:    0.7.0.1
 */