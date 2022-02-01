package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stResult
  extends JceStruct
{
  static int cache_flag;
  public int flag = 0;
  public String msg = "";
  public int ret = 0;
  
  public stResult() {}
  
  public stResult(int paramInt1, int paramInt2, String paramString)
  {
    this.ret = paramInt1;
    this.flag = paramInt2;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 1, true);
    this.flag = paramJceInputStream.read(this.flag, 2, true);
    this.msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 1);
    paramJceOutputStream.write(this.flag, 2);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.stResult
 * JD-Core Version:    0.7.0.1
 */