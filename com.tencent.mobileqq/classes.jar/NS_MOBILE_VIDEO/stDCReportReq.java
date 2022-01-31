package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stDCReportReq
  extends JceStruct
{
  static ArrayList<stMetaReportDataItem> cache_data = new ArrayList();
  public ArrayList<stMetaReportDataItem> data;
  public String dcid = "";
  
  static
  {
    stMetaReportDataItem localstMetaReportDataItem = new stMetaReportDataItem();
    cache_data.add(localstMetaReportDataItem);
  }
  
  public stDCReportReq() {}
  
  public stDCReportReq(String paramString, ArrayList<stMetaReportDataItem> paramArrayList)
  {
    this.dcid = paramString;
    this.data = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dcid = paramJceInputStream.readString(0, true);
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dcid, 0);
    paramJceOutputStream.write(this.data, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.stDCReportReq
 * JD-Core Version:    0.7.0.1
 */