package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class LikeListInfo
  extends JceStruct
{
  static RedTouchInfo cache_stRedInfo = new RedTouchInfo();
  static ArrayList<LikeUserInfo> cache_vLikeList = new ArrayList();
  public RedTouchInfo stRedInfo = null;
  public ArrayList<LikeUserInfo> vLikeList = null;
  
  static
  {
    LikeUserInfo localLikeUserInfo = new LikeUserInfo();
    cache_vLikeList.add(localLikeUserInfo);
  }
  
  public LikeListInfo() {}
  
  public LikeListInfo(ArrayList<LikeUserInfo> paramArrayList, RedTouchInfo paramRedTouchInfo)
  {
    this.vLikeList = paramArrayList;
    this.stRedInfo = paramRedTouchInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vLikeList = ((ArrayList)paramJceInputStream.read(cache_vLikeList, 0, false));
    this.stRedInfo = ((RedTouchInfo)paramJceInputStream.read(cache_stRedInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vLikeList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.stRedInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.LikeListInfo
 * JD-Core Version:    0.7.0.1
 */