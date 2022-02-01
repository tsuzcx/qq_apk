package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.FeedSkinInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallFeedSkin
  extends JceStruct
{
  static FeedSkinInfo cache_stFeedSkinInfo = new FeedSkinInfo();
  public FeedSkinInfo stFeedSkinInfo = null;
  
  public QzmallFeedSkin() {}
  
  public QzmallFeedSkin(FeedSkinInfo paramFeedSkinInfo)
  {
    this.stFeedSkinInfo = paramFeedSkinInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFeedSkinInfo = ((FeedSkinInfo)paramJceInputStream.read(cache_stFeedSkinInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFeedSkinInfo != null) {
      paramJceOutputStream.write(this.stFeedSkinInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallFeedSkin
 * JD-Core Version:    0.7.0.1
 */