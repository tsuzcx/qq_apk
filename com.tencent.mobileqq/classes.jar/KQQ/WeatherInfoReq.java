package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WeatherInfoReq
  extends JceStruct
{
  public String city = "";
  public int iAppId;
  public String strSessionKey = "";
  
  public WeatherInfoReq() {}
  
  public WeatherInfoReq(int paramInt, String paramString1, String paramString2)
  {
    this.iAppId = paramInt;
    this.strSessionKey = paramString1;
    this.city = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 1, true);
    this.strSessionKey = paramJceInputStream.readString(2, true);
    this.city = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 1);
    paramJceOutputStream.write(this.strSessionKey, 2);
    paramJceOutputStream.write(this.city, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.WeatherInfoReq
 * JD-Core Version:    0.7.0.1
 */