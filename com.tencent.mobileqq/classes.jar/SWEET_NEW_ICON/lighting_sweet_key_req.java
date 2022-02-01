package SWEET_NEW_ICON;

import SWEET_NEW_BASE.sweet_req_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class lighting_sweet_key_req
  extends JceStruct
{
  static sweet_req_comm cache_req_comm = new sweet_req_comm();
  public boolean is_reset_data = false;
  public sweet_req_comm req_comm = null;
  
  public lighting_sweet_key_req() {}
  
  public lighting_sweet_key_req(sweet_req_comm paramsweet_req_comm, boolean paramBoolean)
  {
    this.req_comm = paramsweet_req_comm;
    this.is_reset_data = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_comm = ((sweet_req_comm)paramJceInputStream.read(cache_req_comm, 0, true));
    this.is_reset_data = paramJceInputStream.read(this.is_reset_data, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_comm, 0);
    paramJceOutputStream.write(this.is_reset_data, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWEET_NEW_ICON.lighting_sweet_key_req
 * JD-Core Version:    0.7.0.1
 */