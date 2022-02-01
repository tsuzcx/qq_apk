package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_upgrade_key_notify_req
  extends JceStruct
{
  static sweet_req_comm cache_req_comm = new sweet_req_comm();
  public sweet_req_comm req_comm = null;
  
  public sweet_upgrade_key_notify_req() {}
  
  public sweet_upgrade_key_notify_req(sweet_req_comm paramsweet_req_comm)
  {
    this.req_comm = paramsweet_req_comm;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_comm, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWEET_NEW_ICON.sweet_upgrade_key_notify_req
 * JD-Core Version:    0.7.0.1
 */