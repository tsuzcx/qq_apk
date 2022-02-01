package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_upgrade_key_notify_rsp
  extends JceStruct
{
  static sweet_req_comm cache_req_comm = new sweet_req_comm();
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public long host_state = 0L;
  public sweet_req_comm req_comm = null;
  public sweet_rsp_comm rsp_comm = null;
  
  public sweet_upgrade_key_notify_rsp() {}
  
  public sweet_upgrade_key_notify_rsp(sweet_rsp_comm paramsweet_rsp_comm, sweet_req_comm paramsweet_req_comm, long paramLong)
  {
    this.rsp_comm = paramsweet_rsp_comm;
    this.req_comm = paramsweet_req_comm;
    this.host_state = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_comm = ((sweet_rsp_comm)paramJceInputStream.read(cache_rsp_comm, 0, true));
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 1, false));
    this.host_state = paramJceInputStream.read(this.host_state, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_comm, 0);
    sweet_req_comm localsweet_req_comm = this.req_comm;
    if (localsweet_req_comm != null) {
      paramJceOutputStream.write(localsweet_req_comm, 1);
    }
    paramJceOutputStream.write(this.host_state, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWEET_NEW_ICON.sweet_upgrade_key_notify_rsp
 * JD-Core Version:    0.7.0.1
 */