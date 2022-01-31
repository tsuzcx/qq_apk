package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PfaFriendRsp
  extends JceStruct
{
  static ArrayList cache_vecPfaMsg;
  static ArrayList cache_vecRec = new ArrayList();
  static ArrayList cache_vecSpfaRec;
  public String pfa_msg_edition = "";
  public int ret;
  public int use_default;
  public ArrayList vecPfaMsg;
  public ArrayList vecRec;
  public ArrayList vecSpfaRec;
  
  static
  {
    PfaFriend localPfaFriend = new PfaFriend();
    cache_vecRec.add(localPfaFriend);
    cache_vecPfaMsg = new ArrayList();
    cache_vecPfaMsg.add("");
    cache_vecSpfaRec = new ArrayList();
    localPfaFriend = new PfaFriend();
    cache_vecSpfaRec.add(localPfaFriend);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.use_default = paramJceInputStream.read(this.use_default, 1, true);
    this.vecRec = ((ArrayList)paramJceInputStream.read(cache_vecRec, 2, false));
    this.pfa_msg_edition = paramJceInputStream.readString(3, false);
    this.vecPfaMsg = ((ArrayList)paramJceInputStream.read(cache_vecPfaMsg, 4, false));
    this.vecSpfaRec = ((ArrayList)paramJceInputStream.read(cache_vecSpfaRec, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.use_default, 1);
    if (this.vecRec != null) {
      paramJceOutputStream.write(this.vecRec, 2);
    }
    if (this.pfa_msg_edition != null) {
      paramJceOutputStream.write(this.pfa_msg_edition, 3);
    }
    if (this.vecPfaMsg != null) {
      paramJceOutputStream.write(this.vecPfaMsg, 4);
    }
    if (this.vecSpfaRec != null) {
      paramJceOutputStream.write(this.vecSpfaRec, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.PfaFriendRsp
 * JD-Core Version:    0.7.0.1
 */