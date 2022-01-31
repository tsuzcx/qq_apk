package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GoldMsgGetRsp
  extends JceStruct
{
  public static int GOLDMSG_SWITCH_ON;
  public static int STATUS_NOTINWHITELIST = 1000;
  static ArrayList cache_vGoldMsgFriend;
  public long goldMsgPrice;
  public int goldMsgSwitch;
  public int status;
  public ArrayList vGoldMsgFriend;
  
  static
  {
    GOLDMSG_SWITCH_ON = 1;
    cache_vGoldMsgFriend = new ArrayList();
    GoldMsgFriendStatus localGoldMsgFriendStatus = new GoldMsgFriendStatus();
    cache_vGoldMsgFriend.add(localGoldMsgFriendStatus);
  }
  
  public GoldMsgGetRsp() {}
  
  public GoldMsgGetRsp(int paramInt, long paramLong)
  {
    this.goldMsgSwitch = paramInt;
    this.goldMsgPrice = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.goldMsgSwitch = paramJceInputStream.read(this.goldMsgSwitch, 0, false);
    this.goldMsgPrice = paramJceInputStream.read(this.goldMsgPrice, 1, false);
    this.status = paramJceInputStream.read(this.status, 2, false);
    this.vGoldMsgFriend = ((ArrayList)paramJceInputStream.read(cache_vGoldMsgFriend, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.goldMsgSwitch, 0);
    paramJceOutputStream.write(this.goldMsgPrice, 1);
    paramJceOutputStream.write(this.status, 2);
    if (this.vGoldMsgFriend != null) {
      paramJceOutputStream.write(this.vGoldMsgFriend, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GoldMsgGetRsp
 * JD-Core Version:    0.7.0.1
 */