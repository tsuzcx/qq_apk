package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_active_adv
  extends JceStruct
{
  static s_picdata cache_picdata = new s_picdata();
  public int button_actiontype;
  public String button_text = "";
  public String copy = "";
  public String copy_actionturl = "";
  public int copy_actiontype;
  public int is_report;
  public int mediatype;
  public int pic_actiontype = -1;
  public String pic_actionurl = "";
  public s_picdata picdata;
  public String report_url = "";
  public String up_copy = "";
  public int up_copy_actiontype;
  
  public cell_active_adv() {}
  
  public cell_active_adv(int paramInt1, s_picdata params_picdata, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, int paramInt5, int paramInt6, String paramString6)
  {
    this.mediatype = paramInt1;
    this.picdata = params_picdata;
    this.pic_actiontype = paramInt2;
    this.pic_actionurl = paramString1;
    this.copy = paramString2;
    this.copy_actiontype = paramInt3;
    this.copy_actionturl = paramString3;
    this.button_text = paramString4;
    this.button_actiontype = paramInt4;
    this.up_copy = paramString5;
    this.up_copy_actiontype = paramInt5;
    this.is_report = paramInt6;
    this.report_url = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mediatype = paramJceInputStream.read(this.mediatype, 0, false);
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 1, false));
    this.pic_actiontype = paramJceInputStream.read(this.pic_actiontype, 2, false);
    this.pic_actionurl = paramJceInputStream.readString(3, false);
    this.copy = paramJceInputStream.readString(4, false);
    this.copy_actiontype = paramJceInputStream.read(this.copy_actiontype, 5, false);
    this.copy_actionturl = paramJceInputStream.readString(6, false);
    this.button_text = paramJceInputStream.readString(7, false);
    this.button_actiontype = paramJceInputStream.read(this.button_actiontype, 8, false);
    this.up_copy = paramJceInputStream.readString(9, false);
    this.up_copy_actiontype = paramJceInputStream.read(this.up_copy_actiontype, 10, false);
    this.is_report = paramJceInputStream.read(this.is_report, 11, false);
    this.report_url = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mediatype, 0);
    Object localObject = this.picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.pic_actiontype, 2);
    localObject = this.pic_actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.copy;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.copy_actiontype, 5);
    localObject = this.copy_actionturl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.button_text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.button_actiontype, 8);
    localObject = this.up_copy;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.up_copy_actiontype, 10);
    paramJceOutputStream.write(this.is_report, 11);
    localObject = this.report_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_active_adv
 * JD-Core Version:    0.7.0.1
 */