package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_COMM.ParasiticUnit;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_get_visit_rsp
  extends JceStruct
{
  static ArrayList<QueryADBannerUnit> cache_vecAdBanner;
  static ArrayList<ParasiticUnit> cache_vecParasiticUnit;
  static s_visit cache_visit;
  public boolean end = true;
  public int nextTimeInterval;
  public String page = "";
  public ArrayList<QueryADBannerUnit> vecAdBanner;
  public ArrayList<ParasiticUnit> vecParasiticUnit;
  public s_visit visit;
  
  public mobile_sub_get_visit_rsp() {}
  
  public mobile_sub_get_visit_rsp(s_visit params_visit, String paramString, boolean paramBoolean, ArrayList<QueryADBannerUnit> paramArrayList, ArrayList<ParasiticUnit> paramArrayList1, int paramInt)
  {
    this.visit = params_visit;
    this.page = paramString;
    this.end = paramBoolean;
    this.vecAdBanner = paramArrayList;
    this.vecParasiticUnit = paramArrayList1;
    this.nextTimeInterval = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_visit == null) {
      cache_visit = new s_visit();
    }
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 0, false));
    this.page = paramJceInputStream.readString(1, false);
    this.end = paramJceInputStream.read(this.end, 2, false);
    Object localObject;
    if (cache_vecAdBanner == null)
    {
      cache_vecAdBanner = new ArrayList();
      localObject = new QueryADBannerUnit();
      cache_vecAdBanner.add(localObject);
    }
    this.vecAdBanner = ((ArrayList)paramJceInputStream.read(cache_vecAdBanner, 3, false));
    if (cache_vecParasiticUnit == null)
    {
      cache_vecParasiticUnit = new ArrayList();
      localObject = new ParasiticUnit();
      cache_vecParasiticUnit.add(localObject);
    }
    this.vecParasiticUnit = ((ArrayList)paramJceInputStream.read(cache_vecParasiticUnit, 4, false));
    this.nextTimeInterval = paramJceInputStream.read(this.nextTimeInterval, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 0);
    }
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
    paramJceOutputStream.write(this.end, 2);
    if (this.vecAdBanner != null) {
      paramJceOutputStream.write(this.vecAdBanner, 3);
    }
    if (this.vecParasiticUnit != null) {
      paramJceOutputStream.write(this.vecParasiticUnit, 4);
    }
    paramJceOutputStream.write(this.nextTimeInterval, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_rsp
 * JD-Core Version:    0.7.0.1
 */