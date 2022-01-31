package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsDelMsgReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public String domain = "";
  public AcsHead head;
  public String msg_id = "";
  public long uin;
  
  public AcsDelMsgReq() {}
  
  public AcsDelMsgReq(AcsHead paramAcsHead, long paramLong, String paramString1, String paramString2)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.msg_id = paramString1;
    this.domain = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.msg_id = paramJceInputStream.readString(2, false);
    this.domain = paramJceInputStream.readString(3, false);
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
    if (this.domain != null) {
      paramJceOutputStream.write(this.domain, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsDelMsgReq
 * JD-Core Version:    0.7.0.1
 */