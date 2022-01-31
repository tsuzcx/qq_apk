package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AIOSendReq
  extends JceStruct
{
  public int iSend;
  public String sAid = "";
  public String sFriendUin = "";
  public String sUin = "";
  
  public AIOSendReq() {}
  
  public AIOSendReq(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.sUin = paramString1;
    this.sFriendUin = paramString2;
    this.iSend = paramInt;
    this.sAid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUin = paramJceInputStream.readString(0, true);
    this.sFriendUin = paramJceInputStream.readString(1, true);
    this.iSend = paramJceInputStream.read(this.iSend, 2, true);
    this.sAid = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.sFriendUin, 1);
    paramJceOutputStream.write(this.iSend, 2);
    paramJceOutputStream.write(this.sAid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     VIP.AIOSendReq
 * JD-Core Version:    0.7.0.1
 */