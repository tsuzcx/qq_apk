package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReturnToPraise
  extends JceStruct
{
  public int iItemId = -1;
  public String strLeftHandUrl = "";
  public String strRightHandUrl = "";
  public String strText = "";
  
  public ReturnToPraise() {}
  
  public ReturnToPraise(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.strRightHandUrl = paramString1;
    this.strLeftHandUrl = paramString2;
    this.strText = paramString3;
    this.iItemId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strRightHandUrl = paramJceInputStream.readString(0, false);
    this.strLeftHandUrl = paramJceInputStream.readString(1, false);
    this.strText = paramJceInputStream.readString(2, false);
    this.iItemId = paramJceInputStream.read(this.iItemId, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strRightHandUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strLeftHandUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strText;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.iItemId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.ReturnToPraise
 * JD-Core Version:    0.7.0.1
 */