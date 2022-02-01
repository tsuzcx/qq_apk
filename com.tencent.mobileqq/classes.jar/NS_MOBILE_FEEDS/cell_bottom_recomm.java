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
  public int actiontype = 0;
  public String actionurl = "";
  public int anonymity = 0;
  public String buttonIconUrl = "";
  public String buttontext = "";
  public WeishiDownlowdUrl downloadUrl = null;
  public int iButtonFlag = 0;
  public int iReportFlag = 0;
  public boolean isSupportFeedback = false;
  public s_join_list joinlist = null;
  public String jsonData = "";
  public s_picdata picinfo = null;
  public int style = 0;
  public String summary = "";
  public String summaryColor = "";
  public String title = "";
  
  static
  {
    cache_joinlist = new s_join_list();
  }
  
  public cell_bottom_recomm() {}
  
  public cell_bottom_recomm(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, s_join_list params_join_list, boolean paramBoolean, int paramInt3, int paramInt4, WeishiDownlowdUrl paramWeishiDownlowdUrl, String paramString8, int paramInt5)
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
    this.style = paramInt5;
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
    this.style = paramJceInputStream.read(this.style, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.picinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.buttonIconUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.AdvIconUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.summaryColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.buttontext;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.anonymity, 9);
    localObject = this.joinlist;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    paramJceOutputStream.write(this.isSupportFeedback, 11);
    paramJceOutputStream.write(this.iReportFlag, 12);
    paramJceOutputStream.write(this.iButtonFlag, 13);
    localObject = this.downloadUrl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    localObject = this.jsonData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.style, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_bottom_recomm
 * JD-Core Version:    0.7.0.1
 */