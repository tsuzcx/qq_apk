package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAuth
  extends JceStruct
{
  public int iAuthType = 0;
  public String sAccessToken = "";
  public String sRefreshToken = "";
  public String sSessionKey = "";
  public String sThrAppid = "";
  public String sUid = "";
  
  public stAuth() {}
  
  public stAuth(int paramInt, String paramString1, String paramString2)
  {
    this.iAuthType = paramInt;
    this.sUid = paramString1;
    this.sSessionKey = paramString2;
  }
  
  public stAuth(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.iAuthType = paramInt;
    this.sUid = paramString1;
    this.sSessionKey = paramString2;
    this.sRefreshToken = paramString3;
    this.sAccessToken = paramString4;
    this.sThrAppid = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAuthType = paramJceInputStream.read(this.iAuthType, 0, false);
    this.sUid = paramJceInputStream.readString(1, false);
    this.sSessionKey = paramJceInputStream.readString(2, false);
    this.sRefreshToken = paramJceInputStream.readString(3, false);
    this.sAccessToken = paramJceInputStream.readString(4, false);
    this.sThrAppid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAuthType, 0);
    if (this.sUid != null) {
      paramJceOutputStream.write(this.sUid, 1);
    }
    if (this.sSessionKey != null) {
      paramJceOutputStream.write(this.sSessionKey, 2);
    }
    if (this.sRefreshToken != null) {
      paramJceOutputStream.write(this.sRefreshToken, 3);
    }
    if (this.sAccessToken != null) {
      paramJceOutputStream.write(this.sAccessToken, 4);
    }
    if (this.sThrAppid != null) {
      paramJceOutputStream.write(this.sThrAppid, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_PUBLIC.stAuth
 * JD-Core Version:    0.7.0.1
 */