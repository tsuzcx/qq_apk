package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Redpacket
  extends JceStruct
{
  public int dwConfType = 0;
  public String sName = "";
  
  public Redpacket() {}
  
  public Redpacket(int paramInt, String paramString)
  {
    this.dwConfType = paramInt;
    this.sName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwConfType = paramJceInputStream.read(this.dwConfType, 0, false);
    this.sName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwConfType, 0);
    String str = this.sName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.Redpacket
 * JD-Core Version:    0.7.0.1
 */