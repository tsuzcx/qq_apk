package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLinkConfig
  extends JceStruct
{
  public int callCount = 0;
  public int downloadCount = 0;
  public boolean isOpenVideoPage = true;
  public boolean openCallWeishi = false;
  public boolean openDownloadWeishi = false;
  
  public stLinkConfig() {}
  
  public stLinkConfig(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.openCallWeishi = paramBoolean1;
    this.openDownloadWeishi = paramBoolean2;
    this.callCount = paramInt1;
    this.downloadCount = paramInt2;
    this.isOpenVideoPage = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.openCallWeishi = paramJceInputStream.read(this.openCallWeishi, 0, false);
    this.openDownloadWeishi = paramJceInputStream.read(this.openDownloadWeishi, 1, false);
    this.callCount = paramJceInputStream.read(this.callCount, 2, false);
    this.downloadCount = paramJceInputStream.read(this.downloadCount, 3, false);
    this.isOpenVideoPage = paramJceInputStream.read(this.isOpenVideoPage, 4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stLinkConfig {openCallWeishi=");
    localStringBuilder.append(this.openCallWeishi);
    localStringBuilder.append(", openDownloadWeishi=");
    localStringBuilder.append(this.openDownloadWeishi);
    localStringBuilder.append(", callCount=");
    localStringBuilder.append(this.callCount);
    localStringBuilder.append(", downloadCount=");
    localStringBuilder.append(this.downloadCount);
    localStringBuilder.append(", isOpenVideoPage=");
    localStringBuilder.append(this.isOpenVideoPage);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.openCallWeishi, 0);
    paramJceOutputStream.write(this.openDownloadWeishi, 1);
    paramJceOutputStream.write(this.callCount, 2);
    paramJceOutputStream.write(this.downloadCount, 3);
    paramJceOutputStream.write(this.isOpenVideoPage, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stLinkConfig
 * JD-Core Version:    0.7.0.1
 */