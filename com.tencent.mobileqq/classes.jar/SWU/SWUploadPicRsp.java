package SWU;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SWUploadPicRsp
  extends JceStruct
{
  static int cache_ePicType;
  public int ePicType = 0;
  public int iCode = 0;
  public int iHeight = 0;
  public int iUploadTs = 0;
  public int iWidth = 0;
  public String sAlbumID = "";
  public String sName = "";
  public String sPhotoID = "";
  public String sURL = "";
  
  public SWUploadPicRsp() {}
  
  public SWUploadPicRsp(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, int paramInt4, int paramInt5)
  {
    this.iCode = paramInt1;
    this.sURL = paramString1;
    this.sAlbumID = paramString2;
    this.sPhotoID = paramString3;
    this.iWidth = paramInt2;
    this.iHeight = paramInt3;
    this.sName = paramString4;
    this.iUploadTs = paramInt4;
    this.ePicType = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.sURL = paramJceInputStream.readString(1, false);
    this.sAlbumID = paramJceInputStream.readString(2, false);
    this.sPhotoID = paramJceInputStream.readString(3, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 4, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 5, false);
    this.sName = paramJceInputStream.readString(6, false);
    this.iUploadTs = paramJceInputStream.read(this.iUploadTs, 7, false);
    this.ePicType = paramJceInputStream.read(this.ePicType, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.sURL != null) {
      paramJceOutputStream.write(this.sURL, 1);
    }
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 2);
    }
    if (this.sPhotoID != null) {
      paramJceOutputStream.write(this.sPhotoID, 3);
    }
    paramJceOutputStream.write(this.iWidth, 4);
    paramJceOutputStream.write(this.iHeight, 5);
    if (this.sName != null) {
      paramJceOutputStream.write(this.sName, 6);
    }
    paramJceOutputStream.write(this.iUploadTs, 7);
    paramJceOutputStream.write(this.ePicType, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SWU.SWUploadPicRsp
 * JD-Core Version:    0.7.0.1
 */