package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class readUserInfoReq
  extends JceStruct
{
  public int implat;
  public int index;
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
    if (this.qqver != null) {
      paramJceOutputStream.write(this.qqver, 0);
    }
    paramJceOutputStream.write(this.implat, 1);
    paramJceOutputStream.write(this.index, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ProfileLogic.QC.readUserInfoReq
 * JD-Core Version:    0.7.0.1
 */