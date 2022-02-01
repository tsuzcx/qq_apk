package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetDiscuss
  extends JceStruct
{
  public long Uin = 0L;
  
  public ReqGetDiscuss() {}
  
  public ReqGetDiscuss(long paramLong)
  {
    this.Uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Uin = paramJceInputStream.read(this.Uin, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Uin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqGetDiscuss
 * JD-Core Version:    0.7.0.1
 */