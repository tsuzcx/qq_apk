package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class QueryADBannerUnit
  extends JceStruct
{
  static int cache_eAdType;
  static Map<String, String> cache_extendinfo;
  static ArrayList<MultiBanner> cache_multibanner;
  static TimeRange cache_sShowTimeRange = new TimeRange();
  static ArrayList<VideoBanner> cache_videobanners;
  public String DynBannerJsonData = "";
  public String btnText = "";
  public String description = "";
  public int detail_info = 0;
  public int duration = 0;
  public int eAdType = 0;
  public Map<String, String> extendinfo = null;
  public long iAdID = 0L;
  public long iStoreID = 0L;
  public long iTraceID = 0L;
  public long iUin = 0L;
  public ArrayList<MultiBanner> multibanner = null;
  public String nick = "";
  public int noCloseButton = 0;
  public int pattern_id = 0;
  public int priority = 0;
  public int reopenHours = 0;
  public String report_info = "";
  public String roomId = "";
  public TimeRange sShowTimeRange = null;
  public String strJmpUrl = "";
  public String strPicMD5 = "";
  public String strPicUrl = "";
  public String strSchemeUrl = "";
  public String strStoreUrl = "";
  public String strTraceInfo = "";
  public int type = 0;
  public String videoUrl = "";
  public ArrayList<VideoBanner> videobanners = null;
  
  static
  {
    cache_multibanner = new ArrayList();
    Object localObject = new MultiBanner();
    cache_multibanner.add(localObject);
    cache_videobanners = new ArrayList();
    localObject = new VideoBanner();
    cache_videobanners.add(localObject);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public QueryADBannerUnit() {}
  
  public QueryADBannerUnit(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, TimeRange paramTimeRange, String paramString3, long paramLong3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, int paramInt7, String paramString7, String paramString8, String paramString9, long paramLong4, String paramString10, String paramString11, ArrayList<MultiBanner> paramArrayList, ArrayList<VideoBanner> paramArrayList1, Map<String, String> paramMap, String paramString12, String paramString13, int paramInt8)
  {
    this.strPicUrl = paramString1;
    this.strJmpUrl = paramString2;
    this.iAdID = paramLong1;
    this.iTraceID = paramLong2;
    this.eAdType = paramInt1;
    this.sShowTimeRange = paramTimeRange;
    this.strStoreUrl = paramString3;
    this.iStoreID = paramLong3;
    this.strSchemeUrl = paramString4;
    this.detail_info = paramInt2;
    this.noCloseButton = paramInt3;
    this.reopenHours = paramInt4;
    this.priority = paramInt5;
    this.duration = paramInt6;
    this.report_info = paramString5;
    this.strPicMD5 = paramString6;
    this.type = paramInt7;
    this.description = paramString7;
    this.btnText = paramString8;
    this.strTraceInfo = paramString9;
    this.iUin = paramLong4;
    this.roomId = paramString10;
    this.nick = paramString11;
    this.multibanner = paramArrayList;
    this.videobanners = paramArrayList1;
    this.extendinfo = paramMap;
    this.DynBannerJsonData = paramString12;
    this.videoUrl = paramString13;
    this.pattern_id = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.strJmpUrl = paramJceInputStream.readString(1, true);
    this.iAdID = paramJceInputStream.read(this.iAdID, 2, true);
    this.iTraceID = paramJceInputStream.read(this.iTraceID, 3, true);
    this.eAdType = paramJceInputStream.read(this.eAdType, 4, true);
    this.sShowTimeRange = ((TimeRange)paramJceInputStream.read(cache_sShowTimeRange, 5, false));
    this.strStoreUrl = paramJceInputStream.readString(6, false);
    this.iStoreID = paramJceInputStream.read(this.iStoreID, 7, false);
    this.strSchemeUrl = paramJceInputStream.readString(8, false);
    this.detail_info = paramJceInputStream.read(this.detail_info, 9, false);
    this.noCloseButton = paramJceInputStream.read(this.noCloseButton, 10, false);
    this.reopenHours = paramJceInputStream.read(this.reopenHours, 11, false);
    this.priority = paramJceInputStream.read(this.priority, 12, false);
    this.duration = paramJceInputStream.read(this.duration, 13, false);
    this.report_info = paramJceInputStream.readString(14, false);
    this.strPicMD5 = paramJceInputStream.readString(15, false);
    this.type = paramJceInputStream.read(this.type, 16, false);
    this.description = paramJceInputStream.readString(17, false);
    this.btnText = paramJceInputStream.readString(18, false);
    this.strTraceInfo = paramJceInputStream.readString(19, false);
    this.iUin = paramJceInputStream.read(this.iUin, 20, false);
    this.roomId = paramJceInputStream.readString(21, false);
    this.nick = paramJceInputStream.readString(22, false);
    this.multibanner = ((ArrayList)paramJceInputStream.read(cache_multibanner, 23, false));
    this.videobanners = ((ArrayList)paramJceInputStream.read(cache_videobanners, 24, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 25, false));
    this.DynBannerJsonData = paramJceInputStream.readString(26, false);
    this.videoUrl = paramJceInputStream.readString(27, false);
    this.pattern_id = paramJceInputStream.read(this.pattern_id, 28, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.strJmpUrl, 1);
    paramJceOutputStream.write(this.iAdID, 2);
    paramJceOutputStream.write(this.iTraceID, 3);
    paramJceOutputStream.write(this.eAdType, 4);
    Object localObject = this.sShowTimeRange;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.strStoreUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.iStoreID, 7);
    localObject = this.strSchemeUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.detail_info, 9);
    paramJceOutputStream.write(this.noCloseButton, 10);
    paramJceOutputStream.write(this.reopenHours, 11);
    paramJceOutputStream.write(this.priority, 12);
    paramJceOutputStream.write(this.duration, 13);
    localObject = this.report_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.strPicMD5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.type, 16);
    localObject = this.description;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    localObject = this.btnText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    paramJceOutputStream.write(this.iUin, 20);
    localObject = this.roomId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    localObject = this.nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 22);
    }
    localObject = this.multibanner;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 23);
    }
    localObject = this.videobanners;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 24);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 25);
    }
    localObject = this.DynBannerJsonData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 26);
    }
    localObject = this.videoUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 27);
    }
    paramJceOutputStream.write(this.pattern_id, 28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.QueryADBannerUnit
 * JD-Core Version:    0.7.0.1
 */