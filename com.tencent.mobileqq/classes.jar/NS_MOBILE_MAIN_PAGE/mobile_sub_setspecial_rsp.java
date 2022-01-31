package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setspecial_rsp
  extends JceStruct
{
  public int carestatus;
  public int ret;
  
  public mobile_sub_setspecial_rsp() {}
  
  public mobile_sub_setspecial_rsp(int paramInt1, int paramInt2)
  {
    this.ret = paramInt1;
    this.carestatus = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.carestatus = paramJceInputStream.read(this.carestatus, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.carestatus, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setspecial_rsp
 * JD-Core Version:    0.7.0.1
 */