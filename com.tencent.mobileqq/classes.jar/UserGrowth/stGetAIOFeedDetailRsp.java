package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetAIOFeedDetailRsp
  extends JceStruct
{
  static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
  public boolean enable = true;
  public stSimpleMetaFeed feed = null;
  
  public stGetAIOFeedDetailRsp() {}
  
  public stGetAIOFeedDetailRsp(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.enable = paramBoolean;
    this.feed = paramstSimpleMetaFeed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.feed = ((stSimpleMetaFeed)paramJceInputStream.read(cache_feed, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    stSimpleMetaFeed localstSimpleMetaFeed = this.feed;
    if (localstSimpleMetaFeed != null) {
      paramJceOutputStream.write(localstSimpleMetaFeed, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetAIOFeedDetailRsp
 * JD-Core Version:    0.7.0.1
 */