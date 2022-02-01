package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_get_cover_rsp
  extends JceStruct
{
  static Map<String, String> cache_MulRelsotionUrl;
  static CoverPackageInfo cache_packageInfo;
  static ArrayList<Map<Integer, String>> cache_vecUrls;
  public Map<String, String> MulRelsotionUrl;
  public String cover = "";
  public String id = "";
  public CoverPackageInfo packageInfo;
  public int photoWallCombinePic;
  public String type = "";
  public ArrayList<Map<Integer, String>> vecUrls;
  
  public mobile_sub_get_cover_rsp() {}
  
  public mobile_sub_get_cover_rsp(String paramString1, String paramString2, Map<String, String> paramMap, CoverPackageInfo paramCoverPackageInfo, ArrayList<Map<Integer, String>> paramArrayList, String paramString3, int paramInt)
  {
    this.cover = paramString1;
    this.type = paramString2;
    this.MulRelsotionUrl = paramMap;
    this.packageInfo = paramCoverPackageInfo;
    this.vecUrls = paramArrayList;
    this.id = paramString3;
    this.photoWallCombinePic = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.readString(1, false);
    if (cache_MulRelsotionUrl == null)
    {
      cache_MulRelsotionUrl = new HashMap();
      cache_MulRelsotionUrl.put("", "");
    }
    this.MulRelsotionUrl = ((Map)paramJceInputStream.read(cache_MulRelsotionUrl, 2, false));
    if (cache_packageInfo == null) {
      cache_packageInfo = new CoverPackageInfo();
    }
    this.packageInfo = ((CoverPackageInfo)paramJceInputStream.read(cache_packageInfo, 3, false));
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), "");
      cache_vecUrls.add(localHashMap);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 4, false));
    this.id = paramJceInputStream.readString(5, false);
    this.photoWallCombinePic = paramJceInputStream.read(this.photoWallCombinePic, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.cover;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.MulRelsotionUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
    localObject = this.packageInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.vecUrls;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.photoWallCombinePic, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp
 * JD-Core Version:    0.7.0.1
 */