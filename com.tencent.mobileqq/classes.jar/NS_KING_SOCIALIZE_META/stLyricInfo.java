package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLyricInfo
  extends JceStruct
{
  public String strFormat = "";
  public String strLyric = "";
  public String strSongMid = "";
  public long uiSongId;
  
  public stLyricInfo() {}
  
  public stLyricInfo(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.uiSongId = paramLong;
    this.strSongMid = paramString1;
    this.strFormat = paramString2;
    this.strLyric = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiSongId = paramJceInputStream.read(this.uiSongId, 0, false);
    this.strSongMid = paramJceInputStream.readString(1, false);
    this.strFormat = paramJceInputStream.readString(2, false);
    this.strLyric = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiSongId, 0);
    if (this.strSongMid != null) {
      paramJceOutputStream.write(this.strSongMid, 1);
    }
    if (this.strFormat != null) {
      paramJceOutputStream.write(this.strFormat, 2);
    }
    if (this.strLyric != null) {
      paramJceOutputStream.write(this.strLyric, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stLyricInfo
 * JD-Core Version:    0.7.0.1
 */