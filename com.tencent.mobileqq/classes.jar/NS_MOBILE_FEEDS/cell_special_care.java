package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_special_care
  extends JceStruct
{
  static s_picurl cache_icon_after_click = new s_picurl();
  static s_picurl cache_icon_before_click;
  static s_user cache_userinfo = new s_user();
  public int comment_count = 0;
  public String desc_after_click = "";
  public String desc_before_click = "";
  public s_picurl icon_after_click = null;
  public s_picurl icon_before_click = null;
  public int intimacy = 0;
  public int like_count = 0;
  public int rankpercent = 0;
  public String relation_content = "";
  public s_user userinfo = null;
  public int visit_count = 0;
  
  static
  {
    cache_icon_before_click = new s_picurl();
  }
  
  public cell_special_care() {}
  
  public cell_special_care(s_user params_user, int paramInt1, int paramInt2, s_picurl params_picurl1, s_picurl params_picurl2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3)
  {
    this.userinfo = params_user;
    this.intimacy = paramInt1;
    this.rankpercent = paramInt2;
    this.icon_before_click = params_picurl1;
    this.icon_after_click = params_picurl2;
    this.desc_before_click = paramString1;
    this.desc_after_click = paramString2;
    this.visit_count = paramInt3;
    this.like_count = paramInt4;
    this.comment_count = paramInt5;
    this.relation_content = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userinfo = ((s_user)paramJceInputStream.read(cache_userinfo, 0, false));
    this.intimacy = paramJceInputStream.read(this.intimacy, 1, false);
    this.rankpercent = paramJceInputStream.read(this.rankpercent, 2, false);
    this.icon_before_click = ((s_picurl)paramJceInputStream.read(cache_icon_before_click, 3, false));
    this.icon_after_click = ((s_picurl)paramJceInputStream.read(cache_icon_after_click, 4, false));
    this.desc_before_click = paramJceInputStream.readString(5, false);
    this.desc_after_click = paramJceInputStream.readString(6, false);
    this.visit_count = paramJceInputStream.read(this.visit_count, 7, false);
    this.like_count = paramJceInputStream.read(this.like_count, 8, false);
    this.comment_count = paramJceInputStream.read(this.comment_count, 9, false);
    this.relation_content = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.userinfo != null) {
      paramJceOutputStream.write(this.userinfo, 0);
    }
    paramJceOutputStream.write(this.intimacy, 1);
    paramJceOutputStream.write(this.rankpercent, 2);
    if (this.icon_before_click != null) {
      paramJceOutputStream.write(this.icon_before_click, 3);
    }
    if (this.icon_after_click != null) {
      paramJceOutputStream.write(this.icon_after_click, 4);
    }
    if (this.desc_before_click != null) {
      paramJceOutputStream.write(this.desc_before_click, 5);
    }
    if (this.desc_after_click != null) {
      paramJceOutputStream.write(this.desc_after_click, 6);
    }
    paramJceOutputStream.write(this.visit_count, 7);
    paramJceOutputStream.write(this.like_count, 8);
    paramJceOutputStream.write(this.comment_count, 9);
    if (this.relation_content != null) {
      paramJceOutputStream.write(this.relation_content, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_special_care
 * JD-Core Version:    0.7.0.1
 */