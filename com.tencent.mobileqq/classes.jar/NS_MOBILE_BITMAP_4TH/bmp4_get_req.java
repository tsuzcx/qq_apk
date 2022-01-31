package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class bmp4_get_req
  extends JceStruct
{
  static ArrayList cache_vec_keys;
  static ArrayList cache_vec_uins = new ArrayList();
  public int bitmap_id = 4;
  public ArrayList vec_keys;
  public ArrayList vec_uins;
  
  static
  {
    cache_vec_uins.add(Long.valueOf(0L));
    cache_vec_keys = new ArrayList();
    cache_vec_keys.add("");
  }
  
  public bmp4_get_req() {}
  
  public bmp4_get_req(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    this.vec_uins = paramArrayList1;
    this.vec_keys = paramArrayList2;
    this.bitmap_id = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vec_uins = ((ArrayList)paramJceInputStream.read(cache_vec_uins, 0, false));
    this.vec_keys = ((ArrayList)paramJceInputStream.read(cache_vec_keys, 1, false));
    this.bitmap_id = paramJceInputStream.read(this.bitmap_id, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vec_uins != null) {
      paramJceOutputStream.write(this.vec_uins, 0);
    }
    if (this.vec_keys != null) {
      paramJceOutputStream.write(this.vec_keys, 1);
    }
    paramJceOutputStream.write(this.bitmap_id, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_get_req
 * JD-Core Version:    0.7.0.1
 */