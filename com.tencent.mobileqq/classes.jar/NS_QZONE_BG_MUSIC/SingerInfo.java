package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SingerInfo
  extends JceStruct
{
  public String strSingerId = "";
  public String strSingerName = "";
  
  public SingerInfo() {}
  
  public SingerInfo(String paramString1, String paramString2)
  {
    this.strSingerId = paramString1;
    this.strSingerName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSingerId = paramJceInputStream.readString(0, false);
    this.strSingerName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strSingerId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strSingerName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_BG_MUSIC.SingerInfo
 * JD-Core Version:    0.7.0.1
 */