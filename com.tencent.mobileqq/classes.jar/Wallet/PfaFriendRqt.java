package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PfaFriendRqt
  extends JceStruct
{
  public String mqq_version = "";
  public String pfa_msg_edition = "";
  public int pfa_sub_type;
  public String skey = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mqq_version = paramJceInputStream.readString(0, true);
    this.pfa_msg_edition = paramJceInputStream.readString(1, true);
    this.skey = paramJceInputStream.readString(2, true);
    this.pfa_sub_type = paramJceInputStream.read(this.pfa_sub_type, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mqq_version, 0);
    paramJceOutputStream.write(this.pfa_msg_edition, 1);
    paramJceOutputStream.write(this.skey, 2);
    paramJceOutputStream.write(this.pfa_sub_type, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.PfaFriendRqt
 * JD-Core Version:    0.7.0.1
 */