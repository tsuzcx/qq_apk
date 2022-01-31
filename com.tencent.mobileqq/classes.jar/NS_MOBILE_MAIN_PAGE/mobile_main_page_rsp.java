package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_MUSIC.MusicInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_main_page_rsp
  extends JceStruct
{
  static ArrayList cache_adv_banner;
  static ArrayList cache_all_acc;
  static ArrayList cache_all_music_list;
  static s_appinfo cache_appinfo;
  static byte[] cache_bgvoice_buf;
  static s_birthday cache_birthday;
  static s_brandspace_h5 cache_brandspace_h5;
  static s_campus_qz cache_campus_qz;
  static s_count cache_count;
  static s_flower cache_flower;
  static s_friend_ship cache_friend_ship;
  static s_friendreq cache_friendreq;
  static s_game cache_game;
  static s_gift cache_gift;
  static s_main_page cache_mainpage = new s_main_page();
  static s_mayknow cache_mayknow;
  static s_msgb_festival cache_msgb_festival;
  static s_part_error cache_part_error;
  static s_rec_photo_list cache_photos;
  static ArrayList cache_photos_buf;
  static s_profile cache_profile = new s_profile();
  static s_read_space cache_readspace;
  static ArrayList cache_recent_photos;
  static Map cache_redinfo;
  static s_special cache_special;
  static s_sq_mainpage_switch cache_sq_mainpage_switch = new s_sq_mainpage_switch();
  static s_tab_list cache_tab_lst;
  static s_visit cache_visit;
  static s_visit cache_visit_no_right;
  public ArrayList adv_banner;
  public ArrayList all_acc;
  public ArrayList all_music_list;
  public int all_music_nums;
  public s_appinfo appinfo;
  public String attach_info = "";
  public byte[] bgvoice_buf;
  public s_birthday birthday;
  public s_brandspace_h5 brandspace_h5;
  public s_campus_qz campus_qz;
  public s_count count;
  public s_flower flower;
  public s_friend_ship friend_ship;
  public s_friendreq friendreq;
  public s_game game;
  public s_gift gift;
  public byte green_diamond_flag;
  public byte loop_playback_flag;
  public s_main_page mainpage;
  public s_mayknow mayknow;
  public s_msgb_festival msgb_festival;
  public boolean music_can_play = true;
  public int no_update;
  public boolean open_msg_board = true;
  public s_part_error part_error;
  public s_rec_photo_list photos;
  public ArrayList photos_buf;
  public byte play_mode_flag;
  public s_profile profile;
  public String qzmall_cover_url = "";
  public s_read_space readspace;
  public ArrayList recent_photos;
  public Map redinfo;
  public String share_bg_url = "";
  public s_special special;
  public s_sq_mainpage_switch sq_mainpage_switch;
  public s_tab_list tab_lst;
  public long uWanBaNew;
  public s_visit visit;
  public s_visit visit_no_right;
  public byte wifi_auto_play;
  
  static
  {
    cache_count = new s_count();
    cache_visit = new s_visit();
    cache_birthday = new s_birthday();
    cache_gift = new s_gift();
    cache_friendreq = new s_friendreq();
    cache_special = new s_special();
    cache_mayknow = new s_mayknow();
    cache_part_error = new s_part_error();
    cache_appinfo = new s_appinfo();
    cache_photos = new s_rec_photo_list();
    cache_visit_no_right = new s_visit();
    cache_photos_buf = new ArrayList();
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_photos_buf.add(localObject);
    cache_recent_photos = new ArrayList();
    localObject = new single_feed();
    cache_recent_photos.add(localObject);
    cache_readspace = new s_read_space();
    cache_flower = new s_flower();
    cache_game = new s_game();
    cache_redinfo = new HashMap();
    localObject = new s_red_comm();
    cache_redinfo.put(Integer.valueOf(0), localObject);
    cache_friend_ship = new s_friend_ship();
    cache_all_music_list = new ArrayList();
    localObject = new MusicInfo();
    cache_all_music_list.add(localObject);
    cache_all_acc = new ArrayList();
    localObject = new s_app_acc();
    cache_all_acc.add(localObject);
    cache_adv_banner = new ArrayList();
    localObject = new QueryADBannerUnit();
    cache_adv_banner.add(localObject);
    cache_msgb_festival = new s_msgb_festival();
    cache_brandspace_h5 = new s_brandspace_h5();
    cache_campus_qz = new s_campus_qz();
    cache_bgvoice_buf = (byte[])new byte[1];
    ((byte[])cache_bgvoice_buf)[0] = 0;
    cache_tab_lst = new s_tab_list();
  }
  
  public mobile_main_page_rsp() {}
  
  public mobile_main_page_rsp(s_main_page params_main_page, s_profile params_profile, s_count params_count, s_visit params_visit1, s_birthday params_birthday, s_gift params_gift, s_friendreq params_friendreq, s_special params_special, s_mayknow params_mayknow, s_part_error params_part_error, s_appinfo params_appinfo, s_rec_photo_list params_rec_photo_list, s_visit params_visit2, ArrayList paramArrayList1, ArrayList paramArrayList2, s_read_space params_read_space, String paramString1, int paramInt1, s_flower params_flower, s_game params_game, Map paramMap, long paramLong, s_friend_ship params_friend_ship, byte paramByte1, boolean paramBoolean1, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4, byte paramByte2, byte paramByte3, ArrayList paramArrayList5, s_msgb_festival params_msgb_festival, s_brandspace_h5 params_brandspace_h5, s_campus_qz params_campus_qz, byte[] paramArrayOfByte, byte paramByte4, s_tab_list params_tab_list, String paramString2, String paramString3, boolean paramBoolean2, s_sq_mainpage_switch params_sq_mainpage_switch)
  {
    this.mainpage = params_main_page;
    this.profile = params_profile;
    this.count = params_count;
    this.visit = params_visit1;
    this.birthday = params_birthday;
    this.gift = params_gift;
    this.friendreq = params_friendreq;
    this.special = params_special;
    this.mayknow = params_mayknow;
    this.part_error = params_part_error;
    this.appinfo = params_appinfo;
    this.photos = params_rec_photo_list;
    this.visit_no_right = params_visit2;
    this.photos_buf = paramArrayList1;
    this.recent_photos = paramArrayList2;
    this.readspace = params_read_space;
    this.attach_info = paramString1;
    this.no_update = paramInt1;
    this.flower = params_flower;
    this.game = params_game;
    this.redinfo = paramMap;
    this.uWanBaNew = paramLong;
    this.friend_ship = params_friend_ship;
    this.green_diamond_flag = paramByte1;
    this.music_can_play = paramBoolean1;
    this.all_music_nums = paramInt2;
    this.all_music_list = paramArrayList3;
    this.all_acc = paramArrayList4;
    this.wifi_auto_play = paramByte2;
    this.play_mode_flag = paramByte3;
    this.adv_banner = paramArrayList5;
    this.msgb_festival = params_msgb_festival;
    this.brandspace_h5 = params_brandspace_h5;
    this.campus_qz = params_campus_qz;
    this.bgvoice_buf = paramArrayOfByte;
    this.loop_playback_flag = paramByte4;
    this.tab_lst = params_tab_list;
    this.share_bg_url = paramString2;
    this.qzmall_cover_url = paramString3;
    this.open_msg_board = paramBoolean2;
    this.sq_mainpage_switch = params_sq_mainpage_switch;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mainpage = ((s_main_page)paramJceInputStream.read(cache_mainpage, 0, false));
    this.profile = ((s_profile)paramJceInputStream.read(cache_profile, 1, false));
    this.count = ((s_count)paramJceInputStream.read(cache_count, 2, false));
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 3, false));
    this.birthday = ((s_birthday)paramJceInputStream.read(cache_birthday, 4, false));
    this.gift = ((s_gift)paramJceInputStream.read(cache_gift, 5, false));
    this.friendreq = ((s_friendreq)paramJceInputStream.read(cache_friendreq, 6, false));
    this.special = ((s_special)paramJceInputStream.read(cache_special, 7, false));
    this.mayknow = ((s_mayknow)paramJceInputStream.read(cache_mayknow, 8, false));
    this.part_error = ((s_part_error)paramJceInputStream.read(cache_part_error, 9, false));
    this.appinfo = ((s_appinfo)paramJceInputStream.read(cache_appinfo, 10, false));
    this.photos = ((s_rec_photo_list)paramJceInputStream.read(cache_photos, 11, false));
    this.visit_no_right = ((s_visit)paramJceInputStream.read(cache_visit_no_right, 12, false));
    this.photos_buf = ((ArrayList)paramJceInputStream.read(cache_photos_buf, 13, false));
    this.recent_photos = ((ArrayList)paramJceInputStream.read(cache_recent_photos, 14, false));
    this.readspace = ((s_read_space)paramJceInputStream.read(cache_readspace, 15, false));
    this.attach_info = paramJceInputStream.readString(16, false);
    this.no_update = paramJceInputStream.read(this.no_update, 17, false);
    this.flower = ((s_flower)paramJceInputStream.read(cache_flower, 18, false));
    this.game = ((s_game)paramJceInputStream.read(cache_game, 19, false));
    this.redinfo = ((Map)paramJceInputStream.read(cache_redinfo, 20, false));
    this.uWanBaNew = paramJceInputStream.read(this.uWanBaNew, 21, false);
    this.friend_ship = ((s_friend_ship)paramJceInputStream.read(cache_friend_ship, 22, false));
    this.green_diamond_flag = paramJceInputStream.read(this.green_diamond_flag, 23, false);
    this.music_can_play = paramJceInputStream.read(this.music_can_play, 24, false);
    this.all_music_nums = paramJceInputStream.read(this.all_music_nums, 25, false);
    this.all_music_list = ((ArrayList)paramJceInputStream.read(cache_all_music_list, 26, false));
    this.all_acc = ((ArrayList)paramJceInputStream.read(cache_all_acc, 27, false));
    this.wifi_auto_play = paramJceInputStream.read(this.wifi_auto_play, 28, false);
    this.play_mode_flag = paramJceInputStream.read(this.play_mode_flag, 29, false);
    this.adv_banner = ((ArrayList)paramJceInputStream.read(cache_adv_banner, 30, false));
    this.msgb_festival = ((s_msgb_festival)paramJceInputStream.read(cache_msgb_festival, 31, false));
    this.brandspace_h5 = ((s_brandspace_h5)paramJceInputStream.read(cache_brandspace_h5, 32, false));
    this.campus_qz = ((s_campus_qz)paramJceInputStream.read(cache_campus_qz, 33, false));
    this.bgvoice_buf = ((byte[])paramJceInputStream.read(cache_bgvoice_buf, 34, false));
    this.loop_playback_flag = paramJceInputStream.read(this.loop_playback_flag, 35, false);
    this.tab_lst = ((s_tab_list)paramJceInputStream.read(cache_tab_lst, 36, false));
    this.share_bg_url = paramJceInputStream.readString(37, false);
    this.qzmall_cover_url = paramJceInputStream.readString(38, false);
    this.open_msg_board = paramJceInputStream.read(this.open_msg_board, 39, false);
    this.sq_mainpage_switch = ((s_sq_mainpage_switch)paramJceInputStream.read(cache_sq_mainpage_switch, 40, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mainpage != null) {
      paramJceOutputStream.write(this.mainpage, 0);
    }
    if (this.profile != null) {
      paramJceOutputStream.write(this.profile, 1);
    }
    if (this.count != null) {
      paramJceOutputStream.write(this.count, 2);
    }
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 3);
    }
    if (this.birthday != null) {
      paramJceOutputStream.write(this.birthday, 4);
    }
    if (this.gift != null) {
      paramJceOutputStream.write(this.gift, 5);
    }
    if (this.friendreq != null) {
      paramJceOutputStream.write(this.friendreq, 6);
    }
    if (this.special != null) {
      paramJceOutputStream.write(this.special, 7);
    }
    if (this.mayknow != null) {
      paramJceOutputStream.write(this.mayknow, 8);
    }
    if (this.part_error != null) {
      paramJceOutputStream.write(this.part_error, 9);
    }
    if (this.appinfo != null) {
      paramJceOutputStream.write(this.appinfo, 10);
    }
    if (this.photos != null) {
      paramJceOutputStream.write(this.photos, 11);
    }
    if (this.visit_no_right != null) {
      paramJceOutputStream.write(this.visit_no_right, 12);
    }
    if (this.photos_buf != null) {
      paramJceOutputStream.write(this.photos_buf, 13);
    }
    if (this.recent_photos != null) {
      paramJceOutputStream.write(this.recent_photos, 14);
    }
    if (this.readspace != null) {
      paramJceOutputStream.write(this.readspace, 15);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 16);
    }
    paramJceOutputStream.write(this.no_update, 17);
    if (this.flower != null) {
      paramJceOutputStream.write(this.flower, 18);
    }
    if (this.game != null) {
      paramJceOutputStream.write(this.game, 19);
    }
    if (this.redinfo != null) {
      paramJceOutputStream.write(this.redinfo, 20);
    }
    paramJceOutputStream.write(this.uWanBaNew, 21);
    if (this.friend_ship != null) {
      paramJceOutputStream.write(this.friend_ship, 22);
    }
    paramJceOutputStream.write(this.green_diamond_flag, 23);
    paramJceOutputStream.write(this.music_can_play, 24);
    paramJceOutputStream.write(this.all_music_nums, 25);
    if (this.all_music_list != null) {
      paramJceOutputStream.write(this.all_music_list, 26);
    }
    if (this.all_acc != null) {
      paramJceOutputStream.write(this.all_acc, 27);
    }
    paramJceOutputStream.write(this.wifi_auto_play, 28);
    paramJceOutputStream.write(this.play_mode_flag, 29);
    if (this.adv_banner != null) {
      paramJceOutputStream.write(this.adv_banner, 30);
    }
    if (this.msgb_festival != null) {
      paramJceOutputStream.write(this.msgb_festival, 31);
    }
    if (this.brandspace_h5 != null) {
      paramJceOutputStream.write(this.brandspace_h5, 32);
    }
    if (this.campus_qz != null) {
      paramJceOutputStream.write(this.campus_qz, 33);
    }
    if (this.bgvoice_buf != null) {
      paramJceOutputStream.write(this.bgvoice_buf, 34);
    }
    paramJceOutputStream.write(this.loop_playback_flag, 35);
    if (this.tab_lst != null) {
      paramJceOutputStream.write(this.tab_lst, 36);
    }
    if (this.share_bg_url != null) {
      paramJceOutputStream.write(this.share_bg_url, 37);
    }
    if (this.qzmall_cover_url != null) {
      paramJceOutputStream.write(this.qzmall_cover_url, 38);
    }
    paramJceOutputStream.write(this.open_msg_board, 39);
    if (this.sq_mainpage_switch != null) {
      paramJceOutputStream.write(this.sq_mainpage_switch, 40);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_main_page_rsp
 * JD-Core Version:    0.7.0.1
 */