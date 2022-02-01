package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetQzoneMusicInfoRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  static Map<String, MusicInfo> cache_mMusicList = new HashMap();
  public CommRsp errInfo = null;
  public Map<String, MusicInfo> mMusicList = null;
  
  static
  {
    MusicInfo localMusicInfo = new MusicInfo();
    cache_mMusicList.put("", localMusicInfo);
  }
  
  public GetQzoneMusicInfoRsp() {}
  
  public GetQzoneMusicInfoRsp(CommRsp paramCommRsp, Map<String, MusicInfo> paramMap)
  {
    this.errInfo = paramCommRsp;
    this.mMusicList = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.mMusicList = ((Map)paramJceInputStream.read(cache_mMusicList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.errInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.mMusicList;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.GetQzoneMusicInfoRsp
 * JD-Core Version:    0.7.0.1
 */