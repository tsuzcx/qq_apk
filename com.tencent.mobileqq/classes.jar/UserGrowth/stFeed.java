package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stFeed
  extends JceStruct
{
  static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
  static stFriendFeed cache_friendFeed = new stFriendFeed();
  static ArrayList<stSimpleMetaPerson> cache_person_meta = new ArrayList();
  static stSplitBlock cache_recommend_splitter;
  public stSimpleMetaFeed feed = null;
  public int feed_type = 0;
  public stFriendFeed friendFeed = null;
  public ArrayList<stSimpleMetaPerson> person_meta = null;
  public stSplitBlock recommend_splitter = null;
  
  static
  {
    stSimpleMetaPerson localstSimpleMetaPerson = new stSimpleMetaPerson();
    cache_person_meta.add(localstSimpleMetaPerson);
    cache_recommend_splitter = new stSplitBlock();
  }
  
  public stFeed() {}
  
  public stFeed(stSimpleMetaFeed paramstSimpleMetaFeed, ArrayList<stSimpleMetaPerson> paramArrayList, int paramInt, stSplitBlock paramstSplitBlock, stFriendFeed paramstFriendFeed)
  {
    this.feed = paramstSimpleMetaFeed;
    this.person_meta = paramArrayList;
    this.feed_type = paramInt;
    this.recommend_splitter = paramstSplitBlock;
    this.friendFeed = paramstFriendFeed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed = ((stSimpleMetaFeed)paramJceInputStream.read(cache_feed, 0, false));
    this.person_meta = ((ArrayList)paramJceInputStream.read(cache_person_meta, 1, false));
    this.feed_type = paramJceInputStream.read(this.feed_type, 2, false);
    this.recommend_splitter = ((stSplitBlock)paramJceInputStream.read(cache_recommend_splitter, 3, false));
    this.friendFeed = ((stFriendFeed)paramJceInputStream.read(cache_friendFeed, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.feed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.person_meta;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.feed_type, 2);
    localObject = this.recommend_splitter;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.friendFeed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFeed
 * JD-Core Version:    0.7.0.1
 */