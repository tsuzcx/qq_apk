package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUpsInfoRsp
  extends JceStruct
{
  static Map<Long, String> cache_sUrls;
  static byte[] cache_vBusiNessData = (byte[])new byte[1];
  public int iHight = 0;
  public int iPhotoType = 0;
  public int iType = 0;
  public int iWidth = 0;
  public String sUrl = "";
  public Map<Long, String> sUrls = null;
  public byte[] vBusiNessData = null;
  
  static
  {
    ((byte[])cache_vBusiNessData)[0] = 0;
    cache_sUrls = new HashMap();
    cache_sUrls.put(Long.valueOf(0L), "");
  }
  
  public UploadUpsInfoRsp() {}
  
  public UploadUpsInfoRsp(int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, int paramInt4, Map<Long, String> paramMap)
  {
    this.iType = paramInt1;
    this.vBusiNessData = paramArrayOfByte;
    this.sUrl = paramString;
    this.iWidth = paramInt2;
    this.iHight = paramInt3;
    this.iPhotoType = paramInt4;
    this.sUrls = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    this.vBusiNessData = ((byte[])paramJceInputStream.read(cache_vBusiNessData, 1, false));
    this.sUrl = paramJceInputStream.readString(2, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 3, false);
    this.iHight = paramJceInputStream.read(this.iHight, 4, false);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 5, false);
    this.sUrls = ((Map)paramJceInputStream.read(cache_sUrls, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 1);
    }
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 2);
    }
    paramJceOutputStream.write(this.iWidth, 3);
    paramJceOutputStream.write(this.iHight, 4);
    paramJceOutputStream.write(this.iPhotoType, 5);
    if (this.sUrls != null) {
      paramJceOutputStream.write(this.sUrls, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.UploadUpsInfoRsp
 * JD-Core Version:    0.7.0.1
 */