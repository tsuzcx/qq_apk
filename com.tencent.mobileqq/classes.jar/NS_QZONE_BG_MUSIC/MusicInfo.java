package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MusicInfo
  extends JceStruct
{
  static ArrayList<SingerInfo> cache_vecSingerList = new ArrayList();
  public int iAccess;
  public long lDuration;
  public String strAlbumName = "";
  public String strName = "";
  public String strPic = "";
  public String strSongId = "";
  public String strUrl = "";
  public ArrayList<SingerInfo> vecSingerList;
  
  static
  {
    SingerInfo localSingerInfo = new SingerInfo();
    cache_vecSingerList.add(localSingerInfo);
  }
  
  public MusicInfo() {}
  
  public MusicInfo(String paramString1, String paramString2, String paramString3, ArrayList<SingerInfo> paramArrayList, String paramString4, int paramInt, String paramString5, long paramLong)
  {
    this.strSongId = paramString1;
    this.strName = paramString2;
    this.strAlbumName = paramString3;
    this.vecSingerList = paramArrayList;
    this.strPic = paramString4;
    this.iAccess = paramInt;
    this.strUrl = paramString5;
    this.lDuration = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSongId = paramJceInputStream.readString(0, false);
    this.strName = paramJceInputStream.readString(1, false);
    this.strAlbumName = paramJceInputStream.readString(2, false);
    this.vecSingerList = ((ArrayList)paramJceInputStream.read(cache_vecSingerList, 3, false));
    this.strPic = paramJceInputStream.readString(4, false);
    this.iAccess = paramJceInputStream.read(this.iAccess, 5, false);
    this.strUrl = paramJceInputStream.readString(6, false);
    this.lDuration = paramJceInputStream.read(this.lDuration, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strSongId != null) {
      paramJceOutputStream.write(this.strSongId, 0);
    }
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 1);
    }
    if (this.strAlbumName != null) {
      paramJceOutputStream.write(this.strAlbumName, 2);
    }
    if (this.vecSingerList != null) {
      paramJceOutputStream.write(this.vecSingerList, 3);
    }
    if (this.strPic != null) {
      paramJceOutputStream.write(this.strPic, 4);
    }
    paramJceOutputStream.write(this.iAccess, 5);
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 6);
    }
    paramJceOutputStream.write(this.lDuration, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_BG_MUSIC.MusicInfo
 * JD-Core Version:    0.7.0.1
 */