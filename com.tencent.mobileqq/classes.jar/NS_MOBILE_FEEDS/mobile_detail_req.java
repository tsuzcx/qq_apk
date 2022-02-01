package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_detail_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_mapExt;
  public int appid = 0;
  public String attach_info = "";
  public String attach_info_essence = "";
  public Map<Integer, String> busi_param = null;
  public String cellid = "";
  public String clientkey = "";
  public int count = 0;
  public String likekey = "";
  public Map<String, String> mapExt = null;
  public int refresh_type = 0;
  public String subid = "";
  public long uin = 0L;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public mobile_detail_req() {}
  
  public mobile_detail_req(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, Map<Integer, String> paramMap, int paramInt2, int paramInt3, String paramString4, String paramString5, Map<String, String> paramMap1, String paramString6)
  {
    this.uin = paramLong;
    this.appid = paramInt1;
    this.likekey = paramString1;
    this.cellid = paramString2;
    this.subid = paramString3;
    this.busi_param = paramMap;
    this.refresh_type = paramInt2;
    this.count = paramInt3;
    this.attach_info = paramString4;
    this.clientkey = paramString5;
    this.mapExt = paramMap1;
    this.attach_info_essence = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.likekey = paramJceInputStream.readString(2, false);
    this.cellid = paramJceInputStream.readString(3, false);
    this.subid = paramJceInputStream.readString(4, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 6, false);
    this.count = paramJceInputStream.read(this.count, 7, false);
    this.attach_info = paramJceInputStream.readString(8, false);
    this.clientkey = paramJceInputStream.readString(9, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 10, false));
    this.attach_info_essence = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    Object localObject = this.likekey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.cellid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.subid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    paramJceOutputStream.write(this.refresh_type, 6);
    paramJceOutputStream.write(this.count, 7);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.attach_info_essence;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_req
 * JD-Core Version:    0.7.0.1
 */