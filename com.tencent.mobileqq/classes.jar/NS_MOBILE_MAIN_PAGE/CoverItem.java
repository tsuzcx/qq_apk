package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CoverItem
  extends JceStruct
{
  static Map cache_extendinfo;
  static ArrayList cache_imageUrls;
  static ArrayList cache_imageUrls340;
  static ArrayList cache_packages;
  public String description = "";
  public Map extendinfo;
  public String id = "";
  public ArrayList imageUrls;
  public ArrayList imageUrls340;
  public int initIndex;
  public int isFree;
  public int isNew;
  public int isVip;
  public int manyBits;
  public String name = "";
  public ArrayList packages;
  public String size = "";
  public String thumbUrl = "";
  public String type = "";
  
  public CoverItem() {}
  
  public CoverItem(String paramString1, String paramString2, ArrayList paramArrayList1, String paramString3, int paramInt1, int paramInt2, String paramString4, ArrayList paramArrayList2, String paramString5, int paramInt3, int paramInt4, String paramString6, int paramInt5, Map paramMap, ArrayList paramArrayList3)
  {
    this.id = paramString1;
    this.type = paramString2;
    this.imageUrls = paramArrayList1;
    this.thumbUrl = paramString3;
    this.isVip = paramInt1;
    this.initIndex = paramInt2;
    this.name = paramString4;
    this.packages = paramArrayList2;
    this.size = paramString5;
    this.isFree = paramInt3;
    this.isNew = paramInt4;
    this.description = paramString6;
    this.manyBits = paramInt5;
    this.extendinfo = paramMap;
    this.imageUrls340 = paramArrayList3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.readString(1, false);
    if (cache_imageUrls == null)
    {
      cache_imageUrls = new ArrayList();
      cache_imageUrls.add("");
    }
    this.imageUrls = ((ArrayList)paramJceInputStream.read(cache_imageUrls, 2, false));
    this.thumbUrl = paramJceInputStream.readString(3, false);
    this.isVip = paramJceInputStream.read(this.isVip, 4, false);
    this.initIndex = paramJceInputStream.read(this.initIndex, 5, false);
    this.name = paramJceInputStream.readString(6, false);
    if (cache_packages == null)
    {
      cache_packages = new ArrayList();
      CoverPackageInfo localCoverPackageInfo = new CoverPackageInfo();
      cache_packages.add(localCoverPackageInfo);
    }
    this.packages = ((ArrayList)paramJceInputStream.read(cache_packages, 7, false));
    this.size = paramJceInputStream.readString(8, false);
    this.isFree = paramJceInputStream.read(this.isFree, 9, false);
    this.isNew = paramJceInputStream.read(this.isNew, 10, false);
    this.description = paramJceInputStream.readString(11, false);
    this.manyBits = paramJceInputStream.read(this.manyBits, 12, false);
    if (cache_extendinfo == null)
    {
      cache_extendinfo = new HashMap();
      cache_extendinfo.put("", "");
    }
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    if (cache_imageUrls340 == null)
    {
      cache_imageUrls340 = new ArrayList();
      cache_imageUrls340.add("");
    }
    this.imageUrls340 = ((ArrayList)paramJceInputStream.read(cache_imageUrls340, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 1);
    }
    if (this.imageUrls != null) {
      paramJceOutputStream.write(this.imageUrls, 2);
    }
    if (this.thumbUrl != null) {
      paramJceOutputStream.write(this.thumbUrl, 3);
    }
    paramJceOutputStream.write(this.isVip, 4);
    paramJceOutputStream.write(this.initIndex, 5);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 6);
    }
    if (this.packages != null) {
      paramJceOutputStream.write(this.packages, 7);
    }
    if (this.size != null) {
      paramJceOutputStream.write(this.size, 8);
    }
    paramJceOutputStream.write(this.isFree, 9);
    paramJceOutputStream.write(this.isNew, 10);
    if (this.description != null) {
      paramJceOutputStream.write(this.description, 11);
    }
    paramJceOutputStream.write(this.manyBits, 12);
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 13);
    }
    if (this.imageUrls340 != null) {
      paramJceOutputStream.write(this.imageUrls340, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.CoverItem
 * JD-Core Version:    0.7.0.1
 */