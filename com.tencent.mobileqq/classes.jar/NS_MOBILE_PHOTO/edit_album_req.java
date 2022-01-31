package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class edit_album_req
  extends JceStruct
{
  static Album cache_album = new Album();
  static Map cache_busi_param = new HashMap();
  public Album album;
  public Map busi_param;
  public long cancelIndividual;
  public boolean isModifyBitmap;
  public String itemid = "";
  public String newCoverId = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public edit_album_req() {}
  
  public edit_album_req(Album paramAlbum, Map paramMap, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this.album = paramAlbum;
    this.busi_param = paramMap;
    this.newCoverId = paramString1;
    this.itemid = paramString2;
    this.cancelIndividual = paramLong;
    this.isModifyBitmap = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.newCoverId = paramJceInputStream.readString(2, false);
    this.itemid = paramJceInputStream.readString(3, false);
    this.cancelIndividual = paramJceInputStream.read(this.cancelIndividual, 4, false);
    this.isModifyBitmap = paramJceInputStream.read(this.isModifyBitmap, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.newCoverId != null) {
      paramJceOutputStream.write(this.newCoverId, 2);
    }
    if (this.itemid != null) {
      paramJceOutputStream.write(this.itemid, 3);
    }
    paramJceOutputStream.write(this.cancelIndividual, 4);
    paramJceOutputStream.write(this.isModifyBitmap, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.edit_album_req
 * JD-Core Version:    0.7.0.1
 */