package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ListAllCategoryRspItem
  extends JceStruct
{
  static Map<String, CategoryPhoto> cache_categoryid_photos;
  static ArrayList<SummaryInfo> cache_categoryid_summaryinfos = new ArrayList();
  public Map<String, CategoryPhoto> categoryid_photos = null;
  public ArrayList<SummaryInfo> categoryid_summaryinfos = null;
  public boolean has_more = false;
  public String page_str = "";
  public int ret = 0;
  public long total = 0L;
  
  static
  {
    Object localObject = new SummaryInfo();
    cache_categoryid_summaryinfos.add(localObject);
    cache_categoryid_photos = new HashMap();
    localObject = new CategoryPhoto();
    cache_categoryid_photos.put("", localObject);
  }
  
  public ListAllCategoryRspItem() {}
  
  public ListAllCategoryRspItem(ArrayList<SummaryInfo> paramArrayList, Map<String, CategoryPhoto> paramMap, boolean paramBoolean, String paramString, long paramLong, int paramInt)
  {
    this.categoryid_summaryinfos = paramArrayList;
    this.categoryid_photos = paramMap;
    this.has_more = paramBoolean;
    this.page_str = paramString;
    this.total = paramLong;
    this.ret = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.categoryid_summaryinfos = ((ArrayList)paramJceInputStream.read(cache_categoryid_summaryinfos, 0, false));
    this.categoryid_photos = ((Map)paramJceInputStream.read(cache_categoryid_photos, 1, false));
    this.has_more = paramJceInputStream.read(this.has_more, 2, false);
    this.page_str = paramJceInputStream.readString(3, false);
    this.total = paramJceInputStream.read(this.total, 4, false);
    this.ret = paramJceInputStream.read(this.ret, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.categoryid_summaryinfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.categoryid_photos;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    paramJceOutputStream.write(this.has_more, 2);
    localObject = this.page_str;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.total, 4);
    paramJceOutputStream.write(this.ret, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ListAllCategoryRspItem
 * JD-Core Version:    0.7.0.1
 */