package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_outshare;
import NS_MOBILE_FEEDS.s_weishi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WeishiAggregatePageRsp
  extends JceStruct
{
  static s_button cache_bottom_button = new s_button();
  static int cache_page_type;
  static s_outshare cache_share_info = new s_outshare();
  static s_weishi cache_weishi_info = new s_weishi();
  public s_button bottom_button = null;
  public String id = "";
  public long like_num = 0L;
  public int page_type = 0;
  public s_outshare share_info = null;
  public String shot_page_title = "";
  public String summary = "";
  public String title = "";
  public long video_num = 0L;
  public s_weishi weishi_info = null;
  
  public WeishiAggregatePageRsp() {}
  
  public WeishiAggregatePageRsp(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong1, long paramLong2, String paramString4, s_button params_button, s_outshare params_outshare, s_weishi params_weishi)
  {
    this.title = paramString1;
    this.id = paramString2;
    this.page_type = paramInt;
    this.summary = paramString3;
    this.video_num = paramLong1;
    this.like_num = paramLong2;
    this.shot_page_title = paramString4;
    this.bottom_button = params_button;
    this.share_info = params_outshare;
    this.weishi_info = params_weishi;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.id = paramJceInputStream.readString(1, false);
    this.page_type = paramJceInputStream.read(this.page_type, 2, false);
    this.summary = paramJceInputStream.readString(3, false);
    this.video_num = paramJceInputStream.read(this.video_num, 4, false);
    this.like_num = paramJceInputStream.read(this.like_num, 5, false);
    this.shot_page_title = paramJceInputStream.readString(6, false);
    this.bottom_button = ((s_button)paramJceInputStream.read(cache_bottom_button, 7, false));
    this.share_info = ((s_outshare)paramJceInputStream.read(cache_share_info, 8, false));
    this.weishi_info = ((s_weishi)paramJceInputStream.read(cache_weishi_info, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.page_type, 2);
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.video_num, 4);
    paramJceOutputStream.write(this.like_num, 5);
    localObject = this.shot_page_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.bottom_button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.share_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.weishi_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.WeishiAggregatePageRsp
 * JD-Core Version:    0.7.0.1
 */