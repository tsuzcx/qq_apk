package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class readUserInfoReq
  extends JceStruct
{
  public int implat = 0;
  public int index = 0;
  public String qqver = "";
  
  public readUserInfoReq() {}
  
  public readUserInfoReq(String paramString, int paramInt1, int paramInt2)
  {
    this.qqver = paramString;
    this.implat = paramInt1;
    this.index = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qqver = paramJceInputStream.readString(0, false);
    this.implat = paramJceInputStream.read(this.implat, 1, false);
    this.index = paramJceInputStream.read(this.index, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.qqver;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.implat, 1);
    paramJceOutputStream.write(this.index, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ProfileLogic.QC.readUserInfoReq
 * JD-Core Version:    0.7.0.1
 */