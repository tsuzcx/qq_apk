package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSetSwitchReq
  extends JceStruct
{
  public int op;
  public long uin;
  
  public stSetSwitchReq() {}
  
  public stSetSwitchReq(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.op = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.op = paramJceInputStream.read(this.op, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.op, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stSetSwitchReq
 * JD-Core Version:    0.7.0.1
 */