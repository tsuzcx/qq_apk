package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FacadeEditData
  extends JceStruct
{
  public int iIndexId;
  public String strImageUrl = "";
  public String strText = "";
  
  public FacadeEditData() {}
  
  public FacadeEditData(int paramInt, String paramString1, String paramString2)
  {
    this.iIndexId = paramInt;
    this.strText = paramString1;
    this.strImageUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIndexId = paramJceInputStream.read(this.iIndexId, 0, false);
    this.strText = paramJceInputStream.readString(1, false);
    this.strImageUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIndexId, 0);
    String str = this.strText;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strImageUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FacadeEditData
 * JD-Core Version:    0.7.0.1
 */