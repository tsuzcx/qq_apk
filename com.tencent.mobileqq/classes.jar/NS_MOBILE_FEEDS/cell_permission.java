package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_permission
  extends JceStruct
{
  static Map<Integer, String> cache_map_permission_msg = new HashMap();
  public Map<Integer, String> map_permission_msg = null;
  public String permission_info = "";
  public int permission_mask;
  public String permission_tips = "";
  public byte permission_visit;
  public String status_info = "";
  
  static
  {
    cache_map_permission_msg.put(Integer.valueOf(0), "");
  }
  
  public cell_permission() {}
  
  public cell_permission(String paramString1, int paramInt, String paramString2, byte paramByte, String paramString3, Map<Integer, String> paramMap)
  {
    this.permission_info = paramString1;
    this.permission_mask = paramInt;
    this.status_info = paramString2;
    this.permission_visit = paramByte;
    this.permission_tips = paramString3;
    this.map_permission_msg = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.permission_info = paramJceInputStream.readString(0, false);
    this.permission_mask = paramJceInputStream.read(this.permission_mask, 1, false);
    this.status_info = paramJceInputStream.readString(2, false);
    this.permission_visit = paramJceInputStream.read(this.permission_visit, 3, false);
    this.permission_tips = paramJceInputStream.readString(4, false);
    this.map_permission_msg = ((Map)paramJceInputStream.read(cache_map_permission_msg, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.permission_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.permission_mask, 1);
    localObject = this.status_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.permission_visit, 3);
    localObject = this.permission_tips;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.map_permission_msg;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_permission
 * JD-Core Version:    0.7.0.1
 */