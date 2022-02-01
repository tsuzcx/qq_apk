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
  public long uiSongId = 0L;
  
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
    String str = this.strSongMid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strFormat;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strLyric;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stLyricInfo
 * JD-Core Version:    0.7.0.1
 */