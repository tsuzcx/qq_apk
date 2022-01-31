package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadVideoInfoReq
  extends JceStruct
{
  static Map<String, String> cache_extend_info;
  static byte[] cache_vBusiNessData = (byte[])new byte[1];
  public Map<String, String> extend_info = null;
  public int height = 0;
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public int iIsFormatF20 = 0;
  public int iIsNew = 0;
  public int iIsOriginalVideo = 0;
  public int iPlayTime = 0;
  public long iUploadTime = 0L;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  public int width = 0;
  
  static
  {
    ((byte[])cache_vBusiNessData)[0] = 0;
    cache_extend_info = new HashMap();
    cache_extend_info.put("", "");
  }
  
  public UploadVideoInfoReq() {}
  
  public UploadVideoInfoReq(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte, int paramInt3, String paramString3, int paramInt4, int paramInt5, int paramInt6, Map<String, String> paramMap, int paramInt7, int paramInt8)
  {
    this.sTitle = paramString1;
    this.sDesc = paramString2;
    this.iFlag = paramInt1;
    this.iUploadTime = paramLong;
    this.iBusiNessType = paramInt2;
    this.vBusiNessData = paramArrayOfByte;
    this.iPlayTime = paramInt3;
    this.sCoverUrl = paramString3;
    this.iIsNew = paramInt4;
    this.iIsOriginalVideo = paramInt5;
    this.iIsFormatF20 = paramInt6;
    this.extend_info = paramMap;
    this.height = paramInt7;
    this.width = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sTitle = paramJceInputStream.readString(0, false);
    this.sDesc = paramJceInputStream.readString(1, false);
    this.iFlag = paramJceInputStream.read(this.iFlag, 2, false);
    this.iUploadTime = paramJceInputStream.read(this.iUploadTime, 3, false);
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 4, false);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(cache_vBusiNessData, 5, false));
    this.iPlayTime = paramJceInputStream.read(this.iPlayTime, 6, false);
    this.sCoverUrl = paramJceInputStream.readString(7, false);
    this.iIsNew = paramJceInputStream.read(this.iIsNew, 8, false);
    this.iIsOriginalVideo = paramJceInputStream.read(this.iIsOriginalVideo, 9, false);
    this.iIsFormatF20 = paramJceInputStream.read(this.iIsFormatF20, 10, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 11, false));
    this.height = paramJceInputStream.read(this.height, 12, false);
    this.width = paramJceInputStream.read(this.width, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sTitle != null) {
      paramJceOutputStream.write(this.sTitle, 0);
    }
    if (this.sDesc != null) {
      paramJceOutputStream.write(this.sDesc, 1);
    }
    paramJceOutputStream.write(this.iFlag, 2);
    paramJceOutputStream.write(this.iUploadTime, 3);
    paramJceOutputStream.write(this.iBusiNessType, 4);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 5);
    }
    paramJceOutputStream.write(this.iPlayTime, 6);
    if (this.sCoverUrl != null) {
      paramJceOutputStream.write(this.sCoverUrl, 7);
    }
    paramJceOutputStream.write(this.iIsNew, 8);
    paramJceOutputStream.write(this.iIsOriginalVideo, 9);
    paramJceOutputStream.write(this.iIsFormatF20, 10);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 11);
    }
    paramJceOutputStream.write(this.height, 12);
    paramJceOutputStream.write(this.width, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.UploadVideoInfoReq
 * JD-Core Version:    0.7.0.1
 */