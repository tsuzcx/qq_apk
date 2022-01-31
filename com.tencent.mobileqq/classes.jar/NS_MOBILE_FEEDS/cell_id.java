package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_id
  extends JceStruct
{
  public String cellid = "";
  public String subid = "";
  
  public cell_id() {}
  
  public cell_id(String paramString1, String paramString2)
  {
    this.cellid = paramString1;
    this.subid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cellid = paramJceInputStream.readString(0, false);
    this.subid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cellid != null) {
      paramJceOutputStream.write(this.cellid, 0);
    }
    if (this.subid != null) {
      paramJceOutputStream.write(this.subid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_id
 * JD-Core Version:    0.7.0.1
 */