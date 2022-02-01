package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class st_report_info
  extends JceStruct
{
  public int report_first_page = 0;
  public int report_second_page = 0;
  
  public st_report_info() {}
  
  public st_report_info(int paramInt1, int paramInt2)
  {
    this.report_first_page = paramInt1;
    this.report_second_page = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.report_first_page = paramJceInputStream.read(this.report_first_page, 0, false);
    this.report_second_page = paramJceInputStream.read(this.report_second_page, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.report_first_page, 0);
    paramJceOutputStream.write(this.report_second_page, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.st_report_info
 * JD-Core Version:    0.7.0.1
 */