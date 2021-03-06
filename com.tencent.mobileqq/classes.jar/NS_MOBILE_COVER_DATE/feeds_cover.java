package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class feeds_cover
  extends JceStruct
{
  static Map<String, String> cache_MulRelsotionUrl;
  static GameCoverInfo cache_gameCoverInfo;
  static Map<String, String> cache_mapExtInfo;
  static CoverPackageInfo cache_packageInfo;
  static ArrayList<Map<Integer, String>> cache_vecUrls;
  public Map<String, String> MulRelsotionUrl;
  public GameCoverInfo gameCoverInfo;
  public String id = "";
  public Map<String, String> mapExtInfo;
  public CoverPackageInfo packageInfo;
  public int photoWallCombinePic;
  public String type = "";
  public ArrayList<Map<Integer, String>> vecUrls;
  
  public feeds_cover() {}
  
  public feeds_cover(String paramString1, Map<String, String> paramMap1, CoverPackageInfo paramCoverPackageInfo, ArrayList<Map<Integer, String>> paramArrayList, String paramString2, int paramInt, GameCoverInfo paramGameCoverInfo, Map<String, String> paramMap2)
  {
    this.type = paramString1;
    this.MulRelsotionUrl = paramMap1;
    this.packageInfo = paramCoverPackageInfo;
    this.vecUrls = paramArrayList;
    this.id = paramString2;
    this.photoWallCombinePic = paramInt;
    this.gameCoverInfo = paramGameCoverInfo;
    this.mapExtInfo = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.readString(0, false);
    if (cache_MulRelsotionUrl == null)
    {
      cache_MulRelsotionUrl = new HashMap();
      cache_MulRelsotionUrl.put("", "");
    }
    this.MulRelsotionUrl = ((Map)paramJceInputStream.read(cache_MulRelsotionUrl, 1, false));
    if (cache_packageInfo == null) {
      cache_packageInfo = new CoverPackageInfo();
    }
    this.packageInfo = ((CoverPackageInfo)paramJceInputStream.read(cache_packageInfo, 2, false));
    if (cache_vecUrls == null)
    {
      cache_vecUrls = new ArrayList();
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), "");
      cache_vecUrls.add(localHashMap);
    }
    this.vecUrls = ((ArrayList)paramJceInputStream.read(cache_vecUrls, 3, false));
    this.id = paramJceInputStream.readString(4, false);
    this.photoWallCombinePic = paramJceInputStream.read(this.photoWallCombinePic, 5, false);
    if (cache_gameCoverInfo == null) {
      cache_gameCoverInfo = new GameCoverInfo();
    }
    this.gameCoverInfo = ((GameCoverInfo)paramJceInputStream.read(cache_gameCoverInfo, 6, false));
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.MulRelsotionUrl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    localObject = this.packageInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.vecUrls;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.photoWallCombinePic, 5);
    localObject = this.gameCoverInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COVER_DATE.feeds_cover
 * JD-Core Version:    0.7.0.1
 */