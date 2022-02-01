package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class operation_forward_req
  extends JceStruct
{
  public static final String XCX_MAPEX_KEY_APPID = "xcxAppId";
  public static final String XCX_MAPEX_KEY_FAKE_LINK = "xcxFakeLink";
  public static final String XCX_MAPEX_KEY_PATH = "xcxPath";
  public static final String XCX_MAPEX_KEY_SOURCE_TYPE = "xcxSourceType";
  static Map<Integer, String> cache_busi_param;
  static Map<String, ArrayList<String>> cache_photoids;
  static share_tail_info cache_sharetailinfo = new share_tail_info();
  static ArrayList<String> cache_srcImages;
  static ArrayList<String> cache_srcSubid = new ArrayList();
  static Map<String, String> cache_stored_extend_info;
  static Map<String, String> cache_xcxMapEx;
  public int appid = 0;
  public Map<Integer, String> busi_param = null;
  public String category = "";
  public String ciphertext = "";
  public String dstAlbumId = "";
  public int dstAlbumType = 0;
  public int iUrlInfoFrm = 0;
  public int isverified = 0;
  public int operatemask = 0;
  public long ownUin = 0L;
  public Map<String, ArrayList<String>> photoids = null;
  public String reason = "";
  public share_tail_info sharetailinfo = null;
  public int source = 0;
  public String srcAbstract = "";
  public String srcId = "";
  public ArrayList<String> srcImages = null;
  public int srcPicNum = 0;
  public ArrayList<String> srcSubid = null;
  public String srcTitle = "";
  public Map<String, String> stored_extend_info = null;
  public int subid = 0;
  public long uin = 0L;
  public Map<String, String> xcxMapEx = null;
  public int xcxZZType = 0;
  
  static
  {
    cache_srcSubid.add("");
    cache_srcImages = new ArrayList();
    cache_srcImages.add("");
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_photoids = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    cache_photoids.put("", localArrayList);
    cache_xcxMapEx = new HashMap();
    cache_xcxMapEx.put("", "");
    cache_stored_extend_info = new HashMap();
    cache_stored_extend_info.put("", "");
  }
  
  public operation_forward_req() {}
  
  public operation_forward_req(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, ArrayList<String> paramArrayList1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList2, int paramInt3, int paramInt4, int paramInt5, String paramString5, int paramInt6, String paramString6, int paramInt7, Map<Integer, String> paramMap, Map<String, ArrayList<String>> paramMap1, int paramInt8, String paramString7, int paramInt9, Map<String, String> paramMap2, Map<String, String> paramMap3, share_tail_info paramshare_tail_info)
  {
    this.appid = paramInt1;
    this.subid = paramInt2;
    this.uin = paramLong1;
    this.ownUin = paramLong2;
    this.srcId = paramString1;
    this.srcSubid = paramArrayList1;
    this.reason = paramString2;
    this.srcTitle = paramString3;
    this.srcAbstract = paramString4;
    this.srcImages = paramArrayList2;
    this.srcPicNum = paramInt3;
    this.source = paramInt4;
    this.isverified = paramInt5;
    this.category = paramString5;
    this.operatemask = paramInt6;
    this.dstAlbumId = paramString6;
    this.dstAlbumType = paramInt7;
    this.busi_param = paramMap;
    this.photoids = paramMap1;
    this.iUrlInfoFrm = paramInt8;
    this.ciphertext = paramString7;
    this.xcxZZType = paramInt9;
    this.xcxMapEx = paramMap2;
    this.stored_extend_info = paramMap3;
    this.sharetailinfo = paramshare_tail_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.subid = paramJceInputStream.read(this.subid, 1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
    this.ownUin = paramJceInputStream.read(this.ownUin, 3, false);
    this.srcId = paramJceInputStream.readString(4, false);
    this.srcSubid = ((ArrayList)paramJceInputStream.read(cache_srcSubid, 5, false));
    this.reason = paramJceInputStream.readString(6, false);
    this.srcTitle = paramJceInputStream.readString(7, false);
    this.srcAbstract = paramJceInputStream.readString(8, false);
    this.srcImages = ((ArrayList)paramJceInputStream.read(cache_srcImages, 9, false));
    this.srcPicNum = paramJceInputStream.read(this.srcPicNum, 10, false);
    this.source = paramJceInputStream.read(this.source, 11, false);
    this.isverified = paramJceInputStream.read(this.isverified, 12, false);
    this.category = paramJceInputStream.readString(13, false);
    this.operatemask = paramJceInputStream.read(this.operatemask, 14, false);
    this.dstAlbumId = paramJceInputStream.readString(15, false);
    this.dstAlbumType = paramJceInputStream.read(this.dstAlbumType, 16, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 17, false));
    this.photoids = ((Map)paramJceInputStream.read(cache_photoids, 18, false));
    this.iUrlInfoFrm = paramJceInputStream.read(this.iUrlInfoFrm, 19, false);
    this.ciphertext = paramJceInputStream.readString(20, false);
    this.xcxZZType = paramJceInputStream.read(this.xcxZZType, 21, false);
    this.xcxMapEx = ((Map)paramJceInputStream.read(cache_xcxMapEx, 22, false));
    this.stored_extend_info = ((Map)paramJceInputStream.read(cache_stored_extend_info, 23, false));
    this.sharetailinfo = ((share_tail_info)paramJceInputStream.read(cache_sharetailinfo, 24, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.subid, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.ownUin, 3);
    Object localObject = this.srcId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.srcSubid;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.reason;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.srcTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.srcAbstract;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.srcImages;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    paramJceOutputStream.write(this.srcPicNum, 10);
    paramJceOutputStream.write(this.source, 11);
    paramJceOutputStream.write(this.isverified, 12);
    localObject = this.category;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.operatemask, 14);
    localObject = this.dstAlbumId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.dstAlbumType, 16);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 17);
    }
    localObject = this.photoids;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 18);
    }
    paramJceOutputStream.write(this.iUrlInfoFrm, 19);
    localObject = this.ciphertext;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    paramJceOutputStream.write(this.xcxZZType, 21);
    localObject = this.xcxMapEx;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 22);
    }
    localObject = this.stored_extend_info;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 23);
    }
    localObject = this.sharetailinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_forward_req
 * JD-Core Version:    0.7.0.1
 */