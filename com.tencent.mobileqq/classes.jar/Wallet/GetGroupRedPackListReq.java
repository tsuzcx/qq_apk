package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetGroupRedPackListReq
  extends JceStruct
{
  public int iGroupType;
  public int iPlatForm;
  public String sClientIp = "";
  public String sGroupUin = "";
  public String sQQVersion = "";
  public String sSkey = "";
  public String sUin = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sGroupUin = paramJceInputStream.readString(0, false);
    this.iPlatForm = paramJceInputStream.read(this.iPlatForm, 1, false);
    this.sQQVersion = paramJceInputStream.readString(2, false);
    this.iGroupType = paramJceInputStream.read(this.iGroupType, 3, false);
    this.sUin = paramJceInputStream.readString(4, false);
    this.sSkey = paramJceInputStream.readString(5, false);
    this.sClientIp = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sGroupUin != null) {
      paramJceOutputStream.write(this.sGroupUin, 0);
    }
    paramJceOutputStream.write(this.iPlatForm, 1);
    if (this.sQQVersion != null) {
      paramJceOutputStream.write(this.sQQVersion, 2);
    }
    paramJceOutputStream.write(this.iGroupType, 3);
    if (this.sUin != null) {
      paramJceOutputStream.write(this.sUin, 4);
    }
    if (this.sSkey != null) {
      paramJceOutputStream.write(this.sSkey, 5);
    }
    if (this.sClientIp != null) {
      paramJceOutputStream.write(this.sClientIp, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetGroupRedPackListReq
 * JD-Core Version:    0.7.0.1
 */