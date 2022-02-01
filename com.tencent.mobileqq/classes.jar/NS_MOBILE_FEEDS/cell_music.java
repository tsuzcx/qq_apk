package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_music
  extends JceStruct
{
  public String coverurl = "";
  public int height = 0;
  public String musicMId = "";
  public String musicMUrl = "";
  public String musicType = "";
  public String musicid = "";
  public int musictime = 0;
  public String musicurl = "";
  public String title = "";
  public int width = 0;
  
  public cell_music() {}
  
  public cell_music(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    this.musicid = paramString1;
    this.musicurl = paramString2;
    this.coverurl = paramString3;
    this.width = paramInt1;
    this.height = paramInt2;
    this.title = paramString4;
    this.musictime = paramInt3;
    this.musicMId = paramString5;
    this.musicType = paramString6;
    this.musicMUrl = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.musicid = paramJceInputStream.readString(0, false);
    this.musicurl = paramJceInputStream.readString(1, false);
    this.coverurl = paramJceInputStream.readString(2, false);
    this.width = paramJceInputStream.read(this.width, 3, false);
    this.height = paramJceInputStream.read(this.height, 4, false);
    this.title = paramJceInputStream.readString(5, false);
    this.musictime = paramJceInputStream.read(this.musictime, 6, false);
    this.musicMId = paramJceInputStream.readString(7, false);
    this.musicType = paramJceInputStream.readString(8, false);
    this.musicMUrl = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.musicid != null) {
      paramJceOutputStream.write(this.musicid, 0);
    }
    if (this.musicurl != null) {
      paramJceOutputStream.write(this.musicurl, 1);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 2);
    }
    paramJceOutputStream.write(this.width, 3);
    paramJceOutputStream.write(this.height, 4);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 5);
    }
    paramJceOutputStream.write(this.musictime, 6);
    if (this.musicMId != null) {
      paramJceOutputStream.write(this.musicMId, 7);
    }
    if (this.musicType != null) {
      paramJceOutputStream.write(this.musicType, 8);
    }
    if (this.musicMUrl != null) {
      paramJceOutputStream.write(this.musicMUrl, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_music
 * JD-Core Version:    0.7.0.1
 */