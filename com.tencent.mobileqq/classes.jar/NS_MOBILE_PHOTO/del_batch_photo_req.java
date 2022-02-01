package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class del_batch_photo_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  static ArrayList<String> cache_picid_list = new ArrayList();
  static ArrayList<String> cache_vids;
  public String albumid = "";
  public int appid = 4;
  public Map<Integer, String> busi_param = null;
  public ArrayList<String> picid_list = null;
  public ArrayList<String> vids = null;
  
  static
  {
    cache_picid_list.add("");
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_vids = new ArrayList();
    cache_vids.add("");
  }
  
  public del_batch_photo_req() {}
  
  public del_batch_photo_req(String paramString, ArrayList<String> paramArrayList1, Map<Integer, String> paramMap, int paramInt, ArrayList<String> paramArrayList2)
  {
    this.albumid = paramString;
    this.picid_list = paramArrayList1;
    this.busi_param = paramMap;
    this.appid = paramInt;
    this.vids = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.picid_list = ((ArrayList)paramJceInputStream.read(cache_picid_list, 1, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
    this.appid = paramJceInputStream.read(this.appid, 3, false);
    this.vids = ((ArrayList)paramJceInputStream.read(cache_vids, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.picid_list, 1);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
    paramJceOutputStream.write(this.appid, 3);
    if (this.vids != null) {
      paramJceOutputStream.write(this.vids, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.del_batch_photo_req
 * JD-Core Version:    0.7.0.1
 */