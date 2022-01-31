package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadPicInfoReq
  extends JceStruct
{
  static Map<String, byte[]> cache_ExternalData;
  static Map<String, String> cache_mapExt;
  static MultiPicInfo cache_mutliPicInfo = new MultiPicInfo();
  static int cache_resource_type = 0;
  static PicExtendInfo cache_stExtendInfo = new PicExtendInfo();
  static Map<String, String> cache_stExternalMapExt;
  static stPoi cache_uploadPoi;
  static byte[] cache_vBusiNessData;
  static stWaterTemplate cache_waterTemplate;
  public Map<String, byte[]> ExternalData = null;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public int iBitmap = 0;
  public int iBusiNessType = 0;
  public int iDistinctUse = 0;
  public int iNeedFeeds = 0;
  public int iPicHight = 0;
  public int iPicWidth = 0;
  public int iUpPicType = 0;
  public long iUploadTime = 0L;
  public int iUploadType = 0;
  public int iWaterType = 0;
  public Map<String, String> mapExt = null;
  public MultiPicInfo mutliPicInfo = null;
  public String otherParams = "";
  public int resource_type = 0;
  public String sAlbumID = "";
  public String sAlbumName = "";
  public String sExif_CameraMaker = "";
  public String sExif_CameraModel = "";
  public String sExif_Latitude = "";
  public String sExif_LatitudeRef = "";
  public String sExif_Longitude = "";
  public String sExif_LongitudeRef = "";
  public String sExif_Time = "";
  public String sPicDesc = "";
  public String sPicPath = "";
  public String sPicTitle = "";
  public PicExtendInfo stExtendInfo = null;
  public Map<String, String> stExternalMapExt = null;
  public stPoi uploadPoi = null;
  public byte[] vBusiNessData = null;
  public stWaterTemplate waterTemplate = null;
  
  static
  {
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
    cache_uploadPoi = new stPoi();
    cache_waterTemplate = new stWaterTemplate();
    cache_vBusiNessData = (byte[])new byte[1];
    ((byte[])cache_vBusiNessData)[0] = 0;
    cache_stExternalMapExt = new HashMap();
    cache_stExternalMapExt.put("", "");
    cache_ExternalData = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_ExternalData.put("", arrayOfByte);
  }
  
  public UploadPicInfoReq() {}
  
  public UploadPicInfoReq(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, MultiPicInfo paramMultiPicInfo, PicExtendInfo paramPicExtendInfo, String paramString5, int paramInt5, int paramInt6, int paramInt7, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt8, long paramLong2, Map<String, String> paramMap1, int paramInt9, stPoi paramstPoi, stWaterTemplate paramstWaterTemplate, String paramString13, int paramInt10, byte[] paramArrayOfByte, Map<String, String> paramMap2, Map<String, byte[]> paramMap, int paramInt11)
  {
    this.sPicTitle = paramString1;
    this.sPicDesc = paramString2;
    this.sAlbumName = paramString3;
    this.sAlbumID = paramString4;
    this.iAlbumTypeID = paramInt1;
    this.iBitmap = paramInt2;
    this.iUploadType = paramInt3;
    this.iUpPicType = paramInt4;
    this.iBatchID = paramLong1;
    this.mutliPicInfo = paramMultiPicInfo;
    this.stExtendInfo = paramPicExtendInfo;
    this.sPicPath = paramString5;
    this.iPicWidth = paramInt5;
    this.iPicHight = paramInt6;
    this.iWaterType = paramInt7;
    this.sExif_CameraMaker = paramString6;
    this.sExif_CameraModel = paramString7;
    this.sExif_Time = paramString8;
    this.sExif_LatitudeRef = paramString9;
    this.sExif_Latitude = paramString10;
    this.sExif_LongitudeRef = paramString11;
    this.sExif_Longitude = paramString12;
    this.iNeedFeeds = paramInt8;
    this.iUploadTime = paramLong2;
    this.mapExt = paramMap1;
    this.iDistinctUse = paramInt9;
    this.uploadPoi = paramstPoi;
    this.waterTemplate = paramstWaterTemplate;
    this.otherParams = paramString13;
    this.iBusiNessType = paramInt10;
    this.vBusiNessData = paramArrayOfByte;
    this.stExternalMapExt = paramMap2;
    this.ExternalData = paramMap;
    this.resource_type = paramInt11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sPicTitle = paramJceInputStream.readString(0, false);
    this.sPicDesc = paramJceInputStream.readString(1, false);
    this.sAlbumName = paramJceInputStream.readString(2, false);
    this.sAlbumID = paramJceInputStream.readString(3, false);
    this.iAlbumTypeID = paramJceInputStream.read(this.iAlbumTypeID, 4, false);
    this.iBitmap = paramJceInputStream.read(this.iBitmap, 5, false);
    this.iUploadType = paramJceInputStream.read(this.iUploadType, 6, false);
    this.iUpPicType = paramJceInputStream.read(this.iUpPicType, 7, false);
    this.iBatchID = paramJceInputStream.read(this.iBatchID, 8, false);
    this.mutliPicInfo = ((MultiPicInfo)paramJceInputStream.read(cache_mutliPicInfo, 9, false));
    this.stExtendInfo = ((PicExtendInfo)paramJceInputStream.read(cache_stExtendInfo, 10, false));
    this.sPicPath = paramJceInputStream.readString(11, false);
    this.iPicWidth = paramJceInputStream.read(this.iPicWidth, 12, false);
    this.iPicHight = paramJceInputStream.read(this.iPicHight, 13, false);
    this.iWaterType = paramJceInputStream.read(this.iWaterType, 14, false);
    this.sExif_CameraMaker = paramJceInputStream.readString(15, false);
    this.sExif_CameraModel = paramJceInputStream.readString(16, false);
    this.sExif_Time = paramJceInputStream.readString(17, false);
    this.sExif_LatitudeRef = paramJceInputStream.readString(18, false);
    this.sExif_Latitude = paramJceInputStream.readString(19, false);
    this.sExif_LongitudeRef = paramJceInputStream.readString(20, false);
    this.sExif_Longitude = paramJceInputStream.readString(21, false);
    this.iNeedFeeds = paramJceInputStream.read(this.iNeedFeeds, 22, false);
    this.iUploadTime = paramJceInputStream.read(this.iUploadTime, 23, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 24, false));
    this.iDistinctUse = paramJceInputStream.read(this.iDistinctUse, 25, false);
    this.uploadPoi = ((stPoi)paramJceInputStream.read(cache_uploadPoi, 26, false));
    this.waterTemplate = ((stWaterTemplate)paramJceInputStream.read(cache_waterTemplate, 27, false));
    this.otherParams = paramJceInputStream.readString(28, false);
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 29, false);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(cache_vBusiNessData, 30, false));
    this.stExternalMapExt = ((Map)paramJceInputStream.read(cache_stExternalMapExt, 31, false));
    this.ExternalData = ((Map)paramJceInputStream.read(cache_ExternalData, 32, false));
    this.resource_type = paramJceInputStream.read(this.resource_type, 33, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sPicTitle != null) {
      paramJceOutputStream.write(this.sPicTitle, 0);
    }
    if (this.sPicDesc != null) {
      paramJceOutputStream.write(this.sPicDesc, 1);
    }
    if (this.sAlbumName != null) {
      paramJceOutputStream.write(this.sAlbumName, 2);
    }
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 3);
    }
    paramJceOutputStream.write(this.iAlbumTypeID, 4);
    paramJceOutputStream.write(this.iBitmap, 5);
    paramJceOutputStream.write(this.iUploadType, 6);
    paramJceOutputStream.write(this.iUpPicType, 7);
    paramJceOutputStream.write(this.iBatchID, 8);
    if (this.mutliPicInfo != null) {
      paramJceOutputStream.write(this.mutliPicInfo, 9);
    }
    if (this.stExtendInfo != null) {
      paramJceOutputStream.write(this.stExtendInfo, 10);
    }
    if (this.sPicPath != null) {
      paramJceOutputStream.write(this.sPicPath, 11);
    }
    paramJceOutputStream.write(this.iPicWidth, 12);
    paramJceOutputStream.write(this.iPicHight, 13);
    paramJceOutputStream.write(this.iWaterType, 14);
    if (this.sExif_CameraMaker != null) {
      paramJceOutputStream.write(this.sExif_CameraMaker, 15);
    }
    if (this.sExif_CameraModel != null) {
      paramJceOutputStream.write(this.sExif_CameraModel, 16);
    }
    if (this.sExif_Time != null) {
      paramJceOutputStream.write(this.sExif_Time, 17);
    }
    if (this.sExif_LatitudeRef != null) {
      paramJceOutputStream.write(this.sExif_LatitudeRef, 18);
    }
    if (this.sExif_Latitude != null) {
      paramJceOutputStream.write(this.sExif_Latitude, 19);
    }
    if (this.sExif_LongitudeRef != null) {
      paramJceOutputStream.write(this.sExif_LongitudeRef, 20);
    }
    if (this.sExif_Longitude != null) {
      paramJceOutputStream.write(this.sExif_Longitude, 21);
    }
    paramJceOutputStream.write(this.iNeedFeeds, 22);
    paramJceOutputStream.write(this.iUploadTime, 23);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 24);
    }
    paramJceOutputStream.write(this.iDistinctUse, 25);
    if (this.uploadPoi != null) {
      paramJceOutputStream.write(this.uploadPoi, 26);
    }
    if (this.waterTemplate != null) {
      paramJceOutputStream.write(this.waterTemplate, 27);
    }
    if (this.otherParams != null) {
      paramJceOutputStream.write(this.otherParams, 28);
    }
    paramJceOutputStream.write(this.iBusiNessType, 29);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 30);
    }
    if (this.stExternalMapExt != null) {
      paramJceOutputStream.write(this.stExternalMapExt, 31);
    }
    if (this.ExternalData != null) {
      paramJceOutputStream.write(this.ExternalData, 32);
    }
    paramJceOutputStream.write(this.resource_type, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.UploadPicInfoReq
 * JD-Core Version:    0.7.0.1
 */