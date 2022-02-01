package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_qboss_psv_adv
  extends JceStruct
{
  static s_picdata cache_backgd_picdata;
  static Map<String, String> cache_extendinfo;
  static s_picdata cache_float_picdata = new s_picdata();
  static s_picdata cache_picdata = new s_picdata();
  public int actiontype = 0;
  public String actionurl = "";
  public s_picdata backgd_picdata = null;
  public String btnText = "";
  public long countDownTime = 0L;
  public Map<String, String> extendinfo = null;
  public s_picdata float_picdata = null;
  public int markType = 0;
  public int mediatype = 0;
  public s_picdata picdata = null;
  public int psvAdvType = 0;
  public String summary = "";
  public String title = "";
  
  static
  {
    cache_backgd_picdata = new s_picdata();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_qboss_psv_adv() {}
  
  public cell_qboss_psv_adv(int paramInt1, s_picdata params_picdata1, String paramString1, String paramString2, long paramLong, s_picdata params_picdata2, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, Map<String, String> paramMap, s_picdata params_picdata3)
  {
    this.mediatype = paramInt1;
    this.picdata = params_picdata1;
    this.title = paramString1;
    this.summary = paramString2;
    this.countDownTime = paramLong;
    this.backgd_picdata = params_picdata2;
    this.psvAdvType = paramInt2;
    this.markType = paramInt3;
    this.btnText = paramString3;
    this.actiontype = paramInt4;
    this.actionurl = paramString4;
    this.extendinfo = paramMap;
    this.float_picdata = params_picdata3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mediatype = paramJceInputStream.read(this.mediatype, 0, false);
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 1, false));
    this.title = paramJceInputStream.readString(2, false);
    this.summary = paramJceInputStream.readString(3, false);
    this.countDownTime = paramJceInputStream.read(this.countDownTime, 4, false);
    this.backgd_picdata = ((s_picdata)paramJceInputStream.read(cache_backgd_picdata, 5, false));
    this.psvAdvType = paramJceInputStream.read(this.psvAdvType, 6, false);
    this.markType = paramJceInputStream.read(this.markType, 7, false);
    this.btnText = paramJceInputStream.readString(8, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 9, false);
    this.actionurl = paramJceInputStream.readString(10, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 11, false));
    this.float_picdata = ((s_picdata)paramJceInputStream.read(cache_float_picdata, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mediatype, 0);
    Object localObject = this.picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.countDownTime, 4);
    localObject = this.backgd_picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.psvAdvType, 6);
    paramJceOutputStream.write(this.markType, 7);
    localObject = this.btnText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.actiontype, 9);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
    localObject = this.float_picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_qboss_psv_adv
 * JD-Core Version:    0.7.0.1
 */