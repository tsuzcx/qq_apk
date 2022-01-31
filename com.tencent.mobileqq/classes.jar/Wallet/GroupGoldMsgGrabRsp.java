package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupGoldMsgGrabRsp
  extends JceStruct
{
  public String retcode = "";
  public String retmsg = "";
  
  public GroupGoldMsgGrabRsp() {}
  
  public GroupGoldMsgGrabRsp(String paramString1, String paramString2)
  {
    this.retcode = paramString1;
    this.retmsg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retcode = paramJceInputStream.readString(0, true);
    this.retmsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retcode, 0);
    paramJceOutputStream.write(this.retmsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.GroupGoldMsgGrabRsp
 * JD-Core Version:    0.7.0.1
 */