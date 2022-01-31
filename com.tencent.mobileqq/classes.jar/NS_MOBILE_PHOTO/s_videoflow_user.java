package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_videoflow_user
  extends JceStruct
{
  static s_user cache_user = new s_user();
  public long follower_count;
  public long following_count;
  public boolean is_followed;
  public boolean is_following;
  public s_user user;
  
  public s_videoflow_user() {}
  
  public s_videoflow_user(s_user params_user, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.user = params_user;
    this.is_followed = paramBoolean1;
    this.is_following = paramBoolean2;
    this.follower_count = paramLong1;
    this.following_count = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, true));
    this.is_followed = paramJceInputStream.read(this.is_followed, 1, true);
    this.is_following = paramJceInputStream.read(this.is_following, 2, false);
    this.follower_count = paramJceInputStream.read(this.follower_count, 3, false);
    this.following_count = paramJceInputStream.read(this.following_count, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.user, 0);
    paramJceOutputStream.write(this.is_followed, 1);
    paramJceOutputStream.write(this.is_following, 2);
    paramJceOutputStream.write(this.follower_count, 3);
    paramJceOutputStream.write(this.following_count, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.s_videoflow_user
 * JD-Core Version:    0.7.0.1
 */