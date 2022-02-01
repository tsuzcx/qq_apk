package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CommHeader
  extends JceStruct
{
  static Map<String, String> cache_map_ext = new HashMap();
  public String auth_key = "";
  public long auth_type = 0L;
  public long client_ip = 0L;
  public Map<String, String> map_ext = null;
  public long platform = 0L;
  public long ptlogin_id = 0L;
  public String qqver = "";
  public String qua = "";
  public long server_ip = 0L;
  public long uin = 0L;
  
  static
  {
    cache_map_ext.put("", "");
  }
  
  public CommHeader() {}
  
  public CommHeader(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3, long paramLong6, Map<String, String> paramMap)
  {
    this.uin = paramLong1;
    this.auth_type = paramLong2;
    this.auth_key = paramString1;
    this.ptlogin_id = paramLong3;
    this.client_ip = paramLong4;
    this.server_ip = paramLong5;
    this.qua = paramString2;
    this.qqver = paramString3;
    this.platform = paramLong6;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.auth_type = paramJceInputStream.read(this.auth_type, 1, false);
    this.auth_key = paramJceInputStream.readString(2, false);
    this.ptlogin_id = paramJceInputStream.read(this.ptlogin_id, 3, false);
    this.client_ip = paramJceInputStream.read(this.client_ip, 4, false);
    this.server_ip = paramJceInputStream.read(this.server_ip, 5, false);
    this.qua = paramJceInputStream.readString(6, false);
    this.qqver = paramJceInputStream.readString(7, false);
    this.platform = paramJceInputStream.read(this.platform, 8, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.auth_type, 1);
    Object localObject = this.auth_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.ptlogin_id, 3);
    paramJceOutputStream.write(this.client_ip, 4);
    paramJceOutputStream.write(this.server_ip, 5);
    localObject = this.qua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.qqver;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.platform, 8);
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VA_PROFILE_COMM_TASK.CommHeader
 * JD-Core Version:    0.7.0.1
 */