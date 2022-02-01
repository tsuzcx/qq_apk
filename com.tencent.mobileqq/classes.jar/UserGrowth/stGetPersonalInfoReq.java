package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetPersonalInfoReq
  extends JceStruct
{
  public String reqPid = "";
  
  public stGetPersonalInfoReq() {}
  
  public stGetPersonalInfoReq(String paramString)
  {
    this.reqPid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqPid = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.reqPid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetPersonalInfoReq
 * JD-Core Version:    0.7.0.1
 */