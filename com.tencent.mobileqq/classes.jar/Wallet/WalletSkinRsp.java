package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WalletSkinRsp
  extends JceStruct
{
  public static final int STATUS_CLOSE = 0;
  public static final int STATUS_OPEN = 1;
  public int skinID;
  public int status;
  public long uin;
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
    return "WalletSkinRsp{uin=" + this.uin + ", skinID=" + this.skinID + ", zipUrl='" + this.zipUrl + '\'' + ", zipMd5='" + this.zipMd5 + '\'' + ", status=" + this.status + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.skinID, 1);
    if (this.zipUrl != null) {
      paramJceOutputStream.write(this.zipUrl, 2);
    }
    if (this.zipMd5 != null) {
      paramJceOutputStream.write(this.zipMd5, 3);
    }
    paramJceOutputStream.write(this.status, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.WalletSkinRsp
 * JD-Core Version:    0.7.0.1
 */