package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setspaceright_rsp
  extends JceStruct
{
  public long cur_seq;
  
  public mobile_sub_setspaceright_rsp() {}
  
  public mobile_sub_setspaceright_rsp(long paramLong)
  {
    this.cur_seq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cur_seq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setspaceright_rsp
 * JD-Core Version:    0.7.0.1
 */