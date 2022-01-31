package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_video
  extends JceStruct
{
  static Map cache_coverurl = new HashMap();
  static Map cache_extendinfo;
  static Map cache_gaussPicUrl;
  static ArrayList cache_vcCovers;
  static int cache_video_show_type;
  static int cache_video_source;
  static s_videoremark cache_videoremark;
  static Map cache_videourls;
  static s_weishi cache_weishi = new s_weishi();
  public int actiontype;
  public String actionurl = "";
  public int adv_delay_time;
  public int auto_refresh_second;
  public String clientkey = "";
  public Map coverurl;
  public Map extendinfo;
  public int filetype;
  public Map gaussPicUrl;
  public boolean isHadSetPlayOnWifi;
  public boolean isOnWifiPlay;
  public boolean isPanorama;
  public boolean is_share;
  public String lloc = "";
  public byte playtype;
  public int report_video_feeds_type;
  public String sloc = "";
  public String toast = "";
  public ArrayList vcCovers;
  public int video_form;
  public int video_show_type;
  public int video_source;
  public String video_webview_url = "";
  public String videoid = "";
  public int videoplaycnt;
  public s_videoremark videoremark;
  public int videostatus;
  public long videotime;
  public byte videotype;
  public String videourl = "";
  public Map videourls;
  public s_weishi weishi;
  
  static
  {
    Object localObject = new s_picurl();
    cache_coverurl.put(Integer.valueOf(0), localObject);
    cache_videourls = new HashMap();
    localObject = new s_videourl();
    cache_videourls.put(Integer.valueOf(0), localObject);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
    cache_videoremark = new s_videoremark();
    cache_video_show_type = 0;
    cache_video_source = 0;
    cache_vcCovers = new ArrayList();
    localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(0), new s_picurl());
    cache_vcCovers.add(localObject);
    cache_gaussPicUrl = new HashMap();
    localObject = new s_picurl();
    cache_gaussPicUrl.put(Integer.valueOf(0), localObject);
  }
  
  public cell_video() {}
  
  public cell_video(String paramString1, String paramString2, Map paramMap1, int paramInt1, String paramString3, String paramString4, int paramInt2, byte paramByte1, long paramLong, Map paramMap2, byte paramByte2, int paramInt3, String paramString5, Map paramMap3, s_videoremark params_videoremark, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString6, String paramString7, int paramInt6, int paramInt7, boolean paramBoolean2, int paramInt8, String paramString8, boolean paramBoolean3, boolean paramBoolean4, int paramInt9, ArrayList paramArrayList, int paramInt10, Map paramMap4, s_weishi params_weishi)
  {
    this.videoid = paramString1;
    this.videourl = paramString2;
    this.coverurl = paramMap1;
    this.actiontype = paramInt1;
    this.actionurl = paramString3;
    this.clientkey = paramString4;
    this.filetype = paramInt2;
    this.videotype = paramByte1;
    this.videotime = paramLong;
    this.videourls = paramMap2;
    this.playtype = paramByte2;
    this.videostatus = paramInt3;
    this.toast = paramString5;
    this.extendinfo = paramMap3;
    this.videoremark = params_videoremark;
    this.video_show_type = paramInt4;
    this.isPanorama = paramBoolean1;
    this.video_source = paramInt5;
    this.sloc = paramString6;
    this.lloc = paramString7;
    this.report_video_feeds_type = paramInt6;
    this.videoplaycnt = paramInt7;
    this.is_share = paramBoolean2;
    this.adv_delay_time = paramInt8;
    this.video_webview_url = paramString8;
    this.isOnWifiPlay = paramBoolean3;
    this.isHadSetPlayOnWifi = paramBoolean4;
    this.auto_refresh_second = paramInt9;
    this.vcCovers = paramArrayList;
    this.video_form = paramInt10;
    this.gaussPicUrl = paramMap4;
    this.weishi = params_weishi;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    this.coverurl = ((Map)paramJceInputStream.read(cache_coverurl, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    this.filetype = paramJceInputStream.read(this.filetype, 6, false);
    this.videotype = paramJceInputStream.read(this.videotype, 7, false);
    this.videotime = paramJceInputStream.read(this.videotime, 8, false);
    this.videourls = ((Map)paramJceInputStream.read(cache_videourls, 9, false));
    this.playtype = paramJceInputStream.read(this.playtype, 10, false);
    this.videostatus = paramJceInputStream.read(this.videostatus, 11, false);
    this.toast = paramJceInputStream.readString(12, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    this.videoremark = ((s_videoremark)paramJceInputStream.read(cache_videoremark, 14, false));
    this.video_show_type = paramJceInputStream.read(this.video_show_type, 15, false);
    this.isPanorama = paramJceInputStream.read(this.isPanorama, 16, false);
    this.video_source = paramJceInputStream.read(this.video_source, 17, false);
    this.sloc = paramJceInputStream.readString(18, false);
    this.lloc = paramJceInputStream.readString(19, false);
    this.report_video_feeds_type = paramJceInputStream.read(this.report_video_feeds_type, 20, false);
    this.videoplaycnt = paramJceInputStream.read(this.videoplaycnt, 21, false);
    this.is_share = paramJceInputStream.read(this.is_share, 22, false);
    this.adv_delay_time = paramJceInputStream.read(this.adv_delay_time, 23, false);
    this.video_webview_url = paramJceInputStream.readString(24, false);
    this.isOnWifiPlay = paramJceInputStream.read(this.isOnWifiPlay, 25, false);
    this.isHadSetPlayOnWifi = paramJceInputStream.read(this.isHadSetPlayOnWifi, 26, false);
    this.auto_refresh_second = paramJceInputStream.read(this.auto_refresh_second, 27, false);
    this.vcCovers = ((ArrayList)paramJceInputStream.read(cache_vcCovers, 28, false));
    this.video_form = paramJceInputStream.read(this.video_form, 29, false);
    this.gaussPicUrl = ((Map)paramJceInputStream.read(cache_gaussPicUrl, 30, false));
    this.weishi = ((s_weishi)paramJceInputStream.read(cache_weishi, 31, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.videoid != null) {
      paramJceOutputStream.write(this.videoid, 0);
    }
    if (this.videourl != null) {
      paramJceOutputStream.write(this.videourl, 1);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 4);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 5);
    }
    paramJceOutputStream.write(this.filetype, 6);
    paramJceOutputStream.write(this.videotype, 7);
    paramJceOutputStream.write(this.videotime, 8);
    if (this.videourls != null) {
      paramJceOutputStream.write(this.videourls, 9);
    }
    paramJceOutputStream.write(this.playtype, 10);
    paramJceOutputStream.write(this.videostatus, 11);
    if (this.toast != null) {
      paramJceOutputStream.write(this.toast, 12);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 13);
    }
    if (this.videoremark != null) {
      paramJceOutputStream.write(this.videoremark, 14);
    }
    paramJceOutputStream.write(this.video_show_type, 15);
    paramJceOutputStream.write(this.isPanorama, 16);
    paramJceOutputStream.write(this.video_source, 17);
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 18);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 19);
    }
    paramJceOutputStream.write(this.report_video_feeds_type, 20);
    paramJceOutputStream.write(this.videoplaycnt, 21);
    paramJceOutputStream.write(this.is_share, 22);
    paramJceOutputStream.write(this.adv_delay_time, 23);
    if (this.video_webview_url != null) {
      paramJceOutputStream.write(this.video_webview_url, 24);
    }
    paramJceOutputStream.write(this.isOnWifiPlay, 25);
    paramJceOutputStream.write(this.isHadSetPlayOnWifi, 26);
    paramJceOutputStream.write(this.auto_refresh_second, 27);
    if (this.vcCovers != null) {
      paramJceOutputStream.write(this.vcCovers, 28);
    }
    paramJceOutputStream.write(this.video_form, 29);
    if (this.gaussPicUrl != null) {
      paramJceOutputStream.write(this.gaussPicUrl, 30);
    }
    if (this.weishi != null) {
      paramJceOutputStream.write(this.weishi, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_video
 * JD-Core Version:    0.7.0.1
 */