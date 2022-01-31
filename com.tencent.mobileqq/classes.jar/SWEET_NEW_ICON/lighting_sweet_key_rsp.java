package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class lighting_sweet_key_rsp
  extends JceStruct
{
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public sweet_rsp_comm rsp_comm;
  
  public lighting_sweet_key_rsp() {}
  
  public lighting_sweet_key_rsp(sweet_rsp_comm paramsweet_rsp_comm)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWEET_NEW_ICON.lighting_sweet_key_rsp
 * JD-Core Version:    0.7.0.1
 */