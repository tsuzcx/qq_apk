package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class BatchGetSimilarGroupidReq
  extends JceStruct
{
  static Map<String, PhotoInfos> cache_infos = new HashMap();
  public Map<String, PhotoInfos> infos;
  public boolean is_need_new_groupids;
  public long uin;
  
  static
  {
    PhotoInfos localPhotoInfos = new PhotoInfos();
    cache_infos.put("", localPhotoInfos);
  }
  
  public BatchGetSimilarGroupidReq() {}
  
  public BatchGetSimilarGroupidReq(long paramLong, Map<String, PhotoInfos> paramMap, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.infos = paramMap;
    this.is_need_new_groupids = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.infos = ((Map)paramJceInputStream.read(cache_infos, 1, false));
    this.is_need_new_groupids = paramJceInputStream.read(this.is_need_new_groupids, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.infos != null) {
      paramJceOutputStream.write(this.infos, 1);
    }
    paramJceOutputStream.write(this.is_need_new_groupids, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.BatchGetSimilarGroupidReq
 * JD-Core Version:    0.7.0.1
 */