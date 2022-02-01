package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stFriendFeed
  extends JceStruct
{
  static ArrayList<stSimpleMetaFeed> cache_friendFeeds = new ArrayList();
  public String attachInfo = "";
  public String dialogTips = "";
  public ArrayList<stSimpleMetaFeed> friendFeeds = null;
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_friendFeeds.add(localstSimpleMetaFeed);
  }
  
  public stFriendFeed() {}
  
  public stFriendFeed(ArrayList<stSimpleMetaFeed> paramArrayList, String paramString1, String paramString2)
  {
    this.friendFeeds = paramArrayList;
    this.attachInfo = paramString1;
    this.dialogTips = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.friendFeeds = ((ArrayList)paramJceInputStream.read(cache_friendFeeds, 0, false));
    this.attachInfo = paramJceInputStream.readString(1, false);
    this.dialogTips = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.friendFeeds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.dialogTips;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFriendFeed
 * JD-Core Version:    0.7.0.1
 */