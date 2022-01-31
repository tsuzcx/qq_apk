package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsGetMsgListReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public AcsHead head;
  public int record_size;
  public int record_start;
  public long uin;
  
  public AcsGetMsgListReq() {}
  
  public AcsGetMsgListReq(AcsHead paramAcsHead, long paramLong, int paramInt1, int paramInt2)
  {
    this.head = paramAcsHead;
    this.uin = paramLong;
    this.record_start = paramInt1;
    this.record_size = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.head = ((AcsHead)paramJceInputStream.read(cache_head, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.record_start = paramJceInputStream.read(this.record_start, 2, true);
    this.record_size = paramJceInputStream.read(this.record_size, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.head != null) {
      paramJceOutputStream.write(this.head, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.record_start, 2);
    paramJceOutputStream.write(this.record_size, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsGetMsgListReq
 * JD-Core Version:    0.7.0.1
 */