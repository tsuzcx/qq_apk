package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class modify_active_album_req
  extends JceStruct
{
  static ArrayList<active_photo> cache_added_photo;
  static Map<String, String> cache_map_params = new HashMap();
  static shuoshuo_privacy cache_ss_info = new shuoshuo_privacy();
  public ArrayList<active_photo> added_photo = null;
  public Map<String, String> map_params = null;
  public String mgz_id = "";
  public long pic_total = 0L;
  public shuoshuo_privacy ss_info = null;
  public long uin = 0L;
  
  static
  {
    cache_map_params.put("", "");
    cache_added_photo = new ArrayList();
    active_photo localactive_photo = new active_photo();
    cache_added_photo.add(localactive_photo);
  }
  
  public modify_active_album_req() {}
  
  public modify_active_album_req(long paramLong1, Map<String, String> paramMap, ArrayList<active_photo> paramArrayList, shuoshuo_privacy paramshuoshuo_privacy, String paramString, long paramLong2)
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
    Object localObject = this.map_params;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.added_photo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.ss_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.mgz_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.pic_total, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_active_album_req
 * JD-Core Version:    0.7.0.1
 */