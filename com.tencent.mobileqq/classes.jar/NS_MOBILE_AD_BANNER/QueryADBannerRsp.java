package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QueryADBannerRsp
  extends JceStruct
{
  private static volatile boolean cacheInited = false;
  static volatile ArrayList<QueryADBannerUnit> cache_vecAdBanner;
  public ArrayList<QueryADBannerUnit> vecAdBanner;
  
  public QueryADBannerRsp() {}
  
  public QueryADBannerRsp(ArrayList<QueryADBannerUnit> paramArrayList)
  {
    this.vecAdBanner = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (!cacheInited) {}
    try
    {
      if (!cacheInited)
      {
        cache_vecAdBanner = new ArrayList();
        QueryADBannerUnit localQueryADBannerUnit = new QueryADBannerUnit();
        cache_vecAdBanner.add(localQueryADBannerUnit);
        cacheInited = true;
      }
      this.vecAdBanner = ((ArrayList)paramJceInputStream.read(cache_vecAdBanner, 0, true));
      return;
    }
    finally {}
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecAdBanner, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.QueryADBannerRsp
 * JD-Core Version:    0.7.0.1
 */