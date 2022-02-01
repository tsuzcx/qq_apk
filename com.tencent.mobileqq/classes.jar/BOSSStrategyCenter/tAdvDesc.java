package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class tAdvDesc
  extends JceStruct
{
  static Map<String, String> cache_adv_config_info;
  static Map<String, String> cache_adv_user_feed;
  public Map<String, String> adv_config_info;
  public Map<String, String> adv_user_feed;
  public long expose_time;
  public String name = "";
  public int parent_id;
  public String pattern_data = "";
  public int pattern_id;
  public String pattern_logic = "";
  public String res_data = "";
  public String res_preprocess = "";
  public String res_traceinfo = "";
  public int resource_id;
  public int ret;
  public String s_cmd_info = "";
  public String s_ret_msg = "";
  public int task_id;
  public int type;
  
  public tAdvDesc() {}
  
  public tAdvDesc(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, String paramString6, int paramInt6, String paramString7, String paramString8, long paramLong, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.task_id = paramInt1;
    this.type = paramInt2;
    this.name = paramString1;
    this.resource_id = paramInt3;
    this.res_data = paramString2;
    this.res_preprocess = paramString3;
    this.pattern_id = paramInt4;
    this.pattern_logic = paramString4;
    this.pattern_data = paramString5;
    this.parent_id = paramInt5;
    this.res_traceinfo = paramString6;
    this.ret = paramInt6;
    this.s_ret_msg = paramString7;
    this.s_cmd_info = paramString8;
    this.expose_time = paramLong;
    this.adv_config_info = paramMap1;
    this.adv_user_feed = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.task_id = paramJceInputStream.read(this.task_id, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.resource_id = paramJceInputStream.read(this.resource_id, 3, true);
    this.res_data = paramJceInputStream.readString(4, false);
    this.res_preprocess = paramJceInputStream.readString(5, false);
    this.pattern_id = paramJceInputStream.read(this.pattern_id, 6, false);
    this.pattern_logic = paramJceInputStream.readString(7, false);
    this.pattern_data = paramJceInputStream.readString(8, false);
    this.parent_id = paramJceInputStream.read(this.parent_id, 9, false);
    this.res_traceinfo = paramJceInputStream.readString(10, false);
    this.ret = paramJceInputStream.read(this.ret, 11, false);
    this.s_ret_msg = paramJceInputStream.readString(12, false);
    this.s_cmd_info = paramJceInputStream.readString(13, false);
    this.expose_time = paramJceInputStream.read(this.expose_time, 14, false);
    if (cache_adv_config_info == null)
    {
      cache_adv_config_info = new HashMap();
      cache_adv_config_info.put("", "");
    }
    this.adv_config_info = ((Map)paramJceInputStream.read(cache_adv_config_info, 15, false));
    if (cache_adv_user_feed == null)
    {
      cache_adv_user_feed = new HashMap();
      cache_adv_user_feed.put("", "");
    }
    this.adv_user_feed = ((Map)paramJceInputStream.read(cache_adv_user_feed, 16, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.task_id, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.resource_id, 3);
    Object localObject = this.res_data;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.res_preprocess;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.pattern_id, 6);
    localObject = this.pattern_logic;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.pattern_data;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.parent_id, 9);
    localObject = this.res_traceinfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.ret, 11);
    localObject = this.s_ret_msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.s_cmd_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.expose_time, 14);
    localObject = this.adv_config_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 15);
    }
    localObject = this.adv_user_feed;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     BOSSStrategyCenter.tAdvDesc
 * JD-Core Version:    0.7.0.1
 */