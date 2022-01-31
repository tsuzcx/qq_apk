package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WalletSkinReq
  extends JceStruct
{
  public static final int SKINID_DEFAULT = 1;
  public static final int TYPE_CLOSE = 2;
  public static final int TYPE_GET = 0;
  public static final int TYPE_OPEN = 1;
  public int skinID;
  public int type;
  public long uin;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.skinID = paramJceInputStream.read(this.skinID, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.skinID, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.WalletSkinReq
 * JD-Core Version:    0.7.0.1
 */