package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PreuploadPicInfo
  extends JceStruct
{
  static UploadPicInfoReq cache_picinfoReq = new UploadPicInfoReq();
  public int iAlbumTypeID = 0;
  public int iDescLen = 0;
  public long iFileLen = 0L;
  public int iNeedCheckAlbum = 0;
  public long md5filelen = 0L;
  public int md5type = 0;
  public UploadPicInfoReq picinfoReq = null;
  public String sAlbumID = "";
  public String sDescMD5 = "";
  public String sFileMD5 = "";
  public String seq = "";
  
  public PreuploadPicInfo() {}
  
  public PreuploadPicInfo(UploadPicInfoReq paramUploadPicInfoReq, String paramString1, String paramString2, long paramLong1, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, long paramLong2)
  {
    this.picinfoReq = paramUploadPicInfoReq;
    this.sFileMD5 = paramString1;
    this.sDescMD5 = paramString2;
    this.iFileLen = paramLong1;
    this.iDescLen = paramInt1;
    this.md5type = paramInt2;
    this.seq = paramString3;
    this.sAlbumID = paramString4;
    this.iAlbumTypeID = paramInt3;
    this.iNeedCheckAlbum = paramInt4;
    this.md5filelen = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfoReq = ((UploadPicInfoReq)paramJceInputStream.read(cache_picinfoReq, 0, true));
    this.sFileMD5 = paramJceInputStream.readString(1, true);
    this.sDescMD5 = paramJceInputStream.readString(2, true);
    this.iFileLen = paramJceInputStream.read(this.iFileLen, 3, true);
    this.iDescLen = paramJceInputStream.read(this.iDescLen, 4, true);
    this.md5type = paramJceInputStream.read(this.md5type, 5, true);
    this.seq = paramJceInputStream.readString(6, true);
    this.sAlbumID = paramJceInputStream.readString(7, false);
    this.iAlbumTypeID = paramJceInputStream.read(this.iAlbumTypeID, 8, false);
    this.iNeedCheckAlbum = paramJceInputStream.read(this.iNeedCheckAlbum, 9, false);
    this.md5filelen = paramJceInputStream.read(this.md5filelen, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.picinfoReq, 0);
    paramJceOutputStream.write(this.sFileMD5, 1);
    paramJceOutputStream.write(this.sDescMD5, 2);
    paramJceOutputStream.write(this.iFileLen, 3);
    paramJceOutputStream.write(this.iDescLen, 4);
    paramJceOutputStream.write(this.md5type, 5);
    paramJceOutputStream.write(this.seq, 6);
    String str = this.sAlbumID;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.iAlbumTypeID, 8);
    paramJceOutputStream.write(this.iNeedCheckAlbum, 9);
    paramJceOutputStream.write(this.md5filelen, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.PreuploadPicInfo
 * JD-Core Version:    0.7.0.1
 */