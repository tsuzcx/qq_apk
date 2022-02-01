package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDramaFeed
  extends JceStruct
{
  static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
  public String dramaID = "";
  public stSimpleMetaFeed feed = null;
  public String id = "";
  public int num = 0;
  
  public stDramaFeed() {}
  
  public stDramaFeed(String paramString1, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString2)
  {
    this.id = paramString1;
    this.feed = paramstSimpleMetaFeed;
    this.num = paramInt;
    this.dramaID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.feed = ((stSimpleMetaFeed)paramJceInputStream.read(cache_feed, 1, false));
    this.num = paramJceInputStream.read(this.num, 2, false);
    this.dramaID = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.feed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.num, 2);
    localObject = this.dramaID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stDramaFeed
 * JD-Core Version:    0.7.0.1
 */