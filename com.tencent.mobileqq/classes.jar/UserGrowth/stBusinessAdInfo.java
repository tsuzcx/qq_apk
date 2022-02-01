package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stBusinessAdInfo
  extends JceStruct
{
  public String adId = "";
  public int adType = 0;
  public String advertiserId = "";
  public String creativeId = "";
  
  public stBusinessAdInfo() {}
  
  public stBusinessAdInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.adType = paramInt;
    this.adId = paramString1;
    this.creativeId = paramString2;
    this.advertiserId = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.adType = paramJceInputStream.read(this.adType, 0, false);
    this.adId = paramJceInputStream.readString(1, false);
    this.creativeId = paramJceInputStream.readString(2, false);
    this.advertiserId = paramJceInputStream.readString(3, false);
  }
  
  public String toString()
  {
    return "stBusinessAdInfo{adType=" + this.adType + ", adId='" + this.adId + '\'' + ", creativeId='" + this.creativeId + '\'' + ", advertiserId='" + this.advertiserId + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.adType, 0);
    if (this.adId != null) {
      paramJceOutputStream.write(this.adId, 1);
    }
    if (this.creativeId != null) {
      paramJceOutputStream.write(this.creativeId, 2);
    }
    if (this.advertiserId != null) {
      paramJceOutputStream.write(this.advertiserId, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stBusinessAdInfo
 * JD-Core Version:    0.7.0.1
 */