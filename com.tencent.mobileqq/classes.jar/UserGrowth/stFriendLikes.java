package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stFriendLikes
  extends JceStruct
{
  static ArrayList<stFriendLike> cache_likeFriends = new ArrayList();
  public ArrayList<stFriendLike> likeFriends = null;
  public int total = 0;
  
  static
  {
    stFriendLike localstFriendLike = new stFriendLike();
    cache_likeFriends.add(localstFriendLike);
  }
  
  public stFriendLikes() {}
  
  public stFriendLikes(ArrayList<stFriendLike> paramArrayList, int paramInt)
  {
    this.likeFriends = paramArrayList;
    this.total = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.likeFriends = ((ArrayList)paramJceInputStream.read(cache_likeFriends, 0, false));
    this.total = paramJceInputStream.read(this.total, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.likeFriends;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    paramJceOutputStream.write(this.total, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFriendLikes
 * JD-Core Version:    0.7.0.1
 */