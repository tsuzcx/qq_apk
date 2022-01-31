package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_photo_list_bytimeline_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static Map<Long, Long> cache_time_range = new HashMap();
  public String albumid = "";
  public int albumtype;
  public String attach_info = "";
  public Map<Integer, String> busi_param;
  public int gettimeline;
  public int num;
  public String password = "";
  public int sort;
  public int start;
  public Map<Long, Long> time_range;
  public long uin;
  
  static
  {
    cache_time_range.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public get_photo_list_bytimeline_req() {}
  
  public get_photo_list_bytimeline_req(long paramLong, String paramString1, Map<Long, Long> paramMap, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Map<Integer, String> paramMap1)
  {
    this.uin = paramLong;
    this.albumid = paramString1;
    this.time_range = paramMap;
    this.sort = paramInt1;
    this.attach_info = paramString2;
    this.password = paramString3;
    this.start = paramInt2;
    this.num = paramInt3;
    this.albumtype = paramInt4;
    this.gettimeline = paramInt5;
    this.busi_param = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.time_range = ((Map)paramJceInputStream.read(cache_time_range, 2, true));
    this.sort = paramJceInputStream.read(this.sort, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
    this.password = paramJceInputStream.readString(5, false);
    this.start = paramJceInputStream.read(this.start, 6, false);
    this.num = paramJceInputStream.read(this.num, 7, false);
    this.albumtype = paramJceInputStream.read(this.albumtype, 8, false);
    this.gettimeline = paramJceInputStream.read(this.gettimeline, 9, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.time_range, 2);
    paramJceOutputStream.write(this.sort, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
    if (this.password != null) {
      paramJceOutputStream.write(this.password, 5);
    }
    paramJceOutputStream.write(this.start, 6);
    paramJceOutputStream.write(this.num, 7);
    paramJceOutputStream.write(this.albumtype, 8);
    paramJceOutputStream.write(this.gettimeline, 9);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_bytimeline_req
 * JD-Core Version:    0.7.0.1
 */