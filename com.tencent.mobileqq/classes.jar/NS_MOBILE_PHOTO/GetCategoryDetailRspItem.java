package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetCategoryDetailRspItem
  extends JceStruct
{
  static SummaryInfo cache_attr;
  static ArrayList<face_show_info> cache_face_shows;
  static CategoryPhoto cache_photos = new CategoryPhoto();
  static CategoryRecommend cache_recommend;
  public SummaryInfo attr = null;
  public ArrayList<face_show_info> face_shows = null;
  public boolean is_recommend_appoint = false;
  public CategoryPhoto photos = null;
  public CategoryRecommend recommend = null;
  public int ret = 0;
  
  static
  {
    cache_attr = new SummaryInfo();
    cache_recommend = new CategoryRecommend();
    cache_face_shows = new ArrayList();
    face_show_info localface_show_info = new face_show_info();
    cache_face_shows.add(localface_show_info);
  }
  
  public GetCategoryDetailRspItem() {}
  
  public GetCategoryDetailRspItem(CategoryPhoto paramCategoryPhoto, SummaryInfo paramSummaryInfo, CategoryRecommend paramCategoryRecommend, ArrayList<face_show_info> paramArrayList, int paramInt, boolean paramBoolean)
  {
    this.photos = paramCategoryPhoto;
    this.attr = paramSummaryInfo;
    this.recommend = paramCategoryRecommend;
    this.face_shows = paramArrayList;
    this.ret = paramInt;
    this.is_recommend_appoint = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((CategoryPhoto)paramJceInputStream.read(cache_photos, 0, false));
    this.attr = ((SummaryInfo)paramJceInputStream.read(cache_attr, 1, false));
    this.recommend = ((CategoryRecommend)paramJceInputStream.read(cache_recommend, 2, false));
    this.face_shows = ((ArrayList)paramJceInputStream.read(cache_face_shows, 3, false));
    this.ret = paramJceInputStream.read(this.ret, 4, false);
    this.is_recommend_appoint = paramJceInputStream.read(this.is_recommend_appoint, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 0);
    }
    if (this.attr != null) {
      paramJceOutputStream.write(this.attr, 1);
    }
    if (this.recommend != null) {
      paramJceOutputStream.write(this.recommend, 2);
    }
    if (this.face_shows != null) {
      paramJceOutputStream.write(this.face_shows, 3);
    }
    paramJceOutputStream.write(this.ret, 4);
    paramJceOutputStream.write(this.is_recommend_appoint, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetCategoryDetailRspItem
 * JD-Core Version:    0.7.0.1
 */