package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_userlogo_timestamp_rsp
  extends JceStruct
{
  static Map<Long, s_facade_info> cache_facade_data;
  static s_rc_tab_list cache_rc_data;
  static Map<Long, s_user_logo> cache_result;
  static Map<Long, s_skin_info> cache_skin_data;
  public boolean canRenew;
  public Map<Long, s_facade_info> facade_data;
  public int iOSPayType;
  public int open_vip_dialog_type;
  public s_rc_tab_list rc_data;
  public Map<Long, s_user_logo> result;
  public Map<Long, s_skin_info> skin_data;
  public long timestamp;
  
  public mobile_userlogo_timestamp_rsp() {}
  
  public mobile_userlogo_timestamp_rsp(Map<Long, s_user_logo> paramMap, Map<Long, s_skin_info> paramMap1, long paramLong, Map<Long, s_facade_info> paramMap2, boolean paramBoolean, s_rc_tab_list params_rc_tab_list, int paramInt1, int paramInt2)
  {
    this.result = paramMap;
    this.skin_data = paramMap1;
    this.timestamp = paramLong;
    this.facade_data = paramMap2;
    this.canRenew = paramBoolean;
    this.rc_data = params_rc_tab_list;
    this.iOSPayType = paramInt1;
    this.open_vip_dialog_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject = cache_result;
    Long localLong = Long.valueOf(0L);
    if (localObject == null)
    {
      cache_result = new HashMap();
      localObject = new s_user_logo();
      cache_result.put(localLong, localObject);
    }
    this.result = ((Map)paramJceInputStream.read(cache_result, 0, false));
    if (cache_skin_data == null)
    {
      cache_skin_data = new HashMap();
      localObject = new s_skin_info();
      cache_skin_data.put(localLong, localObject);
    }
    this.skin_data = ((Map)paramJceInputStream.read(cache_skin_data, 1, false));
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
    if (cache_facade_data == null)
    {
      cache_facade_data = new HashMap();
      localObject = new s_facade_info();
      cache_facade_data.put(localLong, localObject);
    }
    this.facade_data = ((Map)paramJceInputStream.read(cache_facade_data, 3, false));
    this.canRenew = paramJceInputStream.read(this.canRenew, 4, false);
    if (cache_rc_data == null) {
      cache_rc_data = new s_rc_tab_list();
    }
    this.rc_data = ((s_rc_tab_list)paramJceInputStream.read(cache_rc_data, 5, false));
    this.iOSPayType = paramJceInputStream.read(this.iOSPayType, 6, false);
    this.open_vip_dialog_type = paramJceInputStream.read(this.open_vip_dialog_type, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.result;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.skin_data;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
    localObject = this.facade_data;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.canRenew, 4);
    localObject = this.rc_data;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.iOSPayType, 6);
    paramJceOutputStream.write(this.open_vip_dialog_type, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.mobile_userlogo_timestamp_rsp
 * JD-Core Version:    0.7.0.1
 */