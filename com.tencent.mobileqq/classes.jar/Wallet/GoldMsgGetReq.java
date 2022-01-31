package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GoldMsgGetReq
  extends JceStruct
{
  public static final int TYPE_ALL = 3;
  public static final int TYPE_FRIEND_2_SELF = 1;
  public static final int TYPE_SELF_2_FRIEND = 2;
  public long friendUin;
  public String skey = "";
  public int type;
  
  public GoldMsgGetReq() {}
  
  public GoldMsgGetReq(int paramInt, long paramLong, String paramString)
  {
    this.type = paramInt;
    this.friendUin = paramLong;
    this.skey = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.friendUin = paramJceInputStream.read(this.friendUin, 1, false);
    this.skey = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.friendUin, 1);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GoldMsgGetReq
 * JD-Core Version:    0.7.0.1
 */