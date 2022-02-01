package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stGetCollectionRsp
  extends JceStruct
{
  static stCollection cache_collection = new stCollection();
  static ArrayList<stSimpleMetaFeed> cache_feedList = new ArrayList();
  static Map<String, String> cache_map_ext;
  public String attachInfo = "";
  public stCollection collection = null;
  public ArrayList<stSimpleMetaFeed> feedList = null;
  public boolean isFinished = true;
  public Map<String, String> map_ext = null;
  public String traceId = "";
  
  static
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    cache_feedList.add(localstSimpleMetaFeed);
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public stGetCollectionRsp() {}
  
  public stGetCollectionRsp(String paramString1, boolean paramBoolean, ArrayList<stSimpleMetaFeed> paramArrayList, String paramString2, Map<String, String> paramMap, stCollection paramstCollection)
  {
    this.attachInfo = paramString1;
    this.isFinished = paramBoolean;
    this.feedList = paramArrayList;
    this.traceId = paramString2;
    this.map_ext = paramMap;
    this.collection = paramstCollection;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 1, false);
    this.feedList = ((ArrayList)paramJceInputStream.read(cache_feedList, 2, false));
    this.traceId = paramJceInputStream.readString(3, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 4, false));
    this.collection = ((stCollection)paramJceInputStream.read(cache_collection, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.isFinished, 1);
    localObject = this.feedList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.traceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    localObject = this.collection;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetCollectionRsp
 * JD-Core Version:    0.7.0.1
 */