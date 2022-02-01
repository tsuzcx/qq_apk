package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class DcStandardReportReq
  extends JceStruct
{
  static ArrayList<Map<String, String>> cache_report_infos = new ArrayList();
  public String dc_name = "";
  public ArrayList<Map<String, String>> report_infos = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("", "");
    cache_report_infos.add(localHashMap);
  }
  
  public DcStandardReportReq() {}
  
  public DcStandardReportReq(String paramString, ArrayList<Map<String, String>> paramArrayList)
  {
    this.dc_name = paramString;
    this.report_infos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dc_name = paramJceInputStream.readString(0, false);
    this.report_infos = ((ArrayList)paramJceInputStream.read(cache_report_infos, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.dc_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.report_infos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.DcStandardReportReq
 * JD-Core Version:    0.7.0.1
 */