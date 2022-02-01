package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetItemWatchWordRsp
  extends JceStruct
{
  public String errmsg = "";
  public int ret;
  public String sharemsg = "";
  
  public GetItemWatchWordRsp() {}
  
  public GetItemWatchWordRsp(int paramInt, String paramString1, String paramString2)
  {
    this.ret = paramInt;
    this.errmsg = paramString1;
    this.sharemsg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.sharemsg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.sharemsg != null) {
      paramJceOutputStream.write(this.sharemsg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.GetItemWatchWordRsp
 * JD-Core Version:    0.7.0.1
 */