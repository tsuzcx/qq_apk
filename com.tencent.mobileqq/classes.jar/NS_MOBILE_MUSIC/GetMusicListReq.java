package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetMusicListReq
  extends JceStruct
{
  static ArrayList cache_music_id;
  public ArrayList music_id;
  
  public GetMusicListReq() {}
  
  public GetMusicListReq(ArrayList paramArrayList)
  {
    this.music_id = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_music_id == null)
    {
      cache_music_id = new ArrayList();
      MusicID localMusicID = new MusicID();
      cache_music_id.add(localMusicID);
    }
    this.music_id = ((ArrayList)paramJceInputStream.read(cache_music_id, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.music_id != null) {
      paramJceOutputStream.write(this.music_id, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_MUSIC.GetMusicListReq
 * JD-Core Version:    0.7.0.1
 */