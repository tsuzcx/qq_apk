package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class sweet_comm_cfg_get_rsp
  extends JceStruct
{
  static Map<Long, sweet_comm_cfg_item> cache_m_cfg_res;
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public Map<Long, sweet_comm_cfg_item> m_cfg_res = null;
  public sweet_rsp_comm rsp_comm = null;
  
  static
  {
    cache_m_cfg_res = new HashMap();
    sweet_comm_cfg_item localsweet_comm_cfg_item = new sweet_comm_cfg_item();
    cache_m_cfg_res.put(Long.valueOf(0L), localsweet_comm_cfg_item);
  }
  
  public sweet_comm_cfg_get_rsp() {}
  
  public sweet_comm_cfg_get_rsp(sweet_rsp_comm paramsweet_rsp_comm, Map<Long, sweet_comm_cfg_item> paramMap)
  {
    this.rsp_comm = paramsweet_rsp_comm;
    this.m_cfg_res = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_comm = ((sweet_rsp_comm)paramJceInputStream.read(cache_rsp_comm, 0, true));
    this.m_cfg_res = ((Map)paramJceInputStream.read(cache_m_cfg_res, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_comm, 0);
    paramJceOutputStream.write(this.m_cfg_res, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_rsp
 * JD-Core Version:    0.7.0.1
 */