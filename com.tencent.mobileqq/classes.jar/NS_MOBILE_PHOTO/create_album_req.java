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
  public Album album = null;
  public Map<Integer, String> busi_param = null;
  public String invite_key = "";
  public boolean is_from_public_url = false;
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
    Object localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.itemid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.action, 3);
    localObject = this.invite_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.is_from_public_url, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.create_album_req
 * JD-Core Version:    0.7.0.1
 */