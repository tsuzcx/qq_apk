package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QbossAdv
  extends JceStruct
{
  public int iAdId;
  public int iAdType;
  public int iBoardId;
  public String sBosstrace = "";
  public String sExtData = "";
  public String sPostrace = "";
  
  public QbossAdv() {}
  
  public QbossAdv(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.iAdId = paramInt1;
    this.iAdType = paramInt2;
    this.iBoardId = paramInt3;
    this.sBosstrace = paramString1;
    this.sExtData = paramString2;
    this.sPostrace = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAdId = paramJceInputStream.read(this.iAdId, 0, true);
    this.iAdType = paramJceInputStream.read(this.iAdType, 1, true);
    this.iBoardId = paramJceInputStream.read(this.iBoardId, 2, true);
    this.sBosstrace = paramJceInputStream.readString(3, true);
    this.sExtData = paramJceInputStream.readString(4, true);
    this.sPostrace = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAdId, 0);
    paramJceOutputStream.write(this.iAdType, 1);
    paramJceOutputStream.write(this.iBoardId, 2);
    paramJceOutputStream.write(this.sBosstrace, 3);
    paramJceOutputStream.write(this.sExtData, 4);
    paramJceOutputStream.write(this.sPostrace, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_VipReminderSvrProto.QbossAdv
 * JD-Core Version:    0.7.0.1
 */