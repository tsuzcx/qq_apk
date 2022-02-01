package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MusicListInfo
  extends JceStruct
{
  static ArrayList<MusicInfo> cache_vMusicList = new ArrayList();
  public ArrayList<MusicInfo> vMusicList = null;
  
  static
  {
    MusicInfo localMusicInfo = new MusicInfo();
    cache_vMusicList.add(localMusicInfo);
  }
  
  public MusicListInfo() {}
  
  public MusicListInfo(ArrayList<MusicInfo> paramArrayList)
  {
    this.vMusicList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vMusicList = ((ArrayList)paramJceInputStream.read(cache_vMusicList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.vMusicList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.MusicListInfo
 * JD-Core Version:    0.7.0.1
 */