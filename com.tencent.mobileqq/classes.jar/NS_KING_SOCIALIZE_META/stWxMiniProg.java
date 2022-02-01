package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWxMiniProg
  extends JceStruct
{
  public String appThumbUrl = "";
  public String appid = "";
  public String hdImageDataURL = "";
  public int miniProgramType = 0;
  public String path = "";
  public String userName = "";
  public int videoCoverHeight = 0;
  public int videoCoverWidth = 0;
  public String videoSource = "";
  public String videoUserName = "";
  public String webpageUrl = "";
  public int withShareTicket = 0;
  
  public stWxMiniProg() {}
  
  public stWxMiniProg(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, String paramString8)
  {
    this.webpageUrl = paramString1;
    this.userName = paramString2;
    this.path = paramString3;
    this.hdImageDataURL = paramString4;
    this.withShareTicket = paramInt1;
    this.miniProgramType = paramInt2;
    this.appid = paramString5;
    this.videoUserName = paramString6;
    this.videoSource = paramString7;
    this.videoCoverWidth = paramInt3;
    this.videoCoverHeight = paramInt4;
    this.appThumbUrl = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.webpageUrl = paramJceInputStream.readString(0, false);
    this.userName = paramJceInputStream.readString(1, false);
    this.path = paramJceInputStream.readString(2, false);
    this.hdImageDataURL = paramJceInputStream.readString(3, false);
    this.withShareTicket = paramJceInputStream.read(this.withShareTicket, 4, false);
    this.miniProgramType = paramJceInputStream.read(this.miniProgramType, 5, false);
    this.appid = paramJceInputStream.readString(6, false);
    this.videoUserName = paramJceInputStream.readString(7, false);
    this.videoSource = paramJceInputStream.readString(8, false);
    this.videoCoverWidth = paramJceInputStream.read(this.videoCoverWidth, 9, false);
    this.videoCoverHeight = paramJceInputStream.read(this.videoCoverHeight, 10, false);
    this.appThumbUrl = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.webpageUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.userName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.path;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.hdImageDataURL;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.withShareTicket, 4);
    paramJceOutputStream.write(this.miniProgramType, 5);
    str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.videoUserName;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.videoSource;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.videoCoverWidth, 9);
    paramJceOutputStream.write(this.videoCoverHeight, 10);
    str = this.appThumbUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stWxMiniProg
 * JD-Core Version:    0.7.0.1
 */