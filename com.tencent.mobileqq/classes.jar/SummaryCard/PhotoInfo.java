package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PhotoInfo
  extends JceStruct
{
  static Map<String, String> cache_mapEx = new HashMap();
  public int IsOnlySelf = 0;
  public Map<String, String> mapEx = null;
  public String strPicUrl = "";
  public long uPhotoTimestamp = 0L;
  
  static
  {
    cache_mapEx.put("", "");
  }
  
  public PhotoInfo() {}
  
  public PhotoInfo(String paramString, long paramLong, int paramInt, Map<String, String> paramMap)
  {
    this.strPicUrl = paramString;
    this.uPhotoTimestamp = paramLong;
    this.IsOnlySelf = paramInt;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.uPhotoTimestamp = paramJceInputStream.read(this.uPhotoTimestamp, 1, true);
    this.IsOnlySelf = paramJceInputStream.read(this.IsOnlySelf, 2, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.uPhotoTimestamp, 1);
    paramJceOutputStream.write(this.IsOnlySelf, 2);
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */