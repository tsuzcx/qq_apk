package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommonRsp
  extends JceStruct
{
  public int err;
  public String msg = "";
  public int ret;
  
  public CommonRsp() {}
  
  public CommonRsp(int paramInt1, int paramInt2, String paramString)
  {
    this.ret = paramInt1;
    this.err = paramInt2;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.err = paramJceInputStream.read(this.err, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.err, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.CommonRsp
 * JD-Core Version:    0.7.0.1
 */