package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_skin_info
  extends JceStruct
{
  public String id = "";
  public long timestamp;
  public String url = "";
  
  public s_skin_info() {}
  
  public s_skin_info(String paramString1, String paramString2, long paramLong)
  {
    this.id = paramString1;
    this.url = paramString2;
    this.timestamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.url = paramJceInputStream.readString(1, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    paramJceOutputStream.write(this.timestamp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.s_skin_info
 * JD-Core Version:    0.7.0.1
 */