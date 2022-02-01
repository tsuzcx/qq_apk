package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWeishiDengtaReportRsp
  extends JceStruct
{
  public int code = 0;
  public String msg = "";
  
  public stWeishiDengtaReportRsp() {}
  
  public stWeishiDengtaReportRsp(int paramInt, String paramString)
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
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stWeishiDengtaReportRsp
 * JD-Core Version:    0.7.0.1
 */