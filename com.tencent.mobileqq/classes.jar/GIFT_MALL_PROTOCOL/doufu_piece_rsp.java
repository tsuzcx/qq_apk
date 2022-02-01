package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class doufu_piece_rsp
  extends JceStruct
{
  static ArrayList<DouFuInfo> cache_doufu = new ArrayList();
  static Map<String, String> cache_mapExt;
  public ArrayList<DouFuInfo> doufu = null;
  public Map<String, String> mapExt = null;
  
  static
  {
    DouFuInfo localDouFuInfo = new DouFuInfo();
    cache_doufu.add(localDouFuInfo);
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public doufu_piece_rsp() {}
  
  public doufu_piece_rsp(ArrayList<DouFuInfo> paramArrayList, Map<String, String> paramMap)
  {
    this.doufu = paramArrayList;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.doufu = ((ArrayList)paramJceInputStream.read(cache_doufu, 0, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.doufu;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     GIFT_MALL_PROTOCOL.doufu_piece_rsp
 * JD-Core Version:    0.7.0.1
 */