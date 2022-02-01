package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class tPullADVRequest
  extends JceStruct
{
  static Map<String, String> cache_ext_user_info;
  static ArrayList<tAdvAppInfo> cache_vec_req_app = new ArrayList();
  public Map<String, String> ext_user_info = null;
  public int i_need_expose_time = 0;
  public int i_req_flag = 0;
  public String idfa = "";
  public String ip_from_pc_user = "";
  public long l_user = 0L;
  public int pull_as_expose_oper = 0;
  public int request_from = 0;
  public String s_phone_qua = "";
  public String s_req_source = "";
  public ArrayList<tAdvAppInfo> vec_req_app = null;
  
  static
  {
    tAdvAppInfo localtAdvAppInfo = new tAdvAppInfo();
    cache_vec_req_app.add(localtAdvAppInfo);
    cache_ext_user_info = new HashMap();
    cache_ext_user_info.put("", "");
  }
  
  public tPullADVRequest() {}
  
  public tPullADVRequest(long paramLong, ArrayList<tAdvAppInfo> paramArrayList, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, Map<String, String> paramMap, int paramInt3, int paramInt4, String paramString4)
  {
    this.l_user = paramLong;
    this.vec_req_app = paramArrayList;
    this.s_req_source = paramString1;
    this.s_phone_qua = paramString2;
    this.pull_as_expose_oper = paramInt1;
    this.ip_from_pc_user = paramString3;
    this.request_from = paramInt2;
    this.ext_user_info = paramMap;
    this.i_need_expose_time = paramInt3;
    this.i_req_flag = paramInt4;
    this.idfa = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.l_user = paramJceInputStream.read(this.l_user, 0, true);
    this.vec_req_app = ((ArrayList)paramJceInputStream.read(cache_vec_req_app, 1, true));
    this.s_req_source = paramJceInputStream.readString(2, false);
    this.s_phone_qua = paramJceInputStream.readString(3, false);
    this.pull_as_expose_oper = paramJceInputStream.read(this.pull_as_expose_oper, 4, false);
    this.ip_from_pc_user = paramJceInputStream.readString(5, false);
    this.request_from = paramJceInputStream.read(this.request_from, 6, false);
    this.ext_user_info = ((Map)paramJceInputStream.read(cache_ext_user_info, 7, false));
    this.i_need_expose_time = paramJceInputStream.read(this.i_need_expose_time, 8, false);
    this.i_req_flag = paramJceInputStream.read(this.i_req_flag, 9, false);
    this.idfa = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.l_user, 0);
    paramJceOutputStream.write(this.vec_req_app, 1);
    if (this.s_req_source != null) {
      paramJceOutputStream.write(this.s_req_source, 2);
    }
    if (this.s_phone_qua != null) {
      paramJceOutputStream.write(this.s_phone_qua, 3);
    }
    paramJceOutputStream.write(this.pull_as_expose_oper, 4);
    if (this.ip_from_pc_user != null) {
      paramJceOutputStream.write(this.ip_from_pc_user, 5);
    }
    paramJceOutputStream.write(this.request_from, 6);
    if (this.ext_user_info != null) {
      paramJceOutputStream.write(this.ext_user_info, 7);
    }
    paramJceOutputStream.write(this.i_need_expose_time, 8);
    paramJceOutputStream.write(this.i_req_flag, 9);
    if (this.idfa != null) {
      paramJceOutputStream.write(this.idfa, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     BOSSStrategyCenter.tPullADVRequest
 * JD-Core Version:    0.7.0.1
 */