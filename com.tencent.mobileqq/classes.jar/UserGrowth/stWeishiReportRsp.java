package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWeishiReportRsp
  extends JceStruct
{
  public int code;
  public String msg = "";
  
  public stWeishiReportRsp() {}
  
  public stWeishiReportRsp(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stWeishiReportRsp
 * JD-Core Version:    0.7.0.1
 */