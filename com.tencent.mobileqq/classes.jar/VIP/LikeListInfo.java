package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class LikeListInfo
  extends JceStruct
{
  static RedTouchInfo cache_stRedInfo = new RedTouchInfo();
  static ArrayList<LikeUserInfo> cache_vLikeList = new ArrayList();
  public RedTouchInfo stRedInfo;
  public ArrayList<LikeUserInfo> vLikeList;
  
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
    if (this.vLikeList != null) {
      paramJceOutputStream.write(this.vLikeList, 0);
    }
    if (this.stRedInfo != null) {
      paramJceOutputStream.write(this.stRedInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.LikeListInfo
 * JD-Core Version:    0.7.0.1
 */