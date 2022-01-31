package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_visit_report_req
  extends JceStruct
{
  static ArrayList<s_visit_record> cache_vec_visit_record;
  public ArrayList<s_visit_record> vec_visit_record;
  
  public mobile_visit_report_req() {}
  
  public mobile_visit_report_req(ArrayList<s_visit_record> paramArrayList)
  {
    this.vec_visit_record = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vec_visit_record == null)
    {
      cache_vec_visit_record = new ArrayList();
      s_visit_record locals_visit_record = new s_visit_record();
      cache_vec_visit_record.add(locals_visit_record);
    }
    this.vec_visit_record = ((ArrayList)paramJceInputStream.read(cache_vec_visit_record, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vec_visit_record, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_visit_report_req
 * JD-Core Version:    0.7.0.1
 */