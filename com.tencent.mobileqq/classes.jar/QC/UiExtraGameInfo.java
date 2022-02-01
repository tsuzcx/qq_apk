package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UiExtraGameInfo
  extends JceStruct
{
  public long gameappid = 0L;
  public String gameappname = "";
  public String gamepkgname = "";
  public String gamevia = "";
  public String loginurl = "";
  
  public UiExtraGameInfo() {}
  
  public UiExtraGameInfo(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.gameappid = paramLong;
    this.loginurl = paramString1;
    this.gamevia = paramString2;
    this.gamepkgname = paramString3;
    this.gameappname = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.gameappid = paramJceInputStream.read(this.gameappid, 0, false);
    this.loginurl = paramJceInputStream.readString(1, false);
    this.gamevia = paramJceInputStream.readString(2, false);
    this.gamepkgname = paramJceInputStream.readString(3, false);
    this.gameappname = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.gameappid, 0);
    String str = this.loginurl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.gamevia;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.gamepkgname;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.gameappname;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UiExtraGameInfo
 * JD-Core Version:    0.7.0.1
 */