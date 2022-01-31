package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_addreply_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_bypass_param;
  static MediaInfo cache_mediainfo;
  public int appid;
  public Map<Integer, String> busi_param;
  public Map<String, String> bypass_param;
  public String commentid = "";
  public long commentuin;
  public String content = "";
  public int isverified;
  public int mediabittype;
  public MediaInfo mediainfo;
  public long ownuin;
  public String srcId = "";
  public long uin;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mediainfo = new MediaInfo();
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
  }
  
  public operation_addreply_req() {}
  
  public operation_addreply_req(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, int paramInt2, Map<Integer, String> paramMap, MediaInfo paramMediaInfo, int paramInt3, Map<String, String> paramMap1)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.commentuin = paramLong3;
    this.srcId = paramString1;
    this.commentid = paramString2;
    this.content = paramString3;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.mediainfo = paramMediaInfo;
    this.mediabittype = paramInt3;
    this.bypass_param = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.commentuin = paramJceInputStream.read(this.commentuin, 3, false);
    this.srcId = paramJceInputStream.readString(4, false);
    this.commentid = paramJceInputStream.readString(5, false);
    this.content = paramJceInputStream.readString(6, false);
    this.isverified = paramJceInputStream.read(this.isverified, 7, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 8, false));
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 9, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 10, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    paramJceOutputStream.write(this.commentuin, 3);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 4);
    }
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 5);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 6);
    }
    paramJceOutputStream.write(this.isverified, 7);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 8);
    }
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 9);
    }
    paramJceOutputStream.write(this.mediabittype, 10);
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addreply_req
 * JD-Core Version:    0.7.0.1
 */