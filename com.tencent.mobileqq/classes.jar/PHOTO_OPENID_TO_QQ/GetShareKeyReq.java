package PHOTO_OPENID_TO_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetShareKeyReq
  extends JceStruct
{
  public String albumid = "";
  public String openid = "";
  public String uin = "";
  
  public GetShareKeyReq() {}
  
  public GetShareKeyReq(String paramString1, String paramString2, String paramString3)
  {
    this.openid = paramString1;
    this.albumid = paramString2;
    this.uin = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.openid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.uin = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.openid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PHOTO_OPENID_TO_QQ.GetShareKeyReq
 * JD-Core Version:    0.7.0.1
 */