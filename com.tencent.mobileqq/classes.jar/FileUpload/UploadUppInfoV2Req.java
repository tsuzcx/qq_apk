package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUppInfoV2Req
  extends JceStruct
{
  static stPhotoSepcInfo cache_PhotoSpecInfo = new stPhotoSepcInfo();
  static Map<String, String> cache_mapExt = new HashMap();
  static MultiPicInfo cache_mutlipicinfo = new MultiPicInfo();
  public stPhotoSepcInfo PhotoSpecInfo = null;
  public long iBatchID = 0L;
  public int iPhotoType = 0;
  public int iType = 0;
  public long iUploadIp = 0L;
  public Map<String, String> mapExt = null;
  public MultiPicInfo mutlipicinfo = null;
  public String sAlbumId = "";
  public String sAppId = "";
  public String sDesc = "";
  public String sPicPath = "";
  public String sTitle = "";
  public String sUserId = "";
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public UploadUppInfoV2Req() {}
  
  public UploadUppInfoV2Req(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong1, stPhotoSepcInfo paramstPhotoSepcInfo, Map<String, String> paramMap, String paramString6, long paramLong2, MultiPicInfo paramMultiPicInfo, int paramInt2)
  {
    this.sAppId = paramString1;
    this.sUserId = paramString2;
    this.sAlbumId = paramString3;
    this.sTitle = paramString4;
    this.sDesc = paramString5;
    this.iType = paramInt1;
    this.iUploadIp = paramLong1;
    this.PhotoSpecInfo = paramstPhotoSepcInfo;
    this.mapExt = paramMap;
    this.sPicPath = paramString6;
    this.iBatchID = paramLong2;
    this.mutlipicinfo = paramMultiPicInfo;
    this.iPhotoType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sAppId = paramJceInputStream.readString(0, true);
    this.sUserId = paramJceInputStream.readString(1, true);
    this.sAlbumId = paramJceInputStream.readString(2, true);
    this.sTitle = paramJceInputStream.readString(3, true);
    this.sDesc = paramJceInputStream.readString(4, true);
    this.iType = paramJceInputStream.read(this.iType, 5, true);
    this.iUploadIp = paramJceInputStream.read(this.iUploadIp, 6, true);
    this.PhotoSpecInfo = ((stPhotoSepcInfo)paramJceInputStream.read(cache_PhotoSpecInfo, 7, true));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 8, false));
    this.sPicPath = paramJceInputStream.readString(9, false);
    this.iBatchID = paramJceInputStream.read(this.iBatchID, 10, false);
    this.mutlipicinfo = ((MultiPicInfo)paramJceInputStream.read(cache_mutlipicinfo, 11, false));
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sAppId, 0);
    paramJceOutputStream.write(this.sUserId, 1);
    paramJceOutputStream.write(this.sAlbumId, 2);
    paramJceOutputStream.write(this.sTitle, 3);
    paramJceOutputStream.write(this.sDesc, 4);
    paramJceOutputStream.write(this.iType, 5);
    paramJceOutputStream.write(this.iUploadIp, 6);
    paramJceOutputStream.write(this.PhotoSpecInfo, 7);
    Object localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.sPicPath;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.iBatchID, 10);
    localObject = this.mutlipicinfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    paramJceOutputStream.write(this.iPhotoType, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.UploadUppInfoV2Req
 * JD-Core Version:    0.7.0.1
 */