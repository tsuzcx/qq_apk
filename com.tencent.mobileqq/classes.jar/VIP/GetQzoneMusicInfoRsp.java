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
  public CommRsp errInfo;
  public Map<String, MusicInfo> mMusicList;
  
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
    if (this.errInfo != null) {
      paramJceOutputStream.write(this.errInfo, 0);
    }
    if (this.mMusicList != null) {
      paramJceOutputStream.write(this.mMusicList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetQzoneMusicInfoRsp
 * JD-Core Version:    0.7.0.1
 */