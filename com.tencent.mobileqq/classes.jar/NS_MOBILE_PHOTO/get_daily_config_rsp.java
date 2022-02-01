package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_daily_config_rsp
  extends JceStruct
{
  static daily_config_eventcard cache_eventCard_conf = new daily_config_eventcard();
  static daily_recommend_status cache_recommend_status = new daily_recommend_status();
  public daily_config_eventcard eventCard_conf = null;
  public daily_recommend_status recommend_status = null;
  public boolean remind_upload_on = true;
  public long uin = 0L;
  
  public get_daily_config_rsp() {}
  
  public get_daily_config_rsp(long paramLong, daily_config_eventcard paramdaily_config_eventcard, daily_recommend_status paramdaily_recommend_status, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.eventCard_conf = paramdaily_config_eventcard;
    this.recommend_status = paramdaily_recommend_status;
    this.remind_upload_on = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.eventCard_conf = ((daily_config_eventcard)paramJceInputStream.read(cache_eventCard_conf, 1, false));
    this.recommend_status = ((daily_recommend_status)paramJceInputStream.read(cache_recommend_status, 2, false));
    this.remind_upload_on = paramJceInputStream.read(this.remind_upload_on, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Object localObject = this.eventCard_conf;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.recommend_status;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    paramJceOutputStream.write(this.remind_upload_on, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_daily_config_rsp
 * JD-Core Version:    0.7.0.1
 */