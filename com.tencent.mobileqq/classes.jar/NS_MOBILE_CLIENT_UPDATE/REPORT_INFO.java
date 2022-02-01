package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class REPORT_INFO
  extends JceStruct
{
  static ArrayList<Map<String, String>> cache_info = new ArrayList();
  public ArrayList<Map<String, String>> info = null;
  public int subtable = 0;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("", "");
    cache_info.add(localHashMap);
  }
  
  public REPORT_INFO() {}
  
  public REPORT_INFO(int paramInt, ArrayList<Map<String, String>> paramArrayList)
  {
    this.subtable = paramInt;
    this.info = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subtable = paramJceInputStream.read(this.subtable, 0, false);
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subtable, 0);
    ArrayList localArrayList = this.info;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.REPORT_INFO
 * JD-Core Version:    0.7.0.1
 */