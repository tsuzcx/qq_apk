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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stBusinessAdInfo{adType=");
    localStringBuilder.append(this.adType);
    localStringBuilder.append(", adId='");
    localStringBuilder.append(this.adId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", creativeId='");
    localStringBuilder.append(this.creativeId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", advertiserId='");
    localStringBuilder.append(this.advertiserId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.adType, 0);
    String str = this.adId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.creativeId;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.advertiserId;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stBusinessAdInfo
 * JD-Core Version:    0.7.0.1
 */