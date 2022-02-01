package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CKV_MusicListInfo
  extends JceStruct
{
  static ArrayList<CKV_MusicInfo> cache_vMusicList = new ArrayList();
  public ArrayList<CKV_MusicInfo> vMusicList = null;
  
  static
  {
    CKV_MusicInfo localCKV_MusicInfo = new CKV_MusicInfo();
    cache_vMusicList.add(localCKV_MusicInfo);
  }
  
  public CKV_MusicListInfo() {}
  
  public CKV_MusicListInfo(ArrayList<CKV_MusicInfo> paramArrayList)
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
 * Qualified Name:     VIP.CKV_MusicListInfo
 * JD-Core Version:    0.7.0.1
 */