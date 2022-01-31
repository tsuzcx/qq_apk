package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_search
  extends JceStruct
{
  public String tip = "";
  
  public cell_search() {}
  
  public cell_search(String paramString)
  {
    this.tip = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tip = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.tip != null) {
      paramJceOutputStream.write(this.tip, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_search
 * JD-Core Version:    0.7.0.1
 */