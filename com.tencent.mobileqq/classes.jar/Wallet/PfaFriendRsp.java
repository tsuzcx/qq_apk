package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PfaFriendRsp
  extends JceStruct
{
  static ArrayList<String> cache_vecPfaMsg;
  static ArrayList<PfaFriend> cache_vecRec = new ArrayList();
  static ArrayList<PfaFriend> cache_vecSpfaRec;
  public String pfa_msg_edition = "";
  public int ret = 0;
  public int use_default = 0;
  public ArrayList<String> vecPfaMsg = null;
  public ArrayList<PfaFriend> vecRec = null;
  public ArrayList<PfaFriend> vecSpfaRec = null;
  
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
    Object localObject = this.vecRec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.pfa_msg_edition;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.vecPfaMsg;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.vecSpfaRec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.PfaFriendRsp
 * JD-Core Version:    0.7.0.1
 */