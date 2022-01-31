package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSuixintieSigFontReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public int appid;
  public int itemid;
  public LoginInfo stLogin;
  public String strAttachInfo = "";
  public String strSeesionID = "";
  
  public GetSuixintieSigFontReq() {}
  
  public GetSuixintieSigFontReq(LoginInfo paramLoginInfo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.stLogin = paramLoginInfo;
    this.appid = paramInt1;
    this.itemid = paramInt2;
    this.strSeesionID = paramString1;
    this.strAttachInfo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.itemid = paramJceInputStream.read(this.itemid, 2, false);
    this.strSeesionID = paramJceInputStream.readString(3, false);
    this.strAttachInfo = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.itemid, 2);
    if (this.strSeesionID != null) {
      paramJceOutputStream.write(this.strSeesionID, 3);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetSuixintieSigFontReq
 * JD-Core Version:    0.7.0.1
 */