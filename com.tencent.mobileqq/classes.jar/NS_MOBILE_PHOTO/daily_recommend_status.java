package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class daily_recommend_status
  extends JceStruct
{
  static int cache_switchType;
  public boolean recommendPush_on = true;
  public boolean recommend_on = true;
  public int switchType = 0;
  
  public daily_recommend_status() {}
  
  public daily_recommend_status(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.recommend_on = paramBoolean1;
    this.recommendPush_on = paramBoolean2;
    this.switchType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.recommend_on = paramJceInputStream.read(this.recommend_on, 0, false);
    this.recommendPush_on = paramJceInputStream.read(this.recommendPush_on, 1, false);
    this.switchType = paramJceInputStream.read(this.switchType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.recommend_on, 0);
    paramJceOutputStream.write(this.recommendPush_on, 1);
    paramJceOutputStream.write(this.switchType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.daily_recommend_status
 * JD-Core Version:    0.7.0.1
 */