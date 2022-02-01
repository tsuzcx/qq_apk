package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsQueryReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public AcsHead head;
  public String msg_id = "";
  public long uin;
  
  public AcsQueryReq() {}
  
  public AcsQueryReq(AcsHead paramAcsHead, long paramLong, String paramString)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.msg_id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.msg_id = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.head != null) {
      paramJceOutputStream.write(this.head, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    if (this.msg_id != null) {
      paramJceOutputStream.write(this.msg_id, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsQueryReq
 * JD-Core Version:    0.7.0.1
 */