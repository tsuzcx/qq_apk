package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Order
  extends JceStruct
  implements Cloneable
{
  public String OrderId = "";
  public int OrigPayAmt;
  public int PayAmt;
  public String PayChannel = "";
  public String PayChannelSubId = "";
  public String PayInfo = "";
  public String PayItem = "";
  public String PayRemark = "";
  public int PayState;
  public String PayUin = "";
  public int PayUnit;
  public String PortalExtendField = "";
  public String PortalSerialNo = "";
  public int ProvideState;
  public String ProvideUin = "";
  public long QQuin;
  public long SerialNo;
  public String ServiceCode = "";
  public String ServiceType = "";
  public String Source = "";
  public long Time;
  public String UserIP = "";
  
  public Order() {}
  
  public Order(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, int paramInt4, int paramInt5, long paramLong2, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, long paramLong3, String paramString12, String paramString13, String paramString14)
  {
    this.PayState = paramInt1;
    this.ProvideState = paramInt2;
    this.ServiceType = paramString1;
    this.ServiceCode = paramString2;
    this.QQuin = paramLong1;
    this.PayUin = paramString3;
    this.ProvideUin = paramString4;
    this.PayChannel = paramString5;
    this.PayChannelSubId = paramString6;
    this.PayAmt = paramInt3;
    this.OrigPayAmt = paramInt4;
    this.PayUnit = paramInt5;
    this.SerialNo = paramLong2;
    this.PortalSerialNo = paramString7;
    this.PayInfo = paramString8;
    this.PayRemark = paramString9;
    this.PortalExtendField = paramString10;
    this.Source = paramString11;
    this.Time = paramLong3;
    this.UserIP = paramString12;
    this.PayItem = paramString13;
    this.OrderId = paramString14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.PayState = paramJceInputStream.read(this.PayState, 0, true);
    this.ProvideState = paramJceInputStream.read(this.ProvideState, 1, true);
    this.ServiceType = paramJceInputStream.readString(2, true);
    this.ServiceCode = paramJceInputStream.readString(3, true);
    this.QQuin = paramJceInputStream.read(this.QQuin, 4, true);
    this.PayUin = paramJceInputStream.readString(5, true);
    this.ProvideUin = paramJceInputStream.readString(6, true);
    this.PayChannel = paramJceInputStream.readString(7, true);
    this.PayChannelSubId = paramJceInputStream.readString(8, true);
    this.PayAmt = paramJceInputStream.read(this.PayAmt, 9, true);
    this.OrigPayAmt = paramJceInputStream.read(this.OrigPayAmt, 10, true);
    this.PayUnit = paramJceInputStream.read(this.PayUnit, 11, true);
    this.SerialNo = paramJceInputStream.read(this.SerialNo, 12, true);
    this.PortalSerialNo = paramJceInputStream.readString(13, true);
    this.PayInfo = paramJceInputStream.readString(14, true);
    this.PayRemark = paramJceInputStream.readString(15, true);
    this.PortalExtendField = paramJceInputStream.readString(16, true);
    this.Source = paramJceInputStream.readString(17, true);
    this.Time = paramJceInputStream.read(this.Time, 18, true);
    this.UserIP = paramJceInputStream.readString(19, true);
    this.PayItem = paramJceInputStream.readString(20, true);
    this.OrderId = paramJceInputStream.readString(21, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PayState, 0);
    paramJceOutputStream.write(this.ProvideState, 1);
    paramJceOutputStream.write(this.ServiceType, 2);
    paramJceOutputStream.write(this.ServiceCode, 3);
    paramJceOutputStream.write(this.QQuin, 4);
    paramJceOutputStream.write(this.PayUin, 5);
    paramJceOutputStream.write(this.ProvideUin, 6);
    paramJceOutputStream.write(this.PayChannel, 7);
    paramJceOutputStream.write(this.PayChannelSubId, 8);
    paramJceOutputStream.write(this.PayAmt, 9);
    paramJceOutputStream.write(this.OrigPayAmt, 10);
    paramJceOutputStream.write(this.PayUnit, 11);
    paramJceOutputStream.write(this.SerialNo, 12);
    paramJceOutputStream.write(this.PortalSerialNo, 13);
    paramJceOutputStream.write(this.PayInfo, 14);
    paramJceOutputStream.write(this.PayRemark, 15);
    paramJceOutputStream.write(this.PortalExtendField, 16);
    paramJceOutputStream.write(this.Source, 17);
    paramJceOutputStream.write(this.Time, 18);
    paramJceOutputStream.write(this.UserIP, 19);
    paramJceOutputStream.write(this.PayItem, 20);
    paramJceOutputStream.write(this.OrderId, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     CardPay.Order
 * JD-Core Version:    0.7.0.1
 */