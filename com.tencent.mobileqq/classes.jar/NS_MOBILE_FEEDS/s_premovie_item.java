package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_premovie_item
  extends JceStruct
{
  public int actiontype;
  public int duration;
  public int height;
  public String jumpurl = "";
  public String vid = "";
  public String videourl = "";
  public int width;
  
  public s_premovie_item() {}
  
  public s_premovie_item(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    this.vid = paramString1;
    this.videourl = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
    this.duration = paramInt3;
    this.actiontype = paramInt4;
    this.jumpurl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    this.width = paramJceInputStream.read(this.width, 2, false);
    this.height = paramJceInputStream.read(this.height, 3, false);
    this.duration = paramJceInputStream.read(this.duration, 4, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 5, false);
    this.jumpurl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vid != null) {
      paramJceOutputStream.write(this.vid, 0);
    }
    if (this.videourl != null) {
      paramJceOutputStream.write(this.videourl, 1);
    }
    paramJceOutputStream.write(this.width, 2);
    paramJceOutputStream.write(this.height, 3);
    paramJceOutputStream.write(this.duration, 4);
    paramJceOutputStream.write(this.actiontype, 5);
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_premovie_item
 * JD-Core Version:    0.7.0.1
 */