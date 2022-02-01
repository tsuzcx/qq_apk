package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommSetRsp
  extends JceStruct
{
  public int ret = 0;
  public String strRsp = "";
  
  public CommSetRsp() {}
  
  public CommSetRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.strRsp = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.strRsp = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.strRsp;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.CommSetRsp
 * JD-Core Version:    0.7.0.1
 */