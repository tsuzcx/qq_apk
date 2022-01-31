package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShareInfo
  extends JceStruct
{
  static ShareCell cache_shareToFriend = new ShareCell();
  static ShareCell cache_shareToQzone = new ShareCell();
  public ShareCell shareToFriend;
  public ShareCell shareToQzone;
  
  public ShareInfo() {}
  
  public ShareInfo(ShareCell paramShareCell1, ShareCell paramShareCell2)
  {
    this.shareToFriend = paramShareCell1;
    this.shareToQzone = paramShareCell2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shareToFriend = ((ShareCell)paramJceInputStream.read(cache_shareToFriend, 0, false));
    this.shareToQzone = ((ShareCell)paramJceInputStream.read(cache_shareToQzone, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.shareToFriend != null) {
      paramJceOutputStream.write(this.shareToFriend, 0);
    }
    if (this.shareToQzone != null) {
      paramJceOutputStream.write(this.shareToQzone, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.ShareInfo
 * JD-Core Version:    0.7.0.1
 */