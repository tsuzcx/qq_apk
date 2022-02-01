package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class clear_count_req
  extends JceStruct
{
  public String LastUndealCountTime = "";
  public int clearType;
  
  public clear_count_req() {}
  
  public clear_count_req(int paramInt, String paramString)
  {
    this.clearType = paramInt;
    this.LastUndealCountTime = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.clearType = paramJceInputStream.read(this.clearType, 0, false);
    this.LastUndealCountTime = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.clearType, 0);
    String str = this.LastUndealCountTime;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.clear_count_req
 * JD-Core Version:    0.7.0.1
 */