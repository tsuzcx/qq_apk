package NS_QZONE_MQMSG;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShareInfo
  extends JceStruct
{
  static ShareCell cache_shareToFriend = new ShareCell();
  static ShareCell cache_shareToQzone = new ShareCell();
  static single_feed cache_single_feed_data = new single_feed();
  public ShareCell shareToFriend = null;
  public ShareCell shareToQzone = null;
  public single_feed single_feed_data = null;
  
  public ShareInfo() {}
  
  public ShareInfo(ShareCell paramShareCell1, ShareCell paramShareCell2, single_feed paramsingle_feed)
  {
    this.shareToFriend = paramShareCell1;
    this.shareToQzone = paramShareCell2;
    this.single_feed_data = paramsingle_feed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shareToFriend = ((ShareCell)paramJceInputStream.read(cache_shareToFriend, 0, false));
    this.shareToQzone = ((ShareCell)paramJceInputStream.read(cache_shareToQzone, 1, false));
    this.single_feed_data = ((single_feed)paramJceInputStream.read(cache_single_feed_data, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.shareToFriend;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.shareToQzone;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.single_feed_data;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.ShareInfo
 * JD-Core Version:    0.7.0.1
 */