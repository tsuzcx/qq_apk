package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UserCommReport
  extends JceStruct
{
  static Map<String, String> cache_user_tag = new HashMap();
  public String app_version = "";
  public String city_code = "";
  public String client_type = "";
  public String guid = "";
  public String ip_addr = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public String market = "";
  public String mobile_type = "";
  public String network_type = "";
  public String operators = "";
  public String os_version = "";
  public String platform = "";
  public String qimei = "";
  public String qua = "";
  public long to_uin = 0L;
  public long uin = 0L;
  public Map<String, String> user_tag = null;
  
  static
  {
    cache_user_tag.put("", "");
  }
  
  public UserCommReport() {}
  
  public UserCommReport(long paramLong1, long paramLong2, String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, Map<String, String> paramMap)
  {
    this.uin = paramLong1;
    this.to_uin = paramLong2;
    this.guid = paramString1;
    this.longitude = paramDouble1;
    this.latitude = paramDouble2;
    this.city_code = paramString2;
    this.platform = paramString3;
    this.client_type = paramString4;
    this.app_version = paramString5;
    this.market = paramString6;
    this.qua = paramString7;
    this.os_version = paramString8;
    this.mobile_type = paramString9;
    this.ip_addr = paramString10;
    this.network_type = paramString11;
    this.operators = paramString12;
    this.qimei = paramString13;
    this.user_tag = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.to_uin = paramJceInputStream.read(this.to_uin, 1, false);
    this.guid = paramJceInputStream.readString(2, false);
    this.longitude = paramJceInputStream.read(this.longitude, 3, false);
    this.latitude = paramJceInputStream.read(this.latitude, 4, false);
    this.city_code = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, true);
    this.client_type = paramJceInputStream.readString(7, true);
    this.app_version = paramJceInputStream.readString(8, false);
    this.market = paramJceInputStream.readString(9, false);
    this.qua = paramJceInputStream.readString(10, false);
    this.os_version = paramJceInputStream.readString(11, false);
    this.mobile_type = paramJceInputStream.readString(12, false);
    this.ip_addr = paramJceInputStream.readString(13, false);
    this.network_type = paramJceInputStream.readString(14, true);
    this.operators = paramJceInputStream.readString(15, false);
    this.qimei = paramJceInputStream.readString(16, false);
    this.user_tag = ((Map)paramJceInputStream.read(cache_user_tag, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.to_uin, 1);
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 2);
    }
    paramJceOutputStream.write(this.longitude, 3);
    paramJceOutputStream.write(this.latitude, 4);
    if (this.city_code != null) {
      paramJceOutputStream.write(this.city_code, 5);
    }
    paramJceOutputStream.write(this.platform, 6);
    paramJceOutputStream.write(this.client_type, 7);
    if (this.app_version != null) {
      paramJceOutputStream.write(this.app_version, 8);
    }
    if (this.market != null) {
      paramJceOutputStream.write(this.market, 9);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 10);
    }
    if (this.os_version != null) {
      paramJceOutputStream.write(this.os_version, 11);
    }
    if (this.mobile_type != null) {
      paramJceOutputStream.write(this.mobile_type, 12);
    }
    if (this.ip_addr != null) {
      paramJceOutputStream.write(this.ip_addr, 13);
    }
    paramJceOutputStream.write(this.network_type, 14);
    if (this.operators != null) {
      paramJceOutputStream.write(this.operators, 15);
    }
    if (this.qimei != null) {
      paramJceOutputStream.write(this.qimei, 16);
    }
    if (this.user_tag != null) {
      paramJceOutputStream.write(this.user_tag, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserCommReport
 * JD-Core Version:    0.7.0.1
 */