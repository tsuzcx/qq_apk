package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class sweet_pair_check_rsp
  extends JceStruct
{
  static int cache_host_state;
  static ArrayList cache_lst_invite;
  static sweet_req_comm cache_req_comm;
  static int cache_right;
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public int host_state;
  public ArrayList lst_invite;
  public sweet_req_comm req_comm;
  public int right;
  public sweet_rsp_comm rsp_comm;
  
  static
  {
    cache_req_comm = new sweet_req_comm();
    cache_host_state = 0;
    cache_right = 0;
    cache_lst_invite = new ArrayList();
    invite_item localinvite_item = new invite_item();
    cache_lst_invite.add(localinvite_item);
  }
  
  public sweet_pair_check_rsp() {}
  
  public sweet_pair_check_rsp(sweet_rsp_comm paramsweet_rsp_comm, sweet_req_comm paramsweet_req_comm, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.rsp_comm = paramsweet_rsp_comm;
    this.req_comm = paramsweet_req_comm;
    this.host_state = paramInt1;
    this.right = paramInt2;
    this.lst_invite = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_comm = ((sweet_rsp_comm)paramJceInputStream.read(cache_rsp_comm, 0, true));
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 1, false));
    this.host_state = paramJceInputStream.read(this.host_state, 2, false);
    this.right = paramJceInputStream.read(this.right, 3, false);
    this.lst_invite = ((ArrayList)paramJceInputStream.read(cache_lst_invite, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_comm, 0);
    if (this.req_comm != null) {
      paramJceOutputStream.write(this.req_comm, 1);
    }
    paramJceOutputStream.write(this.host_state, 2);
    paramJceOutputStream.write(this.right, 3);
    if (this.lst_invite != null) {
      paramJceOutputStream.write(this.lst_invite, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWEET_NEW_PAIR.sweet_pair_check_rsp
 * JD-Core Version:    0.7.0.1
 */