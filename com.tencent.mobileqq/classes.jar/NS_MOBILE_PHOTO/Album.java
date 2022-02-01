package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_MATERIAL.MaterialItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.client_attr;

public final class Album
  extends JceStruct
{
  static ArrayList<Long> cache_album_white_list = new ArrayList();
  static s_arkshare cache_ark_sharedata;
  static Map<Integer, String> cache_busi_param;
  static ArrayList<TimeEventOp> cache_lover_events;
  static MaterialItem cache_material;
  static int cache_recommend_album_type;
  static s_arkshare cache_share_album_invate_ark = new s_arkshare();
  static ArrayList<client_attr> cache_shareattrs;
  static int cache_sort_type;
  public ArrayList<Long> album_white_list = null;
  public String albumid = "";
  public String albumowner = "";
  public int allow_share = 0;
  public String answer = "";
  public s_arkshare ark_sharedata = null;
  public long birth_day = 0L;
  public long birth_month = 0L;
  public String birth_nickname = "";
  public int birth_sexual = 0;
  public long birth_time = 0L;
  public long birth_type = 0L;
  public long birth_year = 0L;
  public String bitmap = "";
  public Map<Integer, String> busi_param = null;
  public String coverurl = "";
  public int createtime = 0;
  public String desc = "";
  public int game_album_flag = 0;
  public long individual = 0L;
  public boolean isSubscribe = true;
  public int is_allow_share = 0;
  public int is_allow_sharer_upload = 0;
  public int is_share = 0;
  public int lastuploadtime = 0;
  public long love_time = 0L;
  public long love_value = 0L;
  public ArrayList<TimeEventOp> lover_events = null;
  public MaterialItem material = null;
  public int moditytime = 0;
  public String name = "";
  public int opmask = 0;
  public long owner = 0L;
  public int photo_num = 0;
  public int priv = 0;
  public String question = "";
  public long recoded_days = 0L;
  public int recommend_album_type = 0;
  public s_arkshare share_album_invate_ark = null;
  public ArrayList<client_attr> shareattrs = null;
  public int sort_type = 3;
  public long svrtime = 0L;
  public int top_flag = 0;
  public int total = 0;
  public int type = 0;
  public long uin = 0L;
  public int video_num = 0;
  
  static
  {
    cache_album_white_list.add(Long.valueOf(0L));
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_material = new MaterialItem();
    cache_shareattrs = new ArrayList();
    Object localObject = new client_attr();
    cache_shareattrs.add(localObject);
    cache_lover_events = new ArrayList();
    localObject = new TimeEventOp();
    cache_lover_events.add(localObject);
    cache_recommend_album_type = 0;
    cache_ark_sharedata = new s_arkshare();
    cache_sort_type = 0;
  }
  
  public Album() {}
  
  public Album(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, int paramInt6, ArrayList<Long> paramArrayList, long paramLong2, Map<Integer, String> paramMap, long paramLong3, int paramInt7, boolean paramBoolean, int paramInt8, String paramString6, String paramString7, int paramInt9, String paramString8, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, MaterialItem paramMaterialItem, String paramString9, ArrayList<client_attr> paramArrayList1, int paramInt10, long paramLong9, long paramLong10, ArrayList<TimeEventOp> paramArrayList2, long paramLong11, long paramLong12, int paramInt11, int paramInt12, int paramInt13, s_arkshare params_arkshare1, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, s_arkshare params_arkshare2)
  {
    this.uin = paramLong1;
    this.albumid = paramString1;
    this.name = paramString2;
    this.desc = paramString3;
    this.createtime = paramInt1;
    this.moditytime = paramInt2;
    this.lastuploadtime = paramInt3;
    this.priv = paramInt4;
    this.total = paramInt5;
    this.question = paramString4;
    this.answer = paramString5;
    this.allow_share = paramInt6;
    this.album_white_list = paramArrayList;
    this.svrtime = paramLong2;
    this.busi_param = paramMap;
    this.birth_time = paramLong3;
    this.type = paramInt7;
    this.isSubscribe = paramBoolean;
    this.opmask = paramInt8;
    this.coverurl = paramString6;
    this.bitmap = paramString7;
    this.birth_sexual = paramInt9;
    this.birth_nickname = paramString8;
    this.birth_year = paramLong4;
    this.birth_month = paramLong5;
    this.birth_day = paramLong6;
    this.birth_type = paramLong7;
    this.individual = paramLong8;
    this.material = paramMaterialItem;
    this.albumowner = paramString9;
    this.shareattrs = paramArrayList1;
    this.is_share = paramInt10;
    this.owner = paramLong9;
    this.love_time = paramLong10;
    this.lover_events = paramArrayList2;
    this.love_value = paramLong11;
    this.recoded_days = paramLong12;
    this.video_num = paramInt11;
    this.photo_num = paramInt12;
    this.recommend_album_type = paramInt13;
    this.ark_sharedata = params_arkshare1;
    this.sort_type = paramInt14;
    this.top_flag = paramInt15;
    this.game_album_flag = paramInt16;
    this.is_allow_sharer_upload = paramInt17;
    this.is_allow_share = paramInt18;
    this.share_album_invate_ark = params_arkshare2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.desc = paramJceInputStream.readString(3, true);
    this.createtime = paramJceInputStream.read(this.createtime, 4, true);
    this.moditytime = paramJceInputStream.read(this.moditytime, 5, true);
    this.lastuploadtime = paramJceInputStream.read(this.lastuploadtime, 6, true);
    this.priv = paramJceInputStream.read(this.priv, 7, true);
    this.total = paramJceInputStream.read(this.total, 8, true);
    this.question = paramJceInputStream.readString(9, false);
    this.answer = paramJceInputStream.readString(10, false);
    this.allow_share = paramJceInputStream.read(this.allow_share, 11, false);
    this.album_white_list = ((ArrayList)paramJceInputStream.read(cache_album_white_list, 12, false));
    this.svrtime = paramJceInputStream.read(this.svrtime, 13, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 14, false));
    this.birth_time = paramJceInputStream.read(this.birth_time, 15, false);
    this.type = paramJceInputStream.read(this.type, 16, false);
    this.isSubscribe = paramJceInputStream.read(this.isSubscribe, 17, false);
    this.opmask = paramJceInputStream.read(this.opmask, 18, false);
    this.coverurl = paramJceInputStream.readString(19, false);
    this.bitmap = paramJceInputStream.readString(20, false);
    this.birth_sexual = paramJceInputStream.read(this.birth_sexual, 21, false);
    this.birth_nickname = paramJceInputStream.readString(22, false);
    this.birth_year = paramJceInputStream.read(this.birth_year, 23, false);
    this.birth_month = paramJceInputStream.read(this.birth_month, 24, false);
    this.birth_day = paramJceInputStream.read(this.birth_day, 25, false);
    this.birth_type = paramJceInputStream.read(this.birth_type, 26, false);
    this.individual = paramJceInputStream.read(this.individual, 27, false);
    this.material = ((MaterialItem)paramJceInputStream.read(cache_material, 28, false));
    this.albumowner = paramJceInputStream.readString(29, false);
    this.shareattrs = ((ArrayList)paramJceInputStream.read(cache_shareattrs, 30, false));
    this.is_share = paramJceInputStream.read(this.is_share, 31, false);
    this.owner = paramJceInputStream.read(this.owner, 32, false);
    this.love_time = paramJceInputStream.read(this.love_time, 33, false);
    this.lover_events = ((ArrayList)paramJceInputStream.read(cache_lover_events, 34, false));
    this.love_value = paramJceInputStream.read(this.love_value, 35, false);
    this.recoded_days = paramJceInputStream.read(this.recoded_days, 36, false);
    this.video_num = paramJceInputStream.read(this.video_num, 37, false);
    this.photo_num = paramJceInputStream.read(this.photo_num, 38, false);
    this.recommend_album_type = paramJceInputStream.read(this.recommend_album_type, 39, false);
    this.ark_sharedata = ((s_arkshare)paramJceInputStream.read(cache_ark_sharedata, 40, false));
    this.sort_type = paramJceInputStream.read(this.sort_type, 41, false);
    this.top_flag = paramJceInputStream.read(this.top_flag, 42, false);
    this.game_album_flag = paramJceInputStream.read(this.game_album_flag, 43, false);
    this.is_allow_sharer_upload = paramJceInputStream.read(this.is_allow_sharer_upload, 44, false);
    this.is_allow_share = paramJceInputStream.read(this.is_allow_share, 45, false);
    this.share_album_invate_ark = ((s_arkshare)paramJceInputStream.read(cache_share_album_invate_ark, 46, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.desc, 3);
    paramJceOutputStream.write(this.createtime, 4);
    paramJceOutputStream.write(this.moditytime, 5);
    paramJceOutputStream.write(this.lastuploadtime, 6);
    paramJceOutputStream.write(this.priv, 7);
    paramJceOutputStream.write(this.total, 8);
    Object localObject = this.question;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.answer;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.allow_share, 11);
    localObject = this.album_white_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    paramJceOutputStream.write(this.svrtime, 13);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
    paramJceOutputStream.write(this.birth_time, 15);
    paramJceOutputStream.write(this.type, 16);
    paramJceOutputStream.write(this.isSubscribe, 17);
    paramJceOutputStream.write(this.opmask, 18);
    localObject = this.coverurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    localObject = this.bitmap;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    paramJceOutputStream.write(this.birth_sexual, 21);
    localObject = this.birth_nickname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 22);
    }
    paramJceOutputStream.write(this.birth_year, 23);
    paramJceOutputStream.write(this.birth_month, 24);
    paramJceOutputStream.write(this.birth_day, 25);
    paramJceOutputStream.write(this.birth_type, 26);
    paramJceOutputStream.write(this.individual, 27);
    localObject = this.material;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 28);
    }
    localObject = this.albumowner;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 29);
    }
    localObject = this.shareattrs;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 30);
    }
    paramJceOutputStream.write(this.is_share, 31);
    paramJceOutputStream.write(this.owner, 32);
    paramJceOutputStream.write(this.love_time, 33);
    localObject = this.lover_events;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 34);
    }
    paramJceOutputStream.write(this.love_value, 35);
    paramJceOutputStream.write(this.recoded_days, 36);
    paramJceOutputStream.write(this.video_num, 37);
    paramJceOutputStream.write(this.photo_num, 38);
    paramJceOutputStream.write(this.recommend_album_type, 39);
    localObject = this.ark_sharedata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 40);
    }
    paramJceOutputStream.write(this.sort_type, 41);
    paramJceOutputStream.write(this.top_flag, 42);
    paramJceOutputStream.write(this.game_album_flag, 43);
    paramJceOutputStream.write(this.is_allow_sharer_upload, 44);
    paramJceOutputStream.write(this.is_allow_share, 45);
    localObject = this.share_album_invate_ark;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 46);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.Album
 * JD-Core Version:    0.7.0.1
 */