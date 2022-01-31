package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportPayFailedReq
  extends JceStruct
{
  public int iErrorCode;
  public int iSrc;
  public int iStep;
  public String sAid = "";
  public String sQua = "";
  public String sReason = "";
  public long uiUin;
  
  public ReportPayFailedReq() {}
  
  public ReportPayFailedReq(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.sAid = paramString1;
    this.uiUin = paramLong;
    this.sQua = paramString2;
    this.iSrc = paramInt1;
    this.iStep = paramInt2;
    this.iErrorCode = paramInt3;
    this.sReason = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sAid = paramJceInputStream.readString(0, true);
    this.uiUin = paramJceInputStream.read(this.uiUin, 1, true);
    this.sQua = paramJceInputStream.readString(2, false);
    this.iSrc = paramJceInputStream.read(this.iSrc, 3, false);
    this.iStep = paramJceInputStream.read(this.iStep, 4, false);
    this.iErrorCode = paramJceInputStream.read(this.iErrorCode, 5, false);
    this.sReason = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sAid, 0);
    paramJceOutputStream.write(this.uiUin, 1);
    if (this.sQua != null) {
      paramJceOutputStream.write(this.sQua, 2);
    }
    paramJceOutputStream.write(this.iSrc, 3);
    paramJceOutputStream.write(this.iStep, 4);
    paramJceOutputStream.write(this.iErrorCode, 5);
    if (this.sReason != null) {
      paramJceOutputStream.write(this.sReason, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_VipReminderSvrProto.ReportPayFailedReq
 * JD-Core Version:    0.7.0.1
 */