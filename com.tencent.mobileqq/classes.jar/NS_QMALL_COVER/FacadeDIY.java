package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FacadeDIY
  extends JceStruct
{
  public int iEnable = -1;
  public String strChecksum = "";
  
  public FacadeDIY() {}
  
  public FacadeDIY(int paramInt, String paramString)
  {
    this.iEnable = paramInt;
    this.strChecksum = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEnable = paramJceInputStream.read(this.iEnable, 0, false);
    this.strChecksum = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEnable, 0);
    String str = this.strChecksum;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.FacadeDIY
 * JD-Core Version:    0.7.0.1
 */