package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleGetFeedDetailRsp
  extends JceStruct
{
  static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
  public stSimpleMetaFeed feed = null;
  
  public stSimpleGetFeedDetailRsp() {}
  
  public stSimpleGetFeedDetailRsp(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.feed = paramstSimpleMetaFeed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed = ((stSimpleMetaFeed)paramJceInputStream.read(cache_feed, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.feed;
    if (localstSimpleMetaFeed != null) {
      paramJceOutputStream.write(localstSimpleMetaFeed, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedDetailRsp
 * JD-Core Version:    0.7.0.1
 */