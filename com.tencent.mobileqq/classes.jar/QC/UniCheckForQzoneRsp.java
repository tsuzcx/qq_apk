package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniCheckForQzoneRsp
  extends JceStruct
{
  public String errmsg = "";
  public int ret = 0;
  
  public UniCheckForQzoneRsp() {}
  
  public UniCheckForQzoneRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.errmsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniCheckForQzoneRsp
 * JD-Core Version:    0.7.0.1
 */