package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class st_pic_text
  extends JceStruct
{
  static s_picdata cache_picinfo = new s_picdata();
  static ArrayList<s_user> cache_userlist = new ArrayList();
  public int actiontype = 0;
  public String actionurl = "";
  public String desc_after_click = "";
  public String desc_before_click = "";
  public s_picdata picinfo = null;
  public String playurl = "";
  public String postfix = "";
  public String strHeader = "";
  public String summary = "";
  public String title = "";
  public ArrayList<s_user> userlist = null;
  
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
    Object localObject = this.picinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.userlist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.postfix;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.playurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.strHeader;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.desc_before_click;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.desc_after_click;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.st_pic_text
 * JD-Core Version:    0.7.0.1
 */