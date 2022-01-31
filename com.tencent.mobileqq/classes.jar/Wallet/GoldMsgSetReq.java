package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GoldMsgSetReq
  extends JceStruct
{
  public static final int GOLDMSG_SWITCH_ON = 1;
  public long friendUin;
  public long goldMsgPrice;
  public int goldMsgSwitch;
  public String skey = "";
  
  public GoldMsgSetReq() {}
  
  public GoldMsgSetReq(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    this.friendUin = paramLong1;
    this.goldMsgSwitch = paramInt;
    this.goldMsgPrice = paramLong2;
    this.skey = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendUin = paramJceInputStream.read(this.friendUin, 0, false);
    this.goldMsgSwitch = paramJceInputStream.read(this.goldMsgSwitch, 1, false);
    this.goldMsgPrice = paramJceInputStream.read(this.goldMsgPrice, 2, false);
    this.skey = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.friendUin, 0);
    paramJceOutputStream.write(this.goldMsgSwitch, 1);
    paramJceOutputStream.write(this.goldMsgPrice, 2);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.GoldMsgSetReq
 * JD-Core Version:    0.7.0.1
 */