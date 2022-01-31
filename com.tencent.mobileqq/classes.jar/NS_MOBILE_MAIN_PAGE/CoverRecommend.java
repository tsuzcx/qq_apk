package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CoverRecommend
  extends JceStruct
{
  static ArrayList cache_imageUrls;
  static CoverItem cache_item;
  static CoverCate cache_zhuanti;
  public ArrayList imageUrls;
  public CoverItem item;
  public String jumpUrl = "";
  public int type;
  public CoverCate zhuanti;
  
  public CoverRecommend() {}
  
  public CoverRecommend(ArrayList paramArrayList, CoverItem paramCoverItem, CoverCate paramCoverCate, int paramInt, String paramString)
  {
    this.imageUrls = paramArrayList;
    this.item = paramCoverItem;
    this.zhuanti = paramCoverCate;
    this.type = paramInt;
    this.jumpUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_imageUrls == null)
    {
      cache_imageUrls = new ArrayList();
      cache_imageUrls.add("");
    }
    this.imageUrls = ((ArrayList)paramJceInputStream.read(cache_imageUrls, 0, false));
    if (cache_item == null) {
      cache_item = new CoverItem();
    }
    this.item = ((CoverItem)paramJceInputStream.read(cache_item, 1, false));
    if (cache_zhuanti == null) {
      cache_zhuanti = new CoverCate();
    }
    this.zhuanti = ((CoverCate)paramJceInputStream.read(cache_zhuanti, 2, false));
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.jumpUrl = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imageUrls != null) {
      paramJceOutputStream.write(this.imageUrls, 0);
    }
    if (this.item != null) {
      paramJceOutputStream.write(this.item, 1);
    }
    if (this.zhuanti != null) {
      paramJceOutputStream.write(this.zhuanti, 2);
    }
    paramJceOutputStream.write(this.type, 3);
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.CoverRecommend
 * JD-Core Version:    0.7.0.1
 */