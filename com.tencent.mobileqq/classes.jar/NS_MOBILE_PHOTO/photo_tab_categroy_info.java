package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class photo_tab_categroy_info
  extends JceStruct
{
  static int cache_status = 0;
  static int cache_type = 0;
  static ArrayList<String> cache_url = new ArrayList();
  public long count;
  public int status = 1;
  public int type;
  public ArrayList<String> url;
  
  static
  {
    cache_url.add("");
  }
  
  public photo_tab_categroy_info() {}
  
  public photo_tab_categroy_info(int paramInt1, ArrayList<String> paramArrayList, long paramLong, int paramInt2)
  {
    this.type = paramInt1;
    this.url = paramArrayList;
    this.count = paramLong;
    this.status = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.url = ((ArrayList)paramJceInputStream.read(cache_url, 1, false));
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    paramJceOutputStream.write(this.count, 2);
    paramJceOutputStream.write(this.status, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.photo_tab_categroy_info
 * JD-Core Version:    0.7.0.1
 */