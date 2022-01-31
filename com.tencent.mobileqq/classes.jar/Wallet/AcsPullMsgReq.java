package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsPullMsgReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public String day = "";
  public AcsHead head;
  public long uin;
  
  public AcsPullMsgReq() {}
  
  public AcsPullMsgReq(AcsHead paramAcsHead, long paramLong, String paramString)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.day = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.day = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.head != null) {
      paramJceOutputStream.write(this.head, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    if (this.day != null) {
      paramJceOutputStream.write(this.day, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsPullMsgReq
 * JD-Core Version:    0.7.0.1
 */