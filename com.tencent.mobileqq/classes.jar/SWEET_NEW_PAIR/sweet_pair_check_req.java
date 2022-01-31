package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_pair_check_req
  extends JceStruct
{
  static sweet_req_comm cache_req_comm = new sweet_req_comm();
  public boolean need_check_visit_right;
  public boolean need_get_invite_lst;
  public sweet_req_comm req_comm;
  
  public sweet_pair_check_req() {}
  
  public sweet_pair_check_req(sweet_req_comm paramsweet_req_comm, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.req_comm = paramsweet_req_comm;
    this.need_check_visit_right = paramBoolean1;
    this.need_get_invite_lst = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 0, true));
    this.need_check_visit_right = paramJceInputStream.read(this.need_check_visit_right, 1, false);
    this.need_get_invite_lst = paramJceInputStream.read(this.need_get_invite_lst, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_comm, 0);
    paramJceOutputStream.write(this.need_check_visit_right, 1);
    paramJceOutputStream.write(this.need_get_invite_lst, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SWEET_NEW_PAIR.sweet_pair_check_req
 * JD-Core Version:    0.7.0.1
 */