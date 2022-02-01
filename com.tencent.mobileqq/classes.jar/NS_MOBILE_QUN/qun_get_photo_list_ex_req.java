package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_get_photo_list_ex_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public String albumid = "";
  public long batch_id = 0L;
  public Map<Integer, String> busi_param = null;
  public String curlloc = "";
  public int get_comment = 0;
  public int get_pfinfo = 0;
  public int get_poi = 0;
  public long left = 0L;
  public String password = "";
  public String qunid = "";
  public long right = 0L;
  public int sort = 0;
  public long type = 0L;
  public long uin = 0L;
  public String url = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public qun_get_photo_list_ex_req() {}
  
  public qun_get_photo_list_ex_req(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, String paramString4, int paramInt1, int paramInt2, long paramLong4, String paramString5, Map<Integer, String> paramMap, long paramLong5, int paramInt3, int paramInt4)
  {
    this.qunid = paramString1;
    this.uin = paramLong1;
    this.albumid = paramString2;
    this.curlloc = paramString3;
    this.left = paramLong2;
    this.right = paramLong3;
    this.password = paramString4;
    this.sort = paramInt1;
    this.get_comment = paramInt2;
    this.type = paramLong4;
    this.url = paramString5;
    this.busi_param = paramMap;
    this.batch_id = paramLong5;
    this.get_poi = paramInt3;
    this.get_pfinfo = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.albumid = paramJceInputStream.readString(2, true);
    this.curlloc = paramJceInputStream.readString(3, true);
    this.left = paramJceInputStream.read(this.left, 4, true);
    this.right = paramJceInputStream.read(this.right, 5, true);
    this.password = paramJceInputStream.readString(6, true);
    this.sort = paramJceInputStream.read(this.sort, 7, true);
    this.get_comment = paramJceInputStream.read(this.get_comment, 8, true);
    this.type = paramJceInputStream.read(this.type, 9, false);
    this.url = paramJceInputStream.readString(10, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 11, false));
    this.batch_id = paramJceInputStream.read(this.batch_id, 12, false);
    this.get_poi = paramJceInputStream.read(this.get_poi, 13, false);
    this.get_pfinfo = paramJceInputStream.read(this.get_pfinfo, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.albumid, 2);
    paramJceOutputStream.write(this.curlloc, 3);
    paramJceOutputStream.write(this.left, 4);
    paramJceOutputStream.write(this.right, 5);
    paramJceOutputStream.write(this.password, 6);
    paramJceOutputStream.write(this.sort, 7);
    paramJceOutputStream.write(this.get_comment, 8);
    paramJceOutputStream.write(this.type, 9);
    Object localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
    paramJceOutputStream.write(this.batch_id, 12);
    paramJceOutputStream.write(this.get_poi, 13);
    paramJceOutputStream.write(this.get_pfinfo, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_photo_list_ex_req
 * JD-Core Version:    0.7.0.1
 */