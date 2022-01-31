package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.stFaceItem;
import NS_MOBILE_FEEDS.stPhotoTag;
import NS_MOBILE_FEEDS.stPoi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.pic_host;

public final class Photo
  extends JceStruct
{
  static Map<String, byte[]> cache_binaryExtInfo;
  static Map<Integer, String> cache_busi_param = new HashMap();
  static stFaceInfo cache_face_info;
  static ArrayList<stFaceItem> cache_facelist;
  static stLabelInfo cache_label_info;
  static Map<Integer, String> cache_mapExifInfo;
  static Map<String, String> cache_mapExtern;
  static Map<Integer, String> cache_mapOcrInfo;
  static ArrayList<stPhotoTag> cache_photoTag;
  static pic_host cache_pic_host_nick;
  static Map<Integer, Integer> cache_pics_enlargerate;
  static s_outshare cache_share_info;
  static stPoi cache_shoot_place_info;
  static Map<Integer, String> cache_shouzhang_extend_map;
  static cell_video cache_videodata;
  public String albumid = "";
  public String bigurl = "";
  public Map<String, byte[]> binaryExtInfo;
  public Map<Integer, String> busi_param;
  public String client_key = "";
  public int cmtnum;
  public String curkey = "";
  public String currenturl = "";
  public String desc = "";
  public stFaceInfo face_info;
  public ArrayList<stFaceItem> facelist;
  public int flag;
  public int height;
  public int isIndependentUgc;
  public stLabelInfo label_info;
  public int likenum;
  public String lloc = "";
  public Map<Integer, String> mapExifInfo;
  public Map<String, String> mapExtern;
  public Map<Integer, String> mapOcrInfo;
  public String midurl = "";
  public int modifytime;
  public byte mylike;
  public String name = "";
  public byte opmask = 7;
  public int opsynflag;
  public long origin_size;
  public ArrayList<stPhotoTag> photoTag;
  public String photo_visitor_ugc_key = "";
  public pic_host pic_host_nick;
  public Map<Integer, Integer> pics_enlargerate;
  public int quanflag;
  public long raw;
  public long raw_height;
  public long raw_width;
  public s_outshare share_info;
  public stPoi shoot_place_info;
  public int shoottime;
  public Map<Integer, String> shouzhang_extend_map;
  public String sloc = "";
  public String smallurl = "";
  public String thumburl = "";
  public int trannum;
  public int type;
  public long uin;
  public String unikey = "";
  public int uploadtime;
  public String url = "";
  public cell_video videodata;
  public int videoflag;
  public long view_count;
  public int width;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_pics_enlargerate = new HashMap();
    cache_pics_enlargerate.put(Integer.valueOf(0), Integer.valueOf(0));
    cache_photoTag = new ArrayList();
    Object localObject = new stPhotoTag();
    cache_photoTag.add(localObject);
    cache_videodata = new cell_video();
    cache_pic_host_nick = new pic_host();
    cache_share_info = new s_outshare();
    cache_shoot_place_info = new stPoi();
    cache_face_info = new stFaceInfo();
    cache_label_info = new stLabelInfo();
    cache_facelist = new ArrayList();
    localObject = new stFaceItem();
    cache_facelist.add(localObject);
    cache_mapExifInfo = new HashMap();
    cache_mapExifInfo.put(Integer.valueOf(0), "");
    cache_mapOcrInfo = new HashMap();
    cache_mapOcrInfo.put(Integer.valueOf(0), "");
    cache_mapExtern = new HashMap();
    cache_mapExtern.put("", "");
    cache_binaryExtInfo = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_binaryExtInfo.put("", localObject);
    cache_shouzhang_extend_map = new HashMap();
    cache_shouzhang_extend_map.put(Integer.valueOf(0), "");
  }
  
  public Photo() {}
  
  public Photo(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, int paramInt5, int paramInt6, byte paramByte1, int paramInt7, String paramString8, String paramString9, String paramString10, String paramString11, Map<Integer, String> paramMap1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, String paramString12, Map<Integer, Integer> paramMap, ArrayList<stPhotoTag> paramArrayList, byte paramByte2, int paramInt12, int paramInt13, String paramString13, int paramInt14, cell_video paramcell_video, pic_host parampic_host, s_outshare params_outshare, long paramLong3, String paramString14, String paramString15, stPoi paramstPoi, stFaceInfo paramstFaceInfo, stLabelInfo paramstLabelInfo, ArrayList<stFaceItem> paramArrayList1, long paramLong4, Map<Integer, String> paramMap2, Map<Integer, String> paramMap3, Map<String, String> paramMap4, long paramLong5, long paramLong6, Map<String, byte[]> paramMap5, Map<Integer, String> paramMap6)
  {
    this.uin = paramLong1;
    this.lloc = paramString1;
    this.sloc = paramString2;
    this.name = paramString3;
    this.desc = paramString4;
    this.uploadtime = paramInt1;
    this.modifytime = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.url = paramString5;
    this.bigurl = paramString6;
    this.smallurl = paramString7;
    this.cmtnum = paramInt5;
    this.likenum = paramInt6;
    this.mylike = paramByte1;
    this.trannum = paramInt7;
    this.unikey = paramString8;
    this.curkey = paramString9;
    this.midurl = paramString10;
    this.thumburl = paramString11;
    this.busi_param = paramMap1;
    this.type = paramInt8;
    this.isIndependentUgc = paramInt9;
    this.opsynflag = paramInt10;
    this.quanflag = paramInt11;
    this.raw = paramLong2;
    this.currenturl = paramString12;
    this.pics_enlargerate = paramMap;
    this.photoTag = paramArrayList;
    this.opmask = paramByte2;
    this.shoottime = paramInt12;
    this.flag = paramInt13;
    this.albumid = paramString13;
    this.videoflag = paramInt14;
    this.videodata = paramcell_video;
    this.pic_host_nick = parampic_host;
    this.share_info = params_outshare;
    this.view_count = paramLong3;
    this.photo_visitor_ugc_key = paramString14;
    this.client_key = paramString15;
    this.shoot_place_info = paramstPoi;
    this.face_info = paramstFaceInfo;
    this.label_info = paramstLabelInfo;
    this.facelist = paramArrayList1;
    this.origin_size = paramLong4;
    this.mapExifInfo = paramMap2;
    this.mapOcrInfo = paramMap3;
    this.mapExtern = paramMap4;
    this.raw_width = paramLong5;
    this.raw_height = paramLong6;
    this.binaryExtInfo = paramMap5;
    this.shouzhang_extend_map = paramMap6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.lloc = paramJceInputStream.readString(1, true);
    this.sloc = paramJceInputStream.readString(2, true);
    this.name = paramJceInputStream.readString(3, true);
    this.desc = paramJceInputStream.readString(4, true);
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 5, true);
    this.modifytime = paramJceInputStream.read(this.modifytime, 6, true);
    this.width = paramJceInputStream.read(this.width, 7, true);
    this.height = paramJceInputStream.read(this.height, 8, true);
    this.url = paramJceInputStream.readString(9, true);
    this.bigurl = paramJceInputStream.readString(10, true);
    this.smallurl = paramJceInputStream.readString(11, true);
    this.cmtnum = paramJceInputStream.read(this.cmtnum, 12, true);
    this.likenum = paramJceInputStream.read(this.likenum, 13, true);
    this.mylike = paramJceInputStream.read(this.mylike, 14, true);
    this.trannum = paramJceInputStream.read(this.trannum, 15, true);
    this.unikey = paramJceInputStream.readString(16, false);
    this.curkey = paramJceInputStream.readString(17, false);
    this.midurl = paramJceInputStream.readString(18, false);
    this.thumburl = paramJceInputStream.readString(19, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 20, false));
    this.type = paramJceInputStream.read(this.type, 21, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 22, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 23, false);
    this.quanflag = paramJceInputStream.read(this.quanflag, 24, false);
    this.raw = paramJceInputStream.read(this.raw, 25, false);
    this.currenturl = paramJceInputStream.readString(26, false);
    this.pics_enlargerate = ((Map)paramJceInputStream.read(cache_pics_enlargerate, 27, false));
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 28, false));
    this.opmask = paramJceInputStream.read(this.opmask, 29, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 30, false);
    this.flag = paramJceInputStream.read(this.flag, 31, false);
    this.albumid = paramJceInputStream.readString(32, false);
    this.videoflag = paramJceInputStream.read(this.videoflag, 33, false);
    this.videodata = ((cell_video)paramJceInputStream.read(cache_videodata, 34, false));
    this.pic_host_nick = ((pic_host)paramJceInputStream.read(cache_pic_host_nick, 35, false));
    this.share_info = ((s_outshare)paramJceInputStream.read(cache_share_info, 36, false));
    this.view_count = paramJceInputStream.read(this.view_count, 37, false);
    this.photo_visitor_ugc_key = paramJceInputStream.readString(38, false);
    this.client_key = paramJceInputStream.readString(39, false);
    this.shoot_place_info = ((stPoi)paramJceInputStream.read(cache_shoot_place_info, 40, false));
    this.face_info = ((stFaceInfo)paramJceInputStream.read(cache_face_info, 41, false));
    this.label_info = ((stLabelInfo)paramJceInputStream.read(cache_label_info, 42, false));
    this.facelist = ((ArrayList)paramJceInputStream.read(cache_facelist, 43, false));
    this.origin_size = paramJceInputStream.read(this.origin_size, 44, false);
    this.mapExifInfo = ((Map)paramJceInputStream.read(cache_mapExifInfo, 45, false));
    this.mapOcrInfo = ((Map)paramJceInputStream.read(cache_mapOcrInfo, 46, false));
    this.mapExtern = ((Map)paramJceInputStream.read(cache_mapExtern, 47, false));
    this.raw_width = paramJceInputStream.read(this.raw_width, 48, false);
    this.raw_height = paramJceInputStream.read(this.raw_height, 49, false);
    this.binaryExtInfo = ((Map)paramJceInputStream.read(cache_binaryExtInfo, 50, false));
    this.shouzhang_extend_map = ((Map)paramJceInputStream.read(cache_shouzhang_extend_map, 51, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.lloc, 1);
    paramJceOutputStream.write(this.sloc, 2);
    paramJceOutputStream.write(this.name, 3);
    paramJceOutputStream.write(this.desc, 4);
    paramJceOutputStream.write(this.uploadtime, 5);
    paramJceOutputStream.write(this.modifytime, 6);
    paramJceOutputStream.write(this.width, 7);
    paramJceOutputStream.write(this.height, 8);
    paramJceOutputStream.write(this.url, 9);
    paramJceOutputStream.write(this.bigurl, 10);
    paramJceOutputStream.write(this.smallurl, 11);
    paramJceOutputStream.write(this.cmtnum, 12);
    paramJceOutputStream.write(this.likenum, 13);
    paramJceOutputStream.write(this.mylike, 14);
    paramJceOutputStream.write(this.trannum, 15);
    if (this.unikey != null) {
      paramJceOutputStream.write(this.unikey, 16);
    }
    if (this.curkey != null) {
      paramJceOutputStream.write(this.curkey, 17);
    }
    if (this.midurl != null) {
      paramJceOutputStream.write(this.midurl, 18);
    }
    if (this.thumburl != null) {
      paramJceOutputStream.write(this.thumburl, 19);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 20);
    }
    paramJceOutputStream.write(this.type, 21);
    paramJceOutputStream.write(this.isIndependentUgc, 22);
    paramJceOutputStream.write(this.opsynflag, 23);
    paramJceOutputStream.write(this.quanflag, 24);
    paramJceOutputStream.write(this.raw, 25);
    if (this.currenturl != null) {
      paramJceOutputStream.write(this.currenturl, 26);
    }
    if (this.pics_enlargerate != null) {
      paramJceOutputStream.write(this.pics_enlargerate, 27);
    }
    if (this.photoTag != null) {
      paramJceOutputStream.write(this.photoTag, 28);
    }
    paramJceOutputStream.write(this.opmask, 29);
    paramJceOutputStream.write(this.shoottime, 30);
    paramJceOutputStream.write(this.flag, 31);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 32);
    }
    paramJceOutputStream.write(this.videoflag, 33);
    if (this.videodata != null) {
      paramJceOutputStream.write(this.videodata, 34);
    }
    if (this.pic_host_nick != null) {
      paramJceOutputStream.write(this.pic_host_nick, 35);
    }
    if (this.share_info != null) {
      paramJceOutputStream.write(this.share_info, 36);
    }
    paramJceOutputStream.write(this.view_count, 37);
    if (this.photo_visitor_ugc_key != null) {
      paramJceOutputStream.write(this.photo_visitor_ugc_key, 38);
    }
    if (this.client_key != null) {
      paramJceOutputStream.write(this.client_key, 39);
    }
    if (this.shoot_place_info != null) {
      paramJceOutputStream.write(this.shoot_place_info, 40);
    }
    if (this.face_info != null) {
      paramJceOutputStream.write(this.face_info, 41);
    }
    if (this.label_info != null) {
      paramJceOutputStream.write(this.label_info, 42);
    }
    if (this.facelist != null) {
      paramJceOutputStream.write(this.facelist, 43);
    }
    paramJceOutputStream.write(this.origin_size, 44);
    if (this.mapExifInfo != null) {
      paramJceOutputStream.write(this.mapExifInfo, 45);
    }
    if (this.mapOcrInfo != null) {
      paramJceOutputStream.write(this.mapOcrInfo, 46);
    }
    if (this.mapExtern != null) {
      paramJceOutputStream.write(this.mapExtern, 47);
    }
    paramJceOutputStream.write(this.raw_width, 48);
    paramJceOutputStream.write(this.raw_height, 49);
    if (this.binaryExtInfo != null) {
      paramJceOutputStream.write(this.binaryExtInfo, 50);
    }
    if (this.shouzhang_extend_map != null) {
      paramJceOutputStream.write(this.shouzhang_extend_map, 51);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.Photo
 * JD-Core Version:    0.7.0.1
 */