package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_recomm_footer
  extends JceStruct
{
  public String text = "";
  
  public cell_recomm_footer() {}
  
  public cell_recomm_footer(String paramString)
  {
    this.text = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.text = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomm_footer
 * JD-Core Version:    0.7.0.1
 */