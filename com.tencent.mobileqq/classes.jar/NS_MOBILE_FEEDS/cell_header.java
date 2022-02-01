package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_header
  extends JceStruct
{
  public int tih_year;
  public int type;
  
  public cell_header() {}
  
  public cell_header(int paramInt1, int paramInt2)
  {
    this.type = paramInt1;
    this.tih_year = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.tih_year = paramJceInputStream.read(this.tih_year, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.tih_year, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_header
 * JD-Core Version:    0.7.0.1
 */