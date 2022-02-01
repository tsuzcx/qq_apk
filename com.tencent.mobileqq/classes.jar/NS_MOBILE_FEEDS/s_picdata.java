package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class s_picdata
  extends JceStruct
{
  static Map<String, byte[]> cache_binaryExtInfo;
  static Map<Integer, String> cache_busi_param;
  static s_imgcrop cache_cropinfo;
  static ArrayList<stFaceItem> cache_facelist;
  static ArrayList<stFaceItem> cache_facelist_info;
  static stPoi cache_geo;
  static s_LabelInfo cache_label_info;
  static Map<Integer, String> cache_mapExifInfo;
  static Map<String, String> cache_mapExtern;
  static Map<Integer, String> cache_mapOcrInfo;
  static cell_music cache_musicdata;
  static cell_operation cache_operation;
  static ArrayList<stPhotoTag> cache_photoTag;
  static Map<Integer, s_picurl> cache_photourl = new HashMap();
  static s_pic_host cache_pic_host_nick;
  static stPoi cache_poi;
  static Map<Integer, String> cache_shouzhang_extend_map;
  static ArrayList<showdrying_taginfo> cache_vecShowDryingTagInfo;
  static cell_video cache_videodata;
  public String albumid = "";
  public String audio_summary = "";
  public long batchid = 0L;
  public Map<String, byte[]> binaryExtInfo = null;
  public Map<Integer, String> busi_param = null;
  public String clientkey = "";
  public int commentcount = 0;
  public s_imgcrop cropinfo = null;
  public String curlikekey = "";
  public String desc = "";
  public ArrayList<stFaceItem> facelist = null;
  public ArrayList<stFaceItem> facelist_info = null;
  public String fashion_tag_key = "";
  public int flag = 0;
  public stPoi geo = null;
  public boolean isAutoPlayGif = false;
  public boolean isCoverPic = false;
  public int isIndependentUgc = 0;
  public boolean ismylike = false;
  public s_LabelInfo label_info = null;
  public int likecount = 0;
  public String lloc = "";
  public String luckyMoneyDesc = "";
  public Map<Integer, String> mapExifInfo = null;
  public Map<String, String> mapExtern = null;
  public Map<Integer, String> mapOcrInfo = null;
  public long modifytime = 0L;
  public cell_music musicdata = null;
  public cell_operation operation = null;
  public byte opmask = 7;
  public int opsynflag = 0;
  public String orglikekey = "";
  public long origin_height = 0L;
  public long origin_phototype = 0L;
  public long origin_size = 0L;
  public long origin_width = 0L;
  public ArrayList<stPhotoTag> photoTag = null;
  public Map<Integer, s_picurl> photourl = null;
  public s_pic_host pic_host_nick = null;
  public int piccategory = 0;
  public String picname = "";
  public stPoi poi = null;
  public String quankey = "";
  public int raw = 0;
  public int shoottime = 0;
  public Map<Integer, String> shouzhang_extend_map = null;
  public String sloc = "";
  public int type = 0;
  public long uUploadTime = 0L;
  public long uploadUin = 0L;
  public ArrayList<showdrying_taginfo> vecShowDryingTagInfo = null;
  public cell_video videodata = null;
  public int videoflag = 0;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = new s_picurl();
    cache_photourl.put(localInteger, localObject);
    cache_busi_param = new HashMap();
    cache_busi_param.put(localInteger, "");
    cache_cropinfo = new s_imgcrop();
    cache_poi = new stPoi();
    cache_facelist = new ArrayList();
    localObject = new stFaceItem();
    cache_facelist.add(localObject);
    cache_photoTag = new ArrayList();
    localObject = new stPhotoTag();
    cache_photoTag.add(localObject);
    cache_videodata = new cell_video();
    cache_pic_host_nick = new s_pic_host();
    cache_geo = new stPoi();
    cache_operation = new cell_operation();
    cache_musicdata = new cell_music();
    cache_binaryExtInfo = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_binaryExtInfo.put("", localObject);
    cache_vecShowDryingTagInfo = new ArrayList();
    localObject = new showdrying_taginfo();
    cache_vecShowDryingTagInfo.add(localObject);
    cache_shouzhang_extend_map = new HashMap();
    cache_shouzhang_extend_map.put(localInteger, "");
    cache_label_info = new s_LabelInfo();
    cache_facelist_info = new ArrayList();
    localObject = new stFaceItem();
    cache_facelist_info.add(localObject);
    cache_mapOcrInfo = new HashMap();
    cache_mapOcrInfo.put(localInteger, "");
    cache_mapExifInfo = new HashMap();
    cache_mapExifInfo.put(localInteger, "");
    cache_mapExtern = new HashMap();
    cache_mapExtern.put("", "");
  }
  
  public s_picdata() {}
  
  public s_picdata(String paramString1, String paramString2, String paramString3, Map<Integer, s_picurl> paramMap, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, Map<Integer, String> paramMap1, String paramString4, int paramInt4, int paramInt5, long paramLong1, long paramLong2, String paramString5, String paramString6, String paramString7, s_imgcrop params_imgcrop, long paramLong3, int paramInt6, int paramInt7, stPoi paramstPoi1, ArrayList<stFaceItem> paramArrayList1, int paramInt8, boolean paramBoolean2, ArrayList<stPhotoTag> paramArrayList, byte paramByte, String paramString8, int paramInt9, int paramInt10, cell_video paramcell_video, boolean paramBoolean3, s_pic_host params_pic_host, String paramString9, stPoi paramstPoi2, cell_operation paramcell_operation, cell_music paramcell_music, String paramString10, long paramLong4, String paramString11, long paramLong5, long paramLong6, long paramLong7, long paramLong8, Map<String, byte[]> paramMap2, ArrayList<showdrying_taginfo> paramArrayList2, String paramString12, Map<Integer, String> paramMap3, s_LabelInfo params_LabelInfo, ArrayList<stFaceItem> paramArrayList3, Map<Integer, String> paramMap4, Map<Integer, String> paramMap5, Map<String, String> paramMap6)
  {
    this.picname = paramString1;
    this.sloc = paramString2;
    this.lloc = paramString3;
    this.photourl = paramMap;
    this.type = paramInt1;
    this.ismylike = paramBoolean1;
    this.likecount = paramInt2;
    this.commentcount = paramInt3;
    this.busi_param = paramMap1;
    this.clientkey = paramString4;
    this.isIndependentUgc = paramInt4;
    this.opsynflag = paramInt5;
    this.uUploadTime = paramLong1;
    this.modifytime = paramLong2;
    this.desc = paramString5;
    this.orglikekey = paramString6;
    this.curlikekey = paramString7;
    this.cropinfo = params_imgcrop;
    this.uploadUin = paramLong3;
    this.shoottime = paramInt6;
    this.flag = paramInt7;
    this.poi = paramstPoi1;
    this.facelist = paramArrayList1;
    this.raw = paramInt8;
    this.isAutoPlayGif = paramBoolean2;
    this.photoTag = paramArrayList;
    this.opmask = paramByte;
    this.albumid = paramString8;
    this.piccategory = paramInt9;
    this.videoflag = paramInt10;
    this.videodata = paramcell_video;
    this.isCoverPic = paramBoolean3;
    this.pic_host_nick = params_pic_host;
    this.luckyMoneyDesc = paramString9;
    this.geo = paramstPoi2;
    this.operation = paramcell_operation;
    this.musicdata = paramcell_music;
    this.audio_summary = paramString10;
    this.batchid = paramLong4;
    this.quankey = paramString11;
    this.origin_size = paramLong5;
    this.origin_width = paramLong6;
    this.origin_height = paramLong7;
    this.origin_phototype = paramLong8;
    this.binaryExtInfo = paramMap2;
    this.vecShowDryingTagInfo = paramArrayList2;
    this.fashion_tag_key = paramString12;
    this.shouzhang_extend_map = paramMap3;
    this.label_info = params_LabelInfo;
    this.facelist_info = paramArrayList3;
    this.mapOcrInfo = paramMap4;
    this.mapExifInfo = paramMap5;
    this.mapExtern = paramMap6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picname = paramJceInputStream.readString(0, false);
    this.sloc = paramJceInputStream.readString(1, false);
    this.lloc = paramJceInputStream.readString(2, false);
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 3, false));
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.ismylike = paramJceInputStream.read(this.ismylike, 5, false);
    this.likecount = paramJceInputStream.read(this.likecount, 6, false);
    this.commentcount = paramJceInputStream.read(this.commentcount, 7, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 8, false));
    this.clientkey = paramJceInputStream.readString(9, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 10, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 11, false);
    this.uUploadTime = paramJceInputStream.read(this.uUploadTime, 12, false);
    this.modifytime = paramJceInputStream.read(this.modifytime, 13, false);
    this.desc = paramJceInputStream.readString(14, false);
    this.orglikekey = paramJceInputStream.readString(15, false);
    this.curlikekey = paramJceInputStream.readString(16, false);
    this.cropinfo = ((s_imgcrop)paramJceInputStream.read(cache_cropinfo, 17, false));
    this.uploadUin = paramJceInputStream.read(this.uploadUin, 18, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 19, false);
    this.flag = paramJceInputStream.read(this.flag, 20, false);
    this.poi = ((stPoi)paramJceInputStream.read(cache_poi, 21, false));
    this.facelist = ((ArrayList)paramJceInputStream.read(cache_facelist, 22, false));
    this.raw = paramJceInputStream.read(this.raw, 23, false);
    this.isAutoPlayGif = paramJceInputStream.read(this.isAutoPlayGif, 24, false);
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 25, false));
    this.opmask = paramJceInputStream.read(this.opmask, 26, false);
    this.albumid = paramJceInputStream.readString(27, false);
    this.piccategory = paramJceInputStream.read(this.piccategory, 28, false);
    this.videoflag = paramJceInputStream.read(this.videoflag, 29, false);
    this.videodata = ((cell_video)paramJceInputStream.read(cache_videodata, 30, false));
    this.isCoverPic = paramJceInputStream.read(this.isCoverPic, 31, false);
    this.pic_host_nick = ((s_pic_host)paramJceInputStream.read(cache_pic_host_nick, 32, false));
    this.luckyMoneyDesc = paramJceInputStream.readString(33, false);
    this.geo = ((stPoi)paramJceInputStream.read(cache_geo, 34, false));
    this.operation = ((cell_operation)paramJceInputStream.read(cache_operation, 35, false));
    this.musicdata = ((cell_music)paramJceInputStream.read(cache_musicdata, 36, false));
    this.audio_summary = paramJceInputStream.readString(37, false);
    this.batchid = paramJceInputStream.read(this.batchid, 38, false);
    this.quankey = paramJceInputStream.readString(39, false);
    this.origin_size = paramJceInputStream.read(this.origin_size, 40, false);
    this.origin_width = paramJceInputStream.read(this.origin_width, 41, false);
    this.origin_height = paramJceInputStream.read(this.origin_height, 42, false);
    this.origin_phototype = paramJceInputStream.read(this.origin_phototype, 43, false);
    this.binaryExtInfo = ((Map)paramJceInputStream.read(cache_binaryExtInfo, 44, false));
    this.vecShowDryingTagInfo = ((ArrayList)paramJceInputStream.read(cache_vecShowDryingTagInfo, 45, false));
    this.fashion_tag_key = paramJceInputStream.readString(46, false);
    this.shouzhang_extend_map = ((Map)paramJceInputStream.read(cache_shouzhang_extend_map, 47, false));
    this.label_info = ((s_LabelInfo)paramJceInputStream.read(cache_label_info, 48, false));
    this.facelist_info = ((ArrayList)paramJceInputStream.read(cache_facelist_info, 49, false));
    this.mapOcrInfo = ((Map)paramJceInputStream.read(cache_mapOcrInfo, 50, false));
    this.mapExifInfo = ((Map)paramJceInputStream.read(cache_mapExifInfo, 51, false));
    this.mapExtern = ((Map)paramJceInputStream.read(cache_mapExtern, 52, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.picname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.lloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.photourl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.type, 4);
    paramJceOutputStream.write(this.ismylike, 5);
    paramJceOutputStream.write(this.likecount, 6);
    paramJceOutputStream.write(this.commentcount, 7);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.isIndependentUgc, 10);
    paramJceOutputStream.write(this.opsynflag, 11);
    paramJceOutputStream.write(this.uUploadTime, 12);
    paramJceOutputStream.write(this.modifytime, 13);
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.orglikekey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.curlikekey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.cropinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
    paramJceOutputStream.write(this.uploadUin, 18);
    paramJceOutputStream.write(this.shoottime, 19);
    paramJceOutputStream.write(this.flag, 20);
    localObject = this.poi;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 21);
    }
    localObject = this.facelist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 22);
    }
    paramJceOutputStream.write(this.raw, 23);
    paramJceOutputStream.write(this.isAutoPlayGif, 24);
    localObject = this.photoTag;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 25);
    }
    paramJceOutputStream.write(this.opmask, 26);
    localObject = this.albumid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 27);
    }
    paramJceOutputStream.write(this.piccategory, 28);
    paramJceOutputStream.write(this.videoflag, 29);
    localObject = this.videodata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 30);
    }
    paramJceOutputStream.write(this.isCoverPic, 31);
    localObject = this.pic_host_nick;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 32);
    }
    localObject = this.luckyMoneyDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 33);
    }
    localObject = this.geo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 34);
    }
    localObject = this.operation;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 35);
    }
    localObject = this.musicdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 36);
    }
    localObject = this.audio_summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 37);
    }
    paramJceOutputStream.write(this.batchid, 38);
    localObject = this.quankey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 39);
    }
    paramJceOutputStream.write(this.origin_size, 40);
    paramJceOutputStream.write(this.origin_width, 41);
    paramJceOutputStream.write(this.origin_height, 42);
    paramJceOutputStream.write(this.origin_phototype, 43);
    localObject = this.binaryExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 44);
    }
    localObject = this.vecShowDryingTagInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 45);
    }
    localObject = this.fashion_tag_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 46);
    }
    localObject = this.shouzhang_extend_map;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 47);
    }
    localObject = this.label_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 48);
    }
    localObject = this.facelist_info;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 49);
    }
    localObject = this.mapOcrInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 50);
    }
    localObject = this.mapExifInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 51);
    }
    localObject = this.mapExtern;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 52);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_picdata
 * JD-Core Version:    0.7.0.1
 */