package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetAlbumCommShareKeyReq
  extends JceStruct
{
  static Map<String, String> cache_ins = new HashMap();
  static int cache_scene;
  public Map<String, String> ins = null;
  public int scene = 0;
  public long uin = 0L;
  
  static
  {
    cache_ins.put("", "");
  }
  
  public GetAlbumCommShareKeyReq() {}
  
  public GetAlbumCommShareKeyReq(long paramLong, int paramInt, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.scene = paramInt;
    this.ins = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.ins = ((Map)paramJceInputStream.read(cache_ins, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.scene, 1);
    Map localMap = this.ins;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetAlbumCommShareKeyReq
 * JD-Core Version:    0.7.0.1
 */