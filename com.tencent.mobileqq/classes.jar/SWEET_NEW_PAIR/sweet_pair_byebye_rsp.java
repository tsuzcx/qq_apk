package SWEET_NEW_PAIR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_pair_byebye_rsp
  extends JceStruct
{
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public sweet_rsp_comm rsp_comm = null;
  
  public sweet_pair_byebye_rsp() {}
  
  public sweet_pair_byebye_rsp(sweet_rsp_comm paramsweet_rsp_comm)
  {
    this.rsp_comm = paramsweet_rsp_comm;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_comm = ((sweet_rsp_comm)paramJceInputStream.read(cache_rsp_comm, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_comm, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWEET_NEW_PAIR.sweet_pair_byebye_rsp
 * JD-Core Version:    0.7.0.1
 */