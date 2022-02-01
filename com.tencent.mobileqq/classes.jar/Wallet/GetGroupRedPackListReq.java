package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetGroupRedPackListReq
  extends JceStruct
{
  public int iGroupType = 0;
  public int iPlatForm = 0;
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
    String str = this.sGroupUin;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.iPlatForm, 1);
    str = this.sQQVersion;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.iGroupType, 3);
    str = this.sUin;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.sSkey;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.sClientIp;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetGroupRedPackListReq
 * JD-Core Version:    0.7.0.1
 */