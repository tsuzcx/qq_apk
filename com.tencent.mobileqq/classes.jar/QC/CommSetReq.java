package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommSetReq
  extends JceStruct
{
  public String strReq = "";
  
  public CommSetReq() {}
  
  public CommSetReq(String paramString)
  {
    this.strReq = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strReq = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strReq;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.CommSetReq
 * JD-Core Version:    0.7.0.1
 */