package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFeedOpInfo
  extends JceStruct
{
  static stBusinessAdInfo cache_businessAdInfo = new stBusinessAdInfo();
  static stFunctionalIconInfo cache_shootIconInfo = new stFunctionalIconInfo();
  public stBusinessAdInfo businessAdInfo = null;
  public String feedId = "";
  public int iconType = 0;
  public int isRequesting = 0;
  public stFunctionalIconInfo shootIconInfo = null;
  public String traceId = "";
  public int videoType = 0;
  
  public stFeedOpInfo() {}
  
  public stFeedOpInfo(String paramString1, int paramInt1, String paramString2, int paramInt2, stFunctionalIconInfo paramstFunctionalIconInfo, stBusinessAdInfo paramstBusinessAdInfo, int paramInt3)
  {
    this.feedId = paramString1;
    this.videoType = paramInt1;
    this.traceId = paramString2;
    this.iconType = paramInt2;
    this.shootIconInfo = paramstFunctionalIconInfo;
    this.businessAdInfo = paramstBusinessAdInfo;
    this.isRequesting = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feedId = paramJceInputStream.readString(0, false);
    this.videoType = paramJceInputStream.read(this.videoType, 1, false);
    this.traceId = paramJceInputStream.readString(2, false);
    this.iconType = paramJceInputStream.read(this.iconType, 3, false);
    this.shootIconInfo = ((stFunctionalIconInfo)paramJceInputStream.read(cache_shootIconInfo, 4, false));
    this.businessAdInfo = ((stBusinessAdInfo)paramJceInputStream.read(cache_businessAdInfo, 5, false));
    this.isRequesting = paramJceInputStream.read(this.isRequesting, 6, false);
  }
  
  public String toString()
  {
    return "stFeedOpInfo{feedId='" + this.feedId + '\'' + ", videoType=" + this.videoType + ", traceId='" + this.traceId + '\'' + ", iconType=" + this.iconType + ", shootIconInfo=" + this.shootIconInfo + ", businessAdInfo=" + this.businessAdInfo + ", isRequesting=" + this.isRequesting + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feedId != null) {
      paramJceOutputStream.write(this.feedId, 0);
    }
    paramJceOutputStream.write(this.videoType, 1);
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 2);
    }
    paramJceOutputStream.write(this.iconType, 3);
    if (this.shootIconInfo != null) {
      paramJceOutputStream.write(this.shootIconInfo, 4);
    }
    if (this.businessAdInfo != null) {
      paramJceOutputStream.write(this.businessAdInfo, 5);
    }
    paramJceOutputStream.write(this.isRequesting, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFeedOpInfo
 * JD-Core Version:    0.7.0.1
 */