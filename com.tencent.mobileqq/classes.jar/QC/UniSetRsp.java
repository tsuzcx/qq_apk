package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniSetRsp
  extends JceStruct
{
  static HamletCheck cache_stHamletItem = new HamletCheck();
  public String errmsg = "";
  public int ret;
  public HamletCheck stHamletItem;
  public String url = "";
  
  public UniSetRsp() {}
  
  public UniSetRsp(int paramInt, String paramString1, HamletCheck paramHamletCheck, String paramString2)
  {
    this.ret = paramInt;
    this.errmsg = paramString1;
    this.stHamletItem = paramHamletCheck;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stHamletItem = ((HamletCheck)paramJceInputStream.read(cache_stHamletItem, 2, false));
    this.url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.stHamletItem != null) {
      paramJceOutputStream.write(this.stHamletItem, 2);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniSetRsp
 * JD-Core Version:    0.7.0.1
 */