package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsPullMsgReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public String day = "";
  public AcsHead head = null;
  public long uin = 0L;
  
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
    Object localObject = this.head;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    localObject = this.day;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsPullMsgReq
 * JD-Core Version:    0.7.0.1
 */