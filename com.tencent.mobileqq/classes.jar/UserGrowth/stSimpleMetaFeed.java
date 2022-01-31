package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaGeoInfo;
import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import NS_KING_SOCIALIZE_META.stMusicFullInfo;
import NS_KING_SOCIALIZE_META.stShareInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleMetaFeed
  extends JceStruct
{
  static stMetaTag cache_bt_style;
  static ArrayList<stMetaComment> cache_comments;
  static stMetaGeoInfo cache_geoInfo;
  static stH5OpInfo cache_h5_op_info;
  static ArrayList<stMetaUgcImage> cache_images;
  static ArrayList<stImgReplacement> cache_imgReplacements;
  static stMagicBrand cache_magicBrand;
  static Map<String, String> cache_map_ext;
  static Map<Integer, byte[]> cache_map_pass_back;
  static stMusicFullInfo cache_music_info;
  static stNewIconStyle cache_new_icon;
  static stOpVideo cache_opVideo;
  static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
  static stShareInfo cache_share_info;
  static ArrayList<stSimpleComment> cache_simpleComments;
  static ArrayList<stMetaTag> cache_tags;
  static stMetaUgcVideoSeg cache_video = new stMetaUgcVideoSeg();
  static stVideoTag cache_videoTag = new stVideoTag();
  static stWaterFallCardStyle cache_waterFallCardStyle;
  static stWaterFallItemStrategy cache_waterFallItemStrategy;
  public String bottom_img_url = "";
  public stMetaTag bt_style;
  public ArrayList<stMetaComment> comments;
  public int createTime;
  public int ding_count;
  public String feed_desc = "";
  public String feed_material_jump_url = "";
  public String gdt_ad_info = "";
  public int gdt_ad_type;
  public stMetaGeoInfo geoInfo;
  public stH5OpInfo h5_op_info;
  public String id = "";
  public ArrayList<stMetaUgcImage> images;
  public ArrayList<stImgReplacement> imgReplacements;
  public int is_ding;
  public stMagicBrand magicBrand;
  public Map<String, String> map_ext;
  public Map<Integer, byte[]> map_pass_back;
  public String material_desc = "";
  public String material_id = "";
  public String material_thumburl = "";
  public long music_begin_time;
  public long music_end_time;
  public String music_id = "";
  public stMusicFullInfo music_info;
  public stNewIconStyle new_icon;
  public stOpVideo opVideo;
  public int playNum;
  public stSimpleMetaPerson poster;
  public String poster_id = "";
  public stShareInfo share_info;
  public ArrayList<stSimpleComment> simpleComments;
  public ArrayList<stMetaTag> tags;
  public int total_comment_num;
  public String traceId = "";
  public stMetaUgcVideoSeg video;
  public int videoPoolType;
  public stVideoTag videoTag;
  public int video_type;
  public String video_url = "";
  public stWaterFallCardStyle waterFallCardStyle;
  public stWaterFallItemStrategy waterFallItemStrategy;
  public String weishi_jump_url = "";
  public String wording = "";
  
  static
  {
    cache_images = new ArrayList();
    Object localObject = new stMetaUgcImage();
    cache_images.add(localObject);
    cache_comments = new ArrayList();
    localObject = new stMetaComment();
    cache_comments.add(localObject);
    cache_share_info = new stShareInfo();
    cache_music_info = new stMusicFullInfo();
    cache_tags = new ArrayList();
    localObject = new stMetaTag();
    cache_tags.add(localObject);
    cache_map_pass_back = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_map_pass_back.put(Integer.valueOf(0), localObject);
    cache_bt_style = new stMetaTag();
    cache_h5_op_info = new stH5OpInfo();
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
    cache_new_icon = new stNewIconStyle();
    cache_waterFallItemStrategy = new stWaterFallItemStrategy();
    cache_waterFallCardStyle = new stWaterFallCardStyle();
    cache_imgReplacements = new ArrayList();
    localObject = new stImgReplacement();
    cache_imgReplacements.add(localObject);
    cache_opVideo = new stOpVideo();
    cache_geoInfo = new stMetaGeoInfo();
    cache_magicBrand = new stMagicBrand();
    cache_simpleComments = new ArrayList();
    localObject = new stSimpleComment();
    cache_simpleComments.add(localObject);
  }
  
  public stSimpleMetaFeed() {}
  
  public stSimpleMetaFeed(String paramString1, String paramString2, String paramString3, stSimpleMetaPerson paramstSimpleMetaPerson, stMetaUgcVideoSeg paramstMetaUgcVideoSeg, ArrayList<stMetaUgcImage> paramArrayList, int paramInt1, int paramInt2, ArrayList<stMetaComment> paramArrayList1, String paramString4, String paramString5, int paramInt3, int paramInt4, String paramString6, String paramString7, stShareInfo paramstShareInfo, String paramString8, long paramLong1, long paramLong2, stMusicFullInfo paramstMusicFullInfo, String paramString9, ArrayList<stMetaTag> paramArrayList2, Map<Integer, byte[]> paramMap, int paramInt5, String paramString10, stMetaTag paramstMetaTag, stH5OpInfo paramstH5OpInfo, int paramInt6, Map<String, String> paramMap1, String paramString11, String paramString12, stNewIconStyle paramstNewIconStyle, String paramString13, stWaterFallItemStrategy paramstWaterFallItemStrategy, stWaterFallCardStyle paramstWaterFallCardStyle, int paramInt7, ArrayList<stImgReplacement> paramArrayList3, stOpVideo paramstOpVideo, String paramString14, stMetaGeoInfo paramstMetaGeoInfo, stMagicBrand paramstMagicBrand, ArrayList<stSimpleComment> paramArrayList4, int paramInt8, stVideoTag paramstVideoTag)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.poster_id = paramString3;
    this.poster = paramstSimpleMetaPerson;
    this.video = paramstMetaUgcVideoSeg;
    this.images = paramArrayList;
    this.ding_count = paramInt1;
    this.total_comment_num = paramInt2;
    this.comments = paramArrayList1;
    this.material_id = paramString4;
    this.material_desc = paramString5;
    this.is_ding = paramInt3;
    this.playNum = paramInt4;
    this.video_url = paramString6;
    this.material_thumburl = paramString7;
    this.share_info = paramstShareInfo;
    this.feed_desc = paramString8;
    this.music_begin_time = paramLong1;
    this.music_end_time = paramLong2;
    this.music_info = paramstMusicFullInfo;
    this.music_id = paramString9;
    this.tags = paramArrayList2;
    this.map_pass_back = paramMap;
    this.gdt_ad_type = paramInt5;
    this.gdt_ad_info = paramString10;
    this.bt_style = paramstMetaTag;
    this.h5_op_info = paramstH5OpInfo;
    this.video_type = paramInt6;
    this.map_ext = paramMap1;
    this.weishi_jump_url = paramString11;
    this.bottom_img_url = paramString12;
    this.new_icon = paramstNewIconStyle;
    this.feed_material_jump_url = paramString13;
    this.waterFallItemStrategy = paramstWaterFallItemStrategy;
    this.waterFallCardStyle = paramstWaterFallCardStyle;
    this.videoPoolType = paramInt7;
    this.imgReplacements = paramArrayList3;
    this.opVideo = paramstOpVideo;
    this.traceId = paramString14;
    this.geoInfo = paramstMetaGeoInfo;
    this.magicBrand = paramstMagicBrand;
    this.simpleComments = paramArrayList4;
    this.createTime = paramInt8;
    this.videoTag = paramstVideoTag;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.poster_id = paramJceInputStream.readString(2, false);
    this.poster = ((stSimpleMetaPerson)paramJceInputStream.read(cache_poster, 3, false));
    this.video = ((stMetaUgcVideoSeg)paramJceInputStream.read(cache_video, 4, false));
    this.images = ((ArrayList)paramJceInputStream.read(cache_images, 5, false));
    this.ding_count = paramJceInputStream.read(this.ding_count, 6, false);
    this.total_comment_num = paramJceInputStream.read(this.total_comment_num, 7, false);
    this.comments = ((ArrayList)paramJceInputStream.read(cache_comments, 8, false));
    this.material_id = paramJceInputStream.readString(9, false);
    this.material_desc = paramJceInputStream.readString(10, false);
    this.is_ding = paramJceInputStream.read(this.is_ding, 11, false);
    this.playNum = paramJceInputStream.read(this.playNum, 12, false);
    this.video_url = paramJceInputStream.readString(13, false);
    this.material_thumburl = paramJceInputStream.readString(14, false);
    this.share_info = ((stShareInfo)paramJceInputStream.read(cache_share_info, 15, false));
    this.feed_desc = paramJceInputStream.readString(16, false);
    this.music_begin_time = paramJceInputStream.read(this.music_begin_time, 17, false);
    this.music_end_time = paramJceInputStream.read(this.music_end_time, 18, false);
    this.music_info = ((stMusicFullInfo)paramJceInputStream.read(cache_music_info, 19, false));
    this.music_id = paramJceInputStream.readString(20, false);
    this.tags = ((ArrayList)paramJceInputStream.read(cache_tags, 21, false));
    this.map_pass_back = ((Map)paramJceInputStream.read(cache_map_pass_back, 22, false));
    this.gdt_ad_type = paramJceInputStream.read(this.gdt_ad_type, 23, false);
    this.gdt_ad_info = paramJceInputStream.readString(24, false);
    this.bt_style = ((stMetaTag)paramJceInputStream.read(cache_bt_style, 25, false));
    this.h5_op_info = ((stH5OpInfo)paramJceInputStream.read(cache_h5_op_info, 26, false));
    this.video_type = paramJceInputStream.read(this.video_type, 27, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 28, false));
    this.weishi_jump_url = paramJceInputStream.readString(29, false);
    this.bottom_img_url = paramJceInputStream.readString(30, false);
    this.new_icon = ((stNewIconStyle)paramJceInputStream.read(cache_new_icon, 31, false));
    this.feed_material_jump_url = paramJceInputStream.readString(32, false);
    this.waterFallItemStrategy = ((stWaterFallItemStrategy)paramJceInputStream.read(cache_waterFallItemStrategy, 33, false));
    this.waterFallCardStyle = ((stWaterFallCardStyle)paramJceInputStream.read(cache_waterFallCardStyle, 34, false));
    this.videoPoolType = paramJceInputStream.read(this.videoPoolType, 35, false);
    this.imgReplacements = ((ArrayList)paramJceInputStream.read(cache_imgReplacements, 36, false));
    this.opVideo = ((stOpVideo)paramJceInputStream.read(cache_opVideo, 37, false));
    this.traceId = paramJceInputStream.readString(38, false);
    this.geoInfo = ((stMetaGeoInfo)paramJceInputStream.read(cache_geoInfo, 39, false));
    this.magicBrand = ((stMagicBrand)paramJceInputStream.read(cache_magicBrand, 40, false));
    this.simpleComments = ((ArrayList)paramJceInputStream.read(cache_simpleComments, 41, false));
    this.createTime = paramJceInputStream.read(this.createTime, 42, false);
    this.videoTag = ((stVideoTag)paramJceInputStream.read(cache_videoTag, 43, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.wording != null) {
      paramJceOutputStream.write(this.wording, 1);
    }
    if (this.poster_id != null) {
      paramJceOutputStream.write(this.poster_id, 2);
    }
    if (this.poster != null) {
      paramJceOutputStream.write(this.poster, 3);
    }
    if (this.video != null) {
      paramJceOutputStream.write(this.video, 4);
    }
    if (this.images != null) {
      paramJceOutputStream.write(this.images, 5);
    }
    paramJceOutputStream.write(this.ding_count, 6);
    paramJceOutputStream.write(this.total_comment_num, 7);
    if (this.comments != null) {
      paramJceOutputStream.write(this.comments, 8);
    }
    if (this.material_id != null) {
      paramJceOutputStream.write(this.material_id, 9);
    }
    if (this.material_desc != null) {
      paramJceOutputStream.write(this.material_desc, 10);
    }
    paramJceOutputStream.write(this.is_ding, 11);
    paramJceOutputStream.write(this.playNum, 12);
    if (this.video_url != null) {
      paramJceOutputStream.write(this.video_url, 13);
    }
    if (this.material_thumburl != null) {
      paramJceOutputStream.write(this.material_thumburl, 14);
    }
    if (this.share_info != null) {
      paramJceOutputStream.write(this.share_info, 15);
    }
    if (this.feed_desc != null) {
      paramJceOutputStream.write(this.feed_desc, 16);
    }
    paramJceOutputStream.write(this.music_begin_time, 17);
    paramJceOutputStream.write(this.music_end_time, 18);
    if (this.music_info != null) {
      paramJceOutputStream.write(this.music_info, 19);
    }
    if (this.music_id != null) {
      paramJceOutputStream.write(this.music_id, 20);
    }
    if (this.tags != null) {
      paramJceOutputStream.write(this.tags, 21);
    }
    if (this.map_pass_back != null) {
      paramJceOutputStream.write(this.map_pass_back, 22);
    }
    paramJceOutputStream.write(this.gdt_ad_type, 23);
    if (this.gdt_ad_info != null) {
      paramJceOutputStream.write(this.gdt_ad_info, 24);
    }
    if (this.bt_style != null) {
      paramJceOutputStream.write(this.bt_style, 25);
    }
    if (this.h5_op_info != null) {
      paramJceOutputStream.write(this.h5_op_info, 26);
    }
    paramJceOutputStream.write(this.video_type, 27);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 28);
    }
    if (this.weishi_jump_url != null) {
      paramJceOutputStream.write(this.weishi_jump_url, 29);
    }
    if (this.bottom_img_url != null) {
      paramJceOutputStream.write(this.bottom_img_url, 30);
    }
    if (this.new_icon != null) {
      paramJceOutputStream.write(this.new_icon, 31);
    }
    if (this.feed_material_jump_url != null) {
      paramJceOutputStream.write(this.feed_material_jump_url, 32);
    }
    if (this.waterFallItemStrategy != null) {
      paramJceOutputStream.write(this.waterFallItemStrategy, 33);
    }
    if (this.waterFallCardStyle != null) {
      paramJceOutputStream.write(this.waterFallCardStyle, 34);
    }
    paramJceOutputStream.write(this.videoPoolType, 35);
    if (this.imgReplacements != null) {
      paramJceOutputStream.write(this.imgReplacements, 36);
    }
    if (this.opVideo != null) {
      paramJceOutputStream.write(this.opVideo, 37);
    }
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 38);
    }
    if (this.geoInfo != null) {
      paramJceOutputStream.write(this.geoInfo, 39);
    }
    if (this.magicBrand != null) {
      paramJceOutputStream.write(this.magicBrand, 40);
    }
    if (this.simpleComments != null) {
      paramJceOutputStream.write(this.simpleComments, 41);
    }
    paramJceOutputStream.write(this.createTime, 42);
    if (this.videoTag != null) {
      paramJceOutputStream.write(this.videoTag, 43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleMetaFeed
 * JD-Core Version:    0.7.0.1
 */