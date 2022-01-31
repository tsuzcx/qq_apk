package QCARD;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetListReq
  extends JceStruct
{
  static LBSInfo cache_lbs_info = new LBSInfo();
  static Map cache_map_folderid_index = new HashMap();
  public int condition;
  public LBSInfo lbs_info;
  public Map map_folderid_index;
  public int req_type;
  public long sequence;
  public String skey = "";
  public long uin;
  
  static
  {
    cache_map_folderid_index.put(Integer.valueOf(0), "");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req_type = paramJceInputStream.read(this.req_type, 0, true);
    this.condition = paramJceInputStream.read(this.condition, 1, false);
    this.sequence = paramJceInputStream.read(this.sequence, 2, false);
    this.map_folderid_index = ((Map)paramJceInputStream.read(cache_map_folderid_index, 3, false));
    this.lbs_info = ((LBSInfo)paramJceInputStream.read(cache_lbs_info, 4, false));
    this.uin = paramJceInputStream.read(this.uin, 5, false);
    this.skey = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.req_type, 0);
    paramJceOutputStream.write(this.condition, 1);
    paramJceOutputStream.write(this.sequence, 2);
    if (this.map_folderid_index != null) {
      paramJceOutputStream.write(this.map_folderid_index, 3);
    }
    if (this.lbs_info != null) {
      paramJceOutputStream.write(this.lbs_info, 4);
    }
    paramJceOutputStream.write(this.uin, 5);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QCARD.GetListReq
 * JD-Core Version:    0.7.0.1
 */