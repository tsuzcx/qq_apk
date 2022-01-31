package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_left_thumb
  extends JceStruct
{
  static Map cache_mapExt;
  static s_picdata cache_picdata = new s_picdata();
  static s_user cache_user = new s_user();
  public String actionturl = "";
  public int actiontype;
  public Map mapExt;
  public int mediatype;
  public int pic_actiontype = -1;
  public String pic_actionurl = "";
  public s_picdata picdata;
  public String postparams = "";
  public String remark = "";
  public String summary = "";
  public String title = "";
  public byte usepost;
  public s_user user;
  public int user_actiontype = 5;
  public String user_actionurl = "";
  
  static
  {
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public cell_left_thumb() {}
  
  public cell_left_thumb(int paramInt1, s_picdata params_picdata, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, byte paramByte, s_user params_user, int paramInt3, String paramString6, int paramInt4, String paramString7, Map paramMap)
  {
    this.mediatype = paramInt1;
    this.picdata = params_picdata;
    this.summary = paramString1;
    this.title = paramString2;
    this.actiontype = paramInt2;
    this.actionturl = paramString3;
    this.remark = paramString4;
    this.postparams = paramString5;
    this.usepost = paramByte;
    this.user = params_user;
    this.pic_actiontype = paramInt3;
    this.pic_actionurl = paramString6;
    this.user_actiontype = paramInt4;
    this.user_actionurl = paramString7;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mediatype = paramJceInputStream.read(this.mediatype, 0, false);
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 1, false));
    this.summary = paramJceInputStream.readString(2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionturl = paramJceInputStream.readString(5, false);
    this.remark = paramJceInputStream.readString(6, false);
    this.postparams = paramJceInputStream.readString(7, false);
    this.usepost = paramJceInputStream.read(this.usepost, 8, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 9, false));
    this.pic_actiontype = paramJceInputStream.read(this.pic_actiontype, 10, false);
    this.pic_actionurl = paramJceInputStream.readString(11, false);
    this.user_actiontype = paramJceInputStream.read(this.user_actiontype, 12, false);
    this.user_actionurl = paramJceInputStream.readString(13, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mediatype, 0);
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionturl != null) {
      paramJceOutputStream.write(this.actionturl, 5);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 6);
    }
    if (this.postparams != null) {
      paramJceOutputStream.write(this.postparams, 7);
    }
    paramJceOutputStream.write(this.usepost, 8);
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 9);
    }
    paramJceOutputStream.write(this.pic_actiontype, 10);
    if (this.pic_actionurl != null) {
      paramJceOutputStream.write(this.pic_actionurl, 11);
    }
    paramJceOutputStream.write(this.user_actiontype, 12);
    if (this.user_actionurl != null) {
      paramJceOutputStream.write(this.user_actionurl, 13);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_left_thumb
 * JD-Core Version:    0.7.0.1
 */