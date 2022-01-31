package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqChannel
  extends JceStruct
  implements Cloneable
{
  static LBSInfo cache_lbsInfo;
  public String MQVersion = "";
  public LBSInfo lbsInfo;
  public int nfcSupported;
  public String phoneModel = "";
  public int pid;
  public int subCmd;
  
  public ReqChannel() {}
  
  public ReqChannel(int paramInt1, int paramInt2, LBSInfo paramLBSInfo, String paramString1, int paramInt3, String paramString2)
  {
    this.subCmd = paramInt1;
    this.pid = paramInt2;
    this.lbsInfo = paramLBSInfo;
    this.phoneModel = paramString1;
    this.nfcSupported = paramInt3;
    this.MQVersion = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.pid = paramJceInputStream.read(this.pid, 1, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 2, true));
    this.phoneModel = paramJceInputStream.readString(3, true);
    this.nfcSupported = paramJceInputStream.read(this.nfcSupported, 4, false);
    this.MQVersion = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.pid, 1);
    paramJceOutputStream.write(this.lbsInfo, 2);
    paramJceOutputStream.write(this.phoneModel, 3);
    paramJceOutputStream.write(this.nfcSupported, 4);
    if (this.MQVersion != null) {
      paramJceOutputStream.write(this.MQVersion, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     CardPay.ReqChannel
 * JD-Core Version:    0.7.0.1
 */