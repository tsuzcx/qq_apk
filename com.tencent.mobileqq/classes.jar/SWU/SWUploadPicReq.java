package SWU;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SWUploadPicReq
  extends JceStruct
{
  static int cache_eFileType;
  static int cache_eUseType;
  static byte[] cache_wnskey;
  public String device = "";
  public String duration = "";
  public int eFileType = 0;
  public int eUseType = 0;
  public String emojitype = "";
  public long iBatchID = 0L;
  public int iCurPicNum = 0;
  public int iFromQZone = 0;
  public int iPicHight = 0;
  public int iPicWidth = 0;
  public int iPictotalNum = 0;
  public int isShareFeeds = 0;
  public String itemid = "";
  public int keyType = 0;
  public String localid = "";
  public String os = "";
  public String osver = "";
  public String pic_url = "";
  public String sAddress = "";
  public String sAlbumID = "";
  public String sClientip = "";
  public String sPicDesc = "";
  public String sPicPath = "";
  public String sPicTitle = "";
  public String sUserAgent = "";
  public String ver = "";
  public byte[] wnskey = null;
  
  public SWUploadPicReq() {}
  
  public SWUploadPicReq(String paramString1, String paramString2, int paramInt1, String paramString3, long paramLong, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, String paramString6, String paramString7, int paramInt6, int paramInt7, int paramInt8, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt9, byte[] paramArrayOfByte, String paramString14, String paramString15, String paramString16)
  {
    this.sPicTitle = paramString1;
    this.sPicDesc = paramString2;
    this.eUseType = paramInt1;
    this.sAlbumID = paramString3;
    this.iBatchID = paramLong;
    this.eFileType = paramInt2;
    this.sPicPath = paramString4;
    this.iPicWidth = paramInt3;
    this.iPicHight = paramInt4;
    this.sClientip = paramString5;
    this.isShareFeeds = paramInt5;
    this.sUserAgent = paramString6;
    this.sAddress = paramString7;
    this.iPictotalNum = paramInt6;
    this.iCurPicNum = paramInt7;
    this.iFromQZone = paramInt8;
    this.pic_url = paramString8;
    this.localid = paramString9;
    this.os = paramString10;
    this.device = paramString11;
    this.osver = paramString12;
    this.ver = paramString13;
    this.keyType = paramInt9;
    this.wnskey = paramArrayOfByte;
    this.duration = paramString14;
    this.itemid = paramString15;
    this.emojitype = paramString16;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sPicTitle = paramJceInputStream.readString(0, false);
    this.sPicDesc = paramJceInputStream.readString(1, false);
    this.eUseType = paramJceInputStream.read(this.eUseType, 2, false);
    this.sAlbumID = paramJceInputStream.readString(3, false);
    this.iBatchID = paramJceInputStream.read(this.iBatchID, 4, false);
    this.eFileType = paramJceInputStream.read(this.eFileType, 5, false);
    this.sPicPath = paramJceInputStream.readString(6, false);
    this.iPicWidth = paramJceInputStream.read(this.iPicWidth, 7, false);
    this.iPicHight = paramJceInputStream.read(this.iPicHight, 8, false);
    this.sClientip = paramJceInputStream.readString(9, false);
    this.isShareFeeds = paramJceInputStream.read(this.isShareFeeds, 10, false);
    this.sUserAgent = paramJceInputStream.readString(11, false);
    this.sAddress = paramJceInputStream.readString(12, false);
    this.iPictotalNum = paramJceInputStream.read(this.iPictotalNum, 13, false);
    this.iCurPicNum = paramJceInputStream.read(this.iCurPicNum, 14, false);
    this.iFromQZone = paramJceInputStream.read(this.iFromQZone, 15, false);
    this.pic_url = paramJceInputStream.readString(16, false);
    this.localid = paramJceInputStream.readString(17, false);
    this.os = paramJceInputStream.readString(18, false);
    this.device = paramJceInputStream.readString(19, false);
    this.osver = paramJceInputStream.readString(20, false);
    this.ver = paramJceInputStream.readString(21, false);
    this.keyType = paramJceInputStream.read(this.keyType, 22, false);
    if (cache_wnskey == null)
    {
      cache_wnskey = (byte[])new byte[1];
      ((byte[])cache_wnskey)[0] = 0;
    }
    this.wnskey = ((byte[])paramJceInputStream.read(cache_wnskey, 23, false));
    this.duration = paramJceInputStream.readString(24, false);
    this.itemid = paramJceInputStream.readString(25, false);
    this.emojitype = paramJceInputStream.readString(26, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.sPicTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sPicDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.eUseType, 2);
    localObject = this.sAlbumID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.iBatchID, 4);
    paramJceOutputStream.write(this.eFileType, 5);
    localObject = this.sPicPath;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.iPicWidth, 7);
    paramJceOutputStream.write(this.iPicHight, 8);
    localObject = this.sClientip;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.isShareFeeds, 10);
    localObject = this.sUserAgent;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.sAddress;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    paramJceOutputStream.write(this.iPictotalNum, 13);
    paramJceOutputStream.write(this.iCurPicNum, 14);
    paramJceOutputStream.write(this.iFromQZone, 15);
    localObject = this.pic_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.localid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    localObject = this.os;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    localObject = this.device;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    localObject = this.osver;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.ver;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.keyType, 22);
    localObject = this.wnskey;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 23);
    }
    localObject = this.duration;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 24);
    }
    localObject = this.itemid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 25);
    }
    localObject = this.emojitype;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 26);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SWU.SWUploadPicReq
 * JD-Core Version:    0.7.0.1
 */