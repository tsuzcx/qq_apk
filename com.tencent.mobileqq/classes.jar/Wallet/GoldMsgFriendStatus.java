package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class GoldMsgFriendStatus
  extends JceStruct
{
  public long goldMsgPrice;
  public int goldMsgSwitch;
  public long uin;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.goldMsgSwitch = paramJceInputStream.read(this.goldMsgSwitch, 1, false);
    this.goldMsgPrice = paramJceInputStream.read(this.goldMsgPrice, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.goldMsgSwitch, 1);
    paramJceOutputStream.write(this.goldMsgPrice, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.GoldMsgFriendStatus
 * JD-Core Version:    0.7.0.1
 */