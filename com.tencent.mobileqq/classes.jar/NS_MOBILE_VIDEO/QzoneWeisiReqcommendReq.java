package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QzoneWeisiReqcommendReq
  extends JceStruct
{
  static int cache_entrance_type = 0;
  static ArrayList cache_keys = new ArrayList();
  public int entrance_type = 2;
  public int index;
  public ArrayList keys;
  
  static
  {
    QzoneWeisiReqcommendKey localQzoneWeisiReqcommendKey = new QzoneWeisiReqcommendKey();
    cache_keys.add(localQzoneWeisiReqcommendKey);
  }
  
  public QzoneWeisiReqcommendReq() {}
  
  public QzoneWeisiReqcommendReq(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    this.keys = paramArrayList;
    this.index = paramInt1;
    this.entrance_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.keys = ((ArrayList)paramJceInputStream.read(cache_keys, 0, false));
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.entrance_type = paramJceInputStream.read(this.entrance_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.keys != null) {
      paramJceOutputStream.write(this.keys, 0);
    }
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.entrance_type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.QzoneWeisiReqcommendReq
 * JD-Core Version:    0.7.0.1
 */