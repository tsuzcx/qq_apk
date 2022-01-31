package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientMsg
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static Msg cache_stMsg;
  public ReqHeader stHeader;
  public Msg stMsg;
  
  public ClientMsg() {}
  
  public ClientMsg(ReqHeader paramReqHeader, Msg paramMsg)
  {
    this.stHeader = paramReqHeader;
    this.stMsg = paramMsg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stMsg == null) {
      cache_stMsg = new Msg();
    }
    this.stMsg = ((Msg)paramJceInputStream.read(cache_stMsg, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stMsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AccostSvc.ClientMsg
 * JD-Core Version:    0.7.0.1
 */