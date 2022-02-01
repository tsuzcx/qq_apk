package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SourceInfo
  extends JceStruct
{
  public int iSource = 0;
  public String sVersion = "";
  
  public SourceInfo() {}
  
  public SourceInfo(int paramInt, String paramString)
  {
    this.iSource = paramInt;
    this.sVersion = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSource = paramJceInputStream.read(this.iSource, 0, false);
    this.sVersion = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSource, 0);
    if (this.sVersion != null) {
      paramJceOutputStream.write(this.sVersion, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.SourceInfo
 * JD-Core Version:    0.7.0.1
 */