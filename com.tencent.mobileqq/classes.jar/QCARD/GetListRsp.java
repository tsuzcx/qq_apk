package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetListRsp
  extends JceStruct
{
  static ArrayList cache_folder_list = new ArrayList();
  static Map cache_map_folderid_nextindex;
  public ArrayList folder_list;
  public Map map_folderid_nextindex;
  public int op_type;
  public int refresh_interval;
  public int req_type;
  public int ret_code = -1;
  public long sequence;
  
  static
  {
    CouponMobileFolder localCouponMobileFolder = new CouponMobileFolder();
    cache_folder_list.add(localCouponMobileFolder);
    cache_map_folderid_nextindex = new HashMap();
    cache_map_folderid_nextindex.put(Integer.valueOf(0), "");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_type = paramJceInputStream.read(this.req_type, 0, true);
    this.op_type = paramJceInputStream.read(this.op_type, 1, false);
    this.folder_list = ((ArrayList)paramJceInputStream.read(cache_folder_list, 2, false));
    this.refresh_interval = paramJceInputStream.read(this.refresh_interval, 3, false);
    this.sequence = paramJceInputStream.read(this.sequence, 4, false);
    this.map_folderid_nextindex = ((Map)paramJceInputStream.read(cache_map_folderid_nextindex, 5, false));
    this.ret_code = paramJceInputStream.read(this.ret_code, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_type, 0);
    paramJceOutputStream.write(this.op_type, 1);
    if (this.folder_list != null) {
      paramJceOutputStream.write(this.folder_list, 2);
    }
    paramJceOutputStream.write(this.refresh_interval, 3);
    paramJceOutputStream.write(this.sequence, 4);
    if (this.map_folderid_nextindex != null) {
      paramJceOutputStream.write(this.map_folderid_nextindex, 5);
    }
    paramJceOutputStream.write(this.ret_code, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QCARD.GetListRsp
 * JD-Core Version:    0.7.0.1
 */