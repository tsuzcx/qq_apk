package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class setUserFlagReq
  extends JceStruct
{
  public int flag;
  public int implat;
  public String qqver = "";
  
  public setUserFlagReq() {}
  
  public setUserFlagReq(int paramInt1, String paramString, int paramInt2)
  {
    this.flag = paramInt1;
    this.qqver = paramString;
    this.implat = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.flag = paramJceInputStream.read(this.flag, 0, false);
    this.qqver = paramJceInputStream.readString(1, false);
    this.implat = paramJceInputStream.read(this.implat, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.flag, 0);
    if (this.qqver != null) {
      paramJceOutputStream.write(this.qqver, 1);
    }
    paramJceOutputStream.write(this.implat, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ProfileLogic.QC.setUserFlagReq
 * JD-Core Version:    0.7.0.1
 */