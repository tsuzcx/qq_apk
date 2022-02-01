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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleMetaFeed
  extends JceStruct
{
  static stVideoTag cache_bottomTag;
  static ArrayList<stMagicBrand> cache_brands;
  static stMetaTag cache_bt_style;
  static stCardInfo cache_cardInfo;
  static stCollection cache_collection;
  static ArrayList<stMetaComment> cache_comments;
  static stDramaFall cache_dramaInfo;
  static stFeedBarInfo cache_feedBarInfo = new stFeedBarInfo();
  static stFloatingLayerCardStyle cache_floatingLayerCardStyle;
  static stFriendLikes cache_friendLikes;
  static stMetaGeoInfo cache_geoInfo;
  static stH5OpInfo cache_h5_op_info;
  static ArrayList<stMetaUgcImage> cache_images;
  static ArrayList<stImgReplacement> cache_imgReplacements;
  static stLive cache_live;
  static stMagicBrand cache_magicBrand;
  static Map<String, String> cache_map_ext;
  static Map<Integer, byte[]> cache_map_pass_back;
  static stMusicFullInfo cache_music_info;
  static stNewIconStyle cache_new_icon;
  static stFeedOpInfo cache_opInfo;
  static stOpVideo cache_opVideo;
  static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
  static ArrayList<stQQGroupInfo> cache_qqGroups;
  static stShareInfo cache_share_info;
  static ArrayList<stSimpleComment> cache_simpleComments;
  static ArrayList<stMetaTag> cache_tags;
  static stMetaUgcVideoSeg cache_video = new stMetaUgcVideoSeg();
  static stVideoTag cache_videoTag;
  static stWaterFallCardStyle cache_waterFallCardStyle;
  static stWaterFallItemStrategy cache_waterFallItemStrategy;
  static stCallWeishiButton cache_weishiButton;
  public stVideoTag bottomTag = null;
  public String bottom_img_url = "";
  public ArrayList<stMagicBrand> brands = null;
  public stMetaTag bt_style = null;
  public stCardInfo cardInfo = null;
  public stCollection collection = null;
  public ArrayList<stMetaComment> comments = null;
  public int createTime = 0;
  public int ding_count = 0;
  public stDramaFall dramaInfo = null;
  public stFeedBarInfo feedBarInfo = null;
  public String feed_desc = "";
  public String feed_material_jump_url = "";
  public stFloatingLayerCardStyle floatingLayerCardStyle = null;
  public stFriendLikes friendLikes = null;
  public String gdt_ad_info = "";
  public int gdt_ad_type = 0;
  public stMetaGeoInfo geoInfo = null;
  public stH5OpInfo h5_op_info = null;
  public String id = "";
  public ArrayList<stMetaUgcImage> images = null;
  public ArrayList<stImgReplacement> imgReplacements = null;
  public boolean isLoop = false;
  public int is_ding = 0;
  public stLive live = null;
  public stMagicBrand magicBrand = null;
  public Map<String, String> map_ext = null;
  public Map<Integer, byte[]> map_pass_back = null;
  public String material_desc = "";
  public String material_id = "";
  public String material_thumburl = "";
  public long music_begin_time = 0L;
  public long music_end_time = 0L;
  public String music_id = "";
  public stMusicFullInfo music_info = null;
  public stNewIconStyle new_icon = null;
  public stFeedOpInfo opInfo = null;
  public stOpVideo opVideo = null;
  public int playNum = 0;
  public stSimpleMetaPerson poster = null;
  public String poster_id = "";
  public ArrayList<stQQGroupInfo> qqGroups = null;
  public int scaleType = 0;
  public stShareInfo share_info = null;
  public ArrayList<stSimpleComment> simpleComments = null;
  public ArrayList<stMetaTag> tags = null;
  public int total_comment_num = 0;
  public String traceId = "";
  public stMetaUgcVideoSeg video = null;
  public int videoPoolType = 0;
  public stVideoTag videoTag = null;
  public int video_type = 0;
  public String video_url = "";
  public stWaterFallCardStyle waterFallCardStyle = null;
  public stWaterFallItemStrategy waterFallItemStrategy = null;
  public stCallWeishiButton weishiButton = null;
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
    cache_videoTag = new stVideoTag();
    cache_floatingLayerCardStyle = new stFloatingLayerCardStyle();
    cache_collection = new stCollection();
    cache_friendLikes = new stFriendLikes();
    cache_brands = new ArrayList();
    localObject = new stMagicBrand();
    cache_brands.add(localObject);
    cache_qqGroups = new ArrayList();
    localObject = new stQQGroupInfo();
    cache_qqGroups.add(localObject);
    cache_live = new stLive();
    cache_opInfo = new stFeedOpInfo();
    cache_cardInfo = new stCardInfo();
    cache_dramaInfo = new stDramaFall();
    cache_bottomTag = new stVideoTag();
    cache_weishiButton = new stCallWeishiButton();
  }
  
  public stSimpleMetaFeed() {}
  
  public stSimpleMetaFeed(String paramString1, String paramString2, String paramString3, stSimpleMetaPerson paramstSimpleMetaPerson, stMetaUgcVideoSeg paramstMetaUgcVideoSeg, ArrayList<stMetaUgcImage> paramArrayList, int paramInt1, int paramInt2, ArrayList<stMetaComment> paramArrayList1, String paramString4, String paramString5, int paramInt3, int paramInt4, String paramString6, String paramString7, stShareInfo paramstShareInfo, String paramString8, long paramLong1, long paramLong2, stMusicFullInfo paramstMusicFullInfo, String paramString9, ArrayList<stMetaTag> paramArrayList2, Map<Integer, byte[]> paramMap, int paramInt5, String paramString10, stMetaTag paramstMetaTag, stH5OpInfo paramstH5OpInfo, int paramInt6, Map<String, String> paramMap1, String paramString11, String paramString12, stNewIconStyle paramstNewIconStyle, String paramString13, stWaterFallItemStrategy paramstWaterFallItemStrategy, stWaterFallCardStyle paramstWaterFallCardStyle, int paramInt7, ArrayList<stImgReplacement> paramArrayList3, stOpVideo paramstOpVideo, String paramString14, stMetaGeoInfo paramstMetaGeoInfo, stMagicBrand paramstMagicBrand, ArrayList<stSimpleComment> paramArrayList4, int paramInt8, stVideoTag paramstVideoTag1, stFloatingLayerCardStyle paramstFloatingLayerCardStyle, stCollection paramstCollection, stFriendLikes paramstFriendLikes, ArrayList<stMagicBrand> paramArrayList5, ArrayList<stQQGroupInfo> paramArrayList6, boolean paramBoolean, stLive paramstLive, int paramInt9, stFeedOpInfo paramstFeedOpInfo, stCardInfo paramstCardInfo, stDramaFall paramstDramaFall, stVideoTag paramstVideoTag2, stCallWeishiButton paramstCallWeishiButton, stFeedBarInfo paramstFeedBarInfo)
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
    this.videoTag = paramstVideoTag1;
    this.floatingLayerCardStyle = paramstFloatingLayerCardStyle;
    this.collection = paramstCollection;
    this.friendLikes = paramstFriendLikes;
    this.brands = paramArrayList5;
    this.qqGroups = paramArrayList6;
    this.isLoop = paramBoolean;
    this.live = paramstLive;
    this.scaleType = paramInt9;
    this.opInfo = paramstFeedOpInfo;
    this.cardInfo = paramstCardInfo;
    this.dramaInfo = paramstDramaFall;
    this.bottomTag = paramstVideoTag2;
    this.weishiButton = paramstCallWeishiButton;
    this.feedBarInfo = paramstFeedBarInfo;
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
    this.floatingLayerCardStyle = ((stFloatingLayerCardStyle)paramJceInputStream.read(cache_floatingLayerCardStyle, 44, false));
    this.collection = ((stCollection)paramJceInputStream.read(cache_collection, 45, false));
    this.friendLikes = ((stFriendLikes)paramJceInputStream.read(cache_friendLikes, 46, false));
    this.brands = ((ArrayList)paramJceInputStream.read(cache_brands, 47, false));
    this.qqGroups = ((ArrayList)paramJceInputStream.read(cache_qqGroups, 48, false));
    this.isLoop = paramJceInputStream.read(this.isLoop, 49, false);
    this.live = ((stLive)paramJceInputStream.read(cache_live, 50, false));
    this.scaleType = paramJceInputStream.read(this.scaleType, 51, false);
    this.opInfo = ((stFeedOpInfo)paramJceInputStream.read(cache_opInfo, 52, false));
    this.cardInfo = ((stCardInfo)paramJceInputStream.read(cache_cardInfo, 53, false));
    this.dramaInfo = ((stDramaFall)paramJceInputStream.read(cache_dramaInfo, 54, false));
    this.bottomTag = ((stVideoTag)paramJceInputStream.read(cache_bottomTag, 55, false));
    this.weishiButton = ((stCallWeishiButton)paramJceInputStream.read(cache_weishiButton, 56, false));
    this.feedBarInfo = ((stFeedBarInfo)paramJceInputStream.read(cache_feedBarInfo, 57, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.wording;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.poster_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.poster;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.video;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.images;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    paramJceOutputStream.write(this.ding_count, 6);
    paramJceOutputStream.write(this.total_comment_num, 7);
    localObject = this.comments;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.material_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.material_desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.is_ding, 11);
    paramJceOutputStream.write(this.playNum, 12);
    localObject = this.video_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.material_thumburl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.share_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
    localObject = this.feed_desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    paramJceOutputStream.write(this.music_begin_time, 17);
    paramJceOutputStream.write(this.music_end_time, 18);
    localObject = this.music_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 19);
    }
    localObject = this.music_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.tags;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 21);
    }
    localObject = this.map_pass_back;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 22);
    }
    paramJceOutputStream.write(this.gdt_ad_type, 23);
    localObject = this.gdt_ad_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 24);
    }
    localObject = this.bt_style;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 25);
    }
    localObject = this.h5_op_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 26);
    }
    paramJceOutputStream.write(this.video_type, 27);
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 28);
    }
    localObject = this.weishi_jump_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 29);
    }
    localObject = this.bottom_img_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 30);
    }
    localObject = this.new_icon;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 31);
    }
    localObject = this.feed_material_jump_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 32);
    }
    localObject = this.waterFallItemStrategy;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 33);
    }
    localObject = this.waterFallCardStyle;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 34);
    }
    paramJceOutputStream.write(this.videoPoolType, 35);
    localObject = this.imgReplacements;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 36);
    }
    localObject = this.opVideo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 37);
    }
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 38);
    }
    localObject = this.geoInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 39);
    }
    localObject = this.magicBrand;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 40);
    }
    localObject = this.simpleComments;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 41);
    }
    paramJceOutputStream.write(this.createTime, 42);
    localObject = this.videoTag;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 43);
    }
    localObject = this.floatingLayerCardStyle;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 44);
    }
    localObject = this.collection;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 45);
    }
    localObject = this.friendLikes;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 46);
    }
    localObject = this.brands;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 47);
    }
    localObject = this.qqGroups;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 48);
    }
    paramJceOutputStream.write(this.isLoop, 49);
    localObject = this.live;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 50);
    }
    paramJceOutputStream.write(this.scaleType, 51);
    localObject = this.opInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 52);
    }
    localObject = this.cardInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 53);
    }
    localObject = this.dramaInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 54);
    }
    localObject = this.bottomTag;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 55);
    }
    localObject = this.weishiButton;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 56);
    }
    localObject = this.feedBarInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 57);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleMetaFeed
 * JD-Core Version:    0.7.0.1
 */