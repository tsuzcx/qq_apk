package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Bubble
  extends JceStruct
{
  public int deltype = 0;
  public String strDiyJson = "";
  
  public Bubble() {}
  
  public Bubble(String paramString, int paramInt)
  {
    this.strDiyJson = paramString;
    this.deltype = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strDiyJson = paramJceInputStream.readString(0, false);
    this.deltype = paramJceInputStream.read(this.deltype, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strDiyJson != null) {
      paramJceOutputStream.write(this.strDiyJson, 0);
    }
    paramJceOutputStream.write(this.deltype, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.Bubble
 * JD-Core Version:    0.7.0.1
 */