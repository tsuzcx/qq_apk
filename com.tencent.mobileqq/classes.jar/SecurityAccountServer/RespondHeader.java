package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespondHeader
  extends JceStruct
{
  public String account = "";
  public int cmd = 0;
  public String ksid = "";
  public int requestID = 0;
  public int result = 0;
  public int svrSeqNo = 0;
  public String tips = "";
  public int ver = 0;
  
  public RespondHeader() {}
  
  public RespondHeader(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2, String paramString3)
  {
    this.ver = paramInt1;
    this.cmd = paramInt2;
    this.requestID = paramInt3;
    this.account = paramString1;
    this.svrSeqNo = paramInt4;
    this.result = paramInt5;
    this.ksid = paramString2;
    this.tips = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.cmd = paramJceInputStream.read(this.cmd, 1, true);
    this.requestID = paramJceInputStream.read(this.requestID, 2, true);
    this.account = paramJceInputStream.readString(3, true);
    this.svrSeqNo = paramJceInputStream.read(this.svrSeqNo, 4, true);
    this.result = paramJceInputStream.read(this.result, 5, true);
    this.ksid = paramJceInputStream.readString(6, true);
    this.tips = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.cmd, 1);
    paramJceOutputStream.write(this.requestID, 2);
    paramJceOutputStream.write(this.account, 3);
    paramJceOutputStream.write(this.svrSeqNo, 4);
    paramJceOutputStream.write(this.result, 5);
    paramJceOutputStream.write(this.ksid, 6);
    String str = this.tips;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SecurityAccountServer.RespondHeader
 * JD-Core Version:    0.7.0.1
 */