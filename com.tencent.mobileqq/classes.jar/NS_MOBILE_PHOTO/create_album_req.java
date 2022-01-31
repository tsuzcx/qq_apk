package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class create_album_req
  extends JceStruct
{
  static int cache_action = 0;
  static Album cache_album = new Album();
  static Map<Integer, String> cache_busi_param = new HashMap();
  public int action = 0;
  public Album album;
  public Map<Integer, String> busi_param;
  public String invite_key = "";
  public boolean is_from_public_url;
  public String itemid = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public create_album_req() {}
  
  public create_album_req(Album paramAlbum, Map<Integer, String> paramMap, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    this.album = paramAlbum;
    this.busi_param = paramMap;
    this.itemid = paramString1;
    this.action = paramInt;
    this.invite_key = paramString2;
    this.is_from_public_url = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.itemid = paramJceInputStream.readString(2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.invite_key = paramJceInputStream.readString(4, false);
    this.is_from_public_url = paramJceInputStream.read(this.is_from_public_url, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.itemid != null) {
      paramJceOutputStream.write(this.itemid, 2);
    }
    paramJceOutputStream.write(this.action, 3);
    if (this.invite_key != null) {
      paramJceOutputStream.write(this.invite_key, 4);
    }
    paramJceOutputStream.write(this.is_from_public_url, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.create_album_req
 * JD-Core Version:    0.7.0.1
 */