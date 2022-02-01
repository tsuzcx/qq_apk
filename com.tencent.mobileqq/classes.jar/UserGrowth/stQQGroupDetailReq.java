package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stQQGroupDetailReq
  extends JceStruct
{
  public String groupId = "";
  public String posterPersonId = "";
  
  public stQQGroupDetailReq() {}
  
  public stQQGroupDetailReq(String paramString1, String paramString2)
  {
    this.groupId = paramString1;
    this.posterPersonId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupId = paramJceInputStream.readString(0, false);
    this.posterPersonId = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.groupId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.posterPersonId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stQQGroupDetailReq
 * JD-Core Version:    0.7.0.1
 */