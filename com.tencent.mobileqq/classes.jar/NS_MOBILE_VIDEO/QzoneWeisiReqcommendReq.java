package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class QzoneWeisiReqcommendReq
  extends JceStruct
{
  static int cache_entrance_type = 0;
  static ArrayList<QzoneWeisiReqcommendKey> cache_keys = new ArrayList();
  public String aggregate_name = "";
  public String aggregate_page_id = "";
  public int entrance_type = 2;
  public int index = 0;
  public ArrayList<QzoneWeisiReqcommendKey> keys = null;
  
  static
  {
    QzoneWeisiReqcommendKey localQzoneWeisiReqcommendKey = new QzoneWeisiReqcommendKey();
    cache_keys.add(localQzoneWeisiReqcommendKey);
  }
  
  public QzoneWeisiReqcommendReq() {}
  
  public QzoneWeisiReqcommendReq(ArrayList<QzoneWeisiReqcommendKey> paramArrayList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.keys = paramArrayList;
    this.index = paramInt1;
    this.entrance_type = paramInt2;
    this.aggregate_page_id = paramString1;
    this.aggregate_name = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.keys = ((ArrayList)paramJceInputStream.read(cache_keys, 0, false));
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.entrance_type = paramJceInputStream.read(this.entrance_type, 2, false);
    this.aggregate_page_id = paramJceInputStream.readString(3, false);
    this.aggregate_name = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.keys;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.entrance_type, 2);
    localObject = this.aggregate_page_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.aggregate_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.QzoneWeisiReqcommendReq
 * JD-Core Version:    0.7.0.1
 */