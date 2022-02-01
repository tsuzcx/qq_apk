package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class bmp4_set_req
  extends JceStruct
{
  static bmp4_values cache_map_kv = new bmp4_values();
  public int bitmap_id = 4;
  public bmp4_values map_kv = null;
  public long uin = 0L;
  
  public bmp4_set_req() {}
  
  public bmp4_set_req(long paramLong, bmp4_values parambmp4_values, int paramInt)
  {
    this.uin = paramLong;
    this.map_kv = parambmp4_values;
    this.bitmap_id = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.map_kv = ((bmp4_values)paramJceInputStream.read(cache_map_kv, 1, false));
    this.bitmap_id = paramJceInputStream.read(this.bitmap_id, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.map_kv != null) {
      paramJceOutputStream.write(this.map_kv, 1);
    }
    paramJceOutputStream.write(this.bitmap_id, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_set_req
 * JD-Core Version:    0.7.0.1
 */