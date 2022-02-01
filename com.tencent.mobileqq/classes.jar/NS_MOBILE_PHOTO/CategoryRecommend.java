package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CategoryRecommend
  extends JceStruct
{
  static ArrayList<CategoryRecommendItem> cache_items = new ArrayList();
  public ArrayList<CategoryRecommendItem> items = null;
  
  static
  {
    CategoryRecommendItem localCategoryRecommendItem = new CategoryRecommendItem();
    cache_items.add(localCategoryRecommendItem);
  }
  
  public CategoryRecommend() {}
  
  public CategoryRecommend(ArrayList<CategoryRecommendItem> paramArrayList)
  {
    this.items = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.items = ((ArrayList)paramJceInputStream.read(cache_items, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.items;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryRecommend
 * JD-Core Version:    0.7.0.1
 */