package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class tGetMusicInfoRsp
  extends JceStruct
{
  static Map<String, MusicInfo> cache_mapMusic = new HashMap();
  public Map<String, MusicInfo> mapMusic;
  
  static
  {
    MusicInfo localMusicInfo = new MusicInfo();
    cache_mapMusic.put("", localMusicInfo);
  }
  
  public tGetMusicInfoRsp() {}
  
  public tGetMusicInfoRsp(Map<String, MusicInfo> paramMap)
  {
    this.mapMusic = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapMusic = ((Map)paramJceInputStream.read(cache_mapMusic, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapMusic != null) {
      paramJceOutputStream.write(this.mapMusic, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_BG_MUSIC.tGetMusicInfoRsp
 * JD-Core Version:    0.7.0.1
 */