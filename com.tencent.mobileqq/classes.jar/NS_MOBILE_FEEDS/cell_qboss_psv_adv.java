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
  static Map cache_extendinfo;
  static s_picdata cache_float_picdata = new s_picdata();
  static s_picdata cache_picdata = new s_picdata();
  public int actiontype;
  public String actionurl = "";
  public s_picdata backgd_picdata;
  public String btnText = "";
  public long countDownTime;
  public Map extendinfo;
  public s_picdata float_picdata;
  public int markType;
  public int mediatype;
  public s_picdata picdata;
  public int psvAdvType;
  public String summary = "";
  public String title = "";
  
  static
  {
    cache_backgd_picdata = new s_picdata();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_qboss_psv_adv() {}
  
  public cell_qboss_psv_adv(int paramInt1, s_picdata params_picdata1, String paramString1, String paramString2, long paramLong, s_picdata params_picdata2, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, Map paramMap, s_picdata params_picdata3)
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
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 1);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 3);
    }
    paramJceOutputStream.write(this.countDownTime, 4);
    if (this.backgd_picdata != null) {
      paramJceOutputStream.write(this.backgd_picdata, 5);
    }
    paramJceOutputStream.write(this.psvAdvType, 6);
    paramJceOutputStream.write(this.markType, 7);
    if (this.btnText != null) {
      paramJceOutputStream.write(this.btnText, 8);
    }
    paramJceOutputStream.write(this.actiontype, 9);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 10);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 11);
    }
    if (this.float_picdata != null) {
      paramJceOutputStream.write(this.float_picdata, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_qboss_psv_adv
 * JD-Core Version:    0.7.0.1
 */