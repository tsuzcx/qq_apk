package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_adv_container_attach
  extends JceStruct
{
  static s_picdata cache_picinfo = new s_picdata();
  public int actiontype = 0;
  public String actionurl = "";
  public int is_report = 0;
  public s_picdata picinfo = null;
  public String remark = "";
  public String report_url = "";
  
  public cell_adv_container_attach() {}
  
  public cell_adv_container_attach(s_picdata params_picdata, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this.picinfo = params_picdata;
    this.remark = paramString1;
    this.actiontype = paramInt1;
    this.actionurl = paramString2;
    this.is_report = paramInt2;
    this.report_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfo = ((s_picdata)paramJceInputStream.read(cache_picinfo, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.actionurl = paramJceInputStream.readString(3, false);
    this.is_report = paramJceInputStream.read(this.is_report, 4, false);
    this.report_url = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.picinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.remark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.is_report, 4);
    localObject = this.report_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_adv_container_attach
 * JD-Core Version:    0.7.0.1
 */