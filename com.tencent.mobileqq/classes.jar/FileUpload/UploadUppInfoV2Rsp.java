package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUppInfoV2Rsp
  extends JceStruct
{
  static Map<Long, stPhotoSepcInfo> cache_mapSpecInfo = new HashMap();
  public Map<Long, stPhotoSepcInfo> mapSpecInfo = null;
  public String sPhotoId = "";
  public String sUrl = "";
  
  static
  {
    stPhotoSepcInfo localstPhotoSepcInfo = new stPhotoSepcInfo();
    cache_mapSpecInfo.put(Long.valueOf(0L), localstPhotoSepcInfo);
  }
  
  public UploadUppInfoV2Rsp() {}
  
  public UploadUppInfoV2Rsp(String paramString1, String paramString2, Map<Long, stPhotoSepcInfo> paramMap)
  {
    this.sUrl = paramString1;
    this.sPhotoId = paramString2;
    this.mapSpecInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUrl = paramJceInputStream.readString(0, true);
    this.sPhotoId = paramJceInputStream.readString(1, true);
    this.mapSpecInfo = ((Map)paramJceInputStream.read(cache_mapSpecInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUrl, 0);
    paramJceOutputStream.write(this.sPhotoId, 1);
    paramJceOutputStream.write(this.mapSpecInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.UploadUppInfoV2Rsp
 * JD-Core Version:    0.7.0.1
 */