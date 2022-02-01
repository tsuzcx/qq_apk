package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class bmp4_set_rsp
  extends JceStruct
{
  public String errmsg = "";
  public int retCode = 0;
  
  public bmp4_set_rsp() {}
  
  public bmp4_set_rsp(int paramInt, String paramString)
  {
    this.retCode = paramInt;
    this.errmsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_set_rsp
 * JD-Core Version:    0.7.0.1
 */