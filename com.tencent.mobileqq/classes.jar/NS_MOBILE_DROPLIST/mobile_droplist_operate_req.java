package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_droplist_operate_req
  extends JceStruct
{
  static Map cache_busi_param = new HashMap();
  public Map busi_param;
  public int feedback_id;
  public long login_uin;
  public long owner_uin;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public mobile_droplist_operate_req() {}
  
  public mobile_droplist_operate_req(Map paramMap, long paramLong1, long paramLong2, int paramInt)
  {
    this.busi_param = paramMap;
    this.login_uin = paramLong1;
    this.owner_uin = paramLong2;
    this.feedback_id = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.login_uin = paramJceInputStream.read(this.login_uin, 1, false);
    this.owner_uin = paramJceInputStream.read(this.owner_uin, 2, false);
    this.feedback_id = paramJceInputStream.read(this.feedback_id, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 0);
    }
    paramJceOutputStream.write(this.login_uin, 1);
    paramJceOutputStream.write(this.owner_uin, 2);
    paramJceOutputStream.write(this.feedback_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_DROPLIST.mobile_droplist_operate_req
 * JD-Core Version:    0.7.0.1
 */