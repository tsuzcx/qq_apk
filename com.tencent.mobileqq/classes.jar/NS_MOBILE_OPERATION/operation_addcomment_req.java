package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_addcomment_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  static Map<String, String> cache_bypass_param;
  static Map<String, byte[]> cache_bypass_param_binary;
  static MediaInfo cache_mediainfo;
  public int appid = 0;
  public Map<Integer, String> busi_param = null;
  public Map<String, String> bypass_param = null;
  public Map<String, byte[]> bypass_param_binary = null;
  public String content = "";
  public int isPrivateComment = 0;
  public int isverified = 0;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public long ownuin = 0L;
  public String srcId = "";
  public String srcSubid = "";
  public long uin = 0L;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_mediainfo = new MediaInfo();
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
    cache_bypass_param_binary = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_bypass_param_binary.put("", arrayOfByte);
  }
  
  public operation_addcomment_req() {}
  
  public operation_addcomment_req(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt2, Map<Integer, String> paramMap, String paramString3, MediaInfo paramMediaInfo, int paramInt3, int paramInt4, Map<String, String> paramMap1, Map<String, byte[]> paramMap2)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcId = paramString1;
    this.content = paramString2;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.srcSubid = paramString3;
    this.mediainfo = paramMediaInfo;
    this.mediabittype = paramInt3;
    this.isPrivateComment = paramInt4;
    this.bypass_param = paramMap1;
    this.bypass_param_binary = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcId = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.isverified = paramJceInputStream.read(this.isverified, 5, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.srcSubid = paramJceInputStream.readString(7, false);
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 8, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 9, false);
    this.isPrivateComment = paramJceInputStream.read(this.isPrivateComment, 10, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 11, false));
    this.bypass_param_binary = ((Map)paramJceInputStream.read(cache_bypass_param_binary, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 3);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    paramJceOutputStream.write(this.isverified, 5);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 6);
    }
    if (this.srcSubid != null) {
      paramJceOutputStream.write(this.srcSubid, 7);
    }
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 8);
    }
    paramJceOutputStream.write(this.mediabittype, 9);
    paramJceOutputStream.write(this.isPrivateComment, 10);
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 11);
    }
    if (this.bypass_param_binary != null) {
      paramJceOutputStream.write(this.bypass_param_binary, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addcomment_req
 * JD-Core Version:    0.7.0.1
 */