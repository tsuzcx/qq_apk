package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportRecommendedPhotosReq
  extends JceStruct
{
  static RecommendPhotos cache_recommend_photos = new RecommendPhotos();
  public RecommendPhotos recommend_photos;
  public long uin;
  
  public ReportRecommendedPhotosReq() {}
  
  public ReportRecommendedPhotosReq(long paramLong, RecommendPhotos paramRecommendPhotos)
  {
    this.uin = paramLong;
    this.recommend_photos = paramRecommendPhotos;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.recommend_photos = ((RecommendPhotos)paramJceInputStream.read(cache_recommend_photos, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.recommend_photos != null) {
      paramJceOutputStream.write(this.recommend_photos, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ReportRecommendedPhotosReq
 * JD-Core Version:    0.7.0.1
 */