package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class OneVideoInfo
  extends JceStruct
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public int actiontype = 0;
  public String actionurl = "";
  public String clientkey = "";
  public int commentCount = 0;
  public String coverurl = "";
  public long createtime = 0L;
  public Map<String, String> extendinfo = null;
  public int filetype = 0;
  public int height = 0;
  public int ifLiked = 0;
  public String likeKey = "";
  public int likeNum = 0;
  public String lloc = "";
  public byte playtype = 0;
  public String qqUrl = "";
  public String shuoid = "";
  public String sloc = "";
  public String toast = "";
  public String ugckey = "";
  public String videoid = "";
  public int videostatus = 0;
  public long videotime = 0L;
  public byte videotype = 0;
  public String videourl = "";
  public String weixinUrl = "";
  public int width = 0;
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public OneVideoInfo() {}
  
  public OneVideoInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, byte paramByte1, long paramLong1, long paramLong2, byte paramByte2, int paramInt3, String paramString6, Map<String, String> paramMap, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, int paramInt6, String paramString10, String paramString11, int paramInt7, int paramInt8, String paramString12, String paramString13)
  {
    this.videoid = paramString1;
    this.videourl = paramString2;
    this.coverurl = paramString3;
    this.actiontype = paramInt1;
    this.actionurl = paramString4;
    this.clientkey = paramString5;
    this.filetype = paramInt2;
    this.videotype = paramByte1;
    this.videotime = paramLong1;
    this.createtime = paramLong2;
    this.playtype = paramByte2;
    this.videostatus = paramInt3;
    this.toast = paramString6;
    this.extendinfo = paramMap;
    this.sloc = paramString7;
    this.lloc = paramString8;
    this.width = paramInt4;
    this.height = paramInt5;
    this.shuoid = paramString9;
    this.likeNum = paramInt6;
    this.weixinUrl = paramString10;
    this.qqUrl = paramString11;
    this.ifLiked = paramInt7;
    this.commentCount = paramInt8;
    this.likeKey = paramString12;
    this.ugckey = paramString13;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.videoid = paramJceInputStream.readString(0, false);
    this.videourl = paramJceInputStream.readString(1, false);
    this.coverurl = paramJceInputStream.readString(2, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.actionurl = paramJceInputStream.readString(4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    this.filetype = paramJceInputStream.read(this.filetype, 6, false);
    this.videotype = paramJceInputStream.read(this.videotype, 7, false);
    this.videotime = paramJceInputStream.read(this.videotime, 8, false);
    this.createtime = paramJceInputStream.read(this.createtime, 9, false);
    this.playtype = paramJceInputStream.read(this.playtype, 10, false);
    this.videostatus = paramJceInputStream.read(this.videostatus, 11, false);
    this.toast = paramJceInputStream.readString(12, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 13, false));
    this.sloc = paramJceInputStream.readString(14, false);
    this.lloc = paramJceInputStream.readString(15, false);
    this.width = paramJceInputStream.read(this.width, 16, false);
    this.height = paramJceInputStream.read(this.height, 17, false);
    this.shuoid = paramJceInputStream.readString(18, false);
    this.likeNum = paramJceInputStream.read(this.likeNum, 19, false);
    this.weixinUrl = paramJceInputStream.readString(20, false);
    this.qqUrl = paramJceInputStream.readString(21, false);
    this.ifLiked = paramJceInputStream.read(this.ifLiked, 22, false);
    this.commentCount = paramJceInputStream.read(this.commentCount, 23, false);
    this.likeKey = paramJceInputStream.readString(24, false);
    this.ugckey = paramJceInputStream.readString(25, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.videoid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.videourl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.coverurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.filetype, 6);
    paramJceOutputStream.write(this.videotype, 7);
    paramJceOutputStream.write(this.videotime, 8);
    paramJceOutputStream.write(this.createtime, 9);
    paramJceOutputStream.write(this.playtype, 10);
    paramJceOutputStream.write(this.videostatus, 11);
    localObject = this.toast;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
    localObject = this.sloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.lloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.width, 16);
    paramJceOutputStream.write(this.height, 17);
    localObject = this.shuoid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    paramJceOutputStream.write(this.likeNum, 19);
    localObject = this.weixinUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.qqUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.ifLiked, 22);
    paramJceOutputStream.write(this.commentCount, 23);
    localObject = this.likeKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 24);
    }
    localObject = this.ugckey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 25);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.OneVideoInfo
 * JD-Core Version:    0.7.0.1
 */