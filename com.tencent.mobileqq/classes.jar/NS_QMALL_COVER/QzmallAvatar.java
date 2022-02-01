package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.AvatarItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallAvatar
  extends JceStruct
{
  static AvatarItem cache_stAvatarItem = new AvatarItem();
  public AvatarItem stAvatarItem = null;
  
  public QzmallAvatar() {}
  
  public QzmallAvatar(AvatarItem paramAvatarItem)
  {
    this.stAvatarItem = paramAvatarItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stAvatarItem = ((AvatarItem)paramJceInputStream.read(cache_stAvatarItem, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    AvatarItem localAvatarItem = this.stAvatarItem;
    if (localAvatarItem != null) {
      paramJceOutputStream.write(localAvatarItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallAvatar
 * JD-Core Version:    0.7.0.1
 */