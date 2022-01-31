package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_pic
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static ArrayList<s_user> cache_facemans;
  static s_user cache_friendinfo;
  static ArrayList<s_picdata> cache_picdata = new ArrayList();
  static ArrayList<wx_user_info> cache_sharer_wx_info;
  static int cache_sort_type;
  public int actiontype = 18;
  public String actionurl = "";
  public int activealbum;
  public int albshowmask;
  public String albumanswer = "";
  public String albumid = "";
  public String albumname = "";
  public int albumnum;
  public String albumquestion = "";
  public int albumrights;
  public int albumtype;
  public int allow_access;
  public int allow_share;
  public int animation_type;
  public int anonymity;
  public boolean balbum = true;
  public Map<Integer, String> busi_param;
  public String desc = "";
  public int extend_actiontype;
  public String extend_actionurl = "";
  public int faceman_num;
  public ArrayList<s_user> facemans;
  public s_user friendinfo;
  public String icon_url = "";
  public int individualalbum;
  public boolean isSubscribe = true;
  public boolean is_contain_video_and_pic;
  public boolean is_share;
  public boolean is_share_owner = true;
  public boolean is_topped_album;
  public boolean is_video_pic_mix;
  public int lastupdatetime;
  public int like_cnt;
  public int newestupload;
  public String news = "";
  public ArrayList<s_picdata> picdata;
  public String qunid = "";
  public String share_new_reason = "";
  public int sharer_count;
  public ArrayList<wx_user_info> sharer_wx_info;
  public int sort_type;
  public String store_appid = "";
  public long uin;
  public int unread_count;
  public int uploadnum;
  public int view_cnt;
  
  static
  {
    Object localObject = new s_picdata();
    cache_picdata.add(localObject);
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_friendinfo = new s_user();
    cache_facemans = new ArrayList();
    localObject = new s_user();
    cache_facemans.add(localObject);
    cache_sort_type = 0;
    cache_sharer_wx_info = new ArrayList();
    localObject = new wx_user_info();
    cache_sharer_wx_info.add(localObject);
  }
  
  public cell_pic() {}
  
  public cell_pic(ArrayList<s_picdata> paramArrayList, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, long paramLong, boolean paramBoolean1, int paramInt4, Map<Integer, String> paramMap, String paramString6, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString7, boolean paramBoolean2, s_user params_user, String paramString8, int paramInt9, ArrayList<s_user> paramArrayList1, int paramInt10, String paramString9, int paramInt11, String paramString10, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt17, int paramInt18, boolean paramBoolean7, int paramInt19, int paramInt20, String paramString11, int paramInt21, ArrayList<wx_user_info> paramArrayList2, String paramString12)
  {
    this.picdata = paramArrayList;
    this.albumname = paramString1;
    this.albumid = paramString2;
    this.albumnum = paramInt1;
    this.uploadnum = paramInt2;
    this.albumrights = paramInt3;
    this.albumquestion = paramString3;
    this.albumanswer = paramString4;
    this.desc = paramString5;
    this.uin = paramLong;
    this.balbum = paramBoolean1;
    this.lastupdatetime = paramInt4;
    this.busi_param = paramMap;
    this.qunid = paramString6;
    this.allow_access = paramInt5;
    this.anonymity = paramInt6;
    this.albumtype = paramInt7;
    this.actiontype = paramInt8;
    this.actionurl = paramString7;
    this.isSubscribe = paramBoolean2;
    this.friendinfo = params_user;
    this.news = paramString8;
    this.unread_count = paramInt9;
    this.facemans = paramArrayList1;
    this.faceman_num = paramInt10;
    this.store_appid = paramString9;
    this.extend_actiontype = paramInt11;
    this.extend_actionurl = paramString10;
    this.albshowmask = paramInt12;
    this.allow_share = paramInt13;
    this.individualalbum = paramInt14;
    this.activealbum = paramInt15;
    this.newestupload = paramInt16;
    this.is_share = paramBoolean3;
    this.is_video_pic_mix = paramBoolean4;
    this.is_contain_video_and_pic = paramBoolean5;
    this.is_share_owner = paramBoolean6;
    this.animation_type = paramInt17;
    this.sort_type = paramInt18;
    this.is_topped_album = paramBoolean7;
    this.view_cnt = paramInt19;
    this.like_cnt = paramInt20;
    this.icon_url = paramString11;
    this.sharer_count = paramInt21;
    this.sharer_wx_info = paramArrayList2;
    this.share_new_reason = paramString12;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picdata = ((ArrayList)paramJceInputStream.read(cache_picdata, 0, false));
    this.albumname = paramJceInputStream.readString(1, false);
    this.albumid = paramJceInputStream.readString(2, false);
    this.albumnum = paramJceInputStream.read(this.albumnum, 3, false);
    this.uploadnum = paramJceInputStream.read(this.uploadnum, 4, false);
    this.albumrights = paramJceInputStream.read(this.albumrights, 5, false);
    this.albumquestion = paramJceInputStream.readString(6, false);
    this.albumanswer = paramJceInputStream.readString(7, false);
    this.desc = paramJceInputStream.readString(8, false);
    this.uin = paramJceInputStream.read(this.uin, 9, false);
    this.balbum = paramJceInputStream.read(this.balbum, 10, false);
    this.lastupdatetime = paramJceInputStream.read(this.lastupdatetime, 11, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 12, false));
    this.qunid = paramJceInputStream.readString(13, false);
    this.allow_access = paramJceInputStream.read(this.allow_access, 14, false);
    this.anonymity = paramJceInputStream.read(this.anonymity, 15, false);
    this.albumtype = paramJceInputStream.read(this.albumtype, 16, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 17, false);
    this.actionurl = paramJceInputStream.readString(18, false);
    this.isSubscribe = paramJceInputStream.read(this.isSubscribe, 19, false);
    this.friendinfo = ((s_user)paramJceInputStream.read(cache_friendinfo, 20, false));
    this.news = paramJceInputStream.readString(21, false);
    this.unread_count = paramJceInputStream.read(this.unread_count, 22, false);
    this.facemans = ((ArrayList)paramJceInputStream.read(cache_facemans, 23, false));
    this.faceman_num = paramJceInputStream.read(this.faceman_num, 24, false);
    this.store_appid = paramJceInputStream.readString(25, false);
    this.extend_actiontype = paramJceInputStream.read(this.extend_actiontype, 26, false);
    this.extend_actionurl = paramJceInputStream.readString(27, false);
    this.albshowmask = paramJceInputStream.read(this.albshowmask, 28, false);
    this.allow_share = paramJceInputStream.read(this.allow_share, 29, false);
    this.individualalbum = paramJceInputStream.read(this.individualalbum, 30, false);
    this.activealbum = paramJceInputStream.read(this.activealbum, 31, false);
    this.newestupload = paramJceInputStream.read(this.newestupload, 32, false);
    this.is_share = paramJceInputStream.read(this.is_share, 33, false);
    this.is_video_pic_mix = paramJceInputStream.read(this.is_video_pic_mix, 34, false);
    this.is_contain_video_and_pic = paramJceInputStream.read(this.is_contain_video_and_pic, 35, false);
    this.is_share_owner = paramJceInputStream.read(this.is_share_owner, 36, false);
    this.animation_type = paramJceInputStream.read(this.animation_type, 37, false);
    this.sort_type = paramJceInputStream.read(this.sort_type, 38, false);
    this.is_topped_album = paramJceInputStream.read(this.is_topped_album, 39, false);
    this.view_cnt = paramJceInputStream.read(this.view_cnt, 40, false);
    this.like_cnt = paramJceInputStream.read(this.like_cnt, 41, false);
    this.icon_url = paramJceInputStream.readString(42, false);
    this.sharer_count = paramJceInputStream.read(this.sharer_count, 43, false);
    this.sharer_wx_info = ((ArrayList)paramJceInputStream.read(cache_sharer_wx_info, 44, false));
    this.share_new_reason = paramJceInputStream.readString(45, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 0);
    }
    if (this.albumname != null) {
      paramJceOutputStream.write(this.albumname, 1);
    }
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 2);
    }
    paramJceOutputStream.write(this.albumnum, 3);
    paramJceOutputStream.write(this.uploadnum, 4);
    paramJceOutputStream.write(this.albumrights, 5);
    if (this.albumquestion != null) {
      paramJceOutputStream.write(this.albumquestion, 6);
    }
    if (this.albumanswer != null) {
      paramJceOutputStream.write(this.albumanswer, 7);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 8);
    }
    paramJceOutputStream.write(this.uin, 9);
    paramJceOutputStream.write(this.balbum, 10);
    paramJceOutputStream.write(this.lastupdatetime, 11);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 12);
    }
    if (this.qunid != null) {
      paramJceOutputStream.write(this.qunid, 13);
    }
    paramJceOutputStream.write(this.allow_access, 14);
    paramJceOutputStream.write(this.anonymity, 15);
    paramJceOutputStream.write(this.albumtype, 16);
    paramJceOutputStream.write(this.actiontype, 17);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 18);
    }
    paramJceOutputStream.write(this.isSubscribe, 19);
    if (this.friendinfo != null) {
      paramJceOutputStream.write(this.friendinfo, 20);
    }
    if (this.news != null) {
      paramJceOutputStream.write(this.news, 21);
    }
    paramJceOutputStream.write(this.unread_count, 22);
    if (this.facemans != null) {
      paramJceOutputStream.write(this.facemans, 23);
    }
    paramJceOutputStream.write(this.faceman_num, 24);
    if (this.store_appid != null) {
      paramJceOutputStream.write(this.store_appid, 25);
    }
    paramJceOutputStream.write(this.extend_actiontype, 26);
    if (this.extend_actionurl != null) {
      paramJceOutputStream.write(this.extend_actionurl, 27);
    }
    paramJceOutputStream.write(this.albshowmask, 28);
    paramJceOutputStream.write(this.allow_share, 29);
    paramJceOutputStream.write(this.individualalbum, 30);
    paramJceOutputStream.write(this.activealbum, 31);
    paramJceOutputStream.write(this.newestupload, 32);
    paramJceOutputStream.write(this.is_share, 33);
    paramJceOutputStream.write(this.is_video_pic_mix, 34);
    paramJceOutputStream.write(this.is_contain_video_and_pic, 35);
    paramJceOutputStream.write(this.is_share_owner, 36);
    paramJceOutputStream.write(this.animation_type, 37);
    paramJceOutputStream.write(this.sort_type, 38);
    paramJceOutputStream.write(this.is_topped_album, 39);
    paramJceOutputStream.write(this.view_cnt, 40);
    paramJceOutputStream.write(this.like_cnt, 41);
    if (this.icon_url != null) {
      paramJceOutputStream.write(this.icon_url, 42);
    }
    paramJceOutputStream.write(this.sharer_count, 43);
    if (this.sharer_wx_info != null) {
      paramJceOutputStream.write(this.sharer_wx_info, 44);
    }
    if (this.share_new_reason != null) {
      paramJceOutputStream.write(this.share_new_reason, 45);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_pic
 * JD-Core Version:    0.7.0.1
 */