package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GuidePaster
  extends JceStruct
{
  public String pasterId = "";
  public String url = "";
  
  public GuidePaster() {}
  
  public GuidePaster(String paramString1, String paramString2)
  {
    this.url = paramString1;
    this.pasterId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.pasterId = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.pasterId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.GuidePaster
 * JD-Core Version:    0.7.0.1
 */