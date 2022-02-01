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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stFeedOpInfo{feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.videoType);
    localStringBuilder.append(", traceId='");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconType=");
    localStringBuilder.append(this.iconType);
    localStringBuilder.append(", shootIconInfo=");
    localStringBuilder.append(this.shootIconInfo);
    localStringBuilder.append(", businessAdInfo=");
    localStringBuilder.append(this.businessAdInfo);
    localStringBuilder.append(", isRequesting=");
    localStringBuilder.append(this.isRequesting);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.feedId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.videoType, 1);
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.iconType, 3);
    localObject = this.shootIconInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.businessAdInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.isRequesting, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFeedOpInfo
 * JD-Core Version:    0.7.0.1
 */