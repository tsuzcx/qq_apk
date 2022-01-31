package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class last_album_area_info
  extends JceStruct
{
  static ArrayList<album_area_item> cache_pos = new ArrayList();
  public int anonymity;
  public String id = "";
  public String name = "";
  public ArrayList<album_area_item> pos;
  public long switch_state;
  
  static
  {
    album_area_item localalbum_area_item = new album_area_item();
    cache_pos.add(localalbum_area_item);
  }
  
  public last_album_area_info() {}
  
  public last_album_area_info(String paramString1, String paramString2, int paramInt, ArrayList<album_area_item> paramArrayList, long paramLong)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.anonymity = paramInt;
    this.pos = paramArrayList;
    this.switch_state = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.anonymity = paramJceInputStream.read(this.anonymity, 2, false);
    this.pos = ((ArrayList)paramJceInputStream.read(cache_pos, 3, false));
    this.switch_state = paramJceInputStream.read(this.switch_state, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    paramJceOutputStream.write(this.anonymity, 2);
    if (this.pos != null) {
      paramJceOutputStream.write(this.pos, 3);
    }
    paramJceOutputStream.write(this.switch_state, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.last_album_area_info
 * JD-Core Version:    0.7.0.1
 */