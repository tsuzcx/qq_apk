package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class setUserProfileReq
  extends JceStruct
{
  public int implat;
  public int itemid;
  public String qqver = "";
  
  public setUserProfileReq() {}
  
  public setUserProfileReq(int paramInt1, String paramString, int paramInt2)
  {
    this.itemid = paramInt1;
    this.qqver = paramString;
    this.implat = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.itemid = paramJceInputStream.read(this.itemid, 0, false);
    this.qqver = paramJceInputStream.readString(1, false);
    this.implat = paramJceInputStream.read(this.implat, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.itemid, 0);
    if (this.qqver != null) {
      paramJceOutputStream.write(this.qqver, 1);
    }
    paramJceOutputStream.write(this.implat, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ProfileLogic.QC.setUserProfileReq
 * JD-Core Version:    0.7.0.1
 */