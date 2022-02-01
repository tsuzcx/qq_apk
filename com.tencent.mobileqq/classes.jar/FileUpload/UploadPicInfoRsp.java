package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadPicInfoRsp
  extends JceStruct
{
  static byte[] cache_vBusiNessDataRsp;
  static stWaterTemplate cache_waterTemplate = new stWaterTemplate();
  public int iBusiNessType = 0;
  public int iHeight = 0;
  public int iOriHeight = 0;
  public int iOriWidth = 0;
  public int iPicType = 0;
  public int iWidth = 0;
  public String sAdaptUrl_1000 = "";
  public String sAdaptUrl_160 = "";
  public String sAdaptUrl_200 = "";
  public String sAdaptUrl_400 = "";
  public String sAdaptUrl_640 = "";
  public String sAlbumID = "";
  public String sBURL = "";
  public String sOriPhotoID = "";
  public String sOriUrl = "";
  public String sPhotoID = "";
  public String sPhotoMD5 = "";
  public String sRealLloc = "";
  public String sSURL = "";
  public String sSloc = "";
  public byte[] vBusiNessDataRsp = null;
  public stWaterTemplate waterTemplate = null;
  
  static
  {
    cache_vBusiNessDataRsp = (byte[])new byte[1];
    ((byte[])cache_vBusiNessDataRsp)[0] = 0;
  }
  
  public UploadPicInfoRsp() {}
  
  public UploadPicInfoRsp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, int paramInt3, int paramInt4, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, stWaterTemplate paramstWaterTemplate, int paramInt6, byte[] paramArrayOfByte, String paramString13, String paramString14)
  {
    this.sSURL = paramString1;
    this.sBURL = paramString2;
    this.sAlbumID = paramString3;
    this.sPhotoID = paramString4;
    this.sSloc = paramString5;
    this.iWidth = paramInt1;
    this.iHeight = paramInt2;
    this.sOriUrl = paramString6;
    this.iOriWidth = paramInt3;
    this.iOriHeight = paramInt4;
    this.sOriPhotoID = paramString7;
    this.iPicType = paramInt5;
    this.sAdaptUrl_160 = paramString8;
    this.sAdaptUrl_200 = paramString9;
    this.sAdaptUrl_400 = paramString10;
    this.sAdaptUrl_640 = paramString11;
    this.sAdaptUrl_1000 = paramString12;
    this.waterTemplate = paramstWaterTemplate;
    this.iBusiNessType = paramInt6;
    this.vBusiNessDataRsp = paramArrayOfByte;
    this.sRealLloc = paramString13;
    this.sPhotoMD5 = paramString14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSURL = paramJceInputStream.readString(0, false);
    this.sBURL = paramJceInputStream.readString(1, false);
    this.sAlbumID = paramJceInputStream.readString(2, false);
    this.sPhotoID = paramJceInputStream.readString(3, false);
    this.sSloc = paramJceInputStream.readString(4, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 5, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 6, false);
    this.sOriUrl = paramJceInputStream.readString(7, false);
    this.iOriWidth = paramJceInputStream.read(this.iOriWidth, 8, false);
    this.iOriHeight = paramJceInputStream.read(this.iOriHeight, 9, false);
    this.sOriPhotoID = paramJceInputStream.readString(10, false);
    this.iPicType = paramJceInputStream.read(this.iPicType, 11, false);
    this.sAdaptUrl_160 = paramJceInputStream.readString(12, false);
    this.sAdaptUrl_200 = paramJceInputStream.readString(13, false);
    this.sAdaptUrl_400 = paramJceInputStream.readString(14, false);
    this.sAdaptUrl_640 = paramJceInputStream.readString(15, false);
    this.sAdaptUrl_1000 = paramJceInputStream.readString(16, false);
    this.waterTemplate = ((stWaterTemplate)paramJceInputStream.read(cache_waterTemplate, 17, false));
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 18, false);
    this.vBusiNessDataRsp = ((byte[])paramJceInputStream.read(cache_vBusiNessDataRsp, 19, false));
    this.sRealLloc = paramJceInputStream.readString(20, false);
    this.sPhotoMD5 = paramJceInputStream.readString(21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.sSURL;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sBURL;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.sAlbumID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.sPhotoID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.sSloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.iWidth, 5);
    paramJceOutputStream.write(this.iHeight, 6);
    localObject = this.sOriUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.iOriWidth, 8);
    paramJceOutputStream.write(this.iOriHeight, 9);
    localObject = this.sOriPhotoID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.iPicType, 11);
    localObject = this.sAdaptUrl_160;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.sAdaptUrl_200;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.sAdaptUrl_400;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.sAdaptUrl_640;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.sAdaptUrl_1000;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.waterTemplate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
    paramJceOutputStream.write(this.iBusiNessType, 18);
    localObject = this.vBusiNessDataRsp;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 19);
    }
    localObject = this.sRealLloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.sPhotoMD5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.UploadPicInfoRsp
 * JD-Core Version:    0.7.0.1
 */