package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_video_nag_feedback_req
  extends JceStruct
{
  static ArrayList<nagative_fb_info> cache_vecNagFbInfo = new ArrayList();
  public long feedsUin = 0L;
  public long loginUin = 0L;
  public ArrayList<nagative_fb_info> vecNagFbInfo = null;
  
  static
  {
    nagative_fb_info localnagative_fb_info = new nagative_fb_info();
    cache_vecNagFbInfo.add(localnagative_fb_info);
  }
  
  public mobile_video_nag_feedback_req() {}
  
  public mobile_video_nag_feedback_req(long paramLong1, long paramLong2, ArrayList<nagative_fb_info> paramArrayList)
  {
    this.loginUin = paramLong1;
    this.feedsUin = paramLong2;
    this.vecNagFbInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.loginUin = paramJceInputStream.read(this.loginUin, 0, false);
    this.feedsUin = paramJceInputStream.read(this.feedsUin, 1, false);
    this.vecNagFbInfo = ((ArrayList)paramJceInputStream.read(cache_vecNagFbInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.loginUin, 0);
    paramJceOutputStream.write(this.feedsUin, 1);
    if (this.vecNagFbInfo != null) {
      paramJceOutputStream.write(this.vecNagFbInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_DROPLIST.mobile_video_nag_feedback_req
 * JD-Core Version:    0.7.0.1
 */