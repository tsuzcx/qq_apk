package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_concern_req
  extends JceStruct
{
  static Map<Integer, String> cache_map_ext = new HashMap();
  public int isconcern = 0;
  public Map<Integer, String> map_ext = null;
  public long objuin = 0L;
  public int source = 0;
  
  static
  {
    cache_map_ext.put(Integer.valueOf(0), "");
  }
  
  public mobile_sub_concern_req() {}
  
  public mobile_sub_concern_req(long paramLong, int paramInt1, int paramInt2, Map<Integer, String> paramMap)
  {
    this.objuin = paramLong;
    this.isconcern = paramInt1;
    this.source = paramInt2;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.objuin = paramJceInputStream.read(this.objuin, 0, true);
    this.isconcern = paramJceInputStream.read(this.isconcern, 1, true);
    this.source = paramJceInputStream.read(this.source, 2, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.objuin, 0);
    paramJceOutputStream.write(this.isconcern, 1);
    paramJceOutputStream.write(this.source, 2);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_concern_req
 * JD-Core Version:    0.7.0.1
 */