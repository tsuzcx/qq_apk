package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_visit_notification
  extends JceStruct
{
  static s_visit_contentkey cache_contentkey;
  static s_user cache_user;
  public s_visit_contentkey contentkey;
  public String msg = "";
  public short state;
  public long time;
  public s_user user;
  public short user_type;
  
  public s_visit_notification() {}
  
  public s_visit_notification(s_user params_user, short paramShort1, short paramShort2, String paramString, long paramLong, s_visit_contentkey params_visit_contentkey)
  {
    this.user = params_user;
    this.user_type = paramShort1;
    this.state = paramShort2;
    this.msg = paramString;
    this.time = paramLong;
    this.contentkey = params_visit_contentkey;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.user_type = paramJceInputStream.read(this.user_type, 1, false);
    this.state = paramJceInputStream.read(this.state, 2, false);
    this.msg = paramJceInputStream.readString(3, false);
    this.time = paramJceInputStream.read(this.time, 4, false);
    if (cache_contentkey == null) {
      cache_contentkey = new s_visit_contentkey();
    }
    this.contentkey = ((s_visit_contentkey)paramJceInputStream.read(cache_contentkey, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.user_type, 1);
    paramJceOutputStream.write(this.state, 2);
    localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.time, 4);
    localObject = this.contentkey;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_visit_notification
 * JD-Core Version:    0.7.0.1
 */