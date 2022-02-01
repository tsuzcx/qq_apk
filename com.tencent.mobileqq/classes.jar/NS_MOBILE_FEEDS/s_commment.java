package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class s_commment
  extends JceStruct
{
  static s_audio cache_audio;
  static Map<String, byte[]> cache_binaryExtInfo;
  static ArrayList<s_picdata> cache_commentpic;
  static Map<String, String> cache_extendInfo;
  static ArrayList<s_likeman> cache_likemans;
  static ArrayList<s_picdata> cache_picdata;
  static ArrayList<s_reply> cache_replys;
  static s_user cache_user = new s_user();
  public s_audio audio = null;
  public Map<String, byte[]> binaryExtInfo = null;
  public String commentLikekey = "";
  public String commentid = "";
  public ArrayList<s_picdata> commentpic = null;
  public String content = "";
  public int date = 0;
  public int displayflag = 0;
  public Map<String, String> extendInfo = null;
  public int floor = 0;
  public int iDisplayReplyNum = 0;
  public boolean isDeleted = false;
  public int isEssence = 0;
  public int isPrivate = 0;
  public int isStickTop = 0;
  public int isliked = 0;
  public int likeNum = 0;
  public ArrayList<s_likeman> likemans = null;
  public ArrayList<s_picdata> picdata = null;
  public int pokeLikeCount = 0;
  public String pokeLikeEmotion = "";
  public String refer = "";
  public int replynum = 0;
  public ArrayList<s_reply> replys = null;
  public s_user user = null;
  
  static
  {
    cache_replys = new ArrayList();
    Object localObject = new s_reply();
    cache_replys.add(localObject);
    cache_picdata = new ArrayList();
    localObject = new s_picdata();
    cache_picdata.add(localObject);
    cache_audio = new s_audio();
    cache_commentpic = new ArrayList();
    localObject = new s_picdata();
    cache_commentpic.add(localObject);
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
    cache_likemans = new ArrayList();
    localObject = new s_likeman();
    cache_likemans.add(localObject);
    cache_binaryExtInfo = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_binaryExtInfo.put("", localObject);
  }
  
  public s_commment() {}
  
  public s_commment(String paramString1, s_user params_user, String paramString2, int paramInt1, String paramString3, ArrayList<s_reply> paramArrayList, int paramInt2, ArrayList<s_picdata> paramArrayList1, s_audio params_audio, ArrayList<s_picdata> paramArrayList2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Map<String, String> paramMap, int paramInt6, String paramString4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ArrayList<s_likeman> paramArrayList3, Map<String, byte[]> paramMap1, String paramString5, int paramInt11)
  {
    this.commentid = paramString1;
    this.user = params_user;
    this.content = paramString2;
    this.date = paramInt1;
    this.refer = paramString3;
    this.replys = paramArrayList;
    this.replynum = paramInt2;
    this.picdata = paramArrayList1;
    this.audio = params_audio;
    this.commentpic = paramArrayList2;
    this.floor = paramInt3;
    this.isPrivate = paramInt4;
    this.isEssence = paramInt5;
    this.isDeleted = paramBoolean;
    this.extendInfo = paramMap;
    this.likeNum = paramInt6;
    this.commentLikekey = paramString4;
    this.isliked = paramInt7;
    this.isStickTop = paramInt8;
    this.displayflag = paramInt9;
    this.iDisplayReplyNum = paramInt10;
    this.likemans = paramArrayList3;
    this.binaryExtInfo = paramMap1;
    this.pokeLikeEmotion = paramString5;
    this.pokeLikeCount = paramInt11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commentid = paramJceInputStream.readString(0, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    this.replys = ((ArrayList)paramJceInputStream.read(cache_replys, 5, false));
    this.replynum = paramJceInputStream.read(this.replynum, 6, false);
    this.picdata = ((ArrayList)paramJceInputStream.read(cache_picdata, 7, false));
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 8, false));
    this.commentpic = ((ArrayList)paramJceInputStream.read(cache_commentpic, 9, false));
    this.floor = paramJceInputStream.read(this.floor, 10, false);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 11, false);
    this.isEssence = paramJceInputStream.read(this.isEssence, 12, false);
    this.isDeleted = paramJceInputStream.read(this.isDeleted, 13, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 14, false));
    this.likeNum = paramJceInputStream.read(this.likeNum, 15, false);
    this.commentLikekey = paramJceInputStream.readString(16, false);
    this.isliked = paramJceInputStream.read(this.isliked, 17, false);
    this.isStickTop = paramJceInputStream.read(this.isStickTop, 18, false);
    this.displayflag = paramJceInputStream.read(this.displayflag, 19, false);
    this.iDisplayReplyNum = paramJceInputStream.read(this.iDisplayReplyNum, 20, false);
    this.likemans = ((ArrayList)paramJceInputStream.read(cache_likemans, 21, false));
    this.binaryExtInfo = ((Map)paramJceInputStream.read(cache_binaryExtInfo, 22, false));
    this.pokeLikeEmotion = paramJceInputStream.readString(23, false);
    this.pokeLikeCount = paramJceInputStream.read(this.pokeLikeCount, 24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.commentid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.date, 3);
    localObject = this.refer;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.replys;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    paramJceOutputStream.write(this.replynum, 6);
    localObject = this.picdata;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.audio;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.commentpic;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    paramJceOutputStream.write(this.floor, 10);
    paramJceOutputStream.write(this.isPrivate, 11);
    paramJceOutputStream.write(this.isEssence, 12);
    paramJceOutputStream.write(this.isDeleted, 13);
    localObject = this.extendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
    paramJceOutputStream.write(this.likeNum, 15);
    localObject = this.commentLikekey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    paramJceOutputStream.write(this.isliked, 17);
    paramJceOutputStream.write(this.isStickTop, 18);
    paramJceOutputStream.write(this.displayflag, 19);
    paramJceOutputStream.write(this.iDisplayReplyNum, 20);
    localObject = this.likemans;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 21);
    }
    localObject = this.binaryExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 22);
    }
    localObject = this.pokeLikeEmotion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    paramJceOutputStream.write(this.pokeLikeCount, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_commment
 * JD-Core Version:    0.7.0.1
 */