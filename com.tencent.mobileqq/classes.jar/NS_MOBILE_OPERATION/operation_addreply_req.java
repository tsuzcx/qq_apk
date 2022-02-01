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
  public int appid = 0;
  public Map<Integer, String> busi_param = null;
  public Map<String, String> bypass_param = null;
  public String commentid = "";
  public long commentuin = 0L;
  public String content = "";
  public int isverified = 0;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public long ownuin = 0L;
  public String srcId = "";
  public long uin = 0L;
  
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
    Object localObject = this.srcId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.commentid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.isverified, 7);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.mediainfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    paramJceOutputStream.write(this.mediabittype, 10);
    localObject = this.bypass_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addreply_req
 * JD-Core Version:    0.7.0.1
 */