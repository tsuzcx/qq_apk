package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stGetDramaFeedsRsp
  extends JceStruct
{
  static stDrama cache_drama = new stDrama();
  static ArrayList<stDramaFeed> cache_dramaFeeds = new ArrayList();
  public String attachInfo = "";
  public String curFeedID = "";
  public stDrama drama = null;
  public ArrayList<stDramaFeed> dramaFeeds = null;
  public boolean isFinished = true;
  public int refresh = 0;
  
  static
  {
    stDramaFeed localstDramaFeed = new stDramaFeed();
    cache_dramaFeeds.add(localstDramaFeed);
  }
  
  public stGetDramaFeedsRsp() {}
  
  public stGetDramaFeedsRsp(String paramString1, boolean paramBoolean, stDrama paramstDrama, ArrayList<stDramaFeed> paramArrayList, int paramInt, String paramString2)
  {
    this.attachInfo = paramString1;
    this.isFinished = paramBoolean;
    this.drama = paramstDrama;
    this.dramaFeeds = paramArrayList;
    this.refresh = paramInt;
    this.curFeedID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 1, false);
    this.drama = ((stDrama)paramJceInputStream.read(cache_drama, 2, false));
    this.dramaFeeds = ((ArrayList)paramJceInputStream.read(cache_dramaFeeds, 3, false));
    this.refresh = paramJceInputStream.read(this.refresh, 4, false);
    this.curFeedID = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.isFinished, 1);
    localObject = this.drama;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.dramaFeeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.refresh, 4);
    localObject = this.curFeedID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetDramaFeedsRsp
 * JD-Core Version:    0.7.0.1
 */