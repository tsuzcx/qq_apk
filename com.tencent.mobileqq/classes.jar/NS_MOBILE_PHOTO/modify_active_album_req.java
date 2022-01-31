package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class modify_active_album_req
  extends JceStruct
{
  static ArrayList cache_added_photo;
  static Map cache_map_params = new HashMap();
  static shuoshuo_privacy cache_ss_info = new shuoshuo_privacy();
  public ArrayList added_photo;
  public Map map_params;
  public String mgz_id = "";
  public long pic_total;
  public shuoshuo_privacy ss_info;
  public long uin;
  
  static
  {
    cache_map_params.put("", "");
    cache_added_photo = new ArrayList();
    active_photo localactive_photo = new active_photo();
    cache_added_photo.add(localactive_photo);
  }
  
  public modify_active_album_req() {}
  
  public modify_active_album_req(long paramLong1, Map paramMap, ArrayList paramArrayList, shuoshuo_privacy paramshuoshuo_privacy, String paramString, long paramLong2)
  {
    this.uin = paramLong1;
    this.map_params = paramMap;
    this.added_photo = paramArrayList;
    this.ss_info = paramshuoshuo_privacy;
    this.mgz_id = paramString;
    this.pic_total = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.map_params = ((Map)paramJceInputStream.read(cache_map_params, 1, false));
    this.added_photo = ((ArrayList)paramJceInputStream.read(cache_added_photo, 2, false));
    this.ss_info = ((shuoshuo_privacy)paramJceInputStream.read(cache_ss_info, 3, false));
    this.mgz_id = paramJceInputStream.readString(4, false);
    this.pic_total = paramJceInputStream.read(this.pic_total, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.map_params != null) {
      paramJceOutputStream.write(this.map_params, 1);
    }
    if (this.added_photo != null) {
      paramJceOutputStream.write(this.added_photo, 2);
    }
    if (this.ss_info != null) {
      paramJceOutputStream.write(this.ss_info, 3);
    }
    if (this.mgz_id != null) {
      paramJceOutputStream.write(this.mgz_id, 4);
    }
    paramJceOutputStream.write(this.pic_total, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_active_album_req
 * JD-Core Version:    0.7.0.1
 */