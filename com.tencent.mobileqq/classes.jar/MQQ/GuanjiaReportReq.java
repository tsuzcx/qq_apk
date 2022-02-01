package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GuanjiaReportReq
  extends JceStruct
{
  public boolean bKingCard = true;
  public boolean bReportFlag = true;
  public int iCardStatus = 0;
  public int iCardType = 0;
  public int iImplat = 0;
  public String sIdfa = "";
  public String sIdfv = "";
  public String sMac = "";
  public String sMachine = "";
  public String sOsVersion = "";
  public String sPhoneNum = "";
  public String sPkgName = "";
  public long uin = 0L;
  
  public GuanjiaReportReq() {}
  
  public GuanjiaReportReq(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, int paramInt1, String paramString7, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.sIdfa = paramString1;
    this.sIdfv = paramString2;
    this.sMac = paramString3;
    this.sMachine = paramString4;
    this.sOsVersion = paramString5;
    this.sPkgName = paramString6;
    this.uin = paramLong;
    this.iImplat = paramInt1;
    this.sPhoneNum = paramString7;
    this.bKingCard = paramBoolean1;
    this.iCardType = paramInt2;
    this.iCardStatus = paramInt3;
    this.bReportFlag = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIdfa = paramJceInputStream.readString(0, false);
    this.sIdfv = paramJceInputStream.readString(1, false);
    this.sMac = paramJceInputStream.readString(2, false);
    this.sMachine = paramJceInputStream.readString(3, false);
    this.sOsVersion = paramJceInputStream.readString(4, false);
    this.sPkgName = paramJceInputStream.readString(5, false);
    this.uin = paramJceInputStream.read(this.uin, 6, false);
    this.iImplat = paramJceInputStream.read(this.iImplat, 7, false);
    this.sPhoneNum = paramJceInputStream.readString(8, false);
    this.bKingCard = paramJceInputStream.read(this.bKingCard, 9, false);
    this.iCardType = paramJceInputStream.read(this.iCardType, 10, false);
    this.iCardStatus = paramJceInputStream.read(this.iCardStatus, 11, false);
    this.bReportFlag = paramJceInputStream.read(this.bReportFlag, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.sIdfa;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.sIdfv;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.sMac;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.sMachine;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.sOsVersion;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.sPkgName;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.uin, 6);
    paramJceOutputStream.write(this.iImplat, 7);
    str = this.sPhoneNum;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.bKingCard, 9);
    paramJceOutputStream.write(this.iCardType, 10);
    paramJceOutputStream.write(this.iCardStatus, 11);
    paramJceOutputStream.write(this.bReportFlag, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.GuanjiaReportReq
 * JD-Core Version:    0.7.0.1
 */