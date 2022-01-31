package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class st_pic_text
  extends JceStruct
{
  static s_picdata cache_picinfo = new s_picdata();
  static ArrayList<s_user> cache_userlist = new ArrayList();
  public int actiontype;
  public String actionurl = "";
  public String desc_after_click = "";
  public String desc_before_click = "";
  public s_picdata picinfo;
  public String playurl = "";
  public String postfix = "";
  public String strHeader = "";
  public String summary = "";
  public String title = "";
  public ArrayList<s_user> userlist;
  
  static
  {
    s_user locals_user = new s_user();
    cache_userlist.add(locals_user);
  }
  
  public st_pic_text() {}
  
  public st_pic_text(s_picdata params_picdata, ArrayList<s_user> paramArrayList, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.picinfo = params_picdata;
    this.userlist = paramArrayList;
    this.summary = paramString1;
    this.title = paramString2;
    this.actiontype = paramInt;
    this.actionurl = paramString3;
    this.postfix = paramString4;
    this.playurl = paramString5;
    this.strHeader = paramString6;
    this.desc_before_click = paramString7;
    this.desc_after_click = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfo = ((s_picdata)paramJceInputStream.read(cache_picinfo, 0, false));
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 1, false));
    this.summary = paramJceInputStream.readString(2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionurl = paramJceInputStream.readString(5, false);
    this.postfix = paramJceInputStream.readString(6, false);
    this.playurl = paramJceInputStream.readString(7, false);
    this.strHeader = paramJceInputStream.readString(8, false);
    this.desc_before_click = paramJceInputStream.readString(9, false);
    this.desc_after_click = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picinfo != null) {
      paramJceOutputStream.write(this.picinfo, 0);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 5);
    }
    if (this.postfix != null) {
      paramJceOutputStream.write(this.postfix, 6);
    }
    if (this.playurl != null) {
      paramJceOutputStream.write(this.playurl, 7);
    }
    if (this.strHeader != null) {
      paramJceOutputStream.write(this.strHeader, 8);
    }
    if (this.desc_before_click != null) {
      paramJceOutputStream.write(this.desc_before_click, 9);
    }
    if (this.desc_after_click != null) {
      paramJceOutputStream.write(this.desc_after_click, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.st_pic_text
 * JD-Core Version:    0.7.0.1
 */