package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShuoShuoUgcDeco
  extends JceStruct
{
  static FeedSkin cache_stFeedSkin = new FeedSkin();
  public FeedSkin stFeedSkin;
  
  public ShuoShuoUgcDeco() {}
  
  public ShuoShuoUgcDeco(FeedSkin paramFeedSkin)
  {
    this.stFeedSkin = paramFeedSkin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFeedSkin = ((FeedSkin)paramJceInputStream.read(cache_stFeedSkin, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFeedSkin != null) {
      paramJceOutputStream.write(this.stFeedSkin, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.ShuoShuoUgcDeco
 * JD-Core Version:    0.7.0.1
 */