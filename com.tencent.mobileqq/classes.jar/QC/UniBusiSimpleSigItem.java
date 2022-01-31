package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiSimpleSigItem
  extends JceStruct
{
  public String desc = "";
  public String fontColor = "";
  public int materialVersion;
  public String timeAndLocation = "";
  
  public UniBusiSimpleSigItem() {}
  
  public UniBusiSimpleSigItem(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.materialVersion = paramInt;
    this.fontColor = paramString1;
    this.desc = paramString2;
    this.timeAndLocation = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.materialVersion = paramJceInputStream.read(this.materialVersion, 0, false);
    this.fontColor = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.timeAndLocation = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.materialVersion, 0);
    if (this.fontColor != null) {
      paramJceOutputStream.write(this.fontColor, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    if (this.timeAndLocation != null) {
      paramJceOutputStream.write(this.timeAndLocation, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiSimpleSigItem
 * JD-Core Version:    0.7.0.1
 */