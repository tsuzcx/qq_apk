package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BGMusicForQzone
  extends JceStruct
{
  public String showAudioUrl = "";
  public int showDuration = 0;
  public String showID = "";
  public String showName = "";
  public String showPicurl = "";
  
  public BGMusicForQzone() {}
  
  public BGMusicForQzone(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.showID = paramString1;
    this.showName = paramString2;
    this.showAudioUrl = paramString3;
    this.showPicurl = paramString4;
    this.showDuration = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.showID = paramJceInputStream.readString(0, false);
    this.showName = paramJceInputStream.readString(1, false);
    this.showAudioUrl = paramJceInputStream.readString(2, false);
    this.showPicurl = paramJceInputStream.readString(3, false);
    this.showDuration = paramJceInputStream.read(this.showDuration, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.showID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.showName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.showAudioUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.showPicurl;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.showDuration, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone
 * JD-Core Version:    0.7.0.1
 */