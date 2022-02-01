package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniSetExtFriendReq
  extends JceStruct
{
  static ExtendFriend cache_stExtendFriend = new ExtendFriend();
  static LoginInfo cache_stLogin = new LoginInfo();
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public ExtendFriend stExtendFriend = null;
  public LoginInfo stLogin = null;
  public UniBusinessItem stUniBusinessItem = null;
  
  public UniSetExtFriendReq() {}
  
  public UniSetExtFriendReq(LoginInfo paramLoginInfo, UniBusinessItem paramUniBusinessItem, ExtendFriend paramExtendFriend)
  {
    this.stLogin = paramLoginInfo;
    this.stUniBusinessItem = paramUniBusinessItem;
    this.stExtendFriend = paramExtendFriend;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.stUniBusinessItem = ((UniBusinessItem)paramJceInputStream.read(cache_stUniBusinessItem, 1, true));
    this.stExtendFriend = ((ExtendFriend)paramJceInputStream.read(cache_stExtendFriend, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    paramJceOutputStream.write(this.stUniBusinessItem, 1);
    ExtendFriend localExtendFriend = this.stExtendFriend;
    if (localExtendFriend != null) {
      paramJceOutputStream.write(localExtendFriend, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniSetExtFriendReq
 * JD-Core Version:    0.7.0.1
 */