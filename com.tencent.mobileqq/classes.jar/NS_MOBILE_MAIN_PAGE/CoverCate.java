package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CoverCate
  extends JceStruct
{
  static ArrayList<CoverItem> cache_items;
  public String attachInfo = "";
  public String description = "";
  public int hasMore;
  public String id = "";
  public ArrayList<CoverItem> items;
  public int manyBits;
  public String name = "";
  public int showCount;
  public int totalCount;
  public int type;
  public String zhuanTiBannerUrl = "";
  public String zhuanTiThumbUrl = "";
  
  public CoverCate() {}
  
  public CoverCate(String paramString1, ArrayList<CoverItem> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, int paramInt5)
  {
    this.name = paramString1;
    this.items = paramArrayList;
    this.showCount = paramInt1;
    this.totalCount = paramInt2;
    this.hasMore = paramInt3;
    this.attachInfo = paramString2;
    this.id = paramString3;
    this.description = paramString4;
    this.type = paramInt4;
    this.zhuanTiThumbUrl = paramString5;
    this.zhuanTiBannerUrl = paramString6;
    this.manyBits = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, false);
    if (cache_items == null)
    {
      cache_items = new ArrayList();
      CoverItem localCoverItem = new CoverItem();
      cache_items.add(localCoverItem);
    }
    this.items = ((ArrayList)paramJceInputStream.read(cache_items, 1, false));
    this.showCount = paramJceInputStream.read(this.showCount, 2, false);
    this.totalCount = paramJceInputStream.read(this.totalCount, 3, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 4, false);
    this.attachInfo = paramJceInputStream.readString(5, false);
    this.id = paramJceInputStream.readString(6, false);
    this.description = paramJceInputStream.readString(7, false);
    this.type = paramJceInputStream.read(this.type, 8, false);
    this.zhuanTiThumbUrl = paramJceInputStream.readString(9, false);
    this.zhuanTiBannerUrl = paramJceInputStream.readString(10, false);
    this.manyBits = paramJceInputStream.read(this.manyBits, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.items;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.showCount, 2);
    paramJceOutputStream.write(this.totalCount, 3);
    paramJceOutputStream.write(this.hasMore, 4);
    localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.description;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.type, 8);
    localObject = this.zhuanTiThumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.zhuanTiBannerUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.manyBits, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.CoverCate
 * JD-Core Version:    0.7.0.1
 */