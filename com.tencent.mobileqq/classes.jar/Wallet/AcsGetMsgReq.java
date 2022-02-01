package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsGetMsgReq
  extends JceStruct
{
  static AcsHead cache_head = new AcsHead();
  public String domain = "";
  public AcsHead head = null;
  public String msg_id = "";
  public long uin = 0L;
  
  public AcsGetMsgReq() {}
  
  public AcsGetMsgReq(AcsHead paramAcsHead, long paramLong, String paramString1, String paramString2)
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
    Object localObject = this.head;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    localObject = this.msg_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.domain;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsGetMsgReq
 * JD-Core Version:    0.7.0.1
 */