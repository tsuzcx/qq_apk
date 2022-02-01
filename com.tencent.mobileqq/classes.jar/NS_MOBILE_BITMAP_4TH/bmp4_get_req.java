package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class bmp4_get_req
  extends JceStruct
{
  static ArrayList<String> cache_vec_keys;
  static ArrayList<Long> cache_vec_uins = new ArrayList();
  public int bitmap_id = 4;
  public ArrayList<String> vec_keys = null;
  public ArrayList<Long> vec_uins = null;
  
  static
  {
    cache_vec_uins.add(Long.valueOf(0L));
    cache_vec_keys = new ArrayList();
    cache_vec_keys.add("");
  }
  
  public bmp4_get_req() {}
  
  public bmp4_get_req(ArrayList<Long> paramArrayList, ArrayList<String> paramArrayList1, int paramInt)
  {
    this.vec_uins = paramArrayList;
    this.vec_keys = paramArrayList1;
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
    ArrayList localArrayList = this.vec_uins;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    localArrayList = this.vec_keys;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    paramJceOutputStream.write(this.bitmap_id, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_get_req
 * JD-Core Version:    0.7.0.1
 */