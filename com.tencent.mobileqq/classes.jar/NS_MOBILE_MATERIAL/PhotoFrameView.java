package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoFrameView
  extends JceStruct
{
  static MaterialFile cache_stBgImagePhoto;
  static MaterialFile cache_stBgImagePhotoOnly = new MaterialFile();
  static MaterialFile cache_stBgImageText = new MaterialFile();
  static MaterialFile cache_stH5BgImagePhoto = new MaterialFile();
  static MaterialFile cache_stH5BgImagePhotoOnly;
  static MaterialFile cache_stH5BgImageText;
  public int iContentWidth;
  public long iTextColor;
  public MaterialFile stBgImagePhoto;
  public MaterialFile stBgImagePhotoOnly;
  public MaterialFile stBgImageText;
  public MaterialFile stH5BgImagePhoto;
  public MaterialFile stH5BgImagePhotoOnly;
  public MaterialFile stH5BgImageText;
  
  static
  {
    cache_stBgImagePhoto = new MaterialFile();
    cache_stH5BgImagePhotoOnly = new MaterialFile();
    cache_stH5BgImageText = new MaterialFile();
  }
  
  public PhotoFrameView() {}
  
  public PhotoFrameView(int paramInt, MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, MaterialFile paramMaterialFile3, MaterialFile paramMaterialFile4, MaterialFile paramMaterialFile5, MaterialFile paramMaterialFile6, long paramLong)
  {
    this.iContentWidth = paramInt;
    this.stBgImagePhotoOnly = paramMaterialFile1;
    this.stBgImageText = paramMaterialFile2;
    this.stBgImagePhoto = paramMaterialFile3;
    this.stH5BgImagePhotoOnly = paramMaterialFile4;
    this.stH5BgImageText = paramMaterialFile5;
    this.stH5BgImagePhoto = paramMaterialFile6;
    this.iTextColor = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iContentWidth = paramJceInputStream.read(this.iContentWidth, 0, false);
    this.stBgImagePhotoOnly = ((MaterialFile)paramJceInputStream.read(cache_stBgImagePhotoOnly, 1, false));
    this.stBgImageText = ((MaterialFile)paramJceInputStream.read(cache_stBgImageText, 2, false));
    this.stBgImagePhoto = ((MaterialFile)paramJceInputStream.read(cache_stBgImagePhoto, 3, false));
    this.stH5BgImagePhotoOnly = ((MaterialFile)paramJceInputStream.read(cache_stH5BgImagePhotoOnly, 4, false));
    this.stH5BgImageText = ((MaterialFile)paramJceInputStream.read(cache_stH5BgImageText, 5, false));
    this.stH5BgImagePhoto = ((MaterialFile)paramJceInputStream.read(cache_stH5BgImagePhoto, 6, false));
    this.iTextColor = paramJceInputStream.read(this.iTextColor, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iContentWidth, 0);
    if (this.stBgImagePhotoOnly != null) {
      paramJceOutputStream.write(this.stBgImagePhotoOnly, 1);
    }
    if (this.stBgImageText != null) {
      paramJceOutputStream.write(this.stBgImageText, 2);
    }
    if (this.stBgImagePhoto != null) {
      paramJceOutputStream.write(this.stBgImagePhoto, 3);
    }
    if (this.stH5BgImagePhotoOnly != null) {
      paramJceOutputStream.write(this.stH5BgImagePhotoOnly, 4);
    }
    if (this.stH5BgImageText != null) {
      paramJceOutputStream.write(this.stH5BgImageText, 5);
    }
    if (this.stH5BgImagePhoto != null) {
      paramJceOutputStream.write(this.stH5BgImagePhoto, 6);
    }
    paramJceOutputStream.write(this.iTextColor, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.PhotoFrameView
 * JD-Core Version:    0.7.0.1
 */