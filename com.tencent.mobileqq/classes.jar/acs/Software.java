package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Software
  extends JceStruct
{
  public String category = "";
  public String cpname = "";
  public String downloadCountDesc = "";
  public int nCommentCount;
  public int nDownloadCount;
  public int nFileId;
  public int nFileSize;
  public int nProductId;
  public byte nScore;
  public int nSoftId;
  public String sFee = "";
  public String sFeedesc = "";
  public String sFileuid = "";
  public String sFileurl = "";
  public String sFunction = "";
  public String sLogoUrl = "";
  public String sPrefix = "";
  public String sProductName = "";
  public String sPublishTime = "";
  public String sSoftName = "";
  public String sSoftVersion = "";
  public int supportdevice;
  
  public Software() {}
  
  public Software(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, int paramInt4, String paramString7, String paramString8, byte paramByte, int paramInt5, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, String paramString14)
  {
    this.nProductId = paramInt1;
    this.sProductName = paramString1;
    this.sLogoUrl = paramString2;
    this.nSoftId = paramInt2;
    this.sSoftName = paramString3;
    this.sSoftVersion = paramString4;
    this.sFee = paramString5;
    this.sPublishTime = paramString6;
    this.nFileId = paramInt3;
    this.nFileSize = paramInt4;
    this.sFileurl = paramString7;
    this.sFileuid = paramString8;
    this.nScore = paramByte;
    this.nCommentCount = paramInt5;
    this.nDownloadCount = paramInt6;
    this.sFunction = paramString9;
    this.sPrefix = paramString10;
    this.sFeedesc = paramString11;
    this.category = paramString12;
    this.cpname = paramString13;
    this.supportdevice = paramInt7;
    this.downloadCountDesc = paramString14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nProductId = paramJceInputStream.read(this.nProductId, 0, true);
    this.sProductName = paramJceInputStream.readString(1, true);
    this.sLogoUrl = paramJceInputStream.readString(2, true);
    this.nSoftId = paramJceInputStream.read(this.nSoftId, 3, true);
    this.sSoftName = paramJceInputStream.readString(4, true);
    this.sSoftVersion = paramJceInputStream.readString(5, true);
    this.sFee = paramJceInputStream.readString(6, true);
    this.sPublishTime = paramJceInputStream.readString(7, true);
    this.nFileId = paramJceInputStream.read(this.nFileId, 8, true);
    this.nFileSize = paramJceInputStream.read(this.nFileSize, 9, true);
    this.sFileurl = paramJceInputStream.readString(10, true);
    this.sFileuid = paramJceInputStream.readString(11, true);
    this.nScore = paramJceInputStream.read(this.nScore, 12, true);
    this.nCommentCount = paramJceInputStream.read(this.nCommentCount, 13, true);
    this.nDownloadCount = paramJceInputStream.read(this.nDownloadCount, 14, true);
    this.sFunction = paramJceInputStream.readString(15, true);
    this.sPrefix = paramJceInputStream.readString(16, true);
    this.sFeedesc = paramJceInputStream.readString(17, true);
    this.category = paramJceInputStream.readString(18, true);
    this.cpname = paramJceInputStream.readString(19, false);
    this.supportdevice = paramJceInputStream.read(this.supportdevice, 20, false);
    this.downloadCountDesc = paramJceInputStream.readString(21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nProductId, 0);
    paramJceOutputStream.write(this.sProductName, 1);
    paramJceOutputStream.write(this.sLogoUrl, 2);
    paramJceOutputStream.write(this.nSoftId, 3);
    paramJceOutputStream.write(this.sSoftName, 4);
    paramJceOutputStream.write(this.sSoftVersion, 5);
    paramJceOutputStream.write(this.sFee, 6);
    paramJceOutputStream.write(this.sPublishTime, 7);
    paramJceOutputStream.write(this.nFileId, 8);
    paramJceOutputStream.write(this.nFileSize, 9);
    paramJceOutputStream.write(this.sFileurl, 10);
    paramJceOutputStream.write(this.sFileuid, 11);
    paramJceOutputStream.write(this.nScore, 12);
    paramJceOutputStream.write(this.nCommentCount, 13);
    paramJceOutputStream.write(this.nDownloadCount, 14);
    paramJceOutputStream.write(this.sFunction, 15);
    paramJceOutputStream.write(this.sPrefix, 16);
    paramJceOutputStream.write(this.sFeedesc, 17);
    paramJceOutputStream.write(this.category, 18);
    if (this.cpname != null) {
      paramJceOutputStream.write(this.cpname, 19);
    }
    paramJceOutputStream.write(this.supportdevice, 20);
    if (this.downloadCountDesc != null) {
      paramJceOutputStream.write(this.downloadCountDesc, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acs.Software
 * JD-Core Version:    0.7.0.1
 */