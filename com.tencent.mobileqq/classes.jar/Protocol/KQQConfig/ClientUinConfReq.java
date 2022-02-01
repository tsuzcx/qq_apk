package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientUinConfReq
  extends JceStruct
{
  static ClientGetUinConfReq cache_clientGetUinConfReq;
  static ClientSetUinConfReq cache_clientSetUinConfReq;
  public ClientGetUinConfReq clientGetUinConfReq = null;
  public ClientSetUinConfReq clientSetUinConfReq = null;
  public int iUinCmdType = 0;
  
  public ClientUinConfReq() {}
  
  public ClientUinConfReq(int paramInt, ClientSetUinConfReq paramClientSetUinConfReq, ClientGetUinConfReq paramClientGetUinConfReq)
  {
    this.iUinCmdType = paramInt;
    this.clientSetUinConfReq = paramClientSetUinConfReq;
    this.clientGetUinConfReq = paramClientGetUinConfReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUinCmdType = paramJceInputStream.read(this.iUinCmdType, 1, true);
    if (cache_clientSetUinConfReq == null) {
      cache_clientSetUinConfReq = new ClientSetUinConfReq();
    }
    this.clientSetUinConfReq = ((ClientSetUinConfReq)paramJceInputStream.read(cache_clientSetUinConfReq, 3, false));
    if (cache_clientGetUinConfReq == null) {
      cache_clientGetUinConfReq = new ClientGetUinConfReq();
    }
    this.clientGetUinConfReq = ((ClientGetUinConfReq)paramJceInputStream.read(cache_clientGetUinConfReq, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUinCmdType, 1);
    Object localObject = this.clientSetUinConfReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.clientGetUinConfReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     protocol.KQQConfig.ClientUinConfReq
 * JD-Core Version:    0.7.0.1
 */