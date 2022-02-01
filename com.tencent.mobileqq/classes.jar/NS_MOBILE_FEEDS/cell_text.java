package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_text
  extends JceStruct
{
  public String data = "";
  public int type;
  
  public cell_text() {}
  
  public cell_text(String paramString, int paramInt)
  {
    this.data = paramString;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.data;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_text
 * JD-Core Version:    0.7.0.1
 */