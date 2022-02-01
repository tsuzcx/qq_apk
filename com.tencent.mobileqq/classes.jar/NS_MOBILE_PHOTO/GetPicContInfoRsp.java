package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetPicContInfoRsp
  extends JceStruct
{
  static Map<String, PicContInfo> cache_pic_info = new HashMap();
  public Map<String, PicContInfo> pic_info = null;
  
  static
  {
    PicContInfo localPicContInfo = new PicContInfo();
    cache_pic_info.put("", localPicContInfo);
  }
  
  public GetPicContInfoRsp() {}
  
  public GetPicContInfoRsp(Map<String, PicContInfo> paramMap)
  {
    this.pic_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_info = ((Map)paramJceInputStream.read(cache_pic_info, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.pic_info;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetPicContInfoRsp
 * JD-Core Version:    0.7.0.1
 */