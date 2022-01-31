package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_commment
  extends JceStruct
{
  static s_audio cache_audio;
  static Map cache_binaryExtInfo;
  static ArrayList cache_commentpic;
  static Map cache_extendInfo;
  static ArrayList cache_likemans;
  static ArrayList cache_picdata;
  static ArrayList cache_replys;
  static s_user cache_user = new s_user();
  public s_audio audio;
  public Map binaryExtInfo;
  public String commentLikekey = "";
  public String commentid = "";
  public ArrayList commentpic;
  public String content = "";
  public int date;
  public int displayflag;
  public Map extendInfo;
  public int floor;
  public int iDisplayReplyNum;
  public boolean isDeleted;
  public int isEssence;
  public int isPrivate;
  public int isStickTop;
  public int isliked;
  public int likeNum;
  public ArrayList likemans;
  public ArrayList picdata;
  public String refer = "";
  public int replynum;
  public ArrayList replys;
  public s_user user;
  
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
  
  public s_commment(String paramString1, s_user params_user, String paramString2, int paramInt1, String paramString3, ArrayList paramArrayList1, int paramInt2, ArrayList paramArrayList2, s_audio params_audio, ArrayList paramArrayList3, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Map paramMap1, int paramInt6, String paramString4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ArrayList paramArrayList4, Map paramMap2)
  {
    this.commentid = paramString1;
    this.user = params_user;
    this.content = paramString2;
    this.date = paramInt1;
    this.refer = paramString3;
    this.replys = paramArrayList1;
    this.replynum = paramInt2;
    this.picdata = paramArrayList2;
    this.audio = params_audio;
    this.commentpic = paramArrayList3;
    this.floor = paramInt3;
    this.isPrivate = paramInt4;
    this.isEssence = paramInt5;
    this.isDeleted = paramBoolean;
    this.extendInfo = paramMap1;
    this.likeNum = paramInt6;
    this.commentLikekey = paramString4;
    this.isliked = paramInt7;
    this.isStickTop = paramInt8;
    this.displayflag = paramInt9;
    this.iDisplayReplyNum = paramInt10;
    this.likemans = paramArrayList4;
    this.binaryExtInfo = paramMap2;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 0);
    }
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.date, 3);
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 4);
    }
    if (this.replys != null) {
      paramJceOutputStream.write(this.replys, 5);
    }
    paramJceOutputStream.write(this.replynum, 6);
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 7);
    }
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 8);
    }
    if (this.commentpic != null) {
      paramJceOutputStream.write(this.commentpic, 9);
    }
    paramJceOutputStream.write(this.floor, 10);
    paramJceOutputStream.write(this.isPrivate, 11);
    paramJceOutputStream.write(this.isEssence, 12);
    paramJceOutputStream.write(this.isDeleted, 13);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 14);
    }
    paramJceOutputStream.write(this.likeNum, 15);
    if (this.commentLikekey != null) {
      paramJceOutputStream.write(this.commentLikekey, 16);
    }
    paramJceOutputStream.write(this.isliked, 17);
    paramJceOutputStream.write(this.isStickTop, 18);
    paramJceOutputStream.write(this.displayflag, 19);
    paramJceOutputStream.write(this.iDisplayReplyNum, 20);
    if (this.likemans != null) {
      paramJceOutputStream.write(this.likemans, 21);
    }
    if (this.binaryExtInfo != null) {
      paramJceOutputStream.write(this.binaryExtInfo, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_commment
 * JD-Core Version:    0.7.0.1
 */