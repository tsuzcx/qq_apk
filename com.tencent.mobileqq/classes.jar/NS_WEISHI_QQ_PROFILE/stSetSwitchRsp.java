package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSetSwitchRsp
  extends JceStruct
{
  static stRspComm cache_rspComm = new stRspComm();
  public stRspComm rspComm;
  
  public stSetSwitchRsp() {}
  
  public stSetSwitchRsp(stRspComm paramstRspComm)
  {
    this.rspComm = paramstRspComm;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rspComm = ((stRspComm)paramJceInputStream.read(cache_rspComm, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rspComm != null) {
      paramJceOutputStream.write(this.rspComm, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stSetSwitchRsp
 * JD-Core Version:    0.7.0.1
 */