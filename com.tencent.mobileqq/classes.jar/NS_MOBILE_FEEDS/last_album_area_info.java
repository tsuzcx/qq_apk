package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class last_album_area_info
  extends JceStruct
{
  static ArrayList<album_area_item> cache_pos = new ArrayList();
  public int anonymity = 0;
  public String id = "";
  public String name = "";
  public ArrayList<album_area_item> pos = null;
  public long switch_state = 0L;
  
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
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.anonymity, 2);
    localObject = this.pos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.switch_state, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.last_album_area_info
 * JD-Core Version:    0.7.0.1
 */