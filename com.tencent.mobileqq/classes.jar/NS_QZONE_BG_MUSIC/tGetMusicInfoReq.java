package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class tGetMusicInfoReq
  extends JceStruct
{
  static ArrayList<String> cache_vecSongId = new ArrayList();
  public int iNeedUrl = 0;
  public long lUin = 0L;
  public ArrayList<String> vecSongId = null;
  
  static
  {
    cache_vecSongId.add("");
  }
  
  public tGetMusicInfoReq() {}
  
  public tGetMusicInfoReq(long paramLong, ArrayList<String> paramArrayList, int paramInt)
  {
    this.lUin = paramLong;
    this.vecSongId = paramArrayList;
    this.iNeedUrl = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.vecSongId = ((ArrayList)paramJceInputStream.read(cache_vecSongId, 1, false));
    this.iNeedUrl = paramJceInputStream.read(this.iNeedUrl, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    ArrayList localArrayList = this.vecSongId;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    paramJceOutputStream.write(this.iNeedUrl, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_BG_MUSIC.tGetMusicInfoReq
 * JD-Core Version:    0.7.0.1
 */