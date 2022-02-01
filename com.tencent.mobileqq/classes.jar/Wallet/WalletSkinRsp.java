package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WalletSkinRsp
  extends JceStruct
{
  public static final int STATUS_CLOSE = 0;
  public static final int STATUS_OPEN = 1;
  public int skinID = 0;
  public int status = 0;
  public long uin = 0L;
  public String zipMd5 = "";
  public String zipUrl = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.skinID = paramJceInputStream.read(this.skinID, 1, false);
    this.zipUrl = paramJceInputStream.readString(2, false);
    this.zipMd5 = paramJceInputStream.readString(3, false);
    this.status = paramJceInputStream.read(this.status, 4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WalletSkinRsp{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", skinID=");
    localStringBuilder.append(this.skinID);
    localStringBuilder.append(", zipUrl='");
    localStringBuilder.append(this.zipUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", zipMd5='");
    localStringBuilder.append(this.zipMd5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.skinID, 1);
    String str = this.zipUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.zipMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.status, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.WalletSkinRsp
 * JD-Core Version:    0.7.0.1
 */