package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_left_thumb
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static s_picdata cache_picdata = new s_picdata();
  static s_user cache_user = new s_user();
  public String actionturl = "";
  public int actiontype = 0;
  public Map<String, String> mapExt = null;
  public int mediatype = 0;
  public int pic_actiontype = -1;
  public String pic_actionurl = "";
  public s_picdata picdata = null;
  public String postparams = "";
  public String remark = "";
  public String summary = "";
  public String title = "";
  public byte usepost = 0;
  public s_user user = null;
  public int user_actiontype = 5;
  public String user_actionurl = "";
  
  static
  {
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public cell_left_thumb() {}
  
  public cell_left_thumb(int paramInt1, s_picdata params_picdata, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, byte paramByte, s_user params_user, int paramInt3, String paramString6, int paramInt4, String paramString7, Map<String, String> paramMap)
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
    Object localObject = this.picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
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
    localObject = this.actionturl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.remark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.postparams;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.usepost, 8);
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    paramJceOutputStream.write(this.pic_actiontype, 10);
    localObject = this.pic_actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.user_actiontype, 12);
    localObject = this.user_actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_left_thumb
 * JD-Core Version:    0.7.0.1
 */