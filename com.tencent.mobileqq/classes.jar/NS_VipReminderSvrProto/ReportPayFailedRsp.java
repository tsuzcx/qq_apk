package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportPayFailedRsp
  extends JceStruct
{
  public int iRet;
  public String sMsg = "";
  
  public ReportPayFailedRsp() {}
  
  public ReportPayFailedRsp(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.sMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sMsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sMsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_VipReminderSvrProto.ReportPayFailedRsp
 * JD-Core Version:    0.7.0.1
 */