package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqChangeDiscussName
  extends JceStruct
{
  public long DiscussUin = 0L;
  public String NewName = "";
  
  public ReqChangeDiscussName() {}
  
  public ReqChangeDiscussName(long paramLong, String paramString)
  {
    this.DiscussUin = paramLong;
    this.NewName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.NewName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.NewName, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.ReqChangeDiscussName
 * JD-Core Version:    0.7.0.1
 */