package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_album_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public String albumid = "";
  public Map<Integer, String> busi_param;
  public boolean is_from_public_url;
  public boolean is_get_url_key;
  public long owner_uin;
  public String share_key = "";
  public int type;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_album_req() {}
  
  public get_album_req(String paramString1, int paramInt, Map<Integer, String> paramMap, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    this.albumid = paramString1;
    this.type = paramInt;
    this.busi_param = paramMap;
    this.owner_uin = paramLong;
    this.is_get_url_key = paramBoolean1;
    this.share_key = paramString2;
    this.is_from_public_url = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
    this.owner_uin = paramJceInputStream.read(this.owner_uin, 3, false);
    this.is_get_url_key = paramJceInputStream.read(this.is_get_url_key, 4, false);
    this.share_key = paramJceInputStream.readString(5, false);
    this.is_from_public_url = paramJceInputStream.read(this.is_from_public_url, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
    paramJceOutputStream.write(this.owner_uin, 3);
    paramJceOutputStream.write(this.is_get_url_key, 4);
    if (this.share_key != null) {
      paramJceOutputStream.write(this.share_key, 5);
    }
    paramJceOutputStream.write(this.is_from_public_url, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_req
 * JD-Core Version:    0.7.0.1
 */