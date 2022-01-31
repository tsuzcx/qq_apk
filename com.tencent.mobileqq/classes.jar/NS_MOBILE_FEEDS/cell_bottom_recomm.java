package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_bottom_recomm
  extends JceStruct
{
  static WeishiDownlowdUrl cache_downloadUrl = new WeishiDownlowdUrl();
  static s_join_list cache_joinlist;
  static s_picdata cache_picinfo = new s_picdata();
  public String AdvIconUrl = "";
  public int actiontype;
  public String actionurl = "";
  public int anonymity;
  public String buttonIconUrl = "";
  public String buttontext = "";
  public WeishiDownlowdUrl downloadUrl;
  public int iButtonFlag;
  public int iReportFlag;
  public boolean isSupportFeedback;
  public s_join_list joinlist;
  public String jsonData = "";
  public s_picdata picinfo;
  public String summary = "";
  public String summaryColor = "";
  public String title = "";
  
  static
  {
    cache_joinlist = new s_join_list();
  }
  
  public cell_bottom_recomm() {}
  
  public cell_bottom_recomm(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, s_join_list params_join_list, boolean paramBoolean, int paramInt3, int paramInt4, WeishiDownlowdUrl paramWeishiDownlowdUrl, String paramString8)
  {
    this.picinfo = params_picdata;
    this.title = paramString1;
    this.summary = paramString2;
    this.buttonIconUrl = paramString3;
    this.actiontype = paramInt1;
    this.actionurl = paramString4;
    this.AdvIconUrl = paramString5;
    this.summaryColor = paramString6;
    this.buttontext = paramString7;
    this.anonymity = paramInt2;
    this.joinlist = params_join_list;
    this.isSupportFeedback = paramBoolean;
    this.iReportFlag = paramInt3;
    this.iButtonFlag = paramInt4;
    this.downloadUrl = paramWeishiDownlowdUrl;
    this.jsonData = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfo = ((s_picdata)paramJceInputStream.read(cache_picinfo, 0, false));
    this.title = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.buttonIconUrl = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionurl = paramJceInputStream.readString(5, false);
    this.AdvIconUrl = paramJceInputStream.readString(6, false);
    this.summaryColor = paramJceInputStream.readString(7, false);
    this.buttontext = paramJceInputStream.readString(8, false);
    this.anonymity = paramJceInputStream.read(this.anonymity, 9, false);
    this.joinlist = ((s_join_list)paramJceInputStream.read(cache_joinlist, 10, false));
    this.isSupportFeedback = paramJceInputStream.read(this.isSupportFeedback, 11, false);
    this.iReportFlag = paramJceInputStream.read(this.iReportFlag, 12, false);
    this.iButtonFlag = paramJceInputStream.read(this.iButtonFlag, 13, false);
    this.downloadUrl = ((WeishiDownlowdUrl)paramJceInputStream.read(cache_downloadUrl, 14, false));
    this.jsonData = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picinfo != null) {
      paramJceOutputStream.write(this.picinfo, 0);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.buttonIconUrl != null) {
      paramJceOutputStream.write(this.buttonIconUrl, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 5);
    }
    if (this.AdvIconUrl != null) {
      paramJceOutputStream.write(this.AdvIconUrl, 6);
    }
    if (this.summaryColor != null) {
      paramJceOutputStream.write(this.summaryColor, 7);
    }
    if (this.buttontext != null) {
      paramJceOutputStream.write(this.buttontext, 8);
    }
    paramJceOutputStream.write(this.anonymity, 9);
    if (this.joinlist != null) {
      paramJceOutputStream.write(this.joinlist, 10);
    }
    paramJceOutputStream.write(this.isSupportFeedback, 11);
    paramJceOutputStream.write(this.iReportFlag, 12);
    paramJceOutputStream.write(this.iButtonFlag, 13);
    if (this.downloadUrl != null) {
      paramJceOutputStream.write(this.downloadUrl, 14);
    }
    if (this.jsonData != null) {
      paramJceOutputStream.write(this.jsonData, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_bottom_recomm
 * JD-Core Version:    0.7.0.1
 */