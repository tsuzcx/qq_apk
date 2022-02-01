package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sweet_comm_cfg_get_req
  extends JceStruct
{
  static sweet_req_comm cache_req_comm = new sweet_req_comm();
  static ArrayList<Integer> cache_vec_cfg = new ArrayList();
  public sweet_req_comm req_comm = null;
  public ArrayList<Integer> vec_cfg = null;
  
  static
  {
    cache_vec_cfg.add(Integer.valueOf(0));
  }
  
  public sweet_comm_cfg_get_req() {}
  
  public sweet_comm_cfg_get_req(sweet_req_comm paramsweet_req_comm, ArrayList<Integer> paramArrayList)
  {
    this.req_comm = paramsweet_req_comm;
    this.vec_cfg = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 0, true));
    this.vec_cfg = ((ArrayList)paramJceInputStream.read(cache_vec_cfg, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_comm, 0);
    paramJceOutputStream.write(this.vec_cfg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_req
 * JD-Core Version:    0.7.0.1
 */